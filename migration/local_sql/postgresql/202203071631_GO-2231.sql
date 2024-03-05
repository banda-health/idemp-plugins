DROP TABLE IF EXISTS tmp_m_attributesetinstance_ids_to_delete;
DROP TABLE IF EXISTS tmp_storage_updates;

-- Get the attribute set instances we need to delete (will have NULL guarantee date)
SELECT asi.m_attributesetinstance_id
INTO TEMP tmp_m_attributesetinstance_ids_to_delete
FROM m_attributesetinstance asi
	JOIN m_attributeset atset ON asi.m_attributeset_id = atset.m_attributeset_id
WHERE atset.name = 'BandaHealthProductAttributeSet'
	AND asi.guaranteedate IS NULL
	AND asi.ad_client_id > 999999;

/**********************************************************************************************************/
-- When actually deploying this, we dropped constraints and then re-added them. But, as iDempiere grows,
-- the number of constraints continues to grow. To avoid having to continually adjust this, we'll skip
-- it for new DBs since the single transaction won't be that bad
/**********************************************************************************************************/
BEGIN;

	/**********************************************************************************************************/
	-- Update all m_attributesetinstance_ids to delete to have m_attributesetinstance_id 0 (system use for "NO ASI")
	/**********************************************************************************************************/
	UPDATE C_InvoiceLine SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE C_OrderLine SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_CostDetail SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_CostHistory SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_InOutLine SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_InventoryLine SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_InventoryLineMA SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_MatchPO SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_MovementLineMA SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	UPDATE M_Transaction SET m_attributesetinstance_id = 0 WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);

	/**********************************************************************************************************/
	-- For the following tables, we need to update them to point to a 0 ASI only if they don't have a certain combination
	-- (due to the PK being a combination of columns)
	/**********************************************************************************************************/
	-- M_Cost PK Columns: client/org/product/cost element/accounting schema/cost type combinations that don't already have have a 0 ASI
	UPDATE M_Cost SET m_attributesetinstance_id = 0 WHERE m_cost_uu IN (
		SELECT
			max(c1.m_cost_uu)
		FROM m_cost c1
			LEFT JOIN m_cost c2 ON
				c1.ad_client_id = c2.ad_client_id AND
				c1.ad_org_id = c2.ad_org_id AND
				c1.m_product_id = c2.m_product_id AND
				c1.c_acctschema_id = c2.c_acctschema_id AND
				c1.m_costtype_id = c2.m_costtype_id AND
				c1.m_costelement_id = c2.m_costelement_id AND
				c2.m_attributesetinstance_id = 0
		WHERE c1.m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			AND c2.m_attributesetinstance_id IS NULL
		GROUP BY c1.ad_client_id, c1.ad_org_id, c1.m_product_id, c1.c_acctschema_id, c1.m_costtype_id, c1.m_costelement_id
	);

	-- M_InOutLineMA PK columns: m_inoutline_id, m_attributesetinstance_id, datematerialpolicy
	UPDATE M_InOutLineMA SET m_attributesetinstance_id = 0 WHERE m_inoutlinema_uu IN (
		SELECT
			max(iolma1.m_inoutlinema_uu)
		FROM M_InOutLineMA iolma1
			LEFT JOIN M_InOutLineMA iolma2 ON
				iolma1.ad_client_id = iolma2.ad_client_id AND
				iolma1.ad_org_id = iolma2.ad_org_id AND
				iolma1.m_inoutline_id = iolma2.m_inoutline_id AND
				iolma1.datematerialpolicy = iolma2.datematerialpolicy AND
				iolma2.m_attributesetinstance_id = 0
		WHERE iolma1.m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			AND iolma2.m_attributesetinstance_id IS NULL
		GROUP BY iolma1.ad_client_id, iolma1.ad_org_id, iolma1.m_inoutline_id, iolma1.datematerialpolicy
	);
	-- M_StorageOnHand PK columns: m_product_id, m_locator_id, m_attributesetinstance_id, datematerialpolicy
	UPDATE M_StorageOnHand SET m_attributesetinstance_id = 0 WHERE m_storageonhand_uu IN (
		SELECT
			max(soh1.m_storageonhand_uu)
		FROM M_StorageOnHand soh1
			LEFT JOIN M_StorageOnHand soh2 ON
				soh1.m_product_id = soh2.m_product_id AND
				soh1.m_locator_id = soh2.m_locator_id AND
				soh1.datematerialpolicy = soh2.datematerialpolicy AND
				soh2.m_attributesetinstance_id = 0
		WHERE soh1.m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			AND soh2.m_attributesetinstance_id IS NULL
		GROUP BY soh1.m_product_id, soh1.m_locator_id, soh1.datematerialpolicy
	);
	-- M_StorageReservation PK column: m_product_id, m_warehouse_id, issotrx, m_attributesetinstance_id
	UPDATE M_StorageReservation SET m_attributesetinstance_id = 0 WHERE m_storagereservation_uu IN (
		SELECT
			max(sr1.m_storagereservation_uu)
		FROM M_StorageReservation sr1
			LEFT JOIN M_StorageReservation sr2 ON
				sr1.m_product_id = sr2.m_product_id AND
				sr1.m_warehouse_id = sr2.m_warehouse_id AND
				sr1.issotrx = sr2.issotrx AND
				sr2.m_attributesetinstance_id = 0
		WHERE sr1.m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			AND sr2.m_attributesetinstance_id IS NULL
		GROUP BY sr1.m_product_id, sr1.m_warehouse_id, sr1.issotrx
	);

	/**********************************************************************************************************/
	-- For the above tables (M_Cost, M_InOutLineMA, M_StorageOnHand, M_StorageReservation), we need to combine values since
	-- a simple FK update was insufficient
	/**********************************************************************************************************/
	UPDATE m_cost c
	SET
		currentcostprice = t.currentcostprice,
		currentqty = t.currentqty,
		cumulatedamt = t.cumulatedamt,
		cumulatedqty = t.cumulatedqty,
		futurecostprice = t.futurecostprice,
		percent = t.percent,
		currentcostpricell = t.currentcostpricell
	FROM (
		SELECT
			m_product_id,
			c_acctschema_id,
			m_costtype_id,
			m_costelement_id,
			sum(currentcostprice) as currentcostprice,
			sum(currentqty) as currentqty,
			sum(cumulatedamt) as cumulatedamt,
			sum(cumulatedqty) as cumulatedqty,
			sum(futurecostprice) as futurecostprice,
			sum(percent) as percent,
			sum(currentcostpricell) as currentcostpricell
		FROM m_cost
		WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			OR m_attributesetinstance_id = 0
		GROUP BY m_product_id, c_acctschema_id, m_costtype_id, m_costelement_id
	) t
	WHERE t.m_product_id = c.m_product_id
		AND t.c_acctschema_id = c.c_acctschema_id
		AND t.m_costtype_id = c.m_costtype_id
		AND t.m_costelement_id = c.m_costelement_id
		AND c.m_attributesetinstance_id = 0;

	-- PK: m_inoutline_id, m_attributesetinstance_id, datematerialpolicy
	UPDATE M_InOutLineMA iolma
	SET movementqty = t.movementqty
	FROM (
		SELECT
			m_inoutline_id,
			datematerialpolicy,
			sum(movementqty) as movementqty
		FROM M_InOutLineMA
		WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			OR m_attributesetinstance_id = 0
		GROUP BY m_inoutline_id, datematerialpolicy
	) t
	WHERE t.m_inoutline_id = iolma.m_inoutline_id
		AND t.datematerialpolicy = iolma.datematerialpolicy
		AND iolma.m_attributesetinstance_id = 0;

	-- PK columns: m_product_id, m_locator_id, m_attributesetinstance_id, datematerialpolicy
	UPDATE M_StorageOnHand soh
	SET qtyonhand = t.qtyonhand
	FROM (
		SELECT
			m_product_id,
			m_locator_id,
			datematerialpolicy,
			sum(qtyonhand) as qtyonhand
		FROM M_StorageOnHand
		WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			OR m_attributesetinstance_id = 0
		GROUP BY m_product_id, m_locator_id, datematerialpolicy
	) t
	WHERE t.m_product_id = soh.m_product_id
		AND t.m_locator_id = soh.m_locator_id
		AND t.datematerialpolicy = soh.datematerialpolicy
		AND soh.m_attributesetinstance_id = 0;

	-- M_StorageReservation PK column: m_product_id, m_warehouse_id, issotrx, m_attributesetinstance_id
	UPDATE M_StorageReservation soh
	SET qty = t.qty
	FROM (
		SELECT
			m_product_id,
			m_warehouse_id,
			issotrx,
			sum(qty) as qty
		FROM M_StorageReservation
		WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete)
			OR m_attributesetinstance_id = 0
		GROUP BY m_product_id, m_warehouse_id, issotrx
	) t
	WHERE t.m_product_id = soh.m_product_id
		AND t.m_warehouse_id = soh.m_warehouse_id
		AND t.issotrx = soh.issotrx
		AND soh.m_attributesetinstance_id = 0;

	/**********************************************************************************************************/
	-- Delete the ASIs that shouldn't be there
	/**********************************************************************************************************/
	DELETE FROM C_InvoiceLine WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM C_OrderLine WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_Cost WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_CostDetail WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_CostHistory WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_InOutLine WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_InOutLineMA WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_InventoryLine WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_InventoryLineMA WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_MatchPO WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_MovementLineMA WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_StorageOnHand WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_StorageReservation WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_Transaction WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);
	DELETE FROM M_AttributeSetInstance WHERE m_attributesetinstance_id IN (SELECT m_attributesetinstance_id FROM tmp_m_attributesetinstance_ids_to_delete);

	/**********************************************************************************************************/
	-- Delete m_storageonhand records that were last updated over a month ago
	/**********************************************************************************************************/
	DELETE FROM m_storageonhand
	WHERE qtyonhand = 0 AND updated < now() - INTERVAL '1 MONTH' AND ad_client_id > 999999;

COMMIT;

SELECT register_migration_script('202203071631_GO-2231.sql') FROM dual;
