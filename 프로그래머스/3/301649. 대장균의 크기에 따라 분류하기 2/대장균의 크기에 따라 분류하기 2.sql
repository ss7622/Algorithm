-- 코드를 작성해주세요

select ID,
(case
    when ECOLI_DATA_COPY.a/total <= 0.25 then 'CRITICAL'
    when ECOLI_DATA_COPY.a/total <= 0.5 then 'HIGH'
    when ECOLI_DATA_COPY.a/total <= 0.75 then 'MEDIUM'
    else 'LOW'
end) as COLONY_NAME
from (select ECOLI_DATA.ID, rank() over(order by SIZE_OF_COLONY desc) as a, count(*) over() as total
from ECOLI_DATA) as ECOLI_DATA_COPY
group by id
order by id