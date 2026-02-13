CREATE TABLE IF NOT EXISTS `tbl_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `phone_number` varchar(80) NOT NULL,
  `birthday` DATE,
  PRIMARY KEY (`id`)
);