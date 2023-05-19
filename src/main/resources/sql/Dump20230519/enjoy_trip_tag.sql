-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoy_trip
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(45) NOT NULL,
  `pin_id` int DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `fk_tag_to_pin_pin_id_idx` (`pin_id`),
  CONSTRAINT `fk_tag_to_pin_pin_id` FOREIGN KEY (`pin_id`) REFERENCES `pin` (`pin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (3,'서울대입구역',28),(4,'덮밥',28),(5,'서울대입구역',29),(6,'고굽사',29),(7,'고깃집',29),(18,'일식',32),(19,'스테이크',32),(20,'덮밥',32),(21,'맛집',32),(22,'강남역',32),(23,'고기',33),(24,'강남역',33),(25,'맛집',33),(26,'김치찌개',33),(27,'부산',34),(28,'바다',34),(29,'해운대',34),(30,'해수욕장',34),(31,'부산',35),(32,'동백섬',35),(33,'산책',35),(34,'섬',35),(43,'부산',38),(44,'바다',38),(45,'해운대',38),(46,'해수욕장',38),(47,'부산',39),(48,'동백섬',39),(49,'산책',39),(58,'부산',42),(59,'해운대',42),(60,'해수욕장',42),(61,'바다',42),(62,'부산',43),(63,'동백섬',43),(64,'산책',43),(65,'섬',43),(66,'부산',44),(67,'해운대',44),(68,'바다',44),(69,'해수욕장',44),(70,'부산',45),(71,'동백섬',45),(72,'산책',45),(73,'부산',46),(74,'해운대',46),(75,'해수욕장',46),(76,'바다',46),(77,'부산',47),(78,'동백섬',47),(79,'산책',47),(80,'섬',47);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-19 17:39:50
