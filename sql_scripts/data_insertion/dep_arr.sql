INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8551 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YYC', TO_TIMESTAMP_TZ('May 15, 2012 07:40 -07:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 07:40');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8551 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 08:09 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 08:09');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8553 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A2', 'YYC', TO_TIMESTAMP_TZ('May 15, 2012 11:25 -07:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 11:25');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8553 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 11:54 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 11:54');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8555 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A2', 'YYC', TO_TIMESTAMP_TZ('May 15, 2012 16:25 -07:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 16:25');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8555 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 16:54 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 16:54');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8559 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A2', 'YYC', TO_TIMESTAMP_TZ('May 15, 2012 18:45 -07:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 18:45');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8559 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 19:14 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 19:14');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8197 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YKA', TO_TIMESTAMP_TZ('May 15, 2012 17:15 -07:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 17:15');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8197 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 19:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 19:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YOW', TO_TIMESTAMP_TZ('May 15, 2012 07:00 -05:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 07:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 10:56 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 10:56');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8557 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YXE', TO_TIMESTAMP_TZ('May 15, 2012 16:50 -06:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 16:50');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8557 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 19:14 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 19:14');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4401 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'SFO', TO_TIMESTAMP_TZ('May 15, 2012 10:33 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 10:33');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4401 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 12:50 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 12:50');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4403 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'SFO', TO_TIMESTAMP_TZ('May 15, 2012 19:46 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 19:46');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=4403 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 22:03 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 22:03');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8059 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YXT', TO_TIMESTAMP_TZ('May 15, 2012 06:25 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 06:25');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8059 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 09:23 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 09:23');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A8', 'YYZ', TO_TIMESTAMP_TZ('May 15, 2012 18:05 -05:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 18:05');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=191 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 20:09 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 20:09');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1193 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A8', 'YYZ', TO_TIMESTAMP_TZ('May 15, 2012 20:55 -05:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 20:55');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=1193 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 23:06 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 23:06');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8055 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 07:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 07:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8055 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 07:24 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 07:24');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8057 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 08:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 08:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8057 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 08:24 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 08:24');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8061 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 10:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 10:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8061 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 10:23 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 10:23');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8063 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 11:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 11:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8063 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 11:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 11:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8051 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 11:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 11:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8051 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 11:53 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 11:53');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8065 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 12:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 12:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8065 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 12:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 12:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8085 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 12:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 12:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8085 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 12:53 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 12:53');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8067 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 13:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 13:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8067 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 13:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 13:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8053 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 13:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 13:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8053 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 13:52 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 13:52');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8069 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 14:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 14:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8069 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 14:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 14:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8071 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 15:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 15:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8071 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 15:23 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 15:23');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8161 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 15:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 15:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8161 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 15:53 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 15:53');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8073 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 16:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 16:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8073 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 16:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 16:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8091 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 16:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 16:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8091 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 16:52 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 16:52');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8075 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 17:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 17:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8075 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 17:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 17:20');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8077 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 18:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 18:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8077 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 18:22 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 18:22');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8079 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 19:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 19:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8079 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 19:21 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 19:21');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8081 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 20:00 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 20:00');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8081 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 20:21 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 20:21');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8083 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 22:20 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 22:20');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8083 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 22:43 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 22:43');
INSERT INTO Departures VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8087 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), 'A1', 'YVR', TO_TIMESTAMP_TZ('May 15, 2012 23:30 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'departed at 23:30');
INSERT INTO Arrivals VALUES((SELECT id FROM FlightInstances WHERE airlineCode='AC' AND flightNumber=8087 AND flightDate=TO_DATE('May 15, 2012', 'MON DD, YYYY')), '1', 'YYJ', TO_TIMESTAMP_TZ('May 15, 2012 23:53 -08:00', 'MON DD, YYYY HH24:MI TZH:TZM'), 'arrived at 23:53');