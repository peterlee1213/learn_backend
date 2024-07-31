CREATE DATABASE IF NOT EXISTS `security-demo`;
use `security-demo`;

CREATE TABLE IF NOT EXISTS tuser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) DEFAULT NULL,
    password VARCHAR(500) DEFAULT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE UNIQUE INDEX user_username_uindex ON tuser(username);

-- 默认密码123456
INSERT INTO tuser (username,password,enabled) values ("admin","$2a$10$LiXy01t7NAz/qqzopfJGDeQv/BQ1wBYApT6IdUSzQK1x7n9/eEKFe",TRUE);

