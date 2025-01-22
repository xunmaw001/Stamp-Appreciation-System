-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssm34f5g
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ssm34f5g`
--

/*!40000 DROP DATABASE IF EXISTS `ssm34f5g`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ssm34f5g` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ssm34f5g`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/1649212862089.png'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussgerenfenxiang`
--

DROP TABLE IF EXISTS `discussgerenfenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussgerenfenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212632035 DEFAULT CHARSET=utf8 COMMENT='个人分享评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussgerenfenxiang`
--

LOCK TABLES `discussgerenfenxiang` WRITE;
/*!40000 ALTER TABLE `discussgerenfenxiang` DISABLE KEYS */;
INSERT INTO `discussgerenfenxiang` VALUES (91,'2022-04-06 02:34:07',1,1,'用户名1','评论内容1','回复内容1'),(92,'2022-04-06 02:34:07',2,2,'用户名2','评论内容2','回复内容2'),(93,'2022-04-06 02:34:07',3,3,'用户名3','评论内容3','回复内容3'),(94,'2022-04-06 02:34:07',4,4,'用户名4','评论内容4','回复内容4'),(95,'2022-04-06 02:34:07',5,5,'用户名5','评论内容5','回复内容5'),(96,'2022-04-06 02:34:07',6,6,'用户名6','评论内容6','回复内容6'),(1649212632034,'2022-04-06 02:37:11',56,1649212524247,'11','这里是评价其它用户发布的分享',NULL);
/*!40000 ALTER TABLE `discussgerenfenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusswenzhangxinxi`
--

DROP TABLE IF EXISTS `discusswenzhangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusswenzhangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212598596 DEFAULT CHARSET=utf8 COMMENT='文章信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusswenzhangxinxi`
--

LOCK TABLES `discusswenzhangxinxi` WRITE;
/*!40000 ALTER TABLE `discusswenzhangxinxi` DISABLE KEYS */;
INSERT INTO `discusswenzhangxinxi` VALUES (81,'2022-04-06 02:34:07',1,1,'用户名1','评论内容1','回复内容1'),(82,'2022-04-06 02:34:07',2,2,'用户名2','评论内容2','回复内容2'),(83,'2022-04-06 02:34:07',3,3,'用户名3','评论内容3','回复内容3'),(84,'2022-04-06 02:34:07',4,4,'用户名4','评论内容4','回复内容4'),(85,'2022-04-06 02:34:07',5,5,'用户名5','评论内容5','回复内容5'),(86,'2022-04-06 02:34:07',6,6,'用户名6','评论内容6','回复内容6'),(1649212598595,'2022-04-06 02:36:38',45,1649212524247,'11','文章也是一样的推荐',NULL);
/*!40000 ALTER TABLE `discusswenzhangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussyoupiaoxinxi`
--

DROP TABLE IF EXISTS `discussyoupiaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussyoupiaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212579808 DEFAULT CHARSET=utf8 COMMENT='邮票信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussyoupiaoxinxi`
--

LOCK TABLES `discussyoupiaoxinxi` WRITE;
/*!40000 ALTER TABLE `discussyoupiaoxinxi` DISABLE KEYS */;
INSERT INTO `discussyoupiaoxinxi` VALUES (71,'2022-04-06 02:34:07',1,1,'用户名1','评论内容1','回复内容1'),(72,'2022-04-06 02:34:07',2,2,'用户名2','评论内容2','回复内容2'),(73,'2022-04-06 02:34:07',3,3,'用户名3','评论内容3','回复内容3'),(74,'2022-04-06 02:34:07',4,4,'用户名4','评论内容4','回复内容4'),(75,'2022-04-06 02:34:07',5,5,'用户名5','评论内容5','回复内容5'),(76,'2022-04-06 02:34:07',6,6,'用户名6','评论内容6','回复内容6'),(1649212579807,'2022-04-06 02:36:19',23,1649212524247,'11','这里的推荐是根据用户收藏了某类邮票进行推荐的，比如说这里收藏类类型3的，则该类型的排序就在首页推荐靠前','这里可以回复用户评论或者删除不良评论');
/*!40000 ALTER TABLE `discussyoupiaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerenfenxiang`
--

DROP TABLE IF EXISTS `gerenfenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gerenfenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fenxiangbiaoti` varchar(200) NOT NULL COMMENT '分享标题',
  `fenxiangfengmian` varchar(200) DEFAULT NULL COMMENT '分享封面',
  `fenxiangjianjie` longtext COMMENT '分享简介',
  `fenxiangneirong` longtext COMMENT '分享内容',
  `fenxiangriqi` date DEFAULT NULL COMMENT '分享日期',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212710766 DEFAULT CHARSET=utf8 COMMENT='个人分享';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerenfenxiang`
--

LOCK TABLES `gerenfenxiang` WRITE;
/*!40000 ALTER TABLE `gerenfenxiang` DISABLE KEYS */;
INSERT INTO `gerenfenxiang` VALUES (51,'2022-04-06 02:34:07','分享标题1','upload/gerenfenxiang_fenxiangfengmian1.jpg','分享简介1','分享内容1','2022-04-06','账号1','姓名1'),(52,'2022-04-06 02:34:07','分享标题2','upload/gerenfenxiang_fenxiangfengmian2.jpg','分享简介2','分享内容2','2022-04-06','账号2','姓名2'),(53,'2022-04-06 02:34:07','分享标题3','upload/gerenfenxiang_fenxiangfengmian3.jpg','分享简介3','分享内容3','2022-04-06','账号3','姓名3'),(54,'2022-04-06 02:34:07','分享标题4','upload/gerenfenxiang_fenxiangfengmian4.jpg','分享简介4','分享内容4','2022-04-06','账号4','姓名4'),(55,'2022-04-06 02:34:07','分享标题5','upload/gerenfenxiang_fenxiangfengmian5.jpg','分享简介5','分享内容5','2022-04-06','账号5','姓名5'),(56,'2022-04-06 02:34:07','分享标题6','upload/gerenfenxiang_fenxiangfengmian6.jpg','分享简介6','分享内容6','2022-04-06','账号6','姓名6'),(1649212710765,'2022-04-06 02:38:29','某某分享','upload/1649212685744.jpg','这里是用户分享的地方','<p>这里输入分享的内容</p><p>还可以适当的插入图片</p><p><img src=\"http://localhost:8080/ssm34f5g/upload/1649212708354.jpg\"></p>','2022-04-06','11','张三');
/*!40000 ALTER TABLE `gerenfenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212536868 DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
INSERT INTO `storeup` VALUES (1649212536867,'2022-04-06 02:35:35',1649212524247,23,'youpiaoxinxi','邮票名称3','upload/youpiaoxinxi_youpiaofengmian3.jpg','1','邮票分类3');
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1649212524247,'11','yonghu','用户','qzi4klv0jt2sot3wfy7o7empqvqo751w','2022-04-06 02:35:29','2022-04-06 03:41:16'),(2,1,'abo','users','管理员','7rg3yc2y0eu5uq1h34yjqeuzzf8dxpjl','2022-04-06 02:38:37','2022-04-06 03:38:38');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2022-04-06 02:34:07');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wenzhangxinxi`
--

DROP TABLE IF EXISTS `wenzhangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wenzhangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `wenzhangbiaoti` varchar(200) NOT NULL COMMENT '文章标题',
  `wenzhangfengmian` varchar(200) DEFAULT NULL COMMENT '文章封面',
  `youpiaofenlei` varchar(200) NOT NULL COMMENT '邮票分类',
  `wenzhangjianjie` longtext COMMENT '文章简介',
  `wenzhangneirong` longtext COMMENT '文章内容',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212840547 DEFAULT CHARSET=utf8 COMMENT='文章信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wenzhangxinxi`
--

LOCK TABLES `wenzhangxinxi` WRITE;
/*!40000 ALTER TABLE `wenzhangxinxi` DISABLE KEYS */;
INSERT INTO `wenzhangxinxi` VALUES (41,'2022-04-06 02:34:07','文章标题1','upload/wenzhangxinxi_wenzhangfengmian1.jpg','邮票分类1','文章简介1','文章内容1','2022-04-06','2022-04-06 10:34:07'),(42,'2022-04-06 02:34:07','文章标题2','upload/wenzhangxinxi_wenzhangfengmian2.jpg','邮票分类2','文章简介2','文章内容2','2022-04-06','2022-04-06 10:34:07'),(43,'2022-04-06 02:34:07','文章标题3','upload/wenzhangxinxi_wenzhangfengmian3.jpg','邮票分类3','文章简介3','文章内容3','2022-04-06','2022-04-06 10:34:07'),(44,'2022-04-06 02:34:07','文章标题4','upload/wenzhangxinxi_wenzhangfengmian4.jpg','邮票分类4','文章简介4','文章内容4','2022-04-06','2022-04-06 10:34:07'),(45,'2022-04-06 02:34:07','文章标题5','upload/wenzhangxinxi_wenzhangfengmian5.jpg','邮票分类5','文章简介5','文章内容5','2022-04-06','2022-04-06 10:37:39'),(46,'2022-04-06 02:34:07','文章标题6','upload/wenzhangxinxi_wenzhangfengmian6.jpg','邮票分类6','文章简介6','文章内容6','2022-04-06','2022-04-06 10:36:50'),(1649212840546,'2022-04-06 02:40:40','某某文章','upload/1649212827770.jpg','某某类','文章的简介','<p>文章的内容</p><p><img src=\"http://localhost:8080/ssm34f5g/upload/1649212838727.jpg\"></p>','2022-04-06','2022-04-06 10:41:33');
/*!40000 ALTER TABLE `wenzhangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `xiangpian` varchar(200) DEFAULT NULL COMMENT '相片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212524248 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2022-04-06 02:34:07','账号1','123456','姓名1','男','773890001@qq.com','13823888881','upload/yonghu_xiangpian1.jpg'),(12,'2022-04-06 02:34:07','账号2','123456','姓名2','男','773890002@qq.com','13823888882','upload/yonghu_xiangpian2.jpg'),(13,'2022-04-06 02:34:07','账号3','123456','姓名3','男','773890003@qq.com','13823888883','upload/yonghu_xiangpian3.jpg'),(14,'2022-04-06 02:34:07','账号4','123456','姓名4','男','773890004@qq.com','13823888884','upload/yonghu_xiangpian4.jpg'),(15,'2022-04-06 02:34:07','账号5','123456','姓名5','男','773890005@qq.com','13823888885','upload/yonghu_xiangpian5.jpg'),(16,'2022-04-06 02:34:07','账号6','123456','姓名6','男','773890006@qq.com','13823888886','upload/yonghu_xiangpian6.jpg'),(1649212524247,'2022-04-06 02:35:24','11','11','张三','男','131@163.com','13111111111','upload/1649212640629.jpg');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youpiaofenlei`
--

DROP TABLE IF EXISTS `youpiaofenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youpiaofenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youpiaofenlei` varchar(200) NOT NULL COMMENT '邮票分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212729173 DEFAULT CHARSET=utf8 COMMENT='邮票分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youpiaofenlei`
--

LOCK TABLES `youpiaofenlei` WRITE;
/*!40000 ALTER TABLE `youpiaofenlei` DISABLE KEYS */;
INSERT INTO `youpiaofenlei` VALUES (31,'2022-04-06 02:34:07','邮票分类1'),(32,'2022-04-06 02:34:07','邮票分类2'),(33,'2022-04-06 02:34:07','邮票分类3'),(34,'2022-04-06 02:34:07','邮票分类4'),(35,'2022-04-06 02:34:07','邮票分类5'),(36,'2022-04-06 02:34:07','邮票分类6'),(1649212729172,'2022-04-06 02:38:48','某某类');
/*!40000 ALTER TABLE `youpiaofenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youpiaoxinxi`
--

DROP TABLE IF EXISTS `youpiaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youpiaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `youpiaomingcheng` varchar(200) NOT NULL COMMENT '邮票名称',
  `youpiaofengmian` varchar(200) DEFAULT NULL COMMENT '邮票封面',
  `youpiaofenlei` varchar(200) NOT NULL COMMENT '邮票分类',
  `zuozhe` varchar(200) NOT NULL COMMENT '作者',
  `fabunianxian` date DEFAULT NULL COMMENT '发布年限',
  `caizhi` varchar(200) DEFAULT NULL COMMENT '材质',
  `chicun` varchar(200) DEFAULT NULL COMMENT '尺寸',
  `mianzhi` varchar(200) DEFAULT NULL COMMENT '面值',
  `yinshuadanwei` varchar(200) NOT NULL COMMENT '印刷单位',
  `youpiaoxiangqing` longtext COMMENT '邮票详情',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1649212795807 DEFAULT CHARSET=utf8 COMMENT='邮票信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youpiaoxinxi`
--

LOCK TABLES `youpiaoxinxi` WRITE;
/*!40000 ALTER TABLE `youpiaoxinxi` DISABLE KEYS */;
INSERT INTO `youpiaoxinxi` VALUES (21,'2022-04-06 02:34:07','邮票名称1','upload/youpiaoxinxi_youpiaofengmian1.jpg','邮票分类1','作者1','2022-04-06','材质1','尺寸1','面值1','印刷单位1','邮票详情1','2022-04-06 10:34:07'),(22,'2022-04-06 02:34:07','邮票名称2','upload/youpiaoxinxi_youpiaofengmian2.jpg','邮票分类2','作者2','2022-04-06','材质2','尺寸2','面值2','印刷单位2','邮票详情2','2022-04-06 10:34:07'),(23,'2022-04-06 02:34:07','邮票名称3','upload/youpiaoxinxi_youpiaofengmian3.jpg','邮票分类3','作者3','2022-04-06','材质3','尺寸3','面值3','印刷单位3','邮票详情3','2022-04-06 10:36:22'),(24,'2022-04-06 02:34:07','邮票名称4','upload/youpiaoxinxi_youpiaofengmian4.jpg','邮票分类4','作者4','2022-04-06','材质4','尺寸4','面值4','印刷单位4','邮票详情4','2022-04-06 10:36:45'),(25,'2022-04-06 02:34:07','邮票名称5','upload/youpiaoxinxi_youpiaofengmian5.jpg','邮票分类5','作者5','2022-04-06','材质5','尺寸5','面值5','印刷单位5','邮票详情5','2022-04-06 10:41:23'),(26,'2022-04-06 02:34:07','邮票名称6','upload/youpiaoxinxi_youpiaofengmian6.jpg','邮票分类6','作者6','2022-04-06','材质6','尺寸6','面值6','印刷单位6','邮票详情6','2022-04-06 10:34:07'),(1649212795806,'2022-04-06 02:39:55','某某邮票','upload/1649212738249.png','某某类','某某','2020-01-01','纸张','120*120','5元','某某单位','<p>这里输入邮票的详情</p><p><img src=\"http://localhost:8080/ssm34f5g/upload/1649212793618.jpg\"></p>','2022-04-06 10:41:27');
/*!40000 ALTER TABLE `youpiaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08 18:33:35
