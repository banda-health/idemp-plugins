/**********************************************************************************************************/
-- Separate out a visit from an order
--  1. Create new bh_visit table
--  2. Create document sequence for the visits
--  3. Migrate data from c_order to bh_visit
--	4. Add bh_visit_id to c_order, c_invoice, & m_inout (c_payment to come later since we're changing
--			an existing column)
--  5. Point anything needing visit stuff currently using c_order to bh_visit
--  6. Delete columns from c_order (and anything that used them that we don't currently use)
--	7. Add bh_visit_id to c_payment by altering bh_c_order_id
--  8. Set bh_visit_id column on all tables
--  9. Wrap up
/**********************************************************************************************************/

/**********************************************************************************************************/
-- 1. Create new bh_visit table
/**********************************************************************************************************/
CREATE TABLE IF NOT EXISTS BH_Visit
(
	BH_Visit_ID                   numeric(10)                      NOT NULL,
	ad_client_id                  numeric(10)                      NOT NULL,
	ad_org_id                     numeric(10)                      NOT NULL,
	isactive                      char         DEFAULT 'Y'::bpchar NOT NULL,
	created                       timestamp    DEFAULT NOW()       NOT NULL,
	createdby                     numeric(10)                      NOT NULL,
	updated                       timestamp    DEFAULT NOW()       NOT NULL,
	updatedby                     numeric(10)                      NOT NULL,
	description                   varchar(255),
	DocumentNo                    varchar(30)                      NOT NULL,
	patient_id                    numeric(10)                      NOT NULL,
	BH_Visit_UU                   varchar(36)  DEFAULT NULL,
	BH_BloodPressure              varchar(100) DEFAULT NULL,
	BH_ChiefComplaint             varchar(100) DEFAULT NULL,
	BH_ClinicalNotes              text         DEFAULT NULL,
	BH_Clinician_User_ID          numeric(10)  DEFAULT NULL,
	bh_diastolic_blood_pressure   numeric(10)  DEFAULT NULL,
	BH_Height                     varchar(100) DEFAULT NULL,
	BH_LabNotes                   text         DEFAULT NULL,
	BH_NewVisit                   CHAR(1)      DEFAULT 'N'::bpchar,
	BH_OxygenSaturation           numeric      DEFAULT NULL,
	BH_PatientType                varchar(10)  DEFAULT 'O',
	BH_PrimaryCodedDiagnosis_ID   numeric(10)  DEFAULT NULL,
	bh_primaryuncodeddiagnosis    text         DEFAULT NULL,
	BH_Process_Stage              varchar(100) DEFAULT NULL,
	BH_Pulse                      varchar(100) DEFAULT NULL,
	bh_referral                   varchar(100) DEFAULT NULL,
	BH_ReferredFromTo             varchar(100) DEFAULT NULL,
	BH_RespiratoryRate            varchar(100) DEFAULT NULL,
	bh_secondarycodeddiagnosis_ID numeric(10)  DEFAULT NULL,
	bh_secondaryuncodeddiagnosis  text         DEFAULT NULL,
	bh_systolic_blood_pressure    numeric(10)  DEFAULT NULL,
	BH_Temperature                varchar(100) DEFAULT NULL,
	BH_VisitDate                  timestamptz  DEFAULT NULL,
	bh_voided_reason_ID           numeric(10)  DEFAULT NULL,
	BH_Weight                     varchar(100) DEFAULT NULL,
	CONSTRAINT bh_visit_key PRIMARY KEY (bh_visit_id)
);

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bh_visit_uu_idx;
ALTER TABLE bh_visit
	ADD CONSTRAINT bh_visit_uu_idx UNIQUE (bh_visit_uu);

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS adclient_bhvisit;
ALTER TABLE bh_visit
	ADD CONSTRAINT adclient_bhvisit FOREIGN KEY (ad_client_id) REFERENCES ad_client DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS adorg_bhvisit;
ALTER TABLE bh_visit
	ADD CONSTRAINT adorg_bhvisit FOREIGN KEY (ad_org_id) REFERENCES ad_org DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bh_visi_bh_primarycodeddiagnos;
ALTER TABLE bh_visit
	ADD CONSTRAINT bh_visi_bh_primarycodeddiagnos FOREIGN KEY (bh_primarycodeddiagnosis_id) REFERENCES bh_coded_diagnosis DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bh_visit_bh_secondarycodeddiag;
ALTER TABLE bh_visit
	ADD CONSTRAINT bh_visit_bh_secondarycodeddiag FOREIGN KEY (bh_secondarycodeddiagnosis_id) REFERENCES bh_coded_diagnosis DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bhvoidedreason_bhvisit;
ALTER TABLE bh_visit
	ADD CONSTRAINT bhvoidedreason_bhvisit FOREIGN KEY (bh_voided_reason_id) REFERENCES bh_voided_reason DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bh_visit_bh_newvisit_check;
ALTER TABLE bh_visit
	ADD CONSTRAINT bh_visit_bh_newvisit_check CHECK (bh_newvisit = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE bh_visit
	DROP CONSTRAINT IF EXISTS bh_visit_isactive_check;
ALTER TABLE bh_visit
	ADD CONSTRAINT bh_visit_isactive_check CHECK (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE BH_Visit
	DROP CONSTRAINT IF EXISTS cbpartner_p_bhvisit;
ALTER TABLE BH_Visit
	ADD CONSTRAINT cbpartner_p_bhvisit FOREIGN KEY (Patient_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;

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
	 ), 0, 0, 'Y', '2023-04-24 11:18:39.433000', 100, '2023-04-24 11:18:39.433000', 100, 'BH_Visit_ID', 'U', 'Visit',
	 'Visit', NULL, NULL, NULL, NULL, NULL, NULL, 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a', NULL)
ON CONFLICT DO NOTHING;
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
	 ), 0, 0, 'Y', '2023-04-25 09:01:05.204000', 100, '2023-04-25 09:01:05.204000', 100, 'Patient_ID', 'U', 'Patient',
	 'Patient', 'The Patient must be a valid business partner.', NULL, NULL, NULL, NULL, NULL,
	 'b7e75979-daae-4d47-9dc1-d15c58f42374', NULL);
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
	 ), 0, 0, 'Y', '2023-04-24 11:18:39.501000', 100, '2023-04-24 11:18:39.501000', 100, 'BH_Visit_UU', 'U',
	 'BH_Visit_UU', 'BH_Visit_UU', NULL, NULL, NULL, NULL, NULL, NULL, 'a699c600-3a66-4151-aadf-4cbfd2118abc', NULL)
