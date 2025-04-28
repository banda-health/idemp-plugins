CREATE TABLE BH_Product_Included
(
    AD_Client_ID           NUMERIC(10) NOT NULL,
    AD_Org_ID              NUMERIC(10) NOT NULL,
    BH_Product_Included_UU VARCHAR(36)                                         DEFAULT NULL,
    Created                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    CreatedBy              NUMERIC(10) NOT NULL,
    Included_Product_ID    NUMERIC(10) NOT NULL,
    IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
    M_Product_ID           NUMERIC(10) NOT NULL,
    SeqNo                  NUMERIC(10) NOT NULL,
    Updated                TIMESTAMP   NOT NULL                                DEFAULT getDate(),
    UpdatedBy              NUMERIC(10) NOT NULL,
    CONSTRAINT BH_Product_Included_UU_idx UNIQUE (BH_Product_Included_UU)
);
ALTER TABLE BH_Product_Included
    ADD CONSTRAINT IncludedProduct_BHProductIncluded FOREIGN KEY (Included_Product_ID) REFERENCES m_product (m_product_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Product_Included
    ADD CONSTRAINT MProduct_BHProductIncluded FOREIGN KEY (M_Product_ID) REFERENCES m_product (m_product_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE C_OrderLine
    ADD COLUMN Included_OrderLine_ID NUMERIC(10) DEFAULT NULL;
ALTER TABLE C_OrderLine
    ADD CONSTRAINT IncludedOrderLine_COrderLine FOREIGN KEY (Included_OrderLine_ID) REFERENCES c_orderline (c_orderline_id) DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX c_orderline_includedorderline_idx ON c_orderline (included_orderline_id);
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                      name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id,
                      ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable,
                      ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained,
                      ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
                      createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES ((SELECT MAX(ad_table_id) FROM ad_table) + 1, 0, 0, 'Y', '2025-04-28 11:53:00.918000', 100,
        '2025-04-28 12:05:37.844000', 100, ' Included Product',
        null, null, 'BH_Product_Included', 'N', '3', 'D', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y',
        '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                        updatedby, columnname, entitytype, name, printname, description, help, po_name,
                        po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id) FROM ad_element) + 1, 0, 0, 'Y', '2025-04-28 12:19:30.290000', 100,
        '2025-04-28 12:20:13.284000', 100,
        'Included_OrderLine_ID', 'U', 'Included OrdeLine ID', 'Include Product OrdeLine ID', null, null, null, null,
        null, null, 'f2e5e7a7-7c97-43d8-b774-6d1ecfb71a45', null);
INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                                  updatedby, columnname, entitytype, name, printname, description, help, po_name,
                                  po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id) FROM ad_element) + 1, 0, 0, 'Y', '2025-04-28 12:12:45.817000', 100, '2025-04-28 12:12:45.817000', 100, 'Included_Product_ID',
        'U', 'Include Product ID', 'Id of the Included Product', null, null, null, null, null, null,
        '0fbacafe-013f-4e93-b883-cd7c28c3e2b3', null);
INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                                  updatedby, columnname, entitytype, name, printname, description, help, po_name,
                                  po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES ((SELECT MAX(ad_element_id) FROM ad_element) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.719000', 100, '2025-04-28 12:07:36.719000', 100,
        'BH_Product_Included_UU', 'D', 'BH_Product_Included_UU', 'BH_Product_Included_UU', null, null, null, null, null,
        null, '0347856f-14d8-4532-8f91-a7690005288d', null);


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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:23:28.520000',
        '2025-04-28 12:23:38.316000', 100, 100,
        'Included OrdeLine ID', null, null, 0, 'U', 'Included_OrderLine_ID', 260, 18, 271, null, 10, null, 'N', 'N',
        'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N',
        (SELECT ad_element_id FROM ad_element where ad_element_uu = 'f2e5e7a7-7c97-43d8-b774-6d1ecfb71a45'), null, 'N',
        'N', null, null, null, 'N',
        'Y', null, '4148b65d-9617-4f18-af84-ead5e2e5d0cc', 'Y', 0, 'N', 'N', null, 'IncludedOrderLine_COrderLine', 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);

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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.941000', '2025-04-28 12:07:36.941000', 100, 100, 'Updated By',
        'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'D',
        'UpdatedBy',  (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 30, 110, null, 22, null, 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 608, null, 'N', 'N', null, null, null, 'N', 'Y', null, '8951e660-17dd-489a-adcc-094f7c181dcc', 'N',
        null, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.908000', '2025-04-28 12:07:36.908000', 100, 100, 'Updated',
        'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'D',
        'Updated', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 607, null, 'N', 'N', null, null, null, 'N', 'Y', null, 'edba55a2-4496-4ff1-8906-da67b9038919', 'N',
        null, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.862000', '2025-04-28 12:07:36.862000', 100, 100, 'Sequence',
        'Method of ordering records; lowest number comes first', 'The Sequence indicates the order of records', 0, 'D',
        'SeqNo', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 11, null, null, 10,
        '@SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@', 'N',
        'N', 'Y', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 566, null, 'N', 'N', null, null, null, 'N',
        'Y', null, '12d2828d-efa1-4337-9ab0-afe8597973c5', 'Y', null, 'N', 'N', null, null, 'N', null, null, 'N', null,
        null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.835000', '2025-04-28 12:07:36.835000', 100, 100, 'Active',
        'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
        1, 'D', 'IsActive', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 20, null, null, 1, 'Y', 'N', 'N', 'Y', 'Y', null, 'N', 0, 'N', 'N', null, null,
        null, null, 'N', 348, null, 'N', 'N', null, null, null, 'N', 'Y', null, '0a31dfeb-a935-49a7-a9fe-724ca52ac4a2',
        'N', null, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.804000', '2025-04-28 12:14:15.485000', 100, 100, 'Include Product ID',
        null, null, 0, 'D', 'Included_Product_ID', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 18, 200176, 200006, 10, null, 'N', 'Y', 'Y', 'N', null, 'N',
        0, 'N', 'N', null, null, null, null, 'N', (SELECT ad_element_id from ad_element where ad_element_uu='0fbacafe-013f-4e93-b883-cd7c28c3e2b3'), null, 'N', 'N', null, null, null, 'N', 'Y', null,
        'ee8f39f6-8ac6-464e-96c4-d7e7fd20c5be', 'Y', null, 'N', 'N', null, 'IncludedProduct_BHProductIncluded', 'N',
        null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.776000', '2025-04-28 12:07:36.776000', 100, 100, 'Created By',
        'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'D',
        'CreatedBy', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 30, 110, null, 22, null, 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 246, null, 'N', 'N', null, null, null, 'N', 'Y', null, '7b789d5c-d8eb-49d9-bd56-1249063ba3ab', 'N',
        null, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.736000', '2025-04-28 12:07:36.736000', 100, 100, 'Created',
        'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'D',
        'Created', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 245, null, 'N', 'N', null, null, null, 'N', 'Y', null, '946d6198-ebc5-4db9-97e5-5da58fcf8aa0', 'N',
        null, 'N', 'N', null, null, 'N', null, null, 'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.693000', '2025-04-28 12:07:36.693000', 100, 100,
        'BH_Product_Included_UU', null, null, 1, 'D', 'BH_Product_Included_UU', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 200231, null, null, 36, null,
        'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N', (SELECT ad_element_id from ad_element where ad_element_uu='0347856f-14d8-4532-8f91-a7690005288d'), null, 'N', 'N', null, null,
        null, 'N', 'Y', null, 'e9e080b4-6e4c-40fe-b31c-616efaa4cc8a', 'N', null, 'N', 'N', null, null, 'N', null, null,
        'N', null, null, null, null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.658000', '2025-04-28 12:14:15.506000', 100, 100, 'Product/Service',
        'Product, Service, Item', 'Identifies an item which is either purchased or sold in this organization.', 1, 'D',
        'M_Product_ID', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 30, null, 231, 22, null, 'N', 'Y', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 454, null, 'N', 'N', null, null, null, 'N', 'Y', null, '9edd7bac-42ee-4b88-811d-765ef52c7a5c', 'Y',
        null, 'N', 'N', null, 'MProduct_BHProductIncluded', 'N', null, null, 'N', null, null, null, null, null, 'N',
        null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.616000', '2025-04-28 12:07:36.616000', 100, 100, 'Organization',
        'Organizational entity within tenant',
        'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
        1, 'D', 'AD_Org_ID', (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 30, null, null, 22, '@AD_Org_ID@', 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N',
        null, null, null, null, 'N', 113, null, 'N', 'N', null, null, null, 'N', 'Y', null,
        'e8b97758-5a1e-4b11-b045-1c55560e3f1d', 'N', null, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null,
        null, null, 'N', null, null);
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
VALUES ((SELECT MAX(ad_column_id) FROM ad_column) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.524000', '2025-04-28 12:07:36.524000', 100, 100, 'Tenant',
        'Tenant for this installation.',
        'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 1, 'D', 'AD_Client_ID',
        (SELECT ad_table_id FROM ad_table where ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'), 30, null, null, 22, '@AD_Client_ID@', 'N', 'N', 'Y', 'N', null, 'N', 0, 'N', 'N', null, null, null,
        null, 'N', 102, null, 'N', 'N', null, null, null, 'N', 'Y', null, 'f0939748-b270-41a7-922f-1216384b16d5', 'N',
        null, 'N', 'N', null, null, 'D', null, null, 'N', null, null, null, null, null, 'N', null, null);



SELECT register_migration_script('202504281135_GO-2334.sql')
FROM dual;
