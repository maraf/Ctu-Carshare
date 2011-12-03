/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

/**
 *
 * @author Mara
 */
@Serializable(name="user-detail")
@Deserializable(name="user-detail")
public class UserDetail extends User {
    private int rating;

    public UserDetail() {
    }

    public UserDetail(String id, String email, String firstName, String lastName, String phoneNumber, String address, String carDescription, Date registrated, boolean certified, int rating) {
        super(id, email, firstName, lastName, phoneNumber, address, carDescription, registrated, certified);
        this.rating = rating;
    }

    @Serializable(name="rating")
    public int getRating() {
        return rating;
    }

    @Deserializable(name="rating")
    public void setRating(int rating) {
        this.rating = rating;
    }
}
