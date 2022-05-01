package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.JwtResponse;
import com.example.doctorbackend.model.MessageSpecialist;
import com.example.doctorbackend.model.Messages;
import com.example.doctorbackend.service.MessageRequest;
import com.example.doctorbackend.service.MessageService;
import com.example.doctorbackend.service.MessageSpecialistRequest;
import com.example.doctorbackend.service.MessageSpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController


@CrossOrigin(origins ="http://localhost:4210")
public class MessageSpecialistController {

    @Autowired
    private MessageSpecialistService messageSpecialistService;

    @PostMapping(value = "specialist/postMessage/{spec_id}/{doc_id}")
    private JwtResponse postMessage(@RequestBody MessageSpecialistRequest messageSpecialistRequest, @PathVariable Long doc_id,
                                    @PathVariable Long spec_id)
    {
        System.out.println("Message obtained is " + messageSpecialistRequest.getMessage());
        System.out.println("Message obtained posted by " + messageSpecialistRequest.isPostedBy());

        messageSpecialistService.storeMessage(messageSpecialistRequest,doc_id,spec_id);
        return new JwtResponse();
    }

    @GetMapping(value = "specialist/getMessages/{doctor_id}/{spec_id}")
    private List<MessageSpecialist> getMessages(@PathVariable Long doctor_id, @PathVariable Long spec_id)
    {
        System.out.println("Get Messages of specialist and doctor called!");
        List<MessageSpecialist> messages = messageSpecialistService.getMessages(doctor_id,spec_id);

        for(MessageSpecialist message: messages)
        {
            System.out.println("Message posted by " + message.isPostedBy() + " and the message is " + message.getMessage());
        }
        return messages;
    }

//    @GetMapping(value = "specialist/getDoctorMessages/{doctor_id}/{spec_id}")
//    private List<MessageSpecialist> getDoctorMessages(@PathVariable String doctor_id)
//    {
//        System.out.println("Get called!");
//        Long doc_id = Long.parseLong(doctor_id);
//        List<MessageSpecialist> doctorMessages = messageSpecialistService.getDoctorMessages(doc_id);
//
//        for(MessageSpecialist message: doctorMessages)
//        {
//            System.out.println("Message posted by " + message.isPostedBy() + " and the message is " + message.getMessage());
//        }
//        return doctorMessages;
//    }
//
//    @GetMapping(value = "specialist/getSpecialistMessages/{doc_id}")
//    private List<MessageSpecialist> getSpecialistMessages(@PathVariable String doc_id)
//    {
//        System.out.println("Get called!");
//        Long doctor_id = Long.parseLong(doc_id);
//        List<MessageSpecialist> specialistMessages = messageSpecialistService.getDoctorMessages(doctor_id);
//
//        for(MessageSpecialist message: specialistMessages)
//        {
//            System.out.println("Message posted by " + message.isPostedBy() + " and the message is " + message.getMessage());
//        }
//        return specialistMessages;
//    }

//anitiki spec_id ne pampali
    @PostMapping(value = "specialist/updateReadReceipt/{doc_id}")
    private JwtResponse updateReadReceiptOfDoctor(@PathVariable Long doc_id)
    {
        messageSpecialistService.updateReadReceiptOfDoctor(doc_id);
        return new JwtResponse();
    }
}
