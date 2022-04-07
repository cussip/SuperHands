--------------------------------------------------------------------------------
-- ORACLE JOIN
-- ����Ŭ������ �۵��ϴ� JOIN �������� �� �������� �ַ� ����Ͽ���.
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- INNER JOIN
--------------------------------------------------------------------------------
SELECT m.name, n.*
FROM member m INNER JOIN notice n ON m.id = n.writer_id
WHERE m.id = 'newlec';

SELECT m.name, n.*
FROM member m, notice n
WHERE m.id = n.writer_id AND m.id = 'newlec';


--------------------------------------------------------------------------------
-- OUTER JOIN
-- ����Ŭ�� FULL OUTER JOIN�� �������� �ʴ´�.
--------------------------------------------------------------------------------
SELECT m.name, n.* 
FROM member m LEFT JOIN notice n ON m.id = n.writer_id;

SELECT m.name, n.*
FROM member m, notice n
WHERE m.id = n.writer_id(+);


--------------------------------------------------------------------------------
-- CROSS JOIN
--------------------------------------------------------------------------------
SELECT m.name, n.* 
FROM member m CROSS JOIN notice n;

SELECT m.name, n.*
FROM member m, notice n;

