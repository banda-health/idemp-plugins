/************ BH_Ocl_Originating_Source ************/
CREATE TABLE BH_Ocl_Originating_Source
(
	AD_Client_ID                 numeric(10)                                            NOT NULL,
	AD_Org_ID                    numeric(10)                                            NOT NULL,
	BH_Ocl_Originating_Source_ID numeric(10)                                            NOT NULL,
	BH_Ocl_Originating_Source_UU VARCHAR(36)                                            NOT NULL,
	BH_Concept_ID                numeric(10)                                            NOT NULL,
	Created                      timestamp   DEFAULT NOW()                              NOT NULL,
	CreatedBy                    numeric(10)                                            NOT NULL,
	IsActive                     CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Updated                      timestamp   DEFAULT NOW()                              NOT NULL,
	UpdatedBy                    numeric(10)                                            NOT NULL,
	BH_Ocl_Source                VARCHAR(10) DEFAULT NULL,

	CONSTRAINT BH_Ocl_Originating_Source_Key PRIMARY KEY (BH_Ocl_Originating_Source_ID),
	CONSTRAINT BH_Ocl_Originating_Source_UU_idx UNIQUE (BH_Ocl_Originating_Source_UU),
	CONSTRAINT ADClient_BHOclOriginatingSource FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT ADOrg_BHOclOriginatingSource FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT BHConcept_BHOclOriginatingSource FOREIGN KEY (BH_Concept_ID) REFERENCES BH_Concept (BH_Concept_ID) DEFERRABLE INITIALLY DEFERRED
);

-- Insert BH Ocl Source reference
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT MAX(AD_Reference_ID) + 1
		 FROM AD_Reference
	 ), 0, 0, 'Y', '2024-07-02 16:22:19.802000', 100, '2024-07-02 16:22:19.802000', 100, 'BH Ocl Source',
	 'A list of sources of concepts Banda Health has defined in OCL', NULL, 'L', NULL, 'U', 'N',
	 '6e6a9ace-0369-4ede-937a-8b40c752b80c', NULL)
ON CONFLICT DO NOTHING;

-- Insert BH Ocl Source reference list items
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2024-07-02 16:23:44.577000', 100, '2024-07-02 16:26:18.032000', 100, 'BHGO', 'BHGO - Coded diagnoses',
	 'Coded diagnoses', (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', 'e5517bb6-f4b5-40cf-b98f-0e32213413cf', NULL, NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2024-07-02 16:23:31.031000', 100, '2024-07-02 16:26:25.574000', 100, 'BHLabs', 'BHLabs - Lab tests',
	 'Diagnostic lab tests, panels, and findings', (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', '0ec64177-8a96-41a4-add6-e411046377c9', NULL, NULL)
ON CONFLICT DO NOTHING;

-- Add ad_elements
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.104000', 100, '2024-07-02 14:47:36.104000', 100, 'BH_Ocl_Originating_Source_ID',
	 'U', 'OCL Originating Source', 'OCL Originating Source', NULL, NULL, NULL, NULL, NULL, NULL,
	 '0938647e-8ceb-4023-a023-79d3c4034399', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.135000', 100, '2024-07-02 14:47:36.135000', 100, 'BH_Ocl_Originating_Source_UU',
	 'U', 'BH_Ocl_Originating_Source_UU', 'BH_Ocl_Originating_Source_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'a1aca021-f7b4-47ea-a360-685917098058', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.135000', 100, '2024-07-02 14:47:36.135000', 100, 'BH_Ocl_Source', 'U',
	 'BH Ocl Source', 'Banda Health source in OCL', NULL, NULL, NULL, NULL, NULL, NULL,
	 '743fb05a-8ed9-4c83-8330-4a3fdbc7b79c', NULL)
ON CONFLICT DO NOTHING;

-- Add ad_table
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT MAX(AD_Table_ID) + 1
		 FROM AD_Table
	 ), 0, 0, 'Y', '2024-07-02 14:47:35.999000', 100, '2024-07-02 14:47:35.999000', 100, 'OCL Originating Source',
	 'Tracks the original Banda Health source that was used to sync concepts from OCL into our system', NULL,
	 'BH_Ocl_Originating_Source', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '66968549-9d1b-4c41-9fe2-17db87eba6d1', 'N', 'N', 'N', 'N')
ON CONFLICT DO NOTHING;

