/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.domain.dto;

import java.util.Date;
import com.neptuo.service.io.annotation.*;

/**
 *
 * @author Mara
 */
@Serializable(name="user")
@Deserializable(name="user")
public class User {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String carDescription;
    private Date registrated;
    private boolean certified;

    public User() {
    }

    public User(String id, String email, String firstName, String lastName, String phoneNumber, String address, String carDescription, Date registrated, boolean certified) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.carDescription = carDescription;
        this.registrated = registrated;
        this.certified = certified;
    }

    @Serializable(name="id")
    public String getId() {
        return id;
    }

    @Deserializable(name="id")
    public void setId(String id) {
        this.id = id;
    }

    @Serializable(name="address")
    public String getAddress() {
        return address;
    }

    @Deserializable(name="address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Serializable(name="car-description")
    public String getCarDescription() {
        return carDescription;
    }

    @Deserializable(name="car-description")
    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    @Serializable(name="certified")
    public boolean getCertified() {
        return certified;
    }

    @Deserializable(name="certified")
    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    @Serializable(name="email")
    public String getEmail() {
        return email;
    }

    @Deserializable(name="email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Serializable(name="firstname")
    public String getFirstName() {
        return firstName;
    }

    @Deserializable(name="firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Serializable(name="lastname")
    public String getLastName() {
        return lastName;
    }

    @Deserializable(name="lastname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Serializable(name="phone-number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Deserializable(name="phone-number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Serializable(name="registrated")
    public Date getRegistrated() {
        return registrated;
    }

    @Deserializable(name="registrated")
    public void setRegistrated(Date registrated) {
        this.registrated = registrated;
    }
}
