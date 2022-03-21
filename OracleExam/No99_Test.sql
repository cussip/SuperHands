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
    
select count(id) from notice;

SELECT count(" + searchField + ") count FROM notice
WHERE " + searchField + " LIKE %?%;

select count(title) count from notice
where title like '%����%';
