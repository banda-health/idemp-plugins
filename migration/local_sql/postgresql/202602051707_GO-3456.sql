/**********************************************************************************************************/
-- GO-3456: Fix OTC patient payment issues
/**********************************************************************************************************/

/**********************************************************************************************************/
-- PART 1 (202511181439): Create missing payments and allocations for OTC patient visits
--                        that have completed orders but no payments
/**********************************************************************************************************/

-- First, identify OTC patient visits with completed orders but no payments
DROP TABLE IF EXISTS tmp_missing_otc_payments;
SELECT DISTINCT
	v.documentno,
	v.bh_visit_id,
	v.bh_visitdate,
	o.c_order_id,
	CASE
		WHEN ROUND(o.grandtotal) - COALESCE(SUM(ROUND(p.payamt)), 0) > 0
			THEN ROUND(o.grandtotal) - COALESCE(SUM(ROUND(p.payamt)), 0)
		ELSE o.grandtotal END          AS grandtotal,
	o.ad_client_id,
	o.ad_org_id,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.c_currency_id,
	o.dateordered,
	o.dateacct,
	COALESCE(MAX(p.tendertype), 'X') AS tendertype
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
			ON v.bh_visit_id = p.bh_visit_id AND p.isallocated = 'Y'
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
	AND (SUM(ROUND(p.payamt)) IS NULL OR SUM(ROUND(p.payamt)) != ROUND(o.grandtotal))
	AND (CASE
		     WHEN ROUND(o.grandtotal) - COALESCE(SUM(ROUND(p.payamt)), 0) > 0
			     THEN ROUND(o.grandtotal) - COALESCE(SUM(ROUND(p.payamt)), 0)
		     ELSE o.grandtotal END) > 0;

-- Create or collect invoices for these visits (use existing or create new)
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
	isfixedassetinvoice    char         DEFAULT 'N',
	bh_visit_id            numeric(10)                      NOT NULL,
	is_new                 char         DEFAULT 'Y'::bpchar NOT NULL
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
-- Check invoices for OTC patient visits
-- First, collect existing invoices
INSERT INTO
	tmp_c_invoice_otc (c_invoice_id, ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	                   description, salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id,
	                   dateordered, c_currency_id,
	                   c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon, bh_visit_id, is_new)
SELECT
	i.c_invoice_id,
	i.ad_client_id,
	i.ad_org_id,
	i.documentno::numeric,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.c_order_id,
	'OTC Patient Invoice - Existing',
	i.salesrep_id,
	i.dateinvoiced,
	i.dateacct,
	i.c_bpartner_id,
	i.c_bpartner_location_id,
	i.dateordered,
	i.c_currency_id,
	i.c_paymentterm_id,
	i.totallines,
	i.grandtotal,
	i.m_pricelist_id,
	i.processedon,
	i.bh_visit_id,
	'N'
FROM
	tmp_missing_otc_payments mp
		JOIN c_invoice i
			ON mp.bh_visit_id = i.bh_visit_id AND i.docstatus IN ('CO', 'CL');

-- Then, create new invoices for visits that don't have existing invoices
INSERT INTO
	tmp_c_invoice_otc (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	                   salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered,
	                   c_currency_id,
	                   c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon, bh_visit_id)
SELECT
	mp.ad_client_id,
	mp.ad_org_id,
	seq.currentnext - 1,
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
	EXTRACT(EPOCH FROM mp.dateordered) * 1000,
	mp.bh_visit_id
FROM
	tmp_missing_otc_payments mp
		JOIN c_order o
			ON mp.c_order_id = o.c_order_id
		JOIN ad_sequence seq
			ON seq.ad_client_id = mp.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON mp.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
		JOIN c_paymentterm pt
			ON pt.ad_client_id = mp.ad_client_id AND pt.value = 'Immediate'
		LEFT JOIN c_invoice i
			ON mp.bh_visit_id = i.bh_visit_id AND i.docstatus IN ('CO', 'CL')
WHERE
	i.c_invoice_id IS NULL;


-- Update the document numbers
UPDATE tmp_c_invoice_otc i
SET
	documentno = documentno + ti.row_num
FROM
	(
		SELECT
			c_invoice_id,
			ad_client_id,
			c_doctype_id,
					ROW_NUMBER() OVER (PARTITION BY ad_client_id, c_doctype_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice_otc
		WHERE
			is_new = 'Y'
	) ti
WHERE
	i.c_invoice_id = ti.c_invoice_id
	AND i.is_new = 'Y';

-- Insert only the NEW invoices (existing ones are already in the database)
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, issotrx, documentno, docstatus, docaction,
	           processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id,
	           dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, isdiscountprinted, dateordered,
	           c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal, m_pricelist_id, ispaid, processedon,
	           c_invoice_uu, isfixedassetinvoice, bh_visit_id)
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
	isfixedassetinvoice,
	bh_visit_id
FROM
	tmp_c_invoice_otc
WHERE
	is_new = 'Y';

