-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bianca
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `autori`
--

DROP TABLE IF EXISTS `autori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autori` (
  `idAutor` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) DEFAULT NULL,
  `Prenume` varchar(45) DEFAULT NULL,
  `DataNasterii` date DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autori`
--

LOCK TABLES `autori` WRITE;
/*!40000 ALTER TABLE `autori` DISABLE KEYS */;
INSERT INTO `autori` VALUES (1,'Tolstoy','Lev','1828-09-09'),(2,'Eliade','Mircea','1907-03-13'),(3,'Preda','Marin','1922-08-05'),(4,'Verne','Jules','1828-02-08');
/*!40000 ALTER TABLE `autori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biblioteci`
--

DROP TABLE IF EXISTS `biblioteci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biblioteci` (
  `idBiblioteca` bigint unsigned NOT NULL AUTO_INCREMENT,
  `idAutor` bigint unsigned DEFAULT NULL,
  `idCarte` bigint unsigned DEFAULT NULL,
  `Nume` varchar(45) DEFAULT NULL,
  `Adresa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBiblioteca`),
  KEY `fk_biblioteci_1_idx` (`idAutor`),
  KEY `fk_biblioteci_2_idx` (`idCarte`),
  CONSTRAINT `fk_biblioteci_1` FOREIGN KEY (`idAutor`) REFERENCES `autori` (`idAutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_biblioteci_2` FOREIGN KEY (`idCarte`) REFERENCES `carti` (`idCarte`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biblioteci`
--

LOCK TABLES `biblioteci` WRITE;
/*!40000 ALTER TABLE `biblioteci` DISABLE KEYS */;
INSERT INTO `biblioteci` VALUES (4,3,5,'Panait Istrati','Braila'),(5,4,1,'Mihail Sadoveanu','Bucuresti'),(6,4,2,'Cezar Petrescu','Bucuresti'),(7,2,3,'Emil Garleanu','Timisoara'),(8,1,6,'Mircea Voda','Buzau'),(9,3,4,'Dimitre Cantemir','Ialomita');
/*!40000 ALTER TABLE `biblioteci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carti`
--

DROP TABLE IF EXISTS `carti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carti` (
  `idCarte` bigint unsigned NOT NULL AUTO_INCREMENT,
  `Nume` varchar(45) DEFAULT NULL,
  `Gen` varchar(45) DEFAULT NULL,
  `DataPublicarii` date DEFAULT NULL,
  PRIMARY KEY (`idCarte`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carti`
--

LOCK TABLES `carti` WRITE;
/*!40000 ALTER TABLE `carti` DISABLE KEYS */;
INSERT INTO `carti` VALUES (1,'Insula misterioasa','Fantasy','1872-02-12'),(2,'Calatorie spre centrul Pamantului','Fantasy','2008-01-23'),(3,'Maitrey','Nuvela','1933-12-10'),(4,'Morometii1','Roman','1955-10-01'),(5,'Morometii2','Roman','1967-08-19'),(6,'Romanul unei drame','Roman','2005-03-25');
/*!40000 ALTER TABLE `carti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25  1:10:45
