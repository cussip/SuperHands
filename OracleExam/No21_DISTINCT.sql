SELECT * FROM member;

ALTER TABLE member ADD (age NUMBER);
UPDATE member SET age = round(30 + (ROWNUM * 27 / 3 / 5));
UPDATE member SET age = 32 WHERE age IN (35, 37);

SELECT age FROM member;
SELECT DISTINCT age FROM member;
    -- ���̰� �ߺ��� ��� �ϳ��� ���
    -- �ϳ��� �÷��� ����Ͽ� ��ȸ�ϴ� ��쿡�� ��ȿ�ϰ� ��� ����
    -- (�ٸ� �÷��� ���� ��ȸ�� ��� ���������� �۵����� ����)





