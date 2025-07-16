ALTER TABLE M_Movement
    ADD COLUMN BH_Voided_Reason_ID NUMERIC(10) DEFAULT NULL;
ALTER TABLE M_Movement
    ADD CONSTRAINT BHVoidedReason_MMovement FOREIGN KEY (BH_Voided_Reason_ID) REFERENCES bh_voided_reason (bh_voided_reason_id) DEFERRABLE INITIALLY DEFERRED;

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
VALUES ((select max(ad_column_id) + 1 from ad_column), 0, 0, 'Y', '2025-07-15 14:34:44.411000',
        '2025-07-15 14:40:33.431000', 100, 100, 'BH_Voided_Reason_ID',
        null, null, 0, 'U', 'BH_Voided_Reason_ID', 323, 19, null, null, 22, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N',
        'N', null, null, null, null, 'N',
        (select ad_element_id from ad_element where ad_element_uu = '9f1bb1b0-353c-4f5c-a034-e5faea969b35'), null, 'N',
        'N', null, null, null, 'N', 'Y', null,
        '6ceeb982-ad37-44a7-931b-9854c910d8d2', 'Y', 0, 'N', 'N', null, 'BHVoidedReason_MMovement', 'N', null, null,
        'N', null, null, null, null, null, 'N', null, null);

SELECT
	register_migration_script('202507151441_GO-3329.sql')
FROM
	dual;
