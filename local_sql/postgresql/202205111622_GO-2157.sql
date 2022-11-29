-- Update the bh_labnotes column to be on the c_order table
UPDATE ad_column SET ad_table_id = 259 WHERE ad_column_uu = '2abb34f8-4224-4139-aae7-cac33a606be3';

SELECT register_migration_script('202205111622_GO-2157.sql') FROM dual;