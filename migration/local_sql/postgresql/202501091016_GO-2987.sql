-- Add indexes to help with changelog fetching (may remove if this causes INSERT slow-downs)
CREATE INDEX ad_changelog_ad_column_id ON ad_changelog (ad_column_id);
CREATE INDEX ad_changelog_ad_record_id ON ad_changelog (record_id);

SELECT
	register_migration_script('202501091016_GO-2987.sql')
FROM
	dual;
