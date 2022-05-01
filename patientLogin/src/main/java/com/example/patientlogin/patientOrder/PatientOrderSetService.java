package com.example.patientlogin.patientOrder;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientOrderSetService {

    private final AppUserRepository appUserRepository;
    private final PatientOrderSetRepo patientOrderSetRepo;

    public Patient_orderset getOrderSet(Long patientId){
        Optional<AppUser> patient = appUserRepository.findById(patientId);
        List<Patient_orderset> patient_ordersets = patientOrderSetRepo.getPatient_ordersetByPatient(patient.get());
        if(patient_ordersets.size()>=1)
            return patient_ordersets.get(0);
        else
            return null;
    }



    public boolean addOrderSet(Map<String, Object> payload, Long patientId){
        AppUser patient = appUserRepository.getById(patientId);

        Patient_orderset patient_orderset = new Patient_orderset();
        patient_orderset.setPatient(patient);
        String orderset = "{\"first\": \"" + (String) payload.get("first") + "\",";
        orderset += "\"second\": \"" + (String) payload.get("second") + "\",";
        orderset += "\"third\": \"" + (String) payload.get("third") + "\",";
        orderset += "\"fourth\": \"" + (String) payload.get("fourth") + "\",";
        orderset += "\"fifth\": \"" + (String) payload.get("fifth") + "\",";
        orderset += "\"sixth\": \"" + (String) payload.get("sixth") + "\",";
        orderset += "\"seventh\": \"" + (String) payload.get("seventh") + "\",";
        orderset += "\"eight\": \"" + (String) payload.get("eight") + "\"}";

        patient_orderset.setOrderset(orderset);
        System.out.println(patient_orderset.getOrderset());
        Patient_orderset patient_orderset1 = patientOrderSetRepo.save(patient_orderset);
        if (patient_orderset1!=null)
            return true;
        else
            return false;


    }

    public boolean updateOrderSet(Map<String, Object> payload, Long patientId)
    {

        AppUser patient = appUserRepository.getById(patientId);
        patientOrderSetRepo.deleteById(patientId);


        Patient_orderset patient_orderset = new Patient_orderset();
        patient_orderset.setPatient(patient);

        String orderset = "{\"first\": \"" + (String) payload.get("first") + "\",";
        orderset += "\"second\": \"" + (String) payload.get("second") + "\",";
        orderset += "\"third\": \"" + (String) payload.get("third") + "\",";
        orderset += "\"fourth\": \"" + (String) payload.get("fourth") + "\",";
        orderset += "\"fifth\": \"" + (String) payload.get("fifth") + "\",";
        orderset += "\"sixth\": \"" + (String) payload.get("sixth") + "\",";
        orderset += "\"seventh\": \"" + (String) payload.get("seventh") + "\",";
        orderset += "\"eight\": \"" + (String) payload.get("eight") + "\"}";

        patient_orderset.setOrderset(orderset);
        System.out.println(patient_orderset.getOrderset());
        Patient_orderset patient_orderset1 = patientOrderSetRepo.save(patient_orderset);
        if (patient_orderset1!=null)
            return true;
        else
            return false;
    }
}
