DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `addCompany`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addCompany`(companyID int(9), name VARCHAR(50), contactNumber char(10), invoiceMethod char(1), email VARCHAR(50), billingAddress VARCHAR(50), mailingAddress VARCHAR(50), clientID int(9))
BEGIN
	INSERT INTO company 
	SET companyID=companyID, name=name, contactNumber=contactNumber, invoiceMethod=invoiceMethod, email=email, billingAddress=billingAddress, mailingAddress=mailingAddress, clientID=clientID;
    END$$

DELIMITER ;