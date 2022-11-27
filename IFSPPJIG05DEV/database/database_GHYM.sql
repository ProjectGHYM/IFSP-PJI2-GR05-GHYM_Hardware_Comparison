drop database IF EXISTS GHYM;
create database GHYM;
use GHYM;

create table Marca(
cod_marca int NOT NULL,
nome varchar(20),
PRIMARY KEY (cod_marca)
);

insert into Marca values
(1, 'INTEL'),
(2, 'AMD'),
(3, 'NVIDIA'),
(4, 'GIGABYTE'),
(5, 'ASUS'),
(6, 'PCEYES'),
(7, 'MSI'),
(8, 'HyperX'),
(9, 'XPG'),
(10, 'GALAX'),
(11, 'AFOX'),
(12, 'Powercolor'),
(13, 'Zotac'),
(14, 'EVGA'),
(15, 'Sapphire'),
(16, 'ASRock'),
(17, 'MAXSUN'),
(18, 'Colorfire'),
(19, 'XFX'),
(20, 'Gainward'),
(21, 'Corsair'),
(22, 'Crucial'),
(23, 'ADATA'),
(24, 'TeamGroup'),
(25, 'Kingston'),
(26, 'Husky Gaming'),
(27, 'Samsung');

-- NOME DA TABELA NÃO PODE SER 'CPU', POIS É UMA PALAVRA RESERVADA
create table Processador(
cod_cpu int NOT NULL,
id_marca int NOT NULL,
nome varchar(60),
clock float,
turbo float,
cores int,
threads int,
mark int,
TDP int,
arquitetura varchar(15),
preco float,
imagem varchar(50),
PRIMARY KEY (cod_cpu),
FOREIGN KEY (id_marca) REFERENCES Marca(cod_marca)
);

