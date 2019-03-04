package com.surveyapp.survey.controller;

import com.surveyapp.survey.security.domain.dto.PasswordResetDTO;
import com.surveyapp.survey.security.domain.dto.RequestPasswordResetDTO;
import com.surveyapp.survey.security.domain.entities.PasswordResetToken;
import com.surveyapp.survey.security.domain.entities.User;
import com.surveyapp.survey.security.service.impl.PasswordResetTokenService;
import com.surveyapp.survey.service.MailService;
import com.surveyapp.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ResetPasswordController {

    private final MailService mailService;
    private final PasswordResetTokenService passwordResetTokenService;
    private final UserService userService;
    private final String SUBJECT="Password reset";
    private final String BODY="To reset the password, click on the following link ";
    @Value("${reset.path}")
    private String resetPath;

    @Autowired
    public ResetPasswordController(MailService mailService, PasswordResetTokenService passwordResetTokenService, UserService userService) {
        this.mailService = mailService;
        this.passwordResetTokenService = passwordResetTokenService;
        this.userService = userService;
    }

    @PostMapping("/forgotPassword")
    @Transactional
    public ResponseEntity<?> requestPasswordReset(@Valid @RequestBody RequestPasswordResetDTO resetPasswordDTO) {
        try {
            String email = resetPasswordDTO.getEmail();
            PasswordResetToken passwordResetToken = passwordResetTokenService.createPasswordRsetTokenForEmail(email);
            String token = passwordResetToken.getToken();
            String link = "<a>"+resetPath+token+"</a>";
            mailService.sendEmail(email, SUBJECT, BODY+link);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/resetPassword")
    @Transactional
    public ResponseEntity<?> resetPassword(@Valid @RequestBody PasswordResetDTO passwordResetDTO) {
        try {
            String token = passwordResetDTO.getToken();
            PasswordResetToken passwordResetToken = passwordResetTokenService.findByToken(token);
            User user = passwordResetToken.getUser();
            userService.updateUserPassword(user, passwordResetDTO.getPassword());
            passwordResetTokenService.deletePasswordResetToken(passwordResetToken.getID()); //consume token
            return new ResponseEntity<>("Password updated", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
