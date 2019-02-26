package com.surveyapp.survey.service;

import com.surveyapp.survey.security.domain.Roles;
import com.surveyapp.survey.security.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    boolean existsUser(String email);
    User createUser(String username, String email, String password);
}