insert into Processador (cod_cpu, id_marca, nome, clock, turbo, cores, threads, mark, TDP, arquitetura, preco) values
(1, 1, 'I5-2400', 3.10, 3.40, 4, 4, 3843, 35, 'LGA1155', 399.99),
(2, 2, 'Ryzen 5 5600G', 3.90, 4.20, 8, 6, 19821, 65, 'AM4', 1299.99),
(3, 1, 'I5-4590T', 2.00, 3.00, 4, 4, 3984, 35, 'LGA1150', 514.99),
(4, 1, 'I3-4360', 3.70, 3.70, 2, 4, 3699, 54, 'LGA1150', 249.99),
(5, 1, 'I7-4790S', 3.20, 4.00, 4, 8, 6891, 65, 'LGA1150', 879.99),
(6, 1, 'I7-4770S', 3.10, 3.90, 4, 8, 6832, 65, 'LGA1150', 679.99),
(7, 1, 'I5-8500', 3.00, 4.10, 6, 6, 8234, 65, 'LGA1151', 814.99),
(8, 1, 'I3-9100', 3.60, 4.20, 4, 4, 5465, 65, 'LGA1151', 539.99),
(9, 2, 'Ryzen 3 3200G', 3.60, 4.00, 4, 4, 3878, 65, 'AM4', 569.99),
(10, 2, 'Ryzen 5 3600', 3.60, 4.20, 6, 12, 6214, 65, 'AM4', 879.99),
(11, 1, 'I7-10700', 2.90, 4.80, 8, 16, 16886, 65, 'LGA1200', 1899.99),
(12, 1, 'I3-12300', 3.50, 4.40, 4, 8, 14955, 70, 'LGA1700', 614.99),
(13, 1, 'I5-6500', 3.20, 3.60, 4, 4, 5655, 65, 'LGA1151', 679.99),
(14, 2, 'Ryzen 7 3700X', 3.60, 4.40, 8, 16, 22731, 65, 'AM4', 879.99),
(15, 2, 'Ryzen 9 5900X', 3.70, 4.80, 12, 24, 39348, 105, 'AM4', 2899.99),
(16, 1, 'I5-3570K', 3.40, 3.80, 4, 4, 4941, 77, 'LGA1155', 234.99),
(17, 1, 'I5-7500', 3.40, 3.80, 4, 4, 6059, 65, 'LGA1151', 192.99),
(18, 1, 'I5-8500', 3.00, 4.10, 6, 6, 9589, 65, 'LGA1151', 289.99),
(19, 1, 'I5-9600K', 3.70, 4.60, 6, 6, 10772, 95, 'LGA1151', 329.99),
(20, 1, 'I5-9600', 3.10, 4.60, 6, 6, 10356, 65, 'LGA1151', 249.99),
(21, 1, 'I5-10600K', 4.10, 4.80, 6, 12, 14511, 95, 'LGA1200', 369.99),
(22, 1, 'I5-10400F', 2.90, 4.30, 6, 12, 12375, 65, 'LGA1200', 329.99),
(23, 1, 'I5-10600', 3.30, 4.80, 6, 12, 13832, 65, 'LGA1200', 289.99),
(24, 1, 'I5-11500', 2.70, 4.60, 6, 12, 17612, 65, 'LGA1200', 269.99),
(25, 1, 'I5-11600K', 3.90, 4.90, 6, 12, 19738, 95, 'LGA1200', 389.99),
(26, 1, 'I5-11400', 2.60, 4.40, 6, 12, 17069, 65, 'LGA1200', 299.99),
(27, 1, 'I5-12600K', 3.60, 4.90, 10, 16, 27691, 150, 'LGA1700', 410.99),
(28, 1, 'I5-12600', 3.30, 4.80, 6, 12, 21200, 117, 'LGA1700', 319.99),
(29, 1, 'I5-12400', 2.50, 4.40, 6, 12, 19501, 117, 'LGA1700', 310.99),
(30, 1, 'I7-6700', 3.40, 4.00, 4, 8, 8088, 65, 'LGA1151', 304.99),
(31, 1, 'I7-7700', 3.60, 4.20, 4, 8, 8652, 65, 'LGA1151', 314.99),
(32, 1, 'I7-8700', 3.20, 4.60, 6, 12, 13001, 65, 'LGA1151', 329.99),
(33, 1, 'I7-9700K', 3.60, 4.90, 8, 8, 14554, 95, 'LGA1151', 384.99),
(34, 1, 'I7-9700', 3.00, 4.70, 8, 8, 13365, 65, 'LGA1151', 334.99),
(35, 1, 'I7-10700K', 3.80, 5.10, 8, 16, 19179, 125, 'LGA1200', 414.99),
(36, 1, 'I7-10700', 2.90, 4.70, 8, 16, 16811, 65, 'LGA1200', 364.99),
(37, 1, 'I7-11700K', 3.60, 5.00, 8, 16, 24665, 95, 'LGA1200', 439.99),
(38, 1, 'I7-11700', 2.50, 4.90, 8, 16, 20096, 65, 'LGA1200', 384.99),
(39, 1, 'I7-12700K', 3.60, 5.00, 12, 20, 34633, 190, 'LGA1700', 454.99),
(40, 1, 'I9-9900K', 3.60, 5.00, 8, 16, 18632, 95, 'LGA1151', 499.99),
(41, 1, 'I9-9900', 3.10, 5.00, 8, 16, 16798, 65, 'LGA1151', 449.99),
(42, 1, 'I9-10900K', 3.70, 5.30, 10, 20, 23567, 125, 'LGA1200', 544.99),
(43, 1, 'I9-10900', 2.80, 5.20, 10, 20, 20283, 65, 'LGA1200', 484.99),
(44, 1, 'I9-11900', 2.50, 5.20, 8, 16, 22994, 65, 'LGA1200', 499.99),
(45, 1, 'I9-11900K', 3.50, 5.30, 8, 16, 25523, 125, 'LGA1200', 579.99),
(46, 1, 'I9-12900K', 3.20, 5.20, 16, 24, 41475, 241, 'LGA1700', 659.99),
(47, 1, 'I9-12900', 2.40, 5.10, 16, 24, 36241, 202, 'LGA1700', 569.99),
(48, 1, 'I9-10850K', 3.60, 5.20, 10, 20, 22885, 125, 'LGA1200', 509.99),
(49, 1, 'I9-12900KS', 3.40, 5.50, 16, 24, 44859, 241, 'LGA1700', 829.99),
(50, 1, 'I9-12900F', 2.40, 5.10, 16, 24, 37464, 202, 'LGA1700', 549.99),
(51, 1, 'Xeon E-2134', 3.50, 4.50, 4, 8, 8741, 71, 'LGA1151', 289.99),
(52, 1, 'Xeon E-2124', 3.30, 4.30, 4, 4, 6992, 71, 'LGA1151', 229.99),
(53, 1, 'Xeon E-2224', 3.40, 4.60, 4, 4, 7223, 71, 'LGA1151', 239.99),
(54, 1, 'Xeon E-2234', 3.60, 4.80, 4, 8, 9903, 71, 'LGA1151', 299.99),
(55, 1, 'Xeon E-2378', 2.60, 4.80, 8, 16, 17981, 65, 'LGA1200', 409.99),
(56, 1, 'Xeon E-2314', 2.80, 4.50, 4, 4, 8091, 65, 'LGA1200', 259.99),
(57, 1, 'Xeon E5-2620', 2.00, 2.50, 6, 12, 5288, 95, 'LGA2011', 409.99),
(58, 1, 'Xeon E5-2650', 2.00, 2.80, 8, 16, 7328, 95, 'LGA2011', 1099.99),
(59, 1, 'Xeon E5-2640', 2.50, 3.00, 6, 12, 6318, 95, 'LGA2011', 889.99),
(60, 1, 'Xeon E5-2670', 2.60, 3.30, 8, 16, 8958, 115, 'LGA2011', 1499.99),
(61, 1, 'I3-9100', 3.60, 4.20, 4, 4, 6636, 65, 'LGA1151', 419.99),
(62, 1, 'I3-6100', 3.70, 3.70, 2, 4, 4152, 51, 'LGA1151', 239.99),
(63, 1, 'I3-7100', 3.90, 3.90, 2, 4, 4341, 51, 'LGA1151', 259.99),
(64, 1, 'I3-7100T', 3.40, 3.40, 2, 4, 3766, 35, 'LGA1151', 299.99),
(65, 1, 'I3-8100', 3.60, 3.60, 4, 4, 6164, 65, 'LGA1151', 399.99),
(66, 1, 'I3-9100F', 3.60, 4.20, 4, 4, 6773, 65, 'LGA1151', 499.99),
(67, 1, 'I3-10100F', 3.60, 4.30, 4, 8, 8850, 65, 'LGA1200', 349.99),
(68, 1, 'I3-11100B', 3.60, 4.40, 4, 8, 11357, 65, 'LGA1200', 549.99),
(69, 1, 'I3-12100', 3.30, 4.30, 4, 4, 14336, 89, 'LGA1700', 659.99),
(70, 1, 'I3-12100F', 3.30, 4.30, 4, 8, 14372, 89, 'LGA1700', 599.99),
(71, 2, 'Ryzen 9 7950X', 4.50, 5.70, 16, 32, 64372, 170, 'AM5', 5499.99),
(72, 2, 'Ryzen 9 7900X', 4.70, 5.60, 12, 24, 51401, 170, 'AM5', 4199.99),
(73, 2, 'Ryzen 7 7700X', 4.50, 5.40, 8, 16, 36580, 105, 'AM5', 2999.99),
(74, 2, 'Ryzen 5 7600X', 4.70, 5.30, 6, 12, 28582, 105, 'AM5', 2199.99),
(75, 2, 'Ryzen 7 5700G', 3.80, 4.60, 8, 16, 24564, 65, 'AM4', 1579.99),
(76, 2, 'Ryzen 7 5700GE', 3.20, 4.60, 8, 16, 22484, 35, 'AM4', 1299.99),
(77, 2, 'Ryzen 5 5600G', 3.90, 4.40, 6, 12, 19837, 65, 'AM4', 1074.99),
(78, 2, 'Ryzen 5 5600GE', 3.40, 4.40, 6, 12, 18879, 35, 'AM4', 999.99),
(79, 2, 'Ryzen 5 4600G', 3.70, 4.20, 6, 12, 15585, 65, 'AM4', 689.99),
(80, 2, 'FX-9590', 4.70, 5.00, 8, 8, 6737, 220, 'AM3+', 399.99),
(81, 2, 'FX-9370', 4.40, 4.70, 8, 8, 5994, 220, 'AM3+', 389.99),
(82, 2, 'FX-8370E', 3.30, 4.30, 8, 8, 5331, 95, 'AM3+', 169.99),
(83, 2, 'FX-8370', 4.00, 4.30, 8, 8, 6146, 125, 'AM3+', 139.99),
(84, 2, 'FX-8350', 4.00, 4.20, 8, 8, 5999, 125, 'AM3+', 99.99),
(85, 2, 'FX-8320E', 3.20, 4.00, 8, 8, 5054, 95, 'AM3+', 129.99),
(86, 2, 'FX-8320', 3.50, 4.00, 8, 8, 5421, 125, 'AM3+', 49.99),
(87, 2, 'FX-8300', 3.30, 4.20, 8, 8, 5293, 95, 'AM3+', 49.99),
(88, 2, 'FX-6350', 3.90, 4.20, 6, 6, 4484, 125, 'AM3+', 59.99),
(89, 2, 'FX-6300', 3.50, 3.80, 6, 6, 4182, 95, 'AM3+', 39.99),
(90, 2, 'FX-6200', 3.80, 4.10, 6, 6, 4079, 125, 'AM3+', 219.99),
(91, 2, 'FX-6100', 3.30, 3.90, 6, 6, 3686, 95, 'AM3+', 69.99),
(92, 2, 'FX-4350', 4.20, 4.30, 4, 4, 3224, 125, 'AM3+', 89.99),
(93, 2, 'FX-4320', 4.00, 4.10, 4, 4, 3043, 95, 'AM3+', 54.99),
(94, 2, 'FX-4300', 3.80, 4.00, 4, 4, 2957, 95, 'AM3+', 39.99),
(95, 2, 'FX-4130', 3.80, 3.90, 4, 4, 2669, 125, 'AM3+', 19.99),
(96, 2, 'FX-4100', 3.60, 3.80, 4, 4, 2558, 95, 'AM3+', 19.99),
(97, 2, 'Athlon 200GE', 3.20, 3.20, 2, 4, 4109, 35, 'AM4', 124.99),
(98, 2, 'Athlon 220GE', 3.40, 3.40, 2, 4, 4424, 35, 'AM4', 129.99),
(99, 2, 'Athlon 240GE', 3.50, 3.50, 2, 4, 4551, 35, 'AM4', 169.99),
(100, 2, 'Athlon 3000G', 3.50, 3.50, 2, 4, 4483, 35, 'AM4', 89.99);

