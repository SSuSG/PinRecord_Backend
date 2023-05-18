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
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `pin_id` int DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `fk_image_to_pin_pin_id_idx` (`pin_id`),
  CONSTRAINT `fk_image_to_pin_pin_id` FOREIGN KEY (`pin_id`) REFERENCES `pin` (`pin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (2,23,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(3,24,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(4,24,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(5,25,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(8,28,'c:\\SSAFY\\upload\\SE-1C0CA927-BEE9-466C-AD01-DE988B792573.jpg'),(9,29,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(10,28,'c:\\SSAFY\\upload\\SE-5180159A-36FA-4495-8D81-91D920B0AFF9.jpg'),(11,32,'c:\\SSAFY\\upload\\2022-08-27.jpg'),(12,32,'c:\\SSAFY\\upload\\2023-04-25.jpg'),(13,32,'c:\\SSAFY\\upload\\20221112_143236.jpg'),(15,33,'c:\\SSAFY\\upload\\2022-02-06.jpg'),(16,33,'c:\\SSAFY\\upload\\2023-02-01.jpg'),(17,33,'c:\\SSAFY\\upload\\2022-12-19.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 17:43:21
