--------------------------------------------------------------------------------
-- Sequence (�Ϸù�ȣ)
--------------------------------------------------------------------------------

SELECT * FROM notice;
    -- id�� �Ϸù�ȣ�� �ο�

-- ������ ����. �������ε� ���� ����������, ���� �̿��Ͽ� ����
CREATE SEQUENCE sequence1;

SELECT notice_id_seq.NEXTVAL FROM dual;

INSERT INTO notice (id, title, writer_id, content, hit
) VALUES (
    notice_id_seq.NEXTVAL, 
    '������ ���', 
    'unknown', 
    '������ ��� �׽�Ʈ ���� ����',
    666
);
    -- ID�� 52��, 53���� �ڵ����� �ο���
    
-- '���̺����� / ��/ ID��'���� �ڵ����� �������� ����ϵ��� ����
INSERT INTO notice (title, writer_id, content, hit
) VALUES ( 
    'ID ���Է� ������ ���', 
    'kkj21', 
    '������ ��� �׽�Ʈ ���� ����',
    6666
);    
    
    
    