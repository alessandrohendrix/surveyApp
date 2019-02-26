package com.surveyapp.survey.security.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
public class LoginDTO {
    @NotBlank
    @Size(min = 1, max=50)
    String username;
    @NotBlank
    @Size(min = 5)
    String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
