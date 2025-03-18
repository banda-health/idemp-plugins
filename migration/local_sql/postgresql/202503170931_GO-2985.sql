-- Insert AD_Reference values for our new OCL list sources
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
	 ), 0, 0, 'Y', '2025-03-17 08:31:59.338016', 100, '2025-03-17 08:31:59.338016', 100, 'BHAllergies',
	 'BHAllergies - Allergies', 'An allergies list for patients', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', '42fb416a-4b53-469c-b9b5-419fae9b97d9', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-17 08:31:59.338016', 100, '2025-03-17 08:31:59.338016', 100, 'BHAllergyReactions',
	 'BHAllergyReactions - Allergy reaqctions', 'A list of possible reactions to an allergy', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', 'b9f21bfc-d7c9-4b07-a628-93086ce650a8', NULL, NULL);
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
	 ), 0, 0, 'Y', '2025-03-17 08:31:59.338016', 100, '2025-03-17 08:31:59.338016', 100, 'BHAllergySeverities',
	 'BHAllergySeverities - Allergy severities', 'The different severities a patient has to an allergy', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', '06b7f750-4a16-43e8-ab66-32e8496ed15e', NULL, NULL);


-- Add the allergies window
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
	 ), 0, 0, 'Y', '2025-03-17 09:39:15.465000', 100, '2025-03-17 09:39:15.465000', 100, 'Allergies', 'Allergies', NULL,
	 'T', 'N', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N', '45f693e1-d33a-43cf-81dc-1f75262f3bd0', NULL, NULL);

-- Add the allergies tab
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
	 ), 0, 0, 'Y', '2025-03-17 09:39:50.234000', 100, '2025-03-17 09:39:50.234000', 100, 'Allergies', NULL, NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '2dcec3ca-58e7-4f5e-86b9-90465b99a581'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '45f693e1-d33a-43cf-81dc-1f75262f3bd0'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '39911068-fd6c-4d48-a8cf-c6dee5b59b17', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);


-- Insert the menu under "Back End"
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
	 ), 0, 0, 'Y', '2025-03-17 09:41:56.477000', 100, '2025-03-17 09:41:56.477000', 'Allergies', 100, 'Allergies', 'N',
	 'Y', 'N', 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '45f693e1-d33a-43cf-81dc-1f75262f3bd0'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y', 'b2bc0064-0825-453f-b06a-7f23513f1f8f', NULL, 'fas fa-snake-staff', NULL);
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'b2bc0064-0825-453f-b06a-7f23513f1f8f'
	), 0, 0, 'Y', '2025-03-17 09:41:56.512017', 100, '2025-03-17 09:42:25.472000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'
	 ), 5, '9df5c175-2f53-4b9e-bf2a-039df1bbdb2a');


-- Add price list and allergies window access to all non-manual roles
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	146,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_role r
WHERE
	r.ismanual = 'N'
ON CONFLICT DO NOTHING;
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	w.ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_role r
		JOIN ad_window w
		ON w.ad_window_uu = '45f693e1-d33a-43cf-81dc-1f75262f3bd0'
WHERE
	r.ismanual = 'N';


-- Wrap up and be done
SELECT
	register_migration_script('202503170931_GO-2985.sql')
FROM
	dual;
