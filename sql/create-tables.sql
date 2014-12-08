CREATE TABLE "kayttaja"
(
kayttaja_id int PRIMARY KEY,
kayttajatunnus character varying(15) NOT NULL,
nimi character varying(30) NOT NULL,
salasana character varying(15) NOT NULL,
oikeustaso int NOT NULL
);

CREATE TABLE "laakarit"
(
laakari_id int PRIMARY KEY references kayttaja on delete cascade
);

CREATE TABLE "asiakkaat"
(
asiakas_id int PRIMARY KEY references kayttaja on delete cascade
);

CREATE TABLE "varaus"
(
varaus_id int PRIMARY KEY,
asiakas_id int NOT NULL references asiakkaat on delete cascade on update cascade,
laakari_id int NOT NULL references laakarit on delete cascade on update cascade,
paiva date NOT NULL,
kellonaika time NOT NULL,
oireet character varying(120) NOT NULL
);

CREATE TABLE raportti
(
  raportti_id int PRIMARY KEY,
  varaus_id int NOT NULL references varaus on delete cascade on update cascade,
  asiakas_id int NOT NULL references asiakkaat on delete cascade on update cascade,
  potilasraportti character varying(500) NOT NULL,
  hoito_ohjeet character varying(500) NULL
);




