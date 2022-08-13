drop database IF EXISTS GHYM;
create database GHYM;
use GHYM;

create table Marca(
    id int NOT NULL,
    nome varchar(20),
    PRIMARY KEY (id)
);

-- NOME DA TABELA NÃO PODE SER 'CPU', POIS É UMA PALAVRA RESERVADA
create table Processador(
    id int NOT NULL,
    id_marca int NOT NULL,
    nome varchar(60),
    clock float,
    turbo float,
    cores int,
    threads int,
    mark int,
    TDP int,
    lancamento varchar(20),
    arquitetura varchar(15),
    preco float,
    imagem longblob,
    PRIMARY KEY (id),
    FOREIGN KEY (id_marca) REFERENCES Marca(id)
);

create table GPU(
    id int NOT NULL,
    id_marca int NOT NULL,
    nome varchar(60),
    clock int,
    mark int,
    VRAM int,
    TDP int,
    preco float,
    imagem longblob,
    PRIMARY KEY (id),
    FOREIGN KEY (id_marca) REFERENCES Marca(id)
);

create table RAM(
    id int NOT NULL,
    id_marca int NOT NULL,
    nome varchar(60),
    frequencia int,
    capacidade int,
    tipo varchar(5),
    preco float,
    PRIMARY KEY (id),
    FOREIGN KEY (id_marca) REFERENCES Marca(id)
);

create table Tipo(
    id int NOT NULL,
    nome varchar(20),
    PRIMARY KEY (id)
);

create table RecomendacaoCpu(
    codigo int NOT NULL,
    coremax int,
    coremin int,
    corerec int,
    clockmax float,
    clockmin float,
    clockrec float,
    PRIMARY KEY (codigo)
);

create table RecomendacaoGpu(
    codigo int NOT NULL,
    vrammax int,
    vrammin int,
    vramrec int,
    clockmax float,
    clockmin float,
    clockrec float,
    PRIMARY KEY (codigo)
);

create table RecomendacaoRam(
    codigo int NOT NULL,
    capacidademax int,
    capacidademin int,
    capacidaderec int,
    PRIMARY KEY (codigo)
);

create table Software(
    id int NOT NULL,
    id_recomendacaoram int NOT NULL,
    id_recomendacaogpu int NOT NULL,
    id_recomendacaocpu int NOT NULL,
    id_tipo int NOT NULL,
    nome varchar(50),
    imagem longblob,
    PRIMARY KEY (id),
    FOREIGN KEY (id_recomendacaoram) REFERENCES RecomendacaoRam(codigo),
    FOREIGN KEY (id_recomendacaogpu) REFERENCES RecomendacaoGpu(codigo),
    FOREIGN KEY (id_recomendacaocpu) REFERENCES RecomendacaoCpu(codigo),
    FOREIGN KEY (id_tipo) REFERENCES Tipo(id)
);

insert into Marca (id, nome) values
(1, 'INTEL'),
(2, 'AMD'),
(3, 'NVIDIA'),
(4, 'GIGABYTE'),
(5, 'ASUS'),
(6, 'PCEYES'),
(7, 'MSI'),
(8, 'HyperX'),
(9, 'XPG'),
(10, 'GALAX');

insert into GPU (id, id_marca, nome, clock, mark, VRAM, TDP, preco) values
(1, 4, 'GeForce GTX 1660 OC', 1830, 11707, 6, 420, 1799.99),
(2, 6, 'RX 550', 1183, 2722, 4, 80, 899.99);

insert into Processador (id, id_marca, nome, clock, turbo, cores, threads, mark, TDP, arquitetura, preco) values
(1, 1, 'I5-2400', 3.10, 3.40, 4, 4, 3843, 35, 'LGA1155', 399.99),
(2, 2, 'Ryzen 5 5600G', 3.90, 4.20, 8, 6, 19821, 65, 'AM4', 1299.99);

insert into RAM values
(1, 8, 'Fury', 2666, 8, 'DDR4', 215.99),
(2, 9, 'Gammix D45', 3200, 16, 'DDR4', 474.90);

insert into RecomendacaoRam values
(1, 16, 4, 8),
(2, 8, 2, 4);

insert into RecomendacaoCpu values
(1, 8, 2, 4, 3.60, 2.00, 3.10),
(2, 8, 4, 6, 3.90, 3.10, 3.60);

insert into RecomendacaoGpu values
(1, 6, 2, 4, 1850, 900, 1100),
(2, 10, 4, 6, 19504, 1100, 1850);

insert into Tipo values
(1, 'Jogos'),
(2, 'Editor de imagem');

insert into Software (id, id_recomendacaoram, id_recomendacaogpu, id_recomendacaocpu, id_tipo, nome) values
(1, 1, 2, 2, 1, 'God of War'),
(2, 2, 1, 1, 2, 'Adobe Photoshop'),
(3, 2, 1, 1, 2, 'Counter-Strike Global Offensive');

-- SELECT PARA COMPARAÇÃO DE CPU
Select * from Processador WHERE id = 1;
Select * from Processador WHERE id = 2;

-- SELECT PARA COMPARAÇÃO DE GPU
Select * from GPU WHERE id = 1;
Select * from GPU WHERE id = 2;

-- SELECT PARA RECOMENDAÇÃO
Select * From Software;

-- EXEMPLO: GOD OF WAR

-- RECOMENDAÇÃO MÁXIMA
Select DISTINCT id, id_marca, nome, clock, cores, threads, TDP, arquitetura, preco from Processador, RecomendacaoCpu WHERE clock >= clockmax and cores >= coremax;
-- GPU E RAM É A MESMA COISA

-- RECOMENDAÇÃO MÍNIMA
Select DISTINCT id, id_marca, nome, clock, VRAM, TDP, preco from GPU, RecomendacaoGpu WHERE clock >= clockmin and VRAM >= vrammin;
-- CPU E RAM É A MESMA COISA

-- RECOMENDAÇÃO RECOMENDADA
Select DISTINCT id , id_marca, nome, frequencia, capacidade, tipo, preco from RAM, RecomendacaoRam WHERE capacidade >= capacidaderec;
-- GPU E CPU É A MESMA COISA
