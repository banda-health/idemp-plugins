-- Field Rules: per-clinic configuration of which Patient Registration / Vitals fields are required
-- (settings page under System Settings; see GO-3645 in greenlight-client for the client-side counterpart)

CREATE TABLE BH_Field_Rule
(
    AD_Client_ID     NUMERIC(10) NOT NULL,
    AD_Org_ID        NUMERIC(10) NOT NULL,
    BH_Field_Rule_ID NUMERIC(10) NOT NULL,
    BH_Field_Rule_UU VARCHAR(36)                                            DEFAULT NULL,
    BH_Form          VARCHAR(30) NOT NULL,
    BH_FieldKey      VARCHAR(80) NOT NULL,
    BH_Required      CHAR(1)     NOT NULL CHECK (BH_Required IN ('Y', 'N')) DEFAULT 'N',
    Created          TIMESTAMP   NOT NULL                                  DEFAULT getDate(),
    CreatedBy        NUMERIC(10) NOT NULL,
    IsActive         CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))   DEFAULT 'Y',
    Updated          TIMESTAMP   NOT NULL                                  DEFAULT getDate(),
    UpdatedBy        NUMERIC(10) NOT NULL,
    CONSTRAINT BH_Field_Rule_Key PRIMARY KEY (BH_Field_Rule_ID),
    CONSTRAINT BH_Field_Rule_UU_idx UNIQUE (BH_Field_Rule_UU),
    CONSTRAINT BH_Field_Rule_Client_Form_Key_idx UNIQUE (AD_Client_ID, BH_Form, BH_FieldKey)
);
ALTER TABLE BH_Field_Rule
    ADD CONSTRAINT ADClient_BHFieldRule FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Field_Rule
    ADD CONSTRAINT ADOrg_BHFieldRule FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                      description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id,
                      loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype,
                      po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing,
                      databaseviewdrop, copycomponentsfromview, createwindowfromtable, isshowindrilloptions,
                      ispartition, createpartition)
VALUES ((SELECT MAX(ad_table_id + 1) FROM ad_table), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100,
        '2026-07-02 16:47:00.000000', 100, 'Field Rule', null,
        null, 'BH_Field_Rule', 'N', '4', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y',
        'b12361c9-4f77-4be2-8226-4d8b1e942ba1', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                         name, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys,
                         istableid, ad_sequence_uu)
VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100,
        '2026-07-02 16:47:00.000000', 100, 'BH_Field_Rule', null, 'Y', 1, 1000000, 1000000, 200000, 'Y',
        'e8a195dd-03e9-4cc0-b0cc-621a52c41c70');

-- ad_element (custom columns)
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100, 'BH_Field_Rule_ID', 'U', 'Field Rule', 'Field Rule', null, null, 'd57289c3-9ca5-46ec-bf90-794c29b454c6');
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100, 'BH_Field_Rule_UU', 'U', 'BH_Field_Rule_UU', 'BH_Field_Rule_UU', null, null, 'e260e5fb-ed60-4f55-bea6-f03349493de8');
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100, 'BH_Form', 'U', 'Form', 'Form', null, null, 'b545ee3a-66fa-4319-b217-43d066e80cb7');
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100, 'BH_FieldKey', 'U', 'Field Key', 'Field Key', null, null, '145651c4-0477-440e-88a4-3d1154a61ba5');
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100, 'BH_Required', 'U', 'Required', 'Required', null, null, 'e4219c40-df04-4883-ab43-b339d4050e7f');

