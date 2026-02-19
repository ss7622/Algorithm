-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPERS
where id in (select id
from developers a join SKILLCODES b
where (a.SKILL_CODE & b.CODE) > 0
and CATEGORY = 'Front End')
order by id