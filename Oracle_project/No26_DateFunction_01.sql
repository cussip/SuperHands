/* 함수의 종류
문자열 함수
숫자 함수
날짜 함수
변환 함수
NULL 관련 함수
집계 함수
*/

--------------------------------------------------------------------------------
-- 현재시간을 얻는 함수
-- 오라클 설정 시간: SYS
-- 세션 설정 시간: CURRENT
-- 밀리 세컨드: ~TIMESTAMP
--------------------------------------------------------------------------------
SELECT sysdate 오라클, current_date 세션, systimestamp, current_timestamp 
FROM dual;


--------------------------------------------------------------------------------
-- 세션 시간과 포맷 변경
--------------------------------------------------------------------------------
ALTER SESSION SET time_zone = '09:00';
    -- 세션의 기준 시간을 변경(표준시각 기준)
    
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
    -- 시분초까지 표시되도록 설정 변경


--------------------------------------------------------------------------------
-- 날짜 추출함수 EXTRACT(YEAR/MONTH/DAY/HOUR/MINUTE/SECOND)
--------------------------------------------------------------------------------
SELECT EXTRACT(MONTH FROM sysdate) || '월' FROM dual;

SELECT * FROM member WHERE EXTRACT(MONTH FROM regdate) IN (2, 3, 11);
    -- 2, 3, 11월에 입사한 멤버를 조회


--------------------------------------------------------------------------------
-- 날짜를 누적하는 함수 ADD_MONTH(날짜, 정수)
--------------------------------------------------------------------------------
SELECT add_months(sysdate, 1) FROM dual;
    -- 현재 날짜에 1개월을 더한다

-- 멤버 중 가입 6개월 미만을 조회, 6개월 이상을 조회
SELECT * FROM member WHERE add_months(regdate, 6) > sysdate;
SELECT * FROM member WHERE add_months(regdate, 6) <= sysdate;


--------------------------------------------------------------------------------
-- 개월의 차이를 알아내는 함수 MONTHS_BETWEEN(날짜, 날짜)
--------------------------------------------------------------------------------
SELECT months_between(sysdate, to_date('2013-12-24')) FROM dual;

-- 멤버 중 가입 6개월 미만을 조회, 6개월 이상을 조회
SELECT months_between(sysdate, regdate) bet FROM member;
SELECT * FROM member WHERE months_between(sysdate, regdate) < 6;
SELECT * FROM member WHERE months_between(sysdate, regdate) >= 6;


--------------------------------------------------------------------------------
-- 다음 요일을 알려주는 함수 NEXT_DAY(현재날짜, 다음요일)
--------------------------------------------------------------------------------
SELECT next_day(sysdate, '토요일') FROM dual;
SELECT next_day(sysdate, 7) FROM dual;
    -- 일=1, ..., 토=7


--------------------------------------------------------------------------------
-- 해당 월의 마지막 일자를 알려주는 함수 LAST_DAY(현재날짜)
--------------------------------------------------------------------------------
SELECT last_day(sysdate) FROM dual;
SELECT last_day(add_months(sysdate, 11)) FROM dual;


--------------------------------------------------------------------------------
-- 지정된 범위에서 날짜를 반올림/버림 하는 함수 ROUND/TRUNC(날짜, 포맷)
--------------------------------------------------------------------------------
SELECT round(sysdate, 'cc'), trunc(sysdate, 'cc') FROM dual;
    -- cc: 1세기(100년) 단위
SELECT round(to_date('2021-07-21'), 'year')
        , trunc(to_date('2021-07-21'), 'year') 
FROM dual;

SELECT round(to_date('2021-07-21'), 'month')
        , trunc(to_date('2021-07-21'), 'month') 
FROM dual;

commit;



















