-- Ensure products without expiration don't have the expiration attribute set assigned
UPDATE m_product SET m_attributeset_id = NULL, m_attributesetinstance_id = 0 WHERE bh_hasexpiration = 'N' AND ad_client_id > 999999;

-- Ensure products with an expiration have the expiration attribute set assigned
UPDATE m_product p
SET m_attributeset_id = attr.m_attributeset_id, m_attributesetinstance_id = 0
FROM m_attributeset attr
WHERE p.ad_client_id = attr.ad_client_id
	AND attr.name = 'BandaHealthProductAttributeSet'
	AND p.bh_hasexpiration = 'Y'
	AND p.ad_client_id > 999999
	AND p.m_attributeset_id IS NULL;

-- Remove storage on hand records that have no expiration for products with expiration
DELETE FROM m_storageonhand soh
USING m_product p
WHERE p.m_product_id = soh.m_product_id
	AND p.bh_hasexpiration = 'Y'
	AND soh.m_attributesetinstance_id = 0;

SELECT register_migration_script('202110191942_GO-1933.sql') FROM dual;
