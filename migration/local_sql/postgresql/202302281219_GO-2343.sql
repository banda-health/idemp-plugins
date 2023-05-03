-- add header field
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
	 ), 0, 0, 'Y', '2023-02-28 12:44:14.402000', 100, '2023-02-28 12:44:14.402000', 100, 'BH_Header', 'U', 'Header',
	 'Header', 'Header information e.g address, phone number etc.', NULL, NULL, NULL, NULL, NULL,
	 '83f0823c-7bd4-4266-942f-8a1b8d9e3512', NULL)
ON CONFLICT DO NOTHING;

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
	 ), 0, 0, 'Y', '2023-02-28 12:44:50.480000', '2023-02-28 12:44:50.480000', 100, 100, 'Header',
	 'Header information e.g address, phone number etc.', NULL, 0, 'U', 'BH_Header', 228, 10, NULL, NULL, 100, NULL, 'N',
	 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '83f0823c-7bd4-4266-942f-8a1b8d9e3512'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'ac4122ed-781e-4e0b-b81f-cee1bf79f360', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

ALTER TABLE AD_OrgInfo
	ADD BH_Header VARCHAR(100) DEFAULT NULL;

-- add facility number field
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
	 ), 0, 0, 'Y', '2023-02-28 12:52:38.383000', 100, '2023-02-28 12:52:38.383000', 100, 'BH_FacilityNumber', 'U',
	 'Facility Number', 'Facility Number', 'Facility Number (MFL No.)', NULL, NULL, NULL, NULL, NULL,
	 '6c91979c-b06e-4c71-b046-adfccd927fc6', NULL)
ON CONFLICT DO NOTHING;

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
	 ), 0, 0, 'Y', '2023-02-28 12:54:06.189000', '2023-02-28 12:54:06.189000', 100, 100, 'Facility Number',
	 'Facility Number (MFL No.)', NULL, 0, 'U', 'BH_FacilityNumber', 228, 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y',
	 NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '6c91979c-b06e-4c71-b046-adfccd927fc6'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4bbea2b7-14a1-4e84-ac3a-c83cfb6f9296', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

ALTER TABLE AD_OrgInfo
	ADD BH_FacilityNumber VARCHAR(100) DEFAULT NULL;

-- add payment information
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
	 ), 0, 0, 'Y', '2023-02-28 12:59:47.692000', 100, '2023-02-28 12:59:47.692000', 100, 'BH_PaymentInformation', 'U',
	 'Payment Information', 'Payment Information', 'Payment Information', NULL, NULL, NULL, NULL, NULL,
	 '36095c07-0089-44cd-9b2f-85723c87db12', NULL)
ON CONFLICT DO NOTHING;

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
	 ), 0, 0, 'Y', '2023-02-28 13:00:59.254000', '2023-02-28 13:00:59.254000', 100, 100, 'Payment Information',
	 'Payment Information', NULL, 0, 'U', 'BH_PaymentInformation', 228, 10, NULL, NULL, 100, NULL, 'N', 'N', 'N', 'Y',
	 NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '36095c07-0089-44cd-9b2f-85723c87db12'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2059d3ad-3d63-4aef-a531-140d7bbe1567', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N')
ON CONFLICT DO NOTHING;

ALTER TABLE AD_OrgInfo
	ADD BH_PaymentInformation VARCHAR(100) DEFAULT NULL;

-- add global storage provider
INSERT INTO
	ad_storageprovider (ad_client_id, ad_org_id, ad_storageprovider_id, ad_storageprovider_uu, created, createdby, folder,
	                    isactive, method, name, password, updated, updatedby, url, username)
VALUES
	(0, 0, (
		SELECT COALESCE(MAX(ad_storageprovider_id) + 1, 1000000) FROM ad_storageprovider
	), '8b887c9c-d8ca-4b9c-a548-267b1e9c7c5c', '2023-03-10 14:54:49.201000', 100, '/opt/idempiere-server/logo-images',
	 'Y', 'FileSystem', 'LogoStorageProvider', NULL, '2023-03-10 14:54:49.201000', 100, NULL, NULL)
ON CONFLICT DO NOTHING;

-- org information window
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
	 ), 0, 0, 'Y', '2023-03-15 12:02:38.545000', 100, '2023-03-15 12:02:38.545000', 100, 'Facility Information',
	 'facility information details', NULL, 'M', 'Y', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N',
	 '66df8b28-5a44-40a0-b63e-d51695bdfc92', NULL)
ON CONFLICT DO NOTHING;

-- org information tab
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
	 ), 0, 0, 'Y', '2023-04-26 14:26:11.025000', 100, '2023-04-26 14:26:11.025000', 100, 'Facility Information',
	 NULL, NULL, 228, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '66df8b28-5a44-40a0-b63e-d51695bdfc92'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL,
	 'N', 'U', NULL, NULL, NULL, 'Y', 'N', NULL, '55a5371d-32f4-4fa3-9053-3e9d819ba9dc', NULL, 'B', 0)
ON CONFLICT DO NOTHING;

-- give clinic admin role access to facility information window.
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM AD_Window WHERE ad_window_uu = '66df8b28-5a44-40a0-b63e-d51695bdfc92'
	 ), (
		 SELECT ad_role_id FROM AD_Role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', '2023-03-15 12:28:04.564000', 100, '2023-03-15 12:28:04.564000', 100, 'Y',
	 '7df96f38-479b-457f-a401-b476a98bfae9', 'Y')
ON CONFLICT DO NOTHING;

-- Give all non-mandatory roles access to this window
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	r.ad_client_id,
	r.ad_org_id,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_window w
		JOIN ad_role r
			ON r.ismasterrole = 'N' AND r.ismanual = 'N'
WHERE
		ad_window_uu = '66df8b28-5a44-40a0-b63e-d51695bdfc92'
ON CONFLICT DO NOTHING;

-- facility information menu
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
	 ), 0, 0, 'Y', '2023-03-15 12:10:47.863000', 100, '2023-03-15 12:10:47.863000', 'Facility Information', 100,
	 'Facility information details', 'N', 'Y', 'N', 'W', (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '66df8b28-5a44-40a0-b63e-d51695bdfc92'
	 ), NULL, NULL, NULL, NULL, NULL, 'U', 'Y', '791c9ae3-7600-400c-ae92-676a5cbd9ca8', NULL, 'fas fa-hospital')
ON CONFLICT DO NOTHING;

-- add facility information menu to Greenlight -> Back-end tree
INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '791c9ae3-7600-400c-ae92-676a5cbd9ca8'
	), 0, 0, 'Y', '2023-03-15 12:10:47.924229', 100, '2023-03-15 12:12:42.844504', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'
	 ), 2, '58e80a91-030d-4679-9c9a-356cffd30a40')
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202302281219_GO-2343.sql')
FROM
	dual;
