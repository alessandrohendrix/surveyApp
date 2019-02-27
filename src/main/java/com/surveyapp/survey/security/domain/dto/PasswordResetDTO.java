package com.surveyapp.survey.security.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PasswordResetDTO implements Serializable {
    private static final long serialVersionUID=1L;
    @NotBlank
    private String token;
    @NotBlank
    @Size(min = 5)
    private String password;

    public PasswordResetDTO(@NotBlank String token, @NotBlank @Size(min = 5) String password) {
        this.token = token;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
