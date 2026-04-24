select a.EMP_NO, EMP_NAME, 
case
    when avg(SCORE) >= 96 then 'S'
    when avg(SCORE) >= 90 then 'A'
    when avg(SCORE) >= 80 then 'B'
    else 'C'
end as GRADE,
case
    when avg(SCORE) >= 96 then 0.2 * a.SAL
    when avg(SCORE) >= 90 then 0.15 * a.SAL
    when avg(SCORE) >= 80 then 0.1 * a.SAL
    else 0
end as BONUS
from HR_EMPLOYEES a
join HR_GRADE b on a.EMP_NO = b.EMP_NO
group by EMP_NO, EMP_NAME
order by EMP_NO