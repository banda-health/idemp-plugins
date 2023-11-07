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
			 MAX(AD_Field_ID) + 1
		 FROM
			 AD_Field
	 ), 0, 0, 'Y', '2023-11-06 11:56:05.874000', 100, '2023-11-06 11:56:05.874000', 100, 'Client',
	 'Client/Tenant for this installation.',
	 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.',
	 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = 'e2b742ba-5998-4cdf-93b4-cda8db96f11b'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '58e4d45d-bf24-4225-bf33-8f63d3a00f9b'
	 ), NULL, 'Y', NULL, 22, 'N', 10, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '42aa1bfb-7ff5-43e4-b58b-7ad157612fa5', NULL, NULL, 'N', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N');

-- create encounter type
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(AD_Ref_List_ID) + 1 FROM AD_Ref_List), 0, 0, 'Y', '2023-11-07 14:45:40.891000', 100, '2023-11-07 14:45:40.891000', 100, 'C', 'Chief Complaint', null, 1000048, null, null, 'U', 'e822496b-fc64-4db9-9b89-39c7ee6e9986', null, null);

INSERT INTO
	bh_encounter_type_window (ad_client_id, ad_org_id, ad_window_id, bh_encounter_type_window_uu, created, createdby,
	                          isactive, updated, updatedby, bh_encounter_type)
VALUES
	(0, 0, (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	), 'cc62f9eb-2d59-48da-839e-d093a3f2c0e3', '2023-11-06 11:17:57.302000', 100, 'Y',
	 '2023-11-06 11:17:57.302000', 100, 'C');

SELECT
	register_migration_script('202311061144_GO-2357.sql')
FROM
	dual;	 
