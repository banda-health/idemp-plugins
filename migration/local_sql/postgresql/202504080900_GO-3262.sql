-- Re-enable the dashboard menu item
UPDATE ad_menu
SET
	isactive     = 'Y',
	ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b'
	)
WHERE
	ad_menu_uu = 'cc0d5ed0-b0c9-4038-93b3-b7c7343bdde6';

-- Add dashboard access to all roles
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
	'Y',
	uuid_generate_v4(),
	'N'
FROM
	ad_window w
		JOIN ad_role r
		ON r.ad_role_uu IN ('097feff0-3aa6-41fe-bf76-936b03859846', '93365778-a2d9-433b-b962-87fb150db4fa',
		                    '09eb7fc8-9cc5-44b0-9d14-15258a066038', '98617c31-55ff-48f9-bd44-253ef323d960',
		                    'ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
		                    'c54253cf-c86b-4aaa-b472-ed8880635c62', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
		                    'a1618fd6-e1ab-4e41-a08d-854229cd5971', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a')
WHERE
	w.ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b';

-- Wrap up and be done
SELECT
	register_migration_script('202504080900_GO-3262.sql')
FROM
	dual;
