/*[요구사항]
김영희 회원과 같은 지역에 사는 회원들의 지역명, 아이디, 이름, 등급명을 이름 오름차순으로 조회
[작성한 SQL] */

SELECT AREA_NAME 지역명, MEMBER_ID 아이디, MEMBER_NAME 이름, GRADE_NAME 등급명
FROM TB_MEMBER
JOIN TB_GRADE ON(GRADE = GRADE_CODE)
JOIN TB_AREA ON (AREA_CODE = AREA_CODE)
WHERE AREA_CODE = ( SELECT AREA_CODE 
					FROM TB_MEMBER
					WHERE 이름 = '김영희')
					ORDER BY 이름 DESC;
					
SELECT AREA_NAME 지역명, MEMBER_ID 아이디, MEMBER_NAME 이름, GRADE_NAME 등급명
FROM TB_MEMBER
JOIN TB_AREA USING(AREA_CODE)
JOIN TB_GRADE ON(GRADE = GRADE_CODE)
WHERE AREA_CODE = ( SELECT AREA_CODE 
					FROM TB_MEMBER
					WHERE MEMBER_NAME = '김영희')
ORDER BY 이름;
					
-- JOIN TB_AREA ON (AREA_CODE = AREA_CODE)
-- 문제원인 : TB_MEMBER, TB_AREA JOIN 시 사용한 컬럼
-- TB_AREA가 구분되지 않아서 열의 정의 애매하다는 문제 발생
				
-- 해결 방법 : 컬림명이 같으르모 USING을 이용해서 열의 정의 애매함을 해결
-- JOIN TB_AREA USING(AREA_CODE)
				
-- 
-- 문제 원인 : 서브쿼리 문제 원인 SELECT AREA_CODE FROM TB_MEMBER WHERE 이름 ='김영희'에서
				--TB_MEMEBER테이블에 "이름" 컬럼이 없기도 하고, 해석도 안된 "이름" 이라는 컬럼명이
				-- WHERE 절에 작성해서 문제 발생 
				
-- 해결 방법 : 
-- SELECT AREA_CODE FROM TB_MEMBER WHERE MEMBER_NAME = '김영희'
				

-- 문제 원인 : 이름 오름차순을 요구했으나 DESC로 내림차순으로 되어있어서, 조회 결과가 문제
-- 해결 방법 : ORDER BY 이름; (DESC 삭제)

				
				
				
				
