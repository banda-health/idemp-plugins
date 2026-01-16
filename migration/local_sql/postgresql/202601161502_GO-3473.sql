INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created,
	                   createdby, updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'fb90406f-1ba4-43df-9cec-6844e10c13d9'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 'Y',
	 '2026-01-16 12:11:21.444000', 100, '2026-01-16 12:11:21.444000', 100, 'Y',
	 'f79bb09b-48a0-463d-b0f3-be0f4e9e2ef1');

-- Register migration script
SELECT
	register_migration_script('202601161502_GO-3473.sql')
FROM
	dual;
