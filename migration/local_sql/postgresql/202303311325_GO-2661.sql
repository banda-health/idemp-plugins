/**********************************************************************************************************/
-- This script takes care of fixing duplicate allocations of payments by doing the following things:
--  1. Get the payments we need to deal with.
--  2. Get the allocations to work with. For all allocations, we'll keep the oldest, completed allocation
--  3. For the allocations that aren't completed, just void them
--  4. For the allocations that are completed, we need to reverse accrue them
--  5. Update open balances for all BPs involved (shouldn't change anything, but just in case)
--  6. Finish up
/**********************************************************************************************************/
/**********************************************************************************************************/
-- 1. Get the payments we need to deal with
/**********************************************************************************************************/
SELECT
	ap.c_payment_id
INTO TEMP TABLE
	tmp_payment_ids_with_duplicate_full_allocations
FROM
	(
		SELECT
			c_payment_id,
			amount
		FROM
			c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		WHERE
			ah.docstatus NOT IN ('RE', 'RA', 'VO')
		GROUP BY c_payment_id, amount
		HAVING
			COUNT(*) > 1
	) AS ap
		JOIN c_payment p
			ON p.c_payment_id = ap.c_payment_id AND ap.amount = p.payamt AND payamt != 0;

/**********************************************************************************************************/
-- 2. Get the allocations to work with. For all allocations, we'll keep the oldest, completed allocation
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_allocation_headers_to_remove;
SELECT
	c_allocationhdr_id
INTO TEMP TABLE
	tmp_allocation_headers_to_remove
FROM
	c_allocationhdr
WHERE
		c_allocationhdr_id IN (
		SELECT
			c_allocationhdr_id
		FROM
			c_allocationline
		WHERE
				c_payment_id IN (
				SELECT
					c_payment_id
				FROM
					tmp_payment_ids_with_duplicate_full_allocations
			)
	)
	AND c_allocationhdr_id NOT IN (
	SELECT
		c_allocationhdr_id
	FROM
		tmp_payment_ids_with_duplicate_full_allocations tpiwdfa
			JOIN c_allocationhdr ah
				ON ah.c_allocationhdr_id = (
			SELECT
				ah.c_allocationhdr_id
			FROM
				c_allocationhdr ah
					JOIN c_allocationline al
						ON ah.c_allocationhdr_id = al.c_allocationhdr_id AND al.c_payment_id = tpiwdfa.c_payment_id
			WHERE
				ah.docstatus = 'CO'
			ORDER BY ah.created
			LIMIT 1
		)
);

-- Now separate out the allocations we're dealing with
DROP TABLE IF EXISTS tmp_allocation_headers_to_void;
DROP TABLE IF EXISTS tmp_c_allocationhdrs_to_reverse;
SELECT
	ah.c_allocationhdr_id
INTO TEMP TABLE
	tmp_allocation_headers_to_void
FROM
	c_allocationhdr ah
		JOIN tmp_allocation_headers_to_remove tahtr
			ON ah.c_allocationhdr_id = tahtr.c_allocationhdr_id
WHERE
	ah.docstatus = 'DR';
SELECT
	ah.c_allocationhdr_id
INTO TEMP TABLE
	tmp_c_allocationhdrs_to_reverse
FROM
	c_allocationhdr ah
		JOIN tmp_allocation_headers_to_remove tahtr
			ON ah.c_allocationhdr_id = tahtr.c_allocationhdr_id
WHERE
	ah.docstatus = 'CO';

/**********************************************************************************************************/
-- 3. For the allocations that aren't completed, just void them
/**********************************************************************************************************/
UPDATE c_allocationhdr ah
SET
	updated     = NOW(),
	updatedby   = 100,
	description = ah.description || ' | ** Voided',
	docstatus   = 'VO',
	docaction   = '--',
	processedon = EXTRACT(EPOCH FROM NOW()) * 1000
FROM
	tmp_allocation_headers_to_void tahtv
WHERE
	tahtv.c_allocationhdr_id = ah.c_allocationhdr_id;

UPDATE c_allocationline al
SET
	updated   = NOW(),
	updatedby = 100,
	amount    = 0
FROM
	tmp_allocation_headers_to_void tahtv
WHERE
	al.c_allocationhdr_id = tahtv.c_allocationhdr_id;

/**********************************************************************************************************/
-- 4. For the allocations that are completed, we need to reverse accrue them
/**********************************************************************************************************/
-- Create the reversal Allocation Headers
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
	documentno         varchar(30)                     NOT NULL,
	description        varchar(255),
	datetrx            timestamp   DEFAULT date(NOW()) NOT NULL,
	dateacct           timestamp   DEFAULT date(NOW()) NOT NULL,
	c_currency_id      numeric(10)                     NOT NULL,
-- 	approvalamt        numeric     DEFAULT 0           NOT NULL,
-- 	ismanual           char        DEFAULT 'N'::bpchar NOT NULL,
	docstatus          char(2)     DEFAULT 'RE'        NOT NULL,
	docaction          char(2)     DEFAULT '--'        NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()),
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	reversal_id        numeric(10) DEFAULT NULL::numeric,
	c_doctype_id       numeric(10) DEFAULT NULL::numeric
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
	tmp_c_allocationhdr (ad_client_id, ad_org_id, documentno, description, c_currency_id, reversal_id, c_doctype_id)
