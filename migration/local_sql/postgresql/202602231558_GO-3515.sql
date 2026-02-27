-- First make sure the BPs are "On Credit" that were previously "Cash"
UPDATE c_bpartner
SET
	paymentrule = 'P'
WHERE
	ad_client_id NOT IN (0, 11)
	AND paymentrule != 'P';

-- Get the list of invoices we're working with
SELECT
	i.c_invoice_id
INTO TEMP TABLE
	tmp_c_invoices_to_fix
FROM
	c_invoice i
		JOIN LATERAL (SELECT
			              c_invoice_id
		              FROM
			              c_allocationline al
		              WHERE
			              al.c_invoice_id = i.c_invoice_id
		              GROUP BY c_invoice_id, amount
		              HAVING
			              COUNT(*) > 1) al
			ON al.c_invoice_id = i.c_invoice_id
WHERE
	i.issotrx = 'N'
	AND i.bh_visit_id IS NULL
	AND i.c_order_id IS NULL
	AND i.docstatus IN ('CO', 'CL')
	AND ispaid = 'N';

-- Update those invoices
UPDATE c_invoice
SET
	updated      = NOW(),
	updatedby    = 100,
	ispaid       = 'Y',
	c_payment_id = NULL
WHERE
	c_invoice_id IN (
		SELECT
			c_invoice_id
		FROM
			tmp_c_invoices_to_fix
	);

-- Insert payment reversals
DROP TABLE IF EXISTS tmp_c_payment;
CREATE TEMP TABLE tmp_c_payment
(
	c_payment_id             serial                          NOT NULL,
	ad_client_id             numeric(10)                     NOT NULL,
	ad_org_id                numeric(10)                     NOT NULL,
-- 	isactive                 char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                  timestamp    DEFAULT NOW()       NOT NULL,
	createdby                numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                  timestamp    DEFAULT NOW()       NOT NULL,
	updatedby                numeric(10) DEFAULT 100         NOT NULL,
	documentno               varchar(30)                     NOT NULL,
	datetrx                  timestamp                       NOT NULL,
	isreceipt                char        DEFAULT 'N'::bpchar NOT NULL,
	c_doctype_id             numeric(10)                     NOT NULL,
	trxtype                  char                            NOT NULL,
	c_bankaccount_id         numeric(10),
	c_bpartner_id            numeric(10),
	c_invoice_id             numeric(10),
-- 	c_bp_bankaccount_id      numeric(10),
-- 	c_paymentbatch_id        numeric(10),
	tendertype               char                            NOT NULL,
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
	c_currency_id            numeric(10)                     NOT NULL,
	payamt                   numeric                         NOT NULL,
-- 	discountamt              numeric      DEFAULT 0,
-- 	writeoffamt              numeric      DEFAULT 0,
-- 	taxamt                   numeric      DEFAULT 0,
	isapproved               char                            NOT NULL,
-- 	r_pnref                  varchar(20),
-- 	r_result                 varchar(20),
-- 	r_respmsg                varchar(60),
-- 	r_authcode               varchar(20),
	r_avsaddr                char,
	r_avszip                 char,
-- 	r_info                   varchar(2000),
	processing               char        DEFAULT 'N',
	oprocessing              char        DEFAULT 'N',
	docstatus                char(2)     DEFAULT 'RE'        NOT NULL,
	docaction                char(2)     DEFAULT '--'        NOT NULL,
	isreconciled             char                            NOT NULL,
	isallocated              char                            NOT NULL,
-- 	isonline                 char         DEFAULT 'N'::bpchar NOT NULL,
	processed                char        DEFAULT 'Y'         NOT NULL,
	posted                   char        DEFAULT 'Y'         NOT NULL,
	isoverunderpayment       char        DEFAULT 'N'         NOT NULL,
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
	description              varchar(255),
	dateacct                 timestamp   DEFAULT NOW()::date NOT NULL,
-- 	c_order_id               numeric(10),
-- 	isprepayment             char         DEFAULT 'N'::bpchar NOT NULL,
-- 	ref_payment_id           numeric(10),
	reversal_id              numeric(10),
-- 	c_cashbook_id            numeric(10),
	processedon              numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_payment_uu             uuid        DEFAULT uuid_generate_v4(),
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
	bh_visit_id              numeric(10),
	bh_tender_amount         numeric,
-- 	currencyrate             numeric,
-- 	convertedamt             numeric,
-- 	isoverridecurrencyrate   char         DEFAULT 'N'::bpchar NOT NULL,
-- 	c_banktransfer_id        numeric(10)  DEFAULT NULL::numeric,
-- 	scheduled                char         DEFAULT 'N'::bpchar NOT NULL,
	bh_original_c_invoice_id numeric
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
	tmp_c_payment (ad_client_id, ad_org_id, documentno, datetrx, c_doctype_id, trxtype, c_bankaccount_id, c_bpartner_id,
	               c_invoice_id, tendertype, c_currency_id, payamt, isapproved, r_avsaddr, r_avszip, oprocessing,
	               isreconciled, isallocated, processed, posted, isoverunderpayment, description, reversal_id,
	               bh_visit_id, bh_tender_amount, bh_original_c_invoice_id)
SELECT
	p.ad_client_id,
	p.ad_org_id,
	p.documentno || '^',
	p.datetrx,
	p.c_doctype_id,
	p.trxtype,
	p.c_bankaccount_id,
	p.c_bpartner_id,
	NULL,
	p.tendertype,
	p.c_currency_id,
	p.payamt * -1,
	p.isapproved,
	p.r_avsaddr,
	p.r_avszip,
	'N',
	p.isreconciled,
	p.isallocated,
	p.processed,
	p.posted,
	p.isoverunderpayment,
	'Auto-generated reversal | {->' || p.documentno || ')',
	p.c_payment_id,
	p.bh_visit_id,
	NULL,
	NULL
FROM
	c_payment p
		JOIN c_allocationline al
			ON p.c_payment_id = al.c_payment_id
		JOIN tmp_c_invoices_to_fix titf
			ON al.c_invoice_id = titf.c_invoice_id
WHERE
	NOT EXISTS(
		SELECT
			1
		FROM
			c_allocationline al2
		WHERE
			al2.c_allocationline_id != al.c_allocationline_id
			AND al2.c_invoice_id = al.c_invoice_id
			AND al2.c_payment_id > al.c_payment_id
	);

INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, isreceipt, c_doctype_id,
	           trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, tendertype, c_currency_id, payamt, isapproved,
	           r_avsaddr, r_avszip, processing, oprocessing, docstatus, docaction, isreconciled, isallocated, processed,
	           posted, isoverunderpayment, description, dateacct, reversal_id, processedon, c_payment_uu, bh_visit_id,
	           bh_tender_amount, bh_original_c_invoice_id)
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
	oprocessing,
	docstatus,
	docaction,
	isreconciled,
	isallocated,
	processed,
	posted,
	isoverunderpayment,
	description,
	dateacct,
	reversal_id,
	processedon,
	c_payment_uu,
	bh_visit_id,
	bh_tender_amount,
	bh_original_c_invoice_id
