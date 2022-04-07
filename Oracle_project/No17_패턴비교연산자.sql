SELECT * FROM member;

INSERT INTO member VALUES(
    'newlecking',
    '123',
    '뉴렉킹',
    '여',
    '19990102',
    '01012345678',
    '2022-03-11',
    'newlecking@newlecking.kr'
);
    
SELECT * FROM member WHERE name LIKE '손%';
SELECT * FROM member WHERE name LIKE '%수%';
SELECT * FROM member WHERE name LIKE '손%';
SELECT * FROM member WHERE name LIKE '뉴_';
SELECT * FROM member WHERE name LIKE '%렉_';
SELECT * FROM member WHERE name NOT LIKE '뉴%';
