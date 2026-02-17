-- 코드를 입력하세요
SELECT BOOK_ID, date_format(PUBLISHED_DATE,'%Y-%m-%d') from book
where published_date >= '2021-01-01' and published_date <= '2021-12-31' and category = '인문'
order by PUBLISHED_DATE;

# SELECT * from book;