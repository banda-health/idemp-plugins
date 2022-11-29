DROP FUNCTION IF EXISTS bh_execute_statement_without_indexes(varchar, varchar);
CREATE OR REPLACE FUNCTION bh_execute_statement_without_indexes(_sql_to_execute varchar, _column_to_remove_indexes_from varchar)
	RETURNS void
AS
$$
DECLARE
	statement varchar;
BEGIN
	DROP TABLE IF EXISTS tmp_constraint_deletions;
	DROP TABLE IF EXISTS tmp_constraint_additions;

	CREATE TEMP TABLE tmp_constraint_deletions
	(
		statement varchar
	);
	CREATE TEMP TABLE tmp_constraint_additions
	(
		statement varchar
	);

	-- Fetch the constraints
	INSERT INTO tmp_constraint_deletions
	SELECT
								'ALTER TABLE ' || nspname || '."' || relname || '" DROP CONSTRAINT "' || conname || '";'
	FROM
		pg_constraint
			INNER JOIN pg_class
				ON conrelid = pg_class.oid
			INNER JOIN pg_namespace
				ON pg_namespace.oid = pg_class.relnamespace
	WHERE
			LOWER(PG_GET_CONSTRAINTDEF(pg_constraint.oid)) LIKE '%' || LOWER('c_elementvalue_id') || '%'
		AND contype != 'p'
	ORDER BY CASE WHEN contype = 'f' THEN 0 ELSE 1 END, contype, nspname, relname, conname;

	INSERT INTO tmp_constraint_additions
	SELECT
										'ALTER TABLE ' || nspname || '."' || relname || '" ADD CONSTRAINT "' || conname || '" ' ||
										PG_GET_CONSTRAINTDEF(pg_constraint.oid) || ';'
	FROM
		pg_constraint
			INNER JOIN pg_class
				ON conrelid = pg_class.oid
			INNER JOIN pg_namespace
				ON pg_namespace.oid = pg_class.relnamespace
	WHERE
			LOWER(PG_GET_CONSTRAINTDEF(pg_constraint.oid)) LIKE '%' || LOWER(_column_to_remove_indexes_from) || '%'
		AND contype != 'p'
	ORDER BY CASE WHEN contype = 'f' THEN 0 ELSE 1 END DESC, contype DESC, nspname DESC, relname DESC, conname DESC;

	-- Drop the constraints
	FOR statement IN SELECT * FROM tmp_constraint_deletions
		LOOP
			EXECUTE statement;
		END LOOP;

	-- Execute the SQL passed in
	EXECUTE _sql_to_execute;

	-- Re-add the constraints
	FOR statement IN SELECT * FROM tmp_constraint_additions
		LOOP
			EXECUTE statement;
		END LOOP;

	-- Clean up
	DROP TABLE IF EXISTS tmp_constraint_deletions;
	DROP TABLE IF EXISTS tmp_constraint_additions;
END
$$
	LANGUAGE plpgsql;

-- Get the clients to update
DROP TABLE IF EXISTS tmp_c_client_id;
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_c_client_id
FROM
	ad_client
WHERE
		ad_client_id IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = 'DEFAULTS_NOT_CONFIGURED'
	)
	AND ad_client_id NOT IN (
	SELECT
		ad_client_id
	FROM
		c_elementvalue
	WHERE
		value = '99999'
);

DROP TABLE IF EXISTS tmp_c_elementvalue_id_to_update;
SELECT
	ad_client_id,
	c_elementvalue_id
INTO TEMP TABLE
	tmp_c_elementvalue_id_to_update
FROM
	c_elementvalue
WHERE
	value = 'DEFAULTS_NOT_CONFIGURED'
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

DROP TABLE IF EXISTS tmp_c_elementvalue_id_to_remove;
SELECT
	c_elementvalue_id
INTO TEMP TABLE
	tmp_c_elementvalue_id_to_remove
FROM
	c_elementvalue
