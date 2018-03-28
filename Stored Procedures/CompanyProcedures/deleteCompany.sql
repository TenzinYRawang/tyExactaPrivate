DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deleteCompany`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCompany`(companyID int(9))
BEGIN
	DELETE FROM company WHERE companyID=companyID;
    END$$

DELIMITER ;