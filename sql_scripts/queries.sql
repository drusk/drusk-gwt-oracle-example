-- David Rusk
-- V00662179
-- CSC 370
-- Project

-- This file contains the main queries implemented for this project.

-- 4. a) Given an airline find all the flights it operates
-- Input: p1->the airline code for the airline in question
SELECT flightNumber, source, destination 
FROM Flights 
WHERE airlineCode=p1;

-- 4. b) Given a place, find all the flights from and to that place.
-- Input: p1->the airport code of the place to find flights for (city names are not unique)
SELECT airlineCode, flightNumber, source, destination 
FROM Flights 
WHERE source=p1 OR destination=p1;

-- 4. c) Given a time of the day find all the arrivals and departures around that time
--         and print their status.

-- Inputs: p1->the airport code of the airport whose arrivals and departures will be searched
--         p2->the time of day to search around.  It gets specified in HH24:MI format, and 
--               a default day is used since Oracle does not have the TIME SQL type separate from DATE.
--               The time zone offset information is looked up from the Airports table since we have the airport code.
--         p3->the buffer time (in minutes) around the specified time in which results may be found.
--               This is needed because the specification was just 'around that time' which is not precise enough.

-- Done in two queries (one for arrivals, one for departures)
-- Query for departures:
SELECT flightNumber, TO_CHAR(plannedDepartureTime, 'HH24:MI') AS scheduledDeparture, departureDate, status 
FROM Flights JOIN FlightInstances USING(flightNumber) JOIN Departures USING(id) 
WHERE airportCode=p1 AND 
  TO_TIMESTAMP_TZ(p2, 'MON DD, YYYY HH24:MI TZH:TZM') BETWEEN 
  (plannedDepartureTime - interval p3 minute) AND (plannedDepartureTime + interval p3 minute);
  
-- Query for arrivals:
SELECT flightNumber, TO_CHAR(plannedArrivalTime, 'HH24:MI') AS scheduledArrival, arrivalDate, status 
FROM Flights JOIN FlightInstances USING(flightNumber) JOIN Arrivals USING(id) 
WHERE airportCode=p1 AND 
  TO_TIMESTAMP_TZ(p2, 'MON DD, YYYY HH24:MI TZH:TZM') BETWEEN 
  (plannedArrivalTime - interval p3 minute) AND (plannedArrivalTime + interval p3 minute);
  

-- 4. d) Given a departure or arrival find all the passengers recorded for it.  Print all the information
--         about these passengers.
-- Input: p1->the flight instance id for the departure or arrival of interest.
SELECT Passengers.id, travelClass, firstName, lastName, citizenship, placeOfBirth, 
  TO_CHAR(dateOfBirth, 'MON DD, YYYY') AS dateOfBirth, dietaryRestrictions, 
  medicalConsiderations, isAirlineEmployee, isDoctor, isInfant 
FROM FlightAttendance JOIN Passengers ON FlightAttendance.passengerId=Passengers.id 
WHERE flightId=p1;

-- 4. e) For a given passenger in a flight find his/her baggage.
-- Inputs: p1->the passengers' id
--         p2->the flight instance id
SELECT Baggage.id, ownerId, weight 
FROM FlightInventory JOIN Baggage ON Baggage.id=FlightInventory.baggageId 
WHERE ownerId=p1 AND flightId=p2;

-- 5. a) List all the connecting flights, i.e. pairs (f1, f2) of incoming-outgoing
--        flights such that the scheduled arrival time of f1 is not more than 
--        3 hours earlier than the scheduled departure time of f2.
-- Inputs: p1->
--         p2->
SELECT R1.airlineCode AS f1_airlineCode, R1.flightNumber AS f1_flightNumber, 
  R2.airlineCode AS f2_airlineCode, R2.flightNumber AS f2_flightNumber 
FROM Flights R1, Flights R2 
WHERE R1.destination=R2.source AND 
  R1.destination='YYJ' AND 
  R2.plannedDepartureTime>R1.plannedArrivalTime 
  AND R2.plannedDepartureTime<(R1.plannedArrivalTime + INTERVAL '180' MINUTE);

-- 5. b) Find all the passengers in transit.
SELECT Passengers.id, Passengers.firstName, Passengers.lastName 
FROM (
  SELECT passengerId 
  FROM FlightAttendance JOIN 
    (SELECT id 
     FROM FlightInstances JOIN Departures USING(id) 
       LEFT OUTER JOIN Arrivals USING(id) 
     WHERE departureDate IS NOT NULL AND arrivalDate IS NULL) R 
    ON FlightAttendance.flightId=R.id) S 
  JOIN Passengers ON Passengers.id=S.passengerId;
  
-- 5. c) List the top 3 passengers with respect to the number of flights they 
--         have taken.
-- Input: p1->the number of passengers to show, i.e. top n.  Can specify 3 to 
--              get the value requested in the problem.  
SELECT * 
FROM (
  SELECT passengerId, firstName, lastName, numberOfFlights 
  FROM 
    (SELECT passengerId, COUNT(flightId) AS numberOfFlights 
       FROM FlightAttendance GROUP BY passengerId) R 
    JOIN Passengers ON R.passengerId=Passengers.id 
  ORDER BY numberOfFlights DESC) 
WHERE ROWNUM <= p1;  
    
-- 5. d) For each (from, to) route, find the airline with the most delays.
CREATE VIEW DelayedFlights AS
  SELECT source, destination, airlineCode, COUNT(id) AS numDelays  
  FROM Flights JOIN FlightInstances USING(airlineCode, flightNumber) JOIN
    Arrivals USING(id)
  WHERE Arrivals.status LIKE 'delayed%'
  GROUP BY source, destination, airlineCode;
  
SELECT source, destination, airlineCode, numDelays 
FROM DelayedFlights R 
WHERE numDelays=(
  SELECT MAX(numDelays) 
  FROM DelayedFlights S 
  WHERE R.source=S.source AND 
    R.destination=S.destination
);
