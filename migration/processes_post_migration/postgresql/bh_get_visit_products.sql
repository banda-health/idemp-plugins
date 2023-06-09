DROP FUNCTION IF EXISTS bh_get_visit_products(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_products(ad_client_id numeric,
                                      begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id           numeric,
		        c_order_id            numeric,
		        m_product_id          numeric,
		        product_name          character varying,
		        m_product_category_id numeric,
		        product_category_name character varying,
		        product_type_value    character varying,
		        product_type_name     character varying,
		        quantity              numeric,
		        price                 numeric,
		        linenetamt            numeric,
		        m_warehouse_id        numeric,
		        warehouse_name        character varying,
		        processed             character
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	v.bh_visit_id,
	ol.c_order_id,
	p.m_product_id,
	p.name          AS product_name,
	pc.m_product_category_id,
	pc.name         AS product_category_name,
	rl.value        AS product_type_value,
	rl.name         AS product_type_name,
	ol.qtyentered   AS quantity,
	ol.priceentered AS price,
	ol.linenetamt,
	w.m_warehouse_id,
	w.name          AS warehouse_name,
	ol.processed
FROM
	c_orderline ol
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
		JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id
		JOIN m_product p
			ON ol.m_product_id = p.m_product_id
		JOIN m_product_category pc
			ON p.m_product_category_id = pc.m_product_category_id
		JOIN ad_ref_list rl
			ON p.producttype = rl.value
		JOIN ad_reference r
			ON rl.ad_reference_id = r.ad_reference_id AND r.ad_reference_uu = '668f05be-1e2e-498c-a016-cc5b623ed0cd'
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id
		LEFT JOIN m_locator l
			ON iol.m_locator_id = l.m_locator_id
		LEFT JOIN m_warehouse w
			ON l.m_warehouse_id = w.m_warehouse_id
WHERE
	v.bh_visitdate BETWEEN $2 AND $3
	AND ol.ad_client_id = $1;
$$;
