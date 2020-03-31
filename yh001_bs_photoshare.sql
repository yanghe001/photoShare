/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : yh001_bs_photoshare

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 31/03/2020 22:07:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态自增id',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文字介绍',
  `images` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推片链接 ，分割',
  `praise_counts` int(11) NULL DEFAULT 0 COMMENT '点赞数量统计',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES (1, '111', '太好看了吧', 'upload/dynamic/1585635424159.jpg,upload/dynamic/1585635424167.jpeg', 2, '2020-03-30 23:54:48');
INSERT INTO `dynamic` VALUES (3, '111', '杨贺大傻吊', 'upload/dynamic/1585635424159.jpg,upload/dynamic/1585635424167.jpeg', 2, '2020-03-31 14:17:04');
INSERT INTO `dynamic` VALUES (4, '李大艺', '真帅气', 'upload/dynamic/1585651229994.jpg,upload/dynamic/1585651231650.jpg,upload/dynamic/1585651231655.jpg,upload/dynamic/1585651231661.jpg,upload/dynamic/1585651231666.jpg,upload/dynamic/1585651231671.jpg', 3, '2020-03-31 18:40:31');

-- ----------------------------
-- Table structure for dynamic_comments
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_comments`;
CREATE TABLE `dynamic_comments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 评论主键自增id',
  `dynamic_id` int(11) NULL DEFAULT NULL COMMENT '评论动态id',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `from_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户(存储用户名)',
  `identify_id` tinyint(1) NULL DEFAULT 0 COMMENT '用户区分评论类型',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic_comments
-- ----------------------------
INSERT INTO `dynamic_comments` VALUES (1, 1, '真是的', '1', 0, '2020-03-30 21:59:25');
INSERT INTO `dynamic_comments` VALUES (2, 1, '使得', '2', 0, '2020-03-31 00:17:01');
INSERT INTO `dynamic_comments` VALUES (3, 3, '李小艺才是呢', '111', 0, '2020-03-31 15:37:52');
INSERT INTO `dynamic_comments` VALUES (4, 3, '发发发', '1', 0, '2020-03-31 16:54:52');
INSERT INTO `dynamic_comments` VALUES (5, 4, '没有杨贺帅', '李大艺', 0, '2020-03-31 18:41:57');
INSERT INTO `dynamic_comments` VALUES (6, 4, '早上好啊', '李1', 0, '2020-03-31 19:02:57');

-- ----------------------------
-- Table structure for dynamic_love
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_love`;
CREATE TABLE `dynamic_love`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态点赞自增id',
  `dynamic_id` int(11) NULL DEFAULT NULL COMMENT '动态id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `flag` int(1) NULL DEFAULT 1 COMMENT '是否点赞 （0 取消赞  1点赞）',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic_love
-- ----------------------------
INSERT INTO `dynamic_love` VALUES (1, 4, '李大艺', 1, '2020-03-31 18:41:10');
INSERT INTO `dynamic_love` VALUES (2, 3, '李大艺', 1, '2020-03-31 18:42:23');
INSERT INTO `dynamic_love` VALUES (3, 1, '李大艺', 1, '2020-03-31 18:42:29');
INSERT INTO `dynamic_love` VALUES (4, 4, '111', 1, '2020-03-31 18:42:53');
INSERT INTO `dynamic_love` VALUES (5, 3, '111', 1, '2020-03-31 18:43:05');
INSERT INTO `dynamic_love` VALUES (6, 1, '111', 1, '2020-03-31 18:43:29');
INSERT INTO `dynamic_love` VALUES (7, 4, '李1', 1, '2020-03-31 19:02:43');

-- ----------------------------
-- Table structure for dynamic_reply
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_reply`;
CREATE TABLE `dynamic_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复表自增id',
  `comment_id` int(11) NOT NULL COMMENT '评论id',
  `dynamic_id` int(11) NOT NULL COMMENT '动态id',
  `reply_type` tinyint(1) NOT NULL COMMENT '0 针对评论表  1针对回复表',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `from_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人(存储用户名)',
  `to_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复目标人(存储用户名)',
  `identify_id` tinyint(1) NULL DEFAULT 1 COMMENT '用户区分评论类型',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '该记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic_reply
