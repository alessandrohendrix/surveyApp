package com.surveyapp.survey.service.survey;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import com.surveyapp.survey.domain.entities.survey.Section;

import java.util.Map;

public interface SectionService {

    Map<SectionEnum, Section> getSectionsMap();
}
