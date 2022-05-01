package com.example.patientlogin.patientOrder;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import com.example.patientlogin.jwt.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@AllArgsConstructor
public class PatientOrderSetController {

    private final PatientOrderSetService patientOrderSetService;
    private final AppUserRepository appUserRepository;
    private final PatientOrderSetRepo patientOrderSetRepo;

    @GetMapping("/getOrderSet/{patientId}")
    public ResponseEntity<?> getOrderSet(@PathVariable Long patientId){
        System.out.println("Entered get order set function");
        Patient_orderset patient_orderset = patientOrderSetService.getOrderSet(patientId);
        if (patient_orderset!=null) {
            System.out.println("Obtained ordered set is "+ patient_orderset.getOrderset());
            return ResponseEntity.ok(patient_orderset.getOrderset());
        }
        else
            return ResponseEntity.badRequest().body("Invalid request");
    }


    @PostMapping("/addOrderSet/{patientId}")
    public ResponseEntity<?> addOrderSet(@RequestBody Map<String, Object> payload, @PathVariable Long patientId){
        if(patientOrderSetService.addOrderSet(payload, patientId))
            return ResponseEntity.ok("OrderSet add successfully");
        else
            return ResponseEntity.badRequest().body("orderSet addition unsuccessful");
    }


    @PostMapping("/updateOrderSet/{patientId}")
    public JwtResponse updateOrderSet(@RequestBody Map<String, Object> payload, @PathVariable Long patientId){
        if(patientOrderSetService.updateOrderSet(payload, patientId))
            return new JwtResponse();
        else
            return new JwtResponse("Failed");
    }


}
