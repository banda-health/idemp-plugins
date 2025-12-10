/**********************************************************************************************************/
-- Handle the multiples cases
-- 1. Combine duplicates and delete the duplicate row
-- 2. Manually handle the remaining cases
/**********************************************************************************************************/

-- Get the order lines to delete
SELECT
	ol1.c_orderline_id AS orderline_to_keep,
	ol2.c_orderline_id AS orderline_to_delete
INTO TEMP TABLE
	tmp_c_orderlines_to_delete
FROM
	c_orderline ol2
		JOIN c_orderline ol1
			ON ol2.c_orderline_id > ol1.c_orderline_id AND ol2.c_order_id = ol1.c_order_id AND
			   ol2.c_charge_id = ol1.c_charge_id
		JOIN c_order o
			ON ol1.c_order_id = o.c_order_id AND o.bh_visit_id IS NOT NULL;

-- Update the order and any invoice lines with the new line net amount
UPDATE c_orderline ol1
SET
	priceactual = ol1.priceactual + ol2.priceactual,
	linenetamt  = ol1.linenetamt + ol2.linenetamt
FROM
	c_orderline ol2
		JOIN tmp_c_orderlines_to_delete toltd
			ON ol2.c_orderline_id = toltd.orderline_to_delete
WHERE
	ol1.c_orderline_id = toltd.orderline_to_keep;
UPDATE c_invoiceline il1
SET
	priceactual = il1.priceactual + il2.priceactual,
	linenetamt  = il1.linenetamt + il2.linenetamt
FROM
	c_invoiceline il2
		JOIN tmp_c_orderlines_to_delete toltd
			ON il2.c_orderline_id = toltd.orderline_to_delete
WHERE
	il1.c_orderline_id = toltd.orderline_to_keep;

-- Delete the duplicate invoice lines & order lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_invoiceline
WHERE
	c_orderline_id IN (
		SELECT
			orderline_to_delete
		FROM
			tmp_c_orderlines_to_delete
	);$$, 'c_invoiceline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline
WHERE
	c_orderline_id IN (
		SELECT
			orderline_to_delete
		FROM
			tmp_c_orderlines_to_delete
	);$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline
WHERE
	c_orderline_id IN (
		SELECT
			orderline_to_delete
		FROM
			tmp_c_orderlines_to_delete
	);$$, 'c_orderline_id');

/**********************************************************************************************************/
-- Scenarios we have to deal with (problem exits on order) of 20676 cases
-- 1. Bill waiver that already exists on an invoice (14098 of these - just delete and update order total)
-- 2. Bill waiver that isn't on an invoice and the visit has an invoice (9 of these - add an invoice line)
-- 3. Bill waiver that isn't on an invoice and the visit has no invoice (506 of these - create an invoice and possibly payments)
-- 4. Insurer/donor on invoice and additional invoice already generated (12 of these - just delete and update the order total)
-- 5. Insurer/donor on invoice and additional invoice not generated (5354 of these - delete and update the order total, and generate new invoice)
-- 6. Insurer/donor not on invoice and additional invoice is generated (0 of these - add an invoice line and add to the invoice)
-- 7. Insurer/donor not on invoice and additional invoice not generated (55 of these - add an invoice line and generate new invoice)
-- 8. Insurer/donor with no invoice and additional invoice is generated (0 of these - create an invoice)
-- 9. Insurer/donor with on invoice and additional invoice not generated (662 of these - create an invoice, and generate new invoice)
/**********************************************************************************************************/

-- Get the orders with erroneous order lines
SELECT
	c_order_id
INTO TEMP
	TABLE
	tmp_c_orders_to_update
FROM
	c_order
WHERE
	bh_visit_id IS NOT NULL
	AND EXISTS (
		SELECT
			1
		FROM
			c_orderline
		WHERE
			c_order_id = c_order.c_order_id
			AND c_charge_id IS NOT NULL
	);

/**********************************************************************************************************/
-- 1. Bill waiver that already exists on an invoice (14098 of these - just delete and update order total)
/**********************************************************************************************************/
-- Get the order lines we're working with
DROP TABLE IF EXISTS tmp_c_orderline_to_work_with;
SELECT DISTINCT
	ol.c_orderline_id,
	FALSE AS need_to_create_invoice
INTO TEMP TABLE
	tmp_c_orderline_to_work_with
FROM
	c_orderline ol
		JOIN tmp_c_orders_to_update totu
			ON ol.c_order_id = totu.c_order_id
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id AND c.name IN ('Bill Waiver', 'Finances - Miscellaneous/Other', 'Charge Test')
		JOIN c_invoiceline il
			ON ol.c_orderline_id = il.c_orderline_id;

-- Update any invoice lines pointing to this order line to not point there
UPDATE c_invoiceline il
SET
	c_orderline_id = NULL,
	m_inoutline_id = NULL
FROM
	tmp_c_orderline_to_work_with toltww
WHERE
	toltww.c_orderline_id = il.c_orderline_id;
-- Now remove the unnecessary order lines and inout lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline iol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	iol.c_orderline_id = toltww.c_orderline_id;$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	ol.c_orderline_id = toltww.c_orderline_id;$$, 'c_orderline_id');

