CREATE TABLE BH_Tag
(
    AD_Client_ID  NUMERIC(10) NOT NULL,
    AD_Org_ID     NUMERIC(10) NOT NULL,
    BH_ColourCode VARCHAR(10)                                         DEFAULT NULL,
    BH_Tag_ID    NUMERIC(10) NOT NULL,
    BH_Tag_UU    VARCHAR(36)                                         DEFAULT NULL,
    Created       TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    CreatedBy     NUMERIC(10) NOT NULL,
    Description   VARCHAR(255)                                        DEFAULT NULL,
    IsActive      CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
    Name          VARCHAR(60) NOT NULL,
    Updated       TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    UpdatedBy     NUMERIC(10) NOT NULL,
    CONSTRAINT BH_Tag_Key PRIMARY KEY (BH_Tag_ID),
    CONSTRAINT BH_Tag_UU_idx UNIQUE (BH_Tag_UU)
);
ALTER TABLE BH_Tag
    ADD CONSTRAINT ADClient_BHTag FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Tag
    ADD CONSTRAINT ADOrg_BHTag FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE BH_BPartner_Tags
(
    AD_Client_ID        NUMERIC(10) NOT NULL,
    AD_Org_ID           NUMERIC(10) NOT NULL                                DEFAULT 0,
    BH_BPartner_Tags_UU VARCHAR(36)                                         DEFAULT NULL,
    BH_Tag_ID          NUMERIC(10) NOT NULL,
    C_BPartner_ID       NUMERIC(10) NOT NULL,
    Created             TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    CreatedBy           NUMERIC(10) NOT NULL,
    IsActive            CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
    Updated             TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    UpdatedBy           NUMERIC(10) NOT NULL,
    CONSTRAINT BH_BPartner_Tags_UU_idx UNIQUE (BH_BPartner_Tags_UU)
);
ALTER TABLE BH_BPartner_Tags
    ADD CONSTRAINT ADClient_BHBPartnerTags FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BPartner_Tags
    ADD CONSTRAINT ADOrg_BHBPartnerTags FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BPartner_Tags
    ADD CONSTRAINT BHTag_BHBPartnerTags FOREIGN KEY (BH_Tag_ID) REFERENCES bh_Tag (bh_Tag_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BPartner_Tags
    ADD CONSTRAINT CBPartner_BHBPartnerTags FOREIGN KEY (C_BPartner_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;
alter table BH_BPartner_Tags
    add primary key (BH_Tag_ID, C_BPartner_ID);


INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                      description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id,
                      loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype,
                      po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing,
                      databaseviewdrop, copycomponentsfromview, createwindowfromtable, isshowindrilloptions,
                      ispartition, createpartition)
VALUES ((SELECT MAX(ad_table_id + 1) FROM ad_table), 0, 0, 'Y', '2025-05-06 13:01:25.110000', 100,
        '2025-05-06 13:01:25.110000', 100, 'BPartner_Tags', null,
        null, 'BH_BPartner_Tags', 'N', '4', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y',
        'efe5be1e-bc23-4e21-9807-81e67b3be56a', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                      description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id,
                      loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype,
                      po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing,
                      databaseviewdrop, copycomponentsfromview, createwindowfromtable, isshowindrilloptions,
                      ispartition, createpartition)
VALUES ((SELECT MAX(ad_table_id + 1) FROM ad_table), 0, 0, 'Y', '2025-05-06 11:14:59.920000', 100,
        '2025-05-06 11:14:59.920000', 100, 'BH Tag', null, null,
        'BH_Tag', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y',
        '5d7cd657-7ae6-4005-80e4-1d1a1dca5233', 'N', 'N', 'N', 'N', 'N', 'N', 'N');


INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:12:44.021000', 100,
        '2025-05-06 13:12:44.021000', 100, 'BH_Tag_UU', 'U',
        'BH_Tag_UU', 'BH_Tag_UU', null, null, null, null, null, null, 'd814e5b4-ec8c-4463-b956-1e493fd39835', null);
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:12:43.993000', 100,
        '2025-05-06 13:12:43.993000', 100, 'BH_Tag_ID', 'U',
        'BH Tag', 'BH Tag', null, null, null, null, null, null, '8b6100d1-055a-44ed-bf81-07b4eafb2660', null);
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:01:42.641000', 100,
        '2025-05-06 13:01:42.641000', 100, 'BH_BPartner_Tags_UU',
        'U', 'BH_BPartner_Tags_UU', 'BH_BPartner_Tags_UU', null, null, null, null, null, null,
        '56868f03-181d-49b7-9128-97dd6d638f1d', null);
