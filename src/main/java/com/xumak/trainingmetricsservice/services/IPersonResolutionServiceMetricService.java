package com.xumak.trainingmetricsservice.services;

import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;

import java.sql.Timestamp;
import java.util.List;

public interface IPersonResolutionServiceMetricService {

    boolean savePersonResolutionMetric(Timestamp timestamp, int individualMatches,
                                                             int houseHoldMatches, int nonMatches,
                                                             int errors, String url);

    List<PersonResolutionServiceMetric> findPersonResolutionMetrics(Timestamp start, Timestamp end);
}
