-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.14

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `discount` double NOT NULL,
  `image_link` varchar(45) DEFAULT NULL,
  `doc` datetime NOT NULL,
  `view` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `publishinghouse_id` int(11) NOT NULL,
  `sold_number` varchar(45) DEFAULT NULL,
  `star` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`category_id`),
  KEY `id_idx1` (`publishinghouse_id`),
  CONSTRAINT `catelogy_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `publishouse_id` FOREIGN KEY (`publishinghouse_id`) REFERENCES `publishing_houses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Hóa học 9',1,45000,35,'hoahoc9.jpg','2018-11-21 00:00:00',30,200,4,'100',NULL),(2,'Hóa học 12',1,45000,30,'hoahoc12.jpg','2018-05-16 00:00:00',20,100,1,'100',NULL),(3,'Tiếng việt 3',1,35000,30,'tiengviet3.jpg','2018-11-19 00:00:00',30,100,1,'100',NULL),(4,'Toán 4',1,52000,30,'toan4.jpg','2018-11-19 00:00:00',20,100,1,'100',NULL),(5,'Toán 9',1,38000,30,'toan9.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(6,'Vật lý 8',1,32000,30,'vatli8.jpg','2018-11-19 00:00:00',30,100,2,'100',NULL),(7,'Vật lý 9',1,38000,30,'vatli9.jpg','2018-11-19 00:00:00',40,100,2,'100',NULL),(8,'Vật lý 12',1,47000,30,'vatli12.jpg','2018-11-19 00:00:00',50,100,3,'100',NULL),(9,'Vật lý 7',1,42000,30,'vatli7.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(10,'Vở bt toán 2',1,25000,30,'vobttoan2.jpg','2018-11-19 00:00:00',30,100,2,'100',NULL),(11,'Vở bt toán 5',1,30000,30,'vobttoan5.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(12,'Cáo thơm trước đèn',2,100000,20,'caothomtruocden.jpg','2018-05-18 00:00:00',30,100,1,'100',NULL),(13,'Đại việt sử kí toàn thư',2,33000,50,'daivietsukitoanthu.jpg','2018-11-19 00:00:00',30,100,2,'100',NULL),(14,'Kể chuyện danh nhân Việt Nam',2,299000,30,'kechuyendanhnhanvietnam1.jpg','2018-11-19 00:00:00',20,100,3,'100',NULL),(15,'Kể chuyện danh nhân Việt Nam 6',2,299000,30,'kechuyendanhnhanvietnam6.jpg','2018-04-18 00:00:00',30,100,1,'100',NULL),(16,'Lịch sử nội chiến Việt Nam',2,245000,25,'lichsunoichienvietnam.jpg','2018-11-19 00:00:00',32,100,2,'100',NULL),(17,'Lịch sử Việt Nam bằng tranh',2,110000,51,'lichsuvietnambangtranh.jpg','2018-11-19 00:00:00',20,100,1,'100',NULL),(18,'Nam quốc sơn hà',2,85000,30,'namquocsonha.jpg','2018-11-19 00:00:00',30,100,1,'100',NULL),(19,'Người thắp lửa',2,100000,30,'nguoithaplua.jpg','2018-11-19 00:00:00',32,100,3,'100',NULL),(20,'Việt nam phong tục',2,75000,27,'vietnamphongtuc.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(21,'Chuyện con mèo dạy hải âu bay',3,45000,15,'chuyenconmeodayhaiaubay.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(22,'Có hai con mèo ngoài cửa sổ',3,50000,35,'cohaiconmeo.jpg','2018-11-19 00:00:00',20,100,2,'100',NULL),(23,'Đảo mộng mơ',3,75000,25,'daomongmo.jpg','2018-11-19 00:00:00',12,100,1,'100',NULL),(24,'Hoàng tử bé',3,35000,30,'hoangtube.jpg','2018-11-19 00:00:00',21,100,1,'100',NULL),(25,'Ngôi trường mọi khi',3,65000,27,'ngoitruongmoikhi.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(26,'Vì sao tớ yêu bố',3,45000,45,'visaotoyeubo.jpg','2018-11-19 00:00:00',12,100,3,'100',NULL),(27,'Anh chỉ là thanh xuân của em',4,65000,30,'anhchilathanhxuancuaem.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(28,'Bảy bước tới mùa hè',4,80000,27,'baybuoctoimuahe.jpg','2018-11-19 00:00:00',21,100,1,'100',NULL),(29,'Chuyện về những người cô đơn',4,65000,20,'chuyenvenhungnguoicodon.jpg','2018-11-19 00:00:00',5,100,2,'100',NULL),(30,'Đắc nhân tâm',4,120000,35,'dacnhantam.jpg','2018-11-19 00:00:00',15,100,4,'100',NULL),(31,'Đơi ngắn đừng ngủ dài',4,65000,33,'doingandungngudai.jpg','2018-11-19 00:00:00',23,100,4,'100',NULL),(32,'Lẽ nào em không biết',4,82000,32,'lenaoemkhongbiet.jpg','2018-11-19 00:00:00',35,100,1,'100',NULL),(33,'Nhà giả kim',4,42000,52,'nhagiakim.jpg','2018-11-19 00:00:00',56,100,2,'100',NULL),(34,'Nhận biết cơ hội thành công',4,53000,27,'nhanbietcohoithanhcong.jpg','2018-11-19 00:00:00',56,100,3,'100',NULL),(35,'Ông trăm tuổi',4,45000,32,'ongtramtuoi.jpg','2018-11-19 00:00:00',85,100,4,'100',NULL),(36,'Thất tình không mùa',4,55000,45,'thattinhkhongmua.jpg','2018-11-19 00:00:00',95,100,2,'100',NULL),(37,'Thời thanh xuân đẹp nhất của chúng ta',4,42000,42,'thoithanhxuancuachungta.jpg','2018-11-19 00:00:00',12,100,3,'100',NULL),(38,'Tôi thấy hoa vàng trên cỏ xanh',4,150000,35,'toithayhoavangtrencoxanh.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(39,'Tuổi thơ dữ dội',4,250000,25,'tuoithodudoi.jpg','2018-11-19 00:00:00',21,100,1,'100',NULL),(40,'Yêu em từ cái nhìn đầu tiên',4,89000,30,'yeuemtucainhindautien.jpg','2018-11-19 00:00:00',32,100,2,'100',NULL),(41,'Conan 1',5,25000,25,'conan1.jpg','2018-11-19 00:00:00',125,100,2,'100',NULL),(42,'Conan 21',5,25000,25,'conan21.jpg','2018-11-19 00:00:00',21,100,3,'100',NULL),(43,'Conan 26',5,25000,25,'conan26.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(44,'Conan 35',5,25000,25,'conan35.jpg','2018-11-19 00:00:00',21,100,3,'100',NULL),(45,'Conan 42',5,25000,25,'conan42.jpg','2018-11-19 00:00:00',12,100,4,'100',NULL),(46,'Conan 62',5,25000,25,'conan62.jpg','2018-11-19 00:00:00',23,100,4,'100',NULL),(47,'Conan 72',5,25000,25,'conan72.jpg','2018-11-19 00:00:00',32,100,4,'100',NULL),(48,'Conan 86',5,25000,25,'conan86.jpg','2018-11-19 00:00:00',12,100,2,'100',NULL),(49,'Conan 91',5,25000,25,'conan91.jpg','2018-11-19 00:00:00',21,100,3,'100',NULL),(50,'Conan 92',5,25000,25,'conan92.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(51,'Conan 93',5,25000,25,'conan93.jpg','2018-11-19 00:00:00',2,100,1,'100',NULL),(52,'Conan đặc biệt',5,45000,50,'conandacbiet.jpg','2018-11-19 00:00:00',1,100,2,'100',NULL),(53,'Đô rê mon 1',5,27800,50,'doremon1.jpg','2018-11-19 00:00:00',21,100,2,'100',NULL),(54,'Đô rê mon 6',5,27800,50,'doremon6.jpg','2018-11-19 00:00:00',1,100,3,'100',NULL),(55,'Đô rê mon đại tuyển tập',5,110000,50,'doremondaituyentap.jpg','2018-11-19 00:00:00',2,100,2,'100',NULL),(56,'Hunterxhunter',5,52000,35,'hunterxhunter.jpg','2018-11-19 00:00:00',21,100,4,'100',NULL),(57,'Miko 2',5,30000,30,'miko3.jpg','2018-11-19 00:00:00',21,100,4,'100',NULL),(58,'Miko 3',5,30000,30,'miko3.jpg','2018-11-19 00:00:00',12,100,2,'100',NULL),(59,'Miko 10',5,30000,30,'miko10.jpg','2018-11-19 00:00:00',1,100,3,'100',NULL),(60,'Miko đặc biệt',5,42000,30,'mikodacbiet.jpg','2018-11-19 00:00:00',2,100,4,'100',NULL),(61,'Onepiece 3',5,25000,25,'onepiece3.jpg','2018-11-19 00:00:00',12,100,2,'100',NULL),(62,'Onepiece 86',5,25000,25,'onepiece86.jpg','2018-11-19 00:00:00',20,100,3,'100',NULL),(63,'One punch 1',5,25000,20,'onepunch1.jpg','2018-11-19 00:00:00',12,100,2,'100',NULL),(64,'One punch 2',5,25000,20,'onepunch2.jpg','2018-11-19 00:00:00',1,100,1,'100',NULL),(65,'Hinh hoc 12',1,35000,35,'hinhhoc12.jpg','2018-12-05 00:00:00',0,15,3,'100',NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-01 21:30:24
