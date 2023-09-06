/******************************************************************************************/
-- Update clinical to the new DB architecture
-- 1. Create encounter details
-- 2. Create encounter diagnosis details
-- 3. Create observation details
-- 4. Create encounter-type-to-window mapping details
-- 5. Update old DB information to leverage the new architecture
-- 6. Insert sequences for the new tables
-- 7. Migrate historical data to the new
-- 8. Delete the columns from the visit table that aren't there anymore
-- 9. Update procedure that fetches diagnosis information
-- 10. Wrap up
/******************************************************************************************/

/******************************************************************************************/
-- 1. Create encounter details
/******************************************************************************************/
-- Create encounter type reference list
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(AD_Reference_ID) + 1
		 FROM
			 AD_Reference
	 ), 0, 0, 'Y', '2023-07-05 10:09:11.956000', 100, '2023-07-05 10:09:11.956000', 100, 'BH_Encounter_Type', NULL, NULL,
	 'L', NULL, 'U', 'N', 'ced05cde-f4e6-4d72-9134-c16e27eb963f', NULL);

INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(AD_Ref_List_ID) + 1
		 FROM
			 AD_Ref_List
	 ), 0, 0, 'Y', '2023-07-06 12:36:47.115000', 100, '2023-07-06 12:36:47.115000', 100, 'I', 'Immunizations', NULL, (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, NULL, 'U', 'c03f4d1d-fcec-4f91-a673-0ab1c3327578', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(AD_Ref_List_ID) + 1
		 FROM
			 AD_Ref_List
	 ), 0, 0, 'Y', '2023-07-06 12:37:28.131000', 100, '2023-07-06 12:37:28.131000', 100, 'V', 'Capture Vitals', NULL, (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, NULL, 'U', '6b25aa54-bbae-4432-a4e9-7a9a3116fc95', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(AD_Ref_List_ID) + 1
		 FROM
			 AD_Ref_List
	 ), 0, 0, 'Y', '2023-07-06 12:37:37.991000', 100, '2023-07-06 12:37:37.991000', 100, 'm', 'Diagnosis', NULL, (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, NULL, 'U', 'ba49a71c-938a-4e16-9cd9-e0819e4e9d3b', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(AD_Ref_List_ID) + 1
		 FROM
			 AD_Ref_List
	 ), 0, 0, 'Y', '2023-07-21 11:30:16.746000', 100, '2023-07-21 11:30:16.746000', 100, 'D', 'Clinical Details',
	 'clinical details', (
		 SELECT AD_Reference_ID FROM AD_Reference WHERE AD_Reference_UU = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, NULL, 'U', '9bd78d1a-3ec7-46eb-a7b9-58c183b823ae', NULL, NULL);

-- Create encounter table and related data
CREATE TABLE BH_Encounter
(
	AD_Client_ID      NUMERIC(10)                                            NOT NULL,
	AD_Org_ID         NUMERIC(10)                                            NOT NULL,
	BH_Encounter_ID   NUMERIC(10)                                            NOT NULL,
	BH_Encounter_Type VARCHAR(22)                                            NOT NULL,
	BH_Encounter_UU   VARCHAR(36) DEFAULT NULL,
	BH_Visit_ID       NUMERIC(10)                                            NOT NULL,
	CREATED           TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	CreatedBy         NUMERIC(10)                                            NOT NULL,
	IsActive          CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Updated           TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	UpdatedBy         NUMERIC(10)                                            NOT NULL,
	CONSTRAINT BH_Encounter_Key PRIMARY KEY (BH_Encounter_ID),
	CONSTRAINT BH_Encounter_UU_idx UNIQUE (BH_Encounter_UU)
);

ALTER TABLE BH_Encounter
	ADD CONSTRAINT ADClient_BHEncounter FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Encounter
	ADD CONSTRAINT ADOrg_BHEncounter FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT
			 MAX(AD_Table_ID) + 1
		 FROM
			 AD_Table
	 ), 0, 0, 'Y', '2023-07-06 11:57:18.621000', 100, '2023-07-06 11:57:18.621000', 100, 'Encounter', NULL, NULL,
	 'BH_Encounter', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '755aac0f-8697-4520-ba42-08ad092299cd', 'N', 'N', 'N', 'N');

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
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.706000', 100, '2023-07-06 11:58:38.706000', 100, 'BH_Encounter_ID', 'U',
	 'Encounter', 'Encounter', NULL, NULL, NULL, NULL, NULL, NULL, '1471c9f4-6679-4063-b5c6-7aa15553891b', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.819000', 100, '2023-07-06 11:58:38.819000', 100, 'BH_Encounter_UU', 'U',
	 'BH_Encounter_UU', 'BH_Encounter_UU', NULL, NULL, NULL, NULL, NULL, NULL, '82fa0b5d-1751-459c-a94e-ad569d3c4aa9',
	 NULL);

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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.510000', '2023-07-07 10:45:13.602000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '076182c7-bb13-4282-9c99-c4bd6c75251e', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHEncounter', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.704000', '2023-07-06 11:58:38.704000', 100, 100, 'Encounter', NULL, NULL, 1, 'U',
	 'BH_Encounter_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1471c9f4-6679-4063-b5c6-7aa15553891b'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '789d31ed-4461-4500-86c1-5fcad6eb7bb2', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.817000', '2023-07-06 11:58:38.817000', 100, 100, 'BH_Encounter_UU', NULL, NULL, 1,
	 'U', 'BH_Encounter_UU', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '82fa0b5d-1751-459c-a94e-ad569d3c4aa9'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6349b237-f88b-4dcd-b932-02f105097266', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.919000', '2023-07-06 11:58:38.919000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '05066dcf-32b3-49c2-be5f-d202545c56ad', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:39.005000', '2023-07-06 11:58:39.005000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9fad7d82-38ae-4674-9413-842c5b1d435b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:39.137000', '2023-07-06 11:58:39.137000', 100, 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5c9b3348-00fd-4e1d-8301-dc7a2c89a7fe', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:39.228000', '2023-07-06 11:58:39.228000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f7f2e7e7-de4f-4b77-857d-6e9c765c97bb', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:39.265000', '2023-07-06 11:58:39.265000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c368cf6b-6d14-43bd-8f5e-948908081e0f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:02:47.689000', '2023-07-18 13:26:56.045000', 100, 100, 'Encounter Type', NULL, NULL, 0,
	 'U', 'BH_Encounter_Type', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 17, ((
		SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	)
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '140205b3-495c-4f7d-b6ec-1e1707e383a0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3466dd8c-bedc-4c90-9ac9-02528ed1dfbd', 'Y', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:03:47.168000', '2023-07-06 12:03:47.168000', 100, 100, 'Visit', NULL, NULL, 0, 'U',
	 'BH_Visit_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 13, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fa2e7bc6-538b-468e-9c90-f740bbd35c4a', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 11:58:38.644000', '2023-07-07 10:45:13.666000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a2b4fc4e-e503-4396-9baa-612239dffdf0', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHEncounter', 'N', NULL, NULL, 'N');

