-- GO-3618: Speed up login user lookup (Login.getClients uses COALESCE(LDAPUser, Name))
CREATE INDEX IF NOT EXISTS ad_user_coalesce_login_name
	ON ad_user (COALESCE(ldapuser, name), ad_client_id)
	WHERE isactive = 'Y' AND password IS NOT NULL;

SELECT
	register_migration_script('202606161530_GO-3618.sql')
FROM
	dual;
