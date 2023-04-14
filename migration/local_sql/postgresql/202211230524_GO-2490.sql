-- Update document numbers that aren't automatically updated...
UPDATE ad_sequence s
SET
	currentnext = t.value
FROM
	(
		SELECT
			ad_client_id,
			MAX(value::numeric) + 1 AS value
		FROM
			c_bpartner
		WHERE
			isnumeric(value)
			AND ad_client_id > 999999
		GROUP BY ad_client_id
	) t
WHERE
	t.value > 1000000
	AND s.name = 'DocumentNo_C_BPartner'
	AND s.ad_client_id = t.ad_client_id;

SELECT
	register_migration_script('202211230524_GO-2490.sql')
FROM
	dual;
