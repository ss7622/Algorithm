select *
from(
SELECT a.CAR_ID, a.CAR_TYPE, round(a.daily_fee * (1 - (c.discount_rate * 0.01)), 0) * 30 as FEE
from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.CAR_ID = b.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
on a.CAR_TYPE = c.CAR_TYPE
where (a.CAR_TYPE = 'SUV' or a.CAR_TYPE = '세단')
and c.duration_type = '30일 이상' and
a.car_id not in(
    select a.car_id
    from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    on a.CAR_ID = b.CAR_ID
    where (start_date <= '2022-11-30' and end_date >= '2022-11-01')
)
    ) k
where FEE >= 500000 and FEE < 2000000
group by car_id
order by FEE desc, CAR_TYPE, car_id desc
;