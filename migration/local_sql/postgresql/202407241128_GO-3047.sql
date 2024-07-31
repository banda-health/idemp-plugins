-- Ensure the clinic admin can work with images/logos
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
	w.ad_window_uu = '2fa5f5cd-0a9d-4485-b3fb-51b0e59da956';

SELECT
	register_migration_script('202407241128_GO-3047.sql')
FROM
	dual;