-- ----------------------------
INSERT INTO `dynamic_reply` VALUES (1, 1, 1, 0, '你好', '2', '1', 1, '2020-03-30 22:00:20');
INSERT INTO `dynamic_reply` VALUES (2, 1, 1, 1, '你也好啊', '3', '2', 1, '2020-03-30 22:18:50');
INSERT INTO `dynamic_reply` VALUES (3, 2, 1, 1, '都好啊', '2', '3', 1, '2020-03-30 22:20:12');
INSERT INTO `dynamic_reply` VALUES (4, 1, 1, 0, '挺好的', '20', '1', 1, '2020-03-31 00:13:07');
INSERT INTO `dynamic_reply` VALUES (5, 4, 1, 1, '都是挺好', '21', '20', 1, '2020-03-31 00:13:44');
INSERT INTO `dynamic_reply` VALUES (6, 4, 1, 1, '咱们都好', '22', '20', 1, '2020-03-31 00:14:10');
INSERT INTO `dynamic_reply` VALUES (7, 22, 2, 0, '一起冲浪啊', '2', '1', 1, '2020-03-31 00:14:43');
INSERT INTO `dynamic_reply` VALUES (8, 2, 1, 0, 'a安定', '22', '2', 1, '2020-03-31 00:17:53');
INSERT INTO `dynamic_reply` VALUES (9, 3, 3, 0, '丰富房地产', '1', '111', 1, '2020-03-31 17:20:42');
INSERT INTO `dynamic_reply` VALUES (10, 4, 3, 0, '发过', '1', '1', 1, '2020-03-31 17:20:51');
INSERT INTO `dynamic_reply` VALUES (11, 1, 1, 0, '滚滚滚', '1', '1', 1, '2020-03-31 17:21:04');
INSERT INTO `dynamic_reply` VALUES (12, 1, 1, 0, '急急急', '1', '1', 1, '2020-03-31 17:21:27');
INSERT INTO `dynamic_reply` VALUES (13, 4, 1, 1, '啦啦啦', '1', '20', 1, '2020-03-31 17:25:06');
INSERT INTO `dynamic_reply` VALUES (14, 9, 3, 1, '啦啦啦', '李大艺', '1', 1, '2020-03-31 17:29:43');
INSERT INTO `dynamic_reply` VALUES (15, 3, 3, 0, '回家，即', '李大艺', '111', 1, '2020-03-31 17:31:01');
INSERT INTO `dynamic_reply` VALUES (16, 5, 4, 0, '那可不', '111', '李大艺', 1, '2020-03-31 18:43:00');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片自增id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `sort_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `praise_count` int(11) NULL DEFAULT 0 COMMENT '点赞量',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 214 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (8, 'upload/images/zhuapai/1584547467259.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (9, 'upload/images/zhuapai/1584547467285.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (10, 'upload/images/zhuapai/1584547467308.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (12, 'upload/images/zhuapai/1584547467344.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (13, 'upload/images/zhuapai/1584547467359.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (14, 'upload/images/zhuapai/1584547467377.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (15, 'upload/images/zhuapai/1584547467393.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (22, 'upload/images/zipai/1584547532387.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (23, 'upload/images/zipai/1584547532407.jpeg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (24, 'upload/images/zipai/1584547532417.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (25, 'upload/images/zipai/1584547532436.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (26, 'upload/images/zipai/1584547532447.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (27, 'upload/images/zipai/1584547532460.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (28, 'upload/images/zipai/1584547532471.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (29, 'upload/images/zipai/1584547532482.jpg', '自拍', '111', 1, '2020-03-19 00:05:32');
INSERT INTO `image` VALUES (30, 'upload/images/jiepai/1584547651912.jpg', '街拍', '111', 0, '2020-03-19 00:07:31');
INSERT INTO `image` VALUES (31, 'upload/images/jiepai/1584547651928.jpg', '街拍', '111', 0, '2020-03-19 00:07:31');
INSERT INTO `image` VALUES (32, 'upload/images/jiepai/1584547651938.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (33, 'upload/images/jiepai/1584547653627.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (34, 'upload/images/jiepai/1584547653679.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (35, 'upload/images/jiepai/1584547653703.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (36, 'upload/images/jiepai/1584547653721.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (37, 'upload/images/jiepai/1584547653744.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (38, 'upload/images/jiepai/1584547653773.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (39, 'upload/images/jiepai/1584547653786.png', '街拍', '111', 1, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (40, 'upload/images/jiepai/1584547653845.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (41, 'upload/images/jiepai/1584547653864.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (42, 'upload/images/jiepai/1584547653876.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (43, 'upload/images/jiepai/1584547653896.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (44, 'upload/images/jiepai/1584547653908.jpg', '街拍', '111', 0, '2020-03-19 00:07:33');
INSERT INTO `image` VALUES (45, 'upload/images/jiepai/1584547668728.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (46, 'upload/images/jiepai/1584547668746.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (47, 'upload/images/jiepai/1584547668759.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (48, 'upload/images/jiepai/1584547668774.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (49, 'upload/images/jiepai/1584547668807.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (50, 'upload/images/jiepai/1584547668833.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (51, 'upload/images/jiepai/1584547668845.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (52, 'upload/images/jiepai/1584547668868.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (53, 'upload/images/jiepai/1584547668893.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (54, 'upload/images/jiepai/1584547668902.png', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (55, 'upload/images/jiepai/1584547668912.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (56, 'upload/images/jiepai/1584547668930.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (57, 'upload/images/jiepai/1584547668940.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (58, 'upload/images/jiepai/1584547668952.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (59, 'upload/images/jiepai/1584547668962.jpg', '街拍', '111', 0, '2020-03-19 00:07:48');
INSERT INTO `image` VALUES (60, 'upload/images/lvyou/1584547694780.png', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (61, 'upload/images/lvyou/1584547694804.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (62, 'upload/images/lvyou/1584547694815.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (63, 'upload/images/lvyou/1584547694855.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (64, 'upload/images/lvyou/1584547694868.png', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (65, 'upload/images/lvyou/1584547694883.png', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (66, 'upload/images/lvyou/1584547694897.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (67, 'upload/images/lvyou/1584547694912.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (68, 'upload/images/lvyou/1584547694926.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (69, 'upload/images/lvyou/1584547694947.jpg', '旅游', '111', 0, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (70, 'upload/images/lvyou/1584547694959.jpg', '旅游', '111', 1, '2020-03-19 00:08:14');
INSERT INTO `image` VALUES (71, 'upload/images/jiepai/1584547711688.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (72, 'upload/images/jiepai/1584547711707.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (73, 'upload/images/jiepai/1584547711719.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (74, 'upload/images/jiepai/1584547711730.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (75, 'upload/images/jiepai/1584547711768.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (76, 'upload/images/jiepai/1584547711793.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (77, 'upload/images/jiepai/1584547711807.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (78, 'upload/images/jiepai/1584547711835.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (79, 'upload/images/jiepai/1584547711865.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (80, 'upload/images/jiepai/1584547711876.png', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (81, 'upload/images/jiepai/1584547711890.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (82, 'upload/images/jiepai/1584547711906.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (83, 'upload/images/jiepai/1584547711916.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (84, 'upload/images/jiepai/1584547711927.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (85, 'upload/images/jiepai/1584547711937.jpg', '街拍', '111', 0, '2020-03-19 00:08:31');
INSERT INTO `image` VALUES (86, 'upload/images/jiepai/1584547713196.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (87, 'upload/images/jiepai/1584547713211.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (88, 'upload/images/jiepai/1584547713225.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (89, 'upload/images/jiepai/1584547713237.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (90, 'upload/images/jiepai/1584547713281.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (91, 'upload/images/jiepai/1584547713325.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (92, 'upload/images/jiepai/1584547713343.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (93, 'upload/images/jiepai/1584547713369.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (94, 'upload/images/jiepai/1584547713397.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (95, 'upload/images/jiepai/1584547713410.png', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (96, 'upload/images/jiepai/1584547713420.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (97, 'upload/images/jiepai/1584547713436.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (98, 'upload/images/jiepai/1584547713446.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (99, 'upload/images/jiepai/1584547713460.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (100, 'upload/images/jiepai/1584547713471.jpg', '街拍', '111', 0, '2020-03-19 00:08:33');
INSERT INTO `image` VALUES (101, 'upload/images/jiepai/1584547715823.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (102, 'upload/images/jiepai/1584547715842.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (103, 'upload/images/jiepai/1584547715878.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (104, 'upload/images/jiepai/1584547715891.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (105, 'upload/images/jiepai/1584547715923.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (106, 'upload/images/jiepai/1584547715951.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (107, 'upload/images/jiepai/1584547715968.jpg', '街拍', '111', 0, '2020-03-19 00:08:35');
INSERT INTO `image` VALUES (108, 'upload/images/jiepai/1584547715995.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (109, 'upload/images/jiepai/1584547716021.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (110, 'upload/images/jiepai/1584547716033.png', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (111, 'upload/images/jiepai/1584547716046.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (112, 'upload/images/jiepai/1584547716063.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (113, 'upload/images/jiepai/1584547716075.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (114, 'upload/images/jiepai/1584547716086.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (115, 'upload/images/jiepai/1584547716096.jpg', '街拍', '111', 0, '2020-03-19 00:08:36');
INSERT INTO `image` VALUES (116, 'upload/images/jiepai/1584547721142.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (117, 'upload/images/jiepai/1584547721159.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (118, 'upload/images/jiepai/1584547721175.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (119, 'upload/images/jiepai/1584547721210.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (120, 'upload/images/jiepai/1584547721240.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (121, 'upload/images/jiepai/1584547721265.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (122, 'upload/images/jiepai/1584547721277.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (123, 'upload/images/jiepai/1584547721301.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (124, 'upload/images/jiepai/1584547721326.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (125, 'upload/images/jiepai/1584547721334.png', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (126, 'upload/images/jiepai/1584547721344.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (127, 'upload/images/jiepai/1584547721359.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (128, 'upload/images/jiepai/1584547721370.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (129, 'upload/images/jiepai/1584547721383.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (130, 'upload/images/jiepai/1584547721394.jpg', '街拍', '111', 0, '2020-03-19 00:08:41');
INSERT INTO `image` VALUES (132, 'upload/images/fengjing/1584547746944.png', '风景', '111', 0, '2020-03-19 00:09:06');
INSERT INTO `image` VALUES (133, 'upload/images/fengjing/1584547746962.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (134, 'upload/images/fengjing/1584547747005.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (135, 'upload/images/fengjing/1584547747016.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (136, 'upload/images/fengjing/1584547747027.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (137, 'upload/images/fengjing/1584547747039.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (138, 'upload/images/fengjing/1584547747051.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (139, 'upload/images/fengjing/1584547747062.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (140, 'upload/images/fengjing/1584547747073.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (141, 'upload/images/fengjing/1584547747084.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (142, 'upload/images/fengjing/1584547747095.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (143, 'upload/images/fengjing/1584547747105.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (144, 'upload/images/fengjing/1584547747114.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (145, 'upload/images/fengjing/1584547747124.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (146, 'upload/images/fengjing/1584547747134.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (147, 'upload/images/fengjing/1584547747145.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (149, 'upload/images/fengjing/1584547747165.png', '风景', '111', 0, '2020-03-19 00:09:07');
INSERT INTO `image` VALUES (150, 'upload/images/fengjing/1584547758147.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (151, 'upload/images/fengjing/1584547758175.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (152, 'upload/images/fengjing/1584547758190.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (153, 'upload/images/fengjing/1584547758205.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (154, 'upload/images/fengjing/1584547758220.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (155, 'upload/images/fengjing/1584547758231.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (156, 'upload/images/fengjing/1584547758248.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (157, 'upload/images/fengjing/1584547758258.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (158, 'upload/images/fengjing/1584547758269.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (159, 'upload/images/fengjing/1584547758278.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (160, 'upload/images/fengjing/1584547758301.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (161, 'upload/images/fengjing/1584547758311.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (162, 'upload/images/fengjing/1584547758321.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (163, 'upload/images/fengjing/1584547758332.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (164, 'upload/images/fengjing/1584547758342.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (165, 'upload/images/fengjing/1584547758351.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (166, 'upload/images/fengjing/1584547758360.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (167, 'upload/images/fengjing/1584547758370.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (168, 'upload/images/fengjing/1584547758381.png', '风景', '111', 0, '2020-03-19 00:09:18');
INSERT INTO `image` VALUES (169, 'upload/images/zipai/1585296612528.png', '自拍', '111', 0, '2020-03-27 16:10:12');
INSERT INTO `image` VALUES (170, 'upload/images/jiepai/1585572762519.jpg', '街拍', '111', 0, '2020-03-30 20:52:42');
INSERT INTO `image` VALUES (171, 'upload/images/jiepai/1585572835197.jpg', '街拍', '111', 0, '2020-03-30 20:53:55');
INSERT INTO `image` VALUES (172, 'upload/images/jiepai/1585572972390.jpg', '街拍', '111', 0, '2020-03-30 20:56:12');
INSERT INTO `image` VALUES (173, 'upload/images/zipai/1585573061962.jpg', '自拍', '111', 0, '2020-03-30 20:57:41');
INSERT INTO `image` VALUES (174, 'upload/images/zipai/1585573303169.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (175, 'upload/images/zipai/1585573303235.jpeg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (176, 'upload/images/zipai/1585573303251.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (177, 'upload/images/zipai/1585573303265.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (178, 'upload/images/zipai/1585573303283.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (179, 'upload/images/zipai/1585573303302.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (180, 'upload/images/zipai/1585573303319.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (181, 'upload/images/zipai/1585573303334.jpg', '自拍', '111', 0, '2020-03-30 21:01:43');
INSERT INTO `image` VALUES (182, 'upload/images/zipai/1585573546075.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (183, 'upload/images/zipai/1585573546142.jpeg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (184, 'upload/images/zipai/1585573546160.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (185, 'upload/images/zipai/1585573546176.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (186, 'upload/images/zipai/1585573546198.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (187, 'upload/images/zipai/1585573546218.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (188, 'upload/images/zipai/1585573546235.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (189, 'upload/images/zipai/1585573546254.jpg', '自拍', '111', 0, '2020-03-30 21:05:46');
INSERT INTO `image` VALUES (190, 'upload/images/lvyou/1585574084451.jpg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (191, 'upload/images/lvyou/1585574084526.jpeg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (192, 'upload/images/lvyou/1585574084544.jpg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (193, 'upload/images/lvyou/1585574084562.jpg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (194, 'upload/images/lvyou/1585574084579.jpg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (195, 'upload/images/lvyou/1585574084597.jpg', '旅游', '111', 0, '2020-03-30 21:14:44');
INSERT INTO `image` VALUES (196, 'upload/images/lvyou/1585574084614.jpg', '旅游', '111', 0, '2020-03-30 21:14:46');
INSERT INTO `image` VALUES (197, 'upload/images/lvyou/1585574086343.jpg', '旅游', '111', 0, '2020-03-30 21:14:46');
INSERT INTO `image` VALUES (206, 'upload/images/jishi/1585575012197.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (207, 'upload/images/jishi/1585575012240.jpeg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (208, 'upload/images/jishi/1585575012249.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (209, 'upload/images/jishi/1585575012259.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (210, 'upload/images/jishi/1585575012271.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (211, 'upload/images/jishi/1585575012283.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (212, 'upload/images/jishi/1585575012295.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');
INSERT INTO `image` VALUES (213, 'upload/images/jishi/1585575012305.jpg', '纪实', '111', 0, '2020-03-30 21:30:12');

-- ----------------------------
-- Table structure for love
-- ----------------------------
DROP TABLE IF EXISTS `love`;
CREATE TABLE `love`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '喜欢自增id',
  `img_id` int(11) NULL DEFAULT NULL COMMENT '图片id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `sort_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of love
