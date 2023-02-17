-- Redo the negative inventory check
UPDATE m_warehouse
SET
	isdisallownegativeinv = 'Y'
WHERE
	ad_client_id != 0;

SELECT
	register_migration_script('202302130913_GO-2376.sql')
FROM
	dual;
