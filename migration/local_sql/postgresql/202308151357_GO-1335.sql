/******************************************************************************************/
-- This script handles transformation of non-patient payments into non-patient payors.
--	1. Perform initial DB updates and clean-up
--	2. Create new tables to hold our data
--	3. Update accounting
--	4. Create new business partner groups for Insurance & Donors (waivers stay separate)
--	5. Migrate all default charges to be BPs
--	6. Update table names to match our new direction
--	7. Remove tables & columns no longer needed
--	8. Wrap-up
/******************************************************************************************/

DROP TABLE IF EXISTS tmp_clients_to_work_with;
SELECT
	ad_client_id
INTO TEMP TABLE
	tmp_clients_to_work_with
FROM
	ad_client
WHERE
	(ad_client_id = 2
		OR ad_client_id > 999999)
	AND isactive = 'Y';

/******************************************************************************************/
--	1. Perform initial DB updates and clean-up
/******************************************************************************************/
-- Delete old columns on c_payment
ALTER TABLE c_payment
	DROP COLUMN BH_MPesaPhnTrx_Num;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_claim_number;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_member_id;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_member_name;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_relationship;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_valid;
ALTER TABLE c_payment
	DROP COLUMN bh_nhif_linda_mama;
ALTER TABLE c_payment
	DROP COLUMN BH_NHIF_Type;
ALTER TABLE c_payment
	DROP COLUMN BH_Processing;
ALTER TABLE c_payment
	DROP COLUMN BH_IsServiceDebt;
ALTER TABLE c_invoice
	DROP COLUMN bh_invoicetype;
ALTER TABLE c_invoice
	DROP COLUMN bh_processing;
ALTER TABLE c_invoice
	DROP COLUMN bh_isexpense;
ALTER TABLE c_invoice
	DROP COLUMN bh_docaction;
ALTER TABLE c_invoice
	DROP COLUMN bh_docaction_2;

DELETE
FROM
	ad_field_trl
WHERE
		ad_field_id IN (
		SELECT
			ad_field_id
		FROM
			ad_field
		WHERE
				ad_column_id IN (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
						LOWER(columnname) IN
						('bh_mpesaphntrx_Num', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name',
						 'bh_nhif_relationship', 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type',
						 'bh_processing', 'bh_isservicedebt', 'bh_invoicetype', 'bh_processing', 'bh_isexpense',
						 'bh_docaction', 'bh_docaction_2')
					AND ad_table_id IN (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename IN ('C_Payment', 'C_BPartner', 'C_Invoice')
					)
			)
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
				LOWER(columnname) IN ('bh_mpesaphntrx_Num', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name',
				                      'bh_nhif_relationship', 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type',
				                      'bh_processing', 'bh_isservicedebt', 'bh_invoicetype', 'bh_processing', 'bh_isexpense',
				                      'bh_docaction', 'bh_docaction_2')
			AND ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename IN ('C_Payment', 'C_BPartner', 'C_Invoice')
			)
	);
DELETE
FROM
	ad_column
WHERE
		LOWER(columnname) IN
		('bh_mpesaphntrx_Num', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name', 'bh_nhif_relationship',
		 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type', 'bh_processing', 'bh_isservicedebt', 'bh_invoicetype',
		 'bh_processing', 'bh_isexpense', 'bh_docaction', 'bh_docaction_2')
	AND ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename IN ('C_Payment', 'C_BPartner', 'C_Invoice')
	);
DELETE
FROM
	ad_element
WHERE
		LOWER(columnname) IN
		('bh_mpesaphntrx_Num', 'bh_nhif_claim_number', 'bh_nhif_member_id', 'bh_nhif_member_name', 'bh_nhif_relationship',
		 'bh_nhif_valid', 'bh_nhif_linda_mama', 'bh_nhif_type', 'bh_processing', 'bh_isservicedebt', 'bh_invoicetype',
		 'bh_processing', 'bh_isexpense', 'bh_docaction', 'bh_docaction_2')
	AND ad_element_id NOT IN (
		SELECT
			ad_element_id
		FROM
			ad_column
	);

-- Rename the reference
UPDATE ad_reference
SET
	name        = 'Non-Patient Payer Category',
	description = 'A category to help differentiate non-patient payers'
WHERE
	ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375';

-- Add columns to c_bp_group & c_bpartner
ALTER TABLE c_bp_group
	ADD COLUMN IF NOT EXISTS bh_subtype varchar(2);
ALTER TABLE c_bpartner
	ADD COLUMN IF NOT EXISTS bh_needadditionalvisitinfo char;
ALTER TABLE c_bpartner
	ADD COLUMN bh_locked char DEFAULT 'N';
ALTER TABLE c_bp_group
	ADD COLUMN bh_locked char DEFAULT 'N';

-- Insert the bh_locked column on c_bp_group
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2023-08-16 01:07:21.492234', '2023-08-16 01:07:21.492234', 100, 100, 'BH_Locked',
	 'Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)',
	 NULL, 0, 'U', 'BH_Locked', 394, 20, NULL, NULL, 1, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL,
	 NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a72b2d6e-eb96-4b6d-9eee-5a099053b43a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4101e1a2-7209-4b96-afd4-ed05a83bd534', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
-- Insert the bh_locked column on c_bpartner
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
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2023-08-16 01:07:21.492234', '2023-08-16 01:07:21.492234', 100, 100, 'BH_Locked',
	 'Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)',
	 NULL, 0, 'U', 'BH_Locked', 291, 20, NULL, NULL, 1, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL,
	 NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a72b2d6e-eb96-4b6d-9eee-5a099053b43a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '05670947-68c9-400e-ae4c-8ab001596fc2', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
-- Insert the bh_subtype column on c_bp_group
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
	 ), 0, 0, 'Y', '2023-08-09 13:08:16.834945', '2023-08-09 13:08:16.834945', 0, 0, 'Sub Type',
	 'Meant to be a sub-type of the charge type', NULL, 0, 'U', 'BH_SubType', 394, 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'
	 ), NULL, 2, 'I', 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'eac953c3-043c-4eb9-b728-7499f9fe7336'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '41ea900e-b13a-462b-b7ec-1cf419789a21', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
-- Insert the bh_needadditionalvisitinfo column on c_bpartner
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
	 ), 0, 0, 'Y', '2023-08-09 13:08:16.834945', '2023-08-09 13:08:16.834945', 0, 0, 'Need Additional Visit Info', NULL,
	 NULL, 0, 'U', 'BH_NeedAdditionalVisitInfo', 291, 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N',
	 NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '28dca3b5-6a5b-4666-8ba7-e65bdf1b76ca'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4311a45e-dd19-4ae2-9dc6-2ed9df87e65c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');

