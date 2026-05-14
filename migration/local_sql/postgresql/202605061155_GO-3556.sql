-- Return the standard position from 10 to 2
UPDATE c_currency
SET
	stdprecision = 2
WHERE
	c_currency_id = 266;

-- Correct buying prices of products that have too many decimals
UPDATE m_productprice pp
SET
	pricestd   = ROUND(pricestd, 2),
	pricelist  = ROUND(pricelist, 2),
	pricelimit = ROUND(pricelimit, 2)
FROM
	m_pricelist_version plv
		CROSS JOIN m_product p
		JOIN m_pricelist pl
			ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.issopricelist = 'Y' AND pl.isactive = 'Y'
WHERE
	pp.m_pricelist_version_id = plv.m_pricelist_version_id
	AND pp.m_product_id = p.m_product_id
	AND p.bh_sellprice != ROUND(p.bh_sellprice, 2);
UPDATE m_product
SET
	bh_sellprice = ROUND(bh_sellprice, 2)
WHERE
	bh_sellprice != ROUND(bh_sellprice, 2)
	AND updated > '2026-04-10';

-- Go through and update orders that have used this to make sure that all the buying prices and things are correct
UPDATE c_orderline ol
SET
	pricelist    = ROUND(pricelist, 2),
	priceactual  = ROUND(priceactual, 2),
	priceentered = ROUND(priceentered, 2),
	pricelimit   = ROUND(pricelimit, 2),
	linenetamt   = ROUND(linenetamt, 2)
FROM
	c_order o
WHERE
	ol.c_order_id = o.c_order_id
	AND o.dateordered > '2026-04-10'
	AND (
		ol.pricelist <> ROUND(ol.pricelist, 2)
			OR ol.priceactual <> ROUND(ol.priceactual, 2)
			OR ol.priceentered <> ROUND(ol.priceentered, 2)
			OR ol.pricelimit <> ROUND(ol.pricelimit, 2)
			OR ol.linenetamt <> ROUND(ol.linenetamt, 2)
		);

UPDATE c_order
SET
	totallines = ROUND(totallines, 2),
	grandtotal = ROUND(grandtotal, 2)
SELECT
	totallines,
	grandtotal
FROM
	c_order
WHERE
	dateordered > '2026-04-10'
	AND (
		totallines <> ROUND(totallines, 2)
			OR grandtotal <> ROUND(grandtotal, 2)
		);
-- Update invoices and invoice lines with this issue
UPDATE c_invoiceline il
SET
	pricelist    = ROUND(pricelist, 2),
	priceactual  = ROUND(priceactual, 2),
	priceentered = ROUND(priceentered, 2),
	pricelimit   = ROUND(pricelimit, 2),
	linenetamt   = ROUND(linenetamt, 2)
FROM
	c_invoice i
WHERE
	il.c_invoice_id = i.c_invoice_id
	AND i.dateinvoiced > '2026-04-10'
	AND (
		il.pricelist <> ROUND(il.pricelist, 2)
			OR il.priceactual <> ROUND(il.priceactual, 2)
			OR il.priceentered <> ROUND(il.priceentered, 2)
			OR il.pricelimit <> ROUND(il.pricelimit, 2)
			OR il.linenetamt <> ROUND(il.linenetamt, 2)
		);

UPDATE c_invoice
SET
	totallines = ROUND(totallines, 2),
	grandtotal = ROUND(grandtotal, 2)
WHERE
	dateinvoiced > '2026-04-10'
	AND (
		totallines <> ROUND(totallines, 2)
			OR grandtotal <> ROUND(grandtotal, 2)
		);
-- Update payment and accounting
UPDATE c_payment
SET
	payamt       = ROUND(payamt, 2),
	discountamt  = ROUND(discountamt, 2),
	writeoffamt  = ROUND(writeoffamt, 2),
	overunderamt = ROUND(overunderamt, 2)
WHERE
	datetrx > '2026-04-10'
	AND (
		payamt <> ROUND(payamt, 2)
			OR discountamt <> ROUND(discountamt, 2)
			OR writeoffamt <> ROUND(writeoffamt, 2)
			OR overunderamt <> ROUND(overunderamt, 2)
		);

