-- Create the allergy and allergy-reaction tables
ALTER TABLE C_BPartner
	ADD COLUMN BH_Have_Specified_No_Known_Allergies CHAR(1) NOT NULL CHECK (BH_Have_Specified_No_Known_Allergies IN ('Y', 'N')) DEFAULT 'N';

CREATE TABLE IF NOT EXISTS bh_allergy
(
	ad_client_id        numeric(10)                      NOT NULL,
	ad_org_id           numeric(10)                      NOT NULL,
	bh_allergy_id       numeric(10)                      NOT NULL,
	bh_allergy_note     text,
	bh_allergy_uu       varchar(36)  DEFAULT NULL::character varying,
	bh_concept_id       numeric(10)  DEFAULT NULL::numeric,
	bh_uncoded_allergen text,
	c_bpartner_id       numeric(10)                      NOT NULL,
	created             timestamp    DEFAULT getdate()   NOT NULL,
	createdby           numeric(10)                      NOT NULL,
	description         varchar(255) DEFAULT NULL::character varying,
	isactive            char         DEFAULT 'Y'::bpchar NOT NULL,
	severity_concept_id numeric(10)  DEFAULT NULL::numeric,
	updated             timestamp    DEFAULT getdate()   NOT NULL,
	updatedby           numeric(10)                      NOT NULL
);

ALTER TABLE bh_allergy
	OWNER TO adempiere;
ALTER TABLE bh_allergy
	ADD CONSTRAINT bh_allergy_key
		PRIMARY KEY (bh_allergy_id);
ALTER TABLE bh_allergy
	ADD CONSTRAINT bh_allergy_uu_idx
		UNIQUE (bh_allergy_uu);
ALTER TABLE bh_allergy
	ADD CONSTRAINT adclient_bhallergy
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy
	ADD CONSTRAINT adorg_bhallergy
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy
	ADD CONSTRAINT bhconcept_bhallergy
		FOREIGN KEY (bh_concept_id) REFERENCES bh_concept
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy
	ADD CONSTRAINT cbpartner_bhallergy
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy
	ADD CONSTRAINT severityconcept_bhallergy
		FOREIGN KEY (severity_concept_id) REFERENCES bh_concept
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy
	ADD CONSTRAINT bh_allergy_isactive_check
		CHECK (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

CREATE TABLE IF NOT EXISTS bh_allergy_reaction
(
	ad_client_id                numeric(10)                      NOT NULL,
	ad_org_id                   numeric(10)                      NOT NULL,
	bh_allergy_id               numeric(10)  DEFAULT NULL::numeric,
	bh_allergy_reaction_id      numeric(10)                      NOT NULL,
	bh_allergy_reaction_uu      varchar(36)  DEFAULT NULL::character varying,
	bh_concept_id               numeric(10)  DEFAULT NULL::numeric,
	bh_uncoded_allergy_reaction text,
	created                     timestamp    DEFAULT getdate()   NOT NULL,
	createdby                   numeric(10)                      NOT NULL,
	description                 varchar(255) DEFAULT NULL::character varying,
	isactive                    char         DEFAULT 'Y'::bpchar NOT NULL,
	updated                     timestamp    DEFAULT getdate()   NOT NULL,
	updatedby                   numeric(10)                      NOT NULL
);

ALTER TABLE bh_allergy_reaction
	OWNER TO adempiere;
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT bh_allergy_reaction_key
		PRIMARY KEY (bh_allergy_reaction_id);
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT bh_allergy_reaction_uu_idx
		UNIQUE (bh_allergy_reaction_uu);
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT adclient_bhallergyreaction
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT adorg_bhallergyreaction
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT bhallergy_bhallergyreaction
		FOREIGN KEY (bh_allergy_id) REFERENCES bh_allergy
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT bhconcept_bhallergyreaction
		FOREIGN KEY (bh_concept_id) REFERENCES bh_concept
			DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_allergy_reaction
	ADD CONSTRAINT bh_allergy_reaction_isactive_check
		CHECK (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

-- Add the AD_Elements
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
	 ), 0, 0, 'Y', '2025-03-14 14:05:24.399000', 100, '2025-03-14 14:05:36.650000', 100,
	 'BH_Have_Specified_No_Known_Allergies', 'U', 'Have Specified No Known Allergies',
	 'Have Specified No Known Allergies', NULL, NULL, NULL, NULL, NULL, NULL, '9b9af246-fb99-4a97-af4c-482ec0c65c5d',
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
	 ), 0, 0, 'Y', '2025-03-14 13:58:54.928000', 100, '2025-03-14 13:58:54.928000', 100, 'BH_Uncoded_Allergy_Reaction',
	 'U', 'Uncoded Allergy Reaction', 'Uncoded Allergy Reaction', NULL, NULL, NULL, NULL, NULL, NULL,
	 '81877ff1-e62d-470e-8d0d-6cf07f312828', NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.073000', 100, '2025-03-14 12:23:39.073000', 100, 'BH_Allergy_Reaction_UU', 'U',
	 'BH_Allergy_Reaction_UU', 'BH_Allergy_Reaction_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 'ee8c98f1-68be-45f3-82c0-d047d0ac7836', NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:38.996000', 100, '2025-03-14 12:23:38.996000', 100, 'BH_Allergy_Reaction_ID', 'U',
	 'Allergy Reaction', 'Allergy Reaction', NULL, NULL, NULL, NULL, NULL, NULL, 'c9da1988-e9d1-4afb-a41f-e79fc6444200',
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
	 ), 0, 0, 'Y', '2025-03-13 16:40:09.667000', 100, '2025-03-13 16:40:09.667000', 100, 'BH_Uncoded_Allergen', 'U',
	 'Uncoded Allergen', 'Uncoded Allergen', NULL, NULL, NULL, NULL, NULL, NULL, 'f889bdd5-f7ca-4eec-8fb5-4116c2668601',
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
	 ), 0, 0, 'Y', '2025-03-13 16:35:10.984000', 100, '2025-03-13 16:35:10.984000', 100, 'Severity_Concept_ID', 'U',
	 'Severity Concept ID', 'Severity Concept ID', NULL, NULL, NULL, NULL, NULL, NULL,
	 '328bcdbd-c652-47f4-b3f8-48bbc6dfc777', NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.570000', 100, '2025-03-13 16:33:25.570000', 100, 'BH_Allergy_UU', 'U',
	 'BH_Allergy_UU', 'BH_Allergy_UU', NULL, NULL, NULL, NULL, NULL, NULL, 'b025f74b-c770-4a4e-bb95-6b4f65f16d66', NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.517000', 100, '2025-03-13 16:33:25.517000', 100, 'BH_Allergy_ID', 'U', 'Allergy',
	 'Allergy', NULL, NULL, NULL, NULL, NULL, NULL, '3d5c455f-6f98-4333-9c6c-e46fdff4d675', NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 15:16:06.672000', 100, '2025-03-14 15:16:06.672000', 100, 'BH_Allergy_Note', 'U',
	 'Allergy Note', 'Allergy Note', NULL, NULL, NULL, NULL, NULL, NULL, '108581e9-88ca-4a6e-947d-67d34dcaae90', NULL);


