package com.example.doctorbackend.service;

import com.example.doctorbackend.model.*;
import com.example.doctorbackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageSpecialistService {


    @Autowired
    private MessageSpecialistRepo messageSpecialistRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private SpecialistRepository specialistRepository;
    List<Long> ids;


    public void storeMessage(MessageSpecialistRequest messageRequest, Long doc_id, Long spec_id)
    {

        MessageSpecialist messageSpecialist = new MessageSpecialist();
        Doctor doctor = doctorRepo.getById(doc_id);
        Specialist specialist = specialistRepository.getById(spec_id);
        if (messageRequest.getMessage().length()==0)
            return;

//        System.out.println("Message obtained is " + messageRequest.getMessage());
//        System.out.println("Message obtained posted by " + messageRequest.getPostedBy());

        messageSpecialist.setMessage(messageRequest.getMessage());
        messageSpecialist.setPostedBy(messageRequest.isPostedBy()); //change it to false while deploying
        messageSpecialist.setDoctor(doctor);
        messageSpecialist.setSpecialist(specialist);
        messageSpecialist.setReadReceipt(false);
        messageSpecialist.setTime(LocalDateTime.now());
        messageSpecialistRepo.save(messageSpecialist);

//        Hardcoded patient msg

//        Messages docReply = new Messages();
//        docReply.setMessage("Hello! i am not feeling well doctor!");
//        docReply.setPostedBy(true);
//        docReply.setPatient(appUser);
//        docReply.setDoctor(appUser.getDoctor());
//        docReply.setReadReceipt(false);
//
//        docReply.setTime(LocalDateTime.now());
//        messageRepo.save(docReply);

//        Hardcoding of patient msg done
    }

    public List<MessageSpecialist> getDoctorMessages(Long doc_id)
    {
        return messageSpecialistRepo.getAllByDoctorId(doc_id);
    }

//    public List<MessageSpecialist> getSpecialistMessages(Long spec_id)
//    {
//        return messageSpecialistRepo.getAllByDoctorId(spec_id);
//    }

    public void updateReadReceiptOfDoctor(Long doc_id) {
        List<MessageSpecialist> messages = messageSpecialistRepo.getAllBySpecialistIdAndSentBySpecialist(doc_id);

        for(MessageSpecialist message : messages)
        {
            message.setReadReceipt(true);
        }
        messageSpecialistRepo.saveAll(messages);
    }

    public void updateReadReceiptOfSpecialist(Long doc_id) {
        List<MessageSpecialist> messages = messageSpecialistRepo.getAllBySpecialistIdAndNotSentBySpecialist(doc_id);

        for(MessageSpecialist message : messages)
        {
            message.setReadReceipt(true);
        }
        messageSpecialistRepo.saveAll(messages);
    }

    public List<MessageSpecialist> getMessages(Long doc_id, Long spec_id) {
        return messageSpecialistRepo.getAllMessages(doc_id,spec_id);

    }
}
