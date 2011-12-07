/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import com.carshare.domain.dto.TripUserStatus;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Mara
 */
@Entity
public class TripUserEntity implements Serializable {

    private String id;

    private String tripId;
    private String userId;
    private TripUserStatus status;

    public TripUserEntity() {
    }

    public TripUserEntity(String tripId, String userId) {
        this.tripId = tripId;
        this.userId = userId;
        this.status = TripUserStatus.REQUESTED;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getTripId() {
        return tripId;
    }

    public String getUserId() {
        return userId;
    }

    public TripUserStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(TripUserStatus status) {
        this.status = status;
    }
}
