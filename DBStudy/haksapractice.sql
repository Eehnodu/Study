INSERT INTO department (department_name) VALUES
('컴퓨터공학과'),
('국어국문과'),
('정보통신과'),
('전자공학과');

INSERT INTO Student (student_name, student_height, department_code) VALUES
('가길동', 170.5, 1),
('나길동', 165.2, 1),
('다길동', 180.0, 2),
('라길동', 175.8, 3),
('마길동', 160.7, 4),
('바길동', 168.3, 1),
('사길동', 172.1, 2),
('아길동', 175.0, 1);

INSERT INTO Professor (professor_name, department_code) VALUES
('가 교수', 1),
('나 교수', 1),
('다 교수', 2),
('빌 게이츠', 3),
('스티브 잡스', 4);

INSERT INTO Course (course_name, professor_code, start_date, end_date) VALUES
('교양 영어', 1, '2023-07-01', '2023-08-15'),
('데이터베이스 입문', 2, '2023-07-01', '2023-08-31'),
('회로이론', 3, '2023-07-15', '2023-09-15'),
('공학수학', 4, '2023-07-15', '2023-09-30'),
('객체지향 프로그래밍', 5, '2023-07-01', '2023-08-31');

INSERT INTO Student_Course (student_id, course_code) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 5);

SELECT t.student_name, d.department_name
FROM student t
left join department d
on t.department_code = d.department_code;

SELECT d.department_name, COUNT(s.department_code) AS 'cnt'
FROM department d
INNER JOIN student s
on d.department_code = s.department_code
GROUP BY s.department_code
HAVING cnt>=2;

SELECT s.student_name, d.department_name
FROM student s
INNER JOIN department d
ON	s.department_code = d.department_code 
WHERE d.department_name='국어국문과';

SELECT s.student_name, d.department_name
FROM student s
INNER JOIN department d
ON	s.department_code = d.department_code 
WHERE s.student_name LIKE '%길%';

SELECT *
FROM student s
WHERE student_height BETWEEN 170 AND 180
ORDER BY student_height DESC;

SELECT *
FROM student s
ORDER BY student_height DESC
LIMIT 1;

INSERT INTO department (department_name) VALUES
('수학'),
('국문과'),
('정보통신과'),
('모바일공학');
-- 학생
INSERT INTO Student (student_name, student_height, 
department_code) VALUES
('가길동', 170.5, 1),
('나길동', 165.2, 1),
('다길동', 180.0, 2),
('라길동', 175.8, 3),
('마길동', 160.7, 4),
('바길동', 168.3, 1),
('사길동', 172.1, 2),
('아길동', 175.0, 1);
-- 교수
INSERT INTO Professor (professor_name, department_code) VALUES
('가 교수', 1),
('나 교수', 1),
('다 교수', 2),
('빌 게이츠', 3),
('스티브 잡스', 4);
-- 개설과목
INSERT INTO Course (course_name, professor_code, start_date, 
end_date) VALUES
('교양 영어', 1, '2023-07-01', '2023-08-15'),
('데이터베이스 입문', 2, '2023-07-01', '2023-08-31'),
('회로이론', 3, '2023-07-15', '2023-09-15'),
('공학수학', 4, '2023-07-15', '2023-09-30'),
('객체지향 프로그래밍', 5, '2023-07-01', '2023-08-31');
-- 수강
INSERT INTO Student_Course (id, student_id, course_code) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 5, 4),
(6, 6, 5),
(7, 7, 5);

SELECT d.department_name, p.professor_name
FROM department d
INNER JOIN professor p
ON d.department_code = p.department_code
WHERE d.department_name = '컴퓨터공학과';

SELECT d.department_name, COUNT(p.professor_name) as 'total'
FROM professor p
INNER JOIN department d
ON d.department_code = p.department_code
GROUP BY d.department_name;

SELECT d.department_name, COUNT(p.professor_name) as 'total'
FROM professor p
INNER JOIN department d
ON d.department_code = p.department_code
GROUP BY d.department_name
HAVING total >= 2;

SELECT d.department_name, COUNT(s.department_code) as 'MAX'
FROM student s
INNER JOIN department d
ON s.department_code = d.department_code
GROUP BY s.department_code
ORDER BY MAX DESC
LIMIT 1;

SELECT department_name
FROM department
WHERE department_code = (
	SELECT department_code
	FROM student
	GROUP BY department_code
	HAVING COUNT(department_code) = 
		(SELECT count(department_code) AS 'cnt'
		FROM student
		GROUP BY department_code
		ORDER BY cnt DESC
		LIMIT 1)
	);

SELECT d.department_name, s.student_name
FROM student s
INNER JOIN department d
ON d.department_code = s.department_code
WHERE s.student_name LIKE '아%';

SELECT COUNT(s.student_id) AS 'total'
FROM student s
WHERE s.student_height >= 175 AND s.student_height <= 180;

SELECT s.student_name
FROM student s
WHERE s.department_code =(
	SELECT s.department_code
	FROM student s
	WHERE s.student_name = '다길동');

SELECT d.department_name, MAX(s.student_height) AS 'max' , ROUND(AVG(s.student_height),2) AS 'avg'
FROM student s
INNER JOIN department d
ON d.department_code = s.department_code
GROUP BY d.department_name;

SELECT c.course_name, p.professor_name
FROM course c
INNER JOIN professor p
ON p.professor_code = c.professor_code
WHERE p.professor_name='빌 게이츠';

SELECT c.course_name, count(sc.id) as 'cnt'
FROM course c
INNER JOIN student_course sc
ON c.course_code = sc.course_code
GROUP BY c.course_name
HAVING cnt >= 2
ORDER BY c.course_name ASC;

SELECT s.student_name
FROM student s
INNER JOIN student_course sc
ON s.student_id = sc.student_id
WHERE sc.student_id = (
	SELECT sc.student_id
	FROM course c
	INNER JOIN student_course sc
	ON c.course_code = sc.course_code
	WHERE c.professor_code = (
		SELECT p.professor_code
		FROM professor p
		INNER JOIN course c
		ON p.professor_code = c.professor_code
		WHERE p.professor_name = '빌 게이츠'));
        
SELECT d.department_name, A.student_name
FROM department d
INNER JOIN (
	SELECT s.department_code, s.student_name
	FROM student s
	WHERE s.student_id IN (
		SELECT sc.student_id
		FROM course c
		INNER JOIN student_course sc
		ON c.course_code = sc.course_code
		WHERE c.course_code = (
			SELECT c.course_code
			FROM course c
			INNER JOIN student_course sc
			ON c.course_code = sc.course_code
			WHERE c.professor_code = (
				SELECT p.professor_code
				FROM professor p
				INNER JOIN course c
				ON p.professor_code = c.professor_code
				WHERE p.professor_name = '스티브 잡스')
				LIMIT 1)))A
ON A.department_code = d.department_code; 

SELECT s.student_name
FROM student s
WHERE s.student_id IN(
	SELECT sc.student_id
	FROM student_course sc
	WHERE sc.course_code IN(
		SELECT sc.course_code
		FROM student_course sc
		WHERE sc.student_id IN (
			SELECT s.student_id
			FROM student s
			WHERE s.student_name = '사길동')));