select sum(c.score) as SCORE, b.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL from
HR_EMPLOYEES b join HR_GRADE c on b.EMP_NO = c.EMP_NO
where b.EMP_NO = 
(select emp_no from HR_GRADE
where year = 2022
group by EMP_NO,YEAR
order by sum(score) desc
limit 1) and c.year = 2022
group by EMP_NO,YEAR