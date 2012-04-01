-- CREATE TABLE Passengers(
--   id INT PRIMARY KEY,
--   firstName VARCHAR(255),
--   lastName VARCHAR(255),
--   citizenship VARCHAR(255) REFERENCES Citizenships(citizenship),
--   placeOfBirth VARCHAR(255),
--   dateOfBirth DATE,
--   dietaryRestrictions VARCHAR(255) DEFAULT NULL,
--   medicalConsiderations VARCHAR(255) DEFAULT NULL,
--   isAirlineEmployee CHAR(1) DEFAULT 'n' CHECK(isAirlineEmployee IN ('y', 'n')),
--   isDoctor CHAR(1) DEFAULT 'n' CHECK(isDoctor IN ('y', 'n')),
--   isInfant CHAR(1) DEFAULT 'n' CHECK(isInfant IN ('y', 'n'))
-- );
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Barnett', 'Iranian', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Bigboote', 'Italian', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,'Gout','n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Camp', 'British', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','y','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Careful Walker', 'Korean', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Chief Crier', 'Irish', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Fish', 'Dutch', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Kim Chi', 'Korean', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Littlejohn', 'British', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Rajeesh', 'Indian', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Smallberries', 'Canadian', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,'Allergic to Strawberries','n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Whorfin', 'United States', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Yaya', 'Polish', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Emdell', 'Hungarian', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Parker', 'British', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1918','MON DD, YYYY'),null,null,'n','n','n');
INSERT INTO Passengers VALUES(PassengerIds.nextval,'John', 'Lithgow', 'United States', 'Grover''s Mill, New Jersey',TO_DATE('Nov 01, 1948','MON DD, YYYY'),null,null,'n','y','n');
