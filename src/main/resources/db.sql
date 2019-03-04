-- MySQL dump 10.13  Distrib 5.6.9-rc, for Win64 (x86_64)
--
-- Host: localhost    Database: appointment
-- ------------------------------------------------------
-- Server version	5.6.9-rc-log

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



--Create Database appointment
CREATE DATABASE appointment;

INSERT INTO mysql.user(Host,User,Password) values("localhost","zhh",password("zhh1026"));

GRANT all privileges on appointment.* to zhh@localhost identified by 'zhh1026';

flush privileges;

use appointment;
--
-- Table structure for table `app_admin`
--

DROP TABLE IF EXISTS `app_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '管理员名称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `admin_code` varchar(12) DEFAULT NULL COMMENT '管理员编码',
  `email` varchar(45) DEFAULT NULL,
  `IDcard` varchar(45) DEFAULT NULL,
  `authority` varchar(1) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_admin`
--

LOCK TABLES `app_admin` WRITE;
/*!40000 ALTER TABLE `app_admin` DISABLE KEYS */;
INSERT INTO `app_admin` VALUES (6,'管理员1',23,'13218020018','a25dec56fe51d8b685c91f610fc8a731ffdbaad568dca00744dcb6e743e916cd','13218020018','448826602@qq.com','3402412421321312','0',NULL,'男');
/*!40000 ALTER TABLE `app_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_appointment_record`
--

DROP TABLE IF EXISTS `app_appointment_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_appointment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `user_name` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `opt_time` varchar(14) DEFAULT NULL COMMENT '操作时间',
  `appoint_time` varchar(14) DEFAULT NULL COMMENT '预约时间',
  `doctor_code` varchar(12) DEFAULT NULL COMMENT '预约医生编码',
  `doctor_name` varchar(200) DEFAULT NULL COMMENT '医生姓名',
  `hospital` varchar(255) DEFAULT NULL COMMENT '医院名称',
  `department` varchar(255) DEFAULT NULL COMMENT '科室名称',
  `disease` varchar(500) DEFAULT NULL COMMENT '病情描述',
  `finish_time` varchar(14) DEFAULT NULL COMMENT '完成就诊时间',
  `fail_reason` varchar(255) DEFAULT NULL COMMENT '未完成就诊原因，完成后此字段为空',
  `hospital_code` varchar(12) DEFAULT NULL COMMENT '预约医院编码',
  `hospital_name` varchar(200) DEFAULT NULL COMMENT '预约医院名称',
  `department_code` varchar(12) DEFAULT NULL COMMENT '预约科室编码',
  `department_name` varchar(100) DEFAULT NULL COMMENT '预约科室名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='预约记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_appointment_record`
--

LOCK TABLES `app_appointment_record` WRITE;
/*!40000 ALTER TABLE `app_appointment_record` DISABLE KEYS */;
INSERT INTO `app_appointment_record` VALUES (18,'13218020019','萧红','20180313200523','20180314','','值班医生','北京协和医院','儿科',NULL,NULL,NULL,'000001','北京协和医院','EK001','儿科'),(19,'13218020019','萧红','20180313202315','20180329','','值班医生','北京协和医院','妇科',NULL,NULL,NULL,'000001','北京协和医院','F001','妇科'),(20,'13218020019','萧红','20180314125319','20180315','','值班医生','北京协和医院','神经外科',NULL,NULL,NULL,'000001','北京协和医院','SJW001','神经外科'),(21,'13218020019','萧红','20180314125458','20180316','','值班医生','北京协和医院','神经外科',NULL,NULL,NULL,'000001','北京协和医院','SJW001','神经外科'),(23,'13218020019','萧红','20180314130407','20180323','9999','值班医生','北京协和医院','神经外科',NULL,NULL,NULL,'000001','北京协和医院','SJW001','神经外科'),(24,'13218020018','用户1','20180507173626','20180510','9999','值班医生','北京协和医院','神经外科',NULL,NULL,NULL,'000001','北京协和医院','SJW001','神经外科');
/*!40000 ALTER TABLE `app_appointment_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_department`
--

DROP TABLE IF EXISTS `app_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '科室名称',
  `code` varchar(12) DEFAULT NULL COMMENT '科室编码',
  `description` varchar(1000) DEFAULT NULL COMMENT '科室介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='医院科室表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_department`
--

LOCK TABLES `app_department` WRITE;
/*!40000 ALTER TABLE `app_department` DISABLE KEYS */;
INSERT INTO `app_department` VALUES (1,'神经外科','SJW001','神经外科（Neurosurgery）是外科学中的一个分支，是在外科学以手术为主要治疗手段的基础上，应用独特的神经外科学研究方法，研究人体神经系统。'),(8,'妇科','F001','妇科是医疗机构的一个诊疗科目，妇科是妇产科的一个分支专业，是以诊疗女性妇科病为诊疗的专业科室，分为西医妇科与中医妇科。'),(9,'儿科','EK001','儿科是全面研究小儿时期身心发育、保健以及疾病防治的综合医学科学。凡涉及儿童和青少年时期的健康与卫生问题都属于儿科范围。其医治对象处于生长发育期。'),(10,'骨科','GK001','有关人体骨骼的科目'),(11,'眼科','YK001','眼科的全称是“眼病专科”，是研究发生在视觉系统，包括眼球及与其相关联的组织有关疾病的学科。'),(12,'口腔科','KQK001','口腔科，医学学科分类之一。主要口腔科疾病包括：口腔颌面部皮样、表皮颌下间隙感染、颌面部淋巴管瘤、齿状突发育畸形、上颌窦恶性肿瘤、颌骨造釉细胞瘤、慢性筛窦炎、下颌后缩、四环素牙、舌白斑等疾病。现在的技术，许多牙周病完全可以治愈。'),(13,'皮肤科','PFK001','皮肤科属于外科，主要治疗各种皮肤病，常见皮肤病有牛皮癣 、 疱疹 、酒渣鼻 、脓疱疮 、化脓菌感染 、疤痕 、癣 、鱼鳞病 、腋臭 、青春痘 、毛囊炎 、斑秃脱发 、男科炎症 、婴儿尿布疹 、鸡眼 、雀斑 、汗疱疹 、螨虫性皮炎 、白癜风 、湿疹 、灰指甲 、硬皮病 、皮肤瘙痒 、口腔部护理 、脱毛 、黄褐斑等。'),(14,'耳鼻喉科','EBH001','“耳鼻咽喉科”是诊断治疗耳、鼻、咽、喉、及其相关头颈区域的外科学科。随着科技的进步与发展，医学各科相互渗透和促进，拓展了耳鼻咽喉科的范畴，耳显微外科，耳神经外科，侧颅底外科，听力学及平衡科学，鼻内镜外科，鼻神经外科（鼻颅底外科），头颈外科，喉显微外科，嗓音与言语疾病科，小儿耳鼻咽喉科等的出现，大大丰富了耳鼻咽喉科的内容。');
/*!40000 ALTER TABLE `app_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_department_hospital`
--

DROP TABLE IF EXISTS `app_department_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_department_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_code` varchar(12) DEFAULT NULL COMMENT '科室编码',
  `hospital_code` varchar(12) DEFAULT NULL COMMENT '医院编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='医院与科室关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_department_hospital`
--

LOCK TABLES `app_department_hospital` WRITE;
/*!40000 ALTER TABLE `app_department_hospital` DISABLE KEYS */;
INSERT INTO `app_department_hospital` VALUES (1,'SJW001','000001'),(2,'F001','000001'),(3,'EK001','000001'),(4,'GK001','000001'),(5,'YK001','000001'),(6,'PFK001','000001'),(7,'EBH001','000001'),(8,'KQK001','000001'),(9,'KQK001','000002'),(10,'EBH001','000002'),(11,'EBH001','000005'),(12,'EK001','000005'),(13,'EK001','000002'),(14,'F001','000002'),(15,'GK001','000002'),(16,'EK001','000003'),(17,'GK001','000003'),(18,'EBH001','000003'),(19,'KQK001','000003'),(20,'F001','000003'),(21,'SJW001','000004'),(22,'F001','000004'),(23,'EK001','000004'),(24,'GK001','000004'),(25,'YK001','000004'),(26,'PFK001','000004'),(27,'EBH001','000004');
/*!40000 ALTER TABLE `app_department_hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_doctor`
--

DROP TABLE IF EXISTS `app_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '医生姓名',
  `age` int(11) NOT NULL COMMENT '医生年龄',
  `level` varchar(100) DEFAULT NULL COMMENT '医生级别',
  `sex` varchar(2) DEFAULT NULL COMMENT '医生性别',
  `exprience` varchar(4000) DEFAULT NULL COMMENT '医生履历',
  `image` varchar(2000) DEFAULT NULL COMMENT '医生图片',
  `email` varchar(100) DEFAULT NULL COMMENT '医生邮箱',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '医生电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭住址',
  `hospital_code` varchar(12) DEFAULT NULL COMMENT '所属医院',
  `doctor_code` varchar(12) DEFAULT NULL COMMENT '医生编码',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `IDcard` varchar(18) DEFAULT NULL,
  `department_code` varchar(45) DEFAULT NULL,
  `hospitalName` varchar(200) DEFAULT NULL,
  `departmentName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='医生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_doctor`
--

LOCK TABLES `app_doctor` WRITE;
/*!40000 ALTER TABLE `app_doctor` DISABLE KEYS */;
INSERT INTO `app_doctor` VALUES (6,'医生1',22,'普通医生','男','大师',NULL,'448826602@qq.com','13218020018','浙江省杭州市拱墅区','000001','13218020018','a25dec56fe51d8b685c91f610fc8a731ffdbaad568dca00744dcb6e743e916cd','343343123123123123','SJW001','北京协和医院','神经外科');
/*!40000 ALTER TABLE `app_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_evaluation`
--

DROP TABLE IF EXISTS `app_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `appointment_code` int(11) DEFAULT NULL COMMENT '预约记录',
  `content` varchar(2000) DEFAULT NULL COMMENT '评价内容',
  `opt_time` varchar(14) DEFAULT NULL COMMENT '评价时间',
  `doctor_code` varchar(16) DEFAULT NULL COMMENT '医生编码',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='预约评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_evaluation`
--

LOCK TABLES `app_evaluation` WRITE;
/*!40000 ALTER TABLE `app_evaluation` DISABLE KEYS */;
INSERT INTO `app_evaluation` VALUES (1,NULL,NULL,'这个系统真是不够完善，请继续','20180310141642',NULL,'0'),(2,NULL,NULL,'qweqweqwe','20180310141854',NULL,'0'),(3,NULL,NULL,'12312','20180310142138',NULL,'0'),(4,NULL,NULL,'qweqweqwe','20180312170144','13210011001','0');
/*!40000 ALTER TABLE `app_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_hospital`
--

DROP TABLE IF EXISTS `app_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键		',
  `name` varchar(255) NOT NULL COMMENT '医院名称',
  `address` varchar(400) NOT NULL COMMENT '医院地址',
  `description` varchar(2000) DEFAULT NULL COMMENT '医院描述',
  `level` varchar(12) DEFAULT NULL COMMENT '医院等级',
  `website` varchar(100) DEFAULT NULL COMMENT '医院网站',
  `area` varchar(12) DEFAULT NULL COMMENT '医院区域',
  `type` varchar(12) DEFAULT NULL COMMENT '医院类别',
  `image` varchar(2000) DEFAULT NULL COMMENT '医院图片介绍',
  `phone` varchar(50) NOT NULL COMMENT '医院电话',
  `property` varchar(50) DEFAULT NULL,
  `code` varchar(12) DEFAULT NULL COMMENT '医院标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_hospital_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='医院表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_hospital`
--

LOCK TABLES `app_hospital` WRITE;
/*!40000 ALTER TABLE `app_hospital` DISABLE KEYS */;
INSERT INTO `app_hospital` VALUES (2,'北京协和医院','[东院]北京市东城区帅府园一号 [西院]北京市西城区大木仓胡同41号',' 北京协和医院是集医疗、教学、科研于一体的大型三级甲等综合医院，是国家卫生计生委指定的全国疑难重症诊治指导中心，也是最早承担高干保健和外宾医疗任务的医院之一，以学科齐全、技术力量雄厚、特色专科突出、多学科综合优势强大享誉海内外。在2010、2011、2012、2013、2014年复旦大学医院管理研究所公布的“中国最佳医院排行榜”中连续五年名列榜首。','301','\r\nhttp://www.pumch.cn/','010101',NULL,'bjxh.jpg','69156114','','000001'),(3,'中国人民解放军总医院(301医院)','北京市海淀区复兴路28号','中国人民解放军总医院（301医院）创建于1953年，是集医疗、保健、教学、科研于一体的大型现代化综合性医院。医院担负党中央、中央军委和总部首长及部分驻京部队官兵的医疗保健任务，承担各军区、军兵种转送的疑难、危重病人的诊治工作，收治全国各地的患者。医院同时又是解放军医学院，是全军唯一一所医院办学单位。','301','\r\nhttp://www.301hospital.com.cn/','010102',NULL,'zgrmjfj.jpg','\r\n010-66887329',NULL,'000002'),(4,'北京大学第一医院','北京市西城区西什库大街八号','北京大学第一医院（简称“北大医院”）位于北京老皇城内，是距离中南海最近的医院，是一所融医疗、教学、科研、预防为一体的大型综合性三级甲等医院，是中央保健基地医院。','301','\r\nhttp://www.bddyyy.com.cn/','010103','','bjdxdiyy.jpg','010-83572211、010-66551056(院办)',NULL,'000003'),(5,'北京市中关村医院','海淀区中关村南路12号','中关村医院创建于1957年，前身为中国科学院西郊门诊部，经过50多年的历史积淀，发展成为一所由海淀区卫生局所属的集医、教、研、防、社区卫生服务为一体的二级甲等综合性医院。医院建筑面积3.3万平方米，拥有现代化的门诊医技大楼和内科楼。设有急诊科、口腔科、中医科等27个门急诊科室，心血管内科、神经内科、肿瘤内科等12个临床科室，放射科、超声诊断科等9个医技辅助科室，开放病床255张。医院注重人才的培养和引进，现有职工767人，专业技术人员661人，其中高级职称62人，中级职称177人。','201','\r\nhttp://www.zgchospital.com/','010104',NULL,'bjzgcyy.jpg','\r\n010-82548751',NULL,'000004'),(6,'北京惠民中医儿童医院','北京市东城区珠市口东大街4号1-B2','在北京地铁5号线磁器口站D口向西200米处坐落着一家精致小巧的儿童专科医院，蓝白主色的建筑外观，看上去和平常的医院无异。只有门口边上的几幅竖条牌匾在静悄悄的展示着这家医院的与众不同。——它是包括北京儿童医院、北京中医医院、北京友谊医院在内的多家知名三甲公立医院的协作医院。','103','\r\nhttp://www.hmzyet.com','010101',NULL,'bjhmzyetyy.jpg','\r\n400-686-8861',NULL,'000005');
/*!40000 ALTER TABLE `app_hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_schedule`
--

DROP TABLE IF EXISTS `app_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_code` varchar(12) DEFAULT NULL,
  `hospital_code` varchar(12) DEFAULT NULL,
  `appoint_day` varchar(8) DEFAULT NULL,
  `doctor_code` varchar(12) DEFAULT NULL,
  `total_limit` int(11) DEFAULT '200',
  `left_limit` int(11) DEFAULT '200',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1564 DEFAULT CHARSET=utf8 COMMENT='预约调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_schedule`
--

LOCK TABLES `app_schedule` WRITE;
/*!40000 ALTER TABLE `app_schedule` DISABLE KEYS */;
INSERT INTO `app_schedule` VALUES (1563,'SJW001','000001','20180510',NULL,500,499);
/*!40000 ALTER TABLE `app_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `qq` varchar(20) DEFAULT NULL COMMENT '用户QQ',
  `email` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `user_code` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `IDcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `phone_number` varchar(16) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (17,'用户1',22,NULL,'448826602@qq.com','南京金陵科技学院','13218020018','男','a25dec56fe51d8b685c91f610fc8a731ffdbaad568dca00744dcb6e743e916cd','343123213213213123','13218020018');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sd_h_area`
--

DROP TABLE IF EXISTS `sd_h_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sd_h_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent` int(11) NOT NULL DEFAULT '0' COMMENT '父级区域',
  `name` varchar(2000) NOT NULL COMMENT '区域名称',
  `zipcode` int(11) DEFAULT NULL COMMENT '区域邮编',
  `code` varchar(6) NOT NULL COMMENT '区域标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sd_h_area_code_uindex` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='静态数据地区表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sd_h_area`
--

LOCK TABLES `sd_h_area` WRITE;
/*!40000 ALTER TABLE `sd_h_area` DISABLE KEYS */;
INSERT INTO `sd_h_area` VALUES (1,0,'东城区',NULL,'010101'),(2,0,'海淀区',NULL,'010102'),(3,0,'西城区',NULL,'010103'),(4,0,'中关村',NULL,'010104');
/*!40000 ALTER TABLE `sd_h_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sd_h_level`
--

DROP TABLE IF EXISTS `sd_h_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sd_h_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '医院等级名称',
  `code` varchar(6) NOT NULL COMMENT '等级标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='医院等级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sd_h_level`
--

LOCK TABLES `sd_h_level` WRITE;
/*!40000 ALTER TABLE `sd_h_level` DISABLE KEYS */;
INSERT INTO `sd_h_level` VALUES (1,'一级甲等','101'),(2,'一级乙等','102'),(3,'一级丙等','103'),(4,'二级甲等','201'),(5,'二级乙等','202'),(6,'二级丙等','203'),(7,'三级甲等','301'),(8,'三级乙等','302'),(9,'三级丙等','303');
/*!40000 ALTER TABLE `sd_h_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sd_h_type`
--

DROP TABLE IF EXISTS `sd_h_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sd_h_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(1000) NOT NULL COMMENT '医院类型名称',
  `parent` int(11) NOT NULL COMMENT '父级所属类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医院类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sd_h_type`
--

LOCK TABLES `sd_h_type` WRITE;
/*!40000 ALTER TABLE `sd_h_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `sd_h_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-24 19:29:35
