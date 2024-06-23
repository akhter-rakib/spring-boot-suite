package com.rakib.mailhogspringintegration.service;

import jakarta.mail.MessagingException;

import java.io.File;
import java.util.List;

public interface EmailService {

    void sendHtmlMessage(String to, String subject, String text, List<File> attachments) throws MessagingException;

    void sendPlainTextMessage(String to, String subject, String text) throws MessagingException;
}
