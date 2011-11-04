/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

/**
 *
 * @author Mara
 */
@Serializable(name="user-login")
@Deserializable(name="user-login")
public class UserLogin {
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
