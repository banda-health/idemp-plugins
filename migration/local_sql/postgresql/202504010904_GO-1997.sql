/**********************************************************************************************************/
-- Insert the new element values & valid combinations for the new service categories
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_elementvalue;
CREATE TEMP TABLE tmp_c_elementvalue
(
	c_elementvalue_id serial                          NOT NULL,
	ad_client_id      numeric(10)                     NOT NULL,
	ad_org_id         numeric(10) DEFAULT 0           NOT NULL,
--     isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
--     created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10) DEFAULT 100         NOT NULL,
--     updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10) DEFAULT 100         NOT NULL,
	value             varchar(40)                     NOT NULL,
	name              varchar(120)                    NOT NULL,
	description       varchar(255),
	accounttype       char        DEFAULT 'R'         NOT NULL,
	accountsign       char        DEFAULT 'N'         NOT NULL,
--     isdoccontrolled   char        DEFAULT 'N'::bpchar,
	c_element_id      numeric(10)                     NOT NULL,
	issummary         char        DEFAULT 'N'::bpchar NOT NULL,
--     validfrom         timestamp,
--     validto           timestamp,
--     postactual        char        DEFAULT 'Y'::bpchar NOT NULL,
--     postbudget        char        DEFAULT 'Y'::bpchar NOT NULL,
--     postencumbrance   char        DEFAULT 'Y'::bpchar NOT NULL,
--     poststatistical   char        DEFAULT 'Y'::bpchar NOT NULL,
--     isbankaccount     char        DEFAULT 'N'::bpchar,
--     c_bankaccount_id  numeric(10),
--     isforeigncurrency char        DEFAULT 'N'::bpchar,
--     c_currency_id     numeric(10),
	c_elementvalue_uu uuid        DEFAULT uuid_generate_v4()
--     isdetailbpartner  char        DEFAULT 'N'::bpchar NOT NULL,
--     isdetailproduct   char        DEFAULT 'N'::bpchar NOT NULL,
--     bpartnertype      char        DEFAULT NULL::bpchar
);
DROP TABLE IF EXISTS tmp_c_validcombination;
CREATE TEMP TABLE tmp_c_validcombination
(
	c_validcombination_id serial                  NOT NULL,
	ad_client_id          numeric(10)             NOT NULL,
	ad_org_id             numeric(10) DEFAULT 0   NOT NULL,
	-- isactive              char        default 'Y'::bpchar not null,
	-- created               timestamp   default now() not null,
	createdby             numeric(10) DEFAULT 100 NOT NULL,
	-- updated               timestamp   default now() not null,
	updatedby             numeric(10) DEFAULT 100 NOT NULL,
	-- alias                 varchar(40),
	combination           varchar(60),
	description           varchar(255),
	-- isfullyqualified      char        default 'Y'::bpchar not null,
	c_acctschema_id       numeric(10)             NOT NULL,
	account_id            numeric(10)             NOT NULL,
	--  m_product_id          numeric(10),
	-- c_bpartner_id         numeric(10),
	-- ad_orgtrx_id          numeric(10),
	-- c_locfrom_id          numeric(10),
	-- c_locto_id            numeric(10),
	-- c_salesregion_id      numeric(10),
	-- c_project_id          numeric(10),
	-- c_campaign_id         numeric(10),
	-- c_activity_id         numeric(10),
	-- user1_id              numeric(10),
	-- user2_id              numeric(10),
	-- c_subacct_id          numeric(10),
	--userelement1_id       numeric(10),
	-- userelement2_id       numeric(10),
	c_validcombination_uu varchar(36) DEFAULT NULL::character varying
);
-- Alter the sequence so the correct IDs will be inserted since iDempiere tracks this manually
SELECT
	SETVAL(
		'tmp_c_elementvalue_c_elementvalue_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_ElementValue'
			LIMIT 1
		)::INT,
		FALSE
	);
