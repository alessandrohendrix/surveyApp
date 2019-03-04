package com.surveyapp.survey.security.service.impl;

import com.surveyapp.survey.repository.security.PasswordResetTokenRepository;
import com.surveyapp.survey.repository.security.UserRepository;
import com.surveyapp.survey.security.domain.entities.PasswordResetToken;
import com.surveyapp.survey.security.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserRepository userRepository;

    @Value("${token.expiration.length.minutes}")
    private int tokenExpirationInMinutes;

    @Autowired
    public PasswordResetTokenService(PasswordResetTokenRepository passwordResetTokenRepository, UserRepository userRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.userRepository = userRepository;
    }

    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Invalid token"));
    }

    public PasswordResetToken createPasswordRsetTokenForEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now(Clock.systemUTC());
        PasswordResetToken resetToken = new PasswordResetToken(token, user, now, tokenExpirationInMinutes);
        return passwordResetTokenRepository.save(resetToken);
    }

    public void deletePasswordResetToken(Integer tokenID) {
        passwordResetTokenRepository.deleteById(tokenID);
    }
}
