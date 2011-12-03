package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="trip-detail")
@Deserializable(name="trip-detail")
public class TripStop {
    private String place;
    private Date arrival;

    public TripStop() {
    }

    public TripStop(String place, Date arrival) {
        this.place = place;
        this.arrival = arrival;
    }

    @Serializable(name="place")
    public String getPlace() {
        return place;
    }

    @Serializable(name="arrival")
    public Date getArrival() {
        return arrival;
    }

    @Deserializable(name="place")
    public void setPlace(String place) {
        this.place = place;
    }

    @Deserializable(name="arrival")
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
}
