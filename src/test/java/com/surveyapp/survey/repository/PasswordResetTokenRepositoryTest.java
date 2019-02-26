package com.surveyapp.survey.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.Assert.*;

public class PasswordResetTokenRepositoryTest {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${expiration.length.minutes}")
    private int expirationMinutes;

    @Before
    public void init() {
        Assert.assertFalse(expirationMinutes == 0);
    }

    @Test
    public void testTokenExpirationLenght() throws Exception{

    }

}