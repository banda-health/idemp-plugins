-- Remove the ability to "Close" from the "Must Haves" role
DELETE
FROM
	ad_document_action_access daa
	USING
		ad_role r
WHERE
	daa.ad_role_id = r.ad_role_id
	AND r.ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
	AND daa.ad_ref_list_id = 183;

SELECT
	register_migration_script('202304061227_GO-2673.sql')
FROM
	dual;
