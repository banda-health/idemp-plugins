-- create bpartner groups...
DROP TABLE IF EXISTS tmp_c_bp_group;

CREATE TEMP TABLE tmp_c_bp_group
(
	c_bp_group_id        serial                                      NOT NULL,
	ad_client_id         numeric(10)                                 NOT NULL,
	ad_org_id            numeric(10)  DEFAULT 0                      NOT NULL,
	isactive             char         DEFAULT 'Y'                    NOT NULL,
	createdby            numeric(10)  DEFAULT 100                    NOT NULL,
	updated              timestamp    DEFAULT NOW()                  NOT NULL,
	updatedby            numeric(10)  DEFAULT 100                    NOT NULL,
	value                varchar(40)  DEFAULT 'No Supplier Selected' NOT NULL,
	name                 varchar(60)  DEFAULT 'No Supplier Selected' NOT NULL,
	description          varchar(255) DEFAULT 'DO NOT CHANGE',
	prioritybase         char,
	m_pricelist_id       numeric(10),
	po_pricelist_id      numeric(10),
	m_discountschema_id  numeric(10),
	po_discountschema_id numeric(10),
	creditwatchpercent   numeric,
	pricematchtolerance  numeric,
	c_dunning_id         numeric(10),
	c_bp_group_uu        uuid         DEFAULT uuid_generate_v4()     NOT NULL
);

