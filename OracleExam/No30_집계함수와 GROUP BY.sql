--------------------------------------------------------------------------------
-- SELECT���� ����: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- ������ �ٲ��� �ȵ�
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- �����Լ�: SUM, MIN, MAX, COUNT, AVG
--------------------------------------------------------------------------------
SELECT COUNT(title) FROM notice;
SELECT COUNT(id) FROM notice;
    -- null�� �������� �ʱ� ������ �÷����� ī��Ʈ�� ���̰� ���� �� �ִ�.
SELECT COUNT(*) FROM notice;
    -- ��ü �÷��� ������� �����ϱ� ������ �ӵ��� ���ϵ� �� �����Ƿ� ������(ID)
    -- ���� ��ȸ�� �����ϴ� ���� �ٶ����ϴ�.

INSERT INTO notice(id, regdate, hit, writer_id) 
VALUES (8, sysdate, 3, 'newlec');

SELECT SUM(hit) FROM notice;    -- ����
SELECT AVG(hit) FROM notice;    -- ���

SELECT writer_id, COUNT(id) ī��Ʈ FROM notice GROUP BY writer_id;
    -- writer_id �ܿ� �׷�(����)���� ���� �÷��� ����� �� ����

-- ����� �Խù��� ���ں��� ����
SELECT writer_id, COUNT(id) ī��Ʈ FROM notice GROUP BY writer_id;
    
-- ������ ������ cound(id)�� ��������, writer_id�� ������������ ����
SELECT writer_id, COUNT(id) count 
FROM notice 
GROUP BY writer_id 
ORDER BY count ASC, writer_id DESC;

--------------------------------------------------------------------------------
-- �������: FROM => CONNECT BY => WHERE => GROUP BY 
--          => HAVING => SELECT => ORDER BY
-- ��������� �� �κ��� �������� ������ ��Ī�� �� �κ��� �������� ���Ұ�
--------------------------------------------------------------------------------















