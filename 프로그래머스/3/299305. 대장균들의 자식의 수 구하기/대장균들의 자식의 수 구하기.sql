-- 코드를 작성해주세요

select a.id as id, count(b.id) as CHILD_COUNT
from ECOLI_DATA a left join ECOLI_DATA b on a.ID = b.PARENT_ID
group by a.id
order by a.id
