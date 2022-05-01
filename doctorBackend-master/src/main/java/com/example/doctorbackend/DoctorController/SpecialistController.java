package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.service.DashboardService;
import com.example.doctorbackend.service.ResponseService;
import com.example.doctorbackend.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class SpecialistController {
//Specialist Controller
    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private DashboardService dashboardService;

//    Login Controller of Specialist
    @PostMapping("/specialist/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> payload){
        Specialist specialist = specialistService.login(payload);
        if (specialist==null){
            return ResponseEntity.badRequest().body(new Response("Bad Credentials"));
        }
        return ResponseEntity.ok(specialist);
    }

//    Fetching all Doctors for Specialist
    @GetMapping("/specialist/doctorList/{spec_id}")
    public List<Doctor> getAllDoctor(@PathVariable Long spec_id){
        List<Doctor> doctorList = specialistService.getAllDoctor(spec_id);
        for(Doctor doctor: doctorList){
            doctor.setPassword("");
            doctor.setPatient(null);
        }
        return doctorList;
    }

//    Fetching all patientlist in a doctor for Specialist
    @GetMapping("/specialist/patientlistbyDoctor/{doc_id}/{spec_id}")
    public List<Patient> getPatientByDoctorIdforSpecialist(@PathVariable Long doc_id, @PathVariable Long spec_id){
        return specialistService.getPatientByDoctorIdforSpecialist(doc_id, spec_id);
    }

//    Asking and checking for permissions
    @GetMapping("/specialist/askPermision/{spec_id}/{pat_id}")
    public ResponseEntity<?> askPermission(@PathVariable Long spec_id, @PathVariable Long pat_id){
        if(specialistService.askForPermission(spec_id, pat_id))
            return ResponseEntity.ok(new Response("Permission Sent successfully!"));
        else
            return ResponseEntity.badRequest().body(new Response(("Permission already sent!")));
    }

//    *******************PATIENT RESPONSES FOR SPECIALIST*****************************


    @GetMapping("/specialist/doctor/response/questions/{sectionId}")
    public List<Questions> getQuestionBySectionId(@PathVariable long sectionId){
        return responseService.getQuestionBySectionId(sectionId);
    }

    @GetMapping("/specialist/doctor/response/{sectionId}/{patientId}")
    public List<Patient_responses> getResponseBySectionId(@PathVariable long sectionId, @PathVariable long patientId){
        System.out.println("Enter point of controller");
        List<Patient_responses> resultSet = responseService.getResponseBySectionId(sectionId, patientId);
        System.out.println("CONTROLLER -->>> "+resultSet);
        return resultSet;
    }


    @GetMapping("/specialist/doctor/response/{patientId}/getOrderSet")
    public ResponseEntity<?> getOrderSet(@PathVariable Long patientId){
        Patient_orderset patient_orderset = responseService.getOrderSet(patientId);
        if (patient_orderset!=null)
            return ResponseEntity.ok(patient_orderset);
        else
            return ResponseEntity.badRequest().body(new Response("Order Not Available"));
    }

    @GetMapping("/specialist/doctor/dashboard/{patientId}/progress")
    public PatientProgressReturn getPatientProgress(@PathVariable Long patientId){
        PatientProgressReturn patientProgressReturn =  dashboardService.getPatientProgress(patientId);
        System.out.println("CONTROLLER PROGRESS--->>>> "+patientProgressReturn);
        return patientProgressReturn; //section id not getting in the json format;
    }

    }
