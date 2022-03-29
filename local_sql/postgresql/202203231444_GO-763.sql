ALTER TABLE c_bpartner ADD IF NOT EXISTS BH_IsApproximateDateOfBirth char default 'N'::bpchar not null;

ALTER TABLE c_bpartner DROP CONSTRAINT IF EXISTS c_bpartner_bh_isapproximatedateofbirth_check;

alter table c_bpartner
    add constraint c_bpartner_bh_isapproximatedateofbirth_check
        check (bh_isapproximatedateofbirth = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((select max(ad_element_id) + 1 from ad_element), 0, 0, 'Y', '2022-02-10 15:55:31.761000', 100, '2022-02-10 15:55:31.761000', 100, 'BH_IsApproximateDateOfBirth', 'U', 'Is Approximate Date Of Birth', 'Is Approximate Date Of Birth', null, null, null, null, null, null, '778c4fe6-3fe1-4e4e-bfdf-c5b19f56522c', null) ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((select max(ad_column_id) + 1 from ad_column), 0, 0, 'Y', '2022-03-04 22:15:36.871000', '2022-03-04 22:15:36.871000', 100, 100, 'Is Approximate Date Of Birth', null, null, 0, 'U', 'BH_IsApproximateDateOfBirth', 291, 20, null, null, 1, 'N', 'N', 'N', 'Y', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = '778c4fe6-3fe1-4e4e-bfdf-c5b19f56522c'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '72675ef6-a4f9-4a32-98d7-f7a8b98e3761', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202203231444_GO-763.sql') FROM dual;
