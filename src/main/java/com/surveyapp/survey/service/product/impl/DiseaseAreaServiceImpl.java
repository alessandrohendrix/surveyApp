package com.surveyapp.survey.service.product.impl;

import com.surveyapp.survey.domain.entities.product.DiseaseArea;
import com.surveyapp.survey.repository.product.DiseaseAreaRepository;
import com.surveyapp.survey.service.product.DiseaseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
public class DiseaseAreaServiceImpl implements DiseaseAreaService {

    private final DiseaseAreaRepository diseaseAreaRepository;

    @Autowired
    public DiseaseAreaServiceImpl(DiseaseAreaRepository diseaseAreaRepository) {
        this.diseaseAreaRepository = diseaseAreaRepository;
    }

    @Override
    public Set<DiseaseArea> getDiseaseAreas() {
        Set<DiseaseArea> diseaseAreas = new HashSet<>();
        diseaseAreaRepository.findAll().iterator().forEachRemaining(diseaseAreas::add);
        return diseaseAreas;
    }

    @Override
    public Set<DiseaseArea> saveDiseaseAreas(Set<DiseaseArea> diseaseAreas) {
        List<DiseaseArea> savedDiseaseAreas = diseaseAreaRepository.saveAll(diseaseAreas);
        return new HashSet<>(savedDiseaseAreas);
    }

    @Override
    public Set<DiseaseArea> updateDiseaseAreas(Set<DiseaseArea> diseaseAreas) {
        Set<DiseaseArea> updatedDiseaseAreas = this.saveDiseaseAreas(diseaseAreas);
        return updatedDiseaseAreas;
    }

    @Override
    public Integer deleteDiseaseAreaByID(Integer id) {
        diseaseAreaRepository.deleteById(id);
        return id;
    }
}
