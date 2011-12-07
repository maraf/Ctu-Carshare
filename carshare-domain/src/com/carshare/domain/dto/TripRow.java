package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="trip-row")
@Deserializable(name="trip-row")
public class TripRow implements java.io.Serializable {
    private String id;
    private String from;
    private String to;
    private Date departure;
    private Date arrival;
    private int totalPrice;
    private int availableSeats;
    private int totalSeats;
    private String driverId;
    private int driverRating;

    public TripRow() {
    }

    public TripRow(String id, String from, String to, Date departure, Date arrival, int totalPrice, int availableSeats, int totalSeats, String driverId, int driverRating) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
        this.totalPrice = totalPrice;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.driverId = driverId;
        this.driverRating = driverRating;
    }

    @Serializable(name="id")
    public String getId() {
        return id;
    }

    @Serializable(name="to")
    public String getTo() {
        return to;
    }

    @Serializable(name="from")
    public String getFrom() {
        return from;
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

    @Serializable(name="driver-id")
    public String getDriverId() {
        return driverId;
    }

    @Serializable(name="driver-rating")
    public int getDriverRating() {
        return driverRating;
    }

    @Deserializable(name="id")
    public void setId(String id) {
        this.id = id;
    }

    @Deserializable(name="to")
    public void setTo(String to) {
        this.to = to;
    }

    @Deserializable(name="from")
    public void setFrom(String from) {
        this.from = from;
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

    @Deserializable(name="driver-id")
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Deserializable(name="driver-rating")
    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }
}
