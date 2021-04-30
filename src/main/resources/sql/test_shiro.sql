/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost:3306
 Source Schema         : test_shiro

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 30/04/2021 14:34:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` bigint(20) NULL DEFAULT NULL,
  `lastmodified_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` bigint(20) NULL DEFAULT NULL,
  `body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `view` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_571gx7oqo5xpmgocegaidlcu9`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, NULL, 1604130987473, NULL, 1604130987473, '一般般', 'python', 0);
INSERT INTO `article` VALUES (2, NULL, 1604130997252, NULL, 1604130997252, 'java是世界最好的语言', 'java', 0);
INSERT INTO `article` VALUES (3, NULL, 1604130997257, NULL, 1604130997252, 'aaaa', 'fdsff', 0);
INSERT INTO `article` VALUES (4, NULL, NULL, NULL, NULL, 'bbbb', 'adsfdas', 0);
INSERT INTO `article` VALUES (5, NULL, NULL, NULL, NULL, 'cccc', 'dsfaf', 0);
INSERT INTO `article` VALUES (6, NULL, NULL, NULL, NULL, 'zjh520', '520', NULL);
INSERT INTO `article` VALUES (7, NULL, NULL, NULL, NULL, 'dasfsaf', 'TEST', NULL);
INSERT INTO `article` VALUES (9, NULL, NULL, NULL, NULL, '一般般', 'rrrr', NULL);
INSERT INTO `article` VALUES (10, NULL, NULL, NULL, NULL, 'dasff', 'lllllll', NULL);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `parent_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_type` enum('menu','button') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, b'0', '用户管理', 0, '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES (2, b'0', '用户添加', 1, '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES (3, b'0', '用户删除', 1, '0/1', 'userInfo:del', 'button', 'userInfo/userDel');
INSERT INTO `sys_permission` VALUES (4, b'0', '图书管理', 0, '0/', 'article:view', 'menu', 'article/list');
INSERT INTO `sys_permission` VALUES (5, b'0', '图书添加', 1, '0/1', 'article:add', 'button', 'article/add');
INSERT INTO `sys_permission` VALUES (6, b'0', '图书删除', 1, '0/1', 'article:del', 'button', 'article/delbook/{id}');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, b'0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES (2, b'0', 'VIP会员', 'vip');
INSERT INTO `sys_role` VALUES (3, b'1', 'test', 'test');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  INDEX `FK9q28ewrhntqeipl1t04kh1be7`(`role_id`) USING BTREE,
  INDEX `FKomxrs8a388bknvhjokh440waq`(`permission_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (1, 2);
INSERT INTO `sys_role_permission` VALUES (2, 3);
INSERT INTO `sys_role_permission` VALUES (1, 5);
INSERT INTO `sys_role_permission` VALUES (2, 4);
INSERT INTO `sys_role_permission` VALUES (1, 4);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  INDEX `FKhh52n8vd4ny9ff4x9fb8v65qx`(`role_id`) USING BTREE,
  INDEX `FKgkmyslkrfeyn9ukmolvek8b8f`(`uid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 2);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `UK_f2ksd6h8hsjtd57ipfq9myr64`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0, 'admin');
INSERT INTO `user_info` VALUES (2, 'vip', '4a350a2475ae16335946d5b0ceabb9cc', '8d78869f470951332959580424d4bf4f', 0, 'vip');
INSERT INTO `user_info` VALUES (3, 'test1', 'f6d684cb7c19093c984e96d6aacd0e9b', '8d78869f470951332959580424d4bf4f', 0, 'test1');

SET FOREIGN_KEY_CHECKS = 1;