SELECT
	ad_client_id,
	ad_org_id,
	documentno || '^',
	description || ' | {->' || documentno || '}',
	c_currency_id,
	c_allocationhdr_id,
	c_doctype_id
FROM
	c_allocationhdr
WHERE
		c_allocationhdr_id IN (
		SELECT
			c_allocationhdr_id
		FROM
			tmp_c_allocationhdrs_to_reverse
	);

INSERT INTO
	c_allocationhdr (c_allocationhdr_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, description, datetrx,
	                 dateacct, c_currency_id, docstatus, docaction, processing, processedon, c_allocationhdr_uu,
	                 reversal_id, c_doctype_id)
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
	processing,
	processedon,
	c_allocationhdr_uu,
	reversal_id,
	c_doctype_id
FROM
	tmp_c_allocationhdr;

-- Set the allocation's document status & action, description, plus updated/updatedby, then approvalamt to 0
UPDATE c_allocationhdr
SET
	docstatus   = 'RE',
	docaction   = '--',
	description = description || ' | (' || documentno || '^<-)',
	updated     = NOW(),
	updatedby   = 100,
	approvalamt = 0
WHERE
		c_allocationhdr_id IN (
		SELECT
			c_allocationhdr_id
		FROM
			tmp_c_allocationhdrs_to_reverse
	);

