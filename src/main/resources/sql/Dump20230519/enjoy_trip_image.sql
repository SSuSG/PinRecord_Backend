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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (2,23,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(3,24,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(4,24,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(5,25,'c:\\SSAFY\\upload\\a0cfcdd6-afb0-4e58-af67-5f3eb898e2af.jpg'),(8,28,'c:\\SSAFY\\upload\\SE-1C0CA927-BEE9-466C-AD01-DE988B792573.jpg'),(9,29,'c:\\SSAFY\\upload\\고기굽는사람들-00.jpg'),(10,28,'c:\\SSAFY\\upload\\SE-5180159A-36FA-4495-8D81-91D920B0AFF9.jpg'),(11,32,'c:\\SSAFY\\upload\\2022-08-27.jpg'),(12,32,'c:\\SSAFY\\upload\\2023-04-25.jpg'),(13,32,'c:\\SSAFY\\upload\\20221112_143236.jpg'),(15,33,'c:\\SSAFY\\upload\\2022-02-06.jpg'),(16,33,'c:\\SSAFY\\upload\\2023-02-01.jpg'),(17,33,'c:\\SSAFY\\upload\\2022-12-19.jpg'),(18,34,'c:\\SSAFY\\upload\\120f2bc9-f681-416a-b17d-ec45fff0d605.jpg'),(19,34,'c:\\SSAFY\\upload\\0051169e-03a3-4906-803d-8339e7e5d6b0.jpg'),(20,35,'c:\\SSAFY\\upload\\9ff2f6a0-e09b-49da-a94e-f69f64ff4f49.jpg'),(21,35,'c:\\SSAFY\\upload\\c4ecdb19-7fb4-4949-b120-eb0466626cf2.jpg'),(22,38,'c:\\SSAFY\\upload\\e12da695-3821-426c-bbab-478e44dd4416.jpg'),(23,38,'c:\\SSAFY\\upload\\15474bff-095b-462e-a5d1-192ff15a2ee9.jpg'),(24,42,'c:\\SSAFY\\upload\\b67e9b90-0da3-45dc-8ece-4ba2980dedb9.jpg'),(25,42,'c:\\SSAFY\\upload\\601177c3-ceb9-44d6-bcaa-de27621aada0.jpg'),(26,43,'c:\\SSAFY\\upload\\8f89c535-2c9a-474a-824f-0444036ba529.jpg'),(27,43,'c:\\SSAFY\\upload\\4479ef8e-5929-4b25-b0af-1487f7c8bbad.jpg'),(28,44,'c:\\SSAFY\\upload\\6afa378e-b90d-4244-ad04-47cc9bece0b9.jpg'),(29,44,'c:\\SSAFY\\upload\\da9d4c45-2e36-41d8-ab87-c4ee9a85e33a.jpg'),(30,45,'c:\\SSAFY\\upload\\11769b62-c20e-4af7-ac30-15d15182ccdf.jpg'),(31,45,'c:\\SSAFY\\upload\\2129a358-eca1-4a2b-b83e-36af22b8b7a1.jpg'),(32,46,'c:\\SSAFY\\upload\\c34b13a5-566d-4f1b-bbc2-76b9147764fe.jpg'),(33,46,'c:\\SSAFY\\upload\\ce5b6b7a-36eb-48fe-a8ac-5771206eba7e.jpg'),(34,47,'c:\\SSAFY\\upload\\00b203c5-2011-4954-8b05-0aa331dffbf4.jpg'),(35,47,'c:\\SSAFY\\upload\\efae2d6c-e34c-40ba-a830-711d49116bbf.jpg');
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

-- Dump completed on 2023-05-19 17:39:49