create table GPU(
cod_gpu int NOT NULL,
id_marca int NOT NULL,
nome varchar(60),
clock int,
mark int,
VRAM int,
TDP int,
preco float,
imagem varchar(50),
PRIMARY KEY (cod_gpu),
FOREIGN KEY (id_marca) REFERENCES Marca(cod_marca)
);

insert into GPU (cod_gpu, id_marca, nome, clock, mark, VRAM, TDP, preco) values
(1, 4, 'GeForce GTX 1660 OC', 1530, 11707, 6, 125, 1799.99),
(2, 6, 'Radeon RX 550', 1183, 2722, 4, 80, 899.99),
(3, 4, 'GeForce RTX 3090', 1395, 26488, 24, 350, 14699.99),
(4, 5, 'Radeon RX 6900 XT', 1900, 25708, 16, 300, 16999.99),
(5, 20, 'GeForce RTX 3060TI', 1410, 20291, 8, 2000, 4399.99),
(6, 19, 'Radeon RX 6700 XT', 2457, 18894, 12, 230, 12255.62),
(7, 7, 'Radeon RX 5700 XT', 1730, 16898, 8, 225, 12999.99),
(8, 5, 'GeForce RTX 2060', 1365, 13964, 6, 160, 5543.90),
(9, 4, 'GeForce RTX 3080 Aorus Xtreme', 1440, 25024, 10, 320, 10299.99),
(10, 10, 'GeForce GTX 1650', 1410, 7817, 4, 185, 2799.99),
(11, 6, 'Radeon RX 580', 1257, 7797, 8, 185, 1630.60),
(12, 11, 'Geforce GT 610', 810, 302, 2, 20, 229.99),
(13, 11, 'Radeon R5 220', 1066, 135, 1, 20, 259.99),
(14, 20, 'Geforce GT 710', 800, 637, 2, 25, 399.99),
(15, 7, 'Geforce GT 1030', 1250, 2539, 2, 30, 899.99),
(16, 7, 'Radeon RX 6800 XT', 1250, 2539, 2, 30, 899.99),
(17, 10, 'Titan RTX', 1770, 19897, 24, 280, 10999.99),
(18, 4, 'GeForce RTX 2080 Super', 1815, 19546, 8, 250, 2499.99),
(19, 4, 'GeForce RTX 2080', 1710, 18748, 8, 215, 2299.99),
(20, 2, 'Radeon VII', 1750, 16837, 16, 295, 1199.99),
(21, 5, 'GeForce RTX 3080 Ti', 1667, 27283, 12, 350, 4899.99),
(22, 4, 'GeForce RTX 3080', 1710, 25231, 10, 320, 4299.99),
(23, 4, 'GeForce RTX 3070', 1725, 22323, 8, 220, 3599.99),
(24, 2, 'Titan V', 1455, 19773, 12, 250, 3599.99),
(25, 2, 'Titan Xp', 1582, 19155, 12, 250, 2899.99),
(26, 5, 'GeForce RTX 2070', 1620, 16125, 8, 175, 2199.99),
(27, 13, 'Radeon RX 5600 XT', 1750, 13833, 6, 150, 899.99),
(28, 14, 'GeForce GTX 1080', 1733, 15352, 8, 180, 1599.99),
(29, 14, 'GeForce GTX 1070 Ti', 1683, 14645, 8, 180, 1299.99),
(30, 10, 'GeForce GTX 1070', 1683, 13507, 8, 150, 1099.99),
(31, 3, 'GTX Titan X', 1075, 13177, 12, 250, 1499.99),
(32, 14, 'GeForce GTX 980 Ti', 1075, 13856, 6, 250, 1699.99),
(33, 15, 'Radeon R9 Fury X', 1050, 10078, 4, 275, 2099.99),
(34, 6, 'Radeon RX 590', 1545, 9657, 8, 175, 1399.99),
(35, 15, 'Radeon RX 5500 XT', 1845, 9196, 8, 130, 1499.99),
(36, 6, 'Radeon RX 580', 1340, 8923, 8, 185, 1199.99),
(37, 4, 'GeForce GTX 1650 Super', 1725, 10077, 4, 125, 1299.99),
(38, 2, 'GeForce GTX 1660', 1785, 9048, 6, 120, 1399.99),
(39, 4, 'GeForce GTX 1060', 1708, 10069, 6, 120, 1499.99),
(40, 14, 'GeForce GTX 980', 1216, 11221, 4, 165, 1199.99),
(41, 11, 'Radeon RX 570', 1244, 8100, 8, 120, 1199.99),
(42, 13, 'GeForce GTX 970', 1178, 9647, 4, 145, 699.99),
(43, 5, 'Geforce GTX 1650', 1665, 7827, 4, 75, 799.99),
(44, 6, 'GeForce GTX 1050 Ti', 1392, 6298, 4, 75, 699.99),
(45, 16, 'Radeon RX 560', 1275, 3613, 4, 75, 999.99),
(46, 14, 'GeForce GT 1030', 1670, 2518, 4, 30, 399.99),
(47, 14, 'GeForce GTX 1050', 1392, 5054, 2, 75, 899.99),
(48, 5, 'GeForce RTX 4090', 2520, 39062, 24, 450, 15899.99),
(49, 5, 'GeForce RTX 4080', 2505, 33652, 16, 320, 9899.99),
(50, 7, 'Radeon RX 6950 XT', 2324, 28659, 16, 335, 6799.99);

