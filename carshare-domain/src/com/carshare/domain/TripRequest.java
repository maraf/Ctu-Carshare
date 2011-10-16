package com.carshare.domain;

public class TripRequest {
    private int id;
    private int maximumPrice;
    private int seats;
    private Stop start;
    private Stop end;

    public Stop getEnd() {
        return end;
    }

    public void setEnd(Stop end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Stop getStart() {
        return start;
    }

    public void setStart(Stop start) {
        this.start = start;
    }
}
