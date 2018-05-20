-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `desweb` ;

-- -----------------------------------------------------
-- Schema desweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `desweb` DEFAULT CHARACTER SET utf8 ;

USE `desweb` ;

-- -----------------------------------------------------
-- Table `desweb`.`ano`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `desweb`.`ano` ;

CREATE TABLE IF NOT EXISTS `desweb`.`ano` (
  `ano` INT(4) NOT NULL,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ano`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`modalidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `desweb`.`modalidade` ;

CREATE TABLE IF NOT EXISTS `desweb`.`modalidade` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(100) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`pais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `desweb`.`pais` ;

CREATE TABLE IF NOT EXISTS `desweb`.`pais` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `populacao` MEDIUMTEXT NULL DEFAULT NULL,
  `area` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`olimpiada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `desweb`.`olimpiada` ;

CREATE TABLE IF NOT EXISTS `desweb`.`olimpiada` (
  `ouro` INT(11) NULL DEFAULT NULL,
  `prata` INT(11) NULL DEFAULT NULL,
  `bronze` INT(11) NULL DEFAULT NULL,
  `modalidade_id` INT(11) NOT NULL,
  `pais_id` INT(11) NOT NULL,
  `ano_ano` INT(4) NOT NULL,
  PRIMARY KEY (`modalidade_id`, `pais_id`, `ano_ano`),
  INDEX `fk_olimpiada_modalidade_idx` (`modalidade_id` ASC),
  INDEX `fk_olimpiada_pais1_idx` (`pais_id` ASC),
  INDEX `fk_olimpiada_ano1_idx` (`ano_ano` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
