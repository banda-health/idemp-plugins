-- Enable the encryption extension
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Insert salts to be used for hashing the passwords
UPDATE
    ad_user adu
SET
    salt = gen_salt.salt
FROM 
    (
    SELECT
        ad_user_id,
        substr(md5(random()::text), 1, 16) AS salt
    FROM
        ad_user
    WHERE
        ad_user_id IN (
                        SELECT
                            ad_user_id
                        FROM ad_user
                        WHERE name IN ('Configuration User', 'Configuration Admin','GardenUser',
                                      'GardenAdmin','System','WebService')
                                       AND salt IS NULL)
) gen_salt
WHERE adu.ad_user_id = gen_salt.ad_user_id;

-- Hash the plain text passwords
UPDATE
    ad_user adu
SET
    password = gen_hash.hashed_password
FROM 
    (
    SELECT
        ad_user_id,
        encode(digest(salt || password,'sha256'),'hex') AS hashed_password
    FROM
        ad_user
    WHERE
        ad_user_id IN (
                        SELECT
                            ad_user_id
                        FROM ad_user
                        WHERE name IN ('Configuration User', 'Configuration Admin','GardenUser',
                                      'GardenAdmin','System','WebService'))
) gen_hash
WHERE adu.ad_user_id = gen_hash.ad_user_id;

SELECT
	register_migration_script('202402061520_GO-2894.sql')
FROM
	dual;
