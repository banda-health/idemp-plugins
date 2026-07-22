-- GO-3624: persisted "current payroll period" on payroll settings, advanced when a run locks.
-- Elements BH_PayrollMonth / BH_PayrollYear already exist (created with BH_Payroll_Run) — reuse them.
ALTER TABLE BH_Payroll_Settings
	ADD COLUMN IF NOT EXISTS BH_PayrollMonth NUMERIC(2) DEFAULT NULL
		CHECK (BH_PayrollMonth IS NULL OR BH_PayrollMonth BETWEEN 1 AND 12);
ALTER TABLE BH_Payroll_Settings
	ADD COLUMN IF NOT EXISTS BH_PayrollYear NUMERIC(4) DEFAULT NULL;

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-19 10:00:00', '2026-07-19 10:00:00', 100, 100, 'Payroll Month', NULL, NULL, 1,
	 'U', 'BH_PayrollMonth', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, '1', '12', 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c69da128-20f5-4a6a-9adb-6c4b08f74663'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'df4ed975-97ed-46f7-af85-d76d7f3617ce', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

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
	((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-19 10:00:00', '2026-07-19 10:00:00', 100, 100, 'Payroll Year', NULL, NULL, 1,
	 'U', 'BH_PayrollYear', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1ad0e498-4a19-4234-8bf8-2ea2e8b29841'), 11, NULL, NULL, 22, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '17f1b02b-90b1-4597-b231-2e768d15c430'),
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '53891bf7-9746-49d3-80d2-112e92e287e8', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

SELECT update_sequences();

SELECT register_migration_script('202607191000_GO-3624.sql') FROM dual;
