DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deleteRegisteredClient`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRegisteredClient`(theRegisteredClientID INT(9))
BEGIN
	DELETE FROM client_register WHERE registerID=theRegisteredClientID;
	
    END$$

DELIMITER ;