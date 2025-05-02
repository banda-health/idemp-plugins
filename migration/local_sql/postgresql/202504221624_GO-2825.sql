-- Remove reset process from Must Haves
DELETE
FROM
	ad_process_access
WHERE
	ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '25239635-591f-4940-bfb4-46533068af7d'
	)
	AND ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
	);

-- Add the reset process to the clinic admin
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	ad_process_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_process p
		JOIN ad_role r
		ON r.ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
WHERE
	p.ad_process_uu = '25239635-591f-4940-bfb4-46533068af7d';

-- Finish
SELECT
	register_migration_script('202504221624_GO-2825.sql')
FROM
	dual;
