-- Make casing correct on this column for code-generation purposes
UPDATE ad_column
SET
	columnname = 'BH_Voided_Reason_UU'
WHERE
	ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';

-- Update the bh_encounter_type_window table to not make certain columns keys
UPDATE ad_column
SET
	iskey    = 'N',
	isparent = 'Y'
WHERE
	ad_column_uu IN ('7cbc8eec-f8ba-4532-ac24-06dde60c76df', '2a30994f-7159-4802-be91-cdd770b991df');

-- Make the coded diagnosis column on the encounter diagnosis table not mandatory
UPDATE ad_column
SET
	ismandatory = 'N'
WHERE
	ad_column_uu = '65218da9-6835-4cda-a2d8-f275b313b1c4';

-- Set model cascades so iDempiere can handle deletion of dependent entities
UPDATE ad_column
SET
	fkconstrainttype = 'M'
WHERE
	ad_column_uu IN ('8d840880-1948-44d5-b160-c309c8b49716', '3d272d31-6f45-41de-92e5-2ed8ec22d41c',
	                 'a5413729-1309-4f91-addf-7ed9e0599ec5', 'ae09c94f-ec03-4809-9544-1aefb4075799',
	                 'fa2e7bc6-538b-468e-9c90-f740bbd35c4a', 'd4e8a380-4f18-4fcd-a9ac-53f63be918d3',
	                 'c4c984e2-47d8-4a24-afcb-48f4539c6e47');

-- Since invoice lines are cascade delete from invoices, do the same for the BP Specific Payer Information
ALTER TABLE bh_bp_specific_payer_info
	DROP CONSTRAINT IF EXISTS cinvoiceline_bhbpspecificpayer;
ALTER TABLE bh_bp_specific_payer_info
	ADD CONSTRAINT cinvoiceline_bhbpspecificpayer
		FOREIGN KEY (c_invoiceline_id) REFERENCES c_invoiceline
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;
-- Update the column to specify this
UPDATE ad_column
SET
	fkconstrainttype = 'C'
WHERE
	ad_column_uu IN ('69734631-bd60-4d59-b3d7-6104527a00e7');

-- Update the clinician user column so that it gets generated correctly
UPDATE ad_column
SET
	ad_reference_id       = 18,
	ad_reference_value_id = 110
WHERE
	ad_column_uu = '1aa5d014-0270-451b-a902-50862bd3338a';

-- Insert the generator template stuff
CREATE TABLE BH_GraphQLGeneratorTemplate
(
	AD_Client_ID                   NUMERIC(10) NOT NULL,
	AD_Org_ID                      NUMERIC(10) NOT NULL,
	BH_GraphQLGeneratorTemplate_ID NUMERIC(10) NOT NULL,
	BH_GraphQLGeneratorTemplate_UU VARCHAR(36)                                         DEFAULT NULL,
	ColumnEntityType               TEXT                                                DEFAULT NULL,
	Created                        TIMESTAMP   NOT NULL,
	CreatedBy                      NUMERIC(10) NOT NULL,
	CustomModelFolder              TEXT                                                DEFAULT NULL,
	CustomModelPackageName         TEXT                                                DEFAULT NULL,
	DataLoaderFolder               TEXT                                                DEFAULT NULL,
	DataLoaderPackageName          TEXT                                                DEFAULT NULL,
	InputModelFolder               TEXT                                                DEFAULT NULL,
	InputModelPackageName          TEXT                                                DEFAULT NULL,
	IsActive                       CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	ModelResolverFolder            TEXT                                                DEFAULT NULL,
	ModelResolverPackageName       TEXT                                                DEFAULT NULL,
	MutationResolverFolder         TEXT                                                DEFAULT NULL,
	MutationResolverPackageName    TEXT                                                DEFAULT NULL,
	Name                           TEXT        NOT NULL,
	QueryResolverFolder            TEXT                                                DEFAULT NULL,
	QueryResolverPackageName       TEXT                                                DEFAULT NULL,
	SchemaFolder                   TEXT                                                DEFAULT NULL,
	TableEntityType                TEXT                                                DEFAULT NULL,
	TableName                      TEXT                                                DEFAULT NULL,
	Updated                        TIMESTAMP   NOT NULL,
	UpdatedBy                      NUMERIC(10) NOT NULL,
	CONSTRAINT BH_GraphQLGeneratorTemplat_Key PRIMARY KEY (BH_GraphQLGeneratorTemplate_ID),
	CONSTRAINT BH_GraphQLGeneratorTemplauuidx UNIQUE (BH_GraphQLGeneratorTemplate_UU)
);

