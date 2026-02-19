-- 코드를 입력하세요
SELECT a.PRODUCT_ID, a.PRODUCT_NAME, sum(PRICE * AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT a left join FOOD_ORDER b on a.PRODUCT_ID = b.PRODUCT_ID
where year(PRODUCE_DATE) = '2022' and month(PRODUCE_DATE) = '05'
group by a.PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID