\echo 'Вывод всей таблицы:'
SELECT * FROM jaegers ORDER BY model_name;
\echo 'Вывод только не уничтоженных роботов:'
SELECT * FROM jaegers WHERE status = 'undestroyed' ORDER BY model_name;
\echo 'Вывод только роботов серии Mark-1 и Mark-4:'
SELECT * FROM jaegers WHERE mark IN ('Mark-1', 'Mark-4') ORDER BY model_name;
\echo 'Вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark:'
SELECT * FROM jaegers WHERE mark NOT IN ('Mark-1', 'Mark-4') ORDER BY mark DESC;
\echo 'Вывод информации о самых старых роботах:'
SELECT * FROM jaegers WHERE launch = (SELECT MIN(launch) FROM Jaegers) ORDER BY model_name;
\echo 'Вывод информации из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju:'
SELECT model_name, mark, launch, kaiju_kill FROM jaegers WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM Jaegers) ORDER BY model_name;
\echo 'Вывод среднего веса роботов, округлив его до трех знаков после запятой:'
SELECT round(AVG(weight), 3) FROM Jaegers;
\echo 'Увеличение на единицу количество уничтоженных kaiju у неразрушенных роботов, а затем вывод таблицы.'
UPDATE Jaegers SET kaiju_kill = kaiju_kill + 1 WHERE status = 'undestroyed';
SELECT * FROM jaegers ORDER BY model_name;
\echo 'Удаление уничтоженных роботов, а затем вывод оставшихся.'
DELETE FROM Jaegers WHERE status = 'destroyed';
SELECT * FROM jaegers ORDER BY model_name;