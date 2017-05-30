-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 18, 2017 at 07:20 PM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dummyapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int(11) NOT NULL,
  `client_name` varchar(50) NOT NULL,
  `location` varchar(20) DEFAULT NULL,
  `IP_address` varchar(255) DEFAULT NULL,
  `display_type` varchar(255) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `client_name`, `location`, `IP_address`, `display_type`, `server_id`) VALUES
(1, 'anuj', 'Kathmandu', '192.32.23.12', 'kathmandu', 1),
(4, 'hello', 'Pokhara', '192.32.23.122', 'kathmandu', 1),
(5, 'hello', 'Dharan', '192.32.23.121', 'kathmandu', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contents`
--

CREATE TABLE IF NOT EXISTS `contents` (
  `content_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `content_type` varchar(100) NOT NULL,
  `content_location` varchar(100) NOT NULL,
  `valid_date` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contents`
--

INSERT INTO `contents` (`content_id`, `title`, `description`, `content_type`, `content_location`, `valid_date`) VALUES
(1, 'DummyAPI', 'Great things takes time', '', 'content1', '2017-01-03 07:17:16'),
(2, 'DummyClient', 'Clients are always dumb', '', 'content2', '2017-01-03 00:00:00'),
(3, 'Student', 'Hello', '', 'content3', '2017-01-03 00:00:00'),
(4, 'Html ', 'New HTML content', 'html', 'Hello world!! this is fun.', '2017-05-24 00:00:00'),
(5, 'ContentUpdate', 'Child content updates', 'html', 'This is great', '2017-05-23 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `content_update_status`
--

CREATE TABLE IF NOT EXISTS `content_update_status` (
  `status_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `content_id` int(11) NOT NULL,
  `valid_date` datetime NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `content_update_status`
--

INSERT INTO `content_update_status` (`status_id`, `client_id`, `content_id`, `valid_date`, `status`) VALUES
(1, 1, 3, '2017-01-03 07:14:14', 0),
(2, 4, 2, '2017-01-02 06:16:16', 0),
(3, 5, 1, '2017-01-10 05:12:12', 0),
(4, 4, 3, '2017-03-23 00:00:00', 0),
(5, 4, 4, '2017-05-24 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `servers`
--

CREATE TABLE IF NOT EXISTS `servers` (
  `server_id` int(11) NOT NULL,
  `server_name` varchar(255) NOT NULL,
  `IP` varchar(20) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `servers`
--

INSERT INTO `servers` (`server_id`, `server_name`, `IP`, `location`) VALUES
(1, 'ktm_server', '129.12.12.34', 'Kathmandu'),
(2, 'pkh_server', '122.32.1.23', 'Pokhara');

-- --------------------------------------------------------

--
-- Table structure for table `user_content_status`
--

CREATE TABLE IF NOT EXISTS `user_content_status` (
  `content_status_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `last_content_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_content_status`
--

INSERT INTO `user_content_status` (`content_status_id`, `user_id`, `last_content_id`, `status`) VALUES
(1, 1, 0, 0),
(2, 4, 1, 1),
(3, 5, 3, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_id`),
  ADD KEY `server_id` (`server_id`);

--
-- Indexes for table `contents`
--
ALTER TABLE `contents`
  ADD PRIMARY KEY (`content_id`);

--
-- Indexes for table `content_update_status`
--
ALTER TABLE `content_update_status`
  ADD PRIMARY KEY (`status_id`),
  ADD KEY `user_id` (`client_id`),
  ADD KEY `content_id` (`content_id`);

--
-- Indexes for table `servers`
--
ALTER TABLE `servers`
  ADD PRIMARY KEY (`server_id`);

--
-- Indexes for table `user_content_status`
--
ALTER TABLE `user_content_status`
  ADD PRIMARY KEY (`content_status_id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `contents`
--
ALTER TABLE `contents`
  MODIFY `content_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `content_update_status`
--
ALTER TABLE `content_update_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `servers`
--
ALTER TABLE `servers`
  MODIFY `server_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_content_status`
--
ALTER TABLE `user_content_status`
  MODIFY `content_status_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`server_id`) REFERENCES `servers` (`server_id`);

--
-- Constraints for table `content_update_status`
--
ALTER TABLE `content_update_status`
  ADD CONSTRAINT `content_update_status_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  ADD CONSTRAINT `content_update_status_ibfk_2` FOREIGN KEY (`content_id`) REFERENCES `contents` (`content_id`);

--
-- Constraints for table `user_content_status`
--
ALTER TABLE `user_content_status`
  ADD CONSTRAINT `user_content_status_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `clients` (`client_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
