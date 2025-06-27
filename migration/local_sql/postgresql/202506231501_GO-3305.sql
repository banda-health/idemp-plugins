INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                                   updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype,
                                   ad_ref_list_uu, bh_update_existing, bh_add_all)
VALUES ((SELECT max(ad_ref_list_id) + 1 from ad_ref_list), 0, 0, 'Y', '2025-06-19 16:11:38.454000', 100, '2025-06-19 16:11:38.454000', 100, 'BHPharmacy',
        'BHPharmacy - Product Catalog', 'Products & Services catalogue', (select ad_reference_id from ad_reference where ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'), null, null, 'U',
        'e3770de6-7586-4bda-8689-98a5c63fde76', null, null);

SELECT
	register_migration_script('202506231501_GO-3305.sql')
FROM
	dual;