-- We only want to run this script if we're in a PROD system
DO
$$
	BEGIN
		IF EXISTS (
			SELECT *
			FROM ad_system
			WHERE systemstatus = 'P'
		) THEN
			/**********************************************************************************************************/
			-- Add new system configurations to hide data displayed
			/**********************************************************************************************************/
			INSERT INTO
				ad_sysconfig (ad_sysconfig_id, ad_client_id, ad_org_id, created, updated, createdby, updatedby, isactive, name,
				              value, description, entitytype, configurationlevel, ad_sysconfig_uu)
			VALUES
				((
					 SELECT MAX(ad_sysconfig_id) + 1
					 FROM ad_sysconfig
				 ), 0, 0, '2024-03-19 15:32:25.124000', '2024-03-19 15:32:25.124000', 100, 100, 'Y',
				 'APPLICATION_MAIN_VERSION_SHOWN', 'false', NULL, 'U', 'S', 'b510ddc0-1c5d-499e-b03a-cd5b912d0d18');
			INSERT INTO
				ad_sysconfig (ad_sysconfig_id, ad_client_id, ad_org_id, created, updated, createdby, updatedby, isactive, name,
				              value, description, entitytype, configurationlevel, ad_sysconfig_uu)
			VALUES
				((
					 SELECT MAX(ad_sysconfig_id) + 1
					 FROM ad_sysconfig
				 ), 0, 0, '2024-03-19 15:46:57.093000', '2024-03-19 15:46:57.093000', 100, 100, 'Y',
				 'APPLICATION_IMPLEMENTATION_VENDOR_SHOWN', 'false', NULL, 'U', 'S', 'dfb8f85f-745f-4dd6-92b6-db61a76c98cc');

		END IF;

	END
$$ LANGUAGE plpgsql;

SELECT
	register_migration_script('202403201110_GO-2887.sql')
FROM
	dual;
