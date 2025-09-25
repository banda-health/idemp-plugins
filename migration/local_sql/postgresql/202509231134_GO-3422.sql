INSERT INTO
	ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby,
	         description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct,
	         ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc,
	         isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess,
	         ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account,
	         allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout,
	         allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource,
	         allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice,
	         isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand,
	         ismasterrole, isaccessadvanced, roletype, isclientadministrator, predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_role_id)
		 FROM
			 ad_role
	 ) + 1, 0, 0, 'Y', '2025-09-23 11:44:59.200000', 100, '2025-09-23 15:12:45.142000', 'Implementer', 100, NULL,
	 'S  ', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y',
	 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'N', 'N', 'N', 'N', 0, 0, 'd162fcdb-22ff-4004-8685-f9ebef1aa273',
	 'N', 'N', 'Y', NULL, 'N', NULL);


INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, createdby, updatedby, ad_user_role_uu)
SELECT
	u.ad_user_id,
	r.ad_role_id,
	100,
	100,
	uuid_generate_v4()
FROM
	ad_user u
		JOIN ad_role r
			ON r.ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
WHERE
	u.ad_uswe_uu IN ('775cf2b6-988f-46bc-a7d0-47721a9ffd97', '7f805ff3-65ce-4283-838b-154def453c98',
	                 '7f805ff3-65ce-4283-838b-154def453c98');


SELECT
	register_migration_script('202509231134_GO-3422.sql')
FROM
	dual;
