INSERT INTO kayttaja (kayttaja_id, nimi, salasana, oikeustaso)
    VALUES (1234, 'Marianne Ojala', 'kissa', 1);

INSERT INTO kayttaja (kayttaja_id, nimi, salasana, oikeustaso)
    VALUES (0987, 'Tiina Talitintti', 'laakari', 2);

INSERT INTO varaus (varaus_id, kayttaja_id, paiva, kellonaika, oireet)
    VALUES (2, 1234, '2014-10-11', '09:00:00', 'Kurkkukipu');

INSERT INTO raportti (raportti_id, kayttaja_id, potilasraportti, hoito_ohjeet, potilashistoria)
    VALUES (1, 1234, 'Ei aikaisempia kaynteja', 'Lepoa', 'Diabeetikko');


