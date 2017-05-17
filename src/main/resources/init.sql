SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `bfa`;

CREATE DATABASE `bfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `bfa`;

CREATE TABLE `ToDo` (
    `id`INT AUTO_INCREMENT,
    `status` VARCHAR(20),
    `text` VARCHAR(20) NOT NULL,
    PRIMARY KEY(`id`)
);

INSERT INTO `ToDo`(`status`, `text`) VALUES ('NEW', 'szia');
INSERT INTO `ToDo`(`status`, `text`) VALUES ('NEW', 'hello');
INSERT INTO `ToDo`(`status`, `text`) VALUES ('NEW', 'cső');
