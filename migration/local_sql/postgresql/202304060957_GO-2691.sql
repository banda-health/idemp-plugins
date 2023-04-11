/**********************************************************************************************************/
-- Create physical inventory records to be completed within iDempiere
--  1. Create inventory records for the data we'll clear
--  2. Create all the lines for products that have inventory assigned to the bad ASI
--  3. Update the sequences
--  4. Make sure that, even though we select the "0" ASI, it still gets used since it's the oldest
--  5. Finish up
/**********************************************************************************************************/
/**********************************************************************************************************/
-- 1. Create inventory records for the data we'll clear
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_bad_inventory;
SELECT DISTINCT
	soh.ad_client_id,
	soh.ad_org_id,
	l.m_warehouse_id,
	l.m_locator_id,
	soh.m_product_id
INTO TEMP TABLE
	tmp_bad_inventory
FROM
	m_storageonhand soh
		JOIN ad_client c
			ON c.ad_client_id = soh.ad_client_id
		JOIN m_locator l
			ON soh.m_locator_id = l.m_locator_id
WHERE
	qtyonhand != 0
	AND c.isactive = 'Y'
	AND m_attributesetinstance_id = 0;

DROP TABLE IF EXISTS tmp_m_inventory;
CREATE TABLE IF NOT EXISTS tmp_m_inventory
(
	m_inventory_id    serial                           NOT NULL,
	ad_client_id      numeric(10)                      NOT NULL,
	ad_org_id         numeric(10)                      NOT NULL,
-- 	isactive       char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created        timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10)  DEFAULT 100         NOT NULL,
-- 	updated        timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10)  DEFAULT 100         NOT NULL,
	documentno        varchar(30)                      NOT NULL,
	description       varchar(255) DEFAULT NULL,
	m_warehouse_id    numeric(10),
	movementdate      timestamp    DEFAULT date(NOW()) NOT NULL,
-- 	posted              char        DEFAULT 'N'::bpchar NOT NULL,
-- 	processed           char        DEFAULT 'N'::bpchar NOT NULL,
	processing        char         DEFAULT 'N'::bpchar,
-- 	updateqty           char        DEFAULT 'N'::bpchar,
-- 	generatelist        char        DEFAULT 'Y'::bpchar,
	m_perpetualinv_id numeric(10)  DEFAULT NULL,
	ad_orgtrx_id      numeric(10)  DEFAULT NULL,
	c_project_id      numeric(10)  DEFAULT NULL,
	c_campaign_id     numeric(10)  DEFAULT NULL,
	c_activity_id     numeric(10)  DEFAULT NULL,
	user1_id          numeric(10)  DEFAULT NULL,
	user2_id          numeric(10)  DEFAULT NULL,
-- 	isapproved          char        DEFAULT 'N'::bpchar NOT NULL,
	docstatus         char(2)      DEFAULT 'DR'        NOT NULL,
	docaction         char(2)      DEFAULT 'CO'        NOT NULL,
	approvalamt       numeric      DEFAULT 0,
	c_doctype_id      numeric(10)                      NOT NULL,
-- 	reversal_id         numeric(10),
-- 	processedon         numeric,
	m_inventory_uu    uuid         DEFAULT uuid_generate_v4(),
-- 	costingmethod       char        DEFAULT NULL::bpchar,
-- 	c_conversiontype_id numeric(10) DEFAULT NULL::numeric,
-- 	c_currency_id       numeric(10) DEFAULT NULL::numeric,
-- 	bh_navbuttons       varchar(36) DEFAULT NULL::character varying,
	bh_update_reason  varchar(10)  DEFAULT NULL
);

