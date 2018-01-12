/*
Navicat MySQL Data Transfer

Source Server         : Tiffany
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : tiffany

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-09 20:31:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` int(11) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
