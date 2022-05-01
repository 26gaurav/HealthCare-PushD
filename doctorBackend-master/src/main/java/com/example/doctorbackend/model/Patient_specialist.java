package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Patient_specialist {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String viewConsent; //0 means no consent, 1 means asked for consent , 2 means consent granted

    @OneToOne
    @JoinColumn(name="pat_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    private Specialist specialist;

    public Patient_specialist() {
    }

    public Patient_specialist(Long id, String viewConsent, Patient patient, Specialist specialist) {
        Id = id;
        this.viewConsent = viewConsent;
        this.patient = patient;
        this.specialist = specialist;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getViewConsent() {
        return viewConsent;
    }

    public void setViewConsent(String viewConsent) {
        this.viewConsent = viewConsent;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonManagedReference
    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }
}
