-- 1. Add bh_concept_id column in bh_encounter_diagnosis table
-- 2. Update the new bh_concept_id column to point to bh_concept table values.
-- 3. Drop bh_coded_diagnosis_id column
-- 4. Drop bh_coded_diagnosis_mapping table
-- 5. Drop bh_coded_diagnosis table
-- 6. Remove CodedDiagnosisSyncProcess
-- 7. Update reports

-- Step 1:
ALTER TABLE BH_Encounter_Diagnosis
	ADD COLUMN BH_Concept_ID NUMERIC(10) DEFAULT NULL;
ALTER TABLE BH_Encounter_Diagnosis
	ADD CONSTRAINT BHConcept_BHEncounterDiagnosis FOREIGN KEY (BH_Concept_ID) REFERENCES bh_concept (bh_concept_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-04-04 12:14:57.678000', '2024-04-04 12:15:05.129000', 100, 100, 'Concept', NULL, NULL, 0, 'U',
	 'BH_Concept_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f5d356cd-fdb8-4fdd-aea5-2e11726c0141'
	 ), NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '56380abf-0060-4511-9a22-0f966a598729', 'Y', 0, 'N', 'N', NULL,
	 'BHConcept_BHEncounterDiagnosis', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;

-- Step 2:
DROP TABLE IF EXISTS tmp_bh_encounter_diagnosis_coded_diagnosis_ids;

SELECT
	e.bh_coded_diagnosis_id,
	c.bh_concept_id
INTO TEMP TABLE
	tmp_bh_encounter_diagnosis_coded_diagnosis_ids
FROM
	bh_encounter_diagnosis e
		INNER JOIN bh_coded_diagnosis cd
		ON e.bh_coded_diagnosis_id = cd.bh_coded_diagnosis_id
		INNER JOIN bh_concept c
		ON cd.bh_cielname = c.bh_display_name AND c.bh_source = 'BHGO';

UPDATE bh_encounter_diagnosis ed
SET
	bh_concept_id = tmp.bh_concept_id
FROM
	tmp_bh_encounter_diagnosis_coded_diagnosis_ids tmp
WHERE
	ed.bh_coded_diagnosis_id = tmp.bh_coded_diagnosis_id;

-- Step 3:
DELETE
FROM
	AD_Column
WHERE
	AD_Column_UU = '65218da9-6835-4cda-a2d8-f275b313b1c4';
ALTER TABLE BH_Encounter_Diagnosis
	DROP COLUMN BH_Coded_Diagnosis_ID;

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
UPDATE AD_Tab
SET
	AD_Table_ID = (
		SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '2dcec3ca-58e7-4f5e-86b9-90465b99a581'
	)
WHERE
	AD_Tab_UU = 'd25b4199-f9f8-482a-b4a7-cdc7a628bf10';

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
DELETE
FROM
	AD_Process_Para
WHERE
	AD_Process_ID IN (
		SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU = 'dc0a5369-1478-46ff-aef4-8bac662132b7'
	);
DELETE
FROM
	AD_Menu
WHERE
	AD_Process_ID IN (
		SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU = 'dc0a5369-1478-46ff-aef4-8bac662132b7'
	);
DELETE
FROM
	AD_PInstance
WHERE
	AD_Process_ID IN (
		SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU = 'dc0a5369-1478-46ff-aef4-8bac662132b7'
	);

DELETE
FROM
	AD_Process
WHERE
	AD_Process_UU = 'dc0a5369-1478-46ff-aef4-8bac662132b7';

-- Create bh_client_concept_extra table
CREATE TABLE BH_Client_Concept_Extra
(
	AD_Client_ID               NUMERIC(10)                                     DEFAULT NULL,
	AD_Org_ID                  NUMERIC(10)                                     DEFAULT NULL,
	BH_Client_Concept_Extra_ID NUMERIC(10)                                     DEFAULT NULL,
	BH_Client_Concept_Extra_UU VARCHAR(36)                                     DEFAULT NULL,
	BH_Concept_Extra_ID        NUMERIC(10)                                     DEFAULT NULL,
	BH_Value                   TEXT                                            DEFAULT NULL,
	Created                    TIMESTAMP                                       DEFAULT getDate(),
	CreatedBy                  NUMERIC(10)                                     DEFAULT NULL,
	IsActive                   CHAR(1) NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Updated                    TIMESTAMP                                       DEFAULT getDate(),
	UpdatedBy                  NUMERIC(10)                                     DEFAULT NULL,

	CONSTRAINT BH_Client_Concept_Extra_Key PRIMARY KEY (BH_Client_Concept_Extra_ID),
	CONSTRAINT BH_Client_Concept_Extra_UU_idx UNIQUE (BH_Client_Concept_Extra_UU)
);

