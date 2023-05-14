CREATE TABLE IF NOT EXISTS clients(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `weight` int DEFAULT NULL,
    `height` int DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
DELETE FROM clients;
INSERT INTO clients(email, password, weight, height) VALUES ('235979@edu.p.lodz.pl','123',68,181);