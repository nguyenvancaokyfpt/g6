-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2022 at 10:14 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `training_support_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `ass_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `ass_body` varchar(5000) NOT NULL,
  `eval_weight` int(11) NOT NULL,
  `is_team_work` tinyint(1) NOT NULL,
  `is_ongoing` tinyint(1) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`ass_id`, `subject_id`, `title`, `ass_body`, `eval_weight`, `is_team_work`, `is_ongoing`, `status_id`) VALUES
(1, 10, 'Documents & Iter1 Reports', 'Team to prepare & submit back below documents following attached templates:\n\n1. Updated SRS where the Records of change, Overview (part I), and Functional Requirements for the iter1 are filled.\n2. Updated SDs document  where the Records of change, Overview (part I) are filled\n3. Project Tracking: updated information in the sheets Project & Iter1\n4. Issue Report: with all the tasks/issues for the iter1 are filled, mapped to the Functions/Screens', 20, 0, 1, 1),
(2, 1, 'Practical Exam', 'All students must do the exam with mark > 0 to pass the subject.', 30, 0, 0, 1),
(3, 2, 'Final Exam', 'All students must do the exam with mark > 4, then total > 5 to pass the subject.', 40, 0, 0, 1),
(4, 8, 'Computer Project', 'Team will do project by teacher\'s require, work about data, probability and statistic', 15, 1, 1, 1),
(5, 9, 'Progress test 1', 'Test about knowledge that students learned in study progress, jsp, servlet, ...', 5, 0, 1, 1),
(6, 10, 'Documents & Iter 2 Reports', 'Team will make plan for iteration 2, assign duties for each member in team. Team will code and submit, review in class.', 20, 1, 1, 1),
(7, 9, 'Progress test 2', 'Test about knowledge that students learned in study progress, jsp, servlet, and JDBC, CRUD data with database ...', 5, 0, 1, 1),
(8, 9, 'Assignment', 'Student will choose one project topic to do assignment, and review the final project in week 9 of term.', 40, 0, 1, 1),
(9, 8, '	Final Exam', 'All students must do the exam with mark > 4, then total > 5 to pass the subject.', 35, 0, 0, 1),
(10, 4, 'Assignment', 'Student will do a small project by C, teacher will send request about it for students.', 10, 0, 1, 1),
(11, 7, '	Final Exam', 'Student must do the theory exam, mark > 4 and total > 5 to pass this subject.', 30, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `class_id` int(11) NOT NULL,
  `trainer_id` int(11) NOT NULL,
  `schedule_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `comment` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_code` varchar(255) NOT NULL,
  `combo_id` int(11) DEFAULT NULL,
  `trainer_id` int(11) NOT NULL,
  `term_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_code`, `combo_id`, `trainer_id`, `term_id`, `status_id`, `description`) VALUES
(1, 'SE1627', 3, 23, 41, 0, 'SWP'),
(2, 'SE1628', 3, 23, 41, 1, 'SWP'),
(3, 'SE1629', 3, 23, 41, 1, 'SWP'),
(4, 'SE1630', 3, 23, 41, 1, 'SWP'),
(5, 'SE1631', 3, 23, 41, 1, 'SWP'),
(6, 'SE1632', 3, 23, 41, 1, 'SWP'),
(7, 'SE1633', 3, 23, 41, 1, 'SWP'),
(8, 'SE1634', 3, 23, 41, 1, 'SWP'),
(9, 'SE1635', 3, 23, 41, 1, 'SWP'),
(10, 'SE1636', 3, 23, 41, 1, 'SWP'),
(11, 'SE1637', 3, 23, 41, 1, 'SWP');

-- --------------------------------------------------------

--
-- Table structure for table `class_lesson`
--