/******************************************************************************************/
--	2. Create new tables to hold our data
/******************************************************************************************/
-- Create the table to hold payer info fields (replacing bh_charge_info)
CREATE TABLE BH_Payer_Info_Field
(
	AD_Client_ID              numeric(10)                                                       NOT NULL,
	AD_Org_ID                 numeric(10)                                                       NOT NULL,
	BH_PayerInfoFieldDataType VARCHAR(2)   DEFAULT 'T'                                          NOT NULL,
	BH_FillFromPatient        CHAR(1)      DEFAULT 'N' CHECK (BH_FillFromPatient IN ('Y', 'N')) NOT NULL,
	BH_Payer_ID               numeric(10)                                                       NOT NULL,
	BH_Payer_Info_Field_ID    numeric(10)                                                       NOT NULL,
	BH_Payer_Info_Field_UU    VARCHAR(36)  DEFAULT NULL,
	Created                   DATE         DEFAULT NOW()                                        NOT NULL,
	CreatedBy                 numeric(10)                                                       NOT NULL,
	Description               VARCHAR(255) DEFAULT NULL,
	IsActive                  CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N'))           NOT NULL,
	Line                      numeric(10)                                                       NOT NULL,
	Name                      VARCHAR(60)                                                       NOT NULL,
	Updated                   DATE         DEFAULT NOW()                                        NOT NULL,
	UpdatedBy                 numeric(10)                                                       NOT NULL,
	CONSTRAINT BH_Payer_Info_Field_Key PRIMARY KEY (BH_Payer_Info_Field_ID),
	CONSTRAINT BH_Payer_Info_Field_UU_idx UNIQUE (BH_Payer_Info_Field_UU)
);
ALTER TABLE BH_Payer_Info_Field
	ADD CONSTRAINT ADClient_BHPayerInfoField FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field
	ADD CONSTRAINT ADOrg_BHPayerInfoField FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field
	ADD CONSTRAINT BHPayer_BHPayerInfoField FOREIGN KEY (BH_Payer_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold payer info field values (replacing bh_payer_info_field_value)
CREATE TABLE BH_Payer_Info_Field_Value
(
	AD_Client_ID                 numeric(10)                                             NOT NULL,
	AD_Org_ID                    numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_ID       numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_Value_ID numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_Value_UU VARCHAR(36)  DEFAULT NULL,
	Created                      DATE         DEFAULT NOW()                              NOT NULL,
	CreatedBy                    numeric(10)                                             NOT NULL,
	Description                  VARCHAR(255) DEFAULT NULL,
	IsActive                     CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Line                         numeric(10)                                             NOT NULL,
	Name                         VARCHAR(60)                                             NOT NULL,
	Updated                      DATE         DEFAULT NOW()                              NOT NULL,
	UpdatedBy                    numeric(10)                                             NOT NULL,
	CONSTRAINT BH_Payer_Info_Field_Value_Key PRIMARY KEY (BH_Payer_Info_Field_Value_ID),
	CONSTRAINT BH_Payer_Info_Field_Valueuuidx UNIQUE (BH_Payer_Info_Field_Value_UU)
);
ALTER TABLE BH_Payer_Info_Field_Value
	ADD CONSTRAINT ADClient_BHPayerInfoFieldValue FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field_Value
	ADD CONSTRAINT ADOrg_BHPayerInfoFieldValue FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field_Value
	ADD CONSTRAINT BHPayerInfoField_BHPayerInfoFi FOREIGN KEY (BH_Payer_Info_Field_ID) REFERENCES bh_payer_info_field (bh_payer_info_field_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold payer info field suggestions (replacing bh_charge_info_suggestion)
CREATE TABLE BH_Payer_Info_Field_Suggestion
(
	AD_Client_ID                      numeric(10)                                                       NOT NULL,
	AD_Org_ID                         numeric(10)                                                       NOT NULL,
	BH_PayerInfoFieldDataType         VARCHAR(2)   DEFAULT 'T'                                          NOT NULL,
	BH_FillFromPatient                CHAR(1)      DEFAULT 'N' CHECK (BH_FillFromPatient IN ('Y', 'N')) NOT NULL,
	BH_Payer_Info_Field_Suggestion_ID numeric(10)                                                       NOT NULL,
	BH_Payer_Info_Field_Suggestion_UU VARCHAR(36)  DEFAULT NULL,
	BH_SubType                        VARCHAR(2)   DEFAULT 'I'                                          NOT NULL,
	Created                           DATE         DEFAULT NOW()                                        NOT NULL,
	CreatedBy                         numeric(10)                                                       NOT NULL,
	Description                       VARCHAR(255) DEFAULT NULL,
	IsActive                          CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N'))           NOT NULL,
	Line                              numeric(10)                                                       NOT NULL,
	Name                              VARCHAR(60)                                                       NOT NULL,
	Updated                           DATE         DEFAULT NOW()                                        NOT NULL,
	UpdatedBy                         numeric(10)                                                       NOT NULL,
	CONSTRAINT BH_Payer_Info_Field_Sugges_Key PRIMARY KEY (BH_Payer_Info_Field_Suggestion_ID)
);
ALTER TABLE BH_Payer_Info_Field_Suggestion
	ADD CONSTRAINT ADClient_BHPayerInfoFieldSugge FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field_Suggestion
	ADD CONSTRAINT ADOrg_BHPayerInfoFieldSuggesti FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold payer info field value suggestions (replacing bh_charge_info_values_suggestion)
CREATE TABLE BH_Payer_Info_Field_Value_Suggestion
(
	AD_Client_ID                            numeric(10)                                             NOT NULL,
	AD_Org_ID                               numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_Suggestion_ID       numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_Value_Suggestion_ID numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_Value_Suggestion_UU VARCHAR(36)  DEFAULT NULL,
	Created                                 DATE         DEFAULT NOW()                              NOT NULL,
	CreatedBy                               numeric(10)                                             NOT NULL,
	Description                             VARCHAR(255) DEFAULT NULL,
	IsActive                                CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Line                                    numeric(10)                                             NOT NULL,
	Name                                    VARCHAR(60)                                             NOT NULL,
	Updated                                 DATE         DEFAULT NOW()                              NOT NULL,
	UpdatedBy                               numeric(10)                                             NOT NULL,
	CONSTRAINT BH_Payer_Info_Field_Value__Key PRIMARY KEY (BH_Payer_Info_Field_Value_Suggestion_ID)
);
ALTER TABLE BH_Payer_Info_Field_Value_Suggestion
	ADD CONSTRAINT ADClient_BHPayerInfoFieldValSu FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field_Value_Suggestion
	ADD CONSTRAINT ADOrg_BHPayerInfoFieldValueSug FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_Payer_Info_Field_Value_Suggestion
	ADD CONSTRAINT BHPayerInfoFieldSuggestion_BHP FOREIGN KEY (BH_Payer_Info_Field_Suggestion_ID) REFERENCES bh_payer_info_field_suggestion (bh_payer_info_field_suggestion_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold BP payer info (replacing bh_bpartner_charge)
CREATE TABLE BH_BP_Payer_Info
(
	AD_Client_ID        numeric(10)                                             NOT NULL,
	AD_Org_ID           numeric(10)                                             NOT NULL,
	BH_BP_Payer_Info_ID numeric(10)                                             NOT NULL,
	BH_BP_Payer_Info_UU VARCHAR(36)  DEFAULT NULL,
	BH_Payer_ID         numeric(10)                                             NOT NULL,
	C_BPartner_ID       numeric(10)                                             NOT NULL,
	Created             DATE         DEFAULT NOW()                              NOT NULL,
	CreatedBy           numeric(10)                                             NOT NULL,
	Description         VARCHAR(255) DEFAULT NULL,
	IsActive            CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Name                VARCHAR(60)  DEFAULT NULL,
	Updated             DATE         DEFAULT NOW()                              NOT NULL,
	UpdatedBy           numeric(10)                                             NOT NULL,
	CONSTRAINT BH_BP_Payer_Info_Key PRIMARY KEY (BH_BP_Payer_Info_ID),
	CONSTRAINT BH_BP_Payer_Info_UU_idx UNIQUE (BH_BP_Payer_Info_UU)
);
ALTER TABLE BH_BP_Payer_Info
	ADD CONSTRAINT ADClient_BHBPPayerInfo FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Payer_Info
	ADD CONSTRAINT ADOrg_BHBPPayerInfo FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Payer_Info
	ADD CONSTRAINT BHPayer_BHBPPayerInfo FOREIGN KEY (BH_Payer_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Payer_Info
	ADD CONSTRAINT CBPartner_BHBPPayerInfo FOREIGN KEY (C_BPartner_ID) REFERENCES c_bpartner (c_bpartner_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold BP general payer info (replacing bh_bpartner_charge_info)
CREATE TABLE BH_BP_General_Payer_Info
(
	AD_Client_ID                numeric(10)                                             NOT NULL,
	AD_Org_ID                   numeric(10)                                             NOT NULL,
	BH_BP_General_Payer_Info_ID numeric(10)                                             NOT NULL,
	BH_BP_General_Payer_Info_UU VARCHAR(36)  DEFAULT NULL,
	BH_BP_Payer_Info_ID         numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_ID      numeric(10)                                             NOT NULL,
	Created                     DATE         DEFAULT NOW()                              NOT NULL,
	CreatedBy                   numeric(10)                                             NOT NULL,
	Description                 VARCHAR(255) DEFAULT NULL,
	IsActive                    CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Name                        VARCHAR(60)                                             NOT NULL,
	Updated                     DATE         DEFAULT NOW()                              NOT NULL,
	UpdatedBy                   numeric(10)                                             NOT NULL,
	CONSTRAINT BH_BP_General_Payer_Info_Key PRIMARY KEY (BH_BP_General_Payer_Info_ID),
	CONSTRAINT BH_BP_General_Payer_Info_uuidx UNIQUE (BH_BP_General_Payer_Info_UU)
);
ALTER TABLE BH_BP_General_Payer_Info
	ADD CONSTRAINT ADClient_BHBPGeneralPayerInfo FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_General_Payer_Info
	ADD CONSTRAINT ADOrg_BHBPGeneralPayerInfo FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_General_Payer_Info
	ADD CONSTRAINT BHBPPayerInfo_BHBPGeneralPayer FOREIGN KEY (BH_BP_Payer_Info_ID) REFERENCES bh_bp_payer_info (bh_bp_payer_info_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_General_Payer_Info
	ADD CONSTRAINT BHPayerInfoField_BHBPGeneralPa FOREIGN KEY (BH_Payer_Info_Field_ID) REFERENCES bh_payer_info_field (bh_payer_info_field_id) DEFERRABLE INITIALLY DEFERRED;

-- Create the table to hold BP specific payer info (replacing bh_orderline_charge_info)
CREATE TABLE BH_BP_Specific_Payer_Info
(
	AD_Client_ID                 numeric(10)                                             NOT NULL,
	AD_Org_ID                    numeric(10)                                             NOT NULL,
	BH_Payer_Info_Field_ID       numeric(10)                                             NOT NULL,
	BH_BP_Specific_Payer_Info_ID numeric(10)                                             NOT NULL,
	BH_BP_Specific_Payer_Info_UU VARCHAR(36)  DEFAULT NULL,
	C_OrderLine_ID               numeric(10)                                             NOT NULL,
	Created                      DATE         DEFAULT NOW()                              NOT NULL,
	CreatedBy                    numeric(10)                                             NOT NULL,
	Description                  VARCHAR(255) DEFAULT NULL,
	IsActive                     CHAR(1)      DEFAULT 'Y' CHECK (IsActive IN ('Y', 'N')) NOT NULL,
	Name                         VARCHAR(60)  DEFAULT NULL,
	Updated                      DATE         DEFAULT NOW()                              NOT NULL,
	UpdatedBy                    numeric(10)                                             NOT NULL,
	CONSTRAINT BH_BP_Specific_Payer_Info_Key PRIMARY KEY (BH_BP_Specific_Payer_Info_ID),
	CONSTRAINT BH_BP_Specific_Payer_Infouuidx UNIQUE (BH_BP_Specific_Payer_Info_UU)
);
ALTER TABLE BH_BP_Specific_Payer_Info
	ADD CONSTRAINT ADClient_BHBPSpecificPayerInfo FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Specific_Payer_Info
	ADD CONSTRAINT ADOrg_BHBPSpecificPayerInfo FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Specific_Payer_Info
	ADD CONSTRAINT BHPayerInfoField_BHBPSpecificP FOREIGN KEY (BH_Payer_Info_Field_ID) REFERENCES bh_payer_info_field (bh_payer_info_field_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_BP_Specific_Payer_Info
	ADD CONSTRAINT COrderLine_BHBPSpecificPayerIn FOREIGN KEY (C_OrderLine_ID) REFERENCES c_orderline (c_orderline_id) DEFERRABLE INITIALLY DEFERRED;

-- Update an existing element that we're going to hijack
UPDATE ad_element
SET
	name       = 'Payer Info Field Data Type',
	printname  = 'Payer Info Field Data Type',
	columnname = 'BH_PayerInfoFieldDataType'
WHERE
	ad_element_uu = '9ebeb2eb-6583-4c55-80a7-1e04fad7c7d8';

-- Insert the new Elements
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.640000', 100, '2023-08-10 16:59:35.640000', 100, 'BH_Payer_Info_Field_ID', 'U',
	 'Payer Info Field', 'Payer Info Field', NULL, NULL, NULL, NULL, NULL, NULL, 'd767b978-2ec9-4f86-b614-f17a6535513f',
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.690000', 100, '2023-08-10 16:59:35.690000', 100, 'BH_Payer_Info_Field_UU', 'U',
	 'BH_Payer_Info_Field_UU', 'BH_Payer_Info_Field_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'd90e9a3d-c190-4a90-92c3-76774928dd66', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:00:06.288000', 100, '2023-08-10 17:00:06.288000', 100, 'BH_Payer_ID', 'U', 'Payer ID',
	 'Payer ID', NULL, NULL, NULL, NULL, NULL, NULL, 'f4b8eed1-e1a1-4f58-95d5-4eef13816625', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.465000', 100, '2023-08-10 17:07:52.465000', 100, 'BH_Payer_Info_Field_Value_ID',
	 'U', 'Payer Info Values', 'Payer Info Values', NULL, NULL, NULL, NULL, NULL, NULL,
	 'a9e534e0-1204-4671-b29c-8ec92921390b', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.502000', 100, '2023-08-10 17:07:52.502000', 100, 'BH_Payer_Info_Field_Value_UU',
	 'U', 'BH_Payer_Info_Field_Value_UU', 'BH_Payer_Info_Field_Value_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '3d6ec214-2785-4fba-b325-9342a996c842', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.636000', 100, '2023-08-10 17:11:09.636000', 100,
	 'BH_Payer_Info_Field_Suggestion_ID', 'U', 'Payer Info Field Suggestion', 'Payer Info Field Suggestion', NULL, NULL,
	 NULL, NULL, NULL, NULL, 'e4859cca-bd6f-4446-8079-ca64c7619fd7', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.676000', 100, '2023-08-10 17:11:09.676000', 100,
	 'BH_Payer_Info_Field_Suggestion_UU', 'U', 'BH_Payer_Info_Field_Suggestion_UU', 'BH_Payer_Info_Field_Suggestion_UU',
	 NULL, NULL, NULL, NULL, NULL, NULL, 'f8d67a52-c7d7-40e6-a07b-bcb83a6c482a', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.632000', 100, '2023-08-10 17:14:34.632000', 100,
	 'BH_Payer_Info_Field_Value_Suggestion_ID', 'U', 'Payer Info Field Value Suggestion',
	 'Payer Info Field Value Suggestion', NULL, NULL, NULL, NULL, NULL, NULL, '78cd8dad-571e-4d6a-a9c3-27c50800ad3f',
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.672000', 100, '2023-08-10 17:14:34.672000', 100,
	 'BH_Payer_Info_Field_Value_Suggestion_UU', 'U', 'BH_Payer_Info_Field_Value_Suggestion_UU',
	 'BH_Payer_Info_Field_Value_Suggestion_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '74550115-b68f-4d36-97f5-e77fe7521759', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.815000', 100, '2023-08-10 17:20:33.815000', 100, 'BH_BP_Payer_Info_ID', 'U',
	 'Business Partner Payer Information', 'Business Partner Payer Information', NULL, NULL, NULL, NULL, NULL, NULL,
	 '09d13be5-7c3e-442a-90be-0e43fa3bcc4f', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.849000', 100, '2023-08-10 17:20:33.849000', 100, 'BH_BP_Payer_Info_UU', 'U',
	 'BH_BP_Payer_Info_UU', 'BH_BP_Payer_Info_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'd2ad76b0-8e34-4a0f-88f8-6fe13e59ea90', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.680000', 100, '2023-08-10 17:25:19.680000', 100, 'BH_BP_General_Payer_Info_ID',
	 'U', 'Business Partner General Payer Info', 'Business Partner General Payer Info', NULL, NULL, NULL, NULL, NULL,
	 NULL, '492a0ad8-7f29-464a-a996-056f1d77f723', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.719000', 100, '2023-08-10 17:25:19.719000', 100, 'BH_BP_General_Payer_Info_UU',
	 'U', 'BH_BP_General_Payer_Info_UU', 'BH_BP_General_Payer_Info_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '05ccbcb4-b4fd-412c-af64-7066895bcb28', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.616000', 100, '2023-08-10 17:29:14.616000', 100, 'BH_BP_Specific_Payer_Info_ID',
	 'U', 'Business Partner Specific Payer Information', 'Business Partner Specific Payer Information', NULL, NULL, NULL,
	 NULL, NULL, NULL, '9b81af74-68bb-45a7-a98b-03dde124e261', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.654000', 100, '2023-08-10 17:29:14.654000', 100, 'BH_BP_Specific_Payer_Info_UU',
	 'U', 'BH_BP_Specific_Payer_Info_UU', 'BH_BP_Specific_Payer_Info_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'caec92d7-455e-4d4a-9c4a-bdb479e0e6b6', NULL);

-- Insert the new tables
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:06.223000', 100, '2023-08-10 17:29:06.223000', 100,
	 'Business Partner Specific Payer Information', NULL, NULL, 'BH_BP_Specific_Payer_Info', 'N', '3', 'U', NULL, NULL, 0,
	 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y', 'f09bd346-9075-49a1-a6d8-c5ba882c1960', 'N', 'N', 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:09.145000', 100, '2023-08-10 17:25:09.145000', 100,
	 'Business Partner General Payer Info', NULL, NULL, 'BH_BP_General_Payer_Info', 'N', '3', 'U', NULL, NULL, 0, 'N',
	 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y', '18293592-398c-447d-9ca1-ffd585098118', 'N', 'N', 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:20.797000', 100, '2023-08-10 17:20:20.797000', 100,
	 'Business Partner Payer Information', NULL, NULL, 'BH_BP_Payer_Info', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N',
	 'N', 'Y', 'L', NULL, 'N', 'Y', '1f1f63f5-e42e-43fb-b007-1c83f1e59734', 'N', 'N', 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:22.431000', 100, '2023-08-10 17:14:22.431000', 100,
	 'Payer Info Field Value Suggestion',
	 'The suggested values to hold for any list types of payers defaults that will be available to clients', NULL,
	 'BH_Payer_Info_Field_Value_Suggestion', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '417447b6-ce19-46fd-a7fc-0aa737800de2', 'N', 'N', 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 17:10:57.344000', 100, '2023-08-10 17:10:57.344000', 100, 'Payer Info Field Suggestion',
	 NULL, NULL, 'BH_Payer_Info_Field_Suggestion', 'N', '4', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N',
	 'Y', '365c340b-fc56-4aff-ae65-c1af9e5a5e36', 'N', 'N', 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:41.362000', 100, '2023-08-10 17:07:41.362000', 100, 'Payer Info Values',
	 'Holds any list values that may be required to limit payer info input', NULL, 'BH_Payer_Info_Field_Value', 'N', '3',
	 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y', '06800b5e-8094-4b77-8b74-32ca2a71e580', 'N', 'N',
	 'N', 'N');
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
	 ), 0, 0, 'Y', '2023-08-10 16:58:43.294000', 100, '2023-08-10 16:58:43.294000', 100, 'Payer Info Field',
	 'A table to dynamically hold extra information for payers', NULL, 'BH_Payer_Info_Field', 'N', '3', 'U', NULL, NULL,
	 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y', '9d22b46b-7f36-4a71-a316-2746cae40cb3', 'N', 'N', 'N', 'N');

-- Insert the new columns
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.707000', '2023-08-10 17:25:19.707000', 100, 100, 'BH_BP_General_Payer_Info_UU',
	 NULL, NULL, 1, 'U', 'BH_BP_General_Payer_Info_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '05ccbcb4-b4fd-412c-af64-7066895bcb28'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9d7ee167-5863-4736-8c8d-6200e6b78213', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.628000', '2023-08-10 16:59:35.628000', 100, 100, 'Payer Info Field', NULL, NULL,
	 1, 'U', 'BH_Payer_Info_Field_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd767b978-2ec9-4f86-b614-f17a6535513f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c3430303-c869-4acd-a2a9-bfadf2a0b848', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.678000', '2023-08-10 16:59:35.678000', 100, 100, 'BH_Payer_Info_Field_UU', NULL,
	 NULL, 1, 'U', 'BH_Payer_Info_Field_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd90e9a3d-c190-4a90-92c3-76774928dd66'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9b71f975-4410-4a41-b6f6-491a5696756e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.731000', '2023-08-10 16:59:35.731000', 100, 100, 'Charge Info Data Type', NULL,
	 NULL, 0, 'U', 'BH_PayerInfoFieldDataType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'
	 ), NULL, 2, 'T', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9ebeb2eb-6583-4c55-80a7-1e04fad7c7d8'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '361c3931-2562-4c4e-b567-58b41f5d3dea', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.763000', '2023-08-10 16:59:35.763000', 100, 100, 'Fill From Patient', NULL, NULL,
	 0, 'U', 'BH_FillFromPatient', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1c551a60-8b34-4199-af1b-a8c5be094daf'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '372e3e78-9c3a-4a59-8b12-4e6e131c1101', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.840000', '2023-08-10 16:59:35.840000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6f5eccb9-2878-48e1-8d68-600e138264f7', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.876000', '2023-08-10 16:59:35.876000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0abdc1cd-3503-4ed9-bbc1-8f2c93f11df1', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.906000', '2023-08-10 16:59:35.906000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '57dbe8da-6c76-4682-90f7-cecf7c557a55', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.548000', '2023-08-10 17:03:42.035000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '776c4bb9-b388-44b5-89b5-01715c04b15b', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHPayerInfoField', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.770000', '2023-08-10 17:25:19.770000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '939717d1-81d3-4053-95b8-0080ffa7df38', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.792000', '2023-08-10 17:25:19.792000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '661d3f64-b5bf-45c4-a2cb-e6a5d8d168f9', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.593000', '2023-08-10 17:03:42.056000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '16452e3c-00ef-4e3f-ac00-ec144fce449a', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHPayerInfoField', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.931000', '2023-08-10 16:59:35.931000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a984efd3-7e45-4eda-bf75-6cd6e2f07e39', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.962000', '2023-08-10 16:59:35.962000', 100, 100, 'Line No',
	 'Unique line for this document',
	 'Indicates the unique line for a document.  It will also control the display order of the lines within a document.',
	 0, 'U', 'Line', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 11, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bae98683-f4c8-4cd0-aedf-565a2791758a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e11c6d0c-155f-4a8c-ada4-9b52c2e8fac0', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.989000', '2023-08-10 16:59:35.989000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c50b5a75-0d05-41fc-99c3-c4b47fe3575f', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:36.017000', '2023-08-10 16:59:36.017000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '179c62b1-93d6-455d-be40-5d5c991515ab', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:36.045000', '2023-08-10 16:59:36.045000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f8dd654e-da0d-4518-9278-f5231f45506f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:59:35.801000', '2023-08-10 17:03:42.082000', 100, 100, 'Payer ID', NULL, NULL, 0, 'U',
	 'BH_Payer_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9d22b46b-7f36-4a71-a316-2746cae40cb3'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '9464f6b3-d548-48c9-aaad-0c4ea9b5afd7'
	 ), NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f4b8eed1-e1a1-4f58-95d5-4eef13816625'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '625ce37a-2250-45f1-bf0a-7568a1d5609b', 'Y', 0, 'N', 'N', NULL,
	 'BHPayer_BHPayerInfoField', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.643000', '2023-08-10 17:07:52.643000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9c14194a-41e1-4b5a-96ca-73344ae03d6b', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.454000', '2023-08-10 17:07:52.454000', 100, 100, 'Payer Info Values', NULL, NULL,
	 1, 'U', 'BH_Payer_Info_Field_Value_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a9e534e0-1204-4671-b29c-8ec92921390b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e3c381ef-6f66-4ff0-b93a-65fb45a6a5e9', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.492000', '2023-08-10 17:07:52.492000', 100, 100, 'BH_Payer_Info_Field_Value_UU',
	 NULL, NULL, 1, 'U', 'BH_Payer_Info_Field_Value_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3d6ec214-2785-4fba-b325-9342a996c842'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c72ac7f1-b901-478f-8fe1-c2f32e511b8e', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.530000', '2023-08-10 17:07:52.530000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '890538ee-18a7-4e90-b188-65bdf745ccff', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.552000', '2023-08-10 17:07:52.552000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dd0a41c3-f138-455b-ac25-4b32211ed7fd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.575000', '2023-08-10 17:07:52.575000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '61db9abb-c9f6-4771-8581-5f5f0d1ca7bf', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.596000', '2023-08-10 17:07:52.596000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd584b255-2f44-4c3f-8e61-37a7e4acbb3b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.621000', '2023-08-10 17:07:52.621000', 100, 100, 'Line No',
	 'Unique line for this document',
	 'Indicates the unique line for a document.  It will also control the display order of the lines within a document.',
	 0, 'U', 'Line', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 11, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bae98683-f4c8-4cd0-aedf-565a2791758a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1ba86984-7e34-478e-b641-707bbef5271f', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.666000', '2023-08-10 17:07:52.666000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3c4367cb-f43b-4d2e-ac2e-08d2cdce0adc', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.688000', '2023-08-10 17:07:52.688000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a8af33e3-9b7d-433d-9694-615da115c820', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.363000', '2023-08-10 17:08:36.987000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b068ced4-4379-486e-8385-bca6185ca540', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHPayerInfoFieldValue', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.390000', '2023-08-10 17:08:37.007000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd376e1a9-c076-4b5e-a06a-f4cea9674c8b', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHPayerInfoFieldValue', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:52.429000', '2023-08-10 17:08:37.024000', 100, 100, 'Payer Info Field', NULL, NULL,
	 0, 'U', 'BH_Payer_Info_Field_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '06800b5e-8094-4b77-8b74-32ca2a71e580'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd767b978-2ec9-4f86-b614-f17a6535513f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c2165d7f-96fc-4816-a777-b0d95bd8520f', 'Y', 0, 'N', 'N', NULL,
	 'BHPayerInfoField_BHPayerInfoFi', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.560000', '2023-08-10 17:11:52.682000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8da79553-0412-4776-b6d6-b749477ac2b1', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHPayerInfoFieldSugge', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.602000', '2023-08-10 17:11:52.703000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '373fc235-b03f-42ee-8434-d05e0aa76e00', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHPayerInfoFieldSuggesti', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.625000', '2023-08-10 17:11:09.625000', 100, 100, 'Payer Info Field Suggestion',
	 NULL, NULL, 1, 'U', 'BH_Payer_Info_Field_Suggestion_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e4859cca-bd6f-4446-8079-ca64c7619fd7'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '48163e85-0872-4849-baa4-cb288fc505c0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.665000', '2023-08-10 17:11:09.665000', 100, 100,
	 'BH_Payer_Info_Field_Suggestion_UU', NULL, NULL, 1, 'U', 'BH_Payer_Info_Field_Suggestion_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f8d67a52-c7d7-40e6-a07b-bcb83a6c482a'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'efe4a7d4-f177-416c-95ee-009c65caa36d', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.703000', '2023-08-10 17:11:09.703000', 100, 100, 'Charge Info Data Type', NULL,
	 NULL, 0, 'U', 'BH_PayerInfoFieldDataType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'
	 ), NULL, 2, 'T', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9ebeb2eb-6583-4c55-80a7-1e04fad7c7d8'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e887efcc-f7cc-40e8-90f1-5697c09d552c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.725000', '2023-08-10 17:11:09.725000', 100, 100, 'Fill From Patient', NULL, NULL,
	 0, 'U', 'BH_FillFromPatient', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1c551a60-8b34-4199-af1b-a8c5be094daf'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5de34fbe-6dcd-4c23-9688-2b2d085b1069', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.748000', '2023-08-10 17:11:09.748000', 100, 100, 'Sub Type',
	 'Meant to be a sub-type of the charge type', NULL, 0, 'U', 'BH_SubType', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'
	 ), NULL, 2, 'I', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'eac953c3-043c-4eb9-b728-7499f9fe7336'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7df28e20-7a83-487f-9733-19eb6e3ad804', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.779000', '2023-08-10 17:11:09.779000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd88b6466-27f1-4230-88c0-52f8f5ecd530', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.803000', '2023-08-10 17:11:09.803000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fc2b0870-09b8-4da1-8ba5-ed9c9a5b4803', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.826000', '2023-08-10 17:11:09.826000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '327ba656-4646-4e8f-8a68-a4b5da5f1ece', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.850000', '2023-08-10 17:11:09.850000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f0605a7b-98b9-49d6-af23-2cd35201a510', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.876000', '2023-08-10 17:11:09.876000', 100, 100, 'Line No',
	 'Unique line for this document',
	 'Indicates the unique line for a document.  It will also control the display order of the lines within a document.',
	 0, 'U', 'Line', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 11, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bae98683-f4c8-4cd0-aedf-565a2791758a'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a74c9f56-7dcf-4cc0-886d-0ec78013be7f', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.898000', '2023-08-10 17:11:09.898000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7157ab88-d9e4-49fe-950d-eb2f6146c388', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.926000', '2023-08-10 17:11:09.926000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cb5e5cf0-6739-4dbe-995a-521847d9a214', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:11:09.950000', '2023-08-10 17:11:09.950000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '365c340b-fc56-4aff-ae65-c1af9e5a5e36'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4c177e97-c795-4cd4-bb5f-86cc0290557f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.527000', '2023-08-10 17:15:10.572000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6beeaed6-75c9-4152-9ac6-4bdc192527b4', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHPayerInfoFieldValSu', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.622000', '2023-08-10 17:14:34.622000', 100, 100,
	 'Payer Info Field Value Suggestion', NULL, NULL, 1, 'U', 'BH_Payer_Info_Field_Value_Suggestion_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '78cd8dad-571e-4d6a-a9c3-27c50800ad3f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f7e21b37-983d-419f-b88f-c2c7327ed599', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.664000', '2023-08-10 17:14:34.664000', 100, 100,
	 'BH_Payer_Info_Field_Value_Suggestion_UU', NULL, NULL, 1, 'U', 'BH_Payer_Info_Field_Value_Suggestion_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '74550115-b68f-4d36-97f5-e77fe7521759'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0b2e674d-3c0f-4c9f-8bfe-ba14927e24da', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.698000', '2023-08-10 17:14:34.698000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '189ff517-e0b9-4662-a27e-02f1e6750558', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.719000', '2023-08-10 17:14:34.719000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '037fe180-ca8e-41ae-9291-ef1d14c450bf', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.738000', '2023-08-10 17:14:34.738000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ffbfdfd2-da88-4ae1-ba42-be74220ce17c', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.780000', '2023-08-10 17:21:47.455000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '200b321e-c02d-4609-9223-fd166eac0f6a', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHBPPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.870000', '2023-08-10 17:21:47.493000', 100, 100, 'Business Partner ',
	 'Identifies a Business Partner',
	 'A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson',
	 0, 'U', 'C_BPartner_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 30, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '5f73bc9f-04e0-448f-978d-f2d3e18f2ac3'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f73be7e1-04ba-40a1-9f22-8316416e8153', 'Y', 0, 'N', 'N', NULL,
	 'CBPartner_BHBPPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.815000', '2023-08-10 17:25:19.815000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dcc0f84d-b012-4cdd-855c-24aee2b11c87', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.776000', '2023-08-10 17:14:34.776000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c89bab16-ce47-4507-8e9c-8fde1a14a5ca', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.799000', '2023-08-10 17:14:34.799000', 100, 100, 'Line No',
	 'Unique line for this document',
	 'Indicates the unique line for a document.  It will also control the display order of the lines within a document.',
	 0, 'U', 'Line', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 11, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bae98683-f4c8-4cd0-aedf-565a2791758a'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'aabe0d23-4f20-4927-881f-6bd791843a89', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.825000', '2023-08-10 17:14:34.825000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b1e996de-2919-46fd-8374-74a172226062', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.846000', '2023-08-10 17:14:34.846000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b8712a7d-fb4e-4dd1-929b-fa6b26583e5b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.871000', '2023-08-10 17:14:34.871000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '41ce70ca-e40b-4103-9b66-b7dffec34394', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.575000', '2023-08-10 17:15:10.593000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7726733c-3647-4c08-b54f-9e200b78b2e9', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHPayerInfoFieldValueSug', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:34.600000', '2023-08-10 17:15:10.612000', 100, 100, 'Payer Info Field Suggestion',
	 NULL, NULL, 0, 'U', 'BH_Payer_Info_Field_Suggestion_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '417447b6-ce19-46fd-a7fc-0aa737800de2'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'e4859cca-bd6f-4446-8079-ca64c7619fd7'
	 ), NULL, 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '65030db9-f453-4826-a949-691d62567b6a', 'Y', 0, 'N', 'N', NULL,
	 'BHPayerInfoFieldSuggestion_BHP', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.757000', '2023-08-10 17:21:47.435000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd71ef6af-962b-44e0-b70f-b092a8dbde9d', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHBPPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.804000', '2023-08-10 17:20:33.804000', 100, 100,
	 'Business Partner Payer Information', NULL, NULL, 1, 'U', 'BH_BP_Payer_Info_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '09d13be5-7c3e-442a-90be-0e43fa3bcc4f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8ddc149f-fa6e-4de8-9aad-fae1d571dc1b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.838000', '2023-08-10 17:20:33.838000', 100, 100, 'BH_BP_Payer_Info_UU', NULL,
	 NULL, 1, 'U', 'BH_BP_Payer_Info_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd2ad76b0-8e34-4a0f-88f8-6fe13e59ea90'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7a74bf96-3bb8-4f3a-938a-5d8d5b879344', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.917000', '2023-08-10 17:20:33.917000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd66fb22c-c8b9-423f-9c00-413620e097a5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.939000', '2023-08-10 17:20:33.939000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e6e70e66-fa73-45ad-9e76-43111f6a55bc', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.961000', '2023-08-10 17:20:33.961000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3f7054d6-ef33-47a5-b71d-09a6315ff320', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.984000', '2023-08-10 17:20:33.984000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3fa1352e-5589-4988-a814-83da6de0bc0a', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:34.006000', '2023-08-10 17:20:34.006000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'N', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '59d9975f-eecc-43fd-baf7-a98af302eb16', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:34.030000', '2023-08-10 17:20:34.030000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a01df242-4447-4913-b042-58114afde5c4', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:34.050000', '2023-08-10 17:20:34.050000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '063f0da9-806d-421c-878d-64417f1a31b7', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:33.895000', '2023-08-10 17:21:47.475000', 100, 100, 'Payer ID', NULL, NULL, 0, 'U',
	 'BH_Payer_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '1f1f63f5-e42e-43fb-b007-1c83f1e59734'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '9464f6b3-d548-48c9-aaad-0c4ea9b5afd7'
	 ), NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f4b8eed1-e1a1-4f58-95d5-4eef13816625'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '02325e94-bace-437b-90f5-8c77cad30375', 'Y', 0, 'N', 'N', NULL,
	 'BHPayer_BHBPPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.668000', '2023-08-10 17:25:19.668000', 100, 100,
	 'Business Partner General Payer Info', NULL, NULL, 1, 'U', 'BH_BP_General_Payer_Info_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '492a0ad8-7f29-464a-a996-056f1d77f723'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '750ec259-f568-4157-afdd-db3b720a2576', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.850000', '2023-08-10 17:25:19.850000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5d7e62c4-cbec-4ec0-8c89-0ddae61503e5', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.872000', '2023-08-10 17:25:19.872000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'Y', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a51affcc-1564-4b47-b715-19fe12110e50', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.892000', '2023-08-10 17:25:19.892000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a1657f56-cabb-4329-8848-1e7c8d8f431a', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.915000', '2023-08-10 17:25:19.915000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '18150f7b-0814-45e2-8e7a-b23bf6a29bf0', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.576000', '2023-08-10 17:26:49.967000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'dad85082-3fab-47c8-9137-167ac9cf7d61', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHBPGeneralPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.620000', '2023-08-10 17:26:49.988000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cbe1dcf4-972f-431e-8cab-85440b47a513', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHBPGeneralPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.644000', '2023-08-10 17:26:50.008000', 100, 100,
	 'Business Partner Payer Information', NULL, NULL, 0, 'U', 'BH_BP_Payer_Info_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '09d13be5-7c3e-442a-90be-0e43fa3bcc4f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'fb5e3c74-81a8-402d-a188-be921de71f7e', 'Y', 0, 'N', 'N', NULL,
	 'BHBPPayerInfo_BHBPGeneralPayer', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.747000', '2023-08-10 17:26:50.026000', 100, 100, 'Payer Info Field', NULL, NULL,
	 0, 'U', 'BH_Payer_Info_Field_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '18293592-398c-447d-9ca1-ffd585098118'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd767b978-2ec9-4f86-b614-f17a6535513f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cb7b7580-75ca-4ca5-bd0c-1f174465d53f', 'Y', 0, 'N', 'N', NULL,
	 'BHPayerInfoField_BHBPGeneralPa', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.517000', '2023-08-10 17:30:03.737000', 100, 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 1,
	 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c46491d1-7547-4374-88fd-cbc701d47d7f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8b1e890c-cbf1-4d28-a63d-5f522d259518', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHBPSpecificPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.605000', '2023-08-10 17:29:14.605000', 100, 100,
	 'Business Partner Specific Payer Information', NULL, NULL, 1, 'U', 'BH_BP_Specific_Payer_Info_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9b81af74-68bb-45a7-a98b-03dde124e261'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5ece5df7-f946-4bad-8241-22e9ed0497c6', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.643000', '2023-08-10 17:29:14.643000', 100, 100, 'BH_BP_Specific_Payer_Info_UU',
	 NULL, NULL, 1, 'U', 'BH_BP_Specific_Payer_Info_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'caec92d7-455e-4d4a-9c4a-bdb479e0e6b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '79988f67-4d79-4a1d-bb6b-d12bb1423dbd', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.706000', '2023-08-10 17:29:14.706000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9458b908-d27b-47ad-a75a-4ba58483e36b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.729000', '2023-08-10 17:29:14.729000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '7d1537a0-5d13-4a79-a578-1ceb55dd59a2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '205f5fe9-c0c4-4caa-8b56-9548c2eab105', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.751000', '2023-08-10 17:29:14.751000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'dd7a3063-5c49-4fba-b661-67c482533985'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '39896b67-7b49-442f-b75f-5f003763034d', 'Y', 10, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.783000', '2023-08-10 17:29:14.783000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b31f7d52-846f-40ac-b1d2-33bae38a247e'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4e1f7356-d14a-473c-965c-dd36b8b809a8', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.804000', '2023-08-10 17:29:14.804000', 100, 100, 'Name',
	 'Alphanumeric identifier of the entity',
	 'The name of an entity (record) is used as an default search option in addition to the search key. The name is up to 60 characters in length.',
	 1, 'U', 'Name', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 10, NULL, NULL, 60, NULL, 'N', 'N', 'N', 'Y', NULL, 'Y', 1, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3a38ae9b-e9df-4678-bca8-fa97b457d8d4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c7b69c20-2fb8-43ad-8580-5e4ba9759eca', 'Y', 20, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.826000', '2023-08-10 17:29:14.826000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ef178cde-f302-4224-ad8f-49e6f319b7b6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8cde97e8-766a-438b-9c66-d5f9e489359b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.847000', '2023-08-10 17:29:14.847000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 30, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '3f317876-0b22-44c2-95bb-4201bf9ca37b'
	 ), NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '46db21da-0463-4b85-8eae-b6c223dd402f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e59f5f7e-15ae-4ff7-907d-6b379e87c69f', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'D', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.558000', '2023-08-10 17:30:03.759000', 100, 100, 'Organization',
	 'Organizational entity within client',
	 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8103f72-3282-4298-9ed4-360b12abc9d2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '45ea2e29-2a09-494d-8e72-1de4c4e04a51', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHBPSpecificPayerInfo', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.581000', '2023-08-10 17:30:03.777000', 100, 100,
	 'Business Partner Payer Information', NULL, NULL, 0, 'U', 'BH_BP_Payer_Info_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '09d13be5-7c3e-442a-90be-0e43fa3bcc4f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'd3e96efe-b1fe-4a1a-bbc3-e1a53b93ed5a', 'Y', 0, 'N', 'N', NULL,
	 'BHBPPayerInfo_BHBPSpecificPaye', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:14.682000', '2023-08-10 17:30:03.794000', 100, 100, 'Sales Order Line',
	 'Sales Order Line', 'The Sales Order Line is a unique identifier for a line in an order.', 0, 'U', 'C_OrderLine_ID',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c5747e24-3a7b-44cd-af2d-5c9a6dd94d58'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '69734631-bd60-4d59-b3d7-6104527a00e7', 'Y', 0, 'N', 'N', NULL,
	 'COrderLine_BHBPSpecificPayerIn', 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:19.747000', '2023-08-10 17:26:50.026000', 100, 100, 'Payer Info Field', NULL, NULL,
	 0, 'U', 'BH_Payer_Info_Field_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f09bd346-9075-49a1-a6d8-c5ba882c1960'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd767b978-2ec9-4f86-b614-f17a6535513f'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '36fc8c69-0077-4251-a2de-1b9c93bbf14e', 'Y', 0, 'N', 'N', NULL,
	 'BHPayerInfoField_BHBPSpecificP', 'N', NULL, NULL);


