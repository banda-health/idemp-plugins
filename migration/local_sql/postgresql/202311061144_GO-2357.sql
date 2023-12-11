-- create chief complaint window
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
	 ), 0, 0, 'Y', '2023-11-06 11:52:38.934000', 100, '2023-11-06 11:52:38.934000', 100,
	 'Chief Complaint', NULL, NULL, 'M', 'N', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N',
	 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed', NULL);

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
	 ), 0, 0, 'Y', '2023-11-06 11:54:47.848000', 100, '2023-11-06 11:54:47.848000', 100,
	 'Chief Complaint', NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2c9b934-ef14-483f-ac29-6a68611b0552'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, 'e2b742ba-5998-4cdf-93b4-cda8db96f11b', NULL, 'B', 0);

-- Move the chief complaint field from the Vitals Details tab to this new Chief Complaint tab
UPDATE ad_field
SET
	ad_tab_id = (
		SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'e2b742ba-5998-4cdf-93b4-cda8db96f11b'
	)
WHERE
	ad_field_uu = 'e1d01fe4-16b6-4125-a385-34cf4531c06f';

-- create encounter type
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
	 ), 0, 0, 'Y', '2023-11-07 14:45:40.891000', 100, '2023-11-07 14:45:40.891000', 100, 'C', 'Chief Complaint', NULL,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ced05cde-f4e6-4d72-9134-c16e27eb963f'
	 ), NULL, NULL, 'U', 'e822496b-fc64-4db9-9b89-39c7ee6e9986', NULL, NULL);

INSERT INTO
	bh_encounter_type_window (ad_client_id, ad_org_id, ad_window_id, bh_encounter_type_window_uu, created, createdby,
	                          isactive, updated, updatedby, bh_encounter_type)
VALUES
	(0, 0, (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	), 'cc62f9eb-2d59-48da-839e-d093a3f2c0e3', '2023-11-06 11:17:57.302000', 100, 'Y',
	 '2023-11-06 11:17:57.302000', 100, 'C');

-- For all existing chief complaints, we need to create new encounters for them, then migrate the observations from
-- the old Vitals Details encounter
DROP TABLE IF EXISTS tmp_bh_encounter;
CREATE TABLE tmp_bh_encounter
(
	ad_client_id            numeric(10)             NOT NULL,
	ad_org_id               numeric(10)             NOT NULL,
	bh_encounter_id         serial                  NOT NULL,
	bh_encounter_type       varchar(22) DEFAULT 'C' NOT NULL,
	bh_encounter_uu         uuid        DEFAULT uuid_generate_v4(),
	bh_visit_id             numeric(10)             NOT NULL,
-- 	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby               numeric(10) DEFAULT 100 NOT NULL,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby               numeric(10) DEFAULT 100 NOT NULL,
	tmp_old_bh_encounter_id numeric(10)             NOT NULL
);

SELECT
	SETVAL(
		'tmp_bh_encounter_bh_encounter_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'BH_Encounter'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_visit_id, tmp_old_bh_encounter_id)
SELECT
	ad_client_id,
	ad_org_id,
	bh_visit_id,
	bh_encounter_id
FROM
	bh_encounter
WHERE
	bh_encounter_id IN (
		SELECT
			bh_encounter_id
		FROM
			bh_observation
		WHERE
			ad_field_id = (
				SELECT ad_field_id FROM ad_field WHERE ad_field_uu = 'e1d01fe4-16b6-4125-a385-34cf4531c06f'
			)
	);

-- Now insert the real values
INSERT INTO
	bh_encounter (ad_client_id, ad_org_id, bh_encounter_id, bh_encounter_type, bh_encounter_uu, bh_visit_id, createdby,
	              updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	bh_encounter_id,
	bh_encounter_type,
	bh_encounter_uu,
	bh_visit_id,
	createdby,
	updatedby
FROM
	tmp_bh_encounter;

-- Map the chief complaint observations to point to the new encounter
UPDATE bh_observation o
SET
	bh_encounter_id = te.bh_encounter_id
FROM
	tmp_bh_encounter te
WHERE
	o.bh_encounter_id = te.tmp_old_bh_encounter_id;

-- Delete any Vitals encounters that don't have any observations
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	bh_encounter e_d
	USING bh_encounter e
		LEFT JOIN (
			SELECT DISTINCT bh_encounter_id
			FROM bh_observation
		) o ON e.bh_encounter_id = o.bh_encounter_id
WHERE
	o.bh_encounter_id IS NULL
	AND e.bh_encounter_type = 'V'
	AND e_d.bh_encounter_id = e.bh_encounter_id;
	$$, 'bh_encounter_id');

-- Add the new fields
-- Add MUAC element
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
	 ), 0, 0, 'Y', '2023-11-23 08:13:15.665000', 100, '2023-11-23 08:13:15.665000', 100, 'BH_MUAC', 'U',
	 'Mid-Upper Arm Circumference (mm)', 'MUAC', NULL, NULL, NULL, NULL, NULL, NULL,
	 '89db51ee-d555-4d76-b73f-85bb1cd4c483', NULL);
