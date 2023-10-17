
### Выдайте всю информацию о спортсменах из таблицы sportsman.
```sql
competitions=# SELECT * FROM sportsman;
 sportsman_id | sportsman_name | rank | year_of_birth | personal_record | country  
--------------+----------------+------+---------------+-----------------+----------
            1 | Спортсмен 1    |    9 |          1974 |          176.32 | Китай
            2 | Спортсмен 2    |    6 |          1978 |          409.37 | Китай
            3 | Спортсмен 3    |    5 |          1988 |           35.14 | Китай
            4 | Спортсмен 4    |    8 |          1980 |          974.27 | Китай
            5 | Спортсмен 5    |    8 |          1979 |          911.05 | США
            6 | Спортсмен 6    |    8 |          1996 |          443.80 | Россия
            7 | Спортсмен 7    |    2 |          1991 |           43.56 | Китай
            8 | Спортсмен 8    |    7 |          1990 |          734.96 | Германия
            9 | Спортсмен 9    |    7 |          1998 |          135.87 | Россия
           10 | Спортсмен 10   |    8 |          1992 |            0.06 | Россия
           11 | Спортсмен 11   |    5 |          1997 |          129.19 | Франция
           12 | Спортсмен 12   |    9 |          1983 |          176.94 | Китай
           13 | Спортсмен 13   |   10 |          1991 |          801.09 | Китай
           14 | Спортсмен 14   |    9 |          1978 |          347.87 | Россия
           15 | Спортсмен 15   |    5 |          1981 |          182.10 | Китай
           16 | Спортсмен 16   |    3 |          1998 |          202.63 | Россия
           17 | Спортсмен 17   |    3 |          1995 |          100.54 | Франция
           18 | Спортсмен 18   |    9 |          1994 |          826.23 | Россия
           19 | Спортсмен 19   |   10 |          1984 |          421.45 | Россия
           20 | Спортсмен 20   |    4 |          1986 |          705.33 | Россия
           21 | Спортсмен 21   |    3 |          1991 |          779.72 | Германия
           22 | Спортсмен 22   |    6 |          1977 |          915.81 | США
           23 | Спортсмен 23   |    5 |          1971 |          970.95 | Россия
           24 | Спортсмен 24   |    5 |          1995 |          661.88 | Китай
           25 | Спортсмен 25   |    6 |          1997 |            5.54 | Франция
           26 | Спортсмен 26   |   10 |          1991 |          508.13 | Россия
           27 | Спортсмен 27   |    6 |          1981 |          872.68 | Китай
           28 | Спортсмен 28   |    4 |          1989 |          582.65 | США
           29 | Спортсмен 29   |    5 |          1987 |          145.65 | Франция
           30 | Спортсмен 30   |    7 |          1976 |          643.70 | Россия
```
-----
### Выдайте наименование и мировые результаты по всем соревнованиям.
```sql
competitions=# SELECT competition_name, world_record FROM competition;
             competition_name             | world_record 
------------------------------------------+--------------
 Бег на 100 метров. Мужчины               |         9.58
 Бег на 200 метров. Мужчины               |        19.19
 Бег на 400 метров. Мужчины               |        43.03
 Бег на 800 метров. Мужчины               |       100.91
 Бег на 1000 метров. Мужчины              |       131.96
 Бег на 1500 метров. Мужчины              |       206.00
 Бег на 1 милю. Мужчины                   |       223.13
 Бег на 2000 метров. Мужчины              |       284.79
 Бег на 3000 метров. Мужчины              |       440.67
 Бег на 5000 метров. Мужчины              |       755.36
 Бег на 10000 метров. Мужчины             |      1577.53
 Бег на 20000 метров. Мужчины             |      3385.98
 Бег на 25000 метров. Мужчины             |       4345.4
 Бег на 30000 метров. Мужчины             |       5207.4
 Бег. Марафон. Мужчины                    |         7299
 Бег 3000 метров с препятствиями. Мужчины |       473.63
 Бег на 110 метров c барьерами. Мужчины   |        12.80
 Бег на 400 метров с барьерами. Мужчины   |        46.78
 Ходьба на 20000 метров. Мужчины          |       4645.6
 Ходьба на 30000 метров. Мужчины          |       7304.1
 Ходьба на 50000 метров. Мужчины          |      12927.2
```
-----
### Выберите имена всех спортсменов, которые родились в 1990 году.