FROM
	tmp_c_payment;

-- Update the payments that are now reversed
UPDATE c_payment p
SET
	updated      = NOW(),
	updatedby    = 100,
	c_invoice_id = NULL,
	docstatus    = 'RE',
	docaction    = '--',
	description  = '(' || p.documentno || '^<-)',
	reversal_id  = p_r.c_payment_id
FROM
	tmp_c_payment p_r
WHERE
	p.c_payment_id = p_r.reversal_id;

-- We won't create new fact_acct records because they'll just map to the 99999 account
-- Create new allocation headers
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
	documentno_old     varchar(30),
	documentno         numeric,
	description        varchar(255),
	datetrx            timestamp                       NOT NULL,
	dateacct           timestamp   DEFAULT NOW()::date NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
-- 	approvalamt        numeric     DEFAULT 0           NOT NULL,
-- 	ismanual           char        DEFAULT 'N'::bpchar NOT NULL,
	docstatus          char(2)                         NOT NULL,
	docaction          char(2)                         NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N'::bpchar,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	reversal_id        numeric(10),
	c_doctype_id       numeric(10),
	tmp_c_payment_id   numeric(10)
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

-- Insert a reversal header for all headers that have the payments we're reversing on them
INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno_old, documentno, description, datetrx, c_currency_id,
	                     docstatus, docaction, reversal_id, c_doctype_id, tmp_c_payment_id)
SELECT
	ah.ad_client_id,
	ah.ad_org_id,
	ah.documentno || '^',
	NULL, -- We'll use the old document number (with modifications) when we insert later
	ah.description || ' | {->' || ah.documentno || ')',
	NOW()::date,
	ah.c_currency_id,
	'RE',
	'--',
	ah.c_allocationhdr_id,
	dt.c_doctype_id,
	NULL
FROM
	c_allocationhdr ah
		JOIN c_doctype dt
			ON ah.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA'
		JOIN c_allocationline al
			ON ah.c_allocationhdr_id = al.c_allocationhdr_id
		JOIN tmp_c_payment tp
			ON al.c_payment_id = tp.reversal_id;

-- Now insert the headers for every single reversal payment
INSERT INTO
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno_old, documentno, description, datetrx, c_currency_id,
	                     docstatus, docaction, reversal_id, c_doctype_id, tmp_c_payment_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	NULL,
	seq.currentnext - 1, -- We'll use the old document number (with modifications) when we insert later
	'Payment: ' || tp.documentno,
	p.datetrx,
	tp.c_currency_id,
	'CO',
	'CL',
	NULL,
	dt.c_doctype_id,
	tp.c_payment_id
