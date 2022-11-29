/********************************************************************************/
-- For some reason, some storage on hand rows still share ASIs with the same
-- locator and have negative quantities. This script fixes that.
--
-- NB: Since some clients have multiple warehouses, this will move storage
-- around and the potential exists for some clients to now have storage in the
-- wrong place. We mitigate this risk by updating the storage of whatever was
-- received most recently and, if there's a tie, whatever was updated most
-- recently.
/********************************************************************************/

-- Get products that share ASIs but some storage rows with qty < 0 for the ASI
DROP TABLE IF EXISTS tmp_storageonhand_to_update;
SELECT
	counts.m_product_id,
	counts.m_attributesetinstance_id,
	counts.totalqty,
	mmp.m_storageonhand_uu
INTO TEMP TABLE
	tmp_storageonhand_to_update
FROM
	(
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			SUM(qtyonhand) AS totalqty
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_attributesetinstance_id
	) counts
		JOIN (
		SELECT m_product_id, m_attributesetinstance_id FROM m_storageonhand WHERE qtyonhand < 0
	) swnq -- storage_with_negative_quantity
			ON counts.m_product_id = swnq.m_product_id AND
			   counts.m_attributesetinstance_id = swnq.m_attributesetinstance_id
		JOIN (
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			m_storageonhand_uu,
					ROW_NUMBER()
					OVER (PARTITION BY m_product_id,m_attributesetInstance_id ORDER BY datematerialpolicy DESC, created DESC) AS row_num
		FROM
			m_storageonhand
	) mmp -- max_material_policy
			ON mmp.m_product_id = counts.m_product_id AND mmp.m_attributesetinstance_id = counts.m_attributesetinstance_id AND
			   mmp.row_num = 1;

-- Take the total and store it on the row with the most recent material policy
UPDATE m_storageonhand soh
SET
	qtyonhand = tsohtu.totalqty
FROM
	tmp_storageonhand_to_update tsohtu
WHERE
	soh.m_storageonhand_uu = tsohtu.m_storageonhand_uu;

-- Set all other rows = 0 for the product and ASI
UPDATE m_storageonhand soh
SET
	qtyonhand = 0
FROM
	tmp_storageonhand_to_update tsohtu
WHERE
	soh.m_storageonhand_uu != tsohtu.m_storageonhand_uu
	AND soh.m_product_id = tsohtu.m_product_id
	AND soh.m_attributesetinstance_id = tsohtu.m_attributesetinstance_id;

-- Delete records where the date created was over a month ago and that have zero quantity
DELETE
FROM
	m_storageonhand soh
	USING m_attributesetinstance asi
WHERE
	soh.m_attributesetinstance_id = asi.m_attributesetinstance_id
	AND qtyonhand = 0
	AND (soh.created < 'now'::timestamp - '1 month'::interval OR asi.serno = '100');

SELECT register_migration_script('202206161343_GO-2353.sql') FROM dual;
