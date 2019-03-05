package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.service.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/newest")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getMostRecentSurvey(@RequestParam("productId") Integer productId) {
        try {
            Survey survey = surveyService.findProductMostRecentSurvey(productId);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/lastPublished")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getLastPublishedSurvey(@RequestParam("productId") Integer productId) {
        try {
            Survey survey = surveyService.findLastPublishedSurvey(productId);
            return new ResponseEntity<>(survey, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/allPublished")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getAllPublishedSurveys(@RequestParam("productId") Integer productId) {
        try {
            Set<Survey> surveys = surveyService.getAllPublishedSurveys(productId);
            return new ResponseEntity<>(surveys, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/publish")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> publishSurvey(@RequestParam("surveyId") Integer surveyId) {
        try {
            surveyService.publishSurvey(surveyId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
