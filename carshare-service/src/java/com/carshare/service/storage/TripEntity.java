/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import java.io.Serializable;
import javax.persistence.*;
import com.carshare.domain.dto.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mara
 */
@Entity
public class TripEntity implements Serializable {
    private String id;
    private String from;
    private String to;
    private Date departure;
    private Date arrival;
    private int totalPrice;
    private int availableSeats;
    private int totalSeats;
    private List<TripStop> stops;
    private String driverId;

    public TripEntity() {
    }

    public TripEntity(String id, String from, String to, Date departure, Date arrival, int totalPrice, int availableSeats, int totalSeats, List<TripStop> stops, String driverId) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
        this.totalPrice = totalPrice;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.stops = stops;
        this.driverId = driverId;
    }

    public TripEntity(NewTrip trip) {
        this.from = trip.getFrom();
        this.to = trip.getTo();
        this.departure = trip.getDeparture();
        this.arrival = trip.getArrival();
        this.totalPrice = trip.getTotalPrice();
        this.availableSeats = trip.getAvailableSeats();
        this.totalSeats = trip.getTotalSeats();
        this.stops = trip.getStops();
    }

    @Id
    public String getId() {
        return id;
    }

    @Column(name="trip_to")
    public String getTo() {
        return to;
    }

    @Column(name="trip_from")
    public String getFrom() {
        return from;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDeparture() {
        return departure;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getArrival() {
        return arrival;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    @Lob
    public List<TripStop> getStops() {
        return stops;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setStops(List<TripStop> stops) {
        this.stops = stops;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public TripRow asTripRow() {
        //TODO: Driver rating
        return new TripRow(id, from, to, departure, arrival, totalPrice, availableSeats, totalSeats, driverId, 0);
    }
}
