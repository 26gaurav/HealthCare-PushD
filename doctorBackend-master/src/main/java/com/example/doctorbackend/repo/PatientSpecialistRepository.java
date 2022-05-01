package com.example.doctorbackend.repo;

import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_specialist;
import com.example.doctorbackend.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientSpecialistRepository extends JpaRepository<Patient_specialist, Long> {

    List<Patient_specialist> getPatient_specialistByPatientAndSpecialist(Patient patient, Specialist specialist);
}
