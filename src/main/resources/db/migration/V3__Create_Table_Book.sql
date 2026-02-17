CREATE TABLE IF NOT EXISTS `tbl_books`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(180) NOT NULL,
    `author` VARCHAR(120) NOT NULL,
    `synopsis` VARCHAR(300) NOT NULL,
    `release_date` DATE
);