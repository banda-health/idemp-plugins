/**********************************************************************************************************/
-- Create invoices, payments, and allocations for all previous purchase orders
/**********************************************************************************************************/

-- First, identify purchase orders that don't have invoices yet
DROP TABLE IF EXISTS tmp_po_without_invoices;
SELECT DISTINCT
	o.c_order_id
INTO TEMP TABLE
	tmp_po_without_invoices
FROM
	c_order o
		LEFT JOIN c_invoice i
			ON o.c_order_id = i.c_order_id AND i.docstatus IN ('CO', 'CL')
WHERE
	o.issotrx = 'N'
	AND o.docstatus IN ('CO', 'CL')
	AND o.bh_visit_id IS NULL
	AND i.c_invoice_id IS NULL
	AND o.ad_client_id > 999999
	AND NOT EXISTS (
		SELECT 1 FROM c_orderline WHERE c_order_id = o.c_order_id AND m_product_id IS NULL
	);

/**********************************************************************************************************/
-- Create invoices for purchase orders
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoice;
CREATE TEMP TABLE tmp_c_invoice
(
	c_invoice_id           serial                           NOT NULL,
	ad_client_id           numeric(10)                      NOT NULL,
	ad_org_id              numeric(10)                      NOT NULL,
-- 	isactive               char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp    DEFAULT NOW()       NOT NULL,
	createdby              numeric(10)  DEFAULT 100         NOT NULL,
-- 	updated                timestamp    DEFAULT NOW()       NOT NULL,
	updatedby              numeric(10)  DEFAULT 100         NOT NULL,
	issotrx                char         DEFAULT 'N'::bpchar NOT NULL,
	documentno             numeric                          NOT NULL,
	docstatus              char(2)      DEFAULT 'CO'        NOT NULL,
	docaction              char(2)      DEFAULT 'CL'        NOT NULL,
	processing             char         DEFAULT 'N',
	processed              char         DEFAULT 'Y'::bpchar NOT NULL,
	posted                 char         DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id           numeric(10)                      NOT NULL,
	c_doctypetarget_id     numeric(10)                      NOT NULL,
	c_order_id             numeric(10),
	description            varchar(255) DEFAULT 'Purchase Order Invoice - Auto Generated',
-- 	isapproved             char         DEFAULT 'N'::bpchar NOT NULL,
-- 	istransferred          char         DEFAULT 'N'::bpchar NOT NULL,
-- 	isprinted              char         DEFAULT 'N'::bpchar NOT NULL,
	salesrep_id            numeric(10),
	dateinvoiced           timestamp                        NOT NULL,
-- 	dateprinted            timestamp,
	dateacct               timestamp                        NOT NULL,
	c_bpartner_id          numeric(10)                      NOT NULL,
	c_bpartner_location_id numeric(10)                      NOT NULL,
	poreference            varchar(20)                      NULL,
	isdiscountprinted      char         DEFAULT 'Y'::bpchar NOT NULL,
	dateordered            timestamp                        NOT NULL,
	c_currency_id          numeric(10)                      NOT NULL,
	paymentrule            char         DEFAULT 'P'         NOT NULL,
	c_paymentterm_id       numeric(10)                      NOT NULL,
-- 	c_charge_id            numeric(10),
-- 	chargeamt              numeric      DEFAULT 0,
	totallines             numeric                          NOT NULL,
	grandtotal             numeric                          NOT NULL,
	m_pricelist_id         numeric(10)                      NOT NULL,
-- 	istaxincluded          char         DEFAULT 'N'::bpchar NOT NULL,
-- 	c_campaign_id          numeric(10),
-- 	c_project_id           numeric(10),
-- 	c_activity_id          numeric(10),
	ispaid                 char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	c_payment_id           numeric(10),
-- 	c_cashline_id          numeric(10),
-- 	createfrom             char,
-- 	generateto             char,
-- 	sendemail              char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ad_user_id             numeric(10),
-- 	copyfrom               char,
-- 	isselfservice          char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ad_orgtrx_id           numeric(10),
-- 	user1_id               numeric(10),
-- 	user2_id               numeric(10),
-- 	c_conversiontype_id    numeric(10),
-- 	ispayschedulevalid     char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ref_invoice_id         numeric(10),
-- 	isindispute            char         DEFAULT 'N'::bpchar NOT NULL,
-- 	invoicecollectiontype  char,
-- 	m_rma_id               numeric(10),
-- 	dunninggrace           timestamp,
-- 	c_dunninglevel_id      numeric(10),
-- 	reversal_id            numeric(10),
	processedon            numeric,
-- 	c_cashplanline_id      numeric(10)  DEFAULT NULL::numeric,
	c_invoice_uu           varchar(36)  DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char         DEFAULT 'N'
-- 	relatedinvoice_id      numeric(10)  DEFAULT NULL::numeric,
-- 	bh_voided_reason_id    numeric(10)  DEFAULT NULL::numeric,
-- 	bh_visit_id            numeric(10)  DEFAULT NULL::numeric,
-- 	isoverridecurrencyrate char         DEFAULT 'N'::bpchar NOT NULL,
-- 	currencyrate           numeric,
-- 	createlinesfrom        char         DEFAULT NULL::bpchar
);

