CREATE DATABASE fmb_main;

Use fmb_main;

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

INSERT INTO `fmb_main`.`user_preference` (`size`,`less_carbs`) VALUES('L',0);

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
  UNIQUE KEY `its_UNIQUE` (`its`),
  UNIQUE KEY `thalinum_UNIQUE` (`thalinum`),
  KEY `preference_fk_idx` (`preference_id`),
  KEY `credentials_fk_idx` (`credentials_id`),
  KEY `raza_status_fk_idx` (`raza_status_id`),
  CONSTRAINT `area_code_fk` FOREIGN KEY (`address_id`) REFERENCES `user_contact` (`id`),
  CONSTRAINT `credentials_fk` FOREIGN KEY (`credentials_id`) REFERENCES `user_credentials` (`id`),
  CONSTRAINT `preference_fk` FOREIGN KEY (`preference_id`) REFERENCES `user_preference` (`id`),
  CONSTRAINT `raza_status_fk` FOREIGN KEY (`raza_status_id`) REFERENCES `user_raza_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

alter table user_raza_status add   CONSTRAINT `aamil_fk` FOREIGN KEY (`aamil`) REFERENCES `user` (`id`);

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `item` varchar(100) NOT NULL,
  `niyaz` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_UNIQUE` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-10-30','Dal Chawal Palidu, Mithaas');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-10-31','Masoor Pulao, Kadhi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-01','Aloo Gosht Tarkari');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-02','Chicken Karahi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-03','Veg Pulao, Soup');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-11-04','Private Darees',1);

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-06','Masoor Daal, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-07','DKheer, Daal Gosht, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-08','Keema Pulao, Soup');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-09','Milad Dai Iz Zaman');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-10','Mithaas, Chicken Korma');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-11-11','Private Thaali',1);

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-12','Khichdo, Afghani Naan');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-13','Mix Sabzi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-14','Homestyle Chicken Tarkari');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-15','Achari Gosht Pulao, Cucumber Raita');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-16','Chicken Enchiladas');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-17','Tikka Boti, Paratha');

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-18','Masoor Daal, Chawal, Bhindi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-11-19','Milad Imam Uz Zaman', 1);
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-20','Mithaas, Malvi Gosht');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-21','Pav Bhaaji');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-22','Daal Gosht, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-23','Butter Chicken');

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-24','Aloo Gosht Tarkari');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-25','Chicken Karahi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-26','Veg Pulao, Soup');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-11-27','Private Darees',1);

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-28','Masoor Daal, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-29','DKheer, Daal Gosht, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-11-30','Keema Pulao, Soup');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-01','Milad Dai Iz Zaman');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-02','Mithaas, Chicken Korma');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-12-03','Private Thaali',1);

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-04','Khichdo, Afghani Naan');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-05','Mix Sabzi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-06','Homestyle Chicken Tarkari');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-07','Achari Gosht Pulao, Cucumber Raita');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-08','Chicken Enchiladas');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-09','Tikka Boti, Paratha');

INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-10','Masoor Daal, Chawal, Bhindi');
INSERT INTO `fmb_main`.`menu`(`date`,`item`,`niyaz`) VALUES ('2023-12-11','Milad Imam Uz Zaman', 1);
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-12','Mithaas, Malvi Gosht');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-13','Pav Bhaaji');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-14','Daal Gosht, Chawal');
INSERT INTO `fmb_main`.`menu`(`date`,`item`) VALUES ('2023-12-15','Butter Chicken');

CREATE TABLE `rsvp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `menu_id` int NOT NULL,
  `size` varchar(3) NOT NULL,
  `less_carbs` tinyint DEFAULT NULL,
  `adult_count` int DEFAULT NULL,
  `kids_count` int DEFAULT NULL,
  `rsvp` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`user_id`,`menu_id`),
  KEY `menu_day_fk_idx` (`menu_id`),
  KEY `user_fk_idx` (`user_id`),
  CONSTRAINT `menu_day_fk` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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

update user set preference_id = 1 where id = 1;

CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_item` int DEFAULT NULL,
  `quality` varchar(45) NOT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `picture` longblob,
  `user` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_item_fk_idx` (`menu_item`),
  KEY `user_fk_idx` (`user`),
  CONSTRAINT `menu_item_fk` FOREIGN KEY (`menu_item`) REFERENCES `menu` (`id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

