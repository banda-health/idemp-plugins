-- Add Role window access to "Clinic Admin" role since sometimes roles need to be created when working with users
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, ad_window_access_uu)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	0,
	0,
	100,
	100,
	uuid_generate_v4()
FROM
	ad_window w
		JOIN ad_role r
		ON r.ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
WHERE
	w.ad_window_uu = '8794d7c3-733c-4a4d-a2d9-f6a9afef594e'
-- This was added in Kenya PROD as a quick-fix, so add the next line to make sure it works there and elsewhere
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202407311343_GO-3305.sql')
FROM
	dual;
