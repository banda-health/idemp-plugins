/**********************************************************************************************************/
-- Create waived invoices for OTC Patient visits that have completed orders but no invoices
/**********************************************************************************************************/

-- Step 1: Identify OTC patient visits with completed orders but no invoices
DROP TABLE IF EXISTS tmp_otc_visits_without_invoices;
SELECT
	v.bh_visit_id,
	v.bh_visitdate,
	o.c_order_id,
	o.grandtotal,
	o.ad_client_id,
	o.ad_org_id,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.c_currency_id
INTO TEMP TABLE
	tmp_otc_visits_without_invoices
FROM
	c_order o
		JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id
		LEFT JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
WHERE
	o.docstatus IN ('CO', 'CL')
	AND i.c_invoice_id IS NULL;

/**********************************************************************************************************/
-- Step 2: Create invoices
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoice;
CREATE TEMP TABLE tmp_c_invoice
(
	c_invoice_id           serial                           NOT NULL,
	ad_client_id           numeric(10)                      NOT NULL,
	ad_org_id              numeric(10)                      NOT NULL,
	createdby              numeric(10)  DEFAULT 100         NOT NULL,
	updatedby              numeric(10)  DEFAULT 100         NOT NULL,
	documentno             numeric                          NOT NULL,
	docstatus              char(2)      DEFAULT 'CO'        NOT NULL,
	docaction              char(2)      DEFAULT 'CL'        NOT NULL,
	processing             char         DEFAULT 'N',
	processed              char         DEFAULT 'Y'::bpchar NOT NULL,
	posted                 char         DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id           numeric(10)                      NOT NULL,
	c_doctypetarget_id     numeric(10)                      NOT NULL,
	description            varchar(255) DEFAULT 'Programmatically clearing open balance via waiver',
	dateinvoiced           timestamp                        NOT NULL,
	dateacct               timestamp                        NOT NULL,
	c_bpartner_id          numeric(10)                      NOT NULL,
	c_bpartner_location_id numeric(10)                      NOT NULL,
	isdiscountprinted      char         DEFAULT 'N'::bpchar NOT NULL,
	c_currency_id          numeric(10)                      NOT NULL,
	paymentrule            char         DEFAULT 'b'         NOT NULL,
	c_paymentterm_id       numeric(10)                      NOT NULL,
	totallines             numeric                          NOT NULL,
	grandtotal             numeric                          NOT NULL,
	m_pricelist_id         numeric(10)                      NOT NULL,
	ispaid                 char         DEFAULT 'N'::bpchar NOT NULL,
	processedon            numeric,
	c_invoice_uu           uuid         DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char         DEFAULT 'N',
	bh_visit_id            numeric(10)                      NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_invoice_c_invoice_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Invoice'
				LIMIT 1
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, dateinvoiced, dateacct,
	               c_bpartner_id, c_bpartner_location_id, c_currency_id, c_paymentterm_id, m_pricelist_id,
	               totallines, grandtotal, processedon, bh_visit_id)
SELECT
	ov.ad_client_id,
	ov.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when we do row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	ov.bh_visitdate,
	ov.bh_visitdate,
	ov.c_bpartner_id,
	ov.c_bpartner_location_id,
	accts.c_currency_id,
	pt.c_paymentterm_id,
	COALESCE(bp.m_pricelist_id, bpg.m_pricelist_id),
	ov.grandtotal,
	ov.grandtotal,
	EXTRACT(EPOCH FROM ov.bh_visitdate) * 1000,
	ov.bh_visit_id
FROM
	tmp_otc_visits_without_invoices ov
		JOIN c_bpartner bp
			ON ov.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN ad_sequence seq
			ON seq.ad_client_id = ov.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON ov.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice Indirect'
		JOIN ad_clientinfo ci
			ON ov.ad_client_id = ci.ad_client_id
		JOIN c_acctschema accts
			ON accts.c_acctschema_id = ci.c_acctschema1_id
		JOIN c_paymentterm pt
			ON pt.ad_client_id = ov.ad_client_id AND pt.value = 'Immediate';


-- Update document numbers with row numbering partitioned by client
UPDATE tmp_c_invoice i
SET
	documentno = documentno + ti.row_num
FROM
	(
		SELECT
			c_invoice_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice
	) ti
WHERE
	i.c_invoice_id = ti.c_invoice_id;

