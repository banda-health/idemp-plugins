-- Delete incorrectly assigned attribute set exclusions
DELETE
FROM
	m_attributesetexclude
WHERE
	m_attributeset_id IN (1000146, 1000225)
	AND ad_client_id != 2;

-- Some new clients didn't get any attribute set exclusions, so add them
DROP TABLE IF EXISTS tmp_ad_client_id;
SELECT DISTINCT
	ad_client_id
INTO TEMP TABLE
	tmp_ad_client_id
FROM
	m_attributeset
WHERE
	name IN ('With Expiry', 'Without Expiry')
	AND m_attributeset_id NOT IN (
	SELECT
		m_attributeset_id
	FROM
		m_attributesetexclude
);

CREATE TEMP TABLE IF NOT EXISTS tmp_m_attributesetexclude
(
	m_attributesetexclude_id serial,
	ad_client_id             numeric(10)                     NOT NULL,
	ad_org_id                numeric(10) DEFAULT 0           NOT NULL,
-- 	isactive                 char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                  timestamp   DEFAULT NOW()       NOT NULL,
	createdby                numeric(10)                     NOT NULL,
-- 	updated                  timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                numeric(10)                     NOT NULL,
	m_attributeset_id        numeric(10)                     NOT NULL,
	ad_table_id              numeric(10)                     NOT NULL,
	issotrx                  char        DEFAULT 'Y'::bpchar NOT NULL,
	m_attributesetexclude_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_m_attributesetexclude_m_attributesetexclude_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'M_AttributeSetExclude'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_m_attributesetexclude (ad_client_id, createdby, updatedby, m_attributeset_id, ad_table_id, issotrx)
SELECT
	c.ad_client_id,
	ase.createdby,
	ase.updatedby,
	clientattrs.m_attributeset_id,
	ase.ad_table_id,
	ase.issotrx
FROM
	m_attributesetexclude ase
		CROSS JOIN tmp_ad_client_id c
		JOIN m_attributeset configattrs
			ON ase.m_attributeset_id = configattrs.m_attributeset_id
		JOIN m_attributeset clientattrs
			ON clientattrs.ad_client_id = c.ad_client_id AND configattrs.name = clientattrs.name
WHERE
	ase.ad_client_id = 2;

INSERT INTO
	m_attributesetexclude (m_attributesetexclude_id, ad_client_id, ad_org_id, createdby,
	                       updatedby, m_attributeset_id, ad_table_id, issotrx, m_attributesetexclude_uu)
SELECT
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	issotrx,
	m_attributesetexclude_uu
FROM
	tmp_m_attributesetexclude;

UPDATE m_attributeset
SET
	bh_locked = 'Y'
WHERE
	name IN ('With Expiry', 'Without Expiry')
	AND bh_locked = 'N';

SELECT update_sequences();

SELECT register_migration_script('202207180700_GO-2386.sql') FROM dual;