-- Create the reversal Allocation Lines
DROP TABLE IF EXISTS tmp_c_allocationline;
CREATE TABLE tmp_c_allocationline
(
	c_allocationline_id serial                  NOT NULL,
	ad_client_id        numeric(10)             NOT NULL,
	ad_org_id           numeric(10)             NOT NULL,
-- 	isactive            char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created             timestamp   DEFAULT NOW()       NOT NULL,
	createdby           numeric(10) DEFAULT 100 NOT NULL,
-- 	updated             timestamp   DEFAULT NOW() NOT NULL,
	updatedby           numeric(10) DEFAULT 100 NOT NULL,
	allocationno        numeric(10),
	datetrx             timestamp   DEFAULT date(NOW()),
-- 	ismanual            char        DEFAULT 'N'::bpchar,
	c_invoice_id        numeric(10),
	c_bpartner_id       numeric(10),
	c_order_id          numeric(10),
	c_payment_id        numeric(10),
	c_cashline_id       numeric(10),
	amount              numeric     DEFAULT 0   NOT NULL,
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
	tmp_c_allocationline (ad_client_id, ad_org_id, allocationno, datetrx, c_invoice_id, c_bpartner_id, c_order_id,
	                      c_payment_id,
	                      c_cashline_id, amount, c_allocationhdr_id)
SELECT
	al.ad_client_id,
	al.ad_org_id,
	al.allocationno,
	al.datetrx,
	al.c_invoice_id,
	al.c_bpartner_id,
	al.c_order_id,
	al.c_payment_id,
	al.c_cashline_id,
	al.amount * -1,
	tah.c_allocationhdr_id
FROM
	tmp_c_allocationhdr tah
		JOIN c_allocationhdr rah
			ON tah.reversal_id = rah.c_allocationhdr_id
		JOIN c_allocationline al
			ON rah.c_allocationhdr_id = al.c_allocationhdr_id;

INSERT INTO
	c_allocationline (c_allocationline_id, ad_client_id, ad_org_id, createdby, updatedby, allocationno, datetrx,
	                  c_invoice_id, c_bpartner_id, c_order_id, c_payment_id, c_cashline_id, amount, c_allocationhdr_id,
	                  c_allocationline_uu)
SELECT
	c_allocationline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	allocationno,
	datetrx,
	c_invoice_id,
	c_bpartner_id,
	c_order_id,
	c_payment_id,
	c_cashline_id,
	amount,
	c_allocationhdr_id,
	c_allocationline_uu
FROM
	tmp_c_allocationline;

-- Create the reversal Allocation postings
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
	tah.ad_client_id,
	tah.ad_org_id,
	c_acctschema_id,
	ev.c_elementvalue_id,
	per.c_period_id,
	tah.c_allocationhdr_id,
	tal.c_allocationline_id,
	gl_category_id,
	tah.c_currency_id,
	CASE WHEN ev.value = '99999' THEN tal.amount ELSE 0 END,
	CASE WHEN ev.value = '99999' THEN 0 ELSE tal.amount END,
	CASE WHEN ev.value = '99999' THEN tal.amount ELSE 0 END,
	CASE WHEN ev.value = '99999' THEN 0 ELSE tal.amount END,
	c_bpartner_id,
	tah.documentno || ' #0 ' || tah.description
FROM
	tmp_c_allocationline tal
		JOIN tmp_c_allocationhdr tah
			ON tal.c_allocationhdr_id = tah.c_allocationhdr_id
		JOIN c_acctschema accts
			ON tah.ad_client_id = accts.ad_client_id
		JOIN (
		SELECT
			c.ad_client_id,
			COALESCE(ev1.c_elementvalue_id, ev2.c_elementvalue_id, ev3.c_elementvalue_id) AS c_elementvalue_id,
			'99999'                                                                       AS value
		FROM
			ad_client c
				LEFT JOIN c_elementvalue ev1
					ON c.ad_client_id = ev1.ad_client_id AND ev1.value = '99999'
				LEFT JOIN c_elementvalue ev2
					ON c.ad_client_id = ev2.ad_client_id AND ev2.value = '121'
				LEFT JOIN c_elementvalue ev3
					ON c.ad_client_id = ev3.ad_client_id AND ev3.value = 'P_LANDEDCOSTCLEARING'
		UNION
		SELECT
			c.ad_client_id,
			COALESCE(ev2.c_elementvalue_id, ev1.c_elementvalue_id, ev3.c_elementvalue_id) AS c_elementvalue_id,
			'12110'                                                                       AS value
		FROM
			ad_client c
				LEFT JOIN c_elementvalue ev1
					ON c.ad_client_id = ev1.ad_client_id AND ev1.value = '99999'
				LEFT JOIN c_elementvalue ev2
					ON c.ad_client_id = ev2.ad_client_id AND ev2.value = '12110'
				LEFT JOIN c_elementvalue ev3
					ON c.ad_client_id = ev3.ad_client_id AND ev3.value = 'C_RECEIVABLE'
	) ev
			ON tah.ad_client_id = ev.ad_client_id
		JOIN c_period per
			ON tah.ad_client_id = per.ad_client_id AND NOW() BETWEEN startdate AND enddate
		JOIN gl_category glc
			ON glc.ad_client_id = tah.ad_client_id AND glc.name = 'Cash/Payments';

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
-- 5. Update open balances for all BPs involved (shouldn't change anything, but just in case)
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
				JOIN c_payment p
					ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN tmp_payment_ids_with_duplicate_full_allocations tpiwdfa
					ON tpiwdfa.c_payment_id = p.c_payment_id
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

/**********************************************************************************************************/
-- 6. Finish up
/**********************************************************************************************************/
UPDATE m_storageonhand
SET
	datematerialpolicy = '2020-01-01'
WHERE
	m_attributesetinstance_id = 0
  AND qtyonhand != 0;

SELECT
	register_migration_script('202303311325_GO-2661.sql')
FROM
	dual;
