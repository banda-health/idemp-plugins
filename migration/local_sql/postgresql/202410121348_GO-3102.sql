UPDATE c_bpartner bp
SET
	bh_birthday = cl.oldvalue
FROM
	ad_changelog cl
		JOIN ad_column c
		ON cl.ad_column_id = c.ad_column_id AND c.ad_column_uu = '1ad15a89-3587-4963-8e21-838d5860e577'
WHERE
	bp.c_bpartner_id = cl.record_id
	AND trxname LIKE 'ProcessVisit%'
	AND cl.newvalue IS NULL
	AND bp.bh_birthday IS NULL;

UPDATE c_bpartner bp
SET
	bh_phone = cl.oldvalue
FROM
	ad_changelog cl
		JOIN ad_column c
		ON cl.ad_column_id = c.ad_column_id AND c.ad_column_uu = '56c39b39-4d74-4c6b-a05c-c8c747d0fb76'
WHERE
	bp.c_bpartner_id = cl.record_id
	AND trxname LIKE 'ProcessVisit%'
	AND cl.newvalue IS NULL
	AND bp.bh_phone IS NULL;

UPDATE c_bpartner bp
SET
	bh_email = cl.oldvalue
FROM
	ad_changelog cl
		JOIN ad_column c
		ON cl.ad_column_id = c.ad_column_id AND c.ad_column_uu = 'c852cf44-f0e9-4936-9ef5-4f29aebff3df'
WHERE
	bp.c_bpartner_id = cl.record_id
	AND trxname LIKE 'ProcessVisit%'
	AND cl.newvalue IS NULL
	AND bp.bh_email IS NULL;

SELECT
	register_migration_script('202410121348_GO-3102.sql')
FROM
	dual;
