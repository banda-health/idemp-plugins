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
	o.c_order_id
INTO TEMP TABLE
	tmp_errored_order_ids
FROM
	c_order o
		LEFT JOIN c_invoice i
			ON o.c_order_id = i.c_order_id
		LEFT JOIN c_payment p
			ON p.bh_c_order_id = o.c_order_id
WHERE
	o.docstatus NOT IN ('CO', 'VO', 'CL')
	AND o.issotrx = 'Y'
	AND (i.docstatus != 'RE' OR
	     ((p.bh_processing = 'Y' AND p.docstatus != 'RE') OR p.docstatus = 'CO'));

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

-- Reset all open balances to match what the system calculates
-- For any open balances that differ from what the system calculates, we need to figure out why and correct stuff

SELECT register_migration_script('202207261947_GO-2380.sql') FROM dual;
