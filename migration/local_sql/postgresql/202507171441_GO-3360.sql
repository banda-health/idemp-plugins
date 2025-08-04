DELETE
from ad_menu
where ad_menu_uu = 'f87dbeb1-8584-44ae-a91c-f80449090a78';

SELECT
	register_migration_script('202507171441_GO-3360.sql')
FROM
	dual;
