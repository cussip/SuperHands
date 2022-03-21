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
    
select count(id) from notice;

SELECT count(" + searchField + ") count FROM notice
WHERE " + searchField + " LIKE %?%;

select count(title) count from notice
where title like '%제목%';
