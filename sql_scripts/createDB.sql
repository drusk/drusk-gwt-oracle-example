-- David Rusk
-- V00662179
-- CSC 370
-- Project

CREATE TABLE Airlines(
  name VARCHAR(255),
  code CHAR(2) PRIMARY KEY,
  website VARCHAR(255)
);

CREATE TABLE PlaneModels(
  code VARCHAR(5) PRIMARY KEY,
  name VARCHAR(32),
  capacity INT
);

CREATE TABLE Airports(
  airportCode CHAR(3) PRIMARY KEY,
  city VARCHAR(255),
  country VARCHAR(255),
  utcOffset VARCHAR(6)
);

CREATE TABLE Flights(
  airlineCode CHAR(2) REFERENCES Airlines(code)
    ON DELETE CASCADE,
  flightNumber INT,
  source CHAR(3) REFERENCES Airports(airportCode)
    ON DELETE CASCADE,
  destination CHAR(3) REFERENCES Airports(airportCode)
    ON DELETE CASCADE,
  planeCode VARCHAR(5) REFERENCES PlaneModels(code)
    ON DELETE CASCADE,
  plannedDepartureTime TIMESTAMP WITH TIME ZONE,
  plannedArrivalTime TIMESTAMP WITH TIME ZONE, 
  PRIMARY KEY(airlineCode, flightNumber)
);

CREATE TABLE Gates(
  gate VARCHAR(5),
  airportCode CHAR(3) REFERENCES Airports(airportCode)
    ON DELETE CASCADE,
  PRIMARY KEY(gate, airportCode)
);

CREATE SEQUENCE FlightInstanceIds
  START WITH 1
  INCREMENT BY 1
  CACHE 10;

CREATE TABLE FlightInstances(
  id INT PRIMARY KEY,
  airlineCode CHAR(2),  
  flightNumber INT,
  flightDate DATE,
  FOREIGN KEY(airlineCode, flightNumber) REFERENCES Flights(airlineCode, flightNumber)
    ON DELETE CASCADE
);

CREATE TABLE Arrivals(
  id INT PRIMARY KEY REFERENCES FlightInstances(id)
    ON DELETE CASCADE,
  gate VARCHAR(5),
  airportCode CHAR(3),
  arrivalDate TIMESTAMP WITH TIME ZONE,
  status VARCHAR(20),
  FOREIGN KEY(gate, airportCode) REFERENCES Gates(gate, airportCode)
    ON DELETE CASCADE, 
  CONSTRAINT arrStatFormat CHECK(status LIKE 'arrived at __:__' OR status LIKE 'delayed to __:__')
);

CREATE TABLE Departures(
  id INT PRIMARY KEY REFERENCES FlightInstances(id)
    ON DELETE CASCADE,
  gate VARCHAR(5),
  airportCode CHAR(3),
  departureDate TIMESTAMP WITH TIME ZONE,
  status VARCHAR(20),
  FOREIGN KEY(gate, airportCode) REFERENCES Gates(gate, airportCode)
    ON DELETE CASCADE, 
  CONSTRAINT depStatFormat CHECK(status LIKE 'departed at __:__' OR status LIKE 'delayed to __:__')
);

CREATE TABLE Citizenships(
  citizenship VARCHAR(255) PRIMARY KEY
);

CREATE SEQUENCE PassengerIds
  START WITH 1
  INCREMENT BY 1
  CACHE 10;

CREATE TABLE Passengers(
  id INT PRIMARY KEY,
  firstName VARCHAR(255),
  lastName VARCHAR(255),
  citizenship VARCHAR(255) REFERENCES Citizenships(citizenship)
    ON DELETE CASCADE,
  placeOfBirth VARCHAR(255),
  dateOfBirth DATE,
  dietaryRestrictions VARCHAR(255) DEFAULT NULL,
  medicalConsiderations VARCHAR(255) DEFAULT NULL,
  isAirlineEmployee CHAR(1) DEFAULT 'n' CHECK(isAirlineEmployee IN ('y', 'n')),
  isDoctor CHAR(1) DEFAULT 'n' CHECK(isDoctor IN ('y', 'n')),
  isInfant CHAR(1) DEFAULT 'n' CHECK(isInfant IN ('y', 'n'))
);

CREATE TABLE PassengerClass(
  travelClass CHAR(1) PRIMARY KEY,
  includesMeal CHAR(1) DEFAULT 'n' CHECK(includesMeal IN ('y', 'n'))
);

CREATE TABLE Infants(
  id INT PRIMARY KEY,
  guardianId INT NOT NULL,
  FOREIGN KEY(id) REFERENCES Passengers(id)
    ON DELETE CASCADE,
  FOREIGN KEY(guardianId) REFERENCES Passengers(id)
    ON DELETE CASCADE
);

CREATE TABLE FlightAttendance(
  passengerId INT REFERENCES Passengers(id)
    ON DELETE CASCADE,
  flightId INT REFERENCES FlightInstances(id)
    ON DELETE CASCADE,
  travelClass CHAR(1) REFERENCES PassengerClass(travelClass)
    ON DELETE CASCADE,
  PRIMARY KEY(passengerId, flightId)
);

CREATE SEQUENCE BaggageIds
  START WITH 1
  INCREMENT BY 1
  CACHE 10;

CREATE TABLE Baggage(
  id INT PRIMARY KEY,
  ownerId INT REFERENCES Passengers(id)
    ON DELETE CASCADE,
  weight NUMBER
);

CREATE TABLE FlightInventory(
  flightId INT REFERENCES FlightInstances(id)
    ON DELETE CASCADE,
  baggageId INT REFERENCES Baggage(id)
    ON DELETE CASCADE,
  PRIMARY KEY(flightId, baggageId)
);

CREATE VIEW DelayedFlights AS
  SELECT source, destination, airlineCode, COUNT(id) AS numDelays  
  FROM Flights JOIN FlightInstances USING(airlineCode, flightNumber) JOIN
    Arrivals USING(id)
  WHERE Arrivals.status LIKE 'delayed%'
  GROUP BY source, destination, airlineCode;
