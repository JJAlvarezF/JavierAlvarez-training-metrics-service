package com.xumak.trainingmetricsservice.controllers;

import com.xumak.trainingmetricsservice.entities.BatchLoaderMetric;
import com.xumak.trainingmetricsservice.response.ApiResponse;
import com.xumak.trainingmetricsservice.services.BatchLoaderMetricService;
import com.xumak.trainingmetricsservice.services.IBatchLoaderMetricsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class BatchLoaderMetricController {

    private final IBatchLoaderMetricsService service;

    public BatchLoaderMetricController(BatchLoaderMetricService service) {
        this.service = service;
    }

    @GetMapping("/metrics/batch-loader-metric")
    ResponseEntity<List<BatchLoaderMetric>> findBatchLoaderMetrics(@RequestParam Timestamp start,
                                                                   @RequestParam Timestamp end) {
        return new ResponseEntity<>(service.findBatchLoaderMetrics(start, end), HttpStatus.OK);
    }

    @PostMapping("/metrics/batch-loader-metric")
    ResponseEntity<ApiResponse> newMetrics(@RequestBody BatchLoaderMetric newMetric) {
        return new ResponseEntity<>(new ApiResponse(service.saveBatchLoaderMetric(newMetric.getTimestamp(),
                newMetric.getFileName(), newMetric.getFileCreated(),
                newMetric.getFilePickedUp(), newMetric.getFileProcessed(), newMetric.getNumberOfRecords())), HttpStatus.OK);
    }
}
