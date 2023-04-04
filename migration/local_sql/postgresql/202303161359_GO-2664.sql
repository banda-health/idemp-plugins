-- Add a configuration value so we can use when incrementally rolling out new features
INSERT INTO
	ad_sysconfig (ad_sysconfig_id, ad_client_id, ad_org_id, created, updated, createdby, updatedby, isactive, name, value,
	              description, entitytype, configurationlevel, ad_sysconfig_uu)
VALUES
	((
		 SELECT MAX(ad_sysconfig_id) + 1
		 FROM ad_sysconfig
	 ), 0, 0, '2023-03-16 19:00:09.399591', '2023-03-16 19:00:09.399591', 100, 100, 'Y',
	 'NEW_FEATURE_ROLLOUT_ALLOW_FOR_CLIENTS', 'N', 'Allow clients with the following UUID to use this new feature', 'U',
	 NULL, '552493d0-c725-4dd0-bbb0-52d5e07deb91');

SELECT
	register_migration_script('202303161359_GO-2664.sql')
FROM
	dual;
