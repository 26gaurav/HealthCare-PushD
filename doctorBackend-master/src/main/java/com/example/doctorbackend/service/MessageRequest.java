package com.example.doctorbackend.service;

public class MessageRequest {

    private final String message;
    private final boolean postedBy;

    public MessageRequest(String comment, boolean postedBy) {
        this.message = comment;
        this.postedBy = postedBy;
    }

    public String getMessage() {
        return message;
    }

    public boolean isPostedBy() {
        return postedBy;
    }
}