/******************************************************************************************/
-- 2. Create encounter diagnosis details
/******************************************************************************************/
-- Create encounter diagnosis
CREATE TABLE BH_Encounter_Diagnosis
(
	AD_Client_ID              NUMERIC(10)                                            NOT NULL,
	AD_Org_ID                 NUMERIC(10)                                            NOT NULL,
	BH_Coded_Diagnosis_ID     NUMERIC(10) DEFAULT NULL,
	BH_Encounter_Diagnosis_ID NUMERIC(10)                                            NOT NULL,
	BH_Encounter_Diagnosis_UU VARCHAR(36) DEFAULT NULL,
	BH_Uncoded_Diagnosis      text        DEFAULT NULL,
	CREATED                   TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	CreatedBy                 NUMERIC(10)                                            NOT NULL,
	IsActive                  CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	LineNo                    NUMERIC(10) DEFAULT NULL,
	Updated                   TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	UpdatedBy                 NUMERIC(10)                                            NOT NULL,
	BH_Encounter_ID           NUMERIC(10)                                            NOT NULL,
	CONSTRAINT BH_Encounter_Diagnosis_Key PRIMARY KEY (BH_Encounter_Diagnosis_ID),
	CONSTRAINT BH_Encounter_Diagnosis_UU_idx UNIQUE (BH_Encounter_Diagnosis_UU)
);

ALTER TABLE BH_Encounter_Diagnosis
	ADD CONSTRAINT ADClient_BHEncounterDiagnosis FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Encounter_Diagnosis
	ADD CONSTRAINT ADOrg_BHEncounterDiagnosis FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Encounter_Diagnosis
	ADD CONSTRAINT BHCodedDiagnosis_BHEncounterDi FOREIGN KEY (BH_Coded_Diagnosis_ID) REFERENCES bh_coded_diagnosis (bh_coded_diagnosis_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT
			 MAX(AD_Table_ID) + 1
		 FROM
			 AD_Table
	 ), 0, 0, 'Y', '2023-07-06 17:48:09.395000', 100, '2023-07-06 17:48:09.395000', 100, 'Encounter Diagnosis',
	 'encounter diagnosis', NULL, 'BH_Encounter_Diagnosis', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L',
	 NULL, 'N', 'Y', 'fcc39724-f742-4fe3-b589-587a69c128e4', 'N', 'N', 'N', 'N');

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
	 ), 0, 0, 'Y', '2023-07-06 18:29:19.228000', 100, '2023-07-06 18:29:19.228000', 100, 'BH_Uncoded_Diagnosis', 'U',
	 'Uncoded Diagnosis', 'Uncoded Diagnosis', 'uncoded diagnosis', NULL, NULL, NULL, NULL, NULL,
	 '5e339add-289a-4208-a2b7-ce20145d2676', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.869000', 100, '2023-07-06 17:48:36.869000', 100, 'BH_Encounter_Diagnosis_ID', 'U',
	 'Encounter Diagnosis', 'Encounter Diagnosis', NULL, NULL, NULL, NULL, NULL, NULL,
	 'dea22713-1d2a-44f1-be46-3c071e477500', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.968000', 100, '2023-07-06 17:48:36.968000', 100, 'BH_Encounter_Diagnosis_UU', 'U',
	 'BH_Encounter_Diagnosis_UU', 'BH_Encounter_Diagnosis_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'ea5df9ee-6083-4151-b2ab-e4c94b7af5ae', NULL);

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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.867000', '2023-07-06 17:48:36.867000', 100, 100, 'Encounter Diagnosis', NULL,
	 NULL, 1, 'U', 'BH_Encounter_Diagnosis_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dea22713-1d2a-44f1-be46-3c071e477500'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ea563c8f-80c0-4a81-a1d1-55480618b589', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.967000', '2023-07-06 17:48:36.967000', 100, 100, 'BH_Encounter_Diagnosis_UU',
	 NULL, NULL, 1, 'U', 'BH_Encounter_Diagnosis_UU', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ea5df9ee-6083-4151-b2ab-e4c94b7af5ae'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9701535e-4512-4fe7-ac77-3fd682f731f4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:37.056000', '2023-07-06 17:48:37.056000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '64b24932-b29c-4c6d-a307-73d3ece4d63d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:37.103000', '2023-07-06 17:48:37.103000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1bc9edf4-87da-4c96-aa0d-69a2801490fd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:37.188000', '2023-07-06 17:48:37.188000', 100, 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fbbe0c9b-821e-48b4-9cbe-c5e1f0950e51', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:37.259000', '2023-07-06 17:48:37.259000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f81a933b-b9f3-41ff-86f5-64a605ba7739', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:37.305000', '2023-07-06 17:48:37.305000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a5cb0128-2c8b-4407-bc93-fb1041f70763', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 18:29:40.817000', '2023-07-06 18:29:40.817000', 100, 100, 'Uncoded Diagnosis',
	 'uncoded diagnosis', NULL, 0, 'U', 'BH_Uncoded_Diagnosis', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5e339add-289a-4208-a2b7-ce20145d2676'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '349aa104-069e-468a-9b47-add48dba3e26', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-07 10:26:58.711000', '2023-07-07 10:26:58.711000', 100, 100, 'Line', 'Line No', NULL, 0, 'U',
	 'LineNo', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 11, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6c565f5a-1e75-4e53-98c3-593da1b95ce2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'addc4186-dfdd-49d0-8ab1-2f67aa603d4e', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.726000', '2023-07-11 09:43:02.724000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '27bb3239-f237-4cf6-9f0e-1ebe62c4168e', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHEncounterDiagnosis', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:48:36.833000', '2023-07-11 09:43:02.795000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9afd8201-d781-40b4-a474-356b97fe5515', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHEncounterDiagnosis', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 17:49:27.451000', '2023-07-11 09:43:02.859000', 100, 100, 'Coded Diagnosis', NULL, NULL, 0,
	 'U', 'BH_Coded_Diagnosis_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '56eea80e-d85d-41b3-8121-55ad5f62bad4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '65218da9-6835-4cda-a2d8-f275b313b1c4', 'Y', 0, 'N', 'N', NULL,
	 'BHCodedDiagnosis_BHEncounterDi', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-13 13:02:46.606000', '2023-07-13 13:02:46.607000', 100, 100, 'Encounter', NULL, NULL, 0, 'U',
	 'BH_Encounter_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE ad_table_uu = 'fcc39724-f742-4fe3-b589-587a69c128e4'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1471c9f4-6679-4063-b5c6-7aa15553891b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd4e8a380-4f18-4fcd-a9ac-53f63be918d3', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');

/******************************************************************************************/
-- 3. Create observation details
/******************************************************************************************/
-- create observation table.
CREATE TABLE BH_Observation
(
	AD_Client_ID      NUMERIC(10)                                            NOT NULL,
	AD_Field_ID       NUMERIC(10)                                            NOT NULL,
	AD_Org_ID         NUMERIC(10)                                            NOT NULL,
	BH_Encounter_ID   NUMERIC(10)                                            NOT NULL,
	BH_Observation_ID NUMERIC(10)                                            NOT NULL,
	BH_Observation_UU VARCHAR(36) DEFAULT NULL,
	CREATED           TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	CreatedBy         NUMERIC(10)                                            NOT NULL,
	IsActive          CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Updated           TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	UpdatedBy         NUMERIC(10)                                            NOT NULL,
	BH_Value          text                                                   NOT NULL,
	CONSTRAINT BH_Observation_Key PRIMARY KEY (BH_Observation_ID),
	CONSTRAINT BH_Observation_UU_idx UNIQUE (BH_Observation_UU)
);

