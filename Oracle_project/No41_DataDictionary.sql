--------------------------------------------------------------------------------
-- Data Dictionary
-- 컬럼, 테이블, 사용자 정보 등을 저장하는 공간으로 VIEW의 집합
-- 콘솔기반의 운영시에는 유용한 도구였으나, 현재는 거의 그래픽 비주얼로 보여주기
--때문에 사용성이 많이 낮아진 상태이다.
--------------------------------------------------------------------------------
SELECT * FROM total_view;

SELECT * FROM dict;
    -- 모든 DataDictionary 목록 확인
    
SELECT * FROM user_tables;
    -- 사용자에 대한 테이블 목록 확인
    
SELECT * FROM user_tab_columns;
SELECT * FROM user_tab_columns WHERE table_name = 'MEMBER';





