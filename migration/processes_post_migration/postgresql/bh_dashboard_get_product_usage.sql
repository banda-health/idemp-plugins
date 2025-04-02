DROP FUNCTION IF EXISTS bh_dashboard_get_product_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_product_usage(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        m_product_id numeric,
		        name         varchar,
		        current      numeric,
		        previous     numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH current_period_product AS (
	SELECT
		p.m_product_id,
		COUNT(p.*) AS ct
	FROM
		m_product p
			JOIN c_orderline ol
			ON p.m_product_id = ol.m_product_id
			JOIN c_order o
			ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('CO', 'CL')
			JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN _begin_date AND _end_date AND
			   v.ad_client_id = _ad_client_id
			JOIN m_product_category pc
			ON p.m_product_category_id = pc.m_product_category_id AND pc.name = 'Pharmacy'
	WHERE
		p.producttype = 'I'
	GROUP BY p.m_product_id
),
	previous_period_product AS (
		SELECT
			p.m_product_id,
			COUNT(p.*) AS ct
		FROM
			m_product p
				JOIN c_orderline ol
				ON p.m_product_id = ol.m_product_id
				JOIN c_order o
				ON ol.c_order_id = o.c_order_id AND o.docstatus IN ('CO', 'CL')
				JOIN bh_visit v
				ON o.bh_visit_id = v.bh_visit_id AND
				   v.bh_visitdate BETWEEN (_begin_date - (_end_date - _begin_date)) AND _begin_date AND
				   v.ad_client_id = _ad_client_id
				JOIN m_product_category pc
				ON p.m_product_category_id = pc.m_product_category_id AND pc.name = 'Pharmacy'
		WHERE
			p.producttype = 'I'
		GROUP BY p.m_product_id
	)
SELECT
	cpp.m_product_id,
	p.name,
	cpp.ct              AS current,
	COALESCE(ppp.ct, 0) AS previous
FROM
	(
		SELECT *
		FROM
			current_period_product
		ORDER BY ct DESC
		LIMIT 10
	) cpp
		LEFT JOIN previous_period_product ppp
		ON cpp.m_product_id = ppp.m_product_id
		JOIN m_product p
		ON cpp.m_product_id = p.m_product_id
UNION ALL
SELECT
	NULL,
	'Other',
	COALESCE(SUM(ct), 0),
	NULL
FROM
	current_period_product
WHERE
	m_product_id NOT IN (
		SELECT
			m_product_id
		FROM
			current_period_product
		ORDER BY ct DESC
		LIMIT 10
	);
$$;