SELECT
	SETVAL(
		'tmp_c_validcombination_c_validcombination_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_ValidCombination'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_elementvalue (ad_client_id, value, name, issummary, c_element_id)
SELECT
	e.ad_client_id,
	ev.value,
	ev.name,
	ev.issummary,
	e.c_element_id
FROM
	c_element e
		CROSS JOIN (
		VALUES
			('411', 'Product Revenue', 'Y'),
			('412', 'Service Revenue', 'Y'),
			('41201', 'Service Revenue - Consultation', 'N'),
			('41202', 'Service Revenue - Laboratory', 'N'),
			('41203', 'Service Revenue - Imaging', 'N'),
			('41204', 'Service Revenue - Dental', 'N'),
			('41205', 'Service Revenue - Orthopedic Trauma Services', 'N'),
			('41206', 'Service Revenue - OPD procedures', 'N'),
			('41207', 'Service Revenue - Antenatal care', 'N'),
			('41208', 'Service Revenue - Postnatal care', 'N'),
			('41209', 'Service Revenue - Family planning', 'N'),
			('41210', 'Service Revenue - Maternity', 'N'),
			('41211', 'Service Revenue - Eye Clinic', 'N'),
			('41212', 'Service Revenue - Surgery', 'N'),
			('41213', 'Service Revenue - Day-case Services', 'N'),
			('41214', 'Service Revenue - Home Care Services', 'N'),
			('41215', 'Service Revenue - Inpatient', 'N'),
			('41216', 'Service Revenue - Follow up', 'N')
	) ev (value, name, issummary)
WHERE
	ad_client_id > 999999;

INSERT INTO
	c_elementvalue (c_elementvalue_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description,
	                accounttype, accountsign, c_element_id, issummary, c_elementvalue_uu)
SELECT
	c_elementvalue_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	accounttype,
	accountsign,
	c_element_id,
	issummary,
	c_elementvalue_uu
FROM
	tmp_c_elementvalue;

-- Update 41100 to be 41200 and a new name
UPDATE c_elementvalue
SET
	value = '41200',
	name  = 'Service Revenue - Other'
WHERE
	value = '41100';

-- Update the valid combination name
UPDATE c_validcombination vc
SET
	combination = '*-' || ev.value || '-_-_',
	description = '*-' || ev.name || '-_-_'
FROM
	c_elementvalue ev
WHERE
	ev.value = '41200'
	AND vc.account_id = ev.c_elementvalue_id;

-- Update 41200 to point to a new parent
UPDATE ad_treenode tn
SET
	parent_id = pev.c_elementvalue_id
FROM
	c_elementvalue ev
		JOIN c_elementvalue pev
		ON pev.value = '412'
WHERE
	tn.node_id = ev.c_elementvalue_id
	AND ev.value = '41200'
	AND ev.ad_client_id = pev.ad_client_id;

-- Add the new account to the Element Value tree so it shows up in the UI
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno, ad_treenode_uu)
SELECT
	tr.ad_tree_id,
	ev.c_elementvalue_id,
	ev.ad_client_id,
	0,
	100,
	100,
	CASE
		WHEN ev.value IN ('411', '412') THEN (
			SELECT c_elementvalue_id FROM c_elementvalue ev1 WHERE ev1.ad_client_id = ev.ad_client_id AND value = '41'
		)
		ELSE (
			SELECT c_elementvalue_id FROM c_elementvalue ev1 WHERE ev1.ad_client_id = ev.ad_client_id AND value = '412'
		)
		END,
	999,
	uuid_generate_v4()
FROM
	tmp_c_elementvalue ev
		JOIN ad_tree tr
		ON tr.ad_client_id = ev.ad_client_id
		AND tr.name LIKE '%Element Value';


-- Create combinations for each new element that was added
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id)
SELECT
	ev.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	accts.c_acctschema_id,
	ev.c_elementvalue_id
