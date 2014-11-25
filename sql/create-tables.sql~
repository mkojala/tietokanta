CREATE TABLE "kayttaja"
(
kayttaja_id SERIAL PRIMARY KEY,
nimi character varying(30) NOT NULL,
salasana character varying(8) NOT NULL,
oikeustaso int NOT NULL
);

CREATE TABLE "varaus"
(
varaus_id SERIAL PRIMARY KEY,
kayttaja_id int NOT NULL references kayttaja,
paiva date NOT NULL,
kellonaika time NOT NULL,
oireet character varying(120) NOT NULL
);

CREATE TABLE raportti
(
  raportti_id SERIAL PRIMARY KEY,
  kayttaja_id int NOT NULL references kayttaja,
  potilasraportti character varying(200) NOT NULL,
  hoito_ohjeet character varying(200) NULL,
  potilashistoria character varying(300) NOT NULL
);


