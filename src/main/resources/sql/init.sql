CREATE DATABASE fmb_main;

Use fmb_main;

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `item` varchar(100) NOT NULL,
  `menucol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `fmb_main`.`menu`
(`date`,
`item`,
`menucol`)
VALUES
(now(),
'Khurdi Khichdi Gulab Jamun',
'test');