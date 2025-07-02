-- Add OTC only role
INSERT INTO ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby,
                     description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct,
                     ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc,
                     isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess,
                     ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account,
                     allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout,
                     allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource,
                     allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice,
                     isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand,
                     ismasterrole, isaccessadvanced, roletype, isclientadministrator, predefinedcontextvariables)
VALUES ((SELECT MAX(ad_role_id)+1 FROM ad_role), 0, 0, 'Y', '2025-07-02 12:15:59.872000', 100, '2025-07-02 12:15:59.872000', 'OTC only', 100,
        'OTC only role', 'S  ', null, 0, null, 'Y', 'N', 'N', 'N', 'Y', 'Y', null, 'N', 'N', 'N', 'O', 'N', 'N', null,
        0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', 0, 0,
        'b986f846-09bc-461e-956a-e524fd75aa8a', 'N', 'Y', 'Y', null, 'N', null);  
        
-- Add window access        
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:18:58.850000', 100, '2025-07-02 12:18:58.850000', 100, 'Y',
        '11d9645c-1dd0-463f-b557-cdfa17dcf928', 'Y');
        
-- Add process (reports) access
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:26:05.384000', 100, '2025-07-02 12:26:05.384000', 100, 'Y',
        '409bae91-1e5e-4565-8830-9c389c0e61be');

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:26:21.132000', 100, '2025-07-02 12:26:21.132000', 100, 'Y',
        'f2be0a81-76d8-4e45-a136-27a66521d6fd');

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:26:42.705000', 100, '2025-07-02 12:26:42.705000', 100, 'Y',
        '4935d547-f03c-4fb0-8b0e-fb57c13732c0');

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:26:56.860000', 100, '2025-07-02 12:26:56.860000', 100, 'Y',
        '366f4cd7-84d2-4f4e-a97a-5664c4b6e4ec');

INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y',
        '2025-07-02 12:34:51.919000', 100, '2025-07-02 12:34:51.919000', 100, 'Y',
        'b7a71264-7d0f-4dd7-ad40-64fab1b4e411');
        
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), 
		(SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y', 
		'2025-07-02 14:55:31.531000', 100, '2025-07-02 14:55:31.531000', 100, 'Y',
        'd2ff7c44-08dd-455f-8d07-209bb4fe641e');     
        
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84'), 
		(SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b986f846-09bc-461e-956a-e524fd75aa8a'), 0, 0, 'Y', 
		'2025-07-02 14:59:15.519000', 100, '2025-07-02 14:59:15.519000', 100, 'Y',
        '9706fa01-af8c-4d1e-b05f-66fe88eed962');        
        
-- Add it to existing clients
SELECT
	add_roles_to_clients('b986f846-09bc-461e-956a-e524fd75aa8a', 'O');        

SELECT 
	register_migration_script('202508021146_GO-3343.sql')
FROM dual;