ALTER TABLE BH_Observation
	ADD CONSTRAINT ADClient_BHObservation FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Observation
	ADD CONSTRAINT ADField_BHObservation FOREIGN KEY (AD_Field_ID) REFERENCES ad_field (ad_field_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Observation
	ADD CONSTRAINT ADOrg_BHObservation FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Observation
	ADD CONSTRAINT BHEncounter_BHObservation FOREIGN KEY (BH_Encounter_ID) REFERENCES bh_encounter (bh_encounter_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT
			 MAX(AD_Table_ID) + 1
		 FROM
			 AD_Table
	 ), 0, 0, 'Y', '2023-07-06 12:06:49.447000', 100, '2023-07-06 12:06:49.447000', 100, 'Observation', 'Observation',
	 NULL, 'BH_Observation', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'a9673172-25a0-496f-a40f-e53550e2de24', 'N', 'N', 'N', 'N');

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
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.266000', 100, '2023-07-06 12:07:13.266000', 100, 'BH_Observation_UU', 'U',
	 'BH_Observation_UU', 'BH_Observation_UU', NULL, NULL, NULL, NULL, NULL, NULL, '86d49904-6629-4efc-8b5d-69dc0d53db0c',
	 NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.218000', 100, '2023-07-06 12:07:13.218000', 100, 'BH_Observation_ID', 'U',
	 'Observation', 'Observation', NULL, NULL, NULL, NULL, NULL, NULL, '1a75bef1-b239-4f08-baaa-3c8f5bd1da9b', NULL);
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
	 ), 0, 0, 'Y', '2023-08-22 08:42:10.020000', 100, '2023-08-22 09:27:43.702000', 100, 'BH_Value', 'U', 'BH_Value',
	 'BH_Value', 'BH_Value', NULL, NULL, NULL, NULL, NULL, '7ef17536-61e1-4421-9e75-e3732e604dd2', NULL);

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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.137000', '2023-07-11 10:24:50.819000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4d8b4396-f935-4609-bda0-4e2bb94df7f9', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHObservation', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.172000', '2023-07-11 10:24:50.923000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c993a38e-8561-4c8a-b840-cdda53051291', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHObservation', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.217000', '2023-07-06 12:07:13.217000', 100, 100, 'Observation', NULL, NULL, 1,
	 'U', 'BH_Observation_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1a75bef1-b239-4f08-baaa-3c8f5bd1da9b'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd8055fc9-7e72-4e96-afff-76c572f9476a', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.265000', '2023-07-06 12:07:13.265000', 100, 100, 'BH_Observation_UU', NULL, NULL,
	 1, 'U', 'BH_Observation_UU', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '86d49904-6629-4efc-8b5d-69dc0d53db0c'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '18f53549-cd16-4b98-b69b-89c937b21d39', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.366000', '2023-07-06 12:07:13.366000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1ec28741-f346-494d-b769-1efc531f956f', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.417000', '2023-07-06 12:07:13.417000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4bc2f467-1e71-4c42-97a3-4a6c20a954dd', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.509000', '2023-07-06 12:07:13.509000', 100, 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '28b211a2-61f9-4e14-8f81-d6144df20613', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.581000', '2023-07-06 12:07:13.581000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'aa385297-3eb5-4ba4-9456-eebff389cfe4', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:07:13.632000', '2023-07-06 12:07:13.632000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cb3ecf9c-11d8-4ffc-a19e-0ecb503248ee', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:16:49.441000', '2023-07-11 10:24:51.005000', 100, 100, 'Encounter', NULL, NULL, 0, 'U',
	 'BH_Encounter_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1471c9f4-6679-4063-b5c6-7aa15553891b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c4c984e2-47d8-4a24-afcb-48f4539c6e47', 'Y', 0, 'N', 'N', NULL,
	 'BHEncounter_BHObservation', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:17:53.993000', '2023-07-11 10:24:50.872000', 100, 100, 'Field',
	 'Field on a database table', 'The Field identifies a field on a database table.', 0, 'U', 'AD_Field_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 19, NULL, 52005, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 107, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '32af31b7-dfe1-42f8-b346-c8720d87853a', 'Y', 0, 'N', 'N', NULL,
	 'ADField_BHObservation', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-06 12:26:09.267000', '2023-08-22 08:49:48.699000', 100, 100, 'BH_Value', 'BH_Value', NULL, 0,
	 'U', 'BH_Value', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'a9673172-25a0-496f-a40f-e53550e2de24'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7ef17536-61e1-4421-9e75-e3732e604dd2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8ebdaf96-dd00-454c-b5d0-37b58280ca76', 'Y', 10, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N');

/******************************************************************************************/
-- 4. Create encounter-type-to-window mapping details
/******************************************************************************************/
-- Create Encounter Type and Window Mapping Table
CREATE TABLE BH_Encounter_Type_Window
(
	AD_Client_ID                NUMERIC(10)                                            NOT NULL,
	AD_Org_ID                   NUMERIC(10)                                            NOT NULL,
	AD_Window_ID                NUMERIC(10)                                            NOT NULL,
	BH_Encounter_Type           VARCHAR(22)                                            NOT NULL,
	BH_Encounter_Type_Window_UU VARCHAR(36) DEFAULT NULL,
	CREATED                     TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	CreatedBy                   NUMERIC(10)                                            NOT NULL,
	IsActive                    CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Updated                     TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	UpdatedBy                   NUMERIC(10)                                            NOT NULL,
	CONSTRAINT BH_Encounter_Type_Window_M_Key PRIMARY KEY (AD_Window_ID, BH_Encounter_Type)
);

ALTER TABLE BH_Encounter_Type_Window
	ADD CONSTRAINT ADClient_BHEncounterTypeWindow FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Encounter_Type_Window
	ADD CONSTRAINT ADOrg_BHEncounterTypeWindowMap FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Encounter_Type_Window
	ADD CONSTRAINT ADWindow_BHEncounterTypeWindow FOREIGN KEY (AD_Window_ID) REFERENCES ad_window (ad_window_id) DEFERRABLE INITIALLY DEFERRED;

INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT
			 MAX(ad_table_id) + 1
		 FROM
			 ad_table
	 ), 0, 0, 'Y', '2023-07-17 11:35:20.175000', 100, '2023-07-17 13:37:12.809000', 100, 'Encounter Type Window Mapping',
	 'Maps encounter type and window', NULL, 'BH_Encounter_Type_Window', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N',
	 'Y', 'L', NULL, 'N', 'Y', 'be236c71-35e6-4995-a4c3-8bc258d62bab', 'N', 'N', 'N', 'N');

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
	 ), 0, 0, 'Y', '2023-07-06 12:02:17.231000', 100, '2023-07-18 11:21:29.898000', 100, 'BH_Encounter_Type', 'U',
	 'Encounter Type', 'Encounter Type', NULL, NULL, NULL, NULL, NULL, NULL, '140205b3-495c-4f7d-b6ec-1e1707e383a0',
	 NULL);
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
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.364000', 100, '2023-07-21 10:30:01.000000', 100, 'BH_Encounter_Type_Window_UU',
	 'U', 'BH_Encounter_Type_Window_UU', 'BH_Encounter_Type_Window_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'c86595c2-f27e-4633-af6a-c52908a248b8', NULL);

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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.047000', '2023-07-17 13:38:16.629000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4523f5c6-6997-4acb-a3be-9a908abfe081', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHEncounterTypeWindow', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.160000', '2023-07-17 13:38:16.701000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '544439e9-f188-43b0-920c-fd5f4be76e91', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHEncounterTypeWindowMap', 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.362000', '2023-07-17 11:36:19.362000', 100, 100, 'BH_Encounter_Type_Window_UU',
	 NULL, NULL, 1, 'U', 'BH_Encounter_Type_Window_UU', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c86595c2-f27e-4633-af6a-c52908a248b8'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '431d299e-4b9b-4a90-abbd-61aa4170512c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.571000', '2023-07-17 11:36:19.571000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '179af869-dc36-45bb-be69-d4042ec2bff1', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.651000', '2023-07-17 11:36:19.651000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 18, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '492b95c1-f66c-4234-ba62-d2842e118123', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.804000', '2023-07-17 11:36:19.804000', 100, 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1bafb115-cbf1-40ff-ac65-1d89adda2b38', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:19.947000', '2023-07-17 11:36:19.947000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fcdbd6c3-d9f7-481f-95b3-38d354d219d4', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:36:20.014000', '2023-07-17 11:36:20.014000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 18, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2ea49de4-fdfe-4725-957c-5fc84ba3e004', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:37:29.778000', '2023-07-18 11:32:42.442000', 100, 100, 'Encounter Type', NULL, NULL, 0,
	 'U', 'BH_Encounter_Type', (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '140205b3-495c-4f7d-b6ec-1e1707e383a0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7cbc8eec-f8ba-4532-ac24-06dde60c76df', 'Y', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N');
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-07-17 11:37:51.100000', '2023-07-17 13:57:10.689000', 100, 100, 'Window',
	 'Data entry or display window', 'The Window field identifies a unique Window in the system.', 0, 'U', 'AD_Window_ID',
	 (
		 SELECT ad_table_id FROM AD_Table WHERE AD_Table_UU = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), 18, 284, NULL, 22, NULL, 'Y', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 143, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2a30994f-7159-4802-be91-cdd770b991df', 'Y', 0, 'N', 'N', NULL,
	 'ADWindow_BHEncounterTypeWindow', 'N', NULL, NULL, 'N');

-- create encounter type and window mapping window
INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight,
	           winwidth, isbetafunctionality, ad_window_uu, titlelogic)
VALUES
	((
		 SELECT
			 MAX(AD_Window_ID) + 1
		 FROM
			 AD_Window
	 ), 0, 0, 'Y', '2023-07-17 11:52:38.934000', 100, '2023-07-17 11:52:38.934000', 100,
	 'Encounter Type and Window Mapping', NULL, NULL, 'M', 'N', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N',
	 'cc4d214d-b454-44c5-b50c-cae6ef8107d1', NULL);

INSERT INTO
	ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help,
	        ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly,
	        ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id,
	        importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id,
	        readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id,
	        treedisplayedon, maxqueryrecords)
VALUES
	((
		 SELECT
			 MAX(AD_Tab_ID) + 1
		 FROM
			 AD_Tab
	 ), 0, 0, 'Y', '2023-07-17 11:54:47.848000', 100, '2023-07-17 11:54:47.848000', 100,
	 'Encounter Type and Window Mapping', NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'be236c71-35e6-4995-a4c3-8bc258d62bab'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'cc4d214d-b454-44c5-b50c-cae6ef8107d1'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, 'a7f8eba1-b4ef-4467-a6fb-3c2930461214', NULL, 'B', 0);

INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-17 11:56:05.874000', 100, '2023-07-17 11:56:05.874000', 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'a7f8eba1-b4ef-4467-a6fb-3c2930461214'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4523f5c6-6997-4acb-a3be-9a908abfe081'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '664d9252-a309-4ea0-b86c-bc27b7d2bf68', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-17 11:56:05.936000', 100, '2023-07-17 11:56:05.936000', 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'a7f8eba1-b4ef-4467-a6fb-3c2930461214'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '544439e9-f188-43b0-920c-fd5f4be76e91'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '59cb1477-1688-4c12-b7c7-108cea575735', 'Y', 10, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-17 11:56:06.158000', 100, '2023-07-17 11:56:06.158000', 100, 'Encounter Type', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'a7f8eba1-b4ef-4467-a6fb-3c2930461214'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '7cbc8eec-f8ba-4532-ac24-06dde60c76df'
	 ), NULL, 'Y', NULL, 10, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '73fd8b9c-eb84-4475-a284-4c234a248d0b', NULL, 40, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-17 11:56:06.211000', 100, '2023-07-17 11:56:06.211000', 100, 'Window',
	 'Data entry or display window', 'The Window field identifies a unique Window in the system.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'a7f8eba1-b4ef-4467-a6fb-3c2930461214'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2a30994f-7159-4802-be91-cdd770b991df'
	 ), NULL, 'Y', NULL, 22, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9e1784d1-fe57-4860-83a9-d05f509d6ef3', NULL, 50, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-17 11:56:06.262000', 100, '2023-07-17 11:56:06.262000', 100, 'Active',
	 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'a7f8eba1-b4ef-4467-a6fb-3c2930461214'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1bafb115-cbf1-40ff-ac65-1d89adda2b38'
	 ), NULL, 'Y', NULL, 1, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'f4c8668f-874c-47d7-a070-eefdbe0c240f', NULL, 60, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');

-- insert into encounter type window table
-- Capture Vitals
INSERT INTO
	bh_encounter_type_window (ad_client_id, ad_org_id, ad_window_id, bh_encounter_type_window_uu, created, createdby,
	                          isactive, updated, updatedby, bh_encounter_type)
VALUES
	(0, 0, (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '53b4d743-c311-40e5-aa8e-c0880c42c1b1'
	), 'cf6781bd-5ed0-4cd1-9bbf-97758f40c83b', '2023-07-21 11:17:57.302000', 100, 'Y',
	 '2023-07-21 11:17:57.302000', 100, 'V');
-- Capture Details
INSERT INTO
	bh_encounter_type_window (ad_client_id, ad_org_id, ad_window_id, bh_encounter_type_window_uu, created, createdby,
	                          isactive, updated, updatedby, bh_encounter_type)
VALUES
	(0, 0, (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	), '2f613d49-d52b-4672-87ed-a30ef9f16c89', '2023-07-21 11:43:43.122000', 100, 'Y', '2023-07-21 11:43:43.122000', 100,
	 'D');

