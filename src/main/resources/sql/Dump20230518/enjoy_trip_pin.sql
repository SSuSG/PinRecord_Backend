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
-- Table structure for table `pin`
--

DROP TABLE IF EXISTS `pin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pin` (
  `pin_id` int NOT NULL AUTO_INCREMENT,
  `pin_place_name` varchar(100) NOT NULL,
  `pin_place_url` varchar(100) NOT NULL,
  `pin_category_name` varchar(100) NOT NULL,
  `pin_address_name` varchar(100) NOT NULL,
  `pin_road_address_name` varchar(100) DEFAULT NULL,
  `pin_phone` varchar(45) DEFAULT NULL,
  `pin_category_group_code` varchar(45) DEFAULT NULL,
  `pin_category_group_name` varchar(100) DEFAULT NULL,
  `pin_x` double NOT NULL,
  `pin_y` double NOT NULL,
  `travel_id` int DEFAULT NULL,
  `pin_content` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`pin_id`),
  KEY `fk_pin_to_record_record_id_idx` (`travel_id`),
  CONSTRAINT `fk_pin_to_travel_travel_id` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`travel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pin`
--

LOCK TABLES `pin` WRITE;
/*!40000 ALTER TABLE `pin` DISABLE KEYS */;
INSERT INTO `pin` VALUES (23,'qweqwe','asdasd','rrr','qqq','zxczxc',NULL,'www','eee',123,321,27,'qweqwe'),(24,'qweqwe','asdasd','aaa','qqq','zxczxc',NULL,'www','ffd',123,123123,27,'asdasd'),(25,'ㅂㅈㄷㅂㅈㄷ','ㅁㄴㅇㅁㄴㅇ','asdasd','qqq','ㅋㅌㅊㅋㅌㅊ',NULL,'ww','eee',1212,2323,28,'테스트22'),(28,'킷사서울','http://place.map.kakao.com/1153635092','음식점 > 일식','서울 관악구 봉천동 1603-3','서울 관악구 남부순환로226길 31',NULL,'FD6','음식점',126.95376,37.479195,32,'맛도리네~'),(29,'고기굽는사람들 샤로수길본점','http://place.map.kakao.com/563659414','음식점 > 한식 > 육류,고기','서울 관악구 봉천동 1619-1','서울 관악구 관악로14길 70',NULL,'FD6','음식점',126.95645,37.47824,32,'맛도리33333'),(32,'미도인 강남','http://place.map.kakao.com/1804968253','음식점 > 퓨전요리 > 퓨전일식','서울 강남구 역삼동 619-3','서울 강남구 강남대로102길 16',NULL,'FD6','음식점',127.02719,37.5021,35,'맛도리집이야'),(33,'육품','http://place.map.kakao.com/1648266796','음식점 > 한식 > 육류,고기','서울 서초구 서초동 1308-16','서울 서초구 강남대로65길 12',NULL,'FD6','음식점',127.024796,37.500496,35,'고기 야미');
/*!40000 ALTER TABLE `pin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 17:43:22
