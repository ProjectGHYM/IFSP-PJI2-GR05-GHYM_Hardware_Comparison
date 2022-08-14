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
(26, 'Husky Gaming');

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
(15, 2, 'Ryzen 9 5900X', 3.70, 4.80, 12, 24, 39348, 105, 'AM4', 2899.99);

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
(15, 7, 'Geforce GT 1030', 1250, 2539, 2, 30, 899.99);

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
(15, 25, 'Fury Beast Black', 2666, 8, 'DDR4', 295.99);

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
coremax int,
coremin int,
corerec int,
clockmax float,
clockmin float,
clockrec float,
PRIMARY KEY (cod_reccpu)
);

insert into RecomendacaoCpu values
(1, 6, 2, 4, 3.60, 2.00, 3.10),
(2, 8, 4, 6, 3.90, 3.10, 3.60),
(3, 6, 4, 4, 3.90, 2.60, 3.20),
(4, 8, 4, 4, 3.90, 3.20, 3.40),
(5, 8, 2, 4, 4.10, 2.80, 3.00),
(6, 6, 4, 4, 3.80, 2.60, 3.40),
(7, 8, 4, 4, 4.00, 3.10, 3.50),
(8, 6, 2, 4, 3.80, 2.10, 3.30),
(9, 6, 2, 4, 3.60, 2.60, 3.10),
(10, 6, 4, 4, 4.00, 3.10, 3.70);

create table RecomendacaoGpu(
cod_recgpu int NOT NULL,
vrammax int,
vrammin int,
vramrec int,
clockmax float,
clockmin float,
clockrec float,
PRIMARY KEY (cod_recgpu)
);

insert into RecomendacaoGpu values
(1, 6, 2, 4, 1850, 900, 1100),
(2, 10, 4, 6, 1950, 1100, 1850),
(3, 6, 2, 4, 1600, 800, 1300),
(4, 8, 4, 6, 2100, 1050, 1400),
(5, 6, 2, 4, 1550, 760, 1250),
(6, 8, 4, 6, 1820, 830, 1500),
(7, 6, 2, 4, 1430, 800, 1120),
(8, 6, 2, 4, 1580, 790, 1260),
(9, 8, 4, 6, 1900, 900, 1600),
(10, 6, 2, 4, 1560, 800, 1260);

create table RecomendacaoRam(
cod_recram int NOT NULL,
capacidademax int,
capacidademin int,
capacidaderec int,
PRIMARY KEY (cod_recram)
);

insert into RecomendacaoRam values
(1, 16, 4, 8),
(2, 6, 2, 4),
(3, 16, 6, 8),
(4, 12, 4, 8),
(5, 8, 2, 4);

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
(1, 1, 2, 7, 1, 'God of War'),
(2, 1, 5, 1, 2, 'Adobe Photoshop'),
(3, 1, 7, 8, 1, 'Counter-Strike Global Offensive'),
(4, 3, 1, 2, 1, 'Ghost of Tsushima'),
(5, 1, 1, 4, 1, 'GTA V'),
(6, 1, 2, 5, 1, 'Marvels Spider-Man Miles Morales'),
(7, 1, 9, 5, 1, 'Marvels Avenger'),
(8, 1, 6, 3, 1, 'Dark Souls III'),
(9, 1, 3, 9, 1, 'Jurassic World Evolution 2'),
(10, 1, 3, 1, 1, 'Need for Speed Heat'),
(11, 1, 5, 8, 1, 'Fortnite'),
(12, 1, 3, 10, 1, 'Genshin Impact'),
(13, 1, 8, 2, 3, 'Adobe Premiere Pro'),
(14, 1, 3, 1, 7, 'Wireshark'),
(15, 1, 3, 1, 4, 'MySQL'),
(16, 1, 3, 2, 4, 'Visual Studio'),
(17, 1, 3, 1, 4, 'Eclipse'),
(18, 1, 3, 1, 8, 'Chrome'),
(19, 1, 10, 1, 7, 'Geforce Experience'),
(20, 1, 3, 1, 6, 'Office 365');

-- SELECT PARA COMPARAÇÃO DE CPU
Select * from Processador WHERE cod_cpu = 1;
Select * from Processador WHERE cod_cpu = 2;

-- SELECT PARA COMPARAÇÃO DE GPU
Select * from GPU WHERE cod_gpu = 1;
Select * from GPU WHERE cod_gpu = 2;

-- SELECT PARA SOFTWARE
Select id_tipo,  nome_soft From Software WHERE cod_soft = 1;
-- EXEMPLO: GOD OF WAR

-- RECOMENDAÇÃO CPU
-- RECOMENDAÇÃO MÁXIMA
Select DISTINCT cod_cpu, id_marca, nome, clock, turbo, cores, threads, TDP, arquitetura, preco from Processador, RecomendacaoCpu, Software WHERE cod_soft = 1 and id_recomendacaocpu = cod_reccpu and turbo >= clockmax and cores >= coremax;
-- RECOMENDAÇÃO MÍNIMO
Select DISTINCT cod_cpu, id_marca, nome, clock, turbo, cores, threads, TDP, arquitetura, preco from Processador, RecomendacaoCpu, Software WHERE cod_soft = 1 and id_recomendacaocpu = cod_reccpu and turbo >= clockmin and cores >= coremin;
-- RECOMENDAÇÃO EQUILIBRADA
Select DISTINCT cod_cpu, id_marca, nome, clock, turbo, cores, threads, TDP, arquitetura, preco from Processador, RecomendacaoCpu, Software WHERE cod_soft = 1 and id_recomendacaocpu = cod_reccpu and turbo >= clockrec and cores >= corerec;

-- RECOMENDAÇÃO GPU
-- RECOMENDAÇÃO MÁXIMA
Select DISTINCT cod_gpu, id_marca, nome, clock, VRAM, TDP, preco from GPU, RecomendacaoGpu, Software WHERE cod_soft = 1 and id_recomendacaogpu = cod_recgpu and clock >= clockmax and VRAM >= vrammax;
-- RECOMENDAÇÃO MÍNIMA
Select DISTINCT cod_gpu, id_marca, nome, clock, VRAM, TDP, preco from GPU, RecomendacaoGpu, Software WHERE cod_soft = 1 and id_recomendacaogpu = cod_recgpu and clock >= clockmin and VRAM >= vrammin;
-- RECOMENDAÇÃO EQUILIBRADA
Select DISTINCT cod_gpu, id_marca, nome, clock, VRAM, TDP, preco from GPU, RecomendacaoGpu, Software WHERE cod_soft = 1 and id_recomendacaogpu = cod_recgpu and clock >= clockrec and VRAM >= vramrec;

-- RECOMENDAÇÃO RAM
-- RECOMENDAÇÃO MÁXIMA
Select DISTINCT cod_ram, id_marca, nome, frequencia, capacidade, tipo, preco from RAM, RecomendacaoRam, Software WHERE cod_soft = 1 and id_recomendacaoram = cod_recram and capacidade >= capacidademax;
-- RECOMENDAÇÃO MÍNIMO
Select DISTINCT cod_ram, id_marca, nome, frequencia, capacidade, tipo, preco from RAM, RecomendacaoRam, Software WHERE cod_soft = 1 and id_recomendacaoram = cod_recram and capacidade >= capacidademin;
-- RECOMENDAÇÃO EQUILIBRADA
Select DISTINCT cod_ram, id_marca, nome, frequencia, capacidade, tipo, preco from RAM, RecomendacaoRam, Software WHERE cod_soft = 1 and id_recomendacaoram = cod_recram and capacidade >= capacidaderec;