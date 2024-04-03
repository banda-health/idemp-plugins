-- Give every admin in every client access to the new Inventory/Pharmacy Basic role as well
INSERT INTO ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_user_roles_uu)
SELECT ur.ad_user_id, invrole.ad_role_id, ur.ad_client_id, ur.ad_org_id, 'Y', '2024-02-20 14:52:12.079000', 100, '2024-02-20 14:52:12.079000', 100, uuid_generate_v4()
FROM ad_user_roles ur
JOIN ad_role adminrole
	ON adminrole.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = adminrole.ad_client_id
JOIN ad_role invrole
	ON invrole.name = c.name || ' Inventory/Pharmacy Basic'
JOIN ad_user u
    ON u.ad_user_id = ur.ad_user_id
WHERE adminrole.name = c.name || ' Admin'
  AND c.isactive = 'Y'
  AND ur.isactive = 'Y'
  AND u.isactive = 'Y'
ON CONFLICT DO NOTHING;

SELECT register_migration_script('202402201450_GO-2746.sql') FROM dual;
