package com.xumak.trainingmetricsservice.services;

import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;
import com.xumak.trainingmetricsservice.repositories.PersonResolutionServiceMetricRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PersonResolutionServiceMetricService implements IPersonResolutionServiceMetricService {

    private final PersonResolutionServiceMetricRepository repository;


    @Override
    public boolean savePersonResolutionMetric(Timestamp timestamp, int individualMatches,
                                                                    int houseHoldMatches, int nonMatches,
                                                                    int errors, String url) {
        try {
            repository.save(PersonResolutionServiceMetric.builder()
                    .timestamp(timestamp)
                    .individualMatches(individualMatches)
                    .householdMatches(houseHoldMatches)
                    .nonMatches(nonMatches)
                    .errors(errors)
                    .url(url)
                    .build());
            return true;
        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
            return false;
        }
    }

    @Override
    public List<PersonResolutionServiceMetric> findPersonResolutionMetrics(Timestamp start, Timestamp end) {
        return repository.findAllByTimestampBetween(start, end);
    }
}
