package com.example.patientlogin.patientOrder;

import com.example.patientlogin.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientOrderSetRepo extends JpaRepository<Patient_orderset,Long> {

    List<Patient_orderset> getPatient_ordersetByPatient(AppUser patient);

    @Transactional
    @Modifying
    @Query("DELETE FROM patient_orderset WHERE patient = ?1")
    void deleteByPatientId(AppUser appUser);
}
