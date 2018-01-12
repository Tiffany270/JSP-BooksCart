/*
Navicat MySQL Data Transfer

Source Server         : Tiffany
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : tiffany

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-09 20:31:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) DEFAULT NULL,
  `bookname` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `stockout` varchar(11) DEFAULT NULL,
  `totalprice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
