INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT max(ad_ref_list_id)+1 FROM ad_ref_list), 0, 0, 'Y', '2024-12-05 10:46:07.690000', 100, '2024-12-05 10:46:07.690000', 100, 'Mh', 'Mental Health', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', 'b3bd568f-e623-41ba-8d52-c1886a0a3d05', null, null) ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202412051131_GO-3170.sql')
FROM
	dual;
