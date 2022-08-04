CREATE TABLE person_resolution_service_metric
(
    id                 BIGINT  NOT NULL,
    timestamp          TIMESTAMP WITHOUT TIME ZONE,
    individual_matches INTEGER NOT NULL,
    household_matches  INTEGER NOT NULL,
    non_matches        INTEGER NOT NULL,
    errors             INTEGER NOT NULL,
    url                VARCHAR(255),
    CONSTRAINT pk_personresolutionservicemetric PRIMARY KEY (id)
);

CREATE TABLE batch_loader_metric
(
    id                BIGINT  NOT NULL,
    timestamp         TIMESTAMP WITHOUT TIME ZONE,
    file_name         VARCHAR(255),
    file_created      TIMESTAMP WITHOUT TIME ZONE,
    file_picked_up    TIMESTAMP WITHOUT TIME ZONE,
    file_processed    TIMESTAMP WITHOUT TIME ZONE,
    number_of_records INTEGER NOT NULL,
    CONSTRAINT pk_batchloadermetric PRIMARY KEY (id)
);