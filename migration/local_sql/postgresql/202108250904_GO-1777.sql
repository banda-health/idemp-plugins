UPDATE ad_element SET name = 'bh_cielname', printname = 'bh_cielname', columnname = 'bh_cielname' WHERE columnname = 'bh_ceilname';

UPDATE ad_column SET name = 'bh_cielname', columnname = 'bh_cielname' WHERE columnname = 'bh_ceilname';

SELECT register_migration_script('202108250904_GO-1777.sql') FROM dual;
