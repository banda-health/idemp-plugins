DROP TABLE IF EXISTS tmp_c_bpartner_location;
CREATE TEMP TABLE tmp_c_bpartner_location
(
	c_bpartner_location_id serial                  NOT NULL,
	ad_client_id           numeric(10)             NOT NULL,
	ad_org_id              numeric(10)             NOT NULL,
-- 	isactive               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp   DEFAULT NOW()       NOT NULL,
	createdby              numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                timestamp   DEFAULT NOW()       NOT NULL,
	updatedby              numeric(10) DEFAULT 100 NOT NULL,
	name                   varchar(60)             NOT NULL,
-- 	isbillto               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isshipto               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	ispayfrom              char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isremitto              char        DEFAULT 'Y'::bpchar NOT NULL,
	phone                  varchar(40),
	phone2                 varchar(40),
	fax                    varchar(40),
	isdn                   varchar(40),
	c_salesregion_id       numeric(10),
	c_bpartner_id          numeric(10)             NOT NULL,
	c_location_id          numeric(10),
	c_bpartner_location_uu uuid        DEFAULT uuid_generate_v4()
-- 	customeraddressid      varchar(60) DEFAULT NULL::character varying,
-- 	ispreservecustomname   char        DEFAULT 'N'::bpchar NOT NULL
);
SELECT
	SETVAL(
		'tmp_c_bpartner_location_c_bpartner_location_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BPartner_Location'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_bpartner_location (ad_client_id, ad_org_id, name, phone, phone2, fax, isdn, c_salesregion_id, c_bpartner_id,
	                         c_location_id)
SELECT
	bpl.ad_client_id,
	bpl.ad_org_id,
	bpl.name,
	bpl.phone,
	bpl.phone2,
	bpl.fax,
	bpl.isdn,
	bpl.c_salesregion_id,
	bp_sha.c_bpartner_id,
	bpl.c_location_id
FROM
	c_bpartner_location bpl
		JOIN c_bpartner bp_nhif
		ON bpl.c_bpartner_id = bp_nhif.c_bpartner_id AND bp_nhif.name = 'NHIF National Scheme'
		JOIN c_bpartner bp_sha
		ON bp_nhif.ad_client_id = bp_sha.ad_client_id AND bp_sha.name = 'Social Health Authority';

INSERT INTO
	c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, phone, phone2, fax,
	                     isdn, c_salesregion_id, c_bpartner_id, c_location_id, c_bpartner_location_uu)
SELECT
	c_bpartner_location_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	phone,
	phone2,
	fax,
	isdn,
	c_salesregion_id,
	c_bpartner_id,
	c_location_id,
	c_bpartner_location_uu
FROM
	tmp_c_bpartner_location;

SELECT
	update_sequences();

SELECT
	register_migration_script('202410231657_GO-3120.sql')
FROM
	dual;