-- Add BMI element
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
	 ), 0, 0, 'Y', '2023-11-23 08:13:55.275000', 100, '2023-11-23 08:13:55.275000', 100, 'BH_BMI', 'U', 'BMI (kg/m²)',
	 'BMI', NULL, NULL, NULL, NULL, NULL, NULL, 'd8826d20-904b-496c-88c6-850c35237365', NULL);
-- Add LMP element
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
	 ), 0, 0, 'Y', '2023-11-23 08:14:30.583000', 100, '2023-11-23 08:14:51.403000', 100, 'BH_LMP', 'U',
	 'Beginning of Last Menstrual Period', 'LMP', NULL, NULL, NULL, NULL, NULL, NULL,
	 '09060de4-6abf-49d8-a9de-8ab965687a09', NULL);

-- Now add the columns from these elements
-- Add MUAC column
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
	 ), 0, 0, 'Y', '2023-11-23 08:18:25.117000', '2023-11-23 08:18:25.117000', 100, 100,
	 'Mid-Upper Arm Circumference (mm)', NULL, NULL, 0, 'U', 'BH_MUAC', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f472818e-6071-4dcf-b705-4020ad79c154'
	 ), 11, NULL, NULL, 14, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '89db51ee-d555-4d76-b73f-85bb1cd4c483'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '755a4ec9-be8a-4b99-9fca-15836402eca1', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');
-- Add BMI column
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
	 ), 0, 0, 'Y', '2023-11-23 08:26:24.728000', '2023-11-23 08:26:24.728000', 100, 100, 'BMI (kg/m²)', NULL, NULL, 0,
	 'U', 'BH_BMI', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f472818e-6071-4dcf-b705-4020ad79c154'
	 ), 12, NULL, NULL, 14, '@BH_Height@*100*100/@BH_Weight@/@BH_Weight@', 'N', 'N', 'N', 'Y', '1=1', 'N', 0, 'N', 'N',
	 NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd8826d20-904b-496c-88c6-850c35237365'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', '0.00', '850c652d-3cdb-46fa-b40d-f30321dcc35b', 'Y', 0, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N');
-- Add LMP column
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
	 ), 0, 0, 'Y', '2023-11-23 08:27:38.256000', '2023-11-23 08:27:38.256000', 100, 100,
	 'Beginning of Last Menstrual Period', NULL, NULL, 0, 'U', 'BH_LMP', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'f472818e-6071-4dcf-b705-4020ad79c154'
	 ), 15, NULL, NULL, 7, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '09060de4-6abf-49d8-a9de-8ab965687a09'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5fce9cec-8119-4aba-aa00-98618feb2369', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');

-- Update the new tab and the existing observation tabs to point to the encounter table
UPDATE ad_tab
SET
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	)
WHERE
	ad_tab_uu IN ('69b0d4b6-a323-4224-924e-d9d3d2aa5e1b', '789a08af-2015-4469-b2ef-d4ca55e6f2e7',
	              'e2b742ba-5998-4cdf-93b4-cda8db96f11b');
-- Add the three new fields
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
	 ), 0, 0, 'Y', '2023-11-23 12:41:12.503000', 100, '2023-11-23 12:41:12.503000', 100,
	 'Beginning of Last Menstrual Period', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '5fce9cec-8119-4aba-aa00-98618feb2369'
	 ), NULL, 'Y', NULL, 0, 'N', 110, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'da211453-46c6-44a6-8ee2-ded8f8630b23', NULL, 110, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-11-23 12:40:48.980000', 100, '2023-11-23 12:40:48.980000', 100, 'BMI (kg/m²)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '850c652d-3cdb-46fa-b40d-f30321dcc35b'
	 ), NULL, 'Y', NULL, 0, 'N', 25, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '70b5bfa1-9c75-4fea-bf7e-076f4f4163fb', NULL, 25, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
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
			 MAX(ad_field_id) + 1
		 FROM
			 ad_field
	 ), 0, 0, 'Y', '2023-11-23 12:40:22.002000', 100, '2023-11-23 12:40:22.002000', 100,
	 'Mid-Upper Arm Circumference (mm)', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '789a08af-2015-4469-b2ef-d4ca55e6f2e7'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '755a4ec9-be8a-4b99-9fca-15836402eca1'
	 ), NULL, 'Y', NULL, 0, 'N', 90, 0, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '5f1f6878-9012-4cc1-9581-6847b3a6896e', NULL, 90, 'Y', 1, 1, 1, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');

