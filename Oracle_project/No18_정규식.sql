SELECT * FROM notice;

-- 전화번호의 정규식 생성
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}$');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '01[016-9]-\d{3,4}-\d{4}');
UPDATE notice SET notice.title = '010-5515-8139 변경성공' 
    WHERE title = '마지막 글';
UPDATE notice SET notice.content = 'ishcjswo@naver.com 변경성공' 
    WHERE id IN (4, 5);    

-- 이메일의 정규식 (abc11@abc11.com)
-- \w+@\w+.(ORG|NET|COM)       -- 숫자로 시작하는 내용도 검색되는 문제
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(ORG|NET|COM)');
-- \D\w*@\D\w*.(ORG|NET|COM)   -- 첫 글자는 영문자로 제한
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(org|net|com)');