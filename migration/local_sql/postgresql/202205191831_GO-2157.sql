-- Update fields on bh_labnotes column to accept text/long and not boolean type
UPDATE ad_column SET ad_reference_id = 36, fieldlength = 0, defaultvalue = null, ismandatory = 'N' WHERE ad_column_uu = '2abb34f8-4224-4139-aae7-cac33a606be3';

SELECT register_migration_script('202205191831_GO-2157.sql') FROM dual;