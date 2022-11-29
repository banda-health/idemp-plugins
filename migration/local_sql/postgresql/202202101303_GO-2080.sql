-- Move the document action to reopen bills from the "Must Haves" master role to only the Clinic Admin
-- Must Haves UUID = baec9412-d994-4313-815c-31332357863a
-- Clinic Admin UUID = 461b31c5-cae2-449d-8a0c-7385b12f4685
UPDATE ad_document_action_access
SET ad_role_id = (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685')
WHERE ad_role_id = (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a')
	AND ad_ref_list_id = 188;

SELECT register_migration_script('202202101303_GO-2080.sql') FROM dual;
