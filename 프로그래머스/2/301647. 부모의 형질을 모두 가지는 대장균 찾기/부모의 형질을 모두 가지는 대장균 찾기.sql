-- 코드를 작성해주세요
select b.ID, b.GENOTYPE, a.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA a left join ECOLI_DATA b on a.ID = b.PARENT_ID
where b.GENOTYPE & a.GENOTYPE = a.GENOTYPE
order by b.id