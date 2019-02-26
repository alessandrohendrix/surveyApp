package com.surveyapp.survey.security.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.security.domain.User;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class UserPrincipal implements UserDetails {

    private static final long SerialVersionUID=1L;

    private Integer ID;
    private String username;
    private String email;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private String password;
    @EqualsAndHashCode.Exclude
    private Set<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer ID, String username, String email, String password, Set<? extends GrantedAuthority> authorities) {
        this.ID = ID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal build(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new Authority("ROLE_"+user.getRole().getName().name()));
        return new UserPrincipal(
                user.getID(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    public Integer getID() {
        return ID;
    }

    public String getEmail() {
        return email;
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
