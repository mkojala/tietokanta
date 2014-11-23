INSERT INTO asiakas (asiakas_id, nimi, salasana)
    VALUES (1234, 'Marianne Ojala', 'kissa');

INSERT INTO laakari (laakari_id, nimi, salasana)
    VALUES (0987, 'Tiina Talitintti', 'laakari');

INSERT INTO varaus (varaus_id, asiakas_id, laakari_id, paiva, kellonaika, oireet)
    VALUES (2, 4321, 5678, '2014-10-11', 0900, 'Kurkkukipu');

INSERT INTO raportti (raportti_id, asiakas_id, laakari_id, potilasraportti, hoito_ohjeet, potilashistoria)
    VALUES (1, 1234, 0987, 'Ei aikaisempia kaynteja', 'Lepoa', 'Diabeetikko');


