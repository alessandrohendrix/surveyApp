package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.survey.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRespository extends CrudRepository<Section, Integer> {
}
