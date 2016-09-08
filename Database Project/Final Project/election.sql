-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2014 at 05:26 AM
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
  `name` varchar(200) NOT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidateinfo`
--

INSERT INTO `candidateinfo` (`cid`, `name`, `dob`, `address`) VALUES
('C1', 'Candidate 1', '7/25/94', 'Dhaka'),
('C2', 'Candidate 2', '8/25/95', 'Khulna');

-- --------------------------------------------------------

--
-- Table structure for table `celectionreg`
--

CREATE TABLE IF NOT EXISTS `celectionreg` (
  `eid` varchar(200) NOT NULL,
  `postid` varchar(200) NOT NULL,
  `cid` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `celectionreg`
--

INSERT INTO `celectionreg` (`eid`, `postid`, `cid`) VALUES
('E2014', 'President', 'C1'),
('E2015', 'President', 'C1'),
('E2014', 'President', 'C2');

-- --------------------------------------------------------

--
-- Table structure for table `postinfo`
--

CREATE TABLE IF NOT EXISTS `postinfo` (
  `eid` varchar(200) NOT NULL,
  `postid` varchar(200) NOT NULL,
  `noofpost` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `postinfo`
--

INSERT INTO `postinfo` (`eid`, `postid`, `noofpost`) VALUES
('E2014', 'President', '1'),
('E2015', 'President', '1');

-- --------------------------------------------------------

--
-- Table structure for table `velectionreg`
--

CREATE TABLE IF NOT EXISTS `velectionreg` (
  `vid` varchar(200) NOT NULL DEFAULT '',
  `eid` varchar(200) NOT NULL DEFAULT '',
  `status` varchar(200) DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `velectionreg`
--

INSERT INTO `velectionreg` (`vid`, `eid`, `status`) VALUES
('V1', 'E2014', 'YES'),
('V1', 'E2015', 'YES'),
('V2', 'E2014', 'YES'),
('V3', 'E2014', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `votecast`
--

CREATE TABLE IF NOT EXISTS `votecast` (
  `vid` varchar(200) NOT NULL,
  `eid` varchar(200) NOT NULL,
  `postid` varchar(200) NOT NULL,
  `cid` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `votecast`
--

INSERT INTO `votecast` (`vid`, `eid`, `postid`, `cid`) VALUES
('V1', 'E2014', 'President', 'C1'),
('V2', 'E2014', 'President', 'C2'),
('V3', 'E2014', 'President', 'C1'),
('V1', 'E2015', 'President', 'C1');

-- --------------------------------------------------------

--
-- Table structure for table `voterinfo`
--

CREATE TABLE IF NOT EXISTS `voterinfo` (
  `vid` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `dob` varchar(200) DEFAULT NULL,
  `pass` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `voterinfo`
--

INSERT INTO `voterinfo` (`vid`, `name`, `dob`, `pass`) VALUES
('V1', 'Voter 1', '2/1/90', 'voter1'),
('V2', 'Voter 2', '1/2/91', 'voter2'),
('V3', 'Voter 3', '2/3/93', 'voter3');

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
 ADD PRIMARY KEY (`eid`,`postid`);

--
-- Indexes for table `velectionreg`
--
ALTER TABLE `velectionreg`
 ADD PRIMARY KEY (`vid`,`eid`), ADD KEY `eid` (`eid`);

--
-- Indexes for table `votecast`
--
ALTER TABLE `votecast`
 ADD PRIMARY KEY (`vid`,`eid`,`postid`,`cid`), ADD KEY `eid` (`eid`), ADD KEY `cid` (`cid`);

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
ADD CONSTRAINT `celectionreg_ibfk_1` FOREIGN KEY (`eid`, `postid`) REFERENCES `postinfo` (`eid`, `postid`),
ADD CONSTRAINT `celectionreg_ibfk_3` FOREIGN KEY (`eid`) REFERENCES `postinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `celectionreg_ibfk_4` FOREIGN KEY (`cid`) REFERENCES `candidateinfo` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `velectionreg`
--
ALTER TABLE `velectionreg`
ADD CONSTRAINT `velectionreg_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `postinfo` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `velectionreg_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `voterinfo` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `votecast`
--
ALTER TABLE `votecast`
ADD CONSTRAINT `votecast_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `celectionreg` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `votecast_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `celectionreg` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `votecast_ibfk_3` FOREIGN KEY (`vid`) REFERENCES `velectionreg` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
