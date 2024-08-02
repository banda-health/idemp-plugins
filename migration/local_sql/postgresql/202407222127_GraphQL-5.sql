UPDATE ad_column
SET
	isupdateable       = 'Y',
	isalwaysupdateable = 'Y'
WHERE
	ad_column_uu in ('8a25e6da-7705-4868-809b-8573f08eda46','1e64d8e2-67e5-4c01-8469-f67a3c10a93a','56380abf-0060-4511-9a22-0f966a598729');

-- add window access to "Must Haves" role since visits need window access
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, ad_window_access_uu)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	0,
	0,
	100,
	100,
	uuid_generate_v4()
FROM
	ad_window w
		JOIN ad_role r
		ON r.ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
WHERE
	w.ad_window_uu = 'f1f8bd40-7c71-4ace-9a45-1442a2dfd8a9';

SELECT
	register_migration_script('202407222127_GraphQL-5.sql')
FROM
	dual;
