DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `editClientByID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editClientByID`(theClientID INT(9), newClientName VARCHAR(30),
 newClientCss VARCHAR(25), newClientLogo VARCHAR(25), newClientEmail VARCHAR(50), newClientUrl VARCHAR(100), newClientPhoneNumber VARCHAR(10))
BEGIN
	
		UPDATE CLIENT SET NAME=newClientName, css=newClientCss, logo=newClientLogo, email=newClientEmail, url=newClientUrl, phoneNumber=newClientPhoneNumber
		WHERE clientID=theClientID;
	
    END$$

DELIMITER ;