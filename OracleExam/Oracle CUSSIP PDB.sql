CREATE TABLE member (
    id       VARCHAR2(50),
    pwd      NVARCHAR2(50),
    name     NVARCHAR2(50),
    -- gender   CHAR(2),        -- 2����Ʈ�� �Է� �����Ͽ� �ѱ� �Է� �Ұ�
    -- gender   CHAR(2 CHAR),   -- �ѱ� �Է��� �����ϳ� 6����Ʈ�� ������ ���
    gender   NCHAR(2),          -- 4����Ʈ ������ ����ϸ鼭 �ѱ� ��� ����
    age      NUMBER(3),
    birthday CHAR(10),
    phone    CHAR(13),
    regdate  DATE
);

DROP TABLE member;

INSERT INTO member ( gender ) VALUES ( '����' );

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
    name = '�տ���'
WHERE
    id = 'dragon';

DELETE member WHERE id = 'test2';

select * from member;

insert into member values(
    'newlecking',
    '123',
    '����ŷ',
    '��',
    '19990102',
    '01012345678',
    '2022-03-11',
    'newlecking@newlecking.kr'
);
    
select * from member where name like '��%';
select * from member where name like '%��%';
select * from member where name like '��%';
select * from member where name like '��_';
select * from member where name like '%��_';

SELECT * FROM notice;

-- ��ȭ��ȣ�� ���Խ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}$');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '01[016-9]-\d{3,4}-\d{4}');
UPDATE notice SET notice.title = '010-5515-8139 ���漺��' 
    WHERE title = '������ ��';
UPDATE notice SET notice.content = 'ishcjswo@naver.com ���漺��' 
    WHERE id IN (4, 5);    

-- �̸����� ���Խ� (abc11@abc11.com)
-- \w+@\w+.(ORG|NET|COM)       -- ���ڷ� �����ϴ� ���뵵 �˻��Ǵ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(ORG|NET|COM)');
-- \D\w*@\D\w*.(ORG|NET|COM)   -- ù ���ڴ� �����ڷ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(org|net|com)');

SELECT * FROM member;

SELECT * FROM member WHERE ROWNUM BETWEEN 1 AND 2;
    -- 1 ~ 2���� ���

SELECT * FROM member WHERE ROWNUM BETWEEN 3 AND 5;
    -- �ƹ��� �����͵� ��µ��� ����
    -- ROWNUM�� �׻� 1�� ������ ���¿��� �����͸� �����ͼ� ���ϱ� ������
    -- 1�� �ʰ��ϴ� ���� �񱳰� ���������� �̷������ ����
    -- ROWNUM�� �����Ͱ� ���� ������ �ִ� ���� �ƴ� ��� ������ ���������
    -- �ο��Ǵ� �����̱� ������ �߻��ϴ� ����
    
SELECT * FROM (
    SELECT ROWNUM num, member.* FROM member
    )
WHERE num BETWEEN 3 AND 5;
    -- ���������� �̿��Ͽ� ROWNUM�� ������Ų �� ���
    -- ROWNUM�� ���� �̹� ������ �ο��Ǿ��ֱ� ������ �����Ӱ� ������ ����Ͽ�
    -- SELECT�� ����� �� �ִ�.
    -- ROWNUM�� ��ȸ�� ������ �����Ǳ� ������,
    -- �̿��Ϸ��� ROWNUM���� ��Ī�� �ο��Ͽ��� �������� ����� �����ϴ�.
    