FROM
	tmp_c_elementvalue ev
		INNER JOIN ad_client c
		ON c.ad_client_id = ev.ad_client_id
		INNER JOIN c_acctschema accts
		ON accts.ad_client_id = c.ad_client_id;

-- Insert the valid combination into the real table
INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;

/**********************************************************************************************************/
-- Insert the actual product categories and acct mappings
/**********************************************************************************************************/
CREATE TEMP TABLE tmp_m_product_category
(
	m_product_category_id    serial                  NOT NULL,
	ad_client_id             numeric(10)             NOT NULL,
	ad_org_id                numeric(10)             NOT NULL,
-- 	isactive                     char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                      timestamp   DEFAULT NOW()       NOT NULL,
	createdby                numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                      timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                numeric(10) DEFAULT 100 NOT NULL,
	value                    varchar(40)             NOT NULL,
	name                     varchar(60)             NOT NULL,
-- 	description                  varchar(255),
-- 	isdefault                    char        DEFAULT 'N'::bpchar NOT NULL,
	plannedmargin            numeric     DEFAULT 0   NOT NULL,
-- 	a_asset_group_id             numeric(10),
-- 	isselfservice                char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	ad_printcolor_id             numeric(10),
-- 	mmpolicy                     char        DEFAULT 'F'::bpchar NOT NULL,
-- 	m_product_category_parent_id numeric(10),
	m_product_category_uu    uuid        DEFAULT uuid_generate_v4(),
	bh_product_category_type char        DEFAULT 'S'::bpchar,
	c_elementvalue_value     varchar
);
SELECT
	SETVAL(
		'tmp_m_product_category_m_product_category_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'M_Product_Category'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_m_product_category (ad_client_id, ad_org_id, value, name, c_elementvalue_value)
SELECT
	ad_client_id,
	ad_org_id,
	pc.value,
	pc.name,
	pc.c_elementvalue_value
FROM
	ad_org o
		CROSS JOIN (
		VALUES
			('Consultation', '1000005', '41201'),
			('Laboratory', '1000006', '41202'),
			('Imaging', '1000007', '41203'),
			('Dental', '1000008', '41204'),
			('Orthopedic Trauma Services', '1000009', '41205'),
			('OPD procedures', '1000010', '41206'),
			('Antenatal care', '1000011', '41207'),
			('Postnatal care', '1000012', '41208'),
			('Family planning', '1000013', '41209'),
			('Maternity', '1000014', '41210'),
			('Eye Clinic', '1000015', '41211'),
			('Surgery', '1000016', '41212'),
			('Day-case Services', '1000017', '41213'),
			('Home Care Services', '1000018', '41214'),
			('Inpatient', '1000019', '41215'),
			('Follow up', '1000020', '41216')
	) pc (name, value, c_elementvalue_value)
WHERE
	o.ad_client_id > 999999;

-- Insert the product categories
INSERT INTO
	m_product_category (m_product_category_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, plannedmargin,
	                    m_product_category_uu, bh_product_category_type)
SELECT
	m_product_category_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	plannedmargin,
	m_product_category_uu,
	bh_product_category_type
FROM
	tmp_m_product_category;

-- Update the existing services category to have a new name
UPDATE m_product_category
SET
	value = '1000021',
	name  = 'Other'
WHERE
	name = 'Services';


-- Handle the product category mappings
INSERT INTO
	m_product_category_acct (m_product_category_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby,
	                         p_revenue_acct, p_expense_acct, p_asset_acct, p_cogs_acct, p_purchasepricevariance_acct,
	                         p_invoicepricevariance_acct, p_tradediscountrec_acct, p_tradediscountgrant_acct,
	                         p_inventoryclearing_acct, p_costadjustment_acct, p_ratevariance_acct,
	                         p_averagecostvariance_acct, m_product_category_acct_uu, p_landedcostclearing_acct)
SELECT
	tpc.m_product_category_id,
	asd.c_acctschema_id,
	tpc.ad_client_id,
	0,                  --ad_org_id
	100,                --createdby
	100,                --updatedby
	vc.c_validcombination_id,
	asd.p_expense_acct,
	asd.p_asset_acct,
	asd.p_cogs_acct,
	asd.p_purchasepricevariance_acct,
	asd.p_invoicepricevariance_acct,
	asd.p_tradediscountrec_acct,
	asd.p_tradediscountgrant_acct,
	asd.p_inventoryclearing_acct,
	asd.p_costadjustment_acct,
	asd.p_ratevariance_acct,
	asd.p_averagecostvariance_acct,
	uuid_generate_v4(), -- m_product_category_acct_uu
	asd.p_landedcostclearing_acct
FROM
	tmp_m_product_category tpc
		JOIN c_acctschema_default asd
		ON asd.ad_client_id = tpc.ad_client_id
		JOIN c_elementvalue ev
		ON tpc.c_elementvalue_value = ev.value AND tpc.ad_client_id = ev.ad_client_id
		JOIN c_validcombination vc
		ON ev.c_elementvalue_id = vc.account_id;

/**********************************************************************************************************/
-- Update bh_product_categorydefault to ensure that the new default product categories can be added to a new client
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_product_categorydefault;
CREATE TEMP TABLE tmp_product_categorydefault
(
	ad_client_id                  numeric(10) DEFAULT 0   NOT NULL,
	ad_org_id                     numeric(10) DEFAULT 0   NOT NULL,
	bh_product_categorydefault_id serial                  NOT NULL,
	bh_product_categorydefault_uu varchar(36) DEFAULT uuid_generate_v4(),
	bh_product_category_type      char        DEFAULT 'S' NOT NULL,
	-- created                       timestamp    default statement_timestamp() not null,
	createdby                     numeric(10) DEFAULT 100 NOT NULL,
	-- description                   varchar(255) default NULL::character varying,
	-- isactive                      char         default 'Y'::bpchar           not null,
	name                          varchar(60)             NOT NULL,
	-- updated                       timestamp    default statement_timestamp() not null,
	updatedby                     numeric(10) DEFAULT 100 NOT NULL,
	value                         varchar(40)             NOT NULL
);
SELECT
	SETVAL(
		'tmp_product_categorydefault_bh_product_categorydefault_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'BH_Product_CategoryDefault'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_product_categorydefault(name, value)
SELECT
	pc.name,
	pc.c_elementvalue_value
FROM
	(
		VALUES
			('Consultation', '41201'),
			('Laboratory', '41202'),
			('Imaging', '41203'),
			('Dental', '41204'),
			('Orthopedic Trauma Services', '41205'),
			('OPD procedures', '41206'),
			('Antenatal care', '41207'),
			('Postnatal care', '41208'),
			('Family planning', '41209'),
			('Maternity', '41210'),
			('Eye Clinic', '41211'),
			('Surgery', '41212'),
			('Day-case Services', '41213'),
			('Home Care Services', '41214'),
			('Inpatient', '41215'),
			('Follow up', '41216')
	) AS pc (name, c_elementvalue_value);

-- Insert into the realy product category defaults
INSERT INTO
	bh_product_categorydefault(ad_client_id, ad_org_id, bh_product_categorydefault_id, bh_product_categorydefault_uu,
	                           bh_product_category_type, createdby, name, updatedby, value)
SELECT
	ad_client_id,
	ad_org_id,
	bh_product_categorydefault_id,
	bh_product_categorydefault_uu,
	bh_product_category_type,
	createdby,
	name,
	updatedby,
	value
FROM
	tmp_product_categorydefault;

-- Update the default services account to be correct
UPDATE bh_product_categorydefault
SET
	name  = 'Other',
	value = '41200'
WHERE
	name = 'Services'
	AND value = '41100';

/**********************************************************************************************************/
-- Wrap-up
/**********************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202504010904_GO-1997.sql')
FROM
	dual;
