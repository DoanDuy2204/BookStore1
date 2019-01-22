-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: book_store1
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Nguyễn Nhật Ánh','1955-05-07 00:00:00','Bình Quế, Thăng Bình, Quảng Nam'),(2,'Hạ Vũ',NULL,'Hà Nội'),(3,'Cổ Mạn','1981-10-21 00:00:00','Trung Quốc'),(4,'Bát Nguyệt Trường An','1987-08-12 00:00:00','Trung Quốc'),(5,'Fujo fujko','1933-12-01 00:00:00','Tokyo, Nhật Bản'),(6,'Paulo Coelho','1947-08-24 00:00:00','Brazin'),(7,'DaleCarnegie','1888-11-24 00:00:00','NewYork, USA'),(8,'Gosho Aoyama','1963-06-21 00:00:00','Tottori, Nhật Bản'),(9,'Oda Eiichi','1975-01-01 00:00:00','Tokyo, Nhật Bản'),(10,'Ono Eriko','1962-05-05 00:00:00','Nhật Bản'),(11,'One',NULL,'Nhật Bản'),(12,'Robin Sarma','1965-02-22 00:00:00','Canada'),(13,'Lan Rùa',NULL,'Hà Nội'),(14,'Jonasjonasson',NULL,'Đang cập nhật'),(15,'Lâu Vũ Tình',NULL,'Đang cập nhật'),(16,'Phùng Quán','1932-01-21 00:00:00','Hương Thủy, Thừa Thiên Huế'),(17,'Luis Sepulvena',NULL,'Đang cập nhật'),(18,'Antoine de Saint-Exupéry','1900-06-29 00:00:00','Pháp'),(19,'DanielHandler','1970-02-28 00:00:00','USA'),(20,'Phan Huy Chú','1782-10-12 00:00:00','Quốc Oai, Hà Nội'),(21,'Lê Minh Quốc',NULL,'Đang cập nhật'),(22,'Trần Bạch Đằng','1926-04-16 00:00:00','Rạch Giá, Kiên Giang'),(23,'Tạ Chí Đại Trường',NULL,'Đang cập nhật'),(25,'Barak Levi','1991-06-20 00:00:00','Đang cập nhật'),(26,'Nhiều tác giả',NULL,'Đang cập nhật'),(27,'Phan Kế Bình','1875-05-10 00:00:00','Tây Hồ, Hà Nội');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-23 11:42:01
