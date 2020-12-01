-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: abob
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `m_id` varchar(20) DEFAULT NULL,
  `m_pw` varchar(20) DEFAULT NULL,
  `m_name` varchar(20) DEFAULT NULL,
  `m_sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'qkdrmsgh','qkdrmsgh','방근호','남');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `cook_time` int DEFAULT NULL,
  `food_type` varchar(10) DEFAULT NULL,
  `str_id` int DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `str_id` (`str_id`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`str_id`) REFERENCES `store` (`str_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'부리또',4000,600,'양식',0),(2,'불닭마요',3700,420,'한식',0),(3,'짜장면',4500,600,'중식',0),(4,'밥버거',4000,300,'한식',0),(5,'즉석떡볶이',6000,900,'한식',0),
(6,'치즈돈가스',6000,900,'일식',1),(7,'불고기',6000,780,'한식'1),(8,'돼지김치찌개',6000,600,'한식',1),(9,'미트볼스파게티',6000,840,'양식',1),(10,'떡갈비',6000,780,'한식',1),
(11,'숯불직화구이',6000,600,'한식',2)(12,'우동',4000,4200,'일식',2),(13,'떡라면',3000,360,'한식',2),(14,'김치볶음밥',4000,600,'한식',2),(15,'로제스파게티',5000,600,'양식',2),
(16,'순대국',6000,480,'한식',3),(17,'김밥',2500,300,'한식',3),(18,'회덮밥',5500,420,'한식',3),(19,'치즈스테이크',4000,600,'양식',3),(20,'설렁탕',5500,300,'한식',3),
(21,'치킨샐러드',5000,120,'양식',4),(22,'해물짬뽕',6000,780,'중식',4),(23,'쫄면',4000,300,'한식',4),(24,'빠네크림파스타',6000,720,'양식',4),(25,'닭볶음탕',6000,360,'한식',4);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `str_id` int NOT NULL AUTO_INCREMENT,
  `str_name` varchar(20) DEFAULT NULL,
  `loc` varchar(20) DEFAULT NULL,
  `loc_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`str_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (0,'비전타워 식당상가','비전타워',),(1,'비전타워 학생식당','비전타워','123,234'),(2,'예술대학1 학생식당','예술대학1','124,254'),(3,'가천관 지하 푸드코트','가천관',),(4,'교육대학 학생식당','교육대학',);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-24 20:31:01
