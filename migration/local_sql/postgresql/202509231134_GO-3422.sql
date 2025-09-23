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
	 ) + 1, 0, 0, 'Y', '2025-09-23 11:50:59.200000', 100, '2025-09-23 11:50:59.200000', 'Implementer ', 100, NULL,
	 'S  ', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y',
	 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'N', 'N', 'N', 'N', 0, 0, 'd162fcdb-22ff-4004-8685-f9ebef1aa273',
	 'N', 'Y', 'Y', NULL, 'N', NULL);

--- Add Window access

INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:00.200000', 100, '2025-09-23 11:51:00.200000', 100, 'Y',
	 'a7b2c8d9-1e2f-4a5b-9c8d-3e6f7a8b9c0d', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:01.200000', 100, '2025-09-23 11:51:01.200000', 100, 'Y',
	 'b3c9d4e0-2f3a-5b6c-ad9e-4f7a8b9c0d1e', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:02.200000', 100, '2025-09-23 11:51:02.200000', 100, 'Y',
	 'c4d0e5f1-3a4b-6c7d-be0f-5a8b9c0d1e2f', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:03.200000', 100, '2025-09-23 11:51:03.200000', 100, 'Y',
	 'd5e1f6a2-4b5c-7d8e-cf1a-6b9c0d1e2f3a', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '78dd6f39-84f9-4e19-b08e-7a3441af15e5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:04.200000', 100, '2025-09-23 11:51:04.200000', 100, 'Y',
	 'e6f2a7b3-5c6d-8e9f-da2b-7c0d1e2f3a4b', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '37df7931-7d07-4812-b9d4-dec7a53bb70f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:05.200000', 100, '2025-09-23 11:51:05.200000', 100, 'Y',
	 'f7a3b8c4-6d7e-9fa0-eb3c-8d1e2f3a4b5c', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:06.200000', 100, '2025-09-23 11:51:06.200000', 100, 'Y',
	 'a8b4c9d5-7e8f-0ab1-fc4d-9e2f3a4b5c6d', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:07.200000', 100, '2025-09-23 11:51:07.200000', 100, 'Y',
	 'b9c5d0e6-8f9a-1bc2-ad5e-0f3a4b5c6d7e', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:08.200000', 100, '2025-09-23 11:51:08.200000', 100, 'Y',
	 'c0d6e1f7-9a0b-2cd3-be6f-1a4b5c6d7e8f', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:09.200000', 100, '2025-09-23 11:51:09.200000', 100, 'Y',
	 'd1e7f2a8-0b1c-3de4-cf7a-2b5c6d7e8f9a', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '5731bc45-3b78-475a-a347-4ca899f19e32'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:10.200000', 100, '2025-09-23 11:51:10.200000', 100, 'Y',
	 'e2f8a3b9-1c2d-4ef5-da8b-3c6d7e8f9a0b', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:11.200000', 100, '2025-09-23 11:51:11.200000', 100, 'Y',
	 'f3a9b4c0-2d3e-5fa6-eb9c-4d7e8f9a0b1c', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '6b934ec2-7f45-4104-ba10-08e3ce54de7e'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:12.200000', 100, '2025-09-23 11:51:12.200000', 100, 'Y',
	 'a4b0c5d1-3e4f-6ab7-fca0-5e8f9a0b1c2d', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '53b4d743-c311-40e5-aa8e-c0880c42c1b1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:13.200000', 100, '2025-09-23 11:51:13.200000', 100, 'Y',
	 'b5c1d6e2-4f5a-7bc8-adb1-6f9a0b1c2d3e', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:14.200000', 100, '2025-09-23 11:51:14.200000', 100, 'Y',
	 'c6d2e7f3-5a6b-8cd9-bec2-7a0b1c2d3e4f', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:15.200000', 100, '2025-09-23 11:51:15.200000', 100, 'Y',
	 'd7e3f8a4-6b7c-9dea-cfd3-8b1c2d3e4f5a', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:16.200000', 100, '2025-09-23 11:51:16.200000', 100, 'Y',
	 'e8f4a9b5-7c8d-0efb-dae4-9c2d3e4f5a6b', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:17.200000', 100, '2025-09-23 11:51:17.200000', 100, 'Y',
	 'f9a5b0c6-8d9e-1fac-ebf5-0d3e4f5a6b7c', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '44c02ddc-ef83-4020-8e4c-709d8cbeadc2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:18.200000', 100, '2025-09-23 11:51:18.200000', 100, 'Y',
	 'a0b6c1d7-9e0f-2abd-fca6-1e4f5a6b7c8d', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:19.200000', 100, '2025-09-23 11:51:19.200000', 100, 'Y',
	 'b1c7d2e8-0f1a-3bce-adb7-2f5a6b7c8d9e', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '66df8b28-5a44-40a0-b63e-d51695bdfc92'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:20.200000', 100, '2025-09-23 11:51:20.200000', 100, 'Y',
	 'c2d8e3f9-1a2b-4cdf-bec8-3a6b7c8d9e0f', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:21.200000', 100, '2025-09-23 11:51:21.200000', 100, 'Y',
	 'd3e9f4a0-2b3c-5dea-cfd9-4b7c8d9e0f1a', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3084592a-531b-4fbd-a412-5c14c2b15288'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:22.200000', 100, '2025-09-23 11:51:22.200000', 100, 'Y',
	 'e4f0a5b1-3c4d-6efb-da0a-5c8d9e0f1a2b', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '55f080e3-17f4-4ffa-b03b-6dda34884bcc'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:23.200000', 100, '2025-09-23 11:51:23.200000', 100, 'Y',
	 'f5a1b6c2-4d5e-7fac-eb1b-6d9e0f1a2b3c', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2fa5f5cd-0a9d-4485-b3fb-51b0e59da956'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:24.200000', 100, '2025-09-23 11:51:24.200000', 100, 'Y',
	 'a6b2c7d3-5e6f-8abd-fc2c-7e0f1a2b3c4d', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '8794d7c3-733c-4a4d-a2d9-f6a9afef594e'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:25.200000', 100, '2025-09-23 11:51:25.200000', 100, 'Y',
	 'b7c3d8e4-6f7a-9bce-ad3d-8f1a2b3c4d5e', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'e1ba0b91-cb26-4ab0-bcc6-2ee762ad1a84'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:26.200000', 100, '2025-09-23 11:51:26.200000', 100, 'Y',
	 'c8d4e9f5-7a8b-0cdf-be4e-9a2b3c4d5e6f', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '45f693e1-d33a-43cf-81dc-1f75262f3bd0'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:27.200000', 100, '2025-09-23 11:51:27.200000', 100, 'Y',
	 'd9e5f0a6-8b9c-1dea-cf5f-0b3c4d5e6f7a', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:28.200000', 100, '2025-09-23 11:51:28.200000', 100, 'Y',
	 'e0f6a1b7-9c0d-2efb-da6a-1c4d5e6f7a8b', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:29.200000', 100, '2025-09-23 11:51:29.200000', 100, 'Y',
	 'f1a7b2c8-0d1e-3fac-eb7b-2d5e6f7a8b9c', 'Y');
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '02235082-ebb7-47d3-ba31-9654de1f32c1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:51:30.200000', 100, '2025-09-23 11:51:30.200000', 100, 'Y',
	 'a2b8c3d9-1e2f-4abd-fc8c-3e6f7a8b9c0d', 'Y');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:00.200000', 100, '2025-09-23 11:52:00.200000', 100, 'Y',
	 'f1a2b3c4-5d6e-7f8a-9b0c-1d2e3f4a5b6c');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1211e173-6f12-4e2f-bfcc-d43d48af51c3'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:01.200000', 100, '2025-09-23 11:52:01.200000', 100, 'Y',
	 'a2b3c4d5-6e7f-8a9b-0c1d-2e3f4a5b6c7d');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c9f91d23-48ea-4990-af5d-f3e7f0db77de'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:02.200000', 100, '2025-09-23 11:52:02.200000', 100, 'Y',
	 'b3c4d5e6-7f8a-9b0c-1d2e-3f4a5b6c7d8e');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '742f515a-81c7-4690-8d35-2c6f1252ad5b'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:03.200000', 100, '2025-09-23 11:52:03.200000', 100, 'Y',
	 'c4d5e6f7-8a9b-0c1d-2e3f-4a5b6c7d8e9f');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '432eeb61-1a87-4880-bded-91927139341c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:04.200000', 100, '2025-09-23 11:52:04.200000', 100, 'Y',
	 'd5e6f7a8-9b0c-1d2e-3f4a-5b6c7d8e9fa0');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:05.200000', 100, '2025-09-23 11:52:05.200000', 100, 'Y',
	 'e6f7a8b9-0c1d-2e3f-4a5b-6c7d8e9fa0b1');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3edf67b9-ee3d-4b73-a02e-deb1c1811db5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:06.200000', 100, '2025-09-23 11:52:06.200000', 100, 'Y',
	 'f7a8b9c0-1d2e-3f4a-5b6c-7d8e9fa0b1c2');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:07.200000', 100, '2025-09-23 11:52:07.200000', 100, 'Y',
	 'a8b9c0d1-2e3f-4a5b-6c7d-8e9fa0b1c2d3');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:08.200000', 100, '2025-09-23 11:52:08.200000', 100, 'Y',
	 'b9c0d1e2-3f4a-5b6c-7d8e-9fa0b1c2d3e4');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:09.200000', 100, '2025-09-23 11:52:09.200000', 100, 'Y',
	 'c0d1e2f3-4a5b-6c7d-8e9f-a0b1c2d3e4f5');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '630fc1ab-0b64-459b-b10f-68549d21f507'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:10.200000', 100, '2025-09-23 11:52:10.200000', 100, 'Y',
	 'd1e2f3a4-5b6c-7d8e-9fa0-b1c2d3e4f5a6');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:11.200000', 100, '2025-09-23 11:52:11.200000', 100, 'Y',
	 'e2f3a4b5-6c7d-8e9f-a0b1-c2d3e4f5a6b7');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:12.200000', 100, '2025-09-23 11:52:12.200000', 100, 'Y',
	 'f3a4b5c6-7d8e-9fa0-b1c2-d3e4f5a6b7c8');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '173a691b-ba89-4987-9216-9b3f0a60c864'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:13.200000', 100, '2025-09-23 11:52:13.200000', 100, 'Y',
	 'a4b5c6d7-8e9f-a0b1-c2d3-e4f5a6b7c8d9');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '53fc02c9-001a-4536-8d2a-3c003c93effa'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:14.200000', 100, '2025-09-23 11:52:14.200000', 100, 'Y',
	 'b5c6d7e8-9fa0-b1c2-d3e4-f5a6b7c8d9ea');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:15.200000', 100, '2025-09-23 11:52:15.200000', 100, 'Y',
	 'c6d7e8f9-a0b1-c2d3-e4f5-a6b7c8d9eafb');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:16.200000', 100, '2025-09-23 11:52:16.200000', 0, 'Y',
	 'd7e8f9a0-b1c2-d3e4-f5a6-b7c8d9eafbc0');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:17.200000', 100, '2025-09-23 11:52:17.200000', 100, 'Y',
	 'e8f9a0b1-c2d3-e4f5-a6b7-c8d9eafbc0d1');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '20a623fb-e127-4c26-98d5-3604a6d100b2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:18.200000', 100, '2025-09-23 11:52:18.200000', 0, 'Y',
	 'f9a0b1c2-d3e4-f5a6-b7c8-d9eafbc0d1e2');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:19.200000', 100, '2025-09-23 11:52:19.200000', 100, 'Y',
	 'a0b1c2d3-e4f5-a6b7-c8d9-eafbc0d1e2f3');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'fb90406f-1ba4-43df-9cec-6844e10c13d9'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:20.200000', 100, '2025-09-23 11:52:20.200000', 0, 'Y',
	 'b1c2d3e4-f5a6-b7c8-d9ea-fbc0d1e2f3a4');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:21.200000', 100, '2025-09-23 11:52:21.200000', 0, 'Y',
	 'c2d3e4f5-a6b7-c8d9-eafb-c0d1e2f3a4b5');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:22.200000', 100, '2025-09-23 11:52:22.200000', 100, 'Y',
	 'd3e4f5a6-b7c8-d9ea-fbc0-d1e2f3a4b5c6');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:23.200000', 100, '2025-09-23 11:52:23.200000', 100, 'Y',
	 'e4f5a6b7-c8d9-eafb-c0d1-e2f3a4b5c6d7');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:24.200000', 100, '2025-09-23 11:52:24.200000', 100, 'Y',
	 'f5a6b7c8-d9ea-fbc0-d1e2-f3a4b5c6d7e8');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:25.200000', 100, '2025-09-23 11:52:25.200000', 100, 'Y',
	 'a6b7c8d9-eafb-c0d1-e2f3-a4b5c6d7e8f9');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:26.200000', 100, '2025-09-23 11:52:26.200000', 100, 'Y',
	 'b7c8d9ea-fbc0-d1e2-f3a4-b5c6d7e8f9a0');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'e79541fb-9b70-4a10-bfef-7401401b8c56'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:27.200000', 100, '2025-09-23 11:52:27.200000', 100, 'Y',
	 'c8d9eafb-c0d1-e2f3-a4b5-c6d7e8f9a0b1');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '8e270648-1d54-46d9-9161-2d0300dd80ff'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:28.200000', 100, '2025-09-23 11:52:28.200000', 100, 'Y',
	 'd9eafbc0-d1e2-f3a4-b5c6-d7e8f9a0b1c2');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '9fdbe1af-a79c-49ca-8081-0d32de89e053'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:29.200000', 100, '2025-09-23 11:52:29.200000', 100, 'Y',
	 'eafbc0d1-e2f3-a4b5-c6d7-e8f9a0b1c2d3');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1a7175fe-2afe-4404-9c56-58d2fda9bc57'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:30.200000', 100, '2025-09-23 11:52:30.200000', 100, 'Y',
	 'fbc0d1e2-f3a4-b5c6-d7e8-f9a0b1c2d3e4');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '6008a4c3-6329-4aeb-bfbb-3316a42690c9'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:31.200000', 100, '2025-09-23 11:52:31.200000', 100, 'Y',
	 'c0d1e2f3-a4b5-c6d7-e8f9-a0b1c2d3e4f5');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:32.200000', 100, '2025-09-23 11:52:32.200000', 100, 'Y',
	 'd1e2f3a4-b5c6-d7e8-f9a0-b1c2d3e4f5a6');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:33.200000', 100, '2025-09-23 11:52:33.200000', 100, 'Y',
	 'e2f3a4b5-c6d7-e8f9-a0b1-c2d3e4f5a6b7');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:34.200000', 100, '2025-09-23 11:52:34.200000', 100, 'Y',
	 'f3a4b5c6-d7e8-f9a0-b1c2-d3e4f5a6b7c8');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:35.200000', 100, '2025-09-23 11:52:35.200000', 100, 'Y',
	 'a4b5c6d7-e8f9-a0b1-c2d3-e4f5a6b7c8d9');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '25239635-591f-4940-bfb4-46533068af7d'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:36.200000', 100, '2025-09-23 11:52:36.200000', 100, 'Y',
	 'b5c6d7e8-f9a0-b1c2-d3e4-f5a6b7c8d9ea');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '8ea6c947-4450-48dd-8bd0-76b0f307dcb0'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:37.200000', 100, '2025-09-23 11:52:37.200000', 100, 'Y',
	 'c6d7e8f9-a0b1-c2d3-e4f5-a6b7c8d9eafb');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'fd5b6538-760c-4c8f-b943-115c1f3d2287'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:38.200000', 100, '2025-09-23 11:52:38.200000', 100, 'Y',
	 'd3a1496d-6e72-4137-bf30-a89053e216d7');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '5a666f24-469a-43dc-865f-4053e0dd4fd6'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:39.200000', 100, '2025-09-23 11:52:39.200000', 100, 'Y',
	 '13653cab-6aff-4582-9a5d-80e207e2c5b2');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:40.200000', 100, '2025-09-23 11:52:40.200000', 100, 'Y',
	 'c78af12f-0e0b-4407-ad33-0f643582e74b');
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '592179c8-1974-4205-aeca-005233fdacd0'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd162fcdb-22ff-4004-8685-f9ebef1aa273'
	 ), 0, 0, 'Y', '2025-09-23 11:52:41.200000', 100, '2025-09-23 11:52:41.200000', 100, 'Y',
	 '05fdd74c-6eaa-44c2-9a8a-ff201c2d7bfc');
--- Add roles to client
SELECT
	bh_add_roles_to_clients('d162fcdb-22ff-4004-8685-f9ebef1aa273', 'IR');

SELECT
	register_migration_script('202509231134_GO-3422.sql')
FROM
	dual;
