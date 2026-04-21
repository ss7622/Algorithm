SELECT a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES
from REST_INFO a join 
(select max(FAVORITES) as f, FOOD_TYPE
from REST_INFO
group by FOOD_TYPE
) as b on a.FOOD_TYPE = b.FOOD_TYPE and a.FAVORITES = b.f
order by a.FOOD_TYPE desc