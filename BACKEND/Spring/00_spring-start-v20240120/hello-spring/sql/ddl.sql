CREATE DATABASE IF NOT EXISTS spring;
USE spring;

DROP TABLE IF EXISTS member;

CREATE TABLE IF NOT EXISTS member (
id BIGINT AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY (id)
);

INSERT INTO member (name) VALUES ('spring');

SELECT * FROM member;