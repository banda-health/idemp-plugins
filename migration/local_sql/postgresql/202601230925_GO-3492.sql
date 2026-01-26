-- Clear some old data from 2023 that shouldn't be there
DELETE
FROM
	bh_encounter_diagnosis
WHERE
	bh_concept_id IS NULL
	AND TRIM(bh_uncoded_diagnosis) = '';

SELECT
	register_migration_script('202601230925_GO-3492.sql')
FROM
	dual;