/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoiceline_otc;
CREATE TEMP TABLE tmp_c_invoiceline_otc
(
	c_invoiceline_id          serial                           NOT NULL,
	ad_client_id              numeric(10)                      NOT NULL,
	ad_org_id                 numeric(10)                      NOT NULL,
	isactive                  char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby                 numeric(10)  DEFAULT 100         NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                 numeric(10)  DEFAULT 100         NOT NULL,
	c_invoice_id              numeric(10)                      NOT NULL,
	c_orderline_id            numeric(10),
	m_inoutline_id            numeric(10),
	line                      numeric(10)                      NOT NULL,
	description               varchar(255) DEFAULT 'OTC Patient Invoice line - Auto Generated',
	m_product_id              numeric(10)                      NOT NULL,
	qtyinvoiced               numeric                          NOT NULL,
	pricelist                 numeric                          NOT NULL,
	priceactual               numeric                          NOT NULL,
	pricelimit                numeric                          NOT NULL,
	linenetamt                numeric                          NOT NULL,
--	c_charge_id               numeric(10),
	c_uom_id                  numeric(10)                      NOT NULL,
	c_tax_id                  numeric(10)                      NOT NULL,
--	s_resourceassignment_id   numeric(10),
--	a_asset_id                numeric(10),
--	taxamt                    numeric     DEFAULT 0,
	m_attributesetinstance_id numeric(10)                      NOT NULL,
--	isdescription             char        DEFAULT 'N'::bpchar NOT NULL,
--	isprinted                 char        DEFAULT 'Y'::bpchar NOT NULL,
	linetotalamt              numeric                          NOT NULL,
--	ref_invoiceline_id        numeric(10),
	processed                 char         DEFAULT 'Y'::bpchar NOT NULL,
	qtyentered                numeric                          NOT NULL,
	priceentered              numeric                          NOT NULL,
--	c_project_id              numeric(10),
--	c_projectphase_id         numeric(10),
--	c_projecttask_id          numeric(10),
--	rrstartdate               timestamp,
--	rramt                     numeric,
--	c_campaign_id             numeric(10),
--	c_activity_id             numeric(10),
--	user1_id                  numeric(10),
--	user2_id                  numeric(10),
--	ad_orgtrx_id              numeric(10),
--	m_rmaline_id              numeric(10),
--	a_createasset             char        DEFAULT 'N'::bpchar,
--	a_processed               char        DEFAULT 'N'::bpchar,
--	a_capvsexp                varchar(3),
--	a_asset_group_id          numeric(10),
	c_invoiceline_uu          varchar(36)  DEFAULT uuid_generate_v4(),
	isfixedassetinvoice       char         DEFAULT 'N'
--	c_1099box_id              numeric(10) DEFAULT NULL::numeric
);

-- First, collect existing invoice lines for existing invoices
SELECT
	SETVAL(
			'tmp_c_invoiceline_otc_c_invoiceline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_invoiceline_id), 0) + 1
				FROM
					c_invoiceline
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_invoiceline_otc (c_invoiceline_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, c_invoice_id,
	                       c_orderline_id, m_inoutline_id, line, description, m_product_id, qtyinvoiced,
	                       pricelist, priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id,
	                       m_attributesetinstance_id, linetotalamt, processed, qtyentered, priceentered,
	                       c_invoiceline_uu, isfixedassetinvoice)
SELECT
	il.c_invoiceline_id,
	il.ad_client_id,
	il.ad_org_id,
	il.isactive,
	il.createdby,
	il.updatedby,
	il.c_invoice_id,
	il.c_orderline_id,
	il.m_inoutline_id,
	il.line,
	il.description,
	il.m_product_id,
	il.qtyinvoiced,
	il.pricelist,
	il.priceactual,
	il.pricelimit,
	il.linenetamt,
	il.c_uom_id,
	il.c_tax_id,
	il.m_attributesetinstance_id,
	il.linetotalamt,
	il.processed,
	il.qtyentered,
	il.priceentered,
	il.c_invoiceline_uu,
	il.isfixedassetinvoice
FROM
	tmp_c_invoice_otc ti
		JOIN c_invoiceline il
			ON ti.c_invoice_id = il.c_invoice_id
WHERE
	ti.is_new = 'N';
-- Only for existing invoices

-- Then, create new invoice lines for new invoices
INSERT INTO
	tmp_c_invoiceline_otc (ad_client_id, ad_org_id, c_invoice_id, c_orderline_id, m_inoutline_id, line, m_product_id,
	                       qtyinvoiced, pricelist, priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id,
	                       m_attributesetinstance_id, linetotalamt, qtyentered, priceentered,
	                       description, isactive, createdby, updatedby, processed, isfixedassetinvoice)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.c_invoice_id,
	ol.c_orderline_id,
	iol.m_inoutline_id,
	ol.line,
	ol.m_product_id,
	ol.qtyordered,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt,
	ol.qtyentered,
	ol.priceentered,
	'OTC Patient Invoice line - Auto Generated',
	'Y',
	100,
	100,
	'Y',
	'N'
FROM
	tmp_c_invoice_otc ti
		JOIN c_orderline ol
			ON ti.c_order_id = ol.c_order_id
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id
WHERE
	ti.is_new = 'Y';
-- Only for new invoices


-- Insert only the NEW invoice lines (existing ones are already in the database)
INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, c_invoice_id,
	               c_orderline_id, m_inoutline_id, line, m_product_id, qtyinvoiced, pricelist, priceactual, pricelimit,
	               linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt, processed, qtyentered,
	               priceentered, c_invoiceline_uu, isfixedassetinvoice, description)
SELECT
	til.c_invoiceline_id,
	til.ad_client_id,
	til.ad_org_id,
	til.isactive,
	til.createdby,
	til.updatedby,
	til.c_invoice_id,
	til.c_orderline_id,
	til.m_inoutline_id,
	til.line,
	til.m_product_id,
	til.qtyinvoiced,
	til.pricelist,
	til.priceactual,
	til.pricelimit,
	til.linenetamt,
	til.c_uom_id,
	til.c_tax_id,
	til.m_attributesetinstance_id,
	til.linetotalamt,
	til.processed,
	til.qtyentered,
	til.priceentered,
	til.c_invoiceline_uu,
	til.isfixedassetinvoice,
	til.description
FROM
	tmp_c_invoiceline_otc til
WHERE
	til.c_invoiceline_id NOT IN (
		SELECT c_invoiceline_id
		FROM c_invoiceline
	);

-- Create payments for these invoices
DROP TABLE IF EXISTS tmp_c_payment_otc;
CREATE TEMP TABLE tmp_c_payment_otc
(
	c_payment_id       serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric						   NOT NULL,
	description        varchar(255) DEFAULT 'OTC Patient Payment - Auto Generated',
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp                       NOT NULL,
	isreceipt          char        DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'P'         NOT NULL,
	c_bankaccount_id   numeric(10)                     NOT NULL,
	c_bpartner_id      numeric(10)                     NOT NULL,
	c_invoice_id       numeric(10),
	tendertype         char        DEFAULT 'X'         NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	payamt             numeric                         NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isallocated        char        DEFAULT 'Y'::bpchar NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	isoverunderpayment char        DEFAULT 'N'::bpchar NOT NULL,
	processedon        numeric,
	c_payment_uu       varchar(36) DEFAULT uuid_generate_v4(),
	bh_tender_amount   numeric                         NOT NULL,
	bh_visit_id        numeric(10)                     NOT NULL
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
	                   c_bpartner_id, c_invoice_id, c_currency_id, payamt, processedon, bh_tender_amount, tendertype,
	                   bh_visit_id)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	seq.currentnext - 1,
	ti.dateinvoiced,
	ti.dateacct,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	ti.c_bpartner_id,
	ti.c_invoice_id,
	ti.c_currency_id,
	p.grandtotal,
	EXTRACT(EPOCH FROM ti.dateinvoiced) * 1000,
	p.grandtotal,
	p.tendertype,
	p.bh_visit_id
