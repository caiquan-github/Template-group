/*
 Navicat Premium Data Transfer

 Source Server         : 本地环境
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 192.168.174.100:3306
 Source Schema         : testMyBatisPlus

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 25/10/2021 14:49:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', 11, NULL, NULL, '2021-10-25 06:43:59');
INSERT INTO `user` VALUES ('2', '李四', 23, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('3', '王五', 33, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
