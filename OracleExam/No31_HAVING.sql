--------------------------------------------------------------------------------
-- SELECT문의 순서: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- 순서가 바뀌어서는 안됨

-- 집계함수: SUM, MIN, MAX, COUNT, AVG

-- 실행순서: FROM => CONNECT BY => WHERE => GROUP BY 
--          => HAVING => SELECT => ORDER BY
-- 실행순서가 뒷 부분인 구문에서 지정한 별칭은 앞 부분의 구문에서 사용불가
--------------------------------------------------------------------------------

-- 회원별 게시글 수를 조회. 단, 게시글이 2이하인 레코드만 출력
SELECT * FROM notice;

SELECT writer_id, COUNT(id) count FROM notice 
WHERE COUNT(id) <= 2
GROUP BY writer_id 
ORDER BY writer_id DESC;
    -- 집계함수는 GROUP BY 이후에서만 사용 가능한데, WHERE절에서 집계함수로
    -- 조건을 부여하였기 때문에 정상적으로 작동하지 안흔데.

SELECT writer_id, COUNT(id) count FROM notice 
GROUP BY writer_id 
HAVING COUNT(id) <= 2
ORDER BY writer_id DESC;