/**********************************************************************************************************/
-- 2. Bill waiver that isn't on an invoice and the visit has an invoice (9 of these - add an invoice line)
-- 3. Bill waiver that isn't on an invoice and the visit has no invoice (506 of these - create an invoice and possibly payments)
/**********************************************************************************************************/
-- Get the order lines to work with
DROP TABLE tmp_c_orderline_to_work_with;
SELECT DISTINCT
	ol.c_orderline_id,
	CASE WHEN i.c_invoice_id IS NULL THEN TRUE ELSE FALSE END AS need_to_create_invoice
INTO TEMP TABLE
	tmp_c_orderline_to_work_with
FROM
	c_orderline ol
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.bh_visit_id IS NOT NULL
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id AND c.name = 'Bill Waiver'
		LEFT JOIN c_invoiceline il
			ON ol.c_orderline_id = il.c_orderline_id
		LEFT JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
WHERE
	il.c_invoice_id IS NULL;

-- For places we need to create invoices for, do so
-- First update some off document numbers
UPDATE ad_sequence s
SET
	currentnext = i.documentno + 1
FROM
	(
		SELECT ad_client_id, MAX(documentno::numeric) AS documentno FROM c_invoice GROUP BY ad_client_id
	) i
WHERE
	name = 'DocumentNo_C_Invoice'
	AND s.ad_client_id = i.ad_client_id;
DROP TABLE IF EXISTS tmp_c_invoice;
CREATE TEMP TABLE tmp_c_invoice
(
	c_invoice_id           serial                          NOT NULL,
	ad_client_id           numeric(10)                     NOT NULL,
	ad_org_id              numeric(10)                     NOT NULL,
-- 	isactive               char         DEFAULT 'Y'::bpchar NOT NULL,
	created                timestamp                       NOT NULL,
	createdby              numeric(10) DEFAULT 100         NOT NULL,
	updated                timestamp                       NOT NULL,
	updatedby              numeric(10) DEFAULT 100         NOT NULL,
	issotrx                char        DEFAULT 'Y'::bpchar NOT NULL,
	documentno             numeric                         NOT NULL,
	docstatus              char(2)                         NOT NULL,
	docaction              char(2)                         NOT NULL,
	processing             char,
	processed              char                            NOT NULL,
	posted                 char                            NOT NULL,
	c_doctype_id           numeric(10)                     NOT NULL,
	c_doctypetarget_id     numeric(10)                     NOT NULL,
	c_order_id             numeric(10),
	description            varchar(255)                    NOT NULL,
-- 	isapproved             char         DEFAULT 'N'::bpchar NOT NULL,
-- 	istransferred          char         DEFAULT 'N'::bpchar NOT NULL,
-- 	isprinted              char         DEFAULT 'N'::bpchar NOT NULL,
	salesrep_id            numeric(10),
	dateinvoiced           timestamp                       NOT NULL,
-- 	dateprinted            timestamp,
	dateacct               timestamp                       NOT NULL,
	c_bpartner_id          numeric(10)                     NOT NULL,
	c_bpartner_location_id numeric(10)                     NOT NULL,
	poreference            varchar(20)                     NULL,
	isdiscountprinted      char        DEFAULT 'Y'::bpchar NOT NULL,
	dateordered            timestamp,
	c_currency_id          numeric(10)                     NOT NULL,
	paymentrule            char        DEFAULT 'P'         NOT NULL,
	c_paymentterm_id       numeric(10)                     NOT NULL,
-- 	c_charge_id            numeric(10),
-- 	chargeamt              numeric      DEFAULT 0,
	totallines             numeric                         NOT NULL,
	grandtotal             numeric                         NOT NULL,
	m_pricelist_id         numeric(10)                     NOT NULL,
-- 	istaxincluded          char         DEFAULT 'N'::bpchar NOT NULL,
-- 	c_campaign_id          numeric(10),
-- 	c_project_id           numeric(10),
-- 	c_activity_id          numeric(10),
	ispaid                 char                            NOT NULL,
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
	reversal_id            numeric(10),
	processedon            numeric,
-- 	c_cashplanline_id      numeric(10)  DEFAULT NULL::numeric,
	c_invoice_uu           varchar(36) DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char        DEFAULT 'N',
-- 	relatedinvoice_id      numeric(10)  DEFAULT NULL::numeric,
-- 	bh_voided_reason_id    numeric(10)  DEFAULT NULL::numeric,
	bh_visit_id            numeric(10)                     NOT NULL,
-- 	isoverridecurrencyrate char         DEFAULT 'N'::bpchar NOT NULL,
-- 	currencyrate           numeric,
-- 	createlinesfrom        char         DEFAULT NULL::bpchar
	c_orderline_id         numeric(10),
	is_documentno_updated  bool        DEFAULT FALSE
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
	tmp_c_invoice (ad_client_id, ad_org_id, created, updated, documentno, docstatus, docaction, processing, processed,
	               posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id, dateinvoiced, dateacct,
	               c_bpartner_id, c_bpartner_location_id, poreference, dateordered, c_currency_id, c_paymentterm_id,
	               totallines, grandtotal, m_pricelist_id, ispaid, processedon, bh_visit_id)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.created + '1 minute'::interval,
	o.updated + '1 minute'::interval,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	'DR',
	'CO',
	'N',
	'N',
	'N',
	dt.c_doctype_id,
	dt.c_doctype_id,
	o.c_order_id,
	'Visit Invoice - System Generated',
	o.salesrep_id,
	o.dateordered,
	o.dateacct,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	NULL,
	o.dateordered,
	o.c_currency_id,
	pt.c_paymentterm_id,
	o.totallines,
	o.grandtotal,
	o.m_pricelist_id,
	'N',
	NULL,
	o.bh_visit_id
FROM
	c_order o
		JOIN ad_sequence seq
			ON seq.ad_client_id = o.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
		JOIN c_paymentterm pt
			ON pt.ad_client_id = o.ad_client_id AND pt.value = 'Immediate'
WHERE
	o.c_order_id IN (
		SELECT
			c_order_id
		FROM
			c_orderline ol
				JOIN tmp_c_orderline_to_work_with toltww
					ON ol.c_orderline_id = toltww.c_orderline_id
	);

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
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, issotrx, documentno,
	           docstatus, docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id,
	           description, salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference,
	           isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal,
	           m_pricelist_id, ispaid, processedon, c_invoice_uu, isfixedassetinvoice, bh_visit_id)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
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
	isfixedassetinvoice,
	bh_visit_id
