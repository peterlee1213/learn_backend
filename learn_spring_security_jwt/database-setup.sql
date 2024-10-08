CREATE DATABASE IF NOT EXISTS `learn_spring_security`;
use `learn_spring_security`;

-- s01用户表 开始------------------------------------------------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`user_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
`nick_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
`password` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
`status` CHAR(1) DEFAULT '0' COMMENT '账号状态(0正常 1停用)',
`email` VARCHAR(64) DEFAULT NULL COMMENT '邮箱',
`phonenumber` VARCHAR(32) DEFAULT NULL COMMENT '手机号',
`sex` CHAR(1) DEFAULT NULL COMMENT '用户性别(0男,1女,2未知)',
`avatar` VARCHAR(128) DEFAULT NULL COMMENT '头像',
`user_type` CHAR(1) NOT NULL DEFAULT '1' COMMENT '用户类型(0管理员,1普通用户)',
`create_by` BIGINT(20) DEFAULT NULL COMMENT '创建人的用户id',
`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
`update_by` BIGINT(20) DEFAULT NULL COMMENT '更新人',
`update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
`deleted` INT(11) DEFAULT '0' COMMENT '删除标志(0代表未删除,1代表已删除)',
PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

INSERT INTO sys_user (user_name,nick_name,password) values
("admin","aaa","123");
-- s01用户表 开始------------------------------------------------------------------


-- s02用户表 开始------------------------------------------------------
DROP TABLE IF EXISTS `example_user`;
CREATE TABLE `example_user` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
`user_name` VARCHAR(64) NOT NULL UNIQUE COMMENT '用户名',
`password` VARCHAR(64) NOT NULL UNIQUE COMMENT '密码',
`enabled` BOOLEAN NOT NULL DEFAULT TRUE,
`phone_number` VARCHAR(32) DEFAULT NULL COMMENT '手机号',
`version` BIGINT DEFAULT 0
)COMMENT='s02用户表';

-- default password 123456
INSERT INTO `example_user`(user_name,password,phone_number) values
("admin","$2a$10$LiXy01t7NAz/qqzopfJGDeQv/BQ1wBYApT6IdUSzQK1x7n9/eEKFe","16547382746");
-- s02用户表 结束------------------------------------------------------