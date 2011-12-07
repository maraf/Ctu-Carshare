/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.impl;

import com.carshare.domain.dto.*;
import com.carshare.service.storage.TripEntity;
import com.carshare.service.storage.TripUserEntity;
import com.carshare.service.storage.UserEntity;
import com.carshare.service.util.*;
import com.carshare.service.validation.NullFieldException;
import com.carshare.service.validation.NullRequstObjectException;
import com.carshare.service.validation.OnlyDriverCanModifyException;
import com.carshare.service.validation.UserAlreadyInTripException;
import com.carshare.service.validation.UserNotRequestedInTripException;
import com.neptuo.service.*;
import com.neptuo.service.annotation.*;
import com.neptuo.service.result.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Mara
 */
@ServiceClass(url="/trip")
public class TripService {

    @ServiceMethod
    public CollectionResult<TripRow> filter(@RequestInput TripFilter filter, EntityManager em) throws HttpException {
        Map<String, Object> params = new HashMap<String, Object>();
        String query = "select t from TripEntity t where t.departure >= :departure";
        params.put("departure", new Date());

        if(filter != null) {
            if(StringUtils.isNullOrEmpty(filter.getFrom())) {
                query += " and from = :from";
                params.put("from", filter.getFrom());
            }
            if(StringUtils.isNullOrEmpty(filter.getTo())) {
                query += " and to = :to";
                params.put("to", filter.getTo());
            }
//            if(filter.getMaxPrice() > 0) {
//                //TODO: Compute price ...
//                query += " and totalPrice <= :maxPrice";
//                params.put("maxPrice", filter.getMaxPrice());
//            }
//            if(filter.getSeats() > 0) {
//                query += " and availableSeats >= :seats";
//                params.put("seats", filter.getSeats());
//            }
            //TODO: Driver rating ...
        }

        Query q = em.createQuery(query);
        for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
        }

        List<TripRow> result = new ArrayList<TripRow>();
        List<TripEntity> trips = (List<TripEntity>) q.getResultList();
        for (TripEntity entry : trips) {
            if(filter.getSeats() > 0 && filter.getSeats() <= entry.getAvailableSeats())  {
                result.add(entry.asTripRow());
            }
        }

        return new CollectionResult<TripRow>("trips", result);
    }

    @ServiceMethod(name="create")
    public EntityResult<TripRow> create(@RequestInput NewTrip trip, EntityManager em, UserEntity current) throws ServiceException {
        if(trip == null) {
            throw new NullRequstObjectException("trip");
        }
        if(StringUtils.isNullOrEmpty(trip.getFrom())) {
            throw new NullFieldException("from");
        }
        if(StringUtils.isNullOrEmpty(trip.getTo())) {
            throw new NullFieldException("to");
        }
        if(trip.getArrival() == null) {
            throw new NullFieldException("arrival");
        }
        if(trip.getDeparture() == null) {
            throw new NullFieldException("departure");
        }
        if(trip.getTotalPrice() <= 0) {
            throw new NullFieldException("total-price");
        }
        if(trip.getTotalSeats() <= 0) {
            throw new NullFieldException("total-seats");
        }
        if(trip.getAvailableSeats() <= 0) {
            throw new NullFieldException("available-seats");
        }

        TripEntity entity = new TripEntity(trip);
        entity.setId(HashHelper.SHA1(PublicHelper.random()));
        entity.setDriverId(current.getId());
        em.persist(entity);

        return new EntityResult<TripRow>(entity.asTripRow());
    }

    @ServiceMethod(name="request-user-to-trip")
    public EntityResult<TripUserRequest> requestUserToTrip(@RequestInput TripUserRequest request, EntityManager em, UserEntity current) throws ServiceException {
        if(request == null) {
            throw new NullRequstObjectException("trip-user-request");
        }
        if(StringUtils.isNullOrEmpty(request.getTripId())) {
            throw new NullFieldException("trip-id");
        }
        Query q = em.createQuery("select * from TripUserEntity tue where tue.userId = :userId and tue.tripId = :tripId");
        q.setParameter("userId", current.getId());
        q.setParameter("tripId", request.getTripId());
        if(q.getResultList().size() > 0) {
            throw new UserAlreadyInTripException();
        }

        TripUserEntity entity = new TripUserEntity(request.getTripId(), current.getId());
        em.persist(entity);

        return new EntityResult<TripUserRequest>(request);
    }

    @ServiceMethod(name="confirm-user-in-trip")
    public EntityResult<TripUserRequest> confirmUserInTrip(@RequestInput TripUserRequest request, EntityManager em, UserEntity current) throws ServiceException {
        if(request == null) {
            throw new NullRequstObjectException("trip-user-request");
        }
        if(StringUtils.isNullOrEmpty(request.getUserId())) {
            throw new NullFieldException("user-id");
        }
        if(StringUtils.isNullOrEmpty(request.getTripId())) {
            throw new NullFieldException("trip-id");
        }
        TripEntity trip = em.find(TripEntity.class, request.getTripId());
        if(!current.getId().equals(trip.getDriverId())) {
            throw new OnlyDriverCanModifyException();
        }

        Query q = em.createQuery("select * from TripUserEntity tue where tue.userId = :userId and tue.tripId = :tripId");
        q.setParameter("userId", request.getUserId());
        q.setParameter("tripId", request.getTripId());
        List<TripUserEntity> result = q.getResultList();
        if(result.size() != 1) {
            throw new UserNotRequestedInTripException();
        }

        TripUserEntity entity = result.get(0);
        entity.setStatus(TripUserStatus.CONFIRMED);
        em.persist(em.merge(entity));

        return new EntityResult<TripUserRequest>(request);
    }

    @ServiceMethod(name="remove-user-from-trip")
    public EntityResult<TripUserRequest> removeUserFromTrip(@RequestInput TripUserRequest request, EntityManager em, UserEntity current) throws ServiceException {
        if(request == null) {
            throw new NullRequstObjectException("trip-user-request");
        }
        if(StringUtils.isNullOrEmpty(request.getTripId())) {
            throw new NullFieldException("trip-id");
        }
        
        Query q = em.createQuery("select * from TripUserEntity tue where tue.userId = :userId and tue.tripId = :tripId");
        if(!StringUtils.isNullOrEmpty(request.getUserId())) {
            TripEntity trip = em.find(TripEntity.class, request.getTripId());
            if(!current.getId().equals(trip.getDriverId())) {
                throw new OnlyDriverCanModifyException();
            }
            q.setParameter("userId", request.getUserId());
        } else {
            q.setParameter("userId", current.getId());
        }
        
        q.setParameter("tripId", request.getTripId());
        List<TripUserEntity> result = q.getResultList();
        if(result.size() != 1) {
            throw new UserNotRequestedInTripException();
        }

        TripUserEntity entity = result.get(0);
        em.remove(entity);

        return new EntityResult<TripUserRequest>(request);
    }
}
