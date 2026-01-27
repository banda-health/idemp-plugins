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
	documentno             numeric                         NOT NULL,
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

-- Check invoices for OTC patient visits
-- First, collect existing invoices
INSERT INTO
	tmp_c_invoice_otc (c_invoice_id, ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	                   salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered, c_currency_id,
	                   c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon, bh_visit_id, is_new)
SELECT
	i.c_invoice_id,
	i.ad_client_id,
	i.ad_org_id,
	i.documentno::numeric,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.c_order_id,
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
	                   salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered, c_currency_id,
	                   c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon, bh_visit_id)
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
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice_otc
	) ti
WHERE
	i.c_invoice_id = ti.c_invoice_id;

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
	c_invoiceline_id          serial                          NOT NULL,
	ad_client_id              numeric(10)                     NOT NULL,
	ad_org_id                 numeric(10)                     NOT NULL,
	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby                 numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                 numeric(10) DEFAULT 100         NOT NULL,
	c_invoice_id              numeric(10)                     NOT NULL,
	c_orderline_id            numeric(10),
	m_inoutline_id            numeric(10),
	line                      numeric(10)                     NOT NULL,
	description               varchar(255) DEFAULT 'OTC Patient Invoice line - Auto Generated',
	m_product_id              numeric(10),
	qtyinvoiced               numeric                         NOT NULL,
	pricelist                 numeric                         NOT NULL,
	priceactual               numeric                         NOT NULL,
	pricelimit                numeric                         NOT NULL,
	linenetamt                numeric                         NOT NULL,
--	c_charge_id               numeric(10),
	c_uom_id                  numeric(10)                     NOT NULL,
	c_tax_id                  numeric(10)                     NOT NULL,
--	s_resourceassignment_id   numeric(10),
--	a_asset_id                numeric(10),
--	taxamt                    numeric     DEFAULT 0,
	m_attributesetinstance_id numeric(10)                     NOT NULL,
--	isdescription             char        DEFAULT 'N'::bpchar NOT NULL,
--	isprinted                 char        DEFAULT 'Y'::bpchar NOT NULL,
	linetotalamt              numeric                         NOT NULL,
--	ref_invoiceline_id        numeric(10),
	processed                 char        DEFAULT 'Y'::bpchar NOT NULL,
	qtyentered                numeric                         NOT NULL,
	priceentered              numeric                         NOT NULL,
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
	c_invoiceline_uu          varchar(36) DEFAULT uuid_generate_v4(),
	isfixedassetinvoice       char        DEFAULT 'N'
--	c_1099box_id              numeric(10) DEFAULT NULL::numeric
);

-- First, collect existing invoice lines for existing invoices
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
	ti.is_new = 'N'; -- Only for existing invoices

-- Then, create new invoice lines for new invoices
INSERT INTO
	tmp_c_invoiceline_otc (ad_client_id, ad_org_id, c_invoice_id, c_orderline_id, m_inoutline_id, line, m_product_id,
	                       qtyinvoiced, pricelist, priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id,
	                       m_attributesetinstance_id, linetotalamt, qtyentered, priceentered,
	                       description, isactive, createdby, updatedby, processed, c_invoiceline_uu, isfixedassetinvoice)
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
	uuid_generate_v4(),
	'N'
FROM
	tmp_c_invoice_otc ti
		JOIN c_orderline ol
			ON ti.c_order_id = ol.c_order_id
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id
WHERE
	ti.is_new = 'Y'; -- Only for new invoices


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
		JOIN tmp_c_invoice_otc ti
			ON til.c_invoice_id = ti.c_invoice_id
	WHERE ti.is_new = 'Y';

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
	bh_tender_amount   numeric     						NOT NULL,
	bh_visit_id        numeric(10)                      NOT NULL
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
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	COALESCE(ti.dateinvoiced, i.dateinvoiced)   AS datetrx,
	COALESCE(ti.dateacct, i.dateacct)           AS dateacct,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	COALESCE(i.c_bpartner_id, ti.c_bpartner_id) AS c_bpartner_id,
	COALESCE(ti.c_invoice_id, i.c_invoice_id)   AS c_invoice_id,
	COALESCE(ti.c_currency_id, i.c_currency_id) AS c_currency_id,
	p.grandtotal,
	EXTRACT(EPOCH FROM COALESCE(ti.dateinvoiced, i.dateinvoiced)) * 1000,
	p.grandtotal,
	p.tendertype,
	p.bh_visit_id
FROM
	tmp_missing_otc_payments p
		LEFT JOIN tmp_c_invoice_otc ti
			ON p.bh_visit_id = ti.bh_visit_id
		JOIN c_doctype dt
			ON ti.ad_client_id = dt.ad_client_id AND docbasetype = 'ARR'
		JOIN ad_sequence seq
			ON ti.ad_client_id = seq.ad_client_id AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON ti.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y'
		JOIN c_order c
			ON ti.c_order_id = c.c_order_id
		LEFT JOIN c_invoice i
			ON p.bh_visit_id = i.bh_visit_id AND i.docstatus IN ('CO', 'CL')

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
		SELECT COUNT(*) FROM tmp_c_invoice_otc WHERE ad_client_id = ad_sequence.ad_client_id AND is_new = 'Y'
	)
WHERE
	name = 'DocumentNo_C_Invoice'
	AND ad_client_id IN (SELECT DISTINCT ad_client_id FROM tmp_c_invoice_otc WHERE is_new = 'Y');

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
DROP TABLE IF EXISTS tmp_c_invoiceline_otc;
DROP TABLE IF EXISTS tmp_c_payment_otc;
DROP TABLE IF EXISTS tmp_fact_acct_otc;
DROP TABLE IF EXISTS tmp_c_allocationline_otc;
DROP TABLE IF EXISTS tmp_c_allocationhdr_otc;

SELECT
	register_migration_script('202601271542_GO-3456.sql')
FROM
	dual;
