CREATE TABLE BH_Tags
(
    AD_Client_ID  NUMERIC(10) NOT NULL,
    AD_Org_ID     NUMERIC(10) NOT NULL,
    BH_ColourCode VARCHAR(10)                                         DEFAULT NULL,
    BH_Tags_ID    NUMERIC(10) NOT NULL,
    BH_Tags_UU    VARCHAR(36)                                         DEFAULT NULL,
    Created       TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    CreatedBy     NUMERIC(10) NOT NULL,
    Description   VARCHAR(255)                                        DEFAULT NULL,
    IsActive      CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
    Name          VARCHAR(60) NOT NULL,
    Updated       TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    UpdatedBy     NUMERIC(10) NOT NULL,
    CONSTRAINT BH_Tags_Key PRIMARY KEY (BH_Tags_ID),
    CONSTRAINT BH_Tags_UU_idx UNIQUE (BH_Tags_UU)
);
ALTER TABLE BH_Tags
    ADD CONSTRAINT ADClient_BHTags FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Tags
    ADD CONSTRAINT ADOrg_BHTags FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE BH_BPartner_Tags
(
    AD_Client_ID        NUMERIC(10) NOT NULL,
    AD_Org_ID           NUMERIC(10) NOT NULL                                DEFAULT 0,
    BH_BPartner_Tags_UU VARCHAR(36)                                         DEFAULT NULL,
    BH_Tags_ID          NUMERIC(10) NOT NULL,
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
    ADD CONSTRAINT BHTags_BHBPartnerTags FOREIGN KEY (BH_Tags_ID) REFERENCES bh_tags (bh_tags_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BPartner_Tags
    ADD CONSTRAINT CBPartner_BHBPartnerTags FOREIGN KEY (C_BPartner_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;
alter table BH_BPartner_Tags
    add primary key (BH_Tags_ID, C_BPartner_ID);


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
        '2025-05-06 11:14:59.920000', 100, 'BH Tags', null, null,
        'BH_Tags', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y',
        '5d7cd657-7ae6-4005-80e4-1d1a1dca5233', 'N', 'N', 'N', 'N', 'N', 'N', 'N');


INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:12:44.021000', 100,
        '2025-05-06 13:12:44.021000', 100, 'BH_Tags_UU', 'U',
        'BH_Tags_UU', 'BH_Tags_UU', null, null, null, null, null, null, 'd814e5b4-ec8c-4463-b956-1e493fd39835', null);
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:12:43.993000', 100,
        '2025-05-06 13:12:43.993000', 100, 'BH_Tags_ID', 'U',
        'BH Tags', 'BH Tags', null, null, null, null, null, null, '8b6100d1-055a-44ed-bf81-07b4eafb2660', null);
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id + 1) FROM ad_element), 0, 0, 'Y', '2025-05-06 13:03:48.141000', 100,
        '2025-05-06 13:03:48.141000', 100, 'BH_BPartnerTags_ID',
        'D', 'BPartner Tags ID', 'Id of Bpartner', null, null, null, null, null, null,
        '1adea18e-b5d7-490f-899f-4657ce2f47b6', null);
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
        '2025-05-06 15:56:23.130000', 100, 100, 'BH Tags', null, null, 1, 'U', 'BH_Tags_ID',
        (select ad_table_id from ad_table where ad_table_uu = 'efe5be1e-bc23-4e21-9807-81e67b3be56a'), 30, null, null,
        22, null, 'N', 'Y', 'Y', 'N', null, 'N', null, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8b6100d1-055a-44ed-bf81-07b4eafb2660'), null, 'N',
        'N',
        null, null, null, 'N', 'Y', null, 'a04e8bb3-6c40-4a18-8f2f-5d652b09d8bd', 'Y', null, 'N', 'N', null,
        'BHTags_BHBPartnerTags', 'C', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
        '2025-05-06 13:12:44.005000', 100, 100, 'BH_Tags_UU', null, null, 1, 'U', 'BH_Tags_UU',
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
        '2025-05-06 13:54:10.253000', 100, 100, 'BH Tags ID', null, null, 1, 'U', 'BH_Tags_ID',
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
        'ADOrg_BHTags', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
        'ADClient_BHTags', 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);

INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                         name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys,
                         isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu,
                         startnewmonth, isorglevelsequence, orgcolumn)
