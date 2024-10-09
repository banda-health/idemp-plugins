-- Create users for patients that didn't have users created
SELECT
	bp.c_bpartner_id
INTO TEMP TABLE
	tmp_bpartners_to_update
FROM
	c_bpartner bp
		LEFT JOIN ad_user u
		ON bp.c_bpartner_id = u.c_bpartner_id
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'Patients - DO NOT CHANGE'
WHERE
	u.ad_user_id IS NULL
	AND bp.created >= '2024-10-01 00:00';

DROP TABLE IF EXISTS tmp_ad_user;
CREATE TEMP TABLE tmp_ad_user
(
	ad_user_id     serial                  NOT NULL,
	ad_client_id   numeric(10)             NOT NULL,
	ad_org_id      numeric(10)             NOT NULL,
	createdby      numeric(10) DEFAULT 100 NOT NULL,
	updatedby      numeric(10) DEFAULT 100 NOT NULL,
	name           varchar(60)             NOT NULL,
	c_bpartner_id  numeric(10),
	isfullbpaccess char        DEFAULT 'N' NOT NULL,
	ad_user_uu     uuid        DEFAULT uuid_generate_v4()
);
-- SET sequence
SELECT
	SETVAL(
		'tmp_ad_user_ad_user_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'AD_User'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_ad_user (ad_client_id, ad_org_id, name, c_bpartner_id)
SELECT
	ad_client_Id,
	ad_org_id,
	name,
	bp.c_bpartner_id
FROM
	tmp_bpartners_to_update tbp
		JOIN c_bpartner bp
		ON bp.c_bpartner_id = tbp.c_bpartner_id;

INSERT INTO
	ad_user (ad_user_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, isfullbpaccess, ad_user_uu)
SELECT
	ad_user_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	c_bpartner_id,
	isfullbpaccess,
	ad_user_uu
FROM
	tmp_ad_user;

SELECT
	update_sequences();

SELECT
	register_migration_script('202410090811_GO-3100.sql')
FROM
	dual;
