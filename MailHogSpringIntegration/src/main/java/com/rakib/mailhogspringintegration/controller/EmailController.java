package com.rakib.mailhogspringintegration.controller;

import com.rakib.mailhogspringintegration.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-plain-text-email")
    public String sendPlainTextEmail(@RequestParam String to) {
        String subject = "Test Plain Text Email";
        String text = "This is a test email with plain text content.";

        try {
            emailService.sendPlainTextMessage(to, subject, text);
            return "Plain Text Email sent";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
    }

}
