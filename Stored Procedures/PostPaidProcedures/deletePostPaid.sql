DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deletePostPaid`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFleetCard`(fleetCardID int(9))
BEGIN
	DELETE FROM postpaid WHERE postPaidID=postPaidID;
    END$$

DELIMITER ;