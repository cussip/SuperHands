--------------------------------------------------------------------------------
-- VIEW
-- �ʿ信 ���� ���̺��� �����Ͽ� �����δ� �ӽ� ���̺�
--------------------------------------------------------------------------------
SELECT * FROM member;
SELECT * FROM notice;

SELECT m.name, m.id, b.id boss, n.title
FROM member m LEFT JOIN member b ON m.boss_id = b.id
LEFT JOIN notice n ON m.id = n.writer_id;

-- �� ����
CREATE VIEW total_view AS 
    SELECT m.name, m.id, b.id boss, n.title
    FROM member m LEFT JOIN member b ON m.boss_id = b.id
    LEFT JOIN notice n ON m.id = n.writer_id;
    
SELECT * FROM total_view;





