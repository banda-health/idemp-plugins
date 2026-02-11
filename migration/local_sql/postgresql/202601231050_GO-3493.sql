CREATE INDEX bh_concept_mapping_from_concept ON bh_concept_mapping (from_bh_concept_id);
CREATE INDEX bh_concept_mapping_to_concept ON bh_concept_mapping (to_bh_concept_id);
CREATE INDEX bh_concept_extra_concept ON bh_concept_extra (bh_concept_id);
CREATE INDEX bh_concept_extra_concept_mapping ON bh_concept_extra (bh_concept_mapping_id);

SELECT
	register_migration_script('202601231050_GO-3493.sql')
FROM
	dual;
