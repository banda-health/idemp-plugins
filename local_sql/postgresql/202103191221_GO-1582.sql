alter table ad_package_imp alter column name type varchar(200) using name::varchar(200);
UPDATE ad_column SET fieldlength = 200 WHERE ad_column_uu = '80d618f8-7847-4ab6-810e-b6b1d4611546';

alter table ad_package_imp_proc alter column name type varchar(200) using name::varchar(200);
UPDATE ad_column SET fieldlength = 200 WHERE ad_column_uu = '9165c781-852e-4479-9a1f-7976c560b5ec';

UPDATE ad_package_imp SET name = '202011231735_SYSTEM_TabNavigationButtonTranslations-1.0.0.zip' WHERE name = '202011231735_SYSTEM_TabNavigationButtonTranslations-1.0.0.zi';
UPDATE ad_package_imp_proc SET name = '202011231735_SYSTEM_TabNavigationButtonTranslations-1.0.0.zip' WHERE name = '202011231735_SYSTEM_TabNavigationButtonTranslations-1.0.0.zi';

SELECT register_migration_script('202103191221_GO-1582.sql') FROM dual;
