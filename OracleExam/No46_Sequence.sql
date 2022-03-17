--------------------------------------------------------------------------------
-- Sequence (일련번호)
--------------------------------------------------------------------------------

SELECT * FROM notice;
    -- id에 일련번호를 부여

-- 시퀀스 생성. 구문으로도 생성 가능하지만, 툴을 이용하여 생성
CREATE SEQUENCE sequence1;

SELECT notice_id_seq.NEXTVAL FROM dual;

INSERT INTO notice (id, title, writer_id, content, hit
) VALUES (
    notice_id_seq.NEXTVAL, 
    '시퀀스 사용', 
    'unknown', 
    '시퀀스 사용 테스트 내용 없음',
    666
);
    -- ID에 52번, 53번이 자동으로 부여됨
    
-- '테이블편집 / 열/ ID열'에서 자동으로 시퀀스를 사용하도록 설정
INSERT INTO notice (title, writer_id, content, hit
) VALUES ( 
    'ID 미입력 시퀀스 사용', 
    'kkj21', 
    '시퀀스 사용 테스트 내용 없음',
    6666
);    
    
    
    