SELECT
	SETVAL(
			'tmp_m_inventory_m_inventory_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'M_Inventory'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_m_inventory (ad_client_id, ad_org_id, documentno, m_warehouse_id, c_doctype_id)
SELECT DISTINCT
	tbi.ad_client_id,
	tbi.ad_org_id,
	'', -- We'll update document numbers below
	tbi.m_warehouse_id,
	dt.c_doctype_id
FROM
	tmp_bad_inventory tbi
		JOIN c_doctype dt
			ON dt.ad_client_id = tbi.ad_client_id AND dt.docbasetype = 'MMI' AND dt.docsubtypeinv = 'PI';

-- Update the document numbers
UPDATE tmp_m_inventory ti
SET
	documentno = (max_doc.documentno + counter.rownum)::varchar
FROM
	(
		SELECT
			ad_client_id,
			MAX(CASE WHEN isnumeric(documentno) THEN documentno::numeric ELSE 0 END) AS documentno
		FROM
			m_inventory
		GROUP BY ad_client_id
	) max_doc
		JOIN (
		SELECT
			ad_client_id,
			m_inventory_id,
			ROW_NUMBER() OVER (PARTITION BY ad_client_id ORDER BY m_inventory_id) AS rownum
		FROM
			tmp_m_inventory
	) counter
			ON counter.ad_client_id = max_doc.ad_client_id
WHERE
	ti.m_inventory_id = counter.m_inventory_id;

INSERT INTO
	m_inventory (m_inventory_id, ad_client_id, ad_org_id, createdby, updatedby, documentno, description, m_warehouse_id,
	             movementdate, processing, m_perpetualinv_id, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id,
	             user1_id, user2_id, docstatus, docaction, approvalamt, c_doctype_id, m_inventory_uu, bh_update_reason)
SELECT
	m_inventory_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	documentno,
	description,
	m_warehouse_id,
	movementdate,
	processing,
	m_perpetualinv_id,
	ad_orgtrx_id,
	c_project_id,
	c_campaign_id,
	c_activity_id,
	user1_id,
	user2_id,
	docstatus,
	docaction,
	approvalamt,
	c_doctype_id,
	m_inventory_uu,
	bh_update_reason
FROM
	tmp_m_inventory;

/**********************************************************************************************************/
-- 2. Create all the lines for products that have inventory assigned to the bad ASI
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_m_inventoryline;
CREATE TEMP TABLE tmp_m_inventoryline
(
	m_inventoryline_id serial                   NOT NULL,
	ad_client_id       numeric(10)              NOT NULL,
	ad_org_id          numeric(10)              NOT NULL,
-- 	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
-- 	created                   timestamp   DEFAULT NOW()       NOT NULL,
	createdby          numeric(10)  DEFAULT 100 NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby          numeric(10)  DEFAULT 100 NOT NULL,
	m_inventory_id     numeric(10)              NOT NULL,
	m_locator_id       numeric(10),
	m_product_id       numeric(10)              NOT NULL,
	line               numeric(10),
	qtybook            numeric      DEFAULT 0   NOT NULL,
-- 	qtycount                  numeric     DEFAULT 0           NOT NULL,
	description        varchar(255) DEFAULT NULL,
-- 	m_attributesetinstance_id numeric(10) DEFAULT 0,
	c_charge_id        numeric(10)  DEFAULT NULL,
-- 	inventorytype             char        DEFAULT 'D'::bpchar NOT NULL,
-- 	processed                 char        DEFAULT 'N'::bpchar NOT NULL,
	qtyinternaluse     numeric      DEFAULT 0,
	reversalline_id    numeric(10)  DEFAULT NULL,
-- 	qtycsv                    numeric     DEFAULT 0           NOT NULL,
	m_inventoryline_uu uuid         DEFAULT uuid_generate_v4()
-- 	currentcostprice          numeric     DEFAULT (0)::numeric,
-- 	newcostprice              numeric     DEFAULT (0)::numeric,
-- 	bh_expiration             timestamp,
-- 	bh_navbuttons             varchar(36) DEFAULT NULL::character varying
);

SELECT
	SETVAL(
			'tmp_m_inventoryline_m_inventoryline_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'M_InventoryLine'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO
	tmp_m_inventoryline (ad_client_id, ad_org_id, m_inventory_id, m_locator_id, m_product_id, line)
SELECT
	tbi.ad_client_id,
	tbi.ad_org_id,
	ti.m_inventory_id,
	tbi.m_locator_id,
	tbi.m_product_id,
	0
FROM
	tmp_bad_inventory tbi
		JOIN tmp_m_inventory ti
			ON tbi.ad_client_id = ti.ad_client_id AND tbi.ad_org_id = ti.ad_org_id AND tbi.m_warehouse_id = ti.m_warehouse_id;

-- Update the quantity in the books
UPDATE tmp_m_inventoryline til
SET
	qtybook = soh.qtybook
FROM
	(
		SELECT
			m_product_id,
			m_locator_id,
			SUM(qtyonhand) qtybook
		FROM
			m_storageonhand
		WHERE
			m_attributesetinstance_id = 0
		GROUP BY m_product_id, m_locator_id
	) soh
WHERE
	til.m_product_id = soh.m_product_id
	AND til.m_locator_id = soh.m_locator_id;

-- Update the line numbers
UPDATE tmp_m_inventoryline til
SET
	line = counts.rownum * 10
FROM
	(
		SELECT
			m_inventoryline_id,
			ROW_NUMBER() OVER (PARTITION BY m_inventory_id ORDER BY m_product_id) AS rownum
		FROM
			tmp_m_inventoryline
	) counts
WHERE
	til.m_inventoryline_id = counts.m_inventoryline_id;

INSERT INTO
	m_inventoryline (m_inventoryline_id, ad_client_id, ad_org_id, createdby, updatedby, m_inventory_id, m_locator_id,
	                 m_product_id, line, qtybook, description, c_charge_id, qtyinternaluse, reversalline_id,
	                 m_inventoryline_uu)
SELECT
	m_inventoryline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_inventory_id,
	m_locator_id,
	m_product_id,
	line,
	qtybook,
	description,
	c_charge_id,
	qtyinternaluse,
	reversalline_id,
	m_inventoryline_uu
FROM
	tmp_m_inventoryline;

/**********************************************************************************************************/
-- 3. Update the sequences
/**********************************************************************************************************/
UPDATE ad_sequence
SET
	currentnext = COALESCE((
		                       SELECT
			                       MAX(m_inventory_id) + 1
		                       FROM
			                       tmp_m_inventory
	                       ), currentnext)
WHERE
	name = 'M_Inventory';
UPDATE ad_sequence
SET
	currentnext = COALESCE((
		                       SELECT
			                       MAX(m_inventoryline_id) + 1
		                       FROM
			                       tmp_m_inventoryline
	                       ), currentnext)
WHERE
	name = 'M_InventoryLine';

/**********************************************************************************************************/
-- 4. Make sure that, even though we select the "0" ASI, it still gets used since it's the oldest
/**********************************************************************************************************/
UPDATE m_storageonhand soh
SET
	datematerialpolicy = '2020-01-01'
FROM
	tmp_bad_inventory tbi
WHERE
	soh.m_attributesetinstance_id = 0
	AND soh.m_locator_id = tbi.m_locator_id
	AND soh.m_product_id = tbi.m_product_id;

/**********************************************************************************************************/
-- 5. Finish up
/**********************************************************************************************************/
SELECT
	register_migration_script('202304060957_GO-2691.sql')
FROM
	dual;
