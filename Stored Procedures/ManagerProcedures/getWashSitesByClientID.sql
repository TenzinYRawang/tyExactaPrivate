DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getWashSitesByClientID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getWashSitesByClientID`(theClientID INT(9))
BEGIN
	SELECT * FROM site WHERE clientID=theClientID;
    END$$

DELIMITER ;