package com.carshare.domain;

import java.util.Date;
import java.util.List;

public class Trip {
    private int id;
    private Date posted;
    private int seatsAvailable;
    private int seatsTotal;
    private double cost;
    private boolean timeGuarantee;
    private String carDescription;
    private User driver;
    private List<Stop> stops;
    private List<User> passengers;
    private List<User> passengerRequests;
    private List<Rating> ratings;

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getPassengerRequests() {
        return passengerRequests;
    }

    public void setPassengerRequests(List<User> passengerRequests) {
        this.passengerRequests = passengerRequests;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(int seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public boolean isTimeGuarantee() {
        return timeGuarantee;
    }

    public void setTimeGuarantee(boolean timeGuarantee) {
        this.timeGuarantee = timeGuarantee;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
