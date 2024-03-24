-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Mar 2024 pada 12.58
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_rekam_medis`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id` int(50) NOT NULL,
  `nama_admin` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`id`, `nama_admin`, `username`, `password`) VALUES
(1, 'Admin Medis', 'adminmedis', 'adminmedis');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_dokter`
--

CREATE TABLE `tb_data_dokter` (
  `ID_Dokter` int(20) NOT NULL,
  `Nama_Dokter` varchar(30) NOT NULL,
  `Jenis_Kelamin` varchar(20) NOT NULL,
  `Tanggal_lahir` varchar(20) NOT NULL,
  `Praktik_Spesialis` varchar(25) NOT NULL,
  `Alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_dokter`
--

INSERT INTO `tb_data_dokter` (`ID_Dokter`, `Nama_Dokter`, `Jenis_Kelamin`, `Tanggal_lahir`, `Praktik_Spesialis`, `Alamat`) VALUES
(55000001, 'Nurcahyadi', 'Laki-laki', '09 Mei 1999', 'Spesialis THT', 'Kota Bekasi'),
(55000002, 'Ari Santoso', 'Laki-laki', '10 Juni 1998', 'Spesialis Psikiater', 'Cakung Jakarta '),
(55000003, 'Bagas', 'Laki-laki', '10 Juni 1999', 'Spesialis Psikiater', 'Karawang'),
(55000004, 'Silmi', 'Perempuan', '10 April 2000', 'Spesialis Kandungan', 'Kota Bekasi'),
(55000005, 'Riski', 'Laki-laki', '10 April 1997', 'Spesialis THT', 'Jakarta Timur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_obat`
--

CREATE TABLE `tb_data_obat` (
  `ID_Obat` int(20) NOT NULL,
  `Nama_Obat` varchar(100) NOT NULL,
  `Jenis_Obat` varchar(50) NOT NULL,
  `Harga` int(60) NOT NULL,
  `Stok` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_obat`
--

INSERT INTO `tb_data_obat` (`ID_Obat`, `Nama_Obat`, `Jenis_Obat`, `Harga`, `Stok`) VALUES
(33000001, 'Sanmol', 'Tablet', 10000, '300'),
(33000002, 'Paracetamol', 'Tablet', 30000, '280'),
(33000003, 'Panadol', 'Tablet', 12000, '200'),
(33000004, 'Promag', 'Tablet', 12000, '200'),
(33000005, 'Ultraflu', 'Tablet', 12000, '150'),
(33000006, 'Konidin', 'Tablet', 10000, '300');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_pasien`
--

CREATE TABLE `tb_data_pasien` (
  `ID_Pasien` int(20) NOT NULL,
  `Nama_Pasien` varchar(30) NOT NULL,
  `Jenis_kelamin` varchar(20) NOT NULL,
  `Usia` varchar(10) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `Keluhan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_pasien`
--

INSERT INTO `tb_data_pasien` (`ID_Pasien`, `Nama_Pasien`, `Jenis_kelamin`, `Usia`, `Alamat`, `Keluhan`) VALUES
(11000001, 'Adji Muhamad Zidan', 'Laki-laki', '23 Tahun', 'Jatirahayu, Kota Bekasi', 'Tenggorokan tidak enak'),
(11000002, 'Reyhan', 'Laki-laki', '22 Tahun', 'Jatiasih, Kota Bekasi', 'Panas dingin dan batuk'),
(11000003, 'Ariyanto', 'Laki-laki', '25 Tahun', 'Jakarta Timur', 'Pegal Pegal'),
(11000004, 'Hussein', 'Laki-laki', '22 Tahun', 'Parung Panjang', 'Kurang pendengaran'),
(11000005, 'Latifah', 'Perempuan', '24 Tahun', 'Depok', 'Meriang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_rekam_medis`
--

CREATE TABLE `tb_data_rekam_medis` (
  `ID_Medis` int(20) NOT NULL,
  `Tanggal_Periksa` varchar(50) NOT NULL,
  `ID_Pasien` int(20) NOT NULL,
  `Diagnosa` varchar(50) NOT NULL,
  `ID_Dokter` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_rekam_medis`
--

INSERT INTO `tb_data_rekam_medis` (`ID_Medis`, `Tanggal_Periksa`, `ID_Pasien`, `Diagnosa`, `ID_Dokter`) VALUES
(66000001, '11 Mar 2024', 11000001, 'Radang Tenggorokan', 55000001),
(66000003, '12 Mar 2024', 11000002, 'Masuk Angin', 55000004),
(66000004, '12 Mar 2024', 11000003, 'Kecapean', 55000004),
(66000005, '14 Mar 2024', 11000004, 'Telinga Kotor', 55000005),
(66000006, '24 Mar 2024', 11000005, 'Demam Flu', 55000002);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_data_dokter`
--
ALTER TABLE `tb_data_dokter`
  ADD PRIMARY KEY (`ID_Dokter`);

--
-- Indeks untuk tabel `tb_data_obat`
--
ALTER TABLE `tb_data_obat`
  ADD PRIMARY KEY (`ID_Obat`);

--
-- Indeks untuk tabel `tb_data_pasien`
--
ALTER TABLE `tb_data_pasien`
  ADD PRIMARY KEY (`ID_Pasien`);

--
-- Indeks untuk tabel `tb_data_rekam_medis`
--
ALTER TABLE `tb_data_rekam_medis`
  ADD PRIMARY KEY (`ID_Medis`),
  ADD KEY `ID_Pasien` (`ID_Pasien`,`ID_Dokter`),
  ADD KEY `ID_Dokter` (`ID_Dokter`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_data_rekam_medis`
--
ALTER TABLE `tb_data_rekam_medis`
  ADD CONSTRAINT `tb_data_rekam_medis_ibfk_1` FOREIGN KEY (`ID_Pasien`) REFERENCES `tb_data_pasien` (`ID_Pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_data_rekam_medis_ibfk_2` FOREIGN KEY (`ID_Dokter`) REFERENCES `tb_data_dokter` (`ID_Dokter`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
