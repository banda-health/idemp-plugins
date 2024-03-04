/**********************************************************************************************************************/
-- There exist order lines on both SOs and POs that don't have a product or a charge. This should not be. If the
-- order line is mapped to a transaction through the in-out, update it to match the product. Otherwise, we're going
-- to delete it and everything associated with it (accounting, payments, invoices, shipments, visits, allocations)
--  1. For order lines that don't have products but they relate to transactions that do, update their product
--  2. For the remaining order lines, we have some work to do: get orders and visits we're going to delete
--  3. Handle the payments
--  4. Handle the invoices
-- 	5. Remove shipments and orders
-- 	6. For the products that were removed as part of an order and patients where we removed payments on an order,
-- 	update inventory counts and patient open balances
-- 	7. Wrap-up
/**********************************************************************************************************************/

/**********************************************************************************************************************/
--  1. For order lines that don't have products but they relate to transactions that do, update their product
/**********************************************************************************************************************/
UPDATE c_orderline ol
SET
	m_product_id = t.m_product_id
FROM
	c_order o
		JOIN m_inout io
		ON o.c_order_id = io.c_order_id
		JOIN m_inoutline iol
		ON io.m_inout_id = iol.m_inout_id
		JOIN m_transaction t
		ON iol.m_inoutline_id = t.m_inoutline_id
WHERE
	ol.c_order_id = o.c_order_id
	AND ol.m_product_id IS NULL
	AND ol.c_charge_id IS NULL;

/**********************************************************************************************************************/
--  2. For the remaining order lines, we have some work to do: get orders and visits we're going to delete
/**********************************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_orders_with_orderlines_to_delete_and_bps;
SELECT
	c_order_id,
	c_bpartner_id
INTO TEMP TABLE
	tmp_c_orders_with_orderlines_to_delete_and_bps
FROM
	c_order o
WHERE
	c_order_id IN (
		SELECT c_order_id FROM c_orderline WHERE m_product_id IS NULL AND c_charge_id IS NULL
	);

-- If remove the last order from a visit, just remove that visit, too
DROP TABLE IF EXISTS tmp_bh_visits_to_delete;
SELECT
	bh_visit_id
INTO TEMP TABLE
	tmp_bh_visits_to_delete
FROM
	bh_visit
WHERE
	bh_visit_id IN (
		SELECT
			bh_visit_id
		FROM
			c_order
		WHERE
			bh_visit_id IN (
				SELECT
					bh_visit_id
				FROM
					c_order
				WHERE
					c_order_id IN (
						SELECT
							c_order_id
						FROM
							tmp_c_orders_with_orderlines_to_delete_and_bps
					)
			)
		GROUP BY bh_visit_id
		HAVING
			COUNT(*) = 1
	);

-- Some orders we'll be deleting may still have products on them, so we'll need to update their inventories after this
DROP TABLE IF EXISTS tmp_m_products_were_messing_with;
SELECT
	m_product_id
INTO TEMP TABLE
	tmp_m_products_were_messing_with
FROM
	m_product
WHERE
	m_product_id IN (
		SELECT
			m_product_id
		FROM
			c_orderline
		WHERE
			c_order_id IN (
				SELECT
					c_order_id
				FROM
					tmp_c_orders_with_orderlines_to_delete_and_bps
			)
			AND m_product_id IS NOT NULL
	);

/**********************************************************************************************************************/
-- Now we're ready to do our deletes!
-- 3. Handle the payments
/**********************************************************************************************************************/
-- Deallocate current payments that were allocated to historical invoices (that we'll be deleting)
UPDATE c_payment p
SET
	isallocated = 'N'
WHERE
	isallocated = 'Y'
	AND (c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			c_allocationline
		WHERE
			c_invoice_id IN (
				SELECT
					c_invoice_id
				FROM
					c_invoice
				WHERE
					c_order_id IN (
						SELECT
							c_order_id
						FROM
							tmp_c_orders_with_orderlines_to_delete_and_bps
					)
			)
	) OR c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			c_invoice
		WHERE
			c_order_id IN (
				SELECT
					c_order_id
				FROM
					tmp_c_orders_with_orderlines_to_delete_and_bps
			)
	))
	AND created >= '2022-11-13';
DELETE
FROM
	c_allocationline al
	USING c_payment p
		JOIN c_invoice i ON i.c_order_id IN (
			SELECT
				c_order_id
			FROM
				tmp_c_orders_with_orderlines_to_delete_and_bps
		)
WHERE
	al.c_payment_id = p.c_payment_id
	AND p.created >= '2022-11-13'
	AND i.c_invoice_id = al.c_invoice_id;

