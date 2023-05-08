UPDATE ad_ref_list
SET
	name = 'Immunizations & Well Child'
WHERE
	AD_Ref_List_UU = '3cbeb14f-10db-4e32-9b85-e3463eb620b8';

INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2023-05-08 09:35:32.262000', 100, '2023-05-08 09:35:32.262000', 100, 'z', 'Home Visit', 'home visit',
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, NULL, 'U', '6403b016-5628-4612-a7a1-00e68e3dd0ae', NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2023-05-08 09:35:58.443000', 100, '2023-05-08 09:35:58.443000', 100, 'y', 'PT/OT', 'PT/OT', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, NULL, 'U', '1cbfa54e-47ba-4d7b-ada0-119ac3404767', NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2023-05-08 09:36:18.465000', 100, '2023-05-08 09:36:18.465000', 100, 'x', 'Follow-up', 'follow up', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, NULL, 'U', '65ef5222-ed10-4764-b516-a9874ef56519', NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2023-05-08 09:36:30.240000', 100, '2023-05-08 09:36:30.240000', 100, 'u', 'Family Planning',
	 'family planning', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	 ), NULL, NULL, 'U', 'fd6db151-fb69-40ed-a784-5d8b99b92004', NULL, NULL)
ON CONFLICT DO NOTHING;


SELECT
	register_migration_script('202305081013_GO-2636.sql')
FROM
	dual;
