DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getAllRegisteredClients`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegisteredClients`()
BEGIN
	SELECT * FROM client_register;
    END$$

DELIMITER ;