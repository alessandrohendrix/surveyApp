package com.surveyapp.survey.service.impl;

import com.surveyapp.survey.repository.RoleRepository;
import com.surveyapp.survey.repository.UserRepository;
import com.surveyapp.survey.security.domain.Role;
import com.surveyapp.survey.security.domain.Roles;
import com.surveyapp.survey.security.domain.User;
import com.surveyapp.survey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public boolean existsUser(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User createUser(String username, String email, String password) {
        Role userRole = roleRepository.findByName(Roles.USER);
        User user = new User(username, email, password, userRole);
        User newUser = userRepository.save(user);
        return newUser;
    }
}
