-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2022 at 03:41 PM
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
  `body` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_code`, `subject_name`, `manager_id`, `expert_id`, `status_id`, `body`) VALUES
(1, '1', 'subject1 update1', 2, 3, 1, '                                While it may not be obvious to everyone, there are a number of reasons creating random paragraphs can be useful. A few examples of how some people use this generator are listed in the following paragraphs.\r\n                            '),
(2, '2', 'subject2', 2, 3, 1, 'A random paragraph can also be an excellent way for a writer to tackle writers\' block. Writing block can often happen due to being stuck with a current project that the writer is trying to complete. By inserting a completely random paragraph from which to begin, it can take down some of the issues that may have been causing the writers\' block in the first place.'),
(3, '3', 'subject3', 3, 2, 1, 'Another productive way to use this tool to begin a daily writing routine. One way is to generate a random paragraph with the intention to try to rewrite it while still keeping the original meaning. The purpose here is to just get the writing started so that when the writer goes onto their day\'s writing projects, words are already flowing from their fingers.'),
(4, '4', 'subject4', 3, 2, 1, 'Another writing challenge can be to take the individual sentences in the random paragraph and incorporate a single sentence from that into a new paragraph to create a short story. Unlike the random sentence generator, the sentences from the random paragraph will have some connection to one another so it will be a bit different. You also won\'t know exactly how many sentences will appear in the random paragraph.'),
(5, '5', 'subject5', 2, 3, 1, 'It\'s not only writers who can benefit from this free online tool. If you\'re a programmer who\'s working on a project where blocks of text are needed, this tool can be a great way to get that. It\'s a good way to test your programming and that the tool being created is working well.'),
(6, '6', 'subject6', 3, 2, 1, 'Above are a few examples of how the random paragraph generator can be beneficial. The best way to see if this random paragraph picker will be useful for your intended purposes is to give it a try. Generate a number of paragraphs to see if they are beneficial to your current project.'),
(7, '7', 'subject7', 2, 3, 0, 'Yes. We\'re always interested in improving this generator and one of the best ways to do that is to add new and interesting paragraphs to the generator. If you\'d like to contribute some random paragraphs, please contact us.'),
(8, '8', 'subject8', 3, 3, 1, 'There are usually about 200 words in a paragraph, but this can vary widely. Most paragraphs focus on a single idea that\'s expressed with an introductory sentence, then followed by two or more supporting sentences about the idea.'),
(9, '9', 'subject 9', 3, 3, 1, '                    day la subject thu 9 nhe!!!                        \r\n                                        '),
(10, '10', 'subject 10', 2, 2, 1, '                     It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English.                       \r\n                                        ');

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
(26, 'Nguyễn Văn I', 'nguyenvani', 'nguyenvani@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(27, 'Nguyễn Văn J', 'nguyenvanj', 'nguyenvanj@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(28, 'Nguyễn Văn K', 'nguyenvank', 'nguyenvank@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(29, 'Nguyễn Văn L', 'nguyenvanl', 'nguyenvanl@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(30, 'Nguyễn Văn M', 'nguyenvanm', 'nguyenvanm@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(31, 'Nguyễn Văn N', 'nguyenvann', 'nguyenvann@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(32, 'Nguyễn Văn O', 'nguyenvano', 'nguyenvano@gmail.com', NULL, 'YVnt/W+9W3sONJCTAXruKSod26IgYyIJfNSLTFb7UGE=', 'assets/media/avatars/blank.png', 1, NULL, '2022-09-23 08:02:48', '2022-09-23 08:02:48', '2022-09-23 08:02:48'),
(49, 'Nguyễn Văn Cao Kỳ', 'kynvche163260602102', 'kynvche163260@fpt.edu.vn', NULL, 'sxTBT5hdJOyf3GNb92zikebGumFjjVib2syMydx3tq0=', 'https://lh3.googleusercontent.com/a-/ACNPEu-yC8LXnUX3LssR9pvgl_Qr1pvxOYkaxvOv0cus5Q=s96-c', 1, NULL, '2022-09-24 09:34:56', '2022-09-24 09:34:56', '2022-09-24 09:34:56'),
(50, 'DESTINY', 'nguyenvancaoky2020270366', 'nguyenvancaoky2020@gmail.com', NULL, 'CLFgamRFvyY4ow5WhdZhe5Bir5HkHNC3Ocp97iaNupY=', 'https://lh3.googleusercontent.com/a-/ACNPEu-_iMEWblgEPqPD5pVUWJ4AUSwTYWtq3jUm_Ae_ng=s96-c', 1, NULL, '2022-09-25 05:40:55', '2022-09-25 05:40:55', '2022-09-25 05:40:55'),
(51, 'NVCK2002', 'anivns.com642912', 'anivns.com@gmail.com', '1233412312', 'iHMLiufq1SVvg33pAS2krZYrftzjiVqKsnKlmvTSj4s=', 'https://lh3.googleusercontent.com/a-/ACNPEu8f3JVq3J-3MMHL_OBiafCOFVzX4YWfEBx63D572g=s96-c', 1, NULL, '2022-09-25 14:26:51', '2022-09-25 14:26:51', '2022-09-25 14:26:51'),
(52, 'Nguyễn Văn Cao Kỳ', 'nguyenvancaokylop9d219182', 'nguyenvancaokylop9d@gmail.com', NULL, 'jASEmNcGgZ9CKzTI8kOl+0n9btRI/zoGI6l36l2vat4=', 'https://lh3.googleusercontent.com/a-/ACNPEu9q2T3gl19_aTrOHklFQ1cwHfliIOnJ99logazufA=s96-c', 1, NULL, '2022-09-27 14:16:30', '2022-09-27 14:16:30', '2022-09-27 14:16:30'),
(53, 'Wallpapers HDV', 'wallpapershdv826954', 'wallpapershdv@gmail.com', NULL, 'mhKTOXW78eKzPaJWVs+LTw3hELFJJgF8Q/OmhxWUSXE=', 'https://lh3.googleusercontent.com/a-/ACNPEu9sXUC6hwcYpbP1Js19bKXbN1ZuaqSnQgsJSvxT=s96-c', 1, NULL, '2022-09-28 13:27:44', '2022-09-28 13:27:44', '2022-09-28 13:27:44');

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
(49, 26),
(50, 26),
(51, 26),
(52, 26),
(53, 26);

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
-- Indexes for table `reset_password_token`
--
ALTER TABLE `reset_password_token`
  ADD UNIQUE KEY `user_id` (`user_id`);

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
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

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