-- Insert the new sequences
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
	 ), 0, 0, 'Y', '2023-08-10 17:29:06.291000', 100, '2023-08-10 17:29:06.291000', 100, 'BH_BP_Specific_Payer_Info',
	 'Table BH_BP_Specific_Payer_Info', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'b5174fc3-656b-4280-bcf5-705c01aa1c67', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:25:09.168000', 100, '2023-08-10 17:25:09.168000', 100, 'BH_BP_General_Payer_Info',
	 'Table BH_BP_General_Payer_Info', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 'ab60bb0a-cab8-42fd-81f3-087358af5813', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:20:20.844000', 100, '2023-08-10 17:20:20.844000', 100, 'BH_BP_Payer_Info',
	 'Table BH_BP_Payer_Info', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '01eadc94-8c6c-40b3-82ed-933757f94849', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:14:22.468000', 100, '2023-08-10 17:14:22.468000', 100,
	 'BH_Payer_Info_Field_Value_Suggestion', 'Table BH_Payer_Info_Field_Value_Suggestion', NULL, 'Y', 1, 1000000, 1000000,
	 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL, '866610c9-3ca6-4b5f-bb64-a5f72444cb49', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:10:57.408000', 100, '2023-08-10 17:10:57.408000', 100, 'BH_Payer_Info_Field_Suggestion',
	 'Table BH_Payer_Info_Field_Suggestion', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL,
	 NULL, 'ab5a6b0f-cad7-4e4f-b370-8daff783d9ad', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 17:07:41.427000', 100, '2023-08-10 17:07:41.427000', 100, 'BH_Payer_Info_Field_Value',
	 'Table BH_Payer_Info_Field_Value', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '35afc41b-3834-4813-ba57-ef592cf97b3a', 'N', 'N', NULL);
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
	 ), 0, 0, 'Y', '2023-08-10 16:58:43.394000', 100, '2023-08-10 16:58:43.394000', 100, 'BH_Payer_Info_Field',
	 'Table BH_Payer_Info_Field', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '54f42b1a-598c-4026-b57c-98c72e399b62', 'N', 'N', NULL);


