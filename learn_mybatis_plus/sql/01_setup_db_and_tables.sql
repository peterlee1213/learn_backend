CREATE DATABASE IF NOT EXISTS mybatisplus character set utf8mb4 collate utf8mb4_unicode_ci;

USE mybatisplus;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
    id BIGINT(20) NOT NULL COMMENT "主键ID",
    name VARCHAR(30) NULL DEFAULT NULL COMMENT "姓名",
    age INT(11) NULL DEFAULT NULL COMMENT "年龄",
    email VARCHAR(50) NULL DEFAULT NULL COMMENT "邮箱",
    PRIMARY KEY(id)     -- 指定主键之后默认就有NOT NULL以及UNIQUENESS
);

DELETE FROM t_user;
INSERT INTO t_user(id, name, age, email) VALUES
(1, "Jone", 18, "test1.baimidou.com"),
(2, "Jack", 20, "test2.baimidou.com"),
(3, "Tom", 28, "test3.baimidou.com"),
(4, "Sandy", 21, "test4.baimidou.com"),
(5, "Billie", 24, "test5.baimidou.com");
