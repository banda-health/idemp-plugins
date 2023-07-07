/**********************************************************************************************************/
-- To clean up open balances, we need to create payments. Ideally these would also be allocated, but they
-- don't have to be. Given the wide range of possibilities of errors that led to these open balances,
-- we'll not worry about it at this point. Here's what we'll do:
-- 1. Get BPs to work with
-- 2. Create processed payments for those BPs
-- 3. Handle the payment postings
-- 4. Recalculate open balances
-- 5. Wrap up
/**********************************************************************************************************/

/**********************************************************************************************************/
-- 1. Get BPs to work with
/**********************************************************************************************************/-- Get the BPs that need open balance clearing
DROP TABLE IF EXISTS tmp_bps_to_update;
SELECT
	ad_client_id,
	c_bpartner_id,
	totalopenbalance
INTO TEMP TABLE
	tmp_bps_to_update
FROM
	c_bpartner
WHERE
	totalopenbalance != 0
	AND ad_client_id = (
		SELECT ad_client_id FROM ad_client WHERE ad_client_uu = '8f5dd4ad-de55-4edf-86c2-1cbce4ff6512'
	);

/**********************************************************************************************************/
-- 2. Create processed payments for those BPs
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_payment;
CREATE TEMP TABLE tmp_c_payment
(
	c_payment_id       serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10)                     NOT NULL,
--   isactive           char        DEFAULT 'Y'::bpchar NOT NULL,
--   created            timestamp   DEFAULT NOW()       NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
--   updated            timestamp   DEFAULT NOW()       NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	documentno         serial                          NOT NULL,
	datetrx            timestamp   DEFAULT date(NOW()) NOT NULL,
--   isreceipt           char      DEFAULT 'Y'::bpchar NOT NULL,
	c_doctype_id       numeric(10)                     NOT NULL,
	trxtype            char        DEFAULT 'S'         NOT NULL,
	c_bankaccount_id   numeric(10),
	c_bpartner_id      numeric(10),
--   c_invoice_id        numeric(10),
--   c_bp_bankaccount_id numeric(10),
--   c_paymentbatch_id   numeric(10),
	tendertype         char        DEFAULT 'X'         NOT NULL,
--   creditcardtype      char,
--   creditcardnumber    varchar(20),
--   creditcardvv        varchar(4),
--   creditcardexpmm     numeric(10),
--   creditcardexpyy     numeric(10),
--   micr                varchar(20),
--   routingno           varchar(20),
--   accountno           varchar(20),
--   checkno             varchar(20),
--   a_name              varchar(60),
--   a_street            varchar(60),
--   a_city              varchar(60),
--   a_state             varchar(40),
--   a_zip               varchar(20),
--   a_ident_dl          varchar(20),
--   a_ident_ssn         varchar(20),
--   a_email             varchar(60),
--   voiceauthcode       varchar(20),
--   orig_trxid          varchar(20),
--   ponum               varchar(60),
	c_currency_id      numeric(10) DEFAULT 212         NOT NULL,
	payamt             numeric                         NOT NULL,
--   discountamt         numeric   DEFAULT 0,
--   writeoffamt         numeric   DEFAULT 0,
--   taxamt              numeric   DEFAULT 0,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
--   r_pnref             varchar(20),
--   r_result            varchar(20),
--   r_respmsg           varchar(60),
--   r_authcode          varchar(20),
	r_avsaddr          char        DEFAULT 'X',
	r_avszip           char        DEFAULT 'X',
--   r_info              varchar(2000),
	processing         char        DEFAULT 'N',
--   oprocessing         char,
	docstatus          char(2)     DEFAULT 'CO'        NOT NULL,
	docaction          char(2)     DEFAULT 'CL'        NOT NULL,
	isreconciled       char        DEFAULT 'N'::bpchar NOT NULL,
	isallocated        char        DEFAULT 'N'::bpchar NOT NULL,
--   isonline            char      DEFAULT 'N'::bpchar NOT NULL,
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	isoverunderpayment char        DEFAULT 'N'::bpchar NOT NULL,
--   overunderamt        numeric   DEFAULT 0,
--   a_country           varchar(40),
--   c_project_id        numeric(10),
--   isselfservice       char      DEFAULT 'N'::bpchar NOT NULL,
--   chargeamt           numeric   DEFAULT 0,
--   c_charge_id         numeric(10),
--   isdelayedcapture    char      DEFAULT 'N'::bpchar NOT NULL,
--   r_authcode_dc       varchar(20),
--   r_cvv2match         char,
--   r_pnref_dc          varchar(20),
--   swipe               varchar(80),
--   ad_orgtrx_id        numeric(10),
--   c_campaign_id       numeric(10),
--   c_activity_id       numeric(10),
--   user1_id            numeric(10),
--   user2_id            numeric(10),
--   c_conversiontype_id numeric(10),
--   description         varchar(255),
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
--   c_order_id          numeric(10),
--   isprepayment        char      DEFAULT 'N'::bpchar NOT NULL,
--   ref_payment_id      numeric(10),
--   reversal_id         numeric(10),
--   c_cashbook_id       numeric(10),
	processedon        numeric     DEFAULT EXTRACT('epoch' FROM NOW()) * 1000,
	c_payment_uu       uuid        DEFAULT uuid_generate_v4(),
