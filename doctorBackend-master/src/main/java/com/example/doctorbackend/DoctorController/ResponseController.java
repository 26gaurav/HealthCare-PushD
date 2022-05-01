package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4210")
@RestController
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/doctor/response/questions/{sectionId}")
    public List<Questions> getQuestionBySectionId(@PathVariable long sectionId){
        return responseService.getQuestionBySectionId(sectionId);
    }

    @GetMapping("/doctor/response/{sectionId}/{patientId}")
    public List<Patient_responses> getResponseBySectionId(@PathVariable long sectionId, @PathVariable long patientId){
        System.out.println("Enter point of controller");
        List<Patient_responses> resultSet = responseService.getResponseBySectionId(sectionId, patientId);
        System.out.println("CONTROLLER -->>> "+resultSet);
        return resultSet;
    }

    @PostMapping("/doctor/response/{patientId}/addOrderSet")
    public ResponseEntity<?> addOrderSet(@RequestBody Map<String, Object> payload, @PathVariable Long patientId){
        if(responseService.addOrderSet(payload, patientId))
            return ResponseEntity.ok(new Response("OrderSet add successfully"));
        else
            return ResponseEntity.badRequest().body(new Response("orderSet addition unsuccessful! Order already present"));
    }

    @GetMapping("/doctor/response/{patientId}/getOrderSet")
    public ResponseEntity<?> getOrderSet(@PathVariable Long patientId){
        Patient_orderset patient_orderset = responseService.getOrderSet(patientId);
        if (patient_orderset!=null)
            return ResponseEntity.ok(patient_orderset);
        else
            return ResponseEntity.badRequest().body(new Response("Order Not Available"));
    }

    @PostMapping("/doctor/response/{patientId}/resetOrderSet")
    public ResponseEntity<?> resetOrderSet(@RequestBody Map<String, Object> payload, @PathVariable Long patientId){
        if(responseService.resetOrderSet(payload, patientId))
            return ResponseEntity.ok(new Response("OrderSet Reseted successfully"));
        else
            return ResponseEntity.badRequest().body(new Response("orderSet Reset unsuccessful! Order already present"));
    }
}
