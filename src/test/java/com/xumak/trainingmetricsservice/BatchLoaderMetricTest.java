package com.xumak.trainingmetricsservice;

import com.xumak.trainingmetricsservice.entities.BatchLoaderMetric;
import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;
import com.xumak.trainingmetricsservice.repositories.BatchLoaderMetricRepository;
import com.xumak.trainingmetricsservice.services.BatchLoaderMetricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchLoaderMetricTest {

    @InjectMocks
    BatchLoaderMetricService service;

    @Mock
    BatchLoaderMetricRepository repository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenSaveBatchLoaderMetric_shouldReturnTrue() {
        BatchLoaderMetric batchLoaderMetric = BatchLoaderMetric.builder()
                .timestamp(new Timestamp(2022, 8, 4, 0, 0, 0, 0))
                .fileName("File Name")
                .numberOfRecords(1)
                .filePickedUp(new Timestamp(2022, 8, 4, 0, 0, 0, 0))
                .fileProcessed(new Timestamp(2022, 8, 4, 0, 0, 0, 0))
                .fileCreated(new Timestamp(2022, 8, 4, 0, 0, 0, 0))
                .build();

        boolean created = service.saveBatchLoaderMetric(batchLoaderMetric.getTimestamp(), batchLoaderMetric.getFileName(),
                batchLoaderMetric.getFileCreated(), batchLoaderMetric.getFilePickedUp(), batchLoaderMetric.getFileProcessed(),
                batchLoaderMetric.getNumberOfRecords());

        assertThat(created).isTrue();
    }

    @Test
    public void shouldReturnBatchLoaderMetricByTimeStamp() {
        List<BatchLoaderMetric> metrics = new ArrayList();
        Timestamp start = new Timestamp(2022, 8, 4, 0, 0, 0, 0);
        Timestamp end = new Timestamp(2022, 8, 31, 0, 0, 0, 0);
        metrics.add(new BatchLoaderMetric());

        given(service.findBatchLoaderMetrics(start, end)).willReturn(metrics);

        List<BatchLoaderMetric> expected = service.findBatchLoaderMetrics(start, end);

        assertEquals(expected, metrics);
    }
}
