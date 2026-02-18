-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python') > 0
or SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#') > 0
order by id