create table RAM(
cod_ram int NOT NULL,
id_marca int NOT NULL,
nome varchar(60),
frequencia int,
capacidade int,
tipo varchar(5),
preco float,
PRIMARY KEY (cod_ram),
FOREIGN KEY (id_marca) REFERENCES Marca(cod_marca)
);

insert into RAM values
(1, 8, 'Fury', 2666, 8, 'DDR4', 215.99),
(2, 9, 'Gammix D45', 3200, 16, 'DDR4', 474.90),
(3, 21, 'Vengeance LPX', 2666, 8, 'DDR4', 352.99),
(4, 21, 'Vengeance', 2400, 8, 'DDR4', 329.99),
(5, 21, 'Value Select', 1600, 8, 'DDR3L', 329.99),
(6, 21, 'Value Select', 2133, 8, 'DDR4', 319.99),
(7, 26, 'Gamer Husky', 2666, 4, 'DDR4', 139.99),
(8, 26, 'Gamer Husky', 2666, 8, 'DDR4', 189.99),
(9, 26, 'Husky Technologies', 2666, 4, 'DDR4', 142.99),
(10, 9, 'Spectryx D45G', 3600, 8, 'DDR4', 399.99),
(11, 9, 'Spectryx D41 TUF', 3200, 8, 'DDR4', 376.99),
(12, 22, 'Ballistix White', 3000, 8, 'DDR4', 352.99),
(13, 22, 'Ballistix Black', 3200, 8, 'DDR4', 352.99),
(14, 25, 'Fury Beast', 3000, 8, 'DDR4', 411.99),
(15, 25, 'Fury Beast Black', 2666, 8, 'DDR4', 295.99),
(16, 27, 'Samsung Memory', 1600, 4, 'DDR3', 89.99),
(17, 17, 'Multi CL11', 1600, 6, 'DDR3', 114.99),
(18, 25, 'KVR16 Kingston', 1600, 4, 'DDR3', 84.99),
(19, 21, 'Corsair C11', 1600, 6, 'DDR3', 129.99),
(20, 21, 'Corsair CL15', 2133, 4, 'DDR4', 125.99),
(21, 25, 'Kingston CL19', 2666, 4, 'DDR4', 144.99),
(22, 25, 'Fury CL17', 2400, 4, 'DDR4', 295.99),
(23, 25, 'Kingston Fury CL16', 2666, 4, 'DDR4', 166.99),
(24, 26, 'Gaming Avalanche', 3200, 16, 'DDR4', 269.99),
(25, 9, 'XPG Gammix D10', 3200, 16, 'DDR4', 359.99),
(26, 25, 'Kingston Fury Beast RGB', 3200, 16, 'DDR4', 409.99),
(27, 9, 'XPG Gammix D10 Black', 3200, 16, 'DDR4', 470.99),
(28, 21, 'Vengeance LPX CL16', 2400, 16, 'DDR4', 339.99),
(29, 22, 'Crucial Basics 6GB', 2666, 6, 'DDR4', 114.99),
(30, 21, 'Corsair CL15 6GB', 2133, 6, 'DDR4', 125.99);

