package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.DiseaseArea;
import com.surveyapp.survey.service.DiseaseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@RestController
public class DiseaseAreaController {

    private final DiseaseAreaService diseaseAreaService;

    @Autowired
    public DiseaseAreaController(DiseaseAreaService diseaseAreaService) {
        this.diseaseAreaService = diseaseAreaService;
    }

    @GetMapping({"/diseaseAreas"})
    @PreAuthorize("hasRole('ADMIN')")
    public Set<DiseaseArea> getDiseaseAreas() {
        Set<DiseaseArea> diseaseAreas = diseaseAreaService.getDiseaseAreas();
        return diseaseAreas;
    }

    @PostMapping("/diseaseAreas")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewDiseaseAreas(@RequestBody Set<DiseaseArea> diseaseAreas) {
        Set<DiseaseArea> createdDiseaseAreas = diseaseAreaService.saveDiseaseAreas(diseaseAreas);
        return new ResponseEntity<>(createdDiseaseAreas, HttpStatus.CREATED);
    }

    @PutMapping("/diseaseAreas")
    @PreAuthorize("hasRole('ADMIN')")
    public Set<DiseaseArea> updateDiseaseAreas(@RequestBody Set<DiseaseArea> diseaseAreas) {
        return diseaseAreaService.saveDiseaseAreas(diseaseAreas);
    }

    @DeleteMapping("/diseaseAreas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Integer deleteDiseaseAreaByID(@PathVariable String id) {
        return diseaseAreaService.deleteDiseaseAreaByID(Integer.valueOf(id));
    }
}
