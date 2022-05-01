package com.example.patientlogin.patient_mood;

import com.example.patientlogin.appuser.AppUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class PatientMood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_MOOD_SEQUENCE")
    private Long Id;

    private LocalDateTime moodTime;

    private Integer mood;

    //    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private AppUser appUser;
}
