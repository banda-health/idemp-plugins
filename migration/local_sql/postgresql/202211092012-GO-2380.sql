-- Add a configuration value so we can make the errored orders process with the most recent first
INSERT INTO
	ad_sysconfig (ad_sysconfig_id, ad_client_id, ad_org_id, created, updated, createdby, updatedby, isactive, name, value,
	              description, entitytype, configurationlevel, ad_sysconfig_uu)
VALUES
	((
		 SELECT MAX(ad_sysconfig_id) + 1
		 FROM ad_sysconfig
	 ), 0, 0, '2022-11-10 05:18:22.384000', '2022-11-10 05:18:27.795000', 100, 100, 'Y',
	 'AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST', 'N',
	 'Make the order auto-completion process start with most recent visits first (instead of oldest)', 'U', NULL,
	 '6b515a7b-2c38-4ef9-a39e-366b902f4bd9');

SELECT
	register_migration_script('202211092012-GO-2380.sql')
FROM
	dual;
