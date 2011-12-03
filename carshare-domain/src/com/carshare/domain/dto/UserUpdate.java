package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="user-update")
@Deserializable
public class UserUpdate extends User {
    private String password;

    public UserUpdate() {
    }

    public UserUpdate(String id, String email, String firstName, String lastName, String phoneNumber, String address, String carDescription, Date registrated, boolean certified, String password) {
        super(id, email, firstName, lastName, phoneNumber, address, carDescription, registrated, certified);
        this.password = password;
    }

    @Serializable(name="password")
    public String getPassword() {
        return password;
    }

    @Deserializable(name="password")
    public void setPassword(String password) {
        this.password = password;
    }
}
