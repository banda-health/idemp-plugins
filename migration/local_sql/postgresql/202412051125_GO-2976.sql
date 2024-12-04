--- Alter table and add columns
ALTER TABLE bh_encounter_diagnostic
	ADD COLUMN bh_diagnostic_note TEXT DEFAULT NULL;
ALTER TABLE BH_Encounter_Diagnostic
	ADD COLUMN Selected_Panel_ID NUMERIC(10) DEFAULT NULL;
ALTER TABLE BH_Encounter_Diagnostic
	ADD COLUMN Group1 VARCHAR(36) DEFAULT NULL;

INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	              description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id,
	              showinactive)
VALUES
	((
		 SELECT
			 MAX(ad_reference_id) + 1
		 FROM
			 ad_reference
	 ), 0, 0, 'Y', '2024-12-03 11:48:11.087000', 100, '2024-12-03 11:48:11.087000', 100, 'BH_Concept',
	 'Concept Selection', NULL, 'T', NULL, 'U', 'N', '9f81c0d2-3af8-4a2e-b6d4-7b15852a3bbc', NULL, 'N');
INSERT INTO
	ad_ref_table (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_table_id,
	              ad_key, ad_display, isvaluedisplayed, whereclause, orderbyclause, entitytype, ad_window_id,
	              ad_ref_table_uu, ad_infowindow_id)
VALUES
	((
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '9f81c0d2-3af8-4a2e-b6d4-7b15852a3bbc'
	 ), 0, 0, 'Y', '2024-12-03 11:48:57.865000', 100, '2024-12-03 11:48:57.865000', 100, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2dcec3ca-58e7-4f5e-86b9-90465b99a581'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '970eea1a-beb4-4061-a629-6edbde8bbdd4'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'ccf382eb-6e26-40f5-9fcf-f4dc07318a7f'
	 ), 'N', NULL, NULL, 'U', NULL, 'a8a79bb6-2892-4947-9f47-6b621d461727', NULL);

INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(AD_Element_ID) + 1
		 FROM
			 AD_Element
	 ), 0, 0, 'Y', '2024-09-30 12:25:37.915', 100, '2024-09-30 12:25:37.915', 100, 'BH_Diagnostic_Note', 'U', 'Notes',
	 'Notes', 'Notes about the results', NULL, NULL, NULL, NULL, NULL, '64bfe9d3-5c98-4b89-b8bb-beefe2034de2', NULL);

INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition)
VALUES
	((
		 SELECT
			 MAX(AD_Column_ID) + 1
		 FROM
			 AD_Column
	 ), 0, 0, 'Y', '2024-09-30 12:27:59.771', '2024-09-30 12:27:59.771', 100, 100, 'Notes', 'Notes about the results',
	 NULL, 0, 'U', 'BH_Diagnostic_Note', (
		 SELECT
			 AD_Table_ID
		 FROM
			 AD_Table
		 WHERE
			 AD_Table_UU = 'b53c83d8-1eb6-4741-b98e-2a21f3341a37'
	 ), 36, NULL, NULL, 3000, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT
			 AD_Element_ID
		 FROM
			 AD_Element
		 WHERE
			 AD_Element_UU = '64bfe9d3-5c98-4b89-b8bb-beefe2034de2'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e6292f22-ea42-4eb5-a3e3-c2e6b0801baa', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL);

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
	 ), 0, 0, 'Y', '2024-12-03 11:34:37.315000', 100, '2024-12-03 11:34:37.315000', 100, 'Selected_Panel_ID', 'U',
	 'Selected Panel', 'Selected Panel', NULL, NULL, NULL, NULL, NULL, NULL, 'ee9c6db8-55ca-4b4c-a126-5b68b04dbefd',
	 NULL);
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
	 ), 0, 0, 'Y', '2024-12-03 11:37:05.597000', '2024-12-03 11:37:05.597000', 100, 100, 'Group1', NULL, NULL, 1, 'U',
	 'Group1', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b53c83d8-1eb6-4741-b98e-2a21f3341a37'
	 ), 10, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 52018, NULL,
	 'Y', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '339b4c0b-ba80-4841-97af-831fa3c8bbe5', 'N', NULL, 'N', 'N', NULL, NULL,
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
	 ), 0, 0, 'Y', '2024-12-03 11:35:02.748000', '2024-12-03 11:35:02.748000', 100, 100, 'Selected Panel', NULL, NULL, 0,
	 'U', 'Selected_Panel_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'b53c83d8-1eb6-4741-b98e-2a21f3341a37'
	 ), 19, NULL, NULL, 10, NULL, 'N', 'N', 'N', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ee9c6db8-55ca-4b4c-a126-5b68b04dbefd'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0b00b3aa-3bab-40f4-b9a7-bfbaf6ea0977', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Update the existing diagnostics and always assume that a panel was picked
