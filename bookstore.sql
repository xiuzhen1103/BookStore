/*
SQLyog Enterprise v10.42 
MySQL - 5.5.28 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `bookstore`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `shippingAddress` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `paymentMethod` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `account` */

insert  into `account`(`accountId`,`customerId`,`shippingAddress`,`paymentMethod`,`balance`) values (2,1,'Aungier Street','Debit Card',10000),(3,1,'DIT, DUBLIN','Credit Card',10000),(4,1,'DIT, DUBLIN','Credit Card',10000),(5,1,'DIT, DUBLIN','Credit Card',10000),(6,3,'DIT, DUBLIN','Credit Card',19669.74);

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `administrator` */

insert  into `administrator`(`adminId`,`username`,`password`) values (1,'zhen','zhen');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `imagePath` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `book` */

insert  into `book`(`bookId`,`title`,`author`,`price`,`quantity`,`categoryId`,`imagePath`) values (1,'Mother Care','Angelico',33,7,4,'baby.jpg'),(2,'Java ','1',20.89,7,1,'java.jpg'),(3,'Testing Programming','Linda',37.08,6,2,'testing.jpg'),(4,'Testing Programming','Linda',37.08,6,3,'testing.jpg'),(5,'Testing Programming','Linda',37.08,9,3,'testing.jpg'),(6,'Testing Programming','Linda',37.08,9,4,'testing.jpg'),(7,'Ruby on rail','Linda',37.08,9,2,'testing.jpg'),(8,'Ruby on rail','Linda',37.08,9,2,'testing.jpg'),(9,'Ruby on rail','Linda',37.08,9,2,'testing.jpg'),(10,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(11,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(12,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(13,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(14,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(15,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(16,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(17,'Testing Programming','Linda',37.08,9,6,'testing.jpg'),(18,'Ruby on rail','Linda',37.08,9,7,'testing.jpg'),(19,'Ruby on rail','Linda',37.08,9,7,'testing.jpg'),(20,'Art of History','Linda',37.08,9,2,NULL),(21,'Testing Programming','Linda',37.08,9,4,'testing.jpg'),(22,'Java ','1',20.89,9,5,'1');

/*Table structure for table `booktopic` */

DROP TABLE IF EXISTS `booktopic`;

CREATE TABLE `booktopic` (
  `booktopicId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) DEFAULT NULL,
  `topicId` int(11) DEFAULT NULL,
  PRIMARY KEY (`booktopicId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `booktopic` */

insert  into `booktopic`(`booktopicId`,`bookId`,`topicId`) values (1,2,2),(2,6,2),(3,7,2),(4,7,1),(5,8,1),(6,8,2),(7,9,2),(8,9,1),(9,9,2),(10,9,1),(11,10,1),(12,10,2),(13,10,1),(14,10,2),(15,11,2),(16,11,1),(17,11,1),(18,11,2),(19,12,1),(20,12,2),(21,12,1),(22,12,2),(23,13,1),(24,13,2),(25,13,2),(26,13,1),(27,14,1),(28,14,2),(29,14,2),(30,14,1),(31,15,2),(32,15,1),(33,15,2),(34,15,1),(35,16,1),(36,16,2),(37,16,1),(38,16,2),(39,17,1),(40,17,2),(41,17,2),(42,17,1),(43,18,2),(44,18,1),(45,18,1),(46,18,2),(47,19,1),(48,19,2),(49,19,1),(50,19,2),(51,20,1),(52,20,2),(53,21,1),(54,22,2),(55,22,1),(56,23,2),(57,23,1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `category` */

insert  into `category`(`categoryId`,`categoryName`) values (1,'Science'),(2,'Lifes'),(3,'Programming'),(4,'Programming'),(5,'Hibernate'),(6,'Quality Assurance'),(7,'Moive');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) DEFAULT NULL,
  `rate` int(10) DEFAULT NULL,
  `comment` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `comment` */

insert  into `comment`(`commentId`,`bookId`,`rate`,`comment`,`createTime`,`customerId`) values (2,2,NULL,NULL,'2014-04-04 16:26:23',3),(3,2,NULL,NULL,'2014-04-04 16:35:29',4),(4,2,NULL,NULL,'2014-04-04 16:37:26',3),(5,2,NULL,NULL,'2014-04-04 16:37:30',3),(6,2,NULL,NULL,'2014-04-04 16:38:03',4),(7,2,NULL,NULL,'2014-04-04 16:41:17',1),(8,2,NULL,NULL,'2014-04-04 16:41:39',1),(9,2,NULL,NULL,'2014-04-04 16:43:39',1),(10,3,NULL,NULL,'2014-04-04 16:44:36',1),(11,2,1,'df','2014-04-05 10:20:50',1),(12,2,1,'test','2014-04-05 10:21:40',1),(13,3,2,'df','2014-04-05 10:31:44',1),(14,3,2,'df','2014-04-05 10:33:59',1),(15,2,1,'df','2014-04-05 12:39:27',NULL),(16,1,2,'df','2014-04-05 13:30:57',NULL),(17,1,0,'','2014-04-05 14:55:36',1),(18,1,0,'aaaaa','2014-04-06 22:46:56',3),(19,1,2,'bbbbbb','2014-04-06 22:47:47',3),(20,5,2,'test5','2014-04-06 22:49:50',3),(21,3,0,'saaaa','2014-04-07 22:35:41',3),(22,1,0,'tttttttt','2014-04-07 22:39:57',3),(23,4,1,'????±??é','2014-04-07 22:40:24',3),(24,4,1,'luan ma ','2014-04-07 22:40:42',3);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `customer` */

insert  into `customer`(`customerId`,`username`,`password`,`name`,`address`,`phone`) values (1,'xiuzhen','12345','xiuzhen','DIT','0871234776'),(3,'Fiona','1','1','1','0197834'),(4,'','','','','');

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `orderId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orderitem` */

insert  into `orderitem`(`orderItemId`,`price`,`quantity`,`createTime`,`orderId`,`bookId`) values (2,37.08,10,'2014-04-07 20:28:45',5,3),(3,37.08,6,'2014-04-07 20:29:50',5,18),(4,37.08,3,'2014-04-07 20:39:58',6,3),(5,37.08,3,'2014-04-07 20:40:01',6,18),(6,37.08,3,'2014-04-07 20:40:03',6,12),(7,33,3,'2014-04-07 20:50:04',7,1),(8,20.89,1,'2014-04-07 22:23:46',8,2),(9,37.08,1,'2014-04-07 22:23:48',8,3),(10,20.89,3,'2014-04-07 22:28:00',9,2),(11,37.08,3,'2014-04-07 22:28:01',9,4),(12,20.89,3,'2014-04-07 22:29:06',10,2),(13,37.08,3,'2014-04-07 22:29:06',10,4),(14,33,2,'2014-04-07 22:55:34',11,1),(15,20.89,2,'2014-04-07 22:55:34',11,2),(16,37.08,3,'2014-04-07 22:55:34',11,3),(17,37.08,3,'2014-04-07 22:55:34',11,4);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `totalAmount` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `accountId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orders` */

insert  into `orders`(`orderId`,`totalAmount`,`quantity`,`accountId`,`customerId`) values (1,37.08,10,6,3),(2,74.16,15,6,3),(3,74.16,56,6,3),(4,74.16,66,6,3),(5,74.16,16,6,3),(6,111.24,9,6,3),(7,33,3,6,3),(8,57.97,2,6,3),(9,57.97,6,6,3),(10,57.97,6,6,3),(11,330.26,10,6,3);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `topic` */

insert  into `topic`(`topicId`,`name`) values (1,'Software patterns'),(2,'Skill'),(3,'Agile'),(4,'Beautys'),(5,'Shopping'),(6,'Business Management'),(7,'Cuisines');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