ON CONFLICT DO NOTHING;

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
	 ), 0, 0, 'Y', '2023-04-24 11:18:25.089000', 100, '2023-04-24 11:18:25.089000', 100, 'Visit', 'Visit', NULL,
	 'BH_Visit', 'N', '1', 'U', NULL, NULL, 0, 'N', 'Y', 'Y', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'd2c9b934-ef14-483f-ac29-6a68611b0552', 'N', 'N', 'N', 'N')
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_BloodPressure', NULL, NULL, 0, 'U', 'BH_BloodPressure', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fd932aa2-1856-448c-8d13-e2caa4cc9a18'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0cfe2ac9-cd64-492d-966d-373d0cccf018', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_ChiefComplaint', NULL, NULL, 0, 'U', 'BH_ChiefComplaint', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f9e23d7e-abd1-44b4-a83e-8311c25b8f82'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '58e4d45d-bf24-4225-bf33-8f63d3a00f9b', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Height', NULL, NULL, 0, 'U', 'BH_Height', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a4fc780f-3dc3-4b0c-bb4a-26eea119ff55'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '03301cba-14d8-4c1b-8a91-5f566a9f9d2c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Clinician_User_ID', 'BH_Clinician_User_ID', NULL, 0, 'U', 'BH_Clinician_User_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 13, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0dc58523-c362-4ab5-894c-53c95a60f75a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1aa5d014-0270-451b-a902-50862bd3338a', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'bh_diastolic_blood_pressure', NULL, NULL, 0, 'U', 'bh_diastolic_blood_pressure', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 11, NULL, NULL, 3, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'af9ae820-cb81-424c-a4b5-dd4a935e3085'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9e76e902-13ed-44ac-9957-38748277d20e', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Client', 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4687b6cd-2e32-40ff-970d-25b24ddfa2db', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHVisit', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Organization', 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6f34dcd2-d7cc-4865-b0b0-2eb794f3b0c4', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHVisit', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Visit', NULL, NULL, 1, 'U', 'BH_Visit_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ef5e312d-e5c6-45b0-a074-4c70edef02ca', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Visit_UU', NULL, NULL, 1, 'U', 'BH_Visit_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a699c600-3a66-4151-aadf-4cbfd2118abc'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2d1c8203-0319-4ed5-8f0c-064c4c98fb47', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Created', 'Date this record was created',
	 'The Created field indicates the date that this record was created.', 1, 'U', 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '733a40e4-10e2-417f-99a8-1ad9c62b94cf', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Created By', 'User who created this records',
	 'The Created By field indicates the user who created this record.', 1, 'U', 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7d8a86ff-7098-444f-97f0-57abe4af5253', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Description', 'Optional short description of the record',
	 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0d719444-f53a-4872-840f-26205207616a', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Active', 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports on conflict do nothing.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e3ca8199-48a5-443f-97e0-9cd5b6580a10', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Updated', 'Date this record was updated',
	 'The Updated field indicates the date that this record was updated.', 1, 'U', 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dbbc0862-e20e-45a5-9576-b5cf5b42952b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Updated By', 'User who updated this records',
	 'The Updated By field indicates the user who updated this record.', 1, 'U', 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '23f0033e-4b39-4cf7-b0f3-ec0c5468540c', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Document No', 'Document sequence number of the document', e'The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>" on conflict do nothing.

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',
	 0, 'U', 'DocumentNo', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 30, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a2369a26-f17f-4788-acb0-2b963701c940'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2fd7b023-a874-4da8-8a85-4fd8def66bba', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Clinical Notes', NULL, NULL, 0, 'U', 'BH_ClinicalNotes', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'adea5e22-a52b-4da5-84fd-ea2489d50f3c'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9bcfded3-3af9-41d3-94ae-319d1859bb30', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Patient Type', NULL, NULL, 0, 'U', 'BH_PatientType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, 10, 'O', 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5e3e6279-0c10-46b0-b889-801586fe436c'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1a52b028-4e6d-434d-a8f4-43d9c5755423', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Lab Notes', NULL, NULL, 0, 'U', 'BH_LabNotes', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bf639c29-b21a-4db0-890e-eff72fabc076'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '345d1405-6bfe-4cb9-9ece-f60477f46a08', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'New Visit', NULL, NULL, 0, 'U', 'BH_NewVisit', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 20, NULL, NULL, 10, 'N', 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ebccd7a9-e6e7-4aa7-b4bf-879972f5e4ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd6eb599d-87a5-4be5-993d-9cfcd5aceb92', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Oxygen Saturation', NULL, NULL, 0, 'U', 'BH_OxygenSaturation', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 12, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '8011a89c-8f43-4552-babf-7e77507d71ab'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8dc7142c-10da-4499-b4bb-877fab7c716c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_PrimaryCodedDiagnosis_ID', NULL, NULL, 0, 'U', 'BH_PrimaryCodedDiagnosis_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'c2528a7c-1a68-472c-81d1-abbf603c7783'
	 ), NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a93d401a-dbf0-4f1b-a967-c8f7d4f1f79d'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f9556ee9-de59-453f-a45c-f076f4543bf3', 'Y', 0, 'N', 'N', NULL,
	 'bh_visi_bh_primarycodeddiagnos', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'bh_primaryuncodeddiagnosis', NULL, NULL, 0, 'U', 'bh_primaryuncodeddiagnosis', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 14, NULL, NULL, 2147483647, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2c1d012e-c038-4b87-90f8-a408fc501dbb'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e99b4f41-ad71-4bab-adf1-12650990cebe', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Process_Stage', 'Drop down field in visits for users to define the process stage', NULL, 0,
	 'U', 'BH_Process_Stage', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b24e7939-f43e-4add-9fe9-a03b0d862675'
	 ), NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e9ac067d-f564-4a4d-a319-c632c6b21774'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b334317c-e0f4-40f0-a738-bc14fa7b922b', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Pulse', NULL, NULL, 0, 'U', 'BH_Pulse', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6be46897-4408-4080-afe5-4bdcf199b12e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4a54eba3-5712-44cc-bb3c-be8e4d618e69', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Referral', NULL, NULL, 0, 'U', 'bh_referral', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '090f3a94-25a4-4f65-a270-96732df35407'
	 ), NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c2850e0b-38f4-4822-ad54-42d0ea369641'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '80024505-fb16-4b1a-be64-9ee41afc2fe8', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Referred From/To', NULL, NULL, 0, 'U', 'BH_ReferredFromTo', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '44246b9e-5ad4-4b01-8eb1-8410c513a521'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd7c81670-e037-4e3c-9454-e9d88b29c2fb', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_RespiratoryRate', NULL, NULL, 0, 'U', 'BH_RespiratoryRate', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46dd8a18-ede7-462d-8f30-85eb56c628f4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c39eb4d2-92e2-4edb-af60-e909cca39ff3', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'bh_secondarycodeddiagnosis_ID', NULL, NULL, 0, 'U', 'bh_secondarycodeddiagnosis_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'c2528a7c-1a68-472c-81d1-abbf603c7783'
	 ), NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '80d9a9f5-f266-47ec-bb64-6aab3611fa91'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'bd8eeac9-7940-48c6-9b39-724b607f5275', 'Y', 0, 'N', 'N', NULL,
	 'bh_visit_bh_secondarycodeddiag', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'bh_secondaryuncodeddiagnosis', NULL, NULL, 0, 'U', 'bh_secondaryuncodeddiagnosis', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 14, NULL, NULL, 2147483647, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fc9336f9-82f5-4719-90ab-68243a2583b0'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6a74fa3f-f605-4922-91bb-48cbabe73840', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'bh_systolic_blood_pressure', NULL, NULL, 0, 'U', 'bh_systolic_blood_pressure', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 11, NULL, NULL, 3, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0713378f-718f-4a56-9e3a-e71ebdaa6ddf'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9aa46e92-7db9-432d-a6e2-6074294ee431', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Temperature', NULL, NULL, 0, 'U', 'BH_Temperature', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '836e0d1f-b921-4582-8681-a17db1ad19d5'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'abf8f199-df91-4e86-9aea-1be26988985f', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Visit Date', NULL, NULL, 0, 'U', 'BH_VisitDate', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 16, NULL, NULL, 7, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ee46f65a-610f-4396-a994-cb2e722a864d'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ee4a2d92-b848-414a-b272-881f3df597c6', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Voided Reason', NULL, NULL, 0, 'U', 'bh_voided_reason_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9f1bb1b0-353c-4f5c-a034-e5faea969b35'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '26f6dd82-82d5-43e1-9ef6-d1ecaf14af30', 'Y', 0, 'N', 'N', NULL,
	 'bhvoidedreason_BHVisit', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version,
	           entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier,
	           seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn,
	           ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic,
	           infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy,
	           seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype,
	           pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'BH_Weight', NULL, NULL, 0, 'U', 'BH_Weight', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5818719f-2ca4-4204-bb6d-48e27426a30b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c1a0c77f-ee6d-413b-957f-a97d927bac8d', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2023-04-25 09:02:38.874000', '2023-04-25 09:14:23.419000', 100, 100, 'Patient',
	 'The Patient must be a valid business partner.', NULL, 0, 'U', 'Patient_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 18, 173, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b7e75979-daae-4d47-9dc1-d15c58f42374'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '948a726d-0219-4051-a7e0-a04441e17cf9', 'Y', 0, 'N', 'N', NULL,
	 'cbpartner_p_bhvisit', 'N', NULL, NULL)
