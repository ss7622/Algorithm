-- 코드를 입력하세요
with joined2021 as 
(select count(*) as joinedCnt2021
from USER_INFO
where user_id in (SELECT user_id
from USER_INFO
where year(joined)  = '2021'))
select salesYear as YEAR, salesMonth as MONTH, count(distinct user_id) as PURCHASED_USERS,
round(count(distinct user_id)/joinedCnt2021, 1) as PUCHASED_RATIO
from(
select a.*, b.ONLINE_SALE_ID,joinedCnt2021, year(sales_date) as salesYear, month(sales_date) as salesMonth
from
USER_INFO a join ONLINE_SALE b on a.USER_ID = b.USER_ID join joined2021
where year(joined)  = '2021'
) as k
group by salesYear, salesMonth