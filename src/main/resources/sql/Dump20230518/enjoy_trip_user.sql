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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_login_id` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_salt` varchar(45) NOT NULL,
  `user_profile_image` varchar(200) DEFAULT NULL,
  `user_is_auth` tinyint NOT NULL,
  `user_lock_key` varchar(45) DEFAULT NULL,
  `user_mismatch_cnt` int DEFAULT NULL,
  `user_nickname` varchar(45) NOT NULL,
  `user_auth_key` varchar(45) DEFAULT NULL,
  `user_is_lock` tinyint DEFAULT NULL,
  `user_refresh_token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','1234','t','q','0','',0,NULL,NULL,'test1',NULL,NULL,NULL),(2,'test2','1234','t','q','1',NULL,1,NULL,NULL,'test2',NULL,NULL,NULL),(3,'test3','1234','t','q','1',NULL,1,NULL,NULL,'test3',NULL,NULL,NULL),(4,'test4','1234','t','q','1',NULL,1,NULL,NULL,'test4',NULL,NULL,NULL),(5,'test5','1234','t','q','1',NULL,1,NULL,NULL,'test5',NULL,NULL,NULL),(7,'psg980331','wwCDEUw+4jCjZ7DZo/gtHeSFo/N1FivDgZhK9CXFkJc=','박시균','psg980331@naver.com','LPleQ9fa/nEleSUo1ppG1BrvPG8mHnkl1wci9Xa65n0=','c:\\SSAFY\\upload\\04fe8b11-b74a-4544-a85d-e8414910fc30.jpg',1,'980f3U4NyY',0,'시균팍','tZS27o3J7Q',0,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg0Mzk5MjY3LCJleHAiOjE2ODU2MDg4NjcsImxvZ2luSWQiOiJwc2c5ODAzMzEifQ.fOhynsoXXrDZibszgIKrTMGQbhx4JlRU5ZGhyz0E89c');
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

-- Dump completed on 2023-05-18 17:43:21
