--liquibase formatted sql logicalFilePath:24-07-19-init-test-schema.sql

--changeset lepa-id:base-structure

CREATE TABLE pressure_sensor (
                               id serial unique primary key,
                               serialize_json text
);