ON CONFLICT DO NOTHING;

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
	 ), 0, 0, 'Y', '2023-04-24 11:18:25.184000', 100, '2023-04-24 11:18:25.184000', 100, 'BH_Visit', 'Table BH_Visit',
	 NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'f6dbc588-2ea5-450f-a156-ec45367a68d6', 'N', 'N', NULL)
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- 2. Create document sequence for the visits
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_ad_sequence;
CREATE TEMP TABLE tmp_ad_sequence
(
	ad_sequence_id serial                                     NOT NULL,
	ad_client_id   numeric(10)                                NOT NULL,
	ad_org_id      numeric(10)  DEFAULT 0                     NOT NULL,
-- 	isactive           char        DEFAULT 'Y'::bpchar,
-- 	created            timestamp   DEFAULT NOW()       NOT NULL,
	createdby      numeric(10)  DEFAULT 100                   NOT NULL,
-- 	updated            timestamp   DEFAULT NOW()       NOT NULL,
	updatedby      numeric(10)  DEFAULT 100                   NOT NULL,
	name           varchar(60)  DEFAULT 'DocumentNo_BH_Visit' NOT NULL,
	description    varchar(255) DEFAULT 'DocumentNo/Value for Table BH_Visit',
	vformat        varchar(40)  DEFAULT NULL,
-- 	isautosequence     char        DEFAULT 'Y'::bpchar NOT NULL,
	incrementno    numeric(10)  DEFAULT 1                     NOT NULL,
	startno        numeric(10)  DEFAULT 1000000               NOT NULL,
	currentnext    numeric(10)  DEFAULT 1000000               NOT NULL,
	currentnextsys numeric(10)  DEFAULT 200000                NOT NULL,
-- 	isaudited          char        DEFAULT 'N'::bpchar,
-- 	istableid          char        DEFAULT 'N'::bpchar,
	prefix         varchar(255) DEFAULT NULL,
	suffix         varchar(255) DEFAULT NULL,
-- 	startnewyear       char        DEFAULT 'N'::bpchar,
	datecolumn     varchar(60)  DEFAULT NULL,
	decimalpattern varchar(40)  DEFAULT NULL,
	ad_sequence_uu varchar(36)  DEFAULT uuid_generate_v4()
-- 	startnewmonth      char         DEFAULT 'N'::bpchar           NOT NULL,
-- 	isorglevelsequence char         DEFAULT 'N'::bpchar           NOT NULL,
-- 	orgcolumn          varchar(60)  DEFAULT NULL::character varying
);

SELECT
	SETVAL(
			'tmp_ad_sequence_ad_sequence_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'AD_Sequence'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_ad_sequence (ad_client_id)
SELECT DISTINCT
	ad_client_id
FROM
	ad_sequence
WHERE
	name = 'DocumentNo_C_Order';

INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, vformat, incrementno,
	             startno, currentnext, currentnextsys, prefix, suffix, datecolumn, decimalpattern)
SELECT
	ad_sequence_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	vformat,
	incrementno,
	startno,
	currentnext,
	currentnextsys,
	prefix,
	suffix,
	datecolumn,
	decimalpattern
FROM
	tmp_ad_sequence
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- 3. Create the window & menu for the new visits table
/**********************************************************************************************************/
-- First, add the references
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	              name, description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu,
	              ad_element_id)
VALUES
	((
		 SELECT MAX(ad_reference_id) + 1
		 FROM ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:36:44.380000', 100, '2023-05-08 16:41:35.127000', 100,
	 'RelType BH_Visit <= C_Order_ID', NULL, NULL, 'T', NULL, 'U', 'N', '5879f245-335a-4604-b1c7-7bcabf729128', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:44:25.961000', 100, '2023-05-08 16:44:25.961000', 100, 'RelType C_Order <= BH_Visit_ID',
	 NULL, NULL, 'T', NULL, 'U', 'N', '678185b3-6382-4469-ae8f-5428983458a1', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:55:39.124000', 100, '2023-05-08 16:55:39.124000', 100, 'RelType BH_Visit <= M_InOut_ID',
	 NULL, NULL, 'T', NULL, 'U', 'N', 'a9efff18-bdf6-46d3-92b8-c3164a2a9a8b', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:56:45.974000', 100, '2023-05-08 16:56:45.974000', 100, 'RelType M_InOut <= BH_Visit_ID',
	 NULL, NULL, 'T', NULL, 'U', 'N', 'a8388d2d-a496-41dc-89e2-5817bc387bab', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:58:14.373000', 100, '2023-05-08 16:58:14.373000', 100,
	 'RelType BH_Visit <= C_Invoice_ID', NULL, NULL, 'T', NULL, 'U', 'N', '14a589c1-1c05-4ea7-b74d-37c8a173235d', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 16:59:18.362000', 100, '2023-05-08 16:59:18.362000', 100,
	 'RelType C_Invoice <= BH_Visit_ID', NULL, NULL, 'T', NULL, 'U', 'N', 'dffc9d5b-0fa2-40eb-9a22-aa5414e65622', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 17:00:07.822000', 100, '2023-05-08 17:00:07.822000', 100,
	 'RelType BH_Visit <= C_Payment_ID', NULL, NULL, 'T', NULL, 'U', 'N', '3ff49d73-f780-479b-aaf1-f039afef733e', NULL);
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2023-05-08 17:00:46.504000', 100, '2023-05-08 17:00:46.504000', 100,
	 'RelType C_Payment <= BH_Visit_ID', NULL, NULL, 'T', NULL, 'U', 'N', 'e3ecfd13-f6c6-454c-9983-c85660a14044', NULL);

