CREATE DATABASE IF NOT EXISTS `workout_manager`;
USE `workout_manager`;

DROP TABLE IF EXISTS `Exercise`;

CREATE TABLE `Exercise` (
	`id` int NOT NULL AUTO_INCREMENT,
    `workout_name` varchar(45) DEFAULT NULL,
    `exercise_name` varchar(45) DEFAULT NULL,
    `exercise_date` date DEFAULT NULL,
    `weight` double DEFAULT 0,
    `set_number` int NOT NULL,
    `reps` int DEFAULT 0,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
    