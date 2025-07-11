-- Give other roles access
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby,
                              isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT (select ad_window_id from ad_window where ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'),
       ad_role_id,
       0,
       0,
       'Y',
       NOW(),
       100,
       NOW(),
       100,
       'Y',
       uuid_generate_v4(),
       'Y'
FROM ad_role r
WHERE r.ismanual = 'N'
ON CONFLICT DO NOTHING;

-- Give read and write access to some users

INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT ad_window_id,
       ad_role_id,
       0,
       0,
       'Y',
       NOW(),
       100,
       NOW(),
       100,
       'Y',
       uuid_generate_v4(),
       'Y'
FROM ad_role r
         JOIN ad_window w
              ON w.ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'
WHERE r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
                       'ec17fee0-a53a-4dbb-b946-423ce14880eb', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
                       'c54253cf-c86b-4aaa-b472-ed8880635c62', 'a1618fd6-e1ab-4e41-a08d-854229cd5971',
                       '17ccea57-1131-4d51-83ca-1824182e4493', '097feff0-3aa6-41fe-bf76-936b03859846');
-- Give only read access
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                              updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT ad_window_id,
       ad_role_id,
       0,
       0,
       'Y',
       NOW(),
       100,
       NOW(),
       100,
       'N',
       uuid_generate_v4(),
       'Y'
FROM ad_role r
         JOIN ad_window w
              ON w.ad_window_uu = 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e'
WHERE r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', '09eb7fc8-9cc5-44b0-9d14-15258a066038',
                       '98617c31-55ff-48f9-bd44-253ef323d960', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a');

SELECT register_migration_script('202506301350_GO-3305.sql')
FROM dual;
