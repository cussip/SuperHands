--------------------------------------------------------------------------------
-- SELECT���� ����: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- ������ �ٲ��� �ȵ�

-- �����Լ�: SUM, MIN, MAX, COUNT, AVG

-- �������: FROM => CONNECT BY => WHERE => GROUP BY 
--          => HAVING => SELECT => ORDER BY
-- ��������� �� �κ��� �������� ������ ��Ī�� �� �κ��� �������� ���Ұ�
--------------------------------------------------------------------------------

-- ȸ���� �Խñ� ���� ��ȸ. ��, �Խñ��� 2������ ���ڵ常 ���
SELECT * FROM notice;

SELECT writer_id, COUNT(id) count FROM notice 
WHERE COUNT(id) <= 2
GROUP BY writer_id 
ORDER BY writer_id DESC;
    -- �����Լ��� GROUP BY ���Ŀ����� ��� �����ѵ�, WHERE������ �����Լ���
    -- ������ �ο��Ͽ��� ������ ���������� �۵����� ���絥.

SELECT writer_id, COUNT(id) count FROM notice 
GROUP BY writer_id 
HAVING COUNT(id) <= 2
ORDER BY writer_id DESC;












