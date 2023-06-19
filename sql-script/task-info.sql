CREATE DATABASE IF NOT EXISTS `todo_directory`;
USE `todo_directory`;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS`todo`;

CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `task` varchar(45) DEFAULT NULL,
  `target_date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `todo`
--

INSERT INTO `todo` VALUES 
	(1,'2023/06/15','Coding','2000/06/15','Complete'),
	(2,'2023/06/18','User Testing Interview','2023/06/18','Complete'),
	(3,'2023/06/20','Drop Off Packages At The UPS','2023/06/25','Incomplete'),
	(4,'2023/06/15','Apply More Jobs','2023/12/30','Incomplete'),
	(5,'2023/06/10','Build Spring Boot/Angular Project','2023/07/30','Incomplete');