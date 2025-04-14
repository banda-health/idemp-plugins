-- Add the price list page to the appropriate users
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	146, -- Price list window
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
	'Y'
FROM
	ad_role r
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', '461b31c5-cae2-449d-8a0c-7385b12f4685');

-- Grant access to the create price list process to each of those users
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	103, -- Create Product Prices on Price Lists
	r.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_role r
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', '461b31c5-cae2-449d-8a0c-7385b12f4685');

-- Register the script and be done
SELECT
	register_migration_script('202502251420_GO-1443.sql')
FROM
	dual;