-- ad_column
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Tenant',
        'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 1, 'U', 'AD_Client_ID',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 19, null, 129,
        22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null,
        null, null, 'N', 102, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, 'ae17edcd-6a55-4eb2-bf87-12cecbce20f4', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Organization',
        'Organizational entity within tenant', 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.', 1, 'U', 'AD_Org_ID',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 19, null, 104,
        22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', null, 'N', null, 'N', 'N', null, null,
        null, null, 'N', 113, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '0116dd0e-5ad9-42e3-be8f-357c546b6aec', 'N', null, 'N', 'N', null, 'ADOrg_BHFieldRule', 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Field Rule',
        null, null, 1, 'U', 'BH_Field_Rule_ID',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 13, null, null,
        22, null, 'Y', 'N', 'Y', 'N', null, 'N', 1, 'N', 'N', null, null,
        null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd57289c3-9ca5-46ec-bf90-794c29b454c6'), null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '9e592c9d-1c1b-4f70-98e4-0b5211598e95', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'BH_Field_Rule_UU',
        null, null, 1, 'U', 'BH_Field_Rule_UU',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 200231, null, null,
        36, null, 'N', 'N', 'N', 'Y', null, 'N', 2, 'N', 'N', null, null,
        null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e260e5fb-ed60-4f55-bea6-f03349493de8'), null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '67ce4595-5c76-4158-a306-88dbc8286771', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Form',
        null, null, 1, 'U', 'BH_Form',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 10, null, null,
        30, null, 'N', 'N', 'Y', 'N', null, 'Y', 3, 'N', 'N', null, null,
        null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b545ee3a-66fa-4319-b217-43d066e80cb7'), null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '6a155710-68a4-4ad8-8bd3-b896c83e7e7b', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Field Key',
        null, null, 1, 'U', 'BH_FieldKey',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 10, null, null,
        80, null, 'N', 'N', 'Y', 'N', null, 'Y', 4, 'N', 'N', null, null,
        null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '145651c4-0477-440e-88a4-3d1154a61ba5'), null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, 'e8d41613-36c3-4572-9d44-bdcbcf6cd4af', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Required',
        null, null, 1, 'U', 'BH_Required',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 20, null, null,
        1, 'N', 'N', 'N', 'Y', 'Y', null, 'N', 5, 'N', 'N', null, null,
        null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e4219c40-df04-4883-ab43-b339d4050e7f'), null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, 'f5deb850-3ec6-4726-bccb-63309df90ca6', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Created',
        'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U', 'Created',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', 245, 'N', 'N', null, null,
        null, null, 'N', 245, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '193cefff-1340-488a-b566-534985ac5696', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Created By',
        'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U', 'CreatedBy',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 18, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', 246, 'N', 'N', null, null,
        null, null, 'N', 246, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '93d7d5d5-6a01-4253-99cb-9614585dd62c', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Updated',
        'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U', 'Updated',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 16, null, null,
        7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', 607, 'N', 'N', null, null,
        null, null, 'N', 607, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '3040775a-c390-4d69-88b1-011f98a4c5d9', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Updated By',
        'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U', 'UpdatedBy',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 18, 110, null,
        22, null, 'N', 'N', 'Y', 'N', null, 'N', 608, 'N', 'N', null, null,
        null, null, 'N', 608, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, 'dce8c99e-0896-4696-855d-3485e8e68f3e', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
                       description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
                       ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
                       isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
                       valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
                       isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
                       formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
                       fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2026-07-02 16:47:00.000000', '2026-07-02 16:47:00.000000', 100, 100, 'Active',
        'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record.', 1, 'U', 'IsActive',
        (SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'), 20, null, null,
        1, 'Y', 'N', 'N', 'Y', 'N', null, 'N', 348, 'N', 'N', null, null,
        null, null, 'N', 348, null, 'Y', 'N',
        null, null, null, 'N', 'Y', null, '37a8147e-f3e5-43f1-993e-50e8fe8cf7b0', 'N', null, 'N', 'N', null, null, 'N', null, null, 'N');

-- ad_window (permission anchor + menu target; native tab/fields included for convention but not used - React owns the real UI)
INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                       description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id,
                       isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic,
                       predefinedcontextvariables)
VALUES ((SELECT MAX(ad_window_id + 1) FROM ad_window), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100,
        '2026-07-02 16:47:00.000000', 100, 'Field Rules', null,
        null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', 'b56a5e0d-f0ef-47ee-af8d-3c9cca178c05', null, null);

-- Give clinic admins the ability to view/edit (admin-only, unlike most other windows there is no read-only grant to other roles)
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
		ON w.ad_window_uu = 'b56a5e0d-f0ef-47ee-af8d-3c9cca178c05'
WHERE
	r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685');

-- Replicate the same grant to every clinic's auto-provisioned copy of the admin role
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
  AND w.ad_window_uu = 'b56a5e0d-f0ef-47ee-af8d-3c9cca178c05';

INSERT INTO ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                    name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow,
                    isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause,
                    orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields,
                    ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id,
                    readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu,
                    ad_ctxhelp_id, treedisplayedon, maxqueryrecords, islookuponlyselection,
                    isallowadvancedlookup, ad_tabtype, ishighvolume, deleteconfirmationlogic)
