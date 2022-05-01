package com.example.patientlogin.messages;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class MessageRequest {

    private final String message;
    private final boolean postedBy;

    public MessageRequest(String comment, boolean postedBy) {
        this.message = comment;
        this.postedBy = postedBy;
    }
}
