package com.surveyapp.survey.controller;

import com.surveyapp.survey.domain.Competitor;
import com.surveyapp.survey.security.service.UserAuthService;
import com.surveyapp.survey.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Set;

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
        return new ResponseEntity<>(competitors, HttpStatus.OK);
    }

    @GetMapping("/competitors/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getCompetitor(@PathVariable("id") String id) {
        try {
            Competitor competitor = competitorService.findByID(Integer.valueOf(id));
            return new ResponseEntity<>(competitor, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %s not found", id), e);
        }
    }

    @PostMapping("/competitors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewCompetitor(@Valid @RequestBody Set<Competitor> competitors) {
        try {
            Set<Competitor> newCompetitors = this.competitorService.saveCompetitors(competitors);
            return new ResponseEntity<>(newCompetitors, HttpStatus.CREATED);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/competitors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Set<Competitor> competitors) {
        try {
            Set<Competitor> savedCompetitors = this.competitorService.updateCompetitors(competitors);
            return new ResponseEntity<>(savedCompetitors, HttpStatus.OK);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
