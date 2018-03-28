DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getRegisteredClientByID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getRegisteredClientByID`(theRegisteredClientID INT(9))
BEGIN
	SELECT * FROM client_register WHERE registerID=theRegisteredClientID;
    END$$

DELIMITER ;