-- SET sequence
SELECT
	SETVAL(
		'tmp_c_bp_group_c_bp_group_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BP_Group'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_bp_group (ad_client_id, ad_org_id, prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id,
	                po_discountschema_id, creditwatchpercent, pricematchtolerance, c_dunning_id)
SELECT
	c.ad_client_id,
	bp.ad_org_id,
	bp.prioritybase,
	bp.m_pricelist_id,
	bp.po_pricelist_id,
	bp.m_discountschema_id,
	bp.po_discountschema_id,
	bp.creditwatchpercent,
	bp.pricematchtolerance,
	bp.c_dunning_id
FROM
	ad_client c
		INNER JOIN c_bp_group bp
		ON c.ad_client_id = bp.ad_client_id
WHERE
	(c.ad_client_id > 999999 OR c.ad_client_id = 2)
	AND c.isactive = 'Y'
	AND bp.name = 'Standard'
	AND bp.isdefault = 'Y';

INSERT INTO
	c_bp_group(c_bp_group_id, ad_client_id, ad_org_id, isactive, createdby, updated, updatedby, value, name, description,
	           prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id,
	           creditwatchpercent, pricematchtolerance, c_dunning_id, c_bp_group_uu)
SELECT
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	isactive,
	createdby,
	updated,
	updatedby,
	value,
	name,
	description,
	prioritybase,
	m_pricelist_id,
	po_pricelist_id,
	m_discountschema_id,
	po_discountschema_id,
	creditwatchpercent,
	pricematchtolerance,
	c_dunning_id,
	c_bp_group_uu
FROM
	tmp_c_bp_group
ON CONFLICT DO NOTHING;

-- Add bp group a/cs
DROP TABLE IF EXISTS tmp_c_bp_group_acct;
CREATE TEMP TABLE tmp_c_bp_group_acct
(
	c_acctschema_id             serial                    NOT NULL,
	c_bp_group_id               numeric(10)               NOT NULL,
	ad_client_id                numeric(10)               NOT NULL,
	ad_org_id                   numeric(10)               NOT NULL,
	isactive                    char        DEFAULT 'Y'   NOT NULL,
	created                     timestamp   DEFAULT NOW() NOT NULL,
	createdby                   numeric(10) DEFAULT 100   NOT NULL,
	updated                     timestamp   DEFAULT NOW() NOT NULL,
	updatedby                   numeric(10) DEFAULT 100   NOT NULL,
	c_receivable_acct           numeric(10)               NOT NULL,
	c_prepayment_acct           numeric(10)               NOT NULL,
	v_liability_acct            numeric(10)               NOT NULL,
	v_liability_services_acct   numeric(10),
	v_prepayment_acct           numeric(10)               NOT NULL,
	paydiscount_exp_acct        numeric(10)               NOT NULL,
	paydiscount_rev_acct        numeric(10)               NOT NULL,
	writeoff_acct               numeric(10)               NOT NULL,
	notinvoicedreceipts_acct    numeric(10)               NOT NULL,
	unearnedrevenue_acct        numeric(10),
	notinvoicedrevenue_acct     numeric(10),
	notinvoicedreceivables_acct numeric(10),
	processing                  char,
	c_receivable_services_acct  numeric(10),
	c_bp_group_acct_uu          uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO
	tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, c_receivable_acct, c_prepayment_acct,
	                     v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
	                     paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
	                     notinvoicedrevenue_acct, notinvoicedreceivables_acct, processing, c_receivable_services_acct)
SELECT
	bpga.c_acctschema_id,
	tbpg.c_bp_group_id,
	bpga.ad_client_id,
	bpga.ad_org_id,
	bpga.c_receivable_acct,
	bpga.c_prepayment_acct,
	bpga.v_liability_acct,
	bpga.v_liability_services_acct,
	bpga.v_prepayment_acct,
	bpga.paydiscount_exp_acct,
	bpga.paydiscount_rev_acct,
	bpga.writeoff_acct,
	bpga.notinvoicedreceipts_acct,
	bpga.unearnedrevenue_acct,
	bpga.notinvoicedrevenue_acct,
	bpga.notinvoicedreceivables_acct,
	bpga.processing,
	bpga.c_receivable_services_acct
FROM
	c_bp_group tbpg
		JOIN c_bp_group bpg
		ON tbpg.ad_client_id = bpg.ad_client_id AND bpg.name = 'Standard'
		JOIN c_bp_group_acct bpga
		ON bpg.c_bp_group_id = bpga.c_bp_group_id
		LEFT JOIN c_bp_group_acct bpgaotc
		ON tbpg.c_bp_group_id = bpgaotc.c_bp_group_id
WHERE
	tbpg.name = 'No Supplier Selected'
	AND bpgaotc.c_acctschema_id IS NULL;

INSERT INTO
	c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                 updatedby, c_receivable_acct, c_prepayment_acct, v_liability_acct, v_liability_services_acct,
	                 v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct,
	                 notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct, notinvoicedreceivables_acct,
	                 processing, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT
	c_acctschema_id,
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	paydiscount_exp_acct,
	paydiscount_rev_acct,
	writeoff_acct,
	notinvoicedreceipts_acct,
	unearnedrevenue_acct,
	notinvoicedrevenue_acct,
	notinvoicedreceivables_acct,
	processing,
	c_receivable_services_acct,
	c_bp_group_acct_uu
FROM
	tmp_c_bp_group_acct;

-- Add bp to existing clients.
DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TEMP TABLE tmp_c_bpartner
(
	c_bpartner_id    serial                                      NOT NULL,
	ad_client_id     numeric(10)                                 NOT NULL,
	ad_org_id        numeric(10)  DEFAULT 0                      NOT NULL,
	isactive         char         DEFAULT 'Y'::bpchar            NOT NULL,
	created          timestamp    DEFAULT NOW()                  NOT NULL,
	createdby        numeric(10)  DEFAULT 100                    NOT NULL,
	updated          timestamp    DEFAULT NOW()                  NOT NULL,
	updatedby        numeric(10)  DEFAULT 100                    NOT NULL,
	invoicerule      char         DEFAULT 'I'                    NOT NULL,
	paymentrule      char         DEFAULT 'B'                    NOT NULL,
	c_paymentterm_id numeric(10)                                 NOT NULL,
	m_pricelist_id   numeric(10)                                 NOT NULL,
	value            varchar(40)  DEFAULT 'No Supplier Selected' NOT NULL,
	name             varchar(120) DEFAULT 'No Supplier Selected' NOT NULL,
	description      varchar(100) DEFAULT 'DO NOT CHANGE',
	c_bp_group_id    numeric(10),
	c_bpartner_uu    uuid         DEFAULT uuid_generate_v4()     NOT NULL
);

-- SET sequence
SELECT
	SETVAL(
		'tmp_c_bpartner_c_bpartner_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BPartner'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_bpartner (ad_client_id, c_bp_group_id, c_paymentterm_id, m_pricelist_id)
SELECT
	c.ad_client_id,
	(
		SELECT
			c_bp_group.c_bp_group_id
		FROM
			c_bp_group
		WHERE
			c_bp_group.ad_client_id = c.ad_client_id
			AND c_bp_group.name = 'No Supplier Selected'
	),
	(
		SELECT
			c_paymentterm_id
		FROM
			c_paymentterm
		WHERE
			c_paymentterm.ad_client_id = c.ad_client_id
			AND c_paymentterm.name = 'Immediate'
	),
	(
		SELECT
			COALESCE((
				         SELECT
					         g.m_pricelist_id
				         FROM
					         C_BP_Group g
				         WHERE
					         g.ad_client_id = c.ad_client_id
					         AND g.isdefault = 'Y'
				         LIMIT 1
			         ), (
				         SELECT
					         l.m_pricelist_id
				         FROM
					         m_pricelist l
				         WHERE
					         l.ad_client_id = c.ad_client_id
					         AND isdefault = 'Y'
					         AND issopricelist = 'Y'
				         LIMIT 1
			         ), (
				         SELECT
					         l.m_pricelist_id
				         FROM
					         m_pricelist l
				         WHERE
					         l.ad_client_id = c.ad_client_id
					         AND isdefault = 'Y'
				         LIMIT 1
			         ), 0)
	)
FROM
	ad_client c
WHERE
	(c.ad_client_id > 999999 OR c.ad_client_id = 2)
	AND c.isactive = 'Y';

INSERT INTO
	c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, invoicerule,
	            paymentrule, c_paymentterm_id, m_pricelist_id, value, name, description, c_bp_group_id, c_bpartner_uu)
SELECT
	c_bpartner_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	invoicerule,
	paymentrule,
	c_paymentterm_id,
	m_pricelist_id,
	value,
	name,
	description,
	c_bp_group_id,
	c_bpartner_uu
FROM
	tmp_c_bpartner
ON CONFLICT DO NOTHING;

-- Add user contact
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
	c_bpartner_id
FROM
	tmp_c_bpartner;

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

-- Add location
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
	tmp_c_bpartner c;

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

-- Add user location
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
		INNER JOIN tmp_c_bpartner b
		ON c.ad_client_id = b.ad_client_id;

INSERT INTO
	c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id,
	                     c_location_id, c_bpartner_location_uu)
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

