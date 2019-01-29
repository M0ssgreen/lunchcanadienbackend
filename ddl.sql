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
  EMAIL_RH 	VARCHAR(200),
  CREATION   TIMESTAMP NOT NULL DEFAULT now(),
  MAJ     	 TIMESTAMP NOT NULL DEFAULT now(),
  CONSTRAINT e_pk PRIMARY KEY (ID),
  CONSTRAINT e_ad_fk FOREIGN KEY (ID_ADRESSE) REFERENCES ADRESSE (ID)
) AUTO_INCREMENT  = 100;