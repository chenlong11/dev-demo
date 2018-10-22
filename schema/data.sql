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
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_dic`
--

LOCK TABLES `sys_dic` WRITE;
/*!40000 ALTER TABLE `sys_dic` DISABLE KEYS */;
INSERT INTO `sys_dic` VALUES (11031228362784774,'性别','SEX',1,'2018-10-17','11:22:42',1);
/*!40000 ALTER TABLE `sys_dic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_dic_data`
--

LOCK TABLES `sys_dic_data` WRITE;
/*!40000 ALTER TABLE `sys_dic_data` DISABLE KEYS */;
INSERT INTO `sys_dic_data` VALUES (11105153339883520,11031228362784774,'1','男',1),(11105153339883521,11031228362784774,'2','女',2);
/*!40000 ALTER TABLE `sys_dic_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_local_auth`
--

LOCK TABLES `sys_local_auth` WRITE;
/*!40000 ALTER TABLE `sys_local_auth` DISABLE KEYS */;
INSERT INTO `sys_local_auth` VALUES (9497632980336737,9497632980336738,1,'super','1f81b277ff308114ba7db97cfdd4d877',1);
/*!40000 ALTER TABLE `sys_local_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_module`
--

LOCK TABLES `sys_module` WRITE;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
INSERT INTO `sys_module` VALUES (9497632980336731,1,'system:dic','数据字典','',9497632980336733,2,2,'1999-01-01','00:00:00',1),(9497632980336732,1,'system:dic:manage','数据字典维护','/admin/dic/list',9497632980336731,3,1,'1999-01-01','00:00:00',1),(9497632980336733,1,'system','系统管理','',-1,1,1,'1999-01-01','00:00:00',1),(9497632980336734,1,'system:permission','角色权限','',9497632980336733,2,1,'1999-01-01','00:00:00',1),(9497632980336735,1,'system:permission:module','模块管理','/admin/module/treeList',9497632980336734,3,1,'1999-01-01','00:00:00',1),(9823586638364672,1,'system:permission:org','机构管理','/admin/org/treeList',9497632980336734,3,2,'2018-10-16','14:53:18',1),(9834238157258763,1,'system:permission:user','人员管理','/admin/user/orgTreeList',9497632980336734,3,3,'2018-10-16','17:13:49',1),(11031228362784773,1,'system:permission:role','角色管理','/admin/role/orgTreeList',9497632980336734,3,5,'2018-10-17','10:51:49',1),(13945518291943424,1,'system:permission:dept','部门管理','/admin/dept/orgTreeList',9497632980336734,3,6,'2018-10-19','09:30:53',1),(14094519297376258,1,'system:permission:roleReserve','预留角色','/admin/role/reserveList',9497632980336734,3,4,'2018-10-19','13:19:32',1);
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_module_role`
--

LOCK TABLES `sys_module_role` WRITE;
/*!40000 ALTER TABLE `sys_module_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_module_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_org`
--

LOCK TABLES `sys_org` WRITE;
/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` VALUES (9834238157258759,9834238157258759,'河南省',-1,'',-1,'','河南省','001',1,-1,'500849',1,'2018-10-16','16:08:39',1);
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (9497632980336718,-1,1,'super','超级管理员',1,'1999-01-01','00:00:00',1),(11105153339883525,1,1,'lv1','1级机构',1,'2018-10-17','00:00:00',1),(11105153339883526,2,1,'lv2','2级机构',2,'2018-10-17','00:00:00',1),(11105153339883527,3,1,'lv3','3级机构',3,'2018-10-17','00:00:00',1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (9497632980336738,9834238157258759,-1,'超级管理员','super','','',1,'1999-01-01','00:00:00',1);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `worker_node`
--

LOCK TABLES `worker_node` WRITE;
/*!40000 ALTER TABLE `worker_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_node` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-22  9:06:41
