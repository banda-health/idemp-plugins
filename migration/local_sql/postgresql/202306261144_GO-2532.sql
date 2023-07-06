UPDATE ad_process_para
SET
	name          = 'BH_Visit_UU',
	columnname    = 'BH_Visit_UU',
	ad_element_id = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a699c600-3a66-4151-aadf-4cbfd2118abc'
	)
WHERE
	ad_process_para_uu = '989edccc-2afd-4096-ad58-bf076ab4b698';

SELECT
	register_migration_script('202306261144_GO-2532.sql')
FROM
	dual;
