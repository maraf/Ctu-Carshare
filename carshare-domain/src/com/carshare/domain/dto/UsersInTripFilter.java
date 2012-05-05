package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

@Serializable(name="users-in-trip-filter")
@Deserializable(name="users-in-trip-filter")
public class UsersInTripFilter {
    private String tripId;
    private boolean withoutRequests;

    public UsersInTripFilter() {
    }

    public UsersInTripFilter(String tripId, boolean withoutRequests) {
        this.tripId = tripId;
        this.withoutRequests = withoutRequests;
    }

    @Serializable(name="without-requests")
    public boolean getWithoutRequests() {
        return withoutRequests;
    }

    @Deserializable(name="without-requests")
    public void setWithoutRequests(boolean withoutRequests) {
        this.withoutRequests = withoutRequests;
    }

    @Serializable(name="trip-id")
    public String getTripId() {
        return tripId;
    }

    @Deserializable(name="trip-id")
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