```sql
competitions=# SELECT * FROM sportsman where year_of_birth=1990;
 sportsman_id | sportsman_name | rank | year_of_birth | personal_record | country  
--------------+----------------+------+---------------+-----------------+----------
            8 | Спортсмен 8    |    7 |          1990 |          734.96 | Германия
```
-----
### Выберите наименование и мировые результаты по всем соревнованиям, установленные 12-05-2010 или 15-05-2010.

```sql
competitions=# SELECT competition_name,world_record FROM competition WHERE set_date='2010-05-12' OR set_date='2010-05-15';
       competition_name       | world_record 
------------------------------+--------------
 Бег на 25000 метров. Мужчины |       4345.4
 Бег. Марафон. Мужчины        |         7299 
 ```
#### (Предварительно данные были обновлены для того чтобы был какой-то результат)
-----
### Выберите дату проведения всех соревнований, которые проводились в Москве и полученные на них результаты равны 10 секунд.

```sql
competitions=# SELECT hold_date FROM result WHERE city='Москва' AND result=10;
 hold_date  
------------
 2022-10-27
```
-----
### Выберите имена всех спортсменов, у которых персональный рекорд не равен 25 с.
```sql
competitions=# SELECT sportsman_name FROM sportsman WHERE personal_record!=25;
 sportsman_name 
----------------
 Спортсмен 1
 Спортсмен 2
 ...
 Спортсмен 21
 Спортсмен 23
 Спортсмен 24
 Спортсмен 26
 Спортсмен 27
 Спортсмен 28
 Спортсмен 29
 Спортсмен 30
 Спортсмен 25


```

У 22 спортсмена рекорд 25


