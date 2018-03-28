DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addPrePaid`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addPrePaid`(prePaidID int(9), balance DECIMAL(7,2), cardNumber char(16), userID int(9), accountNumber int(9))
BEGIN
	INSERT INTO prepaid 
	SET prePaidID=prePaidID, balance=balance, cardNumber=cardNumber, userID=userID, accountNumber=accountNumber;
    END$$

DELIMITER ;