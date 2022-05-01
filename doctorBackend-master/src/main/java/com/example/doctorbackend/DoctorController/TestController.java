package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TestController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientMoodRepository patientMoodRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private PatientResponseRepository patientResponseRepository;

    @Autowired
    private PatientProgressRepository patientProgressRepository;

    @GetMapping("/addDoctor")
    public List<PatientMood> addDoctor() {
        Doctor d1 = new Doctor();
        Long doc_id = d1.getId();

        d1.setPassword("$2a$10$/jSkWocHkD8dXbmvuaL6ou4oaUYy19ji/0XZ3qqnnL25U93udguLe");
        d1.setUsername("doctor");
        d1.setFname("Benjamin");
        d1.setLname("Bratt");
        d1.setIs_Avail("true");

        doctorRepository.save(d1);

        return null;
    }
//
    @GetMapping("/add")
    public List<PatientMood> test(){
//        Doctor d1 = new Doctor();
////        Long doc_id = d1.getId();
//
//        d1.setPassword("$2a$10$/jSkWocHkD8dXbmvuaL6ou4oaUYy19ji/0XZ3qqnnL25U93udguLe");
//        d1.setUsername("doctor");
//        d1.setFname("Benjamin");
//        d1.setLname("Bratt");
//        d1.setIs_Avail("true");
//
//        doctorRepository.save(d1);
//*************************SECTIONS*************************************************
        Section s0 = new Section();
        s0.setTitle("0. false");

        Section s1 = new Section();
        s1.setTitle("1. Section 1");

        Section s2 = new Section();
        s2.setTitle("2. Section 2");

        Section s3 = new Section();
        s3.setTitle("3. Section 3");

        Section s4 = new Section();
        s4.setTitle("4. Section 4");

        Section s5 = new Section();
        s5.setTitle("5. Section 5");

        Section s6 = new Section();
        s6.setTitle("6. Section 6");

        Section s7 = new Section();
        s7.setTitle("7. Section 7");

        Section s8 = new Section();
        s8.setTitle("2. Section 8");

        sectionRepository.save(s0);
        sectionRepository.save(s1);
        sectionRepository.save(s2);
        sectionRepository.save(s3);
        sectionRepository.save(s4);
        sectionRepository.save(s5);
        sectionRepository.save(s6);
        sectionRepository.save(s7);
        sectionRepository.save(s8);


//*************************SECTIONS ENDS*************************************************
//
//        Patient p1 = new Patient();
//        p1.setFname("William");
//        p1.setLname("johns");
//        p1.setEmail("xyz@gmail.com");
//        p1.setDoctor(d1);
//        p1.setPatient_responses(null);
//
//        Patient p2 = new Patient();
//        p2.setFname("James");
//        p2.setLname("Charles");
//        p2.setEmail("abc@gmail.com");
//        p2.setDoctor(d1);
//        p2.setPatient_responses(null);
//
//        Patient p3 = new Patient();
//        p3.setFname("David");
//        p3.setLname("spades");
//        p3.setEmail("123@gmail.com");
//        p3.setDoctor(d1);
//
//        List<Patient> list = new ArrayList<>();
//        list.add(p1);
//        list.add(p2);
//        d1.setPatient(list);
//
//        System.out.println(
//                "********************JUST BEFORE SAVING***************************************"
//        );
//        patientRepository.save(p1);
//        patientRepository.save(p2);
//
//        System.out.println("Test contorller --->>>>>");
//        System.out.println(d1);
//        System.out.println(patientRepository.findByDoctor(d1));
//
//        System.out.println(
//                "********************MOOOOOOOOOOOOOOOOOOOOD***************************************"
//        );
//
//
//        PatientMood pm1 = new PatientMood();
//        pm1.setPatient(p1);
//        pm1.setMood(1);
//        pm1.setMoodTime(LocalDateTime.now());
//
//        PatientMood pm2 = new PatientMood();
//        pm2.setPatient(p1);
//        pm2.setMood(5);
//        pm2.setMoodTime(LocalDateTime.now().plusHours(1));
//
//        PatientMood pm3 = new PatientMood();
//        pm3.setPatient(p1);
//        pm3.setMood(4);
//        pm3.setMoodTime(LocalDateTime.now().plusHours(2));
//
//        PatientMood pm4 = new PatientMood();
//        pm4.setPatient(p1);
//        pm4.setMood(4);
//        pm4.setMoodTime(LocalDateTime.now().plusHours(3));
//
//        List<PatientMood> patientMoods = new ArrayList<>();
//        patientMoods.add(pm1);
//        patientMoods.add(pm2);
//        patientMoods.add(pm3);
//        patientMoods.add(pm4);
//
//        System.out.println("Before SAVING PATIENTMOOD");
//        p1.setPatientMood(patientMoods);
//        patientMoodRepository.saveAll(patientMoods);
//        patientMoodRepository.save(pm1);
//        patientMoodRepository.save(pm2);
//        patientMoodRepository.save(pm3);
//        patientMoodRepository.save(pm4);
//
//
//        System.out.println("AFTER SAVING PATIENTMOOD");
//        System.out.println(patientMoodRepository.findAll());
//        System.out.println("OUR QUERY");
//        System.out.println(patientMoodRepository.findMood(p1));
//
//        List<PatientMood> resultSet = new ArrayList<>();
//        patientMoods = patientMoodRepository.findMood(p1);
//        int count = 0;
//        for(PatientMood patientMood: patientMoods){
//            if (count==3)
//                break;
//            count+=1;
//            patientMood.setPatient(null);
//            resultSet.add(patientMood);
//        }

//        System.out.println("PRINTING FINAL RESULT");
//        for(PatientMood patientMood: resultSet){
//            System.out.println(patientMood);
//        }
//        return resultSet;


        //********Section and Questions



//        ---------------------
        Questions q1 = new Questions();
        q1.setQuestion("how are you?");
        q1.setSection(s1);

        Questions q2 = new Questions();
        q2.setQuestion("how are you 2 ?");
        q2.setSection(s1);

        Questions q3 = new Questions();
        q3.setQuestion("how are you 3 ?");
        q3.setSection(s1);

        List<Questions> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        s1.setQuestion(questions);

        questionsRepository.saveAll(questions);
//        ---------------------------------------
        Questions q4 = new Questions();
        q4.setQuestion("hows you day going 1 ?");
        q4.setSection(s2);

        Questions q5 = new Questions();
        q5.setQuestion("hows you day going 1 ?");
        q5.setSection(s2);

        Questions q6 = new Questions();
        q6.setQuestion("hows you day going 1 ?");
        q6.setSection(s2);

        List<Questions> questions2 = new ArrayList<>();
        questions2.add(q4);
        questions2.add(q5);
        questions2.add(q6);
        s2.setQuestion(questions2);

        questionsRepository.saveAll(questions2); 
//        ------------------------------------------
        Questions q7 = new Questions();
        q7.setQuestion("hows you day going 1 ?");
        q7.setSection(s3);

        Questions q8 = new Questions();
        q8.setQuestion("hows you day going 1 ?");
        q8.setSection(s3);

        Questions q9 = new Questions();
        q9.setQuestion("hows you day going 1 ?");
        q9.setSection(s3);

        List<Questions> questions3 = new ArrayList<>();
        questions3.add(q7);
        questions3.add(q8);
        questions3.add(q9);
        s3.setQuestion(questions3);

        questionsRepository.saveAll(questions3);
//        ------------------------------------------
        Questions q10 = new Questions();
        q10.setQuestion("hows you day going 1 ?");
        q10.setSection(s4);

        Questions q11 = new Questions();
        q11.setQuestion("hows you day going 1 ?");
        q11.setSection(s4);

        Questions q12 = new Questions();
        q12.setQuestion("hows you day going 1 ?");
        q12.setSection(s4);

        List<Questions> questions4 = new ArrayList<>();
        questions4.add(q10);
        questions4.add(q11);
        questions4.add(q12);
        s4.setQuestion(questions4);

        questionsRepository.saveAll(questions4);
//        ------------------------------------------
        Questions q13 = new Questions();
        q13.setQuestion("hows you day going 1 ?");
        q13.setSection(s5);

        Questions q14 = new Questions();
        q14.setQuestion("hows you day going 1 ?");
        q14.setSection(s5);

        Questions q15 = new Questions();
        q15.setQuestion("hows you day going 1 ?");
        q15.setSection(s5);

        List<Questions> questions5 = new ArrayList<>();
        questions5.add(q13);
        questions5.add(q14);
        questions5.add(q15);
        s5.setQuestion(questions5);

        questionsRepository.saveAll(questions5);
//        ------------------------------------------
        Questions q16 = new Questions();
        q16.setQuestion("hows you day going 1 ?");
        q16.setSection(s6);

        Questions q17 = new Questions();
        q17.setQuestion("hows you day going 1 ?");
        q17.setSection(s6);

        Questions q18 = new Questions();
        q18.setQuestion("hows you day going 1 ?");
        q18.setSection(s6);

        List<Questions> questions6 = new ArrayList<>();
        questions6.add(q16);
        questions6.add(q17);
        questions6.add(q18);
        s6.setQuestion(questions6);

        questionsRepository.saveAll(questions6);
//        ------------------------------------------
        Questions q19 = new Questions();
        q19.setQuestion("hows you day going 1 ?");
        q19.setSection(s7);

        Questions q20 = new Questions();
        q20.setQuestion("hows you day going 1 ?");
        q20.setSection(s7);

        Questions q21 = new Questions();
        q21.setQuestion("hows you day going 1 ?");
        q21.setSection(s7);

        List<Questions> questions7 = new ArrayList<>();
        questions7.add(q19);
        questions7.add(q20);
        questions7.add(q21);
        s7.setQuestion(questions7);

        questionsRepository.saveAll(questions7);
//        ------------------------------------------
        Questions q22 = new Questions();
        q22.setQuestion("hows you day going 1 ?");
        q22.setSection(s8);

        Questions q23 = new Questions();
        q23.setQuestion("hows you day going 1 ?");
        q23.setSection(s8);

        Questions q24 = new Questions();
        q24.setQuestion("hows you day going 1 ?");
        q24.setSection(s8);

        List<Questions> questions8 = new ArrayList<>();
        questions8.add(q22);
        questions8.add(q23);
        questions8.add(q24);
        s8.setQuestion(questions8);

        questionsRepository.saveAll(questions8);



//        ------------------------------------------------
//        Patient_responses pr1 = new Patient_responses();
//        pr1.setPatient(p1);
//        pr1.setQuestions(q1);
//        pr1.setResponse(1);
//
//        Patient_responses pr2 = new Patient_responses();
//        pr2.setPatient(p1);
//        pr2.setQuestions(q2);
//        pr2.setResponse(2);
//
//        Patient_responses pr3 = new Patient_responses();
//        pr3.setPatient(p1);
//        pr3.setQuestions(q3);
//        pr3.setResponse(3);
//
//        List<Patient_responses> patient_responses = new ArrayList<>();
//        patient_responses.add(pr1);
//        patient_responses.add(pr2);
//        patient_responses.add(pr3);
//
//        patientResponseRepository.saveAll(patient_responses);
//
//        //-------------RESPONSE 2
//        Patient_responses pr4 = new Patient_responses();
//        pr4.setPatient(p1);
//        pr4.setQuestions(q4);
//        pr4.setResponse(4);
//
//        Patient_responses pr5 = new Patient_responses();
//        pr5.setPatient(p1);
//        pr5.setQuestions(q5);
//        pr5.setResponse(5);
//
//        Patient_responses pr6 = new Patient_responses();
//        pr6.setPatient(p1);
//        pr6.setQuestions(q6);
//        pr6.setResponse(1);
//
//        List<Patient_responses> patient_responses2 = new ArrayList<>();
//        patient_responses2.add(pr4);
//        patient_responses2.add(pr5);
//        patient_responses2.add(pr6);
//
//        patientResponseRepository.saveAll(patient_responses2);
//
//        //-------------RESPONSE 2
//        Patient_responses pr7 = new Patient_responses();
//        pr7.setPatient(p1);
//        pr7.setQuestions(q10);
//        pr7.setResponse(2);
//
//        Patient_responses pr8 = new Patient_responses();
//        pr8.setPatient(p1);
//        pr8.setQuestions(q11);
//        pr8.setResponse(3);
//
//        Patient_responses pr9 = new Patient_responses();
//        pr9.setPatient(p1);
//        pr9.setQuestions(q12);
//        pr9.setResponse(4);
//
//        List<Patient_responses> patient_responses3 = new ArrayList<>();
//        patient_responses3.add(pr7);
//        patient_responses3.add(pr8);
//        patient_responses3.add(pr9);
//
//        patientResponseRepository.saveAll(patient_responses3);
//
////        ----------------------------------
//        Patient_progress pp1 = new Patient_progress();
//        pp1.setPatient(p1);
//        pp1.setSection(s4);
//        List<Patient_progress> patient_progresses = new ArrayList<>();
//        patient_progresses.add(pp1);
//        s4.setPatient_progress(patient_progresses); //changed from s2 to s1
//        patientProgressRepository.save(pp1);
//
//
//        Patient_progress pp2 = new Patient_progress();
//        pp2.setPatient(p2);
//        pp2.setSection(s0);
//
//        List<Patient_progress> patient_progresses2 = new ArrayList<>();
//        patient_progresses2.add(pp2);
//        s0.setPatient_progress(patient_progresses); //changed from s2 to s1
//        patientProgressRepository.save(pp2);
        return null;
    }

    @GetMapping("/addAgain")
    public void testagain(){
        Doctor d1 = doctorRepository.getById((long)2);


        Patient p1 = new Patient();
        p1.setFname("krishna");
        p1.setDoctor(d1);

        List<Patient> list = d1.getPatient();
        System.out.println("Before save");
        for(Patient p: list){
            System.out.println(p.getFname());
        }
        list.add(p1);

        patientRepository.save(p1);


        Doctor d2 = doctorRepository.getById((long)2);
        List<Patient> list1 = d2.getPatient();
        System.out.println("After save");
        for(Patient p: list1){
            System.out.println(p.getFname());
        }
    }
}
