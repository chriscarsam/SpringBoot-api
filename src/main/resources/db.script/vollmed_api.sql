CREATE DATABASE IF NOT EXISTS vollmed_api;
USE vollmed_api;

SELECT *FROM doctors;
SELECT *FROM patients;

INSERT INTO users VALUES(login, password),("user.test", "$2y$10$86/mbQVVCzkQnE.YyQDbZ.id1baAFpsgu8HIoOtBfPWJCegWiECnO");