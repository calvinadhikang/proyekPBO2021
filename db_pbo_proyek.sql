-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2021 at 02:44 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pbo_proyek`
--

-- --------------------------------------------------------

--
-- Table structure for table `dtrans`
--

CREATE TABLE `dtrans` (
  `nomorNota` varchar(16) NOT NULL,
  `id_menu` int(10) NOT NULL,
  `qty` int(10) NOT NULL,
  `harga` int(10) NOT NULL,
  `subtotal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtrans`
--

INSERT INTO `dtrans` (`nomorNota`, `id_menu`, `qty`, `harga`, `subtotal`) VALUES
('NOTA211120210001', 5, 2, 5000, 10000),
('NOTA211120210001', 4, 2, 20000, 40000);

-- --------------------------------------------------------

--
-- Table structure for table `htrans`
--

CREATE TABLE `htrans` (
  `nomorNota` varchar(16) NOT NULL,
  `tanggalTrans` date NOT NULL,
  `jamTrans` time(6) NOT NULL,
  `metodePembayaran` varchar(50) NOT NULL,
  `total` int(10) NOT NULL,
  `id_karyawan` int(10) NOT NULL,
  `status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `htrans`
--

INSERT INTO `htrans` (`nomorNota`, `tanggalTrans`, `jamTrans`, `metodePembayaran`, `total`, `id_karyawan`, `status`) VALUES
('NOTA211120210001', '2021-11-21', '16:36:27.000000', 'Tunai', 50000, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `status` int(10) NOT NULL,
  `jabatan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `username`, `password`, `nama`, `status`, `jabatan`) VALUES
(1, 'karyawan1', 'karyawan1', 'Michael', 1, 1),
(2, 'karyawan2', 'karyawan2', 'Rico', 1, 1),
(3, 'karyawan3', 'karyawan3', 'Jonathan', 0, 1),
(4, 'manager1', 'manager1', 'Novan', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_menu`, `nama`, `harga`, `kategori`, `status`) VALUES
(1, 'Nasi Goreng', 10000, 'Makanan', 1),
(2, 'Mie Goreng', 12000, 'Makanan', 1),
(3, 'Mie Goreng Cabai Hijau', 12000, 'Makanan', 0),
(4, 'Udang Goreng Tepung', 20000, 'Makanan', 1),
(5, 'Es Teh Manis', 5000, 'Minuman', 1),
(6, 'Ayam Goreng', 18000, 'Makanan', 1),
(7, 'Teh Tawar', 4000, 'Minuman', 1),
(8, 'Lumpia', 5000, 'Snack', 1),
(9, 'Pastel', 5000, 'Snack', 1),
(10, 'Pangsit', 6000, 'Snack', 1),
(11, 'Es Jeruk', 4000, 'Minuman', 1),
(12, 'Milkshake Strawberry', 9000, 'Minuman', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD KEY `FK_MENU` (`id_menu`),
  ADD KEY `FK_HTRANS` (`nomorNota`);

--
-- Indexes for table `htrans`
--
ALTER TABLE `htrans`
  ADD PRIMARY KEY (`nomorNota`),
  ADD KEY `FK_KARYAWAN` (`id_karyawan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD CONSTRAINT `FK_HTRANS` FOREIGN KEY (`nomorNota`) REFERENCES `htrans` (`nomorNota`),
  ADD CONSTRAINT `FK_MENU` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`);

--
-- Constraints for table `htrans`
--
ALTER TABLE `htrans`
  ADD CONSTRAINT `FK_KARYAWAN` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
