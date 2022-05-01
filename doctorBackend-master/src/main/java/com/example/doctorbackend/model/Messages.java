package com.example.doctorbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "messages")
public class Messages {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "Text")
    private String message;

    @Column
    private boolean postedBy;

    @Column
    private boolean readReceipt;

    @Column
    private LocalDateTime time;

    public Messages(String message, boolean postedBy, boolean readReceipt, LocalDateTime time) {
        this.message = message;
        this.postedBy = postedBy;
        this.readReceipt = readReceipt;
        this.time = time;
    }

    public Messages() {

    }

    @ManyToOne
    @JoinColumn(name = "pat_id") // this is the name of the column i.e. pat_id
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Doctor doctor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPostedBy() {
        return postedBy;
    }

    public void setPostedBy(boolean postedBy) {
        this.postedBy = postedBy;
    }

    public boolean isReadReceipt() {
        return readReceipt;
    }

    public void setReadReceipt(boolean readReceipt) {
        this.readReceipt = readReceipt;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonBackReference
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
