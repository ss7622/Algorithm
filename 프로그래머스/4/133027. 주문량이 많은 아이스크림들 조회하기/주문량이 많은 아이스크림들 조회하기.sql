-- 코드를 입력하세요
SELECT a.FLAVOR as FLAVOR
from FIRST_HALF a join (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER  from july group by FLAVOR) b on a.FLAVOR = b.FLAVOR
order by (a.TOTAL_ORDER+b.TOTAL_ORDER) desc
limit 3 offset 0;