-- Add ad_columns
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.035000', '2024-07-02 14:47:36.035000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 0, 'U', 'AD_Client_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 19, NULL, 129, 10, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '51c0a680-1ccb-4b3c-978d-e87f24776418', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.058000', '2024-07-02 14:47:36.058000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 0, 'U', 'AD_Org_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 19, NULL, 104, 10, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4fa32fef-5e61-4ef3-ab2f-ba3dd3868c5d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.066000', '2024-07-02 14:47:36.066000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 0, 'U',
	 'Created', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a0c32d37-0e91-4778-bc26-29e96e066b86', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.074000', '2024-07-02 14:47:36.074000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 0, 'U',
	 'CreatedBy', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 30, 110, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2e094b40-c8c2-4158-82a7-b73bae3aa84e', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.082000', '2024-07-02 14:47:36.082000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 0, 'U',
	 'Updated', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2cde10cc-6f39-49c3-9af3-c581161dca63', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.090000', '2024-07-02 14:47:36.090000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 0, 'U',
	 'UpdatedBy', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 30, 110, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '61156751-494a-44f3-804e-27803b3f30aa', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.097000', '2024-07-02 14:47:36.097000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 0, 'U', 'IsActive', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b5f25862-5649-4494-a702-b6916ff30d54', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.125000', '2024-07-02 14:47:36.125000', 100, 100, 'OCL Originating Source', NULL,
	 NULL, 0, 'U', 'BH_Ocl_Originating_Source_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 13, NULL, NULL, 10, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '0938647e-8ceb-4023-a023-79d3c4034399'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9fcf1a6a-5907-4b44-b8f3-5074a589db07', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.142000', '2024-07-02 14:47:36.142000', 100, 100, 'BH_Ocl_Originating_Source_UU',
	 NULL, NULL, 0, 'U', 'BH_Ocl_Originating_Source_UU', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = 'a1aca021-f7b4-47ea-a360-685917098058'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '825fe615-979d-4211-8273-e453ae02d982', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.142000', '2024-07-02 14:47:36.142000', 100, 100, 'Concept', NULL, NULL, 0, 'U',
	 'BH_Concept_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = 'f5d356cd-fdb8-4fdd-aea5-2e11726c0141'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '72f58fc9-020d-4d99-8d86-217255e3682d', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-02 14:47:36.142000', '2024-07-02 14:47:36.142000', 100, 100, 'BH Ocl Source', NULL, NULL, 0,
	 'U', 'BH_Ocl_Source', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '66968549-9d1b-4c41-9fe2-17db87eba6d1'
	 ), 17, (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, 10, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '743fb05a-8ed9-4c83-8330-4a3fdbc7b79c'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cc06a7c2-3f5b-4c90-934e-295315131314', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

-- insert sequence
INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((
		 SELECT
			 MAX(ad_sequence_id) + 1
		 FROM
			 ad_sequence
	 ), 0, 0, 'Y', '2024-07-03 14:47:36.104000', 100, '2024-07-03 14:47:36.104000', 100, 'BH_Ocl_Originating_Source',
	 'Table BH_Ocl_Originating_Source', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'ddea728a-73ff-4bbe-8b79-147328642645', 'N', 'N', NULL)
ON CONFLICT DO NOTHING;


/************ BH_Concept ************/
ALTER TABLE BH_Concept
	ADD Ocl_Uuid VARCHAR(100);

-- Add ad_element
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'Ocl_Uuid', 'U', 'Ocl Uuid',
	 'Ocl Uuid', 'A UUID from the OCL system', NULL, NULL, NULL, NULL, NULL, '214c9fb5-bdda-4b3c-a5cc-11b73068702e', NULL)
ON CONFLICT DO NOTHING;

-- Add ad_column
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-03 12:25:39.857000', '2024-07-03 12:25:39.857000', 100, 100, 'Ocl Uuid',
	 'A UUID from the OCL System', NULL, 0, 'U', 'Ocl_Uuid', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '2dcec3ca-58e7-4f5e-86b9-90465b99a581'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '214c9fb5-bdda-4b3c-a5cc-11b73068702e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f13dc5ce-e64a-44ef-a615-bd8ec6374af5', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;


/************ BH_Concept_Mapping ************/
ALTER TABLE BH_Concept_Mapping
	ADD Ocl_Uuid VARCHAR(100);

-- Change the way we link between BH_Concept_Mapping and BH_Concept
ALTER TABLE BH_Concept_Mapping
	DROP CONSTRAINT BHConcept_BHConceptMapping;
ALTER TABLE BH_Concept_Mapping
	DROP CONSTRAINT bhconceptmapping_bhconcept;

ALTER TABLE BH_Concept_Mapping
	ADD To_BH_Concept_ID numeric(10);

