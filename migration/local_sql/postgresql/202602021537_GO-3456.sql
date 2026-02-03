/**********************************************************************************************************/
-- Complete drafted payments for visits with complete orders and invoices
-- This properly completes payments, creates allocations, and updates balances
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
			SELECT SUM(al.amount)
			FROM c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			WHERE al.c_invoice_id = i.c_invoice_id
				AND ah.docstatus = 'CO'
		),
		0
	)
	-- Only include invoices with exactly one payment
	AND (
		SELECT COUNT(*)
		FROM c_payment p2
			JOIN bh_visit v2
				ON p2.bh_visit_id = v2.bh_visit_id
			JOIN c_order o2
				ON v2.bh_visit_id = o2.bh_visit_id
				AND o2.docstatus = 'CO'
				AND o2.issotrx = 'Y'
			JOIN c_invoice i2
				ON o2.c_order_id = i2.c_order_id
		WHERE i2.c_invoice_id = i.c_invoice_id
			AND p2.bh_visit_id = p.bh_visit_id
	) = 1;

-- Step 2: Complete the payments
UPDATE c_payment
SET
	docstatus = 'CO',
	docaction = 'CL',
	processed = 'Y',
	posted = 'Y',
	isallocated = 'Y',
	processing = 'N',
	processedon = EXTRACT(EPOCH FROM NOW()) * 1000,
	updated = NOW(),
	updatedby = 100
WHERE
	c_payment_id IN (SELECT c_payment_id FROM tmp_payments_to_complete);

-- Step 3: Create allocation headers
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
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus = 'CO'
			),
			0
		),
		tp.payamt - COALESCE(
			(
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_payment_id = tp.c_payment_id
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
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_invoice_id = i.c_invoice_id
					AND ah.docstatus = 'CO'
			),
			0
		),
		tp.payamt - COALESCE(
			(
				SELECT SUM(al.amount)
				FROM c_allocationline al
					JOIN c_allocationhdr ah
						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				WHERE al.c_payment_id = tp.c_payment_id
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
	ispaid = CASE
		WHEN (
			SELECT COALESCE(SUM(al.amount), 0)
			FROM c_allocationline al
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			WHERE al.c_invoice_id = c_invoice.c_invoice_id
				AND ah.docstatus = 'CO'
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

-- Step 6: Update invoice AllocatedAmt
UPDATE c_invoice
SET
	allocatedamt = (
		SELECT COALESCE(SUM(al.amount), 0)
		FROM c_allocationline al
			JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id
		WHERE al.c_invoice_id = c_invoice.c_invoice_id
			AND ah.docstatus = 'CO'
	),
	updated = NOW(),
	updatedby = 100
WHERE
	c_invoice_id IN (
		SELECT DISTINCT c_invoice_id
		FROM tmp_c_allocationline
	);

-- Step 7: Update business partner TotalOpenBalance
-- Recalculate open balance for all affected business partners
UPDATE c_bpartner bp
SET
	totalopenbalance = (
		SELECT COALESCE(SUM(
			CASE
				WHEN i.issotrx = 'Y' THEN i.grandtotal - COALESCE(i.allocatedamt, 0)
				ELSE -(i.grandtotal - COALESCE(i.allocatedamt, 0))
			END
		), 0)
		FROM c_invoice i
		WHERE i.c_bpartner_id = bp.c_bpartner_id
			AND i.docstatus = 'CO'
			AND (i.grandtotal - COALESCE(i.allocatedamt, 0)) != 0
	),
	updated = NOW(),
	updatedby = 100
WHERE
	c_bpartner_id IN (
		SELECT DISTINCT c_bpartner_id
		FROM tmp_payments_to_complete
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
	updated = NOW(),
	updatedby = 100
WHERE
	c_bpartner_id IN (
		SELECT DISTINCT c_bpartner_id
		FROM tmp_payments_to_complete
	);

/**********************************************************************************************************/
-- Wrap-up
/**********************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202602021537_GO-3456.sql')
FROM
	dual;