ALTER TABLE BH_Concept_Extra
	ADD CONSTRAINT BHConceptExtra_BHClientConceptExtra FOREIGN KEY (BH_Concept_Extra_ID) REFERENCES bh_concept_extra (bh_concept_extra_id) DEFERRABLE INITIALLY DEFERRED;

-- Add table
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT
			 MAX(AD_Table_ID) + 1
		 FROM
			 AD_Table
	 ), 0, 0, 'Y', '2024-05-13 17:19:34.488000', 100, '2024-05-13 17:19:34.488000', 100, 'Client Concept Extra', NULL,
	 NULL, 'BH_Client_Concept_Extra', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'ead1abc8-23d2-467c-b405-d50a4ff6f117', 'N', 'N', 'N', 'N', 'N', 'N', 'N')
ON CONFLICT DO NOTHING;

-- Add columns
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:12.386000', '2024-05-13 17:23:12.386000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 0, 'U', 'AD_Client_ID', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ff5ff9a8-2318-4c0f-a800-be55e0839d39', 'N', 0, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:12.458000', '2024-05-13 17:23:12.458000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 0, 'U', 'AD_Org_ID', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 113,
	 NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dd3f8a7a-3d72-48c4-b2da-953d07217dc6', 'N', 0, 'N', 'N', NULL,
	 NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:12.589000', '2024-05-13 17:23:12.589000', 100, 100, 'Client Concept Extra', NULL,
	 NULL, 0, 'U', 'BH_Client_Concept_Extra_ID', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 13, NULL, NULL, 100, NULL, 'Y', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU = '222ef2df-6f19-4d50-a732-61060f3ae475'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '684d8360-6207-4882-b717-b7c84149b7a4', 'N', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:12.767000', '2024-05-13 17:23:12.767000', 100, 100, 'BH_Client_Concept_Extra_UU',
	 NULL, NULL, 0, 'U', 'BH_Client_Concept_Extra_UU', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU = 'caa32456-e5f3-430e-a65d-478c1a0bbcb5'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b1e257ac-a255-4018-ba62-d95d28437140', 'N', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.337000', '2024-05-13 17:23:13.337000', 100, 100, 'BH_Value', 'BH_Value', NULL, 0,
	 'U', 'BH_Value', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU = '7ef17536-61e1-4421-9e75-e3732e604dd2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9977c013-ef3a-41d8-883d-ff33256eaa63', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.454000', '2024-05-13 17:23:13.454000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 0, 'U',
	 'Created', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5c50276d-7948-4475-9430-1e98467337a4', 'N', 0, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.566000', '2024-05-13 17:23:13.566000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 0, 'U',
	 'CreatedBy', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL, 'Y',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '82ee9c48-09b9-4207-99aa-a405bd42f6c5', 'N', 0, 'N', 'N', NULL, NULL, 'D',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.709000', '2024-05-13 17:23:13.709000', 100, 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 0, 'U', 'IsActive', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL, 'Y',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f56cce73-b7cb-4193-b0bf-ff50baffedf2', 'N', 0, 'N', 'N', NULL, NULL, 'N',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.824000', '2024-05-13 17:23:13.824000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 0, 'U',
	 'Updated', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a0b8f40e-55e5-4bad-8c77-f065c20fddce', 'N', 0, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:13.934000', '2024-05-13 17:23:13.934000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 0, 'U',
	 'UpdatedBy', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL, 'Y',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '84f5ea50-e1c6-4d1c-a9f9-a110903f5cba', 'N', 0, 'N', 'N', NULL, NULL, 'D',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-05-13 17:23:12.922000', '2024-05-13 17:29:28.298000', 100, 100, 'Concept Extra', NULL, NULL, 0,
	 'U', 'BH_Concept_Extra_ID', (
		 SELECT AD_Table_ID FROM AD_TABLE WHERE AD_Table_UU = 'ead1abc8-23d2-467c-b405-d50a4ff6f117'
	 ), 19, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_ELEMENT_UU = 'b86d7ed3-db6c-412d-8868-7e8b29fcdbd2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '48434ac6-6a3a-4056-9020-ca1e9d01346c', 'Y', 0, 'N', 'N', NULL,
	 'BHConceptExtra_BHClientConcept', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;

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
	 '944387fb-6175-4cd7-8333-541b2291e885', 'N', 'N', NULL)
