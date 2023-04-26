/**********************************************************************************************************/
-- Separate out a visit from an order
--  1. Create new bh_visit table
--  2. Create document sequence for the visits
--  3. Migrate data from c_order to bh_visit
--  4. Point anything needing visit stuff currently using c_order to bh_visit
--  5. Delete columns from c_order (and anything that used them that we don't currently use)
--  6. Add bh_visit_id to c_order, c_invoice, m_inout, & c_payment
--  7. Set bh_visit_id column on all tables
--  8. Wrap up
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
	ADD CONSTRAINT cbpartner_p_bhvisit FOREIGN KEY (Patient_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED

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
	 'BH_Visit', 'N', '1', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
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
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
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
	 ), 0, 0, 100, 100, 'Name', 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '91d67bab-b5b0-4ac4-8543-b4262c577409', 'Y', 20, 'N', 'N', NULL,
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
	 ), 10, NULL, NULL, 30, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
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
	 ), 16, NULL, NULL, 7, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
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
-- 4. Point anything needing visit stuff currently using c_order to bh_visit
/**********************************************************************************************************/
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
-- 5. Delete columns from c_order (and anything that used them that we don't currently use)
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
	DROP COLUMN IF EXISTS bh_voided_reason_id;
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
		SELECT ad_column_id FROM ad_column WHERE ad_table_id = 259 AND LOWER(columnname) LIKE 'bh_%'
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = 259
	AND LOWER(columnname) LIKE 'bh_%';

/**********************************************************************************************************/
-- 6. Add bh_visit_id to c_order, c_invoice, m_inout, & c_payment
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
	pa_dashboardcontent_id = NULL,
	placeholder            = NULL,
	ishtml                 = 'N'
WHERE
	ad_column_id = 1000849;

/**********************************************************************************************************/
-- 7. Set bh_visit_id column on all tables
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
-- 8. Wrap up
/**********************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202304241108_GO-2532.sql')
FROM
	dual;
