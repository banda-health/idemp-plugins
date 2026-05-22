-- Return the standard position from 10 to 2
UPDATE c_currency
SET
	stdprecision = 2
WHERE
	c_currency_id = 266;

-- Get the products that have too many decimals
SELECT
	p.m_product_id,
	c.stdprecision,
	c.costingprecision
INTO TEMP TABLE
	tmp_m_products_with_too_many_decimals
FROM
	m_product p
		JOIN LATERAL (
		SELECT
			p.m_product_id,
			c.stdprecision,
			c.costingprecision
		FROM
			c_currency c
		WHERE
			c.c_currency_id IN (
				SELECT
					pl.c_currency_id
				FROM
					m_pricelist pl
						JOIN m_pricelist_version plv
							ON pl.m_pricelist_id = plv.m_pricelist_id AND plv.isactive = 'Y' AND plv.validfrom <= NOW()
						JOIN m_productprice pp
							ON plv.m_pricelist_version_id = pp.m_pricelist_version_id AND
							   pp.m_product_id = p.m_product_id
				WHERE
					pl.isactive = 'Y'
					AND pl.issopricelist = 'Y'
			)) c
			ON p.m_product_id = c.m_product_id
WHERE
	p.bh_sellprice != ROUND(p.bh_sellprice, c.stdprecision)
	AND updated > '2026-04-10';

-- Correct buying prices of products that have too many decimals
UPDATE m_productprice pp
SET
	pricestd   = ROUND(pricestd, tpwtmd.stdprecision),
	pricelist  = ROUND(pricelist, tpwtmd.stdprecision),
	pricelimit = ROUND(pricelimit, tpwtmd.stdprecision)
FROM
	m_pricelist_version plv
		CROSS JOIN m_product p
		JOIN tmp_m_products_with_too_many_decimals tpwtmd
			ON p.m_product_id = tpwtmd.m_product_id
		JOIN m_pricelist pl
			ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.issopricelist = 'Y' AND pl.isactive = 'Y'
WHERE
	pp.m_pricelist_version_id = plv.m_pricelist_version_id
	AND pp.m_product_id = p.m_product_id;
UPDATE m_product p
SET
	bh_sellprice = ROUND(bh_sellprice, tpwtmd.stdprecision)
FROM
	tmp_m_products_with_too_many_decimals tpwtmd
WHERE
	tpwtmd.m_product_id = p.m_product_id;

/**********************************************************************************************************/
-- Fix patient open balances where payamt precision does not match bh_tender_amount
/**********************************************************************************************************/
-- Business partners whose open balance has too many decimal places
SELECT
	bp.c_bpartner_id,
	c.stdprecision
INTO TEMP TABLE
	tmp_bps_open_balance_mismatch
FROM
	c_bpartner bp
		JOIN c_acctschema accts
			ON bp.ad_client_id = accts.ad_client_id
		JOIN c_currency c
			ON accts.c_currency_id = c.c_currency_id
WHERE
	bp.totalopenbalance != ROUND(bp.totalopenbalance, c.stdprecision);

-- Payments where rounded payamt does not match the tender amount
SELECT
	p.c_payment_id,
	p.c_bpartner_id,
	p.payamt                            AS old_payamt,
	ROUND(p.payamt, bpobm.stdprecision) AS new_payamt,
	bpobm.stdprecision
INTO TEMP TABLE
	tmp_payment_payamt_fixes
FROM
	c_payment p
		JOIN tmp_bps_open_balance_mismatch bpobm
			ON p.c_bpartner_id = bpobm.c_bpartner_id
WHERE
	p.docstatus IN ('CO', 'CL')
	AND ROUND(p.payamt, bpobm.stdprecision) != p.payamt;

-- Only apply fixes that would not drive the open balance negative
SELECT
	pf.*
INTO TEMP TABLE
	tmp_payment_payamt_fixes_safe
FROM
	tmp_payment_payamt_fixes pf
		JOIN (
		SELECT
			bpm.c_bpartner_id
		FROM
			tmp_bps_open_balance_mismatch bpm
				JOIN (
				SELECT
					inner_bp.c_bpartner_id,
					COALESCE((
						         SELECT
							         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
							                          i.DateInvoiced, i.AD_Client_ID, i.AD_Org_ID) * i.MultiplierAP)
						         FROM
							         C_Invoice_v i
						         WHERE
							         i.C_BPartner_ID = inner_bp.C_BPartner_ID
							         AND i.IsPaid = 'N'
							         AND i.DocStatus IN ('CO', 'CL')
					         ), 0) - COALESCE((
						                          SELECT
							                          SUM(
									                          currencyBase(
											                          CASE
												                          WHEN pf.c_payment_id IS NOT NULL AND p.IsAllocated = 'N'
													                          THEN pf.new_payamt
												                          ELSE Paymentavailable(p.C_Payment_ID)
												                          END,
											                          p.C_Currency_ID, p.DateTrx, p.AD_Client_ID, p.AD_Org_ID))
						                          FROM
							                          C_Payment_v p
								                          LEFT JOIN tmp_payment_payamt_fixes pf
									                          ON p.C_Payment_ID = pf.c_payment_id
						                          WHERE
							                          p.C_BPartner_ID = inner_bp.C_BPartner_ID
							                          AND p.IsAllocated = 'N'
							                          AND p.C_Charge_ID IS NULL
							                          AND p.DocStatus IN ('CO', 'CL')
					                          ), 0) AS projected_open_balance
				FROM
					C_BPartner inner_bp
			) projected
					ON projected.c_bpartner_id = bpm.c_bpartner_id
		WHERE
			projected.projected_open_balance >= 0
	) safe
			ON safe.c_bpartner_id = pf.c_bpartner_id;

UPDATE c_payment p
SET
	payamt = pf.new_payamt
FROM
	tmp_payment_payamt_fixes_safe pf
WHERE
	p.c_payment_id = pf.c_payment_id;

-- Recalculate open balances for affected business partners
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
			c_bpartner_id
		FROM
			C_BPartner bp
		WHERE
			bp.c_bpartner_id IN (
				SELECT DISTINCT
					c_bpartner_id
				FROM
					tmp_payment_payamt_fixes_safe
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

-- Register the migration script
SELECT
	register_migration_script('202605191500_GO-3556.sql')
FROM
	dual;