VALUES ((SELECT MAX(ad_tab_id + 1) FROM ad_tab), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100,
        '2026-07-02 16:47:00.000000', 100, 'Field Rule',
        'Tab for managing field rules', null,
        (select ad_table_id from ad_table where ad_table_uu = 'b12361c9-4f77-4be2-8226-4d8b1e942ba1'),
        (select ad_window_id from ad_window where ad_window_uu = 'b56a5e0d-f0ef-47ee-af8d-3c9cca178c05'), 10, 0, 'Y',
        'N', 'N', 'N', null, 'N', null, null, null,
        null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null,
        'f166c576-522e-491f-85ea-61fed90ecc09', null, 'B', 0, 'N', 'Y', null, null, null);

-- ad_field (Form / Field Key / Required - the fields an admin would edit if this native tab were ever opened)
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_field_uu)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100,
        'Form', null, null, 'Y',
        (select ad_tab_id from ad_tab where ad_tab_uu = 'f166c576-522e-491f-85ea-61fed90ecc09'),
        (select ad_column_id from ad_column where ad_column_uu = '6a155710-68a4-4ad8-8bd3-b896c83e7e7b'),
        null, 'Y', null, 20, 'N', 10, 10, 'N', 'N', 'N', 'N', 'U', null,
        null, 'Y', null, null, null, 'f0ebb122-708c-4146-8b58-4e9ada00152c');
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_field_uu)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100,
        'Field Key', null, null, 'Y',
        (select ad_tab_id from ad_tab where ad_tab_uu = 'f166c576-522e-491f-85ea-61fed90ecc09'),
        (select ad_column_id from ad_column where ad_column_uu = 'e8d41613-36c3-4572-9d44-bdcbcf6cd4af'),
        null, 'Y', null, 20, 'N', 20, 10, 'N', 'N', 'N', 'N', 'U', null,
        null, 'Y', null, null, null, '4f95d791-4085-4cd3-bb8e-4834ddeefde1');
INSERT INTO ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id,
                      ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno,
                      issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype,
                      ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
                      ad_field_uu)
VALUES ((SELECT MAX(ad_field_id + 1) FROM ad_field), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100,
        'Required', null, null, 'Y',
        (select ad_tab_id from ad_tab where ad_tab_uu = 'f166c576-522e-491f-85ea-61fed90ecc09'),
        (select ad_column_id from ad_column where ad_column_uu = 'f5deb850-3ec6-4726-bccb-63309df90ca6'),
        null, 'Y', null, 1, 'N', 30, 10, 'N', 'N', 'N', 'N', 'U', null,
        null, 'Y', null, null, null, '13acf10c-4def-47aa-8039-d579b4f30c56');

-- ad_menu: nest under System Settings, next to Facility Information / Patient Tags
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
	 ), 0, 0, 'Y', '2026-07-02 16:47:00.000000', 100,
	 '2026-07-02 16:47:00.000000', 'Field Rules', 100,
	 'Configure which Patient Registration and Vitals fields are required', 'N', 'Y', 'N', 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'b56a5e0d-f0ef-47ee-af8d-3c9cca178c05'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y',
	 'd25507e8-f91e-4ebc-bf26-9f67222a8d9b', NULL, NULL, NULL);

INSERT INTO ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                           updatedby, parent_id, seqno, ad_treenodemm_uu)
VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'd25507e8-f91e-4ebc-bf26-9f67222a8d9b'), 0, 0, 'Y',
        '2026-07-02 16:47:00.000000', 100, '2026-07-02 16:47:00.000000', 100,
        (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 7,
        'b377d32e-4518-4700-af81-834578db7d15');

-- GraphQL generator template (idempotent - safe to re-run)
UPDATE bh_graphqlgeneratortemplate
SET tablename = REGEXP_REPLACE(
	tablename,
	'''BH_Encounter_Type_Window''',
	'''BH_Encounter_Type_Window'',''BH_Field_Rule''',
	'i'
)
WHERE bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03'
  AND tablename NOT ILIKE '%BH_Field_Rule%';

SELECT register_migration_script('202607021647_GO-3645.sql') FROM dual;