FROM
	tmp_c_invoice;

-- Add the invoice lines
DROP TABLE IF EXISTS tmp_c_invoiceline;
CREATE TEMP TABLE tmp_c_invoiceline
(
	c_invoiceline_id          serial                          NOT NULL,
	ad_client_id              numeric(10)                     NOT NULL,
	ad_org_id                 numeric(10)                     NOT NULL,
	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
	created                   timestamp                       NOT NULL,
	createdby                 numeric(10) DEFAULT 100         NOT NULL,
	updated                   timestamp                       NOT NULL,
	updatedby                 numeric(10) DEFAULT 100         NOT NULL,
	c_invoice_id              numeric(10)                     NOT NULL,
	c_orderline_id            numeric(10),
	m_inoutline_id            numeric(10),
	line                      numeric(10)                     NOT NULL,
--	description               varchar(255),
-- 	m_product_id              numeric(10),
	qtyinvoiced               numeric                         NOT NULL,
	pricelist                 numeric                         NOT NULL,
	priceactual               numeric                         NOT NULL,
	pricelimit                numeric                         NOT NULL,
	linenetamt                numeric                         NOT NULL,
	c_charge_id               numeric(10),
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

-- Insert new invoice lines where we don't need to create an invoice
INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, created, updated, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist,
	                   priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt,
	                   qtyentered, priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.created + '1 minute'::interval,
	ol.updated + '1 minute'::interval,
	i.c_invoice_id,
	ol.line,
	ol.c_charge_id,
	ol.qtyordered * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt,
	ol.qtyentered,
	ol.priceentered,
	CASE WHEN ol.c_charge_id IS NULL THEN ol.c_orderline_id END
FROM
	c_orderline ol
		JOIN tmp_c_orderline_to_work_with toltww
			ON toltww.c_orderline_id = ol.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
		JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO');

-- Add invoice lines for the other stuff on invoices we're creating
INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, created, updated, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist,
	                   priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt,
	                   qtyentered, priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.created + '1 minute'::interval,
	ol.updated + '1 minute'::interval,
	i.c_invoice_id,
	ol.line,
	ol.c_charge_id,
	ol.qtyordered * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt,
	ol.qtyentered,
	ol.priceentered,
	CASE WHEN ol.c_charge_id IS NULL THEN ol.c_orderline_id END
FROM
	c_order o
		JOIN c_orderline ol
			ON o.c_order_id = ol.c_order_id AND ol.c_charge_id IS NULL
		JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
WHERE
	o.c_order_id IN (
		SELECT
			c_order_id
		FROM
			c_orderline ol_s
				JOIN tmp_c_orderline_to_work_with toltww
					ON toltww.c_orderline_id = ol_s.c_orderline_id AND toltww.need_to_create_invoice
	);

INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, c_invoice_id, line,
	               c_charge_id, c_uom_id, c_tax_id, qtyentered, priceentered, isfixedassetinvoice, c_orderline_id)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
	updatedby,
	c_invoice_id,
	line,
	c_charge_id,
	c_uom_id,
	c_tax_id,
	qtyentered,
	priceentered,
	isfixedassetinvoice,
	c_orderline_id
FROM
	tmp_c_invoiceline;

-- Now remove the unnecessary order lines and inout lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline iol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	iol.c_orderline_id = toltww.c_orderline_id;$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	ol.c_orderline_id = toltww.c_orderline_id;$$, 'c_orderline_id');

/**********************************************************************************************************/
-- 4. Insurer/donor on invoice and additional invoice already generated (12 of these - just delete and update the order total)
/**********************************************************************************************************/
-- Get the order lines we're working with
DROP TABLE tmp_c_orderline_to_work_with;
SELECT DISTINCT
	ol.c_orderline_id,
	FALSE AS need_to_create_invoice
INTO TEMP TABLE
	tmp_c_orderline_to_work_with
