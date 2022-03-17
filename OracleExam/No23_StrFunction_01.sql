/* 함수의 종류
문자열 함수
숫자 함수
날짜 함수
변환 함수
NULL 관련 함수
집계 함수
*/

-----------------------------------------------------------------------------
-- 문자열 추출 함수 SUBSTR(문자열, 시작위치, 길이)
-----------------------------------------------------------------------------
SELECT substr(name, 1, 2) FROM member;
    -- 문자 단위로 추출

SELECT substrb(email, 1, 10) FROM member;
SELECT substrb(name, 1, 4) FROM member;
    -- 바이트 단위로 추출(한글은 3바이트가 1글자)
    
-- 멤버의 이름과 출생 월만 조회하시오.
SELECT name, substr(birthday, 5, 2) month FROM member;

-- 회원정보 추가
SELECT * FROM member;
INSERT INTO member VALUES (
    'nophone',
    '23adccdd',
    '전없찐',
    '남',
    '20020723',
    NULL,
    '2020-04-03',
    'nophone@nophone.org',
    '30'
);
UPDATE member SET phone='016-231-8848' WHERE id='ddhr1202';

-- 전화번호가 011로 시작하는 회원의 모든 정보를 출력.
SELECT * FROM member WHERE substr(phone,1,3) = '016';
SELECT * FROM member WHERE phone LIKE '016%';

-- 생년월일이 7~9월인 회원의 정보를 출력.
SELECT * FROM member WHERE substr(birthday, 5,2) IN (07, 08, 09);

-- 전화번호를 등록하지 않은 회원 중에서 생년월일이 7~9월인 회원의 정보를 출력.
SELECT * FROM member 
WHERE substr(birthday, 5,2) IN (07, 08, 09) AND phone IS NULL;

-----------------------------------------------------------------------------
-- 문자열 덧셈 함수 CONCAT
-----------------------------------------------------------------------------
SELECT concat('3', '4') FROM dual;    
    
-----------------------------------------------------------------------------
-- 문자열 연산 (함수보다 성능상 우위)
-----------------------------------------------------------------------------
SELECT 3 || '4' FROM dual;    

-----------------------------------------------------------------------------
-- 문자열 트림 함수(빈 공간 제거) LTRIM / RTRIM / TRIM
-----------------------------------------------------------------------------
SELECT  ltrim('     홍길동     '), 
        rtrim('     홍길동     '), 
        TRIM('     홍길동     ') 
FROM dual;    

-----------------------------------------------------------------------------
-- 문자열의 대소문자 변경 LOWER / UPPER
-----------------------------------------------------------------------------
SELECT lower('NeWlEc'), upper('NeWlEc') FROM dual;
  
-- 회원 아이디가 NEWLEC인 회원을 조회하시오(대소문자 불문)
SELECT * FROM member WHERE upper(id)='NEWLEC';
    
-----------------------------------------------------------------------------
-- 문자열 대치 함수 REPLACE / TRANSLATE
-----------------------------------------------------------------------------
SELECT replace('newlec', 'new', 'hohoho!!') FROM dual;    
    -- 문자열이 통째로 변경
    
SELECT translate('newlec', 'nw', 'fc') FROM dual;
    -- 각 문자별로 대치되어 변경(n -> f, w -> c)
    
-- 회원의 이름과 주소를 조회하시오(단 주소는 빈칸없이 출력)
SELECT replace(n.title, ' ', '') title FROM notice n;

COMMIT;
    
    
    
    
    