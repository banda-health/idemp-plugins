-- Add tab so OTC access works for users
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
	 ), 0, 0, 'Y', '2022-12-02 20:07:20.664000', 100, '2022-12-02 20:07:20.664000', 100, 'Pharmacy Sales (OTC)', NULL,
	 NULL, 259, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '99e99517-f9fb-44b4-afc4-b61174359dfe', NULL, 'B', 0);

-- add otc to cashier/registration basic & advanced role, clinic user role, and lab/radiology
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'Y', 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	 ), 0, 0, 100, 100, 'Y', 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	 ), 0, 0, 100, 100, 'Y', 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	 ), 0, 0, 100, 100, 'Y', 'N');

-- make sure inventory/pharmacy can't deactivate on OTC
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
);

-- Make sure all existing admins can see the OTC window
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	w.ad_window_id,
	r.ad_role_id,
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
	ad_client c
		JOIN ad_role r
			ON c.ad_client_id = r.ad_client_id
		CROSS JOIN ad_window w
WHERE
	r.ismanual = 'N'
	AND r.name = c.name || ' Admin'
	AND w.ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	AND r.ad_role_id NOT IN (
	SELECT
		ad_role_id
	FROM
		ad_window_access wa
			JOIN ad_window w
				ON wa.ad_window_id = w.ad_window_id
	WHERE
		w.ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
);

SELECT
	register_migration_script('202212021409_GO-2509.sql')
FROM
	dual;
