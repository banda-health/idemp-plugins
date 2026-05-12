CREATE INDEX IF NOT EXISTS bhencounterdiagnostic_group1_idx
	ON bh_encounter_diagnostic (group1);

SELECT
	register_migration_script('202605121034_GO-3568.sql')
FROM
	dual;
