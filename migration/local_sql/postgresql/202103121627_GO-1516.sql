-- For all default users that aren't Admin on a client, they need to be set to manual (so that access doesn't get overridden)
UPDATE ad_role r
SET ismanual = 'Y'
FROM ad_client c
CROSS JOIN ad_ref_list rl
JOIN ad_reference ref
	ON ref.ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'
WHERE c.ad_client_id = r.ad_client_id
	AND rl.value != 'A'
	AND r.name = c.name || ' ' || rl.name;

SELECT register_migration_script('202103121627_GO-1516.sql') FROM dual;
