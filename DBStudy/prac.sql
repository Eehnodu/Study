-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema prac
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema prac
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prac` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `prac` ;

-- -----------------------------------------------------
-- Table `prac`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prac`.`customer` (
  `customer_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `customer_name` VARCHAR(100) NOT NULL,
  `age` INT NULL DEFAULT NULL,
  `rating` VARCHAR(20) NOT NULL,
  `occupation` VARCHAR(20) NULL DEFAULT NULL,
  `reserves` INT NULL DEFAULT '0',
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prac`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prac`.`product` (
  `product_number` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NULL DEFAULT NULL,
  `inventory` INT NULL DEFAULT NULL,
  `price` INT NULL DEFAULT NULL,
  `manufacturer` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`product_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prac`.`customer_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prac`.`customer_product` (
  `order_number` INT NOT NULL AUTO_INCREMENT,
  `customer_id` VARCHAR(50) NULL DEFAULT NULL,
  `product_number` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `order_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_number`),
  INDEX `customer_id` (`customer_id` ASC) VISIBLE,
  INDEX `product_number` (`product_number` ASC) VISIBLE,
  CONSTRAINT `customer_product_ibfk_1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `prac`.`customer` (`customer_id`),
  CONSTRAINT `customer_product_ibfk_2`
    FOREIGN KEY (`product_number`)
    REFERENCES `prac`.`product` (`product_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

ALTER TABLE product ADD CONSTRAINT check_inventory CHECK (inventory > 0 AND inventory <= 10000);

INSERT INTO customer (customer_id, password, customer_name, age, rating, occupation, reserves) VALUES
('CUST001', 'CUST001', '홍길동', 30, 'Gold', '엔지니어', 100),
('CUST002', 'CUST002', '이영희', 25, 'Silver', '교사', 50),
('CUST003', 'CUST003', '김철수', 40, 'VIP', '의사', 75),
('CUST004', 'CUST004', '박영훈', 35, 'Silver', '변호사', 25),
('CUST005', 'CUST005', '최미영', 28, 'Gold', '예술가', 150);

INSERT INTO product (product_name, inventory, price, manufacturer) VALUES
('제품 A', 50, 20000, 'ABC 주식회사'),
('제품 B', 30, 35000, 'XYZ 기업'),
('제품 C', 80, 15000, 'LMN 산업'),
('제품 D', 40, 25000, 'PQR 주식회사'),
('제품 E', 20, 30000, 'JKL 기업');

INSERT INTO customer_product (customer_id, product_number, quantity) VALUES
('CUST001', 1, 2),
('CUST002', 3, 1),
('CUST003', 2, 3),
('CUST004', 4, 2),
('CUST005', 5, 1),
('CUST001', 2, 1),
('CUST002', 4, 2),
('CUST003', 1, 3),
('CUST004', 5, 1),
('CUST005', 3, 2);

SELECT * FROM customer;
SELECT * FROM customer_product;
SELECT * FROM product;

-- Q. 주문테이블에서 CUST005고객이 주문한 제품의 이름을 출력하세요.
SELECT p.product_name
FROM customer_product cp
INNER JOIN product p
ON cp.product_number = p.product_number
WHERE cp.customer_id = 'CUST005';

-- Q. 주문테이블에서 나이가 30세 이상인 고객이 주문한 제품의 번호와 주문일자를 출력하세요.
--    (제품번번호 주문일자)
SELECT cp.product_number, cp.order_date
FROM customer_product cp
INNER JOIN customer c
ON cp.customer_id = c.customer_id
WHERE c.age >= 30;

-- Q. 고객테이블에서 적립금 평균이 80원 이상인 등급에 대해 등급별 고객수와 적립금 평균을 출력
SELECT c.rating, COUNT(c.rating) AS 'cnt', ROUND(AVG(c.reserves),2) AS 'avg'
FROM customer c
GROUP BY c.rating
HAVING avg >= 80;

-- Q. 주문테이블에서 적립금이 가장 많은 고객의 고객이름과 적립금을 출력하세요.
SELECT c.customer_name, c.reserves
FROM customer c
WHERE reserves = (
	SELECT c.reserves
	FROM customer c
	ORDER BY c.reserves DESC
	LIMIT 1);

SELECT c.customer_name, c.reserves
FROM customer c
WHERE reserves IN (SELECT MAX(reserves) FROM customer);

-- Q. 주문테이블에서 'CUST005'고객이 주문한 제품의 이름과 제조업체를 출력하시오.
SELECT p.product_name, p.manufacturer
FROM customer_product cp
INNER JOIN product p
ON cp.product_number = p.product_number
WHERE cp.customer_id = 'CUST005';

 -- Q. 구매이력이 있는 customer_id 출력
SELECT DISTINCT customer_id FROM customer_product;

SELECT manufacturer, CHAR_LENGTH(manufacturer) FROM product;

SELECT * FROM customer WHERE age is NULL;

-- Q. 제품을 2개 이상 제조한 제조업체별로 제품의 개수와 제품중 가장 비싼 단가
SELECT p.manufacturer, COUNT(p.product_name) as 'cnt', MAX(p.price) as 'price'
FROM product p
GROUP BY p.manufacturer
HAVING cnt >= 2;

-- Q. 제품 C를 생산한 제조업체가 만든 제품들의 제품명과 가격을 출력
SELECT p.product_name, p.price
FROM product p
WHERE p.manufacturer = (
	SELECT p.manufacturer
	FROM product p
	WHERE p.product_name = '제품 c');

-- CUST005고객이 주문한 제품의 제품명과 제조업체를 출력하시오
SELECT p.product_name, p.manufacturer
FROM product p
WHERE p.product_number IN (
	SELECT cp.product_number
	FROM customer_product cp
	WHERE cp.customer_id = 'CUST005');
    
SELECT cp.customer_id, p.product_name, p.manufacturer
FROM product p
INNER JOIN customer_product cp
ON p.product_number = cp.product_number
WHERE cp.customer_id = 'CUST005';

-- Q. 제품의 가격을 모두 10% 인상해보자
UPDATE product SET price = price * 1.1;
SELECT * FROM product;
