package com.surveyapp.survey.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RequestPasswordResetDTO implements Serializable {

    public static final long serialVersionUID = 1L;
    @NotBlank
    @Size(min = 5)
    private String email;

    public RequestPasswordResetDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
