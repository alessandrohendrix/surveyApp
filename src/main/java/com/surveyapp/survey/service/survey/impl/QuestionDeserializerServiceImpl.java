package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.dto.survey.OpenQuestionDTO;
import com.surveyapp.survey.domain.dto.survey.StandardQuestionDTO;
import com.surveyapp.survey.domain.entities.product.Competitor;
import com.surveyapp.survey.domain.entities.survey.*;
import com.surveyapp.survey.mapper.survey.OpenQuestionMapper;
import com.surveyapp.survey.mapper.survey.StandardQuestionMapper;
import com.surveyapp.survey.service.survey.QuestionDeserializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionDeserializerServiceImpl implements QuestionDeserializerService {

    private final StandardQuestionMapper standardQuestionMapper;
    private final OpenQuestionMapper openQuestionMapper;

    @Autowired
    public QuestionDeserializerServiceImpl(StandardQuestionMapper standardQuestionMapper, OpenQuestionMapper openQuestionMapper) {
        this.standardQuestionMapper = standardQuestionMapper;
        this.openQuestionMapper = openQuestionMapper;
    }

    @Override
    public Set<ProductStandardQuestion> deserializeProductStandardQuestion(Survey survey,
                                                                           Set<StandardQuestionDTO> standardQuestions) {

        Set<ProductStandardQuestion> deserializedQuestions =
                standardQuestionMapper.standardQuestionDTOsToStandardQuestions(standardQuestions);
        assignSurvey(survey, deserializedQuestions);
        return deserializedQuestions;
    }

    @Override
    public Set<ProductOpenQuestion> deserializeProductOpenQuestion(Survey survey,
                                                                   Set<OpenQuestionDTO> openQuestions, Section section) {

        Set<ProductOpenQuestion> mappedQuestions = openQuestionMapper.openQuestionDTOsToOpenQuestions(openQuestions);
        mappedQuestions.forEach(question -> question.setSection(section));
        return mappedQuestions;
    }

    @Override
    public Set<CompetitorStandardQuestion> deserializeCompetitorStandardQuestions(Survey survey,
                                                                                  Set<StandardQuestionDTO> standardQuestions,
                                                                                  Competitor competitor) {

        Set<CompetitorStandardQuestion> deserializedQuestions =
                standardQuestionMapper.standardQuestionDTOsToCompetitorStandardQuestions(standardQuestions);
        assignSurvey(survey, deserializedQuestions);
        deserializedQuestions.forEach(question -> question.setCompetitor(competitor));
        return deserializedQuestions;
    }

    @Override
    public Set<CompetitorOpenQuestion> deserializeCompetitorOpenQuestions(Survey survey,
                                                                          Set<OpenQuestionDTO> openQuestions,
                                                                          Competitor competitor,
                                                                          Section section) {

        Set<CompetitorOpenQuestion> mappedQuestions = openQuestionMapper.openQuestionDTOsToCompetitOropenQuestions(openQuestions);
        mappedQuestions.forEach(question -> {
            question.setCompetitor(competitor);
            question.setSection(section);
        });
        return mappedQuestions;
    }

    private void assignSurvey(Survey survey, Set<? extends Question> questions) {
        questions.forEach(question -> question.setSurvey(survey));
    }

}
