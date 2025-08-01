/**********************************************************************************************************/
-- Create payments for all the previous expense invoices
/**********************************************************************************************************/
-- Create the payments
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
	datetrx            timestamp                       NOT NULL,
	isreceipt          char        DEFAULT 'N'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'S'         NOT NULL,
	c_bankaccount_id   numeric(10),
	c_bpartner_id      numeric(10),
	c_invoice_id       numeric(10),
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
	oprocessing        char,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
-- 	isreconciled             char         DEFAULT 'N'::bpchar NOT NULL,
	isallocated        char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	isonline                 char         DEFAULT 'N'::bpchar NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	isoverunderpayment char        DEFAULT 'Y'::bpchar NOT NULL,
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
	description        varchar(255),
	dateacct           timestamp                       NOT NULL,
-- 	c_order_id               numeric(10),
-- 	isprepayment             char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ref_payment_id           numeric(10),
	reversal_id        numeric(10),
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
	tmp_c_payment (ad_client_id, ad_org_id, documentno, datetrx, c_doctype_id, c_bankaccount_id, c_bpartner_id,
	               c_invoice_id, c_currency_id, payamt, dateacct)
SELECT
	i.ad_client_id,
	i.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	i.dateinvoiced,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	i.c_bpartner_id,
	i.c_invoice_id,
	i.c_currency_id,
	i.totallines,
	i.dateacct
FROM
	c_invoice i
		JOIN c_doctype dt
			ON i.ad_client_id = dt.ad_client_id AND docbasetype = 'APP'
		JOIN ad_sequence seq
			ON i.ad_client_id = seq.ad_client_id AND seq.name = 'DocumentNo_C_Payment'
		JOIN c_bankaccount ba
			ON i.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y'
WHERE
	i.issotrx = 'N'
	AND i.bh_visit_id IS NULL
	AND i.ispaid = 'N'
	AND i.docstatus IN ('CO', 'CL')
	AND i.ad_client_id > 999999;

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
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, isreceipt, c_doctype_id,
	           trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype, c_currency_id, payamt, isapproved,
	           r_avsaddr, r_avszip, processing, docstatus, docaction, isallocated, processed, posted, isoverunderpayment,
	           dateacct, processedon, c_payment_uu, bh_tender_amount)
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
-- Update all the accounting entries for these payments & allocations
/**********************************************************************************************************/
-- Insert into fact_account
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
	datetrx         timestamp                       NOT NULL,
	dateacct        timestamp   DEFAULT date(NOW()) NOT NULL,
	c_period_id     numeric(10),
	ad_table_id     numeric(10)                     NOT NULL,
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
-- 	c_uom_id        numeric(10),
	qty             numeric     DEFAULT 0,
-- 	m_product_id      numeric(10),
	c_bpartner_id   numeric(10),
-- 	ad_orgtrx_id      numeric(10),
-- 	c_locfrom_id    numeric(10),
-- 	c_locto_id      numeric(10),
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

-- Enter the accounting
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
-- Create the allocation records for each of these payments & invoices
/**********************************************************************************************************/
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
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp                       NOT NULL,
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
	c_allocationhdr_uu varchar(36) DEFAULT uuid_generate_v4(),
-- 	reversal_id        numeric(10) DEFAULT NULL::numeric,
	c_doctype_id       numeric(10)                     NOT NULL,
	tmp_c_payment_id   numeric                         NOT NULL
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
					name ILIKE 'c_allocationhdr'
				LIMIT 1
			)::INT,
			FALSE
	);

-- Insert the allocation headers
INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, datetrx, dateacct, c_currency_id, c_doctype_id,
	                     tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || tp.documentno || ' [1]',
	datetrx,
	dateacct,
	c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_c_payment tp
		JOIN ad_sequence seq
			ON tp.ad_client_id = seq.ad_client_id AND seq.name = 'Allocation'
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA';

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

-- Do the real inserts
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

-- Handle the allocation lines
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
	amount              numeric     DEFAULT 0   NOT NULL,
-- 	discountamt         numeric     DEFAULT 0           NOT NULL,
-- 	writeoffamt         numeric     DEFAULT 0           NOT NULL,
-- 	overunderamt        numeric     DEFAULT 0,
	c_allocationhdr_id  numeric(10)             NOT NULL,
	c_allocationline_uu varchar(36) DEFAULT uuid_generate_v4()
-- 	c_charge_id         numeric(10) DEFAULT NULL::numeric,
-- 	c_banktransfer_id   numeric(10) DEFAULT NULL::numeric
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
					name ILIKE 'c_allocationline'
				LIMIT 1
			)::INT,
			FALSE
	);

-- Insert the allocation lines
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	tp.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	tp.payamt * -1,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment tp
		JOIN tmp_c_allocationhdr tah
			ON tp.c_payment_id = tah.tmp_c_payment_id;

-- Insert the real deal
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

-- Enter the accounting
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

-- Update the invoices to have these payment IDs
UPDATE c_invoice i
SET
	c_payment_id = tp.c_payment_id,
	ispaid       = 'Y',
	updated      = NOW(),
	updatedby    = 100
FROM
	tmp_c_payment tp
WHERE
	i.c_invoice_id = tp.c_invoice_id;

