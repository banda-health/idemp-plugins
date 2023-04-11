-- This is repeat of 202303170724_GO-2633.sql to clean up any remaining things
-- Delete the duplicate records that aren't the most recent
DELETE
FROM
	m_storageonhand soh
	USING (
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id,
			MAX(datematerialpolicy) AS datematerialpolicy
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
		HAVING
				COUNT(*) > 1
	) dups
WHERE
		soh.datematerialpolicy != dups.datematerialpolicy
	AND soh.m_product_id = dups.m_product_id
	AND soh.m_locator_id = dups.m_locator_id
	AND soh.m_attributesetinstance_id = dups.m_attributesetinstance_id;

-- Re-calculate inventory based on what's in m_transaction for certain clients (duplicating 202302091301_GO-2589.sql)
UPDATE m_storageonhand soh
SET
	qtyonhand = sums.qtyonhand
FROM
	(
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id,
			SUM(movementqty) AS qtyonhand
		FROM
			m_transaction
		WHERE
				ad_client_id > 999999
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
	) sums
WHERE
		soh.m_product_id = sums.m_product_id
	AND soh.m_attributesetinstance_id = sums.m_attributesetinstance_id
	AND soh.qtyonhand != sums.qtyonhand
	AND soh.m_locator_id = sums.m_locator_id;

-- Insert storage records that have quantity but aren't in the DB
WITH counts AS (
	SELECT
		m_product_id,
		m_locator_id,
		m_attributesetinstance_id,
		SUM(movementqty) AS qtyonhand
	FROM
		m_transaction
	WHERE
			ad_client_id > 999999
	GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
)
INSERT
INTO
	m_storageonhand (ad_client_id, ad_org_id, created, createdby, datelastinventory, isactive, m_attributesetinstance_id,
	                 m_locator_id, m_product_id, qtyonhand, updated, updatedby, m_storageonhand_uu, datematerialpolicy)
SELECT
	p.ad_client_id,
	o.ad_org_id,
		NOW() - '1 week'::interval,
	100,
	NULL,
	'Y',
	cts.m_attributesetinstance_id,
	cts.m_locator_id,
	cts.m_product_id,
	cts.qtyonhand,
	NOW(),
	100,
	uuid_generate_v4(),
	date(NOW())
FROM
	counts cts
		LEFT JOIN m_storageonhand soh
			ON soh.m_product_id = cts.m_product_id AND soh.m_locator_id = cts.m_locator_id AND
			   soh.m_attributesetinstance_id = cts.m_attributesetinstance_id
		JOIN m_product p
			ON cts.m_product_id = p.m_product_id
		JOIN ad_client c
			ON p.ad_client_id = c.ad_client_id
		JOIN ad_org o
			ON c.ad_client_id = o.ad_client_id
WHERE
	soh.ad_client_id IS NULL
	AND cts.qtyonhand != 0;

SELECT
	register_migration_script('202304041042_GO-2633.sql')
FROM
	dual;
