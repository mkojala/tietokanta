INSERT INTO Asiakas (asiakas_id, etunimi, sukunimi, osoite, salasana, varaus_id, raportti_id)
    VALUES (1234, Marianne, Ojala, Kissakuja 13 Helsinki, kissakissa, 1, 1);
INSERT INTO Asiakas (asiakas_id, etunimi, sukunimi, osoite, salasana, varaus_id, raportti_id)
    VALUES (4321, Heikki, Himmonen, Himmelkatu 6 A, himmellys, 2, 2);

INSERT INTO Laakari (laakari_id, etunimi, sukunimi, salasana, varaus_id, raportti_id)
    VALUES (0987, Tiina, Talitintti, oonlaakari, 1, 1);

INSERT INTO Laakari (laakari_id, etunimi, sukunimi, salasana, varaus_id, raportti_id)
    VALUES (5678, Matti, Meikäläinen, laakarioon, 2, 2);

INSERT INTO Varaus (varaus_id, asiakas_id, laakari_id, paiva, kellonaika, oireet)
    VALUES (1, 1234, 0987, 12.12.2014, 13:15, Särky vasemmassa lonkassa);

INSERT INTO Varaus (varaus_id, asiakas_id, laakari_id, paiva, kellonaika, oireet)
    VALUES (2, 4321, 5678, 10.11.2014, 09:00, Kurkkukipu ja päänsärky);

INSERT INTO Raportti (raportti_id, asiakas_id, laakari_id, potilasraportti, hoito-ohjeet, potilashistoria)
    VALUES (1, 1234, 0987, Lonkassa lievää rasitusta, Lepää ja vältä liikkumista pariin päivään, Potilaalla osteoporoosi);

INSERT INTO Raportti (raportti_id, asiakas_id, laakari_id, potilasraportti, hoito-ohjeet, potilashistoria)
    VALUES (2, 4321, 5678, Potilaalla todettu kurkunpääntulehdus johon määrätty antibioottikuuri, Yksi antibiootti kaksi kertaa päivässä viikon ajan, Ei aikaisempaa historiaa);
