-- Insert the element for price margin
INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2020-06-26 12:37:04.236000', 100, '2020-06-26 12:37:04.236000', 100, 'BH_PriceMargin', 'U', 'Price Margin', 'Price Margin', null, null, null, null, null, null, 'c5165c87-987a-454c-b911-9beb5564eb77', null)
ON CONFLICT DO NOTHING;

-- Insert the column for price margin
INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2020-06-26 12:37:19.132000', '2020-06-26 12:37:19.132000', 100, 100, 'Price Margin', null, null, 0, 'U', 'BH_PriceMargin', 208, 12, null, null, 14, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c5165c87-987a-454c-b911-9beb5564eb77'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '5f4c2d28-a077-4f0a-81b6-87ff866d6ebd', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N')
ON CONFLICT DO NOTHING;

SELECT register_migration_script('202103111113_GO-1581.sql') FROM dual;