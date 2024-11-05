-- Delete all mappings, extras, names, and descriptions since we're about to update them all
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IS NOT NULL;
TRUNCATE TABLE bh_concept_mapping CASCADE;
TRUNCATE TABLE bh_concept_name;
TRUNCATE TABLE bh_concept_description;
TRUNCATE TABLE bh_ocl_originating_source;

-- Add columns to the concept description
ALTER TABLE bh_concept_description
	ADD Ocl_Uuid VARCHAR(100);
ALTER TABLE bh_concept_description
	ADD BH_Concept_Locale_Preferred CHAR(1) DEFAULT 'N';
ALTER TABLE bh_concept_description
	ADD Description TEXT;

-- Add the appropriate columns to ad_column (the ad_elements already exist)
-- Ocl_Uuid
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
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2024-10-28 17:30:44.344564', '2024-10-28 17:30:44.344564', 100, 100, 'Ocl Uuid',
	 'A UUID from the OCL system', NULL, 0, 'U', 'Ocl_Uuid', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'a6e15096-3075-4194-944e-130fd85194fa'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '214c9fb5-bdda-4b3c-a5cc-11b73068702e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '61debec2-e565-4836-8249-302fc49b07e6', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
-- BH_Concept_Locale_Preferred
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
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2024-10-28 17:30:44.344564', '2024-10-28 17:30:44.344564', 100, 100, 'Locale Preferred', NULL, NULL,
	 0, 'U', 'BH_Concept_Locale_Preferred', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'a6e15096-3075-4194-944e-130fd85194fa'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3b776e02-a567-424f-9470-d9bb152c7919'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7f82cd87-4a15-4674-9cf7-b1255097c927', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
-- Description
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
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2024-10-28 17:30:44.344564', '2024-10-28 17:30:44.344564', 100, 100, 'Description',
	 'Description of the record', NULL, 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'a6e15096-3075-4194-944e-130fd85194fa'
	 ), 10, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 275, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '14b3dac6-f29f-416d-a172-41ee00599aad', 'Y', 10, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

SELECT
	register_migration_script('202410282320_GO-3042.sql')
FROM
	dual;
