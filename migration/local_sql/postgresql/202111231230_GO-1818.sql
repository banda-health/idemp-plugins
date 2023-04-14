-- give readwrite and deactivate ability to `clinical admin` for `Users` window
UPDATE ad_window_access
SET isreadwrite = 'Y', bh_candeactivate = 'Y'
WHERE ad_window_id = (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '6b934ec2-7f45-4104-ba10-08e3ce54de7e')
AND ad_role_id = (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685');


SELECT register_migration_script('202111231230_GO-1818.sql') FROM dual;