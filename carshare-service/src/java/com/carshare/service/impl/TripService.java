/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.impl;

import com.carshare.domain.dto.*;
import com.carshare.service.storage.TripEntity;
import com.carshare.service.util.*;
import com.carshare.service.validation.NullFieldException;
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
            if(filter.getSeats() > 0) {
                query += " and availableSeats >= :seats";
                params.put("seats", filter.getSeats());
            }
            //TODO: Driver rating ...
        }

        Query q = em.createQuery(query);
        for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
        }

        List<TripRow> result = new ArrayList<TripRow>();
        List<TripEntity> trips = (List<TripEntity>) q.getResultList();
        for (TripEntity entry : trips) {
            result.add(entry.asTripRow());
        }

        return new CollectionResult<TripRow>("trips", result);
    }

    @ServiceMethod(name="create")
    public EntityResult<TripRow> create(@RequestInput NewTrip trip, EntityManager em) throws ServiceException {
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
        em.persist(entity);

        return new EntityResult<TripRow>(entity.asTripRow());
    }
}
