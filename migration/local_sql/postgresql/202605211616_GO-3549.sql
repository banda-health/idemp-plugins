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
	 100, 'Cashier role with minimal access', 'S  ', NULL, 0, NULL, 'Y',
	 'N', 'N', 'N', 'Y', 'Y', NULL,
	 'N', 'N', 'N', 'O', 'N',
	 'N', NULL, 0, 0, NULL,
	 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y',
	 'Y', 'Y', 'Y', 'Y',
	 NULL, 'N', 'N', 'N', 'N',
	 0, 0, '3665260a-9448-4816-8af7-5e3f93a16ab7',
	 'N', 'Y', 'Y', NULL, 'N', NULL);

-- Windows: same as Cashier/Registration Basic, except excluded windows below
INSERT
INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive,
	                  created, createdby, updated, updatedby, isreadwrite,
	                  ad_window_access_uu, bh_candeactivate)
SELECT
	wa.ad_window_id,
	r_lite.ad_role_id,
	wa.ad_client_id,
	wa.ad_org_id,
	wa.isactive,
	NOW(),
	wa.createdby,
	NOW(),
	wa.updatedby,
	wa.isreadwrite,
	uuid_generate_v4(),
	wa.bh_candeactivate
FROM
	ad_window_access wa
		JOIN ad_window w
			ON wa.ad_window_id = w.ad_window_id
		JOIN ad_role r_basic
			ON wa.ad_role_id = r_basic.ad_role_id
		AND r_basic.ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
		JOIN ad_role r_lite
			ON r_lite.ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
WHERE
	w.ad_window_uu NOT IN (
	                       '3c865615-4f7e-4b19-a64b-740485d99e83', -- Patient Tags
	                       'be24b4d5-987f-4aa5-ae14-38375b0d6bf2', -- Supplier Payments
	                       'c63b9972-1b23-4140-8bbb-0ea2b0b81024', -- Products
	                       'e1ba0b91-cb26-4ab0-bcc6-2ee762ad1a84', -- Price Lists
	                       'fd93da00-871d-4996-a3f7-4528bed8b758', -- Services
	                       '37df7931-7d07-4812-b9d4-dec7a53bb70f', -- Track Expenses
	                       '44c02ddc-ef83-4020-8e4c-709d8cbeadc2', -- Track Income
	                       'd91768c8-5c5b-4d7c-9a6f-15b06d45908b', -- Dashboard
	                       '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f', -- OTC Pharmacy Sales
	                       'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e' -- Products and Services Catalogue
		)
	AND NOT EXISTS (
		SELECT
			1
		FROM
			ad_window_access x
		WHERE
			x.ad_window_id = wa.ad_window_id
			AND x.ad_role_id = r_lite.ad_role_id
	);

-- Processes: visit receipt and visit insurance/invoice reports only
INSERT
INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive,
	                   created, createdby, updated, updatedby, isreadwrite,
	                   ad_process_access_uu)
SELECT
	p.ad_process_id,
	r_lite.ad_role_id,
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
	ad_process p
		CROSS JOIN (
		SELECT
			ad_role_id
		FROM
			ad_role
		WHERE
			ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
	) r_lite
WHERE
	p.ad_process_uu IN (
	                    '30dd7243-11c1-4584-af26-5d977d117c84', -- Visit Receipt
	                    '477cdda4-82ff-4bac-834f-08de384df412' -- Visit Invoice (Insurance)
		)
	AND NOT EXISTS (
		SELECT
			1
		FROM
			ad_process_access x
		WHERE
			x.ad_process_id = p.ad_process_id
			AND x.ad_role_id = r_lite.ad_role_id
	);

-- Migrate Galmi client users from Cashier/Registration Basic or Basic+ to Cashier Lite
WITH roles AS (
	SELECT
		(
			SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
		) AS basic_role_id,
		(
			SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'
		) AS basic_plus_role_id,
		(
			SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '3665260a-9448-4816-8af7-5e3f93a16ab7'
		) AS lite_role_id,
		(
			SELECT ad_client_id FROM ad_client WHERE ad_client_uu = '8f5dd4ad-de55-4edf-86c2-1cbce4ff6512'
		) AS galmi_client_id
)
UPDATE
	ad_user_roles ur
SET
	ad_role_id = r.lite_role_id,
	updated    = NOW()
FROM
	roles r
WHERE
	ur.ad_client_id = r.galmi_client_id
	AND ur.ad_role_id IN (r.basic_role_id, r.basic_plus_role_id)
	AND NOT EXISTS (
		SELECT
			1
		FROM
			ad_user_roles x
		WHERE
			x.ad_user_id = ur.ad_user_id
			AND x.ad_role_id = r.lite_role_id
			AND x.ad_client_id = ur.ad_client_id
	)
	AND 1 = (
		SELECT
			COUNT(*)
		FROM
			ad_user_roles ur2
		WHERE
			ur2.ad_user_id = ur.ad_user_id
			AND ur2.ad_client_id = r.galmi_client_id
			AND ur2.ad_role_id IN (r.basic_role_id, r.basic_plus_role_id)
	);

SELECT
	bh_add_roles_to_clients('3665260a-9448-4816-8af7-5e3f93a16ab7', 'F');

SELECT
	register_migration_script('202605211616_GO-3549.sql')
FROM
	dual;
