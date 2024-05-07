-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2024 at 06:10 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `judul` varchar(30) NOT NULL,
  `alur` double NOT NULL,
  `penokohan` double NOT NULL,
  `akting` double NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES
('aku', 5, 5, 5, 5),
('dc dedi korbuser', 5, 5, 5, 5),
('dc kangkung', 3, 3, 1, 2.3333333333333335),
('dc musik', 2, 3, 1, 2),
('DS', 4, 4, 3, 3.6666666666666665),
('geger', 45, 23, 65, 44.333333333333336),
('haha', 23, 3, 3, 9.666666666666666),
('jujutsu kaisen', 43, 54, 67, 34),
('manto', 43, 34, 54, 43.666666666666664),
('musik', 4, 5, 3, 4),
('musik 2', 4, 2, 3, 3),
('sdf', 3, 3, 3, 3),
('tes tes', 1, 2, 4, 2.3333333333333335);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD UNIQUE KEY `judul` (`judul`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
