package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Patient_responses {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Patient patient;

//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Questions questions;

    private Integer response;

    public Patient_responses() {
    }

    public Patient_responses(Long id, Patient patient, Questions questions, Integer response) {
        Id = id;
        this.patient = patient;
        this.questions = questions;
        this.response = response;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonBackReference
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
