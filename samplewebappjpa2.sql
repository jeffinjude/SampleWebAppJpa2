--
-- Database: `samplewebappjpa2`
--
CREATE DATABASE IF NOT EXISTS samplewebappjpa2;
USE samplewebappjpa2;
-- --------------------------------------------------------

--
-- Table structure for table `tbl_address`
--

DROP TABLE IF EXISTS `tbl_address`;
CREATE TABLE IF NOT EXISTS `tbl_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(100) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_address`
--

INSERT INTO `tbl_address` (`address_id`, `address_name`) VALUES
(1, 'address1'),
(2, 'address2'),
(3, 'address3'),
(4, 'address4');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_party`
--

DROP TABLE IF EXISTS `tbl_party`;
CREATE TABLE IF NOT EXISTS `tbl_party` (
  `party_id` int(11) NOT NULL AUTO_INCREMENT,
  `party_name` varchar(100) DEFAULT NULL,
  `policy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`party_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_party`
--

INSERT INTO `tbl_party` (`party_id`, `party_name`, `policy_id`) VALUES
(1, 'PartyOne', 1),
(2, 'PartyTwo', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_policy`
--

DROP TABLE IF EXISTS `tbl_policy`;
CREATE TABLE IF NOT EXISTS `tbl_policy` (
  `policy_id` int(11) NOT NULL AUTO_INCREMENT,
  `policy_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`policy_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_policy`
--

INSERT INTO `tbl_policy` (`policy_id`, `policy_name`) VALUES
(1, 'PolicyOne');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_policy_vehicle`
--

DROP TABLE IF EXISTS `tbl_policy_vehicle`;
CREATE TABLE IF NOT EXISTS `tbl_policy_vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policy_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_policy_vehicle`
--

INSERT INTO `tbl_policy_vehicle` (`id`, `policy_id`, `vehicle_id`) VALUES
(1, 1, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vehicle`
--

DROP TABLE IF EXISTS `tbl_vehicle`;
CREATE TABLE IF NOT EXISTS `tbl_vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_vehicle`
--

INSERT INTO `tbl_vehicle` (`vehicle_id`, `vehicle_name`) VALUES
(1, 'VehicleOne'),
(2, 'VehicleTwo');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vehicle_address`
--

DROP TABLE IF EXISTS `tbl_vehicle_address`;
CREATE TABLE IF NOT EXISTS `tbl_vehicle_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_vehicle_address`
--

INSERT INTO `tbl_vehicle_address` (`id`, `vehicle_id`, `address_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4);
