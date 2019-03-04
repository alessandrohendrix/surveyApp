package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.service.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/survey")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getMostRecentSurvey(@RequestParam("productId") Integer productId) {
        try {
            Survey survey = surveyService.findProductMostRecentSurvey(productId, true);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
