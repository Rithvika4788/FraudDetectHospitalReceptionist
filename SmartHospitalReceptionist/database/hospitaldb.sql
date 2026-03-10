CREATE DATABASE IF NOT EXISTS hospitaldb;
USE hospitaldb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users (username, password) VALUES ('admin', 'admin123');

CREATE TABLE claims (
    claim_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50),
    policy_no VARCHAR(50),
    claim_amount DOUBLE,
    diagnosis VARCHAR(100),
    status VARCHAR(50),
    fraud_score DOUBLE
);
