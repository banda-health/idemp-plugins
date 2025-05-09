CREATE INDEX mtransaction_adclient_idx ON m_transaction (ad_client_id);

SELECT
	register_migration_script('202505092056_GO-3315.sql')
FROM
	dual;