ALTER TABLE BH_GraphQLGeneratorTemplate
	ADD CONSTRAINT ADClient_BHGraphQLGeneratorTem FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_GraphQLGeneratorTemplate
	ADD CONSTRAINT ADOrg_BHGraphQLGeneratorTempla FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_GraphQLGeneratorTemplate
	ADD CONSTRAINT CreatedBy_BHGraphQLGeneratorTe FOREIGN KEY (CreatedBy) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE BH_GraphQLGeneratorTemplate
	ADD CONSTRAINT UpdatedBy_BHGraphQLGeneratorTe FOREIGN KEY (UpdatedBy) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the system elements
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.165000', 100, '2024-04-04 15:21:46.165000', 100, 'BH_GraphQLGeneratorTemplate_ID',
	 'U', 'Banda GraphQL Generator Template', 'Banda GraphQL Generator Template', NULL, NULL, NULL, NULL, NULL, NULL,
	 'e4c8f9c5-719d-4df5-9f9d-2acfc4ec439f', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.204000', 100, '2024-04-04 15:21:46.204000', 100, 'BH_GraphQLGeneratorTemplate_UU',
	 'U', 'BH_GraphQLGeneratorTemplate_UU', 'BH_GraphQLGeneratorTemplate_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '4fee468a-1de1-49eb-9337-87f1b88c8dba', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:46:06.480000', 100, '2024-04-04 16:46:27.706000', 100, 'CustomModelPackageName', 'U',
	 'Custom Model Package Name', 'Custom Model Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 '92af81d5-eca9-446d-8530-7a035d8c1454', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:46:53.702000', 100, '2024-04-04 16:46:53.702000', 100, 'SchemaFolder', 'U',
	 'Schema Folder', 'Schema Folder', NULL, NULL, NULL, NULL, NULL, NULL, '2fba96a7-7d93-4495-9013-b52da92c1811', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:47:05.391000', 100, '2024-04-04 16:47:05.391000', 100, 'InputModelFolder', 'U',
	 'Input Model Folder', 'Input Model Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '186bc1fc-9ff7-4fe3-ab84-201c0f02274f', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:47:18.063000', 100, '2024-04-04 16:47:18.063000', 100, 'InputModelPackageName', 'U',
	 'Input Model Package Name', 'Input Model Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 '85aa7a3c-b1e8-40dd-b3c4-b68756177ab4', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:47:33.356000', 100, '2024-04-04 16:47:33.356000', 100, 'QueryResolverFolder', 'U',
	 'Query Resolver Folder', 'Query Resolver Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '7e3ec873-0bff-41d4-b474-190b0e869775', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:47:46.605000', 100, '2024-04-04 16:47:46.605000', 100, 'QueryResolverPackageName', 'U',
	 'Query Resolver Package Name', 'Query Resolver Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 '3bfea4ea-adc1-4b0d-8a11-b59b190333a0', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:48:02.684000', 100, '2024-04-04 16:48:02.684000', 100, 'MutationResolverFolder', 'U',
	 'Mutation Resolver Folder', 'Mutation Resolver Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '92a0114e-bc9d-4e21-8417-a7626f446e45', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:59:09.567000', 100, '2024-04-04 16:59:09.567000', 100, 'MutationResolverPackageName',
	 'U', 'Mutation Resolver Package Name', 'Mutation Resolver Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 '9514e16c-6934-4366-8a98-c3ae364680c8', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:59:43.944000', 100, '2024-04-04 16:59:43.944000', 100, 'ModelResolverFolder', 'U',
	 'Model Resolver Folder', 'Model Resolver Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '5911f49e-a8d2-4389-8afd-12245fcf4422', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 16:59:59.091000', 100, '2024-04-04 16:59:59.091000', 100, 'ModelResolverPackageName', 'U',
	 'Model Resolver Package Name', 'Model Resolver Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 '2e82f77e-02f5-4fd9-9d25-08f6448a260d', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 17:00:16.164000', 100, '2024-04-04 17:00:16.164000', 100, 'DataLoaderFolder', 'U',
	 'Data Loader Folder', 'Data Loader Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '0924d539-0ac6-428c-8c35-ca9de422bfea', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 17:00:29.118000', 100, '2024-04-04 17:00:29.118000', 100, 'DataLoaderPackageName', 'U',
	 'Data Loader Package Name', 'Data Loader Package Name', NULL, NULL, NULL, NULL, NULL, NULL,
	 'ffba41ac-1785-4e36-af7c-80a20ecfa3d3', NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 17:01:49.836000', 100, '2024-04-04 17:01:49.836000', 100, 'CustomModelFolder', 'U',
	 'Custom Model Folder', 'Custom Model Folder', NULL, NULL, NULL, NULL, NULL, NULL,
	 '1e54a824-5213-4769-a505-79f044f239f2', NULL);

