/**********************************************************************************************************/
-- Create missing payments and allocations for OTC patient visits that have completed orders but no payments
/**********************************************************************************************************/

-- First, identify OTC patient visits with completed orders but no payments
DROP TABLE IF EXISTS tmp_missing_otc_payments;
SELECT DISTINCT
	v.documentno,
	v.bh_visit_id,
	v.bh_visitdate,
	o.c_order_id,
	CASE
		WHEN ROUND(o.grandtotal - COALESCE(SUM(p.payamt), 0)) > 0
			THEN ROUND(o.grandtotal - COALESCE(SUM(p.payamt), 0))
		ELSE o.grandtotal END AS grandtotal,
	o.ad_client_id,
	o.ad_org_id,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.c_currency_id,
	o.dateordered,
	o.dateacct
INTO TEMP TABLE
	tmp_missing_otc_payments
FROM
	bh_visit v
		JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id AND o.grandtotal > 0 AND o.docstatus = 'CO'
		JOIN c_bpartner bp
			ON o.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
		LEFT JOIN c_payment p
			ON v.bh_visit_id = p.bh_visit_id
GROUP BY
	v.documentno,
	v.bh_visit_id,
	v.bh_visitdate,
	o.c_order_id,
	o.grandtotal,
	o.ad_client_id,
	o.ad_org_id,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.c_currency_id,
	o.dateordered,
	o.dateacct
HAVING
	o.grandtotal > 0
	AND (SUM(p.payamt) IS NULL OR SUM(p.payamt) != o.grandtotal)
	AND (CASE
		     WHEN ROUND(o.grandtotal - COALESCE(SUM(p.payamt), 0)) > 0
			     THEN ROUND(o.grandtotal - COALESCE(SUM(p.payamt), 0))
		     ELSE o.grandtotal END) > 0;

-- Create invoices for these visits if they don't exist
DROP TABLE IF EXISTS tmp_c_invoice_otc;
CREATE TEMP TABLE tmp_c_invoice_otc
(
	c_invoice_id           serial                           NOT NULL,
	ad_client_id           numeric(10)                      NOT NULL,
	ad_org_id              numeric(10)                      NOT NULL,
	createdby              numeric(10)  DEFAULT 100         NOT NULL,
	updatedby              numeric(10)  DEFAULT 100         NOT NULL,
	issotrx                char         DEFAULT 'Y'::bpchar NOT NULL,
	documentno             numeric                          NOT NULL,
	docstatus              char(2)      DEFAULT 'CO'        NOT NULL,
	docaction              char(2)      DEFAULT 'CL'        NOT NULL,
	processing             char         DEFAULT 'N',
	processed              char         DEFAULT 'Y'::bpchar NOT NULL,
	posted                 char         DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id           numeric(10)                      NOT NULL,
	c_doctypetarget_id     numeric(10)                      NOT NULL,
	c_order_id             numeric(10),
	description            varchar(255) DEFAULT 'OTC Patient Invoice - Auto Generated',
	salesrep_id            numeric(10),
	dateinvoiced           timestamp                        NOT NULL,
	dateacct               timestamp                        NOT NULL,
	c_bpartner_id          numeric(10)                      NOT NULL,
	c_bpartner_location_id numeric(10)                      NOT NULL,
	isdiscountprinted      char         DEFAULT 'Y'::bpchar NOT NULL,
	dateordered            timestamp                        NOT NULL,
	c_currency_id          numeric(10)                      NOT NULL,
	paymentrule            char         DEFAULT 'P'         NOT NULL,
	c_paymentterm_id       numeric(10)                      NOT NULL,
	totallines             numeric                          NOT NULL,
	grandtotal             numeric                          NOT NULL,
	m_pricelist_id         numeric(10)                      NOT NULL,
	ispaid                 char         DEFAULT 'Y'::bpchar NOT NULL,
	processedon            numeric,
	c_invoice_uu           varchar(36)  DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char         DEFAULT 'N'
);

SELECT
	SETVAL(
			'tmp_c_invoice_otc_c_invoice_id_seq',
			(
				SELECT
					COALESCE(MAX(c_invoice_id), 0) + 1
				FROM
					c_invoice
			)::INT,
			FALSE
	);

-- Create invoices from the orders
INSERT INTO
	tmp_c_invoice_otc (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	                   salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered, c_currency_id,
	                   c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon)
SELECT
	mp.ad_client_id,
	mp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	mp.c_order_id,
	o.salesrep_id,
	mp.dateordered,
	mp.dateacct,
	mp.c_bpartner_id,
	mp.c_bpartner_location_id,
	mp.dateordered,
	mp.c_currency_id,
	pt.c_paymentterm_id,
	o.totallines,
	mp.grandtotal,
	o.m_pricelist_id,
	EXTRACT(EPOCH FROM mp.dateordered) * 1000
FROM
	tmp_missing_otc_payments mp
		JOIN c_order o
			ON mp.c_order_id = o.c_order_id
		JOIN ad_sequence seq
			ON seq.ad_client_id = mp.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON mp.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
		JOIN c_paymentterm pt
			ON pt.ad_client_id = mp.ad_client_id AND pt.value = 'Immediate';

