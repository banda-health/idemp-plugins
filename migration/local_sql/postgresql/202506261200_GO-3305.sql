INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
                                 updatedby, name, description, help, version, entitytype, columnname, ad_table_id,
                                 ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue,
                                 iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
                                 istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
                                 ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql,
                                 mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern,
                                 ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                                 fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                                 ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                                 partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((select max(ad_column_id) from ad_column) + 1, 0, 0, 'Y', '2025-06-26 11:55:35.021000', '2025-06-26 12:15:46.977000', 100, 100, 'Concept', null, null,
        0, 'U', 'BH_Concept_ID', 208, 19, null, null, 10, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null,
        null, null, 'N',  (select ad_element_id from ad_element where ad_element_uu = 'f5d356cd-fdb8-4fdd-aea5-2e11726c0141'), null, 'N', 'N', null, null, null, 'N', 'Y', null,
        '0ba4ea7d-7c06-4a84-8993-327565c22ca1', 'Y', 0, 'N', 'N', null, 'bhconcept_mproduct', 'N', null, null, 'N',
        null, null, null, null, null, 'N', null, null);
        
SELECT register_migration_script('202506261200_GO-3305.sql')
FROM dual;
