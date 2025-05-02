-- Delete the old warehouse access table
DROP TABLE bh_role_warehouseaccess;
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_role_warehouseaccess'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_role_warehouseaccess'
	);

-- Create the new table
CREATE TABLE BH_Warehouse_Access
(
	AD_Client_ID           NUMERIC(10) NOT NULL,
	AD_Org_ID              NUMERIC(10) NOT NULL,
	AD_Role_ID             NUMERIC(10) NOT NULL,
	BH_Warehouse_Access_UU VARCHAR(36)                                            DEFAULT NULL,
	Created                TIMESTAMP   NOT NULL                                   DEFAULT getDate(),
	CreatedBy              NUMERIC(10) NOT NULL,
	IsActive               CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))    DEFAULT 'Y',
	IsReadWrite            CHAR(1)     NOT NULL CHECK (IsReadWrite IN ('Y', 'N')) DEFAULT 'N',
	M_Warehouse_ID         NUMERIC(10) NOT NULL,
	Updated                TIMESTAMP   NOT NULL                                   DEFAULT getDate(),
	UpdatedBy              NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Warehouse_Access_Key PRIMARY KEY (M_Warehouse_ID, AD_Role_ID),
	CONSTRAINT BH_Warehouse_Access_UU_idx UNIQUE (BH_Warehouse_Access_UU)
);

ALTER TABLE BH_Warehouse_Access
	ADD CONSTRAINT ADClient_BHWarehouseAccess FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_Warehouse_Access
	ADD CONSTRAINT ADOrg_BHWarehouseAccess FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_Warehouse_Access
	ADD CONSTRAINT ADRole_BHWarehouseAccess FOREIGN KEY (AD_Role_ID) REFERENCES ad_role (ad_role_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_Warehouse_Access
	ADD CONSTRAINT MWarehouse_BHWarehouseAccess FOREIGN KEY (M_Warehouse_ID) REFERENCES m_warehouse (m_warehouse_id) DEFERRABLE INITIALLY DEFERRED;

-- Add the system elements
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.870000', 100, '2025-04-25 09:16:00.870000', 100, 'BH_Warehouse_Access_UU', 'U',
	 'BH_Warehouse_Access_UU', 'BH_Warehouse_Access_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '98620c07-fc45-4b5d-9bd8-8ea897105f12', NULL);

-- Insert the table row
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT
			 MAX(ad_table_id) + 1
		 FROM
			 ad_table
	 ), 0, 0, 'Y', '2025-04-25 09:15:50.947000', 100, '2025-04-25 09:15:50.947000', 100, 'Warehouse Access', NULL, NULL,
	 'BH_Warehouse_Access', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

-- Insert the columns
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.739000', '2025-04-25 09:18:02.435000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9721f5cc-56dd-40bd-a08f-77bd55b1c530', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHWarehouseAccess', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.776000', '2025-04-25 09:18:02.448000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '12376319-de56-4f6a-8cd1-a8100281f504', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHWarehouseAccess', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.859000', '2025-04-25 09:16:00.859000', 100, 100, 'BH_Warehouse_Access_UU', NULL,
	 NULL, 1, 'U', 'BH_Warehouse_Access_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '98620c07-fc45-4b5d-9bd8-8ea897105f12'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd39df5b0-6ae6-4c0f-b867-70d5e893d463', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.889000', '2025-04-25 09:16:00.889000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '88ef63ae-c69c-4c2d-8ba6-94201251acd7', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.907000', '2025-04-25 09:16:00.907000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3569e90f-6e0c-4253-a186-6f28e1e4f9d9', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:00.986000', '2025-04-25 09:16:00.986000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'df449584-facd-457b-bdc0-badafacdfaed', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:16:01.011000', '2025-04-25 09:16:01.011000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '418f3c91-da0a-4a44-9d71-0a326367e7b4', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:17:09.610000', '2025-04-25 09:17:09.610000', 100, 100, 'Read Write',
	 'Field is read / write', 'The Read Write indicates that this field may be read and updated.', 0, 'U', 'IsReadWrite',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 406, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'afc8024d-4edb-455d-995f-6e6cf5303fa1', 'Y', 0, 'N', 'N', NULL, NULL, 'N',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:17:21.754000', '2025-04-25 09:18:02.469000', 100, 100, 'Role', 'Responsibility Role',
	 'The Role determines security and access a user who has this Role will have in the System.', 0, 'U', 'AD_Role_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 123, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fb1800fd-2b3d-42d8-923d-eef6bfe79735', 'Y', 0, 'N', 'N', NULL,
	 'ADRole_BHWarehouseAccess', 'C', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-04-25 09:17:36.012000', '2025-04-25 09:18:02.520000', 100, 100, 'Warehouse',
	 'Storage Warehouse and Service Point',
	 'The Warehouse identifies a unique Warehouse where products are stored or Services are provided.', 0, 'U',
	 'M_Warehouse_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 459, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0cb343c3-212d-4144-8bf6-37feb580623f', 'Y', 0, 'N', 'N', NULL,
	 'MWarehouse_BHWarehouseAccess', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Create the tab for access
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
	 ), 0, 0, 'Y', '2025-04-25 09:27:04.343000', 100, '2025-04-25 09:27:04.343000', 100, 'Warehouse Access',
	 'Maintain Role Warehouse Access',
	 'Add the warehouse the user has access to. If no warehouse is added, the user has access to all warehouses.', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '4d3684dc-a0a8-42d8-81f4-93aa622c1d5a'
	 ), 111, 140, 1, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, 'N', 'U', NULL,
	 NULL, '@IsMasterRole@=N', 'Y', 'N', NULL, 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a', NULL, 'B', 0, 'N', 'Y', NULL, NULL,
	 NULL);

