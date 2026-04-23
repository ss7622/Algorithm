-- 코드를 입력하세요
SELECT year(sales_date) as YEAR, month(sales_date) as MONTH, gender as GENDER, count(distinct(b.user_id)) as USERS
from ONLINE_SALE a
join USER_INFO b on a.USER_ID = b.USER_ID
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year(sales_date), month(sales_date), gender