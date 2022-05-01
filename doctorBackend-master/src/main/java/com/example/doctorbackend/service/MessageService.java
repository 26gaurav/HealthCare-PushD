package com.example.doctorbackend.service;

import com.example.doctorbackend.model.Doctor;
import com.example.doctorbackend.model.Messages;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.repo.DoctorRepository;
import com.example.doctorbackend.repo.MessageRepo;
import com.example.doctorbackend.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository appUserRepository;
    List<Long> ids;

    public MessageService() {
    }

    public void storeMessage(MessageRequest messageRequest, Long doc_id, Long pat_id)
    {

        Messages message = new Messages();
        Doctor doctor = doctorRepo.getById(doc_id);
        Patient appUser = appUserRepository.getById(pat_id);
        if (messageRequest.getMessage().length()==0)
            return;

//        System.out.println("Message obtained is " + messageRequest.getMessage());
//        System.out.println("Message obtained posted by " + messageRequest.getPostedBy());

        message.setMessage(messageRequest.getMessage());
        message.setPostedBy(messageRequest.isPostedBy()); //change it to false while deploying
        message.setDoctor(appUser.getDoctor());
        message.setPatient(appUser);
        message.setReadReceipt(false);
        message.setTime(LocalDateTime.now());
        messageRepo.save(message);

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

    public List<Messages> getDoctorMessages(Long pat_id)
    {
        return messageRepo.getAllByPatientId(pat_id);
    }

    public void updateReadReceipt(Long pat_id) {
        List<Messages> messages = messageRepo.getAllByPatientIdAndSentByPatient(pat_id);

        for(Messages message : messages)
        {
            message.setReadReceipt(true);
        }
        messageRepo.saveAll(messages);
    }
}
