package com.example.patientlogin.questions;

import com.example.patientlogin.section.Section;
import com.example.patientlogin.section.SectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsDB {


    private final QuestionsRepo questionsRepo;
    private final SectionRepo sectionRepo;

//    @Autowired
//    public QuestionsDB(QuestionsRepo questionsRepo)
//    {
//        this.questionsRepo = questionsRepo;
//    }

// kinda function lo single lines at 46,61,76 ni uncomment cheyi and comment 32,33,34 if the below code wont work
    public void addQuestions()
    {
//        Section s0 = new Section();
//        s0.setTitle("0. false");

        Section s1 = new Section();
        Section s2 = new Section();
        Section s3 = new Section();
        Section s4 = new Section();
        Section s5 = new Section();
        Section s6 = new Section();
        Section s7 = new Section();
        Section s8 = new Section();
        s1.setTitle("Section 1");
        s2.setTitle("Section 2");
        s3.setTitle("Section 3");
        s4.setTitle("Section 4");
        s5.setTitle("Section 5");
        s6.setTitle("Section 6");
        s7.setTitle("Section 7");
        s8.setTitle("Section 8");
//        sectionRepo.save(s0);
        sectionRepo.save(s1);
        sectionRepo.save(s2);
        sectionRepo.save(s3);
        sectionRepo.save(s4);
        sectionRepo.save(s5);
        sectionRepo.save(s6);
        sectionRepo.save(s7);
        sectionRepo.save(s8);

        Questions q1 = new Questions("Do you feel lonely always?");
        Questions q2 = new Questions("Did you engage in any social activities ?");
        Questions q3 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q1.setSection(s1);
        q2.setSection(s1);
        q3.setSection(s1);
        ArrayList<Questions> l1 = new ArrayList<>();
        l1.add(q1);
        l1.add(q2);
        l1.add(q3);
        s1.setQuestionList(l1);
        questionsRepo.saveAll(l1);
        //--------------------------------------------

        Questions q4 = new Questions("Do you talk to your parents or relatives frequently?");
        Questions q5 = new Questions("Do you feel comfortable in crowdy areas?");
        Questions q6 = new Questions("Do you have a pet at home?");
//        Section s2 = sectionRepo.getById(2l);
        q4.setSection(s2);
        q5.setSection(s2);
        q6.setSection(s2);
        ArrayList<Questions> l2 = new ArrayList<>();
        l2.add(q4);
        l2.add(q5);
        l2.add(q6);
        s2.setQuestionList(l2);
        questionsRepo.saveAll(l2);

        Questions q7 = new Questions("Are you an early bird?");
        Questions q8 = new Questions("Do you worry too often if things dont go your way?");
        Questions q9 = new Questions("Do you feel afraid if something awful might happen?");

//        Section s3 = sectionRepo.getById(3l);
        q7.setSection(s3);
        q8.setSection(s3);
        q9.setSection(s3);
        ArrayList<Questions> l3 = new ArrayList<>();
        l3.add(q7);
        l3.add(q8);
        l3.add(q9);
        s3.setQuestionList(l3);
        questionsRepo.saveAll(l3);

//        --------------------------------------------------------------------------

        Questions q10 = new Questions("Do you feel lonely always?");
        Questions q11 = new Questions("Did you engage in any social activities ?");
        Questions q12 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q10.setSection(s4);
        q11.setSection(s4);
        q12.setSection(s4);
        ArrayList<Questions> l4 = new ArrayList<>();
        l4.add(q10);
        l4.add(q11);
        l4.add(q12);
        s4.setQuestionList(l4);
        questionsRepo.saveAll(l4);

//        ----------------------------------------------------------------------------

        Questions q13 = new Questions("Do you feel lonely always?");
        Questions q14 = new Questions("Did you engage in any social activities ?");
        Questions q15 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q13.setSection(s5);
        q14.setSection(s5);
        q15.setSection(s5);
        ArrayList<Questions> l5 = new ArrayList<>();
        l5.add(q13);
        l5.add(q14);
        l5.add(q15);
        s5.setQuestionList(l5);
        questionsRepo.saveAll(l5);

//        --------------------------------------------------------------------------------

        Questions q16 = new Questions("Do you feel lonely always?");
        Questions q17 = new Questions("Did you engage in any social activities ?");
        Questions q18 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q16.setSection(s6);
        q17.setSection(s6);
        q18.setSection(s6);
        ArrayList<Questions> l6 = new ArrayList<>();
        l6.add(q16);
        l6.add(q17);
        l6.add(q18);
        s6.setQuestionList(l6);
        questionsRepo.saveAll(l6);

//        -----------------------------------------------------------------------------------

        Questions q19 = new Questions("Do you feel lonely always?");
        Questions q20 = new Questions("Did you engage in any social activities ?");
        Questions q21 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q19.setSection(s7);
        q20.setSection(s7);
        q21.setSection(s7);
        ArrayList<Questions> l7 = new ArrayList<>();
        l7.add(q19);
        l7.add(q20);
        l7.add(q21);
        s7.setQuestionList(l7);
        questionsRepo.saveAll(l7);

//        -------------------------------------------------------------------------------------

        Questions q22 = new Questions("Do you feel lonely always?");
        Questions q23 = new Questions("Did you engage in any social activities ?");
        Questions q24 = new Questions("Do you go outside for the weekends?");

//        Section s1 = sectionRepo.getById(1l);
        q22.setSection(s8);
        q23.setSection(s8);
        q24.setSection(s8);
        ArrayList<Questions> l8 = new ArrayList<>();
        l8.add(q22);
        l8.add(q23);
        l8.add(q24);
        s8.setQuestionList(l8);
        questionsRepo.saveAll(l8);

    }
}
