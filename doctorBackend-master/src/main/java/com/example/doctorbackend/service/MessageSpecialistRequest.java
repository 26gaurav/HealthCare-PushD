package com.example.doctorbackend.service;

public class MessageSpecialistRequest {

    private final String message;
    private final boolean postedBy;

    public String getMessage() {
        return message;
    }

    public boolean isPostedBy() {
        return postedBy;
    }

    public MessageSpecialistRequest(String message, boolean postedBy) {
        this.message = message;
        this.postedBy = postedBy;


    }
}
