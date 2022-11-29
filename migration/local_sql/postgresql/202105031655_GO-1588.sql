-- Ensure the field added for the receipt footer isn't marked as translated (because there isn't an associated translation table)
UPDATE ad_column SET istranslated = 'N' WHERE ad_column_uu = '3f5dbee3-9af8-4049-b6c6-f9262622d999';

SELECT register_migration_script('202105031655_GO-1588.sql') FROM dual;
