package com.xumak.trainingmetricsservice.repositories;


import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface PersonResolutionServiceMetricRepository extends JpaRepository<PersonResolutionServiceMetric, Long> {

    List<PersonResolutionServiceMetric> findAllByTimestampBetween(Timestamp startTimeStamp, Timestamp endTimeStamp);
}
