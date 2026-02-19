-- 코드를 작성해주세요
select ID, FISH_NAME, LENGTH
from 
(
select a.ID, a.FISH_TYPE, a.LENGTH, a.TIME, b.FISH_NAME, rank() over(partition by a.FISH_TYPE order by a.LENGTH desc) as r
    from FISH_INFO a left join FISH_NAME_INFO b  on a.FISH_TYPE = b.FISH_TYPE
) ta
where r = 1
order by id;