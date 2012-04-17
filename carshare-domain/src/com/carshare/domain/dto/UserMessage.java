package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="user-message")
@Deserializable(name="user-message")
public class UserMessage implements java.io.Serializable {
    private String id;

    private String userId;
    private String subject;
    private String content;
    private Date sent;
    private boolean isRead;

    public UserMessage() {
    }

    public UserMessage(String userId, String subject, String content, Date sent) {
        this.userId = userId;
        this.subject = subject;
        this.content = content;
        this.sent = sent;
    }

    public UserMessage(String id, String userId, String subject, String content, Date sent, boolean isRead) {
        this(userId, subject, content, sent);
        this.id = id;
        this.isRead = isRead;
    }

    @Serializable(name="id")
    public String getId() {
        return id;
    }

    @Deserializable(name="id")
    public void setId(String id) {
        this.id = id;
    }

    @Serializable(name="content")
    public String getContent() {
        return content;
    }

    @Deserializable(name="content")
    public void setContent(String content) {
        this.content = content;
    }

    @Serializable(name="user-id")
    public String getUserId() {
        return userId;
    }

    @Deserializable(name="user-id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Serializable(name="sent")
    public Date getSent() {
        return sent;
    }

    @Deserializable(name="sent")
    public void setSent(Date sent) {
        this.sent = sent;
    }

    @Serializable(name="subject")
    public String getSubject() {
        return subject;
    }

    @Deserializable(name="subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Serializable(name="is-read")
    public boolean isIsRead() {
        return isRead;
    }

    @Deserializable(name="is-read")
    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
}