VALUES ((SELECT MAX(ad_sequence_id + 1) FROM ad_sequence), 0, 0, 'Y', '2025-05-06 10:04:45.237000', 100,
        '2025-05-06 10:04:45.237000', 100, 'BH_Tags',
        'Table BH_Tags', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null,
        'd854df76-426b-46d7-8f95-d99e0712b09d', 'N', 'N', null);

INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                       description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id,
                       isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic,
                       predefinedcontextvariables)
VALUES ((SELECT MAX(ad_window_id + 1) FROM ad_window), 0, 0, 'Y', '2025-05-06 16:30:47.131000', 100,
        '2025-05-06 16:30:47.131000', 100, 'Patient Tags', null,
        null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '3c865615-4f7e-4b19-a64b-740485d99e83', null, null);

INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0,
        'Y', '2025-05-07 12:01:27.933000', 100, '2025-05-07 12:01:27.933000', 100, 'Y',
        '919628e7-8756-473e-8e7d-1c2142dfbad3', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'), 0, 0,
        'Y', '2025-05-07 12:03:48.297000', 100, '2025-05-07 12:03:48.297000', 100, 'Y',
        '009a97bf-f6cf-4f7e-afd9-f227df44b5bd', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0,
        'Y', '2025-05-07 12:04:27.881000', 100, '2025-05-07 12:04:27.881000', 100, 'N',
        'd5435014-b2f8-4e1d-80c1-8cebef29bc73', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'), 0, 0,
        'Y', '2025-05-07 12:05:00.987000', 100, '2025-05-07 12:05:00.987000', 100, 'Y',
        'd483f367-6cdb-4c06-9c34-074f8dab574f', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'), 0, 0,
        'Y', '2025-05-07 12:05:19.011000', 100, '2025-05-07 12:05:19.011000', 100, 'N',
        'ef4929c8-7e79-4671-b1b4-f0d78ec4cbac', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0,
        'Y', '2025-05-07 12:05:43.833000', 100, '2025-05-07 12:05:43.833000', 100, 'Y',
        '7a9ff6cb-8d46-4696-9bc7-d36d27d3c574', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'), 0, 0,
        'Y', '2025-05-07 12:06:21.221000', 100, '2025-05-07 12:06:21.221000', 100, 'Y',
        'e86ff538-7eb4-4780-9368-1e6aea3b6154', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'), 0, 0,
        'Y', '2025-05-07 12:06:54.200000', 100, '2025-05-07 12:06:54.200000', 100, 'Y',
        'c7f213b2-0e3d-4c1f-b614-f74229a4b09a', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0,
        'Y', '2025-05-07 12:07:25.619000', 100, '2025-05-07 12:07:25.619000', 100, 'N',
        '35871880-e17b-4637-9640-250e76d23706', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'), 0, 0,
        'Y', '2025-05-07 12:07:59.312000', 100, '2025-05-07 12:07:59.312000', 100, 'Y',
        '808247df-e8bd-425c-a3a7-28bc94a96c9f', 'Y');
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493'), 0, 0,
        'Y', '2025-05-07 12:08:21.070000', 100, '2025-05-07 12:08:21.070000', 100, 'N',
        '045ee1c9-639b-4ae3-aaae-fbcfbbb0c6ba', 'Y');

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
        '2025-05-06 16:33:50.998000', 100, 'Patient Tags',
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
        '2025-05-06 16:52:49.131000', 100, 'BH_Tags_UU', null,
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
        '2025-05-06 16:52:49.124000', 100, 'BH Tags', null, null,
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

INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
                     updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id,
                     ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype,
                     iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
                     predefinedcontextvariables)
VALUES ((SELECT MAX(ad_menu_id + 1) FROM ad_menu), 0, 0, 'Y', '2025-05-06 16:54:10.336000', 100,
        '2025-05-06 16:54:10.336000', 'Patient Tags', 100,
        'Tags for Patients', 'N', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'Y',
        '1a45dfaf-5d97-4246-a3c0-1965f91e22b1', null, null, null);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                           updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '1a45dfaf-5d97-4246-a3c0-1965f91e22b1'), 0, 0, 'Y',
        '2025-05-06 16:54:10.371161', 100, '2025-05-06 16:57:50.340000', 100,
        (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 6,
        'ff96739c-44a6-41d8-b1aa-fdf0886440bb');
SELECT register_migration_script('202505061156_GO-3295.sql')
FROM dual;
