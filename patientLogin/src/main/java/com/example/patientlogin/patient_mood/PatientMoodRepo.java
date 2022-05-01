package com.example.patientlogin.patient_mood;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientMoodRepo extends JpaRepository<PatientMood,Long> {

    List<PatientMood> getPatientMoodByAppUser(AppUser appUser);
}