/**********************************************************************************************************/
-- Step 3: Insert invoices into c_invoice
/**********************************************************************************************************/
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, docstatus, docaction, processing,
	           processed, posted, c_doctype_id, c_doctypetarget_id, description, dateinvoiced, dateacct, c_bpartner_id,
	           c_bpartner_location_id, isdiscountprinted, c_currency_id, paymentrule, c_paymentterm_id, totallines,
	           grandtotal, m_pricelist_id, processedon, c_invoice_uu, isfixedassetinvoice, ispaid, bh_visit_id)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno,
	docstatus,
	docaction,
	processing,
	processed,
	posted,
	c_doctype_id,
	c_doctypetarget_id,
	description,
	dateinvoiced,
	dateacct,
	c_bpartner_id,
	c_bpartner_location_id,
	isdiscountprinted,
	c_currency_id,
	paymentrule,
	c_paymentterm_id,
	totallines,
	grandtotal,
	m_pricelist_id,
	processedon,
	c_invoice_uu,
	isfixedassetinvoice,
	ispaid,
	bh_visit_id
FROM
	tmp_c_invoice;

SELECT
	v.bh_visitdate
FROM
	c_order o
		JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id
		LEFT JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
WHERE
	o.docstatus IN ('CO', 'CL')
	AND i.c_invoice_id IS NULL

/**********************************************************************************************************/
-- Step 4: Create invoice lines
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoiceline;
CREATE TEMP TABLE tmp_c_invoiceline
(
	c_invoiceline_id    serial                          NOT NULL,
	ad_client_id        numeric(10)                     NOT NULL,
	ad_org_id           numeric(10)                     NOT NULL,
	createdby           numeric(10) DEFAULT 100         NOT NULL,
	updatedby           numeric(10) DEFAULT 100         NOT NULL,
	c_invoice_id        numeric(10)                     NOT NULL,
	line                numeric(10) DEFAULT 10          NOT NULL,
	qtyinvoiced         numeric     DEFAULT 1           NOT NULL,
	priceactual         numeric                         NOT NULL,
	linenetamt          numeric                         NOT NULL,
	c_charge_id         numeric(10),
	c_uom_id            numeric(10) DEFAULT 100,
	c_tax_id            numeric(10),
	processed           char        DEFAULT 'Y'::bpchar NOT NULL,
	qtyentered          numeric     DEFAULT 1           NOT NULL,
	priceentered        numeric                         NOT NULL,
	c_invoiceline_uu    uuid        DEFAULT uuid_generate_v4(),
	isfixedassetinvoice char        DEFAULT 'N'
);

SELECT
	SETVAL(
			'tmp_c_invoiceline_c_invoiceline_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_InvoiceLine'
				LIMIT 1
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, c_invoice_id, priceactual, linenetamt, c_charge_id, c_tax_id,
	                   priceentered)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.c_invoice_id,
	ti.grandtotal,
	ti.grandtotal,
	c.c_charge_id,
	t.c_tax_id,
	ti.grandtotal
FROM
	tmp_c_invoice ti
		JOIN c_tax t
			ON t.ad_client_id = ti.ad_client_id
		JOIN c_charge c
			ON ti.ad_client_id = c.ad_client_id AND c.name = 'Bad debt write-off - DO NOT CHANGE';

/**********************************************************************************************************/
-- Step 5: Insert invoice lines into c_invoiceline
/**********************************************************************************************************/
INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, line, qtyinvoiced,
	               priceactual, linenetamt, c_charge_id, c_uom_id, c_tax_id, processed, qtyentered, priceentered,
	               c_invoiceline_uu, isfixedassetinvoice)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_invoice_id,
	line,
	qtyinvoiced,
	priceactual,
	linenetamt,
	c_charge_id,
	c_uom_id,
	c_tax_id,
	processed,
	qtyentered,
	priceentered,
	c_invoiceline_uu,
	isfixedassetinvoice
FROM
	tmp_c_invoiceline;

/**********************************************************************************************************/
-- Step 6: Create fact_acct records for the invoices
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_fact_acct;
CREATE TEMP TABLE tmp_fact_acct
(
	fact_acct_id    serial                  NOT NULL,
	ad_client_id    numeric(10)             NOT NULL,
	ad_org_id       numeric(10)             NOT NULL,
	createdby       numeric(10) DEFAULT 100 NOT NULL,
	updatedby       numeric(10) DEFAULT 100 NOT NULL,
	c_acctschema_id numeric(10)             NOT NULL,
	account_id      numeric(10)             NOT NULL,
	datetrx         timestamp               NOT NULL,
	dateacct        timestamp               NOT NULL,
	c_period_id     numeric(10),
	ad_table_id     numeric(10) DEFAULT 318 NOT NULL,
	record_id       numeric(10)             NOT NULL,
	line_id         numeric(10),
	gl_category_id  numeric(10),
	c_tax_id        numeric(10),
	postingtype     char        DEFAULT 'A' NOT NULL,
	c_currency_id   numeric(10)             NOT NULL,
	amtsourcedr     numeric                 NOT NULL,
	amtsourcecr     numeric                 NOT NULL,
	amtacctdr       numeric                 NOT NULL,
	amtacctcr       numeric                 NOT NULL,
	c_uom_id        numeric(10),
	qty             numeric,
	c_bpartner_id   numeric(10),
	c_locfrom_id    numeric(10),
	c_locto_id      numeric(10),
	description     varchar(255),
	fact_acct_uu    uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_fact_acct_fact_acct_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'Fact_Acct'
				LIMIT 1
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, dateacct, c_period_id, record_id,
	               line_id, gl_category_id, c_tax_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr,
	               c_uom_id, qty, c_bpartner_id, c_locfrom_id, c_locto_id, description)
