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
UPDATE AD_Process_Para SET name = 'Coded Diagnosis', columnname = 'BH_Concept_UU' WHERE AD_Process_Para_UU = '250d4efb-e958-4ef6-95cf-4d23b10f0972';

-- Create bh_client_concept_extra table
CREATE TABLE BH_Client_Concept_Extra (
	AD_Client_ID NUMERIC(10) DEFAULT NULL, 
	AD_Org_ID NUMERIC(10) DEFAULT NULL, 
	BH_Client_Concept_Extra_ID NUMERIC(10) DEFAULT NULL, 
	BH_Client_Concept_Extra_UU VARCHAR(36) DEFAULT NULL, 
	BH_Concept_Extra_ID NUMERIC(10) DEFAULT NULL,
	BH_Value TEXT DEFAULT NULL, 
	Created TIMESTAMP DEFAULT getDate(), 
	CreatedBy NUMERIC(10) DEFAULT NULL, 
	IsActive CHAR(1) NOT NULL CHECK (IsActive IN ('Y','N')) DEFAULT 'Y', 
	Updated TIMESTAMP DEFAULT getDate(), 
	UpdatedBy NUMERIC(10) DEFAULT NULL, 
	
	CONSTRAINT BH_Client_Concept_Extra_Key PRIMARY KEY (BH_Client_Concept_Extra_ID), 
	CONSTRAINT BH_Client_Concept_Extra_UU_idx UNIQUE (BH_Client_Concept_Extra_UU)
); 
	
ALTER TABLE BH_Concept_Extra ADD CONSTRAINT BHConceptExtra_BHClientConceptExtra FOREIGN KEY (BH_Concept_Extra_ID) REFERENCES bh_concept_extra(bh_concept_extra_id) DEFERRABLE INITIALLY DEFERRED;

-- Add columns
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:12.386000', '2024-05-13 17:23:12.386000', 100, 100, 'Tenant', 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 0, 'U', 'AD_Client_ID', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 19, null, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 102, null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'ff5ff9a8-2318-4c0f-a800-be55e0839d39', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:12.458000', '2024-05-13 17:23:12.458000', 100, 100, 'Organization', 'Organizational entity within tenant', 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.', 0, 'U', 'AD_Org_ID', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 19, null, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 113, null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'dd3f8a7a-3d72-48c4-b2da-953d07217dc6', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:12.589000', '2024-05-13 17:23:12.589000', 100, 100, 'Client Concept Extra', null, null, 0, 'U', 'BH_Client_Concept_Extra_ID', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 13, null, null, 100, null, 'Y', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU='222ef2df-6f19-4d50-a732-61060f3ae475'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '684d8360-6207-4882-b717-b7c84149b7a4', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:12.767000', '2024-05-13 17:23:12.767000', 100, 100, 'BH_Client_Concept_Extra_UU', null, null, 0, 'U', 'BH_Client_Concept_Extra_UU', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 10, null, null, 36, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU='caa32456-e5f3-430e-a65d-478c1a0bbcb5'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'b1e257ac-a255-4018-ba62-d95d28437140', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.337000', '2024-05-13 17:23:13.337000', 100, 100, 'BH_Value', 'BH_Value', null, 0, 'U', 'BH_Value', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 36, null, null, 0, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU='7ef17536-61e1-4421-9e75-e3732e604dd2'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '9977c013-ef3a-41d8-883d-ff33256eaa63', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.454000', '2024-05-13 17:23:13.454000', 100, 100, 'Created', 'Date this record was created', 'The Created field indicates the date that this record was created.', 0, 'U', 'Created', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 245, null, 'Y', 'N', null, null, null, 'N', 'Y', null, '5c50276d-7948-4475-9430-1e98467337a4', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.566000', '2024-05-13 17:23:13.566000', 100, 100, 'Created By', 'User who created this records', 'The Created By field indicates the user who created this record.', 0, 'U', 'CreatedBy', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 30, 110, null, 22, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 246, null, 'Y', 'N', null, null, null, 'N', 'Y', null, '82ee9c48-09b9-4207-99aa-a405bd42f6c5', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.709000', '2024-05-13 17:23:13.709000', 100, 100, 'Active', 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.', 0, 'U', 'IsActive', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 20, null, null, 1, 'Y', 'N', 'N', 'Y', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 348, null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'f56cce73-b7cb-4193-b0bf-ff50baffedf2', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.824000', '2024-05-13 17:23:13.824000', 100, 100, 'Updated', 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 0, 'U', 'Updated', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 607, null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'a0b8f40e-55e5-4bad-8c77-f065c20fddce', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:13.934000', '2024-05-13 17:23:13.934000', 100, 100, 'Updated By', 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 0, 'U', 'UpdatedBy', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 30, 110, null, 22, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 608, null, 'Y', 'N', null, null, null, 'N', 'Y', null, '84f5ea50-e1c6-4d1c-a9f9-a110903f5cba', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2024-05-13 17:23:12.922000', '2024-05-13 17:29:28.298000', 100, 100, 'Concept Extra', null, null, 0, 'U', 'BH_Concept_Extra_ID', (SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU='ead1abc8-23d2-467c-b405-d50a4ff6f117'), 19, null, null, 100, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU='b86d7ed3-db6c-412d-8868-7e8b29fcdbd2'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '48434ac6-6a3a-4056-9020-ca1e9d01346c', 'Y', 0, 'N', 'N', null, 'BHConceptExtra_BHClientConcept', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null) ON CONFLICT DO NOTHING;

