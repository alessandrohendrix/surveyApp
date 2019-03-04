package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.entities.survey.Survey;
import com.surveyapp.survey.repository.survey.SurveyRepository;
import com.surveyapp.survey.service.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public Survey findProductMostRecentSurvey(Integer productID, boolean published) {
        return surveyRepository
                .findMostRecentSurvey(productID, published, PageRequest.of(0, 1))
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Survey related to product with id "+productID+" not found"));
    }

    @Override
    public Survey findProductSurveyByCreationDate(Integer productID, LocalDateTime creationDate) {
        return surveyRepository
                .findByCreationDateAndProductID(productID, creationDate)
                .orElseThrow(() -> new RuntimeException("Survey related to product with id "+productID+" not found"));
    }

    @Override
    public Set<LocalDateTime> findProductSurveyCreationDates(Integer productID) {
        Set<LocalDateTime> timestamps = new HashSet<>();
        surveyRepository
                .findCreationDates(productID)
                .iterator()
                .forEachRemaining(timestamps::add);
        return timestamps;
    }
}
