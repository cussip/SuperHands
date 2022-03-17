--------------------------------------------------------------------------------
-- ORACLE JOIN
-- 오라클에서만 작동하는 JOIN 구문으로 구 버전에서 주로 사용하였다.
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
-- 오라클은 FULL OUTER JOIN을 지원하지 않는다.
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

