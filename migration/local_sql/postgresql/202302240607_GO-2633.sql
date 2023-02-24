-- Get the SOH records that should be kept (we want the ASI, locator, and product to be unique in the SOH table)
SELECT
	m_product_id,
	m_locator_id,
	m_attributesetinstance_id,
	MAX(datematerialpolicy) AS datematerialpolicy
INTO TEMP TABLE
	tmp_soh_to_keep
FROM
	m_storageonhand
GROUP BY
	m_product_id, m_locator_id, m_attributesetinstance_id;

-- Update the most recent SOH quantity where there are duplicate rows for ASI, locator, and product
UPDATE m_storageonhand soh
SET
	qtyonhand = sums.qtyonhand
FROM
	(
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id,
			MAX(datematerialpolicy) AS datematerialpolicy,
			SUM(qtyonhand)          AS qtyonhand
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
		HAVING
			COUNT(*) > 1
	) sums
WHERE
	soh.datematerialpolicy = sums.datematerialpolicy
	AND soh.m_product_id = sums.m_product_id
	AND soh.m_locator_id = sums.m_locator_id
	AND soh.m_attributesetinstance_id = sums.m_attributesetinstance_id;

-- Delete the duplicate records that aren't the most recent
DELETE
FROM
	m_storageonhand soh
	USING (
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
		HAVING
			COUNT(*) > 1
	) dups
		CROSS JOIN tmp_soh_to_keep soh_to_keep
WHERE
	soh.datematerialpolicy != soh_to_keep.datematerialpolicy
	AND soh.m_product_id = dups.m_product_id
	AND soh.m_locator_id = dups.m_locator_id
	AND soh.m_attributesetinstance_id = dups.m_attributesetinstance_id
	AND soh.m_product_id = soh_to_keep.m_product_id
	AND soh.m_locator_id = soh_to_keep.m_locator_id
	AND soh.m_attributesetinstance_id = soh_to_keep.m_attributesetinstance_id;

SELECT
	register_migration_script('202302240607_GO-2633.sql')
FROM
	dual;
