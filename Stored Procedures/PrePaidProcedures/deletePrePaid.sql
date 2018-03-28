DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deletePrePaid`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePrePaid`(prePaidID int(9))
BEGIN
	DELETE FROM prepaid WHERE prePaidID=prePaidID;
    END$$

DELIMITER ;