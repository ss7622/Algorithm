-- 코드를 입력하세요
SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where year(SALES_DATE) = '2022' and month(SALES_DATE) = '03'
union all
SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE
where year(SALES_DATE) = '2022' and month(SALES_DATE) = '03'
order by SALES_DATE, PRODUCT_ID, USER_ID;