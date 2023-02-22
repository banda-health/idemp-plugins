-- Remove duplicate SOH records
DELETE
FROM
	m_storageonhand soh
	USING (
		SELECT
			soh.m_product_id,
			soh.m_locator_id,
			soh.m_attributesetinstance_id,
			qtyonhand
		FROM
			m_storageonhand soh
				JOIN m_attributesetinstance asi
					ON soh.m_attributesetinstance_id = asi.m_attributesetinstance_id
		GROUP BY soh.m_product_id, soh.m_locator_id, soh.m_attributesetinstance_id, soh.qtyonhand
		HAVING
				COUNT(*) > 1
	) dups
		CROSS JOIN (
			SELECT
				m_product_id,
				m_locator_id,
				m_attributesetinstance_id,
				qtyonhand,
				MAX(datematerialpolicy) AS datematerialpolicy
			FROM
				m_storageonhand
			GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id, qtyonhand
		) soh_to_keep
WHERE
		soh.datematerialpolicy != soh_to_keep.datematerialpolicy
	AND soh.m_product_id = dups.m_product_id
	AND soh.m_locator_id = dups.m_locator_id
	AND soh.m_attributesetinstance_id = dups.m_attributesetinstance_id
	AND soh.qtyonhand = dups.qtyonhand
	AND soh.m_product_id = soh_to_keep.m_product_id
	AND soh.m_locator_id = soh_to_keep.m_locator_id
	AND soh.m_attributesetinstance_id = soh_to_keep.m_attributesetinstance_id;

SELECT
	register_migration_script('202302220717_GO-2633.sql')
FROM
	dual;