create table Tipo(
cod_tipo int NOT NULL,
nome varchar(40),
PRIMARY KEY (cod_tipo)
);

insert into Tipo values
(1, 'Jogos'),
(2, 'Editor de imagem'),
(3, 'Editor de vídeo'),
(4, 'Compilador'),
(5, 'Entretenimento'),
(6, 'Empresarial'),
(7, 'Monitorador de atividades'),
(8, 'Navegadores'),
(9, 'Limpador de arquivos'),
(10, 'Antivírus');

create table RecomendacaoCpu(
cod_reccpu int NOT NULL,
coremin int,
corerec int,
clockmin float,
clockrec float,
PRIMARY KEY (cod_reccpu)
);

insert into RecomendacaoCpu values
(1, 2, 4, 2.00, 3.10),
(2, 4, 6, 3.10, 3.60),
(3, 4, 4, 2.60, 3.20),
(4, 4, 4, 3.20, 3.40),
(5, 2, 4, 2.80, 3.00),
(6, 4, 4, 2.60, 3.40),
(7, 4, 4, 3.10, 3.50),
(8, 2, 4, 2.10, 3.30),
(9, 2, 4, 2.60, 3.10),
(10, 4, 4, 3.10, 3.70),
(11, 4, 12, 2.90, 3.50),
(12, 4, 6, 2.20, 3.00),
(13, 4, 8, 3.10, 3.70),
(14, 4, 8, 2.20, 3.20),
(15, 4, 12, 3.10, 3.70);

create table RecomendacaoGpu(
cod_recgpu int NOT NULL,
vrammin int,
vramrec int,
clockmin int,
clockrec int,
PRIMARY KEY (cod_recgpu)
);

insert into RecomendacaoGpu values
(1, 2, 4, 900, 1100),
(2, 4, 6, 1100, 1850),
(3, 2, 4, 800, 1300),
(4, 4, 6, 1050, 1400),
(5, 2, 4, 760, 1250),
(6, 4, 6, 830, 1500),
(7, 2, 4, 800, 1120),
(8, 2, 4, 790, 1260),
(9, 4, 6, 900, 1600),
(10, 2, 4, 800, 1260);

create table RecomendacaoRam(
cod_recram int NOT NULL,
capacidademin int,
capacidaderec int,
PRIMARY KEY (cod_recram)
);

insert into RecomendacaoRam values
(1, 4, 8),
(2, 2, 4),
(3, 6, 8),
(4, 4, 8),
(5, 2, 4),
(6, 8, 16),
(7, 4, 4),
(8, 8, 8),
(9, 16, 16),
(10, 16, 32);

create table Software(
cod_soft int NOT NULL,
id_recomendacaoram int NOT NULL,
id_recomendacaogpu int NOT NULL,
id_recomendacaocpu int NOT NULL,
id_tipo int NOT NULL,
nome_soft varchar(80),
imagem varchar(50),
PRIMARY KEY (cod_soft),
FOREIGN KEY (id_recomendacaoram) REFERENCES RecomendacaoRam(cod_recram),
FOREIGN KEY (id_recomendacaogpu) REFERENCES RecomendacaoGpu(cod_recgpu),
FOREIGN KEY (id_recomendacaocpu) REFERENCES RecomendacaoCpu(cod_reccpu),
FOREIGN KEY (id_tipo) REFERENCES Tipo(cod_tipo)
);

