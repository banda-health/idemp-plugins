-- Create the new supplier payments window
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
	 ), 0, 0, 'Y', '2025-08-04 10:22:58.184000', 100, '2025-08-04 10:23:55.063000', 100, 'Supplier Payments',
	 'This is meant for giving access to those people who can pay suppliers', NULL, 'T', 'Y', 'U', 'N', NULL, NULL, 'N',
	 0, 0, 'N', 'be24b4d5-987f-4aa5-ae14-38375b0d6bf2', NULL, NULL);

-- Create the tab
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
	 ), 0, 0, 'Y', '2025-08-04 10:25:15.836000', 100, '2025-08-04 10:25:15.836000', 100, 'Supplier Payments', NULL, NULL,
	 335, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'be24b4d5-987f-4aa5-ae14-38375b0d6bf2'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '6b3d9ce8-d4c8-4f41-8bd8-ab30c14ef69a', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);

-- Assign window access
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	ad_window_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	CASE
		WHEN ad_role_uu IN ('c54253cf-c86b-4aaa-b472-ed8880635c62', '097feff0-3aa6-41fe-bf76-936b03859846',
		                    '17ccea57-1131-4d51-83ca-1824182e4493') THEN 'N'
		ELSE 'Y' END,
	uuid_generate_v4(),
	CASE
		WHEN ad_role_uu IN ('c54253cf-c86b-4aaa-b472-ed8880635c62', '097feff0-3aa6-41fe-bf76-936b03859846',
		                    '17ccea57-1131-4d51-83ca-1824182e4493') THEN 'N'
		ELSE 'Y' END
FROM
	ad_role r
		JOIN ad_window
			ON ad_window_uu = 'be24b4d5-987f-4aa5-ae14-38375b0d6bf2'
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
	                 '09eb7fc8-9cc5-44b0-9d14-15258a066038', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a',
	                 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', '461b31c5-cae2-449d-8a0c-7385b12f4685',
	                 'c54253cf-c86b-4aaa-b472-ed8880635c62', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
	                 '097feff0-3aa6-41fe-bf76-936b03859846', '17ccea57-1131-4d51-83ca-1824182e4493');

-- Register the script
SELECT
	register_migration_script('202508041015_GO-984.sql')
FROM
	dual;
