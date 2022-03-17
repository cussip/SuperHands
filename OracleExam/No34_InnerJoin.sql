--------------------------------------------------------------------------------
-- JOIN
-- 참조관계에 있는 테이블을 합치는 작업
-- INNER JOIN, OUTER JOIN, SELF JOIN, CROSS JOIN(Cartesian Product)
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- INNER JOIN
-- 관계가 있는 요소들 끼리만 결합
-- '' INNER JOIN '' ON "" = "";
--------------------------------------------------------------------------------

-- ANSI SQL의 표준방식의 조인 방법
SELECT * FROM member 
INNER JOIN notice ON member.id = notice.writer_id;

SELECT m.name, n.title, n.content
FROM member m INNER JOIN notice n ON m.id = n.writer_id;