FROM
	tmp_missing_otc_payments p
		JOIN tmp_c_invoice_otc ti
			ON p.bh_visit_id = ti.bh_visit_id
		JOIN c_doctype dt
			ON ti.ad_client_id = dt.ad_client_id AND docbasetype = 'ARR'
		JOIN ad_sequence seq
			ON ti.ad_client_id = seq.ad_client_id AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON ti.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y';

-- Update the document numbers
UPDATE tmp_c_payment_otc tp
SET
	documentno = documentno + tpc.row_num
FROM
	(
		SELECT
			c_payment_id,
			ad_client_id,
			c_doctype_id,
					ROW_NUMBER() OVER (PARTITION BY ad_client_id, c_doctype_id ORDER BY c_payment_id) AS row_num
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
	           posted, isoverunderpayment, dateacct, processedon, c_payment_uu, bh_tender_amount, bh_visit_id)
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
	bh_tender_amount,
	bh_visit_id
FROM
	tmp_c_payment_otc;

/**********************************************************************************************************/
-- Create accounting entries for payments
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_fact_acct_otc;
CREATE TEMP TABLE tmp_fact_acct_otc
(
	fact_acct_id    serial                          NOT NULL,
	ad_client_id    numeric(10)                     NOT NULL,
	ad_org_id       numeric(10)                     NOT NULL,
	createdby       numeric(10) DEFAULT 100         NOT NULL,
	updatedby       numeric(10) DEFAULT 100         NOT NULL,
	c_acctschema_id numeric(10)                     NOT NULL,
	account_id      numeric(10)                     NOT NULL,
	datetrx         timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct        timestamp   DEFAULT date(NOW()) NOT NULL,
	c_period_id     numeric(10),
	ad_table_id     numeric(10) DEFAULT 335         NOT NULL,
	record_id       numeric(10)                     NOT NULL,
	line_id         numeric(10),
	gl_category_id  numeric(10),
	c_tax_id        numeric(10),
	postingtype     char        DEFAULT 'A'         NOT NULL,
	c_currency_id   numeric(10)                     NOT NULL,
	amtsourcedr     numeric                         NOT NULL,
	amtsourcecr     numeric                         NOT NULL,
	amtacctdr       numeric                         NOT NULL,
	amtacctcr       numeric                         NOT NULL,
	qty             numeric     DEFAULT 0,
	c_bpartner_id   numeric(10),
	description     varchar(255),
	fact_acct_uu    uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_fact_acct_otc_fact_acct_id_seq',
			(
				SELECT
					COALESCE(MAX(fact_acct_id), 0) + 1
				FROM
					fact_acct
			)::INT,
			FALSE
	);

-- Enter the accounting for payments
INSERT INTO
	tmp_fact_acct_otc (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, c_period_id, ad_table_id, record_id,
	                   gl_category_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty,
	                   c_bpartner_id, description)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	accts.c_acctschema_id,
	CASE WHEN drcr.sign = 'CR' THEN ev_11100.c_elementvalue_id ELSE ev_21100.c_elementvalue_id END,
	tp.datetrx,
	p.c_period_id,
	335,
	tp.c_payment_id,
	cat.gl_category_id,
	tp.c_currency_id,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE tp.payamt END,
	CASE WHEN drcr.sign = 'CR' THEN tp.payamt ELSE 0 END,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE tp.payamt END,
	CASE WHEN drcr.sign = 'CR' THEN tp.payamt ELSE 0 END,
	0,
	tp.c_bpartner_id,
	tp.documentno
FROM
	tmp_c_payment_otc tp
		JOIN c_acctschema accts
			ON tp.ad_client_id = accts.ad_client_id
		JOIN c_period p
			ON tp.ad_client_id = p.ad_client_id AND NOW() BETWEEN startdate AND enddate
		CROSS JOIN (
		VALUES ('DR'), ('CR')
	) drcr (sign)
		JOIN gl_category cat
			ON cat.ad_client_id = tp.ad_client_id AND cat.name = 'AP Payment'
		JOIN c_elementvalue ev_21100
			ON tp.ad_client_id = ev_21100.ad_client_id AND ev_21100.value = '21100'
		JOIN c_elementvalue ev_11100
			ON tp.ad_client_id = ev_11100.ad_client_id AND ev_11100.value = '11100'
		JOIN c_tax t
			ON t.ad_client_id = tp.ad_client_id;

-- Insert the real accounts
INSERT INTO
	fact_acct (fact_acct_id, ad_client_id, ad_org_id, createdby, updatedby, c_acctschema_id, account_id, datetrx,
	           dateacct, c_period_id, ad_table_id, record_id, line_id, gl_category_id, c_tax_id, postingtype,
	           c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty, c_bpartner_id, description,
	           fact_acct_uu)
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
	qty,
	c_bpartner_id,
	description,
	fact_acct_uu
FROM
	tmp_fact_acct_otc;

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
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp                       NOT NULL,
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
	GREATEST(seq.currentnext - 1, COALESCE((
		                                       SELECT
			                                       MAX(CAST(documentno AS numeric))
		                                       FROM
			                                       c_allocationhdr
		                                       WHERE
			                                       ad_client_id = tp.ad_client_id
			                                       AND c_doctype_id = dt.c_doctype_id
	                                       ),
	                                       0)), -- Use the greater of sequence or max documentno to handle out-of-sync sequences
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
			ad_client_id,
			c_doctype_id,
					ROW_NUMBER() OVER (PARTITION BY ad_client_id, c_doctype_id ORDER BY c_allocationhdr_id) AS row_num
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
	tmp_c_allocationline_otc (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount,
	                          c_allocationhdr_id)
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
		SELECT COUNT(*) FROM tmp_c_invoice_otc WHERE ad_client_id = ad_sequence.ad_client_id AND is_new = 'Y'
	)
