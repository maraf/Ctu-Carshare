package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="trip-row")
@Deserializable(name="trip-row")
public class TripRow {
    private String id;
    private Date departure;
    private Date arrival;
    private int totalPrice;
    private int availableSeats;
    private int totalSeats;
    private int driverRating;

    public TripRow() {
    }

    public TripRow(String id, Date departure, Date arrival, int totalPrice, int availableSeats, int totalSeats, int driverRating) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.totalPrice = totalPrice;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.driverRating = driverRating;
    }

    @Serializable(name="id")
    public String getId() {
        return id;
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

    @Deserializable(name="id")
    public void setId(String id) {
        this.id = id;
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
}
