package com.example.patientlogin.messages;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.appuser.AppUserRepository;
import com.example.patientlogin.doctor.Doctor;
import com.example.patientlogin.doctor.DoctorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;
    private final DoctorRepo doctorRepo;
    private final AppUserRepository appUserRepository;
    List<Long> ids;
    public void storeMessage(MessageRequest messageRequest, Long doc_id, Long pat_id)
    {

        if(messageRequest.getMessage().length()==0)
            return;

        Messages message = new Messages();
        AppUser appUser = appUserRepository.getById(pat_id);
        Doctor doctor = doctorRepo.getById(appUser.getDoctor().getId());

//        System.out.println("Message obtained is " + messageRequest.getMessage());
//        System.out.println("Message obtained posted by " + messageRequest.getPostedBy());

        message.setMessage(messageRequest.getMessage());
        message.setPostedBy(messageRequest.isPostedBy());
        message.setDoctor(appUser.getDoctor());
        message.setAppUser(appUser);
        message.setReadReceipt(false);
        message.setTime(LocalDateTime.now());
        messageRepo.save(message);


//        Messages docReply = new Messages();
//
//        docReply.setMessage("Hello! How are you feeling now?");
//        docReply.setPostedBy(false);
//        docReply.setAppUser(appUser);
//        docReply.setDoctor(appUser.getDoctor());
//        docReply.setReadReceipt(false);
//        docReply.setTime(LocalDateTime.now());
//
//        messageRepo.save(docReply);
    }

    public List<Messages> getPatientMessages(Long pat_id)
    {
        return messageRepo.getAllByPatientId(pat_id);
    }

    public void updateReadReceipt(Long pat_id) {

        List<Messages> messages = messageRepo.getAllByPatientIdAndNotSentByPatient(pat_id);

        for(Messages message: messages)
        {
            System.out.println("Message is " + message.getMessage() + " and its read receipt before update is " + message.isReadReceipt());
            message.setReadReceipt(true);
            System.out.println("Message is " + message.getMessage() + " and its read receipt after update is " + message.isReadReceipt());
        }

        messageRepo.saveAll(messages);
    }
}
