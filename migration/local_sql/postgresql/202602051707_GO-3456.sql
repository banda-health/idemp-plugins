/**********************************************************************************************************/
-- Create waived payments for OTC Patient visits with payment shortfalls
-- This script assumes existing payments are already allocated - we only create new waived payments for shortfalls
/**********************************************************************************************************/

-- Step 1: Identify visits with invoices that have remaining unpaid balances
DROP TABLE IF EXISTS tmp_visits_with_shortfalls;
CREATE TEMP TABLE tmp_visits_with_shortfalls AS
SELECT
	v.bh_visit_id,
	v.ad_client_id,
	v.ad_org_id,
	v.patient_id as c_bpartner_id,
	v.dateacct,
	ROUND(SUM(i.grandtotal), 2) as total_invoiced,
	ROUND(SUM(p.payamt), 2) as total_paid,
	-- Calculate actual unallocated amount on invoices
	ROUND(SUM(
		i.grandtotal - COALESCE(
			(
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus IN ('CO', 'CL')
			),
			0
		)
	), 2) as actual_shortfall,
	MAX(i.c_currency_id) as c_currency_id,
	MAX(i.c_invoice_id) as c_invoice_id
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
	v.dateacct
HAVING
	-- Only include visits where invoices have remaining balance
	ROUND(SUM(
		i.grandtotal - COALESCE(
			(
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_invoice_id = i.c_invoice_id
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
	               c_bpartner_id, c_invoice_id, c_currency_id, payamt, description)
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
	'Waived payment for invoice shortfall'
FROM
	tmp_visits_with_shortfalls tvs
		JOIN bh_visit v
			ON tvs.bh_visit_id = v.bh_visit_id
		JOIN c_doctype dt
			ON tvs.ad_client_id = dt.ad_client_id
			AND dt.docbasetype = 'ARR'
			AND dt.name = 'Customer Payment Waived'
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
	c_allocationhdr_id serial                  NOT NULL,
	ad_client_id       numeric(10)             NOT NULL,
	ad_org_id          numeric(10)             NOT NULL,
	createdby          numeric(10) DEFAULT 100 NOT NULL,
	updatedby          numeric(10) DEFAULT 100 NOT NULL,
	documentno         numeric                 NOT NULL,
	description        varchar(255),
	datetrx            timestamp               NOT NULL,
	dateacct           timestamp               NOT NULL,
	c_currency_id      numeric(10)             NOT NULL,
	docstatus          char(2)     DEFAULT 'CO' NOT NULL,
	docaction          char(2)     DEFAULT 'CL' NOT NULL,
	isapproved         char        DEFAULT 'Y'::bpchar NOT NULL,
	processing         char        DEFAULT 'N',
	processed          char        DEFAULT 'Y'::bpchar NOT NULL,
	posted             char        DEFAULT 'Y'::bpchar NOT NULL,
	processedon        numeric     DEFAULT EXTRACT(EPOCH FROM NOW()) * 1000,
	c_allocationhdr_uu uuid        DEFAULT uuid_generate_v4(),
	c_doctype_id       numeric(10)             NOT NULL,
	tmp_c_payment_id   numeric(10)             NOT NULL
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
	tmp_c_allocationline (ad_client_id, ad_org_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, c_allocationhdr_id)
SELECT
	tp.ad_client_id,
	tp.ad_org_id,
	i.c_invoice_id,
	tp.c_bpartner_id,
	tp.c_payment_id,
	-- Calculate remaining unallocated amount for this invoice
	LEAST(
		i.grandtotal - COALESCE(
			(
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus IN ('CO', 'CL')
			),
			0
		) - COALESCE(
			(
				-- Also subtract what we've already allocated in this migration
				SELECT SUM(tal.amount)
				FROM tmp_c_allocationline tal
				WHERE tal.c_invoice_id = i.c_invoice_id
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
	-- Only allocate if there's remaining balance
	i.grandtotal - COALESCE(
		(
			SELECT SUM(al.amount)
			FROM c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			WHERE al.c_invoice_id = i.c_invoice_id
				AND ah.docstatus IN ('CO', 'CL')
		),
		0
	) - COALESCE(
		(
			SELECT SUM(tal.amount)
			FROM tmp_c_allocationline tal
			WHERE tal.c_invoice_id = i.c_invoice_id
		),
		0
	) > 0;

-- Insert allocation lines
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

-- Step 5: Update payment IsAllocated status for new payments only
UPDATE c_payment
SET
	isallocated = CASE
		WHEN (
			SELECT COALESCE(SUM(al.amount), 0)
			FROM c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			WHERE al.c_payment_id = c_payment.c_payment_id
				AND ah.docstatus IN ('CO', 'CL')
		) >= payamt THEN 'Y'
		ELSE 'N'
	END,
	updated = NOW(),
	updatedby = 100
WHERE
	c_payment_id IN (
		SELECT DISTINCT c_payment_id
		FROM tmp_c_payment
	);

-- Step 6: Update invoice IsPaid status
UPDATE c_invoice
SET
	ispaid = CASE
		WHEN (
			SELECT COALESCE(SUM(al.amount), 0)
			FROM c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			WHERE al.c_invoice_id = c_invoice.c_invoice_id
				AND ah.docstatus IN ('CO', 'CL')
		) >= grandtotal THEN 'Y'
		ELSE 'N'
	END,
	updated = NOW(),
	updatedby = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT c_invoice_id
		FROM tmp_c_allocationline
	);

-- Step 7: Update AllocatedAmt on invoices
UPDATE c_invoice
SET
	allocatedamt = (
		SELECT COALESCE(SUM(al.amount), 0)
		FROM c_allocationline al
			JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		WHERE al.c_invoice_id = c_invoice.c_invoice_id
			AND ah.docstatus IN ('CO', 'CL')
	),
	updated = NOW(),
	updatedby = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT c_invoice_id
		FROM tmp_c_allocationline
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
		SELECT DISTINCT ad_client_id
		FROM tmp_c_payment
	);

UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_allocationhdr WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'Allocation'
	AND ad_client_id IN (
		SELECT DISTINCT ad_client_id
		FROM tmp_c_allocationhdr
	);

-- Step 9: Summary report showing what was allocated
SELECT
	v.bh_visit_id,
	v.bh_visitdate,
	bp.name as patient_name,
	tvs.total_invoiced,
	tvs.total_paid as original_payment,
	tvs.actual_shortfall as shortfall_before,
	COALESCE(tp.payamt, 0) as waived_payment_created,
	COALESCE(SUM(tal.amount), 0) as total_allocated,
	tvs.total_invoiced - (
		SELECT COALESCE(SUM(al.amount), 0)
		FROM c_allocationline al
			JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			JOIN c_invoice i
				ON al.c_invoice_id = i.c_invoice_id
		WHERE i.bh_visit_id = tvs.bh_visit_id
			AND ah.docstatus IN ('CO', 'CL')
	) as remaining_balance_after,
	cl.name as client_name,
	v.documentno as visit_documentno
FROM
	tmp_visits_with_shortfalls tvs
		JOIN bh_visit v
			ON tvs.bh_visit_id = v.bh_visit_id
		JOIN c_bpartner bp
			ON tvs.c_bpartner_id = bp.c_bpartner_id
		JOIN ad_client cl
			ON tvs.ad_client_id = cl.ad_client_id
		LEFT JOIN tmp_c_payment tp
			ON tvs.bh_visit_id = tp.bh_visit_id
		LEFT JOIN tmp_c_allocationline tal
			ON tal.c_payment_id = tp.c_payment_id
GROUP BY
	v.bh_visit_id,
	v.bh_visitdate,
	bp.name,
	tvs.total_invoiced,
	tvs.total_paid,
	tvs.actual_shortfall,
	tp.payamt,
	cl.name,
	v.documentno
ORDER BY
	v.created DESC;