-- Then add the reference table information
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5879f245-335a-4604-b1c7-7bcabf729128'
	 ), 0, 0, 'Y', '2023-05-08 16:37:36.710000', 100, '2023-05-08 16:50:28.707000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ef5e312d-e5c6-45b0-a074-4c70edef02ca'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2fd7b023-a874-4da8-8a85-4fd8def66bba'
	 ), 'N', 'BH_Visit_ID=(SELECT BH_Visit_ID FROM C_Order WHERE C_Order_ID = @C_Order_ID@)', 'DocumentNo', 'U', NULL,
	 'f1a4ba26-1380-460e-9d38-569f0f1286df', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '678185b3-6382-4469-ae8f-5428983458a1'
	 ), 0, 0, 'Y', '2023-05-08 16:45:05.444000', 100, '2023-05-08 16:50:25.255000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '45ae7b81-2051-47ee-a5ac-278dac67b7cb'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '58a2a4a3-3b74-4b2b-a05f-85a3ba4cc7d7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c334f1f0-274a-44ce-8e27-52e2ea3f44d4'
	 ), 'N', 'BH_Visit_ID=@BH_Visit_ID@', 'DocumentNo', 'U', NULL, '30ddf009-f4d7-496d-bc11-5444f242baff', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'a9efff18-bdf6-46d3-92b8-c3164a2a9a8b'
	 ), 0, 0, 'Y', '2023-05-08 16:56:27.887000', 100, '2023-05-08 16:56:27.887000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ef5e312d-e5c6-45b0-a074-4c70edef02ca'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2fd7b023-a874-4da8-8a85-4fd8def66bba'
	 ), 'N', 'BH_Visit_ID=(SELECT BH_Visit_ID FROM M_InOut WHERE M_InOut_ID=@M_InOut_ID@)', 'DocumentNo', 'U', NULL,
	 '7347ab25-1677-4b99-8221-fe0086462e2e', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'a8388d2d-a496-41dc-89e2-5817bc387bab'
	 ), 0, 0, 'Y', '2023-05-08 16:57:19.760000', 100, '2023-05-08 17:09:55.373000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd3f7821b-1d9f-4031-b8e7-5ca1ebd120d2'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '6e75497c-c09f-4135-aa02-c5495d218f8a'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd0007e67-dc25-484d-8e71-000c9b6f418a'
	 ), 'N', 'BH_Visit_ID=@BH_Visit_ID@', 'DocumentNo', 'U', NULL, 'f41f3da3-a5a1-4d8c-b345-eb47c6f921e9', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '14a589c1-1c05-4ea7-b74d-37c8a173235d'
	 ), 0, 0, 'Y', '2023-05-08 16:58:56.365000', 100, '2023-05-08 16:58:56.365000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ef5e312d-e5c6-45b0-a074-4c70edef02ca'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2fd7b023-a874-4da8-8a85-4fd8def66bba'
	 ), 'N', 'BH_Visit_ID=(SELECT BH_Visit_ID FROM C_Invoice WHERE C_Invoice_ID=@C_Invoice_ID@)', 'DocumentNo', 'U', NULL,
	 'd6b73806-c2e5-4bff-a49b-8dac2e709b9a', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'dffc9d5b-0fa2-40eb-9a22-aa5414e65622'
	 ), 0, 0, 'Y', '2023-05-08 16:59:38.117000', 100, '2023-05-08 16:59:38.117000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '98b87058-b549-4bd2-90e5-b1caa61b558c'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd9f206f6-80ad-471d-9611-53a4fe85fe5e'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '47ea7b2e-6a54-41f2-93d1-2b0357ccbd13'
	 ), 'N', 'BH_Visit_ID=@BH_Visit_ID@', 'DocumentNo', 'U', NULL, 'f27514f5-8c66-4ec0-a8f2-f9682a6674b0', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3ff49d73-f780-479b-aaf1-f039afef733e'
	 ), 0, 0, 'Y', '2023-05-08 17:00:34.481000', 100, '2023-05-08 17:00:34.481000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ef5e312d-e5c6-45b0-a074-4c70edef02ca'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2fd7b023-a874-4da8-8a85-4fd8def66bba'
	 ), 'N', 'BH_Visit_ID=(SELECT BH_Visit_ID FROM C_Payment WHERE C_Payment_ID=@C_Payment_ID@)', 'DocumentNo', 'U', NULL,
	 '503b8da5-7f9c-4df1-98de-bea93f1556f5', NULL)
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'e3ecfd13-f6c6-454c-9983-c85660a14044'
	 ), 0, 0, 'Y', '2023-05-08 17:01:02.924000', 100, '2023-05-08 17:01:02.924000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f140f2e8-89de-4896-8019-416b9a45c7d6'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'a3159ca0-3114-4f1b-965a-7200e8e477e1'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '12a465b8-c77a-44b5-bc01-9cef7dd64614'
	 ), 'N', 'BH_Visit_ID=@BH_Visit_ID@', 'DocumentNo', 'U', NULL, '47c56915-69d8-4c05-81e6-7f53f85e0657', NULL)
ON CONFLICT DO NOTHING;

-- Now add the relation types
INSERT INTO
	ad_relationtype (ad_client_id, ad_org_id, ad_reference_source_id, ad_reference_target_id, ad_relationtype_id, created,
	                 createdby, description, isactive, isdirected, name, role_source, role_target, type, updated,
	                 updatedby, ad_relationtype_uu)
VALUES
	(0, 0,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5879f245-335a-4604-b1c7-7bcabf729128'
	 ),
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '678185b3-6382-4469-ae8f-5428983458a1'
	 ),
	 (
		 SELECT currentnext FROM ad_sequence WHERE LOWER(name) = 'ad_relationtype'
	 ), '2023-05-08 16:39:29.816000', 100, NULL, 'Y', 'N', 'BH_Visit <-> C_Order', NULL, NULL, 'I',
	 '2023-05-08 16:46:37.368000', 100, 'c51d581c-edf6-41c5-9890-a320df747646')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_relationtype (ad_client_id, ad_org_id, ad_reference_source_id, ad_reference_target_id, ad_relationtype_id, created,
	                 createdby, description, isactive, isdirected, name, role_source, role_target, type, updated,
	                 updatedby, ad_relationtype_uu)
VALUES
	(0, 0,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'a9efff18-bdf6-46d3-92b8-c3164a2a9a8b'
	 ),
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'a8388d2d-a496-41dc-89e2-5817bc387bab'
	 ),
	 (
		 SELECT
			 MAX(ad_relationtype_id) + 1
		 FROM
			 ad_relationtype
	 ), '2023-05-08 16:55:14.869000', 100, NULL, 'Y', 'N', 'BH_Visit <-> M_InOut', NULL, NULL, 'I',
	 '2023-05-08 16:57:43.783000', 100, '60345ca9-88a4-4f36-9621-e3fe79edb7f8')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_relationtype (ad_client_id, ad_org_id, ad_reference_source_id, ad_reference_target_id, ad_relationtype_id, created,
	                 createdby, description, isactive, isdirected, name, role_source, role_target, type, updated,
	                 updatedby, ad_relationtype_uu)
VALUES
	(0, 0,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '14a589c1-1c05-4ea7-b74d-37c8a173235d'
	 ),
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'dffc9d5b-0fa2-40eb-9a22-aa5414e65622'
	 ),
	 (
		 SELECT
			 MAX(ad_relationtype_id) + 1
		 FROM
			 ad_relationtype
	 ), '2023-05-08 16:58:05.203000', 100, NULL, 'Y', 'N', 'BH_Visit <-> C_Invoice', NULL, NULL, 'I',
	 '2023-05-08 16:59:48.497000', 100, '5ca1a0bf-4321-48a8-b392-4813b4e856dc')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_relationtype (ad_client_id, ad_org_id, ad_reference_source_id, ad_reference_target_id, ad_relationtype_id, created,
	                 createdby, description, isactive, isdirected, name, role_source, role_target, type, updated,
	                 updatedby, ad_relationtype_uu)
VALUES
	(0, 0,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3ff49d73-f780-479b-aaf1-f039afef733e'
	 ),
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'e3ecfd13-f6c6-454c-9983-c85660a14044'
	 ),
	 (
		 SELECT
			 MAX(ad_relationtype_id) + 1
		 FROM
			 ad_relationtype
	 ), '2023-05-08 16:59:58.766000', 100, NULL, 'Y', 'N', 'BH_Visit <-> C_Payment', NULL, NULL, 'I',
	 '2023-05-08 17:01:14.105000', 100, 'f52ad02a-6b93-40b5-b6fd-6d3b252b9f19')
ON CONFLICT DO NOTHING;

-- With the Zoom functionality in place, add the WTF
-- Window
INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight,
	           winwidth, isbetafunctionality, ad_window_uu, titlelogic)
VALUES
	((
		 SELECT
			 MAX(ad_window_id) + 1
		 FROM
			 ad_window
	 ), 0, 0, 'Y', '2023-05-08 06:51:10.482000', 100, '2023-05-08 06:51:10.482000', 100, 'Visits',
	 'This shows all the information pertaining to a visit', NULL, 'M', 'Y', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N',
	 '317cb386-251c-4e91-90bd-204f6d4c3931', NULL)
ON CONFLICT DO NOTHING;

-- Tabs
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
			 MAX(ad_tab_id) + 1
		 FROM
			 ad_tab
	 ), 0, 0, 'Y', '2023-05-08 06:51:36.575000', 100, '2023-05-08 06:51:36.575000', 100, 'Visit Information', NULL, NULL,
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '317cb386-251c-4e91-90bd-204f6d4c3931'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '96d2f64c-a773-4dbd-8e1a-1b439ea95858', NULL, 'B', 0)
ON CONFLICT DO NOTHING;

