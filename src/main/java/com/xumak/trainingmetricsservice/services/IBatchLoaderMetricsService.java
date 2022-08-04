package com.xumak.trainingmetricsservice.services;

import com.xumak.trainingmetricsservice.entities.BatchLoaderMetric;

import java.sql.Timestamp;
import java.util.List;

public interface IBatchLoaderMetricsService {

    boolean saveBatchLoaderMetric(Timestamp timestamp, String filename, Timestamp fileCreated,
                                            Timestamp filePickedUp, Timestamp fileProcessed, int numberOfRecords);

    List<BatchLoaderMetric> findBatchLoaderMetrics(Timestamp start, Timestamp end);
}
