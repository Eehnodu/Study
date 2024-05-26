CREATE DATABASE JDBCTEST;

CREATE TABLE bigdatamember(
	id varchar(50) primary key not null,
    pw varchar(100) not null,
    b_name varchar(50) not null,
    age int,
    scrore int
);
commit;

SELECT * FROM jdbctest.bigdatamember;

INSERT INTO jdbctest.bigdatamember VALUES ("smhrd", "12345", "가나다", 20 ,0);
INSERT INTO jdbctest.bigdatamember VALUES ("1", "1", "일", 1 ,100);

DELETE FROM jdbctest.bigdatamember where id = '1';
set sql_safe_updates=0;

UPDATE jdbctest.bigdatamember SET score = 2 where id = 2;
commit;