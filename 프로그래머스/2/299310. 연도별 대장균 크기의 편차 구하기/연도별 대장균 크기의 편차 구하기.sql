select year, (max(SIZE_OF_COLONY) over(partition by year) - SIZE_OF_COLONY) as YEAR_DEV, id
from 
(
    select *, year(DIFFERENTIATION_DATE) as year
    from ECOLI_DATA
) as a
order by YEAR, YEAR_DEV