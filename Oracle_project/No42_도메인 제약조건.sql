--------------------------------------------------------------------------------
-- 도메인 제약조건
-- 컬럼별로 유효한 값의 범위를 설정하는 것

-- 속성에 도메인이 아닌 값이 올 수 없도록 하는 제약 조건
-- NOT NULL: NULL 값이 올 수 없다.
-- DEFAULT: 아무런 데이터를 입력하지 않을 경우 기본으로 전달되는 값(날짜 등)
-- CHECK: 도메인 범위를 체크하는 조건을 설정
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
-- NOT NULL, DEFAULT
-- 콘솔로 입력도 가능하지만 일반적인 경우의 툴의 기능을 사용하는 것이 일반적
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
    '아주 간략한 내용', 
    20
);

SELECT * FROM notice;

--------------------------------------------------------------------------------
-- CHECK
-- 콘솔로 입력도 가능하지만 일반적인 경우의 툴의 기능을 사용하는 것이 일반적
--------------------------------------------------------------------------------
-- 테이블 생성시 조건 삽입
CREATE TABLE test (
    id VARCHAR2(50) NULL,
    phone VARCHAR2(200) CHECK(phone LIKE '010-%-____') NOT NULL,
    email VARCHAR2(500) NULL
);

-- 생성되어 있는 테이블의 조건 삽입
ALTER TABLE test ADD CONSTRAINT cs_test_phone CHECK(phone LIKE '010-%-____');

-- 체크제약 조건 작동 테스트
INSERT INTO member (
    id, pwd, name, gender, birthday, phone, email, age, boss_id
) VALUES (
    'kkj21',
    '11111',
    '김강재',
    '남성',
    19880628,
--  '01000001234',
-- ORA-02290: 체크 제약조건(CUSSIP.MEMBER_PHONE_CHK1)이 위배되었습니다
    '010-2389-8197',
    'kkj21@naver.com',
    35,
    'ishcjswo'
);
    
--------------------------------------------------------------------------------    
-- 정규식을 이용한 CHECK 제약조건  
-- 패턴 문자열을 사용하여 제약조건을 더 정밀하게 구현할 수 있다.
--------------------------------------------------------------------------------
ALTER TABLE member 
DROP CONSTRAINT member_phone_chk1;
    -- 기존 제약 조건 삭제
    
SELECT * FROM user_constraints
WHERE table_name='MEMBER';
    -- MEMBER 테이블의 제약 조건 검색
    
ALTER TABLE member
ADD CONSTRAINT member_phone_chk1 
CHECK(REGEXP_LIKE(phone, '^01[06]-\d{3,4}-\d{4}'));

-- 체크제약 조건 작동 테스트
INSERT INTO member (
    id, pwd, name, gender, birthday, phone, email, age, boss_id
) VALUES (
    'starbusks',
    '123455',
    '스타벅스',
    '여성',
    19700128,
--  '0aa-2389-8197',
--  ORA-02290: 체크 제약조건(CUSSIP.MEMBER_PHONE_CHK1)이 위배되었습니다
    '016-2389-8197',
    'starbucks@starbucks.com',
    45,
    'ishcjswo'
);


    