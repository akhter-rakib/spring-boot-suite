package com.rakib.mailhogspringintegration.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${mail.sender.email}")
    private String senderEmail;
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendHtmlMessage(String to, String subject, String text, List<File> attachments) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(senderEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true); // true indicates HTML
        if (attachments != null) {
            for (File file : attachments) {
                FileSystemResource fileResource = new FileSystemResource(file);
                helper.addAttachment(file.getName(), fileResource);
            }
        }
        mailSender.send(message);
    }

    @Override
    public void sendPlainTextMessage(String to, String subject, String text) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
