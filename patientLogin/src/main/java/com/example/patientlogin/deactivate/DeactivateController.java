package com.example.patientlogin.deactivate;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import com.example.patientlogin.consent.Response;
import com.example.patientlogin.messages.MessageRepo;
import com.example.patientlogin.messages.Messages;
import com.example.patientlogin.patientOrder.PatientOrderSetRepo;
import com.example.patientlogin.patient_mood.PatientMood;
import com.example.patientlogin.patient_mood.PatientMoodRepo;
import com.example.patientlogin.patient_progress.PatientProgressRepo;
import com.example.patientlogin.patient_responses.PatientResponses;
import com.example.patientlogin.patient_responses.PatientResponsesRepo;
import com.example.patientlogin.registration.token.ConfirmationToken;
import com.example.patientlogin.registration.token.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DeactivateController {

    @Autowired
    PatientOrderSetRepo patientOrderSetRepo;

    @Autowired
    PatientProgressRepo patientProgressRepo;

    @Autowired
    PatientMoodRepo patientMoodRepo;

    @Autowired
    PatientResponsesRepo patientResponsesRepo;

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/deleteData/{pat_id}")
    public ResponseEntity<?> deleteData(@PathVariable Long pat_id){
        AppUser patient = appUserRepository.getById(pat_id);
        patientOrderSetRepo.deleteByPatientId(patient);
        patientProgressRepo.deleteByPatientId(patient);

        List<PatientResponses> patientResponsesList = patientResponsesRepo.getPatientResponsesByAppUser(patient);
        List<PatientMood> patientMoodList = patientMoodRepo.getPatientMoodByAppUser(patient);
        List<ConfirmationToken> confirmationTokenList = confirmationTokenRepository.getConfirmationTokenByAppUser(patient);
        List<Messages> messagesList = messageRepo.getMessagesByAppUser(patient);

        patientResponsesRepo.deleteAll(patientResponsesList);
        patientMoodRepo.deleteAll(patientMoodList);
        confirmationTokenRepository.deleteAll(confirmationTokenList);
        messageRepo.deleteAll(messagesList);
        appUserRepository.delete(patient);

        Response response = new Response();
        response.setFname("Deactivation Successful!");
        return ResponseEntity.ok(response);
    }
}