/******************************************************************************************/
--	3. Update accounting
/******************************************************************************************/
-- Update account names for everyone
-- Rename account 12310 and update the valid combinations
UPDATE c_elementvalue
SET
	name = 'Accounts Receivable - FFS Insurance'
WHERE
	value = '12310';
UPDATE c_validcombination
SET
	description = REPLACE(description, 'A/R - NHIF National Scheme', 'Accounts Receivable - FFS Insurance')
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			c_elementvalue
		WHERE
			value = '12310'
	);
-- Rename account 12710 and update the valid combinations
UPDATE c_elementvalue
SET
	name = 'Accounts Receivable - Donations'
WHERE
	value = '12710';
UPDATE c_validcombination
SET
	description = REPLACE(description, 'Donor Fund', 'Accounts Receivable - Donations')
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			c_elementvalue
		WHERE
			value = '12710'
	);
-- Rename account 25200 and update the valid combinations
UPDATE c_elementvalue
SET
	name        = 'Capitation Insurance Payable',
	description = 'Payables for capitation'
WHERE
	value = '25200';
UPDATE c_validcombination
SET
	description = REPLACE(description, 'NHIF National Scheme Payments', 'Capitation Insurance Payable')
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			c_elementvalue
		WHERE
			value = '25200'
	);
-- Rename account 44100 and update the valid combinations
UPDATE c_elementvalue
SET
	name        = 'Capitation Insurance Revenue',
	description = 'Contra revenue'
WHERE
	value = '44100';
UPDATE c_validcombination
SET
	description = REPLACE(description, 'NHIF National Scheme Revenue', 'Capitation Insurance Revenue')
WHERE
		account_id IN (
		SELECT
			c_elementvalue_id
		FROM
			c_elementvalue
		WHERE
			value = '44100'
	);

-- Insert accounts for our new FFS insurance revenue contra account
DROP TABLE IF EXISTS tmp_c_elementvalue;
CREATE TABLE tmp_c_elementvalue
(
	c_elementvalue_id serial                  NOT NULL,
	ad_client_id      numeric(10)             NOT NULL,
	ad_org_id         numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10) DEFAULT 100 NOT NULL,
-- 	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10) DEFAULT 100 NOT NULL,
	value             varchar(40)             NOT NULL,
	name              varchar(120)            NOT NULL,
	description       varchar(255),
	accounttype       char        DEFAULT 'R' NOT NULL,
	accountsign       char        DEFAULT 'N' NOT NULL,
-- 	isdoccontrolled   char        DEFAULT 'N'::bpchar,
	c_element_id      numeric(10)             NOT NULL,
-- 	issummary         char        DEFAULT 'N'::bpchar NOT NULL,
-- 	validfrom         timestamp,
-- 	validto           timestamp,
-- 	postactual        char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	postbudget        char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	postencumbrance   char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	poststatistical   char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isbankaccount     char        DEFAULT 'N'::bpchar,
-- 	c_bankaccount_id  numeric(10),
-- 	isforeigncurrency char        DEFAULT 'N'::bpchar,
-- 	c_currency_id     numeric(10),
	c_elementvalue_uu uuid        DEFAULT uuid_generate_v4()
-- 	isdetailbpartner  char        DEFAULT 'N'::bpchar NOT NULL,
-- 	isdetailproduct   char        DEFAULT 'N'::bpchar NOT NULL,
-- 	bpartnertype      char         DEFAULT NULL::bpchar
);

SELECT
	SETVAL(
		'tmp_c_elementvalue_c_elementvalue_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_ElementValue'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Add 12310 accounts for those that don't have it
INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id, value, name, description, accounttype)
SELECT
	tctww.ad_client_id,
	e.c_element_id,
	'12310',
	'Accounts Receivable - FFS Insurance',
	NULL,
	'A'
FROM
	tmp_clients_to_work_with tctww
		JOIN c_element e
		ON tctww.ad_client_id = e.ad_client_id
WHERE
		tctww.ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = '12310'
	);

-- Add 12710 accounts for those that don't have it
INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id, value, name, description, accounttype)
SELECT
	tctww.ad_client_id,
	e.c_element_id,
	'12710',
	'Accounts Receivable - Donations',
	NULL,
	'A'
FROM
	tmp_clients_to_work_with tctww
		JOIN c_element e
		ON tctww.ad_client_id = e.ad_client_id
WHERE
		tctww.ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = '12710'
	);

-- Add 25200 accounts for those that don't have it
INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id, value, name, description, accounttype)
SELECT
	tctww.ad_client_id,
	e.c_element_id,
	'25200',
	'Capitation Insurance Payable',
	'Payables for capitation',
	'L'
FROM
	tmp_clients_to_work_with tctww
		JOIN c_element e
		ON tctww.ad_client_id = e.ad_client_id
WHERE
		tctww.ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = '25200'
	);

-- Add 44100 accounts for those that don't have it
INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id, value, name, description)
SELECT
	tctww.ad_client_id,
	e.c_element_id,
	'44100',
	'Capitation Insurance Revenue',
	'Contra revenue'
FROM
	tmp_clients_to_work_with tctww
		JOIN c_element e
		ON tctww.ad_client_id = e.ad_client_id
WHERE
		tctww.ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			c_elementvalue
		WHERE
			value = '44100'
	);

-- Add 44200 accounts (no one has them)
INSERT INTO
	tmp_c_elementvalue (ad_client_id, c_element_id, value, name, description)
SELECT
	tctww.ad_client_id,
	e.c_element_id,
	'44200',
	'FFS Insurance Revenue',
	'Contra revenue'
FROM
	tmp_clients_to_work_with tctww
		JOIN c_element e
		ON tctww.ad_client_id = e.ad_client_id;

-- Add all accounts we just inserted into the temp tables
INSERT INTO
	c_elementvalue (c_elementvalue_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description,
	                accounttype, accountsign, c_element_id, c_elementvalue_uu)
SELECT
	c_elementvalue_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	accounttype,
	accountsign,
	c_element_id,
	c_elementvalue_uu
FROM
	tmp_c_elementvalue;

-- Insert the element values into the tree so they show up in the UI
-- We have to deal with possibly new accounts for 12310, 127, 12710, 25200, and 44100, plus the newbie 44200
-- For those that don't have 12310 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '123'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '12310'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != COALESCE(ctn.seqno, 0) - 1
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno;
-- For those with 12310 already in the tree, make sure it's the first child after 123
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno + 1,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '123'
		JOIN c_elementvalue cev
		ON cev.value = '12310' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 1
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '123'
		JOIN c_elementvalue cev
		ON cev.value = '12310' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- For those that don't have 127 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '12'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '127'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != COALESCE(ctn.seqno, 0) + 1
			OR ptn.seqno != COALESCE(ctn.seqno, 0) + 2
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno >= seq.seqno;
-- For those with 127 already in the tree, make sure it's the first child after 12
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno - 1,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '12'
		JOIN c_elementvalue cev
		ON cev.value = '127' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno - 1
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '12'
		JOIN c_elementvalue cev
		ON cev.value = '127' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- For those that don't have 12710 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '127'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '12710'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != COALESCE(ctn.seqno, 0) - 1
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno;
-- For those with 12710 already in the tree, make sure it's the first child after 127
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno + 1,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '127'
		JOIN c_elementvalue cev
		ON cev.value = '12710' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 1
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '127'
		JOIN c_elementvalue cev
		ON cev.value = '12710' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- For those that don't have 25100 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '25100'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != COALESCE(ctn.seqno, 0) - 1
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno;
-- For those with 25100 already in the tree, make sure it's the first child after 25
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno + 1,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
		JOIN c_elementvalue cev
		ON cev.value = '25100' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 1
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
		JOIN c_elementvalue cev
		ON cev.value = '25100' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- For those that don't have 25200 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '25200'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != COALESCE(ctn.seqno, 0) - 2
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno + 1;
-- For those with 25200 already in the tree, make sure it's the second child after 25
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno + 2,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
		JOIN c_elementvalue cev
		ON cev.value = '25200' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 2
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '25'
		JOIN c_elementvalue cev
		ON cev.value = '25200' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- For those that don't have 44100 in the tree or do but with the wrong sequence number, make space by increasing
-- the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '44'
				LEFT JOIN c_elementvalue cev
				ON ptn.ad_client_id = cev.ad_client_id AND cev.value = '44100'
				LEFT JOIN ad_treenode ctn
				ON ctn.node_id = cev.c_elementvalue_id
		WHERE
			cev.c_elementvalue_id IS NULL
			OR ptn.seqno != ctn.seqno - 1
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno;
-- For those with 44100 already in the tree, make sure it's the first child after 44
-- Otherwise, insert it
UPDATE ad_treenode ctn
SET
	seqno     = ptn.seqno + 1,
	parent_id = ptn.node_id
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '44'
		JOIN c_elementvalue cev
		ON cev.value = '44100' AND cev.ad_client_id = ptn.ad_client_id
WHERE
	ctn.node_id = cev.c_elementvalue_id;
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 1
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '44'
		JOIN c_elementvalue cev
		ON cev.value = '44100' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);
-- Since 44200 is new, just make space by increasing the subsequent node sequence numbers
UPDATE ad_treenode tn
SET
	seqno = tn.seqno + 1
FROM
	(
		SELECT
			ptn.ad_client_id,
			ptn.seqno
		FROM
			ad_treenode ptn
				JOIN ad_tree t
				ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
				JOIN c_elementvalue pev
				ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '44'
	) seq
WHERE
	tn.ad_client_id = seq.ad_client_id
	AND tn.seqno > seq.seqno + 1;
-- Insert 44200 (since it's a newbie)
INSERT INTO
	ad_treenode (ad_tree_id, node_id, ad_client_id, ad_org_id, createdby, updatedby, parent_id, seqno)
SELECT
	t.ad_tree_id,
	cev.c_elementvalue_id,
	ptn.ad_client_id,
	ptn.ad_org_id,
	100,
	100,
	ptn.node_id,
	ptn.seqno + 2
FROM
	ad_treenode ptn
		JOIN ad_tree t
		ON ptn.ad_tree_id = t.ad_tree_id AND t.treetype = 'EV'
		JOIN c_elementvalue pev
		ON ptn.node_id = pev.c_elementvalue_id AND pev.value = '44'
		JOIN c_elementvalue cev
		ON cev.value = '44200' AND cev.ad_client_id = ptn.ad_client_id
WHERE
		cev.c_elementvalue_id NOT IN (
		SELECT
			node_id
		FROM
			ad_treenode
	);

-- Create charges for the three accounts we'll be using for invoicing: 12310 (FFS insurance), 12710 (donors),
-- and 25200 (capitation insurance)
DROP TABLE IF EXISTS tmp_c_charge;
CREATE TEMP TABLE tmp_c_charge
(
	c_charge_id       serial                  NOT NULL,
	ad_client_id      numeric(10)             NOT NULL,
	ad_org_id         numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive                   char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                    timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                    timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10) DEFAULT 100 NOT NULL,
	name              varchar(60)             NOT NULL,
	description       varchar(255),
-- 	chargeamt                  numeric     DEFAULT 0           NOT NULL,
-- 	issametax                  char        DEFAULT 'N'::bpchar NOT NULL,
-- 	issamecurrency             char        DEFAULT 'N'::bpchar NOT NULL,
	c_taxcategory_id  numeric(10),
-- 	istaxincluded              char        DEFAULT 'N'::bpchar NOT NULL,
-- 	c_bpartner_id              numeric(10),
	c_chargetype_id   numeric(10),
	c_charge_uu       uuid        DEFAULT uuid_generate_v4(),
	c_elementvalue_id numeric(10) DEFAULT NULL::numeric,
	bh_locked         CHAR        DEFAULT 'Y'::bpchar
-- 	bh_subtype        varchar(2)
-- 	bh_needadditionalvisitinfo char        DEFAULT 'N'::bpchar NOT NULL
);

