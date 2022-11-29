-- give inventory/pharmacy write access
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window where ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'), (select ad_role_id FROM ad_role where ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2021-11-25 08:48:23.861206', 100, '2021-11-25 08:48:23.861206', 100, 'Y', '	411e-8e83-029a54767db4', 'Y') ON CONFLICT DO NOTHING;

-- give clinic admin write access
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2021-11-25 08:48:23.861206', 100, '2021-11-25 08:48:23.861206', 100, 'Y', '98ea7301-3e65-472b-8910-13b014f67e45', 'Y') ON CONFLICT DO NOTHING;


SELECT register_migration_script('202111251111_GO-1806.sql') FROM dual;
