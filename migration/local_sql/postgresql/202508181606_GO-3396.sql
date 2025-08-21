-- Get the invoices with duplicate invoice lines
SELECT DISTINCT
	il1.c_invoice_id
INTO TEMP TABLE
	tmp_c_invoice_ids_to_update
FROM
	c_invoiceline il1
		JOIN c_invoiceline il2
			ON il1.c_invoice_id = il2.c_invoice_id AND il1.c_orderline_id = il2.c_orderline_id AND
			   il1.c_invoiceline_id != il2.c_invoiceline_id;

-- Get the duplicate invoice lines to delete
SELECT
	il2.c_invoice_id,
	il2.c_invoiceline_id
INTO TEMP TABLE
	tmp_c_invoiceline_to_delete
FROM
	c_invoiceline il1
		JOIN tmp_c_invoice_ids_to_update ti
			ON il1.c_invoice_id = ti.c_invoice_id
		JOIN c_invoiceline il2
			ON il1.c_invoice_id = il2.c_invoice_id
		AND il1.c_invoiceline_id < il2.c_invoiceline_id
		AND il1.c_orderline_id = il2.c_orderline_id;

-- Delete the duplicate invoice lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_invoiceline il USING tmp_c_invoiceline_to_delete til
WHERE
	il.c_invoiceline_id = til.c_invoiceline_id;$$, 'c_invoiceline_id');

-- Update the invoice grand total
UPDATE c_invoice i
SET
	totallines = il.grandtotal,
	grandtotal = il.grandtotal
FROM
	(
		SELECT
			il.c_invoice_id,
			SUM(il.linenetamt) AS grandtotal
		FROM
			c_invoiceline il
				JOIN tmp_c_invoice_ids_to_update ti
					ON il.c_invoice_id = ti.c_invoice_id
		GROUP BY il.c_invoice_id
	) il
WHERE
	i.c_invoice_id = il.c_invoice_id;

-- Update the fact_acct amounts
DELETE
FROM
	fact_acct fa USING tmp_c_invoiceline_to_delete til
WHERE
	fa.record_id = til.c_invoice_id
	AND fa.line_id = til.c_invoiceline_id
	AND fa.ad_table_id = 318;

-- If allocated against and full payment was made, update the invoice ispaid
UPDATE c_invoice i
SET
	ispaid = 'Y'
FROM
	c_allocationline al
		JOIN tmp_c_invoice_ids_to_update ti
			ON al.c_invoice_id = ti.c_invoice_id
WHERE
	i.c_invoice_id = al.c_invoice_id
	AND al.amount = i.grandtotal;

-- Update the BP open balances
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
			EXISTS (
				SELECT
					1
				FROM
					c_invoice i
						JOIN tmp_c_invoice_ids_to_update ti
							ON i.c_invoice_id = ti.c_invoice_id AND i.c_bpartner_id = bp.c_bpartner_id
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

-- Wrap up
SELECT
	register_migration_script('202508181606_GO-3396.sql')
FROM
	dual;
