package com.surveyapp.survey.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtResponse {

    private String jtw;
    private final String type = JwtHeaderProperties.BEARER.getType();
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String jtw, String username, Collection<? extends GrantedAuthority> roles) {
        this.jtw = jtw;
        this.username = username;
        this.roles = roles;
    }
}
