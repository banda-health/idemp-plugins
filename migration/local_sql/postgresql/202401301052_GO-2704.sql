DROP FUNCTION IF EXISTS bh_get_product_transactions(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_product_transactions(_ad_client_id numeric)
	RETURNS table
	        (
		        created                   timestamp,
		        m_transaction_id          numeric,
		        c_order_id                numeric,
		        m_movement_id             numeric,
		        bh_visit_id               numeric,
		        m_product_id              numeric,
		        m_locator_id              numeric,
		        m_attributesetinstance_id numeric,
		        createdby                 numeric,
		        transaction_type          varchar,
		        movementqty               numeric,
		        runningtotal_bylocator    numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	created,
	m_transaction_id,
	c_order_id,
	m_movement_id,
	bh_visit_id,
	m_product_id,
	m_locator_id,
	m_attributesetinstance_id,
	createdby,
	CASE
		WHEN t.movementtype IS NULL THEN 'Drafted'
		WHEN t.movementtype = 'I+' AND t.row_num = 1 THEN 'Initial Inventory'
		WHEN t.movementtype IN ('I+', 'I-') THEN 'Manual Inventory Adjustment'
		WHEN t.movementtype = 'C+' THEN 'Customer Returns'
		WHEN t.movementtype = 'C-' AND t.movementqty < 0 THEN 'Patient Sale'
		WHEN t.movementtype = 'C-' AND t.c_order_docstatus = 'VO' THEN 'Void Patient Sale'
		WHEN t.movementtype = 'C-' THEN 'Reactivate Patient Sale'
		WHEN t.movementtype = 'V+' AND t.movementqty > 0 THEN 'Product Received'
		WHEN t.movementtype = 'V+' AND t.c_order_docstatus = 'VO' THEN 'Void Product Receipt'
		WHEN t.movementtype = 'V+' THEN 'Reactivated Product Receipt'
		WHEN t.movementtype = 'V-' THEN 'Vendor Returns'
		WHEN t.movementtype = 'M+' THEN 'Transfer In'
		WHEN t.movementtype = 'M-' THEN 'Transfer Out'
		ELSE 'Unknown Status: ' || t.movementtype 
	END AS transaction_type,
	movementqty,
	SUM(movementqty) FILTER ( WHERE m_transaction_id IS NOT NULL ) OVER (PARTITION BY m_product_id, m_locator_id ORDER BY created) runningtotal_bylocator
FROM
	(
		SELECT
			t.created,
			t.m_transaction_id,
			t.c_order_id,
			t.c_order_docstatus,
			t.m_movement_id,
			t.bh_visit_id,
			t.m_locator_id,
			t.m_attributesetinstance_id,
			t.createdby,
			t.movementtype,
			t.movementqty,
			t.m_product_id,
			ROW_NUMBER() OVER (PARTITION BY m_product_id ORDER BY t.created) AS row_num
		FROM
			(
				SELECT
					t.created,
					t.m_transaction_id,
					o.c_order_id,
					o.docstatus   AS c_order_docstatus,
					NULL::numeric AS m_movement_id,
					o.bh_visit_id,
					t.m_locator_id,
					t.m_attributesetinstance_id,
					t.createdby,
					t.movementtype,
					t.movementqty,
					t.m_product_id
				FROM
					m_transaction t
						LEFT JOIN m_inoutline iol
						ON t.m_inoutline_id = iol.m_inoutline_id
						LEFT JOIN m_inout io
						ON iol.m_inout_id = io.m_inout_id
						LEFT JOIN c_order o
						ON io.c_order_id = o.c_order_id
				WHERE
					t.ad_client_id = _ad_client_id
				UNION ALL
				SELECT
					o.created,
					NULL,
					o.c_order_id,
					o.docstatus,
					NULL,
					o.bh_visit_id,
					NULL,
					NULL,
					o.createdby,
					NULL,
					ol.qtyentered,
					ol.m_product_id
				FROM
					c_order o
						JOIN c_orderline ol
						ON o.c_order_id = ol.c_order_id
				WHERE
					o.docstatus = 'DR'
					AND o.ad_client_id = _ad_client_id
					AND ol.m_product_id IS NOT NULL
				UNION ALL
				SELECT
					m.created,
					NULL,
					NULL,
					NULL,
					m.m_movement_id,
					NULL,
					ml.m_locator_id,
					m_attributesetinstance_id,
					m.createdby,
					NULL,
					ml.movementqty * -1,
					ml.m_product_id
				FROM
					m_movement m
						JOIN m_movementline ml
						ON m.m_movement_id = ml.m_movement_id
				WHERE
					m.ad_client_id = _ad_client_id
				UNION ALL
				SELECT
					m.created,
					NULL,
					NULL,
					NULL,
					m.m_movement_id,
					NULL,
					ml.m_locatorto_id,
					m_attributesetinstance_id,
					m.createdby,
					NULL,
					ml.movementqty,
					ml.m_product_id
				FROM
					m_movement m
						JOIN m_movementline ml
						ON m.m_movement_id = ml.m_movement_id
				WHERE
					m.ad_client_id = _ad_client_id
			) t
	) t;
$$;

SELECT
	register_migration_script('202401301052_GO-2704.sql')
FROM
	dual;
