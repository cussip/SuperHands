--------------------------------------------------------------------------------
-- SELECT문의 순서: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- 순서가 바뀌어서는 안됨
--------------------------------------------------------------------------------
SELECT ROWNUM, id, title, writer_id, regdate, hit
FROM notice
ORDER BY hit; 
    -- ROWNUM은 WHERE절에서 생성되기 때문에 ORDER BY에서 정렬하면서 순서가 섞임
    -- ORDER BY 이후에 순번을 다시 부여할 수 있어야 한다.

--------------------------------------------------------------------------------    
-- ROW_NUMBER: 일련번호를 부여 (중복 불가)
--------------------------------------------------------------------------------
SELECT ROW_NUMBER() OVER (ORDER BY hit) rn, id, title, writer_id, regdate, hit
FROM notice;

--------------------------------------------------------------------------------    
-- RANK: 일반적인 랭킹을 부여
--------------------------------------------------------------------------------
SELECT RANK() OVER (ORDER BY hit) rank, id, title, writer_id, regdate, hit
FROM notice;
    
--------------------------------------------------------------------------------
-- DENSE_RANK: 랭킹을 부여하되, 동일 순위 이후에 순번을 연속적으로 부여 
--------------------------------------------------------------------------------
SELECT DENSE_RANK() OVER (ORDER BY hit) rank, id, title, writer_id, regdate, hit
FROM notice;

--------------------------------------------------------------------------------
-- PARTITION BY: 그룹별로 정렬 
--------------------------------------------------------------------------------
SELECT RANK() OVER (PARTITION BY writer_id ORDER BY hit) rank
        , id
        , title
        , writer_id
        , regdate
        , hit
FROM notice;

SELECT ROW_NUMBER() OVER (PARTITION BY writer_id ORDER BY hit) rank
            , writer_id, title 
FROM notice;  












