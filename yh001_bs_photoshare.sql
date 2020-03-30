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

 Date: 29/03/2020 23:48:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 170 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'upload/images/jishi/1584547445520.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (2, 'upload/images/jishi/1584547445552.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (3, 'upload/images/jishi/1584547445572.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (5, 'upload/images/jishi/1584547445612.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (6, 'upload/images/jishi/1584547445632.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (7, 'upload/images/jishi/1584547445652.jpg', '纪实', '111', 0, '2020-03-19 00:04:05');
INSERT INTO `image` VALUES (8, 'upload/images/zhuapai/1584547467259.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (9, 'upload/images/zhuapai/1584547467285.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (10, 'upload/images/zhuapai/1584547467308.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (12, 'upload/images/zhuapai/1584547467344.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (13, 'upload/images/zhuapai/1584547467359.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (14, 'upload/images/zhuapai/1584547467377.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (15, 'upload/images/zhuapai/1584547467393.jpg', '抓拍', '111', 0, '2020-03-19 00:04:27');
INSERT INTO `image` VALUES (16, 'upload/images/jishi/1584547526110.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
INSERT INTO `image` VALUES (17, 'upload/images/jishi/1584547526171.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
INSERT INTO `image` VALUES (18, 'upload/images/jishi/1584547526200.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
INSERT INTO `image` VALUES (19, 'upload/images/jishi/1584547526230.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
INSERT INTO `image` VALUES (20, 'upload/images/jishi/1584547526253.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
INSERT INTO `image` VALUES (21, 'upload/images/jishi/1584547526290.jpg', '纪实', '111', 0, '2020-03-19 00:05:26');
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
  `url` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `sort_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (1, 'https://baijiahao.baidu.com/s?id=1641920666607287269&wfr=spider&for=pc', '自拍', '2020-03-19 16:32:20');
INSERT INTO `skill` VALUES (2, 'http://www.fsbus.com/sheyingjiqiao/20369.html', '街拍', '2020-03-27 16:18:44');
INSERT INTO `skill` VALUES (3, 'http://www.360doc.com/content/16/0628/07/30242571_571290649.shtml', '纪实', '2020-03-27 16:19:25');
INSERT INTO `skill` VALUES (4, 'https://baijiahao.baidu.com/s?id=1608329023841545576&wfr=spider&for=pc', '旅游', '2020-03-27 16:19:59');
INSERT INTO `skill` VALUES (5, 'https://baijiahao.baidu.com/s?id=1610599732497579720&wfr=spider&for=pc', '风景', '2020-03-27 16:20:07');
INSERT INTO `skill` VALUES (6, 'https://www.sohu.com/a/259543871_99948670', '抓拍', '2020-03-27 16:20:16');

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
INSERT INTO `user` VALUES (3, '李小艺', '7516c04c34c57db8595b58e49e84e637', '女', '2020-03-17', NULL, '2', '2020-03-14 15:27:01');
INSERT INTO `user` VALUES (4, '李大艺', '7516c04c34c57db8595b58e49e84e637', '女', '2020-02-01', NULL, '1', '2020-03-14 15:31:48');
INSERT INTO `user` VALUES (16, '杨小贺', '7516c04c34c57db8595b58e49e84e637', '男', NULL, NULL, '1', '2020-03-16 15:27:11');
INSERT INTO `user` VALUES (18, '111', '8d4bae510248b84723d476020ee5c38d', '女', '2020-03-16', '呼呼呼呼', '1', '2020-03-18 13:08:35');
INSERT INTO `user` VALUES (24, '222', '423275795f866bd2f762ff8a7742dbb9', '', NULL, '', '1', '2020-03-19 10:45:44');
INSERT INTO `user` VALUES (27, '999', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 12:46:06');
INSERT INTO `user` VALUES (28, '666', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 12:47:46');
INSERT INTO `user` VALUES (29, '小一', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 13:42:39');
INSERT INTO `user` VALUES (30, '1', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 14:52:02');
INSERT INTO `user` VALUES (31, '啦啦啦啦啦啦', '12bf5a431554b14fd297ab765cddb568', NULL, NULL, NULL, '1', '2020-03-19 14:58:36');
INSERT INTO `user` VALUES (32, '呼呼呼', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 14:59:16');
INSERT INTO `user` VALUES (33, '大阳', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 15:07:48');
INSERT INTO `user` VALUES (34, '嘤嘤嘤', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 15:09:48');
INSERT INTO `user` VALUES (35, '哭唧唧', '8d4bae510248b84723d476020ee5c38d', NULL, NULL, NULL, '1', '2020-03-19 15:11:16');

SET FOREIGN_KEY_CHECKS = 1;