SELECT
	til.ad_client_id,
	til.ad_org_id,
	accts.c_acctschema_id,
	vc.account_id,
	ti.dateinvoiced,
	ti.dateacct,
	p.c_period_id,
	til.c_invoice_id,
	CASE WHEN drcr.sign = 'CR' THEN til.c_invoiceline_id END,
	cat.gl_category_id,
	CASE WHEN drcr.sign = 'CR' THEN t.c_tax_id END,
	ti.c_currency_id,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE til.linenetamt END,
	CASE WHEN drcr.sign = 'CR' THEN til.linenetamt ELSE 0 END,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE til.linenetamt END,
	CASE WHEN drcr.sign = 'CR' THEN til.linenetamt ELSE 0 END,
	CASE WHEN drcr.sign = 'CR' THEN til.c_uom_id END,
	CASE WHEN drcr.sign = 'CR' THEN til.qtyentered * -1 END,
	ti.c_bpartner_id,
	oi.c_location_id,
	bpl.c_location_id,
	CASE WHEN drcr.sign = 'CR' THEN ti.documentno::varchar || ' #' || til.line ELSE ti.documentno::varchar END
FROM
	tmp_c_invoiceline til
		JOIN c_acctschema accts
			ON til.ad_client_id = accts.ad_client_id
		JOIN c_charge c
			ON til.c_charge_id = c.c_charge_id
		JOIN c_charge_acct ca
			ON c.c_charge_id = ca.c_charge_id
		JOIN c_validcombination vc
			ON ca.ch_expense_acct = vc.c_validcombination_id
		JOIN tmp_c_invoice ti
			ON ti.c_invoice_id = til.c_invoice_id
		JOIN c_period p
			ON til.ad_client_id = p.ad_client_id AND ti.dateinvoiced BETWEEN p.startdate AND p.enddate
		CROSS JOIN (
		VALUES ('DR'), ('CR')
	) drcr (sign)
		JOIN gl_category cat
			ON cat.ad_client_id = til.ad_client_id AND cat.name = 'AR Invoice'
		JOIN c_tax t
			ON t.ad_client_id = til.ad_client_id
		JOIN c_bpartner_location bpl
			ON ti.c_bpartner_location_id = bpl.c_bpartner_location_id
		JOIN ad_orginfo oi
			ON ti.ad_org_id = oi.ad_org_id;

/**********************************************************************************************************/
-- Step 7: Insert fact_acct records
/**********************************************************************************************************/
INSERT INTO
	fact_acct (fact_acct_id, ad_client_id, ad_org_id, createdby, updatedby, c_acctschema_id, account_id, datetrx,
	           dateacct, c_period_id, ad_table_id, record_id, line_id, gl_category_id, c_tax_id, postingtype,
	           c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, c_uom_id, qty, c_bpartner_id, c_locfrom_id,
	           c_locto_id, description, fact_acct_uu)
SELECT
	fact_acct_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_acctschema_id,
	account_id,
	datetrx,
	dateacct,
	c_period_id,
	ad_table_id,
	record_id,
	line_id,
	gl_category_id,
	c_tax_id,
	postingtype,
	c_currency_id,
	amtsourcedr,
	amtsourcecr,
	amtacctdr,
	amtacctcr,
	c_uom_id,
	qty,
	c_bpartner_id,
	c_locfrom_id,
	c_locto_id,
	description,
	fact_acct_uu
FROM
	tmp_fact_acct;

/**********************************************************************************************************/
-- Step 8: Update Business Partner open balances
/**********************************************************************************************************/
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
				JOIN (
				SELECT DISTINCT
					c_bpartner_id
				FROM
					tmp_otc_visits_without_invoices
			) ov
					ON bp.c_bpartner_id = ov.c_bpartner_id
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************/
-- Step 9: Update sequences
/**********************************************************************************************************/
UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoice WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'C_Invoice'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_invoice
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoiceline WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'C_InvoiceLine'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_invoiceline
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_fact_acct WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'Fact_Acct'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_fact_acct
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoice WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Invoice'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_invoice
	);

/**********************************************************************************************************/
-- Step 10: Cleanup and register
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_otc_visits_without_invoices;
DROP TABLE IF EXISTS tmp_c_invoice;
DROP TABLE IF EXISTS tmp_c_invoiceline;
DROP TABLE IF EXISTS tmp_fact_acct;

SELECT
	register_migration_script('202602051404_GO-3456.sql')
FROM
	dual;
