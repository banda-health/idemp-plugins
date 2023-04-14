-- Add the dashboard to the clinic admins
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-06-14 03:59:27.541000', 100, '2022-06-14 03:59:27.541000', 100, 'Y', 'dd129995-23f5-4c96-8d64-6913dea0a88a', 'Y') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202206140353_GO-2156.sql') FROM dual;
