-- Revert the negative inventory check until we know how we're going to solve this problem
UPDATE m_warehouse
SET
	isdisallownegativeinv = 'N'
WHERE
	ad_client_id NOT IN (0, 11);

SELECT
	register_migration_script('202212010645_GO-2376.sql')
FROM
	dual;
