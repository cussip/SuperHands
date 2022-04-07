--------------------------------------------------------------------------------
-- VIEW
-- 필요에 따라 테이블을 가공하여 만들어두는 임시 테이블
--------------------------------------------------------------------------------
SELECT * FROM member;
SELECT * FROM notice;

SELECT m.name, m.id, b.id boss, n.title
FROM member m LEFT JOIN member b ON m.boss_id = b.id
LEFT JOIN notice n ON m.id = n.writer_id;

-- 뷰 생성
CREATE VIEW total_view AS 
    SELECT m.name, m.id, b.id boss, n.title
    FROM member m LEFT JOIN member b ON m.boss_id = b.id
    LEFT JOIN notice n ON m.id = n.writer_id;
    
SELECT * FROM total_view;