-- Get the remaining payments that we'll delete
DROP TABLE IF EXISTS tmp_c_invoices_to_delete;
SELECT
	c_invoice_id
INTO TEMP TABLE
	tmp_c_invoices_to_delete
FROM
	c_invoice
WHERE
	c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_c_orders_with_orderlines_to_delete_and_bps
	)
	OR bh_visit_id IN (
		SELECT
			bh_visit_id
		FROM
			tmp_bh_visits_to_delete
	);
DROP TABLE IF EXISTS tmp_c_payments_to_delete;
SELECT
	ad_client_id,
	c_payment_id,
	isreceipt
INTO TEMP TABLE
	tmp_c_payments_to_delete
FROM
	c_payment
WHERE
	c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			c_allocationline
		WHERE
			c_invoice_id IN (
				SELECT
					c_invoice_id
				FROM
					tmp_c_invoices_to_delete
			)
	)
	OR reversal_id IN (
		SELECT
			c_payment_id
		FROM
			c_allocationline
		WHERE
			c_invoice_id IN (
				SELECT
					c_invoice_id
				FROM
					tmp_c_invoices_to_delete
			)
	)
	OR c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	)
	OR bh_visit_id IN (
		SELECT
			bh_visit_id
		FROM
			tmp_bh_visits_to_delete
	);

-- Remove allocations
DROP TABLE IF EXISTS tmp_c_allocationhdrs_to_delete;
SELECT
	c_allocationhdr_id
INTO TEMP TABLE
	tmp_c_allocationhdrs_to_delete
FROM
	c_allocationhdr
WHERE
	c_allocationhdr_id IN (
		SELECT
			c_allocationhdr_id
		FROM
			c_allocationline
		WHERE
			c_invoice_id IN (
				SELECT
					c_invoice_id
				FROM
					tmp_c_invoices_to_delete
			)
			OR c_payment_id IN (
				SELECT
					c_payment_id
				FROM
					tmp_c_payments_to_delete
			)
	);
DELETE
FROM
	c_allocationline
WHERE
	c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	)
	OR c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			tmp_c_payments_to_delete
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_allocationhdr
WHERE
	c_allocationhdr_id IN (
		SELECT
			c_allocationhdr_id
		FROM
			tmp_c_allocationhdrs_to_delete
	);$$, 'c_allocationhdr_id');

-- Remove payments from fact_acct
DELETE
FROM
	fact_acct fa
	USING gl_category glc
		JOIN tmp_c_payments_to_delete tptd ON
			glc.name = CASE WHEN tptd.isreceipt = 'Y' THEN 'AR Receipt' ELSE 'AP Payment' END AND
			tptd.ad_client_id = glc.ad_client_id
WHERE
	fa.record_id = tptd.c_payment_id
	AND glc.gl_category_id = fa.gl_category_id;

-- Now remove the payments
UPDATE c_invoice
SET
	c_payment_id = NULL
WHERE
	c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			tmp_c_payments_to_delete
	);
UPDATE c_order
SET
	c_payment_id = NULL
WHERE
	c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			tmp_c_payments_to_delete
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_payment
WHERE
	c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			tmp_c_payments_to_delete
	);$$, 'c_payment_id');

/**********************************************************************************************************************/
--  4. Handle the invoices
/**********************************************************************************************************************/
-- Remove invoices from fact_acct
DELETE
FROM
	fact_acct fa
	USING gl_category glc
		JOIN c_invoice i ON glc.name = CASE WHEN i.issotrx = 'Y' THEN 'AR Invoice' ELSE 'AP Invoice' END AND
		                    i.ad_client_id = glc.ad_client_id
WHERE
	fa.record_id = i.c_invoice_id
	AND glc.gl_category_id = fa.gl_category_id
	AND i.c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	);

-- Remove invoices (and invoice lines)
DELETE
FROM
	bh_bp_specific_payer_info
WHERE
	c_invoiceline_id IN (
		SELECT
			c_invoiceline_id
		FROM
			c_invoiceline
		WHERE
			c_invoice_id IN (
				SELECT
					c_invoice_id
				FROM
					tmp_c_invoices_to_delete
			)
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_invoiceline
WHERE
	c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	);$$, 'c_invoiceline_id');
DELETE
FROM
	c_invoicetax
WHERE
	c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	);
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_invoice
WHERE
	c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_delete
	);$$, 'c_invoice_id');