SELECT
	SETVAL(
		'tmp_c_charge_c_charge_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_Charge'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Delete duplicate charge types
DROP TABLE IF EXISTS tmp_chargetype_mapping;
SELECT
	old_ct.c_chargetype_id AS old_chargetype_id,
	new_ct.c_chargetype_id AS new_chargetype_id
INTO TEMP TABLE
	tmp_chargetype_mapping
FROM
	(
		SELECT
			ad_client_id,
			MIN(c_chargetype_id) AS c_chargetype_id
		FROM
			c_chargetype
		WHERE
			name = 'Non-Patient Payment - DO NOT CHANGE'
		GROUP BY ad_client_id
	) AS new_ct
		JOIN c_chargetype old_ct
		ON new_ct.ad_client_id = old_ct.ad_client_id AND name = 'Non-Patient Payment - DO NOT CHANGE' AND
		   old_ct.c_chargetype_id != new_ct.c_chargetype_id;

-- Now do the update
UPDATE c_charge c
SET
	c_chargetype_id = tctm.new_chargetype_id
FROM
	tmp_chargetype_mapping tctm
WHERE
	c.c_chargetype_id = tctm.old_chargetype_id;
-- Finally, delete the bad charge types!
DELETE
FROM
	c_chargetype
WHERE
		c_chargetype_id IN (
		SELECT
			old_chargetype_id
		FROM
			tmp_chargetype_mapping
	);

-- Add the charge for the FFS insurance
INSERT INTO
	tmp_c_charge (ad_client_id, name, description, c_taxcategory_id, c_chargetype_id, c_elementvalue_id)
SELECT
	tctww.ad_client_id,
	'Accounts Receivable - FFS Insurance',
	'Accounts Receivable - FFS Insurance',
	tc.c_taxcategory_id,
	ct.c_chargetype_id,
	ev.c_elementvalue_id
FROM
	tmp_clients_to_work_with tctww
		JOIN c_taxcategory tc
		ON tctww.ad_client_id = tc.ad_client_id
		JOIN c_chargetype ct
		ON tctww.ad_client_id = ct.ad_client_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '12310';

INSERT INTO
	tmp_c_charge (ad_client_id, name, description, c_taxcategory_id, c_chargetype_id, c_elementvalue_id)
SELECT
	tctww.ad_client_id,
	'Accounts Receivable - Donations',
	'Accounts Receivable - Donations',
	tc.c_taxcategory_id,
	ct.c_chargetype_id,
	ev.c_elementvalue_id
FROM
	tmp_clients_to_work_with tctww
		JOIN c_taxcategory tc
		ON tctww.ad_client_id = tc.ad_client_id
		JOIN c_chargetype ct
		ON tctww.ad_client_id = ct.ad_client_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '12710';

INSERT INTO
	tmp_c_charge (ad_client_id, name, description, c_taxcategory_id, c_chargetype_id, c_elementvalue_id)
SELECT
	tctww.ad_client_id,
	'Capitation Insurance Payable',
	'Capitation Insurance Payable',
	tc.c_taxcategory_id,
	ct.c_chargetype_id,
	ev.c_elementvalue_id
FROM
	tmp_clients_to_work_with tctww
		JOIN c_taxcategory tc
		ON tctww.ad_client_id = tc.ad_client_id
		JOIN c_chargetype ct
		ON tctww.ad_client_id = ct.ad_client_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '25200';

-- Insert the new charges
INSERT INTO
	c_charge (c_charge_id, ad_client_id, ad_org_id, createdby, updatedby, name, description, c_chargetype_id, c_charge_uu,
	          c_elementvalue_id, bh_locked)
SELECT
	c_charge_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	c_chargetype_id,
	c_charge_uu,
	c_elementvalue_id,
	bh_locked
FROM
	tmp_c_charge;

-- Create valid combinations for each charge we just created
DROP TABLE IF EXISTS tmp_c_validcombination;
CREATE TEMP TABLE tmp_c_validcombination
(
	c_validcombination_id serial      NOT NULL,
	ad_client_id          numeric(10) NOT NULL,
	ad_org_id             numeric(10) NOT NULL DEFAULT 0,
-- 	isactive              char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created               timestamp   DEFAULT NOW()       NOT NULL,
	createdby             numeric(10) NOT NULL DEFAULT 100,
-- 	updated               timestamp   DEFAULT NOW()       NOT NULL,
	updatedby             numeric(10) NOT NULL DEFAULT 100,
-- 	alias                 varchar(40),
	combination           varchar(60),
	description           varchar(255),
-- 	isfullyqualified      char        DEFAULT 'Y'::bpchar NOT NULL,
	c_acctschema_id       numeric(10) NOT NULL,
	account_id            numeric(10) NOT NULL,
-- 	m_product_id          numeric(10),
-- 	c_bpartner_id         numeric(10),
-- 	ad_orgtrx_id          numeric(10),
-- 	c_locfrom_id          numeric(10),
-- 	c_locto_id            numeric(10),
-- 	c_salesregion_id      numeric(10),
-- 	c_project_id          numeric(10),
-- 	c_campaign_id         numeric(10),
-- 	c_activity_id         numeric(10),
-- 	user1_id              numeric(10),
-- 	user2_id              numeric(10),
-- 	c_subacct_id          numeric(10),
-- 	userelement1_id       numeric(10),
-- 	userelement2_id       numeric(10),
	c_validcombination_uu uuid                 DEFAULT uuid_generate_v4(),
	c_charge_id           numeric(10) NOT NULL
);

SELECT
	SETVAL(
		'tmp_c_validcombination_c_validcombination_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_ValidCombination'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Insert valid combinations for each of the charges we just created
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id, c_charge_id)
SELECT
	tc.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	actts.c_acctschema_id,
	tc.c_elementvalue_id,
	tc.c_charge_id
FROM
	tmp_c_charge tc
		JOIN c_elementvalue ev
		ON tc.c_elementvalue_id = ev.c_elementvalue_id
		JOIN c_acctschema actts
		ON tc.ad_client_id = actts.ad_client_id;

INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;

-- Create charge account records for the charges we just created
DROP TABLE IF EXISTS tmp_c_charge_acct;
CREATE TEMP TABLE tmp_c_charge_acct
(
	c_charge_id      numeric(10)             NOT NULL,
	c_acctschema_id  numeric(10)             NOT NULL,
	ad_client_id     numeric(10)             NOT NULL,
	ad_org_id        numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive         char      DEFAULT 'Y'::bpchar NOT NULL,
-- 	created          timestamp DEFAULT NOW()       NOT NULL,
	createdby        numeric(10) DEFAULT 100 NOT NULL,
-- 	updated          timestamp DEFAULT NOW()       NOT NULL,
	updatedby        numeric(10) DEFAULT 100 NOT NULL,
	ch_expense_acct  numeric(10)             NOT NULL,
-- 	ch_revenue_acct  numeric(10),
	c_charge_acct_uu uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO
	tmp_c_charge_acct (c_charge_id, c_acctschema_id, ad_client_id, ch_expense_acct)
SELECT
	tc.c_charge_id,
	tvc.c_acctschema_id,
	tvc.ad_client_id,
	tvc.c_validcombination_id
FROM
	tmp_c_charge tc
		JOIN tmp_c_validcombination tvc
		ON tc.c_charge_id = tvc.c_charge_id;

-- Now insert the real deal!
INSERT INTO
	c_charge_acct (c_charge_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, ch_expense_acct,
	               c_charge_acct_uu)
SELECT
	c_charge_id,
	c_acctschema_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	ch_expense_acct,
	c_charge_acct_uu
FROM
	tmp_c_charge_acct;

-- Make sure the element values on charges accurately matches the charge account
UPDATE c_charge c
SET
	c_elementvalue_id = ev.c_elementvalue_id
FROM
	c_charge_acct ca
		JOIN c_validcombination vc
		ON ca.ch_expense_acct = vc.c_validcombination_id
		JOIN c_elementvalue ev
		ON vc.account_id = ev.c_elementvalue_id
WHERE
	ca.c_charge_id = c.c_charge_id;

-- Since our new structure is a lot more complicated, we'll just update all existing A/R insurance accounts
-- (previously we also had 12320 and 12330) to point to 12310 and delete the others
TRUNCATE tmp_c_validcombination;

-- Get the charges we need to update
DROP TABLE IF EXISTS tmp_old_insurance_charges;
SELECT
	c.c_charge_id
INTO TEMP TABLE
	tmp_old_insurance_charges
FROM
	c_charge c
		JOIN c_charge_acct ca
		ON c.c_charge_id = ca.c_charge_id
		JOIN c_validcombination vc
		ON ca.ch_expense_acct = vc.c_validcombination_id
		JOIN c_elementvalue ev
		ON vc.account_id = ev.c_elementvalue_id
WHERE
	ev.value IN ('12320', '12330');

-- Update the charge c_elementvalue_id (a column we added for ease that should probably be removed) to point to the
-- associated 12310 account
UPDATE c_charge c
SET
	c_elementvalue_id = COALESCE(ev_ari.c_elementvalue_id, ev_99999.c_elementvalue_id)
FROM
	tmp_old_insurance_charges toic
		JOIN c_elementvalue ev_99999
		ON ev_99999.value = '99999'
		LEFT JOIN c_elementvalue ev_ari
		ON ev_ari.value = '12310' AND ev_99999.ad_client_id = ev_ari.ad_client_id
WHERE
	toic.c_charge_id = c.c_charge_id
	AND ev_99999.ad_client_id = c.ad_client_id;

-- If a charge still has a connection, just eliminate the account id
UPDATE c_charge
SET
	c_elementvalue_id = NULL
WHERE
		c_elementvalue_id IN (
		SELECT c_elementvalue_id FROM c_elementvalue WHERE value IN ('12320', '12330')
	);

-- Create new valid combinations for each of these updates
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id, c_charge_id)
SELECT
	c.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	actts.c_acctschema_id,
	c.c_elementvalue_id,
	c.c_charge_id
FROM
	c_charge c
		JOIN tmp_old_insurance_charges toic
		ON c.c_charge_id = toic.c_charge_id
		JOIN c_elementvalue ev
		ON c.c_elementvalue_id = ev.c_elementvalue_id
		JOIN c_acctschema actts
		ON c.ad_client_id = actts.ad_client_id;

INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;

-- Point the accounting to the new valid combinations
UPDATE c_charge_acct ca
SET
	ch_expense_acct = tvc.c_validcombination_id
FROM
	tmp_c_validcombination tvc
WHERE
	ca.c_charge_id = tvc.c_charge_id;

-- Point all postings to the insurance account
UPDATE fact_acct fa
SET
	account_id = COALESCE(ev_ari.c_elementvalue_id, ev_99999.c_elementvalue_id)
FROM
	c_elementvalue ev_99999
		JOIN c_elementvalue ev
		ON ev.ad_client_id = ev_99999.ad_client_id AND ev.value IN ('12320', '12330')
		LEFT JOIN c_elementvalue ev_ari
		ON ev_ari.ad_client_id = ev_99999.ad_client_id AND ev_ari.value = '12310'
WHERE
	ev_99999.value = '99999'
	AND ev_99999.ad_client_id = fa.ad_client_id
	AND fa.account_id = ev.c_elementvalue_id;

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_validcombination vc
	USING c_elementvalue ev
WHERE
	vc.account_id = ev.c_elementvalue_id
	AND ev.value IN ('12320', '12330');$$, 'c_validcombination_id');

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	i_elementvalue
WHERE
	value IN ('12320', '12330');
DELETE
FROM
	c_elementvalue_trl
WHERE
		c_elementvalue_id IN (
		SELECT
			c_elementvalue_id
		FROM
			c_elementvalue
		WHERE
			value IN ('12320', '12330')
	);
DELETE
FROM
	c_elementvalue
WHERE
	value IN ('12320', '12330');$$, 'c_elementvalue_id');

/******************************************************************************************/
--	4. Create new business partner groups for Insurance & Donors (waivers stay separate)
/******************************************************************************************/
-- Before doing anything, we need to correct the config client's price lists
-- Update the only price list (Standard) to be the purchase price list
UPDATE m_pricelist
SET
	name = 'Purchase'
WHERE
	ad_client_id = 2;
-- Insert a sales price list
INSERT INTO
	m_pricelist (m_pricelist_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, basepricelist_id, istaxincluded, issopricelist, isdefault, c_currency_id, enforcepricelimit,
	             priceprecision, ismandatory, ispresentforproduct, m_pricelist_uu)
SELECT
	m_pricelist_id + 1,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	'Sales',
	description,
	basepricelist_id,
	istaxincluded,
	'Y',
	isdefault,
	c_currency_id,
	enforcepricelimit,
	priceprecision,
	ismandatory,
	ispresentforproduct,
	uuid_generate_v4()
FROM
	m_pricelist
WHERE
	ad_client_id = 2;

-- Prepare the temp tables for more BP groups & associated accounting
DROP TABLE IF EXISTS tmp_c_bp_group;
CREATE TEMP TABLE tmp_c_bp_group
(
	c_bp_group_id       serial      NOT NULL,
	ad_client_id        numeric(10) NOT NULL,
	ad_org_id           numeric(10) NOT NULL DEFAULT 0,
-- 	isactive             char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created              timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) NOT NULL DEFAULT 100,
-- 	updated              timestamp   DEFAULT NOW()       NOT NULL,
	updatedby           numeric(10) NOT NULL DEFAULT 100,
	value               varchar(40) NOT NULL DEFAULT 'Patients',
	name                varchar(60) NOT NULL DEFAULT 'Patients - DO NOT CHANGE',
	description         varchar(255)         DEFAULT 'Patients - DO NOT CHANGE',
-- 	isdefault            char        DEFAULT 'N'::bpchar NOT NULL,
	ad_printcolor_id    numeric(10)          DEFAULT 100,
-- 	isconfidentialinfo   char        DEFAULT 'N'::bpchar NOT NULL,
	prioritybase        char                 DEFAULT 'S',
	m_pricelist_id      numeric(10),
-- 	po_pricelist_id      numeric(10),
-- 	m_discountschema_id  numeric(10),
-- 	po_discountschema_id numeric(10),
	creditwatchpercent  numeric              DEFAULT 0,
	pricematchtolerance numeric              DEFAULT 0,
-- 	c_dunning_id         numeric(10),
	c_bp_group_uu       uuid                 DEFAULT uuid_generate_v4(),
	bh_subtype          varchar,
	bh_locked           char
);

SELECT
	SETVAL(
		'tmp_c_bp_group_c_bp_group_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BP_Group'
			LIMIT 1
		)::INT,
		FALSE
		);

DROP TABLE IF EXISTS tmp_c_bp_group_acct;
CREATE TEMP TABLE tmp_c_bp_group_acct
(
	c_acctschema_id            numeric(10)             NOT NULL,
	c_bp_group_id              numeric(10)             NOT NULL,
	ad_client_id               numeric(10)             NOT NULL,
	ad_org_id                  numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive                    char      DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                     timestamp DEFAULT NOW()       NOT NULL,
	createdby                  numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                     timestamp DEFAULT NOW()       NOT NULL,
	updatedby                  numeric(10) DEFAULT 100 NOT NULL,
	c_receivable_acct          numeric(10)             NOT NULL,
	c_prepayment_acct          numeric(10)             NOT NULL,
	v_liability_acct           numeric(10)             NOT NULL,
	v_liability_services_acct  numeric(10),
	v_prepayment_acct          numeric(10)             NOT NULL,
	paydiscount_exp_acct       numeric(10)             NOT NULL,
	paydiscount_rev_acct       numeric(10)             NOT NULL,
	writeoff_acct              numeric(10)             NOT NULL,
	notinvoicedreceipts_acct   numeric(10)             NOT NULL,
	unearnedrevenue_acct       numeric(10),
-- 	notinvoicedrevenue_acct     numeric(10),
-- 	notinvoicedreceivables_acct numeric(10),
-- 	processing                  char,
	c_receivable_services_acct numeric(10),
	c_bp_group_acct_uu         uuid        DEFAULT uuid_generate_v4()
);

