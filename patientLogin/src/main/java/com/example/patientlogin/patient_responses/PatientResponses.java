package com.example.patientlogin.patient_responses;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.questions.Questions;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class PatientResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer response;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private AppUser appUser;

//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Questions questions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    @JsonBackReference
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @JsonBackReference
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