-- Create the table
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
	 ), 0, 0, 'Y', '2024-04-04 15:19:41.342000', 100, '2024-04-04 15:19:41.342000', 100,
	 'Banda GraphQL Generator Template', NULL, NULL, 'BH_GraphQLGeneratorTemplate', 'N', '4', 'U', NULL, NULL, NULL, 'N',
	 'Y', 'N', NULL, 'Y', 'L', NULL, NULL, 'Y', 'c76d4883-6f02-4cab-a224-3c5aad7d488a', 'N', NULL, NULL, NULL, 'Y', 'N',
	 NULL);

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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.096000', '2024-04-04 17:04:11.236000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 0, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 30, NULL, NULL, 10, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', '1=1', 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL,
	 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '529024b3-c9b3-4027-ab04-763a641ddeb8', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHGraphQLGeneratorTem', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.145000', '2024-04-04 15:21:46.145000', 100, 100,
	 'Banda GraphQL Generator Template', NULL, NULL, 0, 'U', 'BH_GraphQLGeneratorTemplate_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e4c8f9c5-719d-4df5-9f9d-2acfc4ec439f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5f908a73-a546-4ef3-a325-b55da4194dea', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.196000', '2024-04-04 15:21:46.196000', 100, 100, 'BH_GraphQLGeneratorTemplate_UU',
	 NULL, NULL, 0, 'U', 'BH_GraphQLGeneratorTemplate_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '4fee468a-1de1-49eb-9337-87f1b88c8dba'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a2b63b32-cbf9-473c-ab6d-f9c17b9f224b', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.225000', '2024-04-04 17:04:11.251000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 0, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 19, NULL, NULL, 10, '@AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0b63a251-6485-495e-a158-9e0269383c5c', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHGraphQLGeneratorTempla', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.241000', '2024-04-04 15:22:50.566000', 100, 100, 'Column Entity Type', NULL, NULL,
	 0, 'U', 'ColumnEntityType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '22ad1194-cfdc-4582-bd51-a2d7a4a46f14'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8df7478b-4dfb-482c-bd05-8eed1f6a16de', 'Y', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.262000', '2024-04-04 15:21:46.262000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 0, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 16, NULL, NULL, 7, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '237a5a94-4efe-4496-ab71-106d8f660e45', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.282000', '2024-04-04 17:04:11.266000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 0, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 30, 110, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3b0b518f-fc93-45e7-9e07-c26005e4bd18', 'N', NULL, 'N', 'N',
	 NULL, 'CreatedBy_BHGraphQLGeneratorTe', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.303000', '2024-04-04 17:02:11.289000', 100, 100, 'Custom Model Folder', NULL,
	 NULL, 0, 'U', 'CustomModelFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1e54a824-5213-4769-a505-79f044f239f2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c7a3954c-2d15-4938-9ce6-8cc3ac4e95a3', 'Y', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.323000', '2024-04-04 15:21:46.323000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 0, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '37be5602-9b4c-499d-9b47-eab1d0e962a5', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.339000', '2024-04-04 15:23:17.508000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 0, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f06dd798-f490-4092-8d8b-be3cc87d55f9', 'Y', 10, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.360000', '2024-04-04 17:02:51.401000', 100, 100, 'Input Model Package Name', NULL,
	 NULL, 0, 'U', 'InputModelPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '85aa7a3c-b1e8-40dd-b3c4-b68756177ab4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '17bc83a0-4403-415a-a795-519aed88073a', 'Y', 40, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.380000', '2024-04-04 15:23:33.437000', 100, 100, 'Table Entity Type', NULL, NULL,
	 0, 'U', 'TableEntityType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '86a1747f-f3ca-4a32-ba6b-e4461eb99f77'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3c905049-1f97-4e5d-acec-7e0f6281de1d', 'Y', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.401000', '2024-04-04 15:23:38.937000', 100, 100, 'DB Table Name',
	 'Name of the table in the database', 'The DB Table Name indicates the name of the table in database.', 0, 'U',
	 'TableName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3b4fb355-06b1-49b5-986e-9bcddca41727'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4842b101-f5be-47ed-ab4d-667fcbad930c', 'Y', 20, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.421000', '2024-04-04 15:21:46.421000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 0, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 16, NULL, NULL, 7, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd67f83ce-2044-4f06-87ed-7cb60a88b955', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2024-04-04 15:21:46.437000', '2024-04-04 17:04:11.281000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 0, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 30, 110, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dec3184c-66fb-4429-b03d-215e26a10afe', 'N', NULL, 'N', 'N',
	 NULL, 'UpdatedBy_BHGraphQLGeneratorTe', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 17:02:23.476000', '2024-04-04 17:02:23.476000', 100, 100, 'Custom Model Package Name',
	 NULL, NULL, 0, 'U', 'CustomModelPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '92af81d5-eca9-446d-8530-7a035d8c1454'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd1b69fdd-6521-44e6-a389-9218a47f4db3', 'Y', 30, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:02:28.665000', '2024-04-04 17:02:28.665000', 100, 100, 'Schema Folder', NULL, NULL, 0,
	 'U', 'SchemaFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2fba96a7-7d93-4495-9013-b52da92c1811'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a36f85a5-4085-4f4b-b872-80458fcbe39d', 'Y', 30, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:02:40.753000', '2024-04-04 17:02:40.753000', 100, 100, 'Input Model Folder', NULL, NULL,
	 0, 'U', 'InputModelFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '186bc1fc-9ff7-4fe3-ab84-201c0f02274f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c61d9935-e3e3-4b4b-b684-df923cc47d27', 'Y', 30, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:01.070000', '2024-04-04 17:03:01.070000', 100, 100, 'Query Resolver Folder', NULL,
	 NULL, 0, 'U', 'QueryResolverFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7e3ec873-0bff-41d4-b474-190b0e869775'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ba50cb03-4e78-40ac-a053-d971adea4177', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:06.717000', '2024-04-04 17:03:06.717000', 100, 100, 'Query Resolver Package Name',
	 NULL, NULL, 0, 'U', 'QueryResolverPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3bfea4ea-adc1-4b0d-8a11-b59b190333a0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8504213a-316b-4e1d-a3ec-d5671282c8e7', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:12.741000', '2024-04-04 17:03:12.741000', 100, 100, 'Mutation Resolver Folder', NULL,
	 NULL, 0, 'U', 'MutationResolverFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '92a0114e-bc9d-4e21-8417-a7626f446e45'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'efb7c5c5-1d64-41e2-8354-2bd6414f2c7e', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:17.940000', '2024-04-04 17:03:25.712000', 100, 100, 'Model Resolver Folder', NULL,
	 NULL, 0, 'U', 'ModelResolverFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5911f49e-a8d2-4389-8afd-12245fcf4422'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a4742eef-507d-49ad-ac9e-84751cf00d14', 'Y', 40, 'N', 'N', NULL,
	 NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:31.209000', '2024-04-04 17:03:31.209000', 100, 100, 'Model Resolver Package Name',
	 NULL, NULL, 0, 'U', 'ModelResolverPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2e82f77e-02f5-4fd9-9d25-08f6448a260d'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4ac4df07-fdcb-4798-ad2e-bde3561c5342', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:36.501000', '2024-04-04 17:03:36.501000', 100, 100, 'Data Loader Folder', NULL, NULL,
	 0, 'U', 'DataLoaderFolder', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0924d539-0ac6-428c-8c35-ca9de422bfea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'af8c8527-f959-4883-9753-ddc032ed2d35', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:03:41.838000', '2024-04-04 17:03:41.838000', 100, 100, 'Data Loader Package Name', NULL,
	 NULL, 0, 'U', 'DataLoaderPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ffba41ac-1785-4e36-af7c-80a20ecfa3d3'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4f21f56e-1d82-4bd0-8b00-30090fe85604', 'Y', 40, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2024-04-04 17:09:54.615000', '2024-04-04 17:09:54.615000', 100, 100, 'Mutation Resolver Package Name',
	 NULL, NULL, 0, 'U', 'MutationResolverPackageName', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9514e16c-6934-4366-8a98-c3ae364680c8'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b73ba340-bae6-4381-92d9-2aa39148b7ef', 'Y', 40, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Insert the window
INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight,
	           winwidth, isbetafunctionality, ad_window_uu, titlelogic, predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_window_id) + 1
		 FROM
			 ad_window
	 ), 0, 0, 'Y', '2024-04-04 17:06:16.666000', 100, '2024-04-04 17:06:16.666000', 100, 'GraphQL Generator Template',
	 NULL, NULL, 'M', 'N', 'U', 'N', NULL, NULL, 'N', NULL, NULL, 'N', 'dea40a7e-2328-4a93-a60e-5fcc4d96cfc6', NULL,
	 NULL);

-- Update the table with the window
UPDATE ad_table
SET
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'dea40a7e-2328-4a93-a60e-5fcc4d96cfc6'
	)
WHERE
	ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a';

-- Insert the tab
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
	 ), 0, 0, 'Y', '2024-04-04 17:06:42.406000', 100, '2024-04-04 17:07:18.326000', 100, 'GraphQL Generator Template',
	 NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c76d4883-6f02-4cab-a224-3c5aad7d488a'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'dea40a7e-2328-4a93-a60e-5fcc4d96cfc6'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, 'BH_GraphQLGeneratorTemplate.Name', NULL, NULL, 'N', NULL, 'N', NULL,
	 NULL, 'N', 'U', NULL, NULL, NULL, 'Y', 'N', NULL, '4e1f3643-f217-462a-945e-a25128c59a9b', NULL, 'B', 0, 'N', 'Y',
	 NULL, NULL, NULL);

