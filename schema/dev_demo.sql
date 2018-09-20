/*
Navicat MySQL Data Transfer

Source Server         : 10.65.12.250
Source Server Version : 50549
Source Host           : 10.65.12.250:3307
Source Database       : dev_demo

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-09-20 15:36:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` varchar(32) NOT NULL,
  `demo_string` varchar(50) DEFAULT NULL,
  `demo_int` int(11) DEFAULT NULL,
  `demo_double` decimal(10,2) DEFAULT NULL,
  `demo_long` bigint(20) DEFAULT NULL,
  `create_date` int(11) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `state` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
