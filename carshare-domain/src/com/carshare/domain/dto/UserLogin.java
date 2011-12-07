package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

@Serializable(name="user-login")
@Deserializable(name="user-login")
public class UserLogin implements java.io.Serializable {
    private String phoneNumber;
    private String password;

    @Serializable(name="password")
    public String getPassword() {
        return password;
    }

    @Deserializable(name="password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Serializable(name="phone-number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Deserializable(name="phone-number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
