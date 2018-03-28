DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `userRoleStatus`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `userRoleStatus`(theUsername VARCHAR(30))
BEGIN
	SELECT roleNumber FROM user WHERE username=theUsername;
    END$$

DELIMITER ;