-- Insert the abbrevation column stuff
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
	 ), 0, 0, 'Y', '2023-11-30 09:15:21.674000', 100, '2023-11-30 09:15:21.674000', 100, 'BH_Abbreviation', 'U',
	 'BH_Abbreviation', 'Abbreviation', 'An abbreviation for a given name', NULL, NULL, NULL, NULL, NULL,
	 'fcec81de-d989-45be-a06c-29a8c3d6b8a1', NULL);

ALTER TABLE AD_Field
	ADD BH_Abbreviation VARCHAR(60) DEFAULT NULL;
ALTER TABLE ad_field_trl
	ADD BH_Abbreviation VARCHAR(60) DEFAULT NULL;
ALTER TABLE ad_fieldgroup
	ADD BH_Abbreviation VARCHAR(60) DEFAULT NULL;
ALTER TABLE ad_fieldgroup_trl
	ADD BH_Abbreviation VARCHAR(60) DEFAULT NULL;

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
	 ), 0, 0, 'Y', '2023-11-30 09:18:17.085000', '2023-11-30 09:18:17.085000', 100, 100, 'BH_Abbreviation',
	 'An abbreviation for a given name', NULL, 0, 'U', 'BH_Abbreviation', 107, 10, NULL, NULL, 60, NULL, 'N', 'N', 'N',
	 'Y', NULL, 'N', 0, 'Y', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fcec81de-d989-45be-a06c-29a8c3d6b8a1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '20ecfa74-5b79-4eaa-9070-7a8280829dda', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2023-11-30 09:21:39.535000', '2023-11-30 09:21:39.535000', 100, 100, 'BH_Abbreviation',
	 'An abbreviation for a given name', NULL, 0, 'U', 'BH_Abbreviation', 414, 10, NULL, NULL, 60, NULL, 'N', 'N', 'N',
	 'Y', NULL, 'N', 0, 'Y', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fcec81de-d989-45be-a06c-29a8c3d6b8a1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '207239f2-1633-43d0-ab44-d5fceff9a9a9', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2023-11-30 09:19:46.654000', '2023-11-30 09:21:22.596000', 100, 100, 'BH_Abbreviation',
	 'An abbreviation for a given name', NULL, 0, 'U', 'BH_Abbreviation', 127, 10, NULL, NULL, 60, NULL, 'N', 'N', 'N',
	 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fcec81de-d989-45be-a06c-29a8c3d6b8a1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5a9efc24-5699-4e32-b2fa-a1e23f2d73a7', 'Y', 0, 'N', 'N', NULL,
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
	 ), 0, 0, 'Y', '2023-11-30 09:22:32.860000', '2023-11-30 09:22:32.860000', 100, 100, 'BH_Abbreviation',
	 'An abbreviation for a given name', NULL, 0, 'U', 'BH_Abbreviation', 415, 10, NULL, NULL, 60, NULL, 'N', 'N', 'N',
	 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'fcec81de-d989-45be-a06c-29a8c3d6b8a1'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2d572149-1e58-4ec3-a038-bd53565de215', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N');

-- Update the abbreviations for the fields and field groups
-- Beginning of Last Menstrual Period
UPDATE ad_field
SET
	bh_abbreviation = 'LMP'
WHERE
	ad_field_uu = 'da211453-46c6-44a6-8ee2-ded8f8630b23';
-- BMI (kg/m²)
UPDATE ad_field
SET
	bh_abbreviation = 'BMI'
WHERE
	ad_field_uu = '70b5bfa1-9c75-4fea-bf7e-076f4f4163fb';
-- Height (cm)
UPDATE ad_field
SET
	bh_abbreviation = 'Height'
WHERE
	ad_field_uu = '2842fb94-b841-4973-903e-89c7f24455b2';
-- Mid-Upper Arm Circumference (mm)
UPDATE ad_field
SET
	bh_abbreviation = 'MUAC'
WHERE
	ad_field_uu = '5f1f6878-9012-4cc1-9581-6847b3a6896e';
-- Pulse (BPM)
UPDATE ad_field
SET
	bh_abbreviation = 'Pulse'
WHERE
	ad_field_uu = 'c0f0f904-4977-4360-8065-a0e91d4f3a71';
-- Respiratory Rate (RPM)
UPDATE ad_field
SET
	bh_abbreviation = 'RR'
WHERE
	ad_field_uu = '87183dfb-1b7d-4c18-b350-593e576bb49b';
-- SPO² (%)
UPDATE ad_field
SET
	bh_abbreviation = 'SPO²'
WHERE
	ad_field_uu = '7bb73318-f6cc-4540-85d7-69672a18cc5f';
-- Temperature (°C)
UPDATE ad_field
SET
	bh_abbreviation = 'Temp'