/******************************************************************************************/
-- 5. Update old DB information to leverage the new architecture
/******************************************************************************************/
-- Update clinical details window to use bh_visit window
UPDATE ad_tab
SET
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	)
WHERE
	ad_tab_uu = '69b0d4b6-a323-4224-924e-d9d3d2aa5e1b';
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 15:47:56.697000', 100, '2023-07-19 15:47:56.697000', 100, 'Clinical Notes', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '69b0d4b6-a323-4224-924e-d9d3d2aa5e1b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9bcfded3-3af9-41d3-94ae-319d1859bb30'
	 ), NULL, 'Y', NULL, 0, 'N', 10, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '1b28d618-0529-4680-bfe2-2fcb5025fecd', NULL, 10, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, 'History:   Physical Exam:   Treatment: ', 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 15:48:33.235000', 100, '2023-07-19 15:48:38.610000', 100, 'Lab / Imaging Notes', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '69b0d4b6-a323-4224-924e-d9d3d2aa5e1b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '345d1405-6bfe-4cb9-9ece-f60477f46a08'
	 ), NULL, 'Y', NULL, 0, 'N', 20, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '4c4e87c6-e453-470b-87bd-a0c4c6a83438', NULL, 20, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');

-- Update clinical vitals window to use bh_visit window
UPDATE ad_tab
SET
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	)
WHERE
	ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7';

INSERT INTO
	ad_fieldgroup (ad_fieldgroup_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	               entitytype, fieldgrouptype, iscollapsedbydefault, ad_fieldgroup_uu)
VALUES
	((
		 SELECT
			 MAX(ad_fieldgroup_id) + 1
		 FROM
			 ad_fieldgroup
	 ), 0, 0, 'Y', '2023-07-19 14:38:31.913000', 100, '2023-07-19 14:38:31.913000', 100, 'Blood Pressure (mmHg)', 'U',
	 NULL, 'N', '5fa688fd-0075-494f-b880-d9c9ebca60d7');

-- Insert the observation field table record to migrate the new observations columns to
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable)
VALUES
	((
		 SELECT
			 MAX(ad_table_id) + 1
		 FROM
			 ad_table
	 ), 0, 0, 'Y', '2023-09-01 09:22:36.217000', 100, '2023-09-01 09:22:36.217000', 100, 'Observation Field',
	 'This holds the fields tied to the observations, though no matching table exists in the DB for this.', NULL,
	 'BH_Observation_Field', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'f472818e-6071-4dcf-b705-4020ad79c154', 'N', 'N', 'N', 'N');

-- Update the old visit columns (that are now observations) to point to the observation field table
UPDATE ad_column
SET
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f472818e-6071-4dcf-b705-4020ad79c154'
	)
WHERE
		ad_column_uu IN ('9e76e902-13ed-44ac-9957-38748277d20e', '8dc7142c-10da-4499-b4bb-877fab7c716c',
		                 '345d1405-6bfe-4cb9-9ece-f60477f46a08', '03301cba-14d8-4c1b-8a91-5f566a9f9d2c',
		                 '4a54eba3-5712-44cc-bb3c-be8e4d618e69', '9aa46e92-7db9-432d-a6e2-6074294ee431',
		                 'abf8f199-df91-4e86-9aea-1be26988985f', '58e4d45d-bf24-4225-bf33-8f63d3a00f9b',
		                 '9bcfded3-3af9-41d3-94ae-319d1859bb30', 'c39eb4d2-92e2-4edb-af60-e909cca39ff3',
		                 'c1a0c77f-ee6d-413b-957f-a97d927bac8d');

-- Update element names
UPDATE ad_element
SET
	name      = 'Height (cm)',
	printname = 'Height (cm)'
WHERE
	AD_Element_UU = 'a4fc780f-3dc3-4b0c-bb4a-26eea119ff55';
UPDATE ad_element_trl
SET
	name      = 'Taille (cm)',
	printname = 'Taille (cm)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = 'a4fc780f-3dc3-4b0c-bb4a-26eea119ff55'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'Weight (kg)',
	printname = 'Weight (kg)'
WHERE
	AD_Element_UU = '5818719f-2ca4-4204-bb6d-48e27426a30b';
UPDATE ad_element_trl
SET
	name      = 'Poids (kg)',
	printname = 'Poids (kg)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '5818719f-2ca4-4204-bb6d-48e27426a30b'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'Temperature (°C)',
	printname = 'Temperature (°C)'
WHERE
	AD_Element_UU = '836e0d1f-b921-4582-8681-a17db1ad19d5';
UPDATE ad_element_trl
SET
	name      = 'Température (°C)',
	printname = 'Température (°C)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '836e0d1f-b921-4582-8681-a17db1ad19d5'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'Blood Pressure (mmHg)',
	printname = 'Blood Pressure (mmHg)'
WHERE
	AD_Element_UU = 'fd932aa2-1856-448c-8d13-e2caa4cc9a18';
UPDATE ad_element_trl
SET
	name      = 'Tension artérielle (mmHg)',
	printname = 'Tension artérielle (mmHg)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = 'fd932aa2-1856-448c-8d13-e2caa4cc9a18'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'Pulse (BPM)',
	printname = 'Pulse (BPM)'
WHERE
	AD_Element_UU = '6be46897-4408-4080-afe5-4bdcf199b12e';
UPDATE ad_element_trl
SET
	name      = 'Pouls (BPM)',
	printname = 'Pouls (BPM)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '6be46897-4408-4080-afe5-4bdcf199b12e'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'Respiratory Rate (RPM)',
	printname = 'Respiratory Rate (RPM)'
WHERE
	AD_Element_UU = '46dd8a18-ede7-462d-8f30-85eb56c628f4';
UPDATE ad_element_trl
SET
	name      = 'Fréquence respiratoire (RPM)',
	printname = 'Fréquence respiratoire (RPM)'
WHERE
		ad_client_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '46dd8a18-ede7-462d-8f30-85eb56c628f4'
	)
	AND ad_language = 'fr_FR';
UPDATE ad_element
SET
	name      = 'SPO² (%)',
	printname = 'SPO² (%)'
WHERE
	AD_Element_UU = '8011a89c-8f43-4552-babf-7e77507d71ab';
UPDATE ad_element
SET
	name      = 'Chief Complaint',
	printname = 'Chief Complaint'
WHERE
	AD_Element_UU = 'f9e23d7e-abd1-44b4-a83e-8311c25b8f82';
UPDATE ad_element
SET
	name      = 'Lab / Imaging Notes',
	printname = 'Lab / Imaging Notes'
WHERE
	AD_Element_UU = 'bf639c29-b21a-4db0-890e-eff72fabc076';

INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:16:49.635000', 100, '2023-07-19 14:18:21.517000', 100, 'Height (cm)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '03301cba-14d8-4c1b-8a91-5f566a9f9d2c'
	 ), NULL, 'Y', NULL, 0, 'N', 10, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '2842fb94-b841-4973-903e-89c7f24455b2', NULL, 10, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:17:09.348000', 100, '2023-07-19 14:18:00.481000', 100, 'Weight (kg)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c1a0c77f-ee6d-413b-957f-a97d927bac8d'
	 ), NULL, 'Y', NULL, 0, 'N', 20, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e0f68d60-0610-4caa-9dc3-b0143101ccd3', NULL, 20, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:18:44.811000', 100, '2023-07-19 14:18:47.993000', 100, 'Temperature (°C)', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'abf8f199-df91-4e86-9aea-1be26988985f'
	 ), NULL, 'Y', NULL, 0, 'N', 30, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'd3dc091f-ee3d-4607-91d1-4e766cfe5528', NULL, 30, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:38:44.087000', 100, '2023-07-19 14:39:02.941000', 100, 'Blood Pressure (mmHg)', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9e76e902-13ed-44ac-9957-38748277d20e'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '5fa688fd-0075-494f-b880-d9c9ebca60d7'
	 ), 'Y', NULL, 0, 'N', 40, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'cd376ad7-d03b-4970-ab2b-34ef000b93f9', NULL, 40, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'Y', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:39:53.507000', 100, '2023-07-19 14:40:53.512000', 100, 'Blood Pressure (mmHg)', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9aa46e92-7db9-432d-a6e2-6074294ee431'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '5fa688fd-0075-494f-b880-d9c9ebca60d7'
	 ), 'Y', NULL, 0, 'N', 50, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '769b6475-1e35-4618-ad36-09fa0111affb', NULL, 50, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 14:43:22.100000', 100, '2023-07-19 14:43:28.448000', 100, 'Pulse (BPM)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4a54eba3-5712-44cc-bb3c-be8e4d618e69'
	 ), NULL, 'Y', NULL, 0, 'N', 60, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'c0f0f904-4977-4360-8065-a0e91d4f3a71', NULL, 60, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 15:09:37.177000', 100, '2023-07-19 15:09:51.895000', 100, 'Respiratory Rate (RPM)', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c39eb4d2-92e2-4edb-af60-e909cca39ff3'
	 ), NULL, 'Y', NULL, 0, 'N', 70, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '87183dfb-1b7d-4c18-b350-593e576bb49b', NULL, 70, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 15:10:19.717000', 100, '2023-07-19 15:10:26.657000', 100, 'SPO² (%)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8dc7142c-10da-4499-b4bb-877fab7c716c'
	 ), NULL, 'Y', NULL, 0, 'N', 80, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '7bb73318-f6cc-4540-85d7-69672a18cc5f', NULL, 80, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform)
VALUES
	((
		 SELECT
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-07-19 15:10:49.269000', 100, '2023-07-19 15:10:56.318000', 100, 'Chief Complaint', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '58e4d45d-bf24-4225-bf33-8f63d3a00f9b'
	 ), NULL, 'Y', NULL, 0, 'N', 90, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e1d01fe4-16b6-4125-a385-34cf4531c06f', NULL, 90, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');

/******************************************************************************************/
-- 6. Insert sequences for the new tables
/******************************************************************************************/
-- insert sequences
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
	 ), 0, 0, 'Y', '2023-07-21 10:27:32.674000', 100, '2023-07-21 10:27:32.674000', 100, 'BH_Encounter_Type_Window',
	 'Table BH_Encounter_Type_Window', NULL, 'Y', 1, 1000000, 1000008, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'ef0fc0a6-c1ce-4ac2-8006-cafed46a9feb', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 17:48:09.477000', 100, '2023-07-06 17:48:09.477000', 100, 'BH_Encounter_Diagnosis',
	 'Table BH_Encounter_Diagnosis', NULL, 'Y', 1, 1000000, 1000001, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '51b6285c-f095-4d9a-b580-90497c8d1f05', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 12:06:49.525000', 100, '2023-07-06 12:06:49.525000', 100, 'BH_Observation',
	 'Table BH_Observation', NULL, 'Y', 1, 1000000, 1000001, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'b0a81f59-a535-4c37-8805-6b297ce43d2c', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-07-06 11:57:18.724000', 100, '2023-07-06 11:57:18.724000', 100, 'BH_Encounter',
	 'Table BH_Encounter', NULL, 'Y', 1, 1000000, 1000001, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'cdba6e99-1da2-4eb3-ae07-be21415f5bf3', 'N', 'N', NULL);

/******************************************************************************************/
-- 7. Migrate historical data to the new
/******************************************************************************************/
-- Insert encounters for any visits with measurements on it
CREATE TEMP TABLE tmp_bh_encounter
(
	ad_client_id      numeric(10) NOT NULL,
	ad_org_id         numeric(10) NOT NULL,
	bh_encounter_id   serial      NOT NULL,
	bh_encounter_type varchar(22) NOT NULL,
	bh_encounter_uu   uuid                 DEFAULT uuid_generate_v4(),
	bh_visit_id       numeric(10) NOT NULL,
-- 	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10) NOT NULL DEFAULT 100,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10) NOT NULL DEFAULT 100
);
SELECT
	SETVAL('tmp_bh_encounter_bh_encounter_id_seq', (
		SELECT
			currentnext
		FROM
			ad_sequence
		WHERE
			name = 'BH_Encounter'
		LIMIT 1
	)::INT, FALSE);

-- Insert the vitals into our temp table
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id)
SELECT
	ad_client_id,
	ad_org_id,
	'V', -- Capture Vitals
	bh_visit_id
FROM
	bh_visit
WHERE
	bh_height IS NOT NULL
	OR bh_weight IS NOT NULL
	OR bh_temperature IS NOT NULL
	OR bh_systolic_blood_pressure IS NOT NULL
	OR bh_diastolic_blood_pressure IS NOT NULL
	OR bh_pulse IS NOT NULL
	OR bh_respiratoryrate IS NOT NULL
	OR bh_oxygensaturation IS NOT NULL
	OR bh_chiefcomplaint IS NOT NULL;
-- Insert the details into our temp table
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id)
SELECT
	ad_client_id,
	ad_org_id,
	'D', -- Clinical Details
	bh_visit_id
FROM
	bh_visit
WHERE
	bh_clinicalnotes IS NOT NULL
	OR bh_labnotes IS NOT NULL
	OR bh_primarycodeddiagnosis_id IS NOT NULL
	OR bh_primaryuncodeddiagnosis IS NOT NULL
	OR bh_secondarycodeddiagnosis_id IS NOT NULL
	OR bh_secondaryuncodeddiagnosis IS NOT NULL;

-- Insert the encounters into the real table
INSERT INTO
	bh_encounter (AD_Client_ID, AD_Org_ID, BH_Encounter_ID, BH_Encounter_Type, BH_Visit_ID, CreatedBy, UpdatedBy,
	              bh_encounter_uu)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	BH_Encounter_ID,
	BH_Encounter_Type,
	BH_Visit_ID,
	CreatedBy,
	UpdatedBy,
	bh_encounter_uu
FROM
	tmp_bh_encounter;

-- Add diagnoses
CREATE TABLE tmp_bh_encounter_diagnosis
(
	ad_client_id              NUMERIC(10)             NOT NULL,
	ad_org_id                 NUMERIC(10)             NOT NULL,
	bh_coded_diagnosis_id     NUMERIC(10) DEFAULT NULL,
	bh_encounter_diagnosis_id serial                  NOT NULL,
	bh_encounter_diagnosis_uu uuid        DEFAULT uuid_generate_v4(),
	bh_uncoded_diagnosis      text        DEFAULT NULL,
-- 	created                   TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	createdby                 NUMERIC(10) DEFAULT 100 NOT NULL,
-- 	isactive                  CHAR(1)     DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	lineno                    NUMERIC(10) DEFAULT NULL,
-- 	updated                   TIMESTAMP   DEFAULT NOW()                              NOT NULL,
	updatedby                 NUMERIC(10) DEFAULT 100 NOT NULL,
	bh_encounter_id           NUMERIC(10)             NOT NULL
);
SELECT
	SETVAL('tmp_bh_encounter_diagnosis_bh_encounter_diagnosis_id_seq', (
		SELECT
			currentnext
		FROM
			ad_sequence
		WHERE
			name = 'BH_Encounter_Diagnosis'
		LIMIT 1
	)::INT, FALSE);

