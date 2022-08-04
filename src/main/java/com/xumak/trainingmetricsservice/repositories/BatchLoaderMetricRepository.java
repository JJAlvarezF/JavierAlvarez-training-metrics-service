package com.xumak.trainingmetricsservice.repositories;

import com.xumak.trainingmetricsservice.entities.BatchLoaderMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface BatchLoaderMetricRepository extends JpaRepository<BatchLoaderMetric, Long> {

    List<BatchLoaderMetric> findAllByTimestampBetween(Timestamp startTimeStamp, Timestamp endTimeStamp);
}
