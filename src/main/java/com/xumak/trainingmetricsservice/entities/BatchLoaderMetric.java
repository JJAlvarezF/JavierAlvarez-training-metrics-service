package com.xumak.trainingmetricsservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchLoaderMetric {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private Timestamp timestamp;
    private String fileName;
    private Timestamp fileCreated;
    private Timestamp filePickedUp;
    private Timestamp fileProcessed;
    private int numberOfRecords;
}
