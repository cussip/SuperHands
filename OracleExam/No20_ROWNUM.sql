SELECT * FROM member;

SELECT * FROM member WHERE ROWNUM BETWEEN 1 AND 2;
    -- 1 ~ 2까지 출력

SELECT * FROM member WHERE ROWNUM BETWEEN 3 AND 5;
    -- 아무런 데이터도 출력되지 않음
    -- ROWNUM은 항상 1이 고정된 상태에서 데이터를 가져와서 비교하기 때문에
    -- 1을 초과하는 값은 비교가 정상적으로 이루어지지 않음
    -- ROWNUM은 데이터가 원래 가지고 있는 값이 아닌 결과 집합이 만들어질때
    -- 부여되는 순번이기 때문에 발생하는 문제
    
SELECT * FROM (
    SELECT ROWNUM num, member.* FROM member
    )
WHERE num BETWEEN 3 AND 5;
    -- 서브쿼리를 이용하여 ROWNUM을 고정시킨 후 사용
    -- ROWNUM에 따라 이미 순번이 부여되어있기 때문에 자유롭게 순번을 사용하여
    -- SELECT를 사용할 수 있다.
    -- ROWNUM은 조회할 때마다 생성되기 때문에,
    -- 이용하려는 ROWNUM에는 별칭을 부여하여야 정상적인 사용이 가능하다.
    
    
    
    
    
    