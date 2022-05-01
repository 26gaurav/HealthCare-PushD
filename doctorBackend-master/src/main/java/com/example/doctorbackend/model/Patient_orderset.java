package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

import javax.persistence.*;

@Entity
public class Patient_orderset {
    @Id
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="pat_id")
    private Patient patient;

    @Column(columnDefinition = "json")
    @JsonRawValue
    private String orderset;

    public Patient_orderset() {
    }

    public Patient_orderset(Long id, Patient patient, String orderset) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getOrderset() {
        return orderset;
    }

    public void setOrderset(String orderset) {
        this.orderset = orderset;
    }
}
