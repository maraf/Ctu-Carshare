package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;
import java.util.List;

@Serializable(name="new-trip")
@Deserializable(name="new-trip")
public class NewTrip implements java.io.Serializable {
    private String from;
    private String to;
    private Date departure;
    private Date arrival;
    private int totalPrice;
    private int availableSeats;
    private int totalSeats;
    private List<TripStop> stops;

    public NewTrip() {
    }

    public NewTrip(String from, String to, Date departure, Date arrival, int totalPrice, int availableSeats, int totalSeats, List<TripStop> stops) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
        this.totalPrice = totalPrice;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.stops = stops;
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

    @Serializable(name="stops")
    public List<TripStop> getStops() {
        return stops;
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

    @Deserializable(name="stops")
    public void setStops(List<TripStop> stops) {
        this.stops = stops;
    }
}
