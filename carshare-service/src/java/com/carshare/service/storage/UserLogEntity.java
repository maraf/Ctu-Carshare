/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import com.carshare.service.util.PublicHelper;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Mara
 */
@Entity
public class UserLogEntity implements Serializable {
    private String id;
    private String userId;
    private String authToken;
    private Date loginTime;
    private Date logoutTime;

    public UserLogEntity() {
        id = PublicHelper.random();
    }

    public UserLogEntity(String userId, String authToken, Date loginTime) {
        this();
        this.userId = userId;
        this.authToken = authToken;
        this.loginTime = loginTime;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Temporal(TemporalType.DATE)
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Column(nullable=true)
    @Temporal(TemporalType.DATE)
    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