-- Fields
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.168000', 100, '2023-05-08 06:51:44.168000', 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4687b6cd-2e32-40ff-970d-25b24ddfa2db'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '2255697a-83d7-4a97-abcc-d517743f91cf', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.220000', 100, '2023-05-08 06:51:44.220000', 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '6f34dcd2-d7cc-4865-b0b0-2eb794f3b0c4'
	 ), NULL, 'Y', NULL, 22, 'N', 20, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '55a8273b-7eb6-452f-b7e4-ce7d37df2080', 'Y', 10, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.240000', 100, '2023-05-08 07:02:05.814000', 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0d719444-f53a-4872-840f-26205207616a'
	 ), NULL, 'Y', NULL, 255, 'N', 230, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '1547f39a-5f0a-46df-a7de-d78d50c46e6a', NULL, 20, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.260000', 100, '2023-05-08 07:02:05.753000', 100, 'BH_BloodPressure', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '0cfe2ac9-cd64-492d-966d-373d0cccf018'
	 ), NULL, 'Y', NULL, 100, 'N', 160, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'a7bd30d3-226c-41a7-ab55-7cbb829b3528', NULL, 30, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.279000', 100, '2023-05-08 07:02:05.780000', 100, 'BH_ChiefComplaint', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '58e4d45d-bf24-4225-bf33-8f63d3a00f9b'
	 ), NULL, 'Y', NULL, 100, 'N', 190, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '951d35f7-40fc-4eaf-9e45-8cef97f49a63', NULL, 40, 'Y', 1, 1, 5, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.299000', 100, '2023-05-08 07:02:05.717000', 100, 'BH_Height', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '03301cba-14d8-4c1b-8a91-5f566a9f9d2c'
	 ), NULL, 'Y', NULL, 100, 'N', 130, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'aac3d7b7-ee02-41c5-ab98-73e81c2fdc51', NULL, 50, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.318000', 100, '2023-05-08 07:02:05.671000', 100, 'BH_Clinician_User_ID',
	 'BH_Clinician_User_ID', NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1aa5d014-0270-451b-a902-50862bd3338a'
	 ), NULL, 'Y', NULL, 100, 'N', 80, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9daa4e56-8028-4739-ac0f-d614bd8659f1', NULL, 60, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.338000', 100, '2023-05-08 07:02:05.774000', 100, 'bh_diastolic_blood_pressure',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9e76e902-13ed-44ac-9957-38748277d20e'
	 ), NULL, 'Y', NULL, 3, 'N', 180, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '0a97bcc1-4103-4bff-92f0-095deec88935', NULL, 70, 'Y', 5, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.356000', 100, '2023-05-08 07:02:05.872000', 100, 'Visit', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ef5e312d-e5c6-45b0-a074-4c70edef02ca'
	 ), NULL, 'N', NULL, 22, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '7f9a2afe-e883-4fab-ae87-f1cf73a5236b', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.374000', 100, '2023-05-08 07:02:05.867000', 100, 'BH_Visit_UU', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2d1c8203-0319-4ed5-8f0c-064c4c98fb47'
	 ), NULL, 'N', NULL, 36, 'N', 0, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9046eb05-8078-409f-9c12-c66feb84866b', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.408000', 100, '2023-05-08 07:02:05.820000', 100, 'Clinical Notes', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9bcfded3-3af9-41d3-94ae-319d1859bb30'
	 ), NULL, 'Y', NULL, 0, 'N', 240, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'efbdfff4-bac3-47ff-844b-de7f770f06fb', NULL, 90, 'Y', 1, 5, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.426000', 100, '2023-05-08 07:02:05.677000', 100, 'Patient Type', NULL, NULL, 'Y',
	 (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1a52b028-4e6d-434d-a8f4-43d9c5755423'
	 ), NULL, 'Y', NULL, 10, 'N', 90, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '0405a481-3f1b-4f48-bf4a-aee5da6e1d8c', NULL, 100, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.447000', 100, '2023-05-08 07:02:05.826000', 100, 'Lab Notes', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '345d1405-6bfe-4cb9-9ece-f60477f46a08'
	 ), NULL, 'Y', NULL, 0, 'N', 250, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '70807c57-0628-4968-845a-a33e8ea0b7ce', NULL, 110, 'Y', 1, 5, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.466000', 100, '2023-05-08 07:02:05.636000', 100, 'New Visit', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd6eb599d-87a5-4be5-993d-9cfcd5aceb92'
	 ), NULL, 'Y', NULL, 10, 'N', 40, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9020fa6f-c455-4529-8927-0a682bfec629', NULL, 120, 'Y', 5, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.482000', 100, '2023-05-08 07:02:05.808000', 100, 'Oxygen Saturation', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8dc7142c-10da-4499-b4bb-877fab7c716c'
	 ), NULL, 'Y', NULL, 22, 'N', 220, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '81f5b49c-f589-4322-be00-4af535d80ab4', NULL, 130, 'Y', 5, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.500000', 100, '2023-05-08 07:02:05.833000', 100, 'BH_PrimaryCodedDiagnosis_ID',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'f9556ee9-de59-453f-a45c-f076f4543bf3'
	 ), NULL, 'Y', NULL, 10, 'N', 260, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '76fa2c1d-6b0d-4d15-9789-24e893288bd9', NULL, 140, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.513000', 100, '2023-05-08 07:02:05.841000', 100, 'bh_primaryuncodeddiagnosis',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'e99b4f41-ad71-4bab-adf1-12650990cebe'
	 ), NULL, 'Y', NULL, 2147483647, 'N', 270, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 NULL, '88cb767b-200c-4b59-96b8-86158ef75105', NULL, 150, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N',
	 NULL, NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.530000', 100, '2023-05-08 07:02:05.663000', 100, 'BH_Process_Stage',
	 'Drop down field in visits for users to define the process stage', NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'b334317c-e0f4-40f0-a738-bc14fa7b922b'
	 ), NULL, 'Y', NULL, 100, 'N', 70, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '15a7fbf3-66a3-4c51-9e0e-aac3bafbe54a', NULL, 160, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.548000', 100, '2023-05-08 07:02:05.789000', 100, 'BH_Pulse', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4a54eba3-5712-44cc-bb3c-be8e4d618e69'
	 ), NULL, 'Y', NULL, 100, 'N', 200, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '76dc6f9d-03c9-404c-9f90-787a84b75783', NULL, 170, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.568000', 100, '2023-05-08 07:02:05.694000', 100, 'Referral', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '80024505-fb16-4b1a-be64-9ee41afc2fe8'
	 ), NULL, 'Y', NULL, 100, 'N', 110, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'caca39b5-dca7-44ec-a7b9-c20eb0177e34', NULL, 180, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.584000', 100, '2023-05-08 07:02:05.708000', 100, 'Referred From/To', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'd7c81670-e037-4e3c-9454-e9d88b29c2fb'
	 ), NULL, 'Y', NULL, 100, 'N', 120, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'd4458752-e9cb-4c5a-a334-fa137ab36038', NULL, 190, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.603000', 100, '2023-05-08 07:02:05.797000', 100, 'BH_RespiratoryRate', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c39eb4d2-92e2-4edb-af60-e909cca39ff3'
	 ), NULL, 'Y', NULL, 100, 'N', 210, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'ca6b78f5-c55f-4ceb-b077-baa66d11f666', NULL, 200, 'Y', 3, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.620000', 100, '2023-05-08 07:02:05.848000', 100, 'bh_secondarycodeddiagnosis_ID',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'bd8eeac9-7940-48c6-9b39-724b607f5275'
	 ), NULL, 'Y', NULL, 10, 'N', 280, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '50b38cd5-e87a-468d-8b58-1fb00443e312', NULL, 210, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.639000', 100, '2023-05-08 07:02:05.857000', 100, 'bh_secondaryuncodeddiagnosis',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '6a74fa3f-f605-4922-91bb-48cbabe73840'
	 ), NULL, 'Y', NULL, 2147483647, 'N', 290, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 NULL, 'e2b8664b-849c-4a6b-8318-410c01131c05', NULL, 220, 'Y', 4, 3, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N',
	 NULL, NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.657000', 100, '2023-05-08 07:02:05.764000', 100, 'bh_systolic_blood_pressure',
	 NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '9aa46e92-7db9-432d-a6e2-6074294ee431'
	 ), NULL, 'Y', NULL, 3, 'N', 170, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '8c12ac62-f1e0-4150-883f-42e81a7b68cc', NULL, 230, 'Y', 3, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.670000', 100, '2023-05-08 07:02:05.745000', 100, 'BH_Temperature', NULL, NULL,
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'abf8f199-df91-4e86-9aea-1be26988985f'
	 ), NULL, 'Y', NULL, 100, 'N', 150, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '9e14801f-c75d-4602-aed2-b8c486ec06e1', NULL, 240, 'Y', 5, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.685000', 100, '2023-05-08 07:02:05.686000', 100, 'Visit Date', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ee4a2d92-b848-414a-b272-881f3df597c6'
	 ), NULL, 'Y', NULL, 7, 'N', 100, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '45c188be-3adb-40a1-ac8e-3982a4f4420e', NULL, 250, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.701000', 100, '2023-05-08 07:02:05.863000', 100, 'BH_Voided_Reason_ID', NULL,
	 NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '26f6dd82-82d5-43e1-9ef6-d1ecaf14af30'
	 ), NULL, 'Y', NULL, 22, 'N', 300, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '68c1c94a-0f3f-4a3c-b166-e0e0c260fed5', NULL, 260, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.721000', 100, '2023-05-08 07:02:05.732000', 100, 'BH_Weight', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'c1a0c77f-ee6d-413b-957f-a97d927bac8d'
	 ), NULL, 'Y', NULL, 100, 'N', 140, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '78fb5e09-8820-4d71-9e59-b1a75633288a', NULL, 270, 'Y', 3, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.735000', 100, '2023-05-08 07:02:05.645000', 100, 'Patient',
	 'The Patient must be a valid business partner.', NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '948a726d-0219-4051-a7e0-a04441e17cf9'
	 ), NULL, 'Y', NULL, 22, 'N', 50, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '423ef56e-0034-49f6-ade1-eb2f74d4dd36', NULL, 280, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.752000', 100, '2023-05-08 07:02:05.654000', 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'e3ca8199-48a5-443f-97e0-9cd5b6580a10'
	 ), NULL, 'Y', NULL, 1, 'N', 60, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '05ea961c-3031-4d8a-9b80-2e80a7791f88', NULL, 290, 'Y', 5, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-05-08 06:51:44.391000', 100, '2023-05-08 07:02:05.618000', 100, 'Document No',
	 'Document sequence number of the document', e'The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '96d2f64c-a773-4dbd-8e1a-1b439ea95858'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '2fd7b023-a874-4da8-8a85-4fd8def66bba'
	 ), NULL, 'Y', NULL, 30, 'N', 30, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'c3cbb192-f978-4a8c-a768-6fcddbd313a9', NULL, 80, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

