-- 코드를 입력하세요
SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, b.REVIEW_SCORE as SCORE
from REST_INFO a join (select REST_ID, round(avg(REVIEW_SCORE), 2) as REVIEW_SCORE from REST_REVIEW
group by REST_ID) as b on a.REST_ID = b.REST_ID
where a.ADDRESS like('서울%')
order by SCORE desc, FAVORITES desc;
