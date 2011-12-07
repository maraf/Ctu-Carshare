package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;
import java.util.Date;

@Serializable(name="user-message")
@Deserializable(name="user-message")
public class UserMessage implements java.io.Serializable {
    private String userId;
    private String subject;
    private String content;
    private Date sent;

    public UserMessage() {
    }

    public UserMessage(String userId, String subject, String content, Date sent) {
        this.userId = userId;
        this.subject = subject;
        this.content = content;
        this.sent = sent;
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
}
