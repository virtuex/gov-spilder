/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : zhaobiao

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-14 13:27:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zhaobiao
-- ----------------------------
DROP TABLE IF EXISTS `zhaobiao`;
CREATE TABLE `zhaobiao` (
  `id` varchar(255) NOT NULL,
  `mainBidMenuName` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `projectCode` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `pubDate` varchar(255) DEFAULT NULL,
  `districtName` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `typeName` varchar(255) DEFAULT NULL,
  `keywords` longtext,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhaobiao
-- ----------------------------
