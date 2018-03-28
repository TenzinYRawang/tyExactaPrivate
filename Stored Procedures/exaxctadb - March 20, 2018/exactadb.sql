/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 5.7.21-log : Database - exactadb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exactadb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `exactadb`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accountNumber` int(9) NOT NULL AUTO_INCREMENT,
  `accgroup` int(9) NOT NULL,
  `type` int(3) NOT NULL,
  `expiry` date NOT NULL,
  PRIMARY KEY (`accountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

/*Table structure for table `bay` */

DROP TABLE IF EXISTS `bay`;

CREATE TABLE `bay` (
  `bayID` int(9) NOT NULL AUTO_INCREMENT,
  `bayNumber` int(2) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '1 = open, 0 = closed',
  `siteID` int(9) NOT NULL,
  PRIMARY KEY (`bayID`),
  KEY `siteID` (`siteID`),
  CONSTRAINT `bay_ibfk_1` FOREIGN KEY (`siteID`) REFERENCES `site` (`siteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bay` */

/*Table structure for table `baytransaction` */

DROP TABLE IF EXISTS `baytransaction`;

CREATE TABLE `baytransaction` (
  `transactionNumber` int(9) NOT NULL AUTO_INCREMENT,
  `amount` decimal(5,2) NOT NULL,
  `time` date NOT NULL,
  `type` int(3) NOT NULL,
  `bayID` int(9) DEFAULT NULL,
  `accountNumber` int(9) NOT NULL,
  PRIMARY KEY (`transactionNumber`),
  KEY `bayID` (`bayID`),
  KEY `accountNumber` (`accountNumber`),
  CONSTRAINT `baytransaction_ibfk_1` FOREIGN KEY (`bayID`) REFERENCES `bay` (`bayID`),
  CONSTRAINT `baytransaction_ibfk_2` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `baytransaction` */

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `clientID` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `css` varchar(25) NOT NULL,
  `logo` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`clientID`,`name`,`css`,`logo`,`email`,`url`,`phoneNumber`) values 
(1,'Exacta','default.css','default.jpg','exacta@exacta.com','exacta.com','899-676-9992'),
(9,'Test','default.css','default.jpg','test@test.com','test.com','788-383-7884');

/*Table structure for table `client_register` */

DROP TABLE IF EXISTS `client_register`;

CREATE TABLE `client_register` (
  `registerID` int(9) NOT NULL AUTO_INCREMENT,
  `urlRegister` varchar(100) NOT NULL,
  `nameRegister` varchar(30) NOT NULL,
  `emailRegister` varchar(50) NOT NULL,
  `phoneNumberRegister` varchar(15) NOT NULL,
  PRIMARY KEY (`registerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `client_register` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `companyID` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `contactNumber` char(10) NOT NULL,
  `invoiceMethod` char(1) NOT NULL DEFAULT 'e' COMMENT 'e = email or m = mail',
  `email` varchar(50) NOT NULL,
  `billingAddress` varchar(50) NOT NULL,
  `mailingAddress` varchar(50) NOT NULL,
  `clientID` int(9) NOT NULL,
  PRIMARY KEY (`companyID`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`clientID`) REFERENCES `client` (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

/*Table structure for table `fleetcard` */

DROP TABLE IF EXISTS `fleetcard`;

CREATE TABLE `fleetcard` (
  `fleetCardID` int(9) NOT NULL AUTO_INCREMENT,
  `balance` decimal(7,2) NOT NULL,
  `cardNumber` char(16) NOT NULL,
  `companyID` int(9) NOT NULL,
  `accountNumber` int(9) NOT NULL,
  PRIMARY KEY (`fleetCardID`),
  KEY `companyID` (`companyID`),
  KEY `accountNumber` (`accountNumber`),
  CONSTRAINT `fleetcard_ibfk_1` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyID`),
  CONSTRAINT `fleetcard_ibfk_2` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fleetcard` */

/*Table structure for table `giftcard` */

DROP TABLE IF EXISTS `giftcard`;

CREATE TABLE `giftcard` (
  `giftCardID` int(9) NOT NULL AUTO_INCREMENT,
  `balance` decimal(7,2) NOT NULL,
  `cardNumber` char(16) NOT NULL,
  `userID` int(9) DEFAULT NULL,
  `accountNumber` int(9) NOT NULL,
  PRIMARY KEY (`giftCardID`),
  KEY `userID` (`userID`),
  KEY `accountNumber` (`accountNumber`),
  CONSTRAINT `giftcard_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `giftcard_ibfk_2` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `giftcard` */

/*Table structure for table `giftcardtransaction` */

DROP TABLE IF EXISTS `giftcardtransaction`;

CREATE TABLE `giftcardtransaction` (
  `transactionNumber` int(9) NOT NULL AUTO_INCREMENT,
  `amount` decimal(5,2) NOT NULL,
  `time` date NOT NULL,
  `prePaidID` int(9) NOT NULL,
  PRIMARY KEY (`transactionNumber`),
  KEY `prePaidID` (`prePaidID`),
  CONSTRAINT `giftcardtransaction_ibfk_1` FOREIGN KEY (`prePaidID`) REFERENCES `giftcard` (`giftCardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `giftcardtransaction` */

/*Table structure for table `promotion` */

DROP TABLE IF EXISTS `promotion`;

CREATE TABLE `promotion` (
  `promotionID` int(9) NOT NULL AUTO_INCREMENT,
  `amount` decimal(5,2) DEFAULT NULL,
  `information` text NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`promotionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `promotion` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleNumber` int(1) NOT NULL,
  `roleName` varchar(10) NOT NULL,
  PRIMARY KEY (`roleNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleNumber`,`roleName`) values 
(0,'customer'),
(1,'employee'),
(2,'manager'),
(3,'admin');

/*Table structure for table `site` */

DROP TABLE IF EXISTS `site`;

CREATE TABLE `site` (
  `siteID` int(9) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `siteIPV4` varchar(15) NOT NULL,
  `siteName` varchar(50) NOT NULL,
  `numberOfBays` int(2) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `clientID` int(9) NOT NULL,
  PRIMARY KEY (`siteID`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `site_ibfk_1` FOREIGN KEY (`clientID`) REFERENCES `client` (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `site` */

/*Table structure for table `site_promotion` */

DROP TABLE IF EXISTS `site_promotion`;

CREATE TABLE `site_promotion` (
  `siteID` int(9) NOT NULL,
  `promotionID` int(9) NOT NULL,
  PRIMARY KEY (`siteID`,`promotionID`),
  KEY `promotionID` (`promotionID`),
  CONSTRAINT `site_promotion_ibfk_1` FOREIGN KEY (`siteID`) REFERENCES `site` (`siteID`),
  CONSTRAINT `site_promotion_ibfk_2` FOREIGN KEY (`promotionID`) REFERENCES `promotion` (`promotionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `site_promotion` */

/*Table structure for table `siteip_register` */

DROP TABLE IF EXISTS `siteip_register`;

CREATE TABLE `siteip_register` (
  `siteRegisterIPV4` varchar(15) DEFAULT NULL,
  `registerID` int(9) NOT NULL,
  KEY `registerID` (`registerID`),
  CONSTRAINT `siteIP_register_ibfk_1` FOREIGN KEY (`registerID`) REFERENCES `client_register` (`registerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `siteip_register` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `salt` char(8) NOT NULL DEFAULT '',
  `email` varchar(64) DEFAULT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `mailingChoice` int(1) NOT NULL DEFAULT '1' COMMENT '1 = yes, 0 = no',
  `address` varchar(50) NOT NULL,
  `roleNumber` int(1) NOT NULL,
  `clientID` int(9) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `roleNumber` (`roleNumber`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleNumber`) REFERENCES `role` (`roleNumber`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`clientID`) REFERENCES `client` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userID`,`username`,`password`,`salt`,`email`,`firstName`,`lastName`,`mailingChoice`,`address`,`roleNumber`,`clientID`) values 
(2,'admin','password','','test@test.com','admin','admin',1,'123 Test St. Calgary, AB',3,1);

/* Procedure structure for procedure `addClient` */

/*!50003 DROP PROCEDURE IF EXISTS  `addClient` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addClient`(newClientName VARCHAR(30),
 newClientCss VARCHAR(25), newClientLogo VARCHAR(25), newClientEmail VARCHAR(50), newClientUrl VARCHAR(100), newClientPhoneNumber VARCHAR(10))
BEGIN
	
	INSERT INTO client SET name=newClientName, css=newClientCss, logo=newClientLogo, email=newClientEmail, url=newClientUrl, phoneNumber=newClientPhoneNumber;
	SELECT * from client where clientID = (Select Max(clientID) from client);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `addFleetCard` */

/*!50003 DROP PROCEDURE IF EXISTS  `addFleetCard` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addFleetCard`(fleetCardID int(9), balance DECIMAL(7,2), cardNumber char(16), companyID int(9), accountNumber int(9))
BEGIN
	INSERT INTO fleetCardID 
	SET fleetCardID=fleetCardID, balance=balance, cardNumber=cardNumber, companyID=companyID, accountNumber=accountNumber;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `deleteClient` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteClient` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteClient`(theClientID INT(9))
BEGIN
	
		DELETE FROM client WHERE clientID=theClientID;
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `deleteFleetCard` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteFleetCard` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFleetCard`(fleetCardID int(9))
BEGIN
	DELETE FROM postpaid WHERE fleetCardID=fleetCardID;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `editClient` */

/*!50003 DROP PROCEDURE IF EXISTS  `editClient` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `editClient`(theClientID INT(9), newClientName VARCHAR(30),
 newClientCss VARCHAR(25), newClientLogo VARCHAR(25), newClientEmail VARCHAR(50), newClientUrl VARCHAR(100), newClientPhoneNumber VARCHAR(10))
BEGIN
	
		UPDATE CLIENT SET NAME=newClientName, css=newClientCss, logo=newClientLogo, email=newClientEmail, url=newClientUrl, phoneNumber=newClientPhoneNumber
		WHERE clientID=theClientID;
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getAllClients` */

/*!50003 DROP PROCEDURE IF EXISTS  `getAllClients` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllClients`()
BEGIN
		select * from client;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `getUserByUsername` */

/*!50003 DROP PROCEDURE IF EXISTS  `getUserByUsername` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserByUsername`(p_username varchar(30))
BEGIN
		Select * from user where username = p_username;
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
