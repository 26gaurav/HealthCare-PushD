package com.example.patientlogin.patient_responses;

import com.example.patientlogin.jwt.JwtResponse;
import com.example.patientlogin.patient_progress.PatientProgressRepo;
import com.example.patientlogin.questions.Questions;
import com.example.patientlogin.questions.QuestionsRepo;
import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins ="http://localhost:4200")
public class PatientResponsesController {

    private PatientResponsesService patientResponsesService;
    private SectionRepo sectionRepo;
    private QuestionsRepo questionsRepo;
    private PatientProgressRepo patientProgressRepo;

    @GetMapping(value = "/questions/{pat_id}/{sec_id}")
    public List<Questions> getQuestions(@PathVariable String pat_id, @PathVariable Long sec_id)
    {
        Section section = sectionRepo.getById(sec_id);
        List<Questions> questions = questionsRepo.findBySection(section);
        for(Questions i : questions) {
            System.out.println("Question is " + i.getQuestion());
            System.out.println("Question number " + i.getId());
            System.out.println("Question section is  " + i.getSection());

        }
        return questions;
    }

    @PostMapping(value = "/patient/responses/{pat_id}/{sec_id}")
    public JwtResponse storeResponses(@RequestBody PatientResponsesRequest patientResponsesRequest, @PathVariable long pat_id, @PathVariable long sec_id) {
        //,consumes = MediaType.APPLICATION_JSON_VALUE
//        long pat_id = 1;
        System.out.println("THe link is working");
        List<Long> l = patientResponsesRequest.getQuestions();
//        for(Questions i : l) {
//            System.out.println(i.getQuestion());
//            System.out.println(i.getQ_no());
//            System.out.println(i.getSection());
//            System.out.println(i.getPatientResponses());
//
//        }
        patientResponsesService.saveResponses(patientResponsesRequest, pat_id, sec_id);
        return new JwtResponse();
    }

    @PostMapping(value = "/storeSection/{pat_id}/{sec_id}")
    public JwtResponse storeSection(@PathVariable long pat_id, @PathVariable long sec_id)
    {
        patientResponsesService.updateSection(pat_id,sec_id);

        return new JwtResponse();
    }


    @GetMapping(value = "/getCurrentSection/{pat_id}")
    public Long getCurrentSection(@PathVariable Long pat_id)
    {
        try
        {
            return patientProgressRepo.getById(pat_id).getSection().getSec_id();
        }
        catch (Exception e)
        {
            return 0L;
        }

//        return sectionRepo.getById(pat_id).getSec_id();



    }

    @GetMapping("/getPatientResponses/{patientId}/{sectionId}")
    public List<PatientResponses> getResponseBySectionId(@PathVariable long sectionId, @PathVariable long patientId) {
        System.out.println("Enter point of controller");
        List<PatientResponses> resultSet = patientResponsesService.getResponseBySectionId(sectionId, patientId);
        System.out.println("Obtained responses of the patient is -->>> " + resultSet);
        return resultSet;
    }

}
