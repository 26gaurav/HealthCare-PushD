package com.example.patientlogin.admin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class AdminRequest {

    private final String username;
    private final String password;


    public AdminRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
