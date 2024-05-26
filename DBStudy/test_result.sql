-- 문제 4
INSERT INTO t_cus (customer_id, customer_name, address) VALUES
(1, '가길동', '수원시'), (2, '나길동', '안산시'), (3, '조길동', '서울시'), (4, '홍길동', '안양시');

INSERT INTO t_order (order_id, product_name, quantity, price, customer_id) VALUES
(101, '사과', 2, 300, 1), (102, '우류', 3, 200, 1),
(103, '시금치', 4, 100, 2), (104, '콜라', 7, 200, 2),
(105, '두부', 5, 300, 3), (106, '햄버거', 2, 200, 3),
(107, '빵', 3, 100, 3), (108, '감자', 1, 200, 3),
(109, '오이', 5, 200, 4);

-- 문제 5
SELECT c.customer_id, c.customer_name, o.product_name, o.quantity, o.price
FROM t_cus c
LEFT JOIN t_order o ON c.customer_id = o.customer_id
WHERE c.customer_id = 3;

-- 문제 6
SELECT SUM(o.price) AS 'total'
FROM t_order o
WHERE o.customer_id = 2;

-- 문제 7
SELECT o.customer_id, SUM(o.price) AS 'price'
FROM t_order o
GROUP BY o.customer_id;

-- 문제 8
SELECT *
FROM t_cus c
ORDER BY c.customer_name DESC;

-- 문제 9
UPDATE t_cus SET customer_name = '홍길순', address = '인천시' WHERE customer_id=4; 

-- 문제 10
SELECT o.order_id, o.product_name
FROM t_order o
WHERE CHAR_LENGTH(o.product_name) >=3;