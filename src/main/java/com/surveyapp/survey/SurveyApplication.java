package com.surveyapp.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EntityScan(
        basePackages = {
                "com.surveyapp.survey.domain.entities.product",
                "com.surveyapp.survey.domain.entities.survey",
                "com.surveyapp.survey.security.domain.entities"
        })
public class SurveyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }
}
