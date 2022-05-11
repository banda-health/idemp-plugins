/**********************************************************************************************************/
-- Purpose of script:
-- Add account mappings to charges for client's that don't have any. There was a time when the mappings
-- weren't set up correctly that has since been fixed, but client's who were created during this time
-- are missing some accounts.

-- Process:
-- 1. Find the default charges that don't have account mappings and create table entries to hold the mapping.
--		c_charge -> c_charge_acct -> c_validcombination -> c_elementvalue
--			Client's have c_charge and c_elementvalue data - they're missing the two in the middle
-- 2. Create the mapping off the configuration client's setup.
-- 3. Add the mappings to the DB.
/**********************************************************************************************************/

/**********************************************************************************************************/
-- Setup - Create the temporary tables we'll need to add combinations and accounts
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_validcombination;
DROP TABLE IF EXISTS tmp_c_charge_acct;
-- The columns commented here are being left so I know which ones have defaults set in the DB that don't need to overridden
CREATE TEMP TABLE tmp_c_charge_acct (
	c_charge_id numeric(10) not null,
	c_acctschema_id numeric(10) not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	ch_expense_acct serial,
	-- ch_revenue_acct numeric(10),
	c_charge_acct_uu uuid default uuid_generate_v4()
);
CREATE TEMP TABLE tmp_c_validcombination (
	c_validcombination_id numeric(10) not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	-- alias varchar(40),
	combination varchar(60),
	description varchar(255),
	-- isfullyqualified char default 'Y'::bpchar not null,
	c_acctschema_id numeric(10) not null,
	account_id numeric(10) not null,
	-- m_product_id numeric(10),
	-- c_bpartner_id numeric(10),
	-- ad_orgtrx_id numeric(10),
	-- c_locfrom_id numeric(10),
	-- c_locto_id numeric(10),
	-- c_salesregion_id numeric(10),
	-- c_project_id numeric(10),
	-- c_campaign_id numeric(10),
	-- c_activity_id numeric(10),
	-- user1_id numeric(10),
	-- user2_id numeric(10),
	-- c_subacct_id numeric(10),
	-- userelement1_id numeric(10),
	-- userelement2_id numeric(10),
	c_validcombination_uu uuid default uuid_generate_v4()
);

-- Update the serial sequences
SELECT setval(
	'tmp_c_charge_acct_ch_expense_acct_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'c_validcombination'
		LIMIT 1
	)::INT,
	false
);

/**********************************************************************************************************/
-- Add data to temporary tables
/**********************************************************************************************************/
-- First, add all missing charge accounts (they won't have valid combinations at this point)
INSERT INTO tmp_c_charge_acct (
	c_charge_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id
)
SELECT
	c.c_charge_id,
	accts.c_acctschema_id,
	c.ad_client_id,
	c.ad_org_id
FROM c_charge c
	LEFT JOIN c_charge_acct ca ON c.c_charge_id = ca.c_charge_id
	JOIN c_acctschema accts ON c.ad_client_id = accts.ad_client_id
WHERE c.bh_locked = 'Y' AND ca.c_charge_id IS NULL;

-- Add valid combinations that are missing from some clients (specifically around non-patient payments)
INSERT INTO tmp_c_validcombination (
	c_validcombination_id,
	ad_client_id,
	combination,
	description,
	c_acctschema_id,
	account_id
)
SELECT
	ca.ch_expense_acct,
	ca.ad_client_id,
	cvc.combination,
	cvc.description,
	ca.c_acctschema_id,
	ev.c_elementvalue_id
FROM tmp_c_charge_acct ca
	JOIN c_charge c ON c.c_charge_id = ca.c_charge_id
	JOIN c_charge cc ON c.name = cc.name AND cc.ad_client_id = 2 -- navigate to the configuration client's stuff
	JOIN c_charge_acct cca ON cc.c_charge_id = cca.c_charge_id
	JOIN c_validcombination cvc ON cvc.c_validcombination_id = cca.ch_expense_acct
	JOIN c_elementvalue cev ON cvc.account_id = cev.c_elementvalue_id
	JOIN c_elementvalue ev ON ev.value = cev.value AND ev.ad_client_id = c.ad_client_id;

/**********************************************************************************************************/
-- Insert the records into the DB now
/**********************************************************************************************************/
-- We have to insert the valid combinations first since the charge accounts reference them
INSERT INTO c_validcombination (
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
)
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
FROM tmp_c_validcombination;

-- Add the appropriate charge accounts to map the valid combinations to charges
INSERT INTO c_charge_acct (
	c_charge_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	ch_expense_acct,
	c_charge_acct_uu
)
SELECT
	c_charge_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	ch_expense_acct,
	c_charge_acct_uu
FROM tmp_c_charge_acct;

/**********************************************************************************************************/
-- Wrap everything up
/**********************************************************************************************************/
SELECT update_sequences();

SELECT register_migration_script('202203250914_GO-2220.sql') FROM dual;
