-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema desweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema desweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `desweb` DEFAULT CHARACTER SET utf8 ;
USE `desweb` ;

-- -----------------------------------------------------
-- Table `desweb`.`ano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desweb`.`ano` (
  `ano` INT(4) NOT NULL,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ano`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desweb`.`modalidade` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desweb`.`pais` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `populacao` DOUBLE NULL DEFAULT NULL,
  `area` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `desweb`.`olimpiada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desweb`.`olimpiada` (
  `ouro` INT(11) NULL DEFAULT NULL,
  `prata` INT(11) NULL DEFAULT NULL,
  `bronze` INT(11) NULL DEFAULT NULL,
  `modalidade_id` INT(11) NOT NULL,
  `ano_ano` INT(4) NOT NULL,
  `pais_id` INT(11) NOT NULL,
  PRIMARY KEY (`modalidade_id`, `ano_ano`, `pais_id`),
  INDEX `fk_olimpiada_modalidade_idx1` (`modalidade_id` ASC),
  INDEX `fk_olimpiada_ano1_idx1` (`ano_ano` ASC),
  INDEX `fk_olimpiada_pais1_idx1` (`pais_id` ASC),
  CONSTRAINT `fk_olimpiada_modalidade`
    FOREIGN KEY (`modalidade_id`)
    REFERENCES `desweb`.`modalidade` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_olimpiada_ano1`
    FOREIGN KEY (`ano_ano`)
    REFERENCES `desweb`.`ano` (`ano`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_olimpiada_pais1`
    FOREIGN KEY (`pais_id`)
    REFERENCES `desweb`.`pais` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
