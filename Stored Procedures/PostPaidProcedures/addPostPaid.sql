DELIMITER $$

USE `exactadb`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addFleetCard`(fleetCardID int(9), balance DECIMAL(7,2), cardNumber char(16), companyID int(9), accountNumber int(9))
BEGIN
	INSERT INTO fleetCardID 
	SET fleetCardID=fleetCardID, balance=balance, cardNumber=cardNumber, companyID=companyID, accountNumber=accountNumber;
    END$$

DELIMITER ;