-- Insert the new patients BP group (since we'll be removing the bh_patient column)
INSERT INTO
	tmp_c_bp_group (ad_client_id, m_pricelist_id, bh_locked)
SELECT
	tctww.ad_client_id,
	pl.m_pricelist_id,
	'Y'
FROM
	tmp_clients_to_work_with tctww
		JOIN m_pricelist pl
		ON tctww.ad_client_id = pl.ad_client_id AND pl.issopricelist = 'Y' AND pl.isdefault = 'Y' AND isactive = 'Y';
-- Insert the patient BP group
INSERT INTO
	c_bp_group (c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description, ad_printcolor_id,
	            prioritybase, m_pricelist_id, creditwatchpercent, pricematchtolerance, c_bp_group_uu, bh_locked)
SELECT
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	ad_printcolor_id,
	prioritybase,
	m_pricelist_id,
	creditwatchpercent,
	pricematchtolerance,
	c_bp_group_uu,
	bh_locked
FROM
	tmp_c_bp_group;
-- Create the accounts for the the patients BP group
INSERT INTO
	tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, c_receivable_acct, c_prepayment_acct,
	                     v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
	                     paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
	                     c_receivable_services_acct)
SELECT
	accts.c_acctschema_id,
	tbpg.c_bp_group_id,
	tbpg.ad_client_id,
	asd.c_receivable_acct,
	asd.c_prepayment_acct,
	asd.v_liability_acct,
	asd.v_liability_services_acct,
	asd.v_prepayment_acct,
	asd.paydiscount_exp_acct,
	asd.paydiscount_rev_acct,
	asd.writeoff_acct,
	asd.notinvoicedreceipts_acct,
	asd.unearnedrevenue_acct,
	asd.c_receivable_services_acct
FROM
	tmp_c_bp_group tbpg
		JOIN c_acctschema accts
		ON tbpg.ad_client_id = accts.ad_client_id
		JOIN c_acctschema_default asd
		ON accts.c_acctschema_id = asd.c_acctschema_id;
-- Insert the patients BP group accounting
INSERT INTO
	c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                 c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct,
	                 paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct,
	                 unearnedrevenue_acct, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT
	c_acctschema_id,
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	paydiscount_exp_acct,
	paydiscount_rev_acct,
	writeoff_acct,
	notinvoicedreceipts_acct,
	unearnedrevenue_acct,
	c_receivable_services_acct,
	c_bp_group_acct_uu
FROM
	tmp_c_bp_group_acct;

-- Assign all patients to the patients BP group
UPDATE c_bpartner bp
SET
	c_bp_group_id = tbpg.c_bp_group_id
FROM
	tmp_c_bp_group tbpg
		CROSS JOIN c_bp_group bpg
WHERE
	bp.ad_client_id = tbpg.ad_client_id
	AND bp.bh_ispatient = 'Y'
	AND bp.c_bp_group_id = bpg.c_bp_group_id
	AND bpg.name != 'OTC Patient';

-- Create the groups & set the appropriate accounts for A/R (waivers will not be BPs - they remain charges)
-- Will have multiple groups for insurance since some is capitated
-- Create the capitation insurance BP group
TRUNCATE tmp_c_bp_group;
TRUNCATE tmp_c_bp_group_acct;
TRUNCATE tmp_c_validcombination;
INSERT INTO
	tmp_c_bp_group (ad_client_id, value, name, description, m_pricelist_id, bh_subtype, bh_locked)
SELECT
	tctww.ad_client_id,
	'Capitation Insurance',
	'Capitation Insurance - DO NOT CHANGE',
	'Capitation Insurance - DO NOT CHANGE',
	pl.m_pricelist_id,
	'I',
	'Y'
FROM
	tmp_clients_to_work_with tctww
		JOIN m_pricelist pl
		ON tctww.ad_client_id = pl.ad_client_id AND pl.issopricelist = 'Y' AND pl.isdefault = 'Y' AND isactive = 'Y';
-- Insert the capitation insurance BP group
INSERT INTO
	c_bp_group (c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description, ad_printcolor_id,
	            prioritybase, m_pricelist_id, creditwatchpercent, pricematchtolerance, c_bp_group_uu, bh_subtype,
	            bh_locked)
SELECT
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	ad_printcolor_id,
	prioritybase,
	m_pricelist_id,
	creditwatchpercent,
	pricematchtolerance,
	c_bp_group_uu,
	bh_subtype,
	bh_locked
FROM
	tmp_c_bp_group;
-- Create valid combinations for the capitation insurance accounts
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id, c_charge_id)
SELECT
	tctww.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	actts.c_acctschema_id,
	ev.c_elementvalue_id,
	0
FROM
	tmp_clients_to_work_with tctww
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '25200'
		JOIN c_acctschema actts
		ON tctww.ad_client_id = actts.ad_client_id;
-- Insert the actual capitation insurance account valid combinations
INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;
-- Create the accounts for the the capitation insurance BP group
INSERT INTO
	tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, c_receivable_acct, c_prepayment_acct,
	                     v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
	                     paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
	                     c_receivable_services_acct)
SELECT
	accts.c_acctschema_id,
	tbpg.c_bp_group_id,
	tbpg.ad_client_id,
	tvc.c_validcombination_id, -- Different A/R account from the defaults
	asd.c_prepayment_acct,
	asd.v_liability_acct,
	asd.v_liability_services_acct,
	asd.v_prepayment_acct,
	asd.paydiscount_exp_acct,
	asd.paydiscount_rev_acct,
	asd.writeoff_acct,
	asd.notinvoicedreceipts_acct,
	asd.unearnedrevenue_acct,
	asd.c_receivable_services_acct
FROM
	tmp_c_bp_group tbpg
		JOIN c_acctschema accts
		ON tbpg.ad_client_id = accts.ad_client_id
		JOIN c_acctschema_default asd
		ON accts.c_acctschema_id = asd.c_acctschema_id
		JOIN tmp_c_validcombination tvc
		ON tbpg.ad_client_id = tvc.ad_client_id;
-- Insert the capitation insurance BP group accounting
INSERT INTO
	c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                 c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct,
	                 paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct,
	                 unearnedrevenue_acct, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT
	c_acctschema_id,
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	paydiscount_exp_acct,
	paydiscount_rev_acct,
	writeoff_acct,
	notinvoicedreceipts_acct,
	unearnedrevenue_acct,
	c_receivable_services_acct,
	c_bp_group_acct_uu
FROM
	tmp_c_bp_group_acct;

-- Create the FFS insurance BP group
TRUNCATE tmp_c_bp_group;
TRUNCATE tmp_c_bp_group_acct;
TRUNCATE tmp_c_validcombination;
INSERT INTO
	tmp_c_bp_group (ad_client_id, value, name, description, m_pricelist_id, bh_subtype, bh_locked)
SELECT
	tctww.ad_client_id,
	'FFS Insurance',
	'FFS Insurance - DO NOT CHANGE',
	'FFS Insurance - DO NOT CHANGE',
	pl.m_pricelist_id,
	'I',
	'Y'
FROM
	tmp_clients_to_work_with tctww
		JOIN m_pricelist pl
		ON tctww.ad_client_id = pl.ad_client_id AND pl.issopricelist = 'Y' AND pl.isdefault = 'Y' AND isactive = 'Y';
-- Insert the FFS insurance BP group
INSERT INTO
	c_bp_group (c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description, ad_printcolor_id,
	            prioritybase, m_pricelist_id, creditwatchpercent, pricematchtolerance, c_bp_group_uu, bh_subtype,
	            bh_locked)
SELECT
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	ad_printcolor_id,
	prioritybase,
	m_pricelist_id,
	creditwatchpercent,
	pricematchtolerance,
	c_bp_group_uu,
	bh_subtype,
	bh_locked
FROM
	tmp_c_bp_group;
-- Create valid combinations for the FFS insurance accounts
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id, c_charge_id)
SELECT
	tctww.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	actts.c_acctschema_id,
	ev.c_elementvalue_id,
	0
FROM
	tmp_clients_to_work_with tctww
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '12310'
		JOIN c_acctschema actts
		ON tctww.ad_client_id = actts.ad_client_id;
-- Insert the actual FFS insurance account valid combinations
INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;
-- Create the accounts for the the FFS insurance BP group
INSERT INTO
	tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, c_receivable_acct, c_prepayment_acct,
	                     v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
	                     paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
	                     c_receivable_services_acct)
SELECT
	accts.c_acctschema_id,
	tbpg.c_bp_group_id,
	tbpg.ad_client_id,
	tvc.c_validcombination_id, -- Different A/R account from the defaults
	asd.c_prepayment_acct,
	asd.v_liability_acct,
	asd.v_liability_services_acct,
	asd.v_prepayment_acct,
	asd.paydiscount_exp_acct,
	asd.paydiscount_rev_acct,
	asd.writeoff_acct,
	asd.notinvoicedreceipts_acct,
	asd.unearnedrevenue_acct,
	asd.c_receivable_services_acct
FROM
	tmp_c_bp_group tbpg
		JOIN c_acctschema accts
		ON tbpg.ad_client_id = accts.ad_client_id
		JOIN c_acctschema_default asd
		ON accts.c_acctschema_id = asd.c_acctschema_id
		JOIN tmp_c_validcombination tvc
		ON tbpg.ad_client_id = tvc.ad_client_id;
-- Insert the FFS insurance BP group accounting
INSERT INTO
	c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                 c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct,
	                 paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct,
	                 unearnedrevenue_acct, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT
	c_acctschema_id,
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	paydiscount_exp_acct,
	paydiscount_rev_acct,
	writeoff_acct,
	notinvoicedreceipts_acct,
	unearnedrevenue_acct,
	c_receivable_services_acct,
	c_bp_group_acct_uu
FROM
	tmp_c_bp_group_acct;

-- Create the donors BP group
TRUNCATE tmp_c_bp_group;
TRUNCATE tmp_c_bp_group_acct;
TRUNCATE tmp_c_validcombination;
INSERT INTO
	tmp_c_bp_group (ad_client_id, value, name, description, m_pricelist_id, bh_subtype, bh_locked)
SELECT
	tctww.ad_client_id,
	'Donors',
	'Donors - DO NOT CHANGE',
	'Donors - DO NOT CHANGE',
	pl.m_pricelist_id,
	'D',
	'Y'
FROM
	tmp_clients_to_work_with tctww
		JOIN m_pricelist pl
		ON tctww.ad_client_id = pl.ad_client_id AND pl.issopricelist = 'Y' AND pl.isdefault = 'Y' AND isactive = 'Y';
-- Insert the donors BP group
INSERT INTO
	c_bp_group (c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, value, name, description, ad_printcolor_id,
	            prioritybase, m_pricelist_id, creditwatchpercent, pricematchtolerance, c_bp_group_uu, bh_subtype,
	            bh_locked)
SELECT
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	ad_printcolor_id,
	prioritybase,
	m_pricelist_id,
	creditwatchpercent,
	pricematchtolerance,
	c_bp_group_uu,
	bh_subtype,
	bh_locked
FROM
	tmp_c_bp_group;
-- Create valid combinations for the donor accounts
INSERT INTO
	tmp_c_validcombination (ad_client_id, combination, description, c_acctschema_id, account_id, c_charge_id)
SELECT
	tctww.ad_client_id,
	'*-' || ev.value || '-_-_',
	'*-' || ev.name || '-_-_',
	actts.c_acctschema_id,
	ev.c_elementvalue_id,
	0
FROM
	tmp_clients_to_work_with tctww
		JOIN c_elementvalue ev
		ON tctww.ad_client_id = ev.ad_client_id AND ev.value = '12710'
		JOIN c_acctschema actts
		ON tctww.ad_client_id = actts.ad_client_id;
-- Insert the actual FFS insurance account valid combinations
INSERT INTO
	c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, createdby, updatedby, combination, description,
	                    c_acctschema_id, account_id, c_validcombination_uu)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM
	tmp_c_validcombination;
-- Create the accounts for the the donors BP group
INSERT INTO
	tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, c_receivable_acct, c_prepayment_acct,
	                     v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
	                     paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
	                     c_receivable_services_acct)
SELECT
	accts.c_acctschema_id,
	tbpg.c_bp_group_id,
	tbpg.ad_client_id,
	tvc.c_validcombination_id, -- Different A/R account from the defaults
	asd.c_prepayment_acct,
	asd.v_liability_acct,
	asd.v_liability_services_acct,
	asd.v_prepayment_acct,
	asd.paydiscount_exp_acct,
	asd.paydiscount_rev_acct,
	asd.writeoff_acct,
	asd.notinvoicedreceipts_acct,
	asd.unearnedrevenue_acct,
	asd.c_receivable_services_acct
FROM
	tmp_c_bp_group tbpg
		JOIN c_acctschema accts
		ON tbpg.ad_client_id = accts.ad_client_id
		JOIN c_acctschema_default asd
		ON accts.c_acctschema_id = asd.c_acctschema_id
		JOIN tmp_c_validcombination tvc
		ON tbpg.ad_client_id = tvc.ad_client_id;
-- Insert the donors BP group accounting
INSERT INTO
	c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                 c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct,
	                 paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct,
	                 unearnedrevenue_acct, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT
	c_acctschema_id,
	c_bp_group_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_receivable_acct,
	c_prepayment_acct,
	v_liability_acct,
	v_liability_services_acct,
	v_prepayment_acct,
	paydiscount_exp_acct,
	paydiscount_rev_acct,
	writeoff_acct,
	notinvoicedreceipts_acct,
	unearnedrevenue_acct,
	c_receivable_services_acct,
	c_bp_group_acct_uu
FROM
	tmp_c_bp_group_acct;

/******************************************************************************************/
--	5. Migrate all default charges to be BPs
/******************************************************************************************/
-- Remove unneeded BP tables and fields
DROP VIEW IF EXISTS bh_number_of_patients_v;
DROP VIEW IF EXISTS bh_patients_seen_by_month_v;

-- Remove unused columns from c_bpartner
ALTER TABLE c_bpartner
	DROP COLUMN bh_approximateyears;
ALTER TABLE c_bpartner
	DROP COLUMN bh_ispatient;
ALTER TABLE c_bpartner
	DROP COLUMN bh_c_location_id;
ALTER TABLE c_bpartner
	DROP COLUMN nhif_number;
ALTER TABLE c_bpartner
	DROP COLUMN bh_patient_notes;
ALTER TABLE c_bpartner
	DROP COLUMN bh_nhif_member_name;
ALTER TABLE c_bpartner
	DROP COLUMN bh_nhif_relationship;
ALTER TABLE c_bpartner
	DROP COLUMN isnewpatient;
ALTER TABLE c_bpartner
	DROP COLUMN bh_nhif_type;
