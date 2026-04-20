select count(*) as FISH_COUNT, FISH_NAME from FISH_INFO a
join FISH_NAME_INFO b on a.FISH_TYPE = b.FISH_TYPE
group by a.FISH_TYPE, FISH_NAME
order by count(*) desc