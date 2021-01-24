CREATE DATABASE  IF NOT EXISTS `stragame` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `stragame`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stragame
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bug`
--

DROP TABLE IF EXISTS `bug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bug` (
  `codicebug` int NOT NULL AUTO_INCREMENT,
  `autore` varchar(45) NOT NULL,
  `videogioco` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `testo` varchar(300) NOT NULL,
  `immagine` blob,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`codicebug`),
  KEY `autorebug_idx` (`autore`),
  KEY `videogiocobug_idx` (`videogioco`),
  CONSTRAINT `autorebug` FOREIGN KEY (`autore`) REFERENCES `user` (`nickname`),
  CONSTRAINT `videogiocobug` FOREIGN KEY (`videogioco`) REFERENCES `videogioco` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bug`
--

LOCK TABLES `bug` WRITE;
/*!40000 ALTER TABLE `bug` DISABLE KEYS */;
INSERT INTO `bug` VALUES (1,'c.lau','Resident Evil','2021-01-22 16:47:15','Primo Bug','Primo Bug',NULL,'Bug Grafico'),(2,'c.lau','Resident Evil','2021-01-23 10:09:59','Secondo Bug','Ciao sono il secondo bug',NULL,'Bug Grafico'),(3,'c.lau','Resident Evil','2021-01-23 10:12:58','Terzo Bug','Ciao sono il terzo bug',NULL,'Bug Grafico');
/*!40000 ALTER TABLE `bug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `codicepubblicazione` int NOT NULL,
  `autore` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `testo` varchar(45) NOT NULL,
  `mipiace` int NOT NULL,
  PRIMARY KEY (`codicepubblicazione`,`autore`,`data`),
  KEY `autore_idx` (`autore`),
  CONSTRAINT `autore` FOREIGN KEY (`autore`) REFERENCES `user` (`nickname`),
  CONSTRAINT `pubblicationcomment` FOREIGN KEY (`codicepubblicazione`) REFERENCES `pubblication` (`codicepubblicazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `autore` varchar(45) NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `testo` varchar(750) NOT NULL,
  `immagine` blob,
  PRIMARY KEY (`autore`,`titolo`,`data`),
  CONSTRAINT `usernews` FOREIGN KEY (`autore`) REFERENCES `user` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('c.lau','Prima Notizia','2021-01-23 09:36:36','Ciao sono la prima notizia',NULL);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubblication`
--

DROP TABLE IF EXISTS `pubblication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pubblication` (
  `codicepubblicazione` int NOT NULL AUTO_INCREMENT,
  `autore` varchar(45) NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `descrizione` varchar(750) NOT NULL,
  `mipiace` int NOT NULL,
  `videogioco` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `immagine` blob,
  `gameplay` int DEFAULT NULL,
  `trama` int DEFAULT NULL,
  `grafica` int DEFAULT NULL,
  `votocomplessivo` int DEFAULT NULL,
  `tipo` varchar(12) NOT NULL,
  PRIMARY KEY (`codicepubblicazione`),
  KEY `user_idx` (`autore`),
  KEY `pubblicationvideogioco_idx` (`videogioco`),
  CONSTRAINT `pubblicationvideogioco` FOREIGN KEY (`videogioco`) REFERENCES `videogioco` (`nome`),
  CONSTRAINT `userpubblication` FOREIGN KEY (`autore`) REFERENCES `user` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=3219 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubblication`
--

LOCK TABLES `pubblication` WRITE;
/*!40000 ALTER TABLE `pubblication` DISABLE KEYS */;
INSERT INTO `pubblication` VALUES (3212,'c.lau','asdfg','asderty',0,'sxcfgh','2021-01-22 16:47:15',NULL,NULL,NULL,NULL,NULL,'topic'),(3213,'c.lau','rtyetwtryyj','q23wertuitureruty',0,'Resident Evil','2021-01-22 16:48:13',NULL,NULL,NULL,NULL,NULL,'topic'),(3214,'c.lau','Secondo Topic','Secondo Topic',0,'Resident Evil','2021-01-22 21:09:21',NULL,NULL,NULL,NULL,NULL,'topic'),(3215,'c.lau','Terzo Topic','Terzo Topic',0,'Resident Evil','2021-01-22 21:15:06',NULL,NULL,NULL,NULL,NULL,'topic'),(3216,'c.lau','Quarto Topic','Mario è il TOP',0,'Resident Evil','2021-01-22 21:16:55',NULL,NULL,NULL,NULL,NULL,'topic'),(3217,'c.lau','Prima Recensione','Ciao sono la prima Review',0,'Resident Evil','2021-01-23 11:00:57',NULL,10,9,8,7,'review'),(3218,'c.lau','Seconda Review','ciao sono la seconda Review',0,'Resident Evil','2021-01-23 11:14:06',NULL,1,3,7,7,'review');
/*!40000 ALTER TABLE `pubblication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubblicationreport`
--

DROP TABLE IF EXISTS `pubblicationreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pubblicationreport` (
  `autore` varchar(45) NOT NULL,
  `codicepubblicazione` int NOT NULL,
  `data` datetime DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`autore`,`codicepubblicazione`),
  KEY `codepubblicationreport_idx` (`codicepubblicazione`),
  CONSTRAINT `codepubblicationreport` FOREIGN KEY (`codicepubblicazione`) REFERENCES `pubblication` (`codicepubblicazione`),
  CONSTRAINT `userreport` FOREIGN KEY (`autore`) REFERENCES `user` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubblicationreport`
--

LOCK TABLES `pubblicationreport` WRITE;
/*!40000 ALTER TABLE `pubblicationreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubblicationreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `nickname` varchar(25) NOT NULL,
  `ruolo` varchar(25) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `descrizione` varchar(300) DEFAULT NULL,
  `foto` mediumblob,
  `segnalato` tinyint NOT NULL,
  PRIMARY KEY (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('c.bel','user','c.bel@yahoo.it','Ciccio','Bello','ciao','',NULL,0),('c.lau','user','c.lau@yahoo.it','Carmine','Laudato','ciao1','miao a tutti',NULL,0),('Leo.gal','user','leo.gal@yahoo.it','Leo','Galiano','ciao','',NULL,0),('mario.maff','user','maffettone.mario@yahoo.it','Mario','Maffettone','ciao',NULL,NULL,0),('u.mau','user','u.mau@yahoo.it','Umberto','Mauro','ciao','',NULL,0),('v.stra','user','v.stra@yahoo.it','Vincenzo','Strano','ciao','',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videogioco`
--

DROP TABLE IF EXISTS `videogioco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videogioco` (
  `nome` varchar(45) NOT NULL,
  `genere` varchar(45) NOT NULL,
  `Descrizione` varchar(300) DEFAULT NULL,
  `foto` mediumblob,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videogioco`
--

LOCK TABLES `videogioco` WRITE;
/*!40000 ALTER TABLE `videogioco` DISABLE KEYS */;
INSERT INTO `videogioco` VALUES ('fghgfdfghf','Andriod Developer','dsafgjdfgh',NULL),('Resident Evil','Horror',NULL,NULL),('sxcfgh','Andriod Developer','dasfdghjkh',NULL);
/*!40000 ALTER TABLE `videogioco` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  9:48:57
