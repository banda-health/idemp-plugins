-- Grant access to allergies to the right users
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
	CASE
		WHEN r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e') THEN 'Y'
		ELSE 'N' END
FROM
	ad_window w
		JOIN ad_role r
		ON ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', '097feff0-3aa6-41fe-bf76-936b03859846',
		                  'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', '98617c31-55ff-48f9-bd44-253ef323d960',
		                  'c54253cf-c86b-4aaa-b472-ed8880635c62')
WHERE
	w.ad_window_uu = '45f693e1-d33a-43cf-81dc-1f75262f3bd0';

-- Wrap up and be done
SELECT
	register_migration_script('202503201237_GO-2985.sql')
FROM
	dual;
