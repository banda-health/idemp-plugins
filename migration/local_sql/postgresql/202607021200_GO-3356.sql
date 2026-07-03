-- Issue: GO-3356 - Family Planning visit tab window and role access (role matrix row: family planning)
-- Legend: 0=none · 1=read · 2=edit · 3=deactivate · 4=delete/void (client: 3/4 both allow deactivate)

INSERT INTO
	ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	           help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth,
	           isbetafunctionality, ad_window_uu, titlelogic, predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_window_id) + 1
		 FROM ad_window
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Family Planning', 'family planning visit tab',
	 NULL, 'M', 'Y', 'U', 'N', NULL, NULL, 'N', 0, 0, 'N', '2dd179a5-5886-4971-99c0-f7b6f75d0ac3', NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help,
	        ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly, ad_column_id,
	        hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields,
	        ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id, readonlylogic,
	        displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id, treedisplayedon,
	        maxqueryrecords, islookuponlyselection, isallowadvancedlookup, ad_tabtype, ishighvolume, deleteconfirmationlogic)
VALUES
	((
		 SELECT MAX(ad_tab_id) + 1
		 FROM ad_tab
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Family Planning', 'Family Planning', NULL, (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'e0c55a83-6d79-4efe-837d-f16b69d43f9c'
	 ), (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), 10, 0, 'Y', 'N', 'N', 'N', NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, 'N', 'U', NULL, NULL,
	 NULL, 'Y', 'N', NULL, '88c68a91-bc09-4a59-a5bf-9a13a4652c87', NULL, 'B', 0, 'N', 'Y', NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

-- Master roles (ad_client_id = 0) per role matrix snapshot
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Y', 'bfa40b15-7135-4282-8f10-d7a356617029',
	 'Y'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Y', '1eb6cbed-81a8-4ec8-9a53-0cba7002521e',
	 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Y', '23c5f05d-ec87-49fa-bc30-23ec825dc3e3',
	 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'N', 'f6e4ffdf-6547-4650-870e-62b74ad403db',
	 'N'),
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 'Y', '2026-07-02 12:00:00', 100, '2026-07-02 12:00:00', 100, 'Y', '34e0a58f-4c54-4f18-b2f5-bc93262ac504',
	 'Y')
ON CONFLICT DO NOTHING;

-- Automatic tenant roles (system admin per client) get full access, matching other visit sub-windows
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	r.ad_client_id,
	r.ad_org_id,
	'Y',
	'2026-07-02 12:00:00',
	100,
	'2026-07-02 12:00:00',
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_role r
		CROSS JOIN ad_window w
WHERE
	r.ismanual = 'N'
	AND w.ad_window_uu = '2dd179a5-5886-4971-99c0-f7b6f75d0ac3'
	AND NOT EXISTS (
		SELECT
			1
		FROM
			ad_window_access x
		WHERE
			x.ad_window_id = w.ad_window_id
			AND x.ad_role_id = r.ad_role_id
			AND x.ad_client_id = r.ad_client_id
	);

SELECT
	register_migration_script('202607021200_GO-3356.sql')
FROM
	dual;
