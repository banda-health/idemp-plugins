-- Update process stage reference names
UPDATE AD_Ref_List SET Name = 'Cashier / Registration' WHERE AD_Ref_List_UU='fed0d4f4-4eb2-478c-beb4-9570a8da06bf';
UPDATE AD_Ref_List SET Name = 'Clinician / Dentist' WHERE AD_Ref_List_UU='e74d5f99-fd01-4d54-ab35-7a630c43f064';
UPDATE AD_Ref_List SET Name = 'Lab / Imaging' WHERE AD_Ref_List_UU='e3eace1e-ee22-409b-a7ae-09cee5350b91';

-- Insert triage/vitals
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id)+1) FROM ad_ref_list, 0, 0, 'Y', '2024-10-11 17:39:00.981000', 100, '2024-10-11 17:39:00.981000', 100, 'totriage', 'Triage / Vitals', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu='b24e7939-f43e-4add-9fe9-a03b0d862675'), null, null, 'U', '200a2704-2496-49ee-bc15-421cc25abbfd', null, null) ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202410111725_GO-2702.sql')
FROM
	dual;