ALTER TABLE c_bpartner
	DROP COLUMN bh_lastpatientid;

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
				ad_element_id IN (
				SELECT
					ad_element_id
				FROM
					ad_element
				WHERE
						LOWER(columnname) IN
						('bh_approximateyears', 'bh_ispatient', 'bh_c_location_id', 'nhif_number', 'bh_patient_notes',
						 'bh_nhif_member_name', 'bh_nhif_relationship', 'isnewpatient', 'bh_nhif_type', 'bh_lastpatientid')
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_element_id IN (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
				LOWER(columnname) IN
				('bh_approximateyears', 'bh_ispatient', 'bh_c_location_id', 'nhif_number', 'bh_patient_notes',
				 'bh_nhif_member_name', 'bh_nhif_relationship', 'isnewpatient', 'bh_nhif_type', 'bh_lastpatientid')
	);
DELETE
FROM
	ad_element
WHERE
		LOWER(columnname) IN ('bh_approximateyears', 'bh_ispatient', 'bh_c_location_id', 'nhif_number', 'bh_patient_notes',
		                      'bh_nhif_member_name', 'bh_nhif_relationship', 'isnewpatient', 'bh_nhif_type',
		                      'bh_lastpatientid');

-- Some clients have weird access for the default charges - fix it
UPDATE c_charge
SET
	bh_subtype                 = 'I',
	bh_needadditionalvisitinfo = 'Y'
WHERE
	name = 'NHIF National Scheme';

-- Manually differentiate between capitated and not (NHIF National Scheme is the only capitated)
DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TABLE tmp_c_bpartner
(
	c_bpartner_id              serial                          NOT NULL,
	ad_client_id               numeric(10)                     NOT NULL,
	ad_org_id                  numeric(10) DEFAULT 0           NOT NULL,
	isactive                   char        DEFAULT 'Y'::bpchar NOT NULL,
	created                    timestamp   DEFAULT NOW()       NOT NULL,
	createdby                  numeric(10)                     NOT NULL,
	updated                    timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                  numeric(10)                     NOT NULL,
	value                      varchar(40)                     NOT NULL,
	name                       varchar(120)                    NOT NULL,
-- 	name2                       varchar(60),
	description                varchar(255),
-- 	issummary                   char         DEFAULT 'N'::bpchar NOT NULL,
	c_bp_group_id              numeric(10)                     NOT NULL,
-- 	isonetime                   char         DEFAULT 'N'::bpchar NOT NULL,
-- 	isprospect                  char         DEFAULT 'N'::bpchar NOT NULL,
-- 	isvendor                    char         DEFAULT 'N'::bpchar NOT NULL,
-- 	iscustomer                  char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	isemployee                  char         DEFAULT 'N'::bpchar NOT NULL,
-- 	issalesrep                  char         DEFAULT 'N'::bpchar NOT NULL,
-- 	referenceno                 varchar(40),
-- 	duns                        varchar(11),
-- 	url                         varchar(120),
	ad_language                varchar(6),
-- 	taxid                       varchar(20),
-- 	istaxexempt                 char         DEFAULT 'N'::bpchar,
-- 	c_invoiceschedule_id        numeric(10),
-- 	rating                      char,
	salesvolume                numeric(10) DEFAULT 0,
	numberemployees            numeric(10) DEFAULT 0,
-- 	naics                       varchar(6),
-- 	firstsale                   timestamp,
-- 	acqusitioncost              numeric      DEFAULT 0,
-- 	potentiallifetimevalue      numeric      DEFAULT 0,
-- 	actuallifetimevalue         numeric      DEFAULT 0,
	shareofcustomer            numeric(10) DEFAULT 0,
	paymentrule                char        DEFAULT 'P',
-- 	so_creditlimit              numeric      DEFAULT 0,
-- 	so_creditused               numeric      DEFAULT 0,
	c_paymentterm_id           numeric(10),
	m_pricelist_id             numeric(10),
-- 	m_discountschema_id         numeric(10),
-- 	c_dunning_id                numeric(10),
	isdiscountprinted          char        DEFAULT 'N'::bpchar,
-- 	so_description              varchar(255),
-- 	poreference                 varchar(20),
-- 	paymentrulepo               char,
-- 	po_pricelist_id             numeric(10),
-- 	po_discountschema_id        numeric(10),
-- 	po_paymentterm_id           numeric(10),
	documentcopies             numeric(10) DEFAULT 0,
-- 	c_greeting_id               numeric(10),
	invoicerule                char        DEFAULT 'I',
-- 	deliveryrule                char,
-- 	freightcostrule             char,
-- 	deliveryviarule             char,
-- 	salesrep_id                 numeric(10),
-- 	sendemail                   char         DEFAULT 'N'::bpchar NOT NULL,
-- 	bpartner_parent_id          numeric(10),
-- 	invoice_printformat_id      numeric(10),
	socreditstatus             char        DEFAULT 'X'::bpchar,
	shelflifeminpct            numeric(10) DEFAULT 0,
-- 	ad_orgbp_id                 numeric(10),
	flatdiscount               numeric     DEFAULT 0,
	totalopenbalance           numeric     DEFAULT 0,
-- 	dunninggrace                timestamp,
-- 	c_taxgroup_id               numeric(10),
-- 	logo_id                     numeric(10)  DEFAULT NULL::numeric,
-- 	ispotaxexempt               char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ismanufacturer              char         DEFAULT 'N'::bpchar,
	c_bpartner_uu              uuid        DEFAULT uuid_generate_v4(),
-- 	customerprofileid           varchar(60)  DEFAULT NULL::character varying,
-- 	default1099box_id           numeric(10)  DEFAULT NULL::numeric,
-- 	is1099vendor                char         DEFAULT 'N'::bpchar NOT NULL,
-- 	bh_birthday                 timestamp,
-- 	bh_email                    varchar(60)  DEFAULT NULL::character varying,
-- 	bh_phone                    varchar(40)  DEFAULT NULL::character varying,
-- 	bh_patientid                varchar(22),
-- 	nationalid                  varchar(10),
-- 	nextofkin_name              varchar(100) DEFAULT NULL::character varying,
-- 	nextofkin_contact           varchar(100) DEFAULT NULL::character varying,
-- 	bh_occupation               varchar(100) DEFAULT NULL::character varying,
-- 	bh_gender                   varchar(10)  DEFAULT NULL::character varying,
-- 	bh_nextappointmentdate      timestamp,
-- 	bh_local_patientid          varchar(100),
-- 	bh_isapproximatedateofbirth char         DEFAULT 'N'::bpchar NOT NULL,
	bh_needadditionalvisitinfo char,
	c_charge_id                numeric                         NOT NULL,
	mapped_c_charge_id         numeric                         NOT NULL,
	bh_locked                  char
);

SELECT
	SETVAL(
		'tmp_c_bpartner_c_bpartner_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BPartner'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Remove erroneous waivers
DELETE
FROM
	c_charge_trl
WHERE
		c_charge_id IN (
		SELECT c_charge_id FROM c_charge WHERE bh_subtype = 'W' AND name != 'Bill Waiver'
	);
DELETE
FROM
	c_charge
WHERE
	bh_subtype = 'W'
	AND name != 'Bill Waiver';

-- Insert NHIF National Scheme
INSERT INTO
	tmp_c_bpartner (ad_client_id, createdby, updatedby, value, name, description, c_bp_group_id, ad_language,
	                c_paymentterm_id, m_pricelist_id, bh_needadditionalvisitinfo, c_charge_id, mapped_c_charge_id,
	                bh_locked)
SELECT
	c.ad_client_id,
	c.createdby,
	c.updatedby,
	c.name,
	c.name,
	c.description,
	bpg.c_bp_group_id,
	cl.ad_language,
	pt.c_paymentterm_id,
	bpg.m_pricelist_id,
	c.bh_needadditionalvisitinfo,
	c.c_charge_id,
	c_new.c_charge_id,
	c.bh_locked
FROM
	c_charge c
		JOIN tmp_clients_to_work_with tctww
		ON c.ad_client_id = tctww.ad_client_id
		JOIN c_bp_group bpg
		ON tctww.ad_client_id = bpg.ad_client_id AND bpg.name = 'Capitation Insurance - DO NOT CHANGE'
		JOIN ad_client cl
		ON cl.ad_client_id = tctww.ad_client_id
		JOIN c_paymentterm pt
		ON tctww.ad_client_id = pt.ad_client_id AND pt.value = 'Immediate'
		JOIN c_chargetype ct
		ON c.c_chargetype_id = ct.c_chargetype_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
		JOIN c_bp_group_acct bpga
		ON bpg.c_bp_group_id = bpga.c_bp_group_id
		JOIN c_validcombination bpgvc
		ON bpga.c_receivable_acct = bpgvc.c_validcombination_id
		JOIN c_validcombination nvc
		ON bpgvc.account_id = nvc.account_id
		JOIN c_charge_acct ca
		ON nvc.c_validcombination_id = ca.ch_expense_acct
		JOIN c_charge c_new
		ON c_new.c_charge_id = ca.c_charge_id AND c_new.name = 'Capitation Insurance Payable'
WHERE
	c.name = 'NHIF National Scheme'
	AND c.bh_subtype = 'I';
-- Insert FFS insurance and waivers
INSERT INTO
	tmp_c_bpartner (ad_client_id, createdby, updatedby, value, name, description, c_bp_group_id, ad_language,
	                c_paymentterm_id, m_pricelist_id, bh_needadditionalvisitinfo, c_charge_id, mapped_c_charge_id,
	                bh_locked)
SELECT
	c.ad_client_id,
	c.createdby,
	c.updatedby,
	c.name,
	c.name,
	c.description,
	bpg.c_bp_group_id,
	cl.ad_language,
	pt.c_paymentterm_id,
	bpg.m_pricelist_id,
	c.bh_needadditionalvisitinfo,
	c.c_charge_id,
	c_new.c_charge_id,
	c.bh_locked
FROM
	c_charge c
		JOIN tmp_clients_to_work_with tctww
		ON c.ad_client_id = tctww.ad_client_id
		JOIN c_bp_group bpg
		ON tctww.ad_client_id = bpg.ad_client_id AND bpg.name = CASE
			                                                        WHEN c.bh_subtype = 'I'
				                                                        THEN 'FFS Insurance - DO NOT CHANGE'
			                                                        ELSE 'Donors - DO NOT CHANGE' END
		JOIN ad_client cl
		ON cl.ad_client_id = tctww.ad_client_id
		JOIN c_paymentterm pt
		ON tctww.ad_client_id = pt.ad_client_id AND pt.value = 'Immediate'
		JOIN c_chargetype ct
		ON c.c_chargetype_id = ct.c_chargetype_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
		JOIN c_bp_group_acct bpga
		ON bpg.c_bp_group_id = bpga.c_bp_group_id
		JOIN c_validcombination bpgvc
		ON bpga.c_receivable_acct = bpgvc.c_validcombination_id
		JOIN c_validcombination nvc
		ON bpgvc.account_id = nvc.account_id
		JOIN c_charge_acct ca
		ON nvc.c_validcombination_id = ca.ch_expense_acct
		JOIN c_charge c_new
		ON c_new.c_charge_id = ca.c_charge_id AND c_new.name = CASE
			                                                       WHEN c.bh_subtype = 'I'
				                                                       THEN 'Accounts Receivable - FFS Insurance'
			                                                       ELSE 'Accounts Receivable - Donations' END
WHERE
	c.name != 'NHIF National Scheme'
	AND c.bh_subtype IN ('I', 'D');

-- Insert all the new BPs
INSERT INTO
	c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	            description, c_bp_group_id, ad_language, salesvolume, numberemployees, shareofcustomer, paymentrule,
	            c_paymentterm_id, m_pricelist_id, isdiscountprinted, documentcopies, invoicerule, socreditstatus,
	            shelflifeminpct, flatdiscount, totalopenbalance, c_bpartner_uu, bh_needadditionalvisitinfo, bh_locked)
SELECT
	c_bpartner_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	value,
	name,
	description,
	c_bp_group_id,
	ad_language,
	salesvolume,
	numberemployees,
	shareofcustomer,
	paymentrule,
	c_paymentterm_id,
	m_pricelist_id,
	isdiscountprinted,
	documentcopies,
	invoicerule,
	socreditstatus,
	shelflifeminpct,
	flatdiscount,
	totalopenbalance,
	c_bpartner_uu,
	bh_needadditionalvisitinfo,
	bh_locked
FROM
	tmp_c_bpartner;

-- Add the appropriate default accounting for the BPs (based of the BP group)
INSERT INTO
	c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct,
	                    c_prepayment_acct, c_receivable_services_acct, c_bp_customer_acct_uu)
SELECT
	tbp.c_bpartner_id,
	c_acctschema_id,
	tbp.ad_client_id,
	0,
	100,
	100,
	c_receivable_acct,
	c_prepayment_acct,
	c_receivable_services_acct,
	uuid_generate_v4()
FROM
	tmp_c_bpartner tbp
		JOIN c_bp_group_acct bpga
		ON tbp.c_bp_group_id = bpga.c_bp_group_id;

DROP TABLE IF EXISTS tmp_c_location;
CREATE TABLE tmp_c_location
(
	c_location_id serial                  NOT NULL,
	ad_client_id  numeric(10)             NOT NULL,
	ad_org_id     numeric(10) DEFAULT 0   NOT NULL,
-- 	isactive               char          DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp     DEFAULT NOW()       NOT NULL,
	createdby     numeric(10) DEFAULT 100 NOT NULL,
-- 	updated                timestamp     DEFAULT NOW()       NOT NULL,
	updatedby     numeric(10) DEFAULT 100 NOT NULL,
-- 	address1               varchar(60),
-- 	address2               varchar(60),
-- 	city                   varchar(60),
-- 	postal                 varchar(10),
-- 	postal_add             varchar(10),
	c_country_id  numeric(10)             NOT NULL,
-- 	c_region_id            numeric(10),
-- 	c_city_id              numeric(10),
-- 	regionname             varchar(40),
-- 	address3               varchar(60),
-- 	address4               varchar(60),
	c_location_uu uuid        DEFAULT uuid_generate_v4()
-- 	validateaddress        char          DEFAULT NULL::bpchar,
-- 	result                 varchar(2000) DEFAULT NULL::character varying,
-- 	isvalid                char          DEFAULT 'N'::bpchar,
-- 	c_addressvalidation_id numeric(10)   DEFAULT NULL::numeric,
-- 	address5               varchar(60)   DEFAULT NULL::character varying,
-- 	comments               varchar(2000) DEFAULT NULL::character varying
);

SELECT
	SETVAL(
		'tmp_c_location_c_location_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_Location'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Add locations for each of these BPs
INSERT INTO
	tmp_c_location (ad_client_id, c_country_id)
SELECT
	tctww.ad_client_id,
	l.c_country_id
FROM
	tmp_clients_to_work_with tctww
		JOIN ad_org o
		ON o.ad_client_id = tctww.ad_client_id
		JOIN ad_orginfo oi
		ON o.ad_org_id = oi.ad_org_id
		JOIN c_location l
		ON oi.c_location_id = l.c_location_id;
INSERT INTO
	c_location (c_location_id, ad_client_id, ad_org_id, createdby, updatedby, c_country_id, c_location_uu)
SELECT
	c_location_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_country_id,
	c_location_uu
FROM
	tmp_c_location;

-- Finally, add the BP locations for each of these locations
DROP TABLE IF EXISTS tmp_c_bpartner_location;
CREATE TABLE tmp_c_bpartner_location
(
	c_bpartner_location_id serial                                 NOT NULL,
	ad_client_id           numeric(10)                            NOT NULL,
	ad_org_id              numeric(10) DEFAULT 0                  NOT NULL,
-- 	isactive               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp   DEFAULT NOW()       NOT NULL,
	createdby              numeric(10) DEFAULT 100                NOT NULL,
-- 	updated                timestamp   DEFAULT NOW()       NOT NULL,
	updatedby              numeric(10) DEFAULT 100                NOT NULL,
	name                   varchar(60) DEFAULT 'Default Location' NOT NULL,
-- 	isbillto               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isshipto               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	ispayfrom              char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isremitto              char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	phone                  varchar(40),
-- 	phone2                 varchar(40),
-- 	fax                    varchar(40),
-- 	isdn                   varchar(40),
-- 	c_salesregion_id       numeric(10),
	c_bpartner_id          numeric(10)                            NOT NULL,
	c_location_id          numeric(10),
	c_bpartner_location_uu uuid        DEFAULT uuid_generate_v4(),
-- 	customeraddressid      varchar(60) DEFAULT NULL::character varying,
	ispreservecustomname   char        DEFAULT 'N'
);

SELECT
	SETVAL(
		'tmp_c_bpartner_location_c_bpartner_location_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_Location'
			LIMIT 1
		)::INT,
		FALSE
		);

