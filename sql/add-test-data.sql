INSERT INTO kayttaja (kayttaja_id, kayttajatunnus, nimi, salasana, oikeustaso)
    VALUES (1, 'marianne', 'Marianne Ojala', 'asiakas', 2);

INSERT INTO kayttaja (kayttaja_id, kayttajatunnus, nimi, salasana, oikeustaso)
    VALUES (2, 'heikki', 'Heikki Hemmonen','hemmo', 2);

INSERT INTO kayttaja (kayttaja_id, kayttajatunnus, nimi, salasana, oikeustaso)
    VALUES (3, 'tiina', 'Tiina Talitintti','laakari', 1);

INSERT INTO kayttaja (kayttaja_id, kayttajatunnus, nimi, salasana, oikeustaso)
    VALUES (4, 'ossi','Ossi Ortopedi', 'jalka', 1);

INSERT INTO laakarit 
(laakari_id)
select kayttaja_id from kayttaja where oikeustaso = 1;

INSERT INTO asiakkaat 
(asiakas_id)
select kayttaja_id  from kayttaja where oikeustaso = 2;

INSERT INTO varaus 
(varaus_id, asiakas_id, laakari_id, paiva, kellonaika, oireet)
    VALUES (1, 1, 3, '2014-10-12', '10:00:00', 'Selkäsärky');

INSERT INTO varaus 
(varaus_id, asiakas_id, laakari_id, paiva, kellonaika, oireet)
    VALUES (2, 2, 4, '2014-10-12', '09:00:00', 'Kurkkukipu');

INSERT INTO raportti (raportti_id, varaus_id, asiakas_id, potilasraportti, hoito_ohjeet)
    VALUES (1, 1, 1, 'Selän särky rasituksesta johtuvaa.', 'Lepoa ja nesteytystä');

INSERT INTO raportti (raportti_id, varaus_id, asiakas_id, potilasraportti, hoito_ohjeet)
    VALUES (2, 2, 2, 'Kurkunpääntulehdus', 'Antibiootti 2x pv');






