-- GO-3664: Queue prioritization - add BH_IsEmergency (manual, user-settable) and
-- BH_IsReturningFromLab (system-managed, set when a visit transitions tolab -> toclinician,
-- cleared when it transitions away from toclinician again) to BH_Visit.

-- 1. Add the new columns
ALTER TABLE bh_visit
	ADD COLUMN IF NOT EXISTS bh_isemergency CHAR(1) NOT NULL DEFAULT 'N' CHECK (bh_isemergency IN ('Y', 'N')),
	ADD COLUMN IF NOT EXISTS bh_isreturningfromlab CHAR(1) NOT NULL DEFAULT 'N' CHECK (bh_isreturningfromlab IN ('Y', 'N'));

-- 2. Application dictionary elements (Yes-No, reference_id = 20)
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder)
SELECT (SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', now(), 100, now(), 100, 'BH_IsEmergency', 'U', 'Emergency', 'Emergency', 'Whether this visit is flagged as an emergency and should jump the queue', NULL, NULL, NULL, NULL, NULL, '1e5b8e1d-b386-4439-a2bc-7669e9bd5cb1', NULL
WHERE NOT EXISTS (SELECT 1 FROM ad_element WHERE columnname = 'BH_IsEmergency' AND ad_client_id = 0);

INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder)
SELECT (SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', now(), 100, now(), 100, 'BH_IsReturningFromLab', 'U', 'Returning From Lab', 'Returning From Lab', 'Whether this visit just returned to the clinician from lab/imaging and should be prioritized; cleared on the next process stage change', NULL, NULL, NULL, NULL, NULL, 'e390235b-ef0f-4f00-a826-1b7ac369ae52', NULL
WHERE NOT EXISTS (SELECT 1 FROM ad_element WHERE columnname = 'BH_IsReturningFromLab' AND ad_client_id = 0);

-- 3. Application dictionary columns
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', now(), now(), 100, 100, 'Emergency', 'Whether this visit is flagged as an emergency and should jump the queue', NULL, 1, 'U', 'BH_IsEmergency', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE columnname = 'BH_IsEmergency' AND ad_client_id = 0 LIMIT 1), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b468f241-57b8-456f-af1c-b6e4abb530ba', 'Y', NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml, ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', now(), now(), 100, 100, 'Returning From Lab', 'Whether this visit just returned to the clinician from lab/imaging and should be prioritized', NULL, 1, 'U', 'BH_IsReturningFromLab', (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (SELECT ad_element_id FROM ad_element WHERE columnname = 'BH_IsReturningFromLab' AND ad_client_id = 0 LIMIT 1), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4e15f17c-294d-4243-b05a-afcac272d1ef', 'Y', NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL)
ON CONFLICT DO NOTHING;

-- Register the script
SELECT register_migration_script('202607121200_GO-3664.sql') FROM dual;