-- Do the temp BP location insert
INSERT INTO
	tmp_c_bpartner_location (ad_client_id, c_bpartner_id, c_location_id)
SELECT
	tl.ad_client_id,
	tbp.c_bpartner_id,
	tl.c_location_id
FROM
	tmp_c_bpartner tbp
		JOIN tmp_c_location tl
		ON tl.ad_client_id = tbp.ad_client_id;

-- Do the real BP location insert
INSERT INTO
	c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id,
	                     c_location_id, c_bpartner_location_uu, ispreservecustomname)
SELECT
	c_bpartner_location_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	c_bpartner_id,
	c_location_id,
	c_bpartner_location_uu,
	ispreservecustomname
FROM
	tmp_c_bpartner_location;

-- No users are needed for these BPs

/******************************************************************************************/
--	6. Update tables to match our new direction
/******************************************************************************************/
-- Delete from the tables where the clients are inactive
DELETE
FROM
	bh_charge_info_values
WHERE
		ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			tmp_clients_to_work_with
	);
DELETE
FROM
	bh_orderline_charge_info
WHERE
		ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			tmp_clients_to_work_with
	);
DELETE
FROM
	bh_charge_info
WHERE
		ad_client_id NOT IN (
		SELECT
			ad_client_id
		FROM
			tmp_clients_to_work_with
	);

-- Migrate bh_charge_info to bh_payer_info_field
INSERT INTO
	bh_payer_info_field (AD_Client_ID, AD_Org_ID, BH_PayerInfoFieldDataType, BH_FillFromPatient, BH_Payer_ID,
	                     BH_Payer_Info_Field_ID, BH_Payer_Info_Field_UU, Created, CreatedBy, Description, IsActive, Line,
	                     Name, Updated, UpdatedBy)
SELECT
	ci.AD_Client_ID,
	ci.AD_Org_ID,
	ci.BH_ChargeInfoDataType,
	ci.BH_FillFromPatient,
	tbp.c_bpartner_id,
	ci.bh_charge_info_id,
	ci.bh_charge_info_uu,
	ci.Created,
	ci.CreatedBy,
	ci.Description,
	ci.IsActive,
	ci.Line,
	ci.Name,
	ci.Updated,
	ci.UpdatedBy
FROM
	bh_charge_info ci
		JOIN tmp_c_bpartner tbp
		ON ci.c_charge_id = tbp.c_charge_id;

-- Migrate bh_charge_info_values to bh_payer_info_field_value
INSERT INTO
	BH_Payer_Info_Field_Value (AD_Client_ID, AD_Org_ID, BH_Payer_Info_Field_ID, BH_Payer_Info_Field_Value_ID,
	                           BH_Payer_Info_Field_Value_UU, Created, CreatedBy, Description, IsActive, Line, Name,
	                           Updated, UpdatedBy)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	bh_charge_info_id,
	bh_charge_info_values_id,
	bh_charge_info_values_uu,
	Created,
	CreatedBy,
	Description,
	IsActive,
	Line,
	Name,
	Updated,
	UpdatedBy
FROM
	bh_charge_info_values;

-- Migrate bh_charge_info_suggestions to bh_payer_info_field_suggestion
INSERT INTO
	BH_Payer_Info_Field_Suggestion (AD_Client_ID, AD_Org_ID, BH_PayerInfoFieldDataType, BH_FillFromPatient,
	                                BH_Payer_Info_Field_Suggestion_ID, BH_Payer_Info_Field_Suggestion_UU, BH_SubType,
	                                Created, CreatedBy, Description, IsActive, Line, Name, Updated, UpdatedBy)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	BH_ChargeInfoDataType,
	BH_FillFromPatient,
	bh_charge_info_suggestion_id,
	bh_charge_info_suggestion_uu,
	BH_SubType,
	Created,
	CreatedBy,
	Description,
	IsActive,
	Line,
	Name,
	Updated,
	UpdatedBy
FROM
	bh_charge_info_suggestion;

-- Migrate bh_charge_info_values_suggestion to bh_payer_info_field_value_suggestion
INSERT INTO
	BH_Payer_Info_Field_Value_Suggestion (AD_Client_ID, AD_Org_ID, BH_Payer_Info_Field_Suggestion_ID,
	                                      BH_Payer_Info_Field_Value_Suggestion_ID,
	                                      BH_Payer_Info_Field_Value_Suggestion_UU, Created, CreatedBy, Description,
	                                      IsActive, Line, Name, Updated, UpdatedBy)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	bh_charge_info_suggestion_id,
	bh_charge_info_values_suggestion_id,
	bh_charge_info_values_suggestion_uu,
	Created,
	CreatedBy,
	Description,
	IsActive,
	Line,
	Name,
	Updated,
	UpdatedBy
FROM
	bh_charge_info_values_suggestion;

-- Migrate bh_bpartner_charge to bh_bp_payer_info
INSERT INTO
	BH_BP_Payer_Info (AD_Client_ID, AD_Org_ID, BH_BP_Payer_Info_ID, BH_BP_Payer_Info_UU, BH_Payer_ID, C_BPartner_ID,
	                  Created, CreatedBy, Description, IsActive, Name, Updated, UpdatedBy)
SELECT
	bpc.AD_Client_ID,
	bpc.AD_Org_ID,
	bpc.bh_bpartner_charge_id,
	bpc.bh_bpartner_charge_uu,
	tbp.c_bpartner_id,
	bpc.C_BPartner_ID,
	bpc.Created,
	bpc.CreatedBy,
	bpc.Description,
	bpc.IsActive,
	bpc.Name,
	bpc.Updated,
	bpc.UpdatedBy
FROM
	bh_bpartner_charge bpc
		JOIN tmp_c_bpartner tbp
		ON tbp.c_charge_id = bpc.c_charge_id;

-- Migrate bh_bpartner_charge_info to bh_bp_general_payer_info
INSERT INTO
	BH_BP_General_Payer_Info (AD_Client_ID, AD_Org_ID, BH_BP_General_Payer_Info_ID, BH_BP_General_Payer_Info_UU,
	                          BH_BP_Payer_Info_ID, BH_Payer_Info_Field_ID, Created, CreatedBy, Description, IsActive,
	                          Name, Updated, UpdatedBy)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	bh_bpartner_charge_info_id,
	bh_bpartner_charge_info_uu,
	bh_bpartner_charge_id,
	bh_charge_info_id,
	Created,
	CreatedBy,
	Description,
	IsActive,
	Name,
	Updated,
	UpdatedBy
FROM
	bh_bpartner_charge_info;

-- Migrate bh_orderline_charge_info to bh_bp_specific_payer_info
INSERT INTO
	BH_BP_Specific_Payer_Info (AD_Client_ID, AD_Org_ID, bh_payer_info_field_id, BH_BP_Specific_Payer_Info_ID,
	                           BH_BP_Specific_Payer_Info_UU, C_OrderLine_ID, Created, CreatedBy, Description, IsActive,
	                           Name, Updated, UpdatedBy)
SELECT
	AD_Client_ID,
	AD_Org_ID,
	bh_charge_info_id,
	bh_orderline_charge_info_id,
	bh_orderline_charge_info_uu,
	C_OrderLine_ID,
	Created,
	CreatedBy,
	Description,
	IsActive,
	Name,
	Updated,
	UpdatedBy
FROM
	bh_orderline_charge_info;

-- Update the referenced list name
UPDATE ad_reference
SET
	name = 'Payer Info Field Data Type'
WHERE
	ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6';

-- Move all charges on order lines that were the non-patient payments to be the new charges we use
UPDATE c_orderline ol
SET
	c_charge_id = tbp.mapped_c_charge_id
FROM
	tmp_c_bpartner tbp
WHERE
	ol.c_charge_id = tbp.c_charge_id;
UPDATE c_invoiceline il
SET
	c_charge_id = tbp.mapped_c_charge_id
FROM
	tmp_c_bpartner tbp
WHERE
	il.c_charge_id = tbp.c_charge_id;
UPDATE m_inoutline iol
SET
	c_charge_id = tbp.mapped_c_charge_id
FROM
	tmp_c_bpartner tbp
WHERE
	iol.c_charge_id = tbp.c_charge_id;

-- Now clear out the charges we're going to delete for our inactive clients
UPDATE c_orderline ol
SET
	c_charge_id = NULL
FROM
	ad_client c
		JOIN c_charge ch
		ON c.ad_client_id = ch.ad_client_id AND ch.bh_subtype IN ('I', 'D')
WHERE
	ol.ad_client_id = c.ad_client_id
	AND c.isactive = 'N'
	AND ol.c_charge_id = ch.c_charge_id;
UPDATE c_invoiceline il
SET
	c_charge_id = NULL
FROM
	ad_client c
		JOIN c_charge ch
		ON c.ad_client_id = ch.ad_client_id AND ch.bh_subtype IN ('I', 'D')
WHERE
	il.ad_client_id = c.ad_client_id
	AND c.isactive = 'N'
	AND il.c_charge_id = ch.c_charge_id;
UPDATE m_inoutline iol
SET
	c_charge_id = NULL
FROM
	ad_client c
		JOIN c_charge ch
		ON c.ad_client_id = ch.ad_client_id AND ch.bh_subtype IN ('I', 'D')
WHERE
	iol.ad_client_id = c.ad_client_id
	AND c.isactive = 'N'
	AND iol.c_charge_id = ch.c_charge_id;

/******************************************************************************************/
--	7. Remove tables & columns no longer needed
/******************************************************************************************/
-- Remove the old charge info tables
DROP TABLE bh_orderline_charge_info;
DROP TABLE bh_bpartner_charge_info;
DROP TABLE bh_bpartner_charge;
DROP TABLE bh_charge_info_values_suggestion;
DROP TABLE bh_charge_info_suggestion;
DROP TABLE bh_charge_info_values;
DROP TABLE bh_charge_info;

-- Remove bh_orderline_charge_info from the iDempiere tables
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_orderline_charge_info'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_orderline_charge_info'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_orderline_charge_info';
-- Remove bh_bpartner_charge_info from the iDempiere tables
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_bpartner_charge_info'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_bpartner_charge_info'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_bpartner_charge_info';
-- Remove bh_bpartner_charge from the iDempiere tables
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_bpartner_charge'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_bpartner_charge'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_bpartner_charge';
-- Remove bh_charge_info_values_suggestion from the iDempiere tables
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values_suggestion'
			)
	);
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values_suggestion'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values_suggestion'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values_suggestion'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_charge_info_values_suggestion';
-- Remove bh_charge_info_suggestion from the iDempiere tables
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_suggestion'
			)
	);
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_suggestion'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_suggestion'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_suggestion'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_charge_info_suggestion'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_charge_info_suggestion';
-- Remove bh_charge_info_values from the iDempiere tables
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values'
			)
	);
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info_values'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_charge_info_values'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_charge_info_values';
-- Remove bh_charge_info from the iDempiere tables
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info'
			)
	);
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_charge_info'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_charge_info'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_charge_info';

-- Remove all insurance and donor charges
DELETE
FROM
	c_charge_acct
WHERE
		c_charge_id IN (
		SELECT
			c_charge_id
		FROM
			c_charge
		WHERE
			bh_subtype IN ('I', 'D')
	);
DELETE
FROM
	c_charge_trl
WHERE
		c_charge_id IN (
		SELECT
			c_charge_id
		FROM
			c_charge
		WHERE
			bh_subtype IN ('I', 'D')
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_charge
WHERE
	bh_subtype IN ('I', 'D');
$$, 'c_charge_id');

-- Remove the income charges
DELETE
FROM
	c_charge_trl
WHERE
		c_charge_id IN (
		SELECT
			c_charge_id
		FROM
			c_charge
		WHERE
				c_chargetype_id IN (
				SELECT c_chargetype_id FROM c_chargetype WHERE name = 'Default Income Category - DO NOT CHANGE'
			)
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_charge
WHERE
		c_chargetype_id IN (
		SELECT c_chargetype_id FROM c_chargetype WHERE name = 'Default Income Category - DO NOT CHANGE'
	);
$$, 'c_charge_id');
DELETE
FROM
	c_chargetype
WHERE
	name = 'Default Income Category - DO NOT CHANGE';

-- Remove default charges
DROP TABLE bh_chargedefault;
-- Remove the default charges from the DB
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargedefault'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargedefault'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargedefault'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargedefault'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_chargedefault'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_chargedefault';

-- Remove default charge types
DROP TABLE bh_chargetypedefault;
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
				ad_table_id IN (
				SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargetypedefault'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargetypedefault'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_table_id IN (
		SELECT ad_table_id FROM ad_table WHERE LOWER(tablename) = 'bh_chargetypedefault'
	);
DELETE
FROM
	ad_tab
WHERE
		ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			LOWER(tablename) = 'bh_chargetypedefault'
	);
DELETE
FROM
	ad_table
WHERE
	LOWER(tablename) = 'bh_chargetypedefault';

-- Remove unused columns from c_charge
ALTER TABLE c_charge
	DROP COLUMN bh_subtype;
ALTER TABLE c_charge
	DROP COLUMN bh_needadditionalvisitinfo;
ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS c_charge_c_elementvalue_id_fkey;
ALTER TABLE c_charge
	DROP COLUMN c_elementvalue_id;

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
				ad_element_id IN (
				SELECT
					ad_element_id
				FROM
					ad_element
				WHERE
						LOWER(columnname) IN ('bh_subtype', 'bh_needadditionalvisitinfo', 'c_elementvalue_id')
			)
			AND ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename = 'C_Charge'
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_element_id IN (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
				LOWER(columnname) IN ('bh_subtype', 'bh_needadditionalvisitinfo', 'c_elementvalue_id')
	)
	AND ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename = 'C_Charge'
	);

DELETE
FROM
	ad_element
WHERE
		ad_element_id NOT IN (
		SELECT
			ad_element_id
		FROM
			ad_column
	)
	AND ad_element_id NOT IN (
		SELECT
			ad_element_id
		FROM
			ad_process_para
	);

-- Lastly, remove the windows we're no longer using
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_menu_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
				ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
						ad_window_uu IN ('1be2ed69-2ece-4620-8932-737d815b2fea', '8d993058-5cf9-499a-a23b-d3abb4c50176',
						                 '7428298d-d41a-499e-a872-ac01a0e8ecb0', '20639eca-bd84-4ae3-b890-7b32987fcb5e')
			)
	);
DELETE
FROM
	ad_menu
WHERE
		ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
				ad_window_uu IN ('1be2ed69-2ece-4620-8932-737d815b2fea', '8d993058-5cf9-499a-a23b-d3abb4c50176',
				                 '7428298d-d41a-499e-a872-ac01a0e8ecb0', '20639eca-bd84-4ae3-b890-7b32987fcb5e')
	);
DELETE
FROM
	ad_window
WHERE
		ad_window_uu IN ('1be2ed69-2ece-4620-8932-737d815b2fea', '8d993058-5cf9-499a-a23b-d3abb4c50176',
		                 '7428298d-d41a-499e-a872-ac01a0e8ecb0', '20639eca-bd84-4ae3-b890-7b32987fcb5e');

/******************************************************************************************/
--	8. Wrap-up
/******************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202308151357_GO-1335.sql')
FROM
	dual;
