-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2021 at 12:14 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petprotectors`
--

-- --------------------------------------------------------

--
-- Table structure for table `prijavanestanka`
--

CREATE TABLE `prijavanestanka` (
  `id` int(10) NOT NULL,
  `ulicaGrad` varchar(50) DEFAULT NULL,
  `zivotinjaid` int(11) DEFAULT NULL,
  `datumPrijave` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `kontakt` varchar(50) DEFAULT NULL,
  `sifraoglasa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prijavanestanka`
--

INSERT INTO `prijavanestanka` (`id`, `ulicaGrad`, `zivotinjaid`, `datumPrijave`, `kontakt`, `sifraoglasa`) VALUES
(22, 'Novi Beograd', 11, '2021-04-20 21:42:14', 'Jasna 064', 'aki'),
(23, 'Vracar', 13, '2021-04-20 21:59:49', 'Jasna 063', 'eli'),
(24, 'Voždovac', 14, '2021-04-20 22:02:39', 'Jasna 062', 'maki'),
(25, 'Žarkovo', 15, '2021-04-20 22:10:43', 'Jasna 061', 'senica'),
(26, 'Kalemegdan', 16, '2021-04-20 22:13:28', 'Jasna 060', 'bodo');

-- --------------------------------------------------------

--
-- Table structure for table `vrstazivotinje`
--

CREATE TABLE `vrstazivotinje` (
  `id` int(20) NOT NULL,
  `naziv` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vrstazivotinje`
--

INSERT INTO `vrstazivotinje` (`id`, `naziv`) VALUES
(1, 'Pas'),
(2, 'Macka'),
(3, 'Papagaj'),
(4, 'Ostalo'),
(5, 'Ptica');

-- --------------------------------------------------------

--
-- Table structure for table `zivotinje`
--

CREATE TABLE `zivotinje` (
  `id` int(11) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `pol` varchar(1) DEFAULT NULL,
  `bojaDlake` varchar(50) DEFAULT NULL,
  `vrstaDlake` varchar(50) DEFAULT NULL,
  `brojCipa` varchar(50) DEFAULT NULL,
  `sterilisana` varchar(2) DEFAULT NULL,
  `posebnaObelezja` varchar(200) DEFAULT NULL,
  `slika` varchar(100) DEFAULT NULL,
  `rasa` varchar(50) DEFAULT NULL,
  `vrsta` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `zivotinje`
--

INSERT INTO `zivotinje` (`id`, `ime`, `pol`, `bojaDlake`, `vrstaDlake`, `brojCipa`, `sterilisana`, `posebnaObelezja`, `slika`, `rasa`, `vrsta`, `status`) VALUES
(11, 'Ares', 'M', 'zuto-bela', 'duga', '2111', 'Da', 'Plava ogrlica', 'MAres1.jpg', 'Akita', 1, 'NESTALA'),
(13, 'Eli', 'Z', 'Bela sa sivim', 'kratka', '1111', 'Da', 'plave oči', 'ZEli2.jpg', 'Sijamska', 2, 'NESTALA'),
(14, 'Maki', 'M', 'Crven', 'Perje', '', 'Ne', '', 'MMaki3.jpg', 'Makao', 3, 'NESTALA'),
(15, 'Čupa', 'Z', 'žuto plava', 'perje', '', 'Ne', '', 'ZČupa5.jpg', 'Senica', 5, 'NESTALA'),
(16, 'Bodo', 'M', 'crn', 'kratka', '222', 'Da', 'Sledi nagrada!', 'MBodo1.jpg', 'Francuski buldog', 1, 'NESTALA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `prijavanestanka`
--
ALTER TABLE `prijavanestanka`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vrstazivotinje`
--
ALTER TABLE `vrstazivotinje`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zivotinje`
--
ALTER TABLE `zivotinje`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prijavanestanka`
--
ALTER TABLE `prijavanestanka`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `vrstazivotinje`
--
ALTER TABLE `vrstazivotinje`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `zivotinje`
--
ALTER TABLE `zivotinje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
