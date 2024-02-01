-- Get the list of IDs of records without hashed passwords
SELECT
	ad_password_history_id
INTO TEMP TABLE
	tmp_password_history_ids_to_fix
FROM
	ad_password_history
WHERE
    salt IS NULL;

-- Enable the encryption extension
CREATE EXTENSION pgcrypto;

-- Insert salts to be used for hashing the plain text passwords
UPDATE
    ad_password_history ph
SET
    salt = gen_salt.salt
FROM (
    SELECT
        ad_password_history_id,
        substr(md5(random()::text), 1, 16) AS salt
    FROM
        ad_password_history
    WHERE
        ad_password_history.ad_password_history_id IN (
                                                        SELECT
                                                            ad_password_history_id
                                                        FROM tmp_password_history_ids_to_fix)
) gen_salt
WHERE ph.ad_password_history_id = gen_salt.ad_password_history_id;

-- Hash the plain text passwords
UPDATE
    ad_password_history ph
SET
    password = gen_hash.hashed_password
FROM (
    SELECT
        ad_password_history_id,
        encode(digest(salt || password,'sha256'),'hex') AS hashed_password
    FROM
        ad_password_history
    WHERE
        ad_password_history.ad_password_history_id IN (
                                                        SELECT
                                                            ad_password_history_id
                                                        FROM tmp_password_history_ids_to_fix)
) gen_hash
WHERE ph.ad_password_history_id = gen_hash.ad_password_history_id;

SELECT
	register_migration_script('202401311252_GO-2891.sql')
FROM
	dual;
