package com.surveyapp.survey.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    void sendEmail(String toAddress, String subject, String body);
}
