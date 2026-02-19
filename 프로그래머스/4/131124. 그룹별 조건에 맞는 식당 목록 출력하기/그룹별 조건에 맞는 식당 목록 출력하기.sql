
select member_name, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from
(SELECT *, max(cnt) over() as maxCnt
from 
(select a.member_name,b.*, (count(*) over(partition by a.MEMBER_NAME)) as cnt
 from
 MEMBER_PROFILE a join REST_REVIEW b on a.MEMBER_ID = b.MEMBER_ID
) as k) as l
where cnt = maxCnt
order by REVIEW_DATE, REVIEW_TEXT