-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema temp
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`t_region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`t_region` (
  `region_code` VARCHAR(3) NOT NULL,
  `region_name` VARCHAR(10) NULL,
  PRIMARY KEY (`region_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`t_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`t_customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `t_region_region_code1` VARCHAR(3) NOT NULL,
  `regist_date` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_t_customer_t_region1_idx` (`t_region_region_code1` ASC) VISIBLE,
  CONSTRAINT `fk_t_customer_t_region1`
    FOREIGN KEY (`t_region_region_code1`)
    REFERENCES `mydb`.`t_region` (`region_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`t_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`t_product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_code` VARCHAR(12) NOT NULL,
  `product_name` VARCHAR(50) NOT NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `product_code_UNIQUE` (`product_code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`t_sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`t_sales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `qty` INT NOT NULL,
  `sales_date` DATETIME NULL DEFAULT now(),
  `t_customer_id` INT NOT NULL,
  `t_product_code` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_t_sales_t_customer1_idx` (`t_customer_id` ASC) VISIBLE,
  INDEX `fk_t_sales_t_product1_idx` (`t_product_code` ASC) VISIBLE,
  CONSTRAINT `fk_t_sales_t_customer1`
    FOREIGN KEY (`t_customer_id`)
    REFERENCES `mydb`.`t_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_sales_t_product1`
    FOREIGN KEY (`t_product_code`)
    REFERENCES `mydb`.`t_product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
