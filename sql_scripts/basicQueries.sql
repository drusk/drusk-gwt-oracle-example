-- David Rusk
-- V00662179
-- CSC 370
-- Project

-- Given an airline, find all the flights it operates
-- Input: airlineCode x
-- Output: flightNumbers
SELECT flightNumber
FROM Flights
WHERE airlineCode=x;

-- Given a place, find all the flights from and to that place
-- Input: location x
-- Output: flightNumbers
SELECT flightNumbers
FROM Flights
WHERE source=x OR destination=x;

-- Given a time of the day, find all the arrivals and departures around 
--  that time and print their status
-- Input: time of day x
-- Ouput: flight number and status
-- XXX: the arrival date will probably not be set until they have actually
--  arrived.  Should this use the plannedArrivalTime/plannedDepartureTime?
--  Also it says 'around that time'.  This is not specific enough.  Using 
--  exact time for now until I know what exactly would be an appropriate 
--  time buffer region.
(SELECT flightNumber, status
FROM Arrivals
WHERE arrivalDate=x)
UNION
(SELECT flightNumber, status
FROM Departures
WHERE departureDate=x);

SELECT flightNumber, status
FROM 
((SELECT flightNumber
FROM IncomingFlights
WHERE timeBufferMin < ABS(plannedArrivalTime-targetTime)*1440)
UNION
(SELECT flightNumber
FROM OutgoingFlights
WHERE timeBufferMin < ABS(plannedDepartureTime-targetTime)*1440));


-- Given a departure or arrival find all the passengers recorded for it.
-- Print all the information about these passengers.
-- Input: arrival id x.  Should this be based on arrival date or something else 
--  which is not a surrogate key?
-- Output: all of passengers columns.  Should this include info for subclasses?
SELECT Passengers.id, Passengers.name, Passengers.citizenship, Passengers.placeOfBirth, Passengers.dateOfBirth
FROM Arrivals JOIN ArrivalPassengers ON Arrivals.id=ArrivalPassengers.arrivalId
  JOIN Passengers ON ArrivalPassengers.passengerId=Passengers.id
WHERE Arrivals.id=x;

-- Should both arrivals and departures be check in one query?
SELECT Passengers.id, Passengers.name, Passengers.citizenship, Passengers.placeOfBirth, Passengers.dateOfBirth
FROM Departures JOIN DeparturePassengers ON Departures.id=DeparturePassengers.departureId 
  JOIN Passengers ON DeparturePassengers.passengerId=Passengers.id
WHERE Departures.id=x;

SELECT flightNumber, plannedDepartureTime, OutgoingFlights.status AS departureStatus, plannedArrivalTime, IncomingFlights.status AS arrivalStatus 
FROM IncomingFlights JOIN OutgoingFlights USING(flightId) 
WHERE ? < ABS(plannedDepartureTime-?)*1440 OR ? < ABS(plannedArrivalTime-?)*1440;

SELECT flightNumber, plannedDepartureTime, departureDate, status
FROM OutgoingFlights JOIN FlightInstances USING(flightNumber) JOIN Departures USING(id)
WHERE ? < ABS(plannedDepartureTime-?)*1440;

-- For a given passenger in a flight, find his/her baggage
-- Input: passengerId x, flightNumber y
-- Output: baggage ids plus any other info about the baggage
-- XXX any other details about baggage
SELECT Baggage.id, Baggage.weight
FROM HasBaggage JOIN Baggage ON HasBaggage.baggagedId=Baggage.id
WHERE passengerId=x AND flightNumber=y;