-- Lastly, insert the menu
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname)
VALUES
	((
		 SELECT
			 MAX(ad_menu_id) + 1
		 FROM
			 ad_menu
	 ), 0, 0, 'Y', '2023-05-08 07:08:48.440000', 100, '2023-05-08 07:08:48.440000', 'Visits', 100, NULL, 'N', 'Y', 'N',
	 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '317cb386-251c-4e91-90bd-204f6d4c3931'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y', '81295a7e-6f70-4d15-9219-e910296a3fef', NULL, NULL)
ON CONFLICT DO NOTHING;

-- With the menu, insert it's position in the tree
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '81295a7e-6f70-4d15-9219-e910296a3fef'
	), 0, 0, 'Y', '2023-05-08 07:08:48.509927', 100, '2023-05-08 07:08:48.509927', 100, 0, 999,
	 '4a9a735a-adda-404b-b64b-3858d5846cca')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- 4. Update the ad_table entry for bh_visits to use the new window for SO & PO
/**********************************************************************************************************/
UPDATE ad_table t
SET
	ad_window_id = w.ad_window_id,
	po_window_id = w.ad_window_id
FROM
	ad_window w
WHERE
	w.ad_window_uu = '317cb386-251c-4e91-90bd-204f6d4c3931';

/**********************************************************************************************************/
-- 3. Migrate data from c_order to bh_visit
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_bh_visit;
CREATE TEMP TABLE IF NOT EXISTS tmp_bh_visit
(
	bh_visit_id                   serial                           NOT NULL,
	c_order_id                    numeric(10)                      NOT NULL,
	ad_client_id                  numeric(10)                      NOT NULL,
	ad_org_id                     numeric(10)                      NOT NULL,
	isactive                      char         DEFAULT 'Y'::bpchar NOT NULL,
	created                       timestamp    DEFAULT NOW()       NOT NULL,
	createdby                     numeric(10)                      NOT NULL,
	updated                       timestamp    DEFAULT NOW()       NOT NULL,
	updatedby                     numeric(10)                      NOT NULL,
	description                   varchar(255),
	DocumentNo                    varchar(30),
	patient_id                    numeric(10)                      NOT NULL,
	BH_BloodPressure              varchar(100) DEFAULT NULL,
	BH_ChiefComplaint             varchar(100) DEFAULT NULL,
	BH_ClinicalNotes              text         DEFAULT NULL,
	BH_Clinician_User_ID          numeric(10)  DEFAULT NULL,
	bh_diastolic_blood_pressure   numeric(10)  DEFAULT NULL,
	BH_Height                     varchar(100) DEFAULT NULL,
	BH_LabNotes                   text         DEFAULT NULL,
	BH_NewVisit                   CHAR(1)      DEFAULT 'N'::bpchar,
	BH_OxygenSaturation           numeric      DEFAULT NULL,
	BH_PatientType                varchar(10)  DEFAULT 'O',
	BH_PrimaryCodedDiagnosis_ID   numeric(10)  DEFAULT NULL,
	bh_primaryuncodeddiagnosis    text         DEFAULT NULL,
	BH_Process_Stage              varchar(100) DEFAULT NULL,
	BH_Pulse                      varchar(100) DEFAULT NULL,
	bh_referral                   varchar(100) DEFAULT NULL,
	BH_ReferredFromTo             varchar(100) DEFAULT NULL,
	BH_RespiratoryRate            varchar(100) DEFAULT NULL,
	bh_secondarycodeddiagnosis_ID numeric(10)  DEFAULT NULL,
	bh_secondaryuncodeddiagnosis  text         DEFAULT NULL,
	bh_systolic_blood_pressure    numeric(10)  DEFAULT NULL,
	BH_Temperature                varchar(100) DEFAULT NULL,
	BH_Visit_UU                   uuid         DEFAULT uuid_generate_v4(),
	BH_VisitDate                  timestamptz  DEFAULT NULL,
	bh_voided_reason_ID           numeric(10)  DEFAULT NULL,
	BH_Weight                     varchar(100) DEFAULT NULL
);

SELECT
	SETVAL(
			'tmp_bh_visit_bh_visit_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'BH_Visit'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_bh_visit (c_order_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, description,
	              patient_id, bh_bloodpressure, bh_chiefcomplaint, bh_clinicalnotes, bh_clinician_user_id,
	              bh_diastolic_blood_pressure, bh_height, bh_labnotes, bh_newvisit, bh_oxygensaturation, bh_patienttype,
	              bh_primarycodeddiagnosis_id, bh_primaryuncodeddiagnosis, bh_process_stage, bh_pulse, bh_referral,
	              bh_referredfromto, bh_respiratoryrate, bh_secondarycodeddiagnosis_id, bh_secondaryuncodeddiagnosis,
	              bh_systolic_blood_pressure, bh_temperature, bh_visitdate, bh_voided_reason_id, bh_weight)
SELECT
	c_order_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	description,
	c_bpartner_id,
	bh_bloodpressure,
	bh_chiefcomplaint,
	bh_clinicalnotes,
	bh_clinician_user_id,
	bh_diastolic_blood_pressure,
	bh_height,
	bh_labnotes,
	bh_newvisit,
	bh_oxygensaturation,
	bh_patienttype,
	bh_primarycodeddiagnosis_id,
	bh_primaryuncodeddiagnosis,
	bh_process_stage,
	bh_pulse,
	bh_referral,
	bh_referredfromto,
	bh_respiratoryrate,
	bh_secondarycodeddiagnosis_id,
	bh_secondaryuncodeddiagnosis,
	bh_systolic_blood_pressure,
	bh_temperature,
	bh_visitdate,
	bh_voided_reason_id,
	bh_weight
