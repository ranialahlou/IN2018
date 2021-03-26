-- MySQL dump 10.13  Distrib 5.6.51, for Win64 (x86_64)
--
-- Host: jaytauron.xyz    Database: bapers
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.27-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bapers`
--

/*!40000 DROP DATABASE IF EXISTS `bapers`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bapers` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bapers`;

--
-- Table structure for table `cardpayment`
--

DROP TABLE IF EXISTS `cardpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardpayment` (
  `CardID` int(10) NOT NULL,
  `JobID` int(10) NOT NULL,
  `CardType` varchar(50) NOT NULL,
  `ExpiryDate` date NOT NULL,
  `Last4Digits` int(4) NOT NULL,
  PRIMARY KEY (`CardID`,`JobID`),
  CONSTRAINT `Uses` FOREIGN KEY (`CardID`) REFERENCES `payment` (`PaymentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardpayment`
--

LOCK TABLES `cardpayment` WRITE;
/*!40000 ALTER TABLE `cardpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `AccountID` int(10) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `CustomerType` varchar(50) NOT NULL,
  `DiscountID` int(10) DEFAULT NULL,
  PRIMARY KEY (`AccountID`),
  KEY `Has` (`DiscountID`),
  CONSTRAINT `Has` FOREIGN KEY (`DiscountID`) REFERENCES `discount` (`DiscountID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'First','Customer','Type',918);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `DiscountID` int(10) NOT NULL AUTO_INCREMENT,
  `DiscountType` varchar(50) NOT NULL,
  `DiscountAmount` int(3) DEFAULT NULL,
  PRIMARY KEY (`DiscountID`)
) ENGINE=InnoDB AUTO_INCREMENT=1242 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'Fixed',5),(2,'Variable',5),(5,'Fixed',10),(6,'Flexible',5),(7,'Flexible',0),(10,'Variable',99),(12,'Flexible',5),(50,'Variable',5),(221,'Flexible',5),(412,'Variable',5),(431,'Flexible',0),(451,'Flexible',0),(623,'Flexible',5),(654,'Flexible',5),(831,'Flexible',5),(918,'Flexible',20),(1241,'Flexible',5);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `JobID` int(10) NOT NULL AUTO_INCREMENT,
  `AccountID` int(10) NOT NULL,
  `Urgency` varchar(255) NOT NULL,
  `StartDate` date NOT NULL,
  `Price` decimal(7,2) NOT NULL,
  `Paid` varchar(5) NOT NULL,
  `ExpectedDueDate` date NOT NULL,
  `StipulatedDeadline` varchar(5) NOT NULL DEFAULT 'No',
  `Deadline` date NOT NULL,
  `PaymentID` int(10) DEFAULT NULL,
  PRIMARY KEY (`JobID`,`AccountID`),
  KEY `Creates` (`AccountID`),
  KEY `FKJob976870` (`PaymentID`),
  CONSTRAINT `Creates` FOREIGN KEY (`AccountID`) REFERENCES `customer` (`AccountID`),
  CONSTRAINT `FKJob976870` FOREIGN KEY (`PaymentID`) REFERENCES `payment` (`PaymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,1,'High','2010-01-01',21.00,'No','2011-01-01','No','2012-01-01',1),(2,1,'Low','2025-05-05',168.00,'Yes','2029-01-01','Yes','2100-01-01',1);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `MaterialID` int(10) NOT NULL,
  `JobID` int(10) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `AccountID` int(10) NOT NULL,
  PRIMARY KEY (`MaterialID`,`JobID`,`AccountID`),
  KEY `ComesWith` (`JobID`,`AccountID`),
  CONSTRAINT `ComesWith` FOREIGN KEY (`JobID`, `AccountID`) REFERENCES `job` (`JobID`, `AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `PaymentID` int(10) NOT NULL,
  `PaymentAmount` int(10) NOT NULL,
  `PaymentType` varchar(255) NOT NULL,
  `PaymentDate` date NOT NULL,
  `JobJobID` int(10) NOT NULL,
  `JobAccountID` int(10) NOT NULL,
  PRIMARY KEY (`PaymentID`),
  CONSTRAINT `Makes` FOREIGN KEY (`PaymentID`) REFERENCES `customer` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,20,'Cash','2021-03-13',1,1);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shift` (
  `ShiftID` int(10) NOT NULL AUTO_INCREMENT,
  `StaffID` int(10) NOT NULL,
  `Date` date DEFAULT NULL,
  `DayOrNight` varchar(255) DEFAULT NULL,
  `StartTime` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  PRIMARY KEY (`ShiftID`),
  KEY `FKShift748569` (`StaffID`),
  CONSTRAINT `FKShift748569` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `StaffID` int(10) NOT NULL AUTO_INCREMENT,
  `StaffType` varchar(255) NOT NULL,
  `AdministeringPrivileges` varchar(50) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (3,'Office Manager','Admin','Bob Walker','bwalker','password'),(4,'Receptionist','Reception','Trevor Smith','tsmith','database'),(5,'Office Manager','Admin','Jane Green','Manager','Get_it_done'),(6,'Shift Manager','Admin','Harry Potter','Accountant','Count_money'),(7,'Shift Manager','Admin','Clark Kent','Clerk','Paperwork'),(8,'Receptionist','Reception','Obi-wan Kenobi','Hello','Hello_there'),(9,'Technician','Technician','Tony Stark','Development','Lot_smell'),(10,'Technician','Technician','Luna Lovegood','Copy','Too_dark'),(11,'Technician','Technician','Carol Danvers','Packer','Pack_it'),(12,'Technician','Technician','Wanda Maximoff','Finish','Fine_touch');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `TaskID` int(10) NOT NULL,
  `JobID` int(10) NOT NULL,
  `AccountID` int(10) NOT NULL,
  `Completed` varchar(5) NOT NULL,
  `Urgent` varchar(25) DEFAULT NULL,
  `StaffID` int(10) NOT NULL,
  `StartTime` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Department` varchar(255) NOT NULL,
  `Instruction` varchar(255) DEFAULT NULL,
  `DiscountID` int(3) DEFAULT NULL,
  PRIMARY KEY (`TaskID`,`JobID`,`AccountID`,`StaffID`),
  KEY `DividedInto` (`JobID`,`AccountID`),
  KEY `WorksOn` (`StaffID`),
  KEY `DiscountID` (`DiscountID`),
  CONSTRAINT `DividedInto` FOREIGN KEY (`JobID`, `AccountID`) REFERENCES `job` (`JobID`, `AccountID`),
  CONSTRAINT `WorksOn` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`DiscountID`) REFERENCES `discount` (`DiscountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,1,1,'Half','Yes',5,'12:00:00','16:00:00','2021-01-05','Copy Room','Paint stuff',10),(2,2,1,'No','No',3,'15:00:00','21:00:00','2000-01-05','Laboratory','Analyze Image',NULL),(3,2,1,'Yes','Yes',3,'00:00:00','23:00:00','2100-01-01','Dark Room','Dry Image',NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-25 12:15:23
