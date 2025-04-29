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
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	          name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id,
	          ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable,
	          ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained,
	          ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT
			 MAX(ad_table_id)
		 FROM
			 ad_table
	 ) + 1, 0, 0, 'Y', '2025-04-28 11:53:00.918000', 100,
	 '2025-04-28 12:05:37.844000', 100, ' Included Product',
	 NULL, NULL, 'BH_Product_Included', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	            updatedby, columnname, entitytype, name, printname, description, help, po_name,
	            po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id)
		 FROM
			 ad_element
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:19:30.290000', 100,
	 '2025-04-28 12:20:13.284000', 100,
	 'Included_OrderLine_ID', 'U', 'Included OrdeLine ID', 'Include Product OrdeLine ID', NULL, NULL, NULL, NULL,
	 NULL, NULL, 'f2e5e7a7-7c97-43d8-b774-6d1ecfb71a45', NULL);
INSERT INTO
	adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                      updatedby, columnname, entitytype, name, printname, description, help, po_name,
	                      po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id)
		 FROM
			 ad_element
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:12:45.817000', 100, '2025-04-28 12:12:45.817000', 100, 'Included_Product_ID',
	 'U', 'Included Product', 'Included Product', NULL, NULL, NULL, NULL, NULL, NULL,
	 '0fbacafe-013f-4e93-b883-cd7c28c3e2b3', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	            updatedby, columnname, entitytype, name, printname, description, help, po_name,
	            po_printname, po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id)
		 FROM
			 ad_element
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.719000', 100, '2025-04-28 12:07:36.719000', 100,
	 'BH_Product_Included_UU', 'D', 'BH_Product_Included_UU', 'BH_Product_Included_UU', NULL, NULL, NULL, NULL, NULL,
	 NULL, '0347856f-14d8-4532-8f91-a7690005288d', NULL);


INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:23:28.520000',
	 '2025-04-28 12:23:38.316000', 100, 100,
	 'Included OrdeLine ID', NULL, NULL, 0, 'U', 'Included_OrderLine_ID', 260, 18, 271, NULL, 10, NULL, 'N', 'N',
	 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f2e5e7a7-7c97-43d8-b774-6d1ecfb71a45'
	 ), NULL, 'N',
	 'N', NULL, NULL, NULL, 'N',
	 'Y', NULL, '4148b65d-9617-4f18-af84-ead5e2e5d0cc', 'Y', 0, 'N', 'N', NULL, 'IncludedOrderLine_COrderLine', 'N',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.941000', '2025-04-28 12:07:36.941000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'D',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 608, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8951e660-17dd-489a-adcc-094f7c181dcc', 'N',
	 NULL, 'N', 'N', NULL, NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.908000', '2025-04-28 12:07:36.908000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'D',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 607, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'edba55a2-4496-4ff1-8906-da67b9038919', 'N',
	 NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.862000', '2025-04-28 12:07:36.862000', 100, 100, 'Sequence',
	 'Method of ordering records; lowest number comes first', 'The Sequence indicates the order of records', 0, 'D',
	 'SeqNo', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 11, NULL, NULL, 10,
	 '@SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Role_Included WHERE AD_Role_ID=@AD_Role_ID@', 'N',
	 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 566, NULL, 'N', 'N', NULL, NULL, NULL, 'N',
	 'Y', NULL, '12d2828d-efa1-4337-9ab0-afe8597973c5', 'Y', NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.835000', '2025-04-28 12:07:36.835000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'D', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL,
	 NULL, NULL, 'N', 348, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0a31dfeb-a935-49a7-a9fe-724ca52ac4a2',
	 'N', NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.804000', '2025-04-28 12:14:15.485000', 100, 100, 'Include Product ID',
	 NULL, NULL, 0, 'D', 'Included_Product_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, 200176, 231, 10, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N',
	 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0fbacafe-013f-4e93-b883-cd7c28c3e2b3'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL,
	 'ee8f39f6-8ac6-464e-96c4-d7e7fd20c5be', 'Y', NULL, 'N', 'N', NULL, 'IncludedProduct_BHProductIncluded', 'N',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.776000', '2025-04-28 12:07:36.776000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'D',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 246, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7b789d5c-d8eb-49d9-bd56-1249063ba3ab', 'N',
	 NULL, 'N', 'N', NULL, NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.736000', '2025-04-28 12:07:36.736000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'D',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 245, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '946d6198-ebc5-4db9-97e5-5da58fcf8aa0', 'N',
	 NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.693000', '2025-04-28 12:07:36.693000', 100, 100,
	 'BH_Product_Included_UU', NULL, NULL, 1, 'D', 'BH_Product_Included_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 200231, NULL, NULL, 36, NULL,
	 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0347856f-14d8-4532-8f91-a7690005288d'
	 ), NULL, 'N', 'N', NULL, NULL,
	 NULL, 'N', 'Y', NULL, 'e9e080b4-6e4c-40fe-b31c-616efaa4cc8a', 'N', NULL, 'N', 'N', NULL, NULL, 'N', NULL, NULL,
	 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.658000', '2025-04-28 12:14:15.506000', 100, 100, 'Product/Service',
	 'Product, Service, Item', 'Identifies an item which is either purchased or sold in this organization.', 1, 'D',
	 'M_Product_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, NULL, 231, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 454, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9edd7bac-42ee-4b88-811d-765ef52c7a5c', 'Y',
	 NULL, 'N', 'N', NULL, 'MProduct_BHProductIncluded', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N',
	 NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.616000', '2025-04-28 12:07:36.616000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'D', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, NULL, NULL, 22, '@AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N',
	 NULL, NULL, NULL, NULL, 'N', 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL,
	 'e8b97758-5a1e-4b11-b045-1c55560e3f1d', 'N', NULL, 'N', 'N', NULL, NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL,
	 NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby,
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
VALUES
	((
		 SELECT
			 MAX(ad_column_id)
		 FROM
			 ad_column
	 ) + 1, 0, 0, 'Y', '2025-04-28 12:07:36.524000', '2025-04-28 12:07:36.524000', 100, 100, 'Tenant',
	 'Tenant for this installation.',
	 'A Tenant is a company or a legal entity. You cannot share data between Tenants.', 1, 'D', 'AD_Client_ID',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 30, NULL, NULL, 22, '@AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL,
	 NULL, 'N', 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f0939748-b270-41a7-922f-1216384b16d5', 'N',
	 NULL, 'N', 'N', NULL, NULL, 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Add the new tab
INSERT INTO
	ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help,
	        ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly,
	        ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id,
	        importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id,
	        readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id,
	        treedisplayedon, maxqueryrecords, islookuponlyselection, isallowadvancedlookup, ad_tabtype, ishighvolume,
	        deleteconfirmationlogic)
