with c as(select CATEGORY, max(PRICE) as mpirce from FOOD_PRODUCT
where CATEGORY = '과자' || CATEGORY = '국' || CATEGORY = '김치' || CATEGORY = '식용유'
group by CATEGORY)

select a.CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME from FOOD_PRODUCT a join c
on a.CATEGORY = c.CATEGORY and a.PRICE = c.mpirce
order by PRICE desc