-- Insert the primary diagnoses into our temp table
INSERT INTO
	tmp_bh_encounter_diagnosis (ad_client_id, ad_org_id, bh_encounter_id, bh_coded_diagnosis_id, bh_uncoded_diagnosis,
	                            lineno)
SELECT
	v.ad_client_id,
	v.ad_org_id,
	e.bh_encounter_id,
	v.bh_primarycodeddiagnosis_id,
	v.bh_primaryuncodeddiagnosis::text,
	10
FROM
	bh_visit v
		JOIN
		tmp_bh_encounter e
			ON e.bh_visit_id = v.bh_visit_id AND e.bh_encounter_type = 'D'
WHERE
	v.bh_primarycodeddiagnosis_id IS NOT NULL
	OR v.bh_primaryuncodeddiagnosis IS NOT NULL;

-- Insert the secondary diagnoses into our temp table
INSERT INTO
	tmp_bh_encounter_diagnosis (ad_client_id, ad_org_id, bh_encounter_id, bh_coded_diagnosis_id, bh_uncoded_diagnosis,
	                            lineno)
SELECT
	v.ad_client_id,
	v.ad_org_id,
	e.bh_encounter_id,
	v.bh_secondarycodeddiagnosis_id,
	v.bh_secondaryuncodeddiagnosis::text,
	20
FROM
	bh_visit v
		JOIN
		tmp_bh_encounter e
			ON e.bh_visit_id = v.bh_visit_id AND e.bh_encounter_type = 'D'
WHERE
	v.bh_secondarycodeddiagnosis_id IS NOT NULL
	OR v.bh_secondaryuncodeddiagnosis IS NOT NULL;

-- Insert the diagnoses into our real table
INSERT INTO
	bh_encounter_diagnosis (AD_Client_ID, AD_Org_ID, BH_Coded_Diagnosis_ID, BH_Encounter_Diagnosis_ID,
	                        BH_Encounter_Diagnosis_UU, BH_Uncoded_Diagnosis, CreatedBy, LineNo, UpdatedBy,
	                        BH_Encounter_ID)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	BH_Coded_Diagnosis_ID,
	BH_Encounter_Diagnosis_ID,
	BH_Encounter_Diagnosis_UU,
	BH_Uncoded_Diagnosis,
	CreatedBy,
	LineNo,
	UpdatedBy,
	BH_Encounter_ID
FROM
	tmp_bh_encounter_diagnosis;

-- Add observations
CREATE TEMP TABLE tmp_bh_observation
(
	ad_client_id      numeric(10)             NOT NULL,
	ad_field_id       numeric(10) DEFAULT NULL::numeric,
	ad_org_id         numeric(10)             NOT NULL,
	bh_encounter_id   numeric(10)             NOT NULL,
	bh_observation_id serial                  NOT NULL,
	bh_observation_uu uuid        DEFAULT uuid_generate_v4(),
-- 	created           timestamp    DEFAULT NOW()       NOT NULL,
	createdby         numeric(10) DEFAULT 100 NOT NULL,
-- 	isactive          char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	updated           timestamp    DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10) DEFAULT 100 NOT NULL,
	bh_value          text                    NOT NULL
);
SELECT
	SETVAL('tmp_bh_observation_bh_observation_id_seq', (
		SELECT
			currentnext
		FROM
			ad_sequence
		WHERE
			name = 'BH_Observation'
		LIMIT 1
	)::INT, FALSE);

-- Insert the observations values into our temp table
INSERT
INTO
	tmp_bh_observation (ad_client_id, ad_field_id, ad_org_id, bh_encounter_id, bh_value)
SELECT
	ad_client_id,
	ad_field_id,
	ad_org_id,
	bh_encounter_id,
	bh_value
FROM
	tmp_bh_encounter e
		JOIN (
		SELECT
			v.bh_visit_id,
			v.bh_height::text AS bh_value,
			f.ad_field_id,
			'V'               AS bh_encounter_type
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_height IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
					ad_column_uu = '03301cba-14d8-4c1b-8a91-5f566a9f9d2c'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_weight::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_weight IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c1a0c77f-ee6d-413b-957f-a97d927bac8d'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_temperature::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_temperature IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'abf8f199-df91-4e86-9aea-1be26988985f'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_systolic_blood_pressure::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_systolic_blood_pressure IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9aa46e92-7db9-432d-a6e2-6074294ee431'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_diastolic_blood_pressure::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_diastolic_blood_pressure IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9e76e902-13ed-44ac-9957-38748277d20e'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_pulse::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_pulse IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4a54eba3-5712-44cc-bb3c-be8e4d618e69'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_respiratoryrate::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_respiratoryrate IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c39eb4d2-92e2-4edb-af60-e909cca39ff3'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_oxygensaturation::text,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_oxygensaturation IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8dc7142c-10da-4499-b4bb-877fab7c716c'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_chiefcomplaint,
			f.ad_field_id,
			'V'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_chiefcomplaint IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '58e4d45d-bf24-4225-bf33-8f63d3a00f9b'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_clinicalnotes,
			f.ad_field_id,
			'D'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_clinicalnotes IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9bcfded3-3af9-41d3-94ae-319d1859bb30'
			)
		UNION ALL
		SELECT
			v.bh_visit_id,
			v.bh_labnotes,
			f.ad_field_id,
			'D'
		FROM
			ad_field f
				JOIN bh_visit v
				ON v.bh_labnotes IS NOT NULL
		WHERE
				ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '345d1405-6bfe-4cb9-9ece-f60477f46a08'
			)
	) AS fo
		ON fo.bh_visit_id = e.bh_visit_id AND fo.bh_encounter_type = e.bh_encounter_type;

-- Insert the real observations
INSERT INTO
	bh_observation (AD_Client_ID, AD_Field_ID, AD_Org_ID, BH_Encounter_ID, BH_Observation_ID, BH_Observation_UU,
	                CreatedBy, UpdatedBy, BH_Value)
SELECT
	AD_Client_ID,
	AD_Field_ID,
	AD_Org_ID,
	BH_Encounter_ID,
	BH_Observation_ID,
	BH_Observation_UU,
	CreatedBy,
	UpdatedBy,
	BH_Value
FROM
	tmp_bh_observation;

/******************************************************************************************/
-- 8. Delete the columns from the visit table that aren't there anymore
/******************************************************************************************/
ALTER TABLE bh_visit
	DROP COLUMN bh_diastolic_blood_pressure;
ALTER TABLE bh_visit
	DROP COLUMN BH_OxygenSaturation;
ALTER TABLE bh_visit
	DROP COLUMN BH_LabNotes;
ALTER TABLE bh_visit
	DROP COLUMN BH_BloodPressure;
ALTER TABLE bh_visit
	DROP COLUMN BH_Height;
ALTER TABLE bh_visit
	DROP COLUMN BH_ClinicalNotes;
ALTER TABLE bh_visit
	DROP COLUMN BH_Pulse;