-- Insert the fields
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.011000', 100, '2024-04-04 17:07:23.011000', 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '529024b3-c9b3-4027-ab04-763a641ddeb8'
	 ), NULL, 'Y', NULL, 10, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '0551f56e-32e3-4dff-8bc3-4ff6ac7b190e', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.030000', 100, '2024-04-04 17:07:23.030000', 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0b63a251-6485-495e-a158-9e0269383c5c'
	 ), NULL, 'Y', NULL, 10, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'ae09fc1b-3022-4984-b3dc-860a74f9e331', 'Y', NULL, 'N', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.043000', 100, '2024-04-04 17:09:35.617000', 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f06dd798-f490-4092-8d8b-be3cc87d55f9'
	 ), NULL, 'Y', NULL, 0, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '69c2aeee-3843-4c65-a46e-4926e3e036ce', NULL, 10, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.054000', 100, '2024-04-04 17:09:35.659000', 100,
	 'Banda GraphQL Generator Template', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '5f908a73-a546-4ef3-a325-b55da4194dea'
	 ), NULL, 'N', NULL, 22, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '7f0050de-d025-47b6-8d71-f28058cd79a3', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.066000', 100, '2024-04-04 17:09:35.657000', 100, 'BH_GraphQLGeneratorTemplate_UU',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'a2b63b32-cbf9-473c-ab6d-f9c17b9f224b'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '23100589-ea78-49a0-84e9-88a517658bab', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.078000', 100, '2024-04-04 17:09:35.625000', 100, 'Column Entity Type', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8df7478b-4dfb-482c-bd05-8eed1f6a16de'
	 ), NULL, 'Y', NULL, 0, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '841b4c18-1e06-48dd-b9bf-36dc5057b8fc', NULL, 20, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.086000', 100, '2024-04-04 17:09:35.628000', 100, 'Custom Model Folder', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c7a3954c-2d15-4938-9ce6-8cc3ac4e95a3'
	 ), NULL, 'Y', NULL, 0, 'N', 80, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '526ce6a9-ee51-4016-a11a-5d24e2256c2e', NULL, 30, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.097000', 100, '2024-04-04 17:09:35.633000', 100, 'Input Model Package Name', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '17bc83a0-4403-415a-a795-519aed88073a'
	 ), NULL, 'Y', NULL, 0, 'N', 120, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '557cf0c2-fdd9-402b-91ef-4cf847b81c84', NULL, 40, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.108000', 100, '2024-04-04 17:09:35.622000', 100, 'Table Entity Type', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '3c905049-1f97-4e5d-acec-7e0f6281de1d'
	 ), NULL, 'Y', NULL, 0, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '09042110-7a96-474f-8942-8b6827513e94', NULL, 50, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.121000', 100, '2024-04-04 17:09:35.620000', 100, 'DB Table Name',
	 'Name of the table in the database', 'The DB Table Name indicates the name of the table in database.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4842b101-f5be-47ed-ab4d-667fcbad930c'
	 ), NULL, 'Y', NULL, 0, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'de63a91c-e130-4ffd-91f7-6c5f13b82b87', NULL, 60, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.133000', 100, '2024-04-04 17:09:35.631000', 100, 'Custom Model Package Name',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd1b69fdd-6521-44e6-a389-9218a47f4db3'
	 ), NULL, 'Y', NULL, 0, 'N', 90, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '44893c58-f5ac-405e-b820-0aa15e799910', NULL, 70, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.141000', 100, '2024-04-04 17:07:23.141000', 100, 'Schema Folder', NULL, NULL, 'Y',
	 (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'a36f85a5-4085-4f4b-b872-80458fcbe39d'
	 ), NULL, 'Y', NULL, 0, 'N', 100, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '33ae23e2-5f5c-4721-bd01-7f1296771a5f', NULL, 80, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.147000', 100, '2024-04-04 17:07:23.147000', 100, 'Input Model Folder', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c61d9935-e3e3-4b4b-b684-df923cc47d27'
	 ), NULL, 'Y', NULL, 0, 'N', 110, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'a83c7dde-ee13-4baf-a56f-8cd718de7582', NULL, 90, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.159000', 100, '2024-04-04 17:09:35.637000', 100, 'Query Resolver Folder', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ba50cb03-4e78-40ac-a053-d971adea4177'
	 ), NULL, 'Y', NULL, 0, 'N', 130, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '37de027d-8b86-45bb-bb14-b8df8d3e022a', NULL, 100, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.169000', 100, '2024-04-04 17:09:35.640000', 100, 'Query Resolver Package Name',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8504213a-316b-4e1d-a3ec-d5671282c8e7'
	 ), NULL, 'Y', NULL, 0, 'N', 140, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '3f66396e-8c42-4a30-ae15-98ee4bd44201', NULL, 110, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.179000', 100, '2024-04-04 17:09:35.643000', 100, 'Mutation Resolver Folder', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'efb7c5c5-1d64-41e2-8354-2bd6414f2c7e'
	 ), NULL, 'Y', NULL, 0, 'N', 150, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'c115ea2c-d615-4a4e-8195-8da5bc7fbd7d', NULL, 120, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.189000', 100, '2024-04-04 17:10:51.012000', 100, 'Model Resolver Folder', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'a4742eef-507d-49ad-ac9e-84751cf00d14'
	 ), NULL, 'Y', NULL, 0, 'N', 170, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e3b85979-23bf-4862-bd5a-e08f5f352914', NULL, 130, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.196000', 100, '2024-04-04 17:10:51.016000', 100, 'Model Resolver Package Name',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4ac4df07-fdcb-4798-ad2e-bde3561c5342'
	 ), NULL, 'Y', NULL, 0, 'N', 180, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '0a66ce29-1969-4edc-b7a9-5d11332595a8', NULL, 140, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.207000', 100, '2024-04-04 17:10:51.021000', 100, 'Data Loader Folder', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'af8c8527-f959-4883-9753-ddc032ed2d35'
	 ), NULL, 'Y', NULL, 0, 'N', 190, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'a2f168b6-7e91-46ac-bf9c-d0603daef281', NULL, 150, 'Y', 1, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.218000', 100, '2024-04-04 17:10:51.024000', 100, 'Data Loader Package Name', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4f21f56e-1d82-4bd0-8b00-30090fe85604'
	 ), NULL, 'Y', NULL, 0, 'N', 200, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '375bfa38-1cbd-4485-b79e-6525590a9d39', NULL, 160, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:07:23.229000', 100, '2024-04-04 17:09:35.613000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '37be5602-9b4c-499d-9b47-eab1d0e962a5'
	 ), NULL, 'Y', NULL, 1, 'N', 30, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'd2cf9888-04eb-46a1-adaf-d69c545db852', NULL, 170, 'Y', 2, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation, isselectioncolumn, ad_val_rule_lookup_id, columnsql, ad_chart_id, alwaysupdatablelogic)
