--------------------------------------------------------------------------------
-- Entity ��������
-- primary key, unique
-- �ߺ��� ���ڵ尡 ������ �����Ѵ�.
-- �ĺ��� �� �ִ� �÷��� �־�� �ϸ�, �ĺ�Ű��� �Ѵ�.
-- �ĺ�Ű�� ���� �ߺ��� �߻����� �ʾƾ� �Ѵ�.
-- �ܼ� �Է��� ���Ͽ� �����ϴ� �͵� ���������� ���� ����ϴ� ���� �����ϴ�.
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- primary key: �ߺ� �� null �Ұ�
-- unique: �ߺ� �Ұ�, null ����(�Ұ��� ���� �� ���� ����)
--------------------------------------------------------------------------------

CREATE TABLE notice_test (
    id NUMBER CONSTRAINT notice_id_pk PRIMARY KEY,
        -- �������Ǹ� ����, primary key ����
    title VARCHAR2(300) NOT NULL,
    writer_id VARCHAR2(50) NOT NULL UNIQUE,
        -- unique ����
    content VARCHAR2(4000),
    regdate DATE DEFAULT sysdate,
    hit NUMBER DEFAULT 0
);

CREATE TABLE notice_test (
    ID NUMBER,
    TITLE VARCHAR2(300) NOT NULL,
    WRITER_ID VARCHAR2(50) NOT NULL,
    CONTENT VARCHAR2(4000),
    REGDATE DATE DEFAULT SYSDATE,
    HIT NUMBER DEFAULT 0
    
    constraint notice_id_pk PRIMARY KEY(id),
    constraint notice_id_uk UNIQUE(writer_id)
        -- �ϴܿ��� �������Ǹ� ���� ����
);

ALTER TABLE NOTICE
ADD CONSTRAINT NOTICE_ID_PK PRIMARY KEY(ID);
    -- �̹� �����Ǿ� �ִ� �÷��� �Ӽ� ����
    


