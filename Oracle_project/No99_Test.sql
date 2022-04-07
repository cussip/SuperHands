SELECT *FROM notice;

INSERT INTO notice (title, writer_id, content, files) 
VALUES ('타이틀', 'ishcjswo', 'JDBC test content', ' ');

SELECT ROWNUM, notice.* FROM notice 
WHERE ROWNUM BETWEEN 1 AND 4;
    -- ROWNUM은 위와 같이 사용할 시 정상적으로 작동하지 않음.
    
SELECT * FROM (SELECT ROWNUM num, notice.* FROM notice) 
WHERE num BETWEEN 2 AND 10;
    -- 서브쿼리를 사용하여 ROWNUM을 사용한다.
    
SELECT * FROM (
    SELECT ROWNUM num, notice.* FROM notice 
    ORDER BY regdate DESC
    ) 
WHERE num BETWEEN 2 AND 10;    
    -- 작성일자 순으로 정렬하기 위해 서브쿼리에서 ORDER BY를 사용할 경우
    -- ROWNUM으로 우선 정렬된 후 ORDER BY 정렬이 발생하기 때문에 ROWNUM이 
    -- 헝클어지는 문제가 발생한다.

SELECT * FROM (
    SELECT ROWNUM num, n.* FROM (
        SELECT * FROM notice ORDER BY regdate DESC
    ) n
) 
WHERE num BETWEEN 1 AND 5;
    -- 데이터는 정상적으로 출력이 된다.
    -- 다만, 쿼리문이 길어지기 때문에 자주 사용하는 경우 뷰로 생성해둔다.

CREATE VIEW notice_view AS
SELECT * FROM (
    SELECT ROWNUM num, n.* FROM (
        SELECT * FROM notice ORDER BY regdate DESC
    ) n
);

SELECT * FROM notice_view;
    -- view 테스트
    
SELECT COUNT(id) FROM notice;

SELECT COUNT(" + searchField + ") COUNT FROM NOTICE
WHERE " + searchField + " LIKE %?%;

SELECT COUNT(TITLE) COUNT FROM NOTICE
WHERE TITLE LIKE '%제목%';

--getNoticeList
SELECT * FROM (
    SELECT ROWNUM NUM, N.* 
    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N
) 
WHERE NUM BETWEEN 1 AND 5;

--getNoticeCount

--getNotice

--getNextNotice
SELECT * FROM NOTICE
WHERE ID = (
    SELECT ID FROM NOTICE
    WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=5)
    AND ROWNUM = 1
);

--getPrevNotice
SELECT ID, REGDATE FROM NOTICE ORDER BY REGDATE DESC;

SELECT * FROM NOTICE WHERE ID = (
    SELECT ID FROM NOTICE
    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=5)
    AND ROWNUM = 1
);
-- id 12출력되어야 한다
SELECT * FROM ( 
    SELECT ID FROM NOTICE
    WHERE REGDATE < (
        SELECT REGDATE FROM NOTICE WHERE ID=5)
    ORDER BY REGDATE DESC)
WHERE ROWNUM = 1;
 
SELECT * FROM ( 
    SELECT ID FROM NOTICE
    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=5)
    ORDER BY REGDATE DESC)
WHERE ROWNUM = 1;

SELECT COUNT(*) FROM (
    SELECT ROWNUM NUM, N.* 
    FROM (
        SELECT * FROM NOTICE
        WHERE TITLE LIKE '%%'
        ORDER BY REGDATE DESC) N);
 
SELECT * FROM notice; 
 
INSERT INTO notice(title, writer_id, content, hit) 
VALUES(
    '테스트를 진행합니다.',
    'ddhr1202',
    '내용입니다.',
    0
);

-- 공지사항 리스트를 호출하는 쿼리문(코멘트 숫자 표기 포함
SELECT * FROM 
    (
        SELECT ROWNUM num, n.*
        FROM (SELECT * FROM notice
                 WHERE title LIKE '%%'
                 ORDER BY regdate DESC) n
    ) k, 
    (
        SELECT notice_id, COUNT(*) cmt FROM "COMMENT"
        GROUP BY notice_id
    ) r
WHERE k.id = r.notice_id(+)
AND num BETWEEN 1 AND 10;

SELECT notice_id, COUNT(*) FROM "COMMENT" GROUP BY notice_id;

SELECT * FROM notice n 
    LEFT JOIN (
        SELECT notice_id, COUNT(*) cmt 
        FROM "COMMENT" 
        GROUP BY notice_id
        ) m 
    ON n.id = m.notice_id
WHERE n.id = 234;

CREATE VIEW notice_cmt_view
AS
SELECT n.id, n.title, n.writer_id, n.regdate, n.hit, n.files, COUNT(c.id) cmt
FROM notice n
LEFT JOIN "COMMENT" c ON n.id = c.notice_id
GROUP BY n.id, n.title, n.writer_id, n.regdate, n.hit, n.files;

--getNoticeList(CMT)
SELECT * FROM (
    SELECT ROWNUM num, n.* 
    FROM (SELECT * FROM notice_cmt_view ORDER BY regdate DESC) n
) 
WHERE num BETWEEN 1 AND 5;

SELECT id, title, pub FROM notice where id > 225;

INSERT INTO NOTICE(title, content, writer_id, pub)
values ('테스트 제목', '테스트 내용', 'ishcjswo', 1);
commit;

SELECT * FROM 
    (  
    SELECT ROWNUM NUM, N.*  FROM 
        (
        SELECT * FROM NOTICE_CMT_VIEW  
        WHERE title LIKE '%%' 
        ORDER BY REGDATE DESC
        ) N
    WHERE pub = 1
    )  
WHERE NUM BETWEEN 1 AND 10  ;


