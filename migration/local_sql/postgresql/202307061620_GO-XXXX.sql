-- Issue: Some of the ad_org_id values do not match with ad_client_id values hence causing issues on the m_transaction Table
-- Solution: Update all the ad_client_id columns to match the ad_org_id column on m_transaction where the two do not match
UPDATE m_transaction
SET
    ad_client_id = ad_org_id
WHERE
        ad_client_id IN (
        SELECT DISTINCT
            ad_client_id
        FROM
            m_transaction
        WHERE
            ad_client_id <> ad_org_id
    );

-- Finishing Up
-- Named as go-XXXX for now since YouTrack is down and we don't have an issue created for this
SELECT
    register_migration_script('202307061620_GO-XXXX.sql')
FROM
    dual;