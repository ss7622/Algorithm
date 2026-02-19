-- 코드를 입력하세요
SELECT a.book_id, b.author_name, date_format(published_date, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK a join AUTHOR b on a.AUTHOR_ID = b.AUTHOR_ID
where category = '경제'
order by published_date