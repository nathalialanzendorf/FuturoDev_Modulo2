CREATE DATABASE task;

CREATE TABLE contact (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE task (
    id INT PRIMARY KEY,
    description VARCHAR(255),
    start_date Timestamp,
    end_date Timestamp,
    status VARCHAR(255),
    priority VARCHAR(255),
    assignee__contact_id INT
);

ALTER TABLE task
ADD FOREIGN KEY (assignee__contact_id) REFERENCES contact(id);