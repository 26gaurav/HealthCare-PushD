package com.example.patientlogin.consent;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientSpecialistRepo extends JpaRepository<Patient_specialist,Long> {
    List<Patient_specialist> getPatient_specialistByPatient(AppUser appUser);
}
