package com.surveyapp.survey.service.survey.impl;

import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import com.surveyapp.survey.domain.entities.survey.Section;
import com.surveyapp.survey.repository.survey.SectionRespository;
import com.surveyapp.survey.service.survey.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRespository sectionRespository;

    @Autowired
    public SectionServiceImpl(SectionRespository sectionRespository) {
        this.sectionRespository = sectionRespository;
    }

    @Override
    public Map<SectionEnum, Section> getSectionsMap() {

        Map<SectionEnum, Section> sectionsMap = new HashMap<>();
        sectionRespository
                .findAll()
                .iterator()
                .forEachRemaining(section -> sectionsMap.put(section.getSectionName(), section));

        return sectionsMap;
    }
}