WHERE
	name = 'DocumentNo_C_Invoice'
	AND ad_client_id IN (
		SELECT DISTINCT ad_client_id
		FROM tmp_c_invoice_otc
		WHERE is_new = 'Y'
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoiceline_otc til
			JOIN tmp_c_invoice_otc ti ON til.c_invoice_id = ti.c_invoice_id AND ti.is_new = 'Y'
		    WHERE til.ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_InvoiceLine'
	AND ad_client_id IN (
		SELECT DISTINCT ad_client_id
		FROM tmp_c_invoiceline_otc
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_payment_otc WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Payment'
	AND ad_client_id IN (
		SELECT DISTINCT ad_client_id
		FROM tmp_c_payment_otc
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_allocationhdr_otc WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'Allocation'
	AND ad_client_id IN (
		SELECT DISTINCT ad_client_id
		FROM tmp_c_allocationhdr_otc
	);

-- Clean up temporary tables
DROP TABLE IF EXISTS tmp_missing_otc_payments;
DROP TABLE IF EXISTS tmp_c_invoice_otc;
DROP TABLE IF EXISTS tmp_c_invoiceline_otc;
DROP TABLE IF EXISTS tmp_c_payment_otc;
DROP TABLE IF EXISTS tmp_fact_acct_otc;
DROP TABLE IF EXISTS tmp_c_allocationline_otc;
DROP TABLE IF EXISTS tmp_c_allocationhdr_otc;

/**********************************************************************************************************/
-- PART 2 (202602021537): Complete drafted payments for visits with complete orders and invoices
/**********************************************************************************************************/

-- Step 1: Identify drafted payments that need to be completed
-- Exclude payments where invoices are already fully paid by other payments
DROP TABLE IF EXISTS tmp_payments_to_complete;
CREATE TEMP TABLE tmp_payments_to_complete AS
SELECT DISTINCT
	p.c_payment_id,
	p.ad_client_id,
	p.ad_org_id,
	p.bh_visit_id,
	p.c_bpartner_id,
	p.c_currency_id,
	p.payamt,
	p.datetrx,
	p.dateacct,
	p.documentno,
	p.c_bankaccount_id,
	p.isreceipt,
	p.c_doctype_id
FROM
	c_payment p
		JOIN bh_visit v
			ON p.bh_visit_id = v.bh_visit_id
		JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id
		AND o.docstatus = 'CO'
		AND o.issotrx = 'Y'
		JOIN c_invoice i
			ON o.c_order_id = i.c_order_id
		AND i.docstatus = 'CO'
		AND i.issotrx = 'Y'
		AND (i.ispaid = 'N' OR i.ispaid IS NULL)
WHERE
	p.docstatus = 'DR'
	AND p.bh_visit_id > 0
	AND p.isreceipt = 'Y'
	-- Exclude payments where invoice is already fully allocated by other payments
	AND i.grandtotal > COALESCE(
			(
				SELECT
					SUM(al.amount)
				FROM
					c_allocationline al
						JOIN c_allocationhdr ah
							ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE
					al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus = 'CO'
			),
			0
	                   )
	-- Only include invoices with exactly one payment
	AND (
		    SELECT
			    COUNT(*)
		    FROM
			    c_payment p2
				    JOIN bh_visit v2
					    ON p2.bh_visit_id = v2.bh_visit_id
				    JOIN c_order o2
					    ON v2.bh_visit_id = o2.bh_visit_id
				    AND o2.docstatus = 'CO'
				    AND o2.issotrx = 'Y'
				    JOIN c_invoice i2
					    ON o2.c_order_id = i2.c_order_id
		    WHERE
			    i2.c_invoice_id = i.c_invoice_id
			    AND p2.bh_visit_id = p.bh_visit_id
	    ) = 1;

-- Step 2: Complete the payments
UPDATE c_payment
SET
	docstatus   = 'CO',
	docaction   = 'CL',
	processed   = 'Y',
	posted      = 'Y',
	isallocated = 'Y',
	processing  = 'N',
	processedon = EXTRACT(EPOCH FROM NOW()) * 1000,
	updated     = NOW(),
	updatedby   = 100
WHERE
	c_payment_id IN (
		SELECT
			c_payment_id
		FROM
			tmp_payments_to_complete
	);

-- Step 3: Create allocation headers
DROP TABLE IF EXISTS tmp_c_allocationhdr;
CREATE TEMP TABLE tmp_c_allocationhdr
(
	c_allocationhdr_id serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	description        varchar(255),
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp                       NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	c_doctype_id       numeric(10)                     NOT NULL,
	tmp_c_payment_id   numeric(10)                     NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_allocationhdr_c_allocationhdr_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationhdr_id), 0) + 1
				FROM
					c_allocationhdr
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, datetrx, dateacct, c_currency_id, c_doctype_id,
	                     tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || tp.documentno,
	tp.datetrx,
	tp.dateacct,
	tp.c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_payments_to_complete tp
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA'
		JOIN ad_sequence seq
			ON tp.ad_client_id = seq.ad_client_id AND seq.name = 'Allocation';

-- Update the document numbers
UPDATE tmp_c_allocationhdr tah
SET
	documentno = documentno + tahc.row_num
FROM
	(
		SELECT
			c_allocationhdr_id,
			ROW_NUMBER() OVER (PARTITION BY ad_client_id ORDER BY c_allocationhdr_id) AS row_num
		FROM
			tmp_c_allocationhdr
	) tahc
WHERE
	tah.c_allocationhdr_id = tahc.c_allocationhdr_id;

-- Insert the real allocation headers
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
	tmp_c_allocationhdr;

-- Step 4: Create allocation lines linking payments to invoices
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TEMP TABLE tmp_c_allocationline
(
	c_allocationline_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	c_invoice_id        numeric(10)             NOT NULL,
	c_bpartner_id       numeric(10)             NOT NULL,
	c_payment_id        numeric(10)             NOT NULL,
	amount              numeric                 NOT NULL,
	discountamt         numeric     DEFAULT 0   NOT NULL,
	writeoffamt         numeric     DEFAULT 0   NOT NULL,
	overunderamt        numeric     DEFAULT 0   NOT NULL,
	c_allocationhdr_id  numeric(10)             NOT NULL,
	c_allocationline_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_allocationline_c_allocationline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationline_id), 0) + 1
				FROM
					c_allocationline
			)::INT,
			FALSE
	);

