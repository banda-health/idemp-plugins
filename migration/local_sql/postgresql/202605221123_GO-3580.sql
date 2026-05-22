-- Feature flag catalog and targeting rules (see FeatureFlagUtil for evaluation logic).
-- BH_SystemAdmin: when Y on a rule, that rule only applies to system administrator users; when N, all users may match.
CREATE TABLE BH_Feature_Flag
(
	AD_Client_ID       NUMERIC(10) NOT NULL,
	AD_Org_ID          NUMERIC(10) NOT NULL,
	BH_DefaultEnabled  CHAR(1)     NOT NULL CHECK (BH_DefaultEnabled IN ('Y', 'N')) DEFAULT 'N',
	BH_Feature_Flag_ID NUMERIC(10) NOT NULL,
	BH_Feature_Flag_UU VARCHAR(36)                                                  DEFAULT NULL,
	BH_FlagType        TEXT                                                         DEFAULT 'release',
	Created            TIMESTAMP   NOT NULL                                         DEFAULT getDate(),
	CreatedBy          NUMERIC(10) NOT NULL,
	Description        VARCHAR(255)                                                 DEFAULT NULL,
	IsActive           CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))          DEFAULT 'Y',
	Name               TEXT        NOT NULL,
	Updated            TIMESTAMP   NOT NULL                                         DEFAULT getDate(),
	UpdatedBy          NUMERIC(10) NOT NULL,
	CONSTRAINT BH_Feature_Flag_Key PRIMARY KEY (BH_Feature_Flag_ID),
	CONSTRAINT BH_Feature_Flag_UU_idx UNIQUE (BH_Feature_Flag_UU),
	CONSTRAINT BH_Feature_Flag_Name_idx UNIQUE (Name)
);
ALTER TABLE BH_Feature_Flag
	ADD CONSTRAINT ADClient_BHFeatureFlag FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag
	ADD CONSTRAINT ADOrg_BHFeatureFlag FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE BH_Feature_Flag_Rule