FROM
	tmp_c_payment tp
		JOIN c_payment p
			ON tp.reversal_id = p.c_payment_id
		JOIN ad_sequence seq
			ON seq.ad_client_id = tp.ad_client_id AND seq.name = 'DocumentNo_C_AllocationHdr'
		JOIN c_doctype dt
			ON tp.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'CMA';

-- Update the document numbers
UPDATE tmp_c_allocationhdr i
SET
	documentno = documentno + ti.row_num
FROM
	(
		SELECT
			c_allocationhdr_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_allocationhdr_id) AS row_num
		FROM
			tmp_c_allocationhdr
		WHERE
			documentno IS NOT NULL
	) ti
WHERE
	i.c_allocationhdr_id = ti.c_allocationhdr_id;

INSERT INTO
	c_allocationhdr (c_allocationhdr_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, description, datetrx,
	                 dateacct, c_currency_id, docstatus, docaction, isapproved, processing, processed, posted,
	                 processedon, c_allocationhdr_uu, reversal_id, c_doctype_id)
SELECT
	c_allocationhdr_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	CASE WHEN documentno IS NULL THEN documentno_old ELSE documentno::varchar END,
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
	reversal_id,
	c_doctype_id
FROM
	tmp_c_allocationhdr;

-- Now update the allocation headers that were reversed
UPDATE c_allocationhdr ah
SET
	updated     = NOW(),
	updatedby   = 100,
	description = ah.description || ' | (' || ah.documentno || '^<-)',
	docstatus   = 'RE',
	docaction   = '--'
FROM
	tmp_c_allocationhdr tah
WHERE
	ah.c_allocationhdr_id = tah.reversal_id;

-- Now add the allocation lines
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TEMP TABLE tmp_c_allocationline
(
	c_allocationline_id  serial                  NOT NULL,
	ad_client_id         numeric(10)             NOT NULL,
	ad_org_id            numeric(10)             NOT NULL,
-- 	isactive            char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created             timestamp   DEFAULT NOW()       NOT NULL,
	createdby            numeric(10) DEFAULT 100 NOT NULL,
-- 	updated             timestamp   DEFAULT NOW()       NOT NULL,
	updatedby            numeric(10) DEFAULT 100 NOT NULL,
-- 	allocationno        numeric(10),
-- 	datetrx             timestamp,
-- 	ismanual            char        DEFAULT 'N'::bpchar,
	c_invoice_id         numeric(10),
	c_bpartner_id        numeric(10),
	c_order_id           numeric(10),
	c_payment_id         numeric(10),
-- 	c_cashline_id       numeric(10),
	amount               numeric                 NOT NULL,
-- 	discountamt         numeric     DEFAULT 0   NOT NULL,
-- 	writeoffamt         numeric     DEFAULT 0   NOT NULL,
-- 	overunderamt        numeric     DEFAULT 0,
	c_allocationhdr_id   numeric(10)             NOT NULL,
	c_allocationline_uu  uuid        DEFAULT uuid_generate_v4(),
-- 	c_charge_id         numeric(10) DEFAULT NULL::numeric,
-- 	c_banktransfer_id   numeric(10) DEFAULT NULL::numeric
	tmp_reversal_line_id numeric(10)
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

-- Insert reversal lines of the original first
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_order_id, c_payment_id, amount,
	                      c_allocationhdr_id, tmp_reversal_line_id)
SELECT
	tah.ad_client_id,
	tah.ad_org_id,
	al.c_invoice_id,
	al.c_bpartner_id,
	al.c_order_id,
	al.c_payment_id,
	al.amount * -1,
	tah.c_allocationhdr_id,
	al.c_allocationline_id
FROM
	tmp_c_allocationhdr tah
		JOIN c_allocationline al
			ON tah.reversal_id = al.c_allocationhdr_id AND isactive = 'Y';

-- Now insert the new lines for the newly-created reversal payments
INSERT INTO
	tmp_c_allocationline (ad_client_id, ad_org_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tah.ad_client_id,
	tah.ad_org_id,
	tp.c_bpartner_id,
	tp.reversal_id,
	tp.payamt,
	tah.c_allocationhdr_id
FROM
	tmp_c_allocationhdr tah
		JOIN tmp_c_payment tp
			ON tah.tmp_c_payment_id = tp.c_payment_id
UNION ALL
SELECT
	tah.ad_client_id,
	tah.ad_org_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	tp.payamt * -1,
	tah.c_allocationhdr_id
FROM
	tmp_c_allocationhdr tah
		JOIN tmp_c_payment tp
			ON tah.tmp_c_payment_id = tp.c_payment_id;

INSERT INTO
	c_allocationline (c_allocationline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, c_bpartner_id,
	                  c_order_id, c_payment_id, amount, c_allocationhdr_id, c_allocationline_uu)
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
	c_allocationhdr_id,
	c_allocationline_uu
FROM
	tmp_c_allocationline;

-- We won't do any fact_acct records for this, either, since they're just in the 99999 account

SELECT
	register_migration_script('202602231558_GO-3515.sql')
FROM
	dual;