FROM
	c_orderline ol
		JOIN tmp_c_orders_to_update totu
			ON ol.c_order_id = totu.c_order_id
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id
		JOIN c_invoiceline il
			ON ol.c_orderline_id = il.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
WHERE
	EXISTS (
		SELECT
			1
		FROM
			c_invoiceline
				JOIN c_invoice
					ON c_invoice.c_invoice_id = c_invoiceline.c_invoice_id
		WHERE
			c_invoiceline.c_charge_id = ol.c_charge_id
			AND c_invoiceline.linenetamt = -1 * ol.linenetamt
			AND c_invoice.c_bpartner_id != o.c_bpartner_id
			AND c_invoice.bh_visit_id = o.bh_visit_id
			AND (c_invoice.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
	);

-- Update any invoice lines pointing to this order line to not point there
UPDATE c_invoiceline il
SET
	c_orderline_id = NULL,
	m_inoutline_id = NULL
FROM
	tmp_c_orderline_to_work_with toltww
WHERE
	toltww.c_orderline_id = il.c_orderline_id;
-- Now remove the unnecessary order lines and inout lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline iol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	iol.c_orderline_id = toltww.c_orderline_id;$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	ol.c_orderline_id = toltww.c_orderline_id;$$, 'c_orderline_id');

/**********************************************************************************************************/
-- Handle the new insurer/donor invoices needed for the following scenarios:
-- 5. Insurer/donor on invoice and additional invoice not generated (5354 of these - delete and update the order total, and generate new invoice)
-- 6. Insurer/donor not on invoice and additional invoice is generated (0 of these - add an invoice line and add to the invoice)
-- 7. Insurer/donor not on invoice and additional invoice not generated (55 of these - add an invoice line and generate new invoice)
-- 8. Insurer/donor with no invoice and additional invoice is generated (0 of these - create an invoice)
-- 9. Insurer/donor with no invoice and additional invoice not generated (662 of these - create an invoice, and generate new invoice)
/**********************************************************************************************************/
-- Find the insurer/donor to use matching the charge
SELECT
	ol.c_orderline_id,
	o.c_bpartner_id,
	ol.c_charge_id,
	COALESCE(bp_general.c_bpartner_id, bp_payor.c_bpartner_id) AS bh_payor_id,
	CASE
		WHEN bp_general.c_bpartner_id IS NOT NULL THEN bp_general.totalopenbalance
		ELSE bp_payor.totalopenbalance END                       AS current_totalopenbalance
INTO TEMP TABLE
	tmp_charge_to_donor_mapping
FROM
	c_orderline ol
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.bh_visit_id IS NOT NULL
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id
		JOIN c_charge_acct ca
			ON c.c_charge_id = ca.c_charge_id
		JOIN c_validcombination vc_c
			ON ca.ch_expense_acct = vc_c.c_validcombination_id
		JOIN c_elementvalue ev_c
			ON vc_c.account_id = ev_c.c_elementvalue_id
		JOIN c_elementvalue ev_p
			ON ev_c.value = ev_p.value AND ev_c.ad_client_id = ev_p.ad_client_id
		JOIN c_validcombination vc_p
			ON ev_p.c_elementvalue_id = vc_p.account_id
		JOIN c_bp_group_acct bpga
			ON vc_p.c_validcombination_id = bpga.c_receivable_acct
		JOIN c_bp_group bpg
			ON bpga.c_bp_group_id = bpg.c_bp_group_id
		JOIN c_bpartner bp_payor
			ON bpg.c_bp_group_id = bp_payor.c_bp_group_id AND bp_payor.created < '2023-12-01' AND
			   CASE
				   WHEN bpg.bh_subtype = 'I' THEN bp_payor.name IN ('NHIF FFS', 'NHIF National Scheme')
				   WHEN bpg.bh_subtype = 'D' THEN bp_payor.name = 'Donor Fund'
				   ELSE FALSE
				   END
		JOIN c_bpartner bp_patient
			ON o.c_bpartner_id = bp_patient.c_bpartner_id
		LEFT JOIN LATERAL (
		SELECT
			c_bpartner_id,
			bh_payer_id,
			ROW_NUMBER() OVER (PARTITION BY c_bpartner_id ORDER BY created DESC) AS row_num
		FROM
			bh_bp_payer_info
		WHERE
			created < o.created
		) bppi
			ON bp_patient.c_bpartner_id = bppi.c_bpartner_id AND bppi.row_num = 1
		LEFT JOIN c_bpartner bp_general
			ON bppi.bh_payer_id = bp_general.c_bpartner_id AND bp_general.c_bp_group_id = bpg.c_bp_group_id;

-- Generate invoices for each of the above, handling drafted, completed, and voided accordingly
-- First, update all the sequences
SELECT
	update_sequences();
UPDATE ad_sequence
SET
	currentnext = currentnext + (
		SELECT COUNT(*) FROM tmp_c_invoice WHERE ad_client_id = ad_sequence.ad_client_id
	)
WHERE
	name = 'DocumentNo_C_Invoice'
	AND ad_client_id IN (
		SELECT DISTINCT
			ad_client_id
		FROM
			tmp_c_invoice
	);

