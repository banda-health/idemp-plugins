-- Revert the iDempiere theme back to the default, as we are removing our Banda Health webui plugin
UPDATE 
    ad_sysconfig 
SET 
    value='default'
WHERE
    ad_sysconfig.name='ZK_THEME';

SELECT
	register_migration_script('202402141121_GO-2889.sql')
FROM
	dual;
