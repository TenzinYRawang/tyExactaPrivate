DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getEditClientByID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getEditClientByID`(theClientID INT(9))
BEGIN
	SELECT * FROM client WHERE clientID=theClientID;
    END$$

DELIMITER ;