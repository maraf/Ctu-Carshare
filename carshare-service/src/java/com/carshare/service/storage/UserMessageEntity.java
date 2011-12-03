/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carshare.service.storage;

import com.carshare.domain.dto.UserMessage;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Mara
 */
@Entity
public class UserMessageEntity {
    private String id;

    private String userId;
    private String fromUserId;
    private String subject;
    private String content;
    private Date sent;

    public UserMessageEntity() {
    }

    public UserMessageEntity(UserMessage userMessage, String fromUserId, String toUserId) {
        this.fromUserId = fromUserId;
        this.userId = toUserId;
        subject = userMessage.getSubject();
        content = userMessage.getContent();
        sent = userMessage.getSent();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserMessage asUserMessage() {
        return new UserMessage(fromUserId, subject, content, sent);
    }
}
