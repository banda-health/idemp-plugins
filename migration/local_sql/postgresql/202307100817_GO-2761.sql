-- Remove duplicate roles
DROP TABLE IF EXISTS tmp_duplicate_roles;
SELECT
	rtk.ad_role_id   AS role_to_keep,
	r_dup.ad_role_id AS role_to_delete
INTO TEMP TABLE
	tmp_duplicate_roles
FROM
	ad_role r
		JOIN (
		SELECT MIN(ad_role_id) AS ad_role_id FROM ad_role GROUP BY name HAVING COUNT(*) > 1
	) rtk
		ON r.ad_role_id = rtk.ad_role_id
		JOIN ad_role r_dup
		ON r_dup.name = r.name AND r.ad_role_id != r_dup.ad_role_id;

-- Ensure all users are assigned to the duplicate roles are assigned to the new role
INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               ad_user_roles_uu)
SELECT
	ad_user_id,
	role_to_keep,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	uuid_generate_v4()
FROM
	ad_user_roles ur
		JOIN tmp_duplicate_roles tdr
		ON ur.ad_role_id = tdr.role_to_delete
WHERE
		ad_role_id IN (
		SELECT
			role_to_delete
		FROM
			tmp_duplicate_roles
	)
ON CONFLICT DO NOTHING;

-- Ensure the role we're keeping has the correct organization access
INSERT INTO
	ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, createdby, updatedby)
SELECT
	role_to_keep,
	o.ad_org_id,
	o.ad_client_id,
	100,
	100
FROM
	ad_org o
		JOIN ad_client c
		ON o.ad_client_id = c.ad_client_id
		JOIN ad_role r
		ON c.ad_client_id = r.ad_client_id
		JOIN tmp_duplicate_roles tdr
		ON tdr.role_to_keep = r.ad_role_id
WHERE
		ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			ad_role_orgaccess
		WHERE
			o.ad_org_id = ad_org_id
	);

-- Delete the duplicate roles' org access, user assignment, & included roles
DELETE
FROM
	ad_role_orgaccess
WHERE
		ad_role_id IN (
		SELECT
			role_to_delete
		FROM
			tmp_duplicate_roles
	);
DELETE
FROM
	ad_user_roles
WHERE
		ad_role_id IN (
		SELECT
			role_to_delete
		FROM
			tmp_duplicate_roles
	);
DELETE
FROM
	ad_role_included
WHERE
		ad_role_id IN (
		SELECT
			role_to_delete
		FROM
			tmp_duplicate_roles
	);

-- Delete the duplicate roles
DELETE
FROM
	ad_role
WHERE
		ad_role_id IN (
		SELECT
			role_to_delete
		FROM
			tmp_duplicate_roles
	);

-- Now update role assignments
UPDATE ad_user_roles ur
SET
	ad_role_id = CASE WHEN r_bad.ismasterrole = 'Y' THEN r_c.ad_role_id ELSE r_crb.ad_role_id END
FROM
	ad_user u
		JOIN ad_client c
		ON u.ad_client_id = c.ad_client_id
		CROSS JOIN ad_role r_bad
		LEFT JOIN ad_role r_c
		ON c.name || ' ' || r_bad.name = r_c.name
		LEFT JOIN ad_role r_crb
		ON r_crb.name = c.name || ' Cashier/Registration Basic'
WHERE
	ur.ad_user_id = u.ad_user_id
	AND r_bad.ad_role_id = ur.ad_role_id
	AND u.ad_org_id != 0
	AND (r_bad.name = c.name || ' User' OR r_bad.ismasterrole = 'Y');

-- Make sure all default roles have the correct organization access
INSERT INTO
	ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, createdby, updatedby)
SELECT
	r.ad_role_id,
	o.ad_org_id,
	o.ad_client_id,
	100,
	100
FROM
	ad_org o
		JOIN ad_client c
		ON o.ad_client_id = c.ad_client_id
		JOIN ad_role r
		ON c.ad_client_id = r.ad_client_id
WHERE
		ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			ad_role_orgaccess
	)
	AND r.name != c.name || ' User'
	AND r.ismasterrole = 'N';

SELECT
	register_migration_script('202307100817_GO-2761.sql')
FROM
	dual;
