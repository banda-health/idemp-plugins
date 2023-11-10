/**********************************************************************************************************/
-- Remove non-patient payment charges from orders
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_orders_with_npp_charge;
SELECT DISTINCT
	o.c_order_id,
	c.c_charge_id,
	bp.c_bpartner_id,
	bpl.c_bpartner_location_id,
	ol.linenetamt * -1   AS linenetamt,  -- since these were on orders, their amounts were negative
	ol.qtyentered,
	ol.priceentered * -1 AS priceentered -- since these were on orders, their amounts were negative
INTO TEMP TABLE
	tmp_orders_with_npp_charge
FROM
	c_bpartner bp
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN c_bp_group_acct bpga
		ON bpg.c_bp_group_id = bpga.c_bp_group_id
		JOIN c_validcombination vc_bp
		ON bpga.c_receivable_acct = vc_bp.c_validcombination_id
		JOIN c_elementvalue ev_bp
		ON vc_bp.account_id = ev_bp.c_elementvalue_id
		JOIN c_elementvalue ev_c
		ON ev_bp.value = ev_c.value AND ev_bp.ad_client_id = ev_c.ad_client_id
		JOIN c_validcombination vc_c
		ON vc_c.account_id = ev_c.c_elementvalue_id
		JOIN c_charge_acct ca
		ON vc_c.c_validcombination_id = ca.ch_expense_acct
		JOIN c_charge c
		ON ca.c_charge_id = c.c_charge_id
		JOIN c_chargetype ct
		ON c.c_chargetype_id = ct.c_chargetype_id
		JOIN c_orderline ol
		ON c.c_charge_id = ol.c_charge_id
		JOIN c_order o
		ON ol.c_order_id = o.c_order_id
		JOIN c_bpartner_location bpl
		ON bp.c_bpartner_id = bpl.c_bpartner_id
		JOIN c_invoiceline il
		ON ol.c_orderline_id = il.c_orderline_id
		JOIN bh_bp_specific_payer_info bpspi
		ON bpspi.c_invoiceline_id = il.c_invoiceline_id
		JOIN bh_payer_info_fld pif
		ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id AND pif.bh_payer_id = bp.c_bpartner_id
WHERE
	ct.name = 'Non-Patient Payment - DO NOT CHANGE'
	AND c.isactive = 'Y'
	AND o.docstatus IN ('CO', 'CL')
	AND o.created < '2023-11-07 05:00';

-- The charges on any invoice lines shouldn't have any order line references, so remove them
UPDATE c_invoiceline
SET
	c_orderline_id = NULL
WHERE
		c_orderline_id IN (
		SELECT
			ol.c_orderline_id
		FROM
			c_orderline ol
				JOIN tmp_orders_with_npp_charge ownppc
				ON ownppc.c_order_id = ol.c_order_id AND ownppc.c_charge_id = ol.c_charge_id
	);
-- Also reset any shipment line references on the invoices
UPDATE c_invoiceline
SET
	m_inoutline_id = NULL
WHERE
		m_inoutline_id IN (
		SELECT
			m_inoutline_id
		FROM
			m_inoutline
		WHERE
				c_orderline_id IN (
				SELECT
					ol.c_orderline_id
				FROM
					c_orderline ol
						JOIN tmp_orders_with_npp_charge ownppc
						ON ownppc.c_order_id = ol.c_order_id AND ownppc.c_charge_id = ol.c_charge_id
			)
	);

-- Since we can't ship charges, remove those
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline
WHERE
		c_orderline_id IN (
		SELECT
			ol.c_orderline_id
		FROM
			c_orderline ol
				JOIN tmp_orders_with_npp_charge ownppc
				ON ownppc.c_order_id = ol.c_order_id AND ownppc.c_charge_id = ol.c_charge_id
	);
	$$, 'm_inoutline_id');

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_orders_with_npp_charge ownppc
WHERE
	ol.c_order_id = ownppc.c_order_id
	AND ol.c_charge_id = ownppc.c_charge_id;
	$$, 'c_orderline_id');

-- Update the order grand total (this will make some older, weird invoices be different, but oh well)
UPDATE c_order o
SET
	totallines = ol.total_lines,
	grandtotal = ol.total_lines
FROM
	(
		SELECT
			ol.c_order_id,
			SUM(ol.linenetamt) AS total_lines
		FROM
			c_orderline ol
				JOIN tmp_orders_with_npp_charge ownppc
				ON ownppc.c_order_id = ol.c_order_id
		GROUP BY ol.c_order_id
	) ol
