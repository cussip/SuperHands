/* �Լ��� ����
���ڿ� �Լ�
���� �Լ�
��¥ �Լ�
��ȯ �Լ�
NULL ���� �Լ�
���� �Լ�
*/

--------------------------------------------------------------------------------
-- ����ð��� ��� �Լ�
-- ����Ŭ ���� �ð�: SYS
-- ���� ���� �ð�: CURRENT
-- �и� ������: ~TIMESTAMP
--------------------------------------------------------------------------------
SELECT sysdate ����Ŭ, current_date ����, systimestamp, current_timestamp 
FROM dual;


--------------------------------------------------------------------------------
-- ���� �ð��� ���� ����
--------------------------------------------------------------------------------
ALTER SESSION SET time_zone = '09:00';
    -- ������ ���� �ð��� ����(ǥ�ؽð� ����)
    
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
    -- �ú��ʱ��� ǥ�õǵ��� ���� ����


--------------------------------------------------------------------------------
-- ��¥ �����Լ� EXTRACT(YEAR/MONTH/DAY/HOUR/MINUTE/SECOND)
--------------------------------------------------------------------------------
SELECT EXTRACT(MONTH FROM sysdate) || '��' FROM dual;

SELECT * FROM member WHERE EXTRACT(MONTH FROM regdate) IN (2, 3, 11);
    -- 2, 3, 11���� �Ի��� ����� ��ȸ


--------------------------------------------------------------------------------
-- ��¥�� �����ϴ� �Լ� ADD_MONTH(��¥, ����)
--------------------------------------------------------------------------------
SELECT add_months(sysdate, 1) FROM dual;
    -- ���� ��¥�� 1������ ���Ѵ�

-- ��� �� ���� 6���� �̸��� ��ȸ, 6���� �̻��� ��ȸ
SELECT * FROM member WHERE add_months(regdate, 6) > sysdate;
SELECT * FROM member WHERE add_months(regdate, 6) <= sysdate;


--------------------------------------------------------------------------------
-- ������ ���̸� �˾Ƴ��� �Լ� MONTHS_BETWEEN(��¥, ��¥)
--------------------------------------------------------------------------------
SELECT months_between(sysdate, to_date('2013-12-24')) FROM dual;

-- ��� �� ���� 6���� �̸��� ��ȸ, 6���� �̻��� ��ȸ
SELECT months_between(sysdate, regdate) bet FROM member;
SELECT * FROM member WHERE months_between(sysdate, regdate) < 6;
SELECT * FROM member WHERE months_between(sysdate, regdate) >= 6;


--------------------------------------------------------------------------------
-- ���� ������ �˷��ִ� �Լ� NEXT_DAY(���糯¥, ��������)
--------------------------------------------------------------------------------
SELECT next_day(sysdate, '�����') FROM dual;
SELECT next_day(sysdate, 7) FROM dual;
    -- ��=1, ..., ��=7


--------------------------------------------------------------------------------
-- �ش� ���� ������ ���ڸ� �˷��ִ� �Լ� LAST_DAY(���糯¥)
--------------------------------------------------------------------------------
SELECT last_day(sysdate) FROM dual;
SELECT last_day(add_months(sysdate, 11)) FROM dual;


--------------------------------------------------------------------------------
-- ������ �������� ��¥�� �ݿø�/���� �ϴ� �Լ� ROUND/TRUNC(��¥, ����)
--------------------------------------------------------------------------------
SELECT round(sysdate, 'cc'), trunc(sysdate, 'cc') FROM dual;
    -- cc: 1����(100��) ����
SELECT round(to_date('2021-07-21'), 'year')
        , trunc(to_date('2021-07-21'), 'year') 
FROM dual;

SELECT round(to_date('2021-07-21'), 'month')
        , trunc(to_date('2021-07-21'), 'month') 
FROM dual;

commit;


















