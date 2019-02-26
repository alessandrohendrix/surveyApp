package com.surveyapp.survey.service.impl;

import com.surveyapp.survey.service.AbstractMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl extends AbstractMailService {

    private final MailSender mailSender;

    @Autowired
    public MailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String toAddress, String subject, String body) {
        SimpleMailMessage message = this.prepareMessage(toAddress, subject, body);
        mailSender.send(message);
    }
}
