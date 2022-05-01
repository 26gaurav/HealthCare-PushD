package com.example.patientlogin.patient_responses;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.questions.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientResponsesRepo  extends JpaRepository<PatientResponses,Long> {
    List<PatientResponses> findByQuestionsAndAppUser(Questions q, AppUser appUser);

    List<PatientResponses> getPatientResponsesByAppUser(AppUser appUser);
}
