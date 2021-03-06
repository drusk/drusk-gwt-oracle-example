-- CREATE TABLE Flights(
--  airlineCode CHAR(2) REFERENCES Airlines(code),
--  flightNumber INT,
--  source CHAR(3) REFERENCES Airports(airportCode),
--  destination CHAR(3) REFERENCES Airports(airportCode),
--  planeCode VARCHAR(5) REFERENCES PlaneModels(code),
--  plannedArrivalTime TIMESTAMP WITH TIME ZONE, 
--  plannedDepartureTime TIMESTAMP WITH TIME ZONE,
--  PRIMARY KEY(airlineCode, flightNumber)
-- );
-- Air Canada Flights
INSERT INTO Flights VALUES ('AC',8551,'YYC','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 07:40 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:09 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8553,'YYC','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 11:25 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:54 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8555,'YYC','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 16:25 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:54 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8559,'YYC','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 18:45 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:14 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8197,'YKA','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 17:15 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',1191,'YOW','YYJ','E90',TO_TIMESTAMP_TZ('Jan 15, 1980 07:00 -05:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:56 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8557,'YXE','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 16:50 -06:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:14 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',4401,'SFO','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 10:33 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:50 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',4403,'SFO','YYJ','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 19:46 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 22:03 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8059,'YXT','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 06:25 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 09:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',191,'YYZ','YYJ','A319',TO_TIMESTAMP_TZ('Jan 15, 1980 18:05 -05:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 20:09 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',1193,'YYZ','YYJ','E90',TO_TIMESTAMP_TZ('Jan 15, 1980 20:55 -05:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 23:06 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8055,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 07:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 07:24 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8057,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 08:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:24 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8061,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 10:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8063,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 11:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8051,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 11:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8065,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 12:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8085,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 12:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8067,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 13:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 13:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8053,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 13:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 13:52 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8069,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 14:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8071,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 15:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 15:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8161,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 15:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 15:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8073,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 16:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8091,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 16:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:52 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8075,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 17:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 17:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8077,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 18:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 18:22 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8079,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 19:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:21 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8081,'YVR','YYJ','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 20:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 20:21 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8083,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 22:20 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 22:43 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8087,'YVR','YYJ','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 23:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 23:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8552,'YYJ','YYC','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 08:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:45 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8554,'YYJ','YYC','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 12:25 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:45 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8558,'YYJ','YYC','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 20:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 23:00 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8178,'YYJ','YKA','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 15:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:51 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',4400,'YYJ','SFO','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 06:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 09:06 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',4402,'YYJ','SFO','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 13:21 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 15:34 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8556,'YYJ','YXE','BCRJ',TO_TIMESTAMP_TZ('Jan 15, 1980 15:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:12 -06:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',190,'YYJ','YYZ','A319',TO_TIMESTAMP_TZ('Jan 15, 1980 06:45 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:10 -05:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',1186,'YYJ','YYZ','E90',TO_TIMESTAMP_TZ('Jan 15, 1980 12:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:23 -05:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',1192,'YYJ','YYZ','E90',TO_TIMESTAMP_TZ('Jan 15, 1980 23:50 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 16, 1980 07:13 -05:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8050,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 05:25 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 05:48 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8054,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 07:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 07:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8056,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 08:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8058,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 09:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 09:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8060,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 10:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8062,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 11:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8064,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 12:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8052,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 12:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8174,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 12:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8066,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 13:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 13:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8068,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 14:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8084,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 14:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8070,'YYJ','YVR','BDH1',TO_TIMESTAMP_TZ('Jan 15, 1980 15:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 15:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8072,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 16:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8086,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 16:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:53 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8074,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 17:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 17:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8076,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 18:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 18:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8078,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 19:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AC',8080,'YYJ','YVR','BDH3',TO_TIMESTAMP_TZ('Jan 15, 1980 20:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 20:23 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',354,'YYJ','YYC','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 07:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 09:19 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',196,'YYJ','YYC','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 12:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 14:59 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',502,'YYJ','YYC','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 18:10 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 20:29 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',508,'YYJ','YYC','B738',TO_TIMESTAMP_TZ('Jan 15, 1980 20:10 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 22:29 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',614,'YYJ','YEG','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 09:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:28 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',336,'YYJ','YEG','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 14:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:28 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',192,'YYJ','YEG','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 19:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 21:58 -07:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',312,'YYJ','YLW','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 09:15 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:13 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',650,'YYJ','YYZ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 11:35 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:00 -05:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',197,'YLW','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 18:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 18:55 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',546,'YYZ','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 08:45 -05:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 10:51 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',413,'YEG','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 08:05 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',335,'YEG','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 11:30 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 12:05 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',615,'YEG','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 17:00 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 17:35 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',209,'YYC','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 08:00 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:27 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',449,'YYC','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 12:50 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 13:17 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',221,'YYC','YYJ','B738',TO_TIMESTAMP_TZ('Jan 15, 1980 19:05 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:32 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('WS',751,'YYC','YYJ','B737',TO_TIMESTAMP_TZ('Jan 15, 1980 22:30 -07:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 22:57 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2381,'YYJ','SEA','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 06:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 06:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2383,'YYJ','SEA','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 09:05 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 09:45 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2385,'YYJ','SEA','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 12:20 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 13:01 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2387,'YYJ','SEA','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 15:40 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 16:20 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2389,'YYJ','SEA','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 18:50 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 19:30 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2382,'SEA','YYJ','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 07:50 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 08:29 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2384,'SEA','YYJ','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 11:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 11:45 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2386,'SEA','YYJ','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 14:20 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 15:04 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2388,'SEA','YYJ','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 17:32 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 18:15 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));
INSERT INTO Flights VALUES ('AS',2380,'SEA','YYJ','BDH4',TO_TIMESTAMP_TZ('Jan 15, 1980 23:00 -08:00','MON DD, YYYY HH24:MI TZH:TZM'),TO_TIMESTAMP_TZ('Jan 15, 1980 23:42 -08:00','MON DD, YYYY HH24:MI TZH:TZM'));

