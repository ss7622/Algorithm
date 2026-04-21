-- 코드를 입력하세요
SELECT WRITER_ID as USER_ID , b.NICKNAME, sum(price) as TOTAL_SALES from
USED_GOODS_BOARD a join USED_GOODS_USER b on a.WRITER_ID = b.USER_ID
where a.STATUS = 'DONE'
group by WRITER_ID
having sum(PRICE) >= 700000
order by sum(PRICE)