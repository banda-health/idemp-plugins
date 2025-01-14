-- Create indexes for faster querying on PTR and MOH reports
CREATE INDEX bh_encounter_bh_visit_id ON bh_encounter (bh_visit_id);
CREATE INDEX bh_encounter_diagnosis_bh_encounter_id ON bh_encounter_diagnosis (bh_encounter_id);

SELECT
	register_migration_script('202501101324_GO-2987.sql')
FROM
	dual;
