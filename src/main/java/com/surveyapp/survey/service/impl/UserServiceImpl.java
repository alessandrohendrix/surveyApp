package com.surveyapp.survey.service.impl;

import com.surveyapp.survey.repository.security.RoleRepository;
import com.surveyapp.survey.repository.security.UserRepository;
import com.surveyapp.survey.security.domain.entities.Role;
import com.surveyapp.survey.security.domain.enums.Roles;
import com.surveyapp.survey.security.domain.entities.User;
import com.surveyapp.survey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
        String encryptedPassword = passwordEncoder.encode(password);
        User user = new User(username, email, encryptedPassword, userRole);
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User updateUserPassword(User user, String newPassword) {
        String encryptedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encryptedPassword);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
