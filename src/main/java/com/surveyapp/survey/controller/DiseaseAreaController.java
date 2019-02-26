package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.DiseaseArea;
import com.surveyapp.survey.service.DiseaseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
    public ResponseEntity<?> addNewDiseaseAreas(@Valid @RequestBody Set<DiseaseArea> diseaseAreas) {
        Set<DiseaseArea> createdDiseaseAreas = diseaseAreaService.saveDiseaseAreas(diseaseAreas);
        return new ResponseEntity<>(createdDiseaseAreas, HttpStatus.CREATED);
    }

    @PutMapping("/diseaseAreas")
    @PreAuthorize("hasRole('ADMIN')")
    public Set<DiseaseArea> updateDiseaseAreas(@Valid @RequestBody Set<DiseaseArea> diseaseAreas) {
        return diseaseAreaService.saveDiseaseAreas(diseaseAreas);
    }

    @DeleteMapping("/diseaseAreas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Integer deleteDiseaseAreaByID(@PathVariable String id) {
        try {
            return diseaseAreaService.deleteDiseaseAreaByID(Integer.valueOf(id));
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %s not found", id), e);
        }
    }
}
