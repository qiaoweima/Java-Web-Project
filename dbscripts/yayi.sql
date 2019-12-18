/*
Navicat MySQL Data Transfer

Source Server         : 12
Source Server Version : 80016
Source Host           : 111.229.139.137:3306
Source Database       : yayi

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-12-18 10:53:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `医生姓名` varchar(255) DEFAULT NULL,
  `在诊时间` varchar(255) DEFAULT NULL,
  `是否已占用` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('刘明', '9:00~12:00', 'no');
INSERT INTO `doctor` VALUES ('王强', '8:00~11:00', 'no');
INSERT INTO `doctor` VALUES ('刘芳', '14:00~17:00', 'yes');
INSERT INTO `doctor` VALUES ('李霞', '15:00~18:00', 'no');
INSERT INTO `doctor` VALUES ('陈宏', '19:00~21:00', 'no');
INSERT INTO `doctor` VALUES ('苏伟', '10:00~12:00', 'yes');
INSERT INTO `doctor` VALUES ('何伟', '20:00~22:00', 'yes');
INSERT INTO `doctor` VALUES ('刘明', '14:30-15:30', 'yes');
INSERT INTO `doctor` VALUES ('刘明', '19:30-21:00', 'no');
INSERT INTO `doctor` VALUES ('王强', '14:30-17:00', 'no');
INSERT INTO `doctor` VALUES ('王强', '19:30-21:00', 'no');
INSERT INTO `doctor` VALUES ('刘芳', '9:00-11:00', 'no');
INSERT INTO `doctor` VALUES ('李霞', '9:00-11:00', 'yes');
INSERT INTO `doctor` VALUES ('李霞', '19:30-21:00', 'no');
INSERT INTO `doctor` VALUES ('陈宏', '9:00-11:00', 'no');
INSERT INTO `doctor` VALUES ('陈宏', '14:30-15:30', 'no');
INSERT INTO `doctor` VALUES ('苏伟', '14:30-15:30', 'no');
INSERT INTO `doctor` VALUES ('苏伟', '19:30-21:00', 'no');
INSERT INTO `doctor` VALUES ('何伟', '9:00-11:00', 'no');
INSERT INTO `doctor` VALUES ('晓白', '2019.12.6 9:00-11:00', 'no');

-- ----------------------------
-- Table structure for userlist
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist` (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ismanager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlist
-- ----------------------------
INSERT INTO `userlist` VALUES ('123', '123', 'yes');
INSERT INTO `userlist` VALUES ('456', '456', 'no');
INSERT INTO `userlist` VALUES ('root', 'root', 'no');
INSERT INTO `userlist` VALUES ('aaaa', 'aaaa', 'no');
INSERT INTO `userlist` VALUES ('12', '123', 'no');

-- ----------------------------
-- Table structure for yy
-- ----------------------------
DROP TABLE IF EXISTS `yy`;
CREATE TABLE `yy` (
  `姓名` varchar(255) DEFAULT NULL,
  `性别` varchar(10) DEFAULT NULL,
  `年龄` int(255) DEFAULT NULL,
  `预约医生` varchar(20) DEFAULT NULL,
  `预约时间` varchar(255) DEFAULT NULL,
  `备注` varchar(255) DEFAULT NULL,
  `预约状态` varchar(11) DEFAULT NULL,
  `账号` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yy
-- ----------------------------
INSERT INTO `yy` VALUES ('张辉', '男', '23', '刘明', '14:30-15:30', '测试', '未接受', '456');
INSERT INTO `yy` VALUES ('王娇', '女', '20', '李霞', '9:00-11:00', 'ceshi', '未接受', '456');
INSERT INTO `yy` VALUES ('刘杰', '男', '30', '何伟', '20:00~22:00', '', '未接受', '456');
INSERT INTO `yy` VALUES ('何强', '男', '56', '刘芳', '14:00~17:00', '', '未接受', '456');
INSERT INTO `yy` VALUES ('张冲', '男', '62', '苏伟', '10:00~12:00', '', '未接受', '456');
