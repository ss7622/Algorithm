-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(total) as SALES
from 
(select a.PRODUCT_CODE, b.*, (a.price * b.sales_amount) as total
    from PRODUCT a join OFFLINE_SALE b on a.PRODUCT_ID = b.PRODUCT_ID
) as k
group by product_id
order by SALES desc, PRODUCT_CODE