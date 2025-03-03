-- Add scheduled column to c_payment
ALTER TABLE C_Payment
	ADD COLUMN Scheduled CHAR(1) NOT NULL CHECK (Scheduled IN ('Y', 'N')) DEFAULT 'N';

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
	 ), 0, 0, 'Y', '2025-03-03 10:53:24.011000', '2025-03-03 10:53:24.011000', 100, 100, 'Scheduled',
	 'Whether the entity was scheduled or not', NULL, 0, 'U', 'Scheduled', 335, 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y',
	 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6758f4f5-5e4b-4f1e-922d-c2185842d966'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3fda572f-1766-47dc-8d50-1b79eceb74da', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Register the script and be done
SELECT
	register_migration_script('202503031052_GO-2986.sql')
FROM
	dual;
