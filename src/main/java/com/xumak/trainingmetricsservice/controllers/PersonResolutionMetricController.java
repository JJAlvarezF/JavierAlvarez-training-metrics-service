package com.xumak.trainingmetricsservice.controllers;

import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;
import com.xumak.trainingmetricsservice.response.ApiResponse;
import com.xumak.trainingmetricsservice.services.IPersonResolutionServiceMetricService;
import com.xumak.trainingmetricsservice.services.PersonResolutionServiceMetricService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class PersonResolutionMetricController {

    private final IPersonResolutionServiceMetricService service;

    public PersonResolutionMetricController(PersonResolutionServiceMetricService service) {
        this.service = service;
    }

    @GetMapping("/metrics/person-resolution-metrics")
    ResponseEntity<List<PersonResolutionServiceMetric>> findBatchLoaderMetrics(@RequestParam Timestamp start,
                                                                               @RequestParam Timestamp end) {
        return new ResponseEntity<>(service.findPersonResolutionMetrics(start, end), HttpStatus.OK);
    }

    @PostMapping("/metrics/person-resolution-metrics")
    ResponseEntity<ApiResponse> newMetrics(@RequestBody PersonResolutionServiceMetric newMetric) {
        return new ResponseEntity<>(new ApiResponse(service.savePersonResolutionMetric(newMetric.getTimestamp(),
                newMetric.getIndividualMatches(), newMetric.getHouseholdMatches(),
                newMetric.getNonMatches(), newMetric.getErrors(), newMetric.getUrl())), HttpStatus.OK);
    }
}