-- Insert drafted invoices for payers
TRUNCATE tmp_c_invoice;
INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, created, updated, documentno, docstatus, docaction, processing, processed,
	               posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id, dateinvoiced, dateacct,
	               c_bpartner_id, c_bpartner_location_id, poreference, dateordered, c_currency_id, c_paymentterm_id,
	               totallines, grandtotal, m_pricelist_id, ispaid, processedon, bh_visit_id, c_orderline_id)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.created + '1 minute'::interval,
	o.updated + '1 minute'::interval,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'DR' WHEN o.docstatus = 'CO' THEN 'CO' ELSE 'RE' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'CO' WHEN o.docstatus = 'CO' THEN 'CL' ELSE '--' END,
	'N',
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'N' ELSE 'Y' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'N' ELSE 'Y' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 0 ELSE dt.c_doctype_id END,
	dt.c_doctype_id,
	NULL,                -- No order IDs for these invoices
	'Auto-generated insurer/donor invoice in arrears',
	NULL,
	o.dateordered,
	o.dateacct,
	tctdm.bh_payor_id,
	bpl.c_bpartner_location_id,
	NULL,
	NULL,
	o.c_currency_id,
	pt.c_paymentterm_id,
	ol.linenetamt * -1,
	ol.linenetamt * -1,
	m_pricelist_id,
	'N',
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN NULL ELSE EXTRACT(EPOCH FROM NOW()) * 1000 END,
	bh_visit_id,
	ol.c_orderline_id
FROM
	c_orderline ol
		JOIN tmp_charge_to_donor_mapping tctdm
			ON ol.c_orderline_id = tctdm.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('DR', 'IP', 'CO', 'VO')
		JOIN ad_sequence seq
			ON seq.ad_client_id = o.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
		JOIN c_paymentterm pt
			ON pt.ad_client_id = o.ad_client_id AND pt.value = 'Immediate'
		JOIN c_bpartner_location bpl
			ON bpl.c_bpartner_id = tctdm.bh_payor_id
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			c_invoice i
		WHERE
			o.bh_visit_id = i.bh_visit_id
			AND i.c_bpartner_id = tctdm.bh_payor_id
			AND i.docstatus = o.docstatus
	);

-- Now insert the opposing voided invoices
INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, created, createdby, updated, updatedby, issotrx, documentno, docstatus,
	               docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description,
	               salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference,
	               isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal,
	               m_pricelist_id, ispaid, processedon, isfixedassetinvoice, bh_visit_id, c_orderline_id, reversal_id)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.created,
	ti.createdby,
	ti.updated,
	ti.updatedby,
	issotrx,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	docstatus,
	docaction,
	processing,
	processed,
	posted,
	c_doctype_id,
	c_doctypetarget_id,
	c_order_id,
	'Auto-generated insurer/donor invoice | {->' || ti.documentno || ')',
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
	totallines * -1,
	grandtotal * -1,
	m_pricelist_id,
	ispaid,
	processedon,
	isfixedassetinvoice,
	bh_visit_id,
	c_orderline_id,
	c_invoice_id
FROM
	tmp_c_invoice ti
		JOIN ad_sequence seq
			ON seq.ad_client_id = ti.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
WHERE
	docstatus = 'RE';

-- Update the document numbers again
UPDATE tmp_c_invoice i
SET
	documentno            = documentno + ti.row_num,
	is_documentno_updated = TRUE
FROM
	(
		SELECT
			c_invoice_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice
	) ti
		JOIN ad_sequence seq
			ON seq.name = 'DocumentNo_C_Invoice'
WHERE
	i.c_invoice_id = ti.c_invoice_id
	AND seq.ad_client_id = i.ad_client_id
	AND NOT is_documentno_updated;

-- Set the reversals on the original invoices
UPDATE tmp_c_invoice ti_o
SET
	description = ti_o.description || ' | (' || ti_r.documentno || '<-)',
	reversal_id = ti_r.c_invoice_id
FROM
	tmp_c_invoice ti_r
WHERE
	ti_o.c_invoice_id = ti_r.reversal_id;

INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, issotrx, documentno,
	           docstatus, docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id,
	           description, salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference,
	           isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal,
	           m_pricelist_id, ispaid, processedon, c_invoice_uu, isfixedassetinvoice, bh_visit_id)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
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
	isfixedassetinvoice,
	bh_visit_id
FROM
	tmp_c_invoice;

TRUNCATE tmp_c_invoiceline;
INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, created, updated, c_invoice_id, c_orderline_id, m_inoutline_id, line,
	                   qtyinvoiced, pricelist, priceactual, pricelimit, linenetamt, c_charge_id, c_uom_id, c_tax_id,
	                   m_attributesetinstance_id, linetotalamt, qtyentered, priceentered)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.created,
	ti.updated,
	ti.c_invoice_id,
	NULL,
	NULL,
	10,
	ol.qtyinvoiced * CASE WHEN ti.c_invoice_id > ti.reversal_id THEN -1 ELSE 1 END,
	ol.pricelist * -1,
	ol.priceactual * -1,
	ol.pricelimit * -1,
	ol.linenetamt * -1 * CASE WHEN ti.c_invoice_id > ti.reversal_id THEN -1 ELSE 1 END,
	ol.c_charge_id,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt * -1,
	ol.qtyentered * CASE WHEN ti.c_invoice_id > ti.reversal_id THEN -1 ELSE 1 END,
	ol.priceentered * -1
