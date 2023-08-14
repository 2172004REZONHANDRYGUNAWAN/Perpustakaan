-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 14, 2023 at 05:16 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mdata`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookTitle` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `bookType` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookTitle`, `author`, `bookType`, `image`, `date`) VALUES
('cook book', 'dimas', 'tutorial', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-01'),
('book of night', 'yadi', 'Novel', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/bookofnight.jpg', '2023-07-04'),
('build a great business book', 'ucup', 'tutorial', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/buildagreat businessbook.jpg', '2023-08-06'),
('buy build book', 'ucook', 'tutorial', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/buybuildbook.jpg', '2023-07-11'),
('how to succed book', 'Nanda', 'tutorial', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/howtosuccedbook.jpg', '2023-06-05'),
('', '', '', '', NULL),
('a', 'a', 'a', '/librarymanagement/target/classes/com/example/librarymanagement/GAMBARonlinebusinessbook.jpg', '2023-08-17'),
('a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-09');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentNumber` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentNumber`, `password`, `image`) VALUES
('2172004', 'Admin123', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/Ultraman (1).jpg');

-- --------------------------------------------------------

--
-- Table structure for table `take`
--

CREATE TABLE `take` (
  `studentNumber` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `bookTitle` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `bookType` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL,
  `checkReturn` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `take`
--

INSERT INTO `take` (`studentNumber`, `firstName`, `lastName`, `gender`, `bookTitle`, `author`, `bookType`, `image`, `date`, `checkReturn`) VALUES
('2172004', 'rezon', 'HAN', 'Male', 'Label', '', '', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/Ultraman (1).jpg', '2023-08-09', 'Not Return'),
('2172004', 'vivi', 'vivi', 'Female', 'cook book', '', '', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-09', 'Not Return'),
('2172004', 'doni', 'salmanan', 'Male', 'buy build book', '', '', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/buybuildbook.jpg', '2023-08-09', 'Not Return'),
('2172004', 'dani', 'supratna', 'Male', 'cook book', '', '', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-09', 'Not Return'),
('2172004', 'dido', 'dadi', 'Male', 'book of night', 'yadi', 'Novel', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/bookofnight.jpg', '2023-08-09', 'Not Return');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
