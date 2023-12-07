-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2020 at 11:18 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pkk`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `kode_buku` varchar(25) NOT NULL,
  `judul_buku` varchar(25) NOT NULL,
  `tanggal_beli` date NOT NULL,
  `pengarang` varchar(25) NOT NULL,
  `penerbit` varchar(25) NOT NULL,
  `tahun_terbit` int(11) NOT NULL,
  `jumlah_buku` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kode_buku`, `judul_buku`, `tanggal_beli`, `pengarang`, `penerbit`, `tahun_terbit`, `jumlah_buku`) VALUES
('BIO', 'Ir.Soekarno', '2020-04-13', 'Soekarno ', 'Erlangga', 148, 21),
('dawd121', 'dawdad', '2020-04-10', 'dawd', 'adadw', 121, 1212),
('NLV001', 'pkii', '2020-04-01', 'adawd', 'awda', 121, 2121),
('NVL002', 'Tangga Darurat', '2020-04-14', 'WattPad', 'Reza Riefa', 2020, 11);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `kode_peminjaman` varchar(25) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `nis` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kelas` varchar(25) NOT NULL,
  `kode_buku` varchar(25) NOT NULL,
  `judul_buku` varchar(25) NOT NULL,
  `jumlah_buku` int(11) NOT NULL,
  `id_petugas` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`kode_peminjaman`, `tanggal_pinjam`, `nis`, `nama`, `kelas`, `kode_buku`, `judul_buku`, `jumlah_buku`, `id_petugas`) VALUES
('PE001', '2020-03-02', '17180557', 'Reza', 'XII RPL', 'dawd121', 'dawdad', 1212, '1'),
('PE002', '2020-03-02', '17180557', 'Reza', 'XII RPL', 'NLV001', 'pki', 2121, '1'),
('PE003', '2020-03-13', '17180552', 'Reza Chaerul fajri', 'XII RPL', 'BIO', 'Ir.Soekarno', 1, '1'),
('PE004', '2020-04-13', '17180552', 'Reza Chaerul fajri', 'XII RPL', 'NLV001', 'pki', 1, '1'),
('PE005', '2020-04-14', '171805432', 'Fajar Alvian', 'XII TKR 1', 'NVL002', 'Tangga Darurat', 2, '4'),
('PE006', '2020-04-14', '171805432', 'Fajar Alvian', 'XII TKR 1', 'NLV001', 'pkii', 2121, '4');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `kode_pengembalian` varchar(25) NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `kode_peminjaman` varchar(25) NOT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `nis` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kelas` varchar(25) NOT NULL,
  `kode_buku` varchar(25) NOT NULL,
  `nama_buku` varchar(25) NOT NULL,
  `jumlah_buku` int(11) NOT NULL,
  `keterlambatan` varchar(25) NOT NULL,
  `denda` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`kode_pengembalian`, `tanggal_pengembalian`, `kode_peminjaman`, `tanggal_pinjam`, `nis`, `nama`, `kelas`, `kode_buku`, `nama_buku`, `jumlah_buku`, `keterlambatan`, `denda`) VALUES
('PEN001', '2020-04-15', 'PE003', '2020-03-13', 17180552, 'Reza Chaerul fajri', 'XII RPL', 'BIO', 'Ir.Soekarno', 1, '1', 2000),
('PEN002', '2020-04-16', 'PE001', '2020-03-02', 17180557, 'Reza', 'XII RPL', 'dawd121', 'dawdad', 1212, '2', 4000),
('PEN003', '2020-04-17', 'PE005', '2020-04-14', 171805432, 'Fajar Alvian', 'XII TKR 1', 'NVL002', 'Tangga Darurat', 2, '1', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(25) NOT NULL,
  `nama_petugas` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `level` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `username`, `password`, `level`) VALUES
('1', 'Riefaa', 'admin', '123', 'admin'),
('2', 'dede setiabud', 'kepsek', '456', 'kepsek'),
('3', 'Rizky', 'tarmin007', 'tarmin007', 'admin'),
('4', 'ahmad', 'ahmad123', 'rplmutu', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nis` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kelas` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `kelas`) VALUES
('171805432', 'Fajar Alvian', 'XII TKR 1'),
('17180552', 'Reza Chaerul fajri', 'XII RPL'),
('17180556', 'Rizky Fahrureza', 'XII RPL'),
('17180557', 'Reza', 'XII RPL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`kode_peminjaman`),
  ADD KEY `nis` (`nis`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`kode_pengembalian`),
  ADD KEY `kode_peminjaman` (`kode_peminjaman`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode_buku`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`),
  ADD CONSTRAINT `peminjaman_ibfk_4` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`kode_peminjaman`) REFERENCES `peminjaman` (`kode_peminjaman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
