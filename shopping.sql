/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : shopping

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 12/12/2019 15:54:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `discussid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsid` int(11) DEFAULT NULL COMMENT '商品id\r\n',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论',
  `grade` int(255) DEFAULT NULL COMMENT '评论星级',
  PRIMARY KEY (`discussid`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `discuss_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名字',
  `attribute` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `price` int(255) DEFAULT NULL COMMENT '图片链接',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品详情',
  `Imageid` int(11) DEFAULT NULL COMMENT '商品图片',
  `salesvolume` int(255) DEFAULT NULL COMMENT '销量',
  `store` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺名',
  `storeid` int(11) DEFAULT NULL COMMENT '店铺id',
  `date` datetime(0) DEFAULT NULL COMMENT '上架时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('崇杰写真', '0', 0, 987654321, NULL, NULL, 2, '0', NULL, NULL);
INSERT INTO `goods` VALUES ('崇杰性感写真', '0', 2, 1, NULL, NULL, -335, NULL, NULL, NULL);
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 3, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 5, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 6, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 7, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 8, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 9, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES ('醇自然家纺ins网红韩式刺绣小清新床笠款四件套全棉纯棉白色床单', '1', 10, 88, '壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开', 0, 800, '极有家', 0, '2019-12-11 15:31:54');
INSERT INTO `goods` VALUES (NULL, NULL, 41, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 42, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 43, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 44, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 45, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 46, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 47, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 48, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 49, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 51, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 52, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 53, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 54, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 55, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 57, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 58, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 59, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 60, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 61, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 62, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 63, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 64, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 65, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 66, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 67, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 68, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 69, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (NULL, NULL, 70, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goods_receiving
-- ----------------------------
DROP TABLE IF EXISTS `goods_receiving`;
CREATE TABLE `goods_receiving`  (
  `userid` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人名字\r\n',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人手机号',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人地址',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_receiving
-- ----------------------------
INSERT INTO `goods_receiving` VALUES (1, '江崇杰', '18319795400', '江门职业技术学院');

-- ----------------------------
-- Table structure for goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku`  (
  `sp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '属性',
  `goodsid` int(11) DEFAULT NULL COMMENT '商品',
  `stock` int(255) DEFAULT NULL COMMENT '库存',
  `price` float(10, 2) DEFAULT NULL COMMENT '价格',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片',
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `goods_sku_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(11) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (0, 'https://img.alicdn.com/imgextra/i2/730412079/TB2dPo4idhvOuFjSZFBXXcZgFXa_!!730412079.jpg');

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `member_id` bigint(20) NOT NULL COMMENT '会员id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime(0) DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户帐号',
  `pay_amount` decimal(10, 2) DEFAULT NULL COMMENT '支付金额',
  `integration_amount` decimal(10, 2) DEFAULT NULL COMMENT '积分抵扣金额',
  `coupon_amount` decimal(10, 2) DEFAULT NULL COMMENT '优惠券抵扣金额',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `receiver_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人电话',
  `receiver_adress` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货人地址',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(1) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `payment_time` datetime(0) DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime(0) DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime(0) DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime(0) DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES (1, 0, '0', '2019-12-10 16:47:57', '0', 0.00, 0.00, 0.00, 1, '0', '0', '0', '0', 0, 0, '2019-12-10 16:48:17', '2019-12-10 16:48:19', '2019-12-03 16:48:24', '2019-12-18 16:48:26');
INSERT INTO `oms_order` VALUES (2, 0, '0', '2019-12-10 16:47:57', '0', 0.00, 0.00, 0.00, 0, '0', '0', '0', '0', 0, 0, '2019-12-10 16:48:17', '2019-12-10 16:48:19', '2019-12-03 16:48:24', '2019-12-18 16:48:26');

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item`  (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `product_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品品牌',
  `product_price` decimal(10, 2) DEFAULT NULL COMMENT '销售价格',
  `product_quantity` int(11) DEFAULT NULL COMMENT '购买数量',
  `product_sku_id` bigint(20) DEFAULT NULL COMMENT '商品sku编号',
  `product_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oms_order_item
-- ----------------------------
INSERT INTO `oms_order_item` VALUES (1, 1, '0', 1, '100', '1', '1', 1.00, 1, 1, '1');
INSERT INTO `oms_order_item` VALUES (2, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (3, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (4, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (5, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (6, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (7, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (8, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (9, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (10, 1, '0', 1, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (11, 1, '0', 2, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (12, 1, '0', 2, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (13, 1, '0', 2, '100', '1', '4', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (14, 1, '0', 2, '100', '1', '4', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (15, 1, '0', 2, '100', '1', '4', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (16, 1, '0', 5, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (17, 1, '0', 5, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (18, 1, '0', 9, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (19, 1, '0', 9, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (20, 1, '0', 32, '100', '1', '1', 1.00, 8, 1, '1');
INSERT INTO `oms_order_item` VALUES (21, 1, '0', 32, '100', '1', '1', 1.00, -100, 1, '1');
INSERT INTO `oms_order_item` VALUES (22, 1, '0', 2, '100', '1', '1', 1.00, -100, 1, '2');
INSERT INTO `oms_order_item` VALUES (23, 1, '0', 2, '100', '1', '1', 1.00, -100, 1, '2');

-- ----------------------------
-- Table structure for shoppingcar
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar`  (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `id` int(11) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购物车id\r\n',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格',
  `stroeid` int(11) DEFAULT NULL,
  `stroename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE,
  INDEX `shoppingcar_ibfk_1`(`userid`) USING BTREE,
  CONSTRAINT `shoppingcar_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shoppingcar_ibfk_3` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `storename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否启用',
  `registration_date` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `headsculpture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'string', 'string', 'string', 'string', 'string', '2019-12-10 03:26:33', 'string', 'string', 'string');
INSERT INTO `user` VALUES (18, '李梓熙', '男', '18319795400', '江门职业技术学院k', '0', '2019-12-09 02:48:40', '942418004@qq.com', '9494', 'https://img2.woyaogexing.com/2019/12/03/0acdbae3411441a19a8e74204cabc702!400x400.jpeg');
INSERT INTO `user` VALUES (19, '李梓熙', '男', '18319795400', '江门职业技术学院', '0', '2019-12-09 02:49:09', '942418004@qq.com', '942418004@qq.com', 'https://img2.woyaogexing.com/2019/12/03/0acdbae3411441a19a8e74204cabc702!400x400.jpeg');
INSERT INTO `user` VALUES (20, '啊', '男', '18319795400', 'a', '0', '2019-12-12 06:20:33', 'a', 'a', 'null');

SET FOREIGN_KEY_CHECKS = 1;
