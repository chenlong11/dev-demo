-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dev_demo
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `sys_attachment`
--

DROP TABLE IF EXISTS `sys_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_attachment` (
  `id` bigint(20) NOT NULL,
  `business_id` bigint(20) DEFAULT '-1' COMMENT '业务id',
  `att_type` varchar(32) DEFAULT '' COMMENT '附件类型',
  `att_name` varchar(50) DEFAULT '' COMMENT '附件名称',
  `att_path` varchar(100) DEFAULT '' COMMENT '附件路径',
  `att_size` varchar(32) DEFAULT '' COMMENT '附件大小',
  `att_ext` varchar(32) DEFAULT '' COMMENT '扩展名',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_id` bigint(20) DEFAULT '-1' COMMENT '创建人id',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL,
  `org_id` bigint(20) DEFAULT '-1' COMMENT '机构id',
  `dept_name` varchar(50) DEFAULT '',
  `dept_code` varchar(32) DEFAULT '',
  `lv` tinyint(4) DEFAULT '1',
  `pid` bigint(20) DEFAULT '-1',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_dic`
--

DROP TABLE IF EXISTS `sys_dic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dic` (
  `id` bigint(20) NOT NULL,
  `dic_name` varchar(50) DEFAULT '' COMMENT '名称',
  `dic_code` varchar(32) DEFAULT '' COMMENT '编码',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_dic_data`
--

DROP TABLE IF EXISTS `sys_dic_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dic_data` (
  `id` bigint(20) NOT NULL,
  `dic_id` bigint(20) DEFAULT '-1' COMMENT '字典id',
  `data_code` varchar(50) DEFAULT '' COMMENT '字典数据编码',
  `data_val` varchar(32) DEFAULT '' COMMENT '字典数据值',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_local_auth`
--

DROP TABLE IF EXISTS `sys_local_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_local_auth` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '用户id',
  `account_type` tinyint(4) DEFAULT '1' COMMENT '1 用户名 2 手机号 3 微信',
  `account_name` varchar(32) DEFAULT '' COMMENT '账户',
  `account_password` varchar(32) DEFAULT '' COMMENT '密码',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_module`
--

DROP TABLE IF EXISTS `sys_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_module` (
  `id` bigint(20) NOT NULL,
  `module_type` tinyint(4) DEFAULT '1' COMMENT '模块类型',
  `module_code` varchar(100) DEFAULT '' COMMENT '模块编码',
  `module_name` varchar(50) DEFAULT '' COMMENT '模块名称',
  `module_url` varchar(200) DEFAULT '' COMMENT '模块URL',
  `pid` bigint(20) DEFAULT '-1' COMMENT '父ID',
  `lv` tinyint(4) DEFAULT '1' COMMENT '层级',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_module_role`
--

DROP TABLE IF EXISTS `sys_module_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_module_role` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '角色id',
  `module_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '模块id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL,
  `lv1_id` bigint(20) DEFAULT '-1',
  `lv1_name` varchar(32) DEFAULT '',
  `lv2_id` bigint(20) DEFAULT '-1',
  `lv2_name` varchar(32) DEFAULT '',
  `lv3_id` bigint(20) DEFAULT '-1',
  `lv3_name` varchar(32) DEFAULT '',
  `org_name` varchar(50) DEFAULT '',
  `org_code` varchar(32) DEFAULT '',
  `lv` tinyint(4) DEFAULT '1',
  `pid` bigint(20) DEFAULT '-1',
  `org_path` varchar(100) DEFAULT '',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `org_id` bigint(20) DEFAULT '-1',
  `reserved_flag` tinyint(4) DEFAULT '1' COMMENT '系统内置标识[1 是 2 否]',
  `role_code` varchar(100) DEFAULT '' COMMENT '角色编码',
  `role_name` varchar(50) DEFAULT '' COMMENT '角色名称',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `org_id` bigint(20) DEFAULT '-1',
  `dept_id` bigint(20) DEFAULT '-1',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户名',
  `account_name` varchar(32) DEFAULT '',
  `mobile_no` varchar(15) DEFAULT '' COMMENT '手机号',
  `email` varchar(32) DEFAULT '' COMMENT '邮箱',
  `sn` smallint(6) DEFAULT '999' COMMENT '顺序号',
  `create_date` date NOT NULL COMMENT '创建日期',
  `create_time` time NOT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '角色id',
  `user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `worker_node`
--

DROP TABLE IF EXISTS `worker_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker_node` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `HOST_NAME` varchar(64) NOT NULL COMMENT 'host name',
  `PORT` varchar(64) NOT NULL COMMENT 'port',
  `TYPE` int(11) NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
  `LAUNCH_DATE` date NOT NULL COMMENT 'launch date',
  `MODIFIED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'modified time',
  `CREATED` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'created time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='DB WorkerID Assigner for UID Generator';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-14 10:34:52
