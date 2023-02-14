-- Revert the negative inventory check until we know how we're going to solve this problem
UPDATE m_warehouse
SET
	isdisallownegativeinv = 'Y'
WHERE
	ad_client_id != 0;

SELECT
	register_migration_script('202302130913_GO-2376.sql')
FROM
	dual;
