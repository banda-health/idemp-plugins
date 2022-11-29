/******************************************************************************************/
-- This script adds a new Bad-Debt write-off charge to the Configuration client (so
-- that it gets added to all future clients that get created), then goes through and
-- adds the charge to all existing clients
-- 
-- NB: The comments are left in the temp tables to differentiate which columns are
-- defaulted for the temp table compared to the ones defaulted in the actual DB table.
/******************************************************************************************/

/******************************************************************************************/
-- Add new defaults to the Config client
-- NB: we keep these separate because we want their IDs to be specific
/******************************************************************************************/
INSERT INTO c_chargetype (ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu) VALUES (2, 0, 190002, '2022-06-14 18:23:12.912000', 100, 'For special charges that have unique use cases', null, 'Y', 'One-offs - DO NOT CHANGE', '2022-06-14 18:23:12.912000', 100, '1000002', '4dc5426e-79cd-4c40-9b1e-b4bcd58f2c85') ON CONFLICT DO NOTHING;

INSERT INTO c_charge (c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo) VALUES (190043, 2, 0, 'Y', '2022-06-21 06:44:09.974000', 100, '2022-06-21 06:44:10.138000', 100, 'Bad debt write-off - DO NOT CHANGE', 'Debt that may never get paid', 0, 'N', 'N', 190000, 'N', null, 190002, '5b43dc01-eeaf-4de2-bba1-75a67d11edf0', 190083, 'Y', null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, alias, combination, description, isfullyqualified, c_acctschema_id, account_id, m_product_id, c_bpartner_id, ad_orgtrx_id, c_locfrom_id, c_locto_id, c_salesregion_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, c_subacct_id, userelement1_id, userelement2_id, c_validcombination_uu) VALUES (190098, 2, 0, 'Y', '2021-07-09 15:40:54.259000', 100, '2021-07-09 15:41:05.723000', 100, null, '*-78100-_-_', '*-Bad Debts Write-off-_-_', 'Y', 190000, 190083, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '101d427e-006b-420f-aca2-29c1be81498d') ON CONFLICT DO NOTHING;

INSERT INTO c_charge_acct (c_charge_id, c_acctschema_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ch_expense_acct, ch_revenue_acct, c_charge_acct_uu) VALUES (190043, 190000, 2, 0, 'Y', '2022-06-21 06:44:10.068876', 100, '2022-06-21 06:44:10.068876', 100, 190098, null, '0137307b-05d3-405f-90ce-21a0054f887d') ON CONFLICT DO NOTHING;

/******************************************************************************************/
-- Add all the stuff to existing clients
/******************************************************************************************/
DROP TABLE IF EXISTS tmp_ad_client_to_add_charges_to;
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_ad_client_to_add_charges_to
FROM
	ad_client
WHERE
		ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_charge
		WHERE
			name = 'Bad debt write-off - DO NOT CHANGE'
	)
	AND ad_client_id > 999999;

DROP TABLE IF EXISTS tmp_ad_client_to_add_accounts_to;
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_ad_client_to_add_accounts_to
FROM
	ad_client
WHERE
		ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = '78100'
	)
	AND ad_client_id > 999999;

-- 
SELECT
	update_sequences();

/******************************************************************************************/
-- Insert accounts for all clients that don't have the bad-debt write-off account (78100)
/******************************************************************************************/
DROP TABLE IF EXISTS tmp_c_elementvalue;
CREATE TEMP TABLE tmp_c_elementvalue
(
	c_elementvalue_id serial                                     NOT NULL,
	ad_client_id      numeric(10)                                NOT NULL,
	ad_org_id         numeric(10)  DEFAULT 0                     NOT NULL,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10)  DEFAULT 100                   NOT NULL,
-- 	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10)  DEFAULT 100                   NOT NULL,
	value             varchar(40)  DEFAULT '78100'               NOT NULL,
	name              varchar(120) DEFAULT 'Bad Debts Write-off' NOT NULL,
	description       varchar(255) DEFAULT 'Receivables write-off - bad debt',
	accounttype       char         DEFAULT 'E'                   NOT NULL,
	accountsign       char         DEFAULT 'N'                   NOT NULL,
	isdoccontrolled   char         DEFAULT 'Y'::bpchar,
	c_element_id      numeric(10)                                NOT NULL,
-- 	issummary         char         DEFAULT 'N'::bpchar           NOT NULL,
-- 	validfrom         timestamp,
-- 	validto           timestamp,
-- 	postactual        char         DEFAULT 'Y'::bpchar           NOT NULL,
-- 	postbudget        char         DEFAULT 'Y'::bpchar           NOT NULL,
-- 	postencumbrance   char         DEFAULT 'Y'::bpchar           NOT NULL,
-- 	poststatistical   char         DEFAULT 'Y'::bpchar           NOT NULL,
-- 	isbankaccount     char         DEFAULT 'N'::bpchar,
-- 	c_bankaccount_id  numeric(10),
-- 	isforeigncurrency char         DEFAULT 'N'::bpchar,
-- 	c_currency_id     numeric(10),
	c_elementvalue_uu uuid         DEFAULT uuid_generate_v4()