-- Create allocation lines for each payment-invoice pair
-- Handle partial payments and multiple invoices per visit
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	i.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	-- Allocate payment amount against invoice, handling partial payments
	LEAST(
			i.grandtotal - COALESCE(
					(
						SELECT
							SUM(al.amount)
						FROM
							c_allocationline al
								JOIN c_allocationhdr ah
									ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						WHERE
							al.c_invoice_id = i.c_invoice_id
							AND ah.docstatus = 'CO'
					),
					0
			               ),
			tp.payamt - COALESCE(
					(
						SELECT
							SUM(al.amount)
						FROM
							c_allocationline al
								JOIN c_allocationhdr ah
									ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						WHERE
							al.c_payment_id = tp.c_payment_id
							AND ah.docstatus = 'CO'
					),
					0
			            )
	) AS amount,
	tah.c_allocationhdr_id
FROM
	tmp_payments_to_complete tp
		JOIN tmp_c_allocationhdr tah
			ON tp.c_payment_id = tah.tmp_c_payment_id
		JOIN c_order o
			ON tp.bh_visit_id = o.bh_visit_id
		AND o.docstatus = 'CO'
		AND o.issotrx = 'Y'
		JOIN c_invoice i
			ON o.c_order_id = i.c_order_id
		AND i.docstatus = 'CO'
		AND i.issotrx = 'Y'
		AND (i.ispaid = 'N' OR i.ispaid IS NULL)
WHERE
	-- Only create allocation if there's remaining amount to allocate
	LEAST(
			i.grandtotal - COALESCE(
					(
						SELECT
							SUM(al.amount)
						FROM
							c_allocationline al
								JOIN c_allocationhdr ah
									ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						WHERE
							al.c_invoice_id = i.c_invoice_id
							AND ah.docstatus = 'CO'
					),
					0
			               ),
			tp.payamt - COALESCE(
					(
						SELECT
							SUM(al.amount)
						FROM
							c_allocationline al
								JOIN c_allocationhdr ah
									ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						WHERE
							al.c_payment_id = tp.c_payment_id
							AND ah.docstatus = 'CO'
					),
					0
			            )
	) > 0;

-- Insert the real allocation lines
INSERT INTO
	c_allocationline (c_allocationline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, c_bpartner_id,
	                  c_payment_id, amount, discountamt, writeoffamt, overunderamt, c_allocationhdr_id,
	                  c_allocationline_uu)
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
	discountamt,
	writeoffamt,
	overunderamt,
	c_allocationhdr_id,
	c_allocationline_uu
FROM
	tmp_c_allocationline;

-- Step 5: Update invoice IsPaid status based on allocations
UPDATE c_invoice
SET
	ispaid    = CASE
		            WHEN (
			                 SELECT
				                 COALESCE(SUM(al.amount), 0)
			                 FROM
				                 c_allocationline al
					                 JOIN c_allocationhdr ah
						                 ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			                 WHERE
				                 al.c_invoice_id = c_invoice.c_invoice_id
				                 AND ah.docstatus = 'CO'
		                 ) >= grandtotal THEN 'Y'
		            ELSE 'N'
		END,
	updated   = NOW(),
	updatedby = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT
			c_invoice_id
		FROM
			tmp_c_allocationline
	);

-- Step 6: Update invoice AllocatedAmt
UPDATE c_invoice
SET
	grandtotal = (
		SELECT
			COALESCE(SUM(al.amount), 0)
		FROM
			c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		WHERE
			al.c_invoice_id = c_invoice.c_invoice_id
			AND ah.docstatus = 'CO'
	),
	updated    = NOW(),
	updatedby  = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT
			c_invoice_id
		FROM
			tmp_c_allocationline
	);

-- Step 7: Update business partner TotalOpenBalance
-- Recalculate open balance for all affected business partners
UPDATE c_bpartner bp
SET
	totalopenbalance = (
		SELECT
			COALESCE(SUM(
					         CASE
						         WHEN i.issotrx = 'Y' THEN i.grandtotal - COALESCE(i.grandtotal, 0)
						         ELSE -(i.grandtotal - COALESCE(i.grandtotal, 0))
						         END
			         ), 0)
		FROM
			c_invoice i
		WHERE
			i.c_bpartner_id = bp.c_bpartner_id
			AND i.docstatus = 'CO'
			AND (i.grandtotal - COALESCE(i.grandtotal, 0)) != 0
	),
	updated          = NOW(),
	updatedby        = 100
WHERE
	c_bpartner_id IN (
		SELECT DISTINCT
			c_bpartner_id
		FROM
			tmp_payments_to_complete
	);

-- Step 8: Update business partner credit status
UPDATE c_bpartner
SET
	socreditstatus = CASE
		                 WHEN totalopenbalance <= 0 THEN 'X' -- No Credit
		                 WHEN so_creditlimit > 0 AND totalopenbalance >= so_creditlimit THEN 'H' -- Credit Hold
		                 WHEN so_creditlimit > 0 AND totalopenbalance >= (so_creditlimit * 0.9) THEN 'W' -- Credit Watch
		                 ELSE 'O' -- OK
		END,
	updated        = NOW(),
	updatedby      = 100
WHERE
	c_bpartner_id IN (
		SELECT DISTINCT
			c_bpartner_id
		FROM
			tmp_payments_to_complete
	);

SELECT
	update_sequences();

DROP TABLE IF EXISTS tmp_payments_to_complete;
DROP TABLE IF EXISTS tmp_c_allocationhdr;
DROP TABLE IF EXISTS tmp_c_allocationline;

/**********************************************************************************************************/
-- PART 3 (202602051404): Create waived invoices for OTC Patient visits
--                        that have completed orders but no invoices
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
-- Step 10: Cleanup
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_otc_visits_without_invoices;
DROP TABLE IF EXISTS tmp_c_invoice;
DROP TABLE IF EXISTS tmp_c_invoiceline;
DROP TABLE IF EXISTS tmp_fact_acct;

