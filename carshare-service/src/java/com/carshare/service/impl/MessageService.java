/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.impl;

import com.carshare.domain.dto.*;
import com.carshare.service.storage.*;
import com.carshare.service.util.*;
import com.carshare.service.validation.NullFieldException;
import com.neptuo.service.*;
import com.neptuo.service.annotation.*;
import com.neptuo.service.result.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Mara
 */
@ServiceClass(url="/message")
public class MessageService {

    @ServiceMethod(name="send")
    public void send(EntityManager em, UserEntity current, @RequestInput("user-message") UserMessage message) throws ServiceException {
        if(message.getSubject() == null)
            throw new NullFieldException("subject");

        if(message.getContent() == null)
            throw new NullFieldException("subject");

        if(message.getUserId() == null)
            throw new NullFieldException("user-id");

        UserMessageEntity entity = new UserMessageEntity(message, current.getId(), message.getUserId());
        entity.setId(HashHelper.SHA1(PublicHelper.random()));
        entity.setSent(new Date());
        em.persist(entity);
    }

    @ServiceMethod
    public CollectionResult<UserMessage> get(EntityManager em, UserEntity current, @RequestInput("message-filter") MessageFilter filter) throws ServiceException {
        List<UserMessage> result = new ArrayList<UserMessage>();
        List<UserMessageEntity> items;

        if(filter == null) {
             items = (List<UserMessageEntity>) em
                .createQuery("select m from UserMessageEntity m where m.userId = :userId")
                .setParameter("userId", current.getId())
                .getResultList();
        } else {
            Query q = em.createQuery("select m from UserMessageEntity m where m.userId = :userId" + (filter.getFromUserId() != null ? " and m.fromUserId = :fromUserId" : ""));
            q = q.setParameter("userId", current.getId());
            if(filter.getFromUserId() != null) {
                q = q.setParameter("fromUserId", filter.getFromUserId());
            }
            if(filter.getCount() > 0) {
                q = q.setMaxResults(filter.getCount());
            }
            items = (List<UserMessageEntity>) q.getResultList();
        }

        for (UserMessageEntity item : items) {
            result.add(item.asUserMessage());
        }
        return new CollectionResult<UserMessage>("user-messages", result);
    }

    @ServiceMethod(name="test")
    public EntityResult<UserMessage> test(UserEntity current) {
        return new EntityResult<UserMessage>(new UserMessage(current.getId(), "Hello Message!", "Hey, how are you?", new Date()));
    }
}
