DROP DATABASE IF EXISTS `lunchcanadienbdd`;
CREATE DATABASE `lunchcanadienbdd`;

USE `lunchcanadienbdd`;


DROP TABLE IF EXISTS `ADRESSE`;
CREATE TABLE `ADRESSE` (
  `ID` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `RUE` varchar(200) DEFAULT NULL,
  `NUMERO` varchar(200) DEFAULT NULL,
  `CODE_POSTAL` VARCHAR(6) DEFAULT NULL,
  `VILLE` varchar(200) DEFAULT NULL,
  `CREATION` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MAJ` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT = 100;



DROP TABLE IF EXISTS `UTILISATEUR`;
CREATE TABLE UTILISATEUR (
  ID          BIGINT NOT NULL AUTO_INCREMENT,
  PRENOM   VARCHAR(200),
  NOM    VARCHAR(200),
  EMAIL       VARCHAR(200),
  MDP		VARCHAR(200),
  ID_ENTREPRISE	BIGINT,
  TELEPHONE       VARCHAR(200),
  CREATION     TIMESTAMP NOT NULL DEFAULT now(),
  MAJ     TIMESTAMP NOT NULL DEFAULT now(),
  CONSTRAINT telephone_unique UNIQUE (TELEPHONE),
  CONSTRAINT email_unique UNIQUE (EMAIL),
  CONSTRAINT u_en_fk FOREIGN KEY (ID_ENTREPRISE) REFERENCES ENTREPRISE (ID),
  CONSTRAINT PROFIL_pk PRIMARY KEY (ID)
) AUTO_INCREMENT  = 100;


DROP TABLE IF EXISTS `EVENEMENT`;
CREATE TABLE EVENEMENT (
  ID         BIGINT NOT NULL AUTO_INCREMENT,
  NOM    	 VARCHAR(200),
  QUANTIEME TIMESTAMP,
  STATUT	INT,
  CREATION   TIMESTAMP NOT NULL DEFAULT now(),
  MAJ     	 TIMESTAMP NOT NULL DEFAULT now(),
  ID_ADRESSE BIGINT,
  RESTO VARCHAR(200),
  CONSTRAINT evenement_pk PRIMARY KEY (ID),
  CONSTRAINT ev_adr_fk FOREIGN KEY (ID_ADRESSE) REFERENCES ADRESSE (ID)
) AUTO_INCREMENT  = 100;



DROP TABLE IF EXISTS `DEMANDE`;
CREATE TABLE DEMANDE (
  ID         BIGINT NOT NULL AUTO_INCREMENT,
  ID_EVENEMENT BIGINT,
  ID_UTILISATEUR BIGINT,

  CONSTRAINT d_pk PRIMARY KEY (ID),
  CONSTRAINT d_unique UNIQUE (ID_EVENEMENT, ID_UTILISATEUR),
  CONSTRAINT d_ev_fk FOREIGN KEY (ID_EVENEMENT) REFERENCES EVENEMENT (ID),
  CONSTRAINT d_user_fk FOREIGN KEY (ID_UTILISATEUR) REFERENCES UTILISATEUR (ID)
) AUTO_INCREMENT  = 100;

DROP TABLE IF EXISTS `ENTREPRISE`;
CREATE TABLE ENTREPRISE (
  ID         BIGINT NOT NULL AUTO_INCREMENT,
  NOM 	VARCHAR(200),
  ID_ADRESSE 	BIGINT,
  RESPOBONHEUR 	BIGINT,
  CREATION   TIMESTAMP NOT NULL DEFAULT now(),
  MAJ     	 TIMESTAMP NOT NULL DEFAULT now(),
  CONSTRAINT e_pk PRIMARY KEY (ID),
  CONSTRAINT e_ad_fk FOREIGN KEY (ID_ADRESSE) REFERENCES ADRESSE (ID),
  CONSTRAINT e_us_fk FOREIGN KEY (RESPOBONHEUR) REFERENCES UTILISATEUR (ID)
) AUTO_INCREMENT  = 100;

INSERT INTO `adresse` (`ID`, `RUE`, `NUMERO`, `CODE_POSTAL`, `VILLE`, `CREATION`, `MAJ`) VALUES (NULL, 'rue des sushis', '1', '75001', 'Paris', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'avenue des tacos', '56', '69001', 'Lyon', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'rue des kebab', '84', '75011', 'Paris', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO `entreprise` (`ID`, `NOM`, `ID_ADRESSE`, `RESPOBONHEUR`, `CREATION`, `MAJ`) VALUES (NULL, 'Solutec', '100', '100', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Solutec Lyon', '101', '100', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Miam', '102', '101', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO `utilisateur` (`ID`, `PRENOM`, `NOM`, `EMAIL`, `MDP`, `ID_ENTREPRISE`, `TELEPHONE`, `CREATION`, `MAJ`) VALUES (NULL, 'Jo', 'Jojo', 'anais.poujouly@hotmail.fr', '1234', '100', '0123456789', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Bob', 'Bob', 'gabriel.c.t.terrien@gmail.com', 'azerty', '100', '0154879563', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Bill', 'Billy', 'bill@bill.com', '98765', '100', '0154876532', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Ursul', 'Po', 'ur@po.com', '123987', '100', '0154863214', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Lilly', 'Lil', 'lil@ly.com', '654987', '100', '0154763214', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Maurice', 'Momo', 'mo@mo.com', 'az12az', '100', '0165489632', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Paul', 'Cake', 'polo@cake.com', '654tyu', '101', '0135647895', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Luke', 'Skywalker', 'lulu@jedi.com', '951357', '101', '0154753217', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Kyle', 'Bill', 'kb@gmail.com', 'qsdfg', '101', '0195478632', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Alice', 'Martin', 'lice@mart.com', 'pompom', '102', '0154789632', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), (NULL, 'Jean', 'Jean', 'jeanjean@jean.jean', 'mompom', '102', '0654844632', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO `evenement` (`ID`, `NOM`, `QUANTIEME`, `STATUT`, `CREATION`, `MAJ`, `ID_ADRESSE`) VALUES (NULL, 'evenement1', '2019-01-31 12:00:00', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '100'), (NULL, 'evenement2', '2019-02-01 12:00:00', '0', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '101'), (NULL, 'evenement3', '2019-02-03 12:00:00', '0', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '102'); 

INSERT INTO `demande` (`ID`, `ID_EVENEMENT`, `ID_UTILISATEUR`) VALUES (NULL, '100', '100'), (NULL, '100', '101'), (NULL, '100', '102'), (NULL, '100', '103'), (NULL, '100', '104'), (NULL, '100', '105'), (NULL, '101', '106'), (NULL, '101', '107'), (NULL, '101', '108'), (NULL, '102', '109'); 