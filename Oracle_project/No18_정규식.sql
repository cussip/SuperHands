SELECT * FROM notice;

-- ��ȭ��ȣ�� ���Խ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}$');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}');
SELECT * FROM notice WHERE REGEXP_LIKE(title, '01[016-9]-\d{3,4}-\d{4}');
UPDATE notice SET notice.title = '010-5515-8139 ���漺��' 
    WHERE title = '������ ��';
UPDATE notice SET notice.content = 'ishcjswo@naver.com ���漺��' 
    WHERE id IN (4, 5);    

-- �̸����� ���Խ� (abc11@abc11.com)
-- \w+@\w+.(ORG|NET|COM)       -- ���ڷ� �����ϴ� ���뵵 �˻��Ǵ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(ORG|NET|COM)');
-- \D\w*@\D\w*.(ORG|NET|COM)   -- ù ���ڴ� �����ڷ� ����
SELECT * FROM notice WHERE REGEXP_LIKE(content, '\w+@\w+.(org|net|com)');