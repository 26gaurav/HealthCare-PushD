package com.example.patientlogin.appuser;

import com.example.patientlogin.doctor.Doctor;
import com.example.patientlogin.messages.Messages;
import com.example.patientlogin.patientOrder.Patient_orderset;
import com.example.patientlogin.patient_mood.PatientMood;
import com.example.patientlogin.patient_progress.PatientProgress;
import com.example.patientlogin.patient_responses.PatientResponses;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "patient")
public class AppUser implements UserDetails
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; // auto generated when we create a user.

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private boolean enabled = false;

    public AppUser(String firstName, String lastName,
                   String email, String password,
                   AppUserRole appUserRole,boolean enabled)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.enabled = true;
    }

//    @OneToOne(mappedBy = "patient",cascade = CascadeType.MERGE)
//    @PrimaryKeyJoinColumn
//    private Patient_orderset patient_orderset;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;

    @OneToOne(mappedBy = "appUser",cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private PatientProgress patientProgress;

    @OneToMany(mappedBy = "appUser",cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private List<Messages> messages;

    @OneToMany(mappedBy = "appUser")
    private List<PatientMood> patientMood;

    @OneToMany(mappedBy = "appUser")
    private List<PatientResponses> patient_responses;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    //---------------------------------------------------------

    @JsonManagedReference
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

//    @JsonIgnore
    public PatientProgress getPatientProgress() {
        return patientProgress;
    }

    public void setPatientProgress(PatientProgress patientProgress) {
        this.patientProgress = patientProgress;
    }

    @JsonManagedReference
    public List<PatientMood> getPatientMood() {
        return patientMood;
    }

    public void setPatientMood(List<PatientMood> patientMood) {
        this.patientMood = patientMood;
    }

    @JsonManagedReference
    public List<PatientResponses> getPatient_responses() {
        return patient_responses;
    }

    public void setPatient_responses(List<PatientResponses> patient_responses) {
        this.patient_responses = patient_responses;
    }

    @JsonManagedReference
    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

//    @JsonManagedReference
//    public Patient_orderset getPatient_orderset() {
//        return patient_orderset;
//    }
//
//    public void setPatient_orderset(Patient_orderset patient_orderset) {
//        this.patient_orderset = patient_orderset;
//    }
}
