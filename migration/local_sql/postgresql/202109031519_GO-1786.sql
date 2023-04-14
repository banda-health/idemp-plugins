-- visit sent to dropdown labels --
UPDATE ad_ref_list SET name = 'Clinician' WHERE ad_ref_list_uu = 'e74d5f99-fd01-4d54-ab35-7a630c43f064';
UPDATE ad_ref_list_trl SET name = 'Clinician' WHERE ad_ref_list_id  = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'e74d5f99-fd01-4d54-ab35-7a630c43f064');

UPDATE ad_ref_list SET name = 'Lab' WHERE ad_ref_list_uu = 'e3eace1e-ee22-409b-a7ae-09cee5350b91';
UPDATE ad_ref_list_trl SET name = 'Lab' WHERE ad_ref_list_id  = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'e3eace1e-ee22-409b-a7ae-09cee5350b91');

UPDATE ad_ref_list SET name = 'Pharmacy' WHERE ad_ref_list_uu = '24c32cc4-3fdb-4448-85a5-879eea7866ea';
UPDATE ad_ref_list_trl SET name = 'Pharmacy' WHERE ad_ref_list_id  = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '24c32cc4-3fdb-4448-85a5-879eea7866ea');

UPDATE ad_ref_list SET name = 'Cashier' WHERE ad_ref_list_uu = 'fed0d4f4-4eb2-478c-beb4-9570a8da06bf';
UPDATE ad_ref_list_trl SET name = 'Cashier' WHERE ad_ref_list_id  = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'fed0d4f4-4eb2-478c-beb4-9570a8da06bf');

SELECT register_migration_script('202109031519_GO-1786.sql') FROM dual;