-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2022 at 05:06 PM
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
  `is_ongoing` int(11) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Table structure for table `eval_criteria`
--

CREATE TABLE `eval_criteria` (
  `criteria_id` int(11) NOT NULL,
  `ass_id` int(11) NOT NULL,
  `milestone_id` int(11) NOT NULL,
  `criteria_name` varchar(255) NOT NULL,
  `is_team_eval` tinyint(1) NOT NULL,
  `eval_weight` int(11) NOT NULL,
  `max_loc` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(3, 26, 1, 1, 1, 1),
(4, 21, 1, 1, 1, 1),
(5, 21, 1, 1, 1, 1),
(6, 21, 1, 1, 1, 1),
(7, 21, 1, 1, 1, 1),
(10, 21, 1, 1, 1, 1),
(11, 21, 1, 1, 1, 1);

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
  `to_time` time NOT NULL
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
(4, 'Setting', '/settingList'),
(5, 'Setting Detail', '/settingDetail'),
(6, 'User Details', '/management/userdetails'),
(7, 'Web Contact List', '/webcontact/webcontactlist'),
(10, 'Subject List', '/subject/list'),
(11, 'Subject Details', '/subject/details');

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
  `setting_value` varchar(255) NOT NULL,
  `display_order` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 'Nguyễn Văn Cao Kỳ', 'admin', 'nguyenvancaoky@gmail.com', '12345678910', 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'https://lh3.googleusercontent.com/a-/ACNPEu-_iMEWblgEPqPD5pVUWJ4AUSwTYWtq3jUm_Ae_ng=s96-c', 1, '1', '2022-09-19 15:37:50', '2022-09-19 15:37:50', '2022-09-19 15:37:50'),
(3, 'Nguyễn Văn C', 'nguyenvanc', 'nguyenvanc@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:03:01', '2022-09-23 08:03:01', '2022-09-23 08:03:01'),
(19, 'Nguyễn Văn B', 'student', 'student@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 15:02:48', '2022-09-23 15:02:48', '2022-09-23 15:02:48'),
(21, 'Nguyễn Văn D', 'nguyenvand', 'nguyenvand@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(22, 'Nguyễn Văn E', 'nguyenvane', 'nguyenvane@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(23, 'Nguyễn Văn F', 'nguyenvanf', 'nguyenvanf@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(24, 'Nguyễn Văn G', 'nguyenvang', 'nguyenvang@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(25, 'Nguyễn Văn H', 'nguyenvanh', 'nguyenvanh@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(27, 'Nguyễn Văn J', 'nguyenvanj', 'nguyenvanj@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(29, 'Nguyễn Văn L', 'nguyenvanl', 'nguyenvanl@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(32, 'Nguyễn Văn O', 'nguyenvano', 'nguyenvano@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(52, 'Nguyễn Văn Cao Kỳ', 'nguyenvancaokylop9d219182', 'nguyenvancaokylop9d@gmail.com', NULL, 'jASEmNcGgZ9CKzTI8kOl+0n9btRI/zoGI6l36l2vat4=', 'https://lh3.googleusercontent.com/a-/ACNPEu9q2T3gl19_aTrOHklFQ1cwHfliIOnJ99logazufA=s96-c', 1, NULL, '2022-09-27 14:16:30', '2022-09-27 14:16:30', '2022-09-27 14:16:30'),
(53, 'Wallpapers HDV', 'wallpapershdv826954', 'wallpapershdv@gmail.com', NULL, 'mhKTOXW78eKzPaJWVs+LTw3hELFJJgF8Q/OmhxWUSXE=', 'https://lh3.googleusercontent.com/a-/ACNPEu9sXUC6hwcYpbP1Js19bKXbN1ZuaqSnQgsJSvxT=s96-c', 1, NULL, '2022-09-28 13:27:44', '2022-09-28 13:27:44', '2022-09-28 13:27:44'),
(54, 'NGUYEN VAN CAO KY', 'nguyenvancaoky1256840', 'nguyenvancaoky1@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-29 05:09:10', '2022-09-29 05:09:10', '2022-09-29 05:09:10'),
(55, 'Nguyễn Văn Cao Kỳ', 'kynvche163260710017', 'kynvche163260@fpt.edu.vn', NULL, 'XK6KYbSlBuRelGKqPNhdqPsi4TxJVO8QUzukoqQY3uI=', 'https://lh3.googleusercontent.com/a-/ACNPEu-yC8LXnUX3LssR9pvgl_Qr1pvxOYkaxvOv0cus5Q=s96-c', 1, NULL, '2022-09-29 06:09:17', '2022-09-29 06:09:17', '2022-09-29 06:09:17'),
(56, 'NVCK2002', 'anivns.com11323', 'anivns.com@gmail.com', NULL, '1aNrIobFpOrAYFZ8e7Eu3K/H46MA1GlRc2cThB28TUU=', 'https://lh3.googleusercontent.com/a-/ACNPEu8f3JVq3J-3MMHL_OBiafCOFVzX4YWfEBx63D572g=s96-c', 1, NULL, '2022-09-29 07:19:27', '2022-09-29 07:19:27', '2022-09-29 07:19:27');

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
(3, 23),
(19, 26),
(21, 26),
(22, 24),
(25, 26),
(27, 25),
(29, 23),
(32, 26),
(52, 26),
(53, 26),
(54, 26),
(55, 26),
(56, 26);

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
-- Dumping data for table `web_contact`
--

INSERT INTO `web_contact` (`category_id`, `supporter_id`, `full_name`, `email`, `mobile`, `message`, `response`) VALUES
(1, 2, 'Test1', 'test1@gmail.com', '0123456789', 'Plz help me', 'Go to my Home'),
(2, 23, 'Test2', 'test2@gmai.com', '0123456789', 'Hello im Superman', 'Woowwwww'),
(3, 24, 'Test3', 'test3@gmail.com', '0123456789', 'Hihihihi', 'not response');

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
  ADD KEY `supporter_id` (`supporter_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `ass_id` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `eval_criteria`
--
ALTER TABLE `eval_criteria`
  MODIFY `criteria_id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `milestone_id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `screen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `setting`
--
ALTER TABLE `setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `subject_setting`
--
ALTER TABLE `subject_setting`
  MODIFY `setting_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `submit`
--
ALTER TABLE `submit`
  MODIFY `submit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

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
