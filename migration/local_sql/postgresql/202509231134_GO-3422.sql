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
		 SELECT MAX(ad_role_id)
		 FROM ad_role
	 ) + 1, 0, 0, 'Y', '2025-09-23 11:44:59.200000', 100, '2025-09-23 15:12:45.142000', 'Implementer ', 100, NULL,
	 'S  ', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y',
	 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'N', 'N', 'N', 'N', 0, 0, 'd162fcdb-22ff-4004-8685-f9ebef1aa273',
	 'N', 'N', 'Y', NULL, 'N', NULL);

INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                         updatedby, ad_user_roles_uu)
VALUES
	((
		 SELECT
			 ad_user_id
		 FROM
			 ad_user
		 WHERE
			 ad_user_uu = '775cf2b6-988f-46bc-a7d0-47721a9ffd97'
	 ), (
		 SELECT
			 ad_role_id
		 FROM
			 ad_role
		 WHERE
			 ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 16:28:09.767000', 100, '2025-09-23 16:28:09.767000', 100,
	 'f82aa43f-a517-4681-a87c-8f6cf7009e69');

INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                         updatedby, ad_user_roles_uu)
VALUES
	((
		 SELECT
			 ad_user_id
		 FROM
			 ad_user
		 WHERE
			 ad_user_uu = 'f284b016-052f-4f81-b28c-fb918b5ff173'
	 ), (
		 SELECT
			 ad_role_id
		 FROM
			 ad_role
		 WHERE
			 ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 16:28:09.767000', 100, '2025-09-23 16:28:09.767000', 100,
	 '9c262a59-a62c-4f11-94e3-d7bccd374275');

INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                         updatedby, ad_user_roles_uu)
VALUES
	((
		 SELECT
			 ad_user_id
		 FROM
			 ad_user
		 WHERE
			 ad_user_uu = '7f805ff3-65ce-4283-838b-154def453c98'
	 ), (
		 SELECT
			 ad_role_id
		 FROM
			 ad_role
		 WHERE
			 ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 16:28:09.767000', 100, '2025-09-23 16:28:09.767000', 100,
	 'c3b2275f-7499-4c81-aead-57841c02fe06');	 

SELECT
	register_migration_script('202509231134_GO-3422.sql')
FROM
	dual;
