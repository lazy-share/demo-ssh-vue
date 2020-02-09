/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : demo_ssh_vue

Target Server Type    : MYSQL
Target Server Version : 50699
File Encoding         : 65001

Date: 2020-02-09 15:30:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
`id`  bigint(20) NOT NULL COMMENT '主键' ,
`username`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录账号' ,
`password`  varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码' ,
`salt`  varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '加密盐值' ,
`mobile`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码' ,
`email`  varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱' ,
`valid_status`  varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据有效状态' ,
`create_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间' ,
`last_update_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `uniq_1` (`username`) USING BTREE COMMENT '账号唯一'
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='登录账号表'

;

-- ----------------------------
-- Records of t_account
-- ----------------------------
BEGIN;
INSERT INTO `t_account` VALUES ('3', 'lazy', 'CAF5DFC96DBD8569CE686A3515E36EC1', 'abcd', '13666666666', '13666666666@163.com', 'Y', '2020-02-08 19:56:22', '2020-02-08 19:56:22');
COMMIT;

-- ----------------------------
-- Table structure for t_example
-- ----------------------------
DROP TABLE IF EXISTS `t_example`;
CREATE TABLE `t_example` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`valid_status`  varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`create_time`  datetime NOT NULL ,
`last_update_time`  datetime NOT NULL ,
`name`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
`age`  int(11) NULL DEFAULT NULL ,
`email`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=17

;

-- ----------------------------
-- Records of t_example
-- ----------------------------
BEGIN;
INSERT INTO `t_example` VALUES ('10', 'Y', '2020-02-09 15:07:42', '2020-02-09 15:07:42', 'bbb', '23', 'eee33eee@test.com'), ('11', 'Y', '2020-02-09 15:08:04', '2020-02-09 15:08:04', 'ccc', '23', 'aaaaa@test.com'), ('12', 'N', '2020-02-09 15:08:21', '2020-02-09 15:08:21', 'zhangsan', '26', 'zhangsan@test.com'), ('13', 'Y', '2020-02-09 15:08:38', '2020-02-09 15:08:38', 'wangwu', '32', 'wangwu@test.com'), ('14', 'Y', '2020-02-09 15:08:50', '2020-02-09 15:08:50', 'lisi', '22', 'list@test.com'), ('15', 'Y', '2020-02-09 15:09:03', '2020-02-09 15:09:03', 'zhangliu', '27', 'zhaoliu@test.com'), ('16', 'Y', '2020-02-09 15:09:44', '2020-02-09 15:09:44', 'simith', '28', 'smith@test.com');
COMMIT;

-- ----------------------------
-- Table structure for t_token
-- ----------------------------
DROP TABLE IF EXISTS `t_token`;
CREATE TABLE `t_token` (
`id`  bigint(20) NOT NULL COMMENT '主键' ,
`token`  varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token' ,
`account_id`  bigint(20) NOT NULL COMMENT '对应账号id' ,
`valid_status`  varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据有效状态' ,
`create_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间' ,
`last_update_time`  datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='登录token表'

;

-- ----------------------------
-- Records of t_token
-- ----------------------------
BEGIN;
INSERT INTO `t_token` VALUES ('8', '0fb6591d4c32477ea611aaa75af42b20', '3', 'Y', '2020-02-08 20:52:16', '2020-02-09 12:16:26');
COMMIT;

-- ----------------------------
-- Table structure for t_unique
-- ----------------------------
DROP TABLE IF EXISTS `t_unique`;
CREATE TABLE `t_unique` (
`id`  bigint(20) NOT NULL COMMENT '主键' ,
`val`  bigint(20) NOT NULL COMMENT '普通id' ,
`type`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一类型，PrimaryKey:通用id' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `uniq_1` (`type`) USING BTREE COMMENT '类型唯一'
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='唯一发号器'

;

-- ----------------------------
-- Records of t_unique
-- ----------------------------
BEGIN;
INSERT INTO `t_unique` VALUES ('1', '16', 'PRIMARY_KEY');
COMMIT;

-- ----------------------------
-- Auto increment value for t_example
-- ----------------------------
ALTER TABLE `t_example` AUTO_INCREMENT=17;
