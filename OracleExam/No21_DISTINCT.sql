SELECT * FROM member;

ALTER TABLE member ADD (age NUMBER);
UPDATE member SET age = round(30 + (ROWNUM * 27 / 3 / 5));
UPDATE member SET age = 32 WHERE age IN (35, 37);

SELECT age FROM member;
SELECT DISTINCT age FROM member;
    -- 나이가 중복된 경우 하나만 출력
    -- 하나의 컬럼만 사용하여 조회하는 경우에만 유효하게 사용 가능
    -- (다른 컬럼과 같이 조회할 경우 정상적으로 작동하지 않음)





