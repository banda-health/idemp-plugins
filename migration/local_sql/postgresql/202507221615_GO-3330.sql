-- Add the billing history / manage debt window & tab
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
	 ), 0, 0, 'Y', '2025-07-22 16:03:52.396000', 100, '2025-07-22 16:03:52.396000', 100, 'Billing History / Manage Debt',
	 'A page to see all the balance information for a business partner and manage it', NULL, 'M', 'Y', 'U', 'N', NULL,
	 NULL, 'N', 0, 0, 'N', '02235082-ebb7-47d3-ba31-9654de1f32c1', NULL, NULL);

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
	 ), 0, 0, 'Y', '2025-07-22 16:04:06.849000', 100, '2025-07-22 16:04:06.849000', 100, 'Billing History / Manage Debt',
	 NULL, NULL, 291, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '02235082-ebb7-47d3-ba31-9654de1f32c1'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '2d04fe71-af4d-4ab4-a8ca-a68530802590', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL);

-- Grant access to the appropriate users for the new tab
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
		WHEN r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
		                      '09eb7fc8-9cc5-44b0-9d14-15258a066038', '98617c31-55ff-48f9-bd44-253ef323d960',
		                      'ee008abc-2c16-4230-b48c-b1f5577ea270', 'c54253cf-c86b-4aaa-b472-ed8880635c62',
		                      'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a') THEN 'Y'
		ELSE 'N' END,
	uuid_generate_v4(),
	CASE
		WHEN r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
		                      '09eb7fc8-9cc5-44b0-9d14-15258a066038', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
		                      'c54253cf-c86b-4aaa-b472-ed8880635c62', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a') THEN 'Y'
		ELSE 'N' END
FROM
	ad_window w
		JOIN ad_role r
			ON r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
			                    'ec17fee0-a53a-4dbb-b946-423ce14880eb', '09eb7fc8-9cc5-44b0-9d14-15258a066038',
			                    '98617c31-55ff-48f9-bd44-253ef323d960', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
			                    'c54253cf-c86b-4aaa-b472-ed8880635c62', 'a1618fd6-e1ab-4e41-a08d-854229cd5971',
			                    'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a', '097feff0-3aa6-41fe-bf76-936b03859846',
			                    '17ccea57-1131-4d51-83ca-1824182e4493'
		)
WHERE
	w.ad_window_uu = '02235082-ebb7-47d3-ba31-9654de1f32c1';

-- Ensure OTC-only role can't deactivate
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
	ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'
	);

SELECT
	register_migration_script('202507221615_GO-3330.sql')
FROM
	dual;
