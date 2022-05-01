package com.example.patientlogin.messages;

import com.example.patientlogin.jwt.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
@CrossOrigin(origins ="http://localhost:4200")
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/postMessage/{pat_id}/{doc_id}")
    private JwtResponse postMessage(@RequestBody MessageRequest messageRequest, @PathVariable Long doc_id,
                             @PathVariable Long pat_id)
    {
//        System.out.println("Message obtained is " + messageRequest.getComment());
//        System.out.println("Message obtained posted by " + messageRequest.getPostedBy());

        messageService.storeMessage(messageRequest,doc_id,pat_id);
        return new JwtResponse();
    }


    @GetMapping(value = "/getMessages/{patient_id}")
    private List<Messages> getPatientMessages(@PathVariable String patient_id)
    {
        System.out.println("Get called!");
        Long pat_id = Long.parseLong(patient_id);
        List<Messages> patientMessages = messageService.getPatientMessages(pat_id);

        for(Messages message: patientMessages)
        {
            System.out.println("Message posted by " + message.isPostedBy() + " and the message is " + message.getMessage());
        }
        return patientMessages;
    }

    @PostMapping(value = "/updateReadReceipt/{pat_id}")
    private JwtResponse updateReadReceipt(@PathVariable Long pat_id)
    {
//        System.out.println("Message obtained is " + messageRequest.getComment());
//        System.out.println("Message obtained posted by " + messageRequest.getPostedBy());

        messageService.updateReadReceipt(pat_id);
        return new JwtResponse();
    }

}