/**********************************************************************************************************************/
-- 	5. Remove shipments, orders, and some visits that no longer have any orders
/**********************************************************************************************************************/
-- Remove in-outs (and in-out lines)
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline
WHERE
	m_inout_id IN (
		SELECT
			m_inout_id
		FROM
			m_inout
		WHERE
			c_order_id IN (
				SELECT
					c_order_id
				FROM
					tmp_c_orders_with_orderlines_to_delete_and_bps
			)
			OR bh_visit_id IN (
				SELECT
					bh_visit_id
				FROM
					tmp_bh_visits_to_delete
			)
	);$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inout
WHERE
	c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_c_orders_with_orderlines_to_delete_and_bps
	)
	OR bh_visit_id IN (
		SELECT
			bh_visit_id
		FROM
			tmp_bh_visits_to_delete
	);$$, 'm_inout_id');

-- Remove orders (and order lines)
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline
WHERE
	c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_c_orders_with_orderlines_to_delete_and_bps
	);$$, 'c_orderline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_ordertax
WHERE
	c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_c_orders_with_orderlines_to_delete_and_bps
	);$$, 'c_order_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_order
WHERE
	c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_c_orders_with_orderlines_to_delete_and_bps
	);$$, 'c_order_id');

-- Lastly, remove all visits that are obsolete
DELETE
FROM
	bh_visit
WHERE
	bh_visit_id IN (
		SELECT
			bh_visit_id
		FROM
			tmp_bh_visits_to_delete
	);

/**********************************************************************************************************************/
-- 	6. For the products that were removed as part of an order and patients where we removed payments on an order,
-- 	update inventory counts and patient open balances
/**********************************************************************************************************************/
-- Update inventory counts
UPDATE m_storageonhand soh
SET
	qtyonhand = calc.qtyonhand
FROM
	(
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			m_locator_id,
			SUM(movementqty) AS qtyonhand
		FROM
			m_transaction
		WHERE
			m_product_id IN (
				SELECT
					m_product_id
				FROM
					tmp_m_products_were_messing_with
			)
		GROUP BY m_product_id, m_attributesetinstance_id, m_locator_id
	) calc
WHERE
	soh.m_product_id = calc.m_product_id
	AND soh.m_attributesetinstance_id = calc.m_attributesetinstance_id
	AND soh.m_locator_id = calc.m_locator_id;

-- Update open balances
UPDATE c_bpartner bp
SET
	so_creditused    = COALESCE(calc.so_creditused, bp.so_creditused),
	totalopenbalance = COALESCE(calc.totalopenbalance, bp.totalopenbalance),
	socreditstatus   = CASE
		                   WHEN bp.socreditstatus IN ('X', 'S') OR bp.so_creditlimit = 0 THEN bp.socreditstatus
		                   WHEN bp.so_creditlimit < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN 'H'
		                   WHEN bp.so_creditlimit * 0.9 < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN 'W'
		                   ELSE 'O' END
FROM
	(
		SELECT
			COALESCE((
				         SELECT
					         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
					                          i.DateInvoiced,
					                          i.AD_Client_ID, i.AD_Org_ID))
				         FROM
					         C_Invoice_v i
				         WHERE
					         i.C_BPartner_ID = bp.C_BPartner_ID
					         AND i.IsSOTrx = 'Y'
					         AND i.IsPaid = 'N'
					         AND i.DocStatus IN ('CO', 'CL')
			         ), 0)                  AS so_creditused,
			COALESCE((
				         SELECT
					         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
					                          i.DateInvoiced, i.AD_Client_ID, i.AD_Org_ID) * i.MultiplierAP)
				         FROM
					         C_Invoice_v i
				         WHERE
					         i.C_BPartner_ID = bp.C_BPartner_ID
					         AND i.IsPaid = 'N'
					         AND i.DocStatus IN ('CO', 'CL')
			         ), 0) - COALESCE((
				                          SELECT
					                          SUM(currencyBase(Paymentavailable(p.C_Payment_ID), p.C_Currency_ID, p.DateTrx,
					                                           p.AD_Client_ID, p.AD_Org_ID))
				                          FROM
					                          C_Payment_v p
				                          WHERE
					                          p.C_BPartner_ID = bp.C_BPartner_ID
					                          AND p.IsAllocated = 'N'
					                          AND p.C_Charge_ID IS NULL
					                          AND p.DocStatus IN ('CO', 'CL')
			                          ), 0) AS totalopenbalance,
			bp.c_bpartner_id
		FROM
			C_BPartner bp
		WHERE
			bp.c_bpartner_id IN (
				SELECT
					c_bpartner_id
				FROM
					tmp_c_orders_with_orderlines_to_delete_and_bps
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************************/
-- 	7. Wrap-up
/**********************************************************************************************************************/
SELECT
	register_migration_script('202402200902_GO-2898.sql')
FROM
	dual;