SELECT
	SETVAL(
			'tmp_c_invoice_c_invoice_id_seq',
			(
				SELECT
					COALESCE(MAX(c_invoice_id), 0) + 1
				FROM
					c_invoice
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	               salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered, c_currency_id,
	               c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	o.c_order_id,
	o.salesrep_id,
	o.dateordered,
	o.dateacct,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.dateordered,
	o.c_currency_id,
	pt.c_paymentterm_id,
	o.totallines,
	o.grandtotal,
	o.m_pricelist_id,
	EXTRACT(EPOCH FROM o.dateordered) * 1000
FROM
	tmp_po_without_invoices po
		JOIN c_order o
			ON po.c_order_id = o.c_order_id
		JOIN ad_sequence seq
			ON seq.ad_client_id = o.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AP Invoice'
		JOIN c_paymentterm pt
			ON pt.ad_client_id = o.ad_client_id AND pt.value = 'Immediate';

-- Update the document numbers
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

-- Insert the real invoices!
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, issotrx, documentno, docstatus, docaction,
	           processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id,
	           dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference, isdiscountprinted, dateordered,
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
	poreference,
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
	tmp_c_invoice;

/**********************************************************************************************************/
-- Create invoice lines for purchase orders
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoiceline;
CREATE TEMP TABLE tmp_c_invoiceline
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
	c_orderline_id            numeric(10)                     NOT NULL,
	m_inoutline_id            numeric(10),
	line                      numeric(10)                     NOT NULL,
--	description               varchar(255),
	m_product_id              numeric(10)                     NOT NULL,
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

SELECT
	SETVAL(
			'tmp_c_invoiceline_c_invoiceline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_invoiceline_id), 0) + 1
				FROM
					c_invoiceline
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, c_invoice_id, c_orderline_id, m_inoutline_id, line, m_product_id,
	                   qtyinvoiced, pricelist, priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id,
	                   m_attributesetinstance_id, linetotalamt, qtyentered, priceentered)
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
	ol.priceentered
FROM
	tmp_c_invoice ti
		JOIN c_orderline ol
			ON ti.c_order_id = ol.c_order_id
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id;

-- Insert the real invoice lines!
INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, c_invoice_id,
	               c_orderline_id, m_inoutline_id, line, m_product_id, qtyinvoiced, pricelist, priceactual, pricelimit,
	               linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt, processed, qtyentered,
	               priceentered, c_invoiceline_uu, isfixedassetinvoice)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	isactive,
	createdby,
	updatedby,
	c_invoice_id,
	c_orderline_id,
	m_inoutline_id,
	line,
	m_product_id,
	qtyinvoiced,
	pricelist,
	priceactual,
	pricelimit,
	linenetamt,
	c_uom_id,
	c_tax_id,
	m_attributesetinstance_id,
	linetotalamt,
	processed,
	qtyentered,
	priceentered,
	c_invoiceline_uu,
	isfixedassetinvoice
FROM
	tmp_c_invoiceline;

/**********************************************************************************************************/
-- Create payments for the invoices
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_payment;
CREATE TEMP TABLE tmp_c_payment
(
	c_payment_id       serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	datetrx            timestamp   DEFAULT DATE(NOW()) NOT NULL,
	isreceipt          char        DEFAULT 'N'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'S'         NOT NULL,
	c_bankaccount_id   numeric(10),
	c_bpartner_id      numeric(10),
	c_invoice_id       numeric(10),
	tendertype         char        DEFAULT 'X'         NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
	payamt             numeric                         NOT NULL,
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
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_payment_uu       uuid        DEFAULT uuid_generate_v4(),
	bh_tender_amount   numeric     DEFAULT 0
);

SELECT
	SETVAL(
			'tmp_c_payment_c_payment_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Payment'
				LIMIT 1
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_payment (ad_client_id, ad_org_id, documentno, c_doctype_id, c_bankaccount_id, c_bpartner_id,
	               c_invoice_id, c_currency_id, payamt)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	ti.c_bpartner_id,
	ti.c_invoice_id,
	ti.c_currency_id,
	ti.grandtotal
FROM
	tmp_c_invoice ti
		JOIN c_doctype dt
			ON ti.ad_client_id = dt.ad_client_id AND docbasetype = 'APP'
		JOIN ad_sequence seq
			ON ti.ad_client_id = seq.ad_client_id AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON ti.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y';

-- Update the document numbers
UPDATE tmp_c_payment tp
SET
	documentno = documentno + tpc.row_num
FROM
	(
		SELECT
			c_payment_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_payment_id) AS row_num
		FROM
			tmp_c_payment
	) tpc
WHERE
	tp.c_payment_id = tpc.c_payment_id;

-- Insert the real payments!
INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, isreceipt,
	           c_doctype_id, trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype, c_currency_id,
	           payamt, isapproved, r_avsaddr, r_avszip, processing, docstatus, docaction, isallocated, processed,
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
	r_avsaddr,
	r_avszip,
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
	tmp_c_payment;

/**********************************************************************************************************/
-- Create accounting entries for payments
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_fact_acct;
CREATE TEMP TABLE tmp_fact_acct
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
			'tmp_fact_acct_fact_acct_id_seq',
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
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, c_period_id, ad_table_id, record_id,
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
	tmp_c_payment tp
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
	tmp_fact_acct;

/**********************************************************************************************************/
-- Create allocation headers
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
	datetrx            timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
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
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, c_currency_id, c_doctype_id, tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || tp.documentno,
	tp.c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_c_payment tp
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
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_allocationhdr_id) AS row_num
		FROM
			tmp_c_allocationhdr
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
	tmp_c_allocationhdr;

