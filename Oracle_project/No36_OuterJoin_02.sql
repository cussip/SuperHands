--------------------------------------------------------------------------------
-- JOIN
-- �������迡 �ִ� ���̺��� ��ġ�� �۾�
-- INNER JOIN, OUTER JOIN, SELF JOIN, CROSS JOIN(Cartesian Product)
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
-- OUTER JOIN
-- ����Ű�� �������� ��ġ���� �ʴ� �൵ ���Խ�Ű�� ����
-- '' (LEFT/RIGHT/FULL)OUTER JOIN '' ON "" = "";
--------------------------------------------------------------------------------

--ȸ���� �ۼ��� �Խñ� ���� ��ȸ
SELECT m.id, m.name, COUNT(n.id) 
FROM member m INNER JOIN notice n ON m.id = n.writer_id
GROUP BY m.id, m.name;
    -- �Խñ��� 0�� ȸ���� ��ȸ���� ���� ����
    
SELECT m.id, m.name, COUNT(n.id) 
FROM member m LEFT OUTER JOIN notice n ON m.id = n.writer_id
GROUP BY m.id, m.name;
    -- �ٽ��� �Ǵ� ��Ҹ� �ľ��Ͽ� �ش� ��Ҵ� ���� ���Ե� �� �ֵ���
    -- OUTER JOIN �ϴ� ���� �Ϲ������� �� ������ �����Ͷ�� �� �� �ִ�.
    
    
    
    