--- Update columns
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.432000',
        '2025-05-06 15:46:56.432000', 100, 100, 'Updated By', 'User who updated this records',
        'The Updated By field indicates the user who updated this record.', 1, 'U', 'UpdatedBy',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 30, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 608, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '5c1cc9a9-ed62-4df5-b77b-24c28f13a4ab', 'N', null, 'N', 'N', null, null, 'D', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.405000',
        '2025-05-06 15:46:56.405000', 100, 100, 'Updated', 'Date this record was updated',
        'The Updated field indicates the date that this record was updated.', 1, 'U', 'Updated',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 607, null, 'N', 'N',
        null, null, null, 'N', 'Y', null, '3bb2997b-8a67-4656-a2e0-1bb5cec932ad', 'N', null, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.369000',
        '2025-05-06 15:46:56.369000', 100, 100, 'Active', 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
        1, 'U', 'IsActive',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 20, null, null,
        1, 'Y', 'N', 'N', 'Y', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 348, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '227de5ed-08d5-42b7-9b9c-feade3131990', 'N', null, 'N', 'N', null, null, 'N', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.333000',
        '2025-05-06 15:46:56.333000', 100, 100, 'Created By', 'User who created this records',
        'The Created By field indicates the user who created this record.', 1, 'U', 'CreatedBy',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 30, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 246, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, 'bdd49b72-7063-4359-9e44-8db8eb860357', 'N', null, 'N', 'N', null, null, 'D', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.312000',
        '2025-05-06 15:46:56.312000', 100, 100, 'Created', 'Date this record was created',
        'The Created field indicates the date that this record was created.', 1, 'U', 'Created',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 245, null, 'N', 'N',
        null, null, null, 'N', 'Y', null, 'e4aa4768-bc13-43da-b117-5f36c1d5fc10', 'N', null, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.288000',
        '2025-05-06 15:46:56.288000', 100, 100, 'BH_BPartner_Tags_UU', null, null, 1, 'U', 'BH_BPartner_Tags_UU',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 200231, null,
        null, 36, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '56868f03-181d-49b7-9128-97dd6d638f1d')
           , null, 'N',
        'N', null, null, null, 'N', 'Y', null, 'e41c363b-5047-40ef-8784-1fbb14845e7d', 'N', null, 'N', 'N', null, null,
        'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.266000',
        '2025-05-06 15:56:23.130000', 100, 100, 'BH Tag', null, null, 1, 'U', 'BH_Tag_ID',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 30, null, null,
        22, null, 'N', 'Y', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8b6100d1-055a-44ed-bf81-07b4eafb2660'), null, 'N',
        'N',
        null, null, null, 'N', 'Y', null, 'a04e8bb3-6c40-4a18-8f2f-5d652b09d8bd', 'Y', null, 'N', 'N', null,
        'BHTag_BHBPartnerTags', 'C', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.242000',
        '2025-05-06 15:56:23.147000', 100, 100, 'Business Partner', 'Identifies a Business Partner',
        'A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson',
        1, 'U', 'C_BPartner_ID',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 30, null, null,
        22, null, 'N', 'Y', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 187, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '90960ec6-5ca4-4cca-b238-01193a7f2309', 'Y', null, 'N', 'N', null,
        'CBPartner_BHBPartnerTags', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.213000',
        '2025-05-06 15:56:23.112000', 100, 100, 'Organization', 'Organizational entity within tenant',
        'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
        1, 'U', 'AD_Org_ID',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 19, null, 104,
        22, '0', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 113, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '2bf462ab-cc92-44df-8f2f-1b48031b8f17', 'N', null, 'N', 'N', null,
        'ADOrg_BHBPartnerTags', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 15:46:56.186000',
        '2025-05-06 15:56:23.093000', 100, 100, 'Tenant', 'Tenant for this installation.',
        'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 1, 'U', 'AD_Client_ID',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 19, null, 129,
        22, '@AD_Client_ID@', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 102, null,
        'N', 'N', null, null, null, 'N', 'Y', null, '1ceda655-ff0c-4487-bf31-53e777acde18', 'N', null, 'N', 'N', null,
        'ADClient_BHBPartnerTags', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 14:32:59.037000',
        '2025-05-06 14:32:59.037000', 100, 100, 'ColourCode', null, null, 0, 'U', 'BH_ColourCode',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 10, null, null,
        10, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2e4818a7-e7f9-4f23-a4dc-4d236a448d7d'), null, 'N',
        'N',
        null, null, null, 'N', 'Y', null, '044cae97-26e1-4a5d-86a7-9defce40bb7d', 'Y', 0, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.153000',
        '2025-05-06 13:12:44.153000', 100, 100, 'Updated By', 'User who updated this records',
        'The Updated By field indicates the user who updated this record.', 1, 'U', 'UpdatedBy',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 30, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 608, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '7f57ee6f-0da1-4dcf-bbe0-0349d876c25d', 'N', null, 'N', 'N', null, null, 'D', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.133000',
        '2025-05-06 13:12:44.133000', 100, 100, 'Updated', 'Date this record was updated',
        'The Updated field indicates the date that this record was updated.', 1, 'U', 'Updated',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 607, null, 'N', 'N',
        null, null, null, 'N', 'Y', null, '580096db-08e3-4540-bd4b-197bd1a2990c', 'N', null, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.113000',
        '2025-05-06 13:12:44.113000', 100, 100, 'Name', 'Alphanumeric identifier of the entity',
        'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
        1, 'U', 'Name', (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'),
        10, null, null, 60, null, 'N', 'N', 'Y', 'Y', null, 'Y', 1, 'N', 'N', null, null, null, null, 'Y', 469, null,
        'N', 'N', null, null, null, 'N', 'Y', null, 'adaecb3f-9562-4df8-b27a-75f11d508118', 'Y', 20, 'N', 'N', null,
        null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.093000',
        '2025-05-06 13:12:44.093000', 100, 100, 'Active', 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
        1, 'U', 'IsActive',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 20, null, null,
        1, 'Y', 'N', 'N', 'Y', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 348, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '77607cbc-03e2-4b6f-8bab-4f0db4f21dfa', 'N', null, 'N', 'N', null, null, 'N', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.072000',
        '2025-05-06 13:12:44.072000', 100, 100, 'Description', 'Optional short description of the record',
        'A description is limited to 255 characters.', 1, 'U', 'Description',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 10, null, null,
        255, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'Y', 275, null, 'N', 'N',
        null, null, null, 'N', 'Y', null, 'e3ebaf30-3ed1-4a25-bcfe-db84c9a6202e', 'Y', 10, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.052000',
        '2025-05-06 13:12:44.052000', 100, 100, 'Created By', 'User who created this records',
        'The Created By field indicates the user who created this record.', 1, 'U', 'CreatedBy',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 30, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 246, null, 'N', 'N', null,
        null, null, 'N', 'Y', null, '8265f079-eb4a-4bec-a8ea-e854d9cbb2d5', 'N', null, 'N', 'N', null, null, 'D', null,
        null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.032000',
        '2025-05-06 13:12:44.032000', 100, 100, 'Created', 'Date this record was created',
        'The Created field indicates the date that this record was created.', 1, 'U', 'Created',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 245, null, 'N', 'N',
        null, null, null, 'N', 'Y', null, 'ca2a03a6-600d-443a-8fb2-6406dc38e820', 'N', null, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:44.005000',
        '2025-05-06 13:12:44.005000', 100, 100, 'BH_Tag_UU', null, null, 1, 'U', 'BH_Tag_UU',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 200231, null,
        null, 36, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd814e5b4-ec8c-4463-b956-1e493fd39835'), null, 'N',
        'N', null, null, null, 'N', 'Y', null, '189692cb-2237-4e42-84a4-7c82e1d80ebc', 'N', null, 'N', 'N', null, null,
        'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:43.977000',
        '2025-05-06 13:54:10.253000', 100, 100, 'BH Tag ID', null, null, 1, 'U', 'BH_Tag_ID',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 13, null, null,
        22, null, 'Y', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8b6100d1-055a-44ed-bf81-07b4eafb2660'), null, 'N',
        'N',
        null, null, null, 'N', 'Y', null, 'a4e47fdb-2035-414e-923f-091074b2c985', 'N', null, 'N', 'N', null, null, 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:43.956000',
        '2025-05-06 14:25:16.741000', 100, 100, 'Organization', 'Organizational entity within tenant',
        'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
        1, 'U', 'AD_Org_ID',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 19, null, 104,
        22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 113, null, 'N',
        'N', null, null, null, 'N', 'Y', null, 'd43bdd38-c0aa-46db-bb63-54e48b2452b0', 'N', null, 'N', 'N', null,
        'ADOrg_BHTag', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
                       ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
                       partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES ((SELECT MAX(ad_column_id + 1) FROM ad_column), 0, 0, 'Y', '2025-05-06 13:12:43.934000',
        '2025-05-06 13:13:29.073000', 100, 100, 'Tenant', 'Tenant for this installation.',
        'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 1, 'U', 'AD_Client_ID',
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'), 19, null, 129,
        22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N', 102, null,
        'N', 'N', null, null, null, 'N', 'Y', null, '268b3c10-acbd-4214-b5d8-e326711a32fa', 'N', null, 'N', 'N', null,
        'ADClient_BHTag', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);

INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                         name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys,
                         isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu,
                         startnewmonth, isorglevelsequence, orgcolumn)