WHERE
	o.c_order_id = ol.c_order_id;

-- (Order amounts aren't posted anywhere, so nothing else to update)

/**********************************************************************************************************/
-- Create completed invoices for the associated BPs with the positive charge on it
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_invoice;
CREATE TEMP TABLE tmp_c_invoice
(
	c_invoice_id           serial                           NOT NULL,
	ad_client_id           numeric(10)                      NOT NULL,
	ad_org_id              numeric(10)                      NOT NULL,
-- 	isactive               char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp   DEFAULT NOW()       NOT NULL,
	createdby              numeric(10)  DEFAULT 100         NOT NULL,
-- 	updated                timestamp   DEFAULT NOW()       NOT NULL,
	updatedby              numeric(10)  DEFAULT 100         NOT NULL,
-- 	issotrx                char        DEFAULT 'Y'::bpchar NOT NULL,
	documentno             numeric                          NOT NULL,
	docstatus              char(2)      DEFAULT 'CO'        NOT NULL,
	docaction              char(2)      DEFAULT 'CL'        NOT NULL,
	processing             char         DEFAULT 'N',
	processed              char         DEFAULT 'Y'::bpchar NOT NULL,
	posted                 char         DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id           numeric(10)                      NOT NULL,
	c_doctypetarget_id     numeric(10)                      NOT NULL,
-- 	c_order_id             numeric(10),
	description            varchar(255) DEFAULT 'In-arrears-generated Insurer/Donor Invoice',
-- 	isapproved             char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	istransferred          char        DEFAULT 'N'::bpchar NOT NULL,
-- 	isprinted              char        DEFAULT 'N'::bpchar NOT NULL,
-- 	salesrep_id            numeric(10),
	dateinvoiced           timestamp    DEFAULT date(NOW()) NOT NULL,
-- 	dateprinted            timestamp,
	dateacct               timestamp    DEFAULT date(NOW()) NOT NULL,
	c_bpartner_id          numeric(10)                      NOT NULL,
	c_bpartner_location_id numeric(10)                      NOT NULL,
-- 	poreference            varchar(20),
	isdiscountprinted      char         DEFAULT 'N'::bpchar NOT NULL,
-- 	dateordered            timestamp,
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
	processedon            numeric      DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
-- 	c_cashplanline_id      numeric(10)  DEFAULT NULL::numeric,
	c_invoice_uu           uuid         DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char         DEFAULT 'N',
-- 	relatedinvoice_id      numeric(10)  DEFAULT NULL::numeric,
-- 	bh_navbuttons          varchar(36)  DEFAULT NULL::character varying,
-- 	bh_voided_reason_id    numeric(10)  DEFAULT NULL::numeric,
	bh_visit_id            numeric(10),
	tmp_c_order_id         numeric(10)
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
	tmp_c_invoice (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_bpartner_id,
	               c_bpartner_location_id, c_currency_id, c_paymentterm_id, m_pricelist_id, tmp_c_order_id, totallines,
	               grandtotal, bh_visit_id)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	ownppc.c_bpartner_id,
	ownppc.c_bpartner_location_id,
	accts.c_currency_id,
	pt.c_paymentterm_id,
	o.m_pricelist_id,
	o.c_order_id,
	ownppc.total_lines,
	ownppc.total_lines,
	o.bh_visit_id
FROM
	(
		SELECT
			c_order_id,
			c_bpartner_id,
			c_bpartner_location_id,
			SUM(linenetamt) AS total_lines
		FROM
			tmp_orders_with_npp_charge
		GROUP BY c_order_id, c_bpartner_id, c_bpartner_location_id
	) ownppc
		JOIN c_order o
		ON ownppc.c_order_id = o.c_order_id
		JOIN ad_sequence seq
		ON seq.ad_client_id = o.ad_client_id AND seq.name = 'AR Invoice'
		JOIN c_doctype dt
		ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
		JOIN ad_clientinfo ci
		ON o.ad_client_id = ci.ad_client_id
		JOIN c_acctschema accts
		ON accts.c_acctschema_id = ci.c_acctschema1_id
		JOIN c_paymentterm pt
		ON pt.ad_client_id = o.ad_client_id AND pt.value = 'Immediate';

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

-- Now create the real invoices!
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, docstatus, docaction, processing,
	           processed, posted, c_doctype_id, c_doctypetarget_id, description, dateinvoiced, dateacct, c_bpartner_id,
	           c_bpartner_location_id, isdiscountprinted, c_currency_id, paymentrule, c_paymentterm_id, totallines,
	           grandtotal, m_pricelist_id, processedon, c_invoice_uu, isfixedassetinvoice, bh_visit_id, ispaid)
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
	bh_visit_id,
	ispaid
FROM
	tmp_c_invoice;

-- Now insert the invoice lines
DROP TABLE IF EXISTS tmp_c_invoiceline;
CREATE TEMP TABLE tmp_c_invoiceline
(
	c_invoiceline_id    serial                          NOT NULL,
	ad_client_id        numeric(10)                     NOT NULL,
	ad_org_id           numeric(10)                     NOT NULL,
-- 	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby           numeric(10) DEFAULT 100         NOT NULL,
	c_invoice_id        numeric(10)                     NOT NULL,
-- 	c_orderline_id            numeric(10),
-- 	m_inoutline_id            numeric(10),
	line                numeric(10)                     NOT NULL,
-- 	description               varchar(255),
-- 	m_product_id              numeric(10),
	qtyinvoiced         numeric                         NOT NULL,
-- 	pricelist                 numeric     DEFAULT 0           NOT NULL,
	priceactual         numeric                         NOT NULL,
-- 	pricelimit                numeric     DEFAULT 0           NOT NULL,
	linenetamt          numeric                         NOT NULL,
	c_charge_id         numeric(10),
	c_uom_id            numeric(10) DEFAULT 100,
	c_tax_id            numeric(10),
-- 	s_resourceassignment_id   numeric(10),
-- 	a_asset_id                numeric(10),
-- 	taxamt                    numeric     DEFAULT 0,
-- 	m_attributesetinstance_id numeric(10) DEFAULT 0,
-- 	isdescription             char        DEFAULT 'N'::bpchar NOT NULL,
-- 	isprinted                 char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	linetotalamt              numeric     DEFAULT 0,
-- 	ref_invoiceline_id        numeric(10),
	processed           char        DEFAULT 'Y'::bpchar NOT NULL,
	qtyentered          numeric                         NOT NULL,
	priceentered        numeric                         NOT NULL,
-- 	c_project_id              numeric(10),
-- 	c_projectphase_id         numeric(10),
-- 	c_projecttask_id          numeric(10),
-- 	rrstartdate               timestamp,
-- 	rramt                     numeric,
-- 	c_campaign_id             numeric(10),
-- 	c_activity_id             numeric(10),
-- 	user1_id                  numeric(10),
-- 	user2_id                  numeric(10),
-- 	ad_orgtrx_id              numeric(10),
-- 	m_rmaline_id              numeric(10),
-- 	a_createasset             char        DEFAULT 'N'::bpchar,
-- 	a_processed               char        DEFAULT 'N'::bpchar,
-- 	a_capvsexp                varchar(3),
-- 	a_asset_group_id          numeric(10),
	c_invoiceline_uu    uuid        DEFAULT uuid_generate_v4(),
	isfixedassetinvoice char        DEFAULT 'N'
-- 	c_1099box_id              numeric(10) DEFAULT NULL::numeric,
-- 	bh_navbuttons             varchar(36) DEFAULT NULL::character varying
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
	tmp_c_invoiceline (ad_client_id, ad_org_id, c_invoice_id, line, qtyinvoiced, priceactual, c_charge_id, c_tax_id,
	                   qtyentered, priceentered, linenetamt)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.c_invoice_id,
	0, -- Will be updated down below based on c_invoice_id partition
	ownppc.qtyentered,
	ownppc.priceentered,
	ownppc.c_charge_id,
	t.c_tax_id,
	ownppc.qtyentered,
	ownppc.priceentered,
	ownppc.linenetamt
FROM
	tmp_orders_with_npp_charge ownppc
		JOIN tmp_c_invoice ti
		ON ownppc.c_order_id = ti.tmp_c_order_id AND ti.c_bpartner_id = ownppc.c_bpartner_id AND
		   ti.c_bpartner_location_id = ownppc.c_bpartner_location_id
		JOIN c_tax t
		ON t.ad_client_id = ti.ad_client_id;

-- Set the line numbers correctly
UPDATE tmp_c_invoiceline til
SET
	line = tilrn.row_num * 10
FROM
	(
		SELECT
			c_invoiceline_id,
			ROW_NUMBER() OVER (PARTITION BY c_invoice_id ORDER BY c_invoiceline_id) AS row_num
		FROM
			tmp_c_invoiceline
	) tilrn
WHERE
	til.c_invoiceline_id = tilrn.c_invoiceline_id;

-- Now insert the real invoice lines!
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

-- Insert into fact_account
DROP TABLE IF EXISTS tmp_fact_acct;
CREATE TEMP TABLE tmp_fact_acct
(
	fact_acct_id    serial                          NOT NULL,
	ad_client_id    numeric(10)                     NOT NULL,
	ad_org_id       numeric(10)                     NOT NULL,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby       numeric(10) DEFAULT 100         NOT NULL,
-- 	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby       numeric(10) DEFAULT 100         NOT NULL,
	c_acctschema_id numeric(10)                     NOT NULL,
	account_id      numeric(10)                     NOT NULL,
	datetrx         timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct        timestamp   DEFAULT date(NOW()) NOT NULL,
	c_period_id     numeric(10),
	ad_table_id     numeric(10) DEFAULT 318         NOT NULL,
	record_id       numeric(10)                     NOT NULL,
	line_id         numeric(10),
	gl_category_id  numeric(10),
-- 	gl_budget_id      numeric(10),
	c_tax_id        numeric(10),
-- 	m_locator_id      numeric(10),
	postingtype     char        DEFAULT 'A'         NOT NULL,
	c_currency_id   numeric(10)                     NOT NULL,
	amtsourcedr     numeric                         NOT NULL,
	amtsourcecr     numeric                         NOT NULL,
	amtacctdr       numeric                         NOT NULL,
	amtacctcr       numeric                         NOT NULL,
	c_uom_id        numeric(10),
	qty             numeric,
-- 	m_product_id      numeric(10),
	c_bpartner_id   numeric(10),
-- 	ad_orgtrx_id      numeric(10),
	c_locfrom_id    numeric(10),
	c_locto_id      numeric(10),
-- 	c_salesregion_id  numeric(10),
-- 	c_project_id      numeric(10),
-- 	c_campaign_id     numeric(10),
-- 	c_activity_id     numeric(10),
-- 	user1_id          numeric(10),
-- 	user2_id          numeric(10),
	description     varchar(255),
-- 	a_asset_id        numeric(10),
-- 	c_subacct_id      numeric(10),
-- 	userelement1_id   numeric(10),
-- 	userelement2_id   numeric(10),
-- 	c_projectphase_id numeric(10),
-- 	c_projecttask_id  numeric(10),
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
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, c_period_id, record_id, line_id, gl_category_id,
	               c_tax_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, c_uom_id, qty, c_bpartner_id,
	               c_locfrom_id, c_locto_id, description)
SELECT
	til.ad_client_id,
	til.ad_org_id,
	accts.c_acctschema_id,
	vc.account_id,
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
		JOIN c_period p
		ON til.ad_client_id = p.ad_client_id AND NOW() BETWEEN startdate AND enddate
		CROSS JOIN (
		VALUES ('DR'), ('CR')
	) drcr (sign)
		JOIN gl_category cat
		ON cat.ad_client_id = til.ad_client_id AND cat.name = 'AR Invoice'
		JOIN c_tax t
		ON t.ad_client_id = til.ad_client_id
		JOIN tmp_c_invoice ti
		ON ti.c_invoice_id = til.c_invoice_id
		JOIN c_bpartner_location bpl
		ON ti.c_bpartner_location_id = bpl.c_bpartner_location_id
		JOIN ad_orginfo oi
		ON ti.ad_org_id = oi.ad_org_id;

-- Insert the real accounts
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
-- Create payments for all the insurers/donors to clear open balances
/**********************************************************************************************************/
-- Create the payments
DROP TABLE IF EXISTS tmp_c_payment;
CREATE TEMP TABLE tmp_c_payment
(
	c_payment_id       serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
-- 	isactive                 char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                  timestamp    DEFAULT NOW()       NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                  timestamp    DEFAULT NOW()       NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	datetrx            timestamp   DEFAULT DATE(NOW()) NOT NULL,
-- 	isreceipt                char         DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'S'         NOT NULL,
	c_bankaccount_id   numeric(10),
	c_bpartner_id      numeric(10),
-- 	c_invoice_id             numeric(10),
-- 	c_bp_bankaccount_id      numeric(10),
-- 	c_paymentbatch_id        numeric(10),
	tendertype         char        DEFAULT 'X'         NOT NULL,
-- 	creditcardtype           char,
-- 	creditcardnumber         varchar(20),
-- 	creditcardvv             varchar(4),
-- 	creditcardexpmm          numeric(10),
-- 	creditcardexpyy          numeric(10),
-- 	micr                     varchar(20),
-- 	routingno                varchar(20),
-- 	accountno                varchar(20),
-- 	checkno                  varchar(20),
-- 	a_name                   varchar(60),
-- 	a_street                 varchar(60),
-- 	a_city                   varchar(60),
-- 	a_state                  varchar(40),
-- 	a_zip                    varchar(20),
-- 	a_ident_dl               varchar(20),
-- 	a_ident_ssn              varchar(20),
-- 	a_email                  varchar(60),
-- 	voiceauthcode            varchar(20),
-- 	orig_trxid               varchar(20),
-- 	ponum                    varchar(60),
	c_currency_id      numeric(10)                     NOT NULL,
	payamt             numeric                         NOT NULL,
-- 	discountamt              numeric      DEFAULT 0,
-- 	writeoffamt              numeric      DEFAULT 0,
-- 	taxamt                   numeric      DEFAULT 0,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	r_pnref                  varchar(20),
-- 	r_result                 varchar(20),
-- 	r_respmsg                varchar(60),
-- 	r_authcode               varchar(20),
	r_avsaddr          char        DEFAULT 'X',
	r_avszip           char        DEFAULT 'X',
-- 	r_info                   varchar(2000),
	processing         char        DEFAULT 'N',
-- 	oprocessing              char,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
-- 	isreconciled             char         DEFAULT 'N'::bpchar NOT NULL,
	isallocated        char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isonline                 char         DEFAULT 'N'::bpchar NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	isoverunderpayment char        DEFAULT 'N'::bpchar NOT NULL,
-- 	overunderamt             numeric      DEFAULT 0,
-- 	a_country                varchar(40),
-- 	c_project_id             numeric(10),
-- 	isselfservice            char         DEFAULT 'N'::bpchar NOT NULL,
-- 	chargeamt                numeric      DEFAULT 0,
-- 	c_charge_id              numeric(10),
-- 	isdelayedcapture         char         DEFAULT 'N'::bpchar NOT NULL,
-- 	r_authcode_dc            varchar(20),
-- 	r_cvv2match              char,
-- 	r_pnref_dc               varchar(20),
-- 	swipe                    varchar(80),
-- 	ad_orgtrx_id             numeric(10),
-- 	c_campaign_id            numeric(10),
-- 	c_activity_id            numeric(10),
-- 	user1_id                 numeric(10),
-- 	user2_id                 numeric(10),
-- 	c_conversiontype_id      numeric(10),
-- 	description              varchar(255),
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
-- 	c_order_id               numeric(10),
-- 	isprepayment             char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ref_payment_id           numeric(10),
-- 	reversal_id              numeric(10),
-- 	c_cashbook_id            numeric(10),
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_payment_uu       uuid        DEFAULT uuid_generate_v4(),
-- 	c_postendertype_id       numeric(10)  DEFAULT NULL::numeric,
-- 	c_paymentprocessor_id    numeric(10)  DEFAULT NULL::numeric,
-- 	customerpaymentprofileid varchar(60)  DEFAULT NULL::character varying,
-- 	customerprofileid        varchar(60)  DEFAULT NULL::character varying,
-- 	customeraddressid        varchar(60)  DEFAULT NULL::character varying,
-- 	isvoided                 char         DEFAULT 'N'::bpchar NOT NULL,
-- 	r_voidmsg                varchar(255) DEFAULT NULL::character varying,
-- 	c_depositbatch_id        numeric(10)  DEFAULT NULL::numeric,
-- 	iban                     varchar(40)  DEFAULT NULL::character varying,
-- 	swiftcode                varchar(20)  DEFAULT NULL::character varying,
-- 	bh_visit_id              numeric(10),
-- 	bh_navbuttons            varchar(36)  DEFAULT NULL::character varying,
-- 	nhif_number              varchar(10)  DEFAULT NULL::character varying,
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
	tmp_c_payment (ad_client_id, ad_org_id, documentno, c_doctype_id, c_bankaccount_id, c_bpartner_id, c_currency_id,
	               payamt)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	ti.c_bpartner_id,
	ti.c_currency_id,
	ti.payamt
FROM
	(
		SELECT
			ad_client_id,
			ad_org_id,
			c_bpartner_id,
			c_currency_id,
			SUM(totallines) AS payamt
		FROM
			tmp_c_invoice
		GROUP BY ad_client_id, ad_org_id, c_bpartner_id, c_currency_id
	) ti
		JOIN c_doctype dt
		ON ti.ad_client_id = dt.ad_client_id AND docbasetype = 'ARR'
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
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, c_doctype_id, trxtype,
	           c_bankaccount_id, c_bpartner_id, tendertype, c_currency_id, payamt, isapproved, r_avsaddr, r_avszip,
	           processing, docstatus, docaction, isallocated, processed, posted, isoverunderpayment, dateacct,
	           processedon, c_payment_uu, bh_tender_amount)
SELECT
	c_payment_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno,
	datetrx,
	c_doctype_id,
	trxtype,
	c_bankaccount_id,
	c_bpartner_id,
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

-- Enter the accounting
TRUNCATE tmp_fact_acct;
INSERT INTO
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, c_period_id, ad_table_id, record_id,
	               gl_category_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty,
	               c_bpartner_id, description)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	accts.c_acctschema_id,
	CASE WHEN drcr.sign = 'CR' THEN ev_11100.c_elementvalue_id ELSE ev_99999.c_elementvalue_id END,
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
		ON cat.ad_client_id = tp.ad_client_id AND cat.name = 'AR Receipt'
		JOIN c_elementvalue ev_99999
		ON tp.ad_client_id = ev_99999.ad_client_id AND ev_99999.value = '99999'
		JOIN c_elementvalue ev_11100
		ON tp.ad_client_id = ev_11100.ad_client_id AND ev_11100.value = '11100'
		JOIN c_tax t
		ON t.ad_client_id = tp.ad_client_id;

-- Insert the real accounts
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

-- Allocate the payments (these don't have account postings)
-- Create an allocation header for each payment
DROP TABLE IF EXISTS tmp_c_allocationhdr;
CREATE TEMP TABLE tmp_c_allocationhdr
(
	c_allocationhdr_id serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
-- 	isactive           char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created            timestamp   DEFAULT NOW()       NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
-- 	updated            timestamp   DEFAULT NOW()       NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         numeric                         NOT NULL,
	description        varchar(255),
	datetrx            timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
-- 	approvalamt        numeric     DEFAULT 0           NOT NULL,
-- 	ismanual           char        DEFAULT 'N'::bpchar NOT NULL,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
-- 	reversal_id        numeric(10) DEFAULT NULL::numeric,
	c_doctype_id       numeric(10)                     NOT NULL,
	tmp_c_payment_id   numeric(10)                     NOT NULL
);

SELECT
	SETVAL(
		'tmp_c_allocationhdr_c_allocationhdr_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_AllocationHdr'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, c_currency_id, c_doctype_id, tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || documentno,
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

-- Now insert the real allocation headers!
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

-- Lastly, prepare the allocation lines
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TEMP TABLE tmp_c_allocationline
(
	c_allocationline_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
-- 	isactive            char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created             timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
-- 	updated             timestamp   DEFAULT NOW()       NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
-- 	allocationno        numeric(10),
-- 	datetrx             timestamp,
-- 	ismanual            char        DEFAULT 'N'::bpchar,
	c_invoice_id        numeric(10),
	c_bpartner_id       numeric(10),
-- 	c_order_id          numeric(10),
	c_payment_id        numeric(10),
-- 	c_cashline_id       numeric(10),
	amount              numeric                 NOT NULL,
-- 	discountamt         numeric     DEFAULT 0   NOT NULL,
-- 	writeoffamt         numeric     DEFAULT 0   NOT NULL,
-- 	overunderamt        numeric     DEFAULT 0,
	c_allocationhdr_id  numeric(10)             NOT NULL,
	c_allocationline_uu uuid        DEFAULT uuid_generate_v4()
-- 	c_charge_id         numeric(10) DEFAULT NULL::numeric
);

SELECT
	SETVAL(
		'tmp_c_allocationline_c_allocationline_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_AllocationLine'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.c_invoice_id,
	ti.c_bpartner_id,
	tp.c_payment_id,
	ti.totallines,
	tah.c_allocationhdr_id
FROM
	tmp_c_invoice ti
		JOIN tmp_c_payment tp
		ON tp.c_bpartner_id = ti.c_bpartner_id
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

-- BP open balances do not need to be updated because nothing changed (all that was invoiced was paid)

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
		SELECT ad_client_id, MAX(documentno::numeric) max_documentno FROM c_invoice GROUP BY ad_client_id
	) i
WHERE
	s.ad_client_id = i.ad_client_id
	AND s.name IN ('AR Invoice', 'DocumentNo_C_Payment', 'Allocation');

SELECT
	register_migration_script('202311091011_GO-2820.sql')
FROM
	dual;