-- Add the tab fields
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.279000', 100, '2025-04-25 09:27:21.279000', 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9721f5cc-56dd-40bd-a08f-77bd55b1c530'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '87b9420c-2b4b-47d5-96cb-1b8ea354f8a6', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.299000', 100, '2025-04-25 09:27:21.299000', 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '12376319-de56-4f6a-8cd1-a8100281f504'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '72e74771-69f1-444e-909d-91d15fd0cd01', 'Y', 10, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.314000', 100, '2025-04-25 09:29:56.340000', 100, 'Warehouse Access', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd08dbf7c-2eb6-4068-af2b-2ef248a7a7c4'
	 ), NULL, 'N', NULL, 22, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '022c6959-2c5e-4873-8a9b-6fb5b5e2587b', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.324000', 100, '2025-04-25 09:29:56.338000', 100, 'BH_Warehouse_Access_UU', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd39df5b0-6ae6-4c0f-b867-70d5e893d463'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'f86e107b-4f96-41d6-be32-34ae2c9c1aad', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.331000', 100, '2025-04-25 09:29:56.336000', 100, 'Read Write',
	 'Field is read / write', 'The Read Write indicates that this field may be read and updated.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'afc8024d-4edb-455d-995f-6e6cf5303fa1'
	 ), NULL, 'Y', NULL, 1, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'fc565690-f136-4805-a2e2-720f99994f09', NULL, 30, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.342000', 100, '2025-04-25 09:29:56.327000', 100, 'Role', 'Responsibility Role',
	 'The Role determines security and access a user who has this Role will have in the System.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'fb1800fd-2b3d-42d8-923d-eef6bfe79735'
	 ), NULL, 'Y', NULL, 22, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '21038f80-3a0a-4770-b42e-4ede76e13a60', NULL, 40, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.361000', 100, '2025-04-25 09:29:56.332000', 100, 'Warehouse',
	 'Storage Warehouse and Service Point',
	 'The Warehouse identifies a unique Warehouse where products are stored or Services are provided.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0cb343c3-212d-4144-8bf6-37feb580623f'
	 ), NULL, 'Y', NULL, 22, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '1f9c0350-e5d5-4cb6-a35c-a4f8095f3ff8', NULL, 50, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2025-04-25 09:27:21.370000', 100, '2025-04-25 09:27:21.370000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'c86426ae-ff8d-4497-9cd7-c3ce514f5c2a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '44b3ed56-b8cd-46e1-b445-e2da7aa6f8ae'
	 ), NULL, 'Y', NULL, 1, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'ac556105-9126-48ed-89ae-3a77cd6a8d83', NULL, 60, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

UPDATE bh_graphqlgeneratortemplate
SET
	tablename = REGEXP_REPLACE(tablename, 'bh_role_warehouseaccess', 'BH_Warehouse_Access', 'i')
WHERE
	tablename ILIKE '%bh_role_warehouseaccess%';

SELECT
	register_migration_script('202504251134_GO-3280.sql')
FROM
	dual;
