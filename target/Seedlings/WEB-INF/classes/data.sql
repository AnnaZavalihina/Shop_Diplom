
CREATE DATABASE `auf` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
SELECT auf;
CREATE TABLE `basket_items` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `item_id` int NOT NULL,
                                `quantity_buy` int NOT NULL,
                                `price` double NOT NULL,
                                `basket_id` bigint NOT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `id_UNIQUE` (`id`),
                                KEY `item_idx` (`item_id`),
                                KEY `basket_idx` (`basket_id`),
                                CONSTRAINT `basket_item` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                CONSTRAINT `basket_number` FOREIGN KEY (`basket_id`) REFERENCES `baskets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `baskets` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `date_creation` date NOT NULL,
                           `price` double NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `clients` (
                           `id` int NOT NULL,
                           `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                           `tel_number` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci

CREATE TABLE `info` (
                        `id` int NOT NULL,
                        `requisites` varchar(45) DEFAULT NULL,
                        `email` varchar(45) DEFAULT NULL,
                        `mailing_address` varchar(45) DEFAULT NULL,
                        `registration_number` int DEFAULT NULL,
                        `name` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `items` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `unit_price` double NOT NULL,
                         `status` int DEFAULT '0',
                         `image` varchar(300) DEFAULT NULL,
                         `details` text,
                         `subtype_id` int NOT NULL,
                         `discount` varchar(5) NOT NULL DEFAULT 'false',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `id_UNIQUE` (`id`),
                         KEY `type_idx` (`subtype_id`),
                         CONSTRAINT `type` FOREIGN KEY (`subtype_id`) REFERENCES `subtypes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `order_items` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `item_id` int NOT NULL,
                               `order_id` bigint NOT NULL,
                               `price` double NOT NULL,
                               `quantity` int NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `id_UNIQUE` (`id`),
                               KEY `order_item_idx` (`item_id`),
                               KEY `order_number_idx` (`order_id`),
                               CONSTRAINT `order_item` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                               CONSTRAINT `order_number` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `orders` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `date` date NOT NULL,
                          `price` double NOT NULL,
                          `client_id` int NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pickup_addresses` (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `address` varchar(60) NOT NULL,
                                    `working_hours` varchar(45) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `subtypes` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(45) NOT NULL,
                            `title` tinytext NOT NULL,
                            `type_id` int NOT NULL,
                            `details` text,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `id_UNIQUE` (`id`),
                            KEY `type_idx` (`type_id`),
                            CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `types` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `details` tinytext,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `auf`.`types`
(`id`,`name`,`details`)
VALUES
(1,'Плодовые саженцы','САЖЕНЦЫ ПЛОДОВЫХ ДЕРЕВЬЕВ И КУСТАРНИКОВ'),
(2,'Декоративные растения','ДЕКОРАТИВНЫЕ РАСТЕНИЯ'),
(3,'Лиственные растения','САЖЕНЦЫ ЛИСТВЕННЫХ РАСТЕНИЙ'),
(4,'Хвойные растения','САЖЕНЦЫ ХВОЙНЫХ РАСТЕНИЙ');

INSERT INTO `auf`.`subtypes`
    (`id`, `name`, `title`, `type_id`, `details`)
VALUES
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>),
       (<{id: }>,<{name: }>,<{title: }>,<{type_id: }>,<{details: }>);

INSERT INTO `auf`.`info`
(`id`, `requisites`, `email`, `mailing_address`, `registration_number`, `name`)
VALUES
    (1,'ИП Завалихина Анна Сергеевна','info@seedlings.by','220007 г. Минск а\я 202',516928,'Auf');