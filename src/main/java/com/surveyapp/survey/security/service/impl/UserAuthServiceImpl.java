package com.surveyapp.survey.security.service.impl;

import com.surveyapp.survey.security.jwt.JwtProvider;
import com.surveyapp.survey.security.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserAuthServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Authentication authenticate(String username, String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return auth;
    }

    @Override
    public String generateJwt(Authentication auth) {
        return jwtProvider.generateJwt(auth);
    }

    @Override
    public UserDetails getUserDetails(Authentication auth) {
        return (UserDetails) auth.getPrincipal();
    }
}