/**********************************************************************************************************/
-- There are some old payments that are hanging around and hurting the open balances, so reverse those
/**********************************************************************************************************/
TRUNCATE TABLE tmp_c_payment;
INSERT INTO
	tmp_c_payment (ad_client_id, ad_org_id, documentno, datetrx, c_doctype_id, c_bankaccount_id, c_bpartner_id,
	               tendertype, c_currency_id, payamt, oprocessing, docstatus, docaction, description, dateacct,
	               reversal_id, bh_tender_amount)
SELECT
	p.ad_client_id,
	p.ad_org_id,
	p.documentno::numeric,
	NOW()::date,
	p.c_doctype_id,
	p.c_bankaccount_id,
	p.c_bpartner_id,
	p.tendertype,
	p.c_currency_id,
	p.payamt * -1,
	'N',
	'RE',
	'--',
	'{->' || p.documentno || ')',
	NOW()::date,
	p.c_payment_id,
	NULL
FROM
	c_payment p
		JOIN c_bpartner bp
			ON p.c_bpartner_id = bp.c_bpartner_id
		JOIN c_invoice i
			ON p.c_invoice_id = i.c_invoice_id AND i.docstatus = 'RE'
		JOIN c_bp_group bpg
			ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name NOT ILIKE 'Patients%'
WHERE
	bp.isvendor = 'Y'
	AND totalopenbalance != 0
	AND p.docstatus = 'CO'
	AND p.ad_client_id > 999999;

-- Now insert these
INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, isreceipt, c_doctype_id,
	           trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype, c_currency_id, payamt, isapproved,
	           r_avsaddr, r_avszip, processing, oprocessing, docstatus, docaction, isallocated, processed, posted,
	           isoverunderpayment, description, dateacct, reversal_id, processedon, c_payment_uu, bh_tender_amount)
SELECT
	c_payment_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno::text || '^',
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
	oprocessing,
	docstatus,
	docaction,
	isallocated,
	processed,
	posted,
	isoverunderpayment,
	description,
	dateacct,
	reversal_id,
	processedon,
	c_payment_uu,
	bh_tender_amount
FROM
	tmp_c_payment;

-- Reverse the existing payments
UPDATE c_payment p
SET
	updated      = NOW(),
	updatedby    = 100,
	c_invoice_id = NULL,
	docstatus    = 'RE',
	docaction    = '--',
	isallocated  = 'Y',
	description  = '(' || p.documentno || '^<-)',
	reversal_id  = tp.c_payment_id
FROM
	tmp_c_payment tp
WHERE
	p.c_payment_id = tp.reversal_id;

-- Insert the payment accounting records
TRUNCATE tmp_fact_acct;
INSERT INTO
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, c_period_id, ad_table_id, record_id,
	               gl_category_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty,
	               c_bpartner_id, description)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	accts.c_acctschema_id,
	CASE WHEN drcr.sign = 'CR' THEN ev_11100.c_elementvalue_id ELSE ev_99999.c_elementvalue_id END,
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
	tp.documentno::text || '^ (' || tp.description || ')'
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

-- Create the allocations and allocation lines
TRUNCATE tmp_c_allocationhdr;
INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, datetrx, dateacct, c_currency_id, c_doctype_id,
	                     tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'Payment: ' || tp.documentno || '^',
	datetrx,
	dateacct,
	c_currency_id,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_c_payment tp
		JOIN ad_sequence seq
			ON tp.ad_client_id = seq.ad_client_id AND seq.name = 'Allocation'
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA';

-- Do the real inserts
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

-- Insert the lines
TRUNCATE tmp_c_allocationline;
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	tp.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	tp.payamt * -1,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment tp
		JOIN tmp_c_allocationhdr tah
			ON tp.c_payment_id = tah.tmp_c_payment_id;
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	p.ad_client_id,
	p.ad_org_id,
	p.c_invoice_id,
	p.c_bpartner_id,
	p.c_payment_id,
	p.payamt * -1,
	tah.c_allocationhdr_id
FROM
	tmp_c_payment tp
		JOIN c_payment p
			ON tp.reversal_id = p.c_payment_id
		JOIN tmp_c_allocationhdr tah
			ON tp.c_payment_id = tah.tmp_c_payment_id;

-- Insert the real deal
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

-- Insert the allocation accounting records
TRUNCATE TABLE tmp_fact_acct;
INSERT INTO
	tmp_fact_acct (ad_client_id, ad_org_id, c_acctschema_id, account_id, datetrx, c_period_id, ad_table_id, record_id,
	               line_id, gl_category_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, qty,
	               c_bpartner_id, description)
SELECT
	tah.ad_client_id,
	tah.ad_org_id,
	accts.c_acctschema_id,
	ev_99999.c_elementvalue_id,
	tah.datetrx,
	p.c_period_id,
	735,
	tah.c_allocationhdr_id,
	tal.c_allocationline_id,
	cat.gl_category_id,
	tah.c_currency_id,
	tal.amount,
	0,
	tal.amount,
	0,
	0,
	tp.c_bpartner_id,
	tah.documentno || ' #0 (' || tah.description || ')'
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
		JOIN gl_category cat
			ON cat.ad_client_id = tah.ad_client_id AND cat.name = 'Cash/Payments'
		JOIN c_elementvalue ev_99999
			ON tah.ad_client_id = ev_99999.ad_client_id AND ev_99999.value = '99999'
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
-- Update the BP open balances
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
	register_migration_script('202507311735_GO-984.sql')
FROM
	dual;
