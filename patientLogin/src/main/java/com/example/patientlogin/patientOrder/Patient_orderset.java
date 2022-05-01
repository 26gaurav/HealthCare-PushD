package com.example.patientlogin.patientOrder;

import javax.persistence.Entity;

import com.example.patientlogin.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;

import javax.persistence.*;
@Entity(name = "patient_orderset")
public class Patient_orderset {

    @Id
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="pat_id")
    private AppUser patient;

    @Column(columnDefinition = "json")
    @JsonRawValue
    private String orderset;

    public Patient_orderset() {
    }

    public Patient_orderset(Long id, AppUser patient, String orderset) {
        this.id = id;
        this.patient = patient;
        this.orderset = orderset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getPatient() {
        return patient;
    }

    public void setPatient(AppUser patient) {
        this.patient = patient;
    }

    @JsonBackReference
    public String getOrderset() {
        return orderset;
    }

    public void setOrderset(String orderset) {
        this.orderset = orderset;
    }

}
