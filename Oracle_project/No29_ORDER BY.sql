--------------------------------------------------------------------------------
-- SELECT문의 순서: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- 순서가 바뀌어서는 안됨
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- 정렬하기(ORDER BY)
-- ASC: 오름차순(기본값), DESC: 내림차순
--------------------------------------------------------------------------------
SELECT * FROM member;
SELECT title, hit FROM notice ORDER BY hit DESC;

-- hit수가 동일한 경우의 2차 정렬(등록일자 기준)
SELECT title, hit, regdate FROM notice ORDer BY hit desc, regdate desc;

-- 회원 중에서 '이'씨 성을 가진 회원을 조회. 단 나이를 오름차순으로
SELECT * FROM member WHERE name LIKE '이%' ORDER BY age;

commit;


  




















