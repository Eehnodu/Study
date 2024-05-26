-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema haksa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema haksa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `haksa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `haksa` ;

-- -----------------------------------------------------
-- Table `haksa`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `haksa`.`department` (
  `department_code` INT NOT NULL AUTO_INCREMENT,
  `department_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`department_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `haksa`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `haksa`.`student` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `student_name` VARCHAR(50) NOT NULL,
  `student_height` DECIMAL(5,2) NULL,
  `department_code` INT NOT NULL,
  PRIMARY KEY (`student_id`),
  INDEX `fk_student_department_idx` (`department_code` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_code`)
    REFERENCES `haksa`.`department` (`department_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `haksa`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `haksa`.`professor` (
  `professor_code` INT NOT NULL AUTO_INCREMENT,
  `professor_name` VARCHAR(50) NOT NULL,
  `department_code` INT NOT NULL,
  PRIMARY KEY (`professor_code`),
  INDEX `fk_professor_department1_idx` (`department_code` ASC) VISIBLE,
  CONSTRAINT `fk_professor_department1`
    FOREIGN KEY (`department_code`)
    REFERENCES `haksa`.`department` (`department_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `haksa`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `haksa`.`course` (
  `course_code` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(50) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `professor_code` INT NOT NULL,
  PRIMARY KEY (`course_code`),
  INDEX `fk_course_professor1_idx` (`professor_code` ASC) VISIBLE,
  CONSTRAINT `fk_course_professor1`
    FOREIGN KEY (`professor_code`)
    REFERENCES `haksa`.`professor` (`professor_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `haksa`.`student_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `haksa`.`student_course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enrolment_date` DATETIME NOT NULL DEFAULT now(),
  `student_id` INT NOT NULL,
  `course_code` INT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_student_course_student1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_student_course_course1_idx` (`course_code` ASC) VISIBLE,
  PRIMARY KEY (`student_id`, `course_code`),
  CONSTRAINT `fk_student_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `haksa`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_course_course1`
    FOREIGN KEY (`course_code`)
    REFERENCES `haksa`.`course` (`course_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
