-- Get the names of duplicate rows
SELECT
	r.name
INTO TEMP TABLE
	tmp_duplicated_role_names
FROM
	ad_role r
		JOIN (
		SELECT
			ad_role_id,
			STRING_AGG(included_role_id::varchar, '_') AS role_list
		FROM
			(
				SELECT ad_role_id, included_role_id FROM ad_role_included ORDER BY ad_role_id, included_role_id
			) t
		GROUP BY
			ad_role_id
	) included_role_list
		ON r.ad_role_id = included_role_list.ad_role_id
WHERE
	ad_client_id != 0
	AND ismasterrole = 'N'
GROUP BY
	r.name, included_role_list.role_list
HAVING
	COUNT(*) > 1;

WITH role_counting AS (
	SELECT
		r.ad_role_id,
		r.name,
		ROW_NUMBER() OVER (PARTITION BY r.name ORDER BY created) AS priority
	FROM
		ad_role r
			JOIN tmp_duplicated_role_names tdrn
			ON r.name = tdrn.name
)
SELECT
	p1.ad_role_id AS new_id,
	p2.ad_role_id AS old_id
INTO TEMP TABLE
	tmp_role_mapping
FROM
	role_counting p1
		JOIN role_counting p2
		ON p1.name = p2.name AND p2.priority != 1
WHERE
	p1.priority = 1;

SELECT DISTINCT
	ur.ad_user_id,
	trm.new_id
INTO TEMP TABLE
	tmp_users_who_need_roles
FROM
	ad_user_roles ur
		JOIN tmp_role_mapping trm
		ON ur.ad_role_id = trm.old_id
		LEFT JOIN ad_user_roles ur2
		ON ur2.ad_user_id = ur.ad_user_id AND ur2.ad_role_id = trm.new_id
WHERE
	ur2.ad_user_id IS NULL;

-- Delete the old roles
DELETE
FROM
	ad_user_roles
WHERE
	ad_role_id IN (
		SELECT
			old_id
		FROM
			tmp_role_mapping
	);

-- Insert the new roles the user should have access to
INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               ad_user_roles_uu)
SELECT
	tuwnr.ad_user_id,
	tuwnr.new_id,
	u.ad_client_id,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	tmp_users_who_need_roles tuwnr
		JOIN ad_user u
		ON tuwnr.ad_user_id = u.ad_user_id;


SELECT
	register_migration_script('202501151012_GO-3115.sql')
FROM
	dual;
