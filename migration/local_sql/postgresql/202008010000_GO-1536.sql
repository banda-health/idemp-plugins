DO
$$
	BEGIN
		IF EXISTS(SELECT * FROM ad_migrationscript WHERE name = '202009011159_SYSTEM_BandaTables.sql') THEN
			UPDATE ad_migrationscript
			SET
				name     = '202008011159_SYSTEM_BandaTables.sql',
				filename = 'postgresql/202008011159_SYSTEM_BandaTables.sql'
			WHERE
				name = '202009011159_SYSTEM_BandaTables.sql';
			
			UPDATE ad_migrationscript
			SET
				name     = '202008011200_GO-1536_BandaDBInit.sql',
				filename = 'postgresql/202008011200_GO-1536_BandaDBInit.sql'
			WHERE
				name = '202009011200_GO-1536_BandaDBInit.sql';
			
			UPDATE ad_migrationscript
			SET
				name     = '202008011201_Galmi-Sync.sql',
				filename = 'postgresql/202008011201_Galmi-Sync.sql'
			WHERE
				name = '202009011201_Galmi-Sync.sql';
		END IF;
	END
$$;

SELECT register_migration_script('202008010000_GO-1536.sql') FROM dual;