--   c_postendertype_id       numeric(10)  DEFAULT NULL::numeric,
--   c_paymentprocessor_id    numeric(10)  DEFAULT NULL::numeric,
--   customerpaymentprofileid varchar(60)  DEFAULT NULL::character varying,
--   customerprofileid        varchar(60)  DEFAULT NULL::character varying,
--   customeraddressid        varchar(60)  DEFAULT NULL::character varying,
--   isvoided                 char         DEFAULT 'N'::bpchar NOT NULL,
--   r_voidmsg                varchar(255) DEFAULT NULL::character varying,
--   c_depositbatch_id        numeric(10)  DEFAULT NULL::numeric,
--   iban                     varchar(40)  DEFAULT NULL::character varying,
--   swiftcode                varchar(20)  DEFAULT NULL::character varying,
-- 	bh_visit_id        numeric(10),
--   bh_mpesaphntrx_num       varchar(36)  DEFAULT NULL::character varying,
--   bh_navbuttons            varchar(36)  DEFAULT NULL::character varying,
--   bh_nhif_valid            char         DEFAULT NULL::bpchar,
--   bh_nhif_claim_number     varchar(100) DEFAULT NULL::character varying,
--   nhif_number              varchar(10)  DEFAULT NULL::character varying,
--   bh_nhif_member_id        varchar(10)  DEFAULT NULL::character varying,
--   bh_nhif_member_name      varchar(100) DEFAULT NULL::character varying,
--   bh_nhif_relationship     varchar(100) DEFAULT 'P'::character varying,
--   bh_nhif_linda_mama       varchar(100) DEFAULT NULL::character varying,
--   bh_processing            char         DEFAULT 'N'::bpchar,
--   bh_nhif_type             varchar(100) DEFAULT NULL::character varying,
	bh_tender_amount   numeric
--   bh_isservicedebt         char         DEFAULT NULL::bpchar
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

SELECT
	SETVAL(
		'tmp_c_payment_documentno_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'DocumentNo_C_Payment'
				AND ad_client_id = (
					SELECT ad_client_id FROM ad_client WHERE ad_client_uu = '8f5dd4ad-de55-4edf-86c2-1cbce4ff6512'
				)
			LIMIT 1
		)::INT,
		FALSE
		);

INSERT INTO
	tmp_c_payment (ad_client_id, ad_org_id, c_doctype_id, c_bankaccount_id, c_bpartner_id, payamt, bh_tender_amount)
SELECT
	c.ad_client_id,
	o.ad_org_id,
	dt.c_doctype_id,
	ba.c_bankaccount_id,
	tbptu.c_bpartner_id,
	tbptu.totalopenbalance,
	tbptu.totalopenbalance
FROM
	tmp_bps_to_update tbptu
		JOIN ad_client c
		ON tbptu.ad_client_id = c.ad_client_id
		JOIN ad_org o
		ON c.ad_client_id = o.ad_client_id
		JOIN c_doctype dt
		ON tbptu.ad_client_id = dt.ad_client_id AND dt.docbasetype = 'ARR'
		JOIN c_bankaccount ba
		ON tbptu.ad_client_id = ba.ad_client_id AND ba.isdefault = 'Y';

INSERT INTO
	c_payment (c_payment_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, datetrx, c_doctype_id, trxtype,
	           c_bankaccount_id, c_bpartner_id, tendertype, c_currency_id, payamt, isapproved, r_avsaddr, r_avszip,
	           processing, docstatus, docaction, isreconciled, isallocated, processed, posted, isoverunderpayment,
	           dateacct, processedon, c_payment_uu, bh_tender_amount)
