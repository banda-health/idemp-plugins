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
-- 1. Bill waiver that already exists on an invoice (14096 of these - just delete and update order total)
-- 2. Bill waiver that isn't on an invoice and the visit has an invoice (9 of these - add an invoice line)
-- 3. Bill waiver that isn't on an invoice and the visit has no invoice (506 of these - create an invoice and possibly payments)
-- 4. Insurer/donor on invoice and additional invoice already generated (12 of these - just delete and update the order total)
-- 5. Insurer/donor on invoice and additional invoice not generated (5366 of these - delete and update the order total, and generate new invoice)
-- 6. Insurer/donor not on invoice and additional invoice is generated (0 of these - delete and update the order total and add to the invoice)
-- 7. Insurer/donor not on invoice and additional invoice not generated (717 of these - delete and update the order total and add to the invoice)
-- 8. Insurer/donor with no invoice and additional invoice is generated (delete and update the order total and create an invoice)
-- 9. Insurer/donor with on invoice and additional invoice not generated (delete and update the order total, create an invoice and create a new invoice)
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
			c_orderline ol
				JOIN c_charge c
					ON ol.c_charge_id = c.c_charge_id
		WHERE
			ol.c_order_id = c_order.c_order_id
			AND c.name NOT IN ('Finances - Miscellaneous/Other', 'Charge Test')
	);

/**********************************************************************************************************/
-- 1. Bill waiver that already exists on an invoice (14096 of these - just delete and update order total)
/**********************************************************************************************************/
-- Get the order lines we're working with
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
			ON ol.c_charge_id = c.c_charge_id AND c.name = 'Bill Waiver'
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
DROP TABLE IF EXISTS tmp_c_invoice;
CREATE TEMP TABLE tmp_c_invoice
(
	c_invoice_id           serial                          NOT NULL,
	ad_client_id           numeric(10)                     NOT NULL,
	ad_org_id              numeric(10)                     NOT NULL,
-- 	isactive               char         DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                timestamp    DEFAULT NOW()       NOT NULL,
	createdby              numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                timestamp    DEFAULT NOW()       NOT NULL,
	updatedby              numeric(10) DEFAULT 100         NOT NULL,
	issotrx                char        DEFAULT 'N'::bpchar NOT NULL,
	documentno             numeric                         NOT NULL,
	docstatus              char(2)                         NOT NULL,
	docaction              char(2)                         NOT NULL,
	processing             char        DEFAULT 'N',
	processed              char        DEFAULT 'Y'::bpchar NOT NULL,
	posted                 char        DEFAULT 'Y'::bpchar NOT NULL,
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
	dateordered            timestamp                       NOT NULL,
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
	ispaid                 char        DEFAULT 'Y'::bpchar NOT NULL,
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
	processedon            numeric,
-- 	c_cashplanline_id      numeric(10)  DEFAULT NULL::numeric,
	c_invoice_uu           varchar(36) DEFAULT uuid_generate_v4(),
	isfixedassetinvoice    char        DEFAULT 'N',
-- 	relatedinvoice_id      numeric(10)  DEFAULT NULL::numeric,
-- 	bh_voided_reason_id    numeric(10)  DEFAULT NULL::numeric,
	bh_visit_id            numeric(10)                     NOT NULL
-- 	isoverridecurrencyrate char         DEFAULT 'N'::bpchar NOT NULL,
-- 	currencyrate           numeric,
-- 	createlinesfrom        char         DEFAULT NULL::bpchar
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
	tmp_c_invoice (ad_client_id, ad_org_id, documentno, c_doctype_id, c_doctypetarget_id, c_order_id,
	               salesrep_id, dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, dateordered, c_currency_id,
	               c_paymentterm_id, totallines, grandtotal, m_pricelist_id, processedon, docstatus, docaction,
	               description, bh_visit_id)
SELECT
	o.ad_client_id,
	o.ad_org_id,
	seq.currentnext - 1, -- We'll put the correct one when do a row numbering partitioned by ad_client_id below
	dt.c_doctype_id,
	dt.c_doctype_id,
	o.c_order_id,
	o.salesrep_id,
	o.dateordered,
	o.dateacct,
	o.c_bpartner_id,
	o.c_bpartner_location_id,
	o.dateordered,
	o.c_currency_id,
	pt.c_paymentterm_id,
	o.totallines,
	o.grandtotal,
	o.m_pricelist_id,
	NULL,
	'DR',
	'CO',
	'Visit Invoice - Auto Generated',
	o.bh_visit_id
FROM
	c_order o
		JOIN ad_sequence seq
			ON seq.ad_client_id = o.ad_client_id AND seq.name = 'DocumentNo_C_Invoice'
		JOIN c_doctype dt
			ON o.ad_client_id = dt.ad_client_id AND dt.name = 'AP Invoice'
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
	c_invoice (c_invoice_id, ad_client_id, ad_org_id, createdby, updatedby, issotrx, documentno, docstatus, docaction,
	           processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, salesrep_id,
	           dateinvoiced, dateacct, c_bpartner_id, c_bpartner_location_id, poreference, isdiscountprinted, dateordered,
	           c_currency_id, paymentrule, c_paymentterm_id, totallines, grandtotal, m_pricelist_id, ispaid, processedon,
	           c_invoice_uu, isfixedassetinvoice, bh_visit_id)
SELECT
	c_invoice_id,
	ad_client_id,
	ad_org_id,
	createdby,
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
-- 	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby                 numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
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
	tmp_c_invoiceline (ad_client_id, ad_org_id, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist, priceactual,
	                   pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt, qtyentered,
	                   priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
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
	tmp_c_invoiceline (ad_client_id, ad_org_id, c_invoice_id, line, c_charge_id, qtyinvoiced, pricelist, priceactual,
	                   pricelimit, linenetamt, c_uom_id, c_tax_id, m_attributesetinstance_id, linetotalamt, qtyentered,
	                   priceentered, c_orderline_id)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
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
	c_invoiceline (c_invoiceline_id, ad_client_id, ad_org_id, createdby, updatedby, c_invoice_id, line, c_charge_id,
	               c_uom_id, c_tax_id, qtyentered, priceentered, isfixedassetinvoice, c_orderline_id)
SELECT
	c_invoiceline_id,
	ad_client_id,
	ad_org_id,
	createdby,
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


/**********************************************************************************************************/
-- FINAL
/**********************************************************************************************************/
-- Now take all the orders and invoices we messed with and update their grand totals

-- For invoices, ensure the GL entry amounts are correct


SELECT
	register_migration_script('202511211355_GO-3460.sql')
FROM
	dual;
