/* 함수의 종류
문자열 함수
숫자 함수
날짜 함수
변환 함수 
NULL 관련 함수
집계 함수
*/

--------------------------------------------------------------------------------
-- 반환 값이 NULL일 경우에 대체 값을 제공하는 NVL(NULL, 대체값) 함수
--------------------------------------------------------------------------------
UPDATE member SET age = NULL WHERE name='윤금옥';
    -- 멤버 중 1인의 나이를 null으로 변경
    
SELECT nvl(age, 9999) FROM member;
SELECT trunc(age / 10) FROM member;
SELECT trunc(nvl(age, 0) / 10) FROM member;


--------------------------------------------------------------------------------
-- NVL에서 조건을 하나 더 확장한 NVL2(입력값, NOTNULL 대체값, NULL 대체값) 함수
--------------------------------------------------------------------------------
SELECT trunc(nvl(age, 0) / 10) * 10 FROM member;
    -- 모든 연산에서 연산
    
SELECT nvl2(age, trunc(age/10)*10, 0) FROM member;
    -- NULL이 아닌 경우에만 연산. 연산의 횟수가 상대적으로 적음


--------------------------------------------------------------------------------
-- 두 값이 같은 경우 NULL 그렇지 않은 경우 첫 번째 값 반환 NULLIF(값1, 값2) 함수
--------------------------------------------------------------------------------
SELECT name, nullif(age, 32) FROM member;


--------------------------------------------------------------------------------
-- 조건에 따른 값 선택하기 DECODE(기준값, 비교값, 출력값, 비교값, 출력값)
--------------------------------------------------------------------------------
SELECT decode(gender, '남성', 1, 2) FROM member;
SELECT name, decode(substr(phone, 1, 3)
                        , '011', 'SK'
                        , '016', 'KT'
                        , '기타') 통신사 
FROM member;

SELECT name, decode((trunc(age/10)) 
                    , '3', '청년'
                    , '4', '노땅'
                    , '몇 살이니 대체?') 
                    || ', ' || age 연령대
FROM member;


commit;