(
	AD_Client_ID            NUMERIC(10) NOT NULL,
	AD_Org_ID               NUMERIC(10) NOT NULL,
	BH_Environment          CHAR(1)                                                 DEFAULT NULL,
	BH_Feature_Flag_ID      NUMERIC(10) NOT NULL,
	BH_Feature_Flag_Rule_ID NUMERIC(10) NOT NULL,
	BH_Feature_Flag_Rule_UU VARCHAR(36)                                             DEFAULT NULL,
	BH_IsEnabled            CHAR(1)     NOT NULL CHECK (BH_IsEnabled IN ('Y', 'N')) DEFAULT 'N',
	BH_Rule_Client_ID       NUMERIC(10)                                             DEFAULT NULL,
	BH_Rule_Org_ID          NUMERIC(10)                                             DEFAULT NULL,
	BH_Rule_Role_ID         NUMERIC(10)                                             DEFAULT NULL,
	BH_Rule_User_ID         NUMERIC(10)                                             DEFAULT NULL,
	BH_SystemAdmin          CHAR(1)     NOT NULL CHECK (BH_SystemAdmin IN ('Y', 'N')) DEFAULT 'N',
	Created                 TIMESTAMP   NOT NULL                                    DEFAULT getDate(),
	CreatedBy               NUMERIC(10) NOT NULL,
	Description             VARCHAR(255)                                            DEFAULT NULL,
	IsActive                CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))     DEFAULT 'Y',
	Name                    VARCHAR(60) NOT NULL,
	SeqNo                   NUMERIC(10) NOT NULL                                    DEFAULT 0,
	Updated                 TIMESTAMP   NOT NULL                                    DEFAULT getDate(),
	UpdatedBy               NUMERIC(10) NOT NULL,
	ValidFrom               TIMESTAMP                                               DEFAULT NULL,
	ValidTo                 TIMESTAMP                                               DEFAULT NULL,
	CONSTRAINT BH_Feature_Flag_Rule_Key PRIMARY KEY (BH_Feature_Flag_Rule_ID),
	CONSTRAINT BH_Feature_Flag_Rule_UU_idx UNIQUE (BH_Feature_Flag_Rule_UU)
);
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT ADClient_BHFeatureFlagRule FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT ADOrg_BHFeatureFlagRule FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT BHFeatureFlag_BHFeatureFlagRule FOREIGN KEY (BH_Feature_Flag_ID) REFERENCES bh_feature_flag (bh_feature_flag_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT BHRuleClient_BHFeatureFlagRule FOREIGN KEY (BH_Rule_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT BHRuleOrg_BHFeatureFlagRule FOREIGN KEY (BH_Rule_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT BHRuleRole_BHFeatureFlagRule FOREIGN KEY (BH_Rule_Role_ID) REFERENCES ad_role (ad_role_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Feature_Flag_Rule
	ADD CONSTRAINT BHRuleUser_BHFeatureFlagRule FOREIGN KEY (BH_Rule_User_ID) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;

-- Insert the elements
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.166000', 100, '2026-05-21 16:25:01.166000', 100, 'BH_Feature_Flag_ID', 'U',
	 'Feature Flag', 'Feature Flag', NULL, NULL, NULL, NULL, NULL, NULL, '5d0e383a-b007-43a0-8ccc-981fe1e6e4c0', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.230000', 100, '2026-05-21 16:25:01.230000', 100, 'BH_Feature_Flag_UU', 'U',
	 'BH_Feature_Flag_UU', 'BH_Feature_Flag_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '1ff3f9eb-29a4-4738-9ab8-fe6c5a571827', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:25:26.716000', 100, '2026-05-21 16:25:26.716000', 100, 'BH_DefaultEnabled', 'U',
	 'Default Enabled', 'Default Enabled', NULL, NULL, NULL, NULL, NULL, NULL, '087f0b65-42d9-4065-9f86-39c839fa08fd',
	 NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:27:11.597000', 100, '2026-05-21 16:27:11.597000', 100, 'BH_FlagType', 'U', 'Flag Type',
	 'Flag Type', NULL, NULL, NULL, NULL, NULL, NULL, 'e2d8fddd-17ba-4a32-ac82-5f11f5dad33c', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.476000', 100, '2026-05-21 16:29:53.476000', 100, 'BH_Feature_Flag_Rule_ID', 'U',
	 'Feature Flag Rule', 'Feature Flag Rule', NULL, NULL, NULL, NULL, NULL, NULL, '49c3357b-58c5-42ec-9be1-8a844416ba6b',
	 NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.529000', 100, '2026-05-21 16:29:53.529000', 100, 'BH_Feature_Flag_Rule_UU', 'U',
	 'BH_Feature_Flag_Rule_UU', 'BH_Feature_Flag_Rule_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '2401290f-58f8-4fa9-aa85-5a0c00a1cdf1', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:30:41.109000', 100, '2026-05-21 16:30:41.109000', 100, 'BH_Rule_Client_ID', 'U',
	 'Client', 'Client', NULL, NULL, NULL, NULL, NULL, NULL, '2e889bc4-6a97-4add-9488-8b19e301c1b1', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:31:31.047000', 100, '2026-05-21 16:31:31.047000', 100, 'BH_Rule_Org_ID', 'U', 'Org',
	 'Org', NULL, NULL, NULL, NULL, NULL, NULL, 'fef360ee-d353-43d5-a5e7-78580ce154e0', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:32:14.562000', 100, '2026-05-21 16:32:14.562000', 100, 'BH_Rule_Role_ID', 'U', 'Role',
	 'Role', NULL, NULL, NULL, NULL, NULL, NULL, '83f1b703-eb85-4878-8c9c-2a46035f1842', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:32:43.492000', 100, '2026-05-21 16:32:43.492000', 100, 'BH_Rule_User_ID', 'U', 'User',
	 'User', NULL, NULL, NULL, NULL, NULL, NULL, '2db17400-c4a9-4829-b716-a4304443aa8f', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:33:31.363000', 100, '2026-05-21 16:33:31.363000', 100, 'BH_Environment', 'U',
	 'Environment', 'Environment', NULL, NULL, NULL, NULL, NULL, NULL, 'ec987465-2778-4182-ad8c-9aa2b198854e', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:36:25.371000', 100, '2026-05-21 16:36:25.371000', 100, 'BH_IsEnabled', 'U',
	 'Is Enabled', 'Is Enabled', NULL, NULL, NULL, NULL, NULL, NULL, '7861d8dc-bdf0-4b95-8b12-6bfb55dc7409', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-05-21 16:36:25.371000', 100, '2026-05-21 16:36:25.371000', 100, 'BH_SystemAdmin', 'U',
	 'System Admin', 'System Admin',
	 'When enabled, this rule only applies to system administrator users', NULL, NULL, NULL, NULL, NULL, NULL,
	 'c4d8f1e2-6a3b-4c5d-9e0f-1a2b3c4d5e6f', NULL);

-- Insert the tables
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT MAX(ad_table_id) + 1
		 FROM ad_table
	 ), 0, 0, 'Y', '2026-05-21 16:24:51.052000', 100, '2026-05-21 16:24:51.052000', 100, 'Feature Flag', NULL, NULL,
	 'BH_Feature_Flag', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '40106da4-cc26-457e-87c3-c0d5fc65af9e', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT MAX(ad_table_id) + 1
		 FROM ad_table
	 ), 0, 0, 'Y', '2026-05-21 16:29:46.297000', 100, '2026-05-21 16:29:46.297000', 100, 'Feature Flag Rule', NULL, NULL,
	 'BH_Feature_Flag_Rule', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '853c931e-1b31-46b9-a283-211b0cc91a36', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.153000', '2026-05-21 16:25:01.153000', 100, 100, 'Feature Flag', NULL, NULL, 1,
	 'U', 'BH_Feature_Flag_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5d0e383a-b007-43a0-8ccc-981fe1e6e4c0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '73db25f4-aa8f-46aa-9776-064a1df431c5', 'N', NULL, 'N', 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.212000', '2026-05-21 16:25:01.212000', 100, 100, 'BH_Feature_Flag_UU', NULL, NULL,
	 1, 'U', 'BH_Feature_Flag_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1ff3f9eb-29a4-4738-9ab8-fe6c5a571827'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5f43db9e-aa28-4e1f-a669-eca81cb89f04', 'N', NULL, 'N', 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.259000', '2026-05-21 16:25:01.259000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '143fe38a-2e34-4daa-883c-ae1402ea80d0', 'N', NULL, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.293000', '2026-05-21 16:25:01.293000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '04728176-3b88-4e79-85bb-61a0cdb1c0c5', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.333000', '2026-05-21 16:25:01.333000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 275, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9c6f2f90-719c-4d78-aab1-7b5a7393a38e', 'Y', 10, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.373000', '2026-05-21 16:25:01.373000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0e6e4cf9-0a94-4fda-a83c-2912bb0d130c', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.419000', '2026-05-21 16:25:01.419000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7d363292-8445-4f91-8031-c504f32ed3e8', 'N', NULL, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.440000', '2026-05-21 16:25:01.440000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '69234b19-055d-4169-8688-ae29d69e541a', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:48.925000', '2026-05-21 16:25:48.925000', 100, 100, 'Default Enabled', NULL, NULL, 0,
	 'U', 'BH_DefaultEnabled', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '087f0b65-42d9-4065-9f86-39c839fa08fd'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '585050c9-21ec-40d1-ae95-f03f003ebcb5', 'Y', 0, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.400000', '2026-05-21 16:26:41.647000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 469, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd2d6fbc3-7eea-4895-b387-44e94770c45c', 'Y', 20, 'N', 'N', NULL, NULL, NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:27:35.408000', '2026-05-21 16:27:35.408000', 100, 100, 'Flag Type', NULL, NULL, 0, 'U',
	 'BH_FlagType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 36, NULL, NULL, 0, 'release', 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e2d8fddd-17ba-4a32-ac82-5f11f5dad33c'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'eb3e81d3-b595-4801-8051-cb42fcc6163b', 'Y', 0, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.082000', '2026-05-21 16:27:45.333000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5060122f-3fa7-496a-bf91-eb3cb337e5da', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHFeatureFlag', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:25:01.127000', '2026-05-21 16:27:45.346000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7d658f01-5ad1-48a6-94d8-0af2a4da9cad', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHFeatureFlag', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.457000', '2026-05-21 16:29:53.457000', 100, 100, 'Feature Flag Rule', NULL, NULL,
	 1, 'U', 'BH_Feature_Flag_Rule_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '49c3357b-58c5-42ec-9be1-8a844416ba6b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd1b69bd8-f498-468e-a80a-896b3a9c279f', 'N', NULL, 'N', 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.512000', '2026-05-21 16:29:53.512000', 100, 100, 'BH_Feature_Flag_Rule_UU', NULL,
	 NULL, 1, 'U', 'BH_Feature_Flag_Rule_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2401290f-58f8-4fa9-aa85-5a0c00a1cdf1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f7039831-6426-44ad-9af5-0ab87c8ea08a', 'N', NULL, 'N', 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.565000', '2026-05-21 16:29:53.565000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '291f02c3-4af5-4f43-aebe-2d14baa6e014', 'N', NULL, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.595000', '2026-05-21 16:29:53.595000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8829fff2-982e-42a8-94bd-7c8e6d163e62', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.629000', '2026-05-21 16:29:53.629000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 275, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b286092f-f6ae-40d5-911a-e04c02c95211', 'Y', 10, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.667000', '2026-05-21 16:29:53.667000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4a306cba-aea5-440a-9bc0-899a3f88c392', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.705000', '2026-05-21 16:29:53.705000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 469, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7cf4da4c-a58b-43f8-87ab-1b7543d0bd99', 'Y', 20, 'N', 'N', NULL, NULL, 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.744000', '2026-05-21 16:29:53.744000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2ed1f094-edea-4097-9228-e23b791f8d33', 'N', NULL, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.773000', '2026-05-21 16:29:53.773000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '47a3ea29-a9ef-47b0-a193-aff838ad768a', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:35:16.529000', '2026-05-21 16:35:16.529000', 100, 100, 'Environment', NULL, NULL, 0,
	 'U', 'BH_Environment', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 17, 374, NULL, 1, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ec987465-2778-4182-ad8c-9aa2b198854e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'bceb8487-3345-4c17-b31b-bbb73ed46a23', 'Y', 0, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:37:03.150000', '2026-05-21 16:37:03.150000', 100, 100, 'Sequence',
	 'Method of ordering records; lowest number comes first', 'The Sequence indicates the order of records', 0, 'U',
	 'SeqNo', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 11, NULL, NULL, 22, '0', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 566, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '103cdcdd-0739-4dd0-9fe0-e87477c9fe68', 'Y', 0, 'N', 'N', NULL, NULL, 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:37:20.792000', '2026-05-21 16:37:20.792000', 100, 100, 'Valid to',
	 'Valid to including this date (last day)', 'The Valid To date indicates the last day of a date range', 0, 'U',
	 'ValidTo', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 15, NULL, NULL, 7, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 618, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f8c0df88-e40d-496d-8fd1-01fe349db52b', 'Y', 0, 'N', 'N', NULL, NULL, 'N',
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.396000', '2026-05-21 16:37:37.888000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5c6c941e-bdaa-4e8e-bc5a-0526ee9ec04e', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:29:53.425000', '2026-05-21 16:37:37.900000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd12defc7-0c6c-4e3a-8db4-7f904acdfc34', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:36:06.787000', '2026-05-21 16:37:37.915000', 100, 100, 'Feature Flag', NULL, NULL, 0,
	 'U', 'BH_Feature_Flag_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5d0e383a-b007-43a0-8ccc-981fe1e6e4c0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2f559ed0-fef4-4046-ada4-638f6a8bd3f4', 'Y', 0, 'N', 'N', NULL,
	 'BHFeatureFlag_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:31:15.552000', '2026-05-21 16:37:37.935000', 100, 100, 'Client', NULL, NULL, 0, 'U',
	 'BH_Rule_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 200144, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2e889bc4-6a97-4add-9488-8b19e301c1b1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd6124c2e-3bdc-4c51-a23e-61f8af11b300', 'Y', 0, 'N', 'N', NULL,
	 'BHRuleClient_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:32:00.593000', '2026-05-21 16:37:37.966000', 100, 100, 'Org', NULL, NULL, 0, 'U',
	 'BH_Rule_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 276, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fef360ee-d353-43d5-a5e7-78580ce154e0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ab4f4d41-14ba-4052-a2c9-12cc8038870c', 'Y', 0, 'N', 'N', NULL,
	 'BHRuleOrg_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:32:34.156000', '2026-05-21 16:37:37.991000', 100, 100, 'Role', NULL, NULL, 0, 'U',
	 'BH_Rule_Role_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 53317, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '83f1b703-eb85-4878-8c9c-2a46035f1842'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3f54a94b-5b76-4927-860b-c569665f88ad', 'Y', 0, 'N', 'N', NULL,
	 'BHRuleRole_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:33:05.055000', '2026-05-21 16:37:38.022000', 100, 100, 'User', NULL, NULL, 0, 'U',
	 'BH_Rule_User_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 30, 200145, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2db17400-c4a9-4829-b716-a4304443aa8f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '570f9c91-e5ff-4628-9818-c88016637f57', 'Y', 0, 'N', 'N', NULL,
	 'BHRuleUser_BHFeatureFlagRule', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:36:39.770000', '2026-05-21 16:36:39.770000', 100, 100, 'Is Enabled', NULL, NULL, 0, 'U',
	 'BH_IsEnabled', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7861d8dc-bdf0-4b95-8b12-6bfb55dc7409'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '82ca636c-9670-40ac-b0ff-f356bc7cb241', 'Y', 0, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:36:39.770000', '2026-05-21 16:36:39.770000', 100, 100, 'System Admin',
	 'When enabled, this rule only applies to system administrator users', NULL, 0, 'U', 'BH_SystemAdmin', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c4d8f1e2-6a3b-4c5d-9e0f-1a2b3c4d5e6f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd7e8f9a0-1b2c-4d3e-8f9a-0b1c2d3e4f5a', 'Y', 0, 'N', 'N', NULL,
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-05-21 16:37:14.319000', '2026-05-21 16:37:14.319000', 100, 100, 'Valid from',
	 'Valid from including this date (first day)', 'The Valid From date indicates the first day of a date range', 0, 'U',
	 'ValidFrom', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), 15, NULL, NULL, 7, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 617, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f7fba631-dab3-4257-b1f0-eefe99b8f565', 'Y', 0, 'N', 'N', NULL, NULL, 'N',
	 NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Window, Tabs, and Fields
INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight,
	           winwidth, isbetafunctionality, ad_window_uu, titlelogic, predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_window_id) + 1
		 FROM ad_window
	 ), 0, 0, 'Y', '2026-05-21 16:39:59.359000', 100, '2026-05-21 16:39:59.359000', 100, 'Feature Flags', NULL, NULL, 'M',
	 'Y', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N', '87393f5b-a5a1-404e-9392-97b763a45303', NULL, NULL);
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
		 SELECT MAX(ad_tab_id) + 1
		 FROM ad_tab
	 ), 0, 0, 'Y', '2026-05-21 16:40:18.512000', 100, '2026-05-21 16:40:18.512000', 100, 'Flag', NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '40106da4-cc26-457e-87c3-c0d5fc65af9e'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '87393f5b-a5a1-404e-9392-97b763a45303'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, 'd30fea2f-a293-46bc-baf8-7a02b8676ebb', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);
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
		 SELECT MAX(ad_tab_id) + 1
		 FROM ad_tab
	 ), 0, 0, 'Y', '2026-05-21 16:42:57.521000', 100, '2026-05-21 16:42:57.521000', 100, 'Rule', NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '853c931e-1b31-46b9-a283-211b0cc91a36'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '87393f5b-a5a1-404e-9392-97b763a45303'
	 ), 20, 1, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '7ce5f8f8-f446-441c-a7f8-f03d12651e4d', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.627000', 100, '2026-05-21 16:40:21.627000', 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '5060122f-3fa7-496a-bf91-eb3cb337e5da'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'f60d1aea-f96a-4c6b-a223-4ebdf7e0bf6c', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.650000', 100, '2026-05-21 16:40:21.650000', 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '7d658f01-5ad1-48a6-94d8-0af2a4da9cad'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'a724048d-e8c0-4944-9992-039715af296e', 'Y', NULL, 'N', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.699000', 100, '2026-05-21 16:40:21.699000', 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9c6f2f90-719c-4d78-aab1-7b5a7393a38e'
	 ), NULL, 'Y', NULL, 255, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9403858e-5936-46fe-8121-5f78525adaeb', NULL, 20, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.743000', 100, '2026-05-21 16:41:03.255000', 100, 'BH_Feature_Flag_UU', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '5f43db9e-aa28-4e1f-a669-eca81cb89f04'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'cbc25ad8-0d2c-443e-a914-e6999a3c853b', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.790000', 100, '2026-05-21 16:41:03.244000', 100, 'Flag Type', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'eb3e81d3-b595-4801-8051-cb42fcc6163b'
	 ), NULL, 'Y', NULL, 0, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '6de6b5e7-35ca-422f-8eec-924b6d794e62', NULL, 40, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.813000', 100, '2026-05-21 16:40:21.813000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0e6e4cf9-0a94-4fda-a83c-2912bb0d130c'
	 ), NULL, 'Y', NULL, 1, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '3843540f-0bcb-4528-b3f6-0e52911ef5a6', NULL, 50, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.676000', 100, '2026-05-21 16:41:03.235000', 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd2d6fbc3-7eea-4895-b387-44e94770c45c'
	 ), NULL, 'Y', NULL, 0, 'N', 30, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'b641be77-2787-4a7e-9259-84ce8f8e5728', NULL, 10, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.770000', 100, '2026-05-21 16:41:03.250000', 100, 'Default Enabled', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '585050c9-21ec-40d1-ae95-f03f003ebcb5'
	 ), NULL, 'Y', NULL, 1, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '82fc13c0-a6f2-4b1d-8d54-7364cc93ca61', NULL, 30, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:40:21.719000', 100, '2026-05-21 16:41:03.259000', 100, 'Feature Flag', NULL, NULL, 'Y',
	 (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'd30fea2f-a293-46bc-baf8-7a02b8676ebb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '73db25f4-aa8f-46aa-9776-064a1df431c5'
	 ), NULL, 'N', NULL, 22, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'b64571a9-a395-4ebd-8da7-ca05f355c042', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.705000', 100, '2026-05-21 16:43:00.705000', 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '5c6c941e-bdaa-4e8e-bc5a-0526ee9ec04e'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '8cf53653-2875-4fb5-aab2-ee0306d5d5d2', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.753000', 100, '2026-05-21 16:43:00.753000', 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd12defc7-0c6c-4e3a-8db4-7f904acdfc34'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'a441ccde-27bf-400b-9cd1-367f7dd9b6a0', 'Y', NULL, 'N', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.768000', 100, '2026-05-21 16:43:00.768000', 100, 'Feature Flag', NULL, NULL, 'Y',
	 (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2f559ed0-fef4-4046-ada4-638f6a8bd3f4'
	 ), NULL, 'Y', NULL, 22, 'N', 30, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'bf3de004-5cdf-4f16-866a-ce8754c5c33a', NULL, 10, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.790000', 100, '2026-05-21 16:43:00.790000', 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '7cf4da4c-a58b-43f8-87ab-1b7543d0bd99'
	 ), NULL, 'Y', NULL, 60, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'd87282a8-73e6-4587-a506-f3130bfe475c', NULL, 20, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.812000', 100, '2026-05-21 16:43:00.812000', 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'b286092f-f6ae-40d5-911a-e04c02c95211'
	 ), NULL, 'Y', NULL, 255, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '203c1211-0269-4051-90fc-7fd48eabee01', NULL, 30, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.901000', 100, '2026-05-21 16:44:07.018000', 100, 'Role', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '3f54a94b-5b76-4927-860b-c569665f88ad'
	 ), NULL, 'Y', NULL, 10, 'N', 130, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '4deab24c-9a53-4005-9c3c-8a060aecef98', NULL, 60, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.928000', 100, '2026-05-21 16:44:07.022000', 100, 'User', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '570f9c91-e5ff-4628-9818-c88016637f57'
	 ), NULL, 'Y', NULL, 10, 'N', 140, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'b6b89748-7740-4e19-ba06-457bfe16fc22', NULL, 70, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.942000', 100, '2026-05-21 16:43:00.942000', 100, 'Environment', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'bceb8487-3345-4c17-b31b-bbb73ed46a23'
	 ), NULL, 'Y', NULL, 1, 'N', 100, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'd4d0c0e4-1b0a-4e35-b095-e1653de13ac9', NULL, 80, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:01.009000', 100, '2026-05-21 16:44:07.006000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4a306cba-aea5-440a-9bc0-899a3f88c392'
	 ), NULL, 'Y', NULL, 1, 'N', 80, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'eb890b2d-674b-4383-ac5d-85774e3321cc', NULL, 130, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.981000', 100, '2026-05-21 16:44:06.996000', 100, 'Valid from',
	 'Valid from including this date (first day)', 'The Valid From date indicates the first day of a date range', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f7fba631-dab3-4257-b1f0-eefe99b8f565'
	 ), NULL, 'Y', NULL, 7, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '732553a8-11ee-497e-b46c-e8d8bef499e9', NULL, 110, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.994000', 100, '2026-05-21 16:44:07.002000', 100, 'Valid to',
	 'Valid to including this date (last day)', 'The Valid To date indicates the last day of a date range', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f8c0df88-e40d-496d-8fd1-01fe349db52b'
	 ), NULL, 'Y', NULL, 7, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '96d819fd-7804-4673-8fe7-d8ed3b7bf7c6', NULL, 120, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.956000', 100, '2026-05-21 16:44:07.010000', 100, 'Is Enabled', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '82ca636c-9670-40ac-b0ff-f356bc7cb241'
	 ), NULL, 'Y', NULL, 1, 'N', 90, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '3f90521c-80c7-4586-b53b-aee608e315a4', NULL, 90, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.956000', 100, '2026-05-21 16:44:07.010000', 100, 'System Admin',
	 'When enabled, this rule only applies to system administrator users', NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd7e8f9a0-1b2c-4d3e-8f9a-0b1c2d3e4f5a'
	 ), NULL, 'Y', NULL, 1, 'N', 95, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e8f9a0b1-2c3d-4e5f-9a0b-1c2d3e4f5a6b', NULL, 95, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.866000', 100, '2026-05-21 16:44:07.012000', 100, 'Client', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd6124c2e-3bdc-4c51-a23e-61f8af11b300'
	 ), NULL, 'Y', NULL, 10, 'N', 110, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '10c4ddae-0327-4b76-9a47-59c0e4f51c4e', NULL, 40, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.878000', 100, '2026-05-21 16:44:07.015000', 100, 'Org', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ab4f4d41-14ba-4052-a2c9-12cc8038870c'
	 ), NULL, 'Y', NULL, 10, 'N', 120, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '7ebe38a3-35d5-40c1-9547-6423ac9b0a54', NULL, 50, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.968000', 100, '2026-05-21 16:44:07.025000', 100, 'Sequence',
	 'Method of ordering records; lowest number comes first', 'The Sequence indicates the order of records', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '103cdcdd-0739-4dd0-9fe0-e87477c9fe68'
	 ), NULL, 'Y', NULL, 22, 'N', 150, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '3576a686-79e7-4206-8702-86f7f3d67455', NULL, 100, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.849000', 100, '2026-05-21 16:44:07.028000', 100, 'BH_Feature_Flag_Rule_UU', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f7039831-6426-44ad-9af5-0ab87c8ea08a'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e0675973-d109-47ff-a2d8-52f58a3db4b8', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2026-05-21 16:43:00.833000', 100, '2026-05-21 16:44:07.030000', 100, 'Feature Flag Rule', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '7ce5f8f8-f446-441c-a7f8-f03d12651e4d'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd1b69bd8-f498-468e-a80a-896b3a9c279f'
	 ), NULL, 'N', NULL, 22, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '77a60e06-84a6-497c-840c-f756d4419d3b', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Menus
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_menu_id) + 1
		 FROM ad_menu
	 ), 0, 0, 'Y', '2026-05-21 16:44:33.822000', 100, '2026-05-21 16:44:33.822000', 'Feature Flags', 100, NULL, 'N', 'Y',
	 'N', 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '87393f5b-a5a1-404e-9392-97b763a45303'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y', '82a17761-9255-4328-a62d-abb2cb57232f', NULL, NULL, NULL);
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '82a17761-9255-4328-a62d-abb2cb57232f'
	), 0, 0, 'Y', '2026-05-21 16:44:33.845055', 100, '2026-05-21 16:44:49.555000', 100, 161, 24,
	 'a00df918-8b3a-4795-a34e-ae265fdacbf5');

SELECT
	register_migration_script('202605221123_GO-3580.sql')
FROM
	dual;
