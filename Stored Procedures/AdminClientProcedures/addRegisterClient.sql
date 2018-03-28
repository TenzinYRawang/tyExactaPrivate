DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addRegisterClient`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addRegisterClient`(newRegisterClientName VARCHAR(30),
 newRegisterClientEmail VARCHAR(50), newRegisterClientUrl VARCHAR(100), newRegisterClientPhoneNumber VARCHAR(10))
BEGIN
	
		INSERT INTO client_register SET nameRegister=newRegisterClientName, emailRegister=newRegisterClientEmail,
		urlRegister=newRegisterClientUrl, phoneNumberRegister=newRegisterClientPhoneNumber;
	
    END$$

DELIMITER ;