-- insert sequences
INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((
		 SELECT
			 MAX(ad_sequence_id) + 1
		 FROM
			 ad_sequence
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.824000', 100, '2024-05-13 17:23:13.824000', 100, 'BH_Client_Concept_Extra',
	 'Table BH_Client_Concept_Extra', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '944387fb-6175-4cd7-8333-541b2291e885', 'N', 'N', NULL) ON CONFLICT DO NOTHING;

-- Populate bh_client_concept_extra with existing data
CREATE TEMP TABLE tmp_bh_client_concept_extra
(
	ad_client_id                        numeric(10)             NOT NULL,
	ad_org_id                           numeric(10)             NOT NULL,
	bh_concept_extra_id                 numeric(10)             NOT NULL,
	bh_client_concept_extra_uu          uuid                    DEFAULT uuid_generate_v4(),
	bh_client_concept_extra_id          serial,                 NOT NULL,
 	created                             timestamp               DEFAULT NOW()       NOT NULL,
	createdby                           numeric(10)             DEFAULT 100 NOT NULL,
 	isactive                            char                    DEFAULT 'Y'::bpchar NOT NULL,
 	updated                             timestamp               DEFAULT NOW()       NOT NULL,
	updatedby                           numeric(10)             DEFAULT 100 NOT NULL,
	bh_value                            text                    NOT NULL
);

-- Insert the values into our temp table
INSERT
INTO
	tmp_bh_client_concept_extra (ad_client_id, ad_org_id, bh_value, bh_concept_extra_id)
SELECT
    cc.ad_client_id,
    cc.ad_org_id,
    cc.name,
    ce.bh_concept_extra_id
FROM
    bh_client_concept cc
INNER JOIN bh_concept_extra ce ON cc.bh_concept_id = ce.bh_concept_id AND ce.bh_key = 'local_name';

-- Insert into bh_client_concept_extra
INSERT INTO
	bh_client_concept_extra (ad_client_id, ad_org_id, bh_client_concept_extra_uu, bh_client_concept_extra_id, created, createdby, isactive, updated, updatedby, bh_value)
SELECT
	ad_client_id, ad_org_id, bh_client_concept_extra_uu, bh_client_concept_extra_id, created, createdby, isactive, updated, updatedby, bh_value
FROM
	tmp_bh_client_concept_extra;

-- Delete bh_client_concept table
DROP TABLE BH_Client_Concept CASCADE;
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
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_client_concept'
			)
	);
DELETE
FROM
	ad_ref_table
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_client_concept'
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_client_concept'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_client_concept'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_client_concept'
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
			LOWER(tablename) = 'bh_client_concept'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_client_concept';

SELECT
	register_migration_script('202404041052_GO-2923.sql')
FROM
	dual;