ALTER TABLE bh_visit
	DROP COLUMN BH_RespiratoryRate;
ALTER TABLE bh_visit
	DROP COLUMN bh_systolic_blood_pressure;
ALTER TABLE bh_visit
	DROP COLUMN BH_Weight;
ALTER TABLE bh_visit
	DROP COLUMN BH_Temperature;
ALTER TABLE bh_visit
	DROP COLUMN BH_ChiefComplaint;
ALTER TABLE bh_visit
	DROP COLUMN BH_PrimaryCodedDiagnosis_ID;
ALTER TABLE bh_visit
	DROP COLUMN bh_primaryuncodeddiagnosis;
ALTER TABLE bh_visit
	DROP COLUMN bh_secondarycodeddiagnosis_ID;
ALTER TABLE bh_visit
	DROP COLUMN bh_secondaryuncodeddiagnosis;

DELETE
FROM
	ad_field
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_column_uu IN ('f9556ee9-de59-453f-a45c-f076f4543bf3', 'e99b4f41-ad71-4bab-adf1-12650990cebe',
				                 'bd8eeac9-7940-48c6-9b39-724b607f5275', '6a74fa3f-f605-4922-91bb-48cbabe73840',
				                 '0cfe2ac9-cd64-492d-966d-373d0cccf018')
	);

DELETE
FROM
	ad_column
WHERE
		ad_column_uu IN ('f9556ee9-de59-453f-a45c-f076f4543bf3', 'e99b4f41-ad71-4bab-adf1-12650990cebe',
		                 'bd8eeac9-7940-48c6-9b39-724b607f5275', '6a74fa3f-f605-4922-91bb-48cbabe73840',
		                 '0cfe2ac9-cd64-492d-966d-373d0cccf018');

DELETE
FROM
	ad_element
WHERE
		ad_element_uu IN ('a93d401a-dbf0-4f1b-a967-c8f7d4f1f79d', '2c1d012e-c038-4b87-90f8-a408fc501dbb',
		                  '80d9a9f5-f266-47ec-bb64-6aab3611fa91', 'fc9336f9-82f5-4719-90ab-68243a2583b0',
		                  '0cfe2ac9-cd64-492d-966d-373d0cccf018');

/******************************************************************************************/
-- 9. Update procedure that fetches diagnosis information
/******************************************************************************************/
DROP FUNCTION IF EXISTS bh_get_visit_details(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_details(ad_client_id numeric,
                                     begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                     end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id                   numeric,
		        bh_visitdate                  timestamptz,
		        c_order_id                    numeric,
		        c_order_uu                    character varying,
		        ad_org_id                     numeric,
		        receipt_number                numeric,
		        ad_user_id                    numeric,
		        cashier_name                  character varying,
		        createdby_user_uu             character varying,
		        c_bpartner_id                 numeric,
		        patient_name                  character varying,
		        bh_patienttype                character varying,
		        bh_patienttype_name           character varying,
		        bh_patientid                  character varying,
		        bh_birthday                   timestamp WITHOUT TIME ZONE,
		        bh_gender                     character varying,
		        bh_phone                      character varying,
		        bh_primarycodeddiagnosis_id   numeric,
		        bh_secondarycodeddiagnosis_id numeric,
		        bh_primaryuncodeddiagnosis    character varying,
		        bh_secondaryuncodeddiagnosis  character varying,
		        docstatus                     character,
		        bh_clinician_user_id          numeric,
		        processing                    character,
		        saleslineitemtotals           numeric,
		        salestotals                   numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	v.bh_visit_id,
	v.bh_visitdate                                   AS visit_date,
	o.c_order_id,
	o.c_order_uu,
	v.ad_org_id,
	o.c_order_id                                     AS receipt_number,
	createdby_user.ad_user_id                        AS cashier_id,
	createdby_user.name                              AS cashier_name,
	createdby_user.ad_user_uu                        AS createdby_user_uu,
	v.patient_id                                     AS patient_id,
	bp.name                                          AS patient_name,
	v.bh_patienttype                                 AS patient_type,
	rl.name                                          AS bh_patienttype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	primary_diagnosis.bh_coded_diagnosis_id          AS primary_coded,
	secondary_diagnosis.bh_coded_diagnosis_id        AS secondary_coded,
	primary_diagnosis.bh_uncoded_diagnosis           AS primary_uncoded,
	secondary_diagnosis.bh_uncoded_diagnosis         AS secondary_uncoded,
	o.docstatus                                      AS docstatus,
	v.bh_clinician_user_id                           AS clinician_id,
	o.processing                                     AS processing,
	saleslineitemtotals,
	salestotals
FROM
	bh_visit v
		JOIN c_order o
		ON v.bh_visit_id = o.bh_visit_id
		JOIN c_bpartner bp
		ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user createdby_user
		ON v.createdby = createdby_user.ad_user_id
		JOIN ad_ref_list rl
		ON rl.value = v.bh_patienttype
		JOIN ad_reference r
		ON rl.ad_reference_id = r.ad_reference_id
		LEFT JOIN (
		SELECT
			v.bh_visit_id,
			ev.bh_coded_diagnosis_id,
			ev.bh_uncoded_diagnosis
		FROM
			bh_visit v
				JOIN bh_encounter e
				ON v.bh_visit_id = e.bh_visit_id
				LEFT JOIN bh_encounter_diagnosis ev
				ON e.bh_encounter_id = ev.bh_encounter_id AND lineno = 10
		LIMIT 1
	) primary_diagnosis
		ON v.bh_visit_id = primary_diagnosis.bh_visit_id
		LEFT JOIN (
		SELECT
			v.bh_visit_id,
			ev.bh_coded_diagnosis_id,
			ev.bh_uncoded_diagnosis
		FROM
			bh_visit v
				JOIN bh_encounter e
				ON v.bh_visit_id = e.bh_visit_id
				LEFT JOIN bh_encounter_diagnosis ev
				ON e.bh_encounter_id = ev.bh_encounter_id AND lineno = 20
		LIMIT 1
	) secondary_diagnosis
		ON v.bh_visit_id = secondary_diagnosis.bh_visit_id
		JOIN (
		SELECT
			o.c_order_id,
			COALESCE(SUM(ol.linenetamt) FILTER ( WHERE ol.c_charge_id IS NULL ), 0) AS saleslineitemtotals,
			COALESCE(SUM(ol.linenetamt), 0)                                         AS salestotals
		FROM
			c_order o
				JOIN c_orderline ol
				ON o.c_order_id = ol.c_order_id
				JOIN bh_visit v
				ON o.bh_visit_id = v.bh_visit_id
		WHERE
			o.ad_client_id = $1
			AND v.bh_visitdate BETWEEN $2 AND $3
		GROUP BY o.c_order_id
	) sales_details
		ON o.c_order_id = sales_details.c_order_id
WHERE
	v.bh_visitdate BETWEEN $2 AND $3
	AND v.ad_client_id = $1
	AND ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7';
$$;

/******************************************************************************************/
-- 10. Wrap up
/******************************************************************************************/
-- Since we were inserting a lot of new data, update the sequences
SELECT
	update_sequences();

SELECT
	register_migration_script('202308311144_GO-2747.sql')
FROM
	dual;
