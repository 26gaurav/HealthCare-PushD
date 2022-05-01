package com.example.patientlogin.doctor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class DoctorRegistration {

    private final String username;
    private final String password;
    private final String fname;
    private final String lname;


    public DoctorRegistration(String username, String password, String fname, String lname) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }
}
