package com.xumak.trainingmetricsservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResolutionServiceMetric {

    private @Id @GeneratedValue Long id;
    private Timestamp timestamp;
    private int individualMatches;
    private int householdMatches;
    private int nonMatches;
    private int errors;
    private String url;
}
