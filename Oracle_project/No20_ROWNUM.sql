SELECT * FROM member;

SELECT * FROM member WHERE ROWNUM BETWEEN 1 AND 2;
    -- 1 ~ 2���� ���

SELECT * FROM member WHERE ROWNUM BETWEEN 3 AND 5;
    -- �ƹ��� �����͵� ��µ��� ����
    -- ROWNUM�� �׻� 1�� ������ ���¿��� �����͸� �����ͼ� ���ϱ� ������
    -- 1�� �ʰ��ϴ� ���� �񱳰� ���������� �̷������ ����
    -- ROWNUM�� �����Ͱ� ���� ������ �ִ� ���� �ƴ� ��� ������ ���������
    -- �ο��Ǵ� �����̱� ������ �߻��ϴ� ����
    
SELECT * FROM (
    SELECT ROWNUM num, member.* FROM member
    )
WHERE num BETWEEN 3 AND 5;
    -- ���������� �̿��Ͽ� ROWNUM�� ������Ų �� ���
    -- ROWNUM�� ���� �̹� ������ �ο��Ǿ��ֱ� ������ �����Ӱ� ������ ����Ͽ�
    -- SELECT�� ����� �� �ִ�.
    -- ROWNUM�� ��ȸ�� ������ �����Ǳ� ������,
    -- �̿��Ϸ��� ROWNUM���� ��Ī�� �ο��Ͽ��� �������� ����� �����ϴ�.
    
    
    
    
    
    