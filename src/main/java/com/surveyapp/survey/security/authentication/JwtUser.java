package com.surveyapp.survey.security.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class JwtUser implements UserDetails {

    private Integer ID;
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> authorities;

    public JwtUser(String username, String password, Set<GrantedAuthority> authorities, Integer ID) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