insert into Software (cod_soft, id_recomendacaoram, id_recomendacaogpu, id_recomendacaocpu, id_tipo, nome_soft) values
(1, 6, 2, 10, 1, 'God of War'),
(2, 1, 5, 12, 2, 'Adobe Photoshop'),
(3, 1, 7, 8, 1, 'CS GO'),
(4, 3, 6, 14, 1, 'Ghost of Tsushima'),
(5, 1, 1, 4, 1, 'GTA V'),
(6, 6, 9, 14, 1, 'Marvels Spider-Man Miles Morales'),
(7, 6, 9, 14, 1, 'Marvels Avenger'),
(8, 1, 9, 2, 1, 'Dark Souls III'),
(9, 1, 3, 9, 1, 'Jurassic World Evolution 2'),
(10, 1, 10, 9, 1, 'Need for Speed Heat'),
(11, 1, 3, 5, 1, 'Fortnite'),
(12, 1, 1, 12, 1, 'Genshin Impact'),
(13, 1, 2, 10, 3, 'Adobe Premiere Pro'),
(14, 1, 5, 1, 7, 'Wireshark'),
(15, 1, 5, 1, 4, 'MySQL'),
(16, 1, 5, 9, 4, 'Visual Studio'),
(17, 1, 5, 9, 4, 'Eclipse'),
(18, 1, 5, 6, 8, 'Chrome'),
(19, 1, 5, 1, 7, 'Geforce Experience'),
(20, 1, 5, 8, 6, 'Office'),
(21, 6, 7, 3, 1, 'Hot Wheels UNLEASHED'),
(22, 3, 4, 7, 1, 'Apex Legends'),
(23, 8, 3, 7, 1, 'Assassins Creed 3'),
(24, 2, 3, 6, 1, 'Assassins Creed 4 Black Flag'),
(25, 2, 3, 6, 1, 'Assassins Creed Rogue'),
(26, 3, 3, 6, 1, 'Assassins Creed Unity'),
(27, 3, 3, 6, 1, 'Assassins Creed Syndicate'),
(28, 3, 4, 4, 1, 'Assassins Creed Origins'),
(29, 8, 4, 2, 1, 'Assassins Creed Odyssey'),
(30, 1, 3, 4, 1, 'Overcooked 2'),
(31, 3, 4, 6, 1, 'Dark Souls Remastered'),
(32, 2, 7, 5, 1, 'Brawlhalla'),
(33, 6, 9, 10, 1, 'Call of Duty Black Ops 4'),
(34, 6, 9, 10, 1, 'Call of Duty Warzone'),
(35, 6, 9, 10, 1, 'Call of Duty Black Ops Cold War'),
(36, 1, 10, 9, 1, 'Need for Speed Rivals'),
(37, 8, 10, 9, 1, 'Need for Speed Hot Pursuit'),
(38, 3, 10, 9, 1, 'Need for Speed Payback'),
(39, 3, 10, 9, 1, 'Need for Speed 2015'),
(40, 2, 10, 9, 1, 'Need for Speed Most Wanted'),
(41, 1, 10, 9, 1, 'Hollow Knight'),
(42, 3, 3, 9, 1, 'Disgaea 5'),
(43, 1, 6, 6, 1, 'Rocket League'),
(44, 6, 1, 7, 1, 'Crash Bandicoot 4'),
(45, 8, 1, 7, 1, 'Stray'),
(46, 8, 1, 4, 1, 'Mortal Kombat 11'),
(47, 5, 8, 5, 1, 'Dead Cells'),
(48, 6, 8, 5, 1, 'Mortal Shell'),
(49, 8, 6, 12, 1, 'Crash Bandicoot Remake'),
(50, 8, 1, 12, 1, 'FIFA 22'),
(51, 6, 1, 12, 1, 'FIFA 23'),
(52, 2, 8, 5, 1, 'The Survivalists'),
(53, 6, 1, 3, 1, 'A Plague Tale Innocence'),
(54, 6, 6, 4, 1, 'STAR WARS Squadrons'),
(55, 6, 9, 14, 1, 'Horizon Zero Dawn'),
(56, 6, 6, 14, 1, 'Days Gone'),
(57, 1, 1, 3, 1, 'Subnautica'),
(58, 8, 1, 3, 1, 'Subnautica Below Zero'),
(59, 2, 3, 6, 1, 'LEGO Movie'),
(60, 7, 3, 6, 1, 'LEGO Movie 2'),
(61, 6, 10, 3, 1, 'Control'),
(62, 1, 7, 3, 1, 'Cat Quest'),
(63, 1, 7, 3, 1, 'Ni no Kuni Wrath of the White Witch'),
(64, 1, 6, 7, 1, 'PAYDAY 2'),
(65, 8, 10, 9, 1, 'Maneater'),
(66, 1, 7, 9, 1, 'SUPERHOT'),
(67, 9, 2, 13, 1, 'Elden Ring'),
(68, 8, 1, 6, 1, 'Tom Clancy The Division 2'),
(69, 6, 3, 6, 1, 'The Surge 2'),
(70, 2, 3, 4, 1, 'Dark Souls 2'),
(71, 1, 3, 3, 1, 'Resident Evil 1 Remake'),
(72, 8, 6, 6, 1, 'Resident Evil 2 Remake'),
(73, 8, 6, 6, 1, 'Resident Evil 3 Remake'),
(74, 6, 9, 10, 1, 'Resident Evil 4 Remake'),
(75, 8, 6, 6, 1, 'Resident Evil 4'),
(76, 1, 1, 9, 1, 'Resident Evil 5'),
(77, 8, 6, 3, 1, 'Resident Evil 6'),
(78, 6, 4, 7, 1, 'Resident Evil 7'),
(79, 6, 9, 4, 1, 'Resident Evil Village'),
(80, 6, 9, 10, 1, 'Resident Evil Reverse'),
(81, 8, 3, 9, 1, 'Resident Evil Revelations 1'),
(82, 8, 1, 6, 1, 'Resident Evil Revelations 2'),
(83, 2, 8, 5, 1, 'Steam'),
(84, 2, 5, 5, 5, 'Discord'),
(85, 2, 8, 5, 6, 'Adobe Acrobat');

