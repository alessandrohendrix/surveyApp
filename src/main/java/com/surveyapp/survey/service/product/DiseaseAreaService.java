package com.surveyapp.survey.service.product;

import com.surveyapp.survey.domain.entities.product.DiseaseArea;
import java.util.Set;

public interface DiseaseAreaService {

    Set<DiseaseArea> getDiseaseAreas();

    Set<DiseaseArea> saveDiseaseAreas(Set<DiseaseArea> diseaseAreas);

    Set<DiseaseArea> updateDiseaseAreas(Set<DiseaseArea> diseaseAreas);

    Integer deleteDiseaseAreaByID(Integer id);
}