FROM
	c_orderline ol
		JOIN tmp_charge_to_donor_mapping tctdm
			ON ol.c_orderline_id = tctdm.c_orderline_id
		JOIN tmp_c_invoice ti
			ON ol.c_orderline_id = ti.c_orderline_id;

INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               c_invoice_id, c_orderline_id, m_inoutline_id, line, qtyinvoiced, pricelist, priceactual, pricelimit,
	               linenetamt, c_charge_id, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt, processed,
	               qtyentered, priceentered, c_invoiceline_uu, isfixedassetinvoice)
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
	qtyinvoiced,
	pricelist,
	priceactual,
	pricelimit,
	linenetamt,
	c_charge_id,
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

-- Now add the GL entries
DROP TABLE IF EXISTS tmp_fact_acct;
CREATE TEMP TABLE tmp_fact_acct
(
	fact_acct_id    serial                          NOT NULL,
	ad_client_id    numeric(10)                     NOT NULL,
	ad_org_id       numeric(10)                     NOT NULL,
-- 	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
	created         timestamp                       NOT NULL,
	createdby       numeric(10) DEFAULT 100         NOT NULL,
	updated         timestamp                       NOT NULL,
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
	tmp_fact_acct (ad_client_id, ad_org_id, created, updated, c_acctschema_id, account_id, c_period_id, record_id,
	               line_id, gl_category_id, c_tax_id, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr,
	               c_uom_id, qty, c_bpartner_id, c_locfrom_id, c_locto_id, description)
SELECT
	til.ad_client_id,
	til.ad_org_id,
	til.created,
	til.updated,
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
			ON ti.c_invoice_id = til.c_invoice_id AND ti.docstatus IN ('CO', 'RE')
		JOIN c_bpartner_location bpl
			ON ti.c_bpartner_location_id = bpl.c_bpartner_location_id
		JOIN ad_orginfo oi
			ON ti.ad_org_id = oi.ad_org_id;

-- Insert the real accounts
INSERT INTO
	fact_acct (fact_acct_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, c_acctschema_id, account_id,
	           datetrx, dateacct, c_period_id, ad_table_id, record_id, line_id, gl_category_id, c_tax_id, postingtype,
	           c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, c_uom_id, qty, c_bpartner_id, c_locfrom_id,
	           c_locto_id, description, fact_acct_uu)
SELECT
	fact_acct_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
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
-- 5. Insurer/donor on invoice and additional invoice not generated (5354 of these - delete and update the order total, and generate new invoice)
/**********************************************************************************************************/
-- Get the order lines we're working with
DROP TABLE tmp_c_orderline_to_work_with;
SELECT DISTINCT
	ol.c_orderline_id,
	FALSE AS need_to_create_invoice
INTO TEMP TABLE
	tmp_c_orderline_to_work_with
FROM
	c_orderline ol
		JOIN tmp_c_orders_to_update totu
			ON ol.c_order_id = totu.c_order_id
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id
		JOIN c_invoiceline il
			ON ol.c_orderline_id = il.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			c_invoiceline
				JOIN c_invoice
					ON c_invoice.c_invoice_id = c_invoiceline.c_invoice_id AND
					   c_invoice.description NOT ILIKE 'Auto-generated insurer/donor invoice%'
		WHERE
			c_invoiceline.c_charge_id = ol.c_charge_id
			AND c_invoiceline.linenetamt = -1 * ol.linenetamt
			AND c_invoice.c_bpartner_id != o.c_bpartner_id
			AND c_invoice.bh_visit_id = o.bh_visit_id
			AND (c_invoice.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
	);

-- Update any invoice lines pointing to this order line to not point there
UPDATE c_invoiceline il
SET
	c_orderline_id = NULL,
	m_inoutline_id = NULL
FROM
	tmp_c_orderline_to_work_with toltww
WHERE
	toltww.c_orderline_id = il.c_orderline_id;
-- Now remove the unnecessary order lines and inout lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline iol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	iol.c_orderline_id = toltww.c_orderline_id;$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	ol.c_orderline_id = toltww.c_orderline_id;$$, 'c_orderline_id');

/**********************************************************************************************************/
-- 6. ~~Insurer/donor not on invoice and additional invoice is generated (0 of these - add an invoice line and add to the invoice)~~
-- 7. Insurer/donor not on invoice and additional invoice not generated (55 of these - add an invoice line ~~and generate new invoice~~)
-- 8. ~~Insurer/donor with no invoice and additional invoice is generated (0 of these - create an invoice)~~
-- 9. Insurer/donor with no invoice and additional invoice not generated (662 of these - create an invoice~~, and generate new invoice~~)
/**********************************************************************************************************/
DROP TABLE tmp_c_orderline_to_work_with;
SELECT DISTINCT
	ol.c_orderline_id,
	CASE WHEN i.c_invoice_id IS NULL THEN TRUE ELSE FALSE END AS need_to_create_invoice
INTO TEMP TABLE
	tmp_c_orderline_to_work_with
