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
SELECT * FROM member m INNER JOIN notice n ON m.id = n.writer_id;

SELECT * FROM member m LEFT OUTER JOIN notice n ON m.id = n.writer_id;
    -- �����Ŀ��� ����(member) ���̺��� �ƿ��͸� ���Խ�Ų��.
    -- �����ִ� notice�� ���� ��� null�� ǥ���ȴ�.

SELECT * FROM member m RIGHT OUTER JOIN notice n ON m.id = n.writer_id;
    -- �����Ŀ��� ������(notice) ���̺��� �ƿ��͸� ���Խ�Ų��

SELECT * FROM member m FULL OUTER JOIN notice n ON m.id = n.writer_id;
    -- �����Ŀ��� ���� ���̺��� �ƿ��͸� ��� ���Խ�Ų��.
    
    
    
    
    