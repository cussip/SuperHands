--------------------------------------------------------------------------------
-- JOIN
-- 참조관계에 있는 테이블을 합치는 작업
-- INNER JOIN, OUTER JOIN, SELF JOIN, CROSS JOIN(Cartesian Product)
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
-- OUTER JOIN
-- 참조키를 기준으로 일치하지 않는 행도 포함시키는 조인
-- '' (LEFT/RIGHT/FULL)OUTER JOIN '' ON "" = "";
--------------------------------------------------------------------------------

--회원별 작성한 게시글 수를 조회
SELECT m.id, m.name, COUNT(n.id) 
FROM member m INNER JOIN notice n ON m.id = n.writer_id
GROUP BY m.id, m.name;
    -- 게시글이 0인 회원은 조회되지 않은 상태
    
SELECT m.id, m.name, COUNT(n.id) 
FROM member m LEFT OUTER JOIN notice n ON m.id = n.writer_id
GROUP BY m.id, m.name;
    -- 핵심이 되는 요소를 파악하여 해당 요소는 전부 포함될 수 있도록
    -- OUTER JOIN 하는 것이 일반적으로 더 적합한 데이터라고 할 수 있다.
    
    
    
    