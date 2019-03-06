package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SurveyCreationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private SurveyInfoDTO surveyInfoDTO;
    private SurveyQuestionDTO surveyQuestionDTO;
    private Map<SectionEnum, List<KPIQuestionDTO>> kpiQuestionDTO;
}
