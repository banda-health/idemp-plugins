-- Update the field to be displayed
UPDATE ad_field SET SeqNoGrid = 175 WHERE ad_field_id = 56624;

-- Ensure the logo field is at the end
UPDATE ad_field SET SeqNo = 180, SeqNoGrid = 180 WHERE ad_field_id = 57532;

SELECT register_migration_script('202104271402_GO-1588.sql') FROM dual;
