CREATE DATABASE fmb_main;

Use fmb_main;

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `item` varchar(100) NOT NULL,
  `menucol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_raza_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aamil` int DEFAULT NULL,
  `raza_recd` tinyint NOT NULL,
  `requested_date` datetime NOT NULL,
  `approved_date` datetime DEFAULT NULL,
  `rejected_date` datetime DEFAULT NULL,
  `reject_reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aamil_fk_idx` (`aamil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(1) DEFAULT NULL,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(20) NOT NULL,
  `zip` varchar(5) NOT NULL,
  `country` varchar(45) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_preference` (
  `id` int NOT NULL AUTO_INCREMENT,
  `size` varchar(5) NOT NULL,
  `less_carbs` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_credentials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  KEY `role_fk_idx` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `thalinum` int DEFAULT NULL,
  `address_id` int NOT NULL,
  `preference_id` int DEFAULT NULL,
  `credentials_id` int NOT NULL,
  `its` varchar(10) NOT NULL,
  `raza_status_id` int DEFAULT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `thalinum_UNIQUE` (`thalinum`),
  KEY `preference_fk_idx` (`preference_id`),
  KEY `credentials_fk_idx` (`credentials_id`),
  KEY `raza_status_fk_idx` (`raza_status_id`),
  CONSTRAINT `area_code_fk` FOREIGN KEY (`address_id`) REFERENCES `user_contact` (`id`),
  CONSTRAINT `credentials_fk` FOREIGN KEY (`credentials_id`) REFERENCES `user_credentials` (`id`),
  CONSTRAINT `preference_fk` FOREIGN KEY (`preference_id`) REFERENCES `user_preference` (`id`),
  CONSTRAINT `raza_status_fk` FOREIGN KEY (`raza_status_id`) REFERENCES `user_raza_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `fmb_main`.`menu`
(`date`,
`item`,
`menucol`)
VALUES
(now(),
'Khurdi Khichdi Gulab Jamun',
'test');

alter table user_raza_status add   CONSTRAINT `aamil_fk` FOREIGN KEY (`aamil`) REFERENCES `user` (`id`);

CREATE TABLE sequence (
name              VARCHAR(50) NOT NULL,
current_value INT NOT NULL,
increment       INT NOT NULL DEFAULT 1,
PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO sequence VALUES ('ThaliNum',0,1);

DROP FUNCTION IF EXISTS currval;
DELIMITER $
CREATE FUNCTION currval (seq_name VARCHAR(50))
RETURNS INTEGER
READS SQL DATA
DETERMINISTIC
CONTAINS SQL
BEGIN
  DECLARE value INTEGER;
  SET value = 0;
  SELECT current_value INTO value
  FROM sequence
  WHERE name = seq_name;
  RETURN value;
END$
DELIMITER ;

DROP FUNCTION IF EXISTS nextval;
DELIMITER $
CREATE FUNCTION nextval (seq_name VARCHAR(50))
RETURNS INTEGER
READS SQL DATA
DETERMINISTIC
CONTAINS SQL
BEGIN
   UPDATE sequence
   SET          current_value = current_value + increment
   WHERE name = seq_name;
   RETURN currval(seq_name);
END$
DELIMITER ;
