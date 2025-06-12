
UPDATE ad_process_para
SET
	name                  = 'Tags',
	iscentrallymaintained = 'N'
WHERE
	ad_process_para_uu = 'e4d09b67-0da6-4be5-aca8-23ef940e9acf';

SELECT
	register_migration_script('202505231038_GO-3295.sql')
FROM
	dual;
