package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.DiseaseArea;
import com.surveyapp.survey.domain.dto.DiseaseAreaDTO;
import com.surveyapp.survey.service.DiseaseAreaService;
import com.surveyapp.survey.utility.mappers.DiseaseAreaMapper;
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
    public ResponseEntity<?> getDiseaseAreas() {
        Set<DiseaseArea> diseaseAreas = diseaseAreaService.getDiseaseAreas();
        Set<DiseaseAreaDTO> diseaseAreaDTOs = DiseaseAreaMapper.INSTANCE.diseaseAreasToDiseaseAreaDTOs(diseaseAreas);
        return new ResponseEntity<>(diseaseAreaDTOs, HttpStatus.OK);
    }

    @PostMapping("/diseaseAreas")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewDiseaseAreas(@Valid @RequestBody Set<DiseaseAreaDTO> diseaseAreas) {
        Set<DiseaseArea> newDiseaseAreas = DiseaseAreaMapper.INSTANCE.diseaseAreasDTOsToDiseaseAreas(diseaseAreas);
        Set<DiseaseArea> createdDiseaseAreas = diseaseAreaService.saveDiseaseAreas(newDiseaseAreas);
        return new ResponseEntity<>(createdDiseaseAreas, HttpStatus.CREATED);
    }

    @PutMapping("/diseaseAreas")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateDiseaseAreas(@Valid @RequestBody Set<DiseaseAreaDTO> diseaseAreas) {
        Set<DiseaseArea> toUpdate = DiseaseAreaMapper.INSTANCE.diseaseAreasDTOsToDiseaseAreas(diseaseAreas);
        Set<DiseaseArea> updated = diseaseAreaService.saveDiseaseAreas(toUpdate);
        Set<DiseaseAreaDTO> DTOs = DiseaseAreaMapper.INSTANCE.diseaseAreasToDiseaseAreaDTOs(updated);
        return new ResponseEntity<>(DTOs, HttpStatus.OK);
    }

    @DeleteMapping("/diseaseAreas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteDiseaseAreaByID(@PathVariable String id) {
        try {
            return new ResponseEntity<>(diseaseAreaService.deleteDiseaseAreaByID(Integer.valueOf(id)), HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Product with id %s not found", id), e);
        }
    }
}
