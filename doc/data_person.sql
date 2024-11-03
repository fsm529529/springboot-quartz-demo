/*
 Navicat Premium Data Transfer

 Source Server         : localhostDB
 Source Server Type    : MariaDB
 Source Server Version : 100505
 Source Host           : localhost:3306
 Source Schema         : quartz_demo

 Target Server Type    : MariaDB
 Target Server Version : 100505
 File Encoding         : 65001

 Date: 25/08/2021 16:58:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data_person
-- ----------------------------
DROP TABLE IF EXISTS `data_person`;
CREATE TABLE `data_person`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别(0:女/1:男)',
  `age` mediumint(3) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1430454315423662083 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人员表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