-- Add the AD_Columns
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
	 ), 0, 0, 'Y', '2025-03-14 14:06:10.561000', '2025-03-14 14:06:10.561000', 100, 100,
	 'Have Specified No Known Allergies', NULL, NULL, 0, 'U', 'BH_Have_Specified_No_Known_Allergies', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c1c8f57c-abfc-40da-aadd-7ee6c9c75ade'
	 ), 20, NULL, NULL, 1, 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9b9af246-fb99-4a97-af4c-482ec0c65c5d'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e90fce95-d4aa-4282-aeba-31736bcef03f', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 13:59:11.709000', '2025-03-14 13:59:11.709000', 100, 100, 'Uncoded Allergy Reaction', NULL,
	 NULL, 0, 'U', 'BH_Uncoded_Allergy_Reaction', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '81877ff1-e62d-470e-8d0d-6cf07f312828'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f16db6ca-06a3-4f47-966f-c6fe2756d9e5', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 13:42:42.778000', '2025-03-14 13:59:16.788000', 100, 100, 'Concept', NULL, NULL, 0, 'U',
	 'BH_Concept_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f5d356cd-fdb8-4fdd-aea5-2e11726c0141'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1e498c86-2b10-4fca-839b-9d63a9f2fa34', 'Y', 0, 'N', 'N', NULL,
	 'BHConcept_BHAllergyReaction', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 13:37:28.093000', '2025-03-14 13:59:16.760000', 100, 100, 'Allergy', NULL, NULL, 0, 'U',
	 'BH_Allergy_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3d5c455f-6f98-4333-9c6c-e46fdff4d675'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '727bcc19-141d-4654-a1d3-8f01e9de417c', 'Y', 0, 'N', 'N', NULL,
	 'BHAllergy_BHAllergyReaction', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.447000', '2025-03-14 12:23:39.447000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'faf2fe6a-dd27-4ff0-834c-fa5a04c42897', 'N', NULL, 'N', 'N', NULL, NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.402000', '2025-03-14 12:23:39.402000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6e21aa47-2128-4963-84e3-174602fd8bb0', 'N', NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.298000', '2025-03-14 12:23:39.298000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3dc55a23-1b37-4d5e-a068-6b23f9ae5355', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.257000', '2025-03-14 12:23:39.257000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 275, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8646d37b-806f-4c7a-8c33-a7ef5db486ea', 'Y', 10, 'N', 'N', NULL, NULL,
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.157000', '2025-03-14 12:23:39.157000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c84519cd-ec4c-4f9b-943e-e197324ed5c2', 'N', NULL, 'N', 'N', NULL, NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.103000', '2025-03-14 12:23:39.103000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c9f9974a-8d2c-49e6-ae20-dfc7ac8176c0', 'N', NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:39.035000', '2025-03-14 12:23:39.035000', 100, 100, 'BH_Allergy_Reaction_UU', NULL,
	 NULL, 1, 'U', 'BH_Allergy_Reaction_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ee8c98f1-68be-45f3-82c0-d047d0ac7836'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a79bd753-57a3-4e1e-8dd9-9bc828fc6021', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:38.963000', '2025-03-14 12:23:38.963000', 100, 100, 'Allergy Reaction', NULL, NULL,
	 1, 'U', 'BH_Allergy_Reaction_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'c9da1988-e9d1-4afb-a41f-e79fc6444200'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '033c3bc2-8edd-4562-a539-ac46648060af', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:38.921000', '2025-03-14 13:59:16.732000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '63f8cb24-2de3-4220-9813-8d7645dbfaf4', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHAllergyReaction', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 12:23:38.850000', '2025-03-14 13:59:16.717000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '9358c5ff-0b55-44bb-9517-886ece2a9563'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a570f70c-8adf-493d-af41-82a3fe1672ea', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHAllergyReaction', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:40:49.521000', '2025-03-13 16:40:49.521000', 100, 100, 'Uncoded Allergen', NULL, NULL,
	 0, 'U', 'BH_Uncoded_Allergen', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f889bdd5-f7ca-4eec-8fb5-4116c2668601'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '496b1eb7-2e7b-4bf6-8aef-e29c0d9c38f9', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-13 16:39:14.415000', '2025-03-14 12:20:57.997000', 100, 100, 'Concept', NULL, NULL, 0, 'U',
	 'BH_Concept_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'f5d356cd-fdb8-4fdd-aea5-2e11726c0141'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '04e1939f-7384-46a7-a03c-9bdab9e00df0', 'Y', 0, 'N', 'N', NULL,
	 'BHConcept_BHAllergy', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:38:20.705000', '2025-03-14 12:20:58.098000', 100, 100, 'Severity Concept ID', NULL,
	 NULL, 0, 'U', 'Severity_Concept_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 30, 1000051, NULL, 10, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '328bcdbd-c652-47f4-b3f8-48bbc6dfc777'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '19554deb-76f1-41d1-b271-f4155e56a69a', 'Y', 0, 'N', 'N', NULL,
	 'SeverityConcept_BHAllergy', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:34:30.378000', '2025-03-14 12:20:58.022000', 100, 100, 'Business Partner',
	 'Identifies a Business Partner',
	 'A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson',
	 0, 'U', 'C_BPartner_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 30, NULL, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 187, NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '3f5492f3-0e05-422e-937a-2e2c7b1a8c1e', 'Y', 0, 'N', 'N', NULL,
	 'CBPartner_BHAllergy', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.778000', '2025-03-13 16:33:25.778000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4351f4d2-7d3b-487f-a099-df78d1c571fc', 'N', NULL, 'N', 'N', NULL, NULL,
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.744000', '2025-03-13 16:33:25.744000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6ad7bb3a-a85c-43b6-82ce-467ad712b5a2', 'N', NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.685000', '2025-03-13 16:33:25.685000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ccba45e7-ea8b-4227-8c6c-1a8d1da6169d', 'N', NULL, 'N', 'N', NULL, NULL,
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.657000', '2025-03-13 16:33:25.657000', 100, 100, 'Description',
	 'Optional short description of the record', 'A description is limited to 255 characters.', 1, 'U', 'Description', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 10, NULL, NULL, 255, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'Y', 275, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'f42f7df1-2d69-4117-804e-7f49893bdba5', 'Y', 10, 'N', 'N', NULL, NULL,
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
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.627000', '2025-03-13 16:33:25.627000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ebc841b6-42dd-40ca-9047-298a343bb905', 'N', NULL, 'N', 'N', NULL, NULL,
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.598000', '2025-03-13 16:33:25.598000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '7f9d6743-0b9e-45ac-84ac-dfb2ba0aa248', 'N', NULL, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.559000', '2025-03-13 16:33:25.559000', 100, 100, 'BH_Allergy_UU', NULL, NULL, 1,
	 'U', 'BH_Allergy_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'b025f74b-c770-4a4e-bb95-6b4f65f16d66'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '15fd68b4-4405-4f39-80ac-a6eb4e36ecfc', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.495000', '2025-03-13 16:33:25.495000', 100, 100, 'Allergy', NULL, NULL, 1, 'U',
	 'BH_Allergy_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '3d5c455f-6f98-4333-9c6c-e46fdff4d675'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ec94f9e9-2fef-454f-9467-146c702967d8', 'N', NULL, 'N', 'N',
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.457000', '2025-03-14 12:20:57.961000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ae522d1b-748c-4a25-b7d7-b7ce56d99b4c', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHAllergy', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-13 16:33:25.390000', '2025-03-14 12:20:57.926000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '50a09f2f-3d05-4980-bc35-fce313bf6d27', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHAllergy', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-14 15:16:27.389000', '2025-03-14 15:16:27.389000', 100, 100, 'Allergy Note', NULL, NULL, 0,
	 'U', 'BH_Allergy_Note', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '299e9a15-5ca1-49ff-93f5-b4ed315d2f52'
	 ), 14, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '108581e9-88ca-4a6e-947d-67d34dcaae90'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '02f67df7-9fc9-4e24-9be6-2e12db36f68e', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Update the GraphQL generator template
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = '''A_Asset'',''A_Asset_Acct'',''A_Asset_Addition'',''A_Asset_Change'',''A_Asset_Class'',''A_Asset_Delivery'',''A_Asset_Disposed'',''A_Asset_Group'',''A_Asset_Group_Acct'',''A_Asset_Info_Fin'',''A_Asset_Info_Ins'',''A_Asset_Info_Lic'',''A_Asset_Info_Oth'',''A_Asset_Info_Tax'',''A_Asset_Product'',''A_Asset_Retirement'',''A_Asset_Reval'',''A_Asset_Reval_Entry'',''A_Asset_Reval_Index'',''A_Asset_Split'',''A_Asset_Transfer'',''A_Asset_Type'',''A_Asset_Use'',''A_Depreciation'',''A_Depreciation_Build'',''A_Depreciation_Convention'',''A_Depreciation_Entry'',''A_Depreciation_Exp'',''A_Depreciation_Forecast'',''A_Depreciation_Method'',''A_Depreciation_Table_Detail'',''A_Depreciation_Table_Header'',''A_Depreciation_Workfile'',''A_FundingMode'',''A_FundingMode_Acct'',''A_Registration'',''A_RegistrationAttribute'',''A_RegistrationProduct'',''A_RegistrationValue'',''AD_AccessLog'',''AD_Alert'',''AD_AlertProcessor'',''AD_AlertProcessorLog'',''AD_AlertRecipient'',''AD_AlertRule'',''AD_AllClients_V'',''AD_AllUsers_V'',''AD_Archive'',''AD_Attachment'',''AD_AttachmentNote'',''AD_Attribute'',''AD_Attribute_Value'',''AD_AuthorizationAccount'',''AD_AuthorizationCredential'',''AD_AuthorizationProvider'',''AD_BroadcastMessage'',''AD_ChangeLog'',''AD_Chart'',''AD_ChartDatasource'',''AD_Client'',''AD_ClientInfo'',''AD_ClientShare'',''AD_Color'',''AD_Column'',''AD_Column_Access'',''AD_CtxHelp'',''AD_CtxHelpMsg'',''AD_CtxHelpSuggestion'',''AD_Desktop'',''AD_DesktopWorkbench'',''AD_Document_Action_Access'',''AD_Element'',''AD_EntityType'',''AD_Error'',''AD_Field'',''AD_FieldGroup'',''AD_FieldSuggestion'',''AD_Find'',''AD_Form'',''AD_Form_Access'',''AD_HouseKeeping'',''AD_Image'',''AD_ImpFormat'',''AD_ImpFormat_Row'',''AD_ImportTemplate'',''AD_ImportTemplateAccess'',''AD_IndexColumn'',''AD_InfoColumn'',''AD_InfoProcess'',''AD_InfoRelated'',''AD_InfoWindow'',''AD_InfoWindow_Access'',''AD_Issue'',''AD_LabelPrinter'',''AD_LabelPrinterFunction'',''AD_Language'',''AD_LdapAccess'',''AD_LdapProcessor'',''AD_LdapProcessorLog'',''AD_Menu'',''AD_Message'',''AD_MigrationScript'',''AD_ModelValidator'',''AD_Modification'',''AD_Note'',''AD_Org'',''AD_OrgInfo'',''AD_OrgType'',''AD_Package_Exp'',''AD_Package_Exp_Detail'',''AD_Package_Imp'',''AD_Package_Imp_Backup'',''AD_Package_Imp_Detail'',''AD_Package_Imp_Inst'',''AD_Package_Imp_Proc'',''AD_Package_UUID_Map'',''AD_Password_History'',''AD_PasswordRule'',''AD_PInstance'',''AD_PInstance_Log'',''AD_PInstance_Para'',''AD_PostIt'',''AD_Preference'',''AD_PrintColor'',''AD_PrintFont'',''AD_PrintForm'',''AD_PrintFormat'',''AD_PrintFormatItem'',''AD_PrintGraph'',''AD_PrintHeaderFooter'',''AD_PrintLabel'',''AD_PrintLabelLine'',''AD_PrintPaper'',''AD_PrintTableFormat'',''AD_Private_Access'',''AD_Process'',''AD_Process_Access'',''AD_Process_Para'',''AD_RecentItem'',''AD_Record_Access'',''AD_Ref_List'',''AD_Ref_Table'',''AD_Reference'',''AD_Registration'',''AD_RelationType'',''AD_Replication'',''AD_Replication_Log'',''AD_Replication_Run'',''AD_ReplicationDocument'',''AD_ReplicationStrategy'',''AD_ReplicationTable'',''AD_ReportView'',''AD_ReportView_Col'',''AD_ReportView_Column'',''AD_Role'',''AD_Role_Included'',''AD_Role_OrgAccess'',''AD_Rule'',''AD_Schedule'',''AD_Scheduler'',''AD_Scheduler_Para'',''AD_SchedulerLog'',''AD_SchedulerRecipient'',''AD_SearchDefinition'',''AD_Sequence'',''AD_Sequence_Audit'',''AD_Sequence_No'',''AD_Session'',''AD_StatusLine'',''AD_StatusLineUsedIn'',''AD_StorageProvider'',''AD_Style'',''AD_StyleLine'',''AD_SysConfig'',''AD_System'',''AD_Tab'',''AD_Tab_Customization'',''AD_Table'',''AD_Table_Access'',''AD_Table_ScriptValidator'',''AD_TableIndex'',''AD_Task'',''AD_Task_Access'',''AD_TaskInstance'',''AD_ToolBarButton'',''AD_ToolBarButtonRestrict'',''AD_Tree'',''AD_Tree_Favorite'',''AD_Tree_Favorite_Node'',''AD_TreeBar'',''AD_TreeNode'',''AD_TreeNodeBP'',''AD_TreeNodeCMC'',''AD_TreeNodeCMM'',''AD_TreeNodeCMS'',''AD_TreeNodeCMT'',''AD_TreeNodeMM'',''AD_TreeNodePR'',''AD_TreeNodeU1'',''AD_TreeNodeU2'',''AD_TreeNodeU3'',''AD_TreeNodeU4'',''AD_User'',''AD_User_OrgAccess'',''AD_User_Roles'',''AD_User_Substitute'',''AD_UserBPAccess'',''AD_UserDef_Field'',''AD_UserDef_Info'',''AD_UserDef_Info_Column'',''AD_UserDef_Info_Related'',''AD_UserDef_Proc'',''AD_UserDef_Proc_Parameter'',''AD_UserDef_Tab'',''AD_UserDef_Win'',''AD_UserMail'',''AD_UserPreference'',''AD_UserQuery'',''AD_Val_Rule'',''AD_ViewColumn'',''AD_ViewComponent'',''AD_WF_Activity'',''AD_WF_ActivityApprover'',''AD_WF_ActivityResult'',''AD_WF_Block'',''AD_WF_EventAudit'',''AD_WF_NextCondition'',''AD_WF_Node'',''AD_WF_Node_Para'',''AD_WF_NodeNext'',''AD_WF_Process'',''AD_WF_ProcessData'',''AD_WF_Responsible'',''AD_Window'',''AD_Window_Access'',''AD_WizardProcess'',''AD_Workbench'',''AD_WorkbenchWindow'',''AD_Workflow'',''AD_Workflow_Access'',''AD_WorkflowProcessor'',''AD_WorkflowProcessorLog'',''AD_ZoomCondition'',''ASP_ClientException'',''ASP_ClientLevel'',''ASP_Field'',''ASP_Form'',''ASP_Level'',''ASP_Module'',''ASP_Process'',''ASP_Process_Para'',''ASP_Ref_List'',''ASP_Tab'',''ASP_Task'',''ASP_Window'',''ASP_Workflow'',''B_Bid'',''B_BidComment'',''B_Buyer'',''B_BuyerFunds'',''B_Offer'',''B_Seller'',''B_SellerFunds'',''B_Topic'',''B_TopicCategory'',''B_TopicType'',''BH_Allergy'',''BH_Allergy_Reaction'',''BH_BP_General_Payer_Info'',''BH_BP_Payer_Info'',''BH_BP_Specific_Payer_Info'',''BH_ChargeDefault'',''BH_ChargeTypeDefault'',''BH_Client_Concept'',''BH_Concept'',''BH_Concept_Description'',''BH_Concept_Extra'',''BH_Concept_Mapping'',''BH_Concept_Name'',''BH_DbrdBtnGrp'',''BH_DbrdBtnGrp_Btn'',''BH_Default_DocAction_Access'',''BH_DefaultIncludedRole'',''BH_Encounter'',''BH_Encounter_Diagnosis'',''BH_Encounter_Diagnostic'',''BH_Encounter_Type_Window'',''BH_I_Product_Quantity'',''BH_Observation'',''BH_Ocl_Originating_Source'',''BH_Payer_Info_Fld'',''BH_Payer_Info_Fld_Sug'',''BH_Payer_Info_Fld_Val'',''BH_Payer_Info_Fld_Val_Sug'',''BH_PaymentRef'',''BH_PaymentRef_BankAcct'',''BH_Product_CategoryDefault'',''BH_Role_WarehouseAccess'',''BH_Stocktake_v'',''BH_TabNavBtn'',''BH_TabNavBtn_Tab'',''BH_UIButton'',''BH_Visit'',''BH_Voided_Reason'',''C_1099Box'',''C_AcctProcessor'',''C_AcctProcessorLog'',''C_AcctSchema'',''C_AcctSchema_Default'',''C_AcctSchema_Element'',''C_AcctSchema_GL'',''C_Activity'',''C_AddressTransaction'',''C_AddressValidation'',''C_AddressValidationCfg'',''C_AllocationHdr'',''C_AllocationLine'',''C_Bank'',''C_BankAccount'',''C_BankAccount_Acct'',''C_BankAccount_Processor'',''C_BankAccountDoc'',''C_BankStatement'',''C_BankStatementLine'',''C_BankStatementLoader'',''C_BankStatementMatcher'',''C_BankTransfer'',''C_BP_BankAccount'',''C_BP_Customer_Acct'',''C_BP_EDI'',''C_BP_Employee_Acct'',''C_BP_Group'',''C_BP_Group_Acct'',''C_BP_Relation'',''C_BP_ShippingAcct'',''C_BP_Vendor_Acct'',''C_BP_Withholding'',''C_BPartner'',''C_BPartner_Location'',''C_BPartner_Product'',''C_Calendar'',''C_Campaign'',''C_Cash'',''C_CashBook'',''C_CashBook_Acct'',''C_CashLine'',''C_CashPlan'',''C_CashPlanLine'',''C_Channel'',''C_Charge'',''C_Charge_Acct'',''C_ChargeType'',''C_ChargeType_DocType'',''C_City'',''C_Commission'',''C_CommissionAmt'',''C_CommissionDetail'',''C_CommissionLine'',''C_CommissionRun'',''C_ContactActivity'',''C_Conversion_Rate'',''C_ConversionType'',''C_Country'',''C_CountryGroup'',''C_CountryGroupCountry'',''C_Currency'',''C_Currency_Acct'',''C_Cycle'',''C_CyclePhase'',''C_CycleStep'',''C_DepositBatch'',''C_DepositBatchLine'',''C_DocType'',''C_DocTypeCounter'',''C_Dunning'',''C_DunningLevel'',''C_DunningRun'',''C_DunningRunEntry'',''C_DunningRunLine'',''C_Element'',''C_ElementValue'',''C_Greeting'',''C_InterOrg_Acct'',''C_Invoice'',''C_InvoiceBatch'',''C_InvoiceBatchLine'',''C_InvoiceLine'',''C_InvoicePaySchedule'',''C_InvoiceSchedule'',''C_InvoiceTax'',''C_Job'',''C_JobAssignment'',''C_JobCategory'',''C_JobRemuneration'',''C_LandedCost'',''C_LandedCostAllocation'',''C_Location'',''C_NonBusinessDay'',''C_OnlineTrxHistory'',''C_Opportunity'',''C_Order'',''C_OrderLandedCost'',''C_OrderLandedCostAllocation'',''C_OrderLine'',''C_OrderPaySchedule'',''C_OrderSource'',''C_OrderTax'',''C_OrgAssignment'',''C_Payment'',''C_PaymentAllocate'',''C_PaymentBatch'',''C_PaymentProcessor'',''C_PaymentTerm'',''C_PaymentTransaction'',''C_PaySchedule'',''C_PaySelection'',''C_PaySelectionCheck'',''C_PaySelectionLine'',''C_Period'',''C_PeriodControl'',''C_Phase'',''C_POS'',''C_POSKey'',''C_POSKeyLayout'',''C_POSPayment'',''C_POSTenderType'',''C_Project'',''C_Project_Acct'',''C_ProjectIssue'',''C_ProjectIssueMA'',''C_ProjectLine'',''C_ProjectPhase'',''C_ProjectTask'',''C_ProjectType'',''C_Recurring'',''C_Recurring_Run'',''C_RecurringGroup'',''C_Region'',''C_Remuneration'',''C_RevenueRecog_Service'',''C_RevenueRecognition'',''C_RevenueRecognition_Plan'',''C_RevenueRecognition_Run'',''C_RfQ'',''C_RfQ_Topic'',''C_RfQ_TopicSubscriber'',''C_RfQ_TopicSubscriberOnly'',''C_RfQLine'',''C_RfQLineQty'',''C_RfQResponse'',''C_RfQResponseLine'',''C_RfQResponseLineQty'',''C_SalesRegion'',''C_SalesStage'',''C_ServiceLevel'',''C_ServiceLevelLine'',''C_SubAcct'',''C_Subscription'',''C_Subscription_Delivery'',''C_SubscriptionType'',''C_Task'',''C_Tax'',''C_Tax_Acct'',''C_TaxBase'',''C_TaxCategory'',''C_TaxDeclaration'',''C_TaxDeclarationAcct'',''C_TaxDeclarationLine'',''C_TaxDefinition'',''C_TaxGroup'',''C_TaxPostal'',''C_TaxProvider'',''C_TaxProviderCfg'',''C_TaxType'',''C_UOM'',''C_UOM_Conversion'',''C_UserRemuneration'',''C_ValidCombination'',''C_Withholding'',''C_Withholding_Acct'',''C_Year'',''CM_Chat'',''CM_ChatEntry'',''CM_ChatType'',''CM_ChatTypeUpdate'',''CM_ChatUpdate'',''DD_NetworkDistribution'',''DD_NetworkDistributionLine'',''DD_Order'',''DD_OrderLine'',''EXP_Format'',''EXP_FormatLine'',''EXP_Processor'',''EXP_Processor_Type'',''EXP_ProcessorParameter'',''Fact_Acct'',''Fact_Acct_Summary'',''Fact_Reconciliation'',''GL_Budget'',''GL_BudgetControl'',''GL_Category'',''GL_Distribution'',''GL_DistributionLine'',''GL_Fund'',''GL_FundRestriction'',''GL_Journal'',''GL_JournalBatch'',''GL_JournalGenerator'',''GL_JournalGeneratorLine'',''GL_JournalGeneratorSource'',''GL_JournalLine'',''HR_Attribute'',''HR_Concept'',''HR_Concept_Acct'',''HR_Concept_Category'',''HR_Contract'',''HR_Department'',''HR_Employee'',''HR_Job'',''HR_List'',''HR_ListLine'',''HR_ListType'',''HR_ListVersion'',''HR_Movement'',''HR_Payroll'',''HR_PayrollConcept'',''HR_Period'',''HR_Process'',''HR_Year'',''I_Asset'',''I_BankStatement'',''I_BPartner'',''I_Conversion_Rate'',''I_ElementValue'',''I_FAJournal'',''I_FixedAsset'',''I_GLJournal'',''I_HR_Movement'',''I_InOutLineConfirm'',''I_Inventory'',''I_Invoice'',''I_Movement'',''I_Order'',''I_Payment'',''I_PriceList'',''I_Product'',''I_ProductPlanning'',''I_ReportLine'',''IMP_Processor'',''IMP_Processor_Type'',''IMP_ProcessorLog'',''IMP_ProcessorParameter'',''M_Attribute'',''M_AttributeInstance'',''M_AttributeSearch'',''M_AttributeSet'',''M_AttributeSetExclude'',''M_AttributeSetInstance'',''M_AttributeUse'',''M_AttributeValue'',''M_BOM'',''M_BOMAlternative'',''M_BOMProduct'',''M_BP_Price'',''M_ChangeNotice'',''M_ChangeRequest'',''M_CommodityShipment'',''M_Cost'',''M_CostDetail'',''M_CostElement'',''M_CostHistory'',''M_CostQueue'',''M_CostType'',''M_Demand'',''M_DemandDetail'',''M_DemandLine'',''M_DiscountSchema'',''M_DiscountSchemaBreak'',''M_DiscountSchemaLine'',''M_DistributionList'',''M_DistributionListLine'',''M_DistributionRun'',''M_DistributionRunLine'',''M_Forecast'',''M_ForecastLine'',''M_Freight'',''M_FreightCategory'',''M_InOut'',''M_InOutConfirm'',''M_InOutLine'',''M_InOutLineConfirm'',''M_InOutLineMA'',''M_Inventory'',''M_InventoryLine'',''M_InventoryLineMA'',''M_Locator'',''M_LocatorType'',''M_Lot'',''M_LotCtl'',''M_LotCtlExclude'',''M_MatchInv'',''M_MatchPO'',''M_Movement'',''M_MovementConfirm'',''M_MovementLine'',''M_MovementLineConfirm'',''M_MovementLineMA'',''M_OperationResource'',''M_Package'',''M_PackageLine'',''M_PackageMPS'',''M_PartType'',''M_PerpetualInv'',''M_PriceList'',''M_PriceList_Version'',''M_Product'',''M_Product_Acct'',''M_Product_Category'',''M_Product_Category_Acct'',''M_Product_PO'',''M_Product_QualityTest'',''M_ProductDownload'',''M_Production'',''M_ProductionLine'',''M_ProductionLineMA'',''M_ProductionPlan'',''M_ProductOperation'',''M_ProductPrice'',''M_ProductPriceVendorBreak'',''M_Promotion'',''M_PromotionDistribution'',''M_PromotionGroup'',''M_PromotionGroupLine'',''M_PromotionLine'',''M_PromotionPreCondition'',''M_PromotionReward'',''M_QualityTest'',''M_QualityTestResult'',''M_RelatedProduct'',''M_Replenish'',''M_Requisition'',''M_RequisitionLine'',''M_RMA'',''M_RMALine'',''M_RMATax'',''M_RMAType'',''M_SerNoCtl'',''M_SerNoCtlExclude'',''M_Shipper'',''M_ShipperCfg'',''M_ShipperLabels'',''M_ShipperLabelsCfg'',''M_ShipperPackaging'',''M_ShipperPackagingCfg'',''M_ShipperPickupTypes'',''M_ShipperPickupTypesCfg'',''M_ShippingProcessor'',''M_ShippingProcessorCfg'',''M_ShippingTransaction'',''M_ShippingTransactionLine'',''M_StorageOnHand'',''M_StorageReservation'',''M_Substitute'',''M_Transaction'',''M_TransactionAllocation'',''M_Warehouse'',''M_Warehouse_Acct'',''PA_Achievement'',''PA_Benchmark'',''PA_BenchmarkData'',''PA_ColorSchema'',''PA_DashboardContent'',''PA_DashboardContent_Access'',''PA_DashboardPreference'',''PA_DocumentStatus'',''PA_Goal'',''PA_GoalRestriction'',''PA_Hierarchy'',''PA_Measure'',''PA_MeasureCalc'',''PA_Ratio'',''PA_RatioElement'',''PA_Report'',''PA_ReportColumn'',''PA_ReportColumnSet'',''PA_ReportCube'',''PA_ReportLine'',''PA_ReportLineSet'',''PA_ReportSource'',''PA_SLA_Criteria'',''PA_SLA_Goal'',''PA_SLA_Measure'',''PP_Cost_Collector'',''PP_Cost_CollectorMA'',''PP_MRP'',''PP_Order'',''PP_Order_BOM'',''PP_Order_BOMLine'',''PP_Order_Cost'',''PP_Order_Node'',''PP_Order_Node_Asset'',''PP_Order_Node_Product'',''PP_Order_NodeNext'',''PP_Order_Workflow'',''PP_Product_BOM'',''PP_Product_BOMLine'',''PP_Product_Planning'',''PP_WF_Node_Asset'',''PP_WF_Node_Product'',''QM_Specification'',''QM_SpecificationLine'',''R_Category'',''R_CategoryUpdates'',''R_ContactInterest'',''R_Group'',''R_GroupUpdates'',''R_InterestArea'',''R_IssueKnown'',''R_IssueProject'',''R_IssueRecommendation'',''R_IssueStatus'',''R_IssueSystem'',''R_IssueUser'',''R_MailText'',''R_Request'',''R_RequestAction'',''R_RequestProcessor'',''R_RequestProcessor_Route'',''R_RequestProcessorLog'',''R_RequestType'',''R_RequestTypeUpdates'',''R_RequestUpdate'',''R_RequestUpdates'',''R_Resolution'',''R_StandardResponse'',''R_Status'',''R_StatusCategory'',''RV_BPartner'',''RV_WarehousePrice'',''S_ExpenseType'',''S_Resource'',''S_ResourceAssignment'',''S_ResourceType'',''S_ResourceUnAvailable'',''S_TimeExpense'',''S_TimeExpenseLine'',''S_TimeType'',''S_Training'',''S_Training_Class'',''T_1099Extract'',''T_Aging'',''T_BankRegister'',''T_BOM_Indented'',''T_BOMLine'',''T_CashFlow'',''T_DistributionRunDetail'',''T_InventoryValue'',''T_InvoiceGL'',''T_MRP_CRP'',''T_Reconciliation'',''T_Replenish'',''T_Report'',''T_ReportStatement'',''T_Transaction'',''Test'',''U_BlackListCheque'',''U_POSTerminal'',''U_RoleMenu'',''U_Web_Properties'',''U_WebMenu'',''WS_WebService'',''WS_WebService_Para'',''WS_WebServiceFieldInput'',''WS_WebServiceFieldOutput'',''WS_WebServiceMethod'',''WS_WebServiceType'',''WS_WebServiceTypeAccess'''
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03';

SELECT
	register_migration_script('202503141626_GO-2985.sql')
FROM
	dual;