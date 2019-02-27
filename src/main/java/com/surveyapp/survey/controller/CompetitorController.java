package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.Competitor;
import com.surveyapp.survey.domain.dto.CompetitorDTO;
import com.surveyapp.survey.service.CompetitorService;
import com.surveyapp.survey.utility.mappers.CompetitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class CompetitorController {

    private final CompetitorService competitorService;

    @Autowired
    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping("/competitors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getCompetitors() {
        Set<Competitor> competitors = competitorService.getCompetitors();
        Set<CompetitorDTO> competitorDTOs = CompetitorMapper.INSTANCE.competitorsToCompetitorDTOs(competitors);
        competitorService.setProductImgs(competitors, competitorDTOs, competitorService::setProductDTOImg);
        return new ResponseEntity<>(competitorDTOs, HttpStatus.OK);
    }

    @GetMapping("/competitors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getCompetitor(@PathVariable("id") String id) {
        try {
            Competitor competitor = competitorService.findByID(Integer.valueOf(id));
            CompetitorDTO competitorDTO = createCompetitorDTO(competitor);
            return new ResponseEntity<>(competitorDTO, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Product with id %s not found", id), e);
        }
    }

    @PostMapping("/competitors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewCompetitor(@Valid @RequestBody Set<CompetitorDTO> competitorDTOs) {
        try {
            Set<CompetitorDTO> DTOs = saveCompetitors(competitorDTOs, this.competitorService::saveCompetitors);
            return new ResponseEntity<>(DTOs,
                    HttpStatus.CREATED);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/competitors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Set<CompetitorDTO> competitorDTOs) {
        try {
            Set<CompetitorDTO> DTOs = saveCompetitors(competitorDTOs, competitorService::updateCompetitors);
            return new ResponseEntity<>(DTOs, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    private Set<CompetitorDTO> saveCompetitors(Set<CompetitorDTO> competitorDTOs,
                                               Function<Set<Competitor>, Set<Competitor>> serviceFunction) {

        Set<Competitor> newCompetitors = competitorDTOs
                .stream()
                .map(dto -> recreateCompetitor(dto))
                .collect(Collectors.toSet());
        Set<Competitor> savedCompetitors = serviceFunction.apply(newCompetitors);
        Set<CompetitorDTO> DTOs = savedCompetitors
                .stream()
                .map(competitor -> createCompetitorDTO(competitor))
                .collect(Collectors.toSet());
        return DTOs;
    }

    private Competitor recreateCompetitor(CompetitorDTO competitorDTO) {
        Competitor competitor = CompetitorMapper.INSTANCE.competitorDTOToCompetitor(competitorDTO);
        this.competitorService.setProductImg(competitor, competitorDTO);
        return competitor;
    }

    private CompetitorDTO createCompetitorDTO(Competitor competitor) {
        CompetitorDTO dto = CompetitorMapper.INSTANCE.competitorToCompetitorDTO(competitor);
        this.competitorService.setProductDTOImg(competitor, dto);
        return dto;
    }

}
