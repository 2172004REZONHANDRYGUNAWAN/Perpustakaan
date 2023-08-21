-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 21, 2023 at 04:34 AM
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
('', '', '', '', NULL),
('a', 'a', 'a', '/librarymanagement/target/classes/com/example/librarymanagement/GAMBARonlinebusinessbook.jpg', '2023-08-17'),
('a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-09'),
('Cook Book', 'DEDE', 'Tutorial', 'src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-01');

-- --------------------------------------------------------

--
-- Table structure for table `save`
--

CREATE TABLE `save` (
  `studentNumber` varchar(100) NOT NULL,
  `bookTitle` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `bookType` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `save`
--

INSERT INTO `save` (`studentNumber`, `bookTitle`, `author`, `bookType`, `image`, `date`) VALUES
('2172004', 'Cook Book', 'DEDE', 'Tutorial', 'src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-01');

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
('2172004', 'Admin123', '/Users/rezonhandryg/Documents/librarymanagement/src/main/resources/com/example/librarymanagement/GAMBAR/Ultraman (1).jpg'),
('2172007', 'sisca', 'src/main/resources/com/example/librarymanagement/GAMBAR/pentolbiru.png');

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
('2172004', 're', 'zon', 'Male', 'a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-15', 'Returned'),
('2172004', 'ad', 'ipar', 'Female', 'Cook Book', 'DEDE', 'Tutorial', 'src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-15', 'Returned'),
('2172004', 'aa', 'ss', 'Male', 'a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-16', 'Returned'),
('2172004', 'ertyuio', 'ghjkl', 'Male', 'Cook Book', 'DEDE', 'Tutorial', 'src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-21', 'Returned'),
('2172004', 'r', 'h', 'Male', 'a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-21', 'Returned'),
('2172007', 'tyui', 'dftyui', 'Female', 'a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-21', 'Returned'),
('2172007', 'tyui', 'dftyui', 'Female', 'a', 'a', 'a', 'src/main/resources/com/example/librarymanagement/GAMBAR/onlinebusinessbook.jpg', '2023-08-21', 'Returned'),
('2172007', 'tyui', 'dftyui', 'Female', 'Cook Book', 'DEDE', 'Tutorial', 'src/main/resources/com/example/librarymanagement/GAMBAR/cookbook.jpg', '2023-08-21', 'Returned');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
