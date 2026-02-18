with recursive generation as(
    select ID, PARENT_ID, 1 as gen
    from ECOLI_DATA
    where PARENT_ID is null
    union all
    select e.id, e.parent_id, g.gen+1
    from ECOLI_DATA e join generation g
    on g.id = e.parent_id
)

select count(*) as COUNT, gen as GENERATION
from generation g left join ECOLI_DATA a on g.id = a.PARENT_ID
where a.id is null
group by gen
order by gen;