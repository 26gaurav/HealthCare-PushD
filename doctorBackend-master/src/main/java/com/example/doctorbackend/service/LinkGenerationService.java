package com.example.doctorbackend.service;

import com.example.doctorbackend.model.GenerateLink;
import com.example.doctorbackend.model.Patient;
import com.example.doctorbackend.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class LinkGenerationService {

    @Autowired
    private PatientRepository patientRepository;

    private final JavaMailSender mailSender;

    public LinkGenerationService(PatientRepository patientRepository, JavaMailSender mailSender) {
        this.patientRepository = patientRepository;
        this.mailSender = mailSender;
    }


    public boolean emailIsExist(GenerateLink generateLink){
        List<Patient> patient = patientRepository.findByEmail(generateLink.getPatEmail());
        if(patient.size()>=1)
            return false;
        else
            return true;
    }

    public void sendLinkEmail(String link, String email, String fname)
            throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("patient@healthcare.com", "Depression Support Link Generation");
        helper.setTo(email);

        String subject = "Link for New patient Registration";

        String content = "<p>Hello " + fname+ "</p>"
                + "<p>Please Click the following link to Register "
                + "<p><b>" + link + "</b></p>"
                + "<br>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }
}
