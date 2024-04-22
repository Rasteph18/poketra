CREATE DATABASE poketra WITH ENCODING = 'UTF8';

\c poketra

CREATE TABLE look(
    id INT PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE matiere(
    id INT PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE details_look(
    id INT PRIMARY KEY,
    id_look INT,
    id_matiere INT,

    FOREIGN KEY(id_look) REFERENCES look (id),
    FOREIGN KEY(id_matiere) REFERENCES matiere (id) 
);

CREATE TABLE type(
    id INT PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE taille(
    id INT PRIMARY KEY,
    nom VARCHAR(250),
    coefficient INT
);

CREATE TABLE produit(
    id INT PRIMARY KEY,
    id_type INT,
    id_look INT,
    id_taille INT,

    FOREIGN KEY(id_type) REFERENCES type (id),
    FOREIGN KEY(id_look) REFERENCES look (id),
    FOREIGN KEY(id_taille) REFERENCES taille (id)
);

CREATE TABLE details_produit(
    id INT PRIMARY KEY,
    id_produit INT,
    id_matiere INT,
    quantite DOUBLE PRECISION,

    FOREIGN KEY(id_produit) REFERENCES produit (id),
    FOREIGN KEY(id_matiere) REFERENCES matiere (id)
);
-----

CREATE TABLE prix_matiere(
    id INT PRIMARY KEY,
    id_matiere INT,
    date_jour DATE,
    prix DOUBLE PRECISION,

    FOREIGN KEY(id_matiere) REFERENCES matiere (id) --modif
);

CREATE TABLE stock_matiere(
    id INT PRIMARY KEY,
    id_matiere INT,
    quantite_entre DOUBLE PRECISION,
    quantite_sorti DOUBLE PRECISION,
    date_jour DATE,

    FOREIGN KEY(id_matiere) REFERENCES matiere (id)
);

SELECT SUM(quantite_entre) - SUM(quantite_sorti) AS quantite FROM stock_matiere WHERE id_matiere = 2;

CREATE TABLE fabrication(
    id INT PRIMARY KEY,
    id_produit INT,
    quantite DOUBLE PRECISION,
    date_jour DATE,

    FOREIGN KEY(id_produit) REFERENCES produit (id)
);

CREATE TABLE personnel(
    id INT PRIMARY KEY,
    description VARCHAR(250)
);

CREATE TABLE salaire_personnel(
    id INT PRIMARY KEY,
    id_personnel INT,
    salaire DOUBLE PRECISION,
    date DATE,

    FOREIGN KEY(id_personnel) REFERENCES personnel (id)
);

CREATE TABLE nb_personnel_taille(
    id INT PRIMARY KEY,
    id_taille INT,
    nb_personnel INT,
    coeff_taille INT,
    date_jour DATE,

    FOREIGN KEY(id_taille) REFERENCES taille (id)
);


CREATE TABLE dure_travail_personnel(
    id INT PRIMARY KEY,
    id_look INT,
    dure DOUBLE PRECISION,

    FOREIGN KEY(id_look) REFERENCES look (id)
);


CREATE TABLE details_production(
    id INT PRIMARY KEY,
    id_produit INT,
    id_personnel INT,
    nb_personnel INT,
    heure_travail DOUBLE PRECISION,

    FOREIGN KEY(id_produit) REFERENCES produit (id),
    FOREIGN KEY(id_personnel) REFERENCES personnel (id)
);

CREATE TABLE prix_vente_produit(
    id INT PRIMARY KEY,
    id_produit INT,
    prix_vente DOUBLE PRECISION,
    date DATE,

    FOREIGN KEY(id_produit) REFERENCES produit (id)
);

CREATE TABLE employe(
    id INT PRIMARY KEY,
    nom VARCHAR(250),
    prenom VARCHAR(250),
    date_naissance DATE
);

CREATE TABLE profil(
    id INT PRIMARY KEY,
    nom VARCHAR(250), 
    coefficient INT,
    annee INT
);

CREATE TABLE embauche(
    id INT PRIMARY KEY,
    id_employe INT,
    date_embauche DATE,
    id_personnel INT,

    FOREIGN KEY(id_employe) REFERENCES employe(id),
    FOREIGN KEY(id_personnel) REFERENCES personnel(id)
);


CREATE TABLE genre(
    id INT PRIMARY KEY,
    description VARCHAR(250)
);

CREATE TABLE client(
    id INT PRIMARY KEY,
    nom VARCHAR(250),
    id_genre INT,

    FOREIGN KEY(id_genre) REFERENCES genre(id)
);

CREATE TABLE vente(
    id INT PRIMARY KEY,
    id_produit INT,
    quantite INT,
    date_vente DATE,
    id_client INT,

    FOREIGN KEY(id_produit) REFERENCES produit(id),
    FOREIGN KEY(id_client) REFERENCES client(id)
);


----------------------------::::::::::::::::::::::::::::::::----------------------------------------


CREATE SEQUENCE look_sequence INCREMENT 1 START 1;
CREATE SEQUENCE matiere_sequence INCREMENT 1 START 1;
CREATE SEQUENCE details_look_sequence INCREMENT 1 START 1;
CREATE SEQUENCE type_sequence INCREMENT 1 START 1;
CREATE SEQUENCE taille_sequence INCREMENT 1 START 1;
CREATE SEQUENCE produit_sequence INCREMENT 1 START 1;
CREATE SEQUENCE details_produit_sequence INCREMENT 1 START 1;
CREATE SEQUENCE prix_matiere_sequence INCREMENT 1 START 1;
CREATE SEQUENCE stock_matiere_sequence INCREMENT 1 START 1;
CREATE SEQUENCE fabrication_sequence INCREMENT 1 START 1;
CREATE SEQUENCE personnel_sequence INCREMENT 1 START 1;
CREATE SEQUENCE salaire_personnel_sequence INCREMENT 1 START 1;
CREATE SEQUENCE nb_personnel_taille_sequence INCREMENT 1 START 1;
CREATE SEQUENCE dure_travail_personnel_sequence INCREMENT 1 START 1;
CREATE SEQUENCE details_production_sequence INCREMENT 1 START 1;
CREATE SEQUENCE prix_vente_produit_sequence INCREMENT 1 START 1;
CREATE SEQUENCE employe_sequence INCREMENT 1 START 1;
CREATE SEQUENCE profil_sequence INCREMENT 1 START 1;
CREATE SEQUENCE embauche_sequence INCREMENT 1 START 1;
CREATE SEQUENCE genre_sequence INCREMENT 1 START 1;
CREATE SEQUENCE client_sequence INCREMENT 1 START 1;
CREATE SEQUENCE vente_sequence INCREMENT 1 START 1;

INSERT INTO genre VALUES(nextval('genre_sequence'), 'Homme');
INSERT INTO genre VALUES(nextval('genre_sequence'), 'Femme');



CREATE OR REPLACE VIEW V_details_look AS
    SELECT dl.id, l.id AS id_look, m.id AS id_matiere, l.nom AS nom_look, m.nom AS nom_matiere FROM details_look AS dl 
        JOIN look AS l ON dl.id_look = l.id
        JOIN matiere AS m ON dl.id_matiere = m.id;

CREATE OR REPLACE VIEW V_look_taille_type AS
    SELECT p.id AS id_produit, m.id AS id_matiere, taille.nom AS taille, t.nom AS type, l.nom AS look, dp.quantite
        FROM details_produit AS dp
        JOIN matiere AS m ON dp.id_matiere = m.id
        JOIN produit AS p ON dp.id_produit = p.id
        JOIN type AS t ON p.id_type = t.id
        JOIN taille ON p.id_taille = taille.id
        JOIN look AS l ON p.id_look = l.id;


CREATE OR REPLACE VIEW V_prix_produit
AS 
SELECT
    dp.id_produit, sum(p.prix * dp.quantite) AS prix, type.nom AS type, taille.nom AS taille, look.nom AS look
FROM
    details_produit AS dp
    JOIN prix_matiere AS p ON dp.id_matiere = p.id_matiere
    JOIN produit ON dp.id_produit = produit.id
    JOIN type ON produit.id_type = type.id
    JOIN look ON produit.id_look = look.id
    JOIN taille ON produit.id_taille = taille.id
WHERE date_jour = (SELECT max(date_jour) from prix_matiere where prix_matiere.id_matiere = p.id_matiere)
GROUP BY dp.id_produit, type.nom, taille.nom, look.nom;


CREATE OR REPLACE VIEW V_details_stock_matiere
AS 
SELECT 
    sm.id_matiere, 
    m.nom, 
    SUM(quantite_entre) - SUM(quantite_sorti) AS reste
FROM
    stock_matiere AS sm
    JOIN matiere AS m ON sm.id_matiere = m.id
GROUP BY sm.id_matiere, m.nom;

CREATE OR REPLACE VIEW V_details_produit
AS 
SELECT 
    id_produit,
    taille, 
    type, 
    look 
FROM 
    v_look_taille_type 
GROUP BY 
    id_produit, 
    taille, 
    type, 
    look
ORDER BY
    id_produit;




CREATE OR REPLACE VIEW V_prix_personnel_production
AS
SELECT
    dp.id_produit,
    SUM(sp.salaire * dp.nb_personnel * (dp.heure_travail/60)) AS prix
FROM
    details_production AS dp
    JOIN salaire_personnel AS sp ON dp.id_personnel = sp.id_personnel
GROUP BY dp.id_produit;




CREATE OR REPLACE VIEW V_benefice_produit
AS
SELECT
    pvp.id_produit,
    vdp.taille,
    vdp.type,
    vdp.look,
    (pvp.prix_vente - (vpproduit.prix + vpperso.prix)) AS benefice
FROM
    prix_vente_produit AS pvp
    JOIN V_prix_produit AS vpproduit ON pvp.id_produit = vpproduit.id_produit
    JOIN V_prix_personnel_production AS vpperso ON pvp.id_produit = vpperso.id_produit
    JOIN V_details_produit AS vdp ON pvp.id_produit = vdp.id_produit;




CREATE OR REPLACE VIEW V_profil_employe
AS
SELECT 
    emp.id AS id_employe,
    emp.nom AS nom_employe,
    emp.prenom AS prenom_employe,
    emp.date_naissance,
    EXTRACT(YEAR FROM AGE (now(), embauche.date_embauche)) AS annee_experience,
    personnel.description,
    embauche.date_embauche,
    profil.nom AS nom_profil,
    (sp.salaire * profil.coefficient) AS salaire
FROM
    employe AS emp
    JOIN embauche ON emp.id = embauche.id_employe
    JOIN personnel ON embauche.id_personnel = personnel.id
    JOIN salaire_personnel AS sp ON embauche.id_personnel = sp.id_personnel
    JOIN profil ON profil.annee = (SELECT MAX(annee) FROM profil WHERE annee <= EXTRACT(YEAR FROM AGE(now(), embauche.date_embauche)))
WHERE sp.date = (SELECT MAX(date) FROM salaire_personnel WHERE salaire_personnel.id_personnel = sp.id_personnel);



CREATE OR REPLACE VIEW V_statistique_nb_vente
AS
SELECT 
    ROW_NUMBER() OVER (ORDER BY genre.id) AS id,
    genre.id AS id_genre,
    genre.description,
    SUM(v.quantite) AS nombre,
    dp.id_produit
FROM 
    vente AS v
    JOIN client ON v.id_client = client.id
    JOIN genre ON client.id_genre = genre.id
    JOIN V_details_produit AS dp ON v.id_produit = dp.id_produit
GROUP BY genre.description, genre.id, dp.id_produit;



CREATE OR REPLACE VIEW V_statistique_nb_vente_all
AS
SELECT 
    ROW_NUMBER() OVER (ORDER BY genre.id) AS id,
    genre.id AS id_genre,
    genre.description,
    SUM(v.quantite) AS nombre
FROM 
    vente AS v
    JOIN client ON v.id_client = client.id
    JOIN genre ON client.id_genre = genre.id
    JOIN V_details_produit AS dp ON v.id_produit = dp.id_produit
GROUP BY genre.description, genre.id;


CREATE OR REPLACE VIEW V_reste_produit
AS
select 
        vdp.id_produit, 
        vdp.taille,
        vdp.type,
        vdp.look,
        SUM(quantite) AS quantite 
from 
        fabrication 
        JOIN V_details_produit AS vdp ON fabrication.id_produit = vdp.id_produit
GROUP BY 
        vdp.id_produit, vdp.taille, vdp.type, vdp.look;


--------------------------------------------

select id_produit, SUM(quantite) from fabrication GROUP BY id_produit;