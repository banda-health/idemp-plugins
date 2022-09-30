-- Deactivate the Advanced User ref list role item
UPDATE ad_ref_list
SET
	isactive = 'N'
WHERE
	ad_ref_list_uu = 'da77ece5-1da7-4e12-a3b5-8ed40dc85617';

SELECT register_migration_script('202209270649_GO-2457.sql') FROM dual;
