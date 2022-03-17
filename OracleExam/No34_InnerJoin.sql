--------------------------------------------------------------------------------
-- JOIN
-- �������迡 �ִ� ���̺��� ��ġ�� �۾�
-- INNER JOIN, OUTER JOIN, SELF JOIN, CROSS JOIN(Cartesian Product)
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- INNER JOIN
-- ���谡 �ִ� ��ҵ� ������ ����
-- '' INNER JOIN '' ON "" = "";
--------------------------------------------------------------------------------

-- ANSI SQL�� ǥ�ع���� ���� ���
SELECT * FROM member 
INNER JOIN notice ON member.id = notice.writer_id;

SELECT m.name, n.title, n.content
FROM member m INNER JOIN notice n ON m.id = n.writer_id;


