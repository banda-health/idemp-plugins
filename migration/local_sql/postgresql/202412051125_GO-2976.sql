--- Alter table and add column
ALTER TABLE bh_encounter_diagnostic
	ADD COLUMN bh_diagnostic_note TEXT DEFAULT NULL;

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(AD_Element_ID) + 1
		 FROM
			 AD_Element
	 ), 0, 0, 'Y', '2024-09-30 12:25:37.915', 100, '2024-09-30 12:25:37.915', 100, 'BH_Diagnostic_Note', 'U', 'Notes',
	 'Notes', 'Notes about the results', NULL, NULL, NULL, NULL, NULL, '64bfe9d3-5c98-4b89-b8bb-beefe2034de2', NULL);

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-09-30 12:27:59.771', '2024-09-30 12:27:59.771', 100, 100, 'Notes', 'Notes about the results',
	 NULL, 0, 'U', 'BH_Diagnostic_Note', (
		 SELECT
			 AD_Table_ID
		 FROM
			 AD_Table
		 WHERE
			 AD_Table_UU = 'b53c83d8-1eb6-4741-b98e-2a21f3341a37'
	 ), 36, NULL, NULL, 3000, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT
			 AD_Element_ID
		 FROM
			 AD_Element
		 WHERE
			 AD_Element_UU = '64bfe9d3-5c98-4b89-b8bb-beefe2034de2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e6292f22-ea42-4eb5-a3e3-c2e6b0801baa', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL);

SELECT
	register_migration_script('202412051125_GO-2976.sql')
FROM
	dual;
