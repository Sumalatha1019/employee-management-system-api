package com.example.email.controller;

import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@EnableAsync
@RestController
@RequestMapping("email")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService){
        this.emailService=emailService;
    }

    @PostMapping("withAtt")
    public ResponseEntity<String> sendEmailWithAttachment(
            @RequestParam("toAddress") String toAddress,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam("attachment") MultipartFile attachment) {

        return emailService.sendEmailWithAttachment(toAddress, subject, body, attachment);
    }

    @PostMapping("send")
    public ResponseEntity<String> sendEmail(
            @RequestParam("toAddress") String toAddress,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body) {

        return emailService.sendEmail(toAddress, subject, body);
    }



    @PostMapping("add")
    public ResponseEntity<String> addEmail(
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam("toAddress") String toAddress,
            @RequestParam(value = "attachmentFilePath", required = false) String attachmentFilePath ){

        return emailService.addEmail(subject, body, toAddress);
    }

    @Scheduled(cron = "0 10 11 * * *")
    public void sendEmailToAllFromDB() {
        emailService.sendEmailToAll();
    }



}
