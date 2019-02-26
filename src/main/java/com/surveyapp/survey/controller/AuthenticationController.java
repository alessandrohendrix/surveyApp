package com.surveyapp.survey.controller;

import com.surveyapp.survey.security.authentication.LoginDTO;
import com.surveyapp.survey.security.authentication.SignUpDTO;
import com.surveyapp.survey.security.jwt.JwtResponse;
import com.surveyapp.survey.security.service.UserAuthService;
import com.surveyapp.survey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserAuthService userAuthService;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationController(UserAuthService userAuthService, UserService userService) {
        this.userAuthService = userAuthService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {
        logger.info("Inside method");
        Authentication auth = userAuthService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());
        logger.info("Authenticated");
        String jwt = userAuthService.generateJwt(auth);
        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDTO signUpDTO) {
        if(userService.existsUser(signUpDTO.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        logger.info("BEGIN CREATION");
        // Account Creation
        userService.createUser(signUpDTO.getUsername(), signUpDTO.getEmail(), signUpDTO.getPassword());
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }
}
