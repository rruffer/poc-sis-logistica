CREATE DATABASE  IF NOT EXISTS `dblogistica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dblogistica`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.99.100    Database: dblogistica
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID` bigint(20) NOT NULL,
  `CNPJ` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ENDERECO_ID` varchar(255) DEFAULT NULL,
  `INSC_ESTADUAL` varchar(255) DEFAULT NULL,
  `INSC_MUNICIPAL` varchar(255) DEFAULT NULL,
  `RAZAO_SOCIAL` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'1111','teste@teste','rue teste',NULL,NULL,'Itens Raros LTDA','11111');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (19);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacao`
--

DROP TABLE IF EXISTS `solicitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacao` (
  `id` bigint(20) NOT NULL,
  `dateCadastro` datetime DEFAULT NULL,
  `dateColeta` datetime DEFAULT NULL,
  `dateEntrega` datetime DEFAULT NULL,
  `ID_ENDERECO_COLETA` varchar(255) DEFAULT NULL,
  `ID_ENDERECO_ENTREGA` varchar(255) DEFAULT NULL,
  `ID_CLIENTE` bigint(20) DEFAULT NULL,
  `coletado` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `natureza` varchar(255) DEFAULT NULL,
  `observacao` longtext,
  `quantidade` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2niicvptoguxqaisvh7r9pij` (`ID_CLIENTE`),
  CONSTRAINT `FKj2niicvptoguxqaisvh7r9pij` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
INSERT INTO `solicitacao` VALUES (15,'2018-10-07 14:23:15','2018-10-10 17:13:53',NULL,'Rua Doutor Manuel Reis N 300 Duque de caxias. RJ','Rua Conde de Mauá N 456, Caju, RJ',1,0,'PENDENTE',NULL,NULL,NULL,NULL,NULL),(16,'2018-09-20 14:41:31','2018-10-01 17:13:53','2018-10-07 17:13:53','Rua do Catete N 1500, Flamengo, RJ','Rua Presidente Vargas N 548 Centro, RJ',1,1,'RECEBIDO',NULL,NULL,NULL,NULL,NULL),(17,'2018-10-08 02:17:30','2018-10-08 05:07:41','2018-10-08 05:07:41','Rua Eleonel N 500, Olinda MG','Rua Clonildo N1500, Rio de janeiro RJ',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'2018-10-08 02:35:30','2018-10-08 05:07:41','2018-10-08 05:07:41','Rua Eleonel N 500, Olinda MG','Rua Clonildo N1500, Rio de janeiro RJ',1,NULL,NULL,'solida','solida','Este produto deve ser transportado com muito cuidado',20,15.7);
/*!40000 ALTER TABLE `solicitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `matricula` int(11) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `funcao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,111,'F6E0A1E2AC41945A9AA7FF8A8AAA0CEBC12A3BCC981A929AD5CF810A090E11AE','Rodolfo Ruffer','Administrador');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-07 23:37:01