/**********************************************************************************************************/
-- PART 4 (202602051707): Create waived payments for OTC Patient visits with payment shortfalls
-- This script assumes existing payments are already allocated - we only create new waived payments for shortfalls
/**********************************************************************************************************/

-- Step 1: Identify visits with invoices that have remaining unpaid balances
DROP TABLE IF EXISTS tmp_visits_with_shortfalls;
CREATE TEMP TABLE tmp_visits_with_shortfalls AS
SELECT
	v.bh_visit_id,
	v.ad_client_id,
	v.ad_org_id,
	v.patient_id                AS c_bpartner_id,
	i.dateacct,
	i.c_order_id,
	ROUND(SUM(i.grandtotal), 2) AS total_invoiced,
	ROUND(SUM(p.payamt), 2)     AS total_paid,
	-- Calculate actual unallocated amount on invoices
	ROUND(SUM(
			      i.grandtotal - COALESCE(
					      (
						      SELECT
							      SUM(al.amount)
						      FROM
							      c_allocationline al
								      JOIN c_allocationhdr ah
									      ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						      WHERE
							      al.c_invoice_id = i.c_invoice_id
							      AND ah.docstatus IN ('CO', 'CL')
					      ),
					      0
			                     )
	      ), 2)                 AS actual_shortfall,
	MAX(i.c_currency_id)        AS c_currency_id,
	MAX(i.c_invoice_id)         AS c_invoice_id
FROM
	bh_visit v
		JOIN c_invoice i
			ON v.bh_visit_id = i.bh_visit_id
		AND i.docstatus IN ('CO', 'CL')
		JOIN c_payment p
			ON v.bh_visit_id = p.bh_visit_id
		AND p.docstatus IN ('CO', 'CL')
		AND p.isreceipt = 'Y'
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id
		AND bpg.name = 'OTC Patient'
GROUP BY
	v.bh_visit_id,
	v.ad_client_id,
	v.ad_org_id,
	v.patient_id,
	i.dateacct,
	i.c_order_id
HAVING
	-- Only include visits where invoices have remaining balance
	ROUND(SUM(
			      i.grandtotal - COALESCE(
					      (
						      SELECT
							      SUM(al.amount)
						      FROM
							      c_allocationline al
								      JOIN c_allocationhdr ah
									      ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						      WHERE
							      al.c_invoice_id = i.c_invoice_id
							      AND ah.docstatus IN ('CO', 'CL')
					      ),
					      0
			                     )
	      ), 2) > 0;

/**********************************************************************************************************/
-- Step 2: Create waived payments for the actual shortfall amounts
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_payment;
CREATE TEMP TABLE tmp_c_payment
(
	c_payment_id       serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	bh_visit_id        numeric(10)                     NOT NULL,
	documentno         numeric                         NOT NULL,
	datetrx            timestamp                       NOT NULL,
	isreceipt          char        DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'X'         NOT NULL,
	c_bankaccount_id   numeric(10),
	c_bpartner_id      numeric(10)                     NOT NULL,
	c_invoice_id       numeric(10)                     NOT NULL,
	tendertype         char        DEFAULT 'X'         NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	payamt             numeric                         NOT NULL,
	description        varchar(255),
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	r_avsaddr          char        DEFAULT 'X',
	r_avszip           char        DEFAULT 'X',
	processing         char        DEFAULT 'N',
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isallocated        char        DEFAULT 'Y'::bpchar NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	isoverunderpayment char        DEFAULT 'N'::bpchar NOT NULL,
	dateacct           timestamp                       NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_payment_uu       uuid        DEFAULT uuid_generate_v4(),
	bh_tender_amount   numeric     DEFAULT 0
);

SELECT
	SETVAL(
			'tmp_c_payment_c_payment_id_seq',
			(
				SELECT
					COALESCE(MAX(c_payment_id), 0) + 1
				FROM
					c_payment
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_payment (ad_client_id, ad_org_id, bh_visit_id, documentno, datetrx, dateacct, c_doctype_id, c_bankaccount_id,
	               c_bpartner_id, c_invoice_id, c_currency_id, payamt, description, bh_tender_amount)
SELECT
	tvs.ad_client_id,
	tvs.ad_org_id,
	tvs.bh_visit_id,
	seq.currentnext - 1, -- Will be updated with proper row numbering below
	COALESCE(v.bh_visitdate, NOW()),
	tvs.dateacct,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	tvs.c_bpartner_id,
	tvs.c_invoice_id,
	tvs.c_currency_id,
	tvs.actual_shortfall,
	'Waived payment for invoice shortfall',
	tvs.actual_shortfall
FROM
	tmp_visits_with_shortfalls tvs
		JOIN bh_visit v
			ON tvs.bh_visit_id = v.bh_visit_id
		JOIN c_doctype dt
			ON tvs.ad_client_id = dt.ad_client_id
		AND dt.docbasetype = 'ARR'
		JOIN ad_sequence seq
			ON tvs.ad_client_id = seq.ad_client_id
		AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON tvs.ad_client_id = ba.ad_client_id
		AND ba.isdefault = 'Y'
WHERE
	tvs.actual_shortfall > 0;

-- Update the document numbers with proper sequencing
UPDATE tmp_c_payment tp
SET
	documentno = documentno + tpc.row_num
FROM
	(
		SELECT
			c_payment_id,
			ROW_NUMBER() OVER (PARTITION BY ad_client_id ORDER BY c_payment_id) AS row_num
		FROM
			tmp_c_payment
	) tpc
WHERE
	tp.c_payment_id = tpc.c_payment_id;

-- Insert the waived payments
INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, bh_visit_id, documentno, datetrx, dateacct,
	           isreceipt, c_doctype_id, trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype,
	           c_currency_id, payamt, description, isapproved, r_avsaddr, r_avszip, processing, docstatus, docaction,
	           isallocated, processed, posted, isoverunderpayment, processedon, c_payment_uu, bh_tender_amount)
SELECT
	c_payment_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	bh_visit_id,
	documentno,
	datetrx,
	dateacct,
	isreceipt,
	c_doctype_id,
	trxtype,
	c_bankaccount_id,
	c_bpartner_id,
	c_invoice_id,
	tendertype,
	c_currency_id,
	payamt,
	description,
	isapproved,
	r_avsaddr,
	r_avszip,
	processing,
	docstatus,
	docaction,
	isallocated,
	processed,
	posted,
	isoverunderpayment,
	processedon,
	c_payment_uu,
	bh_tender_amount
FROM
	tmp_c_payment;

/**********************************************************************************************************/
-- Step 3: Create allocation headers for the new waived payments only
/**********************************************************************************************************/

DROP TABLE IF EXISTS tmp_c_allocationhdr;
CREATE TEMP TABLE tmp_c_allocationhdr
(
	c_allocationhdr_id serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	description        varchar(255),
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp                       NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	c_doctype_id       numeric(10)                     NOT NULL,
	tmp_c_payment_id   numeric(10)                     NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_allocationhdr_c_allocationhdr_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationhdr_id), 0) + 1
				FROM
					c_allocationhdr
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, datetrx, dateacct, c_currency_id, c_doctype_id,
	                     tmp_c_payment_id)
