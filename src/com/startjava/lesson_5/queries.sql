\echo '����� ���� �������:'
SELECT * FROM jaegers ORDER BY model_name;
\echo '����� ������ �� ������������ �������:'
SELECT * FROM jaegers WHERE status = 'undestroyed' ORDER BY model_name;
\echo '����� ������ ������� ����� Mark-1 � Mark-4:'
SELECT * FROM jaegers WHERE mark IN ('Mark-1', 'Mark-4') ORDER BY model_name;
\echo '����� ���� �������, ����� Mark-1 � Mark-4, ������������ ������� �� �������� �� ������� mark:'
SELECT * FROM jaegers WHERE mark NOT IN ('Mark-1', 'Mark-4') ORDER BY mark DESC;
\echo '����� ���������� � ����� ������ �������:'
SELECT * FROM jaegers WHERE launch = (SELECT MIN(launch) FROM Jaegers) ORDER BY model_name;
\echo '����� ���������� �� �������� model_name, mark, launch, kaiju_kill ��� �������, ������� ���������� ������ ���� kaiju:'
SELECT model_name, mark, launch, kaiju_kill FROM jaegers WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM Jaegers) ORDER BY model_name;
\echo '����� �������� ���� �������, �������� ��� �� ���� ������ ����� �������:'
SELECT round(AVG(weight), 3) FROM Jaegers;
\echo '���������� �� ������� ���������� ������������ kaiju � ������������� �������, � ����� ����� �������.'
UPDATE Jaegers SET kaiju_kill = kaiju_kill + 1 WHERE status = 'undestroyed';
SELECT * FROM jaegers ORDER BY model_name;
\echo '�������� ������������ �������, � ����� ����� ����������.'
DELETE FROM Jaegers WHERE status = 'destroyed';
SELECT * FROM jaegers ORDER BY model_name;