FROM
	c_order
WHERE
	issotrx = 'Y';

-- Do a row count based on client and update the document numbers
UPDATE tmp_bh_visit tv
SET
	documentno = (counts.rownum + 1000000 - 1)::varchar
FROM
	(
		SELECT
			bh_visit_id,
			ROW_NUMBER() OVER (PARTITION BY ad_client_id ORDER BY bh_visit_id) AS rownum
		FROM
			tmp_bh_visit
	) counts
WHERE
	tv.bh_visit_id = counts.bh_visit_id;

INSERT INTO
	bh_visit (BH_Visit_ID, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, description,
	          DocumentNo, BH_Visit_UU, BH_BloodPressure, BH_ChiefComplaint, BH_ClinicalNotes, BH_Clinician_User_ID,
	          bh_diastolic_blood_pressure, BH_Height, BH_LabNotes, BH_NewVisit, BH_OxygenSaturation, BH_PatientType,
	          BH_PrimaryCodedDiagnosis_ID, bh_primaryuncodeddiagnosis, BH_Process_Stage, BH_Pulse, bh_referral,
	          BH_ReferredFromTo, BH_RespiratoryRate, bh_secondarycodeddiagnosis_ID, bh_secondaryuncodeddiagnosis,
	          bh_systolic_blood_pressure, BH_Temperature, BH_VisitDate, bh_voided_reason_ID, BH_Weight, patient_id)
SELECT
	BH_Visit_ID,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	description,
	DocumentNo,
	BH_Visit_UU,
	BH_BloodPressure,
	BH_ChiefComplaint,
	BH_ClinicalNotes,
	BH_Clinician_User_ID,
	bh_diastolic_blood_pressure,
	BH_Height,
	BH_LabNotes,
	BH_NewVisit,
	BH_OxygenSaturation,
	BH_PatientType,
	BH_PrimaryCodedDiagnosis_ID,
	bh_primaryuncodeddiagnosis,
	BH_Process_Stage,
	BH_Pulse,
	bh_referral,
	BH_ReferredFromTo,
	BH_RespiratoryRate,
	bh_secondarycodeddiagnosis_ID,
	bh_secondaryuncodeddiagnosis,
	bh_systolic_blood_pressure,
	BH_Temperature,
	BH_VisitDate,
	bh_voided_reason_ID,
	BH_Weight,
	patient_id
FROM
	tmp_bh_visit;

-- Update all the document number sequences
UPDATE ad_sequence s
SET
	currentnext = maxes.currentnext
FROM
	(
		SELECT
			ad_client_id,
			MAX(documentno::numeric) + 1 AS currentnext
		FROM
			bh_visit
		GROUP BY ad_client_id
	) maxes
WHERE
	s.ad_client_id = maxes.ad_client_id
	AND s.name = 'DocumentNo_BH_Visit';

/**********************************************************************************************************/
-- 4. Add bh_visit_id to c_order, c_invoice, & m_inout (c_payment to come later since we're changing
-- an existing column)
/**********************************************************************************************************/
ALTER TABLE C_Order
	ADD IF NOT EXISTS BH_Visit_ID numeric(10) DEFAULT NULL;
ALTER TABLE C_Order
	DROP CONSTRAINT IF EXISTS BHVisit_COrder;
ALTER TABLE C_Order
	ADD CONSTRAINT BHVisit_COrder FOREIGN KEY (BH_Visit_ID) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE M_InOut
	ADD IF NOT EXISTS BH_Visit_ID numeric(10) DEFAULT NULL;
ALTER TABLE M_InOut
	DROP CONSTRAINT IF EXISTS BHVisit_MInOut;
ALTER TABLE M_InOut
	ADD CONSTRAINT BHVisit_MInOut FOREIGN KEY (BH_Visit_ID) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE C_Invoice
	ADD IF NOT EXISTS BH_Visit_ID numeric(10) DEFAULT NULL;
ALTER TABLE C_Invoice
	DROP CONSTRAINT IF EXISTS BHVisit_CInvoice;
ALTER TABLE C_Invoice
	ADD CONSTRAINT BHVisit_CInvoice FOREIGN KEY (BH_Visit_ID) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

/**********************************************************************************************************/
-- 5. Point anything needing visit stuff currently using c_order to bh_visit
/**********************************************************************************************************/
DROP VIEW IF EXISTS bh_drug_profit_loss_v;
CREATE OR REPLACE VIEW bh_drug_profit_loss_v
			(ad_client_id, ad_org_id, bh_visitdate, name, qtyordered, quantityreceived, pricesold, pricebought, client_name,
			 guaranteedate)
AS
WITH rg AS (
	SELECT
		o.ad_client_id,
		o.ad_org_id,
		ol.m_product_id,
		SUM(ol.qtyordered) AS quantityreceived,
		ol.priceactual     AS pricebought,
		ol.m_warehouse_id,
		t.m_attributesetinstance_id
	FROM
		c_order o
			JOIN c_orderline ol
				ON o.c_order_id = ol.c_order_id
			JOIN m_inoutline iol
				ON ol.c_orderline_id = iol.c_orderline_id
			JOIN m_transaction t
				ON iol.m_inoutline_id = t.m_inoutline_id AND t.movementtype = 'V+'::bpchar
	WHERE
		o.issotrx = 'N'::bpchar
	GROUP BY
		ol.m_product_id, ol.priceactual, ol.m_warehouse_id, o.ad_client_id, o.ad_org_id,
		t.m_attributesetinstance_id
)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	v.bh_visitdate,
	p.name,
	ol.qtyordered,
	rg.quantityreceived,
	ol.priceactual AS pricesold,
	rg.pricebought,
	c.name         AS client_name,
	asi.guaranteedate
FROM
	c_order o
		JOIN c_orderline ol
			ON o.c_order_id = ol.c_order_id AND o.ad_client_id = ol.ad_client_id AND o.ad_org_id = ol.ad_org_id
		JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id
		JOIN m_transaction t
			ON iol.m_inoutline_id = t.m_inoutline_id AND t.movementtype = 'C-'::bpchar
		JOIN rg
			ON t.m_attributesetinstance_id = rg.m_attributesetinstance_id AND ol.m_product_id = rg.m_product_id AND
			   rg.m_warehouse_id = ol.m_warehouse_id
		JOIN m_attributesetinstance asi
			ON t.m_attributesetinstance_id = asi.m_attributesetinstance_id
		JOIN m_product p
			ON ol.m_product_id = p.m_product_id
		JOIN ad_client c
			ON o.ad_client_id = c.ad_client_id
		JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id
WHERE
	o.issotrx = 'Y'::bpchar
ORDER BY
	v.bh_visitdate DESC;

