-- Update some specific, old records that are pointing to an inactive locator
UPDATE m_storageonhand
SET
	m_locator_id = 1000114
WHERE
	m_locator_id = 1000099;

-- Update one transaction that has the wrong ASI on it (due to old, bad data from before the mass ASI update to ensure everything has an ASI)
-- This is the only problem of this kind in the system
UPDATE m_transaction
SET
	m_attributesetinstance_id = 1047542
WHERE
	m_transaction_uu = '504fafcb-8607-4fbd-9811-7eee7c708c8f';

SELECT register_migration_script('202207261317_GO-2404.sql') FROM dual;
