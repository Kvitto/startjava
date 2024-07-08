\! chcp 1251
--echo-all
\c robots
  
   DROP TABLE IF EXISTS jaegers;
  
 CREATE TABLE jaegers (
     id         SERIAL PRIMARY KEY,
     model_name VARCHAR(30) NOT NULL,
     mark       VARCHAR(30) NOT NULL,
     height     INTEGER,
     weight     INTEGER,
     status     VARCHAR(11),
     origin	    VARCHAR(30),
     launch	    DATE,
     kaiju_kill INTEGER);

\i 'populate.sql'
\i 'queries.sql'
