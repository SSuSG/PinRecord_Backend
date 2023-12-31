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
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel` (
  `travel_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `travel_content` varchar(1000) NOT NULL,
  `travel_start_date` datetime NOT NULL,
  `travel_end_date` datetime NOT NULL,
  `travel_cost` int NOT NULL,
  `travel_created_date` datetime NOT NULL,
  `travel_title` varchar(45) NOT NULL,
  `travel_state` varchar(100) NOT NULL,
  `travel_city` varchar(100) NOT NULL,
  `travel_is_deleted` tinyint NOT NULL,
  PRIMARY KEY (`travel_id`),
  KEY `fk_travel_to_user_user_id_idx` (`user_id`),
  CONSTRAINT `fk_travel_to_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (27,7,'테스트','2023-05-02 07:42:57','2023-05-02 07:42:57',15000,'2023-05-02 16:45:29','강릉','강원도','강릉',1),(28,7,'test2','2023-05-04 00:18:10','2023-05-04 00:18:10',12222,'2023-05-04 09:19:08','속초','강원도','속초',1),(32,7,'서울대입구맛집탐방!!!!','2023-05-16 02:25:44','2023-05-16 02:25:44',50000,'2023-05-16 15:23:37','서울대입구맛집탐방','서울특별시','관악구',0),(35,7,'강남역 맛집 탐방~~~~~~~','2023-05-18 07:34:16','2023-05-18 07:34:16',60000,'2023-05-18 16:47:54','강남역 맛집탐방~~!!','서울특별시','강남구',0),(36,7,'부산여행 너무 좋아요','2023-05-20 00:00:00','2023-05-23 00:00:00',232323,'2023-05-19 15:15:08','부산부산','test','',1),(39,7,'여행재밌어요','2023-05-20 00:00:00','2023-05-23 00:00:00',232323,'2023-05-19 15:21:16','부산여행','test','',1),(42,7,'부산여행좋아요','2023-05-20 00:00:00','2023-05-23 00:00:00',232323,'2023-05-19 15:37:28','부산여행부산여행','test','',1),(43,7,'부산여행 좋아요','2023-05-20 00:00:00','2023-05-23 00:00:00',112313,'2023-05-19 16:10:18','부산여행~~','test','',1),(44,7,'너무 좋아요','2023-05-20 00:00:00','2023-05-23 00:00:00',232323,'2023-05-19 16:19:53','진짜 부산여행 안되면 자살','test','',0);
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
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
