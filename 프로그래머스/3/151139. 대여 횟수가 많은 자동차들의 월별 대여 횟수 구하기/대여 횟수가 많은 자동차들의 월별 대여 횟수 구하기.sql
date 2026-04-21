-- 코드를 입력하세요
with b as (SELECT car_ID from
CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
group by CAR_ID
having count(*) >= 5)

select month(start_date) as MONTH, a.CAR_ID as CAR_ID, count(*) as RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
join b on a.car_ID = b.car_ID
where START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
group by month(start_date), a.car_id
order by month(start_date), a.car_id desc