-- Get the triage roles that don't have triage master role
SELECT
	r.ad_role_id,
	ar.seqno + 10 AS seqno
INTO
	tmp_roles_to_update
FROM
	ad_role r
		JOIN ad_role_included ar
		ON r.ad_role_id = ar.ad_role_id
		JOIN ad_role must_haves
		ON ar.included_role_id = must_haves.ad_role_id AND must_haves.ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
WHERE
	r.ismasterrole = 'N'
	AND r.ad_client_id > 999999
	AND r.ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			ad_role_included
		WHERE
			included_role_id = (
				SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf'
			)
	)
	AND r.name LIKE '%Triage';

-- Add the master role to each of these roles that don't have it
INSERT INTO
	ad_role_included (ad_client_id, ad_org_id, ad_role_id, created, createdby, included_role_id, isactive, seqno, updated,
	                  updatedby, ad_role_included_uu)
SELECT
	r.ad_client_id,
	0,
	trtu.ad_role_id,
	NOW(),
	100,
	triage_master.ad_role_id,
	'Y',
	trtu.seqno,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	tmp_roles_to_update trtu
		JOIN ad_role r
		ON trtu.ad_role_id = r.ad_role_id
		JOIN ad_role triage_master
		ON triage_master.ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf';

-- We did this in the UI, but do it here, too
UPDATE bh_defaultincludedrole
SET
	isactive = 'Y'
WHERE
	db_usertype = 'T'
	AND included_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf'
	);

SELECT
	register_migration_script('202501150550_GO-3198.sql')
FROM
	dual;