SELECT DISTINCT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- Will be updated with proper row numbering below
	'Waived Payment Allocation: ' || tp.documentno,
	tp.datetrx,
	tp.dateacct,
	tp.c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_c_payment tp
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id
		AND dt.docbasetype = 'CMA'
		JOIN ad_sequence seq
			ON tp.ad_client_id = seq.ad_client_id
		AND seq.name = 'Allocation';

-- Update the document numbers with proper sequencing
UPDATE tmp_c_allocationhdr tah
SET
	documentno = documentno + tahc.row_num
FROM
	(
		SELECT
			c_allocationhdr_id,
			ROW_NUMBER() OVER (PARTITION BY ad_client_id ORDER BY c_allocationhdr_id) AS row_num
		FROM
			tmp_c_allocationhdr
	) tahc
WHERE
	tah.c_allocationhdr_id = tahc.c_allocationhdr_id;

-- Insert allocation headers
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
	tmp_c_allocationhdr;

-- Step 4: Create allocation lines linking new waived payments to invoices
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TEMP TABLE tmp_c_allocationline
(
	c_allocationline_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	c_invoice_id        numeric(10)             NOT NULL,
	c_bpartner_id       numeric(10)             NOT NULL,
	c_order_id          numeric(10)             NOT NULL,
	c_payment_id        numeric(10)             NOT NULL,
	amount              numeric                 NOT NULL,
	discountamt         numeric     DEFAULT 0   NOT NULL,
	writeoffamt         numeric     DEFAULT 0   NOT NULL,
	overunderamt        numeric     DEFAULT 0   NOT NULL,
	c_allocationhdr_id  numeric(10)             NOT NULL,
	c_allocationline_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_allocationline_c_allocationline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationline_id), 0) + 1
				FROM
					c_allocationline
			)::INT,
			FALSE
	);

-- Allocate new waived payments to invoices (covering the shortfall)
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_order_id, c_payment_id, amount,
	                      c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	i.c_invoice_id,
	tp.c_bpartner_id,
	i.c_order_id,
	tp.c_payment_id,
	-- Calculate the remaining unallocated amount for this invoice
	LEAST(
			i.grandtotal - COALESCE(
					(
						SELECT
							SUM(al.amount)
						FROM
							c_allocationline al
								JOIN c_allocationhdr ah
									ON al.c_allocationhdr_id = ah.c_allocationhdr_id
						WHERE
							al.c_invoice_id = i.c_invoice_id
							AND ah.docstatus IN ('CO', 'CL')
					),
					0
			               ) - COALESCE(
					(
						-- Also subtract what we've already allocated in this migration
						SELECT
							SUM(tal.amount)
						FROM
							tmp_c_allocationline tal
						WHERE
							tal.c_invoice_id = i.c_invoice_id
					),
					0
			                   ),
			tp.payamt
	) AS amount,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment tp
		JOIN tmp_c_allocationhdr tah
			ON tp.c_payment_id = tah.tmp_c_payment_id
		JOIN c_invoice i
			ON tp.bh_visit_id = i.bh_visit_id
		AND i.docstatus IN ('CO', 'CL')
WHERE
	-- Only allocate if there's a remaining balance
	i.grandtotal - COALESCE(
			(
				SELECT
					SUM(al.amount)
				FROM
					c_allocationline al
						JOIN c_allocationhdr ah
							ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE
					al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus IN ('CO', 'CL')
			),
			0
	               ) - COALESCE(
			(
				SELECT
					SUM(tal.amount)
				FROM
					tmp_c_allocationline tal
				WHERE
					tal.c_invoice_id = i.c_invoice_id
			),
			0
	                   ) > 0;

-- Insert allocation lines
INSERT INTO
	c_allocationline (c_allocationline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, c_bpartner_id,
	                  c_order_id,
	                  c_payment_id, amount, discountamt, writeoffamt, overunderamt, c_allocationhdr_id,
	                  c_allocationline_uu)
SELECT
	c_allocationline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_invoice_id,
	c_bpartner_id,
	c_order_id,
	c_payment_id,
	amount,
	discountamt,
	writeoffamt,
	overunderamt,
	c_allocationhdr_id,
	c_allocationline_uu
FROM
	tmp_c_allocationline;

-- Step 5: Update payment IsAllocated status for new payments only
UPDATE c_payment
SET
	isallocated = CASE
		              WHEN (
			                   SELECT
				                   COALESCE(SUM(al.amount), 0)
			                   FROM
				                   c_allocationline al
					                   JOIN c_allocationhdr ah
						                   ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			                   WHERE
				                   al.c_payment_id = c_payment.c_payment_id
				                   AND ah.docstatus IN ('CO', 'CL')
		                   ) >= payamt THEN 'Y'
		              ELSE 'N'
		END,
	updated     = NOW(),
	updatedby   = 100
WHERE
	c_payment_id IN (
		SELECT DISTINCT
			c_payment_id
		FROM
			tmp_c_payment
	);

