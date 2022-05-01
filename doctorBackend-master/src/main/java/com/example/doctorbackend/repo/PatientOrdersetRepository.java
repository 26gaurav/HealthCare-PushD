package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_orderset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientOrdersetRepository extends JpaRepository<Patient_orderset, Long> {

    List<Patient_orderset> getPatient_ordersetByPatient(Patient patient);

    @Transactional
    @Modifying
    @Query("DELETE FROM Patient_orderset WHERE patient = ?1")
    void deleteByPatientId(Patient patient);
}
