-- Add new reference list
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
	 ), 0, 0, 'Y', '2025-03-28 16:42:36.649000', 100, '2025-03-28 16:42:36.649000', 100, 'BH Clinic Affiliation',
	 'The affiliation a clinic should use, such as on the MoH 706 report', NULL, 'L', NULL, 'U', 'N',
	 '265542a9-6002-4677-9433-dcf3867452c5', NULL, 'N');
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-03-28 16:44:06.162000', 100, '2025-03-28 16:44:06.162000', 100, 'P', 'Private', NULL, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '265542a9-6002-4677-9433-dcf3867452c5'
	 ), NULL, NULL, 'U', '4347cb29-65a9-4cf5-8e93-3bc147ea7b1f', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-03-28 16:44:12.806000', 100, '2025-03-28 16:44:12.806000', 100, 'N', 'NGO', NULL, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '265542a9-6002-4677-9433-dcf3867452c5'
	 ), NULL, NULL, 'U', 'b8b2a31d-61d8-4107-9fd1-99a365133614', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-03-28 16:43:41.146000', 100, '2025-03-28 16:44:16.587000', 100, 'G', 'GOK', NULL, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '265542a9-6002-4677-9433-dcf3867452c5'
	 ), NULL, NULL, 'U', 'fc1e774a-e51b-4999-a450-60aeadaddf22', NULL, NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-03-28 16:43:47.637000', 100, '2025-03-28 16:44:22.191000', 100, 'F', 'Faith Based', NULL, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '265542a9-6002-4677-9433-dcf3867452c5'
	 ), NULL, NULL, 'U', '57e24320-0a4d-4af1-a0e3-0f6cc6c06fa2', NULL, NULL);


-- Add new column to ad_orginfo
ALTER TABLE ad_orginfo
	ADD BH_Affiliation char DEFAULT NULL;
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
	 ), 0, 0, 'Y', '2025-03-28 16:48:01.960000', 100, '2025-03-28 16:48:01.960000', 100, 'BH_Affiliation', 'U',
	 'Affiliation', 'Affiliation', NULL, NULL, NULL, NULL, NULL, NULL, '89d919c0-c6c8-4d5e-82c0-72c3419f3835', NULL);
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
	 ), 0, 0, 'Y', '2025-03-28 16:49:31.530000', '2025-03-28 16:49:31.530000', 100, 100, 'Affiliation', NULL, NULL, 0,
	 'U', 'BH_Affiliation', 228, 17, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '265542a9-6002-4677-9433-dcf3867452c5'
	 ), NULL, 1, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '89d919c0-c6c8-4d5e-82c0-72c3419f3835'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '719eba37-89cc-4d9f-8af2-7e4455d938fc', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Add access to the MoH 706 report
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 'Y', '2025-03-28 16:54:06.257000', 100, '2025-03-28 16:54:28.711000', 100, 'Y',
	 'd59a0429-0274-497c-a4a3-ed434ead0fde');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	 ), 0, 0, 'Y', '2025-03-28 16:53:53.483000', 100, '2025-03-28 16:54:21.511000', 100, 'Y',
	 'c98d7a7b-f010-49e0-a5c1-e48370c276c5');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 'Y', '2025-03-28 16:53:48.125000', 100, '2025-03-28 16:54:31.479000', 100, 'Y',
	 'dd4d64bc-3888-4d29-a6c0-d19cf7e3ef94');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', '2025-03-28 16:53:39.040000', 100, '2025-03-28 16:54:18.632000', 100, 'Y',
	 '32d09eba-9504-412b-92f9-dbd45ffed29a');

-- Add the report to the GL menu
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
	 ), 0, 0, 'Y', '2025-03-28 16:59:25.303000', 100, '2025-03-28 16:59:25.303000', 'MoH706 Laboratory Test Summary', 100,
	 'The 706 report that sums up information regarding lab tests', 'N', 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), NULL, NULL, 'U', 'Y', '6d1bb758-7b13-4ea0-b16e-132f2442bb20', NULL, NULL, NULL);
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '6d1bb758-7b13-4ea0-b16e-132f2442bb20'
	), 0, 0, 'Y', '2025-03-28 16:59:25.347342', 100, '2025-03-28 16:59:25.347342', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
	 ), 22, 'f7f754fd-c25a-47c8-9964-7ca64a6916e0');

-- Register the script and be done
SELECT
	register_migration_script('202503281635_GO-2867.sql')
FROM
	dual;
