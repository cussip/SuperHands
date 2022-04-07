/* �Լ��� ����
���ڿ� �Լ�
���� �Լ�
��¥ �Լ�
��ȯ �Լ�
NULL ���� �Լ�
���� �Լ�
*/

-----------------------------------------------------------------------------
-- ���ڿ� �е� �Լ� LPAD / RPAD
-----------------------------------------------------------------------------
SELECT lpad('HELLO', 10) FROM dual;
    -- HELLO�� ����ϵ�, 10ĭ�� ä���� ���. ������ ������ ����
SELECT lpad('HELLO', 10, '*') FROM dual;
    -- HELLO�� ����ϵ�, 10ĭ�� ä���� ���. ������ ������ '*'

-- ȸ���� �̸��� ��ȸ�Ͻÿ�(��, �̸��� ���̰� 3�ڰ� �� �Ǵ� ����
-- ������ �ϴ��� ('_')�� ä��ÿ�
SELECT rpad(name, 6, '_') FROM member;


-----------------------------------------------------------------------------
-- ù ���ڸ� �빮�ڷ� ���� INITCAP
-----------------------------------------------------------------------------
SELECT initcap('the long long time ago. a man....') FROM dual;
    -- ��� �ܾ��� ù ���ڰ� �빮�ڷ� ����.
    
SELECT initcap('the long long t�޷�e ago. a man....') FROM dual; 
    -- �ѱ� ���� �����ڸ� ù ���ڷ� �����Ͽ� �빮�ڷ� ����
    
SELECT initcap(id) FROM member;

-----------------------------------------------------------------------------
-- ���ڸ� ��ȯ�ϴ� ���ڿ� �Լ� INSTR
-----------------------------------------------------------------------------
SELECT instr('all we need to is just to...', 'to') FROM dual;
    -- ���ڿ����� �˻��� ���ڿ��� ��ġ�� ã�Ƽ� ���ڷ� ��ȯ

SELECT instr('all we need to is just to...', 'to', 15) FROM dual;
    -- Ư�� ��ġ���� ���� �˻��ϵ��� ���� ��ġ�� ����    
    
SELECT instr('all we need to is just to...', 'to', 1, 2) FROM dual;
    -- n��° ã�� ���ڿ��� ��ġ�� ��ȯ�ϵ��� ����

SELECT * FROM notice;
SELECT instr(content, '����', 10) FROM notice;
SELECT instr(content, '����', 1, 2) FROM notice;
    
-- ȸ���� ��ȭ��ȣ���� �� ��° ���(-) ���ڰ� �����ϴ� ��ġ�� ���
SELECT instr(phone, '-', 1, 2) FROM member;
    
-- ȸ���� ��ȭ��ȣ���� ù ��° ���(-) ���ڿ� �� ��° ���(-) ���� ������ ����    
SELECT instr(phone, '-', 1, 2) - instr(phone, '-', 1) - 1 FROM member; 

-- ȸ���� ��ȭ��ȣ���� ù ��° ��ÿ� �� ��° ��� ������ ������ ���
SELECT substr(phone
        , (instr(phone, '-', 1)) + 1
        , (instr(phone, '-', 1, 2) - instr(phone, '-', 1) - 1)) 
FROM member;    

-----------------------------------------------------------------------------
-- ���ڿ��� ���̸� ��� �Լ� LENGTH
-----------------------------------------------------------------------------    
SELECT length('where we are') FROM dual;

-- ��� ȸ���� �ڵ��� ��ȣ�� ��ȣ�� ���ڿ� ���̸� ��ȸ    
SELECT phone, length(phone) FROM member;    
    
-- ��ȭ��ȣ�� ���Ե� ���� '-'�� ������ ��ȭ��ȣ�� ���̸� ����Ͻÿ�
SELECT phone, length(phone) ����, length(replace(phone, '-', '')) ���ڸ�
FROM member;

---------------------------------------------------------------------------
-- �ڵ� ���� ��ȯ�ϴ� �Լ� ASCII
-----------------------------------------------------------------------------
SELECT ascii('A') FROM dual;

-------------------------------------------------------------------------------
-- �ڵ� ������ ���ڸ� ��ȯ�ϴ� �Լ� CHR
-----------------------------------------------------------------------------
SELECT CHR(65) FROM dual;

commit;



    
    