/**********************************************************************************************************/
-- 6. Delete columns from c_order (and anything that used them that we don't currently use)
/**********************************************************************************************************/
DROP VIEW IF EXISTS bh_drug_profit_loss_v;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_bloodpressure;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_chiefcomplaint;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_clinicalnotes;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_clinician_user_id;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_diastolic_blood_pressure;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_docaction;
-- ALTER TABLE c_order DROP COLUMN if EXISTS bh_evaluate_newvisit;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_height;
-- ALTER TABLE c_order DROP COLUMN if EXISTS bh_invcamt;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_isexpense;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_lab_notes;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_labnotes;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_navbuttons;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_newvisit;
-- ALTER TABLE c_order DROP COLUMN if EXISTS bh_numorderlines;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_oxygensaturation;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_patienttype;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_payments;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_primarycodeddiagnosis_id;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_primaryuncodeddiagnosis;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_printaction;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_printnhifffsreportaction;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_printnhifreportaction;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_process_stage;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_pulse;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_referral;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_referredfromto;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_respiratoryrate;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_secondarycodeddiagnosis_id;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_secondaryuncodeddiagnosis;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_seconddiagnosis;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_systolic_blood_pressure;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_temperature;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_visitdate;
ALTER TABLE c_order
	DROP COLUMN IF EXISTS bh_weight;

DELETE
FROM
	bh_tabnavbtn_tab_trl
WHERE
		bh_tabnavbtn_tab_id IN (
		SELECT
			bh_tabnavbtn_tab_id
		FROM
			bh_tabnavbtn_tab
		WHERE
				bh_tabnavbtn_id IN (
				SELECT
					bh_tabnavbtn_id
				FROM
					bh_tabnavbtn
				WHERE
						ad_column_id IN (
						SELECT ad_column_id FROM ad_column WHERE ad_table_id = 259 AND LOWER(columnname) LIKE 'bh_%'
					)
			)
	);
DELETE
FROM
	bh_tabnavbtn_tab
WHERE
		bh_tabnavbtn_id IN (
		SELECT
			bh_tabnavbtn_id
		FROM
			bh_tabnavbtn
		WHERE
				ad_column_id IN (
				SELECT ad_column_id FROM ad_column WHERE ad_table_id = 259 AND LOWER(columnname) LIKE 'bh_%'
			)
	);
DELETE
FROM
	bh_tabnavbtn_trl
WHERE
		bh_tabnavbtn_id IN (
		SELECT
			bh_tabnavbtn_id
		FROM
			bh_tabnavbtn
		WHERE
				ad_column_id IN (
				SELECT ad_column_id FROM ad_column WHERE ad_table_id = 259 AND LOWER(columnname) LIKE 'bh_%'
			)
	);
DELETE
FROM
	bh_tabnavbtn
WHERE
		ad_column_id IN (
		SELECT ad_column_id FROM ad_column WHERE ad_table_id = 259 AND LOWER(columnname) LIKE 'bh_%'
	);
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
			ad_table_id = 259
			AND LOWER(columnname) LIKE 'bh_%'
			AND columnname != 'bh_voided_reason_ID'
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = 259
	AND LOWER(columnname) LIKE 'bh_%'
	AND columnname != 'bh_voided_reason_ID';

/**********************************************************************************************************/
-- 7. Add bh_visit_id to c_payment by altering bh_c_order_id
/**********************************************************************************************************/
ALTER TABLE c_payment
	RENAME COLUMN bh_c_order_id TO bh_visit_id;
DROP INDEX IF EXISTS c_payment_bh_corder_id_index;
CREATE INDEX IF NOT EXISTS c_payment_bh_visit_id_index
	ON c_payment (bh_visit_id);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version, entitytype,
	           columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue,
	           iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted,
	           callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Visit', NULL, NULL, 0, 'U', 'BH_Visit_ID', 259, 19, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'Y',
	 NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8d840880-1948-44d5-b160-c309c8b49716', 'Y', 0, 'N', 'N', NULL,
	 'BHVisit_COrder', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version, entitytype,
	           columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue,
	           iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted,
	           callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Visit', NULL, NULL, 0, 'U', 'BH_Visit_ID', 318, 19, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'Y',
	 NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3d272d31-6f45-41de-92e5-2ed8ec22d41c', 'Y', 0, 'N', 'N', NULL,
	 'BHVisit_CInvoice', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, help, version, entitytype,
	           columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue,
	           iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted,
	           callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 100, 100, 'Visit', NULL, NULL, 0, 'U', 'BH_Visit_ID', 319, 19, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'Y',
	 NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a5413729-1309-4f91-addf-7ed9e0599ec5', 'Y', 0, 'N', 'N', NULL,
	 'BHVisit_MInOut', 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

-- Update the bh_c_order_id column in c_payment
UPDATE ad_column
SET
	ad_client_id           = 0,
	ad_org_id              = 0,
	isactive               = 'Y',
	updated                = '2023-04-24 13:31:34.616000',
	createdby              = 100,
	updatedby              = 100,
	name                   = 'Visit',
	description            = NULL,
	help                   = NULL,
	version                = 0,
	entitytype             = 'U',
	columnname             = 'BH_Visit_ID',
	ad_table_id            = 335,
	ad_reference_id        = 19,
	ad_reference_value_id  = NULL,
	ad_val_rule_id         = NULL,
	fieldlength            = 22,
	defaultvalue           = NULL,
	iskey                  = 'N',
	isparent               = 'N',
	ismandatory            = 'N',
	isupdateable           = 'Y',
	readonlylogic          = NULL,
	isidentifier           = 'N',
	seqno                  = 0,
	istranslated           = 'N',
	isencrypted            = 'N',
	callout                = NULL,
	vformat                = NULL,
	valuemin               = NULL,
	valuemax               = NULL,
	isselectioncolumn      = 'N',
	ad_element_id          = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fdcfe214-3025-418b-b2ee-51e4efcfdf1a'
	),
	ad_process_id          = NULL,
	issyncdatabase         = 'N',
	isalwaysupdateable     = 'N',
	columnsql              = NULL,
	mandatorylogic         = NULL,
	infofactoryclass       = NULL,
	isautocomplete         = 'N',
	isallowlogging         = 'Y',
	formatpattern          = NULL,
	isallowcopy            = 'Y',
	seqnoselection         = 0,
	istoolbarbutton        = 'N',
	issecure               = 'N',
	ad_chart_id            = NULL,
	fkconstraintname       = NULL,
	fkconstrainttype       = 'N',
	pa_dashboardcontent_id = NULL
WHERE
		ad_element_id = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '44545cf6-6e23-465b-9ce3-7b27e17c64c8'
	);

-- Delete the BH_C_Order_ID AD_Element (which was only used on C_Payment)
DELETE
FROM
	ad_element
WHERE
	ad_element_uu = '44545cf6-6e23-465b-9ce3-7b27e17c64c8';

-- Delete some virtual columns from c_payment
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
				ad_column_uu IN ('619e14e6-7a21-4e18-ab89-dde7486392df', 'fbeff64e-7682-40a9-b0cd-bee70e01a729')
	);
DELETE
FROM
	ad_column
WHERE
		ad_column_uu IN ('619e14e6-7a21-4e18-ab89-dde7486392df', 'fbeff64e-7682-40a9-b0cd-bee70e01a729');

-- Delete the BH_RmngInvcAmt AD_Element (which is only used on C_Payment)
DELETE
FROM
	ad_element
WHERE
	ad_element_uu = '6dcbcd3a-5bee-425d-bc8c-59679e61af5f';

/**********************************************************************************************************/
-- 8. Set bh_visit_id column on all tables
/**********************************************************************************************************/
UPDATE c_order o
SET
	bh_visit_id = tv.bh_visit_id
FROM
	tmp_bh_visit tv
WHERE
	tv.c_order_id = o.c_order_id;

UPDATE c_invoice i
SET
	bh_visit_id = tv.bh_visit_id
FROM
	tmp_bh_visit tv
WHERE
	tv.c_order_id = i.c_order_id;

UPDATE m_inout io
SET
	bh_visit_id = tv.bh_visit_id
FROM
	tmp_bh_visit tv
WHERE
	tv.c_order_id = io.c_order_id;

UPDATE c_payment p
SET
	bh_visit_id = tv.bh_visit_id
FROM
	tmp_bh_visit tv
WHERE
	tv.c_order_id = p.bh_visit_id;
UPDATE c_payment
SET
	bh_visit_id = NULL
WHERE
	bh_visit_id = 0;

-- Now we can add the FK constraint
ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS BHVisit_CPayment;
ALTER TABLE c_payment
	ADD CONSTRAINT BHVisit_CPayment FOREIGN KEY (BH_Visit_ID) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

/**********************************************************************************************************/
-- 9. Wrap up
/**********************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202304241108_GO-2532.sql')
FROM
	dual;
