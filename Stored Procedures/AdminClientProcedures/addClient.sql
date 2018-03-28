DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addClient`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addClient`(newClientName VARCHAR(30),
 newClientCss VARCHAR(25), newClientLogo VARCHAR(25), newClientEmail VARCHAR(50), newClientUrl VARCHAR(100), newClientPhoneNumber VARCHAR(10))
BEGIN
	
		INSERT INTO client SET name=newClientName, css=newClientCss, logo=newClientLogo, email=newClientEmail, url=newClientUrl, phoneNumber=newClientPhoneNumber;
	
    END$$

DELIMITER ;