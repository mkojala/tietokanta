CREATE TABLE "Asiakas"
(
asiakas_id SERIAL PRIMARY KEY,
etunimi character varying(30) NOT NULL,
sukunimi character varying(30) NOT NULL,
osoite character varying(120) NOT NULL,
salasana character varying(8) NOT NULL,
varaus_id int NULL,
raportti_id int NULL,

FOREIGN KEY varaus_id REFERENCES Varaus(varaus_id)
FOREIGN KEY raportti_id REFERENCES Raportti(raportti_id)
ON UPDATE CASCADE ON DELETE CASCADE
);
 
CREATE TABLE "Laakari"
(
laakari_id SERIAL PRIMARY KEY,
etunimi character varying(30) NOT NULL,
sukunimi character varying(30) NOT NULL,
salasana character varying(8) NOT NULL,
varaus_id int NULL,
raportti_id int NULL,

FOREIGN KEY varaus_id REFERENCES Varaus(varaus_id)
FOREIGN KEY raportti_id REFERENCES Raportti(raportti_id)
ON UPDATE CASCADE ON DELETE CASCADE
);
 
CREATE TABLE "Varaus"
(
varaus_id SERIAL PRIMARY KEY,
asiakas_id int NOT NULL,
laakari_id int NOT NULL,
paiva date NOT NULL,
kellonaika timestamp NOT NULL,
oireet character varying(120) NOT NULL,

FOREIGN KEY asiakas_id REFERENCES Asiakas(asiakas_id)
FOREIGN KEY laakari_id REFERENCES Laakari(laakari_id)
ON UPDATE CASCADE ON DELETE CASCADE
);
 
CREATE TABLE Raportti
(
  raportti_id SERIAL PRIMARY KEY,
  asiakas_id int NOT NULL,
  laakari_id int NOT NULL,
  potilasraportti character varying(200) NOT NULL,
  hoito_ohjeet character varying(200) NULL,
  potilashistoria character varying(300) NOT NULL,

  FOREIGN KEY asiakas_id REFERERNCES Asiakas(asiakas_id),
  FOREIGN KEY laakari_id REFERENCES Laakari(laakari_id) 
  ON UPDATE CASCADE ON DELETE CASCADE
);


