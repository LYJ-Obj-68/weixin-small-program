/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : weixin-mall

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-04-16 13:00:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `d_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '详情表(主键id)',
  `d_title` varchar(255) NOT NULL COMMENT '详情主题',
  `d_decripte` varchar(255) NOT NULL COMMENT '描述',
  `d_picurl` varchar(255) NOT NULL COMMENT '图片保存路径',
  `d_oldprice` decimal(65,4) NOT NULL COMMENT '原价',
  `d_newprice` decimal(65,4) NOT NULL COMMENT '现价',
  `v_id` int(20) NOT NULL COMMENT '关联 分类id',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES ('1', '辅食营养_one', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_1.jpg', '678.0000', '578.0000', '1');
INSERT INTO `details` VALUES ('2', '辅食营养_two', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_2.jpg', '899.0000', '799.0000', '1');
INSERT INTO `details` VALUES ('3', '辅食营养_three', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_3.jpg', '999.0000', '899.0000', '1');
INSERT INTO `details` VALUES ('4', '辅食营养_four', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_4.jpg', '789.0000', '720.0000', '1');
INSERT INTO `details` VALUES ('5', '辅食营养_five', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_5.jpg', '678.0000', '568.0000', '1');
INSERT INTO `details` VALUES ('6', '辅食营养_six', '辅食是完整营养均衡，对成长中的孩子是很重要的，特别是在0岁阶段的营养给予，更是奠定宝宝一生健康的根基；辅食包括米粉、泥湖状食品以及其他的一些家制食品。', 'http://localhost:8080/static/image/fu_6.jpg', '666.0000', '600.0000', '1');
INSERT INTO `details` VALUES ('7', '护肤美体_one', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_1.jpg', '666.0000', '600.0000', '3');
INSERT INTO `details` VALUES ('8', '护肤美体_two', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_2.jpg', '568.0000', '500.0000', '3');
INSERT INTO `details` VALUES ('9', '护肤美体_three', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_3.jpg', '586.0000', '510.0000', '3');
INSERT INTO `details` VALUES ('10', '护肤美体_four', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_4.jpg', '888.0000', '800.0000', '3');
INSERT INTO `details` VALUES ('11', '护肤美体_five', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_5.jpg', '389.0000', '310.0000', '3');
INSERT INTO `details` VALUES ('12', '护肤美体_six', '美,从护肤开始，注重自己的外在形象，提升自己的气质！越活越自信！', 'http://localhost:8080/static/image/hufu_6.jpg', '356.0000', '256.0000', '3');
INSERT INTO `details` VALUES ('13', '母婴用品_one', '母婴用品是指为孕产期女性与0-3岁婴儿这两类特殊相关联群体提供的专业健康产品。', 'http://localhost:8080/static/image/muyin_1.jpg', '698.0000', '589.0000', '2');
INSERT INTO `details` VALUES ('14', '母婴用品_two', '母婴用品是指为孕产期女性与0-3岁婴儿这两类特殊相关联群体提供的专业健康产品。', 'http://localhost:8080/static/image/muyin_2.jpg', '888.0000', '780.0000', '2');
INSERT INTO `details` VALUES ('15', '母婴用品_three', '母婴用品是指为孕产期女性与0-3岁婴儿这两类特殊相关联群体提供的专业健康产品。', 'http://localhost:8080/static/image/muyin_3.jpg', '860.0000', '800.0000', '2');
INSERT INTO `details` VALUES ('16', '轻奢女装_one', '人靠衣装，马靠鞍！穿着讲究可以体现一个人外在气质！', 'http://localhost:8080/static/image/nvzhuang_1.jpg', '299.0000', '199.0000', '4');
INSERT INTO `details` VALUES ('17', '轻奢女装_two', '人靠衣装，马靠鞍！穿着讲究可以体现一个人外在气质！', 'http://localhost:8080/static/image/nvzhuang_2.jpg', '268.0000', '200.0000', '4');
INSERT INTO `details` VALUES ('18', '轻奢女装_three', '人靠衣装，马靠鞍！穿着讲究可以体现一个人外在气质！', 'http://localhost:8080/static/image/nvzhuang_3.jpg', '568.0000', '500.0000', '4');

-- ----------------------------
-- Table structure for slider
-- ----------------------------
DROP TABLE IF EXISTS `slider`;
CREATE TABLE `slider` (
  `s_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '轮播图表(主键id)',
  `s_title` varchar(255) DEFAULT NULL COMMENT '主题',
  `s_picurl` varchar(255) NOT NULL COMMENT '代表图',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of slider
-- ----------------------------
INSERT INTO `slider` VALUES ('1', '特价商品', 'http://localhost:8080/static/image/main_1.jpg');
INSERT INTO `slider` VALUES ('2', '今日抢购', 'http://localhost:8080/static/image/main_2.jpg');
INSERT INTO `slider` VALUES ('3', 'vip专区', 'http://localhost:8080/static/image/main_3.jpg');
INSERT INTO `slider` VALUES ('4', '热购区', 'http://localhost:8080/static/image/main_4.jpg');

-- ----------------------------
-- Table structure for venues
-- ----------------------------
DROP TABLE IF EXISTS `venues`;
CREATE TABLE `venues` (
  `v_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '种类表(主键id)',
  `v_title` varchar(255) NOT NULL COMMENT '主题',
  `v_decripte` varchar(255) NOT NULL COMMENT '主题描述',
  `v_picurl` varchar(255) NOT NULL COMMENT '图片存放路径',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of venues
-- ----------------------------
INSERT INTO `venues` VALUES ('1', '辅食营养', '健康生活', 'http://localhost:8080/static/image/fushi.jpg');
INSERT INTO `venues` VALUES ('2', '母婴专区', '呵护从小孕育', 'http://localhost:8080/static/image/muyin.jpg');
INSERT INTO `venues` VALUES ('3', '护肤美体', '美,从护肤开始', 'http://localhost:8080/static/image/hufu.jpg');
INSERT INTO `venues` VALUES ('4', '轻奢女装', '便捷出行', 'http://localhost:8080/static/image/nvzhuang.jpg');