SELECT
	c_payment_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno::varchar,
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
	isreconciled,
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
-- 3. Handle the payment postings
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_fact_acct;
CREATE TABLE tmp_fact_acct
(
	fact_acct_id    serial                          NOT NULL,
	ad_client_id    numeric(10)                     NOT NULL,
	ad_org_id       numeric(10)                     NOT NULL,
-- 	isactive          char      DEFAULT 'Y'::bpchar NOT NULL,
-- 	created           timestamp DEFAULT NOW()       NOT NULL,
	createdby       numeric(10) DEFAULT 100         NOT NULL,
-- 	updated           timestamp DEFAULT NOW()       NOT NULL,
	updatedby       numeric(10) DEFAULT 100         NOT NULL,
	c_acctschema_id numeric(10)                     NOT NULL,
	account_id      numeric(10)                     NOT NULL,
	datetrx         timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct        timestamp   DEFAULT date(NOW()) NOT NULL,
	c_period_id     numeric(10),
	ad_table_id     numeric(10) DEFAULT 735         NOT NULL,
	record_id       numeric(10)                     NOT NULL,
	line_id         numeric(10),
	gl_category_id  numeric(10),
-- 	gl_budget_id      numeric(10),
-- 	c_tax_id          numeric(10),
-- 	m_locator_id      numeric(10),
	postingtype     char        DEFAULT 'A'         NOT NULL,
	c_currency_id   numeric(10)                     NOT NULL,
	amtsourcedr     numeric                         NOT NULL,
	amtsourcecr     numeric                         NOT NULL,
	amtacctdr       numeric                         NOT NULL,
	amtacctcr       numeric                         NOT NULL,
-- 	c_uom_id          numeric(10),
	qty             numeric     DEFAULT 0,
-- 	m_product_id      numeric(10),
	c_bpartner_id   numeric(10),
-- 	ad_orgtrx_id      numeric(10),
-- 	c_locfrom_id      numeric(10),
-- 	c_locto_id        numeric(10),
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
	               c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, c_bpartner_id, description)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	c_acctschema_id,
	ev.c_elementvalue_id,
	per.c_period_id,
	tp.c_payment_id,
	NULL,
	gl_category_id,
	tp.c_currency_id,
	CASE WHEN ev.value = '99999' THEN tp.payamt ELSE 0 END,
	CASE WHEN ev.value = '99999' THEN 0 ELSE tp.payamt END,
	CASE WHEN ev.value = '99999' THEN tp.payamt ELSE 0 END,
	CASE WHEN ev.value = '99999' THEN 0 ELSE tp.payamt END,
	c_bpartner_id,
	tp.documentno
FROM
	tmp_c_payment tp
		JOIN c_acctschema accts
		ON tp.ad_client_id = accts.ad_client_id
		JOIN (
		SELECT
			c.ad_client_id,
			ev.c_elementvalue_id,
			'99999' AS value
		FROM
			ad_client c
				JOIN c_elementvalue ev
				ON c.ad_client_id = ev.ad_client_id AND ev.value = '99999'
		UNION
		SELECT
			c.ad_client_id,
			ev.c_elementvalue_id,
			'11100' AS value
		FROM
			ad_client c
				JOIN c_elementvalue ev
				ON c.ad_client_id = ev.ad_client_id AND ev.value = '11100'
	) ev
		ON tp.ad_client_id = ev.ad_client_id
		JOIN c_period per
		ON tp.ad_client_id = per.ad_client_id AND NOW() BETWEEN startdate AND enddate
		JOIN gl_category glc
		ON glc.ad_client_id = tp.ad_client_id AND glc.name = 'AR Receipt';

INSERT INTO
	fact_acct (fact_acct_id, ad_client_id, ad_org_id, createdby, updatedby, c_acctschema_id, account_id, datetrx,
	           dateacct, c_period_id, ad_table_id, record_id, line_id, gl_category_id, postingtype, c_currency_id,
	           c_bpartner_id, description)
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
	postingtype,
	c_currency_id,
	c_bpartner_id,
	description
FROM
	tmp_fact_acct;

/**********************************************************************************************************/
-- 4. Recalculate open balances
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
			bp.c_bpartner_id
		FROM
			C_BPartner bp
				JOIN tmp_bps_to_update tbptu
				ON tbptu.c_bpartner_id = bp.c_bpartner_id
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************/
-- 5. Wrap up
/**********************************************************************************************************/
-- Update sequences
SELECT
	update_sequences();

UPDATE ad_sequence s
SET
	currentnext = tp.documentno + 1
FROM
	(
		SELECT
			MAX(documentno) AS documentno
		FROM
			tmp_c_payment
	) tp
WHERE
	s.name = 'DocumentNo_C_Payment'
	AND s.ad_client_id = (
		SELECT ad_client_id FROM ad_client WHERE ad_client_uu = '8f5dd4ad-de55-4edf-86c2-1cbce4ff6512'
	);

SELECT
	register_migration_script('202306061007_GO-2739.sql')
FROM
	dual;
