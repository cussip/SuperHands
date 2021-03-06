/* 함수의 종류
문자열 함수
숫자 함수
날짜 함수
변환 함수
NULL 관련 함수
집계 함수
*/

-----------------------------------------------------------------------------
-- 문자열 패딩 함수 LPAD / RPAD
-----------------------------------------------------------------------------
SELECT lpad('HELLO', 10) FROM dual;
    -- HELLO을 출력하되, 10칸을 채워서 출력. 부족한 공간은 공백
SELECT lpad('HELLO', 10, '*') FROM dual;
    -- HELLO을 출력하되, 10칸을 채워서 출력. 부족한 공간은 '*'

-- 회원의 이름을 조회하시오(단, 이름의 길이가 3자가 안 되는 경우는
-- 오른쪽 하단을 ('_')로 채우시오
SELECT rpad(name, 6, '_') FROM member;


-----------------------------------------------------------------------------
-- 첫 글자를 대문자로 변경 INITCAP
-----------------------------------------------------------------------------
SELECT initcap('the long long time ago. a man....') FROM dual;
    -- 모든 단어의 첫 글자가 대문자로 변경.
    
SELECT initcap('the long long t메롱e ago. a man....') FROM dual; 
    -- 한글 뒤의 영문자를 첫 글자로 간주하여 대문자로 변경
    
SELECT initcap(id) FROM member;

-----------------------------------------------------------------------------
-- 숫자를 반환하는 문자열 함수 INSTR
-----------------------------------------------------------------------------
SELECT instr('all we need to is just to...', 'to') FROM dual;
    -- 문자열에서 검색할 문자열의 위치를 찾아서 숫자로 반환

SELECT instr('all we need to is just to...', 'to', 15) FROM dual;
    -- 특정 위치에서 부터 검색하도록 시작 위치를 지정    
    
SELECT instr('all we need to is just to...', 'to', 1, 2) FROM dual;
    -- n번째 찾은 문자열의 위치를 반환하도록 지정

SELECT * FROM notice;
SELECT instr(content, '내용', 10) FROM notice;
SELECT instr(content, '내용', 1, 2) FROM notice;
    
-- 회원의 전화번호에서 두 번째 대시(-) 문자가 존재하는 위치를 출력
SELECT instr(phone, '-', 1, 2) FROM member;
    
-- 회원의 전화번호에서 첫 번째 대시(-) 문자와 두 번째 대시(-) 문자 사이의 간격    
SELECT instr(phone, '-', 1, 2) - instr(phone, '-', 1) - 1 FROM member; 

-- 회원의 전화번호에서 첫 번째 대시와 두 번째 대시 사이의 국번을 출력
SELECT substr(phone
        , (instr(phone, '-', 1)) + 1
        , (instr(phone, '-', 1, 2) - instr(phone, '-', 1) - 1)) 
FROM member;    

-----------------------------------------------------------------------------
-- 문자열의 길이를 얻는 함수 LENGTH
-----------------------------------------------------------------------------    
SELECT length('where we are') FROM dual;

-- 모든 회원의 핸드폰 번호와 번호의 문자열 길이를 조회    
SELECT phone, length(phone) FROM member;    
    
-- 전화번호에 포함된 문자 '-'를 제외한 전화번호의 길이를 출력하시오
SELECT phone, length(phone) 길이, length(replace(phone, '-', '')) 숫자만
FROM member;

---------------------------------------------------------------------------
-- 코드 값을 반환하는 함수 ASCII
-----------------------------------------------------------------------------
SELECT ascii('A') FROM dual;

-------------------------------------------------------------------------------
-- 코드 값으로 문자를 반환하는 함수 CHR
-----------------------------------------------------------------------------
SELECT CHR(65) FROM dual;

commit;



    
    