-- Update the document numbers
UPDATE tmp_c_invoice_otc i
SET
	documentno = documentno + ti.row_num
FROM
	(
		SELECT
			c_invoice_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice_otc
	) ti
WHERE
	i.c_invoice_id = ti.c_invoice_id;

-- Insert the invoices
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, issotrx, documentno, docstatus, docaction,
	           processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id,
	           dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, isdiscountprinted, dateordered,
	           c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal, m_pricelist_id, ispaid, processedon,
	           c_invoice_uu, isfixedassetinvoice)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	issotrx,
	documentno,
	docstatus,
	docaction,
	processing,
	processed,
	posted,
	c_doctype_id,
	c_doctypetarget_id,
	c_order_id,
	description,
	salesrep_id,
	dateinvoiced,
	dateacct,
	c_bpartner_id,
	c_bpartner_location_id,
	isdiscountprinted,
	dateordered,
	c_currency_id,
	paymentrule,
	c_paymentterm_id,
	totallines,
	grandtotal,
	m_pricelist_id,
	ispaid,
	processedon,
	c_invoice_uu,
	isfixedassetinvoice
FROM
	tmp_c_invoice_otc;

-- Create invoice lines from order lines
INSERT INTO c_invoiceline (
	ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, c_orderline_id, line,
	description, m_product_id, qtyinvoiced, qtyentered, pricelist, priceactual, pricelimit,
	linenetamt, c_charge_id, c_uom_id, processed, c_invoice_uu
)
SELECT
	i.ad_client_id,
	i.ad_org_id,
	i.createdby,
	i.updatedby,
	i.c_invoice_id,
	ol.c_orderline_id,
	ol.line,
	ol.description,
	ol.m_product_id,
	ol.qtyordered,
	ol.qtyentered,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt,
	ol.c_charge_id,
	ol.c_uom_id,
	'Y',
	i.c_invoice_uu
FROM
	tmp_c_invoice_otc i
		JOIN c_orderline ol
			ON i.c_order_id = ol.c_order_id;

-- Create payments for these invoices
DROP TABLE IF EXISTS tmp_c_payment_otc;
CREATE TEMP TABLE tmp_c_payment_otc
(
	c_payment_id       serial                           NOT NULL,
	ad_client_id       numeric(10)                      NOT NULL,
	ad_org_id          numeric(10)                      NOT NULL,
	createdby          numeric(10)  DEFAULT 100         NOT NULL,
	updatedby          numeric(10)  DEFAULT 100         NOT NULL,
	documentno         numeric                          NOT NULL,
	datetrx            timestamp                        NOT NULL,
	dateacct           timestamp                        NOT NULL,
	isreceipt          char        DEFAULT 'Y'::bpchar  NOT NULL,
	c_doctype_id       numeric(10)                      NOT NULL,
	trxtype            char        DEFAULT 'P'          NOT NULL,
	c_bankaccount_id   numeric(10)                      NOT NULL,
	c_bpartner_id      numeric(10)                      NOT NULL,
	c_invoice_id       numeric(10),
	tendertype         char        DEFAULT 'X'          NOT NULL,
	c_currency_id      numeric(10)                      NOT NULL,
	payamt             numeric                          NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar  NOT NULL,
	processing         char        DEFAULT 'N',
	docstatus          char(2)     DEFAULT 'CO'         NOT NULL,
	docaction          char(2)     DEFAULT 'CL'         NOT NULL,
	isallocated        char        DEFAULT 'Y'::bpchar  NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar  NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar  NOT NULL,
	isoverunderpayment char        DEFAULT 'N'::bpchar  NOT NULL,
	processedon        numeric,
	c_payment_uu       varchar(36) DEFAULT uuid_generate_v4(),
	bh_tender_amount   numeric     						NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_payment_otc_c_payment_id_seq',
			(
				SELECT
					COALESCE(MAX(c_payment_id), 0) + 1
				FROM
					c_payment
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_payment_otc (ad_client_id, ad_org_id, documentno, datetrx, dateacct, c_doctype_id, c_bankaccount_id,
	                   c_bpartner_id, c_invoice_id, c_currency_id, payamt, processedon, bh_tender_amount)
SELECT
	i.ad_client_id,
	i.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	i.dateinvoiced,
	i.dateacct,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	i.c_bpartner_id,
	i.c_invoice_id,
	i.c_currency_id,
	i.grandtotal,
	EXTRACT(EPOCH FROM i.dateinvoiced) * 1000,
	i.grandtotal
FROM
	tmp_c_invoice_otc i
		JOIN c_doctype dt
			ON i.ad_client_id = dt.ad_client_id AND docbasetype = 'ARR'
		JOIN ad_sequence seq
			ON i.ad_client_id = seq.ad_client_id AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON i.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y';

-- Update the document numbers
UPDATE tmp_c_payment_otc tp
SET
	documentno = documentno + tpc.row_num
FROM
	(
		SELECT
			c_payment_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_payment_id) AS row_num
		FROM
			tmp_c_payment_otc
	) tpc
WHERE
	tp.c_payment_id = tpc.c_payment_id;

-- Insert the payments
INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, isreceipt,
	           c_doctype_id, trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype, c_currency_id,
	           payamt, isapproved, processing, docstatus, docaction, isallocated, processed,
	           posted, isoverunderpayment, dateacct, processedon, c_payment_uu, bh_tender_amount)
