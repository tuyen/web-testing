-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2015 at 08:19 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlhs`
--
CREATE DATABASE IF NOT EXISTS `qlhs` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `qlhs`;

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE IF NOT EXISTS `diem` (
  `mahs` int(11) NOT NULL,
  `malop` int(11) NOT NULL,
  `toan` int(11) DEFAULT NULL,
  `tiengviet` int(11) DEFAULT NULL,
  `taplamvan` int(11) DEFAULT NULL,
  `theduc` int(11) DEFAULT NULL,
  `tapve` int(11) DEFAULT NULL,
  `tapdoc` int(11) DEFAULT NULL,
  `taphat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

CREATE TABLE IF NOT EXISTS `hocsinh` (
  `mahs` int(11) NOT NULL,
  `hoten` text,
  `ngaysinh` text,
  `gioitinh` text,
  `dantoc` text,
  `tongiao` text,
  `diachi` text,
  `sdt` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE IF NOT EXISTS `lop` (
  `malop` int(11) NOT NULL,
  `tenlop` text,
  `giaovien` text,
  `namhoc` int(11) DEFAULT NULL,
  `siso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`mahs`,`malop`),
  ADD KEY `fk_diem2` (`malop`);

--
-- Indexes for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`mahs`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`malop`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hocsinh`
--
ALTER TABLE `hocsinh`
  MODIFY `mahs` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lop`
--
ALTER TABLE `lop`
  MODIFY `malop` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `fk_diem` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`mahs`),
  ADD CONSTRAINT `fk_diem2` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
