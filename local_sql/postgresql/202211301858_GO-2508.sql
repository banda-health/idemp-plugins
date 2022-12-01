-- Update payment rules of the OTC business partners to be credit
UPDATE c_bpartner
SET
	paymentrule    = 'P', -- on credit
	socreditstatus = 'X'  -- no credit check
WHERE
	ad_client_id > 999999;

SELECT
	register_migration_script('202211301858_GO-2508.sql')
FROM
	dual;
