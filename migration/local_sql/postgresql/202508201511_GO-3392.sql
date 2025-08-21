-- Add Registration role
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
VALUES ((SELECT MAX(ad_role_id)+1 FROM ad_role), 0, 0, 'Y', '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 'Registration', 100,
        'Registration role for patient registration and management', 'S  ', null, 0, null, 'Y', 'N', 'N', 'N', 'Y', 'Y', null, 'N', 'N', 'N', 'O', 'N', 'N', null,
        0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', 0, 0,
        'a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'N', 'Y', 'Y', null, 'N', null);

-- Add window access for Patient page with deactivate permission
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'Y',
                            'b2c3d4e5-f6a7-8901-bcde-f23456789012', 'Y');

-- Add window access for Products & Prices with readonly permission
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
                            'c3d4e5f6-a7b8-9012-cdef-345678901234', 'N');

-- Add window access for Services & Prices with readonly permission
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
                            'd4e5f6a7-b8c9-0123-defa-456789012345', 'N');

-- Add window access for Patient Tags with readonly permission
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
                            'd5e6f7a8-b9c0-1234-efab-567890123456', 'N');

-- Add window access for Visits/Bills with create/edit permission
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'Y',
                            'e5f6a7b8-c9d0-1234-efab-567890123456', 'N');

-- Add process access for Receipt
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
        'a9b0c1d2-e3f4-5678-abcd-901234567890');

-- Add process access for Visit Invoice
INSERT INTO ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
                               updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES ((SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'),
        (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 0, 0, 'Y',
        '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
        'b0c1d2e3-f4a5-6789-bcde-012345678901');

-- Add it to existing clients
SELECT
	add_roles_to_clients('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'W');

SELECT 
	register_migration_script('202508201511_GO-3392.sql')
FROM dual;