-- 	isdetailbpartner  char         DEFAULT 'N'::bpchar           NOT NULL,
-- 	isdetailproduct   char         DEFAULT 'N'::bpchar           NOT NULL,
-- 	bpartnertype      char         DEFAULT NULL::bpchar
);

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

INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id)
SELECT
	c.ad_client_id,
	e.c_element_id
FROM
	tmp_ad_client_to_add_accounts_to c
		JOIN c_element e
			ON c.ad_client_id = e.ad_client_id;

INSERT INTO
	c_elementvalue (c_elementvalue_id,
	                ad_client_id,
	                ad_org_id,
	                createdby,
	                updatedby,
	                value,
	                name,
	                description,
	                accounttype,
	                accountsign,
	                isdoccontrolled,
	                c_element_id,
	                c_elementvalue_uu)
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
	isdoccontrolled,
	c_element_id,
	c_elementvalue_uu
FROM
	tmp_c_elementvalue;

-- Add the new one-offs charge-type
DROP TABLE IF EXISTS tmp_c_chargetype;
CREATE TEMP TABLE tmp_c_chargetype
(
	ad_client_id    numeric(10)                                     NOT NULL,
	ad_org_id       numeric(10)  DEFAULT 0                          NOT NULL,
	c_chargetype_id serial                                          NOT NULL,
-- 	created         timestamp   DEFAULT STATEMENT_TIMESTAMP() NOT NULL,
	createdby       numeric(10)  DEFAULT 100                        NOT NULL,
	description     varchar(255) DEFAULT 'For special charges that have unique use cases',
-- 	help            varchar(2000),
-- 	isactive        char         DEFAULT 'Y'::bpchar           NOT NULL,
	name            varchar(60)  DEFAULT 'One-offs - DO NOT CHANGE' NOT NULL,
-- 	updated         timestamp    DEFAULT STATEMENT_TIMESTAMP()      NOT NULL,
	updatedby       numeric(10)  DEFAULT 100                        NOT NULL,
	value           varchar(40)  DEFAULT '1000193'                  NOT NULL,
	c_chargetype_uu uuid         DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_chargetype_c_chargetype_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_ChargeType'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_c_chargetype (ad_client_id)
SELECT
	ad_client_id
FROM
	tmp_ad_client_to_add_charges_to;

INSERT INTO
	c_chargetype (ad_client_id,
	              ad_org_id,
	              c_chargetype_id,
	              createdby,
	              description,
	              name,
	              updatedby,
	              value,
	              c_chargetype_uu)
SELECT
	ad_client_id,
	ad_org_id,
	c_chargetype_id,
	createdby,
	description,
	name,
	updatedby,
	value,
	c_chargetype_uu
FROM
	tmp_c_chargetype;

/******************************************************************************************/
-- Add the new charges (make sure to map to the right c_elementvalue row)
/******************************************************************************************/
DROP TABLE IF EXISTS tmp_c_charge;
CREATE TEMP TABLE tmp_c_charge
(
	c_charge_id       serial                                                    NOT NULL,
	ad_client_id      numeric(10)                                               NOT NULL,
	ad_org_id         numeric(10)  DEFAULT 0                                    NOT NULL,
-- 	isactive                   char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                    timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10)  DEFAULT 100                                  NOT NULL,
-- 	updated                    timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10)  DEFAULT 100                                  NOT NULL,
	name              varchar(60)  DEFAULT 'Bad debt write-off - DO NOT CHANGE' NOT NULL,
	description       varchar(255) DEFAULT 'Debt that may never get paid',
-- 	chargeamt                  numeric      DEFAULT 0                    NOT NULL,
-- 	issametax                  char         DEFAULT 'N'::bpchar          NOT NULL,
-- 	issamecurrency             char         DEFAULT 'N'::bpchar          NOT NULL,
	c_taxcategory_id  numeric(10),
-- 	istaxincluded              char         DEFAULT 'N'::bpchar          NOT NULL,
-- 	c_bpartner_id              numeric(10),
	c_chargetype_id   numeric(10),
	c_charge_uu       uuid         DEFAULT uuid_generate_v4(),
	c_elementvalue_id numeric(10),
	bh_locked         char         DEFAULT 'Y'::bpchar
-- 	bh_subtype                 varchar(2)   DEFAULT NULL::character varying,
-- 	bh_needadditionalvisitinfo char         DEFAULT 'N'::bpchar          NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_charge_c_charge_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Charge'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_c_charge (ad_client_id,
	              c_taxcategory_id,
	              c_chargetype_id,
	              c_elementvalue_id)
