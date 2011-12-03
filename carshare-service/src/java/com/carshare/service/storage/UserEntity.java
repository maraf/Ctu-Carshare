/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.carshare.domain.dto.*;

/**
 *
 * @author Mara
 */
@Entity
public class UserEntity implements Serializable {
    private String id;

    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String carDescription;
    private Date registrated;
    private boolean certified;

    public UserEntity() {
    }

    public UserEntity(User user) {
        update(user);
    }

    public UserEntity(UserUpdate user) {
        update(user);
    }

    public void update(User user) {
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
        this.carDescription = user.getCarDescription();

        if(this.id == null)
            this.registrated = user.getRegistrated();

        if(this.id == null)
            this.certified = user.getCertified();
    }

    public void update(UserUpdate user) {
        update((User)user);
        this.password = user.getPassword();
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getRegistrated() {
        return registrated;
    }

    public void setRegistrated(Date registrated) {
        this.registrated = registrated;
    }

    public User asUser() {
        return new User(id, email, firstName, lastName, phoneNumber, address, carDescription, registrated, certified);
    }

    public UserUpdate asUserUpdate() {
        return new UserUpdate(id, email, firstName, lastName, phoneNumber, address, carDescription, registrated, certified, password);
    }
}
