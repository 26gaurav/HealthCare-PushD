package com.example.doctorbackend.service;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

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

    @Autowired
    private MessageRepo messageRepo;

    public Doctor findDoctorByUsername(String username){
        Doctor doctor = doctorRepository.findByUsername(username);
        return doctor;
    }

    public List<Patient> findPatientByDoctorService(Long doctorId){
        Doctor doctor = doctorRepository.getById((long)doctorId);
        List<Messages> messagesList = messageRepo.getMessagesByDoctor(doctor);
        List<Long> messagesIdList = new ArrayList<>();
        for(Messages m : messagesList)
            messagesIdList.add(m.getId());

        Collections.sort(messagesIdList, Collections.reverseOrder());

        List<Patient> patients = patientRepository.findByDoctor(doctor);
        List<Patient> patientList = new ArrayList<>();
        HashSet<Long> patientIdSet = new HashSet<>();
        Messages message;
        for (int i=0; i<messagesIdList.size(); i++) {
            message = messageRepo.getById(messagesIdList.get(0));
            if (patientIdSet.contains(message.getPatient().getId()))
                continue;
            else {
                patientList.add(message.getPatient());
                patientIdSet.add(message.getPatient().getId());
            }
        }

        for (Patient patient: patients){
            if (patientIdSet.contains(patient.getId()))
                continue;
            else
                patientList.add(patient);
        }

        int count;
        for(Patient patient: patientList){
            messagesList = null;
            messagesList = messageRepo.getMessagesByDoctorAndPatient(doctor, patient);
            count=0;
            for(Messages m: messagesList){
                if(m.isPostedBy()==true &&m.isReadReceipt()==false) {
                    count+=1;
//                    patient.setPassword("True");  //password will work as read receit
                }
                if(count==0)
                    patient.setCount(null);
                else
                    patient.setCount(Integer.toString(count));
            }
        }
        return patientList;
    }


    public List<PatientMood> findPatientMood(Long patientId){
        Patient patient = patientRepository.getById((long) patientId);

        List<PatientMood> patientMoods = patientMoodRepository.findMood(patient);

        List<PatientMood> resultSet = new ArrayList<>();
        int count = 0;
        for(PatientMood patientMood: patientMoods){
            if (count==7)//taking top 7 results
                break;
            count+=1;
            patientMood.setPatient(null);
            resultSet.add(patientMood);
        }
        return resultSet;
    }


    public Patient findPatientDetails(Long patientId){
        Patient patient = patientRepository.findById(patientId).get();
        return patient;
    }

    public PatientProgressReturn getPatientProgress(Long patientId){
        Patient patient = patientRepository.getById((long) patientId);
        List<Patient_progress> patient_progress =  patientProgressRepository.findByPatient(patient);
        if(patient_progress.size()==0 || patient_progress.get(0).getSection().getId()==0)
        {
            PatientProgressReturn progressProgressReturn = new PatientProgressReturn();
            progressProgressReturn.setPatient(patient);
            List<Section> sectionList = new ArrayList<>();
            sectionList.add(sectionRepository.getById((long)0));
            progressProgressReturn.setSection(sectionList);
            return progressProgressReturn;
        }
        PatientProgressReturn progressProgressReturn = new PatientProgressReturn();
        progressProgressReturn.setPatient(patient);
        List<Section> sectionList = new ArrayList<>();

//       *************Enter new  code here**************************************
        List<Patient_orderset> patient_ordersets = patientOrdersetRepository.getPatient_ordersetByPatient(patient);
        if (patient_ordersets.size()==0)
            return null;
        String orderset = patient_ordersets.get(0).getOrderset();
        System.out.println(orderset);
        HashMap<String, String> ordersetMap = null;
        try {
            ordersetMap = new ObjectMapper().readValue(orderset, HashMap.class);
        } catch (JsonProcessingException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        System.out.println(ordersetMap);
        System.out.println("first value is "+ordersetMap.get("first"));
        System.out.println("eight value is "+ordersetMap.get("eight"));

        List<String> keyList = new ArrayList<>();
        keyList.add("first");
        keyList.add("second");
        keyList.add("third");
        keyList.add("fourth");
        keyList.add("fifth");
        keyList.add("sixth");
        keyList.add("seventh");
        keyList.add("eight");
        Long value;
        for (String key : keyList){
            value = Long.parseLong(ordersetMap.get(key));
            if(patient_progress.get(0).getSection().getId()==value){
                sectionList.add(sectionRepository.getById(value));
                break;
            }
            else{
                sectionList.add(sectionRepository.getById(value));
            }
        }

//        ************Exit New code here******************************************
//
//        for (int i=0;i<=patient_progress.get(0).getSection().getId();i++){
//            sectionList.add(sectionRepository.getById((long) i));
//        }
        progressProgressReturn.setSection(sectionList);
        System.out.println("PATIENT PROGRESS SERVICE ->>>> "+patient_progress);
        return progressProgressReturn;
    }
    public void updateDoctorIsAvail(Long id){
        Doctor doctor = doctorRepository.getById(id);
        if (doctor.getIs_Avail().equals("true")) {
            doctor.setIs_Avail("false");
            doctorRepository.save(doctor);
        }
        else{
            doctor.setIs_Avail("true");
            doctorRepository.save(doctor);
        }
    }
}
