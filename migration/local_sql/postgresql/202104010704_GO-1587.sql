-- Create new column
UPDATE ad_orginfo SET ReceiptFooterMsg = 'Get Well Soon' WHERE ReceiptFooterMsg IS NULL;

-- Update the column
UPDATE ad_column SET updated = '2021-04-01 07:23:35.403000', defaultvalue = NULL, ismandatory = 'N', istranslated = 'Y' WHERE ad_column_id = 52112;

-- Update the field to be displayed
UPDATE ad_field SET updated = '2021-04-01 07:20:47.603000', isdisplayed = 'Y', seqno = 175 WHERE ad_field_id = 56624;

SELECT register_migration_script('202104010704_GO-1587.sql') FROM dual;
