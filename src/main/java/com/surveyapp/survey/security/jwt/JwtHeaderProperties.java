package com.surveyapp.survey.security.jwt;

public enum JwtHeaderProperties {
    BEARER("Bearer");

    private String type;

    private JwtHeaderProperties(String type) {
        this.type = type;
    }

    public String getType() {
        return  type;
    }
}