-- PROCURAMOS SITUAÇÕES DE FUNÇÃO PARA O PROJETO, MAS NÃO ENCONTRAMOS
-- POR ISSO, CRIAMOS A FUNÇÃO DO NOSSO SLUG, CASO O NOSSO PROJETO SEJA SELECIONADO PARA O DESENVOLVIMENTO WEB 
DELIMITER $$
CREATE FUNCTION slug_pags(url text)
    RETURNS TEXT DETERMINISTIC
    BEGIN
        DECLARE slug TEXT;
        SET slug = TRIM(url);
        SET slug = LOWER(slug);
        SET slug = REPLACE(slug, ' ', '-');
        SET slug = REPLACE(slug, '--', '-');
        SET slug = REPLACE(slug, '_', '-');
        SET slug = REPLACE(slug, ':', '-');
        SET slug = REPLACE(slug, ':', '-');
        SET slug = REPLACE(slug, ';', '-');
        SET slug = REPLACE(slug, '|', '-');
        SET slug = REPLACE(slug, ',', '');
        SET slug = REPLACE(slug, '~', '');
        SET slug = REPLACE(slug,  '^', '');
        SET slug = REPLACE(slug, '´', '');
        SET slug = REPLACE(slug, '`', '');
        SET slug = REPLACE(slug, '=', '');
        SET slug = REPLACE(slug, '+', '');
        SET slug = REPLACE(slug, '', '');
        SET slug = REPLACE(slug, '@', '');
        SET slug = REPLACE(slug, '<', '');
        SET slug = REPLACE(slug, '>', '');
        SET slug = REPLACE(slug, '#', '');
        SET slug = REPLACE(slug, '$', '');
        SET slug = REPLACE(slug, '¨', '');
        SET slug = REPLACE(slug, '&', '');
        SET slug = REPLACE(slug, '*', '');
        SET slug = REPLACE(slug, '(', '');
        SET slug = REPLACE(slug, ')', '');
        SET slug = REPLACE(slug, '[', '');
        SET slug = REPLACE(slug, ']', '');
        SET slug = REPLACE(slug, '{', '');
        SET slug = REPLACE(slug, '}', '');
        SET slug = REPLACE(slug, '°', '');
        SET slug = REPLACE(slug, '/', '');
        SET slug = REPLACE(slug, '\\', '');
        SET slug = REPLACE(slug, '\'', '');
        SET slug = REPLACE(slug, '?', '');
        SET slug = REPLACE(slug, '!', '');
        SET slug = REPLACE(slug, 'ã', 'a');
        SET slug = REPLACE(slug, 'á', 'a');
        SET slug = REPLACE(slug, 'â', 'a');
        SET slug = REPLACE(slug, 'à', 'a');
        SET slug = REPLACE(slug, 'ç', 'c');
        SET slug = REPLACE(slug, 'ñ', 'n');
        SET slug = REPLACE(slug, 'é', 'e');
        SET slug = REPLACE(slug, 'ê', 'e');
        SET slug = REPLACE(slug, 'é', 'e');
        SET slug = REPLACE(slug, 'ẽ', 'e');
        SET slug = REPLACE(slug, 'í', 'i');
        SET slug = REPLACE(slug, 'ì', 'i');
        SET slug = REPLACE(slug, 'î', 'i');
        SET slug = REPLACE(slug, 'ĩ', 'i');
        SET slug = REPLACE(slug, 'ó', 'o');
        SET slug = REPLACE(slug, 'ò', 'o');
        SET slug = REPLACE(slug, 'ô', 'o');
        SET slug = REPLACE(slug, 'õ', 'o');
        SET slug = REPLACE(slug, 'ú', 'u');
        SET slug = REPLACE(slug, 'ù', 'u');
        SET slug = REPLACE(slug, 'û', 'u');
        SET slug = REPLACE(slug, 'ũ', 'u');
        RETURN slug;
    END
    $$
    
-- SLUG
SELECT slug_pags("Recomendação de configuração para softwares");

-- EXEMPLO DE COMPARAÇÃO DE CPU
SELECT * FROM Processador WHERE cod_cpu = 1;
SELECT * FROM Processador WHERE cod_cpu = 2;

-- EXEMPLO DE COMPARAÇÃO DE GPU
SELECT * FROM GPU WHERE cod_gpu = 1;
SELECT * FROM GPU WHERE cod_gpu = 2;

-- LISTA DE PROCESSADORES POR ORDEM DE FORÇA DE PROCESSAMENTO (MENOR PARA O MAIOR)
CREATE OR REPLACE VIEW lista_cpu AS
SELECT p.cod_cpu AS id, p.nome, m.nome AS marca, p.clock, p.turbo, p.cores, p.threads, p.mark, p.TDP AS TDP, p.arquitetura, p.preco 
FROM Processador p 
JOIN Marca m 
ON p.id_marca = m.cod_marca
ORDER BY mark ASC;

-- LISTA DE MEMORIAS RAM POR ORDEM DE FORÇA DE DESEMPENHO (MENOR PARA O MAIOR)
CREATE OR REPLACE VIEW lista_ram AS
SELECT r.cod_ram AS id, r.nome, m.nome AS marca, r.frequencia, r.capacidade, r.tipo, r.preco 
FROM Ram r
JOIN Marca m 
ON r.id_marca = m.cod_marca
ORDER BY capacidade ASC;

