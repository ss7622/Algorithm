with car as
(select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date <= '2022-10-16'and END_DATE >= '2022-10-16'
group by CAR_ID)

SELECT CAR_ID,
CASE
    when car_ID in (select * from car) then '대여중'
    else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc