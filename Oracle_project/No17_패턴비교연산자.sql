SELECT * FROM member;

INSERT INTO member VALUES(
    'newlecking',
    '123',
    '����ŷ',
    '��',
    '19990102',
    '01012345678',
    '2022-03-11',
    'newlecking@newlecking.kr'
);
    
SELECT * FROM member WHERE name LIKE '��%';
SELECT * FROM member WHERE name LIKE '%��%';
SELECT * FROM member WHERE name LIKE '��%';
SELECT * FROM member WHERE name LIKE '��_';
SELECT * FROM member WHERE name LIKE '%��_';
SELECT * FROM member WHERE name NOT LIKE '��%';
