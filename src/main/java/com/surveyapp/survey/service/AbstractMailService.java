package com.surveyapp.survey.service;

import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractMailService implements MailService {

    protected SimpleMailMessage prepareMessage(String toAddress, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(body);
        return message;
    }
}
