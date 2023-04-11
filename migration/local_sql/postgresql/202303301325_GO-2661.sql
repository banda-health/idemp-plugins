-- Fix bad org stuff for Galmi
UPDATE c_allocationhdr
SET
	ad_org_id = 1000000
WHERE
		ad_client_id = 1000000
	AND ad_org_id = 1000001;
UPDATE c_allocationline
SET
	ad_org_id = 1000000
WHERE
		ad_client_id = 1000000
	AND ad_org_id = 1000001;
UPDATE fact_acct
SET
	ad_org_id = 1000000
WHERE
		ad_client_id = 1000000
	AND ad_org_id = 1000001;

SELECT
	register_migration_script('202303301325_GO-2661.sql')
FROM
	dual;