-- ----------------------------
INSERT INTO `love` VALUES (1, 22, '111', '自拍', '2020-03-19 00:09:20');
INSERT INTO `love` VALUES (3, 24, '111', '自拍', '2020-03-19 00:09:22');
INSERT INTO `love` VALUES (4, 25, '111', '自拍', '2020-03-19 00:09:23');
INSERT INTO `love` VALUES (5, 29, '111', '自拍', '2020-03-19 00:09:25');
INSERT INTO `love` VALUES (6, 28, '111', '自拍', '2020-03-19 00:09:26');
INSERT INTO `love` VALUES (7, 27, '111', '自拍', '2020-03-19 00:09:28');
INSERT INTO `love` VALUES (8, 26, '111', '自拍', '2020-03-19 00:09:29');
INSERT INTO `love` VALUES (10, 39, '111', '街拍', '2020-03-19 00:10:01');
INSERT INTO `love` VALUES (12, 70, '111', '旅游', '2020-03-19 00:10:21');
INSERT INTO `love` VALUES (15, 23, '111', '自拍', '2020-03-19 18:58:46');

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '技巧自增id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `image_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片链接',
  `skill_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (2, '自拍技巧，记住这12种拍照姿势，拍出上镜好看自拍照', 'upload/skill/zipai.jpg', 'http://www.fsbus.com/sheyingjiqiao/20369.html', '2020-03-27 16:18:44');
INSERT INTO `skill` VALUES (3, '纪实拍摄技巧', 'upload/skill/1585663141307.jpg', 'http://www.360doc.com/content/16/0628/07/30242571_571290649.shtml', '2020-03-27 16:19:25');
INSERT INTO `skill` VALUES (4, '旅行必备几个小技巧', 'upload/skill/lvyou.jpg', 'https://baijiahao.baidu.com/s?id=1608329023841545576&wfr=spider&for=pc', '2020-03-27 16:19:59');
INSERT INTO `skill` VALUES (5, '八个风光摄影技巧，助你拍出风光大片', 'upload/skill/fengjing.jpeg', 'https://baijiahao.baidu.com/s?id=1610599732497579720&wfr=spider&for=pc', '2020-03-27 16:20:07');
INSERT INTO `skill` VALUES (6, '摄影抓拍9个技巧', 'upload/skill/zhuapai.jpg', 'https://www.sohu.com/a/259543871_99948670', '2020-03-27 16:20:16');
INSERT INTO `skill` VALUES (9, '绝美的自拍教程', 'upload/skill/1585662636437.jpg', 'https://zhuanlan.zhihu.com/p/77190151', '2020-03-31 21:50:36');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类自增id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '街拍', '2020-03-18 14:34:06');
INSERT INTO `sort` VALUES (2, '自拍', '2020-03-18 14:34:22');
INSERT INTO `sort` VALUES (3, '纪实', '2020-03-18 14:34:34');
INSERT INTO `sort` VALUES (4, '旅游', '2020-03-18 14:34:40');
INSERT INTO `sort` VALUES (5, '风景', '2020-03-18 14:34:45');
INSERT INTO `sort` VALUES (6, '抓拍', '2020-03-18 14:34:51');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户自增id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '7516c04c34c57db8595b58e49e84e637' COMMENT '用户密码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '用户类型( 1 普通用户 2 管理员)',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '该记录创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '李小艺', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '2', '2020-03-14 15:27:01');
INSERT INTO `user` VALUES (4, '李大艺', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-14 15:31:48');
INSERT INTO `user` VALUES (16, '杨小贺', '8d4bae510248b84723d476020ee5c38d', '男', '2020-03-17', NULL, '1', '2020-03-16 15:27:11');
INSERT INTO `user` VALUES (18, '李1', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', '呼呼呼呼', '1', '2020-03-18 13:08:35');
INSERT INTO `user` VALUES (24, '李2', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', '', '1', '2020-03-19 10:45:44');
INSERT INTO `user` VALUES (27, '李3', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 12:46:06');
INSERT INTO `user` VALUES (28, '李4', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 12:47:46');
INSERT INTO `user` VALUES (29, '李5', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 13:42:39');
INSERT INTO `user` VALUES (30, '李6', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 14:52:02');
INSERT INTO `user` VALUES (31, '李7', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 14:58:36');
INSERT INTO `user` VALUES (32, '李8', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 14:59:16');
INSERT INTO `user` VALUES (33, '李9', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 15:07:48');
INSERT INTO `user` VALUES (34, '李10', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 15:09:48');
INSERT INTO `user` VALUES (35, '李11', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-17', NULL, '1', '2020-03-19 15:11:16');

SET FOREIGN_KEY_CHECKS = 1;
