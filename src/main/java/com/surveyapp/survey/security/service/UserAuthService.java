package com.surveyapp.survey.security.service;

import com.surveyapp.survey.security.domain.Roles;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

public interface UserAuthService {

    Authentication authenticate(String username, String password);
    String generateJwt(Authentication auth);
    UserDetails getUserDetails(Authentication auth);

    default boolean isUserAdmin() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = user
                .getAuthorities()
                .stream()
                .map(role -> ((GrantedAuthority) role).getAuthority())
                .collect(Collectors.toSet());
        return roles.contains("ROLE_"+ Roles.ADMIN);
    }
}
