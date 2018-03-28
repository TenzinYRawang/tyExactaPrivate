DELIMITER $$

USE `exactadb`$$

DROP PROCEDURE IF EXISTS `getAllClients`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllClients`()
BEGIN
	SELECT * FROM client;
    END$$

DELIMITER ;