ON CONFLICT DO NOTHING;

-- Populate bh_client_concept_extra with existing data
CREATE TEMP TABLE tmp_bh_client_concept_extra
(
	ad_client_id               numeric(10)                     NOT NULL,
	ad_org_id                  numeric(10)                     NOT NULL,
	bh_concept_extra_id        numeric(10)                     NOT NULL,
	bh_client_concept_extra_uu uuid        DEFAULT uuid_generate_v4(),
	bh_client_concept_extra_id numeric(10)                     NOT NULL,
	created                    timestamp   DEFAULT NOW()       NOT NULL,
	createdby                  numeric(10) DEFAULT 100         NOT NULL,
	isactive                   char        DEFAULT 'Y'::bpchar NOT NULL,
	updated                    timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                  numeric(10) DEFAULT 100         NOT NULL,
	bh_value                   text                            NOT NULL
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
		INNER JOIN bh_concept_extra ce
		ON cc.bh_concept_id = ce.bh_concept_id AND ce.bh_key = 'local_name';

-- Insert into bh_client_concept_extra
INSERT INTO
	bh_client_concept_extra (ad_client_id, ad_org_id, bh_client_concept_extra_uu, bh_client_concept_extra_id, created,
	                         createdby, isactive, updated, updatedby, bh_value)
SELECT
	ad_client_id,
	ad_org_id,
	bh_client_concept_extra_uu,
	bh_client_concept_extra_id,
	created,
	createdby,
	isactive,
	updated,
	updatedby,
	bh_value
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

-- Update the template file to remove and add tables
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = '''A_Asset'',''A_Asset_Acct'',''A_Asset_Addition'',''A_Asset_Change'',''A_Asset_Class'',''A_Asset_Delivery'',''A_Asset_Disposed'',''A_Asset_Group'',''A_Asset_Group_Acct'',''A_Asset_Info_Fin'',''A_Asset_Info_Ins'',''A_Asset_Info_Lic'',''A_Asset_Info_Oth'',''A_Asset_Info_Tax'',''A_Asset_Product'',''A_Asset_Retirement'',''A_Asset_Reval'',''A_Asset_Reval_Entry'',''A_Asset_Reval_Index'',''A_Asset_Split'',''A_Asset_Transfer'',''A_Asset_Type'',''A_Asset_Use'',''A_Depreciation'',''A_Depreciation_Build'',''A_Depreciation_Convention'',''A_Depreciation_Entry'',''A_Depreciation_Exp'',''A_Depreciation_Forecast'',''A_Depreciation_Method'',''A_Depreciation_Table_Detail'',''A_Depreciation_Table_Header'',''A_Depreciation_Workfile'',''A_FundingMode'',''A_FundingMode_Acct'',''A_Registration'',''A_RegistrationAttribute'',''A_RegistrationProduct'',''A_RegistrationValue'',''AD_AccessLog'',''AD_Alert'',''AD_AlertProcessor'',''AD_AlertProcessorLog'',''AD_AlertRecipient'',''AD_AlertRule'',''AD_AllClients_V'',''AD_AllUsers_V'',''AD_Archive'',''AD_Attachment'',''AD_AttachmentNote'',''AD_Attribute'',''AD_Attribute_Value'',''AD_AuthorizationAccount'',''AD_AuthorizationCredential'',''AD_AuthorizationProvider'',''AD_BroadcastMessage'',''AD_ChangeLog'',''AD_Chart'',''AD_ChartDatasource'',''AD_Client'',''AD_ClientInfo'',''AD_ClientShare'',''AD_Color'',''AD_Column'',''AD_Column_Access'',''AD_CtxHelp'',''AD_CtxHelpMsg'',''AD_CtxHelpSuggestion'',''AD_Desktop'',''AD_DesktopWorkbench'',''AD_Document_Action_Access'',''AD_Element'',''AD_EntityType'',''AD_Error'',''AD_Field'',''AD_FieldGroup'',''AD_FieldSuggestion'',''AD_Find'',''AD_Form'',''AD_Form_Access'',''AD_HouseKeeping'',''AD_Image'',''AD_ImpFormat'',''AD_ImpFormat_Row'',''AD_ImportTemplate'',''AD_ImportTemplateAccess'',''AD_IndexColumn'',''AD_InfoColumn'',''AD_InfoProcess'',''AD_InfoRelated'',''AD_InfoWindow'',''AD_InfoWindow_Access'',''AD_Issue'',''AD_LabelPrinter'',''AD_LabelPrinterFunction'',''AD_Language'',''AD_LdapAccess'',''AD_LdapProcessor'',''AD_LdapProcessorLog'',''AD_Menu'',''AD_Message'',''AD_MigrationScript'',''AD_ModelValidator'',''AD_Modification'',''AD_Note'',''AD_Org'',''AD_OrgInfo'',''AD_OrgType'',''AD_Package_Exp'',''AD_Package_Exp_Detail'',''AD_Package_Imp'',''AD_Package_Imp_Backup'',''AD_Package_Imp_Detail'',''AD_Package_Imp_Inst'',''AD_Package_Imp_Proc'',''AD_Package_UUID_Map'',''AD_Password_History'',''AD_PasswordRule'',''AD_PInstance'',''AD_PInstance_Log'',''AD_PInstance_Para'',''AD_PostIt'',''AD_Preference'',''AD_PrintColor'',''AD_PrintFont'',''AD_PrintForm'',''AD_PrintFormat'',''AD_PrintFormatItem'',''AD_PrintGraph'',''AD_PrintHeaderFooter'',''AD_PrintLabel'',''AD_PrintLabelLine'',''AD_PrintPaper'',''AD_PrintTableFormat'',''AD_Private_Access'',''AD_Process'',''AD_Process_Access'',''AD_Process_Para'',''AD_RecentItem'',''AD_Record_Access'',''AD_Ref_List'',''AD_Ref_Table'',''AD_Reference'',''AD_Registration'',''AD_RelationType'',''AD_Replication'',''AD_Replication_Log'',''AD_Replication_Run'',''AD_ReplicationDocument'',''AD_ReplicationStrategy'',''AD_ReplicationTable'',''AD_ReportView'',''AD_ReportView_Col'',''AD_ReportView_Column'',''AD_Role'',''AD_Role_Included'',''AD_Role_OrgAccess'',''AD_Rule'',''AD_Schedule'',''AD_Scheduler'',''AD_Scheduler_Para'',''AD_SchedulerLog'',''AD_SchedulerRecipient'',''AD_SearchDefinition'',''AD_Sequence'',''AD_Sequence_Audit'',''AD_Sequence_No'',''AD_Session'',''AD_StatusLine'',''AD_StatusLineUsedIn'',''AD_StorageProvider'',''AD_Style'',''AD_StyleLine'',''AD_SysConfig'',''AD_System'',''AD_Tab'',''AD_Tab_Customization'',''AD_Table'',''AD_Table_Access'',''AD_Table_ScriptValidator'',''AD_TableIndex'',''AD_Task'',''AD_Task_Access'',''AD_TaskInstance'',''AD_ToolBarButton'',''AD_ToolBarButtonRestrict'',''AD_Tree'',''AD_Tree_Favorite'',''AD_Tree_Favorite_Node'',''AD_TreeBar'',''AD_TreeNode'',''AD_TreeNodeBP'',''AD_TreeNodeCMC'',''AD_TreeNodeCMM'',''AD_TreeNodeCMS'',''AD_TreeNodeCMT'',''AD_TreeNodeMM'',''AD_TreeNodePR'',''AD_TreeNodeU1'',''AD_TreeNodeU2'',''AD_TreeNodeU3'',''AD_TreeNodeU4'',''AD_User'',''AD_User_OrgAccess'',''AD_User_Roles'',''AD_User_Substitute'',''AD_UserBPAccess'',''AD_UserDef_Field'',''AD_UserDef_Info'',''AD_UserDef_Info_Column'',''AD_UserDef_Info_Related'',''AD_UserDef_Proc'',''AD_UserDef_Proc_Parameter'',''AD_UserDef_Tab'',''AD_UserDef_Win'',''AD_UserMail'',''AD_UserPreference'',''AD_UserQuery'',''AD_Val_Rule'',''AD_ViewColumn'',''AD_ViewComponent'',''AD_WF_Activity'',''AD_WF_ActivityApprover'',''AD_WF_ActivityResult'',''AD_WF_Block'',''AD_WF_EventAudit'',''AD_WF_NextCondition'',''AD_WF_Node'',''AD_WF_Node_Para'',''AD_WF_NodeNext'',''AD_WF_Process'',''AD_WF_ProcessData'',''AD_WF_Responsible'',''AD_Window'',''AD_Window_Access'',''AD_WizardProcess'',''AD_Workbench'',''AD_WorkbenchWindow'',''AD_Workflow'',''AD_Workflow_Access'',''AD_WorkflowProcessor'',''AD_WorkflowProcessorLog'',''AD_ZoomCondition'',''ASP_ClientException'',''ASP_ClientLevel'',''ASP_Field'',''ASP_Form'',''ASP_Level'',''ASP_Module'',''ASP_Process'',''ASP_Process_Para'',''ASP_Ref_List'',''ASP_Tab'',''ASP_Task'',''ASP_Window'',''ASP_Workflow'',''B_Bid'',''B_BidComment'',''B_Buyer'',''B_BuyerFunds'',''B_Offer'',''B_Seller'',''B_SellerFunds'',''B_Topic'',''B_TopicCategory'',''B_TopicType'',''BH_BP_General_Payer_Info'',''BH_BP_Payer_Info'',''BH_BP_Specific_Payer_Info'',''BH_ChargeDefault'',''BH_ChargeTypeDefault'',''BH_Client_Concept_Extra'',''BH_Concept'',''BH_Concept_Description'',''BH_Concept_Extra'',''BH_Concept_Mapping'',''BH_Concept_Name'',''BH_DbrdBtnGrp'',''BH_DbrdBtnGrp_Btn'',''BH_Default_DocAction_Access'',''BH_DefaultIncludedRole'',''BH_Encounter'',''BH_Encounter_Diagnosis'',''BH_Encounter_Type_Window'',''BH_I_Product_Quantity'',''BH_Observation'',''BH_Payer_Info_Fld'',''BH_Payer_Info_Fld_Sug'',''BH_Payer_Info_Fld_Val'',''BH_Payer_Info_Fld_Val_Sug'',''BH_PaymentRef'',''BH_PaymentRef_BankAcct'',''BH_Product_CategoryDefault'',''BH_Role_WarehouseAccess'',''BH_Stocktake_v'',''BH_TabNavBtn'',''BH_TabNavBtn_Tab'',''BH_UIButton'',''BH_Visit'',''BH_Voided_Reason'',''C_1099Box'',''C_AcctProcessor'',''C_AcctProcessorLog'',''C_AcctSchema'',''C_AcctSchema_Default'',''C_AcctSchema_Element'',''C_AcctSchema_GL'',''C_Activity'',''C_AddressTransaction'',''C_AddressValidation'',''C_AddressValidationCfg'',''C_AllocationHdr'',''C_AllocationLine'',''C_Bank'',''C_BankAccount'',''C_BankAccount_Acct'',''C_BankAccount_Processor'',''C_BankAccountDoc'',''C_BankStatement'',''C_BankStatementLine'',''C_BankStatementLoader'',''C_BankStatementMatcher'',''C_BankTransfer'',''C_BP_BankAccount'',''C_BP_Customer_Acct'',''C_BP_EDI'',''C_BP_Employee_Acct'',''C_BP_Group'',''C_BP_Group_Acct'',''C_BP_Relation'',''C_BP_ShippingAcct'',''C_BP_Vendor_Acct'',''C_BP_Withholding'',''C_BPartner'',''C_BPartner_Location'',''C_BPartner_Product'',''C_Calendar'',''C_Campaign'',''C_Cash'',''C_CashBook'',''C_CashBook_Acct'',''C_CashLine'',''C_CashPlan'',''C_CashPlanLine'',''C_Channel'',''C_Charge'',''C_Charge_Acct'',''C_ChargeType'',''C_ChargeType_DocType'',''C_City'',''C_Commission'',''C_CommissionAmt'',''C_CommissionDetail'',''C_CommissionLine'',''C_CommissionRun'',''C_ContactActivity'',''C_Conversion_Rate'',''C_ConversionType'',''C_Country'',''C_CountryGroup'',''C_CountryGroupCountry'',''C_Currency'',''C_Currency_Acct'',''C_Cycle'',''C_CyclePhase'',''C_CycleStep'',''C_DepositBatch'',''C_DepositBatchLine'',''C_DocType'',''C_DocTypeCounter'',''C_Dunning'',''C_DunningLevel'',''C_DunningRun'',''C_DunningRunEntry'',''C_DunningRunLine'',''C_Element'',''C_ElementValue'',''C_Greeting'',''C_InterOrg_Acct'',''C_Invoice'',''C_InvoiceBatch'',''C_InvoiceBatchLine'',''C_InvoiceLine'',''C_InvoicePaySchedule'',''C_InvoiceSchedule'',''C_InvoiceTax'',''C_Job'',''C_JobAssignment'',''C_JobCategory'',''C_JobRemuneration'',''C_LandedCost'',''C_LandedCostAllocation'',''C_Location'',''C_NonBusinessDay'',''C_OnlineTrxHistory'',''C_Opportunity'',''C_Order'',''C_OrderLandedCost'',''C_OrderLandedCostAllocation'',''C_OrderLine'',''C_OrderPaySchedule'',''C_OrderSource'',''C_OrderTax'',''C_OrgAssignment'',''C_Payment'',''C_PaymentAllocate'',''C_PaymentBatch'',''C_PaymentProcessor'',''C_PaymentTerm'',''C_PaymentTransaction'',''C_PaySchedule'',''C_PaySelection'',''C_PaySelectionCheck'',''C_PaySelectionLine'',''C_Period'',''C_PeriodControl'',''C_Phase'',''C_POS'',''C_POSKey'',''C_POSKeyLayout'',''C_POSPayment'',''C_POSTenderType'',''C_Project'',''C_Project_Acct'',''C_ProjectIssue'',''C_ProjectIssueMA'',''C_ProjectLine'',''C_ProjectPhase'',''C_ProjectTask'',''C_ProjectType'',''C_Recurring'',''C_Recurring_Run'',''C_RecurringGroup'',''C_Region'',''C_Remuneration'',''C_RevenueRecog_Service'',''C_RevenueRecognition'',''C_RevenueRecognition_Plan'',''C_RevenueRecognition_Run'',''C_RfQ'',''C_RfQ_Topic'',''C_RfQ_TopicSubscriber'',''C_RfQ_TopicSubscriberOnly'',''C_RfQLine'',''C_RfQLineQty'',''C_RfQResponse'',''C_RfQResponseLine'',''C_RfQResponseLineQty'',''C_SalesRegion'',''C_SalesStage'',''C_ServiceLevel'',''C_ServiceLevelLine'',''C_SubAcct'',''C_Subscription'',''C_Subscription_Delivery'',''C_SubscriptionType'',''C_Task'',''C_Tax'',''C_Tax_Acct'',''C_TaxBase'',''C_TaxCategory'',''C_TaxDeclaration'',''C_TaxDeclarationAcct'',''C_TaxDeclarationLine'',''C_TaxDefinition'',''C_TaxGroup'',''C_TaxPostal'',''C_TaxProvider'',''C_TaxProviderCfg'',''C_TaxType'',''C_UOM'',''C_UOM_Conversion'',''C_UserRemuneration'',''C_ValidCombination'',''C_Withholding'',''C_Withholding_Acct'',''C_Year'',''CM_Chat'',''CM_ChatEntry'',''CM_ChatType'',''CM_ChatTypeUpdate'',''CM_ChatUpdate'',''DD_NetworkDistribution'',''DD_NetworkDistributionLine'',''DD_Order'',''DD_OrderLine'',''EXP_Format'',''EXP_FormatLine'',''EXP_Processor'',''EXP_Processor_Type'',''EXP_ProcessorParameter'',''Fact_Acct'',''Fact_Acct_Summary'',''Fact_Reconciliation'',''GL_Budget'',''GL_BudgetControl'',''GL_Category'',''GL_Distribution'',''GL_DistributionLine'',''GL_Fund'',''GL_FundRestriction'',''GL_Journal'',''GL_JournalBatch'',''GL_JournalGenerator'',''GL_JournalGeneratorLine'',''GL_JournalGeneratorSource'',''GL_JournalLine'',''HR_Attribute'',''HR_Concept'',''HR_Concept_Acct'',''HR_Concept_Category'',''HR_Contract'',''HR_Department'',''HR_Employee'',''HR_Job'',''HR_List'',''HR_ListLine'',''HR_ListType'',''HR_ListVersion'',''HR_Movement'',''HR_Payroll'',''HR_PayrollConcept'',''HR_Period'',''HR_Process'',''HR_Year'',''I_Asset'',''I_BankStatement'',''I_BPartner'',''I_Conversion_Rate'',''I_ElementValue'',''I_FAJournal'',''I_FixedAsset'',''I_GLJournal'',''I_HR_Movement'',''I_InOutLineConfirm'',''I_Inventory'',''I_Invoice'',''I_Movement'',''I_Order'',''I_Payment'',''I_PriceList'',''I_Product'',''I_ProductPlanning'',''I_ReportLine'',''IMP_Processor'',''IMP_Processor_Type'',''IMP_ProcessorLog'',''IMP_ProcessorParameter'',''M_Attribute'',''M_AttributeInstance'',''M_AttributeSearch'',''M_AttributeSet'',''M_AttributeSetExclude'',''M_AttributeSetInstance'',''M_AttributeUse'',''M_AttributeValue'',''M_BOM'',''M_BOMAlternative'',''M_BOMProduct'',''M_BP_Price'',''M_ChangeNotice'',''M_ChangeRequest'',''M_CommodityShipment'',''M_Cost'',''M_CostDetail'',''M_CostElement'',''M_CostHistory'',''M_CostQueue'',''M_CostType'',''M_Demand'',''M_DemandDetail'',''M_DemandLine'',''M_DiscountSchema'',''M_DiscountSchemaBreak'',''M_DiscountSchemaLine'',''M_DistributionList'',''M_DistributionListLine'',''M_DistributionRun'',''M_DistributionRunLine'',''M_Forecast'',''M_ForecastLine'',''M_Freight'',''M_FreightCategory'',''M_InOut'',''M_InOutConfirm'',''M_InOutLine'',''M_InOutLineConfirm'',''M_InOutLineMA'',''M_Inventory'',''M_InventoryLine'',''M_InventoryLineMA'',''M_Locator'',''M_LocatorType'',''M_Lot'',''M_LotCtl'',''M_LotCtlExclude'',''M_MatchInv'',''M_MatchPO'',''M_Movement'',''M_MovementConfirm'',''M_MovementLine'',''M_MovementLineConfirm'',''M_MovementLineMA'',''M_OperationResource'',''M_Package'',''M_PackageLine'',''M_PackageMPS'',''M_PartType'',''M_PerpetualInv'',''M_PriceList'',''M_PriceList_Version'',''M_Product'',''M_Product_Acct'',''M_Product_Category'',''M_Product_Category_Acct'',''M_Product_PO'',''M_Product_QualityTest'',''M_ProductDownload'',''M_Production'',''M_ProductionLine'',''M_ProductionLineMA'',''M_ProductionPlan'',''M_ProductOperation'',''M_ProductPrice'',''M_ProductPriceVendorBreak'',''M_Promotion'',''M_PromotionDistribution'',''M_PromotionGroup'',''M_PromotionGroupLine'',''M_PromotionLine'',''M_PromotionPreCondition'',''M_PromotionReward'',''M_QualityTest'',''M_QualityTestResult'',''M_RelatedProduct'',''M_Replenish'',''M_Requisition'',''M_RequisitionLine'',''M_RMA'',''M_RMALine'',''M_RMATax'',''M_RMAType'',''M_SerNoCtl'',''M_SerNoCtlExclude'',''M_Shipper'',''M_ShipperCfg'',''M_ShipperLabels'',''M_ShipperLabelsCfg'',''M_ShipperPackaging'',''M_ShipperPackagingCfg'',''M_ShipperPickupTypes'',''M_ShipperPickupTypesCfg'',''M_ShippingProcessor'',''M_ShippingProcessorCfg'',''M_ShippingTransaction'',''M_ShippingTransactionLine'',''M_StorageOnHand'',''M_StorageReservation'',''M_Substitute'',''M_Transaction'',''M_TransactionAllocation'',''M_Warehouse'',''M_Warehouse_Acct'',''PA_Achievement'',''PA_Benchmark'',''PA_BenchmarkData'',''PA_ColorSchema'',''PA_DashboardContent'',''PA_DashboardContent_Access'',''PA_DashboardPreference'',''PA_DocumentStatus'',''PA_Goal'',''PA_GoalRestriction'',''PA_Hierarchy'',''PA_Measure'',''PA_MeasureCalc'',''PA_Ratio'',''PA_RatioElement'',''PA_Report'',''PA_ReportColumn'',''PA_ReportColumnSet'',''PA_ReportCube'',''PA_ReportLine'',''PA_ReportLineSet'',''PA_ReportSource'',''PA_SLA_Criteria'',''PA_SLA_Goal'',''PA_SLA_Measure'',''PP_Cost_Collector'',''PP_Cost_CollectorMA'',''PP_MRP'',''PP_Order'',''PP_Order_BOM'',''PP_Order_BOMLine'',''PP_Order_Cost'',''PP_Order_Node'',''PP_Order_Node_Asset'',''PP_Order_Node_Product'',''PP_Order_NodeNext'',''PP_Order_Workflow'',''PP_Product_BOM'',''PP_Product_BOMLine'',''PP_Product_Planning'',''PP_WF_Node_Asset'',''PP_WF_Node_Product'',''QM_Specification'',''QM_SpecificationLine'',''R_Category'',''R_CategoryUpdates'',''R_ContactInterest'',''R_Group'',''R_GroupUpdates'',''R_InterestArea'',''R_IssueKnown'',''R_IssueProject'',''R_IssueRecommendation'',''R_IssueStatus'',''R_IssueSystem'',''R_IssueUser'',''R_MailText'',''R_Request'',''R_RequestAction'',''R_RequestProcessor'',''R_RequestProcessor_Route'',''R_RequestProcessorLog'',''R_RequestType'',''R_RequestTypeUpdates'',''R_RequestUpdate'',''R_RequestUpdates'',''R_Resolution'',''R_StandardResponse'',''R_Status'',''R_StatusCategory'',''RV_BPartner'',''RV_WarehousePrice'',''S_ExpenseType'',''S_Resource'',''S_ResourceAssignment'',''S_ResourceType'',''S_ResourceUnAvailable'',''S_TimeExpense'',''S_TimeExpenseLine'',''S_TimeType'',''S_Training'',''S_Training_Class'',''T_1099Extract'',''T_Aging'',''T_BankRegister'',''T_BOM_Indented'',''T_BOMLine'',''T_CashFlow'',''T_DistributionRunDetail'',''T_InventoryValue'',''T_InvoiceGL'',''T_MRP_CRP'',''T_Reconciliation'',''T_Replenish'',''T_Report'',''T_ReportStatement'',''T_Transaction'',''Test'',''U_BlackListCheque'',''U_POSTerminal'',''U_RoleMenu'',''U_Web_Properties'',''U_WebMenu'',''WS_WebService'',''WS_WebService_Para'',''WS_WebServiceFieldInput'',''WS_WebServiceFieldOutput'',''WS_WebServiceMethod'',''WS_WebServiceType'',''WS_WebServiceTypeAccess'''
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03';

-- Make casing correct on this column for code-generation purposes
UPDATE ad_column
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';
UPDATE ad_element
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_element_uu = '17226899-35c3-41d9-8b3a-79a78f3c4dbb';

SELECT
	register_migration_script('202404041052_GO-2923.sql')
FROM
	dual;
