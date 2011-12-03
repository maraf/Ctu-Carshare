package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;
import java.util.List;

@Serializable(name="new-trip")
@Deserializable(name="new-trip")
public class NewTrip {
    private Date departure;
    private Date arrival;
    private int totalPrice;
    private int availableSeats;
    private int totalSeats;
    private int driverRating;
    private List<TripStop> stops;

    public NewTrip() {
    }

    public NewTrip(Date departure, Date arrival, int totalPrice, int availableSeats, int totalSeats, int driverRating) {
        this.departure = departure;
        this.arrival = arrival;
        this.totalPrice = totalPrice;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.driverRating = driverRating;
    }

    @Serializable(name="departure")
    public Date getDeparture() {
        return departure;
    }

    @Serializable(name="arrival")
    public Date getArrival() {
        return arrival;
    }

    @Serializable(name="total-price")
    public int getTotalPrice() {
        return totalPrice;
    }

    @Serializable(name="available-seats")
    public int getAvailableSeats() {
        return availableSeats;
    }

    @Serializable(name="total-seats")
    public int getTotalSeats() {
        return totalSeats;
    }

    @Serializable(name="driver-rating")
    public int getDriverRating() {
        return driverRating;
    }

    @Serializable(name="stops")
    public List<TripStop> getStops() {
        return stops;
    }

    @Deserializable(name="departure")
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Deserializable(name="arrival")
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    @Deserializable(name="total-price")
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Deserializable(name="available-seats")
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Deserializable(name="total-seats")
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Deserializable(name="driver-rating")
    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    @Deserializable(name="stops")
    public void setStops(List<TripStop> stops) {
        this.stops = stops;
    }
}
