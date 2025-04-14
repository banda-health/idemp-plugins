-- Ensure each extra can only have one override per client
CREATE UNIQUE INDEX bhclientconceptextra_unique ON bh_client_concept_extra (ad_client_id, bh_concept_extra_id);

-- Register the script
SELECT
	register_migration_script('202504091042_GO-3261.sql')
FROM
	dual;
