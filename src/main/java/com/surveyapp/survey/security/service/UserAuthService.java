package com.surveyapp.survey.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthService {

    Authentication authenticate(String username, String password);
    String generateJwt(Authentication auth);
    UserDetails getUserDetails(Authentication auth);
}
