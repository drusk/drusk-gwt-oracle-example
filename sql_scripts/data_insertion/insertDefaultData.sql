INSERT INTO Airlines(name, code, website) 
  VALUES('Air Canada', 'AC', 'www.aircanada.ca');
INSERT INTO Airlines(name, code, website) 
  VALUES('Air France', 'AF', 'www.airfrance.com');
INSERT INTO Airlines(name, code, website) 
  VALUES('Air India', 'AI', 'www.airindia.com');
INSERT INTO Airlines(name, code, website) 
  VALUES('American Airlines', 'AA', 'www.aa.com/content/travelInformation/baggage/generalInfo.jhtml');
INSERT INTO Airlines(name, code, website) 
  VALUES('WestJet', 'WS', 'www.westjet.com');
INSERT INTO Airlines(name, code, website) 
  VALUES('United Airlines', 'UA', 'www.ual.com');
INSERT INTO Airlines(name, code, website) 
  VALUES('British Airways', 'BA', 'www.britishairways.com');

INSERT INTO Citizenships(citizenship) VALUES('Canadian');
INSERT INTO Citizenships(citizenship) VALUES('American');
INSERT INTO Citizenships(citizenship) VALUES('British');
INSERT INTO Citizenships(citizenship) VALUES('French');
INSERT INTO Citizenships(citizenship) VALUES('German');
INSERT INTO Citizenships(citizenship) VALUES('Chinese');
INSERT INTO Citizenships(citizenship) VALUES('Japanese');
INSERT INTO Citizenships(citizenship) VALUES('Indian');

INSERT INTO Airports(airportCode, city, country, utcOffset) 
  VALUES('YYJ', 'Victoria', 'Canada', -8);
INSERT INTO Airports(airportCode, city, country, utcOffset) 
  VALUES('YVR', 'Vancouver', 'Canada', -8);
INSERT INTO Airports(airportCode, city, country, utcOffset) 
  VALUES('YTZ', 'Toronto', 'Canada', -5);

INSERT INTO Gates(gate, airportCode) VALUES('A10', 'YYJ');
INSERT INTO Gates(gate, airportCode) VALUES('B12', 'YVR');

INSERT INTO PlaneModels(code, capacity) VALUES(747, 250);

-- INSERT INTO Flights(flightNumber, source, destination, airlineCode, planeCode) VALUES(111, 'YYJ', 'YVR', 'AC', 747);
