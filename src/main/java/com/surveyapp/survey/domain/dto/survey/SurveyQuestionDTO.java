package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.dto.product.CompetitorDTO;
import com.surveyapp.survey.domain.dto.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SurveyQuestionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProductDTO product;
    private Set<CompetitorDTO> competitors;
    private ProductQuestionsDTO productQuestions;
    private Map<Integer, ProductQuestionsDTO> competitorsQuestions;
}