-----
### Выберите названия всех соревнований, у которых мировой рекорд равен 15 с и дата установки рекорда не равна 12-02-2015.
```sql
competitions=# SELECT competition_name FROM competition WHERE world_record=15 AND set_date!='2015-02-12';
      competition_name      
----------------------------
 Бег на 200 метров. Мужчины
```
-----
### Выберите города проведения соревнований, где результаты принадлежат множеству {13, 25, 17, 9}.
```sql
competitions=# SELECT competition_id,city FROM result WHERE result in (13, 25, 17, 9);
 competition_id |   city   
----------------+----------
              7 | Пекин
              9 | Москва

```
-----
### Выберите имена всех спортсменов, у которых год рождения 2000 и разряд не принадлежит множеству {3, 7, 9}.
```sql
competitions=# SELECT sportsman_name FROM sportsman where year_of_birth=2000 AND NOT rank in (3,7,9);
 sportsman_name 
----------------
 Спортсмен 1
 Спортсмен 2
 Спортсмен 3
 Спортсмен 5

```
-----
### Выберите дату проведения всех соревнований, у которых город проведения начинается с буквы "М".
```sql
competitions=# SELECT DISTINCT set_date FROM competition RIGHT JOIN result ON result.competition_id=competition.competition_id WHERE city like 'М%';
  set_date  
------------
 1996-09-01
 1998-07-14
 1999-07-07
 1999-09-07
 2005-08-26
 2016-08-14
 2020-08-14

```
-----
### Выберите имена всех спортсменов, у которых имена начинаются с буквы "М" и год рождения не заканчивается на "6".
```sql
competitions=# SELECT sportsman_name FROM sportsman WHERE sportsman_name like 'М%' and year_of_birth%10!=6;
 sportsman_name 
----------------
 Михаил

```
-----
### Выберите наименования всех соревнований, у которых в названии есть слово "международные".
```sql
competitions=# SELECT competition_name FROM competition WHERE competition_name ILIKE '%МЕЖДУНАРОДНЫЕ%';
               competition_name                
-----------------------------------------------
 Международные летние игры
 Международные соревнования по легкой атлетике
 Международные соревнования в плавании
 Международные соревнования по футболу
```
-----
### Выберите годы рождения всех спортсменов без повторений.
```sql
competitions=# SELECT DISTINCT year_of_birth FROM sportsman;
 year_of_birth 
---------------
          1989
          1991
          1974
          1977
          1971
          1983
          1997
          1994
          1987
          2000
          1981
          1978
          1988
          1984
          1990
          1979
          1980
          1986
          1995
          1992
          1996
          1976
          1998

```
-----
### Найдите количество результатов, полученных 12-05-2014.
```sql
competitions=# SELECT COUNT(hold_date) FROM result WHERE hold_date='2014-05-12';
 count 
-------
     6

```
-----
### Вычислите максимальный результат, полученный в Москве.
```sql
competitions=# SELECT MAX(result) FROM result WHERE city='Москва';
 max 
-----
  42

```
-----
### Вычислите минимальный год рождения спортсменов, которые имеют 1 разряд.
```sql
competitions=# SELECT MIN(year_of_birth) FROM sportsman WHERE rank=1;
 min  
------
 1978

```
-----
### Определите имена спортсменов, у которых личные рекорды совпадают с результатами, установленными 12-04-2014
```sql
competitions=# SELECT sportsman_name FROM sportsman RIGHT JOIN result ON sportsman.sportsman_id=result.sportsman_id WHERE personal_record=result AND hold_date='2014-04-12';
 sportsman_name 
----------------
 Спортсмен 27
 Спортсмен 28
 Спортсмен 29
 Спортсмен 30

```
-----
### Выведите наименования соревнований, у которых дата установления мирового рекорда совпадает с датой проведения соревнований в Москве 20-04-2015.
```sql
competitions=# SELECT competition_name FROM competition LEFT JOIN result ON result.competition_id=competition.competition_id WHERE city='Москва' AND set_date='2015-04-20' AND hold_date='2015-04-20';
    competition_name    
------------------------
 Бег на 1 милю. Мужчины
```
-----
### Вычислите средний результат каждого из спортсменов.
```sql
competitions=# SELECT sportsman_id, AVG(result) FROM result GROUP BY sportsman_id;
 sportsman_id |         avg          
--------------+----------------------
           29 | 495.3000000000000000
            4 | 297.2566666666666667
            9 | 415.2700000000000000
           10 | 263.2850000000000000
            7 |  34.0000000000000000
           15 | 204.1900000000000000
            6 | 459.1750000000000000
            (truncated)
```
-----
### Выведите годы рождения спортсменов, у которых результат, показанный в Москве выше среднего по всем спортсменам.
```sql
SELECT DISTINCT year_of_birth FROM sportsman RIGHT JOIN result ON result.sportsman_id=sportsman.sportsman_id WHERE result>(SELECT AVG(result) FROM result) AND city='Москва';
 year_of_birth 
---------------
          1977
          1978
          1981
          1986
          1987
          1989
          1990
          1991
          1992
          1995
          1997
          1998
```
-----
### Выведите имена всех спортсменов, у которых год рождения больше, чем год установления мирового рекорда, равного 12 с.
```sql
competitions=# SELECT  DISTINCT sportsman_name FROM sportsman FULL JOIN result ON result.sportsman_id=sportsman.sportsman_id FULL JOIN competition ON competition.competition_id=result.competition_id WHERE year_of_birth>(SELECT EXTRACT('Year' FROM set_date) FROM competition WHERE world_record=12 LIMIT 1);
 sportsman_name 
----------------
 Спортсмен 25
 Спортсмен 11
 Спортсмен 9
(truncated)
```
-----
### Выведите список спортсменов в виде 'Спортсмен ' ['имя спортсмена'] 'показал результат' ['результат'] 'в городе' ['город']
```sql
SELECT DISTINCT CONCAT('Спортсмен ',sportsman_name, ' показал результат ', result, ' в городе ', city) FROM sportsman LEFT JOIN result ON result.sportsman_id=sportsman.sportsman_id INNER JOIN competition ON competition.competition_id=result.competition_id;                              concat                               
-------------------------------------------------------------------
 Спортсмен Спортсмен 26 показал результат 45 в городе Пекин
 Спортсмен Спортсмен 23 показал результат 420.48 в городе Нью-Йорк
 Спортсмен Спортсмен 26 показал результат 488.92 в городе Пекин
 Спортсмен Спортсмен 27 показал результат 344.92 в городе Москва
 Спортсмен Спортсмен 19 показал результат 147.55 в городе Пекин
 Спортсмен Спортсмен 15 показал результат 289.33 в городе Москва
 Спортсмен Спортсмен 9 показал результат 786.42 в городе Москва
 Спортсмен Спортсмен 23 показал результат 980.95 в городе Пекин
 Спортсмен Спортсмен 8 показал результат 852.58 в городе Москва
 Спортсмен Спортсмен 19 показал результат 1.54 в городе Париж
 Спортсмен Спортсмен 30 показал результат 106.68 в городе Париж
 (truncated)
```
-----
### Выведите имена всех спортсменов, у которых разряд ниже среднего разряда всех спортсменов, родившихся в 2000 году.
```sql
competitions=# SELECT * FROM sportsman WHERE RANK<(SELECT AVG(rank) FROM sportsman WHERE year_of_birth=2000) AND year_of_birth=2000;
 sportsman_id | sportsman_name | rank | year_of_birth | personal_record | country 
--------------+----------------+------+---------------+-----------------+---------
           33 | Спортсмен 3    |    4 |          2000 |          659.00 | США
           35 | Спортсмен 5    |    2 |          2000 |          343.02 | Китай

```
-----
### Выведите данные о спортсменах, у которых персональный рекорд совпадает с мировым.
```sql
competitions=# SELECT DISTINCT sportsman.* FROM sportsman LEFT JOIN result ON result.sportsman_id=sportsman.sportsman_id INNER JOIN competition ON competition.competition_id=result.competition_id WHERE personal_record=world_record;
 sportsman_id | sportsman_name | rank | year_of_birth | personal_record | country 
--------------+----------------+------+---------------+-----------------+---------
           26 | Спортсмен 26   |   10 |          1991 |              26 | Россия
```
-----
### Определите количество участников с фамилией Иванов, которые участвовали в соревнованиях с названием, содержащим слово 'Региональные'.
```sql
SELECT COUNT(sportsman_name) FROM sportsman LEFT JOIN result ON result.sportsman_id=sportsman.sportsman_id INNER JOIN competition ON competition.competition_id=result.competition_id WHERE sportsman_name ILIKE '%иванов%' and competition_name ILIKE '%Региональные%';
 count 
-------
     1
```
-----
### Выведите города, в которых были установлены мировые рекорды.
```sql
competitions=# SELECT city FROM competition RIGHT JOIN result ON result.competition_id=competition.competition_id WHERE result=world_record;
  city  
--------
 Москва
```
-----
### Найдите минимальный разряд спортсменов, которые установили мировой рекорд.
```sql
competitions=# SELECT DISTINCT MIN(rank) FROM sportsman LEFT JOIN result ON result.sportsman_id=sportsman.sportsman_id INNER JOIN competition ON competition.competition_id=result.competition_id WHERE personal_record=world_record;
 min 
-----
  10
```
-----
### Выведите названия соревнований, на которых было установлено максимальное количество мировых рекордов.
```sql
competitions=# SELECT COUNT(competition_name),competition_name FROM competition RIGHT JOIN result ON result.competition_id=competition.competition_id WHERE result=world_record GROUP BY competition_name ORDER BY count DESC LIMIT 3;
 count |           competition_name            
-------+---------------------------------------
     7 | Бег на 3000 метров. Мужчины
     6 | Бег на 1500 метров. Мужчины
     6 | Международные соревнования по футболу
```
-----
### Определите, спортсмены какой страны участвовали в соревнованиях больше всего.
```sql
competitions=# SELECT COUNT(sportsman.sportsman_id),country FROM result RIGHT JOIN sportsman ON result.sportsman_id=sportsman.sportsman_id GROUP BY sportsman.sportsman_id ORDER BY count DESC LIMIT 1;
 count | country 
-------+---------
    35 | Россия

```
-----
### Измените разряд на 1 тех спортсменов, у которых личный рекорд совпадает с мировым.
```sql
competitions=# UPDATE sportsman SET rank=rank+1 FROM competition,result WHERE result.result=world_record;
UPDATE 39
```
-----
### Вычислите возраст спортсменов, которые участвовали в соревнованиях в Москве.
```sql
competitions=# SELECT (date_part('year', CURRENT_DATE)-year_of_birth) as age,sportsman.sportsman_id FROM result LEFT JOIN sportsman ON sportsman.sportsman_id=result.sportsman_id WHERE city='Москва';
 age | sportsman_id 
-----+--------------
  26 |           25
  42 |           27
  34 |           28
  49 |            1
  32 |            7
  42 |           15
  37 |           20
  46 |           22
  26 |           11
  (truncated)
  ```
