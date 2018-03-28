DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addBayTransaction`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addBayTransaction`(transactionNumber int(9), amount DECIMAL(5,2), time DATE, type int(3), bayID int(9), accountNumber int(9))
BEGIN
	INSERT INTO baytransaction 
	SET transactionNumber=transactionNumber, amount=amount, time=NOW(), type=type, bayID=bayID, accountNumber=accountNumber;
    END$$

DELIMITER ;