CREATE TABLE `class_lesson` (
  `class_lesson_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `slot_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `class_setting`
--

CREATE TABLE `class_setting` (
  `setting_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `class_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class_setting`
--

INSERT INTO `class_setting` (`setting_id`, `type_id`, `setting_title`, `setting_value`, `display_order`, `class_id`, `status_id`, `description`) VALUES
(2, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 1, 1, 'Video intro for class'),
(3, 32, 'Student can vote', 'true', 'DESC', 1, 1, 'Student can vote comment'),
(5, 32, 'Student can comment', 'false', 'DESC', 1, 1, 'Studen can commentss'),
(6, 31, 'Need to take attendance', 'true', 'ASC', 1, 0, 'Stduent need to attend'),
(7, 31, '% Minimum attendance', '80', 'ASC', 1, 1, '% Minimum attendance'),
(8, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 2, 1, 'Video intro for class'),
(9, 32, 'Student can vote', 'true', 'DESC', 2, 1, 'Student can vote comment'),
(10, 32, 'Student can comment', 'true', 'DESC', 2, 1, 'Studen can commentss'),
(11, 31, 'Need to take attendance', 'true', 'ASC', 2, 1, 'Stduent need to attend'),
(12, 31, '% Minimum attendance', '80', 'ASC', 2, 1, '% Minimum attendance'),
(13, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 3, 1, 'Video intro for class'),
(14, 32, 'Student can vote', 'true', 'DESC', 3, 1, 'Student can vote comment'),
(15, 32, 'Student can comment', 'true', 'DESC', 3, 1, 'Studen can commentss'),
(16, 31, 'Need to take attendance', 'true', 'ASC', 3, 1, 'Stduent need to attend'),
(17, 31, '% Minimum attendance', '80', 'ASC', 3, 1, '% Minimum attendance'),
(18, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 4, 1, 'Video intro for class'),
(19, 32, 'Student can vote', 'true', 'DESC', 4, 1, 'Student can vote comment'),
(20, 32, 'Student can comment', 'true', 'DESC', 4, 1, 'Studen can commentss'),
(21, 31, 'Need to take attendance', 'true', 'ASC', 4, 1, 'Stduent need to attend'),
(22, 31, '% Minimum attendance', '80', 'ASC', 4, 1, '% Minimum attendance'),
(23, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 5, 1, 'Video intro for class'),
(24, 32, 'Student can vote', 'true', 'DESC', 5, 1, 'Student can vote comment'),
(25, 32, 'Student can comment', 'true', 'DESC', 5, 1, 'Studen can commentss'),
(26, 31, 'Need to take attendance', 'true', 'ASC', 5, 1, 'Stduent need to attend'),
(27, 31, '% Minimum attendance', '80', 'ASC', 5, 1, '% Minimum attendance'),
(28, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 6, 1, 'Video intro for class'),
(29, 32, 'Student can vote', 'true', 'DESC', 6, 1, 'Student can vote comment'),
(30, 32, 'Student can comment', 'true', 'DESC', 6, 1, 'Studen can commentss'),
(31, 31, 'Need to take attendance', 'true', 'ASC', 6, 1, 'Stduent need to attend'),
(32, 31, '% Minimum attendance', '80', 'ASC', 6, 1, '% Minimum attendance'),
(33, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 7, 1, 'Video intro for class'),
(34, 32, 'Student can vote', 'true', 'DESC', 7, 1, 'Student can vote comment'),
(35, 32, 'Student can comment', 'true', 'DESC', 7, 1, 'Studen can commentss'),
(36, 31, 'Need to take attendance', 'true', 'ASC', 7, 1, 'Stduent need to attend'),
(37, 31, '% Minimum attendance', '80', 'ASC', 7, 1, '% Minimum attendance'),
(38, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 8, 1, 'Video intro for class'),
(39, 32, 'Student can vote', 'true', 'DESC', 8, 1, 'Student can vote comment'),
(40, 32, 'Student can comment', 'true', 'DESC', 8, 1, 'Studen can commentss'),
(41, 31, 'Need to take attendance', 'true', 'ASC', 8, 1, 'Stduent need to attend'),
(42, 31, '% Minimum attendance', '80', 'ASC', 8, 1, '% Minimum attendance'),
(43, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 9, 1, 'Video intro for class'),
(44, 32, 'Student can vote', 'true', 'DESC', 9, 1, 'Student can vote comment'),
(45, 32, 'Student can comment', 'true', 'DESC', 9, 1, 'Studen can commentss'),
(46, 31, 'Need to take attendance', 'true', 'ASC', 9, 1, 'Stduent need to attend'),
(47, 31, '% Minimum attendance', '80', 'ASC', 9, 1, '% Minimum attendance'),
(48, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 10, 1, 'Video intro for class'),
(49, 32, 'Student can vote', 'true', 'DESC', 10, 1, 'Student can vote comment'),
(50, 32, 'Student can comment', 'true', 'DESC', 10, 1, 'Studen can commentss'),
(51, 31, 'Need to take attendance', 'true', 'ASC', 10, 1, 'Stduent need to attend'),
(52, 31, '% Minimum attendance', '80', 'ASC', 10, 1, '% Minimum attendance'),
(53, 33, 'Video intro', 'https://youtu.be/RgKAFK5djSk', 'ASC', 11, 1, 'Video intro for class'),
(54, 32, 'Student can vote', 'true', 'DESC', 11, 1, 'Student can vote comment'),
(55, 32, 'Student can comment', 'true', 'DESC', 11, 1, 'Studen can commentss'),
(56, 31, 'Need to take attendance', 'true', 'ASC', 11, 1, 'Stduent need to attend'),
(57, 31, '% Minimum attendance', '80', 'ASC', 11, 1, '% Minimum attendance');

-- --------------------------------------------------------

--
-- Table structure for table `class_user`
--

CREATE TABLE `class_user` (
  `class_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `is_leader` tinyint(1) NOT NULL,
  `status_id` int(11) NOT NULL,
  `note` varchar(500) NOT NULL,
  `dropout_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class_user`
--

INSERT INTO `class_user` (`class_id`, `user_id`, `team_id`, `is_leader`, `status_id`, `note`, `dropout_date`) VALUES
(1, 19, 1, 1, 1, 'a', '2022-09-09'),
(2, 19, 1, 1, 1, '1', '2022-09-09');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `mobile` int(11) NOT NULL,
  `address` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  `company` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `eval_criteria`
--

CREATE TABLE `eval_criteria` (
  `criteria_id` int(11) NOT NULL,
  `ass_id` int(11) NOT NULL,
  `milestone_id` int(11) DEFAULT NULL,
  `criteria_name` varchar(255) NOT NULL,
  `is_team_eval` tinyint(1) NOT NULL,
  `eval_weight` int(11) NOT NULL,
  `max_loc` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `eval_criteria`
--

INSERT INTO `eval_criteria` (`criteria_id`, `ass_id`, `milestone_id`, `criteria_name`, `is_team_eval`, `eval_weight`, `max_loc`, `status_id`, `description`) VALUES
(1, 1, 1, 'Writing SRS,SDS,Tracking', 0, 55, 0, 0, '- SRS where the Records of change, Overview (part I), and Functional Requirements for the iter1 are filled.\r\n-Updated SDs document  where the Records of change, Overview (part I) are filled\r\n-Project Tracking: updated information in the sheets Project & Iter1\r\n'),
(2, 1, 1, 'Coding Fucntion', 1, 40, 300, 1, '-Code and show mockup all function in iter 1.'),
(3, 5, 1, 'Lab 1', 0, 60, 100, 0, '- Correct result and clean code.'),
(4, 6, 1, 'Writing SRS,SDS,Tracking', 1, 20, 0, 0, '- SRS where the Records of change, Overview (part I), and Functional Requirements for the iter1 are filled.\n-Updated SDs document  where the Records of change, Overview (part I) are filled\n-Project Tracking: updated information in the sheets Project & Iter2'),
(5, 1, 1, 'Team Work', 1, 10, 0, 1, '- Each Person Work in with other productively'),
(6, 5, 1, 'Presentation', 1, 40, 0, 0, '-Fluent, understand the problem'),
(7, 7, 1, 'Lab 2', 0, 80, 150, 0, '- Correct result and clean code.'),
(8, 6, 1, 'Coding Fucntion', 0, 50, 450, 1, '-Code and show mockup all function in iter 2.'),
(9, 8, 1, 'Clean Code', 0, 20, 75, 1, '-Easy to understand'),
(10, 8, 1, 'Data', 1, 20, 50, 0, '-Groups of students are required to collect secondary data (topics may be suggested by instructor), form their own questions, and apply learned knowledge and methods of inferential statistics to analyze data and make conclusions about the populations.'),
(11, 6, 1, 'Present product', 1, 30, 0, 0, '-Fluent, understand the problem'),
(12, 6, 1, 'Creation of product', 0, 20, 0, 0, '-New idea to excute code'),
(13, 1, 1, 'Present product', 1, 20, 0, 1, '-Fluent, understand the problem'),
(14, 1, 1, 'test', 0, 88, 88, 1, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `issue_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `type_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `extra_labels` varchar(1000) NOT NULL,
  `description` varchar(500) NOT NULL,
  `linked_id` int(11) NOT NULL,
  `gitlab_url` varchar(500) NOT NULL,
  `is_closed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `lesson`
--

CREATE TABLE `lesson` (
  `lesson_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `video_url` varchar(500) NOT NULL,
  `file_url` varchar(500) NOT NULL,
  `body` text NOT NULL,
  `module_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `loc_eval`
--

CREATE TABLE `loc_eval` (
  `loc_eval_id` int(11) NOT NULL,
  `complexity_id` int(11) NOT NULL,
  `quality_id` int(11) NOT NULL,
  `converted_loc` int(11) NOT NULL,
  `is_late_submit` tinyint(1) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `new_milestone_id` int(11) NOT NULL,
  `new_complexity_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `member_eval`
--

CREATE TABLE `member_eval` (
  `member_eval_id` int(11) NOT NULL,
  `evaluation_id` int(11) NOT NULL,
  `criteria_id` int(11) NOT NULL,
  `total_loc` int(11) NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `milestone`
--

CREATE TABLE `milestone` (
  `milestone_id` int(11) NOT NULL,
  `ass_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `ass_body` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `milestone`
--

INSERT INTO `milestone` (`milestone_id`, `ass_id`, `class_id`, `from_date`, `to_date`, `title`, `ass_body`, `description`, `status_id`) VALUES
(1, 10, 1, '2022-09-12', '2022-09-24', '1', '1', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `milestone_eval`
--

CREATE TABLE `milestone_eval` (
  `evaluation_id` int(11) NOT NULL,
  `milestone_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `bonus` float NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL,
  `submit_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `package_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `screen_id` int(11) NOT NULL,
  `setting_id` int(11) NOT NULL,
  `can_get` tinyint(1) NOT NULL,
  `can_delete` tinyint(1) NOT NULL,
  `can_create` tinyint(1) NOT NULL,
  `can_update` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`screen_id`, `setting_id`, `can_get`, `can_delete`, `can_create`, `can_update`) VALUES
(1, 21, 1, 1, 1, 1),
(1, 22, 0, 0, 0, 0),
(1, 23, 0, 0, 0, 0),
(1, 24, 0, 0, 0, 0),
(1, 26, 0, 0, 0, 0),
(2, 21, 1, 1, 1, 1),
(2, 22, 1, 1, 1, 1),
(2, 23, 1, 1, 1, 1),
(2, 24, 1, 1, 1, 1),
(2, 25, 1, 1, 1, 1),
(2, 26, 1, 1, 1, 1),
(3, 21, 1, 1, 1, 1),
(3, 22, 1, 1, 1, 1),
(3, 23, 1, 1, 1, 1),
(3, 24, 1, 1, 1, 1),
(3, 25, 1, 1, 1, 1),
(3, 26, 1, 1, 1, 1),
(4, 21, 1, 1, 1, 1),
(4, 22, 0, 0, 0, 0),
(4, 23, 1, 1, 1, 1),
(4, 24, 0, 0, 0, 0),
(4, 26, 0, 0, 0, 0),
(5, 21, 1, 1, 1, 1),
(5, 22, 0, 0, 0, 0),
(5, 23, 0, 0, 0, 0),
(5, 24, 0, 0, 0, 0),
(5, 26, 0, 0, 0, 0),
(6, 21, 1, 1, 1, 1),
(6, 22, 0, 0, 0, 0),
(6, 23, 0, 0, 0, 0),
(6, 24, 0, 0, 0, 0),
(6, 26, 0, 0, 0, 0),
(7, 21, 1, 1, 1, 1),
(7, 22, 0, 0, 0, 0),
(7, 23, 0, 0, 0, 0),
(7, 24, 0, 0, 0, 0),
(7, 25, 1, 1, 1, 1),
(7, 26, 0, 0, 0, 0),
(10, 21, 1, 1, 1, 1),
(10, 22, 1, 1, 1, 1),
(10, 23, 0, 0, 0, 0),
(10, 24, 0, 0, 0, 0),
(10, 26, 0, 0, 0, 0),
(11, 21, 1, 1, 1, 1),
(11, 22, 1, 1, 1, 1),
(11, 23, 0, 0, 0, 0),
(11, 24, 0, 0, 0, 0),
(11, 26, 0, 0, 0, 0),
(12, 21, 1, 1, 1, 1),
(12, 22, 0, 0, 0, 0),
(12, 23, 0, 0, 0, 0),
(12, 24, 0, 0, 0, 0),
(12, 26, 0, 0, 0, 0),
(13, 21, 1, 1, 1, 1),
(13, 22, 1, 1, 1, 1),
(13, 23, 0, 0, 0, 0),
(13, 24, 0, 0, 0, 0),
(13, 26, 1, 1, 1, 1),
(14, 21, 1, 1, 1, 1),
(14, 22, 1, 1, 1, 1),
(14, 23, 0, 0, 0, 0),
(16, 21, 1, 1, 1, 1),
(16, 22, 0, 0, 0, 0),
(16, 23, 0, 0, 0, 0),
(17, 21, 1, 1, 1, 1),
(17, 22, 0, 0, 0, 0),
(17, 23, 0, 0, 0, 0),
(20, 21, 1, 1, 1, 1),
(20, 22, 1, 1, 1, 1),
(20, 23, 0, 0, 0, 0),
(20, 24, 0, 0, 0, 0),
(20, 26, 0, 0, 0, 0),
(22, 21, 1, 1, 1, 1),
(22, 22, 1, 1, 1, 1),
(22, 23, 0, 0, 0, 0),
(22, 24, 0, 0, 0, 0),
(22, 26, 0, 0, 0, 0),
(23, 21, 1, 1, 1, 1),
(24, 21, 1, 1, 1, 1),
(26, 21, 1, 1, 1, 1),
(27, 21, 1, 1, 1, 1),
(30, 21, 1, 1, 1, 1),
(31, 21, 1, 1, 1, 1),
(32, 21, 1, 1, 1, 1),
(33, 21, 1, 1, 1, 1),
(34, 21, 1, 1, 1, 1),
(35, 21, 1, 1, 1, 1),
(36, 21, 1, 1, 1, 1),
(37, 21, 1, 1, 1, 1),
(38, 21, 1, 1, 1, 1),
(39, 21, 1, 1, 1, 1),
(40, 21, 1, 1, 1, 1),
(41, 21, 1, 1, 1, 1),
(42, 21, 1, 1, 1, 1),
(43, 21, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reset_password_token`
--

CREATE TABLE `reset_password_token` (
  `user_id` int(11) NOT NULL,
  `token` varchar(500) NOT NULL,
  `salt` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reset_password_token`
--

INSERT INTO `reset_password_token` (`user_id`, `token`, `salt`, `created_at`) VALUES
(2, '59f2c6865dc5f92152d8b2b7972f31c8', 1664420351317, '2022-09-29 02:59:11');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `slot_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `training_date` date NOT NULL,
  `from_time` time NOT NULL,
  `to_time` time NOT NULL,
  `room` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `screen`
--

CREATE TABLE `screen` (
  `screen_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `screen`
--

INSERT INTO `screen` (`screen_id`, `title`, `path`) VALUES
(1, 'User Management', '/management/user'),
(2, 'User Profile', '/profile'),
(3, 'Dashboard', '/dashboard'),
(4, 'Setting System', '/setting/system'),
(5, 'Setting Detail', '/setting/system/detail'),
(6, 'User Details', '/management/user/detail'),
(7, 'Web Contact List', '/webcontact/list'),
(10, 'Subject List', '/subject/list'),
(11, 'Subject Details', '/subject/detail'),
(12, 'Setting Role Permissions', '/setting/role/permissions'),
(13, 'Setting Class', '/setting/class'),
(14, 'Setting Class Detail', '/setting/class/detail'),
(16, 'Eval Criteria List', '/evalCriteria/evalCriteriaList'),
(17, 'Eval Criteria Detail', '/evalCriteria/evalCriteriaDetails'),
(20, 'Subject Setting', '/subject/setting'),
(22, 'Assignment List', '/assignment/list'),
(23, 'Class List', '/class/list'),
(24, 'Class Detail', '/class/detail'),
(26, 'Milestone List', '/milestone/list'),
(27, 'Milestone Details', '/milestone/detail'),
(30, 'Class Eval Criteria List', '/evalCriteria/classEvalCriteria/list'),
(31, 'Class Eval Criteria Detail', '/evalCriteria/classEvalCriteria/detail'),
(32, 'Trainee List', '/management/trainee/list'),
(33, 'Trainee Detail', '/management/trainee/detail'),
(34, 'Schedule List', '/schedule/list'),
(35, 'Schedule Detail', '/schedule/detail'),
(36, 'Attendance Tracking', '/attendance/tracking'),
(37, 'Attendance Detail', '/attendance/detail'),
(38, 'Schedule Attendance', '/schedule/attendance'),
(39, 'Team List', '/team/list'),
(40, 'Team New', '/team/new'),
(41, 'Team Detail', '/team/detail'),
(42, 'Issue List', '/issue/list'),
(43, 'Issue Detail', '/issue/detail');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE `setting` (
  `setting_id` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) DEFAULT NULL,
  `display_order` varchar(255) DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`setting_id`, `type_id`, `setting_title`, `setting_value`, `display_order`, `status_id`, `description`) VALUES
(1, 0, 'User Role', NULL, NULL, 1, NULL),
(2, 0, 'Class Setting Type', '', NULL, 1, NULL),
(3, 0, 'Term', NULL, NULL, 1, 'Term'),
(21, 1, 'ADMIN', NULL, NULL, 1, NULL),
(22, 1, 'MANAGER', NULL, NULL, 1, NULL),
(23, 1, 'EXPERT', NULL, NULL, 1, NULL),
(24, 1, 'TRAINER', NULL, NULL, 1, NULL),
(25, 1, 'SUPPORTER', NULL, NULL, 1, NULL),
(26, 1, 'TRAINEE', NULL, NULL, 1, NULL),
(31, 2, 'System', NULL, NULL, 1, 'System config for Class Setting'),
(32, 2, 'Permission', NULL, NULL, 1, 'Permission config for Class Setting'),
(33, 2, 'Information', NULL, NULL, 1, 'Information config for Class Setting'),
(41, 3, 'Summer 2022', 'su2022', NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_title` varchar(255) NOT NULL,
  `status_value` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `status_title`, `status_value`) VALUES
(0, 'Inactive', 'inactive'),
(1, 'Active', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `subject_code` varchar(255) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `expert_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `body` text NOT NULL,
  `img_src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_code`, `subject_name`, `manager_id`, `expert_id`, `status_id`, `body`, `img_src`) VALUES
(1, 'PRO192', 'Object-Oriented Programming', 2, 3, 1, '                                While it may not be obvious to everyone, there are a number of reasons creating random paragraphs can be useful. A few examples of how some people use this generator are listed in the following paragraphs.\r\n\r\n                            ', 'assets/media/books/8.png'),
(2, 'MAD101', 'Discrete mathematics', 2, 3, 1, 'A random paragraph can also be an excellent way for a writer to tackle writers\' block. Writing block can often happen due to being stuck with a current project that the writer is trying to complete. By inserting a completely random paragraph from which to begin, it can take down some of the issues that may have been causing the writers\' block in the first place.', 'assets/media/books/1.png'),
(3, 'MAE101', 'Mathematics for Engineering', 3, 2, 1, 'Another productive way to use this tool to begin a daily writing routine. One way is to generate a random paragraph with the intention to try to rewrite it while still keeping the original meaning. The purpose here is to just get the writing started so that when the writer goes onto their day\'s writing projects, words are already flowing from their fingers.', 'assets/media/books/2.png'),
(4, 'PRF192', 'Programming Fundamentals', 3, 2, 1, '                                Another writing challenge can be to take the individual sentences in the random paragraph and incorporate a single sentence from that into a new paragraph to create a short story. Unlike the random sentence generator, the sentences from the random paragraph will have some connection to one another so it will be a bit different. You also won\'t know exactly how many sentences will appear in the random paragraph.\r\n                            ', 'assets/media/books/3.png'),
(5, 'CEA201', 'Computer Organization and Architecture', 2, 3, 1, 'It\'s not only writers who can benefit from this free online tool. If you\'re a programmer who\'s working on a project where blocks of text are needed, this tool can be a great way to get that. It\'s a good way to test your programming and that the tool being created is working well.', 'assets/media/books/4.png'),
(6, 'CSI104', 'Introduction to Computer Science', 3, 2, 1, 'Above are a few examples of how the random paragraph generator can be beneficial. The best way to see if this random paragraph picker will be useful for your intended purposes is to give it a try. Generate a number of paragraphs to see if they are beneficial to your current project.', 'assets/media/books/5.png'),
(7, 'CSD201', 'Data Structures and Algorithms', 2, 3, 0, 'Yes. We\'re always interested in improving this generator and one of the best ways to do that is to add new and interesting paragraphs to the generator. If you\'d like to contribute some random paragraphs, please contact us.', 'assets/media/books/6.png'),
(8, 'MAS291', 'Statistics and Probability', 3, 3, 1, 'There are usually about 200 words in a paragraph, but this can vary widely. Most paragraphs focus on a single idea that\'s expressed with an introductory sentence, then followed by two or more supporting sentences about the idea.', 'assets/media/books/7.png'),
(9, 'PRJ301', 'Java Web Application Development', 3, 3, 1, 'day la subject thu 9 nhe!!!\r\n', 'assets/media/books/9.png'),
(10, 'SWP391', 'Application development project', 2, 2, 1, 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English.\r\n', 'assets/media/books/10.png');

-- --------------------------------------------------------

--
-- Table structure for table `subject_setting`
--

CREATE TABLE `subject_setting` (
  `setting_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` int(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject_setting`
--

INSERT INTO `subject_setting` (`setting_id`, `type_id`, `setting_title`, `setting_value`, `display_order`, `status_id`, `description`, `subject_id`) VALUES
(21, 2, 'Home Page', 60, 'Simple', 1, '\"Show the static contents and include the web header & footer as in the Mockups sheet\n Allow the guest to submit the contact information in a chosen category\"', 10),
(22, 2, 'Demo Dashobard', 90, 'Normal', 1, '\"Show the sample dashboard information where the data are taken from below APIs (ref https://morioh.com/p/57a8d79967b5 for more details) the page include common Admin Header, Admin Footer, and Nav Bar as in the mockup screen\n- Covid India Data API: https://www.covid19india.org/\n- Saved calls for covid19india (Import this json in postman):    https://www.getpostman.com/collections/2afb23eddb8accf94c3e\"', 10),
(23, 2, 'User Login', 120, 'Complex', 1, '\"Fields: Email, Password, Capcha; Links: Reset Password, Register\n User can choose Google Login using the FPT @fpt.edu.vn account\"', 10),
(24, 2, 'Project Assignment', 180, 'Complex', 0, 'If you are struggling with writing a document like this, engaging with a third-party partner as Branch Strategy can help. We can help you ask the right questions of your team, determine how your project fits into your larger business goals, and get the Project Brief complete so it saves you money, allowing you to build the right website the first time.', 3),
(25, 2, 'Practical Exam', 200, 'Complex', 0, 'Do the exam on PEA Client to finish the PE of subject.', 6),
(26, 2, 'Progress Test', 60, 'Simple', 1, 'Use all knowledge that learned in week 1 - 2. Do test in EOS.', 7),
(27, 2, 'Final Exam', 200, 'Complex', 0, 'Do theory exam in EOS, this test required student gain the marks > 4 and total marks > 5 to pass this subject.', 5),
(28, 2, 'Final Exam', 200, 'Complex', 1, 'Do theory exam in EOS, this test required student gain the marks > 4 and total marks > 5 to pass this subject.', 7);

-- --------------------------------------------------------

--
-- Table structure for table `submit`
--

CREATE TABLE `submit` (
  `submit_id` int(11) NOT NULL,
  `milestone_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `submit_file_url` varchar(500) NOT NULL,
  `submit_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `team_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `project_code` varchar(255) NOT NULL,
  `topic_code` varchar(255) NOT NULL,
  `topic_name` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `class_id`, `project_code`, `topic_code`, `topic_name`, `status_id`, `description`) VALUES
(1, 1, 'SWP', 'SWP211', 'TEST', 1, 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `team_eval`
--

CREATE TABLE `team_eval` (
  `team_eval_id` int(11) NOT NULL,
  `criteria_id` int(11) NOT NULL,
  `submit_id` int(11) NOT NULL,
  `grade` float NOT NULL,
  `comment` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `team_member`
--

CREATE TABLE `team_member` (
  `team_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_leader` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tracking`
--

CREATE TABLE `tracking` (
  `tracking_id` int(11) NOT NULL,
  `milestone_id` int(11) NOT NULL,
  `issue_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `assignee_id` int(11) NOT NULL,
  `submit_id` int(11) NOT NULL,
  `change_log` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `update_history`
--

CREATE TABLE `update_history` (
  `update_history_id` int(11) NOT NULL,
  `tracking_id` int(11) NOT NULL,
  `milestone_id` int(11) NOT NULL,
  `update_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_title` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `password` varchar(500) NOT NULL,
  `avatar_url` varchar(500) NOT NULL DEFAULT 'assets/media/avatars/blank.png',
  `status_id` int(11) NOT NULL DEFAULT 1,
  `note` varchar(500) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_active` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `full_name`, `username`, `email`, `mobile`, `password`, `avatar_url`, `status_id`, `note`, `created_at`, `updated_at`, `last_active`) VALUES
(2, 'Nguyễn Văn Cao Kỳ', 'admin', 'nguyenvancaoky@gmail.com', '0964800139', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'https://lh3.googleusercontent.com/a-/ACNPEu-_iMEWblgEPqPD5pVUWJ4AUSwTYWtq3jUm_Ae_ng=s96-c', 1, '1', '2022-09-19 15:37:50', '2022-09-19 15:37:50', '2022-09-19 15:37:50'),
(3, 'Nguyễn Văn C', 'nguyenvanc', 'nguyenvanc@gmail.com', '0862229529', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:03:01', '2022-09-23 08:03:01', '2022-09-23 08:03:01'),
(19, 'Nguyễn Văn B', 'student', 'student@gmail.com', '0334351838', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 15:02:48', '2022-09-23 15:02:48', '2022-09-23 15:02:48'),
(21, 'Nguyễn Văn D', 'nguyenvand', 'nguyenvand@gmail.com', '0327404366', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(22, 'Nguyễn Văn E', 'nguyenvane', 'nguyenvane@gmail.com', '0973067834', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(23, 'Nguyễn Văn F', 'nguyenvanf', 'nguyenvanf@gmail.com', '0865174588', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(24, 'Nguyễn Văn G', 'nguyenvang', 'nguyenvang@gmail.com', '0347166479', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(25, 'Nguyễn Văn H', 'nguyenvanh', 'nguyenvanh@gmail.com', '0335085366', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(27, 'Nguyễn Văn J', 'nguyenvanj', 'nguyenvanj@gmail.com', '0334459268', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(29, 'Nguyễn Văn L', 'nguyenvanl', 'nguyenvanl@gmail.com', '0329150477', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(32, 'Nguyễn Văn O', 'nguyenvano', 'nguyenvano@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(52, 'Nguyễn Văn Cao Kỳ', 'nguyenvancaokylop9d219182', 'nguyenvancaokylop9d@gmail.com', '0392522679', 'jASEmNcGgZ9CKzTI8kOl+0n9btRI/zoGI6l36l2vat4=', 'https://lh3.googleusercontent.com/a-/ACNPEu9q2T3gl19_aTrOHklFQ1cwHfliIOnJ99logazufA=s96-c', 1, NULL, '2022-09-27 14:16:30', '2022-09-27 14:16:30', '2022-09-27 14:16:30'),
(53, 'Wallpapers HDV', 'wallpapershdv826954', 'wallpapershdv@gmail.com', '0866099914', 'mhKTOXW78eKzPaJWVs+LTw3hELFJJgF8Q/OmhxWUSXE=', 'https://lh3.googleusercontent.com/a-/ACNPEu9sXUC6hwcYpbP1Js19bKXbN1ZuaqSnQgsJSvxT=s96-c', 1, NULL, '2022-09-28 13:27:44', '2022-09-28 13:27:44', '2022-09-28 13:27:44'),
(54, 'NGUYEN VAN CAO KY', 'nguyenvancaoky1256840', 'nguyenvancaoky1@gmail.com', '0346675188', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-29 05:09:10', '2022-09-29 05:09:10', '2022-09-29 05:09:10'),
(55, 'Nguyễn Văn Cao Kỳ', 'kynvche163260710017', 'kynvche163260@fpt.edu.vn', '0353431768', 'XK6KYbSlBuRelGKqPNhdqPsi4TxJVO8QUzukoqQY3uI=', 'https://lh3.googleusercontent.com/a-/ACNPEu-yC8LXnUX3LssR9pvgl_Qr1pvxOYkaxvOv0cus5Q=s96-c', 1, NULL, '2022-09-29 06:09:17', '2022-09-29 06:09:17', '2022-09-29 06:09:17'),
(56, 'NVCK2002', 'anivns.com11323', 'anivns.com@gmail.com', '0355984689', '1aNrIobFpOrAYFZ8e7Eu3K/H46MA1GlRc2cThB28TUU=', 'https://lh3.googleusercontent.com/a-/ACNPEu8f3JVq3J-3MMHL_OBiafCOFVzX4YWfEBx63D572g=s96-c', 1, NULL, '2022-09-29 07:19:27', '2022-09-29 07:19:27', '2022-09-29 07:19:27'),
(57, 'Lai The Dat (K16_HL)', 'datlthe161533539845', 'datlthe161533@fpt.edu.vn', '0989999898', 'hzdd9lBgKW4RREwqpc0hVYVU5njSaQYT9GrPtjeIDm8=', 'https://cdn140.picsart.com/334733793098211.png', 1, 'ひろし', '2022-10-02 23:13:08', '2022-10-02 23:13:08', '2022-10-02 23:13:08');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `setting_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `setting_id`) VALUES
(2, 21),
(3, 25),
(19, 26),
(21, 26),
(22, 24),
(23, 24),
(25, 26),
(27, 25),
(29, 24),
(32, 26),
(52, 26),
(53, 26),
(54, 22),
(55, 26),
(56, 26),
(57, 22);

-- --------------------------------------------------------

--
-- Table structure for table `web_contact`
--

CREATE TABLE `web_contact` (
  `web_contact_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `supporter_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `response` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `web_contact`
--

INSERT INTO `web_contact` (`web_contact_id`, `category_id`, `supporter_id`, `full_name`, `email`, `mobile`, `message`, `response`) VALUES
(4, 1, 2, 'Kate Wolfe', 'katewolfe@gmail.com', '0123456789', 'I cant imagine how the class will go, can you give me a brief introduction?', 'You can call or send email to us to hava more information.'),
(5, 2, 23, 'Janie Hardy', 'janiehardy@gmail.com', '0123456789', 'Hello im Superman fight with me?', 'I dont know what you mean.'),
(6, 3, 24, 'Garry Warner', 'garrywarner@gmail.com', '0123456789', 'Are there any foreign teachers to teach?', 'Not response'),
(7, 4, 27, 'Juanita Lowe', 'juanitalowe@gmail.com', '0382861579', 'Can you introduce me some courses?', 'You should Study LAB211 with Tuan Sensei'),
(8, 5, 21, 'Devin Walker', 'devinwalker@gmail.com', '0364433307', 'Im not very computer savvy, can I learn it?', 'Of course! We will help you'),
(9, 6, 27, 'Maggie Hart', 'maggiehart@gmail.com', '0342311090', 'What do I need to prepare for this online class?', 'Not response'),
(10, 7, 21, 'Emma Blair', 'emmablair@gmail.com', '0869135639', 'Are you allowed to speak up while studying?', 'You will contact with your supporter'),
(11, 8, 27, 'Anita Riley', 'anitariley@gmail.com', '0353594774', 'If Im busy and cant attend an online class, can I retake it?', 'You can !'),
(12, 10, 21, 'Sidney Vargas', 'sidneyvargas@gmail.com', '0366908179', 'I want to register, how do I do that?', 'Click to the link from home page'),
(13, 9, 27, 'Bryan Sullivan', 'bryansullivan@gmail.com', '0385717227', 'Can I contact to the teacher of the course', 'Not response'),
(14, 1, 21, 'Dat Lai', 'datlai@gmail.com', '0344828986', 'I think the course price is a bit expensive, can it be reduced?', 'No, we calculated the price of the course very carefully');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`ass_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD UNIQUE KEY `class_id` (`class_id`,`trainer_id`,`schedule_id`),
  ADD KEY `class_id_2` (`class_id`),
  ADD KEY `trainer_id` (`trainer_id`),
  ADD KEY `schedule_id` (`schedule_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `combo_id` (`combo_id`),
  ADD KEY `trainer_id` (`trainer_id`),
  ADD KEY `term_id` (`term_id`);

--
-- Indexes for table `class_lesson`
--
ALTER TABLE `class_lesson`
  ADD PRIMARY KEY (`class_lesson_id`),
  ADD KEY `slot_id` (`slot_id`),
  ADD KEY `lesson_id` (`lesson_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `class_setting`
--
ALTER TABLE `class_setting`
  ADD PRIMARY KEY (`setting_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `class_user`
--
ALTER TABLE `class_user`
  ADD UNIQUE KEY `class_id` (`class_id`,`user_id`),
  ADD KEY `team_id` (`team_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `eval_criteria`
--
ALTER TABLE `eval_criteria`
  ADD PRIMARY KEY (`criteria_id`),
  ADD KEY `ass_id` (`ass_id`),
  ADD KEY `milestone_id` (`milestone_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`issue_id`),
  ADD KEY `team_id` (`team_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `linked_id` (`linked_id`);

--
-- Indexes for table `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`lesson_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `module_id` (`module_id`);

--
-- Indexes for table `loc_eval`
--
ALTER TABLE `loc_eval`
  ADD PRIMARY KEY (`loc_eval_id`);

--
-- Indexes for table `member_eval`
--
ALTER TABLE `member_eval`
  ADD PRIMARY KEY (`member_eval_id`),
  ADD KEY `evaluation_id` (`evaluation_id`),
  ADD KEY `criteria_id` (`criteria_id`);

--
-- Indexes for table `milestone`
--
ALTER TABLE `milestone`
  ADD PRIMARY KEY (`milestone_id`),
  ADD KEY `ass_id` (`ass_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `milestone_eval`
--
ALTER TABLE `milestone_eval`
  ADD PRIMARY KEY (`evaluation_id`),
  ADD KEY `milestone_id` (`milestone_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `submit_id` (`submit_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`package_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD UNIQUE KEY `screen_id` (`screen_id`,`setting_id`),
  ADD KEY `setting_id` (`setting_id`);

--
-- Indexes for table `reset_password_token`
--
ALTER TABLE `reset_password_token`
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `screen`
--
ALTER TABLE `screen`
  ADD PRIMARY KEY (`screen_id`);

--
-- Indexes for table `setting`
--
ALTER TABLE `setting`
  ADD PRIMARY KEY (`setting_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `expert_id` (`expert_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `subject_setting`
--
ALTER TABLE `subject_setting`
  ADD PRIMARY KEY (`setting_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `submit`
--
ALTER TABLE `submit`
  ADD PRIMARY KEY (`submit_id`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `team_eval`
--
ALTER TABLE `team_eval`
  ADD PRIMARY KEY (`team_eval_id`),
  ADD KEY `criteria_id` (`criteria_id`),
  ADD KEY `submit_id` (`submit_id`);

--
-- Indexes for table `team_member`
--
ALTER TABLE `team_member`
  ADD KEY `team_id` (`team_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tracking`
--
ALTER TABLE `tracking`
  ADD PRIMARY KEY (`tracking_id`),
  ADD KEY `milestone_id` (`milestone_id`),
  ADD KEY `issue_id` (`issue_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `assignee_id` (`assignee_id`),
  ADD KEY `submit_id` (`submit_id`);

--
-- Indexes for table `update_history`
--
ALTER TABLE `update_history`
  ADD PRIMARY KEY (`update_history_id`),
  ADD KEY `tracking_id` (`tracking_id`),
  ADD KEY `milestone_id` (`milestone_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD UNIQUE KEY `user_id` (`user_id`,`setting_id`),
  ADD KEY `setting_id` (`setting_id`);

--
-- Indexes for table `web_contact`
--
ALTER TABLE `web_contact`
  ADD PRIMARY KEY (`web_contact_id`),
  ADD KEY `supporter_id` (`supporter_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `ass_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `class_lesson`
--
ALTER TABLE `class_lesson`
  MODIFY `class_lesson_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class_setting`
--
ALTER TABLE `class_setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `eval_criteria`
--
ALTER TABLE `eval_criteria`
  MODIFY `criteria_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `issue`
--
ALTER TABLE `issue`
  MODIFY `issue_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lesson`
--
ALTER TABLE `lesson`
  MODIFY `lesson_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loc_eval`
--
ALTER TABLE `loc_eval`
  MODIFY `loc_eval_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `member_eval`
--
ALTER TABLE `member_eval`
  MODIFY `member_eval_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `milestone`
--
ALTER TABLE `milestone`
  MODIFY `milestone_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `milestone_eval`
--
ALTER TABLE `milestone_eval`
  MODIFY `evaluation_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `package_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `screen`
--
ALTER TABLE `screen`
  MODIFY `screen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `setting`
--
ALTER TABLE `setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `subject_setting`
--
ALTER TABLE `subject_setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `submit`
--
ALTER TABLE `submit`
  MODIFY `submit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `team_eval`
--
ALTER TABLE `team_eval`
  MODIFY `team_eval_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tracking`
--
ALTER TABLE `tracking`
  MODIFY `tracking_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `update_history`
--
ALTER TABLE `update_history`
  MODIFY `update_history_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `web_contact`
--
ALTER TABLE `web_contact`
  MODIFY `web_contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `attendance_ibfk_3` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`),
  ADD CONSTRAINT `attendance_ibfk_4` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `class_ibfk_3` FOREIGN KEY (`term_id`) REFERENCES `setting` (`setting_id`);

--
-- Constraints for table `class_lesson`
--
ALTER TABLE `class_lesson`
  ADD CONSTRAINT `class_lesson_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `class_lesson_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`lesson_id`),
  ADD CONSTRAINT `class_lesson_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `class_setting`
--
ALTER TABLE `class_setting`
  ADD CONSTRAINT `class_setting_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `class_setting_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `class_setting_ibfk_3` FOREIGN KEY (`type_id`) REFERENCES `setting` (`setting_id`);

--
-- Constraints for table `class_user`
--
ALTER TABLE `class_user`
  ADD CONSTRAINT `class_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `class_user_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `class_user_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `class_user_ibfk_4` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`);

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `eval_criteria`
--
ALTER TABLE `eval_criteria`
  ADD CONSTRAINT `eval_criteria_ibfk_1` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ass_id`),
  ADD CONSTRAINT `eval_criteria_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  ADD CONSTRAINT `eval_criteria_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `issue`
--
ALTER TABLE `issue`
  ADD CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  ADD CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `issue_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `lesson_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `member_eval`
--
ALTER TABLE `member_eval`
  ADD CONSTRAINT `member_eval_ibfk_1` FOREIGN KEY (`criteria_id`) REFERENCES `eval_criteria` (`criteria_id`),
  ADD CONSTRAINT `member_eval_ibfk_2` FOREIGN KEY (`evaluation_id`) REFERENCES `milestone_eval` (`evaluation_id`);

--
-- Constraints for table `milestone`
--
ALTER TABLE `milestone`
  ADD CONSTRAINT `milestone_ibfk_1` FOREIGN KEY (`ass_id`) REFERENCES `assignment` (`ass_id`),
  ADD CONSTRAINT `milestone_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `milestone_eval`
--
ALTER TABLE `milestone_eval`
  ADD CONSTRAINT `milestone_eval_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  ADD CONSTRAINT `milestone_eval_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `milestone_eval_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `milestone_eval_ibfk_4` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`);

--
-- Constraints for table `package`
--
ALTER TABLE `package`
  ADD CONSTRAINT `package_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`setting_id`),
  ADD CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`screen_id`) REFERENCES `screen` (`screen_id`);

--
-- Constraints for table `reset_password_token`
--
ALTER TABLE `reset_password_token`
  ADD CONSTRAINT `reset_password_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `setting`
--
ALTER TABLE `setting`
  ADD CONSTRAINT `setting_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`expert_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `subject_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `subject_setting`
--
ALTER TABLE `subject_setting`
  ADD CONSTRAINT `subject_setting_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `subject_setting_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `team_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `team_eval`
--
ALTER TABLE `team_eval`
  ADD CONSTRAINT `team_eval_ibfk_1` FOREIGN KEY (`criteria_id`) REFERENCES `eval_criteria` (`criteria_id`),
  ADD CONSTRAINT `team_eval_ibfk_2` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`);

--
-- Constraints for table `team_member`
--
ALTER TABLE `team_member`
  ADD CONSTRAINT `team_member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `team_member_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`);

--
-- Constraints for table `tracking`
--
ALTER TABLE `tracking`
  ADD CONSTRAINT `tracking_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  ADD CONSTRAINT `tracking_ibfk_2` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`issue_id`),
  ADD CONSTRAINT `tracking_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `tracking_ibfk_4` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `tracking_ibfk_5` FOREIGN KEY (`submit_id`) REFERENCES `submit` (`submit_id`);

--
-- Constraints for table `update_history`
--
ALTER TABLE `update_history`
  ADD CONSTRAINT `update_history_ibfk_1` FOREIGN KEY (`tracking_id`) REFERENCES `tracking` (`tracking_id`),
  ADD CONSTRAINT `update_history_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`setting_id`);

--
-- Constraints for table `web_contact`
--
ALTER TABLE `web_contact`
  ADD CONSTRAINT `web_contact_ibfk_1` FOREIGN KEY (`supporter_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
