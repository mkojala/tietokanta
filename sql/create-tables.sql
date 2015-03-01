CREATE TABLE "kayttaja"
(
kayttaja_id SERIAL PRIMARY KEY,
kayttajatunnus character varying(15) NOT NULL,
nimi character varying(30) NOT NULL,
osoite character varying(50),
salasana character varying(15) NOT NULL,
oikeustaso int NOT NULL
);


CREATE TABLE "varaus"
(
varaus_id SERIAL PRIMARY KEY,
asiakas_id int NOT NULL references kayttaja on delete cascade on update cascade,
laakari_id int NOT NULL references kayttaja on delete cascade on update cascade,
paiva date,
oireet character varying(120)
);

CREATE TABLE raportti
(
  raportti_id SERIAL PRIMARY KEY,
  varaus_id int NOT NULL references varaus on delete cascade on update cascade,
  asiakas_id int NOT NULL references kayttaja on delete cascade on update cascade,
  laakari_id int NOT NULL references kayttaja on delete cascade on update cascade,
  potilasraportti character varying(500) NOT NULL,
  hoito_ohjeet character varying(500) NULL
);




