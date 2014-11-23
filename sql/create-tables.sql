CREATE TABLE "asiakas"
(
asiakas_id SERIAL PRIMARY KEY,
nimi character varying(30) NOT NULL,
salasana character varying(8) NOT NULL

);
 
CREATE TABLE "laakari"
(
laakari_id SERIAL PRIMARY KEY,
nimi character varying(30) NOT NULL,
salasana character varying(8) NOT NULL
);
 
CREATE TABLE "varaus"
(
varaus_id SERIAL PRIMARY KEY,
asiakas_id int NOT NULL references asiakas,
laakari_id int NOT NULL references laakari,
paiva date NOT NULL,
kellonaika timestamp NOT NULL,
oireet character varying(120) NOT NULL
);

CREATE TABLE raportti
(
  raportti_id SERIAL PRIMARY KEY,
  asiakas_id int NOT NULL references asiakas,
  laakari_id int NOT NULL references laakari,
  potilasraportti character varying(200) NOT NULL,
  hoito_ohjeet character varying(200) NULL,
  potilashistoria character varying(300) NOT NULL
);