VALUES ((SELECT MAX(ad_sequence_id + 1) FROM ad_sequence), 0, 0, 'Y', '2025-05-06 10:04:45.237000', 100,
        '2025-05-06 10:04:45.237000', 100, 'BH_Tag',
        'Table BH_Tag', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null,
        'd854df76-426b-46d7-8f95-d99e0712b09d', 'N', 'N', null);

INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                       description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id,
                       isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic,
                       predefinedcontextvariables)
VALUES ((SELECT MAX(ad_window_id + 1) FROM ad_window), 0, 0, 'Y', '2025-05-06 16:30:47.131000', 100,
        '2025-05-06 16:30:47.131000', 100, 'Patient Tag', null,
        null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '3c865615-4f7e-4b19-a64b-740485d99e83', null, null);

-- Give clinic admins the ability to edit
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_role r
		JOIN ad_window w
		ON w.ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
WHERE
	r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685');

-- Everyone else can see
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'N',
	uuid_generate_v4(),
	'N'
FROM
	ad_role r
		JOIN ad_window w
		ON w.ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
WHERE
	r.ad_role_uu IN ('e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
	                 '09eb7fc8-9cc5-44b0-9d14-15258a066038', '98617c31-55ff-48f9-bd44-253ef323d960',
	                 'ee008abc-2c16-4230-b48c-b1f5577ea270', 'c54253cf-c86b-4aaa-b472-ed8880635c62',
	                 'a1618fd6-e1ab-4e41-a08d-854229cd5971', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a',
	                 '097feff0-3aa6-41fe-bf76-936b03859846', '17ccea57-1131-4d51-83ca-1824182e4493');

INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                              updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT w.ad_window_id,
       r.ad_role_id,
       r.ad_client_id,
       r.ad_org_id,
       'Y',
       now(),
       100,
       now(),
       100,
       'Y',
       uuid_generate_v4(),
       'Y'
FROM ad_role r
         CROSS JOIN ad_window w
WHERE r.ismanual = 'N'
  AND w.ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83';


INSERT INTO ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                    name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow,
                    isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause,
                    orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields,
                    ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id,
                    readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu,
                    ad_ctxhelp_id, treedisplayedon, maxqueryrecords, islookuponlyselection,
                    isallowadvancedlookup, ad_tabtype, ishighvolume, deleteconfirmationlogic)
