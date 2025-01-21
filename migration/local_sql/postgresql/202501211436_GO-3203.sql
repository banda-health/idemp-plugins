UPDATE ad_menu SET iscentrallymaintained = 'N', name = 'Price Lists' WHERE ad_menu_uu = '8da6c2ab-7020-4cac-8f81-5e4aac53e457';

SELECT
	register_migration_script('202501211436_GO-3203.sql')
FROM
	dual;
