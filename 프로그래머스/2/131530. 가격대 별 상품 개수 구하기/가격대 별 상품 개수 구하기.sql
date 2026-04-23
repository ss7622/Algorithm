with a as(
    select product_id,  product_code, 
    case
        when price then truncate(price, -4)
    end as PRICE
    from PRODUCT
)

select PRICE as PRICE_GROUP, count(*) as PRODUCTS from a
group by PRICE
order by PRICE