FROM
	c_orderline ol
		JOIN c_charge c
			ON ol.c_charge_id = c.c_charge_id
		LEFT JOIN c_invoiceline il
			ON ol.c_orderline_id = il.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND bh_visit_id IS NOT NULL
		LEFT JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
WHERE
	ol.c_charge_id IS NOT NULL
	AND il.c_invoiceline_id IS NULL
	AND NOT EXISTS (
		SELECT
			1
		FROM
			c_invoiceline
				JOIN c_invoice
					ON c_invoice.c_invoice_id = c_invoiceline.c_invoice_id AND
					   c_invoice.description NOT ILIKE 'Auto-generated insurer/donor invoice%'
		WHERE
			c_invoiceline.c_charge_id = ol.c_charge_id
			AND c_invoiceline.linenetamt = -1 * ol.linenetamt
			AND c_invoice.c_bpartner_id != o.c_bpartner_id
			AND c_invoice.bh_visit_id = o.bh_visit_id
			AND (c_invoice.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
	);

TRUNCATE tmp_c_invoice;
INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, created, updated, documentno, docstatus, docaction, processing, processed,
	               posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id, dateinvoiced, dateacct,
	               c_bpartner_id, c_bpartner_location_id, poreference, dateordered, c_currency_id, c_paymentterm_id,
	               totallines, grandtotal, m_pricelist_id, ispaid, processedon, bh_visit_id)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.created + '1 minute'::interval,
	o.updated + '1 minute'::interval,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'DR' WHEN o.docstatus = 'CO' THEN 'CO' ELSE 'RE' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'CO' WHEN o.docstatus = 'CO' THEN 'CL' ELSE '--' END,
	'N',
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'N' ELSE 'Y' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 'N' ELSE 'Y' END,
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN 0 ELSE dt.c_doctype_id END,
	dt.c_doctype_id,
	o.c_order_id,
	'Auto-generated insurer/donor invoice in arrears',
	NULL,
	o.dateordered,
	o.dateacct,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	NULL,
	NULL,
	o.c_currency_id,
	pt.c_paymentterm_id,
	ol.linenetamt,
	ol.linenetamt,
	m_pricelist_id,
	'N',
	CASE WHEN o.docstatus IN ('DR', 'IP') THEN NULL ELSE EXTRACT(EPOCH FROM NOW()) * 1000 END,
	bh_visit_id
FROM
	c_orderline ol
		JOIN tmp_c_orderline_to_work_with toltww
			ON ol.c_orderline_id = toltww.c_orderline_id AND toltww.need_to_create_invoice
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('DR', 'IP', 'CO', 'VO')
		JOIN ad_sequence seq
			ON seq.ad_client_id = o.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AR Invoice'
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

-- Now insert the opposing voided invoices
INSERT INTO
	tmp_c_invoice (ad_client_id, ad_org_id, created, createdby, updated, updatedby, issotrx, documentno, docstatus,
	               docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description,
	               salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference,
	               isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal,
	               m_pricelist_id, ispaid, processedon, c_invoice_uu, isfixedassetinvoice, bh_visit_id, c_orderline_id,
	               reversal_id)
SELECT
	ti.ad_client_id,
	ti.ad_org_id,
	ti.created,
	ti.createdby,
	ti.updated,
	ti.updatedby,
	issotrx,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	docstatus,
	docaction,
	processing,
	processed,
	posted,
	c_doctype_id,
	c_doctypetarget_id,
	c_order_id,
	'Auto-generated insurer/donor invoice | {->' || ti.documentno || ')',
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
	totallines * -1,
	grandtotal * -1,
	m_pricelist_id,
	ispaid,
	processedon,
	c_invoice_uu,
	isfixedassetinvoice,
	bh_visit_id,
	c_orderline_id,
	c_invoice_id
FROM
	tmp_c_invoice ti
		JOIN ad_sequence seq
			ON seq.ad_client_id = ti.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
WHERE
	docstatus = 'RE';

-- Update the document numbers again
UPDATE tmp_c_invoice i
SET
	documentno            = documentno + ti.row_num,
	is_documentno_updated = TRUE
FROM
	(
		SELECT
			c_invoice_id,
			ROW_NUMBER() OVER ( PARTITION BY ad_client_id ORDER BY c_invoice_id) AS row_num
		FROM
			tmp_c_invoice
	) ti
WHERE
	i.c_invoice_id = ti.c_invoice_id
	AND NOT is_documentno_updated;

-- Set the reversals on the original invoices
UPDATE tmp_c_invoice ti_o
SET
	description = ti_o.description || ' | (' || ti_r.documentno || '<-)',
	reversal_id = ti_r.c_invoice_id
FROM
	tmp_c_invoice ti_r
WHERE
	ti_o.c_invoice_id = ti_r.reversal_id;

-- Insert the real invoices!
INSERT INTO
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, issotrx, documentno,
	           docstatus, docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id,
	           description, salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference,
	           isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal,
	           m_pricelist_id, ispaid, processedon, c_invoice_uu, isfixedassetinvoice, bh_visit_id)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
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
	isfixedassetinvoice,
	bh_visit_id
FROM
	tmp_c_invoice;

