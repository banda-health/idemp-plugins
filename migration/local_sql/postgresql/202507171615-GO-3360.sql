-- Grant patient view privileges to Accountant and Triage roles
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'N',
	uuid_generate_v4(),
	'N'
FROM
	ad_window w
		JOIN ad_role r
		ON r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', 'ae618e24-a47a-40cc-bb5c-8dca64d86daf')
WHERE
	ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782';

SELECT
	register_migration_script('202507171615-GO-3360.sql')
FROM
	dual;
