-- 1. Update Payment Rules.
-- 2. Create missing locations.
-- 3. Fix erroneous OTC names. 
-- 4. Fix missing pricelists
-- Update payment rules of the OTC business partners to be credit
UPDATE c_bpartner
SET
	paymentrule    = 'P', -- on credit
	socreditstatus = 'X'  -- no credit check
WHERE
	ad_client_id > 999999 or ad_client_id = 2;
	
-- Get OTC patients
DROP TABLE IF EXISTS tmp_otc_c_bpartner;

CREATE TEMP TABLE tmp_otc_c_bpartner
(
	ad_client_id  				numeric(10)             NOT NULL,
	ad_org_id     				numeric(10)             NOT NULL,
	c_bpartner_id  				numeric(10)             NOT NULL,
	c_bpartner_location_id      numeric(10)             NULL,
	name          				varchar(255)			NOT NULL,
	client_name					varchar(255)			NOT NULL,
	m_pricelist_id				numeric(10)				NULL,
	existing_pricelist_id		numeric(10)				NULL
);
INSERT INTO
	tmp_otc_c_bpartner (ad_client_id, ad_org_id, c_bpartner_id, c_bpartner_location_id, name, client_name, m_pricelist_id, existing_pricelist_id) 
	SELECT 
			bp.ad_client_id, bp.ad_org_id, bp.c_bpartner_id, l.c_bpartner_location_id, bp.name, a.name, COALESCE(g.m_pricelist_id, (
				         SELECT
					         l.m_pricelist_id
				         FROM
					         m_pricelist l
				         WHERE
					         l.ad_client_id = bp.ad_client_id
					         AND isdefault = 'Y'
					         AND issopricelist = 'Y'
			         ), (
				         SELECT
					         l.m_pricelist_id
				         FROM
					         m_pricelist l
				         WHERE
					         l.ad_client_id = bp.ad_client_id
					         AND isdefault = 'Y'
				         LIMIT 1
			         ), 0), 
	bp.m_pricelist_id 
FROM 
	c_bpartner bp 
INNER JOIN 
	c_bp_group g ON bp.c_bp_group_id = g.c_bp_group_id AND g.name = 'OTC Patient'
INNER JOIN 
	ad_client a ON bp.ad_client_id = a.ad_client_id
LEFT JOIN 
	c_bpartner_location l ON bp.c_bpartner_id = l.c_bpartner_id;	
	
-- create missing bpartner locations for OTC business partners
DROP TABLE IF EXISTS tmp_c_location;

CREATE TEMP TABLE tmp_c_location
(
	c_location_id serial                  NOT NULL,
	ad_client_id  numeric(10)             NOT NULL,
	ad_org_id     numeric(10)             NOT NULL,
	createdby     numeric(10) DEFAULT 100 NOT NULL,
	updatedby     numeric(10) DEFAULT 100 NOT NULL,
	c_country_id  numeric(10)             NOT NULL,
	c_location_uu uuid        DEFAULT uuid_generate_v4()
);
-- SET sequence
SELECT
	SETVAL(
			'tmp_c_location_c_location_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Location'
				LIMIT 1
			)::INT,
			FALSE
		);

-- Get the country from the last entered location.
INSERT INTO
	tmp_c_location (ad_client_id, ad_org_id, c_country_id)
SELECT
	c.ad_client_id,
	c.ad_org_id,
	(
		SELECT
			c_country_id
		FROM
			c_location
		WHERE
			c_country_id IS NOT NULL
			AND ad_client_id = c.ad_client_id
		ORDER BY created DESC
		LIMIT 1
	)
FROM
	tmp_otc_c_bpartner c
WHERE 
	c.c_bpartner_location_id IS NULL;

-- Create locations..
INSERT INTO
	c_location (c_location_id, ad_client_id, ad_org_id, createdby, updatedby, c_country_id, c_location_uu)
SELECT
	c_location_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_country_id,
	c_location_uu
FROM
	tmp_c_location; 
	
-- create c_bpartner_locations	
DROP TABLE IF EXISTS tmp_c_bpartner_location;

CREATE TEMP TABLE tmp_c_bpartner_location
(
	c_bpartner_location_id serial                                 NOT NULL,
	ad_client_id           numeric(10)                            NOT NULL,
	ad_org_id              numeric(10)                            NOT NULL,
	createdby              numeric(10) DEFAULT 100                NOT NULL,
	updatedby              numeric(10) DEFAULT 100                NOT NULL,
	name                   varchar(60) DEFAULT 'Default Location' NOT NULL,
	c_bpartner_id          numeric(10)                            NOT NULL,
	c_location_id          numeric(10),
	c_bpartner_location_uu uuid        DEFAULT uuid_generate_v4()
);

-- SET sequence
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
	tmp_c_bpartner_location (ad_client_id, ad_org_id, c_bpartner_id, c_location_id)
SELECT
	c.ad_client_id,
	c.ad_org_id,
	b.c_bpartner_id,
	c.c_location_id
FROM
	tmp_c_location c
		INNER JOIN tmp_otc_c_bpartner b
			ON c.ad_client_id = b.ad_client_id;

INSERT INTO
	c_bpartner_location (
		c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, c_location_id, c_bpartner_location_uu
	)
SELECT
	c_bpartner_location_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	c_bpartner_id,
	c_location_id,
	c_bpartner_location_uu
FROM
	tmp_c_bpartner_location;	

-- Fix erroneous OTC names
UPDATE 
	c_bpartner c
SET 
	name = CONCAT('OTC - ', tmp.client_name)
FROM 
	tmp_otc_c_bpartner tmp
WHERE 
	replace(tmp.name, 'OTC - ', '') != tmp.client_name 
AND 
	c.c_bpartner_id = tmp.c_bpartner_id;
	
-- Fix missing pricelists..
UPDATE 
	c_bpartner c
SET 
	m_pricelist_id = tmp.m_pricelist_id
FROM 
	tmp_otc_c_bpartner tmp
WHERE 
	tmp.existing_pricelist_id is null
AND 
	c.c_bpartner_id = tmp.c_bpartner_id;
	
DROP TABLE tmp_c_location;

DROP TABLE tmp_c_bpartner_location;

DROP TABLE tmp_otc_c_bpartner;
	
SELECT
	update_sequences();

SELECT
	register_migration_script('202301181056_GO-2527.sql')
FROM
	dual;
