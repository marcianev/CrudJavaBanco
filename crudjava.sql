-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/05/2025 às 04:06
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `crudjava`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `selecionar_media` ()   BEGIN
SELECT a.nome, n.nota1, n.nota2, s.media
FROM semestre as s
JOIN aluno as a
JOIN nota as n
WHERE s.cod_aluno = a.cod
AND s.cod_aluno = n.cod_aluno;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `cod` int(11) NOT NULL,
  `nome` char(80) NOT NULL,
  `email` char(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aluno`
--

INSERT INTO `aluno` (`cod`, `nome`, `email`) VALUES
(1, 'soraia', 'soraia@email'),
(2, 'Marcos', 'marcos@email'),
(3, 'Melissa', 'melissa@email'),
(4, 'Luis', 'luis@email'),
(5, 'Celia', 'celia@email'),
(6, 'Vanessa', 'vanessa@email');

-- --------------------------------------------------------

--
-- Estrutura para tabela `nota`
--

CREATE TABLE `nota` (
  `cod` int(11) NOT NULL,
  `cod_aluno` int(11) NOT NULL,
  `nota1` decimal(4,2) DEFAULT NULL,
  `nota2` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `nota`
--

INSERT INTO `nota` (`cod`, `cod_aluno`, `nota1`, `nota2`) VALUES
(1, 1, 4.50, 6.50),
(2, 2, 7.50, 9.50),
(3, 3, 9.00, 8.50),
(4, 4, 7.50, 9.50),
(5, 5, 7.40, 6.50),
(6, 6, 3.50, 2.50);

--
-- Acionadores `nota`
--
DELIMITER $$
CREATE TRIGGER `media` AFTER INSERT ON `nota` FOR EACH ROW BEGIN
INSERT semestre 
VALUES(null, new.cod_aluno, (new.nota1+new.nota2)/2);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `semestre`
--

CREATE TABLE `semestre` (
  `cdo` int(11) NOT NULL,
  `cod_aluno` int(11) NOT NULL,
  `media` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `semestre`
--

INSERT INTO `semestre` (`cdo`, `cod_aluno`, `media`) VALUES
(1, 1, 5.50),
(2, 2, 8.50),
(3, 3, 8.75),
(4, 4, 8.50),
(5, 5, 6.95),
(6, 6, 3.00);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`cod`);

--
-- Índices de tabela `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`cod`);

--
-- Índices de tabela `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`cdo`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `nota`
--
ALTER TABLE `nota`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `semestre`
--
ALTER TABLE `semestre`
  MODIFY `cdo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
