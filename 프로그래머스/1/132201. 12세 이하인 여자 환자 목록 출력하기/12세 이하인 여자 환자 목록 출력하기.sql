-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, TLNO from PATIENT
where TLNO is not null and age <= 12 and GEND_CD = 'W'
union all
SELECT PT_NAME, PT_NO, GEND_CD, AGE, 'NONE' from PATIENT
where TLNO is null and age <= 12 and GEND_CD = 'W'
order by age desc, PT_NAME;