SELECT
	c.ad_client_id,
	tc.c_taxcategory_id,
	ct.c_chargetype_id,
	ev.c_elementvalue_id
FROM
	tmp_ad_client_to_add_charges_to c
		JOIN c_taxcategory tc
			ON c.ad_client_id = tc.ad_client_id
		JOIN tmp_c_chargetype ct
			ON ct.ad_client_id = c.ad_client_id
		JOIN c_elementvalue ev
			ON c.ad_client_id = ev.ad_client_id AND ev.value = '78100';

INSERT INTO
	c_charge (c_charge_id,
	          ad_client_id,
	          ad_org_id,
	          createdby,
	          updatedby,
	          name,
	          description,
	          c_taxcategory_id,
	          c_chargetype_id,
	          c_charge_uu,
	          c_elementvalue_id,
	          bh_locked)
SELECT
	c_charge_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	c_taxcategory_id,
	c_chargetype_id,
	c_charge_uu,
	c_elementvalue_id,
	bh_locked
FROM
	tmp_c_charge;

/******************************************************************************************/
-- Add new valid combinations
/******************************************************************************************/
DROP TABLE IF EXISTS tmp_c_validcombination;
CREATE TEMP TABLE tmp_c_validcombination
(
	c_validcombination_id serial                   NOT NULL,
	ad_client_id          numeric(10)              NOT NULL,
	ad_org_id             numeric(10)  DEFAULT 0   NOT NULL,
-- 	isactive              char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created               timestamp   DEFAULT NOW()       NOT NULL,
	createdby             numeric(10)  DEFAULT 100 NOT NULL,
-- 	updated               timestamp   DEFAULT NOW()       NOT NULL,
	updatedby             numeric(10)  DEFAULT 100 NOT NULL,
-- 	alias                 varchar(40),
	combination           varchar(60)  DEFAULT '*-78100-_-_',
	description           varchar(255) DEFAULT '*-Bad Debts Write-off-_-_',
-- 	isfullyqualified      char         DEFAULT 'Y'::bpchar NOT NULL,
	c_acctschema_id       numeric(10)              NOT NULL,
	account_id            numeric(10)              NOT NULL,
-- 	m_product_id          numeric(10),
-- 	c_bpartner_id         numeric(10),
-- 	ad_orgtrx_id          numeric(10),
-- 	c_locfrom_id          numeric(10),
-- 	c_locto_id            numeric(10),
-- 	c_salesregion_id      numeric(10),
-- 	c_project_id          numeric(10),
-- 	c_campaign_id         numeric(10),
-- 	c_activity_id         numeric(10),
-- 	user1_id              numeric(10),
-- 	user2_id              numeric(10),
-- 	c_subacct_id          numeric(10),
-- 	userelement1_id       numeric(10),
-- 	userelement2_id       numeric(10),
	c_validcombination_uu uuid         DEFAULT uuid_generate_v4()
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
	tmp_c_validcombination (ad_client_id,
	                        c_acctschema_id,
	                        account_id)
SELECT
	c.ad_client_id,
	accts.c_acctschema_id,
	ev.c_elementvalue_id
FROM
	tmp_ad_client_to_add_charges_to c
		JOIN c_acctschema accts
			ON c.ad_client_id = accts.ad_client_id
		JOIN c_elementvalue ev
			ON c.ad_client_id = ev.ad_client_id AND ev.value = '78100';

INSERT INTO
	c_validcombination (c_validcombination_id,
	                    ad_client_id,
	                    ad_org_id,
	                    createdby,
	                    updatedby,
	                    combination,
	                    description,
	                    c_acctschema_id,
	                    account_id,
	                    c_validcombination_uu)
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

/******************************************************************************************/
-- Add the charge accounting link to the valid combinations
/******************************************************************************************/
INSERT INTO
	c_charge_acct (c_charge_id,
	               c_acctschema_id,
	               ad_client_id,
	               ad_org_id,
	               createdby,
	               updatedby,
	               ch_expense_acct,
	               c_charge_acct_uu)
SELECT
	tc.c_charge_id,
	accts.c_acctschema_id,
	c.ad_client_id,
	0,                        --ad_org_id
	0,                        --createdby
	0,                        --updatedby
	vc.c_validcombination_id, --ch_expense_acct
	uuid_generate_v4()        --c_charge_acct_uu
FROM
	tmp_ad_client_to_add_charges_to c
		JOIN c_acctschema accts
			ON c.ad_client_id = accts.ad_client_id
		JOIN tmp_c_charge tc
			ON c.ad_client_id = tc.ad_client_id
		JOIN tmp_c_validcombination vc
			ON c.ad_client_id = vc.ad_client_id;

/******************************************************************************************/
-- Wrap-up
/******************************************************************************************/
SELECT register_migration_script('202206141839_GO-2155.sql') FROM dual;
