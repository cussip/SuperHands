CREATE TABLE member (
    id       VARCHAR2(50),
    pwd      NVARCHAR2(50),
    name     NVARCHAR2(50),
    -- gender   CHAR(2),        -- 2바이트만 입력 가능하여 한글 입력 불가
    -- gender   CHAR(2 CHAR),   -- 한글 입력은 가능하나 6바이트의 공간을 사용
    gender   NCHAR(2),          -- 4바이트 공간을 사용하면서 한글 사용 가능
    age      NUMBER(3),
    birthday CHAR(10),
    phone    CHAR(13),
    regdate  DATE
);

DROP TABLE member;

INSERT INTO member ( gender ) VALUES ( '남성' );

SELECT
    lengthb(gender)
FROM
    member;

ALTER TABLE member MODIFY
    id NVARCHAR2(50);
ALTER TABLE member DROP COLUMN age;
ALTER TABLE member ADD email VARCHAR2(200);

CREATE TABLE notice (
    id        NUMBER,
    title     NVARCHAR2(100),
    writer_id NVARCHAR2(50),
    content   CLOB,
    regdate   TIMESTAMP,
    hit       NUMBER,
    files     NVARCHAR2(100)
);

CREATE TABLE role (
    id          VARCHAR2(50),
    discription NVARCHAR2(500)
);

CREATE TABLE member_role (
    member_id NVARCHAR2(50),
    role_id   VARCHAR2(50)
);

CREATE TABLE "COMMENT" (
    id        NUMBER,
    content   NVARCHAR2(2000),
    regdate   TIMESTAMP,
    writer_id NVARCHAR2(50),
    notice_id NUMBER
);

INSERT INTO member (
    id,
    pwd
) VALUES (
    'newlec',
    '111'
);

SELECT
    *
FROM
    member;

INSERT INTO member (
    id,
    pwd
) VALUES (
    'test2',
    '1321'
);

SELECT
    id AS user_id,
    name new_name,
    pwd  "P W D"
FROM
    member;

UPDATE member
SET
    pwd = '222';

UPDATE member
SET
    pwd = '333',
    name = '손오공'
WHERE
    id = 'dragon';

DELETE member WHERE id = 'test2';

select * from member;

insert into member values(
    'newlecking',
    '123',
    '뉴렉킹',
    '여',
    '19990102',
    '01012345678',
    '2022-03-11',
    'newlecking@newlecking.kr'
);
    
select * from member where name like '손%';
select * from member where name like '%수%';
select * from member where name like '손%';
select * from member where name like '뉴_';
select * from member where name like '%렉_';

SELECT * FROM notice;

-- 전화번호의 정규식 생성
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}$');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '01[016-9]-\d{3,4}-\d{4}');
UPDATE notice SET notice.title = '010-5515-8139 변경성공' 
    WHERE title = '마지막 글';
UPDATE notice SET notice.content = 'ishcjswo@naver.com 변경성공' 
    WHERE id IN (4, 5);    

-- 이메일의 정규식 (abc11@abc11.com)
-- \w+@\w+.(ORG|NET|COM)       -- 숫자로 시작하는 내용도 검색되는 문제
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(ORG|NET|COM)');
-- \D\w*@\D\w*.(ORG|NET|COM)   -- 첫 글자는 영문자로 제한
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(org|net|com)');

SELECT * FROM member;

SELECT * FROM member WHERE ROWNUM BETWEEN 1 AND 2;
    -- 1 ~ 2까지 출력

SELECT * FROM member WHERE ROWNUM BETWEEN 3 AND 5;
    -- 아무런 데이터도 출력되지 않음
    -- ROWNUM은 항상 1이 고정된 상태에서 데이터를 가져와서 비교하기 때문에
    -- 1을 초과하는 값은 비교가 정상적으로 이루어지지 않음
    -- ROWNUM은 데이터가 원래 가지고 있는 값이 아닌 결과 집합이 만들어질때
    -- 부여되는 순번이기 때문에 발생하는 문제
    
SELECT * FROM (
    SELECT ROWNUM num, member.* FROM member
    )
WHERE num BETWEEN 3 AND 5;
    -- 서브쿼리를 이용하여 ROWNUM을 고정시킨 후 사용
    -- ROWNUM에 따라 이미 순번이 부여되어있기 때문에 자유롭게 순번을 사용하여
    -- SELECT를 사용할 수 있다.
    -- ROWNUM은 조회할 때마다 생성되기 때문에,
    -- 이용하려는 ROWNUM에는 별칭을 부여하여야 정상적인 사용이 가능하다.
    





