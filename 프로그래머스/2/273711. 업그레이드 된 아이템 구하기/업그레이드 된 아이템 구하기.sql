select info2.ITEM_ID as ITEM_ID, info2.ITEM_NAME as ITEM_NAME, info2.RARITY as RARITY
from ITEM_INFO as info join ITEM_TREE as tree on info.ITEM_ID = tree.PARENT_ITEM_ID
join ITEM_INFO as info2 on tree.ITEM_ID = info2.ITEM_ID
where info.RARITY = 'RARE'
order by info2.ITEM_ID desc;
