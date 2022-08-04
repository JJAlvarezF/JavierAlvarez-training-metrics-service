package com.xumak.trainingmetricsservice;

import com.xumak.trainingmetricsservice.entities.PersonResolutionServiceMetric;
import com.xumak.trainingmetricsservice.repositories.PersonResolutionServiceMetricRepository;
import com.xumak.trainingmetricsservice.services.PersonResolutionServiceMetricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
public class PersonResolutionMetricTest {

    @InjectMocks
    PersonResolutionServiceMetricService service;

    @Mock
    PersonResolutionServiceMetricRepository repository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenSavePersonResolutionMetric_shouldReturnTrue() {
        PersonResolutionServiceMetric personResolutionServiceMetric = PersonResolutionServiceMetric.builder()
                .timestamp(new Timestamp(2022, 8, 4, 0, 0, 0, 0))
                .individualMatches(1)
                .householdMatches(1)
                .nonMatches(1)
                .errors(1)
                .url("http://localhost")
                .build();

        boolean created = service.savePersonResolutionMetric(personResolutionServiceMetric.getTimestamp(), personResolutionServiceMetric.getIndividualMatches(),
                personResolutionServiceMetric.getHouseholdMatches(), personResolutionServiceMetric.getNonMatches(),
                personResolutionServiceMetric.getErrors(), personResolutionServiceMetric.getUrl());

        assertThat(created).isTrue();
    }

    @Test
    public void shouldReturnPersonResolutionMetricsByTimeStamp() {
        List<PersonResolutionServiceMetric> metrics = new ArrayList();
        Timestamp start = new Timestamp(2022, 8, 4, 0, 0, 0, 0);
        Timestamp end = new Timestamp(2022, 8, 31, 0, 0, 0, 0);
        metrics.add(new PersonResolutionServiceMetric());

        given(service.findPersonResolutionMetrics(start, end)).willReturn(metrics);

        List<PersonResolutionServiceMetric> expected = service.findPersonResolutionMetrics(start, end);

        assertEquals(expected, metrics);
    }
}
