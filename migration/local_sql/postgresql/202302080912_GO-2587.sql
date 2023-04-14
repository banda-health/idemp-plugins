-- Update payment terms for incorrectly mapped BPs
UPDATE c_bpartner bp
SET
	c_paymentterm_id = client_pt.c_paymentterm_id
FROM
	c_paymentterm config_pt
		JOIN c_paymentterm client_pt
			ON config_pt.name = client_pt.name
WHERE
	config_pt.ad_client_id = 2
	AND bp.c_paymentterm_id = config_pt.c_paymentterm_id
	AND client_pt.ad_client_id = bp.ad_client_id
	AND bp.ad_client_id NOT IN (1, 2);

SELECT
	register_migration_script('202302080912_GO-2587.sql')
FROM
	dual;
