-- Get the invoices to fix
DROP TABLE IF EXISTS tmp_invoices_to_switch;
SELECT
	c_invoice_id
INTO TEMP TABLE
	tmp_invoices_to_switch
FROM
	c_invoice
WHERE
		c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			c_invoiceline il
				JOIN c_charge c
					ON il.c_charge_id = c.c_charge_id
		WHERE
			c.name = 'Bad debt write-off - DO NOT CHANGE'
	)
	AND issotrx = 'N';

-- Make all the invoices have sales transactions and flip the sign on the amount
UPDATE c_invoice i
SET
	issotrx            = 'Y',
	c_doctype_id       = dt.c_doctype_id,
	c_doctypetarget_id = dt.c_doctype_id,
	m_pricelist_id     = pl.m_pricelist_id
FROM
	c_doctype dt
		JOIN m_pricelist pl
			ON pl.ad_client_id = dt.ad_client_id AND issopricelist = 'Y'
WHERE
	dt.ad_client_id = i.ad_client_id
	AND dt.name = 'AR Invoice Indirect'
	AND i.c_invoice_id IN (
	SELECT
		c_invoice_id
	FROM
		tmp_invoices_to_switch
);

-- Flip the accounting signs
UPDATE fact_acct fa
SET
	amtsourcedr    = amtsourcedr * -1,
	amtsourcecr    = amtsourcecr * -1,
	amtacctcr      = amtacctcr * -1,
	amtacctdr      = amtacctdr * -1,
	gl_category_id = glc.gl_category_id
FROM
	gl_category glc
WHERE
	glc.ad_client_id = fa.ad_client_id
	AND glc.name = 'AR Invoice'
	AND ad_table_id = 318
	AND record_id IN (
	SELECT
		c_invoice_id
	FROM
		tmp_invoices_to_switch
);

-- Update the open balance
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
			         ), 0)                    AS so_creditused,
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
				SELECT
					c_bpartner_id
				FROM
					c_invoice
				WHERE
						c_invoice_id IN (
						SELECT
							c_invoice_id
						FROM
							tmp_invoices_to_switch
					)
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

SELECT
	register_migration_script('202210312029_GO-2476.sql')
FROM
	dual;
