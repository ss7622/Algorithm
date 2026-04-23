with f as (select a.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY, a.price * c.sales as total from
BOOK a join AUTHOR b on a.AUTHOR_ID = b.AUTHOR_ID
join BOOK_SALES c on a.BOOK_ID = c.BOOK_ID
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1)

select AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(total) as TOTAL_SALES from f
group by AUTHOR_ID, AUTHOR_NAME, CATEGORY
order by AUTHOR_ID, CATEGORY desc