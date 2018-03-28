DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `deleteAccount`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAccount`(accountNumber int(9))
BEGIN
	DELETE FROM account WHERE accountNumber=accountNumber;
    END$$

DELIMITER ;