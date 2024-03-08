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
-- Drop constraints for faster execution
/**********************************************************************************************************/
BEGIN;

	-- These first constraints are just for our build process (for some reason, it has different constraints than UAT)
	-- These will not be re-added because they don't exist in UAT
	ALTER TABLE m_cost DROP CONSTRAINT IF EXISTS masi_mcost;
	ALTER TABLE m_costdetail DROP CONSTRAINT IF EXISTS masi_mcostdetail;
	ALTER TABLE m_inoutlinema DROP CONSTRAINT IF EXISTS masi_minourlinema;
	ALTER TABLE m_costhistory DROP CONSTRAINT IF EXISTS mattributesetinstance_mcosthis;
	ALTER TABLE m_matchpo DROP CONSTRAINT IF EXISTS mattributesetinstance_mmatchpo;
	ALTER TABLE m_storageonhand DROP CONSTRAINT IF EXISTS mattributesetinstance_mstoraoh;
	ALTER TABLE m_storagereservation DROP CONSTRAINT IF EXISTS mattributesetinstance_mstorare;
	ALTER TABLE c_invoiceline DROP CONSTRAINT IF EXISTS mattrsetinst_cinvoiceline;
	ALTER TABLE c_orderline DROP CONSTRAINT IF EXISTS mattrsetinst_corderline;
	ALTER TABLE m_inoutline DROP CONSTRAINT IF EXISTS mattrsetinst_minoutline;
	ALTER TABLE m_product DROP CONSTRAINT IF EXISTS mattrsetinst_mproduct;
	ALTER TABLE m_transaction DROP CONSTRAINT IF EXISTS mattrsetinst_mtransaction;

	-- These constraints exist in UAT (and will be re-added at the end of the script)
	ALTER TABLE a_asset DROP CONSTRAINT IF EXISTS mattributesetinstance_aasset;
	ALTER TABLE a_asset_addition DROP CONSTRAINT IF EXISTS mattributesetinstance_aassetad;
	ALTER TABLE a_asset_product DROP CONSTRAINT IF EXISTS mattributesetinstance_aassetpr;
	ALTER TABLE bh_stocktake DROP CONSTRAINT IF EXISTS mattributesetinstance_bhstockt;
	ALTER TABLE c_invoiceline DROP CONSTRAINT IF EXISTS c_invoiceline_m_attributesetinstance_id_fkey;
	ALTER TABLE c_landedcostallocation DROP CONSTRAINT IF EXISTS masi_clandedcostallocation;
	ALTER TABLE c_orderline DROP CONSTRAINT IF EXISTS c_orderline_m_attributesetinstance_id_fkey;
	ALTER TABLE c_projectissue DROP CONSTRAINT IF EXISTS mattrsetinst_cprojectissue;
	ALTER TABLE c_projectissuema DROP CONSTRAINT IF EXISTS masi_cprojectissuema;
	ALTER TABLE c_rfqline DROP CONSTRAINT IF EXISTS masetinstance_crfqline;
	ALTER TABLE dd_orderline DROP CONSTRAINT IF EXISTS mattributesetinstance_ddorderl;
	ALTER TABLE dd_orderline DROP CONSTRAINT IF EXISTS mattributesetinstanceto_ddorde;
	ALTER TABLE i_asset DROP CONSTRAINT IF EXISTS mattributesetinstance_iasset;
	ALTER TABLE m_attributeinstance DROP CONSTRAINT IF EXISTS mattrsetinst__mattrinst;
	ALTER TABLE m_bomproduct DROP CONSTRAINT IF EXISTS masi_mbomproduct;
	ALTER TABLE m_cost DROP CONSTRAINT IF EXISTS m_cost_m_attributesetinstance_id_fkey;
	ALTER TABLE m_costdetail DROP CONSTRAINT IF EXISTS m_costdetail_m_attributesetinstance_id_fkey;
	ALTER TABLE m_costhistory DROP CONSTRAINT IF EXISTS m_costhistory_m_attributesetinstance_id_fkey;
	ALTER TABLE m_costqueue DROP CONSTRAINT IF EXISTS masi_mcostqueue;
	ALTER TABLE m_inoutline DROP CONSTRAINT IF EXISTS m_inoutline_m_attributesetinstance_id_fkey;
	ALTER TABLE m_inoutlinema DROP CONSTRAINT IF EXISTS m_inoutlinema_m_attributesetinstance_id_fkey;
	ALTER TABLE m_inventoryline DROP CONSTRAINT IF EXISTS mattrsetinst_minventoryline;
	ALTER TABLE m_inventorylinema DROP CONSTRAINT IF EXISTS masi_minventorylinema;
	ALTER TABLE m_matchinv DROP CONSTRAINT IF EXISTS mattributesetinstance_mmatchin;
	ALTER TABLE m_matchpo DROP CONSTRAINT IF EXISTS m_matchpo_m_attributesetinstance_id_fkey;
	ALTER TABLE m_movementline DROP CONSTRAINT IF EXISTS mattributesetinstanceto_mmovem;
	ALTER TABLE m_movementline DROP CONSTRAINT IF EXISTS mattrsetinst_mmovementline;
	ALTER TABLE m_movementlinema DROP CONSTRAINT IF EXISTS masi_mmovementlinema;
	ALTER TABLE m_product DROP CONSTRAINT IF EXISTS m_product_m_attributesetinstance_id_fkey;
	ALTER TABLE m_productionline DROP CONSTRAINT IF EXISTS mattrsetinst_mproductionline;
	ALTER TABLE m_productionlinema DROP CONSTRAINT IF EXISTS masi_mproductionlinema;
	ALTER TABLE m_qualitytestresult DROP CONSTRAINT IF EXISTS mattributesetinstance_mquality;
	ALTER TABLE m_requisitionline DROP CONSTRAINT IF EXISTS mattributesetinstance_mrequisi;
	ALTER TABLE m_storageonhand DROP CONSTRAINT IF EXISTS m_storageonhand_m_attributesetinstance_id_fkey;
	ALTER TABLE m_storagereservation DROP CONSTRAINT IF EXISTS m_storagereservation_m_attributesetinstance_id_fkey;
	ALTER TABLE m_transaction DROP CONSTRAINT IF EXISTS m_transaction_m_attributesetinstance_id_fkey;
	ALTER TABLE m_transactionallocation DROP CONSTRAINT IF EXISTS mattributesetinst_mtrxalloc;
	ALTER TABLE pp_cost_collector DROP CONSTRAINT IF EXISTS mattributesetinstance_ppcostco;
	ALTER TABLE pp_cost_collectorma DROP CONSTRAINT IF EXISTS mattributesetinstance_ppcostma;
	ALTER TABLE pp_order DROP CONSTRAINT IF EXISTS mattributesetinstance_pporder;
	ALTER TABLE pp_order_bom DROP CONSTRAINT IF EXISTS mattributesetinstance_pporderb;
	ALTER TABLE pp_order_bomline DROP CONSTRAINT IF EXISTS mattributesetinstance_ppordbl;
	ALTER TABLE pp_order_cost DROP CONSTRAINT IF EXISTS mattributesetinstance_pporderc;
	ALTER TABLE pp_product_bom DROP CONSTRAINT IF EXISTS mattributesetinstance_ppproduc;
	ALTER TABLE pp_product_bomline DROP CONSTRAINT IF EXISTS mattributesetinstance_ppprodbl;
	ALTER TABLE t_inventoryvalue DROP CONSTRAINT IF EXISTS masi_tinventoryvalue;
	ALTER TABLE t_transaction DROP CONSTRAINT IF EXISTS masi_ttransaction;
	ALTER TABLE c_projectissuema DROP CONSTRAINT IF EXISTS c_projectissuema_pkey;
	ALTER TABLE m_attributeinstance DROP CONSTRAINT IF EXISTS m_attributeinstance_pkey;
	ALTER TABLE m_attributesetinstance DROP CONSTRAINT IF EXISTS m_attributesetinstance_pkey;
	ALTER TABLE m_cost DROP CONSTRAINT IF EXISTS m_cost_pkey;
	ALTER TABLE m_inoutlinema DROP CONSTRAINT IF EXISTS m_inoutlinema_pkey;
	ALTER TABLE m_inventorylinema DROP CONSTRAINT IF EXISTS m_inventorylinema_pkey;
	ALTER TABLE m_movementlinema DROP CONSTRAINT IF EXISTS m_movementlinema_pkey;
	ALTER TABLE m_productionlinema DROP CONSTRAINT IF EXISTS m_productionlinema_pkey;
	ALTER TABLE m_storageonhand DROP CONSTRAINT IF EXISTS m_storageonhand_pkey;
	ALTER TABLE m_storagereservation DROP CONSTRAINT IF EXISTS m_storagereservation_pkey;
	ALTER TABLE t_inventoryvalue DROP CONSTRAINT IF EXISTS t_inventoryvalue_pkey;

