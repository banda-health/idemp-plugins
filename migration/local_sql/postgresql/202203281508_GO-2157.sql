ALTER TABLE c_order RENAME bh_lab_notes TO BH_ClinicalNotes;

UPDATE ad_element SET columnname = 'BH_ClinicalNotes', name = 'Clinical Notes', printname = 'Clinical Notes' WHERE ad_element_uu = 'adea5e22-a52b-4da5-84fd-ea2489d50f3c';

UPDATE ad_column SET columnname = 'BH_ClinicalNotes', name = 'Clinical Notes' WHERE ad_column_uu = 'f404155a-d822-49be-b493-1b37ab680d44';

ALTER TABLE c_order ADD BH_LabNotes TEXT DEFAULT NULL;

INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((select max(ad_element_id) + 1 from ad_element), 0, 0, 'Y', '2022-02-10 15:55:31.761000', 100, '2022-02-10 15:55:31.761000', 100, 'BH_LabNotes', 'U', 'Lab Notes', 'Lab Notes', null, null, null, null, null, null, 'bf639c29-b21a-4db0-890e-eff72fabc076', null) ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((select max(ad_column_id) + 1 from ad_column), 0, 0, 'Y', '2022-03-04 22:15:36.871000', '2022-03-04 22:15:36.871000', 100, 100, 'Lab Notes', null, null, 0, 'U', 'BH_LabNotes', 291, 20, null, null, 1, 'N', 'N', 'N', 'Y', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = 'bf639c29-b21a-4db0-890e-eff72fabc076'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '2abb34f8-4224-4139-aae7-cac33a606be3', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202203281508_GO-2157.sql') FROM dual;