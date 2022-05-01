package com.example.patientlogin.consent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class SpecialistRegistration {

    private final String email;
    private final String password;
    private final String fname;
    private final String lname;

    public SpecialistRegistration(String email, String password, String fname, String lname) {
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }
}
