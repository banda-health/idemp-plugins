-- Update payment rules of business partners to be credit
UPDATE c_bpartner
SET
	paymentrule    = 'P', -- on credit
	socreditstatus = 'X'  -- no credit check
WHERE
	ad_client_id > 999999;

-- Get the current orders that are in an error state
DROP TABLE IF EXISTS tmp_errored_order_ids;
SELECT
	c_order_id
INTO TEMP TABLE
	tmp_errored_order_ids
FROM
	c_order
WHERE
		c_order_id IN (
		SELECT
			o.c_order_id
		FROM
			c_order o
				LEFT JOIN c_invoice i
					ON o.c_order_id = i.c_order_id AND i.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
				LEFT JOIN c_allocationline al
					ON i.c_invoice_id = al.c_invoice_id
				LEFT JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id
				LEFT JOIN c_payment p
					ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id) AND
					   p.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
		WHERE
					o.issotrx = 'Y'
				AND (ah.docstatus IS NULL OR ah.docstatus NOT IN ('RA', 'RC'))
				AND (
							(
										o.docstatus IN ('CO', 'CL') AND (
											i.docstatus NOT IN ('CO', 'CL') OR
											(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL'))
									)
								)
							OR (o.docstatus NOT IN ('CO', 'VO', 'CL', 'IN') AND (p.bh_processing = 'Y' OR p.docstatus = 'CO'))
							OR (o.docstatus = 'CO' AND i.docstatus = 'CO' AND o.grandtotal != i.grandtotal))
			OR o.c_order_id IN (
			SELECT
				c_order_id
			FROM
				c_invoice
			WHERE
				docstatus = 'CO'
				AND isactive = 'Y'
			GROUP BY c_order_id
			HAVING
				COUNT(*) > 1
		)
	);

-- Make sure the errored orders now have the correct payment rule
UPDATE c_order o
SET
	paymentrule = 'P' -- on credit
FROM
	tmp_errored_order_ids eoi
WHERE
	o.c_order_id = eoi.c_order_id;

-- Update all orders that aren't completed, closed, or voided to have the correct payment rule
UPDATE c_order
SET
	paymentrule = 'P' -- on credit
WHERE
	docstatus NOT IN ('CO', 'VO', 'CL');

-- We need to remove old orders in an error state that have no lines, but somehow were meant to be completed
DROP TABLE IF EXISTS tmp_orders_with_no_lines;
SELECT
	c_order_id
INTO TEMP TABLE
	tmp_orders_with_no_lines
FROM
	tmp_errored_order_ids
WHERE
		c_order_id NOT IN (
		SELECT
			ol.c_order_id
		FROM
			c_orderline ol
				JOIN tmp_errored_order_ids eoi
					ON eoi.c_order_id = ol.c_order_id
	);

-- Delete these bad orders
DELETE
FROM
	c_order
WHERE
		c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_orders_with_no_lines
	);

-- Delete any payments associated with the bad orders (they would never be completed by the current process)
DELETE
FROM
	c_payment
WHERE
		bh_c_order_id IN (
		SELECT
			c_order_id
		FROM
			tmp_orders_with_no_lines
	);

-- Update payments on bad orders with wrong transaction dates to have the correct transaction date
UPDATE c_payment p
SET
	dateacct = i.dateacct
FROM
	c_invoice i
WHERE
	i.c_order_id = p.bh_c_order_id
	AND i.dateacct > p.dateacct
	AND bh_c_order_id IN (
	SELECT
		o.c_order_id
	FROM
		c_order o
			LEFT JOIN c_invoice i
				ON o.c_order_id = i.c_order_id AND i.docstatus != 'RE'
			LEFT JOIN c_allocationline al
				ON i.c_invoice_id = al.c_invoice_id
			LEFT JOIN c_payment p
				ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id) AND p.docstatus != 'RE'
	WHERE
		o.issotrx = 'Y'
		AND (
			(
						o.docstatus IN ('CO', 'CL') AND (
							i.docstatus NOT IN ('CO', 'CL') OR
							(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL'))
					)
				)
			OR (o.docstatus NOT IN ('CO', 'VO', 'CL', 'IN') AND (p.bh_processing = 'Y' OR p.docstatus = 'CO')))
);

