DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `validateUser`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validateUser`(theUsername VARCHAR(30), thePassword VARCHAR(64))
BEGIN
	DECLARE numRows INT;
	
	SELECT COUNT(*) INTO numRows FROM user
	WHERE username=theUsername AND PASSWORD=thePassword;
	
	SELECT numRows;
    END$$

DELIMITER ;