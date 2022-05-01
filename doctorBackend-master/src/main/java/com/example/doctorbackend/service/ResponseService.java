package com.example.doctorbackend.service;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResponseService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private PatientResponseRepository patientResponseRepository;

    @Autowired
    private PatientOrdersetRepository patientOrdersetRepository;

    @Autowired
    private PatientProgressRepository patientProgressRepository;

    @Autowired
    private PatientMoodRepository patientMoodRepository;


    public List<Questions> getQuestionBySectionId(long sectionId){
        Section section = sectionRepository.getById(sectionId);
        return questionsRepository.findBySection(section);
    }

    public List<Patient_responses> getResponseBySectionId(long sectionId, long patientId){
        System.out.println("ENTERY POINT OF SERVICE");
        Section section = sectionRepository.getById(sectionId);
        System.out.println("ENTERY POINT OF SERVICE 1");
        Patient patient = patientRepository.getById(patientId);
        System.out.println("ENTERY POINT OF SERVICE 2 ");
        List<Questions> questions = questionsRepository.findBySection(section);
        System.out.println("ENTERY POINT OF SERVICE 3");

        List<Patient_responses> resultSet = new ArrayList<>();
        for(Questions q: questions){
            resultSet.add(patientResponseRepository.findByQuestionsAndPatient(q, patient).get(0));
        }
        //change the id to question id
        List<Patient_responses> finalResultSet = new ArrayList<>();
        for(Patient_responses patient_responses:resultSet){
            patient_responses.setId(patient_responses.getQuestions().getId());
            System.out.println("response is "+patient_responses.getResponse());
        }
        return resultSet;
    }

    public boolean addOrderSet(Map<String, Object> payload, Long patientId){
        Patient patient = patientRepository.getById(patientId);
        List<Patient_orderset> patient_ordersets = patientOrdersetRepository.getPatient_ordersetByPatient(patient);
        if(patient_ordersets.size()>0)
            return false; //order already present

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
        Patient_orderset patient_orderset1 = patientOrdersetRepository.save(patient_orderset);
        if (patient_orderset1!=null)
            return true;
        else
            return false;
    }

    public Patient_orderset getOrderSet(Long patientId){
        Patient patient = patientRepository.getById(patientId);
        List<Patient_orderset> patient_ordersets = patientOrdersetRepository.getPatient_ordersetByPatient(patient);
        if(patient_ordersets.size()>=1)
            return patient_ordersets.get(0);
        else
            return null;
    }

    public boolean resetOrderSet(Map<String, Object> payload, Long patientId){
        Patient patient = patientRepository.getById(patientId);
//        Patient_orderset patient_orderset1 = patientOrdersetRepository.getPatient_ordersetByPatient(patient).get(0);
        patientOrdersetRepository.deleteByPatientId(patient);

        List<PatientMood> patientMoods = patientMoodRepository.getPatientMoodByPatient(patient);
        List<Patient_progress> patient_progresses = patientProgressRepository.findByPatient(patient);
        List<Patient_responses> patient_responses = patientResponseRepository.getPatient_responsesByPatient(patient);

        patientMoodRepository.deleteAll(patientMoods);
        if (patient_progresses.size()>=1) {
            System.out.println("patientPROGRESS IS "+patient_progresses.get(0).getPatient().getFname());
            patientProgressRepository.deleteByPatientId(patient);
        }
        patientResponseRepository.deleteAll(patient_responses);

//        Patient

//        ***********RESETING ORDERSET************************

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
        Patient_orderset patient_orderset2 = patientOrdersetRepository.save(patient_orderset);
        if (patient_orderset2!=null)
            return true;
        else
            return false;
    }
}
