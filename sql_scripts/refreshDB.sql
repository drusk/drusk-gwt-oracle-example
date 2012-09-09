-- David Rusk
-- V00662179
-- CSC 370
-- Project

-- This script deletes the existing database, recreates the tables and views,
-- then populates them with example data.

@dropDB.sql;
@createDB.sql;
@data_insertion/airlines.sql;
@data_insertion/planemodels.sql;
@data_insertion/airports.sql;
@data_insertion/flights.sql;
@data_insertion/gates.sql;
@data_insertion/flightinstances.sql;
@data_insertion/departures_arrivals.sql;
@data_insertion/citizenships.sql;
@data_insertion/passengers.sql;
@data_insertion/passengerclasses.sql;
@data_insertion/baggage.sql;
@data_insertion/flightattendance.sql;
@data_insertion/flightinventory.sql;