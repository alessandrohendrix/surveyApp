package com.surveyapp.survey.security.authentication.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpDTO {

    @NotBlank
    @Size(min = 1, max=50)
    private String username;
    @NotBlank
    @Size(max=50)
    private String email;
    @NotBlank
    @Size(min = 5)
    private String password;

    public SignUpDTO(@NotBlank @Size(min = 1, max = 50) String username, @NotBlank @Size(max = 50) String email, @NotBlank @Size(min = 5) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public SignUpDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
