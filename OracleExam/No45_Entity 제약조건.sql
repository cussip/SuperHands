--------------------------------------------------------------------------------
-- Entity 제약조건
-- primary key, unique
-- 중복된 레코드가 없도록 제한한다.
-- 식별할 수 있는 컬럼이 있어야 하며, 식별키라고 한다.
-- 식별키는 결코 중복이 발생하지 않아야 한다.
-- 콘솔 입력을 통하여 설정하는 것도 가능하지만 툴을 사용하는 것이 간편하다.
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- primary key: 중복 및 null 불가
-- unique: 중복 불가, null 가능(불가로 설정 할 수도 있음)
--------------------------------------------------------------------------------

CREATE TABLE notice_test (
    id NUMBER CONSTRAINT notice_id_pk PRIMARY KEY,
        -- 제약조건명 설정, primary key 설정
    title VARCHAR2(300) NOT NULL,
    writer_id VARCHAR2(50) NOT NULL UNIQUE,
        -- unique 설정
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
        -- 하단에서 제약조건만 따로 설정
);

ALTER TABLE NOTICE
ADD CONSTRAINT NOTICE_ID_PK PRIMARY KEY(ID);
    -- 이미 생성되어 있는 컬럼의 속성 변경
    