COMMIT;

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

/**********************************************************************************************************/
-- Re-add the constraints
/**********************************************************************************************************/
BEGIN;

	ALTER TABLE t_inventoryvalue ADD CONSTRAINT t_inventoryvalue_pkey PRIMARY KEY (ad_pinstance_id, m_warehouse_id, m_product_id, m_attributesetinstance_id);
	ALTER TABLE m_storagereservation ADD CONSTRAINT m_storagereservation_pkey PRIMARY KEY (m_product_id, m_warehouse_id, issotrx, m_attributesetinstance_id);
	ALTER TABLE m_storageonhand ADD CONSTRAINT m_storageonhand_pkey PRIMARY KEY (m_product_id, m_locator_id, m_attributesetinstance_id, datematerialpolicy);
	ALTER TABLE m_productionlinema ADD CONSTRAINT m_productionlinema_pkey PRIMARY KEY (m_productionline_id, m_attributesetinstance_id, datematerialpolicy);
	ALTER TABLE m_movementlinema ADD CONSTRAINT m_movementlinema_pkey PRIMARY KEY (m_movementline_id, m_attributesetinstance_id, datematerialpolicy);
	ALTER TABLE m_inventorylinema ADD CONSTRAINT m_inventorylinema_pkey PRIMARY KEY (m_inventoryline_id, m_attributesetinstance_id, datematerialpolicy);
	ALTER TABLE m_inoutlinema ADD CONSTRAINT m_inoutlinema_pkey PRIMARY KEY (m_inoutline_id, m_attributesetinstance_id, datematerialpolicy);
	ALTER TABLE m_cost ADD CONSTRAINT m_cost_pkey PRIMARY KEY (ad_client_id, ad_org_id, m_product_id, m_costtype_id, c_acctschema_id, m_costelement_id, m_attributesetinstance_id);
	ALTER TABLE m_attributesetinstance ADD CONSTRAINT m_attributesetinstance_pkey PRIMARY KEY (m_attributesetinstance_id);
	ALTER TABLE m_attributeinstance ADD CONSTRAINT m_attributeinstance_pkey PRIMARY KEY (m_attributesetinstance_id, m_attribute_id);
	ALTER TABLE c_projectissuema ADD CONSTRAINT c_projectissuema_pkey PRIMARY KEY (c_projectissue_id, m_attributesetinstance_id);
	ALTER TABLE t_transaction ADD CONSTRAINT masi_ttransaction FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE t_inventoryvalue ADD CONSTRAINT masi_tinventoryvalue FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_product_bomline ADD CONSTRAINT mattributesetinstance_ppprodbl FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_product_bom ADD CONSTRAINT mattributesetinstance_ppproduc FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_order_cost ADD CONSTRAINT mattributesetinstance_pporderc FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_order_bomline ADD CONSTRAINT mattributesetinstance_ppordbl FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_order_bom ADD CONSTRAINT mattributesetinstance_pporderb FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_order ADD CONSTRAINT mattributesetinstance_pporder FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_cost_collectorma ADD CONSTRAINT mattributesetinstance_ppcostma FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE pp_cost_collector ADD CONSTRAINT mattributesetinstance_ppcostco FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_transactionallocation ADD CONSTRAINT mattributesetinst_mtrxalloc FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_transaction ADD CONSTRAINT m_transaction_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_storagereservation ADD CONSTRAINT m_storagereservation_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_storageonhand ADD CONSTRAINT m_storageonhand_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_requisitionline ADD CONSTRAINT mattributesetinstance_mrequisi FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_qualitytestresult ADD CONSTRAINT mattributesetinstance_mquality FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_productionlinema ADD CONSTRAINT masi_mproductionlinema FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_productionline ADD CONSTRAINT mattrsetinst_mproductionline FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_product ADD CONSTRAINT m_product_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_movementlinema ADD CONSTRAINT masi_mmovementlinema FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_movementline ADD CONSTRAINT mattrsetinst_mmovementline FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_movementline ADD CONSTRAINT mattributesetinstanceto_mmovem FOREIGN KEY (m_attributesetinstanceto_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_matchpo ADD CONSTRAINT m_matchpo_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_matchinv ADD CONSTRAINT mattributesetinstance_mmatchin FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_inventorylinema ADD CONSTRAINT masi_minventorylinema FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_inventoryline ADD CONSTRAINT mattrsetinst_minventoryline FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_inoutlinema ADD CONSTRAINT m_inoutlinema_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_inoutline ADD CONSTRAINT m_inoutline_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_costqueue ADD CONSTRAINT masi_mcostqueue FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_costhistory ADD CONSTRAINT m_costhistory_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_costdetail ADD CONSTRAINT m_costdetail_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_cost ADD CONSTRAINT m_cost_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_bomproduct ADD CONSTRAINT masi_mbomproduct FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE m_attributeinstance ADD CONSTRAINT mattrsetinst__mattrinst FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE i_asset ADD CONSTRAINT mattributesetinstance_iasset FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE dd_orderline ADD CONSTRAINT mattributesetinstanceto_ddorde FOREIGN KEY (m_attributesetinstanceto_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE dd_orderline ADD CONSTRAINT mattributesetinstance_ddorderl FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_rfqline ADD CONSTRAINT masetinstance_crfqline FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_projectissuema ADD CONSTRAINT masi_cprojectissuema FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_projectissue ADD CONSTRAINT mattrsetinst_cprojectissue FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_orderline ADD CONSTRAINT c_orderline_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_landedcostallocation ADD CONSTRAINT masi_clandedcostallocation FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE c_invoiceline ADD CONSTRAINT c_invoiceline_m_attributesetinstance_id_fkey FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE bh_stocktake ADD CONSTRAINT mattributesetinstance_bhstockt FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE a_asset_product ADD CONSTRAINT mattributesetinstance_aassetpr FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE a_asset_addition ADD CONSTRAINT mattributesetinstance_aassetad FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;
	ALTER TABLE a_asset ADD CONSTRAINT mattributesetinstance_aasset FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance(m_attributesetinstance_id) DEFERRABLE INITIALLY DEFERRED;

COMMIT;

SELECT register_migration_script('202203071631_GO-2231.sql') FROM dual;