-- Update any invoices with no lines, but are linked to completed orders and are an allocation line
DROP TABLE IF EXISTS tmp_bad_invoice_ids;

SELECT
	i.c_invoice_id
INTO TEMP TABLE
	tmp_bad_invoice_ids
FROM
	c_invoice i
		JOIN c_order o
			ON i.c_order_id = o.c_order_id
		LEFT JOIN c_invoiceline il
			ON i.c_invoice_id = il.c_invoice_id
		JOIN c_allocationline al
			ON i.c_invoice_id = al.c_invoice_id
WHERE
	o.docstatus = 'CO'
	AND i.docstatus NOT IN ('CO', 'VO', 'CL', 'IN')
	AND il.c_invoice_id IS NULL;

UPDATE c_invoice i
SET
	issotrx     = o.issotrx,
	paymentrule = o.paymentrule,
	grandtotal  = o.grandtotal
FROM
	c_order o
WHERE
	o.c_order_id = i.c_order_id
	AND i.c_invoice_id IN (
	SELECT
		c_invoice_id
	FROM
		tmp_bad_invoice_ids
);

DROP TABLE IF EXISTS tmp_c_invoiceline;
CREATE TEMP TABLE tmp_c_invoiceline
(
	c_invoiceline_id          serial                          NOT NULL,
	ad_client_id              numeric(10)                     NOT NULL,
	ad_org_id                 numeric(10)                     NOT NULL,
	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby                 numeric(10)                     NOT NULL,
	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                 numeric(10)                     NOT NULL,
	c_invoice_id              numeric(10)                     NOT NULL,
	c_orderline_id            numeric(10),
	m_inoutline_id            numeric(10),
	line                      numeric(10)                     NOT NULL,
	description               varchar(255),
	m_product_id              numeric(10),
	qtyinvoiced               numeric     DEFAULT 0           NOT NULL,
	pricelist                 numeric     DEFAULT 0           NOT NULL,
	priceactual               numeric     DEFAULT 0           NOT NULL,
	pricelimit                numeric     DEFAULT 0           NOT NULL,
	linenetamt                numeric     DEFAULT 0           NOT NULL,
	c_charge_id               numeric(10),
	c_uom_id                  numeric(10),
	c_tax_id                  numeric(10),
	s_resourceassignment_id   numeric(10),
	a_asset_id                numeric(10),
	taxamt                    numeric     DEFAULT 0,
	m_attributesetinstance_id numeric(10) DEFAULT 0,
	isdescription             char        DEFAULT 'N'::bpchar NOT NULL,
	isprinted                 char        DEFAULT 'Y'::bpchar NOT NULL,
	linetotalamt              numeric     DEFAULT 0,
	ref_invoiceline_id        numeric(10),
	processed                 char        DEFAULT 'N'::bpchar NOT NULL,
	qtyentered                numeric                         NOT NULL,
	priceentered              numeric                         NOT NULL,
	c_project_id              numeric(10),
	c_projectphase_id         numeric(10),
	c_projecttask_id          numeric(10),
	rrstartdate               timestamp,
	rramt                     numeric,
	c_campaign_id             numeric(10),
	c_activity_id             numeric(10),
	user1_id                  numeric(10),
	user2_id                  numeric(10),
	ad_orgtrx_id              numeric(10),
	m_rmaline_id              numeric(10),
	a_createasset             char        DEFAULT 'N'::bpchar,
	a_processed               char        DEFAULT 'N'::bpchar,
	a_capvsexp                varchar(3),
	a_asset_group_id          numeric(10),
	c_invoiceline_uu          uuid        DEFAULT uuid_generate_v4(),
	isfixedassetinvoice       char,
	c_1099box_id              numeric(10) DEFAULT NULL::numeric
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
	tmp_c_invoiceline (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_invoice_id,
	                   m_inoutline_id, line, description, m_product_id, qtyinvoiced, pricelist,
	                   priceactual, pricelimit, linenetamt, c_charge_id, c_uom_id, c_tax_id, s_resourceassignment_id,
	                   a_asset_id, taxamt, m_attributesetinstance_id, isdescription, isprinted, linetotalamt,
	                   ref_invoiceline_id, processed, qtyentered, priceentered, c_project_id, c_projectphase_id,
	                   c_projecttask_id, rrstartdate, rramt, c_campaign_id, c_activity_id, user1_id, user2_id,
	                   ad_orgtrx_id, m_rmaline_id, a_createasset, a_processed, a_capvsexp, a_asset_group_id,
	                   isfixedassetinvoice, c_1099box_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.isactive,
	ol.created,
	ol.createdby,
	ol.updated,
	ol.updatedby,
	i.c_invoice_id,
	iol.m_inoutline_id,
	ol.line,
	ol.description,
	ol.m_product_id,
	qtyinvoiced,
	pricelist,
	priceactual,
	pricelimit,
	linenetamt,
	ol.c_charge_id,
	ol.c_uom_id,
	c_tax_id,
	s_resourceassignment_id,
	NULL,          -- a_asset_id
	0,             -- taxamt
	ol.m_attributesetinstance_id,
	ol.isdescription,
	i.isprinted,
	ol.linenetamt, -- linetotalamt
	NULL,          -- ref_invoiceline_id
	'N',           -- processed
	ol.qtyentered,
	priceentered,
	ol.c_project_id,
	ol.c_projectphase_id,
	ol.c_projecttask_id,
	rrstartdate,
	rramt,
	ol.c_campaign_id,
	ol.c_activity_id,
	ol.user1_id,
	ol.user2_id,
	ol.ad_orgtrx_id,
	m_rmaline_id,
	'N',           -- a_createasset
	'N',           -- a_processed
	NULL,          -- a_capvsexp
	NULL,          -- a_asset_group_id
	isfixedassetinvoice,
	NULL           -- c_1099box_id
FROM
	c_order o
		JOIN c_invoice i
			ON o.c_order_id = i.c_order_id
		JOIN tmp_bad_invoice_ids bii
			ON i.c_invoice_id = bii.c_invoice_id
		JOIN c_orderline ol
			ON o.c_order_id = ol.c_order_id
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id;

INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               c_invoice_id, c_orderline_id, m_inoutline_id, line, description, m_product_id, qtyinvoiced, pricelist,
	               priceactual, pricelimit, linenetamt, c_charge_id, c_uom_id, c_tax_id, s_resourceassignment_id,
	               a_asset_id, taxamt, m_attributesetinstance_id, isdescription, isprinted, linetotalamt,
	               ref_invoiceline_id, processed, qtyentered, priceentered, c_project_id, c_projectphase_id,
	               c_projecttask_id, rrstartdate, rramt, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id,
	               m_rmaline_id, a_createasset, a_processed, a_capvsexp, a_asset_group_id, c_invoiceline_uu,
	               isfixedassetinvoice, c_1099box_id)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	c_invoice_id,
	c_orderline_id,
	m_inoutline_id,
	line,
	description,
	m_product_id,
	qtyinvoiced,
	pricelist,
	priceactual,
	pricelimit,
	linenetamt,
	c_charge_id,
	c_uom_id,
	c_tax_id,
	s_resourceassignment_id,
	a_asset_id,
	taxamt,
	m_attributesetinstance_id,
	isdescription,
	isprinted,
	linetotalamt,
	ref_invoiceline_id,
	processed,
	qtyentered,
	priceentered,
	c_project_id,
	c_projectphase_id,
	c_projecttask_id,
	rrstartdate,
	rramt,
	c_campaign_id,
	c_activity_id,
	user1_id,
	user2_id,
	ad_orgtrx_id,
	m_rmaline_id,
	a_createasset,
	a_processed,
	a_capvsexp,
	a_asset_group_id,
	c_invoiceline_uu,
	isfixedassetinvoice,
	c_1099box_id
FROM
	tmp_c_invoiceline;

-- Make sure periods exist for any errored order (or associated invoice/payment)
-- Get all the accounting date information we'll need for the various tables
DROP TABLE IF EXISTS tmp_account_dates;
WITH account_dates AS (
-- Insert years for all errored orders
	SELECT
		o.ad_client_id,
		o.dateacct
	FROM
		c_order o
			JOIN tmp_errored_order_ids teoi
				ON teoi.c_order_id = o.c_order_id
			JOIN c_calendar c
				ON c.ad_client_id = o.ad_client_id
	UNION
-- Insert years for all invoices associated with errored orders
	SELECT
		i.ad_client_id,
		i.dateacct
	FROM
		c_invoice i
			JOIN tmp_errored_order_ids teoi
				ON teoi.c_order_id = i.c_order_id
			JOIN c_calendar c
				ON c.ad_client_id = i.ad_client_id
	UNION
-- Insert years for all payments associated with errored orders
	SELECT
		p.ad_client_id,
		p.dateacct
	FROM
		c_order o
			JOIN tmp_errored_order_ids teoi
				ON teoi.c_order_id = o.c_order_id
			JOIN c_calendar c
				ON c.ad_client_id = o.ad_client_id
			LEFT JOIN c_invoice i
				ON o.c_order_id = i.c_order_id
			LEFT JOIN c_allocationline al
				ON i.c_invoice_id = al.c_invoice_id
			LEFT JOIN c_payment p
				ON al.c_payment_id = p.c_payment_id OR p.bh_c_order_id = o.c_order_id
),
	account_dates_plus_today AS (
		SELECT
			ad_client_id,
			dateacct
		FROM
			account_dates
		UNION
		SELECT
			ad.ad_client_id,
			NOW()::date
		FROM
			(
				SELECT DISTINCT
					ad_client_id
				FROM
					account_dates
			) ad
	)
SELECT DISTINCT
	ad_client_id,
	EXTRACT(YEAR FROM dateacct)                                                 AS calendar_year,
	EXTRACT(MONTH FROM dateacct)                                                AS calendar_month,
	TO_CHAR(dateacct, 'Mon-YY')                                                 AS name,
	DATE_TRUNC('month', dateacct)                                               AS startdate,
			DATE_TRUNC('month', dateacct) + '1 month'::interval - '1 day'::interval AS enddate
INTO TEMP TABLE
	tmp_account_dates
FROM
	account_dates_plus_today;

-- First create any years that don't yet exist
DROP TABLE IF EXISTS tmp_c_year;
CREATE TEMP TABLE tmp_c_year
(
	c_year_id     serial                                  NOT NULL,
	ad_client_id  numeric(10)                             NOT NULL,
	ad_org_id     numeric(10)  DEFAULT 0                  NOT NULL,
	isactive      char         DEFAULT 'Y'::bpchar        NOT NULL,
	created       timestamp    DEFAULT NOW()              NOT NULL,
	createdby     numeric(10)  DEFAULT 100                NOT NULL,
	updated       timestamp    DEFAULT NOW()              NOT NULL,
	updatedby     numeric(10)  DEFAULT 100                NOT NULL,
	fiscalyear    varchar(10)                             NOT NULL,
	description   varchar(255) DEFAULT 'N',
	c_calendar_id numeric(10)                             NOT NULL,
	processing    char         DEFAULT 'N',
	c_year_uu     uuid         DEFAULT uuid_generate_v4() NOT NULL
);

SELECT
	SETVAL(
			'tmp_c_year_c_year_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Year'
				LIMIT 1
			)::INT,
			FALSE
		);

