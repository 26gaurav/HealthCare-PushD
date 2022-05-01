package com.example.patientlogin.consent;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String email;
    private String fname;
    private String lname;
    private String password;
    private String Specilization;

    @OneToMany(mappedBy = "specialist")
    private List<Patient_specialist> patient_specialists;

    public Specialist() {
    }

    public Specialist(Long id, String email, String fname, String lname, String password, String specilization, List<Patient_specialist> patient_specialists) {
        Id = id;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        Specilization = specilization;
        this.patient_specialists = patient_specialists;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecilization() {
        return Specilization;
    }

    public void setSpecilization(String specilization) {
        Specilization = specilization;
    }

    @JsonBackReference
    public List<Patient_specialist> getPatient_specialists() {
        return patient_specialists;
    }

    public void setPatient_specialists(List<Patient_specialist> patient_specialists) {
        this.patient_specialists = patient_specialists;
    }
}
