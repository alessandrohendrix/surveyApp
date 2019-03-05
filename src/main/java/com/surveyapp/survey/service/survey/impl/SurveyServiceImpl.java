package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.repository.survey.SurveyRepository;
import com.surveyapp.survey.service.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey findProductMostRecentSurvey(Integer productID) {
        return surveyRepository
                .findMostRecentSurvey(productID, PageRequest.of(0, 1))
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Survey related to product with id "+productID+" not found"));
    }

    @Override
    public Survey findLastPublishedSurvey(Integer productID) {
        return surveyRepository
                .findLastPublishedSurvey(productID, PageRequest.of(0,1))
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Survey related to product with id "+productID+" not found"));
    }

    @Override
    public Survey findProductSurveyByCreationDate(Integer productID, LocalDateTime creationDate) {
        return surveyRepository
                .findByCreationDateAndProductID(productID, creationDate)
                .orElseThrow(() -> new RuntimeException("Survey related to product with id "+productID+" not found"));
    }

    @Override
    public Set<Survey> getAllPublishedSurveys(Integer productID) {
        Set<Survey> publishedSurveys = new HashSet<>();
        surveyRepository
                .findCreationDates(productID)
                .iterator()
                .forEachRemaining(publishedSurveys::add);
        return publishedSurveys;
    }

    @Override
    @Transactional
    public void publishSurvey(Integer surveyID) {
        Survey survey = surveyRepository
                .findById(surveyID)
                .orElseThrow(() -> new RuntimeException("Survey with id "+surveyID+" not found"));
        survey.setPublished(true);
        surveyRepository.save(survey);
    }
}
