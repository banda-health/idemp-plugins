-- Ensure the update reason can be set for this column (on table c_order)
UPDATE ad_column SET isupdateable = 'Y' WHERE ad_column_uu = '321de5a1-9c73-489b-a9b8-a2fe6d6c3695';

SELECT register_migration_script('202207190432_GO-2389.sql') FROM dual;