-----
### Измените дату проведения всех соревнований, проходящих в Москве на 4 дня вперед.
```sql
competitions=# update result set hold_date=hold_date+4 WHERE city='Москва';
UPDATE 34
```
-----
### Измените страну у спортсменов, у которых разряд равен 1 или 2, с Италии на Россию.
```sql
competitions=# UPDATE sportsman SET country='Италия' WHERE rank<=2 AND country='Россия';
UPDATE 4
```
-----
### Измените название соревнований с 'Бег' на 'Бег с препятствиями'
```sql
--------------------------------------------------------
 Бег на 400 метров. Мужчины
 Бег на 800 метров. Мужчины
 Бег на 1000 метров. Мужчины
 Бег на 1500 метров. Мужчины
 Бег на 2000 метров. Мужчины
 Бег на 5000 метров. Мужчины
 Бег на 10000 метров. Мужчины
 Бег на 20000 метров. Мужчины
 Бег на 30000 метров. Мужчины
 Бег 3000 метров. Мужчины
 Бег на 110 метров c барьерами. Мужчины
 Бег на 400 метров с барьерами. Мужчины
 Бег на 25000 метров. Мужчины
 Бег. Марафон. Мужчины
 Бег на 200 метров. Мужчины
 Бег на 1 милю. Мужчины
 Бег на 3000 метров. Мужчины
 Бег на 100 метров. Мужчины
(18 rows)

competitions=# WITH cte AS (
    SELECT
        POSITION('Бег' IN competition_name) AS ch,competition_name as cte_cn 
    FROM competition
)                   
UPDATE competition SET competition_name=(LEFT(competition_name, ch+2) || ' с препятствиями' || RIGHT(competition_name, LENGTH(competition_name) - ch-2)) FROM cte WHERE ch!=0 and cte.cte_cn=competition_name;
UPDATE 18
competitions=# (get command truncated)
------------------------------------------------------------------------
 Бег с препятствиями с препятствиями на 400 метров. Мужчины
 Бег с препятствиями с препятствиями на 800 метров. Мужчины
 Бег с препятствиями с препятствиями на 1000 метров. Мужчины
 Бег с препятствиями с препятствиями на 1500 метров. Мужчины
 Бег с препятствиями с препятствиями на 2000 метров. Мужчины
 Бег с препятствиями с препятствиями на 5000 метров. Мужчины
 Бег с препятствиями с препятствиями на 10000 метров. Мужчины
 Бег с препятствиями с препятствиями на 20000 метров. Мужчины
 Бег с препятствиями с препятствиями на 30000 метров. Мужчины
 Бег с препятствиями с препятствиями 3000 метров . Мужчины
 Бег с препятствиями с препятствиями на 110 метров c барьерами. Мужчины
 Бег с препятствиями с препятствиями на 400 метров с барьерами. Мужчины
 Бег с препятствиями с препятствиями на 25000 метров. Мужчины
 Бег с препятствиями с препятствиями. Марафон. Мужчины
 Бег с препятствиями с препятствиями на 200 метров. Мужчины
 Бег с препятствиями с препятствиями на 1 милю. Мужчины
 Бег с препятствиями с препятствиями на 3000 метров. Мужчины
 Бег с препятствиями с препятствиями на 100 метров. Мужчины
(18 rows)

```
-----
### Увеличьте мировой результат на 2 с для соревнований ранее 20-03-2005.
```sql
competitions=# UPDATE competition SET world_record=world_record-2 WHERE set_date<'2005-03-20';
UPDATE 8
```
-----
### Уменьшите результаты на 2 с соревнований, которые проводились 20-05-2012 и показанный результат не менее 45 с.
```sql
competitions=# UPDATE result SET result=result-2 WHERE hold_date='2012-05-20' AND result>=45;
UPDATE 4
```
-----
### Удалите все результаты соревнований в Москве, участники которых родились не позже 1980 г.
```sql
competitions=# DELETE FROM result USING sportsman WHERE year_of_birth<=1980 and city='Москва' and result.sportsman_id=sportsman.sportsman_id;
DELETE 665
```
-----
### Удалите все соревнования, у которых результат равен 20 с.
```sql
competitions=# DELETE FROM result WHERE result=20;
DELETE 7
```
-----
### Удалите все результаты спортсменов, которые родились в 2001 году.
```sql
competitions=# DELETE FROM result USING sportsman WHERE year_of_birth=2001 and result.sportsman_id=sportsman.sportsman_id;
DELETE 7
```



