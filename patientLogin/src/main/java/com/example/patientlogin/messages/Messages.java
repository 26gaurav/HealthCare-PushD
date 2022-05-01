package com.example.patientlogin.messages;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.aspectj.weaver.loadtime.definition.Definition;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "messages")
public class Messages {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "text")
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pat_id") // this is the name of the column i.e. pat_id
    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "doc_id")
    private Doctor doctor;


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
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @JsonBackReference
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
