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
SELECT * FROM member m INNER JOIN notice n ON m.id = n.writer_id;

SELECT * FROM member m LEFT OUTER JOIN notice n ON m.id = n.writer_id;
    -- 쿼리식에서 왼쪽(member) 테이블의 아우터를 포함시킨다.
    -- 관계있는 notice가 없는 경우 null로 표현된다.

SELECT * FROM member m RIGHT OUTER JOIN notice n ON m.id = n.writer_id;
    -- 쿼리식에서 오른쪽(notice) 테이블의 아우터를 포함시킨다

SELECT * FROM member m FULL OUTER JOIN notice n ON m.id = n.writer_id;
    -- 쿼리식에서 양쪽 테이블의 아우터를 모두 포함시킨다.
    
    
    
    
    