-- LISTA DE GPU POR ORDEM DE FORÇA DE PROCESSAMENTO GRÁFICO (MENOR PARA O MAIOR)
CREATE OR REPLACE VIEW lista_gpu AS
SELECT g.cod_gpu AS id, g.nome, m.nome AS marca, g.clock, g.VRAM, g.mark, g.TDP AS TDP, g.preco 
FROM Gpu g
JOIN Marca m 
ON g.id_marca = m.cod_marca
ORDER BY mark ASC;

-- TELA DE RECOMENDAÇÃO DE UM SOFTWARE ESPECIFICO
CREATE OR REPLACE VIEW requisitos_soft AS
SELECT cod_soft, nome_soft, t.nome AS tipo, capacidademin, coremin, c.clockmin AS clockmin_cpu, g.clockmin AS clockmin_gpu, vrammin, capacidaderec, corerec, c.clockrec AS clockrec_cpu, g.clockrec AS clockrec_gpu, vramrec
FROM Software
INNER JOIN tipo t
ON id_tipo = cod_tipo
INNER JOIN RecomendacaoRam
ON id_recomendacaoram = cod_recram
INNER JOIN RecomendacaoCpu c
ON id_recomendacaocpu = cod_reccpu
INNER JOIN RecomendacaoGpu g
ON id_recomendacaogpu = cod_recgpu;

-- TELAS DE REQUISITOS PARA UMA CONFIGURAÇÃO ESPECÍFICA
-- UTILIZAÇÃO DA FUNÇÃO MAX PARA ATENDER AS REQUISIÇÕES FEITAS
-- CONFIGURAÇÃO MÍNIMA DE SOFTWARES ESCOLHIDOS
CREATE OR REPLACE VIEW recmin_softs AS
SELECT cod_soft, capacidademin, coremin, vrammin
FROM Software
INNER JOIN RecomendacaoRam
ON id_recomendacaoram = cod_recram
INNER JOIN RecomendacaoCpu c
ON id_recomendacaocpu = cod_reccpu
INNER JOIN RecomendacaoGpu g
ON id_recomendacaogpu = cod_recgpu;

-- CONFIGURAÇÃO RECOMENDADA DE SOFTWARES ESCOLHIDOS
CREATE OR REPLACE VIEW recrec_softs AS
SELECT cod_soft, capacidaderec, corerec, vramrec
FROM Software
INNER JOIN RecomendacaoRam
ON id_recomendacaoram = cod_recram
INNER JOIN RecomendacaoCpu c
ON id_recomendacaocpu = cod_reccpu
INNER JOIN RecomendacaoGpu g
ON id_recomendacaogpu = cod_recgpu;

-- TELAS DE HARDWARES PARA UMA CONFIGURAÇÃO ESPECÍFICA
-- MEMÓRIAS QUE SE ENCAIXAM EM UMA DETERMINADA RECOMENDAÇÃO DO SOFTWARE ESCOLHIDO EM ORDEM CRESCENTE DE CAPACIDADE EM GBS
CREATE VIEW rec_ram AS
SELECT m.nome AS marca, r.nome AS memoria_ram, capacidade, frequencia, tipo, preco  
FROM RAM r
INNER JOIN Marca m
ON cod_marca = id_marca
ORDER BY capacidade ASC;

-- PROCESSADORES QUE SE ENCAIXAM EM UMA DETERMINADA RECOMENDAÇÃO DO SOFTWARE ESCOLHIDO EM ORDEM CRESCENTE DE CORES
CREATE VIEW rec_cpu AS
SELECT m.nome AS marca, p.nome AS processador, cores, threads, clock, turbo, mark, TDP, arquitetura, preco  
FROM Processador p
INNER JOIN Marca m
ON cod_marca = id_marca
ORDER BY cores ASC;

-- PLACAS DE VÍDEO QUE SE ENCAIXAM EM UMA DETERMINADA RECOMENDAÇÃO DO SOFTWARE ESCOLHIDO EM ORDEM CRESCENTE DE VRAM EM GBS
CREATE VIEW rec_gpu AS
SELECT m.nome AS marca, g.nome AS gpu, vram, clock, mark, TDP, preco  
FROM GPU g
INNER JOIN Marca m
ON cod_marca = id_marca
ORDER BY vram ASC;

-- LISTA DE PROCESSADORES
SELECT * FROM lista_cpu;

-- LISTA DE RAM
SELECT * FROM lista_ram;

-- LISTA DE GPU
SELECT * FROM lista_gpu;

-- EXEMPLOS PARA USO NO SOFTWARE JAVA
SELECT * FROM requisitos_soft
WHERE cod_soft IN (1);

SELECT * FROM rec_ram
WHERE capacidade >= 4;

SELECT * FROM rec_cpu
WHERE cores >= 4 and clock >= 3.1;

SELECT * FROM rec_gpu
WHERE vram >= 8;

SELECT AVG(capacidaderec) AS media_RAM, AVG(corerec) AS media_Core, AVG(vramrec) AS media_VRAM
FROM recrec_softs;

SELECT max(capacidademin) AS capacidade_min_RAM, max(coremin) AS core_min_CPU, max(vrammin) AS vram_min_GPU
FROM recmin_softs;

SELECT max(capacidaderec) AS capacidade_rec_RAM, max(corerec) AS core_rec_CPU, max(vramrec) AS vram_rec_GPU
FROM recrec_softs;