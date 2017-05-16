SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `bfa`;

CREATE DATABASE `bfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `bfa`;

CREATE TABLE `ToDo` (
    `id` int,
    `status` VARCHAR(20),
    `text` VARCHAR(20) NOT NULL,
    PRIMARY KEY(`id`)
);

INSERT INTO `ToDo`(`id`, `status`, `text`) VALUES (1, 'new', 'szia');
INSERT INTO `ToDo`(`id`, `status`, `text`) VALUES (2, 'new', 'sziaa');
INSERT INTO `ToDo`(`id`, `status`, `text`) VALUES (3, 'new', 'sziaaa');
