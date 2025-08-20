-- Get the Business Partners with negative open balances
SELECT
	bp.c_bpartner_id
INTO TEMP TABLE
	tmp_bp_with_negative_open_balances
FROM
	c_bpartner bp
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'Patients - DO NOT CHANGE'
WHERE
	bp.totalopenbalance < 0
	AND bp.ad_client_id > 999999;

-- Create invoices with their negative total open balance assigned to the waive debt charge
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
	description            varchar(255) DEFAULT 'Programmatically clearing negative open balance via waiver',
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
	paymentrule            char         DEFAULT 'b'         NOT NULL,
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
	ispaid                 char         DEFAULT 'N'::bpchar NOT NULL,
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
	isfixedassetinvoice    char         DEFAULT 'N'
-- 	relatedinvoice_id      numeric(10)  DEFAULT NULL::numeric,
-- 	bh_navbuttons          varchar(36)  DEFAULT NULL::character varying,
-- 	bh_voided_reason_id    numeric(10)  DEFAULT NULL::numeric,
-- 	bh_visit_id            numeric(10)  DEFAULT NULL::numeric
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
	               c_bpartner_location_id, c_currency_id, c_paymentterm_id, m_pricelist_id, totallines, grandtotal)
SELECT
	bp.ad_client_id,
	bp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	bp.c_bpartner_id,
	bpl.c_bpartner_location_id,
	accts.c_currency_id,
	pt.c_paymentterm_id,
	COALESCE(bp.m_pricelist_id, bpg.m_pricelist_id),
	bp.totalopenbalance * -1,
	bp.totalopenbalance * -1
FROM
	tmp_bp_with_negative_open_balances bpwnob
		JOIN c_bpartner bp
			ON bpwnob.c_bpartner_id = bp.c_bpartner_id
		JOIN (
		SELECT
			bpl.c_bpartner_id,
			c_bpartner_location_id,
			ROW_NUMBER() OVER ( PARTITION BY bpl.c_bpartner_id ) AS loc_count
		FROM
			c_bpartner_location bpl
				JOIN tmp_bp_with_negative_open_balances bpwnob
					ON bpl.c_bpartner_id = bpwnob.c_bpartner_id
	) bpl
			ON bpl.c_bpartner_id = bp.c_bpartner_id AND bpl.loc_count = 1
		JOIN ad_sequence seq
			ON seq.ad_client_id = bp.ad_client_id AND seq.name = 'AR Invoice'
		JOIN c_doctype dt
			ON bp.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice Indirect'
		JOIN ad_clientinfo ci
			ON bp.ad_client_id = ci.ad_client_id
		JOIN c_acctschema accts
			ON accts.c_acctschema_id = ci.c_acctschema1_id
		JOIN c_paymentterm pt
			ON pt.ad_client_id = bp.ad_client_id AND pt.value = 'Immediate'
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id;

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
	           grandtotal, m_pricelist_id, processedon, c_invoice_uu, isfixedassetinvoice, ispaid)
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
	line                numeric(10) DEFAULT 10          NOT NULL,
-- 	description               varchar(255),
-- 	m_product_id              numeric(10),
	qtyinvoiced         numeric     DEFAULT 1           NOT NULL,
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
	qtyentered          numeric     DEFAULT 1           NOT NULL,
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
-- 	c_1099box_id              numeric(10) DEFAULT NULL::numeric
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
	bp.totalopenbalance * -1,
	bp.totalopenbalance * -1,
	c.c_charge_id,
	t.c_tax_id,
	bp.totalopenbalance * -1
FROM
	tmp_c_invoice ti
		JOIN c_bpartner bp
			ON ti.c_bpartner_id = bp.c_bpartner_id
		JOIN c_tax t
			ON t.ad_client_id = ti.ad_client_id
		JOIN c_charge c
			ON ti.ad_client_id = c.ad_client_id AND c.name = 'Bad debt write-off - DO NOT CHANGE';

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

-- Create fact_acct records for the invoices
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

-- Delete drafted payments that aren't tied to a visit
DELETE
FROM
	c_payment
WHERE
	bh_visit_id IS NULL
	AND docstatus = 'DR'
	AND NOT EXISTS (
		SELECT 1 FROM c_allocationline WHERE c_allocationline.c_payment_id = c_payment.c_payment_id
	)
	AND NOT EXISTS (
		SELECT 1 FROM c_payment p WHERE p.ref_payment_id = c_payment.c_payment_id
	);

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

-- We won't update the allocations since there are more variables to consider than we want
-- BUT, update the Business Partner open balances now
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
				JOIN tmp_bp_with_negative_open_balances tbwnob
					ON bp.c_bpartner_id = tbwnob.c_bpartner_id
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

-- Wrap up
SELECT
	register_migration_script('202508191957_GO-3398.sql')
FROM
	dual;
