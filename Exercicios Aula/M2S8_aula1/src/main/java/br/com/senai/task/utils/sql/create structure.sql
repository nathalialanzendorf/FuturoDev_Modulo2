CREATE DATABASE task;

DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS contact;

CREATE TABLE contact (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    start_date Timestamp,
    end_date Timestamp,
    status VARCHAR(255),
    priority VARCHAR(255),
    assignee__contact_id INT,
    FOREIGN KEY (assignee__contact_id) REFERENCES contact(id)
);