package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="user-in-trip")
@Deserializable(name="user-in-trip")
public class UserInTrip extends User {
    private TripUserStatus status;

    public UserInTrip() {
    }

    public UserInTrip(String id, String email, String firstName, String lastName, String phoneNumber, String address, String carDescription, Date registrated, boolean certified, TripUserStatus status) {
        super(id, email, firstName, lastName, phoneNumber, address, carDescription, registrated, certified);
        this.status = status;
    }

    @Serializable(name="status")
    public TripUserStatus getStatus() {
        return status;
    }

    @Deserializable(name="status")
    public void setStatus(TripUserStatus status) {
        this.status = status;
    }
}
