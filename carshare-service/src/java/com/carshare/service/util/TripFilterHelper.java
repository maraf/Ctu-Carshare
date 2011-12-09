/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.util;

import com.carshare.domain.dto.*;
import com.carshare.service.storage.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Mara
 */
public class TripFilterHelper {

    private TripFilter filter;
    private EntityManager em;

    private int fromIndex;

    public TripFilterHelper(TripFilter filter, EntityManager em) {
        this.filter = filter;
        this.em = em;
    }

    public boolean filter(TripEntity entity) {
        fromIndex = -1;

        if(!filterSeats(entity)) {
            return false;
        }

        if(!filterFrom(entity)) {
            return false;
        }

        if(!filterTo(entity)) {
            return false;
        }

        if(!filterMaxPrice(entity)) {
            return false;
        }

        return true;
    }

    private boolean filterSeats(TripEntity entity) {
        if(filter.getSeats() == 0) {
            return true;
        }

        Query q = em.createQuery("select tue from TripUserEntity tue where tue.tripId = :tripId").setParameter("tripId", entity.getId());
        List<TripUserEntity> users = q.getResultList();
        if(users.size() > 0) {
            return (filter.getSeats() + users.size()) <= entity.getAvailableSeats();
        } else {
            return filter.getSeats() <= entity.getAvailableSeats();
        }
    }

    private boolean filterFrom(TripEntity entity) {
        if(StringUtils.isNullOrEmpty(filter.getFrom())) {
            return true;
        }

        if (entity.getFrom().equals(filter.getFrom())) {
            return true;
        }

        int i = 0;
        for (TripStop stop : entity.getStops()) {
            if (stop.getPlace().equals(filter.getFrom())) {
                fromIndex = i;
                return true;
            }
            i++;
        }

        return false;
    }

    private boolean filterTo(TripEntity entity) {
        if (StringUtils.isNullOrEmpty(filter.getTo())) {
            return true;
        }

        if (entity.getTo().equals(filter.getTo())) {
            return true;
        }

        int i = 0;
        for (TripStop stop : entity.getStops()) {
            //Pokud byla při from použita jedna ze zastávek, pak pokud jsme aktuálně až za ní, skončíme
            if(fromIndex != -1 && i >= fromIndex) {
                return false;
            }

            if (stop.getPlace().equals(filter.getTo())) {
                return true;
            }
            i++;
        }

        return false;
    }

    private boolean filterMaxPrice(TripEntity entity) {
        if(filter.getMaxPrice() == 0) {
            return true;
        }

        return (entity.getTotalPrice() / entity.getTotalSeats()) <= filter.getMaxPrice();
    }
}
