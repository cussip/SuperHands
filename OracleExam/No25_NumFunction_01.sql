/* �Լ��� ����
���ڿ� �Լ�
���� �Լ�
��¥ �Լ�
��ȯ �Լ�
NULL ���� �Լ�
���� �Լ�
*/

-----------------------------------------------------------------------------
-- ���밪�� ���ϴ� �Լ� ABS(n)
-----------------------------------------------------------------------------
SELECT abs(35), abs(-35) FROM dual;

-----------------------------------------------------------------------------
-- ����/����� �˷��ִ� �Լ� SIGN(n)
-----------------------------------------------------------------------------
SELECT sign(35), sign(-35), sign(0) FROM dual;

-----------------------------------------------------------------------------
-- �ݿø� �Լ� ROUND(n, i)
-----------------------------------------------------------------------------
SELECT round(34.4568), round(34.76788) FROM dual;
    -- �Ҽ��� �ݿø�
SELECT round(34.45678, 2), round(4335.678678, -3) FROM dual;
    -- ���� �ڸ������� �ݿø�(���� ����)

-----------------------------------------------------------------------------
-- ������ ���� ��ȯ�ϴ� �Լ� TRUNC(n1)
-- ������ ���� ��ȯ�ϴ� �Լ� MOD(n1, n2)
-----------------------------------------------------------------------------
SELECT trunc(17/5) ��, mod(17,5) ������ FROM dual;

-----------------------------------------------------------------------------
-- ������ ���ϴ� �Լ� POWER(n1, n2)
-- �������� ���ϴ� �Լ� SQRT(n)
-----------------------------------------------------------------------------
SELECT power(3, 4), sqrt(25) FROM dual;

-----------------------------------------------------------------------------
-- �Ҽ��� �ø� CEIL(n)
-- �Ҽ��� ���� FLOOR(n)
-----------------------------------------------------------------------------
SELECT ceil(34.333), floor(34.333) FROM dual;


commit;


    
    