-- Grant existing system admin users access to the OTC Only client role
INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               ad_user_roles_uu)
SELECT
	u.ad_user_id,
	r_oo.ad_role_id,
	ur.ad_client_id,
	ur.ad_org_id,
	ur.isactive,
	NOW(),
	100,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	ad_client c
		JOIN ad_role r_ca
		ON r_ca.ad_client_id = c.ad_client_id AND r_ca.name = c.name || ' Clinic Admin'
		JOIN ad_user_roles ur
		ON r_ca.ad_role_id = ur.ad_role_id
		JOIN ad_user u
		ON ur.ad_user_id = u.ad_user_id AND u.ad_client_id = 0
		JOIN ad_role r_oo
		ON r_ca.ad_client_id = c.ad_client_id AND r_oo.name = c.name || ' OTC Only';

SELECT
	register_migration_script('202507071336_GO-3260.sql')
FROM
	dual;
