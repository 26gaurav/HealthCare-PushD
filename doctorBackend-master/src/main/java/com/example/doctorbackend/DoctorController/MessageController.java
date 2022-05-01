package com.example.doctorbackend.DoctorController;

import com.example.doctorbackend.model.JwtResponse;
import com.example.doctorbackend.model.Messages;
import com.example.doctorbackend.service.MessageRequest;
import com.example.doctorbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@CrossOrigin(origins ="http://localhost:4210")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/postMessage/{pat_id}/{doc_id}")
    private JwtResponse postMessage(@RequestBody MessageRequest messageRequest, @PathVariable Long doc_id,
                                    @PathVariable Long pat_id)
    {
        System.out.println("Message obtained is " + messageRequest.getMessage());
        System.out.println("Message obtained posted by " + messageRequest.isPostedBy());

        messageService.storeMessage(messageRequest,doc_id,pat_id);
        return new JwtResponse();
    }


    @GetMapping(value = "/getMessages/{patient_id}")
    private List<Messages> getPatientMessages(@PathVariable String patient_id)
    {
        System.out.println("Get called!");
        Long pat_id = Long.parseLong(patient_id);
        List<Messages> patientMessages = messageService.getDoctorMessages(pat_id);

        for(Messages message: patientMessages)
        {
            System.out.println("Message posted by " + message.isPostedBy() + " and the message is " + message.getMessage());
        }
        return patientMessages;
    }


    @PostMapping(value = "/updateReadReceipt/{pat_id}")
    private JwtResponse updateReadReceipt(@PathVariable Long pat_id)
    {
        messageService.updateReadReceipt(pat_id);
        return new JwtResponse();
    }
}
