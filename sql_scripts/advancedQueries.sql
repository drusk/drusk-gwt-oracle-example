-- David Rusk
-- V00662179
-- CSC 370
-- Project

-- List all the connecting flights.  That is, pairs (f1, f2) of incoming-outgoing 
--  flights such that the scheduled arrival time of f1 is not more than 3 hours 
--  earlier than the scheduled departure time of f2.
SELECT F1.flightNumber, F2.flightNumber
FROM Flights JOIN IncomingFlights USING(flightNumber) F1, 
  Flights JOIN OutgingFlights USING(flightNumber) F2
WHERE F1.destination=F2.source AND 
  F2.plannedDepartureTime-F1.plannedArrivalTime < 3; -- XXX this is unlikely to be 
							-- syntactically correct

SELECT F1.flightNumber AS f1, F2.flightNumber AS f2 
FROM (SELECT * FROM Flights JOIN IncomingFlights USING(flightNumber)) F1, 
  (SELECT * FROM Flights JOIN OutgoingFlights USING(flightNumber)) F2 
WHERE F1.destination=F2.source AND 
  F2.plannedDepartureTime>F1.plannedArrivalTime AND 
  (F2.plannedDepartureTime-F1.plannedArrivalTime)*1440 < 180;
  

-- Find all the passengers in transit.
-- Input: none
-- Output: passenger id, name, etc.
-- find passengers who departed on a flight number but have not arrived yet
SELECT Passengers.id, Passengers.firstName, Passengers.lastName
FROM (SELECT passengerId
       FROM FlightAttendance JOIN 
         (SELECT id
           FROM FlightInstances JOIN Departures USING(id) LEFT OUTER JOIN 
             Arrivals USING(id)
           WHERE departureDate IS NOT NULL AND
             arrivalDate IS NULL) R
       ON FlightAttendance.flightId=R.id) S
JOIN Passengers ON Passengers.id=S.passengerId;  

-- List the top three passengers with respect to the number of flights they have taken.
-- Input: none
-- Output: passenger id, name, etc.
SELECT * FROM (
  SELECT passengerId, firstName, lastName, numberOfFlights FROM 
   (SELECT passengerId, COUNT(flightId) AS numberOfFlights
     FROM FlightAttendance 
     GROUP BY passengerId) R 
   JOIN Passengers ON R.passengerId=Passengers.id 
   ORDER BY numberOfFlights DESC)
WHERE ROWNUM <= 3;

-- For each (from, to) route, find the airline with the most delays.
CREATE VIEW DelayedFlights AS
  SELECT source, destination, airlineCode, COUNT(id) AS numDelays  
  FROM Flights JOIN FlightInstances USING(flightNumber) JOIN
    Arrivals USING(id) JOIN Departures USING(id)
  WHERE Arrivals.status LIKE 'delayed%' OR 
    Departures.status LIKE 'delayed%'
  GROUP BY source, destination, airlineCode;

SELECT source, destination, airlineCode, numDelays
FROM DelayedFlights R
WHERE numDelays=(
  SELECT MAX(numDelays)
  FROM DelayedFlights S
  WHERE R.source=S.source AND
    R.destination=S.destination
);
