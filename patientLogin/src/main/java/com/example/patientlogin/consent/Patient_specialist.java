package com.example.patientlogin.consent;

import com.example.patientlogin.appuser.AppUser;

import javax.persistence.*;

@Entity
public class Patient_specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String viewConsent;

    @OneToOne
    @JoinColumn(name="pat_id")
    private AppUser patient;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Specialist specialist;

    public Patient_specialist() {
    }

    public Patient_specialist(Long id, String viewConsent, AppUser patient, Specialist specialist) {
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

    public AppUser getPatient() {
        return patient;
    }

    public void setPatient(AppUser patient) {
        this.patient = patient;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }
}