-- Add Customer Account
DROP TABLE IF EXISTS tmp_c_bp_customer_acct;
CREATE TEMP TABLE tmp_c_bp_customer_acct
(
	c_bpartner_id              numeric(10)             NOT NULL,
	c_acctschema_id            numeric(10)             NOT NULL,
	ad_client_id               numeric(10)             NOT NULL,
	ad_org_id                  numeric(10)             NOT NULL,
	createdby                  numeric(10) DEFAULT 100 NOT NULL,
	updatedby                  numeric(10) DEFAULT 100 NOT NULL,
	c_receivable_acct          numeric(10),
	c_prepayment_acct          numeric(10),
	c_receivable_services_acct numeric(10),
	c_bp_customer_acct_uu      uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO
	tmp_c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, c_receivable_acct, c_prepayment_acct,
	                        c_receivable_services_acct)
SELECT
	p.c_bpartner_id,
	a.c_acctschema_id,
	c.ad_client_id,
	c.ad_org_id,
	a.c_receivable_acct,
	a.c_prepayment_acct,
	a.c_receivable_services_acct
FROM
	tmp_c_bp_group c
		INNER JOIN tmp_c_bpartner p
		ON c.ad_client_id = p.ad_client_id
		INNER JOIN tmp_c_bp_group_acct a
		ON c.ad_client_id = a.ad_client_id;

INSERT INTO
	c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                    c_prepayment_acct, c_receivable_services_acct, c_bp_customer_acct_uu)
SELECT
	c_bpartner_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	c_receivable_services_acct,
	c_bp_customer_acct_uu
FROM
	tmp_c_bp_customer_acct;

-- Add Vendor Account
DROP TABLE IF EXISTS tmp_c_bp_vendor_acct;
CREATE TEMP TABLE tmp_c_bp_vendor_acct
(
	c_bpartner_id             numeric(10)             NOT NULL,
	c_acctschema_id           numeric(10)             NOT NULL,
	ad_client_id              numeric(10)             NOT NULL,
	ad_org_id                 numeric(10)             NOT NULL,
	createdby                 numeric(10) DEFAULT 100 NOT NULL,
	updatedby                 numeric(10) DEFAULT 100 NOT NULL,
	v_liability_acct          numeric(10),
	v_liability_services_acct numeric(10),
	v_prepayment_acct         numeric(10),
	c_bp_vendor_acct_uu       uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO
	tmp_c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, v_liability_acct,
	                      v_liability_services_acct, v_prepayment_acct)
SELECT
	p.c_bpartner_id,
	a.c_acctschema_id,
	c.ad_client_id,
	c.ad_org_id,
	a.v_liability_acct,
	a.v_liability_services_acct,
	a.v_prepayment_acct
FROM
	tmp_c_bp_group c
		INNER JOIN tmp_c_bpartner p
		ON c.ad_client_id = p.ad_client_id
		INNER JOIN tmp_c_bp_group_acct a
		ON c.ad_client_id = a.ad_client_id;

INSERT INTO
	c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, v_liability_acct,
	                  v_liability_services_acct, v_prepayment_acct, c_bp_vendor_acct_uu)
SELECT
	c_bpartner_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	c_bp_vendor_acct_uu
FROM
	tmp_c_bp_vendor_acct;

-- DROP TEMP Tables
DROP TABLE tmp_c_bp_group_acct;
DROP TABLE tmp_c_bp_group;
DROP TABLE tmp_c_bpartner;
DROP TABLE tmp_ad_user;
DROP TABLE tmp_c_location;
DROP TABLE tmp_c_bpartner_location;
DROP TABLE tmp_c_bp_customer_acct;
DROP TABLE tmp_c_bp_vendor_acct;

SELECT
	update_sequences();

SELECT
	register_migration_script('202507111146_GO-3309.sql')
FROM
	dual;