ALTER TABLE BH_Concept_Mapping
	ADD CONSTRAINT ToBHConcept_BHConceptMapping
		FOREIGN KEY (To_BH_Concept_ID) REFERENCES bh_concept (bh_concept_id)
			DEFERRABLE INITIALLY DEFERRED;

-- Remove requirement for OCL ID to be unique, as we've learned it ISN'T always unique
ALTER TABLE BH_Concept
	DROP CONSTRAINT bh_concept_bh_oclid_idx;
ALTER TABLE BH_Concept_Mapping
	DROP CONSTRAINT bh_concept_mapping_bh_oclid_idx;

-- Add ad_elements
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'Ocl_Uuid', 'U', 'Ocl Uuid',
	 'Ocl Uuid', 'A UUID from the OCL system', NULL, NULL, NULL, NULL, NULL, '4296ee25-9f66-4bea-8920-63c1fbbf52fc', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'To_BH_Concept_ID', 'U',
	 'To Concept', 'To Concept', NULL, NULL, NULL, NULL, NULL, NULL, '97c85412-b8b8-4b1b-9dac-e59c996137f6', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'From_BH_Concept_ID', 'U',
	 'From Concept', 'From Concept', NULL, NULL, NULL, NULL, NULL, NULL, 'bfa03bcb-03bb-44db-9a72-8185d16a2ac0', NULL)
ON CONFLICT DO NOTHING;

-- Add ad_columns
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-03 12:25:39.857000', '2024-07-03 12:25:39.857000', 100, 100, 'Ocl Uuid',
	 'A UUID from the OCL System', NULL, 0, 'U', 'Ocl_Uuid', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '9cb04da0-d6a6-475a-ad62-c29b77b7c509'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '4296ee25-9f66-4bea-8920-63c1fbbf52fc'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a72072ec-e5a0-4ce8-b553-ef0979328d88', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-03 12:25:39.857000', '2024-07-03 12:25:39.857000', 100, 100, 'To Concept', 'To Concept', NULL,
	 0, 'U', 'To_BH_Concept_ID', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = '9cb04da0-d6a6-475a-ad62-c29b77b7c509'
	 ), 13, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '97c85412-b8b8-4b1b-9dac-e59c996137f6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '54a602a8-bb3c-4a12-8ee7-dd2fd876f332', 'Y', 0, 'N', 'N', NULL,
	 'ToBHConcept_BHConceptMapping', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;


/************ BH_Coded_Diagnosis ************/
ALTER TABLE BH_Coded_Diagnosis
	ADD Ocl_Uuid VARCHAR(100);

-- Add ad_element
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'Ocl_Uuid', 'U', 'Ocl Uuid',
	 'Ocl Uuid', 'A UUID from the OCL system', NULL, NULL, NULL, NULL, NULL, '89e78ec7-9e2b-4b4e-a1a5-63f9d95623af', NULL)
ON CONFLICT DO NOTHING;

-- Add ad_column
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-03 12:25:39.857000', '2024-07-03 12:25:39.857000', 100, 100, 'Ocl Uuid',
	 'A UUID from the OCL System', NULL, 0, 'U', 'Ocl_Uuid', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = 'c70f99ee-42b5-4a38-af7f-9260da3bb47a'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '89e78ec7-9e2b-4b4e-a1a5-63f9d95623af'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2367d716-7f25-4a15-b5d6-ec94267fd640', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;


/************ BH_Concept_Name ************/
ALTER TABLE BH_Concept_Name
	ADD Ocl_Uuid VARCHAR(100);

-- Add ad_element
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(AD_Element_ID) + 1
		 FROM AD_Element
	 ), 0, 0, 'Y', '2024-07-03 12:24:35.533000', 100, '2024-07-03 12:24:35.533000', 100, 'Ocl_Uuid', 'U', 'Ocl Uuid',
	 'Ocl Uuid', 'A UUID from the OCL system', NULL, NULL, NULL, NULL, NULL, '6a9c7c84-5087-4066-962e-73c673586258', NULL)
ON CONFLICT DO NOTHING;

-- Add ad_column
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT MAX(AD_Column_ID) + 1
		 FROM AD_Column
	 ), 0, 0, 'Y', '2024-07-03 12:25:39.857000', '2024-07-03 12:25:39.857000', 100, 100, 'Ocl Uuid',
	 'A UUID from the OCL System', NULL, 0, 'U', 'Ocl_Uuid', (
		 SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU = 'da89d74d-1048-4ece-a893-59df4f335ff6'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU = '6a9c7c84-5087-4066-962e-73c673586258'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2cb57de0-84c7-422e-ba73-423e0fe87af2', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202410031144_GO-2923.sql')
FROM
	dual;
