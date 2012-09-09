INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Barnett' AND weight=1.2)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8555 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Barnett' AND weight=1.9)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8555 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Bigboote' AND weight=0.9)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8553 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Camp' AND weight=2.3)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8559 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Camp' AND weight=2.31)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8559 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Camp' AND weight=0.9)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8559 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Careful Walker' AND weight=1.8)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8197 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Chief Crier' AND weight=0.5)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Chief Crier' AND weight=4.3)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Fish' AND weight=3.1)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8557 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Kim Chi' AND weight=2.4)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4401 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Kim Chi' AND weight=3.6)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4401 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Littlejohn' AND weight=1.7)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4403 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Whorfin' AND weight=4.4)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8551 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Rajeesh' AND weight=1.3)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8059 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Rajeesh' AND weight=2.1)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8059 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Rajeesh' AND weight=1.8)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8059 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Smallberries' AND weight=4.2)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Yaya' AND weight=1.6)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1193 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Emdell' AND weight=3.5)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8055 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Parker' AND weight=2.9)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8057 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));
INSERT INTO FlightInventory(baggageId, flightId) VALUES((SELECT id FROM Baggage WHERE ownerID=(SELECT id FROM Passengers WHERE firstName='John' AND lastName='Lithgow' AND weight=2.1)), (SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8061 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')));