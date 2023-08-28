-- 1-1번
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT;

-- 1-2번
SELECT DEPARTMENT_NAME ||'의 정원은', CAPACITY || '명 입니다.'
FROM TB_DEPARTMENT;

-- 1-3번
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '001'
AND ABSENCE_YN = 'Y'
AND SUBSTR(STUDENT_SSN,8,1) = '2';

-- 1-4번
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090' ,'A513091', 'A513110', 'A513119');





-- 1-7번
-- 수강 신청을 하려고 한다. 선수과목 여부를 확인해야하는데, 선수과목이 존재하는 과목들은 어떤 과목인지
-- 과목 번호를 조회하시오. 
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 2-2번
-- 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 두명 있다고 한다.
-- 그 교수의 이름과 주민번호를 조회하는 SQL을 작성하시오.

SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
--WHERE LENGTH(PROFESSOR_NAME) != 3; 
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 2-3번
-- 춘 기술대학교의 남자 교수들의 이름과 나이를 나이 오름차순으로 조회하시오. 
-- (단 교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수 이름"으로 한다.)
-- 나이는 '만'으로 계산한다. )
SELECT PROFESSOR_NAME "교수 이름" ,
     FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('19' || SUBSTR(PROFESSOR_SSN,1,6), 'YYYYMMDD')) /12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN,8,1) = '1'
ORDER BY 나이;



-- 2-5번
-- 춘 기술대학교의 재수생 입학자를 조회하시오.
-- (19살에 입학하면 재수를 하지 않은 것!)

SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT (YEAR FROM ENTRANCE_DATE) 
    - EXTRACT (TO_DATE('19'|| SUBSTR(STUDENT_SSN,1,6), 'YYYYMMDD'));
   
-- 2-7번
SELECT ROUND(AVG(POINT) ,1)평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 2-10번
SELECT SUBSTR(TERM_NO,1,4), ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);

-- 2-11번
SELECT DEPARTMENT_NO "학과코드명", 
     COUNT(DECODE(ABSENCE_YN, 'Y', 'Y')) "휴학생 수"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

SELECT DEPARTMENT_NO "학과코드명", 
     SUM(DECODE(ABSENCE_YN, 'Y',1, 'N', 0)) "휴학생 수"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;


--2-12번
SELECT STUDENT_NAME 이름, COUNT(*) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*)>1
ORDER BY STUDENT_NAME;

--2-13번
SELECT NVL(SUBSTR(TERM_NO,1,4), ' ') 년도, NVL(SUBSTR(TERM_NO,5,2), ' ') 학기, ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2));

--3-10번
SELECT STUDENT_NO 학번, STUDENT_NAME, ROUND(AVG(POINT),1) "전체 평점"
FROM TB_STUDENT 
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO, STUDENT_NAME
ORDER BY STUDENT_NO;

--3-11번
SELECT DEPARTMENT_NAME, STUDENT_NAME, PROFESSOR_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_PROFESSOR ON(COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';


--3-13번
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;

--3-15번
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, DEPARTMENT_NAME "학과 이름", ROUND(AVG(POINT),1) 평점
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING (STUDENT_NO)
WHERE ABSENCE_YN != 'Y'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4
ORDER BY 학번;

   


