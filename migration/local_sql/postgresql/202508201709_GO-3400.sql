-- Update orders with invoice lines that were included that have prices
SELECT
	c_order_id
INTO TEMP TABLE
	tmp_c_order_to_update
FROM
	c_order
WHERE
	EXISTS (
		SELECT
			1
		FROM
			c_orderline
		WHERE
			c_orderline.c_order_id = c_order.c_order_id
			AND included_orderline_id IS NOT NULL
			AND priceactual != 0
	);

UPDATE c_orderline ol
SET
	priceactual = 0,
	linenetamt  = 0
FROM
	tmp_c_order_to_update totu
WHERE
	ol.included_orderline_id IS NOT NULL
	AND ol.priceactual != 0
	AND ol.c_order_id = totu.c_order_id;

-- Correct the totals on the order
UPDATE c_order o
SET
	totallines = ol.grandtotal,
	grandtotal = ol.grandtotal
FROM
	(
		SELECT
			ol.c_order_id,
			SUM(linenetamt) AS grandtotal
		FROM
			c_orderline ol
				JOIN tmp_c_order_to_update totu
					ON ol.c_order_id = totu.c_order_id
		GROUP BY ol.c_order_id
	) ol
WHERE
	o.c_order_id = ol.c_order_id;

-- Register the script
SELECT
	register_migration_script('202508201709_GO-3400.sql')
FROM
	dual;
