package com.carshare.domain.dto;

import com.neptuo.service.io.annotation.*;

@Serializable(name="message-filter")
@Deserializable(name="message-filter")
public class MessageFilter implements java.io.Serializable {
    private int count;
    private String fromUserId;

    public MessageFilter() {
    }

    public MessageFilter(int count, String fromUserId) {
        this.count = count;
        this.fromUserId = fromUserId;
    }

    @Serializable(name="count")
    public int getCount() {
        return count;
    }

    @Deserializable(name="count")
    public void setCount(int count) {
        this.count = count;
    }

    @Serializable(name="from-user-id")
    public String getFromUserId() {
        return fromUserId;
    }

    @Deserializable(name="from-user-id")
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }
}
