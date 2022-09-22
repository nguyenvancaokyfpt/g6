-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2022 at 04:18 AM
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
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_code` varchar(255) NOT NULL,
  `combo_id` int(11) NOT NULL,
  `trainer_id` int(11) NOT NULL,
  `term_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 21, 1, 1, 1, 1),
(2, 22, 1, 1, 1, 1),
(2, 23, 1, 1, 1, 1),
(2, 24, 1, 1, 1, 1),
(2, 25, 1, 1, 1, 1),
(2, 26, 1, 1, 1, 1),
(3, 21, 1, 1, 1, 1),
(3, 22, 1, 1, 1, 1),
(3, 23, 1, 1, 1, 1),
(3, 24, 1, 1, 1, 1);

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
(1, 'User Management', '/user'),
(2, 'User Profile', '/profile'),
(3, 'Dashboard', '/dashboard');

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
(21, 1, 'ADMIN', NULL, NULL, 1, NULL),
(22, 1, 'MANAGER', NULL, NULL, 1, NULL),
(23, 1, 'EXPERT', NULL, NULL, 1, NULL),
(24, 1, 'TRAINER', NULL, NULL, 1, NULL),
(25, 1, 'SUPPORTER', NULL, NULL, 1, NULL),
(26, 1, 'STUDENT', NULL, NULL, 1, NULL);

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
  `subject_code` int(11) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `expert_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `body` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subject_setting`
--

CREATE TABLE `subject_setting` (
  `setting_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `setting_title` varchar(255) NOT NULL,
  `setting_value` varchar(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
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

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `password` varchar(500) NOT NULL,
  `avatar_url` varchar(500) NOT NULL,
  `status_id` int(11) NOT NULL,
  `note` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_active` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `full_name`, `username`, `email`, `mobile`, `password`, `avatar_url`, `status_id`, `note`, `created_at`, `updated_at`, `last_active`) VALUES
(2, 'Nguyễn Văn Cao Kỳ', 'admin', 'nguyenvancaoky@gmail.com', '123456789', '123456', '/upload/avatar.png', 1, '1', '2022-09-19 15:37:50', '2022-09-19 15:37:50', '2022-09-19 15:37:50'),
(3, 'test', 'test', 'test@mail.com', '123456789', '123456', '/upload/avatar.png', 1, 'a', '2022-09-19 15:37:50', '2022-09-19 15:37:50', '2022-09-19 15:37:50');

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
(2, 21);

-- --------------------------------------------------------

--
-- Table structure for table `web_contact`
--

CREATE TABLE `web_contact` (
  `category_id` int(11) NOT NULL,
  `supporter_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `response` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

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
-- Indexes for table `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`lesson_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `module_id` (`module_id`);

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
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `class_id` (`class_id`);

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
  ADD KEY `supporter_id` (`supporter_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class_lesson`
--
ALTER TABLE `class_lesson`
  MODIFY `class_lesson_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class_setting`
--
ALTER TABLE `class_setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lesson`
--
ALTER TABLE `lesson`
  MODIFY `lesson_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `package_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `screen`
--
ALTER TABLE `screen`
  MODIFY `screen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `setting`
--
ALTER TABLE `setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject_setting`
--
ALTER TABLE `subject_setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`);

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
  ADD CONSTRAINT `class_setting_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`);

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
-- Constraints for table `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `lesson_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

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
