-----------------------------------------------------------------------------
-- Migration Script: GO-3523 - Remove Banda UOM Records

-- Re-map the UOMs to the default UOM (Each (100))
UPDATE m_product
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

UPDATE m_movementline
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

UPDATE m_inoutline
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

UPDATE c_orderline
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

UPDATE c_invoiceline
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

UPDATE fact_acct
SET
	c_uom_id = 100
WHERE
	c_uom_id != 100
	AND ad_client_id > 999999;

-- Delete the Banda UOMs translations
DELETE
FROM
	c_uom_trl
WHERE
	c_uom_id IN (
		SELECT
			c_uom_id
		FROM
			c_uom
		WHERE
			c_uom_uu IN ('015f8f25-216b-4bb0-a4f8-3f19f84d27d4', '8afa898c-1a7e-4b66-b878-694409c720ff',
			             '6678e6da-bed0-4704-acc2-f45a77022130')
	);

-- Delete the Banda UOMs
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_uom
WHERE
	c_uom_uu IN ('015f8f25-216b-4bb0-a4f8-3f19f84d27d4', '8afa898c-1a7e-4b66-b878-694409c720ff',
	             '6678e6da-bed0-4704-acc2-f45a77022130');$$, 'c_uom_id');

SELECT
	register_migration_script('202603111517_GO-3523.sql')
FROM
	dual;