VALUES
	((
		 SELECT
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2024-04-04 17:10:22.426000', 100, '2024-04-04 17:10:51.004000', 100, 'Mutation Resolver Package Name',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '4e1f3643-f217-462a-945e-a25128c59a9b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'b73ba340-bae6-4381-92d9-2aa39148b7ef'
	 ), NULL, 'Y', NULL, 0, 'N', 160, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '4d432964-b69b-457b-a74f-4b9e5b741478', NULL, 180, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL);

-- Insert the menu
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_menu_id) + 1
		 FROM
			 ad_menu
	 ), 0, 0, 'Y', '2024-04-04 17:11:46.514000', 100, '2024-04-04 17:11:46.514000', 'GraphQL Generator Template', 100,
	 NULL, 'N', 'N', 'N', 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'dea40a7e-2328-4a93-a60e-5fcc4d96cfc6'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y', 'f1da7101-afba-421a-8d35-ee8007f29b79', NULL, NULL, NULL);

-- Insert the menu position
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'f1da7101-afba-421a-8d35-ee8007f29b79'
	), 0, 0, 'Y', '2024-04-04 17:11:46.567673', 100, '2024-04-04 17:12:15.744000', 100, 153, 41,
	 'ae962ebd-7085-4b25-a7de-c95fb5ed5655');

-- Insert the new sequence
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
	 ), 0, 0, 'Y', '2024-04-04 15:19:41.419000', 100, '2024-04-04 15:19:41.419000', 100, 'BH_GraphQLGeneratorTemplate',
	 'Table BH_GraphQLGeneratorTemplate', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'a4b73753-91e7-478f-9f92-811d8f06e820', 'N', 'N', NULL);

-- Insert the initial data for others to update
INSERT INTO
	bh_graphqlgeneratortemplate (ad_client_id, ad_org_id, bh_graphqlgeneratortemplate_id, bh_graphqlgeneratortemplate_uu,
	                             columnentitytype, created, createdby, custommodelfolder, custommodelpackagename,
	                             dataloaderfolder, dataloaderpackagename, inputmodelfolder, inputmodelpackagename,
	                             isactive, modelresolverfolder, modelresolverpackagename, mutationresolverfolder, name,
	                             queryresolverfolder, queryresolverpackagename, schemafolder, tableentitytype, tablename,
	                             updated, updatedby, mutationresolverpackagename)
