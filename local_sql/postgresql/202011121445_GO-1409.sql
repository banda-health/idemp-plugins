-- Update the appropriate users and set their roles to the normal user, not the Advanced
UPDATE aur
SET aur.ad_role_id = ar2.ad_role_id
FROM ad_user au
JOIN ad_client ac
    ON au.ad_client_id = ac.ad_client_id
JOIN ad_user_roles aur
    ON au.ad_user_id = aur.ad_user_id
JOIN ad_role ar
    ON aur.ad_role_id = ar.ad_role_id
JOIN ad_role ar2
    ON ar.ad_client_id = ar2.ad_client_id
        AND ar2.name = ac.name || ' User'
WHERE au.ad_user_id IN (1018279);

SELECT register_migration_script('202011121445_GO-1409.sql') FROM dual;
