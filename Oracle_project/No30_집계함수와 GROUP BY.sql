--------------------------------------------------------------------------------
-- SELECT문의 순서: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- 순서가 바뀌어서는 안됨
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- 집계함수: SUM, MIN, MAX, COUNT, AVG
--------------------------------------------------------------------------------
SELECT COUNT(title) FROM notice;
SELECT COUNT(id) FROM notice;
    -- null은 집계하지 않기 때문에 컬럼별로 카운트에 차이가 있을 수 있다.
SELECT COUNT(*) FROM notice;
    -- 전체 컬럼을 대상으로 집계하기 때문에 속도가 저하될 수 있으므로 고유값(ID)
    -- 으로 조회를 진행하는 것이 바람직하다.

INSERT INTO notice(id, regdate, hit, writer_id) 
VALUES (8, sysdate, 3, 'newlec');

SELECT SUM(hit) FROM notice;    -- 총합
SELECT AVG(hit) FROM notice;    -- 평균

SELECT writer_id, COUNT(id) 카운트 FROM notice GROUP BY writer_id;
    -- writer_id 외에 그룹(집계)되지 않은 컬럼은 사용할 수 없다

-- 등록한 게시물의 숫자별로 집계
SELECT writer_id, COUNT(id) 카운트 FROM notice GROUP BY writer_id;
    
-- 집계한 내용을 cound(id)의 오름차순, writer_id의 내림차순으로 정렬
SELECT writer_id, COUNT(id) count 
FROM notice 
GROUP BY writer_id 
ORDER BY count ASC, writer_id DESC;

--------------------------------------------------------------------------------
-- 실행순서: FROM => CONNECT BY => WHERE => GROUP BY 
--          => HAVING => SELECT => ORDER BY
-- 실행순서가 뒷 부분인 구문에서 지정한 별칭은 앞 부분의 구문에서 사용불가
--------------------------------------------------------------------------------