SELECT
	c_payment_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno,
	datetrx,
	isreceipt,
	c_doctype_id,
	trxtype,
	c_bankaccount_id,
	c_bpartner_id,
	c_invoice_id,
	tendertype,
	c_currency_id,
	payamt,
	isapproved,
	processing,
	docstatus,
	docaction,
	isallocated,
	processed,
	posted,
	isoverunderpayment,
	dateacct,
	processedon,
	c_payment_uu,
	bh_tender_amount
FROM
	tmp_c_payment_otc;

-- Create allocation headers
DROP TABLE IF EXISTS tmp_c_allocationhdr_otc;
CREATE TEMP TABLE tmp_c_allocationhdr_otc
(
	c_allocationhdr_id serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	description        varchar(255),
	datetrx            timestamp                        NOT NULL,
	dateacct           timestamp                        NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	c_doctype_id       numeric(10)                     NOT NULL,
	tmp_c_payment_id   numeric(10)                     NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_allocationhdr_otc_c_allocationhdr_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationhdr_id), 0) + 1
				FROM
					c_allocationhdr
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_allocationhdr_otc (ad_client_id, ad_org_id, documentno, description, datetrx, dateacct, c_currency_id,
	                         c_doctype_id, tmp_c_payment_id, processedon)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || tp.documentno,
	tp.datetrx,
	tp.dateacct,
	tp.c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id,
	tp.processedon
FROM
	tmp_c_payment_otc tp
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA'
		JOIN ad_sequence seq
			ON tp.ad_client_id = seq.ad_client_id AND seq.name = 'Allocation';

-- Update the document numbers
UPDATE tmp_c_allocationhdr_otc tah
SET
	documentno = documentno + tahc.row_num
FROM
	(
		SELECT
			c_allocationhdr_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_allocationhdr_id) AS row_num
		FROM
			tmp_c_allocationhdr_otc
	) tahc
WHERE
	tah.c_allocationhdr_id = tahc.c_allocationhdr_id;

-- Insert the real allocation headers!
INSERT INTO
	c_allocationhdr (c_allocationhdr_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, description, datetrx,
	                 dateacct, c_currency_id, docstatus, docaction, isapproved, processing, processed, posted,
	                 processedon, c_allocationhdr_uu, c_doctype_id)
SELECT
	c_allocationhdr_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno,
	description,
	datetrx,
	dateacct,
	c_currency_id,
	docstatus,
	docaction,
	isapproved,
	processing,
	processed,
	posted,
	processedon,
	c_allocationhdr_uu,
	c_doctype_id
FROM
	tmp_c_allocationhdr_otc;

-- Create allocation lines
DROP TABLE IF EXISTS tmp_c_allocationline_otc;
CREATE TEMP TABLE tmp_c_allocationline_otc
(
	c_allocationline_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	c_invoice_id        numeric(10),
	c_bpartner_id       numeric(10),
	c_payment_id        numeric(10),
	amount              numeric                 NOT NULL,
	c_allocationhdr_id  numeric(10)             NOT NULL,
	c_allocationline_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_allocationline_otc_c_allocationline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationline_id), 0) + 1
				FROM
					c_allocationline
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_allocationline_otc (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	tp.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	tp.payamt,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment_otc tp
		JOIN tmp_c_allocationhdr_otc tah
			ON tp.c_payment_id = tah.tmp_c_payment_id;

-- Insert the real allocation lines
INSERT INTO
	c_allocationline (c_allocationline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, c_bpartner_id,
	                  c_payment_id, amount, c_allocationhdr_id, c_allocationline_uu)
SELECT
	c_allocationline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_invoice_id,
	c_bpartner_id,
	c_payment_id,
	amount,
	c_allocationhdr_id,
	c_allocationline_uu
FROM
	tmp_c_allocationline_otc;

-- Update sequences
UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoice_otc WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Invoice'
	AND ad_client_id IN (SELECT DISTINCT ad_client_id FROM tmp_c_invoice_otc);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_payment_otc WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Payment'
	AND ad_client_id IN (SELECT DISTINCT ad_client_id FROM tmp_c_payment_otc);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_allocationhdr_otc WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'Allocation'
	AND ad_client_id IN (SELECT DISTINCT ad_client_id FROM tmp_c_allocationhdr_otc);

-- Clean up temporary tables
DROP TABLE IF EXISTS tmp_missing_otc_payments;
DROP TABLE IF EXISTS tmp_c_invoice_otc;
DROP TABLE IF EXISTS tmp_c_payment_otc;
DROP TABLE IF EXISTS tmp_c_allocationhdr_otc;
DROP TABLE IF EXISTS tmp_c_allocationline_otc;

SELECT
	register_migration_script('202511181439_GO-3456.sql')
FROM
	dual;
