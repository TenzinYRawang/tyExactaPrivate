DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addAccount`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addAccount`(accountNumber int(9), group int(9), type int(3), expiry DATE)
BEGIN
	INSERT INTO account 
	SET accountNumber=accountNumber, group=group, type=type, expiry=NOW();
    END$$

DELIMITER ;