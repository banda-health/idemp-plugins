CREATE INDEX IF NOT EXISTS bh_observation_encounter_field_idx
	ON bh_observation (bh_encounter_id, ad_field_id);

UPDATE ad_process
SET
	jasperreport = 'Patient Summary/PatientSummary.jasper',
	updated      = NOW()
WHERE
	ad_process_uu = 'c0e1adfc-f743-49e4-9346-4da29f1e9f6c';

SELECT
	register_migration_script('202605111422_GO-3566.sql')
FROM
	dual;
