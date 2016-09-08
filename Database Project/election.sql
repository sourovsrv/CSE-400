-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2014 at 06:02 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `election`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidateinfo`
--

CREATE TABLE IF NOT EXISTS `candidateinfo` (
  `cid` varchar(200) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `celectionreg`
--

CREATE TABLE IF NOT EXISTS `celectionreg` (
  `eid` varchar(200) NOT NULL DEFAULT '',
  `postid` varchar(200) NOT NULL DEFAULT '',
  `cid` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `postinfo`
--

CREATE TABLE IF NOT EXISTS `postinfo` (
  `sno` varchar(200) NOT NULL DEFAULT '',
  `eid` varchar(200) NOT NULL DEFAULT '',
  `postid` varchar(200) NOT NULL DEFAULT '',
  `noofpost` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `velectionreg`
--

CREATE TABLE IF NOT EXISTS `velectionreg` (
  `vid` varchar(200) NOT NULL,
  `eid` varchar(200) NOT NULL DEFAULT '',
  `status` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `votecast`
--

CREATE TABLE IF NOT EXISTS `votecast` (
  `vid` varchar(200) NOT NULL,
  `eid` varchar(200) NOT NULL DEFAULT '',
  `postid` varchar(200) NOT NULL DEFAULT '',
  `cid` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voterinfo`
--

CREATE TABLE IF NOT EXISTS `voterinfo` (
  `vid` varchar(200) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidateinfo`
--
ALTER TABLE `candidateinfo`
 ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `celectionreg`
--
ALTER TABLE `celectionreg`
 ADD PRIMARY KEY (`eid`,`postid`,`cid`), ADD KEY `cid` (`cid`);

--
-- Indexes for table `postinfo`
--
ALTER TABLE `postinfo`
 ADD PRIMARY KEY (`sno`,`eid`,`postid`);

--
-- Indexes for table `velectionreg`
--
ALTER TABLE `velectionreg`
 ADD PRIMARY KEY (`vid`,`eid`);

--
-- Indexes for table `votecast`
--
ALTER TABLE `votecast`
 ADD PRIMARY KEY (`vid`,`eid`,`postid`,`cid`), ADD KEY `cid` (`cid`);

--
-- Indexes for table `voterinfo`
--
ALTER TABLE `voterinfo`
 ADD PRIMARY KEY (`vid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `celectionreg`
--
ALTER TABLE `celectionreg`
ADD CONSTRAINT `celectionreg_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `candidateinfo` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `velectionreg`
--
ALTER TABLE `velectionreg`
ADD CONSTRAINT `velectionreg_ibfk_1` FOREIGN KEY (`vid`) REFERENCES `voterinfo` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `votecast`
--
ALTER TABLE `votecast`
ADD CONSTRAINT `votecast_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `candidateinfo` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `votecast_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `voterinfo` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
