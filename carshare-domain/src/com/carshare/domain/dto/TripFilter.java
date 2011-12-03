package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

@Serializable(name="trip-filter")
@Deserializable(name="trip-filter")
public class TripFilter {
    private String from;
    private String to;
    private double maxPrice;
    private int seats;
    private int minRating;

    public TripFilter() {
    }

    public TripFilter(String from, String to, double maxPrice, int seats, int minRating) {
        this.from = from;
        this.to = to;
        this.maxPrice = maxPrice;
        this.seats = seats;
        this.minRating = minRating;
    }

    @Serializable(name="from")
    public String getFrom() {
        return from;
    }

    @Serializable(name="to")
    public String getTo() {
        return to;
    }

    @Serializable(name="max-price")
    public double getMaxPrice() { //Not yet implemented on server
        return maxPrice;
    }

    @Serializable(name="seats")
    public int getSeats() {
        return seats;
    }

    @Serializable(name="min-rating")
    public int getMinRating() { //Not yet implemented on server
        return minRating;
    }

    @Deserializable(name="from")
    public void setFrom(String from) {
        this.from = from;
    }

    @Deserializable(name="to")
    public void setTo(String to) {
        this.to = to;
    }

    @Deserializable(name="max-price")
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Deserializable(name="seats")
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Deserializable(name="min-rating")
    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }
}
