-- Add the two new columns
ALTER TABLE BH_Visit
	ADD COLUMN Change_Reason TEXT DEFAULT NULL;
ALTER TABLE BH_Visit
	ADD COLUMN Scheduled CHAR(1) NOT NULL CHECK (Scheduled IN ('Y', 'N')) DEFAULT 'N';

-- Add the two new elements
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-01-29 10:23:12.200000', 100, '2025-01-29 10:23:12.200000', 100, 'Change_Reason', 'U',
	 'Change Reason', 'Change Reason', 'The reason for changing this entity', NULL, NULL, NULL, NULL, NULL,
	 'f39d8ee8-66de-4377-8c08-c5fbee923bfb', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-01-29 10:28:49.819000', 100, '2025-01-29 10:28:49.819000', 100, 'Scheduled', 'U', 'Scheduled',
	 'Scheduled', 'Whether the entity was scheduled or not', NULL, NULL, NULL, NULL, NULL,
	 '6758f4f5-5e4b-4f1e-922d-c2185842d966', NULL);

-- Add the two new column entries
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2025-01-29 10:23:44.769000', '2025-01-29 10:23:44.769000', 100, 100, 'Change Reason',
	 'The reason for changing this entity', NULL, 1, 'U', 'Change_Reason', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 14, NULL, NULL, NULL, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f39d8ee8-66de-4377-8c08-c5fbee923bfb'
	 ), NULL, 'N', 'Y', NULL, NULL, NULL, 'N', 'Y', NULL, 'b21f6db8-ff3c-4754-950e-d79ef0b9ab90', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2025-01-29 10:29:57.336000', '2025-01-29 10:29:57.336000', 100, 100, 'Scheduled',
	 'Whether the entity was scheduled or not', NULL, 0, 'U', 'Scheduled', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6758f4f5-5e4b-4f1e-922d-c2185842d966'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a8025cd3-cd96-4ec6-a902-c3e3247b0b5c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Register the script and be done
SELECT
	register_migration_script('202501291024_GO-2988.sql')
FROM
	dual;