UPDATE c_allocationline al
SET
	amount       = ROUND(amount, 2),
	discountamt  = ROUND(discountamt, 2),
	writeoffamt  = ROUND(writeoffamt, 2),
	overunderamt = ROUND(overunderamt, 2)
FROM
	c_allocationhdr ah
WHERE
	al.c_allocationhdr_id = ah.c_allocationhdr_id
	AND ah.datetrx > '2026-04-10'
	AND (
		al.amount <> ROUND(al.amount, 2)
			OR al.discountamt <> ROUND(al.discountamt, 2)
			OR al.writeoffamt <> ROUND(al.writeoffamt, 2)
			OR al.overunderamt <> ROUND(al.overunderamt, 2)
		);


UPDATE c_allocationhdr
SET
	approvalamt = ROUND(approvalamt, 2)
WHERE
	datetrx > '2026-04-10'
	AND approvalamt <> ROUND(approvalamt, 2);

UPDATE fact_acct
SET
	amtacctdr   = ROUND(amtacctdr, 2),
	amtacctcr   = ROUND(amtacctcr, 2),
	amtsourcedr = ROUND(amtsourcedr, 2),
	amtsourcecr = ROUND(amtsourcecr, 2),
	qty         = ROUND(qty, 2)
WHERE
	dateacct > '2026-04-10'
	AND (
		amtacctdr <> ROUND(amtacctdr, 2)
			OR amtacctcr <> ROUND(amtacctcr, 2)
			OR amtsourcedr <> ROUND(amtsourcedr, 2)
			OR amtsourcecr <> ROUND(amtsourcecr, 2)
			OR qty <> ROUND(qty, 2)
		);
--- Update business partner open balance
UPDATE c_bpartner bp
SET
	totalopenbalance = COALESCE((
		                            SELECT
			                            SUM(invoiceopen(i.c_invoice_id, 0)
				                            * CASE WHEN i.issotrx = 'Y' THEN 1 ELSE -1 END)
		                            FROM
			                            c_invoice i
		                            WHERE
			                            i.c_bpartner_id = bp.c_bpartner_id
			                            AND i.docstatus IN ('CO', 'CL')
			                            AND i.ispaid = 'N'
			                            AND i.isactive = 'Y'
	                            ), 0),
	so_creditused    = COALESCE((
		                            SELECT
			                            SUM(invoiceopen(i.c_invoice_id, 0))
		                            FROM
			                            c_invoice i
		                            WHERE
			                            i.c_bpartner_id = bp.c_bpartner_id
			                            AND i.issotrx = 'Y'
			                            AND i.docstatus IN ('CO', 'CL')
			                            AND i.ispaid = 'N'
			                            AND i.isactive = 'Y'
	                            ), 0)
WHERE
	bp.c_bpartner_id
		IN (
		SELECT DISTINCT
			bp2.c_bpartner_id
		FROM
			bh_visit v
				JOIN c_bpartner bp2
					ON v.patient_id = bp2.c_bpartner_id
				JOIN c_bp_group bpg
					ON bp2.c_bp_group_id = bpg.c_bp_group_id AND bpg.name != 'OTC Patient'
		WHERE
			EXISTS (
				SELECT
					1
				FROM
					c_order o
				WHERE
					o.bh_visit_id = v.bh_visit_id
					AND o.docstatus IN ('CO', 'CL')
			)
			AND (
				EXISTS (
					SELECT
						1

					FROM
						c_invoice i
					WHERE
						i.bh_visit_id = v.bh_visit_id
						AND i.docstatus IN ('CO', 'CL')
					HAVING
						SUM(i.grandtotal) <> ROUND(SUM(i.grandtotal), 2)
				)
					OR EXISTS (
					SELECT
						1
					FROM
						c_payment p
					WHERE
						p.bh_visit_id = v.bh_visit_id
						AND p.docstatus IN ('CO', 'CL')
					HAVING
						SUM(p.payamt) <> ROUND(SUM(p.payamt), 2)
				)
				)
			AND v.bh_visitdate > '2026-04-10'
			AND (bp2.totalopenbalance <> ROUND(bp2.totalopenbalance, 2)
				OR bp2.totalopenbalance = 0)
	);

-- Register the migration script
SELECT
	register_migration_script('202605061155_GO-3556.sql')
FROM
	dual;
