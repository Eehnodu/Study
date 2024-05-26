-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema college
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema college
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `college` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `college` ;

-- -----------------------------------------------------
-- Table `college`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `college`.`department` (
  `department_code` INT NOT NULL,
  `department_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`department_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `college`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `college`.`professor` (
  `professor_code` INT NOT NULL AUTO_INCREMENT,
  `professor_name` VARCHAR(50) NULL DEFAULT NULL,
  `department_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`professor_code`),
  INDEX `FK_Professor_Department` (`department_code` ASC) VISIBLE,
  CONSTRAINT `FK_Professor_Department`
    FOREIGN KEY (`department_code`)
    REFERENCES `college`.`department` (`department_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `college`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `college`.`course` (
  `course_code` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(50) NULL DEFAULT NULL,
  `professor_code` INT NULL DEFAULT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`course_code`),
  INDEX `FK_Course_Professor` (`professor_code` ASC) VISIBLE,
  CONSTRAINT `FK_Course_Professor`
    FOREIGN KEY (`professor_code`)
    REFERENCES `college`.`professor` (`professor_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `college`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `college`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `height` DECIMAL(5,2) NULL DEFAULT NULL,
  `department_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  INDEX `FK_Student_Department` (`department_code` ASC) VISIBLE,
  CONSTRAINT `FK_Student_Department`
    FOREIGN KEY (`department_code`)
    REFERENCES `college`.`department` (`department_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `college`.`student_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `college`.`student_course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NULL DEFAULT NULL,
  `course_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Student_Course_Student` (`student_id` ASC) VISIBLE,
  INDEX `FK_Student_Course_Course` (`course_code` ASC) VISIBLE,
  CONSTRAINT `FK_Student_Course_Course`
    FOREIGN KEY (`course_code`)
    REFERENCES `college`.`course` (`course_code`),
  CONSTRAINT `FK_Student_Course_Student`
    FOREIGN KEY (`student_id`)
    REFERENCES `college`.`student` (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
