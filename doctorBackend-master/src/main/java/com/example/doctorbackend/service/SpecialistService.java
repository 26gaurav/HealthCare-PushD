package com.example.doctorbackend.service;

import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.model.Patient_specialist;
import com.example.doctorbackend.model.Specialist;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpecialistService {

    @Autowired
    SpecialistRepository specialistRepository;

    @Autowired
    PatientSpecialistRepository patientSpecialistRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientMoodRepository patientMoodRepository;

    @Autowired
    private PatientProgressRepository patientProgressRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private PatientOrdersetRepository patientOrdersetRepository;

    public Specialist login(Map<String, Object> payload){
        List<Specialist> specialists = specialistRepository.getSpecialistByEmail((String)payload.get("email"));
        if (specialists.size()==0 || !specialists.get(0).getPassword().equals((String)payload.get("password")))
            return null;
        Specialist specialist = specialists.get(0);
        specialist.setPassword("");
        return specialist;
    }

    public List<Doctor> getAllDoctor(Long specialistId){
        return doctorRepository.findAll();
    }

    public List<Patient> getPatientByDoctorIdforSpecialist(Long DoctorId, Long specialistId){
        Doctor doctor = doctorRepository.getById(DoctorId);
        Specialist specialist = specialistRepository.getById(specialistId);
        List<Patient> patientList = patientRepository.findByDoctor(doctor);
        List<Patient> patients = new ArrayList<>();

        List<Patient_specialist>  patient_specialists = null;
        for (Patient p : patientList){
            patient_specialists = null;
            patient_specialists = patientSpecialistRepository.getPatient_specialistByPatientAndSpecialist(p, specialist);
            p.setPassword("");
            if(patient_specialists.size()==0) {
                p.setCount("0");
                patients.add(p);
            }
            else if(Integer.parseInt(patient_specialists.get(0).getViewConsent())==1){
                p.setCount("1");
                patients.add(p);
            }
            else if(Integer.parseInt(patient_specialists.get(0).getViewConsent())==2){
                p.setCount("2");
                patients.add(p);
            }
        }
        return patients;
    }

    public boolean askForPermission(Long spec_id, Long pat_id){
        Specialist specialist = specialistRepository.getById(spec_id);
        Patient patient = patientRepository.getById(pat_id);

        List<Patient_specialist> patient_specialists = patientSpecialistRepository.getPatient_specialistByPatientAndSpecialist(patient, specialist);
        if(patient_specialists.size()>=1)
            return false;

        Patient_specialist patient_specialist = new Patient_specialist();
        patient_specialist.setPatient(patient);
        patient_specialist.setSpecialist(specialist);
        patient_specialist.setViewConsent("1");
        patientSpecialistRepository.save(patient_specialist);
        return true;
    }

    public List<Specialist> getAllSpecialist(){
        List<Specialist> specialistList = specialistRepository.findAll();

        for(Specialist s: specialistList){
            s.setPassword("");
        }
        return specialistList;
    }

}