WHERE
		value IN (
		          'B_ASSET',
		          'B_INTRANSIT',
		          'B_UNALLOCATEDCASH',
		          'CB_ASSET',
		          'CB_CASHTRANSFER',
		          'C_RECEIVABLE',
		          'C_RECEIVABLE_SERVICES',
		          'V_PREPAYMENT',
		          'T_CREDIT',
		          'INTERCOMPANYDUEFROM',
		          'P_ASSET',
		          'PJ_ASSET',
		          'PJ_WIP',
		          'V_LIABILITY',
		          'NOTINVOICEDRECEIPTS',
		          'V_LIABILITY_SERVICES',
		          'B_PAYMENTSELECT',
		          'C_PREPAYMENT',
		          'T_DUE',
		          'INTERCOMPANYDUETO',
		          'P_REVENUE',
		          'UNEARNEDREVENUE',
		          'P_TRADEDISCOUNTGRANT',
		          'PAYDISCOUNT_EXP',
		          'P_COGS',
		          'P_EXPENSE',
		          'P_COSTADJUSTMENT',
		          'P_LANDEDCOSTCLEARING',
		          'P_INVENTORYCLEARING',
		          'W_DIFFERENCES',
		          'P_INVOICEPRICEVARIANCE',
		          'P_PURCHASEPRICEVARIANCE',
		          'PPVOFFSET',
		          'P_RATEVARIANCE',
		          'P_AVERAGECOSTVARIANCE',
		          'P_TRADEDISCOUNTREC',
		          'PAYDISCOUNT_REV',
		          'T_EXPENSE',
		          'WRITEOFF',
		          'CB_DIFFERENCES',
		          'DEFAULT',
		          'SUSPENSEBALANCING',
		          'CB_EXPENSE',
		          'CB_RECEIPT',
		          'CH_EXPENSE',
		          'B_INTERESTREV',
		          'UNREALIZEDGAIN',
		          'REALIZEDGAIN',
		          'B_INTERESTEXP',
		          'UNREALIZEDLOSS',
		          'REALIZEDLOSS',
		          'CURRENCYBALANCING',
		          'COMMITMENTOFFSET',
		          'COMMITMENTOFFSETSALES')
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

-- Update the base DEFAULTS_NOT_CONFIGURED account to be the DO NOT USE account
UPDATE c_elementvalue
SET
	value       = '99999',
	name        = 'DO NOT USE',
	description = 'DO NOT USE',
	accounttype = 'E',
	issummary   = 'N'
WHERE
	value = 'DEFAULTS_NOT_CONFIGURED'
	AND ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

-- Update the valid combination labels to match and point to this new account
UPDATE c_validcombination
SET
	combination = '*-99999-_-_',
	description = '*-DO NOT USE-_-_'
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_update
	);
UPDATE c_validcombination vc
SET
	combination = '*-99999-_-_',
	description = '*-DO NOT USE-_-_',
	account_id  = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND vc.ad_client_id = tevitu.ad_client_id;

-- Update other tables that were mapping to these accounts
SELECT
	bh_execute_statement_without_indexes('
UPDATE fact_acct fa
SET
	account_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND fa.ad_client_id = tevitu.ad_client_id;
UPDATE c_charge c
SET
	c_elementvalue_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		c.c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND c.ad_client_id = tevitu.ad_client_id;
UPDATE c_acctschema_element ase
SET
	c_elementvalue_id = tevitu.c_elementvalue_id
FROM
	tmp_c_elementvalue_id_to_update tevitu
WHERE
		ase.c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	)
	AND ase.ad_client_id = tevitu.ad_client_id;

-- Delete the other bad element values
DELETE
FROM
	c_elementvalue
WHERE
		c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	);
DELETE
FROM
	c_elementvalue_trl
WHERE
		c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			tmp_c_elementvalue_id_to_remove
	);', 'c_elementvalue_id');

-- Update the charges to have the correct
UPDATE c_charge c
SET
	c_elementvalue_id = ev.c_elementvalue_id
FROM
	c_charge cc
		JOIN c_charge_acct cac
			ON cc.c_charge_id = cac.c_charge_id
		JOIN c_validcombination vc
			ON cac.ch_expense_acct = vc.c_validcombination_id
		JOIN c_elementvalue evc
			ON vc.account_id = evc.c_elementvalue_id
		JOIN c_elementvalue ev
			ON ev.value = evc.value
WHERE
	c.bh_locked = 'Y'
	AND c.name = cc.name
	AND cc.ad_client_id = 2
	AND c.ad_client_id = ev.ad_client_id
	AND c.ad_client_id IN (
	SELECT
		ad_client_id
	FROM
		tmp_c_client_id
);

SELECT
	register_migration_script('202211221315_GO-2496.sql')
FROM
	dual;