VALUES ((SELECT MAX(ad_tab_id + 1) FROM ad_tab), 0, 0, 'Y', '2025-05-06 16:33:50.998000', 100,
        '2025-05-06 16:33:50.998000', 100, 'Patient Tag',
        'Tab for managing patient tags', null,
        (select ad_table_id from ad_table where ad_table_uu = '5d7cd657-7ae6-4005-80e4-1d1a1dca5233'),
        (select ad_window_id from ad_window where ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'), 10, 0, 'Y',
        'N', 'N', 'N', null, 'N', null, null, null,
        null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null,
        '16bf3806-0290-4152-b34a-f7a51643b00f', null, 'B', 0, 'N', 'Y', null, null, null);

INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.144000', 100,
        '2025-05-06 16:52:49.144000', 100, 'Active',
        'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
        'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = '77607cbc-03e2-4b6f-8bab-4f0db4f21dfa'), null,
        'Y', null, 1, 'N', 60, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null, null,
        null, null, null, '897fdede-5c32-4fef-807c-8b40a7d05a0e', null, 50, 'Y', 2, 1, 2, 'N', null, null, null, null,
        null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.138000', 100,
        '2025-05-06 16:52:49.138000', 100, 'ColourCode', null,
        null, 'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = '044cae97-26e1-4a5d-86a7-9defce40bb7d'),
        null, 'Y', null, 10, 'N', 50, null, 'N', 'N', 'N', 'N', 'U', null, null, null,
        null, null, null, null, null, '2533b99a-5b0b-4205-8d86-568c682b0bb9', null, 40, 'Y', 1, 1, 2, 'N', null, null,
        null, null, null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.131000', 100,
        '2025-05-06 16:52:49.131000', 100, 'BH_Tag_UU', null,
        null, 'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = '189692cb-2237-4e42-84a4-7c82e1d80ebc'),
        null, 'N', null, 36, 'N', null, null, 'N', 'N', 'N', 'N', 'U', null, null, null,
        null, null, null, null, null, '0bfc2407-f2de-4e07-b798-82313868e163', null, null, 'N', 1, 1, 2, 'N', null, null,
        null, null, null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.124000', 100,
        '2025-05-06 16:52:49.124000', 100, 'BH Tag', null, null,
        'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = 'a4e47fdb-2035-414e-923f-091074b2c985'), null,
        'N', null, 22, 'N', null, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null,
        null, null, null, null, 'b54ba776-b7f9-40c0-8cd7-f1beb8c974be', null, null, 'N', 1, 1, 2, 'N', null, null, null,
        null, null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.118000', 100,
        '2025-05-06 16:52:49.118000', 100, 'Description',
        'Optional short description of the record', 'A description is limited to 255 characters.', 'Y',
        (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = 'e3ebaf30-3ed1-4a25-bcfe-db84c9a6202e'), null, 'Y',
        null, 255, 'N', 40, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null, null, null, null,
        null, 'aca2a0d4-9b5d-404d-a48f-d5df5d959302', null, 30, 'Y', 1, 1, 5, 'N', null, null, null, null, null, 'N',
        'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.107000', 100,
        '2025-05-06 16:52:49.107000', 100, 'Name',
        'Alphanumeric identifier of the entity',
        'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
        'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = 'adaecb3f-9562-4df8-b27a-75f11d508118'), null,
        'Y', null, 60, 'N', 30, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null,
        null, null, null, null, '56260411-7419-453a-b365-ceed1ac1e709', null, 20, 'Y', 1, 1, 5, 'N', null, null, null,
        null, null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.098000', 100,
        '2025-05-06 16:52:49.098000', 100, 'Organization',
        'Organizational entity within tenant',
        'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
        'Y', (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = 'd43bdd38-c0aa-46db-bb63-54e48b2452b0'), null,
        'Y', null, 22, 'N', 20, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null,
        null, null, null, null, 'ab4136dc-8c60-4b43-8d03-1867517e4a9e', 'Y', 10, 'Y', 4, 1, 2, 'N', null, null, null,
        null, null, 'N', 'N', null, null, null, null, 'N', null, null, null, null, null, null, null);
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid,
                      xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable,
                      mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus,
                      vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform, bh_abbreviation,
                      isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
                      ishtml)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2025-05-06 16:52:49.076000', 100,
        '2025-05-06 16:52:49.076000', 100, 'Tenant',
        'Tenant for this installation.',
        'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 'Y',
        (select ad_tab_id from ad_tab where ad_tab_uu = '16bf3806-0290-4152-b34a-f7a51643b00f'),
        (select ad_column_id from ad_column where ad_column_uu = '268b3c10-acbd-4214-b5d8-e326711a32fa'), null,
        'Y', null, 22, 'N', 10, null, 'N', 'N', 'N', 'N', 'U', null, null, null, null, null, null, null, null,
        'a87b4761-9422-4687-8b0d-126181bfa31e', null, null, 'N', 1, 1, 2, 'N', null, null, null, null, null, 'N', 'N',
        null, null, null, null, 'N', null, null, null, null, null, null, null);

INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
	         updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
	         ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
	         iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_menu_id + 1)
		 FROM ad_menu
	 ), 0, 0, 'Y', '2025-05-06 16:54:10.336000', 100,
	 '2025-05-06 16:54:10.336000', 'Patient Tag', 100,
	 'Tags for Patients', 'N', 'Y', 'N', NULL, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y',
	 '1a45dfaf-5d97-4246-a3c0-1965f91e22b1', NULL, NULL, NULL);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                           updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '1a45dfaf-5d97-4246-a3c0-1965f91e22b1'), 0, 0, 'Y',
        '2025-05-06 16:54:10.371161', 100, '2025-05-06 16:57:50.340000', 100,
        (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 6,
        'ff96739c-44a6-41d8-b1aa-fdf0886440bb');

