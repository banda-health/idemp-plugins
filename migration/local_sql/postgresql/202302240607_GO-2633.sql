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
				ad_client_id IN (
				SELECT
					ad_client_id
				FROM
					ad_client
				WHERE
						ad_client_uu IN ('6a4dfa2c-a606-4aca-8507-8d975d275e2a', '0b5e6a75-7bd2-4218-8b91-c065b1f07c12',
						                 'c8c60e1d-8245-436c-850d-31162ddcbb79', 'f89f0631-d3f2-43f4-be1b-b1f3e029dfd4',
						                 '91415776-1b63-457c-b3f9-fe09696facca')
			)
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
	) sums
WHERE
	soh.m_product_id = sums.m_product_id
	AND soh.m_attributesetinstance_id = sums.m_attributesetinstance_id
	AND soh.qtyonhand != sums.qtyonhand
	AND soh.m_locator_id = sums.m_locator_id;

SELECT
	register_migration_script('202302240607_GO-2633.sql')
FROM
	dual;
