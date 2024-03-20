-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: proiect_pibd
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `departamente`
--

DROP TABLE IF EXISTS `departamente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamente` (
  `iddepartament` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nume_departament` varchar(100) DEFAULT NULL,
  `coordonator` varchar(45) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `facultate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iddepartament`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamente`
--

LOCK TABLES `departamente` WRITE;
/*!40000 ALTER TABLE `departamente` DISABLE KEYS */;
INSERT INTO `departamente` VALUES (2,'Calculatoare','Mariana Pirvu','mariana.pirvu@acs.upb.ro','ACS'),(3,'Tehnologie Electronica si Fiabilitate','Ioana Stoica','ioana.stoica@etti.upb.ro','ETTI'),(4,'Sisteme Electroenergetice','Mihai Dudu','mihai.dudu@energ.upb.ro','Energetica'),(5,'Transporturi, Trafic si Logistica','Mihai Botezatu','mihai.botezatu@trans.upb.ro','Transporturi'),(6,'Telecomunicatii','Ionel Ungureanu','ione.ungureanu@etti.upb.ro','ETTI');
/*!40000 ALTER TABLE `departamente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proiecte`
--

DROP TABLE IF EXISTS `proiecte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proiecte` (
  `idproiect` bigint unsigned NOT NULL AUTO_INCREMENT,
  `idstudent` bigint unsigned DEFAULT NULL,
  `iddepartament` bigint unsigned DEFAULT NULL,
  `data_predare` date DEFAULT NULL,
  `tematica` varchar(45) DEFAULT NULL,
  `nume_proiect` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idproiect`),
  KEY `fk_proiecte_1_idx` (`idstudent`),
  KEY `fk_proiecte_2_idx` (`iddepartament`),
  CONSTRAINT `fk_proiecte_1` FOREIGN KEY (`idstudent`) REFERENCES `studenti` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proiecte_2` FOREIGN KEY (`iddepartament`) REFERENCES `departamente` (`iddepartament`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proiecte`
--

LOCK TABLES `proiecte` WRITE;
/*!40000 ALTER TABLE `proiecte` DISABLE KEYS */;
INSERT INTO `proiecte` VALUES (1,5,4,'2023-10-20','sustenabilitate','SmartVolt: Inovare în Monitorizarea și Controlul Energiei'),(2,1,5,'2023-11-20','logistica','LogiData: Optimizare Logistică Prin Analiză de Date'),(3,4,2,'2023-12-20','cybersecurity','CyberGuard: Securitate Cibernetică Avansată'),(7,4,6,'2024-12-20','radiocomunicatii','5G');
/*!40000 ALTER TABLE `proiecte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenti` (
  `idstudent` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nume_stud` varchar(45) DEFAULT NULL,
  `prenume_stud` varchar(45) DEFAULT NULL,
  `nr_matricol` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `an_studiu` int DEFAULT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti`
--

LOCK TABLES `studenti` WRITE;
/*!40000 ALTER TABLE `studenti` DISABLE KEYS */;
INSERT INTO `studenti` VALUES (1,'Pohrib','Emanuel','81/90C/2023','pohribemy@yahoo.com',1),(2,'Pisica','Rebeca','67/76B/2021','rebecapisic@gmail.com',2),(4,'Pastaie','Alexandru','57/88C/2023','alex_pastaie@yahoo.com',1),(5,'Nasturel','Crina','47/99A/2021','crinasturel@yahoo.com',3),(7,'Cojocaru','Beatrice','89/67A/2021','beatrice_cojocaru@gmail.com',3),(8,'Ionescu','Georgiana','45/23E/2022','geo.ionescu@gmail.com',2);
/*!40000 ALTER TABLE `studenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-23 22:19:29