-- Step 6: Update invoice IsPaid status
UPDATE c_invoice
SET
	ispaid    = CASE
		            WHEN (
			                 SELECT
				                 COALESCE(SUM(al.amount), 0)
			                 FROM
				                 c_allocationline al
					                 JOIN c_allocationhdr ah
						                 ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			                 WHERE
				                 al.c_invoice_id = c_invoice.c_invoice_id
				                 AND ah.docstatus IN ('CO', 'CL')
		                 ) >= grandtotal THEN 'Y'
		            ELSE 'N'
		END,
	updated   = NOW(),
	updatedby = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT
			c_invoice_id
		FROM
			tmp_c_allocationline
	);

-- Step 7: Update AllocatedAmt on invoices
UPDATE c_invoice
SET
	grandtotal = (
		SELECT
			COALESCE(SUM(al.amount), 0)
		FROM
			c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		WHERE
			al.c_invoice_id = c_invoice.c_invoice_id
			AND ah.docstatus IN ('CO', 'CL')
	),
	updated    = NOW(),
	updatedby  = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT
			c_invoice_id
		FROM
			tmp_c_allocationline
	);

-- Step 8: Update sequences
UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_payment WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Payment'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_payment
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_allocationhdr WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'Allocation'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_allocationhdr
	);

DROP TABLE IF EXISTS tmp_visits_with_shortfalls;
DROP TABLE IF EXISTS tmp_c_payment;
DROP TABLE IF EXISTS tmp_c_allocationhdr;
DROP TABLE IF EXISTS tmp_c_allocationline;

---- Part 5 fix payments with decimal shortfalls due to currency rounding issues (GO-3456) ----
/**********************************************************************************************************/
-- Correct OTC payments with decimal amounts
-- OTC payments should be whole numbers; decimal payamt values cause false overpayments
-- This script rounds decimal payment amounts to match their allocated invoice totals
/**********************************************************************************************************/

-- Step 1: Identify OTC CO/CL payments with decimal amounts
-- DROP TABLE IF EXISTS tmp_decimal_otc_payments;
-- CREATE TEMP TABLE tmp_decimal_otc_payments AS
-- SELECT
-- 	p.c_payment_id,
-- 	p.ad_client_id,
-- 	p.ad_org_id,
-- 	p.bh_visit_id,
-- 	p.c_invoice_id,
-- 	p.payamt           AS original_payamt,
-- 	p.bh_tender_amount AS original_tender_amount,
-- 	i_totals.total_invoiced,
-- 	-- Prefer rounding to nearest integer; if still overpaid, cap at invoice total
-- 	CASE
-- 		WHEN ROUND(p.payamt, 0) <= i_totals.total_invoiced THEN ROUND(p.payamt, 0)
-- 		ELSE i_totals.total_invoiced
-- 		END              AS corrected_payamt
-- FROM
-- 	c_payment p
-- 		JOIN bh_visit v
-- 			ON p.bh_visit_id = v.bh_visit_id
-- 		JOIN c_bpartner bp
-- 			ON v.patient_id = bp.c_bpartner_id
-- 		JOIN c_bp_group bpg
-- 			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
-- 		JOIN LATERAL (
-- 		SELECT
-- 			ROUND(SUM(i.grandtotal), 2) AS total_invoiced
-- 		FROM
-- 			c_invoice i
-- 		WHERE
-- 			i.bh_visit_id = p.bh_visit_id
-- 			AND i.docstatus IN ('CO', 'CL')
-- 		) i_totals
-- 			ON TRUE
-- WHERE
-- 	p.docstatus IN ('CO', 'CL')
-- 	AND p.payamt != FLOOR(p.payamt);
-- -- has a decimal component

-- -- Step 2: Update payment amounts
-- UPDATE c_payment
-- SET
-- 	payamt           = td.corrected_payamt,
-- 	bh_tender_amount = td.corrected_payamt,
-- 	updated          = NOW(),
-- 	updatedby        = 100
-- FROM
-- 	tmp_decimal_otc_payments td
-- WHERE
-- 	c_payment.c_payment_id = td.c_payment_id;

-- -- Step 3: Update allocation line amounts tied to these payments
-- UPDATE c_allocationline al
-- SET
-- 	amount    = LEAST(td.corrected_payamt, al.amount),
-- 	updated   = NOW(),
-- 	updatedby = 100
-- FROM
-- 	tmp_decimal_otc_payments td
-- 		JOIN c_allocationhdr ah
-- 			ON al.c_allocationhdr_id = ah.c_allocationhdr_id
-- WHERE
-- 	al.c_payment_id = td.c_payment_id
-- 	AND ah.docstatus IN ('CO', 'CL');

-- -- Step 4: Update invoice IsPaid status for invoices touched by corrected payments
-- UPDATE c_invoice
-- SET
-- 	ispaid    = CASE
-- 		            WHEN (
-- 			                 SELECT
-- 				                 COALESCE(SUM(al.amount), 0)
-- 			                 FROM
-- 				                 c_allocationline al
-- 					                 JOIN c_allocationhdr ah
-- 						                 ON al.c_allocationhdr_id = ah.c_allocationhdr_id
-- 			                 WHERE
-- 				                 al.c_invoice_id = c_invoice.c_invoice_id
-- 				                 AND ah.docstatus IN ('CO', 'CL')
-- 		                 ) >= c_invoice.grandtotal THEN 'Y'
-- 		            ELSE 'N'
-- 		END,
-- 	updated   = NOW(),
-- 	updatedby = 100
-- WHERE
-- 	c_invoice_id IN (
-- 		SELECT DISTINCT
-- 			c_invoice_id
-- 		FROM
-- 			c_allocationline al
-- 				JOIN c_allocationhdr ah
-- 					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
-- 				JOIN tmp_decimal_otc_payments td
-- 					ON al.c_payment_id = td.c_payment_id
-- 		WHERE
-- 			ah.docstatus IN ('CO', 'CL')
-- 	)
-- 	OR c_invoice_id IN (
-- 		SELECT DISTINCT
-- 			c_invoice_id
-- 		FROM
-- 			tmp_decimal_otc_payments
-- 		WHERE
-- 			c_invoice_id IS NOT NULL
-- 	);

-- -- Step 5: Cleanup
-- DROP TABLE IF EXISTS tmp_decimal_otc_payments;

SELECT
	register_migration_script('202602051707_GO-3456.sql')
FROM
	dual;
