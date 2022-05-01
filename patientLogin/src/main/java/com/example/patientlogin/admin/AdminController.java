package com.example.patientlogin.admin;

import com.example.patientlogin.consent.Specialist;
import com.example.patientlogin.consent.SpecialistRegistration;
import com.example.patientlogin.consent.SpecialistRepo;
import com.example.patientlogin.doctor.Doctor;
import com.example.patientlogin.doctor.DoctorRegistration;
import com.example.patientlogin.doctor.DoctorRepo;
import com.example.patientlogin.jwt.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@AllArgsConstructor
public class AdminController {

    private final DoctorRepo doctorRepo;
    private final AdminRepo adminRepo;
    private final SpecialistRepo specialistRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(path="adminLogin")
    public ResponseEntity<?> adminLogin(@RequestBody AdminRequest adminRequest)
    {
        System.out.println("obtained username is " + adminRequest.getUsername());
        System.out.println("obtained password is " + adminRequest.getPassword());
        Admin admin = adminRepo.findByUsername(adminRequest.getUsername());
        if(admin==null || !admin.getPassword().equals(adminRequest.getPassword()))
        {
            System.out.println("Error admin login");
            return ResponseEntity.badRequest().body("Bad credentials!");
        }
        return ResponseEntity.ok(new JwtResponse());
    }

    @GetMapping(path = "getDoctors")
    public List<Doctor> fetchAllDoctors()
    {
//        Doctor temp = doctorRepo.getById(1L);
//        if(temp==null)
//            System.out.println("temp is null");
        List<Doctor> doctors = doctorRepo.getAll();
        for(Doctor doctor : doctors)
        {
            doctor.setMessages(null);
        }
        return doctors;
    }

    @PostMapping(path = "addDoctor")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorRegistration doctorRegistration)
    {
        Doctor temp = doctorRepo.findByUsername(doctorRegistration.getUsername());

        if(temp!=null)
        {
            ResponseEntity.badRequest().body(new JwtResponse());
        }
        Doctor doctor = new Doctor();
        doctor.setFname(doctorRegistration.getFname());
        doctor.setLname(doctorRegistration.getLname());
        doctor.setUsername(doctorRegistration.getUsername());

        String encodedPassword = bCryptPasswordEncoder.encode(doctorRegistration.getPassword());
        doctor.setPassword(encodedPassword);

        doctorRepo.save(doctor);

        return ResponseEntity.ok(new JwtResponse());
    }

    @GetMapping(path = "getSpecialists")
    public List<Specialist> fetchAllSpecialists()
    {
//        Doctor temp = doctorRepo.getById(1L);
//        if(temp==null)
//            System.out.println("temp is null");
        List<Specialist> specialists = specialistRepo.getAll();
        for(Specialist specialist : specialists)
        {
            System.out.println("Specialist is " + specialist.getFname());
        }
        return specialists;
    }

    @PostMapping(path = "addSpecialist")
    public ResponseEntity<?> addSpecialist(@RequestBody SpecialistRegistration specialistRegistration)
    {
        Specialist temp = specialistRepo.findByEmail(specialistRegistration.getEmail());

        if(temp!=null)
        {
            ResponseEntity.badRequest().body(new JwtResponse());
        }
        Specialist specialist = new Specialist();
        specialist.setFname(specialistRegistration.getFname());
        specialist.setLname(specialistRegistration.getLname());
        specialist.setEmail(specialistRegistration.getEmail());

//        String encodedPassword = bCryptPasswordEncoder.encode(specialistRegistration.getPassword());
        specialist.setPassword(specialistRegistration.getPassword());

        specialistRepo.save(specialist);

        return ResponseEntity.ok(new JwtResponse());
    }

}
