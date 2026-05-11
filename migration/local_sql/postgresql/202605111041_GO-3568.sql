CREATE INDEX IF NOT EXISTS bhencounterdiagnostic_bhencounter_idx
	ON bh_encounter_diagnostic (bh_encounter_id);

CREATE INDEX IF NOT EXISTS bhconceptmapping_from_to_url_idx
	ON bh_concept_mapping (bh_from_concept_url, bh_to_concept_url)
	WHERE bh_map_type IN ('SAME-AS', 'Same As')
		AND bh_from_concept_url <> bh_to_concept_url;

SELECT
	register_migration_script('202605111041_GO-3568.sql')
FROM
	dual;
