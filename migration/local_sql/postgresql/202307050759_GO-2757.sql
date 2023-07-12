CREATE INDEX IF NOT EXISTS bh_visit_patient
	ON bh_visit (patient_id);

CREATE INDEX IF NOT EXISTS bh_visit_bh_visitdate_index
	ON bh_visit (bh_visitdate DESC);

REINDEX TABLE bh_visit;

SELECT
	register_migration_script('202307050759_GO-2757.sql')
FROM
	dual;