/**********************************************************************************************************/
-- Create allocation lines
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TEMP TABLE tmp_c_allocationline
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
			'tmp_c_allocationline_c_allocationline_id_seq',
			(
				SELECT
					COALESCE(MAX(c_allocationline_id), 0) + 1
				FROM
					c_allocationline
			)::INT,
			FALSE
	);

INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	tp.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	tp.payamt,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment tp
		JOIN tmp_c_allocationhdr tah
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
	tmp_c_allocationline;

/**********************************************************************************************************/
-- Create accounting entries for allocations
/**********************************************************************************************************/
TRUNCATE TABLE tmp_fact_acct;
INSERT INTO
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, c_period_id, ad_table_id, record_id,
	               line_id, gl_category_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty,
	               c_bpartner_id, description)
SELECT
	tah.ad_client_id,
	tah.ad_org_id,
	accts.c_acctschema_id,
	ev_21100.c_elementvalue_id,
	tah.datetrx,
	p.c_period_id,
	735,
	tah.c_allocationhdr_id,
	tal.c_allocationline_id,
	cat.gl_category_id,
	tah.c_currency_id,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE tp.payamt END,
	CASE WHEN drcr.sign = 'CR' THEN tp.payamt ELSE 0 END,
	CASE WHEN drcr.sign = 'CR' THEN 0 ELSE tp.payamt END,
	CASE WHEN drcr.sign = 'CR' THEN tp.payamt ELSE 0 END,
	0,
	tp.c_bpartner_id,
	tah.documentno
FROM
	tmp_c_allocationhdr tah
		JOIN tmp_c_allocationline tal
			ON tah.c_allocationhdr_id = tal.c_allocationhdr_id
		JOIN tmp_c_payment tp
			ON tal.c_payment_id = tp.c_payment_id
		JOIN c_acctschema accts
			ON tah.ad_client_id = accts.ad_client_id
		JOIN c_period p
			ON tah.ad_client_id = p.ad_client_id AND NOW() BETWEEN startdate AND enddate
		CROSS JOIN (
		VALUES ('DR'), ('CR')
	) drcr (sign)
		JOIN gl_category cat
			ON cat.ad_client_id = tah.ad_client_id AND cat.name = 'Cash/Payments'
		JOIN c_elementvalue ev_21100
			ON tah.ad_client_id = ev_21100.ad_client_id AND ev_21100.value = '21100'
		JOIN c_tax t
			ON t.ad_client_id = tah.ad_client_id;

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
	tmp_fact_acct;

/**********************************************************************************************************/
-- Update business partner open balances
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
					         AND i.IsSOTrx = 'N'
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
			bp.ad_client_id > 999999
			AND bp.isvendor = 'Y'
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************/
-- Wrap-up
/**********************************************************************************************************/
SELECT
	update_sequences();

-- Document numbers are not updated by the above function, so update them manually
UPDATE ad_sequence s
SET
	currentnext = (max_documentno + 1)
FROM
	(
		SELECT ad_client_id, MAX(documentno::numeric) max_documentno FROM tmp_c_invoice GROUP BY ad_client_id
	) i
WHERE
	s.ad_client_id = i.ad_client_id
	AND s.name IN ('DocumentNo_C_Invoice');
UPDATE ad_sequence s
SET
	currentnext = (max_documentno + 1)
FROM
	(
		SELECT ad_client_id, MAX(documentno::numeric) max_documentno FROM tmp_c_payment GROUP BY ad_client_id
	) i
WHERE
	s.ad_client_id = i.ad_client_id
	AND s.name IN ('DocumentNo_C_Payment');
UPDATE ad_sequence s
SET
	currentnext = (max_documentno + 1)
FROM
	(
		SELECT ad_client_id, MAX(documentno::numeric) max_documentno FROM tmp_c_allocationhdr GROUP BY ad_client_id
	) i
WHERE
	s.ad_client_id = i.ad_client_id
	AND s.name IN ('Allocation');

SELECT
	register_migration_script('202509161302_GO-984.sql')
FROM
	dual;
