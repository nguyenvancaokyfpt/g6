-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: training_support_system
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `ass_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `ass_body` varchar(5000) NOT NULL,
  `eval_weight` int NOT NULL,
  `is_team_work` tinyint(1) NOT NULL,
  `is_ongoing` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`ass_id`),
  KEY `subject_id` (`subject_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `class_id` int NOT NULL,
  `trainer_id` int NOT NULL,
  `schedule_id` int NOT NULL,
  `status_id` int NOT NULL,
  `comment` varchar(500) NOT NULL,
  UNIQUE KEY `class_id` (`class_id`,`trainer_id`,`schedule_id`),
  KEY `class_id_2` (`class_id`),
  KEY `trainer_id` (`trainer_id`),
  KEY `schedule_id` (`schedule_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `attendance_ibfk_3` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`),
  CONSTRAINT `attendance_ibfk_4` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_code` varchar(255) NOT NULL,
  `combo_id` int NOT NULL,
  `trainer_id` int NOT NULL,
  `term_id` int NOT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`class_id`),
  KEY `status_id` (`status_id`),
  KEY `combo_id` (`combo_id`),
  KEY `trainer_id` (`trainer_id`),
  KEY `term_id` (`term_id`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_lesson`
--

DROP TABLE IF EXISTS `class_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_lesson` (
  `class_lesson_id` int NOT NULL AUTO_INCREMENT,
  `lesson_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `class_id` int NOT NULL,
  `slot_id` int NOT NULL,
  PRIMARY KEY (`class_lesson_id`),
  KEY `slot_id` (`slot_id`),
  KEY `lesson_id` (`lesson_id`),
  KEY `subject_id` (`subject_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `class_lesson_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `class_lesson_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`lesson_id`),
  CONSTRAINT `class_lesson_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_lesson`
--