WHERE
	ad_field_uu = 'd3dc091f-ee3d-4607-91d1-4e766cfe5528';
-- Weight (kg)
UPDATE ad_field
SET
	bh_abbreviation = 'Weight'
WHERE
	ad_field_uu = 'e0f68d60-0610-4caa-9dc3-b0143101ccd3';
-- Blood Pressure (mmHg)
UPDATE ad_fieldgroup
SET
	bh_abbreviation = 'BP'
WHERE
	ad_fieldgroup_uu = '5fa688fd-0075-494f-b880-d9c9ebca60d7';

-- Insert the correct access for the new Chief Complaint window
DROP TABLE IF EXISTS tmp_ad_window_access;
CREATE TEMP TABLE tmp_ad_window_access
(
	ad_window_id        numeric(10)             NOT NULL,
	ad_role_id          numeric(10)             NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
-- 	isactive            char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created             timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
-- 	updated             timestamp   DEFAULT NOW()       NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	isreadwrite         char        DEFAULT 'Y' NOT NULL,
	ad_window_access_uu uuid                    NOT NULL DEFAULT uuid_generate_v4(),
	bh_candeactivate    CHAR        DEFAULT 'N' NOT NULL
);

-- Update all automatic roles to have access to the Track Income window
INSERT INTO
	tmp_ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, bh_candeactivate)
SELECT
	(
		SELECT ad_window_id FROM AD_Window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	),
	ad_role_id,
	ad_client_id,
	ad_org_id,
	'Y'
FROM
	ad_role
WHERE
	ad_client_id != 0
	AND ismanual = 'N'
	AND ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			ad_window_access
		WHERE
			ad_window_id = (
				SELECT ad_window_id FROM AD_Window WHERE ad_window_uu = '44c02ddc-ef83-4020-8e4c-709d8cbeadc2'
			)
	);

-- Add the specific role stuff
INSERT INTO
	tmp_ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isreadwrite, bh_candeactivate)
SELECT
	(
		SELECT ad_window_id FROM AD_Window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	),
	r.ad_role_id,
	0,
	0,
	role_values.isreadwrite,
	role_values.bh_candeactivate
FROM
	ad_role r
		JOIN (
		VALUES
			('ec17fee0-a53a-4dbb-b946-423ce14880eb', 'N', 'N'), -- Inventory/Pharmacy
			('98617c31-55ff-48f9-bd44-253ef323d960', 'Y', 'N'), -- Clinician/Nurse Basic
			('097feff0-3aa6-41fe-bf76-936b03859846', 'Y', 'N'), -- Lab/Radiology
			('461b31c5-cae2-449d-8a0c-7385b12f4685', 'Y', 'Y'), -- Clinical Admin
			('e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', 'Y', 'Y'), -- Clinic User
			('ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'Y', 'N'), -- Triage
			('c54253cf-c86b-4aaa-b472-ed8880635c62', 'Y', 'N') -- Clinician/Nurse Advanced
	) role_values (ad_role_uu, isreadwrite, bh_candeactivate)
		ON r.ad_role_uu = role_values.ad_role_uu;

INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, ad_window_access_uu,
	                  isreadwrite, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	ad_window_access_uu,
	isreadwrite,
	bh_candeactivate
FROM
	tmp_ad_window_access;

-- Finally, add BMI observations for all encounters that also have height & weight observations
CREATE TEMP TABLE tmp_bh_observation
(
	ad_client_id      numeric(10)             NOT NULL,
	ad_field_id       numeric(10)             NOT NULL,
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

INSERT INTO
	tmp_bh_observation (ad_client_id, ad_field_id, ad_org_id, bh_encounter_id, bh_value)
SELECT
	height.ad_client_id,
	(
		SELECT ad_field_id FROM ad_field WHERE ad_field_uu = '70b5bfa1-9c75-4fea-bf7e-076f4f4163fb'
	),
	height.ad_org_id,
	height.bh_encounter_id,
	ROUND(
		weight.bh_value::numeric / height.bh_value::numeric / height.bh_value::numeric * 10000, 2)::varchar
FROM
	bh_observation height
		JOIN bh_observation weight
		ON height.bh_encounter_id = weight.bh_encounter_id AND weight.ad_field_id = (
		SELECT ad_field_id FROM ad_field WHERE ad_field_uu = 'e0f68d60-0610-4caa-9dc3-b0143101ccd3'
	)
WHERE
	height.ad_field_id = (
		SELECT ad_field_id FROM ad_field WHERE ad_field_uu = '2842fb94-b841-4973-903e-89c7f24455b2'
	)
	AND isnumeric(weight.bh_value)
	AND isnumeric(height.bh_value);

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

SELECT
	update_sequences();

SELECT
	register_migration_script('202311061144_GO-2357.sql')
FROM
	dual;
