package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.entities.survey.KPIQuestion;
import com.surveyapp.survey.repository.survey.KpiQuestionRepository;
import com.surveyapp.survey.service.survey.KpiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KpiQuestionServiceImpl implements KpiQuestionService {

    private KpiQuestionRepository kpiQuestionRepository;

    @Autowired
    public KpiQuestionServiceImpl(KpiQuestionRepository kpiQuestionRepository) {
        this.kpiQuestionRepository = kpiQuestionRepository;
    }

    @Override
    public Set<KPIQuestion> retrieveKPIQuestions() {
        Set<KPIQuestion> kpiQuestions = new HashSet<>();
        kpiQuestionRepository
                .findAll()
                .iterator()
                .forEachRemaining(kpiQuestions::add);
        return kpiQuestions;
    }
}
