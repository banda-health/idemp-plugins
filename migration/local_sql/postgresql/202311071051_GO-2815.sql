-- Historical manually created roles didn't always get set correctly, so we need to update them
UPDATE ad_role r
SET
	isaccessadvanced = 'N'
FROM
	ad_client c
WHERE
	r.ad_client_id = c.ad_client_id
	AND isaccessadvanced = 'Y'
	AND ismasterrole = 'N'
	AND r.ad_client_id NOT IN (0, 11)
	AND r.name NOT IN (c.name || ' Admin', c.name || ' User');

SELECT
	register_migration_script('202311071051_GO-2815.sql')
FROM
	dual;
