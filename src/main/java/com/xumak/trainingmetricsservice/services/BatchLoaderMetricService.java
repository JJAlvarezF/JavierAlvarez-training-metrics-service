package com.xumak.trainingmetricsservice.services;

import com.xumak.trainingmetricsservice.entities.BatchLoaderMetric;
import com.xumak.trainingmetricsservice.repositories.BatchLoaderMetricRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BatchLoaderMetricService implements IBatchLoaderMetricsService {

    private final BatchLoaderMetricRepository repository;

    @Override
        public boolean saveBatchLoaderMetric(Timestamp timestamp, String filename, Timestamp fileCreated,
                                                       Timestamp filePickedUp, Timestamp fileProcessed,
                                                       int numberOfRecords) {
        try {
            repository.save(BatchLoaderMetric.builder()
                    .timestamp(timestamp)
                    .fileName(filename)
                    .fileCreated(fileCreated)
                    .filePickedUp(filePickedUp)
                    .fileProcessed(fileProcessed)
                    .numberOfRecords(numberOfRecords)
                    .build());
            return true;
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
            return false;
        }
    }

    @Override
    public List<BatchLoaderMetric> findBatchLoaderMetrics(Timestamp start, Timestamp end) {
        return repository.findAllByTimestampBetween(start, end);
    }
}
