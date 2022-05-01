package com.example.patientlogin.consent;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class consentController {

    @Autowired
    private PatientSpecialistRepo patientSpecialistRepo;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private SpecialistRepo specialistRepo;

    @GetMapping("/consent/{pat_id}")
    public ResponseEntity<?> getConsent(@PathVariable Long pat_id){
        AppUser appUser = appUserRepository.getById(pat_id);
        List<Patient_specialist> patient_specialistList = patientSpecialistRepo.getPatient_specialistByPatient(appUser);
        Response response = new Response();
        if (patient_specialistList.size()==0){
            response.setFname("");
            response.setLname("");
            response.setCount("0");
            return ResponseEntity.ok(response);
        }
        else{
            response.setCount(patient_specialistList.get(0).getViewConsent());
            response.setFname(patient_specialistList.get(0).getSpecialist().getFname());
            response.setLname(patient_specialistList.get(0).getSpecialist().getLname());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/provideConsent/{pat_id}/{isConsent}")
    public ResponseEntity<?> provideConsent(@PathVariable Long pat_id, @PathVariable String isConsent){
        AppUser appUser = appUserRepository.getById(pat_id);
        try{

            Patient_specialist patient_specialist = patientSpecialistRepo.getPatient_specialistByPatient(appUser).get(0);
            Response response = new Response();
            if(isConsent.equals("1")) {
                patient_specialist.setViewConsent("2");
                response.setCount("2");
            }
            else if(isConsent.equals("2")) {
                patient_specialist.setViewConsent("1");
                response.setCount("1");
                patientSpecialistRepo.delete(patient_specialist);
                response.setCount("3");
                response.setFname(patient_specialist.getSpecialist().getFname());
                response.setLname(patient_specialist.getSpecialist().getLname());
                return ResponseEntity.ok(response);
            }
            patientSpecialistRepo.save(patient_specialist);
            response.setFname(patient_specialist.getSpecialist().getFname());
            response.setLname(patient_specialist.getSpecialist().getLname());
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("unSuccessful");
        }
    }
}
