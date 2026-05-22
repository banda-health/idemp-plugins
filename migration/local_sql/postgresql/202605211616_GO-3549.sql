INSERT INTO
	ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name,
	         updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual,
	         isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id,
	         iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit,
	         isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords,
	         connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner,
	         allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order,
	         allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule,
	         userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice,
	         isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu,
	         ismenuautoexpand, ismasterrole, isaccessadvanced, roletype, isclientadministrator,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT
			 COALESCE(MAX(ad_role_id), 0) + 1
		 FROM
			 ad_role
	 ),
	 0, 0, 'Y', NOW(), 100, NOW(), 'Cashier Lite',
	 100, 'Cashier/Registration Basic Plus Sales Price Editing on Visits Without Add Service',
	 'S  ', NULL, 0, NULL, 'Y',
	 'N', 'N', 'N', 'Y', 'Y', NULL,
	 'N', 'N', 'N', 'O', 'N',
	 'N', NULL, 0, 0, NULL,
	 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y',
	 'Y', 'Y', 'Y', 'Y',
	 NULL, 'N', 'N', 'N', 'N',
	 0, 0, '3665260a-9448-4816-8af7-5e3f93a16ab7',
	 'N', 'Y', 'Y', NULL, 'N', NULL);

WITH target_role AS (
	SELECT
		ad_role_id
	FROM
		ad_role
	WHERE
		ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
),
	window_whitelist(ad_window_uu, isreadwrite, bh_candeactivate) AS (
		VALUES
			('fd93da00-871d-4996-a3f7-4528bed8b758',
			 'N', 'Y'),
			('c63b9972-1b23-4140-8bbb-0ea2b0b81024',
			 'N', 'N'),
			('a1f3e45c-4a6f-4c05-af26-517b8e9cbb77',
			 'Y', 'Y'),
			('37df7931-7d07-4812-b9d4-dec7a53bb70f',
			 'Y', 'N'),
			('ba697729-5ec8-44f7-b534-446310bb5782',
			 'Y', 'Y'),
			('4497b5f7-758d-4e82-8e2b-01c4364ce609',
			 'Y', 'Y'),
			('44c02ddc-ef83-4020-8e4c-709d8cbeadc2',
			 'Y', 'N'),
			('d91768c8-5c5b-4d7c-9a6f-15b06d45908b',
			 'Y', 'N'),
			('3c865615-4f7e-4b19-a64b-740485d99e83',
			 'N', 'N'),
			('02235082-ebb7-47d3-ba31-9654de1f32c1',
			 'Y', 'Y'),
			('be24b4d5-987f-4aa5-ae14-38375b0d6bf2',
			 'Y', 'Y'),
			('d4d1767a-1a6f-45ef-8b72-48ff004f1b4e',
			 'Y', 'Y')
	),
	process_whitelist(ad_process_uu, isreadwrite) AS (
		VALUES
			('4cf22d3f-1fc8-4bdd-83e1-fc5d79537269', 'Y'),
			('30dd7243-11c1-4584-af26-5d977d117c84', 'Y'),
			('1211e173-6f12-4e2f-bfcc-d43d48af51c3', 'Y'),
			('a7ac9f65-45d7-4ae0-80f3-72019de35a4a', 'Y'),
			('173a691b-ba89-4987-9216-9b3f0a60c864', 'Y'),
			('9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2', 'Y'),
			('b4f11e14-b9d8-4f6c-aa46-adfd77c4f773', 'Y'),
			('477cdda4-82ff-4bac-834f-08de384df412', 'Y'),
			('199f56a6-8e1f-47b4-8f22-e2bdb8da7505', 'Y'),
			('226cdf47-9cde-43e8-b7ef-87b28d7ef2e2', 'Y'),
			('b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1', 'Y'),
			('b8508f0a-c66f-4030-a88c-3ae383322ceb', 'Y'),
			('bbffd5e1-973a-4d17-9ddf-9ca78a4e140d', 'Y')
	)

-- Windows
INSERT
INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive,
	                  created, createdby, updated, updatedby, isreadwrite,
	                  ad_window_access_uu, bh_candeactivate)
SELECT
	w.ad_window_id,
	tr.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	ww.isreadwrite,
	gen_random_uuid()::text,
	ww.bh_candeactivate
FROM
	window_whitelist ww
		JOIN ad_window w
			ON w.ad_window_uu = ww.ad_window_uu
		CROSS JOIN target_role tr
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			ad_window_access x
		WHERE
			x.ad_window_id = w.ad_window_id
			AND x.ad_role_id = tr.ad_role_id
	);


-- Processes
WITH target_role AS (
	SELECT
		ad_role_id
	FROM
		ad_role
	WHERE
		ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
),
	process_whitelist(ad_process_uu, isreadwrite) AS (
		VALUES
			('4cf22d3f-1fc8-4bdd-83e1-fc5d79537269', 'Y'),
			('30dd7243-11c1-4584-af26-5d977d117c84', 'Y'),
			('1211e173-6f12-4e2f-bfcc-d43d48af51c3', 'Y'),
			('a7ac9f65-45d7-4ae0-80f3-72019de35a4a', 'Y'),
			('173a691b-ba89-4987-9216-9b3f0a60c864', 'Y'),
			('9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2', 'Y'),
			('b4f11e14-b9d8-4f6c-aa46-adfd77c4f773', 'Y'),
			('477cdda4-82ff-4bac-834f-08de384df412', 'Y'),
			('199f56a6-8e1f-47b4-8f22-e2bdb8da7505', 'Y'),
			('226cdf47-9cde-43e8-b7ef-87b28d7ef2e2', 'Y'),
			('b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1', 'Y'),
			('b8508f0a-c66f-4030-a88c-3ae383322ceb', 'Y'),
			('bbffd5e1-973a-4d17-9ddf-9ca78a4e140d', 'Y')
	)
INSERT
INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive,
	                   created, createdby, updated, updatedby, isreadwrite,
	                   ad_process_access_uu)
SELECT
	p.ad_process_id,
	tr.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	pw.isreadwrite,
	gen_random_uuid()::text
FROM
	process_whitelist pw
		JOIN ad_process p
			ON p.ad_process_uu = pw.ad_process_uu
		CROSS JOIN target_role tr
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			ad_process_access x
		WHERE
			x.ad_process_id = p.ad_process_id
			AND x.ad_role_id = tr.ad_role_id
	);

--- Move old role to new one
WITH roles AS (
	SELECT
		(
			SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'
		) AS old_role_id,
		(
			SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
		) AS new_role_id
)
INSERT
INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive,
	               created, createdby, updated, updatedby, ad_user_roles_uu)
SELECT
	ur.ad_user_id,
	r.new_role_id,
	ur.ad_client_id,
	ur.ad_org_id,
	'Y',
	NOW(),
	ur.createdby,
	NOW(),
	ur.updatedby,
	gen_random_uuid()::text
FROM
	ad_user_roles ur
		CROSS JOIN roles r
WHERE
	ur.ad_role_id = r.old_role_id
	AND NOT EXISTS (
		SELECT
			1
		FROM
			ad_user_roles x
		WHERE
			x.ad_user_id = ur.ad_user_id
			AND x.ad_role_id = r.new_role_id
	);

SELECT
	bh_add_roles_to_clients('3665260a-9448-4816-8af7-5e3f93a16ab7', 'Z');

SELECT
	register_migration_script('202605211616_GO-3549.sql')
FROM
	dual;
