-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 01 fév. 2025 à 15:13
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cookapp`
--

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `id_item` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `calories` float NOT NULL,
  `quantityunit` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`id_item`, `name`, `price`, `category`, `calories`, `quantityunit`) VALUES
(1, 'Milk', 1.5, 'Dairy', 42, '1L'),
(2, 'Eggs', 1.6, 'Dairy', 72, '4 units'),
(3, 'Cheese', 3.08, 'Dairy', 402, '100g'),
(4, 'Chicken Fillets', 17.58, 'Meat', 1650, '1kg'),
(5, 'Beef Round', 50.2, 'Meat', 2500, '1kg'),
(6, 'Apples', 6.64, 'Fruit', 520, '1kg'),
(7, 'Bananas', 9.16, 'Fruit', 890, '1kg'),
(8, 'Tomatoes', 1.2, 'Vegetable', 180, '1kg'),
(9, 'Potatoes', 1.9, 'Vegetable', 770, '1kg'),
(10, 'Onions', 1.7, 'Vegetable', 400, '1kg'),
(11, 'Vegetable Oil', 5, 'Condiment', 884, '1L'),
(12, 'Flour', 0.85, 'Grain', 364, '1kg'),
(13, 'Yogurt', 0.5, 'Dairy', 59, '150g'),
(14, 'Sugar', 2, 'Condiment', 387, '1kg'),
(15, 'Salt', 0.7, 'Condiment', 0, '1kg'),
(16, 'Butter', 3.5, 'Dairy', 717, '100g'),
(17, 'Pasta', 0.48, 'Grain', 371, '500g'),
(18, 'Chicken Breast', 4.5, 'Meat', 165, 'kg'),
(19, 'Broccoli', 2, 'Vegetable', 55, 'kg'),
(20, 'Rice', 1.8, 'Grain', 130, 'kg'),
(21, 'Tomato', 1.5, 'Vegetable', 18, 'kg'),
(22, 'Olive Oil', 5.5, 'Condiment', 884, 'liter'),
(23, 'Mushrooms', 2.5, 'Vegetable', 22, 'kg'),
(24, 'Salmon Fillet', 10, 'Fish', 206, 'kg');

-- --------------------------------------------------------

--
-- Structure de la table `recipes`
--

CREATE TABLE `recipes` (
  `recipe_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `preparation_steps` text DEFAULT NULL,
  `total_cost` decimal(38,2) DEFAULT NULL,
  `servings` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `recipes`
--

INSERT INTO `recipes` (`recipe_id`, `name`, `description`, `preparation_steps`, `total_cost`, `servings`) VALUES
(1, 'Creamy Chicken Pasta', 'A delicious pasta dish with creamy sauce and tender chicken.', '1. Cook pasta according to package instructions. 2. In a skillet, cook chicken fillets until done. 3. Add butter to the skillet and melt. 4. Stir in flour and cook for 1-2 minutes. 5. Gradually add milk and stir until the sauce thickens. 6. Mix in cooked pasta and serve.', 26.98, 4);

-- --------------------------------------------------------

--
-- Structure de la table `recipe_ingredients`
--

CREATE TABLE `recipe_ingredients` (
  `id` int(11) NOT NULL,
  `recipe_id` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity` decimal(38,2) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `recipe_ingredients`
--

INSERT INTO `recipe_ingredients` (`id`, `recipe_id`, `id_item`, `quantity`, `unit`) VALUES
(1, 1, 4, 500.00, 'g'),
(2, 1, 17, 250.00, 'g'),
(3, 1, 3, 100.00, 'g'),
(4, 1, 10, 1.00, 'medium'),
(5, 1, 15, 2.00, 'tbsp');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id_item`);

--
-- Index pour la table `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`recipe_id`);

--
-- Index pour la table `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recipe_id` (`recipe_id`),
  ADD KEY `id_item` (`id_item`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `recipes`
--
ALTER TABLE `recipes`
  MODIFY `recipe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
  ADD CONSTRAINT `recipe_ingredients_ibfk_1` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`),
  ADD CONSTRAINT `recipe_ingredients_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
