package com.example.patientlogin.patient_responses;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import com.example.patientlogin.patient_progress.PatientProgress;
import com.example.patientlogin.patient_progress.PatientProgressRepo;
import com.example.patientlogin.questions.Questions;
import com.example.patientlogin.questions.QuestionsRepo;
import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientResponsesService {

    private final AppUserRepository appUserRepository;
    private final PatientResponsesRepo patientResponsesRepo;
    private final QuestionsRepo questionsRepo;
    private final PatientProgressRepo patientProgressRepo;
    private final SectionRepo sectionRepo;

    @Transactional
    public void saveResponses(PatientResponsesRequest patientResponsesRequest, long pat_id, long sec_id)
            throws InvalidDataAccessApiUsageException
    {
        List<Long> questions = patientResponsesRequest.getQuestions(); //store the questions using their q_no
        List<Integer> answers = patientResponsesRequest.getResponses(); //store the responses of the patient in the list from the request
        AppUser appUser = appUserRepository.getById(pat_id); // get the patient details using the patient_id

        System.out.println("Number of questions are " + questions.size());


        for(int i = 0 ; i < questions.size(); i++)
        {
            PatientResponses patientResponses = new PatientResponses();
            patientResponses.setAppUser(appUser);
            patientResponses.setResponse(answers.get(i));
            patientResponses.setQuestions(questionsRepo.getById(questions.get(i)));
            System.out.println("Dummy1");

//            System.out.println(patientResponses.getAppUser().getEmail());
//            System.out.println(questions.toArray().toString());
//            System.out.println((questions.get(i)));
//
            patientResponsesRepo.save(patientResponses);
        }

        System.out.println("Section id is "+sec_id);
        // uncomment the below code for my module to work..
        if(sec_id!=1)
        {
            PatientProgress p = patientProgressRepo.getById(pat_id);
            p.setSection(sectionRepo.getById(sec_id));
            patientProgressRepo.save(p);
            System.out.println("Dummy2");

            return;
        }
        //until here is the code to uncomment for my module..


        //the above code must be commented and below code must be uncommented while integration due to the presence of section-0;
        PatientProgress patientProgress = new PatientProgress();
        patientProgress.setSection(sectionRepo.getById(sec_id));
        patientProgress.setAppUser(appUser);
        patientProgressRepo.save(patientProgress);

        System.out.println("Dummy3");

//        PatientProgress patientProgress1 = patientProgressRepo.getBI;
//        patientProgress1.setSection(patientProgress.getSection());
//        patientProgress1.setAppUser(patientProgress.getAppUser());
//        patientProgress1.setPat_id(patientProgress.getPat_id());
//
//        patientProgressRepo.ge(patientProgress1);
    }

    public void updateSection(long pat_id, long sec_id) {
        AppUser appUser = appUserRepository.getById(pat_id); // get the patient details using the patient_id

//        if(sec_id==1)
//        {
//            PatientProgress patientProgress = new PatientProgress();
//            patientProgress.setSection(sectionRepo.getById(sec_id));
//            patientProgress.setAppUser(appUser);
//            patientProgressRepo.save(patientProgress);
//            return;
//        }

        PatientProgress p = patientProgressRepo.getById(pat_id);
        p.setSection(sectionRepo.getById(sec_id));
        patientProgressRepo.save(p);


    }

    public List<PatientResponses> getResponseBySectionId(long sectionId, long patientId) {

        Section section = sectionRepo.getById(sectionId);
        AppUser appUser = appUserRepository.getById(patientId);
        List<Questions> questions = questionsRepo.findBySection(section);

        List<PatientResponses> resultSet = new ArrayList<>();

        for(Questions q: questions){
            System.out.println("In For loop");
            resultSet.add(patientResponsesRepo.findByQuestionsAndAppUser(q, appUser).get(0));
        }

        return resultSet;
    }
}
