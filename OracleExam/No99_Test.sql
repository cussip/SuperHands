SELECT *FROM notice;

INSERT INTO notice (title, writer_id, content, files) 
VALUES ('Ÿ��Ʋ', 'ishcjswo', 'JDBC test content', ' ');

SELECT ROWNUM, notice.* FROM notice 
WHERE ROWNUM BETWEEN 1 AND 4;
    -- ROWNUM�� ���� ���� ����� �� ���������� �۵����� ����.
    
SELECT * FROM (SELECT ROWNUM num, notice.* FROM notice) 
WHERE num BETWEEN 2 AND 10;
    -- ���������� ����Ͽ� ROWNUM�� ����Ѵ�.
    
SELECT * FROM (
    SELECT ROWNUM num, notice.* FROM notice 
    ORDER BY regdate DESC
    ) 
WHERE num BETWEEN 2 AND 10;    
    -- �ۼ����� ������ �����ϱ� ���� ������������ ORDER BY�� ����� ���
    -- ROWNUM���� �켱 ���ĵ� �� ORDER BY ������ �߻��ϱ� ������ ROWNUM�� 
    -- ��Ŭ������ ������ �߻��Ѵ�.

SELECT * FROM (
    SELECT ROWNUM num, n.* FROM (
        SELECT * FROM notice ORDER BY regdate DESC
    ) n
) 
WHERE num BETWEEN 1 AND 5;
    -- �����ʹ� ���������� ����� �ȴ�.
    -- �ٸ�, �������� ������� ������ ���� ����ϴ� ��� ��� �����صд�.

CREATE VIEW notice_view AS
SELECT * FROM (
    SELECT ROWNUM num, n.* FROM (
        SELECT * FROM notice ORDER BY regdate DESC
    ) n
);

SELECT * FROM notice_view;
    -- view �׽�Ʈ
    
SELECT COUNT(id) FROM notice;

SELECT COUNT(" + searchField + ") COUNT FROM NOTICE
WHERE " + searchField + " LIKE %?%;

SELECT COUNT(TITLE) COUNT FROM NOTICE
WHERE TITLE LIKE '%����%';

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
-- id 12��µǾ�� �Ѵ�
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
    '�׽�Ʈ�� �����մϴ�.',
    'ddhr1202',
    '�����Դϴ�.',
    0
);

-- �������� ����Ʈ�� ȣ���ϴ� ������(�ڸ�Ʈ ���� ǥ�� ����
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
values ('�׽�Ʈ ����', '�׽�Ʈ ����', 'ishcjswo', 1);
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