VALUES
	((
		 SELECT
			 MAX(ad_tab_id) + 1
		 FROM
			 ad_tab
	 ), 0, 0, 'Y', '2025-04-28 13:38:49.015000', 100, '2025-04-28 13:38:49.015000', 100, 'Included products', NULL, NULL,
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '7d10e5d2-6fba-4f07-ab4d-50e0e5ead7c0'
	 ), 140, 180, 0, 'Y', 'N', 'N', 'N', (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9edd7bac-42ee-4b88-811d-765ef52c7a5c'
	 ), 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL, NULL, 'Y', 'N', NULL,
	 '10763278-352e-496d-a71d-53cfffd2409c', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);

-- Add the appropriate fields
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.855000', 100, '2025-04-28 13:38:59.855000', 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f0939748-b270-41a7-922f-1216384b16d5'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '817e1859-fd39-480e-8a1b-26ca9305c41f', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.875000', 100, '2025-04-28 13:38:59.875000', 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'e8b97758-5a1e-4b11-b045-1c55560e3f1d'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '5b569b4e-858d-46f1-bc67-5dcd219b72e5', 'Y', 10, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.892000', 100, '2025-04-28 13:43:01.604000', 100, 'Included Product', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ee8f39f6-8ac6-464e-96c4-d7e7fd20c5be'
	 ), NULL, 'Y', NULL, 10, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e8af9741-43df-4f5d-8133-5afb2878d9b2', NULL, 20, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.902000', 100, '2025-04-28 13:43:01.595000', 100, 'Product/Service',
	 'Product, Service, Item', 'Identifies an item which is either purchased or sold in this organization.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9edd7bac-42ee-4b88-811d-765ef52c7a5c'
	 ), NULL, 'Y', NULL, 22, 'N', 30, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '44ffd363-bbd3-45a0-b3dd-ca7bd866a380', NULL, 30, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.917000', 100, '2025-04-28 13:38:59.917000', 100, 'Sequence',
	 'Method of ordering records; lowest number comes first', 'The Sequence indicates the order of records', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '12d2828d-efa1-4337-9ab0-afe8597973c5'
	 ), NULL, 'Y', NULL, 10, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '8cda8b14-03a6-44e7-a076-6e74ab84ec5b', NULL, 40, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.934000', 100, '2025-04-28 13:43:01.608000', 100, 'BH_Product_Included_UU', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'e9e080b4-6e4c-40fe-b31c-616efaa4cc8a'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '56d46e54-aa87-4724-8e37-fa25c3f12074', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic,
	          ishtml)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2025-04-28 13:38:59.945000', 100, '2025-04-28 13:38:59.945000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '10763278-352e-496d-a71d-53cfffd2409c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0a31dfeb-a935-49a7-a9fe-724ca52ac4a2'
	 ), NULL, 'Y', NULL, 1, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '5f655266-45e4-4a2f-9fe7-3cf2957690f6', NULL, 50, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SELECT
	register_migration_script('202504281135_GO-2334.sql')
FROM
	dual;