-- Insert new invoice lines where we don't need to create an invoice
INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, created, updated, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist,
	                   priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt,
	                   qtyentered, priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.created + '1 minute'::interval,
	ol.updated + '1 minute'::interval,
	i.c_invoice_id,
	ol.line,
	ol.c_charge_id,
	ol.qtyordered * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt,
	ol.qtyentered,
	ol.priceentered,
	CASE WHEN ol.c_charge_id IS NULL THEN ol.c_orderline_id END
FROM
	c_orderline ol
		JOIN tmp_c_orderline_to_work_with toltww
			ON toltww.c_orderline_id = ol.c_orderline_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
		JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO');

-- Add invoice lines for the other stuff on invoices we're creating
TRUNCATE tmp_c_invoiceline;
INSERT INTO
	tmp_c_invoiceline (ad_client_id, ad_org_id, created, updated, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist,
	                   priceactual, pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt,
	                   qtyentered, priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.created + '1 minute'::interval,
	ol.updated + '1 minute'::interval,
	i.c_invoice_id,
	ol.line,
	ol.c_charge_id,
	ol.qtyordered * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.pricelist,
	ol.priceactual,
	ol.pricelimit,
	ol.linenetamt * CASE WHEN reversal_id < i.c_invoice_id THEN -1 ELSE 1 END,
	ol.c_uom_id,
	ol.c_tax_id,
	ol.m_attributesetinstance_id,
	ol.linenetamt,
	ol.qtyentered,
	ol.priceentered,
	CASE WHEN ol.c_charge_id IS NULL THEN ol.c_orderline_id END
FROM
	c_order o
		JOIN c_orderline ol
			ON o.c_order_id = ol.c_order_id AND ol.c_charge_id IS NULL
		JOIN c_invoice i
			ON o.bh_visit_id = i.bh_visit_id AND (i.docstatus NOT IN ('RE', 'RA', 'VO') OR o.docstatus = 'VO')
WHERE
	o.c_order_id IN (
		SELECT
			c_order_id
		FROM
			c_orderline ol_s
				JOIN tmp_c_orderline_to_work_with toltww
					ON toltww.c_orderline_id = ol_s.c_orderline_id AND toltww.need_to_create_invoice
	);

INSERT INTO
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, created, createdby, updated, updatedby, c_invoice_id, line,
	               c_charge_id, c_uom_id, c_tax_id, qtyentered, priceentered, isfixedassetinvoice, c_orderline_id)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	created,
	createdby,
	updated,
	updatedby,
	c_invoice_id,
	line,
	c_charge_id,
	c_uom_id,
	c_tax_id,
	qtyentered,
	priceentered,
	isfixedassetinvoice,
	c_orderline_id
FROM
	tmp_c_invoiceline;

-- Now remove the unnecessary order lines and inout lines
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	m_inoutline iol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	iol.c_orderline_id = toltww.c_orderline_id;$$, 'm_inoutline_id');
SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	c_orderline ol
	USING tmp_c_orderline_to_work_with toltww
WHERE
	ol.c_orderline_id = toltww.c_orderline_id;$$, 'c_orderline_id');

/**********************************************************************************************************/
-- FINAL
/**********************************************************************************************************/
-- Now take all the orders and invoices we messed with and update their grand totals
UPDATE c_order o
SET
	totallines = ol.total,
	grandtotal = ol.total
FROM
	(
		SELECT
			ol.c_order_id,
			SUM(ol.linenetamt) AS total
		FROM
			c_orderline ol
				JOIN tmp_c_orders_to_update totu
					ON ol.c_order_id = totu.c_order_id
		GROUP BY ol.c_order_id
	) ol
WHERE
	o.c_order_id = ol.c_order_id;

UPDATE c_invoice i
SET
	totallines = il.total,
	grandtotal = il.total
FROM
	(
		SELECT
			i.c_invoice_id,
			SUM(linenetamt) total
		FROM
			c_invoiceline il
				JOIN c_invoice i
					ON il.c_invoice_id = i.c_invoice_id
		WHERE
			EXISTS (
				SELECT 1 FROM tmp_c_orders_to_update totu WHERE i.c_order_id = totu.c_order_id
			)
		GROUP BY i.c_invoice_id
	) il
WHERE
	i.c_invoice_id = il.c_invoice_id;

-- Update document numbers
UPDATE ad_sequence s
SET
	currentnext = i.documentno + 1
FROM
	(
		SELECT ad_client_id, MAX(documentno::numeric) AS documentno FROM c_invoice GROUP BY ad_client_id
	) i
WHERE
	name = 'DocumentNo_C_Invoice'
	AND s.ad_client_id = i.ad_client_id;

-- Update open balances for the affected BPs
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
			bp.c_bpartner_id IN (
				SELECT
					i.c_bpartner_id
				FROM
					c_invoice i
						JOIN c_order o
							ON i.bh_visit_id = o.bh_visit_id
						JOIN
						tmp_c_orders_to_update totu
								ON o.c_order_id = totu.c_order_id
			)
	) calc
WHERE
	calc.c_bpartner_id = bp.c_bpartner_id;

SELECT
	register_migration_script('202512081659_GO-3460.sql')
FROM
	dual;
