package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.dto.survey.SurveyDTO;
import com.surveyapp.survey.domain.dto.survey.SurveyInfoDTO;
import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.service.survey.SurveySerializerService;
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
    private final SurveySerializerService surveySerializerService;

    @Autowired
    public SurveyController(SurveyService surveyService, SurveySerializerService surveySerializerService) {
        this.surveyService = surveyService;
        this.surveySerializerService = surveySerializerService;
    }

    @GetMapping("/newest")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getMostRecentSurveyQuestions(@RequestParam("productId") Integer productId) {
        try {
            Survey survey = surveyService.findProductMostRecentSurvey(productId);
            SurveyDTO surveyDTO = surveySerializerService.generateSurveyCreationDTO(survey);
            return new ResponseEntity<>(surveyDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/lastPublished")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getLastPublishedSurveyInfo(@RequestParam("productId") Integer productId) {
        try {
            Survey survey = surveyService.findLastPublishedSurvey(productId);
            SurveyInfoDTO surveyInfoDTO = surveySerializerService.generateSurveyInfoDTO(survey);
            return new ResponseEntity<>(surveyInfoDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/allPublished")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getAllPublishedSurveysInfo(@RequestParam("productId") Integer productId) {
        try {
            Set<Survey> surveys = surveyService.getAllPublishedSurveys(productId);
            Set<SurveyInfoDTO> surveyInfoDTOs = surveySerializerService.generateSurveyInfoDTOs(surveys);
            return new ResponseEntity<>(surveyInfoDTOs, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/creation")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        return null;
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
