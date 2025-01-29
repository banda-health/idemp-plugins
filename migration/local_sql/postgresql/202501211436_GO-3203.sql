UPDATE ad_menu
SET
	iscentrallymaintained = 'N',
	name                  = 'Price Lists'
WHERE
	ad_menu_uu = '8da6c2ab-7020-4cac-8f81-5e4aac53e457';

UPDATE ad_treenodemm
SET
	seqno = 6
WHERE
	ad_treenodemm_uu = '2c8670c8-e2e4-49f5-9f12-cd62ef58fc69';

SELECT
	register_migration_script('202501211436_GO-3203.sql')
FROM
	dual;