--- Update table name
UPDATE bh_graphqlgeneratortemplate
SET tablename = '''A_Asset'',''A_Asset_Acct'',''A_Asset_Addition'',''A_Asset_Change'',''A_Asset_Class'',''A_Asset_Delivery'',''A_Asset_Disposed'',''A_Asset_Group'',''A_Asset_Group_Acct'',''A_Asset_Info_Fin'',''A_Asset_Info_Ins'',''A_Asset_Info_Lic'',''A_Asset_Info_Oth'',''A_Asset_Info_Tax'',''A_Asset_Product'',''A_Asset_Retirement'',''A_Asset_Reval'',''A_Asset_Reval_Entry'',''A_Asset_Reval_Index'',''A_Asset_Split'',''A_Asset_Transfer'',''A_Asset_Type'',''A_Asset_Use'',''A_Depreciation'',''A_Depreciation_Build'',''A_Depreciation_Convention'',''A_Depreciation_Entry'',''A_Depreciation_Exp'',''A_Depreciation_Forecast'',''A_Depreciation_Method'',''A_Depreciation_Table_Detail'',''A_Depreciation_Table_Header'',''A_Depreciation_Workfile'',''A_FundingMode'',''A_FundingMode_Acct'',''A_Registration'',''A_RegistrationAttribute'',''A_RegistrationProduct'',''A_RegistrationValue'',''AD_AccessLog'',''AD_Alert'',''AD_AlertProcessor'',''AD_AlertProcessorLog'',''AD_AlertRecipient'',''AD_AlertRule'',''AD_AllClients_V'',''AD_AllUsers_V'',''AD_Archive'',''AD_Attachment'',''AD_AttachmentNote'',''AD_Attribute'',''AD_Attribute_Value'',''AD_AuthorizationAccount'',''AD_AuthorizationCredential'',''AD_AuthorizationProvider'',''AD_BroadcastMessage'',''AD_ChangeLog'',''AD_Chart'',''AD_ChartDatasource'',''AD_Client'',''AD_ClientInfo'',''AD_ClientShare'',''AD_Color'',''AD_Column'',''AD_Column_Access'',''AD_CtxHelp'',''AD_CtxHelpMsg'',''AD_CtxHelpSuggestion'',''AD_Desktop'',''AD_DesktopWorkbench'',''AD_Document_Action_Access'',''AD_Element'',''AD_EntityType'',''AD_Error'',''AD_Field'',''AD_FieldGroup'',''AD_FieldSuggestion'',''AD_Find'',''AD_Form'',''AD_Form_Access'',''AD_HouseKeeping'',''AD_Image'',''AD_ImpFormat'',''AD_ImpFormat_Row'',''AD_ImportTemplate'',''AD_ImportTemplateAccess'',''AD_IndexColumn'',''AD_InfoColumn'',''AD_InfoProcess'',''AD_InfoRelated'',''AD_InfoWindow'',''AD_InfoWindow_Access'',''AD_Issue'',''AD_LabelPrinter'',''AD_LabelPrinterFunction'',''AD_Language'',''AD_LdapAccess'',''AD_LdapProcessor'',''AD_LdapProcessorLog'',''AD_Menu'',''AD_Message'',''AD_MigrationScript'',''AD_ModelValidator'',''AD_Modification'',''AD_Note'',''AD_Org'',''AD_OrgInfo'',''AD_OrgType'',''AD_Package_Exp'',''AD_Package_Exp_Detail'',''AD_Package_Imp'',''AD_Package_Imp_Backup'',''AD_Package_Imp_Detail'',''AD_Package_Imp_Inst'',''AD_Package_Imp_Proc'',''AD_Package_UUID_Map'',''AD_Password_History'',''AD_PasswordRule'',''AD_PInstance'',''AD_PInstance_Log'',''AD_PInstance_Para'',''AD_PostIt'',''AD_Preference'',''AD_PrintColor'',''AD_PrintFont'',''AD_PrintForm'',''AD_PrintFormat'',''AD_PrintFormatItem'',''AD_PrintGraph'',''AD_PrintHeaderFooter'',''AD_PrintLabel'',''AD_PrintLabelLine'',''AD_PrintPaper'',''AD_PrintTableFormat'',''AD_Private_Access'',''AD_Process'',''AD_Process_Access'',''AD_Process_Para'',''AD_RecentItem'',''AD_Record_Access'',''AD_Ref_List'',''AD_Ref_Table'',''AD_Reference'',''AD_Registration'',''AD_RelationType'',''AD_Replication'',''AD_Replication_Log'',''AD_Replication_Run'',''AD_ReplicationDocument'',''AD_ReplicationStrategy'',''AD_ReplicationTable'',''AD_ReportView'',''AD_ReportView_Col'',''AD_ReportView_Column'',''AD_Role'',''AD_Role_Included'',''AD_Role_OrgAccess'',''AD_Rule'',''AD_Schedule'',''AD_Scheduler'',''AD_Scheduler_Para'',''AD_SchedulerLog'',''AD_SchedulerRecipient'',''AD_SearchDefinition'',''AD_Sequence'',''AD_Sequence_Audit'',''AD_Sequence_No'',''AD_Session'',''AD_StatusLine'',''AD_StatusLineUsedIn'',''AD_StorageProvider'',''AD_Style'',''AD_StyleLine'',''AD_SysConfig'',''AD_System'',''AD_Tab'',''AD_Tab_Customization'',''AD_Table'',''AD_Table_Access'',''AD_Table_ScriptValidator'',''AD_TableIndex'',''AD_Task'',''AD_Task_Access'',''AD_TaskInstance'',''AD_ToolBarButton'',''AD_ToolBarButtonRestrict'',''AD_Tree'',''AD_Tree_Favorite'',''AD_Tree_Favorite_Node'',''AD_TreeBar'',''AD_TreeNode'',''AD_TreeNodeBP'',''AD_TreeNodeCMC'',''AD_TreeNodeCMM'',''AD_TreeNodeCMS'',''AD_TreeNodeCMT'',''AD_TreeNodeMM'',''AD_TreeNodePR'',''AD_TreeNodeU1'',''AD_TreeNodeU2'',''AD_TreeNodeU3'',''AD_TreeNodeU4'',''AD_User'',''AD_User_OrgAccess'',''AD_User_Roles'',''AD_User_Substitute'',''AD_UserBPAccess'',''AD_UserDef_Field'',''AD_UserDef_Info'',''AD_UserDef_Info_Column'',''AD_UserDef_Info_Related'',''AD_UserDef_Proc'',''AD_UserDef_Proc_Parameter'',''AD_UserDef_Tab'',''AD_UserDef_Win'',''AD_UserMail'',''AD_UserPreference'',''AD_UserQuery'',''AD_Val_Rule'',''AD_ViewColumn'',''AD_ViewComponent'',''AD_WF_Activity'',''AD_WF_ActivityApprover'',''AD_WF_ActivityResult'',''AD_WF_Block'',''AD_WF_EventAudit'',''AD_WF_NextCondition'',''AD_WF_Node'',''AD_WF_Node_Para'',''AD_WF_NodeNext'',''AD_WF_Process'',''AD_WF_ProcessData'',''AD_WF_Responsible'',''AD_Window'',''AD_Window_Access'',''AD_WizardProcess'',''AD_Workbench'',''AD_WorkbenchWindow'',''AD_Workflow'',''AD_Workflow_Access'',''AD_WorkflowProcessor'',''AD_WorkflowProcessorLog'',''AD_ZoomCondition'',''ASP_ClientException'',''ASP_ClientLevel'',''ASP_Field'',''ASP_Form'',''ASP_Level'',''ASP_Module'',''ASP_Process'',''ASP_Process_Para'',''ASP_Ref_List'',''ASP_Tab'',''ASP_Task'',''ASP_Window'',''ASP_Workflow'',''B_Bid'',''B_BidComment'',''B_Buyer'',''B_BuyerFunds'',''B_Offer'',''B_Seller'',''B_SellerFunds'',''B_Topic'',''B_TopicCategory'',''B_TopicType'',''BH_Allergy'',''BH_Allergy_Reaction'',''BH_BP_General_Payer_Info'',''BH_BP_Payer_Info'',''BH_BP_Specific_Payer_Info'',''BH_BPartner_Tags'',''BH_ChargeDefault'',''BH_ChargeTypeDefault'',''BH_Client_Concept'',''BH_Client_Concept_Extra'',''BH_Concept'',''BH_Concept_Description'',''BH_Concept_Extra'',''BH_Concept_Mapping'',''BH_Concept_Name'',''BH_DbrdBtnGrp'',''BH_DbrdBtnGrp_Btn'',''BH_Default_DocAction_Access'',''BH_DefaultIncludedRole'',''BH_Encounter'',''BH_Encounter_Diagnosis'',''BH_Encounter_Diagnostic'',''BH_Encounter_Type_Window'',''BH_I_Product_Quantity'',''BH_Observation'',''BH_Ocl_Originating_Source'',''BH_Payer_Info_Fld'',''BH_Payer_Info_Fld_Sug'',''BH_Payer_Info_Fld_Val'',''BH_Payer_Info_Fld_Val_Sug'',''BH_PaymentRef'',''BH_PaymentRef_BankAcct'',''BH_Product_CategoryDefault'',''BH_Role_WarehouseAccess'',''BH_Stocktake_v'',''BH_TabNavBtn'',''BH_TabNavBtn_Tab'',''BH_Tag'',''BH_UIButton'',''BH_Visit'',''BH_Voided_Reason'',''C_1099Box'',''C_AcctProcessor'',''C_AcctProcessorLog'',''C_AcctSchema'',''C_AcctSchema_Default'',''C_AcctSchema_Element'',''C_AcctSchema_GL'',''C_Activity'',''C_AddressTransaction'',''C_AddressValidation'',''C_AddressValidationCfg'',''C_AllocationHdr'',''C_AllocationLine'',''C_Bank'',''C_BankAccount'',''C_BankAccount_Acct'',''C_BankAccount_Processor'',''C_BankAccountDoc'',''C_BankStatement'',''C_BankStatementLine'',''C_BankStatementLoader'',''C_BankStatementMatcher'',''C_BankTransfer'',''C_BP_BankAccount'',''C_BP_Customer_Acct'',''C_BP_EDI'',''C_BP_Employee_Acct'',''C_BP_Group'',''C_BP_Group_Acct'',''C_BP_Relation'',''C_BP_ShippingAcct'',''C_BP_Vendor_Acct'',''C_BP_Withholding'',''C_BPartner'',''C_BPartner_Location'',''C_BPartner_Product'',''C_Calendar'',''C_Campaign'',''C_Cash'',''C_CashBook'',''C_CashBook_Acct'',''C_CashLine'',''C_CashPlan'',''C_CashPlanLine'',''C_Channel'',''C_Charge'',''C_Charge_Acct'',''C_ChargeType'',''C_ChargeType_DocType'',''C_City'',''C_Commission'',''C_CommissionAmt'',''C_CommissionDetail'',''C_CommissionLine'',''C_CommissionRun'',''C_ContactActivity'',''C_Conversion_Rate'',''C_ConversionType'',''C_Country'',''C_CountryGroup'',''C_CountryGroupCountry'',''C_Currency'',''C_Currency_Acct'',''C_Cycle'',''C_CyclePhase'',''C_CycleStep'',''C_DepositBatch'',''C_DepositBatchLine'',''C_DocType'',''C_DocTypeCounter'',''C_Dunning'',''C_DunningLevel'',''C_DunningRun'',''C_DunningRunEntry'',''C_DunningRunLine'',''C_Element'',''C_ElementValue'',''C_Greeting'',''C_InterOrg_Acct'',''C_Invoice'',''C_InvoiceBatch'',''C_InvoiceBatchLine'',''C_InvoiceLine'',''C_InvoicePaySchedule'',''C_InvoiceSchedule'',''C_InvoiceTax'',''C_Job'',''C_JobAssignment'',''C_JobCategory'',''C_JobRemuneration'',''C_LandedCost'',''C_LandedCostAllocation'',''C_Location'',''C_NonBusinessDay'',''C_OnlineTrxHistory'',''C_Opportunity'',''C_Order'',''C_OrderLandedCost'',''C_OrderLandedCostAllocation'',''C_OrderLine'',''C_OrderPaySchedule'',''C_OrderSource'',''C_OrderTax'',''C_OrgAssignment'',''C_Payment'',''C_PaymentAllocate'',''C_PaymentBatch'',''C_PaymentProcessor'',''C_PaymentTerm'',''C_PaymentTransaction'',''C_PaySchedule'',''C_PaySelection'',''C_PaySelectionCheck'',''C_PaySelectionLine'',''C_Period'',''C_PeriodControl'',''C_Phase'',''C_POS'',''C_POSKey'',''C_POSKeyLayout'',''C_POSPayment'',''C_POSTenderType'',''C_Project'',''C_Project_Acct'',''C_ProjectIssue'',''C_ProjectIssueMA'',''C_ProjectLine'',''C_ProjectPhase'',''C_ProjectTask'',''C_ProjectType'',''C_Recurring'',''C_Recurring_Run'',''C_RecurringGroup'',''C_Region'',''C_Remuneration'',''C_RevenueRecog_Service'',''C_RevenueRecognition'',''C_RevenueRecognition_Plan'',''C_RevenueRecognition_Run'',''C_RfQ'',''C_RfQ_Topic'',''C_RfQ_TopicSubscriber'',''C_RfQ_TopicSubscriberOnly'',''C_RfQLine'',''C_RfQLineQty'',''C_RfQResponse'',''C_RfQResponseLine'',''C_RfQResponseLineQty'',''C_SalesRegion'',''C_SalesStage'',''C_ServiceLevel'',''C_ServiceLevelLine'',''C_SubAcct'',''C_Subscription'',''C_Subscription_Delivery'',''C_SubscriptionType'',''C_Task'',''C_Tax'',''C_Tax_Acct'',''C_TaxBase'',''C_TaxCategory'',''C_TaxDeclaration'',''C_TaxDeclarationAcct'',''C_TaxDeclarationLine'',''C_TaxDefinition'',''C_TaxGroup'',''C_TaxPostal'',''C_TaxProvider'',''C_TaxProviderCfg'',''C_TaxType'',''C_UOM'',''C_UOM_Conversion'',''C_UserRemuneration'',''C_ValidCombination'',''C_Withholding'',''C_Withholding_Acct'',''C_Year'',''CM_Chat'',''CM_ChatEntry'',''CM_ChatType'',''CM_ChatTypeUpdate'',''CM_ChatUpdate'',''DD_NetworkDistribution'',''DD_NetworkDistributionLine'',''DD_Order'',''DD_OrderLine'',''EXP_Format'',''EXP_FormatLine'',''EXP_Processor'',''EXP_Processor_Type'',''EXP_ProcessorParameter'',''Fact_Acct'',''Fact_Acct_Summary'',''Fact_Reconciliation'',''GL_Budget'',''GL_BudgetControl'',''GL_Category'',''GL_Distribution'',''GL_DistributionLine'',''GL_Fund'',''GL_FundRestriction'',''GL_Journal'',''GL_JournalBatch'',''GL_JournalGenerator'',''GL_JournalGeneratorLine'',''GL_JournalGeneratorSource'',''GL_JournalLine'',''HR_Attribute'',''HR_Concept'',''HR_Concept_Acct'',''HR_Concept_Category'',''HR_Contract'',''HR_Department'',''HR_Employee'',''HR_Job'',''HR_List'',''HR_ListLine'',''HR_ListType'',''HR_ListVersion'',''HR_Movement'',''HR_Payroll'',''HR_PayrollConcept'',''HR_Period'',''HR_Process'',''HR_Year'',''I_Asset'',''I_BankStatement'',''I_BPartner'',''I_Conversion_Rate'',''I_ElementValue'',''I_FAJournal'',''I_FixedAsset'',''I_GLJournal'',''I_HR_Movement'',''I_InOutLineConfirm'',''I_Inventory'',''I_Invoice'',''I_Movement'',''I_Order'',''I_Payment'',''I_PriceList'',''I_Product'',''I_ProductPlanning'',''I_ReportLine'',''IMP_Processor'',''IMP_Processor_Type'',''IMP_ProcessorLog'',''IMP_ProcessorParameter'',''M_Attribute'',''M_AttributeInstance'',''M_AttributeSearch'',''M_AttributeSet'',''M_AttributeSetExclude'',''M_AttributeSetInstance'',''M_AttributeUse'',''M_AttributeValue'',''M_BOM'',''M_BOMAlternative'',''M_BOMProduct'',''M_BP_Price'',''M_ChangeNotice'',''M_ChangeRequest'',''M_CommodityShipment'',''M_Cost'',''M_CostDetail'',''M_CostElement'',''M_CostHistory'',''M_CostQueue'',''M_CostType'',''M_Demand'',''M_DemandDetail'',''M_DemandLine'',''M_DiscountSchema'',''M_DiscountSchemaBreak'',''M_DiscountSchemaLine'',''M_DistributionList'',''M_DistributionListLine'',''M_DistributionRun'',''M_DistributionRunLine'',''M_Forecast'',''M_ForecastLine'',''M_Freight'',''M_FreightCategory'',''M_InOut'',''M_InOutConfirm'',''M_InOutLine'',''M_InOutLineConfirm'',''M_InOutLineMA'',''M_Inventory'',''M_InventoryLine'',''M_InventoryLineMA'',''M_Locator'',''M_LocatorType'',''M_Lot'',''M_LotCtl'',''M_LotCtlExclude'',''M_MatchInv'',''M_MatchPO'',''M_Movement'',''M_MovementConfirm'',''M_MovementLine'',''M_MovementLineConfirm'',''M_MovementLineMA'',''M_OperationResource'',''M_Package'',''M_PackageLine'',''M_PackageMPS'',''M_PartType'',''M_PerpetualInv'',''M_PriceList'',''M_PriceList_Version'',''M_Product'',''M_Product_Acct'',''M_Product_Category'',''M_Product_Category_Acct'',''M_Product_PO'',''M_Product_QualityTest'',''M_ProductDownload'',''M_Production'',''M_ProductionLine'',''M_ProductionLineMA'',''M_ProductionPlan'',''M_ProductOperation'',''M_ProductPrice'',''M_ProductPriceVendorBreak'',''M_Promotion'',''M_PromotionDistribution'',''M_PromotionGroup'',''M_PromotionGroupLine'',''M_PromotionLine'',''M_PromotionPreCondition'',''M_PromotionReward'',''M_QualityTest'',''M_QualityTestResult'',''M_RelatedProduct'',''M_Replenish'',''M_Requisition'',''M_RequisitionLine'',''M_RMA'',''M_RMALine'',''M_RMATax'',''M_RMAType'',''M_SerNoCtl'',''M_SerNoCtlExclude'',''M_Shipper'',''M_ShipperCfg'',''M_ShipperLabels'',''M_ShipperLabelsCfg'',''M_ShipperPackaging'',''M_ShipperPackagingCfg'',''M_ShipperPickupTypes'',''M_ShipperPickupTypesCfg'',''M_ShippingProcessor'',''M_ShippingProcessorCfg'',''M_ShippingTransaction'',''M_ShippingTransactionLine'',''M_StorageOnHand'',''M_StorageReservation'',''M_Substitute'',''M_Transaction'',''M_TransactionAllocation'',''M_Warehouse'',''M_Warehouse_Acct'',''PA_Achievement'',''PA_Benchmark'',''PA_BenchmarkData'',''PA_ColorSchema'',''PA_DashboardContent'',''PA_DashboardContent_Access'',''PA_DashboardPreference'',''PA_DocumentStatus'',''PA_Goal'',''PA_GoalRestriction'',''PA_Hierarchy'',''PA_Measure'',''PA_MeasureCalc'',''PA_Ratio'',''PA_RatioElement'',''PA_Report'',''PA_ReportColumn'',''PA_ReportColumnSet'',''PA_ReportCube'',''PA_ReportLine'',''PA_ReportLineSet'',''PA_ReportSource'',''PA_SLA_Criteria'',''PA_SLA_Goal'',''PA_SLA_Measure'',''PP_Cost_Collector'',''PP_Cost_CollectorMA'',''PP_MRP'',''PP_Order'',''PP_Order_BOM'',''PP_Order_BOMLine'',''PP_Order_Cost'',''PP_Order_Node'',''PP_Order_Node_Asset'',''PP_Order_Node_Product'',''PP_Order_NodeNext'',''PP_Order_Workflow'',''PP_Product_BOM'',''PP_Product_BOMLine'',''PP_Product_Planning'',''PP_WF_Node_Asset'',''PP_WF_Node_Product'',''QM_Specification'',''QM_SpecificationLine'',''R_Category'',''R_CategoryUpdates'',''R_ContactInterest'',''R_Group'',''R_GroupUpdates'',''R_InterestArea'',''R_IssueKnown'',''R_IssueProject'',''R_IssueRecommendation'',''R_IssueStatus'',''R_IssueSystem'',''R_IssueUser'',''R_MailText'',''R_Request'',''R_RequestAction'',''R_RequestProcessor'',''R_RequestProcessor_Route'',''R_RequestProcessorLog'',''R_RequestType'',''R_RequestTypeUpdates'',''R_RequestUpdate'',''R_RequestUpdates'',''R_Resolution'',''R_StandardResponse'',''R_Status'',''R_StatusCategory'',''RV_BPartner'',''RV_WarehousePrice'',''S_ExpenseType'',''S_Resource'',''S_ResourceAssignment'',''S_ResourceType'',''S_ResourceUnAvailable'',''S_TimeExpense'',''S_TimeExpenseLine'',''S_TimeType'',''S_Training'',''S_Training_Class'',''T_1099Extract'',''T_Aging'',''T_BankRegister'',''T_BOM_Indented'',''T_BOMLine'',''T_CashFlow'',''T_DistributionRunDetail'',''T_InventoryValue'',''T_InvoiceGL'',''T_MRP_CRP'',''T_Reconciliation'',''T_Replenish'',''T_Report'',''T_ReportStatement'',''T_Transaction'',''Test'',''U_BlackListCheque'',''U_POSTerminal'',''U_RoleMenu'',''U_Web_Properties'',''U_WebMenu'',''WS_WebService'',''WS_WebService_Para'',''WS_WebServiceFieldInput'',''WS_WebServiceFieldOutput'',''WS_WebServiceMethod'',''WS_WebServiceType'',''WS_WebServiceTypeAccess'''
WHERE bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03';

SELECT register_migration_script('202505061156_GO-3295.sql')
FROM dual;
