-- Add price list schemas for all clients
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_ad_client_ids
FROM
	ad_client
WHERE
	ad_client_id = 2
	OR ad_client_id > 999999;

CREATE TEMP TABLE tmp_m_discountschema
(
	m_discountschema_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                timestamp   DEFAULT NOW()       NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	name                varchar(60)             NOT NULL,
	description         varchar(255),
	validfrom           timestamp               NOT NULL,
	discounttype        char        DEFAULT 'P' NOT NULL,
	script              varchar(2000),
	flatdiscount        numeric     DEFAULT 0,
-- 	isquantitybased        char        DEFAULT 'Y'::bpchar NOT NULL,
	cumulativelevel     char        DEFAULT 'L',
	processing          char        DEFAULT 'N',
-- 	isbpartnerflatdiscount char        DEFAULT 'N'::bpchar NOT NULL,
	m_discountschema_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
		'tmp_m_discountschema_m_discountschema_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'M_DiscountSchema'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_m_discountschema (ad_client_id, name, description, validfrom, script)
SELECT
	c.ad_client_id,
	'Default Price List Schema - DO NOT CHANGE',
	NULL,
	ds.validfrom,
	NULL
FROM
	tmp_ad_client_ids c
		JOIN m_discountschema ds
		ON ds.ad_client_id = c.ad_client_id;

INSERT INTO
	m_discountschema (m_discountschema_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, validfrom,
	                  discounttype, script, flatdiscount, cumulativelevel, processing, m_discountschema_uu)
SELECT
	m_discountschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	validfrom,
	discounttype,
	script,
	flatdiscount,
	cumulativelevel,
	processing,
	m_discountschema_uu
FROM
	tmp_m_discountschema;

-- Add schema lines for these schemas
CREATE TEMP TABLE tmp_m_discountschemaline
(
	m_discountschemaline_id serial                          NOT NULL,
	ad_client_id            numeric(10)                     NOT NULL,
	ad_org_id               numeric(10) DEFAULT 0           NOT NULL,
-- 	isactive                char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                 timestamp    DEFAULT NOW()       NOT NULL,
	createdby               numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                 timestamp    DEFAULT NOW()       NOT NULL,
	updatedby               numeric(10) DEFAULT 100         NOT NULL,
	m_discountschema_id     numeric(10)                     NOT NULL,
	seqno                   numeric(10) DEFAULT 10          NOT NULL,
-- 	m_product_category_id   numeric(10),
-- 	c_bpartner_id           numeric(10),
-- 	m_product_id            numeric(10),
	conversiondate          timestamp   DEFAULT NOW()::date NOT NULL,
	list_base               char        DEFAULT 'L'         NOT NULL,
-- 	list_addamt             numeric      DEFAULT 0           NOT NULL,
	list_discount           numeric     DEFAULT 0           NOT NULL,
	list_rounding           char        DEFAULT 'C'         NOT NULL,
-- 	list_minamt             numeric      DEFAULT 0           NOT NULL,
-- 	list_maxamt             numeric      DEFAULT 0           NOT NULL,
-- 	list_fixed              numeric      DEFAULT 0,
	std_base                char        DEFAULT 'S'         NOT NULL,
-- 	std_addamt              numeric      DEFAULT 0           NOT NULL,
	std_discount            numeric     DEFAULT 0           NOT NULL,
	std_rounding            char        DEFAULT 'C'         NOT NULL,
-- 	std_minamt              numeric      DEFAULT 0           NOT NULL,
-- 	std_maxamt              numeric      DEFAULT 0           NOT NULL,
-- 	std_fixed               numeric      DEFAULT 0,
	limit_base              char        DEFAULT 'X'         NOT NULL,
-- 	limit_addamt            numeric      DEFAULT 0           NOT NULL,
	limit_discount          numeric     DEFAULT 0           NOT NULL,
	limit_rounding          char        DEFAULT 'C'         NOT NULL,
-- 	limit_minamt            numeric      DEFAULT 0           NOT NULL,
-- 	limit_maxamt            numeric      DEFAULT 0           NOT NULL,
-- 	limit_fixed             numeric      DEFAULT 0,
	c_conversiontype_id     numeric(10) DEFAULT 114         NOT NULL,
	m_discountschemaline_uu uuid        DEFAULT uuid_generate_v4()
-- 	description             varchar(255) DEFAULT NULL::character varying,
-- 	isignoreiscurrentvendor char         DEFAULT 'N'::bpchar NOT NULL,
-- 	vendorcategory          varchar(30)  DEFAULT NULL::character varying
);

SELECT
	SETVAL(
		'tmp_m_discountschemaline_m_discountschemaline_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'M_DiscountSchemaLine'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_m_discountschemaline (ad_client_id, m_discountschema_id)
SELECT
	ad_client_id,
	m_discountschema_id
FROM
	tmp_m_discountschema;

INSERT INTO
	m_discountschemaline (m_discountschemaline_id, ad_client_id, ad_org_id, createdby, updatedby, m_discountschema_id,
	                      seqno, conversiondate, list_base, list_discount, list_rounding, std_base, std_discount,
	                      std_rounding, limit_base, limit_discount, limit_rounding, c_conversiontype_id,
	                      m_discountschemaline_uu)
SELECT
	m_discountschemaline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_discountschema_id,
	seqno,
	conversiondate,
	list_base,
	list_discount,
	list_rounding,
	std_base,
	std_discount,
	std_rounding,
	limit_base,
	limit_discount,
	limit_rounding,
	c_conversiontype_id,
	m_discountschemaline_uu
FROM
	tmp_m_discountschemaline;

-- Register the script and be done
SELECT
	register_migration_script('202502052042_GO-3202.sql')
FROM
	dual;
