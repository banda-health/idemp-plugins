ALTER TABLE BH_CODED_DIAGNOSIS RENAME COLUMN bh_ceilname TO bh_cielname;

SELECT register_migration_script('202107281600_GO-1777.sql') FROM dual;