-- Insert years for all errored orders
INSERT INTO
	tmp_c_year (ad_client_id, fiscalyear, c_calendar_id)
SELECT
	ad.ad_client_id,
	ad.calendar_year,
	c.c_calendar_id
FROM
	tmp_account_dates ad
		JOIN c_calendar c
			ON c.ad_client_id = ad.ad_client_id
		LEFT JOIN c_year y
			ON c.c_calendar_id = y.c_calendar_id AND y.fiscalyear = ad.calendar_year::varchar
WHERE
	y.c_year_id IS NULL;

INSERT INTO
	c_year (c_year_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, fiscalyear, description,
	        c_calendar_id, processing, c_year_uu)
SELECT
	c_year_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	fiscalyear,
	description,
	c_calendar_id,
	processing,
	c_year_uu
FROM
	tmp_c_year
ON CONFLICT DO NOTHING;

-- Now handle the periods
DROP TABLE IF EXISTS tmp_c_period;
CREATE TEMP TABLE IF NOT EXISTS tmp_c_period
(
	c_period_id  serial                          NOT NULL,
	ad_client_id numeric(10)                     NOT NULL,
	ad_org_id    numeric(10) DEFAULT 0           NOT NULL,
	isactive     char        DEFAULT 'Y'::bpchar NOT NULL,
	created      timestamp   DEFAULT NOW()       NOT NULL,
	createdby    numeric(10) DEFAULT 100         NOT NULL,
	updated      timestamp   DEFAULT NOW()       NOT NULL,
	updatedby    numeric(10) DEFAULT 100         NOT NULL,
	name         varchar(60)                     NOT NULL,
	periodno     numeric(10)                     NOT NULL,
	c_year_id    numeric(10)                     NOT NULL,
	startdate    timestamp                       NOT NULL,
	enddate      timestamp,
	periodtype   char        DEFAULT 'S'         NOT NULL,
	processing   char        DEFAULT 'N',
	c_period_uu  uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_period_c_period_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_Period'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_c_period (ad_client_id, name, periodno, c_year_id, startdate, enddate)
SELECT
	ad.ad_client_id,
	ad.name,
	ad.calendar_month,
	y.c_year_id,
	ad.startdate,
	ad.enddate
FROM
	tmp_account_dates ad
		JOIN c_year y
			ON y.fiscalyear = ad.calendar_year::varchar AND y.ad_client_id = ad.ad_client_id;

INSERT INTO
	c_period (c_period_id, ad_client_id, ad_org_id, createdby, updatedby, name, periodno, c_year_id, startdate, enddate,
	          periodtype, processing)
SELECT
	c_period_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	periodno,
	c_year_id,
	startdate,
	enddate,
	periodtype,
	processing
FROM
	tmp_c_period
ON CONFLICT DO NOTHING;

-- Lastly, insert the period controls
DROP TABLE IF EXISTS tmp_c_periodcontrol;
CREATE TEMP TABLE tmp_c_periodcontrol
(
	c_periodcontrol_id serial                          NOT NULL,
	ad_client_id       numeric(10)                     NOT NULL,
	ad_org_id          numeric(10) DEFAULT 0           NOT NULL,
	isactive           char        DEFAULT 'Y'::bpchar NOT NULL,
	created            timestamp   DEFAULT NOW()       NOT NULL,
	createdby          numeric(10) DEFAULT 100         NOT NULL,
	updated            timestamp   DEFAULT NOW()       NOT NULL,
	updatedby          numeric(10) DEFAULT 100         NOT NULL,
	c_period_id        numeric(10)                     NOT NULL,
	docbasetype        char(3)                         NOT NULL,
	periodstatus       char        DEFAULT 'O',
	periodaction       char        DEFAULT 'N'         NOT NULL,
	processing         char        DEFAULT 'N',
	c_periodcontrol_uu uuid        DEFAULT uuid_generate_v4()
);

SELECT
	SETVAL(
			'tmp_c_periodcontrol_c_periodcontrol_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'C_PeriodControl'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_c_periodcontrol (ad_client_id, c_period_id, docbasetype)
SELECT
	tp.ad_client_id,
	tp.c_period_id,
	dt.docbasetype
FROM
	(
		SELECT
			c_period_id,
			p.ad_client_id
		FROM
			tmp_account_dates ad
				JOIN c_year y
					ON y.fiscalyear = ad.calendar_year::varchar AND y.ad_client_id = ad.ad_client_id
				JOIN c_period p
					ON y.c_year_id = p.c_year_id AND ad.calendar_month = p.periodno
	) tp
		JOIN (
		SELECT DISTINCT
			ad_client_id,
			docbasetype
		FROM
			c_doctype
	) dt
			ON tp.ad_client_id = dt.ad_client_id;

INSERT INTO
	c_periodcontrol (c_periodcontrol_id, ad_client_id, ad_org_id, createdby, updatedby, c_period_id, docbasetype,
	                 periodstatus, periodaction, processing)
SELECT
	c_periodcontrol_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_period_id,
	docbasetype,
	periodstatus,
	periodaction,
	processing
FROM
	tmp_c_periodcontrol
ON CONFLICT DO NOTHING;

UPDATE c_periodcontrol
SET
	periodstatus = 'O'
WHERE
		c_periodcontrol_id IN (
		SELECT
			c_periodcontrol_id
		FROM
			tmp_c_periodcontrol
	);

-- Update completed invoices marked as paid to not be paid if they have no active allocation headers associated with them
UPDATE c_invoice
SET
	ispaid = 'N'
WHERE
	ispaid = 'Y'
	AND isactive = 'Y'
	AND c_invoice_id IN (
	SELECT
		i.c_invoice_id
	FROM
		c_invoice i
			LEFT JOIN c_allocationline al
				ON i.c_invoice_id = al.c_invoice_id AND al.isactive = 'Y'
			LEFT JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id AND ah.docstatus != 'RE'
	WHERE
		al.c_invoice_id IS NULL
		OR ah.c_allocationhdr_id IS NULL
);

UPDATE c_payment
SET
	isallocated  = 'N',
	c_invoice_id = NULL
WHERE
		c_payment_id IN (
		SELECT
			p.c_payment_id
		FROM
			c_payment p
				LEFT JOIN c_allocationline al
					ON p.c_payment_id = al.c_payment_id AND al.isactive = 'Y'
				LEFT JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id AND ah.docstatus != 'RE'
		WHERE
			al.c_payment_id IS NULL
			OR ah.c_allocationhdr_id IS NULL
	)
	AND isactive = 'Y'
	AND isallocated = 'Y';

-- For the errored orders, make sure their grand totals are correct
UPDATE c_order o
SET
	grandtotal = t.grandtotal,
	totallines = t.grandtotal
FROM
	(
		SELECT
			teoi.c_order_id,
			SUM(linenetamt) AS grandtotal
		FROM
			tmp_errored_order_ids teoi
				JOIN c_orderline ol
					ON ol.c_order_id = teoi.c_order_id
		GROUP BY teoi.c_order_id
	) t
WHERE
	t.c_order_id = o.c_order_id;

-- Fix any price lists versions's valid-from to be before any orders that need to be worked with
UPDATE m_pricelist_version plv
SET
	validfrom = mins.min_dateacct
FROM
	(
		SELECT
			p.m_product_id,
			MIN(o.dateacct) min_dateacct
		FROM
			tmp_errored_order_ids teoi
				JOIN c_order o
					ON teoi.c_order_id = o.c_order_id
				JOIN c_orderline ol
					ON o.c_order_id = ol.c_order_id
				JOIN m_product p
					ON ol.m_product_id = p.m_product_id
		GROUP BY p.m_product_id
	) mins
		JOIN m_productprice pp
			ON mins.m_product_id = pp.m_product_id
WHERE
	pp.m_pricelist_version_id = plv.m_pricelist_version_id
	AND mins.min_dateacct < plv.validfrom;

-- Update payments that aren't marked as completed, but really are
UPDATE c_payment
SET
	docstatus = 'CO'
WHERE
	isallocated = 'Y'
	AND docstatus = 'DR'
	AND c_payment_id IN (
	SELECT
		p.c_payment_id
	FROM
		tmp_errored_order_ids teoi
			LEFT JOIN c_invoice i
				ON teoi.c_order_id = i.c_order_id AND i.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
			LEFT JOIN c_allocationline al
				ON i.c_invoice_id = al.c_invoice_id
			LEFT JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			LEFT JOIN c_payment p
				ON (p.bh_c_order_id = teoi.c_order_id OR p.c_payment_id = al.c_payment_id) AND
				   p.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
);

-- Update invoices that aren't marked as completed, but really are
UPDATE c_invoice
SET
	docstatus = 'CO'
WHERE
	issotrx = 'Y'
	AND docstatus IN ('IP')
	AND docaction = 'CL'
	AND c_invoice_id IN (
	SELECT
		i.c_invoice_id
	FROM
		tmp_errored_order_ids teoi
			LEFT JOIN c_invoice i
				ON teoi.c_order_id = i.c_order_id AND i.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
);

-- Set the completion process to not run at the same time
UPDATE ad_process
SET
	allowmultipleexecution = 'N'
WHERE
	ad_process_uu = '1d5191dd-4792-464f-94c5-5b4d652e5fe5';

-- Disable the completion scheduler so we can run it manually (to update a lot of old data)
UPDATE ad_scheduler
SET
	isactive = 'N'
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1d5191dd-4792-464f-94c5-5b4d652e5fe5'
	);

SELECT
	update_sequences();

SELECT
	register_migration_script('202207261947_GO-2380.sql')
FROM
	dual;
