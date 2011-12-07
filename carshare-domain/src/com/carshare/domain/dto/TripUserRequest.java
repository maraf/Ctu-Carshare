/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

/**
 *
 * @author Mara
 */
@Serializable(name="trip-user-request")
@Deserializable(name="trip-user-request")
public class TripUserRequest implements java.io.Serializable {

    private String userId;
    private String tripId;

    public TripUserRequest() {
    }

    public TripUserRequest(String userId, String tripId) {
        this.userId = userId;
        this.tripId = tripId;
    }

    @Serializable(name="trip-id")
    public String getTripId() {
        return tripId;
    }

    @Serializable(name="user-id")
    public String getUserId() {
        return userId;
    }

    @Deserializable(name="trip-id")
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    @Deserializable(name="user-id")
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
