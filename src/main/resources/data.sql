-- Dodawanie adresów
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'ul. Żółta 11', 'apt. 15', 'Zamość', '20-104'),
    (2, 'ul. Wilcza 146', NULL, 'Kurpatka', '66-333'),
    (3, 'ul. Roga 7', NULL, 'Cieszyn', '21-122'),
    (4, 'ul. Kamienna 1', NULL, 'Warszawa', '01-122'),
    (5, 'ul. Zielna 9', NULL, 'Cieszyn', '20-122'),
    (6, 'ul. Polna 1', NULL, 'Warszawa', '02-123');


-- Dodawanie lekarzy
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES
    (1, 'Dominik', 'Romonewski', '777466728', 'dominik222@gmail.com', 'C122', 'DERMATOLOGIST',4),
    (2, 'Roksana', 'Kalczyńska', '543217888', 'soskalczynska@gmail.com', 'A666', 'OCULIST',3);

-- Dodawanie pacjentów
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, field1)
VALUES
    (1, 'Marika', 'Fiodrowa', '122233311', 'marika@example.com', 'P123', '1975-03-14', 1, 'ABC'),
    (2, 'Arnold', 'Cichy', '4666777777', 'cichy@kryptonim.com', 'A666', '1994-05-22', 2, 'xyz'),
    (3, 'Anna', 'Wigura', '4477666', 'anna.wigura@gmail.com', '666333', '1991-09-11', 5, 'Xyzab'),
    (4, 'Artur', 'Egart', '98544327', 'artur.egart@gmail.com', 'BB66', '1990-04-12', 6, '1234');

--  Wizyty
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (1, 'Badanie ogólne', '2022-07-23 10:00:00', 1, 1),
    (2, 'Szczepienie', '2023-04-19 10:10:00', 2, 2),
    (3, 'Wizyta 10', '2023-05-19 08:30:00', 2, 2),
    (4, 'Wizyta 11', '2023-05-19 09:30:00', 3, 2),
    (5, 'Wizyta 12', '2023-05-19 10:30:00', 3, 2),
    (6, 'Wizyta 13', '2023-05-19 11:30:00', 3, 2),
    (7, 'Wizyta 14', '2023-05-19 12:30:00', 4, 1);

-- Dodawanie zdarzenia medycznego
INSERT INTO MEDICAL_TREATMENT (id, description, type, VISIT_ID)
VALUES
    (1, 'Szczepienie ', 'EKG', 1),
    (2, 'Badanie krwi ', 'USG', 2),
    (3, 'Badanie moczu ', 'EKG', 2),
    (4, 'Leczenie 10 ', 'RTG', 2),
    (5, 'Leczenie 11 ', 'EKG', 2),
    (6, 'Leczenie 12 ', 'USG', 2),
    (7, 'Leczenie 13 ', 'RTG', 3),
    (8, 'Leczenie 14 ', 'EKG', 3),
    (9, 'Leczenie 15 ', 'USG', 3),
    (10, 'Leczenie 16 ', 'RTG', 4),
    (11, 'Leczenie 17 ', 'EKG', 5),
    (12, 'Leczenie 18 ', 'USG', 6),
    (13, 'Leczenie 19 ', 'RTG', 7),
    (14, 'Leczenie 20 ', 'EKG', 7),
    (15, 'Leczenie 21 ', 'USG', 7);