--------------------------------------------------------------------------------
-- ������ ��������
-- �÷����� ��ȿ�� ���� ������ �����ϴ� ��

-- �Ӽ��� �������� �ƴ� ���� �� �� ������ �ϴ� ���� ����
-- NOT NULL: NULL ���� �� �� ����.
-- DEFAULT: �ƹ��� �����͸� �Է����� ���� ��� �⺻���� ���޵Ǵ� ��(��¥ ��)
-- CHECK: ������ ������ üũ�ϴ� ������ ����
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- NOT NULL, DEFAULT
-- �ַܼ� �Էµ� ���������� �Ϲ����� ����� ���� ����� ����ϴ� ���� �Ϲ���
--------------------------------------------------------------------------------
ALTER TABLE member MODIFY pwd NVARCHAR2(50) NOT NULL;
ALTER TABLE member MODIFY pwd NVARCHAR2(50) DEFAULT 1234;

INSERT INTO notice (
    id, 
    title, 
    writer_id, 
    content, 
    hit
) VALUES (
    50, 
    'new_title', 
    'ishcjswo', 
    '���� ������ ����', 
    20
);

SELECT * FROM notice;

--------------------------------------------------------------------------------
-- CHECK
-- �ַܼ� �Էµ� ���������� �Ϲ����� ����� ���� ����� ����ϴ� ���� �Ϲ���
--------------------------------------------------------------------------------
-- ���̺� ������ ���� ����
CREATE TABLE test (
    id VARCHAR2(50) NULL,
    phone VARCHAR2(200) CHECK(phone LIKE '010-%-____') NOT NULL,
    email VARCHAR2(500) NULL
);

-- �����Ǿ� �ִ� ���̺��� ���� ����
ALTER TABLE test ADD CONSTRAINT cs_test_phone CHECK(phone LIKE '010-%-____');

-- üũ���� ���� �۵� �׽�Ʈ
INSERT INTO member (
    id, pwd, name, gender, birthday, phone, email, age, boss_id
) VALUES (
    'kkj21',
    '11111',
    '�谭��',
    '����',
    19880628,
--  '01000001234',
-- ORA-02290: üũ ��������(CUSSIP.MEMBER_PHONE_CHK1)�� ����Ǿ����ϴ�
    '010-2389-8197',
    'kkj21@naver.com',
    35,
    'ishcjswo'
);
    
--------------------------------------------------------------------------------    
-- ���Խ��� �̿��� CHECK ��������  
-- ���� ���ڿ��� ����Ͽ� ���������� �� �����ϰ� ������ �� �ִ�.
--------------------------------------------------------------------------------
ALTER TABLE member 
DROP CONSTRAINT member_phone_chk1;
    -- ���� ���� ���� ����
    
SELECT * FROM user_constraints
WHERE table_name='MEMBER';
    -- MEMBER ���̺��� ���� ���� �˻�
    
ALTER TABLE member
ADD CONSTRAINT member_phone_chk1 
CHECK(REGEXP_LIKE(phone, '^01[06]-\d{3,4}-\d{4}'));

-- üũ���� ���� �۵� �׽�Ʈ
INSERT INTO member (
    id, pwd, name, gender, birthday, phone, email, age, boss_id
) VALUES (
    'starbusks',
    '123455',
    '��Ÿ����',
    '����',
    19700128,
--  '0aa-2389-8197',
--  ORA-02290: üũ ��������(CUSSIP.MEMBER_PHONE_CHK1)�� ����Ǿ����ϴ�
    '016-2389-8197',
    'starbucks@starbucks.com',
    45,
    'ishcjswo'
);


    