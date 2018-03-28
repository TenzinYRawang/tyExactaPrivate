DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addPrepaidTransaction`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addPrepaidTransaction`(transactionNumber int(9), amount DECIMAL(5,2), time DATE, prePaidID int(9))
BEGIN
	INSERT INTO prepaidtransaction 
	SET transactionNumber=transactionNumber, amount=amount, time=NOW(), prePaidID=prePaidID;
    END$$

DELIMITER ;