-- 코드를 작성해주세요
select c.ID
from ECOLI_DATA a join ECOLI_DATA b on a.ID = b.PARENT_ID
join ECOLI_DATA c on b.ID = c.PARENT_ID
where a.PARENT_ID is null
order by c.id