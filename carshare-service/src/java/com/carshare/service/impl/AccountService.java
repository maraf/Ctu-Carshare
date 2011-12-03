/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.*;
import com.carshare.domain.dto.*;
import com.carshare.service.storage.*;
import com.carshare.service.util.*;
import com.carshare.service.validation.*;
import com.neptuo.service.*;
import com.neptuo.service.annotation.*;
import com.neptuo.service.result.*;

/**
 *
 * @author Mara
 */
@ServiceClass(url="/account")
public class AccountService {

    @ServiceMethod(name="login")
    public EntityResult<User> login(EntityManager em, @RequestInput("user-login") UserLogin user, HttpServletResponse response, HttpServletRequest request) throws HttpException {
        user.setPassword(HashHelper.SHA1(user.getPhoneNumber() + user.getPassword()));

        List<UserEntity> results = (List<UserEntity>)em
                .createQuery("select u from " + UserEntity.class.getName() + " u where u.phoneNumber = :phoneNumber and u.password = :password")
                .setParameter("phoneNumber", user.getPhoneNumber())
                .setParameter("password", user.getPassword())
                .getResultList();

        if(results.isEmpty()) {
            throw new HttpUnauthorizedException();
        }
        UserEntity entity = results.get(0);

        String authToken = ResponseHelper.setAuthToken(response, HashHelper.SHA1(PublicHelper.random()));
        
        UserLogEntity log = new UserLogEntity(entity.getId(), authToken, new Date());
        em.persist(log);
        
        return new EntityResult<User>(entity.asUser());
    }

    @ServiceMethod(name="info")
    public EntityResult<User> info(UserEntity user) throws HttpException {
        return new EntityResult<User>(user.asUser());
    }

    @ServiceMethod(name="logout")
    public void logout(EntityManager em, UserLogEntity log) throws HttpException {
        log.setLogoutTime(new Date());
        em.persist(log);
    }

    @ServiceMethod(name="register")
    public EntityResult<User> register(EntityManager em, @RequestInput("user-update") UserUpdate user) throws ServiceException {
        if(user.getPhoneNumber() == null || !isPhoneNumberUnique(em, user.getPhoneNumber(), null)) {
            throw new InvalidPhoneNumberException();
        }
        if(user.getPassword() == null) {
            throw new InvalidPasswordException();
        }

        UserEntity entity = new UserEntity(user);
        entity.setId(HashHelper.SHA1(PublicHelper.random()));
        entity.setRegistrated(new Date());
        entity.setCertified(false);
        entity.setPassword(HashHelper.SHA1(entity.getPhoneNumber() + entity.getPassword()));
        em.persist(entity);

        return new EntityResult<User>(entity.asUser());
    }

    @ServiceMethod(name="update")
    public EntityResult<User> update(EntityManager em, UserEntity current, @RequestInput("user-update") UserUpdate user) throws ServiceException {
        if(user.getPhoneNumber() == null || !isPhoneNumberUnique(em, user.getPhoneNumber(), current.getId())) {
            throw new InvalidPhoneNumberException();
        }
        if(user.getPassword() == null) {
            throw new InvalidPasswordException();
        }

        current.update(user);
        current.setPassword(HashHelper.SHA1(current.getPhoneNumber() + current.getPassword()));
        em.persist(current);

        return new EntityResult<User>(current.asUser());
    }

    //TODO: Remove it!
    @ServiceMethod(name="list")
    public CollectionResult<User> list(EntityManager em) {
        List<User> result = new ArrayList<User>();

        for (Object item : em.createQuery("select from " + UserEntity.class.getName()).getResultList()) {
            result.add(((UserEntity)item).asUser());
        }

        return new CollectionResult<User>("users", result);
    }

    private boolean isPhoneNumberUnique(EntityManager em, String phoneNumber, String userId) {
        List<UserEntity> results = (List<UserEntity>) em
                .createQuery("select u from UserEntity u where u.phoneNumber = :phoneNumber")
                .setParameter("phoneNumber", phoneNumber)
                .setMaxResults(1)
                .getResultList();

        if(results.isEmpty())
            return true;
        
        if(userId != null && results.get(0).getId().equals(userId))
            return true;

        return false;
    }
}
