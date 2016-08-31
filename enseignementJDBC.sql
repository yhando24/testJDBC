-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: ecole
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe` (
  `cla_id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_nom` varchar(45) NOT NULL,
  PRIMARY KEY (`cla_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_matiere`
--

DROP TABLE IF EXISTS `classe_matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_matiere` (
  `clm_mat_id` int(11) NOT NULL,
  `clm_pro_id` int(11) NOT NULL,
  `clm_cla_id` int(11) NOT NULL,
  PRIMARY KEY (`clm_mat_id`,`clm_pro_id`,`clm_cla_id`),
  KEY `fk_clm_map_professeur_idx` (`clm_pro_id`),
  KEY `fk_cla_id_idx` (`clm_cla_id`),
  CONSTRAINT `fk_clm_matiere_professeur` FOREIGN KEY (`clm_mat_id`, `clm_pro_id`) REFERENCES `matiere_professeur` (`map_mat_id`, `map_pro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_clm_classe` FOREIGN KEY (`clm_cla_id`) REFERENCES `classe` (`cla_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_matiere`
--

LOCK TABLES `classe_matiere` WRITE;
/*!40000 ALTER TABLE `classe_matiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `classe_matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleve` (
  `ele_id` int(11) NOT NULL,
  `ele_nom` varchar(45) NOT NULL,
  `ele_prenom` varchar(45) NOT NULL,
  `ele_cla_id` int(11) NOT NULL,
  PRIMARY KEY (`ele_id`),
  KEY `fk_cla_id_idx` (`ele_cla_id`),
  CONSTRAINT `fk_cla_id` FOREIGN KEY (`ele_cla_id`) REFERENCES `classe` (`cla_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleve`
--

LOCK TABLES `eleve` WRITE;
/*!40000 ALTER TABLE `eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matiere` (
  `mat_id` int(11) NOT NULL AUTO_INCREMENT,
  `mat_nom` varchar(50) NOT NULL,
  PRIMARY KEY (`mat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matiere`
--

LOCK TABLES `matiere` WRITE;
/*!40000 ALTER TABLE `matiere` DISABLE KEYS */;
INSERT INTO `matiere` VALUES (1,'Mathématiques'),(2,'Informatique'),(3,'Français'),(4,'Philosophie'),(5,'Histoire'),(6,'Géographie'),(7,'SVT'),(8,'EPS'),(9,'Musique'),(10,'Dessin');
/*!40000 ALTER TABLE `matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matiere_professeur`
--

DROP TABLE IF EXISTS `matiere_professeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matiere_professeur` (
  `map_mat_id` int(11) NOT NULL,
  `map_pro_id` int(11) NOT NULL,
  PRIMARY KEY (`map_mat_id`,`map_pro_id`),
  KEY `fk_professeur_idx` (`map_pro_id`),
  CONSTRAINT `fk_matiere` FOREIGN KEY (`map_mat_id`) REFERENCES `matiere` (`mat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_professeur` FOREIGN KEY (`map_pro_id`) REFERENCES `professeur` (`pro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matiere_professeur`
--

LOCK TABLES `matiere_professeur` WRITE;
/*!40000 ALTER TABLE `matiere_professeur` DISABLE KEYS */;
/*!40000 ALTER TABLE `matiere_professeur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professeur` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_nom` varchar(45) NOT NULL,
  `pro_prenom` varchar(45) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professeur`
--

LOCK TABLES `professeur` WRITE;
/*!40000 ALTER TABLE `professeur` DISABLE KEYS */;
INSERT INTO `professeur` VALUES (1,'Enrick','Rick'),(2,'Carton','John'),(3,'Karos','Rosse'),(4,'Ramos','Mose'),(5,'Caliri','Ris'),(6,'Solmineur','Eur');
/*!40000 ALTER TABLE `professeur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-10 11:56:41
