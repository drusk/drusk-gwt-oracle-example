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
  airlineCode CHAR(2) REFERENCES Airlines(code),
  flightNumber INT,
  source CHAR(3) REFERENCES Airports(airportCode),
  destination CHAR(3) REFERENCES Airports(airportCode),
  planeCode VARCHAR(5) REFERENCES PlaneModels(code),
  plannedDepartureTime TIMESTAMP WITH TIME ZONE,
  plannedArrivalTime TIMESTAMP WITH TIME ZONE, 
  PRIMARY KEY(airlineCode, flightNumber)
);

CREATE TABLE Gates(
  gate VARCHAR(5),
  airportCode CHAR(3) REFERENCES Airports(airportCode),
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
  FOREIGN KEY(airlineCode, flightNumber) REFERENCES Flights(airlineCode, flightNumber)
);

CREATE TABLE Arrivals(
  id INT PRIMARY KEY REFERENCES FlightInstances(id),
  gate VARCHAR(5),
  airportCode CHAR(3),
  arrivalDate TIMESTAMP WITH TIME ZONE,
  status VARCHAR(20),
  FOREIGN KEY(gate, airportCode) REFERENCES Gates(gate, airportCode), 
  CONSTRAINT arrStatFormat CHECK(status LIKE 'arrived at __:__' OR status LIKE 'delayed to __:__')
);

CREATE TABLE Departures(
  id INT PRIMARY KEY REFERENCES FlightInstances(id),
  gate VARCHAR(5),
  airportCode CHAR(3),
  departureDate TIMESTAMP WITH TIME ZONE,
  status VARCHAR(20),
  FOREIGN KEY(gate, airportCode) REFERENCES Gates(gate, airportCode), 
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
  citizenship VARCHAR(255) REFERENCES Citizenships(citizenship),
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
  id INT PRIMARY KEY REFERENCES Passengers(id),
  guardianId INT REFERENCES Passengers(id) NOT NULL
);

CREATE TABLE FlightAttendance(
  passengerId INT REFERENCES Passengers(id),
  flightId INT REFERENCES FlightInstances(id),
  travelClass CHAR(1) REFERENCES PassengerClass(travelClass),
  PRIMARY KEY(passengerId, flightId)
);

CREATE SEQUENCE BaggageIds
  START WITH 1
  INCREMENT BY 1
  CACHE 10;

CREATE TABLE Baggage(
  id INT PRIMARY KEY,
  weight NUMBER
);

CREATE TABLE FlightInventory(
  passengerId INT REFERENCES Passengers(id) NOT NULL,
  flightId INT REFERENCES FlightInstances(id) NOT NULL,
  baggageId INT REFERENCES Baggage(id) NOT NULL,
  PRIMARY KEY(passengerId, flightId, baggageId)
);

CREATE VIEW DelayedFlights AS
  SELECT source, destination, airlineCode, COUNT(id) AS numDelays  
  FROM Flights JOIN FlightInstances USING(airlineCode, flightNumber) JOIN
    Arrivals USING(id)
  WHERE Arrivals.status LIKE 'delayed%'
  GROUP BY source, destination, airlineCode;
