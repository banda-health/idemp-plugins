UPDATE ad_column SET valuemin = NULL WHERE ad_column_uu = '678036a0-8ee1-48f3-a0f8-bc64c1439d7a';

SELECT register_migration_script('202103171755_GO-1574.sql') FROM dual;
