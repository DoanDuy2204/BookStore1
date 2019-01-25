-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `catelogy_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `discount` double NOT NULL,
  `image_link` varchar(45) DEFAULT NULL,
  `doc` datetime NOT NULL,
  `view` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `publishouse_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`catelogy_id`),
  KEY `id_idx1` (`publishouse_id`),
  CONSTRAINT `catelogy_id` FOREIGN KEY (`catelogy_id`) REFERENCES `catelogies` (`id`),
  CONSTRAINT `publishouse_id` FOREIGN KEY (`publishouse_id`) REFERENCES `publishing_houses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (3,'HÃ³a há»c 9',1,45000,35,'hoahoc9','2018-11-21 00:00:00',30,200,4),(4,'Hóa học 12',1,45000,30,'hoahoc12','2018-05-16 00:00:00',20,100,1),(5,'Tiếng việt 3',1,35000,30,'tiengviet3','2018-11-19 00:00:00',30,100,1),(6,'Toán 4',1,52000,30,'toan4','2018-11-19 00:00:00',20,100,1),(7,'Toán 9',1,38000,30,'toan9','2018-11-19 00:00:00',20,100,2),(8,'Vật lý 8',1,32000,30,'vatli8','2018-11-19 00:00:00',30,100,2),(9,'Vật lý 9',1,38000,30,'vatli9','2018-11-19 00:00:00',40,100,2),(10,'Vật lý 12',1,47000,30,'vatli12','2018-11-19 00:00:00',50,100,3),(11,'Vật lý 7',1,42000,30,'vatli7','2018-11-19 00:00:00',20,100,2),(12,'Vở bt toán 2',1,25000,30,'vobttoan2','2018-11-19 00:00:00',30,100,2),(13,'Vở bt toán 5',1,30000,30,'vobttoan5','2018-11-19 00:00:00',20,100,2),(14,'Cáo thơm trước đèn',2,100000,20,'caothomtruocden','2018-05-18 00:00:00',30,100,1),(15,'Đại việt sử kí toàn thư',2,33000,50,'daivietsukitoanthu','2018-11-19 00:00:00',30,100,2),(16,'Kể chuyện danh nhân Việt Nam',2,299000,30,'kechuyendanhnhanvietnam1','2018-11-19 00:00:00',20,100,3),(17,'Kể chuyện danh nhân Việt Nam 6',2,299000,30,'kechuyendanhnhanvietnam6','2018-04-18 00:00:00',30,100,1),(18,'Lịch sử nội chiến Việt Nam',2,245000,25,'lichsunoichienvietnam','2018-11-19 00:00:00',32,100,2),(19,'Lịch sử Việt Nam bằng tranh',2,110000,51,'lichsuvietnambangtranh','2018-11-19 00:00:00',20,100,1),(20,'Nam quốc sơn hà',2,85000,30,'namquocsonha','2018-11-19 00:00:00',30,100,1),(21,'Người thắp lửa',2,100000,30,'nguoithaplua','2018-11-19 00:00:00',32,100,3),(22,'Việt nam phong tục',2,75000,27,'vietnamphongtuc','2018-11-19 00:00:00',20,100,2),(23,'Chuyện con mèo dạy hải âu bay',3,45000,15,'chuyenconmeodayhaiaubay','2018-11-19 00:00:00',20,100,2),(24,'Có hai con mèo ngoài cửa sổ',3,50000,35,'cohaiconmeo','2018-11-19 00:00:00',20,100,2),(25,'Đảo mộng mơ',3,75000,25,'daomongmo','2018-11-19 00:00:00',12,100,1),(26,'Hoàng tử bé',3,35000,30,'hoangtube','2018-11-19 00:00:00',21,100,1),(27,'Ngôi trường mọi khi',3,65000,27,'ngoitruongmoikhi','2018-11-19 00:00:00',21,100,2),(28,'Vì sao tớ yêu bố',3,45000,45,'visaotoyeubo','2018-11-19 00:00:00',12,100,3),(29,'Anh chỉ là thanh xuân của em',4,65000,30,'anhchilathanhxuancuaem','2018-11-19 00:00:00',21,100,2),(30,'Bảy bước tới mùa hè',4,80000,27,'baybuoctoimuahe','2018-11-19 00:00:00',21,100,1),(31,'Chuyện về những người cô đơn',4,65000,20,'chuyenvenhungnguoicodon','2018-11-19 00:00:00',5,100,2),(32,'Đắc nhân tâm',4,120000,35,'dacnhantam','2018-11-19 00:00:00',15,100,4),(33,'Đơi ngắn đừng ngủ dài',4,65000,33,'doingandungngudai','2018-11-19 00:00:00',23,100,4),(34,'Lẽ nào em không biết',4,82000,32,'lenaoemkhongbiet','2018-11-19 00:00:00',35,100,1),(35,'Nhà giả kim',4,42000,52,'nhagiakim','2018-11-19 00:00:00',56,100,2),(36,'Nhận biết cơ hội thành công',4,53000,27,'nhanbietcohoithanhcong','2018-11-19 00:00:00',56,100,3),(37,'Ông trăm tuổi',4,45000,32,'ongtramtuoi','2018-11-19 00:00:00',85,100,4),(38,'Thất tình không mùa',4,55000,45,'thattinhkhongmua','2018-11-19 00:00:00',95,100,2),(39,'Thời thanh xuân đẹp nhất của chúng ta',4,42000,42,'thoithanhxuancuachungta','2018-11-19 00:00:00',12,100,3),(40,'Tôi thấy hoa vàng trên cỏ xanh',4,150000,35,'toithayhoavangtrencoxanh','2018-11-19 00:00:00',21,100,2),(41,'Tuổi thơ dữ dội',4,250000,25,'tuoithodudoi','2018-11-19 00:00:00',21,100,1),(42,'Yêu em từ cái nhìn đầu tiên',4,89000,30,'yeuemtucainhindautien','2018-11-19 00:00:00',32,100,2),(43,'Conan 1',5,25000,25,'conan1','2018-11-19 00:00:00',125,100,2),(44,'Conan 21',5,25000,25,'conan21','2018-11-19 00:00:00',21,100,3),(45,'Conan 26',5,25000,25,'conan26','2018-11-19 00:00:00',21,100,2),(46,'Conan 35',5,25000,25,'conan35','2018-11-19 00:00:00',21,100,3),(47,'Conan 42',5,25000,25,'conan42','2018-11-19 00:00:00',12,100,4),(48,'Conan 62',5,25000,25,'conan62','2018-11-19 00:00:00',23,100,4),(49,'Conan 72',5,25000,25,'conan72','2018-11-19 00:00:00',32,100,4),(50,'Conan 86',5,25000,25,'conan86','2018-11-19 00:00:00',12,100,2),(51,'Conan 91',5,25000,25,'conan91','2018-11-19 00:00:00',21,100,3),(52,'Conan 92',5,25000,25,'conan92','2018-11-19 00:00:00',21,100,2),(53,'Conan 93',5,25000,25,'conan93','2018-11-19 00:00:00',2,100,1),(54,'Conan đặc biệt',5,45000,50,'conandacbiet','2018-11-19 00:00:00',1,100,2),(55,'Đô rê mon 1',5,27800,50,'doremon1','2018-11-19 00:00:00',21,100,2),(56,'Đô rê mon 6',5,27800,50,'doremon6','2018-11-19 00:00:00',1,100,3),(57,'Đô rê mon đại tuyển tập',5,110000,50,'doremondaituyentap','2018-11-19 00:00:00',2,100,2),(58,'Hunterxhunter',5,52000,35,'hunterxhunter','2018-11-19 00:00:00',21,100,4),(59,'Miko 2',5,30000,30,'miko3','2018-11-19 00:00:00',21,100,4),(60,'Miko 3',5,30000,30,'miko3','2018-11-19 00:00:00',12,100,2),(61,'Miko 10',5,30000,30,'miko10','2018-11-19 00:00:00',1,100,3),(62,'Miko đặc biệt',5,42000,30,'mikodacbiet','2018-11-19 00:00:00',2,100,4),(63,'Onepiece 3',5,25000,25,'onepiece3','2018-11-19 00:00:00',12,100,2),(64,'Onepiece 86',5,25000,25,'onepiece86','2018-11-19 00:00:00',20,100,3),(65,'One punch 1',5,25000,20,'onepunch1','2018-11-19 00:00:00',12,100,2),(66,'One punch 2',5,25000,20,'onepunch2','2018-11-19 00:00:00',1,100,1),(68,'Hinh hoc 12',1,35000,35,NULL,'2018-12-05 00:00:00',0,15,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-23 11:42:00
