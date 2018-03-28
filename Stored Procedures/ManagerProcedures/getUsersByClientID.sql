DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getUsersByClientID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsersByClientID`(theClientID INT(9))
BEGIN
	SELECT * FROM user WHERE clientID=theClientID;
    END$$

DELIMITER ;