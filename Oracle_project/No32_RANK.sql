--------------------------------------------------------------------------------
-- SELECT���� ����: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
-- ������ �ٲ��� �ȵ�
--------------------------------------------------------------------------------
SELECT ROWNUM, id, title, writer_id, regdate, hit
FROM notice
ORDER BY hit; 
    -- ROWNUM�� WHERE������ �����Ǳ� ������ ORDER BY���� �����ϸ鼭 ������ ����
    -- ORDER BY ���Ŀ� ������ �ٽ� �ο��� �� �־�� �Ѵ�.

--------------------------------------------------------------------------------    
-- ROW_NUMBER: �Ϸù�ȣ�� �ο� (�ߺ� �Ұ�)
--------------------------------------------------------------------------------
SELECT ROW_NUMBER() OVER (ORDER BY hit) rn, id, title, writer_id, regdate, hit
FROM notice;

--------------------------------------------------------------------------------    
-- RANK: �Ϲ����� ��ŷ�� �ο�
--------------------------------------------------------------------------------
SELECT RANK() OVER (ORDER BY hit) rank, id, title, writer_id, regdate, hit
FROM notice;
    
--------------------------------------------------------------------------------
-- DENSE_RANK: ��ŷ�� �ο��ϵ�, ���� ���� ���Ŀ� ������ ���������� �ο� 
--------------------------------------------------------------------------------
SELECT DENSE_RANK() OVER (ORDER BY hit) rank, id, title, writer_id, regdate, hit
FROM notice;

--------------------------------------------------------------------------------
-- PARTITION BY: �׷캰�� ���� 
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












