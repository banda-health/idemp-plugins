/*Create 'Clinic User' role*/


INSERT INTO adempiere.ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)VALUES ((SELECT MAX(ad_role_id) + 1 from ad_role), 0, 0, 'Y', '2021-07-13 11:54:16.579000', 100, '2021-07-13 12:13:53.229000', 'Clinic User', 100, 'A role for single person administration', 'S  ', null, 0, null, 'Y', 'N', 'N', 'N', 'Y', 'Y', null, 'N', 'N', 'N', 'O', 'N', 'N', null, 0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', 0, 0, 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', 'N', 'Y', 'Y', null);

-- Add window access for role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 11:58:56.831000', 100, '2021-07-13 11:58:56.831000', 100, 'Y', '1575a9f9-c6fd-4688-baf5-f26b755a799a', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 11:59:16.291000', 100, '2021-07-13 11:59:16.291000', 100, 'Y', 'ab301d3d-c79e-495d-90cd-f0c085151ae1', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 11:59:26.129000', 100, '2021-07-13 11:59:26.129000', 100, 'Y', '932a65d0-d133-42da-b3f2-4ff750c9777a', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 11:59:35.716000', 100, '2021-07-13 11:59:35.716000', 100, 'Y', 'a180d5f0-dc89-4024-891b-88fe19841f58', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 11:59:44.634000', 100, '2021-07-13 11:59:44.634000', 100, 'Y', '9ed7de7e-f90e-4016-9b96-442cf74d9cdf', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '78dd6f39-84f9-4e19-b08e-7a3441af15e5'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:00:09.387000', 100, '2021-07-13 12:00:09.387000', 100, 'Y', '99276096-a2c7-417a-93a0-29be9dbab672', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '4497b5f7-758d-4e82-8e2b-01c4364ce609'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:00:48.300000', 100, '2021-07-13 12:00:48.300000', 100, 'Y', '229d1e4e-0a80-4feb-bbd4-88390ed48a3b', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '37df7931-7d07-4812-b9d4-dec7a53bb70f'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:01:21.502000', 100, '2021-07-13 12:01:21.502000', 100, 'Y', '4909dcde-a66b-46b9-ba9f-cbbd4ac82c9d', 'Y');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:00:34.105000', 100, '2021-07-13 12:16:00.637000', 100, 'N', 'fa50c263-f080-4f87-8ab6-cbe629ac5edc', 'N');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '5731bc45-3b78-475a-a347-4ca899f19e32'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:01:05.001000', 100, '2021-07-13 12:16:17.347000', 100, 'N', 'ad768153-8c14-4a0e-8efe-17d6222fb06a', 'N');
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:01:36.421000', 100, '2021-07-13 12:16:35.828000', 100, 'N', '837c4ad3-31c0-4dc2-b243-ae95993b86e8', 'N');

-- Add process access for role
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:03:22.630000', 100, '2021-07-13 12:03:22.630000', 100, 'N', 'e1a7e774-6afe-40ca-9072-cbc38e9582f9');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:04:18.173000', 100, '2021-07-13 12:04:18.173000', 100, 'N', '252cfb74-697a-44dd-a933-3ea2e65842e7');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '53fc02c9-001a-4536-8d2a-3c003c93effa'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:04:31.273000', 100, '2021-07-13 12:04:31.273000', 100, 'N', 'd1ae3292-7a9b-4080-b715-2a03202eaab0');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1211e173-6f12-4e2f-bfcc-d43d48af51c3'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:05:01.182000', 100, '2021-07-13 12:05:01.182000', 100, 'N', '9e72c1fd-fc8a-4740-8f46-4d9f18aa8bc6');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:05:10.409000', 100, '2021-07-13 12:05:10.409000', 100, 'N', '2a48b0cf-8a1b-42df-a0a7-e48b481f3067');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3edf67b9-ee3d-4b73-a02e-deb1c1811db5'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:05:23.427000', 100, '2021-07-13 12:05:23.427000', 100, 'N', 'a9a43e85-d335-48d0-9612-a041c4aa97a7');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'c9f91d23-48ea-4990-af5d-f3e7f0db77de'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:05:48.948000', 100, '2021-07-13 12:05:48.948000', 100, 'N', '5c016b19-ee04-4120-a9ec-62ed1b7194e7');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '061ed4a0-5670-4764-909e-fb4592f51aaa'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:06:10.093000', 100, '2021-07-13 12:06:10.093000', 100, 'N', 'a90ae76b-c1f7-49dc-9575-08b6814a709e');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '432eeb61-1a87-4880-bded-91927139341c'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:06:26.296000', 100, '2021-07-13 12:06:26.296000', 100, 'N', '91bd0025-6531-4a88-bf0b-59c82a6175cb');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '742f515a-81c7-4690-8d35-2c6f1252ad5b'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:06:38.407000', 100, '2021-07-13 12:06:38.407000', 100, 'N', 'ab735367-d6e5-4a8b-bd34-7969903b7797');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '630fc1ab-0b64-459b-b10f-68549d21f507'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:06:50.901000', 100, '2021-07-13 12:06:50.901000', 100, 'N', '83442993-1f43-4b8c-8e97-0d84db1283fb');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:07:05.274000', 100, '2021-07-13 12:07:05.274000', 100, 'N', 'e422596b-e7dc-4125-85f3-6e44f5c1bf7e');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:07:40.287000', 100, '2021-07-13 12:07:40.287000', 100, 'N', 'b6b51937-a466-44b7-b761-0f3e156499ec');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '173a691b-ba89-4987-9216-9b3f0a60c864'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:07:59.779000', 100, '2021-07-13 12:07:59.779000', 100, 'N', '071ec8e2-fb4c-4b9f-a31f-5318553ed63f');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:08:12.437000', 100, '2021-07-13 12:08:12.437000', 100, 'N', '927853b5-c616-4646-9a99-f246b7d2bc3a');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:10:30.642000', 100, '2021-07-13 12:10:30.642000', 100, 'N', '3516b19b-82c6-4f24-bf97-51d0c9ddb617');
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2021-07-13 12:10:45.134000', 100, '2021-07-13 12:10:45.134000', 100, 'N', '8790d2af-2df2-4e12-8e4e-ca1f968538fa');

--ref-list for role
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES (1000085, 0, 0, 'Y', '2021-07-13 12:57:23.625000', 100, '2021-07-13 12:57:23.625000', 100, 'M', 'Clinic User', 'A single-person clinic admin role added to new clients', (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'), null, null, 'U', '09992ea0-fed9-4202-a0b9-a40754480a1f', null, null);

-- setup default included roles for role
INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT MAX(bh_defaultincludedrole_id) + 1 from bh_defaultincludedrole), '6ce120d4-caeb-411a-9fb9-5ece9cfca1f1', '2021-07-13 13:12:35.630000', 100, 'M', null, 'Y', null, '2021-07-13 13:12:35.630000', 100, (SELECT ad_role_id FROM ad_role where ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'));
INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT MAX(bh_defaultincludedrole_id) + 1 from bh_defaultincludedrole), '868c8c6e-83c2-45e6-8056-34b2571689bd', '2021-07-13 13:12:49.359000', 100, 'M', null, 'Y', null, '2021-07-13 13:12:49.359000', 100, (SELECT ad_role_id FROM ad_role where ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'));

SELECT register_migration_script('202107131737_GO-1703.sql') FROM dual;
