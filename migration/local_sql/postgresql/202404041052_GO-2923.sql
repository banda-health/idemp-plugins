-- 1. Add bh_concept_id column in bh_encounter_diagnosis table
-- 2. Update the new bh_concept_id column to point to bh_concept table values.
-- 3. Drop bh_coded_diagnosis_id column 
-- 4. Drop bh_coded_diagnosis_mapping table	
-- 5. Drop bh_coded_diagnosis table
-- 6. Update CodedDiagnosisSyncProcess to point to ConceptSyncProcess
-- 7. Update reports

-- Step 1:
ALTER TABLE BH_Encounter_Diagnosis ADD COLUMN BH_Concept_ID NUMERIC(10) DEFAULT NULL;
-- ALTER TABLE BH_Encounter_Diagnosis ADD CONSTRAINT BHConcept_BHEncounterDiagnosis FOREIGN KEY (BH_Concept_ID) REFERENCES bh_concept(bh_concept_id) DEFERRABLE INITIALLY DEFERRED; 

INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-04-04 12:14:57.678000', '2024-04-04 12:15:05.129000', 100, 100, 'Concept', null, null, 0, 'U', 'BH_Concept_ID', (SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU='fcc39724-f742-4fe3-b589-587a69c128e4'), 19, null, null, 10, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 1000310, null, 'N', 'N', null, null, null, 'N', 'Y', null, '56380abf-0060-4511-9a22-0f966a598729', 'Y', 0, 'N', 'N', null, 'BHConcept_BHEncounterDiagnosis', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;

-- Step 2:
DROP TABLE IF EXISTS tmp_bh_encounter_diagnosis_coded_diagnosis_ids;

SELECT 
	e.bh_coded_diagnosis_id,
	c.bh_concept_id
INTO TEMP TABLE tmp_bh_encounter_diagnosis_coded_diagnosis_ids
FROM 
	bh_encounter_diagnosis e
	INNER JOIN bh_coded_diagnosis cd ON e.bh_coded_diagnosis_id = cd.bh_coded_diagnosis_id
	INNER JOIN bh_concept c ON cd.bh_cielname = c.bh_display_name AND c.bh_source='BHGO';

UPDATE bh_encounter_diagnosis ed SET bh_concept_id = tmp.bh_concept_id FROM tmp_bh_encounter_diagnosis_coded_diagnosis_ids tmp WHERE ed.bh_coded_diagnosis_id = tmp.bh_coded_diagnosis_id;

-- Step 3:
DELETE FROM AD_Column WHERE AD_Column_UU='65218da9-6835-4cda-a2d8-f275b313b1c4';
ALTER TABLE BH_Encounter_Diagnosis DROP COLUMN BH_Coded_Diagnosis_ID; 

-- Step 4:
DROP TABLE BH_Coded_Diagnosis_Mapping CASCADE;
DELETE
FROM
	ad_field
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis_mapping'
			)
	);
DELETE
FROM
	ad_ref_table
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis_mapping'
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis_mapping'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis_mapping'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis_mapping'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_coded_diagnosis_mapping'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_coded_diagnosis_mapping';
	
-- Step 5	
-- update coded diagnoses tab to point to bh_concept table
UPDATE  AD_Tab SET AD_Table_ID = (SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '2dcec3ca-58e7-4f5e-86b9-90465b99a581') WHERE AD_Tab_UU = 'd25b4199-f9f8-482a-b4a7-cdc7a628bf10';

DROP TABLE BH_Coded_Diagnosis CASCADE;
DELETE
FROM
	ad_field
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis'
			)
	);
DELETE
FROM
	ad_ref_table
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis'
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_coded_diagnosis'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_coded_diagnosis';

-- Step 6:
UPDATE AD_Process SET classname = 'org.bandahealth.idempiere.base.process.ConceptSyncProcess' WHERE AD_Process_UU='dc0a5369-1478-46ff-aef4-8bac662132b7';

-- Step 7:
UPDATE AD_Process_Para SET name = 'Concept', columnname = 'BH_Concept_UU' WHERE AD_Process_Para_UU = '250d4efb-e958-4ef6-95cf-4d23b10f0972';

SELECT
	register_migration_script('202404041052_GO-2923.sql')
FROM
	dual;
