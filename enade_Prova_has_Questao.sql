-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: enade
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `Prova_has_Questao`
--

DROP TABLE IF EXISTS `Prova_has_Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prova_has_Questao` (
  `Prova_idProva` int NOT NULL AUTO_INCREMENT,
  `Questao_idQuestao` int NOT NULL,
  PRIMARY KEY (`Prova_idProva`,`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Questao1_idx` (`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Questao1` FOREIGN KEY (`Questao_idQuestao`) REFERENCES `Questao` (`idQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prova_has_Questao`
--

LOCK TABLES `Prova_has_Questao` WRITE;
/*!40000 ALTER TABLE `Prova_has_Questao` DISABLE KEYS */;
INSERT INTO `Prova_has_Questao` VALUES (1,1),(1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `Prova_has_Questao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 20:02:52