VALUES
	(0, 0, 1000000, '0b9c9d6a-6e59-4ba4-995a-6762c9effe03', 'U,D,EE01,EE04,EE05,EE02', '2024-04-04 19:08:54.096000', 100,
	 NULL, 'org.bandahealth.idempiere.base.model', NULL, 'org.bandahealth.idempiere.graphql.dataloader.impl', NULL,
	 'org.bandahealth.idempiere.graphql.model.input', 'Y', NULL, 'org.bandahealth.idempiere.graphql.resolver.model', NULL,
	 'Create Everything - Feel free to enter your own folders and packages', NULL,
	 'org.bandahealth.idempiere.graphql.resolver.query', NULL, 'U,D,EE01,EE04,EE05,EE02',
	 '''A_Asset'',''A_Asset_Acct'',''A_Asset_Addition'',''A_Asset_Change'',''A_Asset_Class'',''A_Asset_Delivery'',''A_Asset_Disposed'',''A_Asset_Group'',''A_Asset_Group_Acct'',''A_Asset_Info_Fin'',''A_Asset_Info_Ins'',''A_Asset_Info_Lic'',''A_Asset_Info_Oth'',''A_Asset_Info_Tax'',''A_Asset_Product'',''A_Asset_Retirement'',''A_Asset_Reval'',''A_Asset_Reval_Entry'',''A_Asset_Reval_Index'',''A_Asset_Split'',''A_Asset_Transfer'',''A_Asset_Type'',''A_Asset_Use'',''A_Depreciation'',''A_Depreciation_Build'',''A_Depreciation_Convention'',''A_Depreciation_Entry'',''A_Depreciation_Exp'',''A_Depreciation_Forecast'',''A_Depreciation_Method'',''A_Depreciation_Table_Detail'',''A_Depreciation_Table_Header'',''A_Depreciation_Workfile'',''A_FundingMode'',''A_FundingMode_Acct'',''A_Registration'',''A_RegistrationAttribute'',''A_RegistrationProduct'',''A_RegistrationValue'',''AD_AccessLog'',''AD_Alert'',''AD_AlertProcessor'',''AD_AlertProcessorLog'',''AD_AlertRecipient'',''AD_AlertRule'',''AD_AllClients_V'',''AD_AllUsers_V'',''AD_Archive'',''AD_Attachment'',''AD_AttachmentNote'',''AD_Attribute'',''AD_Attribute_Value'',''AD_AuthorizationAccount'',''AD_AuthorizationCredential'',''AD_AuthorizationProvider'',''AD_BroadcastMessage'',''AD_ChangeLog'',''AD_Chart'',''AD_ChartDatasource'',''AD_Client'',''AD_ClientInfo'',''AD_ClientShare'',''AD_Color'',''AD_Column'',''AD_Column_Access'',''AD_CtxHelp'',''AD_CtxHelpMsg'',''AD_CtxHelpSuggestion'',''AD_Desktop'',''AD_DesktopWorkbench'',''AD_Document_Action_Access'',''AD_Element'',''AD_EntityType'',''AD_Error'',''AD_Field'',''AD_FieldGroup'',''AD_FieldSuggestion'',''AD_Find'',''AD_Form'',''AD_Form_Access'',''AD_HouseKeeping'',''AD_Image'',''AD_ImpFormat'',''AD_ImpFormat_Row'',''AD_ImportTemplate'',''AD_ImportTemplateAccess'',''AD_IndexColumn'',''AD_InfoColumn'',''AD_InfoProcess'',''AD_InfoRelated'',''AD_InfoWindow'',''AD_InfoWindow_Access'',''AD_Issue'',''AD_LabelPrinter'',''AD_LabelPrinterFunction'',''AD_Language'',''AD_LdapAccess'',''AD_LdapProcessor'',''AD_LdapProcessorLog'',''AD_Menu'',''AD_Message'',''AD_MigrationScript'',''AD_ModelValidator'',''AD_Modification'',''AD_Note'',''AD_Org'',''AD_OrgInfo'',''AD_OrgType'',''AD_Package_Exp'',''AD_Package_Exp_Detail'',''AD_Package_Imp'',''AD_Package_Imp_Backup'',''AD_Package_Imp_Detail'',''AD_Package_Imp_Inst'',''AD_Package_Imp_Proc'',''AD_Package_UUID_Map'',''AD_Password_History'',''AD_PasswordRule'',''AD_PInstance'',''AD_PInstance_Log'',''AD_PInstance_Para'',''AD_PostIt'',''AD_Preference'',''AD_PrintColor'',''AD_PrintFont'',''AD_PrintForm'',''AD_PrintFormat'',''AD_PrintFormatItem'',''AD_PrintGraph'',''AD_PrintHeaderFooter'',''AD_PrintLabel'',''AD_PrintLabelLine'',''AD_PrintPaper'',''AD_PrintTableFormat'',''AD_Private_Access'',''AD_Process'',''AD_Process_Access'',''AD_Process_Para'',''AD_RecentItem'',''AD_Record_Access'',''AD_Ref_List'',''AD_Ref_Table'',''AD_Reference'',''AD_Registration'',''AD_RelationType'',''AD_Replication'',''AD_Replication_Log'',''AD_Replication_Run'',''AD_ReplicationDocument'',''AD_ReplicationStrategy'',''AD_ReplicationTable'',''AD_ReportView'',''AD_ReportView_Col'',''AD_ReportView_Column'',''AD_Role'',''AD_Role_Included'',''AD_Role_OrgAccess'',''AD_Rule'',''AD_Schedule'',''AD_Scheduler'',''AD_Scheduler_Para'',''AD_SchedulerLog'',''AD_SchedulerRecipient'',''AD_SearchDefinition'',''AD_Sequence'',''AD_Sequence_Audit'',''AD_Sequence_No'',''AD_Session'',''AD_StatusLine'',''AD_StatusLineUsedIn'',''AD_StorageProvider'',''AD_Style'',''AD_StyleLine'',''AD_SysConfig'',''AD_System'',''AD_Tab'',''AD_Tab_Customization'',''AD_Table'',''AD_Table_Access'',''AD_Table_ScriptValidator'',''AD_TableIndex'',''AD_Task'',''AD_Task_Access'',''AD_TaskInstance'',''AD_ToolBarButton'',''AD_ToolBarButtonRestrict'',''AD_Tree'',''AD_Tree_Favorite'',''AD_Tree_Favorite_Node'',''AD_TreeBar'',''AD_TreeNode'',''AD_TreeNodeBP'',''AD_TreeNodeCMC'',''AD_TreeNodeCMM'',''AD_TreeNodeCMS'',''AD_TreeNodeCMT'',''AD_TreeNodeMM'',''AD_TreeNodePR'',''AD_TreeNodeU1'',''AD_TreeNodeU2'',''AD_TreeNodeU3'',''AD_TreeNodeU4'',''AD_User'',''AD_User_OrgAccess'',''AD_User_Roles'',''AD_User_Substitute'',''AD_UserBPAccess'',''AD_UserDef_Field'',''AD_UserDef_Info'',''AD_UserDef_Info_Column'',''AD_UserDef_Info_Related'',''AD_UserDef_Proc'',''AD_UserDef_Proc_Parameter'',''AD_UserDef_Tab'',''AD_UserDef_Win'',''AD_UserMail'',''AD_UserPreference'',''AD_UserQuery'',''AD_Val_Rule'',''AD_ViewColumn'',''AD_ViewComponent'',''AD_WF_Activity'',''AD_WF_ActivityApprover'',''AD_WF_ActivityResult'',''AD_WF_Block'',''AD_WF_EventAudit'',''AD_WF_NextCondition'',''AD_WF_Node'',''AD_WF_Node_Para'',''AD_WF_NodeNext'',''AD_WF_Process'',''AD_WF_ProcessData'',''AD_WF_Responsible'',''AD_Window'',''AD_Window_Access'',''AD_WizardProcess'',''AD_Workbench'',''AD_WorkbenchWindow'',''AD_Workflow'',''AD_Workflow_Access'',''AD_WorkflowProcessor'',''AD_WorkflowProcessorLog'',''AD_ZoomCondition'',''ASP_ClientException'',''ASP_ClientLevel'',''ASP_Field'',''ASP_Form'',''ASP_Level'',''ASP_Module'',''ASP_Process'',''ASP_Process_Para'',''ASP_Ref_List'',''ASP_Tab'',''ASP_Task'',''ASP_Window'',''ASP_Workflow'',''B_Bid'',''B_BidComment'',''B_Buyer'',''B_BuyerFunds'',''B_Offer'',''B_Seller'',''B_SellerFunds'',''B_Topic'',''B_TopicCategory'',''B_TopicType'',''BH_BP_General_Payer_Info'',''BH_BP_Payer_Info'',''BH_BP_Specific_Payer_Info'',''BH_ChargeDefault'',''BH_ChargeTypeDefault'',''BH_Coded_Diagnosis'',''BH_Coded_Diagnosis_Mapping'',''BH_DbrdBtnGrp'',''BH_DbrdBtnGrp_Btn'',''BH_Default_DocAction_Access'',''BH_DefaultIncludedRole'',''BH_Encounter'',''BH_Encounter_Diagnosis'',''BH_Encounter_Type_Window'',''BH_I_Product_Quantity'',''BH_Observation'',''BH_Payer_Info_Fld'',''BH_Payer_Info_Fld_Sug'',''BH_Payer_Info_Fld_Val'',''BH_Payer_Info_Fld_Val_Sug'',''BH_PaymentRef'',''BH_PaymentRef_BankAcct'',''BH_Product_CategoryDefault'',''BH_Role_WarehouseAccess'',''BH_Stocktake_v'',''BH_TabNavBtn'',''BH_TabNavBtn_Tab'',''BH_UIButton'',''BH_Visit'',''BH_Voided_Reason'',''C_1099Box'',''C_AcctProcessor'',''C_AcctProcessorLog'',''C_AcctSchema'',''C_AcctSchema_Default'',''C_AcctSchema_Element'',''C_AcctSchema_GL'',''C_Activity'',''C_AddressTransaction'',''C_AddressValidation'',''C_AddressValidationCfg'',''C_AllocationHdr'',''C_AllocationLine'',''C_Bank'',''C_BankAccount'',''C_BankAccount_Acct'',''C_BankAccount_Processor'',''C_BankAccountDoc'',''C_BankStatement'',''C_BankStatementLine'',''C_BankStatementLoader'',''C_BankStatementMatcher'',''C_BankTransfer'',''C_BP_BankAccount'',''C_BP_Customer_Acct'',''C_BP_EDI'',''C_BP_Employee_Acct'',''C_BP_Group'',''C_BP_Group_Acct'',''C_BP_Relation'',''C_BP_ShippingAcct'',''C_BP_Vendor_Acct'',''C_BP_Withholding'',''C_BPartner'',''C_BPartner_Location'',''C_BPartner_Product'',''C_Calendar'',''C_Campaign'',''C_Cash'',''C_CashBook'',''C_CashBook_Acct'',''C_CashLine'',''C_CashPlan'',''C_CashPlanLine'',''C_Channel'',''C_Charge'',''C_Charge_Acct'',''C_ChargeType'',''C_ChargeType_DocType'',''C_City'',''C_Commission'',''C_CommissionAmt'',''C_CommissionDetail'',''C_CommissionLine'',''C_CommissionRun'',''C_ContactActivity'',''C_Conversion_Rate'',''C_ConversionType'',''C_Country'',''C_CountryGroup'',''C_CountryGroupCountry'',''C_Currency'',''C_Currency_Acct'',''C_Cycle'',''C_CyclePhase'',''C_CycleStep'',''C_DepositBatch'',''C_DepositBatchLine'',''C_DocType'',''C_DocTypeCounter'',''C_Dunning'',''C_DunningLevel'',''C_DunningRun'',''C_DunningRunEntry'',''C_DunningRunLine'',''C_Element'',''C_ElementValue'',''C_Greeting'',''C_InterOrg_Acct'',''C_Invoice'',''C_InvoiceBatch'',''C_InvoiceBatchLine'',''C_InvoiceLine'',''C_InvoicePaySchedule'',''C_InvoiceSchedule'',''C_InvoiceTax'',''C_Job'',''C_JobAssignment'',''C_JobCategory'',''C_JobRemuneration'',''C_LandedCost'',''C_LandedCostAllocation'',''C_Location'',''C_NonBusinessDay'',''C_OnlineTrxHistory'',''C_Opportunity'',''C_Order'',''C_OrderLandedCost'',''C_OrderLandedCostAllocation'',''C_OrderLine'',''C_OrderPaySchedule'',''C_OrderSource'',''C_OrderTax'',''C_OrgAssignment'',''C_Payment'',''C_PaymentAllocate'',''C_PaymentBatch'',''C_PaymentProcessor'',''C_PaymentTerm'',''C_PaymentTransaction'',''C_PaySchedule'',''C_PaySelection'',''C_PaySelectionCheck'',''C_PaySelectionLine'',''C_Period'',''C_PeriodControl'',''C_Phase'',''C_POS'',''C_POSKey'',''C_POSKeyLayout'',''C_POSPayment'',''C_POSTenderType'',''C_Project'',''C_Project_Acct'',''C_ProjectIssue'',''C_ProjectIssueMA'',''C_ProjectLine'',''C_ProjectPhase'',''C_ProjectTask'',''C_ProjectType'',''C_Recurring'',''C_Recurring_Run'',''C_RecurringGroup'',''C_Region'',''C_Remuneration'',''C_RevenueRecog_Service'',''C_RevenueRecognition'',''C_RevenueRecognition_Plan'',''C_RevenueRecognition_Run'',''C_RfQ'',''C_RfQ_Topic'',''C_RfQ_TopicSubscriber'',''C_RfQ_TopicSubscriberOnly'',''C_RfQLine'',''C_RfQLineQty'',''C_RfQResponse'',''C_RfQResponseLine'',''C_RfQResponseLineQty'',''C_SalesRegion'',''C_SalesStage'',''C_ServiceLevel'',''C_ServiceLevelLine'',''C_SubAcct'',''C_Subscription'',''C_Subscription_Delivery'',''C_SubscriptionType'',''C_Task'',''C_Tax'',''C_Tax_Acct'',''C_TaxBase'',''C_TaxCategory'',''C_TaxDeclaration'',''C_TaxDeclarationAcct'',''C_TaxDeclarationLine'',''C_TaxDefinition'',''C_TaxGroup'',''C_TaxPostal'',''C_TaxProvider'',''C_TaxProviderCfg'',''C_TaxType'',''C_UOM'',''C_UOM_Conversion'',''C_UserRemuneration'',''C_ValidCombination'',''C_Withholding'',''C_Withholding_Acct'',''C_Year'',''CM_Chat'',''CM_ChatEntry'',''CM_ChatType'',''CM_ChatTypeUpdate'',''CM_ChatUpdate'',''DD_NetworkDistribution'',''DD_NetworkDistributionLine'',''DD_Order'',''DD_OrderLine'',''EXP_Format'',''EXP_FormatLine'',''EXP_Processor'',''EXP_Processor_Type'',''EXP_ProcessorParameter'',''Fact_Acct'',''Fact_Acct_Summary'',''Fact_Reconciliation'',''GL_Budget'',''GL_BudgetControl'',''GL_Category'',''GL_Distribution'',''GL_DistributionLine'',''GL_Fund'',''GL_FundRestriction'',''GL_Journal'',''GL_JournalBatch'',''GL_JournalGenerator'',''GL_JournalGeneratorLine'',''GL_JournalGeneratorSource'',''GL_JournalLine'',''HR_Attribute'',''HR_Concept'',''HR_Concept_Acct'',''HR_Concept_Category'',''HR_Contract'',''HR_Department'',''HR_Employee'',''HR_Job'',''HR_List'',''HR_ListLine'',''HR_ListType'',''HR_ListVersion'',''HR_Movement'',''HR_Payroll'',''HR_PayrollConcept'',''HR_Period'',''HR_Process'',''HR_Year'',''I_Asset'',''I_BankStatement'',''I_BPartner'',''I_Conversion_Rate'',''I_ElementValue'',''I_FAJournal'',''I_FixedAsset'',''I_GLJournal'',''I_HR_Movement'',''I_InOutLineConfirm'',''I_Inventory'',''I_Invoice'',''I_Movement'',''I_Order'',''I_Payment'',''I_PriceList'',''I_Product'',''I_ProductPlanning'',''I_ReportLine'',''IMP_Processor'',''IMP_Processor_Type'',''IMP_ProcessorLog'',''IMP_ProcessorParameter'',''M_Attribute'',''M_AttributeInstance'',''M_AttributeSearch'',''M_AttributeSet'',''M_AttributeSetExclude'',''M_AttributeSetInstance'',''M_AttributeUse'',''M_AttributeValue'',''M_BOM'',''M_BOMAlternative'',''M_BOMProduct'',''M_BP_Price'',''M_ChangeNotice'',''M_ChangeRequest'',''M_CommodityShipment'',''M_Cost'',''M_CostDetail'',''M_CostElement'',''M_CostHistory'',''M_CostQueue'',''M_CostType'',''M_Demand'',''M_DemandDetail'',''M_DemandLine'',''M_DiscountSchema'',''M_DiscountSchemaBreak'',''M_DiscountSchemaLine'',''M_DistributionList'',''M_DistributionListLine'',''M_DistributionRun'',''M_DistributionRunLine'',''M_Forecast'',''M_ForecastLine'',''M_Freight'',''M_FreightCategory'',''M_InOut'',''M_InOutConfirm'',''M_InOutLine'',''M_InOutLineConfirm'',''M_InOutLineMA'',''M_Inventory'',''M_InventoryLine'',''M_InventoryLineMA'',''M_Locator'',''M_LocatorType'',''M_Lot'',''M_LotCtl'',''M_LotCtlExclude'',''M_MatchInv'',''M_MatchPO'',''M_Movement'',''M_MovementConfirm'',''M_MovementLine'',''M_MovementLineConfirm'',''M_MovementLineMA'',''M_OperationResource'',''M_Package'',''M_PackageLine'',''M_PackageMPS'',''M_PartType'',''M_PerpetualInv'',''M_PriceList'',''M_PriceList_Version'',''M_Product'',''M_Product_Acct'',''M_Product_Category'',''M_Product_Category_Acct'',''M_Product_PO'',''M_Product_QualityTest'',''M_ProductDownload'',''M_Production'',''M_ProductionLine'',''M_ProductionLineMA'',''M_ProductionPlan'',''M_ProductOperation'',''M_ProductPrice'',''M_ProductPriceVendorBreak'',''M_Promotion'',''M_PromotionDistribution'',''M_PromotionGroup'',''M_PromotionGroupLine'',''M_PromotionLine'',''M_PromotionPreCondition'',''M_PromotionReward'',''M_QualityTest'',''M_QualityTestResult'',''M_RelatedProduct'',''M_Replenish'',''M_Requisition'',''M_RequisitionLine'',''M_RMA'',''M_RMALine'',''M_RMATax'',''M_RMAType'',''M_SerNoCtl'',''M_SerNoCtlExclude'',''M_Shipper'',''M_ShipperCfg'',''M_ShipperLabels'',''M_ShipperLabelsCfg'',''M_ShipperPackaging'',''M_ShipperPackagingCfg'',''M_ShipperPickupTypes'',''M_ShipperPickupTypesCfg'',''M_ShippingProcessor'',''M_ShippingProcessorCfg'',''M_ShippingTransaction'',''M_ShippingTransactionLine'',''M_StorageOnHand'',''M_StorageReservation'',''M_Substitute'',''M_Transaction'',''M_TransactionAllocation'',''M_Warehouse'',''M_Warehouse_Acct'',''PA_Achievement'',''PA_Benchmark'',''PA_BenchmarkData'',''PA_ColorSchema'',''PA_DashboardContent'',''PA_DashboardContent_Access'',''PA_DashboardPreference'',''PA_DocumentStatus'',''PA_Goal'',''PA_GoalRestriction'',''PA_Hierarchy'',''PA_Measure'',''PA_MeasureCalc'',''PA_Ratio'',''PA_RatioElement'',''PA_Report'',''PA_ReportColumn'',''PA_ReportColumnSet'',''PA_ReportCube'',''PA_ReportLine'',''PA_ReportLineSet'',''PA_ReportSource'',''PA_SLA_Criteria'',''PA_SLA_Goal'',''PA_SLA_Measure'',''PP_Cost_Collector'',''PP_Cost_CollectorMA'',''PP_MRP'',''PP_Order'',''PP_Order_BOM'',''PP_Order_BOMLine'',''PP_Order_Cost'',''PP_Order_Node'',''PP_Order_Node_Asset'',''PP_Order_Node_Product'',''PP_Order_NodeNext'',''PP_Order_Workflow'',''PP_Product_BOM'',''PP_Product_BOMLine'',''PP_Product_Planning'',''PP_WF_Node_Asset'',''PP_WF_Node_Product'',''QM_Specification'',''QM_SpecificationLine'',''R_Category'',''R_CategoryUpdates'',''R_ContactInterest'',''R_Group'',''R_GroupUpdates'',''R_InterestArea'',''R_IssueKnown'',''R_IssueProject'',''R_IssueRecommendation'',''R_IssueStatus'',''R_IssueSystem'',''R_IssueUser'',''R_MailText'',''R_Request'',''R_RequestAction'',''R_RequestProcessor'',''R_RequestProcessor_Route'',''R_RequestProcessorLog'',''R_RequestType'',''R_RequestTypeUpdates'',''R_RequestUpdate'',''R_RequestUpdates'',''R_Resolution'',''R_StandardResponse'',''R_Status'',''R_StatusCategory'',''RV_BPartner'',''RV_WarehousePrice'',''S_ExpenseType'',''S_Resource'',''S_ResourceAssignment'',''S_ResourceType'',''S_ResourceUnAvailable'',''S_TimeExpense'',''S_TimeExpenseLine'',''S_TimeType'',''S_Training'',''S_Training_Class'',''T_1099Extract'',''T_Aging'',''T_BankRegister'',''T_BOM_Indented'',''T_BOMLine'',''T_CashFlow'',''T_DistributionRunDetail'',''T_InventoryValue'',''T_InvoiceGL'',''T_MRP_CRP'',''T_Reconciliation'',''T_Replenish'',''T_Report'',''T_ReportStatement'',''T_Transaction'',''Test'',''U_BlackListCheque'',''U_POSTerminal'',''U_RoleMenu'',''U_Web_Properties'',''U_WebMenu'',''WS_WebService'',''WS_WebService_Para'',''WS_WebServiceFieldInput'',''WS_WebServiceFieldOutput'',''WS_WebServiceMethod'',''WS_WebServiceType'',''WS_WebServiceTypeAccess''',
	 '2024-04-04 19:08:54.096000', 100, 'org.bandahealth.idempiere.graphql.resolver.mutation');

-- Done!
SELECT
	update_sequences();

SELECT
	register_migration_script('202401010000_GrapqQL.sql')
FROM
	dual;