UPDATE bh_encounter_diagnostic ed
SET
	selected_panel_id = p.bh_concept_id
FROM
	bh_concept c
		JOIN bh_concept_mapping cm
		ON c.bh_concept_id = cm.to_bh_concept_id AND cm.bh_map_type = 'CONCEPT-SET'
		JOIN bh_concept p
		ON cm.from_bh_concept_id = p.bh_concept_id
WHERE
	ed.bh_concept_id = c.bh_concept_id;

-- Now assign groups to the concepts
DO
$$
	DECLARE
		_diagnostic_cursor CURSOR FOR SELECT
			                              bh_encounter_diagnostic_id,
			                              bh_encounter_id,
			                              bh_concept_id,
			                              selected_panel_id
		                              FROM
			                              bh_encounter_diagnostic
		                              ORDER BY
			                              bh_encounter_id, lineno;
		_diagnostic_row      record;
		_previous_row        record;
		_group1              uuid;
	BEGIN
		CREATE TEMP TABLE _current_panel_tests
		(
			bh_concept_id numeric
		);
		OPEN _diagnostic_cursor;

		-- Do initial step
		FETCH NEXT FROM _diagnostic_cursor INTO _diagnostic_row;
		_group1 = uuid_generate_v4();
		-- Set the group correctly
		UPDATE bh_encounter_diagnostic
		SET
			group1 = _group1
		WHERE
			bh_encounter_diagnostic_id = _diagnostic_row.bh_encounter_diagnostic_id;
		-- Add the current test to the list
		INSERT INTO _current_panel_tests (bh_concept_id) VALUES (_diagnostic_row.bh_concept_id);

		_previous_row = _diagnostic_row;

		-- Loop through each row
		LOOP
			-- Get the next row (which may be the first
			FETCH NEXT FROM _diagnostic_cursor INTO _diagnostic_row;
			EXIT WHEN NOT FOUND;

			-- If there is no previous row or the encounter/panel are different, or the test already exists in the
			-- current test list, get a new group
			IF _previous_row.bh_encounter_id != _diagnostic_row.bh_encounter_id OR
			   _previous_row.selected_panel_id != _diagnostic_row.selected_panel_id OR EXISTS(
					SELECT 1 FROM _current_panel_tests WHERE bh_concept_id = _diagnostic_row.bh_concept_id
				) THEN
				-- Remove the current tests
				TRUNCATE _current_panel_tests;
				-- Generate the new group number
				_group1 = uuid_generate_v4();
			END IF;

			-- Set the group correctly
			UPDATE bh_encounter_diagnostic
			SET
				group1 = _group1
			WHERE
				bh_encounter_diagnostic_id = _diagnostic_row.bh_encounter_diagnostic_id;
			-- Add the current test to the list
			INSERT INTO _current_panel_tests (bh_concept_id) VALUES (_diagnostic_row.bh_concept_id);

			_previous_row = _diagnostic_row;

		END LOOP;

		CLOSE _diagnostic_cursor;
		DROP TABLE _current_panel_tests;
	END
$$;

SELECT
	update_sequences();

SELECT
	register_migration_script('202412051125_GO-2976.sql')
FROM
	dual;
