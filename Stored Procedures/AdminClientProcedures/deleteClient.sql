DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deleteClient`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteClient`(theClientID INT(9))
BEGIN
	
		DELETE FROM client WHERE clientID=theClientID;
	
    END$$

DELIMITER ;