LOCK TABLES `class_lesson` WRITE;
/*!40000 ALTER TABLE `class_lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_setting`
--

DROP TABLE IF EXISTS `class_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `type_id` int NOT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `class_id` int NOT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `status_id` (`status_id`),
  KEY `type_id` (`type_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `class_setting_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `class_setting_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_setting`
--

LOCK TABLES `class_setting` WRITE;
/*!40000 ALTER TABLE `class_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_user`
--

DROP TABLE IF EXISTS `class_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_user` (
  `class_id` int NOT NULL,
  `user_id` int NOT NULL,
  `team_id` int NOT NULL,
  `is_leader` tinyint(1) NOT NULL,
  `status_id` int NOT NULL,
  `note` varchar(500) NOT NULL,
  `dropout_date` date NOT NULL,
  UNIQUE KEY `class_id` (`class_id`,`user_id`),
  KEY `team_id` (`team_id`),
  KEY `status_id` (`status_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `class_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `class_user_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `class_user_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `class_user_ibfk_4` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_user`
--

LOCK TABLES `class_user` WRITE;
/*!40000 ALTER TABLE `class_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `mobile` int NOT NULL,
  `address` int NOT NULL,
  `position` int NOT NULL,
  `company` int NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eval_criteria`
--

DROP TABLE IF EXISTS `eval_criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eval_criteria` (
  `criteria_id` int NOT NULL AUTO_INCREMENT,
  `ass_id` int NOT NULL,
  `milestone_id` int NOT NULL,
  `criteria_name` varchar(255) NOT NULL,
  `is_team_eval` tinyint(1) NOT NULL,
  `eval_weight` int NOT NULL,
  `max_loc` int NOT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`criteria_id`),
  KEY `ass_id` (`ass_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `eval_criteria_ibfk_1` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ass_id`),
  CONSTRAINT `eval_criteria_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `eval_criteria_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eval_criteria`
--

LOCK TABLES `eval_criteria` WRITE;
/*!40000 ALTER TABLE `eval_criteria` DISABLE KEYS */;
/*!40000 ALTER TABLE `eval_criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue` (
  `issue_id` int NOT NULL AUTO_INCREMENT,
  `team_id` int NOT NULL,
  `author_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `type_id` int NOT NULL,
  `status_id` int NOT NULL,
  `extra_labels` varchar(1000) NOT NULL,
  `description` varchar(500) NOT NULL,
  `linked_id` int NOT NULL,
  `gitlab_url` varchar(500) NOT NULL,
  `is_closed` tinyint(1) NOT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `team_id` (`team_id`),
  KEY `author_id` (`author_id`),
  KEY `status_id` (`status_id`),
  KEY `type_id` (`type_id`),
  KEY `linked_id` (`linked_id`),
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `issue_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `lesson_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `author_id` int NOT NULL,
  `video_url` varchar(500) NOT NULL,
  `file_url` varchar(500) NOT NULL,
  `body` text NOT NULL,
  `module_id` int NOT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `subject_id` (`subject_id`),
  KEY `author_id` (`author_id`),
  KEY `module_id` (`module_id`),
  CONSTRAINT `lesson_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loc_eval`
--

DROP TABLE IF EXISTS `loc_eval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loc_eval` (
  `loc_eval_id` int NOT NULL AUTO_INCREMENT,
  `complexity_id` int NOT NULL,
  `quality_id` int NOT NULL,
  `converted_loc` int NOT NULL,
  `is_late_submit` tinyint(1) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `new_milestone_id` int NOT NULL,
  `new_complexity_id` int NOT NULL,
  PRIMARY KEY (`loc_eval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loc_eval`
--

LOCK TABLES `loc_eval` WRITE;
/*!40000 ALTER TABLE `loc_eval` DISABLE KEYS */;
/*!40000 ALTER TABLE `loc_eval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_eval`
--

DROP TABLE IF EXISTS `member_eval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_eval` (
  `member_eval_id` int NOT NULL AUTO_INCREMENT,
  `evaluation_id` int NOT NULL,
  `criteria_id` int NOT NULL,
  `total_loc` int NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`member_eval_id`),
  KEY `evaluation_id` (`evaluation_id`),
  KEY `criteria_id` (`criteria_id`),
  CONSTRAINT `member_eval_ibfk_1` FOREIGN KEY (`criteria_id`) REFERENCES `eval_criteria` (`criteria_id`),
  CONSTRAINT `member_eval_ibfk_2` FOREIGN KEY (`evaluation_id`) REFERENCES `milestone_eval` (`evaluation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_eval`
--

LOCK TABLES `member_eval` WRITE;
/*!40000 ALTER TABLE `member_eval` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_eval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone`
--

DROP TABLE IF EXISTS `milestone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone` (
  `milestone_id` int NOT NULL AUTO_INCREMENT,
  `ass_id` int NOT NULL,
  `class_id` int NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `ass_body` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`milestone_id`),
  KEY `ass_id` (`ass_id`),
  KEY `class_id` (`class_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `milestone_ibfk_1` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ass_id`),
  CONSTRAINT `milestone_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone_eval`
--

DROP TABLE IF EXISTS `milestone_eval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone_eval` (
  `evaluation_id` int NOT NULL AUTO_INCREMENT,
  `milestone_id` int NOT NULL,
  `class_id` int NOT NULL,
  `bonus` float NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL,
  `submit_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`evaluation_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `class_id` (`class_id`),
  KEY `submit_id` (`submit_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `milestone_eval_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `milestone_eval_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `milestone_eval_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `milestone_eval_ibfk_4` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone_eval`
--

LOCK TABLES `milestone_eval` WRITE;
/*!40000 ALTER TABLE `milestone_eval` DISABLE KEYS */;
/*!40000 ALTER TABLE `milestone_eval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `package_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`package_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `package_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `screen_id` int NOT NULL,
  `setting_id` int NOT NULL,
  `can_get` tinyint(1) NOT NULL,
  `can_delete` tinyint(1) NOT NULL,
  `can_create` tinyint(1) NOT NULL,
  `can_update` tinyint(1) NOT NULL,
  UNIQUE KEY `screen_id` (`screen_id`,`setting_id`),
  KEY `setting_id` (`setting_id`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`setting_id`),
  CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`screen_id`) REFERENCES `screen` (`screen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,21,1,1,1,1),(2,21,1,1,1,1),(2,22,1,1,1,1),(2,23,1,1,1,1),(2,24,1,1,1,1),(2,25,1,1,1,1),(2,26,1,1,1,1),(3,21,1,1,1,1),(3,22,1,1,1,1),(3,23,1,1,1,1),(3,24,1,1,1,1),(3,26,1,1,1,1),(4,21,1,1,1,1),(5,21,1,1,1,1),(6,21,1,1,1,1),(7,21,1,1,1,1),(10,21,1,1,1,1),(11,21,1,1,1,1);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reset_password_token`
--

DROP TABLE IF EXISTS `reset_password_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reset_password_token` (
  `user_id` int NOT NULL,
  `token` varchar(500) NOT NULL,
  `salt` bigint NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `reset_password_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reset_password_token`
--

LOCK TABLES `reset_password_token` WRITE;
/*!40000 ALTER TABLE `reset_password_token` DISABLE KEYS */;
INSERT INTO `reset_password_token` VALUES (2,'59f2c6865dc5f92152d8b2b7972f31c8',1664420351317,'2022-09-29 02:59:11');
/*!40000 ALTER TABLE `reset_password_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `slot_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `training_date` date NOT NULL,
  `from_time` time NOT NULL,
  `to_time` time NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen`
--

DROP TABLE IF EXISTS `screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `screen` (
  `screen_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen`
--

LOCK TABLES `screen` WRITE;
/*!40000 ALTER TABLE `screen` DISABLE KEYS */;
INSERT INTO `screen` VALUES (1,'User Management','/management/user'),(2,'User Profile','/profile'),(3,'Dashboard','/dashboard'),(4,'Setting','/settingList'),(5,'Setting Detail','/settingDetail'),(6,'User Details','/management/userdetails'),(7,'Web Contact List','/webcontact/webcontactlist'),(10,'Subject List','/subject/list'),(11,'Subject Details','/subject/details');
/*!40000 ALTER TABLE `screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `type_id` int DEFAULT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) DEFAULT NULL,
  `display_order` varchar(255) DEFAULT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `type_id` (`type_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `setting_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (1,0,'User Role',NULL,NULL,1,NULL),(21,1,'ADMIN',NULL,NULL,1,NULL),(22,1,'MANAGER',NULL,NULL,1,NULL),(23,1,'EXPERT',NULL,NULL,1,NULL),(24,1,'TRAINER',NULL,NULL,1,NULL),(25,1,'SUPPORTER',NULL,NULL,1,NULL),(26,1,'STUDENT',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL,
  `status_title` varchar(255) NOT NULL,
  `status_value` varchar(255) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (0,'Inactive','inactive'),(1,'Active','active');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(255) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  `manager_id` int NOT NULL,
  `expert_id` int NOT NULL,
  `status_id` int NOT NULL,
  `body` text NOT NULL,
  `img_src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `status_id` (`status_id`),
  KEY `expert_id` (`expert_id`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`expert_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `subject_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'PRO192','Object-Oriented Programming',2,3,1,'                                While it may not be obvious to everyone, there are a number of reasons creating random paragraphs can be useful. A few examples of how some people use this generator are listed in the following paragraphs.\r\n\r\n                            ','assets/media/books/8.png'),(2,'MAD101','Discrete mathematics',2,3,1,'A random paragraph can also be an excellent way for a writer to tackle writers\' block. Writing block can often happen due to being stuck with a current project that the writer is trying to complete. By inserting a completely random paragraph from which to begin, it can take down some of the issues that may have been causing the writers\' block in the first place.','assets/media/books/1.png'),(3,'MAE101','Mathematics for Engineering',3,2,1,'Another productive way to use this tool to begin a daily writing routine. One way is to generate a random paragraph with the intention to try to rewrite it while still keeping the original meaning. The purpose here is to just get the writing started so that when the writer goes onto their day\'s writing projects, words are already flowing from their fingers.','assets/media/books/2.png'),(4,'PRF192','Programming Fundamentals',3,2,1,'                                Another writing challenge can be to take the individual sentences in the random paragraph and incorporate a single sentence from that into a new paragraph to create a short story. Unlike the random sentence generator, the sentences from the random paragraph will have some connection to one another so it will be a bit different. You also won\'t know exactly how many sentences will appear in the random paragraph.\r\n                            ','assets/media/books/3.png'),(5,'CEA201','Computer Organization and Architecture',2,3,1,'It\'s not only writers who can benefit from this free online tool. If you\'re a programmer who\'s working on a project where blocks of text are needed, this tool can be a great way to get that. It\'s a good way to test your programming and that the tool being created is working well.','assets/media/books/4.png'),(6,'CSI104','Introduction to Computer Science',3,2,1,'Above are a few examples of how the random paragraph generator can be beneficial. The best way to see if this random paragraph picker will be useful for your intended purposes is to give it a try. Generate a number of paragraphs to see if they are beneficial to your current project.','assets/media/books/5.png'),(7,'CSD201','Data Structures and Algorithms',2,3,0,'Yes. We\'re always interested in improving this generator and one of the best ways to do that is to add new and interesting paragraphs to the generator. If you\'d like to contribute some random paragraphs, please contact us.','assets/media/books/6.png'),(8,'MAS291','Statistics and Probability',3,3,1,'There are usually about 200 words in a paragraph, but this can vary widely. Most paragraphs focus on a single idea that\'s expressed with an introductory sentence, then followed by two or more supporting sentences about the idea.','assets/media/books/7.png'),(9,'PRJ301','Java Web Application Development',3,3,1,'day la subject thu 9 nhe!!!\r\n','assets/media/books/9.png'),(10,'SWP391','Application development project',2,2,1,'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English.\r\n','assets/media/books/10.png');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_setting`
--

DROP TABLE IF EXISTS `subject_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `type_id` int NOT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `status_id` (`status_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `subject_setting_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `subject_setting_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_setting`
--

LOCK TABLES `subject_setting` WRITE;
/*!40000 ALTER TABLE `subject_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submit`
--

DROP TABLE IF EXISTS `submit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submit` (
  `submit_id` int NOT NULL AUTO_INCREMENT,
  `milestone_id` int NOT NULL,
  `class_id` int NOT NULL,
  `team_id` int NOT NULL,
  `submit_file_url` varchar(500) NOT NULL,
  `submit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`submit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submit`
--

LOCK TABLES `submit` WRITE;
/*!40000 ALTER TABLE `submit` DISABLE KEYS */;
/*!40000 ALTER TABLE `submit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `project_code` varchar(255) NOT NULL,
  `topic_code` varchar(255) NOT NULL,
  `topic_name` varchar(255) NOT NULL,
  `status_id` int NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`team_id`),
  KEY `status_id` (`status_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `team_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_eval`
--

DROP TABLE IF EXISTS `team_eval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_eval` (
  `team_eval_id` int NOT NULL AUTO_INCREMENT,
  `criteria_id` int NOT NULL,
  `submit_id` int NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`team_eval_id`),
  KEY `criteria_id` (`criteria_id`),
  KEY `submit_id` (`submit_id`),
  CONSTRAINT `team_eval_ibfk_1` FOREIGN KEY (`criteria_id`) REFERENCES `eval_criteria` (`criteria_id`),
  CONSTRAINT `team_eval_ibfk_2` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_eval`
--

LOCK TABLES `team_eval` WRITE;
/*!40000 ALTER TABLE `team_eval` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_eval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_member`
--

DROP TABLE IF EXISTS `team_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_member` (
  `team_id` int NOT NULL,
  `user_id` int NOT NULL,
  `is_leader` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  KEY `team_id` (`team_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `team_member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `team_member_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_member`
--

LOCK TABLES `team_member` WRITE;
/*!40000 ALTER TABLE `team_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracking`
--

DROP TABLE IF EXISTS `tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracking` (
  `tracking_id` int NOT NULL AUTO_INCREMENT,
  `milestone_id` int NOT NULL,
  `issue_id` int NOT NULL,
  `author_id` int NOT NULL,
  `assignee_id` int NOT NULL,
  `submit_id` int NOT NULL,
  `change_log` varchar(1000) NOT NULL,
  PRIMARY KEY (`tracking_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `issue_id` (`issue_id`),
  KEY `author_id` (`author_id`),
  KEY `assignee_id` (`assignee_id`),
  KEY `submit_id` (`submit_id`),
  CONSTRAINT `tracking_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `tracking_ibfk_2` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`issue_id`),
  CONSTRAINT `tracking_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `tracking_ibfk_4` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `tracking_ibfk_5` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracking`
--

LOCK TABLES `tracking` WRITE;
/*!40000 ALTER TABLE `tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update_history`
--

DROP TABLE IF EXISTS `update_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `update_history` (
  `update_history_id` int NOT NULL AUTO_INCREMENT,
  `tracking_id` int NOT NULL,
  `milestone_id` int NOT NULL,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_title` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`update_history_id`),
  KEY `tracking_id` (`tracking_id`),
  KEY `milestone_id` (`milestone_id`),
  CONSTRAINT `update_history_ibfk_1` FOREIGN KEY (`tracking_id`) REFERENCES `tracking` (`tracking_id`),
  CONSTRAINT `update_history_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update_history`
--

LOCK TABLES `update_history` WRITE;
/*!40000 ALTER TABLE `update_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `update_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `password` varchar(500) NOT NULL,
  `avatar_url` varchar(500) NOT NULL DEFAULT 'assets/media/avatars/blank.png',
  `status_id` int NOT NULL DEFAULT '1',
  `note` varchar(500) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_active` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Nguyễn Văn Cao Kỳ','admin','nguyenvancaoky@gmail.com','12345678910','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','https://lh3.googleusercontent.com/a-/ACNPEu-_iMEWblgEPqPD5pVUWJ4AUSwTYWtq3jUm_Ae_ng=s96-c',1,'Project Manager','2022-09-19 15:37:50','2022-09-19 15:37:50','2022-09-19 15:37:50'),(3,'Nguyễn Văn C','nguyenvanc','nguyenvanc@gmail.com','0862229529','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-1.jpg',1,NULL,'2022-09-23 08:03:01','2022-09-23 08:03:01','2022-09-23 08:03:01'),(19,'Nguyễn Văn B','student','student@gmail.com','0334351838','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-2.jpg',0,NULL,'2022-09-23 15:02:48','2022-09-23 15:02:48','2022-09-23 15:02:48'),(21,'Nguyễn Văn D','nguyenvand','nguyenvand@gmail.com','0327404366','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-3.jpg',1,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(22,'Nguyễn Văn E','nguyenvane','nguyenvane@gmail.com','0973067834','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-4.jpg',0,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(23,'Nguyễn Văn F','nguyenvanf','nguyenvanf@gmail.com','0865174588','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-5.jpg',1,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(24,'Nguyễn Văn G','nguyenvang','nguyenvang@gmail.com','0347166479','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-6.jpg',1,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(25,'Nguyễn Văn H','nguyenvanh','nguyenvanh@gmail.com','0335085366','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-7.jpg',0,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(27,'Nguyễn Văn J','nguyenvanj','nguyenvanj@gmail.com','0334459268','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-8.jpg',1,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(29,'Nguyễn Văn L','nguyenvanl','nguyenvanl@gmail.com','0329150477','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-9.jpg',1,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(32,'Nguyễn Văn O','nguyenvano','nguyenvano@gmail.com','0354377709','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/150-10.jpg',0,NULL,'2022-09-23 08:02:48','2022-09-23 08:02:48','2022-09-23 08:02:48'),(52,'Nguyễn Văn Cao Kỳ','nguyenvancaokylop9d219182','nguyenvancaokylop9d@gmail.com','0392522679','jASEmNcGgZ9CKzTI8kOl+0n9btRI/zoGI6l36l2vat4=','https://lh3.googleusercontent.com/a-/ACNPEu9q2T3gl19_aTrOHklFQ1cwHfliIOnJ99logazufA=s96-c',1,NULL,'2022-09-27 14:16:30','2022-09-27 14:16:30','2022-09-27 14:16:30'),(53,'Wallpapers HDV','wallpapershdv826954','wallpapershdv@gmail.com','0866099914','mhKTOXW78eKzPaJWVs+LTw3hELFJJgF8Q/OmhxWUSXE=','https://lh3.googleusercontent.com/a-/ACNPEu9sXUC6hwcYpbP1Js19bKXbN1ZuaqSnQgsJSvxT=s96-c',0,NULL,'2022-09-28 13:27:44','2022-09-28 13:27:44','2022-09-28 13:27:44'),(54,'NGUYEN VAN CAO KY','nguyenvancaoky1256840','nguyenvancaoky1@gmail.com','0346675188','YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=','assets/media/avatars/blank.png',1,NULL,'2022-09-29 05:09:10','2022-09-29 05:09:10','2022-09-29 05:09:10'),(55,'Nguyễn Văn Cao Kỳ','kynvche163260710017','kynvche163260@fpt.edu.vn','0353431768','XK6KYbSlBuRelGKqPNhdqPsi4TxJVO8QUzukoqQY3uI=','https://lh3.googleusercontent.com/a-/ACNPEu-yC8LXnUX3LssR9pvgl_Qr1pvxOYkaxvOv0cus5Q=s96-c',1,NULL,'2022-09-29 06:09:17','2022-09-29 06:09:17','2022-09-29 06:09:17'),(56,'NVCK2002','anivns.com11323','anivns.com@gmail.com','0355984689','1aNrIobFpOrAYFZ8e7Eu3K/H46MA1GlRc2cThB28TUU=','https://lh3.googleusercontent.com/a-/ACNPEu8f3JVq3J-3MMHL_OBiafCOFVzX4YWfEBx63D572g=s96-c',1,NULL,'2022-09-29 07:19:27','2022-09-29 07:19:27','2022-09-29 07:19:27'),(57,'Lai The Dat (K16_HL)','datlthe161533539845','datlthe161533@fpt.edu.vn','0989999898','hzdd9lBgKW4RREwqpc0hVYVU5njSaQYT9GrPtjeIDm8=','https://cdn140.picsart.com/334733793098211.png',1,'ひろし','2022-10-03 06:13:08','2022-10-03 06:13:08','2022-10-03 06:13:08');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `setting_id` int NOT NULL,
  UNIQUE KEY `user_id` (`user_id`,`setting_id`),
  KEY `setting_id` (`setting_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,21),(57,22),(3,23),(29,23),(22,24),(21,25),(27,25),(19,26),(25,26),(32,26),(52,26),(53,26),(54,26),(55,26),(56,26);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_contact`
--

DROP TABLE IF EXISTS `web_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_contact` (
  `category_id` int NOT NULL,
  `supporter_id` int NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `response` varchar(2000) NOT NULL,
  KEY `supporter_id` (`supporter_id`),
  CONSTRAINT `web_contact_ibfk_1` FOREIGN KEY (`supporter_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_contact`
--

LOCK TABLES `web_contact` WRITE;
/*!40000 ALTER TABLE `web_contact` DISABLE KEYS */;
INSERT INTO `web_contact` VALUES (1,2,'Kate Wolfe','katewolfe@gmail.com','0123456789','I cant imagine how the class will go, can you give me a brief introduction?','You can call or send email to us to hava more information.'),(2,23,'Janie Hardy','janiehardy@gmail.com','0123456789','Hello im Superman fight with me?','I dont know what you mean.'),(3,24,'Garry Warner','garrywarner@gmail.com','0123456789','Are there any foreign teachers to teach?','Not response'),(4,27,'Juanita Lowe','juanitalowe@gmail.com','0382861579','Can you introduce me some courses?','You should Study LAB211 with Tuan Sensei'),(5,21,'Devin Walker','devinwalker@gmail.com','0364433307','Im not very computer savvy, can I learn it?','Of course! We will help you'),(6,27,'Maggie Hart','maggiehart@gmail.com','0342311090','What do I need to prepare for this online class?','Not response'),(7,21,'Emma Blair','emmablair@gmail.com','0869135639','Are you allowed to speak up while studying?','You will contact with your supporter'),(8,27,'Anita Riley','anitariley@gmail.com','0353594774','If Im busy and cant attend an online class, can I retake it?','You can !'),(10,21,'Sidney Vargas','sidneyvargas@gmail.com','0366908179','I want to register, how do I do that?','Click to the link from home page'),(9,27,'Bryan Sullivan','bryansullivan@gmail.com','0385717227','Can I contact to the teacher of the course','Not response'),(1,21,'Dat Lai','datlai@gmail.com','0344828986','I think the course price is a bit expensive, can it be reduced?','No, we calculated the price of the course very carefully');
/*!40000 ALTER TABLE `web_contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-03 14:12:51
